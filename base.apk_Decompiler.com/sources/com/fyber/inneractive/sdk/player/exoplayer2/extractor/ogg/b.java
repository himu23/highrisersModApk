package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.e;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class b extends h {
    public e n;
    public a o;

    public class a implements f, m {
        public long[] a;
        public long[] b;
        public long c = -1;
        public long d = -1;

        public a() {
        }

        public long a(g gVar) throws IOException, InterruptedException {
            long j = this.d;
            if (j < 0) {
                return -1;
            }
            long j2 = -(j + 2);
            this.d = -1;
            return j2;
        }

        public boolean a() {
            return true;
        }

        public m b() {
            return this;
        }

        public long c(long j) {
            long j2 = (((long) b.this.i) * j) / 1000000;
            this.d = this.a[u.b(this.a, j2, true, true)];
            return j2;
        }

        public long a(long j) {
            return this.c + this.b[u.b(this.a, (((long) b.this.i) * j) / 1000000, true, true)];
        }

        public long c() {
            e eVar = b.this.n;
            return (eVar.d * 1000000) / ((long) eVar.a);
        }
    }

    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }

    public long a(k kVar) {
        int i;
        int i2;
        int i3;
        byte[] bArr = kVar.a;
        int i4 = -1;
        if (bArr[0] != -1) {
            return -1;
        }
        int i5 = (bArr[2] & UByte.MAX_VALUE) >> 4;
        switch (i5) {
            case 1:
                i4 = 192;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                i2 = i5 - 2;
                i = 576;
                break;
            case 6:
            case 7:
                kVar.f(4);
                long j = (long) kVar.a[kVar.b];
                int i6 = 7;
                while (true) {
                    if (i6 >= 0) {
                        int i7 = 1 << i6;
                        if ((((long) i7) & j) != 0) {
                            i6--;
                        } else if (i6 < 6) {
                            j &= (long) (i7 - 1);
                            i3 = 7 - i6;
                        } else if (i6 == 7) {
                            i3 = 1;
                        }
                    }
                }
                i3 = 0;
                if (i3 != 0) {
                    int i8 = 1;
                    while (i8 < i3) {
                        byte b = kVar.a[kVar.b + i8];
                        if ((b & 192) == 128) {
                            j = (j << 6) | ((long) (b & 63));
                            i8++;
                        } else {
                            throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                        }
                    }
                    kVar.b += i3;
                    int l = i5 == 6 ? kVar.l() : kVar.q();
                    kVar.e(0);
                    i4 = l + 1;
                    break;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
                }
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i2 = i5 - 8;
                i = 256;
                break;
        }
        i4 = i << i2;
        return (long) i4;
    }

    public boolean a(k kVar, long j, h.a aVar) throws IOException, InterruptedException {
        k kVar2 = kVar;
        h.a aVar2 = aVar;
        byte[] bArr = kVar2.a;
        if (this.n == null) {
            this.n = new e(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, kVar2.c);
            copyOfRange[4] = ByteCompanionObject.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            e eVar = this.n;
            int i = eVar.c;
            int i2 = eVar.a;
            aVar2.a = i.a((String) null, "audio/flac", (String) null, -1, i * i2, eVar.b, i2, -1, (List<byte[]>) singletonList, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null);
        } else {
            byte b = bArr[0];
            if ((b & Byte.MAX_VALUE) == 3) {
                a aVar3 = new a();
                this.o = aVar3;
                kVar2.f(1);
                int n2 = kVar.n() / 18;
                aVar3.a = new long[n2];
                aVar3.b = new long[n2];
                for (int i3 = 0; i3 < n2; i3++) {
                    aVar3.a[i3] = kVar.i();
                    aVar3.b[i3] = kVar.i();
                    kVar2.f(2);
                }
            } else if (b == -1) {
                a aVar4 = this.o;
                if (aVar4 != null) {
                    aVar4.c = j;
                    aVar2.b = aVar4;
                }
                return false;
            }
        }
        return true;
    }
}
