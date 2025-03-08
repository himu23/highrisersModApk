package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final Buffer buffer = new Buffer();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    final Buffer upstreamBuffer = new Buffer();
    long upstreamPos;
    Thread upstreamReader;

    /* access modifiers changed from: package-private */
    public boolean isClosed() {
        return this.file == null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file2, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0, byteString, j);
        randomAccessFile.setLength(0);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer2 = new Buffer();
        fileOperator.read(0, buffer2, 32);
        ByteString byteString = PREFIX_CLEAN;
        if (buffer2.readByteString((long) byteString.size()).equals(byteString)) {
            long readLong = buffer2.readLong();
            long readLong2 = buffer2.readLong();
            Buffer buffer3 = new Buffer();
            fileOperator.read(readLong + 32, buffer3, readLong2);
            return new Relay(randomAccessFile, (Source) null, readLong, buffer3.readByteString(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(byteString);
        buffer2.writeLong(j);
        buffer2.writeLong(j2);
        if (buffer2.size() == 32) {
            new FileOperator(this.file.getChannel()).write(0, buffer2, 32);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j, buffer2, (long) this.metadata.size());
    }

    /* access modifiers changed from: package-private */
    public void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, (long) this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly((Closeable) this.upstream);
        this.upstream = null;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public Timeout timeout() {
            return this.timeout;
        }

        RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r11 = r1.this$0.upstream.read(r1.this$0.upstreamBuffer, r1.this$0.bufferMaxSize);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
            if (r11 != -1) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
            r1.this$0.commit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r1.this$0.upstreamReader = null;
            r1.this$0.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r2 = java.lang.Math.min(r11, r2);
            r1.this$0.upstreamBuffer.copyTo(r21, 0, r2);
            r1.sourcePos += r2;
            r1.fileOperator.write(r7 + 32, r1.this$0.upstreamBuffer.clone(), r11);
            r5 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r1.this$0.buffer.write(r1.this$0.upstreamBuffer, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a6, code lost:
            if (r1.this$0.buffer.size() <= r1.this$0.bufferMaxSize) goto L_0x00bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a8, code lost:
            r1.this$0.buffer.skip(r1.this$0.buffer.size() - r1.this$0.bufferMaxSize);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bc, code lost:
            r1.this$0.upstreamPos += r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c3, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c4, code lost:
            r6 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
            monitor-enter(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            r1.this$0.upstreamReader = null;
            r1.this$0.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d0, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d1, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00db, code lost:
            monitor-enter(r1.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r1.this$0.upstreamReader = null;
            r1.this$0.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e6, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            r5 = r7 - r1.this$0.buffer.size();
            r11 = r1.sourcePos;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f8, code lost:
            if (r11 >= r5) goto L_0x0112;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00fb, code lost:
            r2 = java.lang.Math.min(r2, r7 - r11);
            r1.fileOperator.read(r1.sourcePos + 32, r21, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0111, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r11);
            r1.this$0.buffer.copyTo(r21, r1.sourcePos - r5, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x012b, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r21, long r22) throws java.io.IOException {
            /*
                r20 = this;
                r1 = r20
                r2 = r22
                okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                if (r0 == 0) goto L_0x012f
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r4)
            L_0x000b:
                long r5 = r1.sourcePos     // Catch:{ all -> 0x012c }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x012c }
                long r7 = r0.upstreamPos     // Catch:{ all -> 0x012c }
                r9 = 32
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 != 0) goto L_0x00ea
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x012c }
                boolean r0 = r0.complete     // Catch:{ all -> 0x012c }
                r5 = -1
                if (r0 == 0) goto L_0x0021
                monitor-exit(r4)     // Catch:{ all -> 0x012c }
                return r5
            L_0x0021:
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x012c }
                java.lang.Thread r0 = r0.upstreamReader     // Catch:{ all -> 0x012c }
                if (r0 == 0) goto L_0x002f
                okio.Timeout r0 = r1.timeout     // Catch:{ all -> 0x012c }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x012c }
                r0.waitUntilNotified(r5)     // Catch:{ all -> 0x012c }
                goto L_0x000b
            L_0x002f:
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x012c }
                java.lang.Thread r11 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x012c }
                r0.upstreamReader = r11     // Catch:{ all -> 0x012c }
                monitor-exit(r4)     // Catch:{ all -> 0x012c }
                r4 = 0
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d8 }
                okio.Source r0 = r0.upstream     // Catch:{ all -> 0x00d8 }
                okhttp3.internal.cache2.Relay r11 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d8 }
                okio.Buffer r11 = r11.upstreamBuffer     // Catch:{ all -> 0x00d8 }
                okhttp3.internal.cache2.Relay r12 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d8 }
                long r12 = r12.bufferMaxSize     // Catch:{ all -> 0x00d8 }
                long r11 = r0.read(r11, r12)     // Catch:{ all -> 0x00d8 }
                int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r0 != 0) goto L_0x0063
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d8 }
                r0.commit(r7)     // Catch:{ all -> 0x00d8 }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0060 }
                r0.upstreamReader = r4     // Catch:{ all -> 0x0060 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0060 }
                r0.notifyAll()     // Catch:{ all -> 0x0060 }
                monitor-exit(r2)     // Catch:{ all -> 0x0060 }
                return r5
            L_0x0060:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0060 }
                throw r0
            L_0x0063:
                long r2 = java.lang.Math.min(r11, r2)     // Catch:{ all -> 0x00d8 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d8 }
                okio.Buffer r13 = r0.upstreamBuffer     // Catch:{ all -> 0x00d8 }
                r15 = 0
                r14 = r21
                r17 = r2
                r13.copyTo((okio.Buffer) r14, (long) r15, (long) r17)     // Catch:{ all -> 0x00d8 }
                long r5 = r1.sourcePos     // Catch:{ all -> 0x00d8 }
                long r5 = r5 + r2
                r1.sourcePos = r5     // Catch:{ all -> 0x00d8 }
                okhttp3.internal.cache2.FileOperator r14 = r1.fileOperator     // Catch:{ all -> 0x00d8 }
                long r15 = r7 + r9
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d8 }
                okio.Buffer r0 = r0.upstreamBuffer     // Catch:{ all -> 0x00d8 }
                okio.Buffer r17 = r0.clone()     // Catch:{ all -> 0x00d8 }
                r18 = r11
                r14.write(r15, r17, r18)     // Catch:{ all -> 0x00d8 }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d8 }
                monitor-enter(r5)     // Catch:{ all -> 0x00d8 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d5 }
                okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x00d5 }
                okhttp3.internal.cache2.Relay r6 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d5 }
                okio.Buffer r6 = r6.upstreamBuffer     // Catch:{ all -> 0x00d5 }
                r0.write((okio.Buffer) r6, (long) r11)     // Catch:{ all -> 0x00d5 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d5 }
                okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x00d5 }
                long r6 = r0.size()     // Catch:{ all -> 0x00d5 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d5 }
                long r8 = r0.bufferMaxSize     // Catch:{ all -> 0x00d5 }
                int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x00bc
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d5 }
                okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x00d5 }
                okhttp3.internal.cache2.Relay r6 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d5 }
                okio.Buffer r6 = r6.buffer     // Catch:{ all -> 0x00d5 }
                long r6 = r6.size()     // Catch:{ all -> 0x00d5 }
                okhttp3.internal.cache2.Relay r8 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d5 }
                long r8 = r8.bufferMaxSize     // Catch:{ all -> 0x00d5 }
                long r6 = r6 - r8
                r0.skip(r6)     // Catch:{ all -> 0x00d5 }
            L_0x00bc:
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d5 }
                long r6 = r0.upstreamPos     // Catch:{ all -> 0x00d5 }
                long r6 = r6 + r11
                r0.upstreamPos = r6     // Catch:{ all -> 0x00d5 }
                monitor-exit(r5)     // Catch:{ all -> 0x00d5 }
                okhttp3.internal.cache2.Relay r6 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r6)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d2 }
                r0.upstreamReader = r4     // Catch:{ all -> 0x00d2 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d2 }
                r0.notifyAll()     // Catch:{ all -> 0x00d2 }
                monitor-exit(r6)     // Catch:{ all -> 0x00d2 }
                return r2
            L_0x00d2:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x00d2 }
                throw r0
            L_0x00d5:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x00d5 }
                throw r0     // Catch:{ all -> 0x00d8 }
            L_0x00d8:
                r0 = move-exception
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                okhttp3.internal.cache2.Relay r3 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00e7 }
                r3.upstreamReader = r4     // Catch:{ all -> 0x00e7 }
                okhttp3.internal.cache2.Relay r3 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00e7 }
                r3.notifyAll()     // Catch:{ all -> 0x00e7 }
                monitor-exit(r2)     // Catch:{ all -> 0x00e7 }
                throw r0
            L_0x00e7:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00e7 }
                throw r0
            L_0x00ea:
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x012c }
                okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x012c }
                long r5 = r0.size()     // Catch:{ all -> 0x012c }
                long r5 = r7 - r5
                long r11 = r1.sourcePos     // Catch:{ all -> 0x012c }
                int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0112
                monitor-exit(r4)     // Catch:{ all -> 0x012c }
                long r7 = r7 - r11
                long r2 = java.lang.Math.min(r2, r7)
                okhttp3.internal.cache2.FileOperator r11 = r1.fileOperator
                long r4 = r1.sourcePos
                long r12 = r4 + r9
                r14 = r21
                r15 = r2
                r11.read(r12, r14, r15)
                long r4 = r1.sourcePos
                long r4 = r4 + r2
                r1.sourcePos = r4
                return r2
            L_0x0112:
                long r7 = r7 - r11
                long r2 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x012c }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x012c }
                okio.Buffer r9 = r0.buffer     // Catch:{ all -> 0x012c }
                long r7 = r1.sourcePos     // Catch:{ all -> 0x012c }
                long r11 = r7 - r5
                r10 = r21
                r13 = r2
                r9.copyTo((okio.Buffer) r10, (long) r11, (long) r13)     // Catch:{ all -> 0x012c }
                long r5 = r1.sourcePos     // Catch:{ all -> 0x012c }
                long r5 = r5 + r2
                r1.sourcePos = r5     // Catch:{ all -> 0x012c }
                monitor-exit(r4)     // Catch:{ all -> 0x012c }
                return r2
            L_0x012c:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x012c }
                throw r0
            L_0x012f:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "closed"
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    relay.sourceCount--;
                    if (Relay.this.sourceCount == 0) {
                        RandomAccessFile randomAccessFile2 = Relay.this.file;
                        Relay.this.file = null;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }
    }
}
