package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.text.Typography;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    Segment head;
    long size;

    public Buffer buffer() {
        return this;
    }

    public void close() {
    }

    public BufferedSink emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean exhausted() {
        return this.size == 0;
    }

    public void flush() {
    }

    public boolean isOpen() {
        return true;
    }

    public boolean request(long j) {
        return this.size >= j;
    }

    public final long size() {
        return this.size;
    }

    public OutputStream outputStream() {
        return new OutputStream() {
            public void close() {
            }

            public void flush() {
            }

            public void write(int i) {
                Buffer.this.writeByte((int) (byte) i);
            }

            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.write(bArr, i, i2);
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }
        };
    }

    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    public InputStream inputStream() {
        return new InputStream() {
            public void close() {
            }

            public int read() {
                if (Buffer.this.size > 0) {
                    return Buffer.this.readByte() & UByte.MAX_VALUE;
                }
                return -1;
            }

            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.read(bArr, i, i2);
            }

            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0, this.size);
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            Segment segment = this.head;
            while (j >= ((long) (segment.limit - segment.pos))) {
                j -= (long) (segment.limit - segment.pos);
                segment = segment.next;
            }
            while (j2 > 0) {
                int i = (int) (((long) segment.pos) + j);
                int min = (int) Math.min((long) (segment.limit - i), j2);
                outputStream.write(segment.data, i, min);
                j2 -= (long) min;
                segment = segment.next;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            Util.checkOffsetAndCount(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.size += j2;
            Segment segment = this.head;
            while (j >= ((long) (segment.limit - segment.pos))) {
                j -= (long) (segment.limit - segment.pos);
                segment = segment.next;
            }
            while (j2 > 0) {
                Segment sharedCopy = segment.sharedCopy();
                sharedCopy.pos = (int) (((long) sharedCopy.pos) + j);
                sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j2), sharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    segment2.prev.push(sharedCopy);
                }
                j2 -= (long) (sharedCopy.limit - sharedCopy.pos);
                segment = segment.next;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, 0, j);
            Segment segment = this.head;
            while (j > 0) {
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                outputStream.write(segment.data, segment.pos, min);
                segment.pos += min;
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                if (segment.pos == segment.limit) {
                    Segment pop = segment.pop();
                    this.head = pop;
                    SegmentPool.recycle(segment);
                    segment = pop;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream != null) {
            while (true) {
                if (j > 0 || z) {
                    Segment writableSegment = writableSegment(1);
                    int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, (long) (8192 - writableSegment.limit)));
                    if (read != -1) {
                        writableSegment.limit += read;
                        long j2 = (long) read;
                        this.size += j2;
                        j -= j2;
                    } else if (!z) {
                        throw new EOFException();
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("in == null");
        }
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0;
        }
        Segment segment = this.head.prev;
        return (segment.limit >= 8192 || !segment.owner) ? j : j - ((long) (segment.limit - segment.pos));
    }

    public byte readByte() {
        if (this.size != 0) {
            Segment segment = this.head;
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b = segment.data[i];
            this.size--;
            if (i3 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public final byte getByte(long j) {
        Util.checkOffsetAndCount(this.size, j, 1);
        long j2 = this.size;
        if (j2 - j > j) {
            Segment segment = this.head;
            while (true) {
                long j3 = (long) (segment.limit - segment.pos);
                if (j < j3) {
                    return segment.data[segment.pos + ((int) j)];
                }
                j -= j3;
                segment = segment.next;
            }
        } else {
            long j4 = j - j2;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                j4 += (long) (segment2.limit - segment2.pos);
            } while (j4 < 0);
            return segment2.data[segment2.pos + ((int) j4)];
        }
    }

    public short readShort() {
        if (this.size >= 2) {
            Segment segment = this.head;
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) (((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i + 2;
            byte b = (bArr[i3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8);
            this.size -= 2;
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) b;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    public int readInt() {
        if (this.size >= 4) {
            Segment segment = this.head;
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 4) {
                return ((readByte() & UByte.MAX_VALUE) << Ascii.CAN) | ((readByte() & UByte.MAX_VALUE) << Ascii.DLE) | ((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE);
            }
            byte[] bArr = segment.data;
            byte b = ((bArr[i + 1] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[i] & UByte.MAX_VALUE) << Ascii.CAN);
            int i3 = i + 3;
            int i4 = i + 4;
            byte b2 = (bArr[i3] & UByte.MAX_VALUE) | b | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
            this.size -= 4;
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    public long readLong() {
        if (this.size >= 8) {
            Segment segment = this.head;
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = segment.data;
            long j = ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24);
            int i3 = i + 7;
            int i4 = i + 8;
            long j2 = j | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8) | (((long) bArr[i3]) & 255);
            this.size -= 8;
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return j2;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r2 != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095 A[EDGE_INSN: B:47:0x0095->B:29:0x0095 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b4
            r1 = 0
            r5 = -7
            r6 = r5
            r2 = 0
            r4 = r3
            r3 = 0
        L_0x0011:
            okio.Segment r8 = r0.head
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L_0x0019:
            if (r10 >= r11) goto L_0x0095
            byte r12 = r9[r10]
            r13 = 48
            if (r12 < r13) goto L_0x0069
            r13 = 57
            if (r12 > r13) goto L_0x0069
            int r13 = 48 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x003f
            if (r16 != 0) goto L_0x0038
            long r14 = (long) r13
            int r16 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x0038
            goto L_0x003f
        L_0x0038:
            r14 = 10
            long r4 = r4 * r14
            long r12 = (long) r13
            long r4 = r4 + r12
            goto L_0x0074
        L_0x003f:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong((long) r4)
            okio.Buffer r1 = r1.writeByte((int) r12)
            if (r2 != 0) goto L_0x0051
            r1.readByte()
        L_0x0051:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Number too large: "
            r3.<init>(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0069:
            r13 = 45
            r14 = 1
            if (r12 != r13) goto L_0x0079
            if (r1 != 0) goto L_0x0079
            r12 = 1
            long r6 = r6 - r12
            r2 = 1
        L_0x0074:
            int r10 = r10 + 1
            int r1 = r1 + 1
            goto L_0x0019
        L_0x0079:
            if (r1 == 0) goto L_0x007d
            r3 = 1
            goto L_0x0095
        L_0x007d:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.<init>(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0095:
            if (r10 != r11) goto L_0x00a1
            okio.Segment r9 = r8.pop()
            r0.head = r9
            okio.SegmentPool.recycle(r8)
            goto L_0x00a3
        L_0x00a1:
            r8.pos = r10
        L_0x00a3:
            if (r3 != 0) goto L_0x00a9
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L_0x0011
        L_0x00a9:
            long r6 = r0.size
            long r8 = (long) r1
            long r6 = r6 - r8
            r0.size = r6
            if (r2 == 0) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            long r4 = -r4
        L_0x00b3:
            return r4
        L_0x00b4:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
        if (r8 != r9) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        r15.head = r6.pop();
        okio.SegmentPool.recycle(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0094, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0096, code lost:
        if (r1 != false) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0070 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a3
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            okio.Segment r6 = r15.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x0013:
            if (r8 >= r9) goto L_0x0088
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x0037
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002d
            int r11 = r10 + -87
            goto L_0x0037
        L_0x002d:
            r11 = 65
            if (r10 < r11) goto L_0x006c
            r11 = 70
            if (r10 > r11) goto L_0x006c
            int r11 = r10 + -55
        L_0x0037:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x0047
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0047:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x006c:
            if (r0 == 0) goto L_0x0070
            r1 = 1
            goto L_0x0088
        L_0x0070:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0088:
            if (r8 != r9) goto L_0x0094
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x0096
        L_0x0094:
            r6.pos = r8
        L_0x0096:
            if (r1 != 0) goto L_0x009c
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L_0x000b
        L_0x009c:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        L_0x00a3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip((long) options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public int selectPrefix(Options options, boolean z) {
        int i;
        int i2;
        int i3;
        Segment segment;
        int i4;
        Options options2 = options;
        Segment segment2 = this.head;
        int i5 = -2;
        if (segment2 != null) {
            byte[] bArr = segment2.data;
            int i6 = segment2.pos;
            int i7 = segment2.limit;
            int[] iArr = options2.trie;
            Segment segment3 = segment2;
            int i8 = 0;
            int i9 = -1;
            loop0:
            while (true) {
                int i10 = i8 + 1;
                int i11 = iArr[i8];
                int i12 = i8 + 2;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (segment3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = i12 + (i11 * -1);
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr[i6] & UByte.MAX_VALUE) != iArr[i12]) {
                            return i9;
                        }
                        boolean z2 = i16 == i14;
                        if (i15 == i7) {
                            Segment segment4 = segment3.next;
                            i4 = segment4.pos;
                            byte[] bArr2 = segment4.data;
                            i3 = segment4.limit;
                            if (segment4 != segment2) {
                                byte[] bArr3 = bArr2;
                                segment = segment4;
                                bArr = bArr3;
                            } else if (!z2) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                segment = null;
                            }
                        } else {
                            segment = segment3;
                            i3 = i7;
                            i4 = i15;
                        }
                        if (z2) {
                            i = iArr[i16];
                            i2 = i4;
                            i7 = i3;
                            segment3 = segment;
                            break;
                        }
                        i6 = i4;
                        i7 = i3;
                        segment3 = segment;
                        i12 = i16;
                    }
                } else {
                    int i17 = i6 + 1;
                    byte b = bArr[i6] & UByte.MAX_VALUE;
                    int i18 = i12 + i11;
                    while (i12 != i18) {
                        if (b == iArr[i12]) {
                            i = iArr[i12 + i11];
                            if (i17 == i7) {
                                segment3 = segment3.next;
                                i2 = segment3.pos;
                                bArr = segment3.data;
                                i7 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            } else {
                                i2 = i17;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                if (i >= 0) {
                    return i;
                }
                i8 = -i;
                i6 = i2;
                i5 = -2;
            }
            return z ? i5 : i9;
        } else if (z) {
            return -2;
        } else {
            return options2.indexOf(ByteString.EMPTY);
        }
    }

    public void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    public long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readUtf8(long j) throws EOFException {
        return readString(j, Util.UTF_8);
    }

    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readString(long j, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            Segment segment = this.head;
            if (((long) segment.pos) + j > ((long) segment.limit)) {
                return new String(readByteArray(j), charset);
            }
            String str = new String(segment.data, segment.pos, (int) j, charset);
            segment.pos = (int) (((long) segment.pos) + j);
            this.size -= j;
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j = this.size;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    /* access modifiers changed from: package-private */
    public String readUtf8Line(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String readUtf8 = readUtf8(j2);
                skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j);
        skip(1);
        return readUtf82;
    }

    public int readUtf8CodePoint() throws EOFException {
        byte b;
        int i;
        byte b2;
        if (this.size != 0) {
            byte b3 = getByte(0);
            int i2 = 1;
            if ((b3 & ByteCompanionObject.MIN_VALUE) == 0) {
                b2 = b3 & Byte.MAX_VALUE;
                i = 1;
                b = 0;
            } else if ((b3 & 224) == 192) {
                b2 = b3 & Ascii.US;
                i = 2;
                b = ByteCompanionObject.MIN_VALUE;
            } else if ((b3 & 240) == 224) {
                b2 = b3 & Ascii.SI;
                i = 3;
                b = 2048;
            } else if ((b3 & 248) == 240) {
                b2 = b3 & 7;
                i = 4;
                b = 65536;
            } else {
                skip(1);
                return REPLACEMENT_CHARACTER;
            }
            long j = (long) i;
            if (this.size >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte b4 = getByte(j2);
                    if ((b4 & 192) == 128) {
                        b2 = (b2 << 6) | (b4 & 63);
                        i2++;
                    } else {
                        skip(j2);
                        return REPLACEMENT_CHARACTER;
                    }
                }
                skip(j);
                if (b2 > 1114111) {
                    return REPLACEMENT_CHARACTER;
                }
                if ((b2 < 55296 || b2 > 57343) && b2 >= b) {
                    return b2;
                }
                return REPLACEMENT_CHARACTER;
            }
            throw new EOFException("size < " + i + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b3) + ")");
        }
        throw new EOFException();
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] readByteArray(long j) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i, min);
        segment.pos += min;
        this.size -= (long) min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        segment.pos += min;
        this.size -= (long) min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.limit - this.head.pos));
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                this.head.pos += min;
                if (this.head.pos == this.head.limit) {
                    Segment segment2 = this.head;
                    this.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    public Buffer writeUtf8(String str, int i, int i2) {
        char c;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    Segment writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.data;
                    int i3 = writableSegment.limit - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = (i3 + i4) - writableSegment.limit;
                    writableSegment.limit += i5;
                    this.size += (long) i5;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i6 = i + 1;
                        if (i6 < i2) {
                            c = str.charAt(i6);
                        } else {
                            c = 0;
                        }
                        if (charAt > 56319 || c < 56320 || c > 57343) {
                            writeByte(63);
                            i = i6;
                        } else {
                            int i7 = (((charAt & 10239) << 10) | (9215 & c)) + 0;
                            writeByte((i7 >> 18) | 240);
                            writeByte(((i7 >> 12) & 63) | 128);
                            writeByte(((i7 >> 6) & 63) | 128);
                            writeByte((i7 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(Util.UTF_8)) {
            return writeUtf8(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i3 - i, 8192 - writableSegment.limit);
                System.arraycopy(bArr, i, writableSegment.data, writableSegment.limit, min);
                i += min;
                writableSegment.limit += min;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i, 8192 - writableSegment.limit);
                byteBuffer.get(writableSegment.data, writableSegment.limit, min);
                i -= min;
                writableSegment.limit += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long writeAll(Source source) throws IOException {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public Buffer writeByte(int i) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        writableSegment.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    public Buffer writeShort(int i) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        writableSegment.limit = i2 + 2;
        this.size += 2;
        return this;
    }

    public Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytesShort((short) i));
    }

    public Buffer writeInt(int i) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        writableSegment.limit = i2 + 4;
        this.size += 4;
        return this;
    }

    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    public Buffer writeLong(long j) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        bArr[i + 1] = (byte) ((int) ((j >>> 48) & 255));
        bArr[i + 2] = (byte) ((int) ((j >>> 40) & 255));
        bArr[i + 3] = (byte) ((int) ((j >>> 32) & 255));
        bArr[i + 4] = (byte) ((int) ((j >>> 24) & 255));
        bArr[i + 5] = (byte) ((int) ((j >>> 16) & 255));
        bArr[i + 6] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i + 7] = (byte) ((int) (j & 255));
        writableSegment.limit = i + 8;
        this.size += 8;
        return this;
    }

    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    public Buffer writeDecimalLong(long j) {
        boolean z;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return writeByte(48);
        }
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment = writableSegment(i2);
        byte[] bArr = writableSegment.data;
        int i3 = writableSegment.limit + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        writableSegment.limit += i2;
        this.size += (long) i2;
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        for (int i2 = (writableSegment.limit + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: package-private */
    public Segment writableSegment(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Segment segment2 = segment.prev;
        return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
    }

    public void write(Buffer buffer, long j) {
        int i;
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size, 0, j);
            while (j > 0) {
                if (j < ((long) (buffer.head.limit - buffer.head.pos))) {
                    Segment segment = this.head;
                    Segment segment2 = segment != null ? segment.prev : null;
                    if (segment2 != null && segment2.owner) {
                        long j2 = ((long) segment2.limit) + j;
                        if (segment2.shared) {
                            i = 0;
                        } else {
                            i = segment2.pos;
                        }
                        if (j2 - ((long) i) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            buffer.head.writeTo(segment2, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    buffer.head = buffer.head.split((int) j);
                }
                Segment segment3 = buffer.head;
                long j3 = (long) (segment3.limit - segment3.pos);
                buffer.head = segment3.pop();
                Segment segment4 = this.head;
                if (segment4 == null) {
                    this.head = segment3;
                    segment3.prev = segment3;
                    segment3.next = segment3;
                } else {
                    segment4.prev.push(segment3).compact();
                }
                buffer.size -= j3;
                this.size += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.size;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public long indexOf(byte b) {
        return indexOf(b, 0, Long.MAX_VALUE);
    }

    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.size;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (segment = this.head) == null) {
            return -1;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.prev;
                j4 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j6 = ((long) (segment.limit - segment.pos)) + j3;
                if (j6 >= j) {
                    break;
                }
                segment = segment.next;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = segment.data;
            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j5) - j4);
            for (int i = (int) ((((long) segment.pos) + j7) - j4); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - segment.pos)) + j4;
                }
            }
            byte b2 = b;
            j4 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j7 = j4;
        }
        return -1;
    }

    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j) throws IOException {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j >= 0) {
                Segment segment = this.head;
                long j3 = -1;
                if (segment == null) {
                    return -1;
                }
                long j4 = this.size;
                if (j4 - j < j) {
                    while (j4 > j) {
                        segment = segment.prev;
                        j4 -= (long) (segment.limit - segment.pos);
                    }
                } else {
                    while (true) {
                        long j5 = ((long) (segment.limit - segment.pos)) + j2;
                        if (j5 >= j) {
                            break;
                        }
                        segment = segment.next;
                        j2 = j5;
                    }
                    j4 = j2;
                }
                byte b = byteString.getByte(0);
                int size2 = byteString.size();
                long j6 = 1 + (this.size - ((long) size2));
                long j7 = j;
                Segment segment2 = segment;
                long j8 = j4;
                while (j8 < j6) {
                    byte[] bArr2 = segment2.data;
                    int min = (int) Math.min((long) segment2.limit, (((long) segment2.pos) + j6) - j8);
                    int i = (int) ((((long) segment2.pos) + j7) - j8);
                    while (i < min) {
                        if (bArr2[i] == b) {
                            bArr = bArr2;
                            if (rangeEquals(segment2, i + 1, byteString, 1, size2)) {
                                return ((long) (i - segment2.pos)) + j8;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i++;
                        bArr2 = bArr;
                    }
                    j8 += (long) (segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    j7 = j8;
                    j3 = -1;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public long indexOfElement(ByteString byteString, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            long j3 = this.size;
            if (j3 - j < j) {
                while (j3 > j) {
                    segment = segment.prev;
                    j3 -= (long) (segment.limit - segment.pos);
                }
            } else {
                while (true) {
                    long j4 = ((long) (segment.limit - segment.pos)) + j2;
                    if (j4 >= j) {
                        break;
                    }
                    segment = segment.next;
                    j2 = j4;
                }
                j3 = j2;
            }
            if (byteString.size() == 2) {
                byte b = byteString.getByte(0);
                byte b2 = byteString.getByte(1);
                while (j3 < this.size) {
                    byte[] bArr = segment.data;
                    i = (int) ((((long) segment.pos) + j) - j3);
                    int i3 = segment.limit;
                    while (i < i3) {
                        byte b3 = bArr[i];
                        if (b3 == b || b3 == b2) {
                            i2 = segment.pos;
                        } else {
                            i++;
                        }
                    }
                    j3 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    j = j3;
                }
                return -1;
            }
            byte[] internalArray = byteString.internalArray();
            while (j3 < this.size) {
                byte[] bArr2 = segment.data;
                int i4 = (int) ((((long) segment.pos) + j) - j3);
                int i5 = segment.limit;
                while (i < i5) {
                    byte b4 = bArr2[i];
                    int length = internalArray.length;
                    int i6 = 0;
                    while (i6 < length) {
                        if (b4 == internalArray[i6]) {
                            i2 = segment.pos;
                        } else {
                            i6++;
                        }
                    }
                    i4 = i + 1;
                }
                j3 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j = j3;
            }
            return -1;
            return ((long) (i - i2)) + j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean rangeEquals(Segment segment, int i, ByteString byteString, int i2, int i3) {
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                int i5 = segment.pos;
                bArr = bArr2;
                i = i5;
                i4 = segment.limit;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    /* access modifiers changed from: package-private */
    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        }
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public final ByteString sha1() {
        return digest(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private ByteString digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                instance.update(segment.data, this.head.pos, this.head.limit - this.head.pos);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    instance.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                }
            }
            return ByteString.of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                instance.update(segment.data, this.head.pos, this.head.limit - this.head.pos);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    instance.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                }
            }
            return ByteString.of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.size;
        if (j != buffer.size) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i = segment.pos;
        int i2 = segment2.pos;
        while (j2 < this.size) {
            long min = (long) Math.min(segment.limit - i, segment2.limit - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == segment.limit) {
                segment = segment.next;
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                i2 = segment2.pos;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i;
    }

    public String toString() {
        return snapshot().toString();
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment != this.head) {
                buffer.head.prev.push(segment.sharedCopy());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private Segment segment;
        public int start = -1;

        public final int next() {
            if (this.offset != this.buffer.size) {
                long j = this.offset;
                if (j == -1) {
                    return seek(0);
                }
                return seek(j + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException();
        }

        public final int seek(long j) {
            int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if (i < 0 || j > this.buffer.size) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j), Long.valueOf(this.buffer.size)}));
            } else if (i == 0 || j == this.buffer.size) {
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            } else {
                long j2 = this.buffer.size;
                Segment segment2 = this.buffer.head;
                Segment segment3 = this.buffer.head;
                Segment segment4 = this.segment;
                long j3 = 0;
                if (segment4 != null) {
                    long j4 = this.offset - ((long) (this.start - segment4.pos));
                    if (j4 > j) {
                        segment3 = this.segment;
                        j2 = j4;
                    } else {
                        segment2 = this.segment;
                        j3 = j4;
                    }
                }
                if (j2 - j > j - j3) {
                    while (j >= ((long) (segment2.limit - segment2.pos)) + j3) {
                        j3 += (long) (segment2.limit - segment2.pos);
                        segment2 = segment2.next;
                    }
                } else {
                    while (j2 > j) {
                        segment3 = segment3.prev;
                        j2 -= (long) (segment3.limit - segment3.pos);
                    }
                    j3 = j2;
                    segment2 = segment3;
                }
                if (this.readWrite && segment2.shared) {
                    Segment unsharedCopy = segment2.unsharedCopy();
                    if (this.buffer.head == segment2) {
                        this.buffer.head = unsharedCopy;
                    }
                    segment2 = segment2.push(unsharedCopy);
                    segment2.prev.pop();
                }
                this.segment = segment2;
                this.offset = j;
                this.data = segment2.data;
                this.start = segment2.pos + ((int) (j - j3));
                int i2 = segment2.limit;
                this.end = i2;
                return i2 - this.start;
            }
        }

        public final long resizeBuffer(long j) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer");
            } else if (this.readWrite) {
                long j2 = buffer2.size;
                int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i <= 0) {
                    if (j >= 0) {
                        long j3 = j2 - j;
                        while (true) {
                            if (j3 <= 0) {
                                break;
                            }
                            Segment segment2 = this.buffer.head.prev;
                            long j4 = (long) (segment2.limit - segment2.pos);
                            if (j4 > j3) {
                                segment2.limit = (int) (((long) segment2.limit) - j3);
                                break;
                            }
                            this.buffer.head = segment2.pop();
                            SegmentPool.recycle(segment2);
                            j3 -= j4;
                        }
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException("newSize < 0: " + j);
                    }
                } else if (i > 0) {
                    long j5 = j - j2;
                    boolean z = true;
                    while (j5 > 0) {
                        Segment writableSegment = this.buffer.writableSegment(1);
                        int min = (int) Math.min(j5, (long) (8192 - writableSegment.limit));
                        writableSegment.limit += min;
                        j5 -= (long) min;
                        if (z) {
                            this.segment = writableSegment;
                            this.offset = j2;
                            this.data = writableSegment.data;
                            this.start = writableSegment.limit - min;
                            this.end = writableSegment.limit;
                            z = false;
                        }
                    }
                }
                this.buffer.size = j;
                return j2;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i);
            } else if (i <= 8192) {
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new IllegalStateException("not attached to a buffer");
                } else if (this.readWrite) {
                    long j = buffer2.size;
                    Segment writableSegment = this.buffer.writableSegment(i);
                    int i2 = 8192 - writableSegment.limit;
                    writableSegment.limit = 8192;
                    long j2 = (long) i2;
                    this.buffer.size = j + j2;
                    this.segment = writableSegment;
                    this.offset = j;
                    this.data = writableSegment.data;
                    this.start = 8192 - i2;
                    this.end = 8192;
                    return j2;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            }
        }

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }
}
