package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.drm.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.e;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.c;
import com.fyber.inneractive.sdk.player.exoplayer2.util.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;

public final class d implements h {
    public static final byte[] r = {73, 68, 51};
    public final boolean a;
    public final j b = new j(new byte[7]);
    public final k c = new k(Arrays.copyOf(r, 10));
    public final String d;
    public String e;
    public n f;
    public n g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public long m;
    public int n;
    public long o;
    public n p;
    public long q;

    public d(boolean z, String str) {
        c();
        this.a = z;
        this.d = str;
    }

    public void a() {
        c();
    }

    public void a(long j2, boolean z) {
        this.o = j2;
    }

    public void b() {
    }

    public final void c() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.e = dVar.b();
        this.f = hVar.a(dVar.c(), 1);
        if (this.a) {
            dVar.a();
            n a2 = hVar.a(dVar.c(), 4);
            this.g = a2;
            a2.a(i.a(dVar.b(), "application/id3", (String) null, -1, (a) null));
            return;
        }
        this.g = new e();
    }

    public void a(k kVar) {
        k kVar2 = kVar;
        while (kVar.a() > 0) {
            int i2 = this.h;
            boolean z = true;
            if (i2 == 0) {
                byte[] bArr = kVar2.a;
                int i3 = kVar2.b;
                int i4 = kVar2.c;
                while (true) {
                    if (i3 >= i4) {
                        kVar2.e(i3);
                        break;
                    }
                    int i5 = i3 + 1;
                    byte b2 = bArr[i3];
                    byte b3 = b2 & UByte.MAX_VALUE;
                    int i6 = this.j;
                    if (i6 != 512 || b3 < 240 || b3 == 255) {
                        byte b4 = i6 | b3;
                        if (b4 == 329) {
                            this.j = 768;
                        } else if (b4 == 511) {
                            this.j = 512;
                        } else if (b4 != 836) {
                            if (b4 == 1075) {
                                this.h = 1;
                                this.i = r.length;
                                this.n = 0;
                                this.c.e(0);
                                kVar2.e(i5);
                                break;
                            } else if (i6 != 256) {
                                this.j = 256;
                            }
                        } else {
                            this.j = 1024;
                        }
                        i3 = i5;
                    } else {
                        if ((b2 & 1) != 0) {
                            z = false;
                        }
                        this.k = z;
                        this.h = 2;
                        this.i = 0;
                        kVar2.e(i5);
                    }
                }
            } else if (i2 != 1) {
                if (i2 == 2) {
                    if (a(kVar2, this.b.a, this.k ? 7 : 5)) {
                        this.b.b(0);
                        if (!this.l) {
                            int a2 = this.b.a(2) + 1;
                            if (a2 != 2) {
                                Log.w("AdtsReader", "Detected audio object type: " + a2 + ", but assuming AAC LC.");
                                a2 = 2;
                            }
                            int a3 = this.b.a(4);
                            this.b.c(1);
                            byte[] bArr2 = {(byte) (((a2 << 3) & 248) | ((a3 >> 1) & 7)), (byte) (((a3 << 7) & 128) | ((this.b.a(3) << 3) & 120))};
                            Pair<Integer, Integer> a4 = c.a(bArr2);
                            i a5 = i.a(this.e, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) a4.second).intValue(), ((Integer) a4.first).intValue(), -1, (List<byte[]>) Collections.singletonList(bArr2), (a) null, 0, this.d);
                            this.m = 1024000000 / ((long) a5.s);
                            this.f.a(a5);
                            this.l = true;
                        } else {
                            this.b.c(10);
                        }
                        this.b.c(4);
                        int a6 = this.b.a(13);
                        int i7 = a6 - 7;
                        if (this.k) {
                            i7 = a6 - 9;
                        }
                        n nVar = this.f;
                        long j2 = this.m;
                        this.h = 3;
                        this.i = 0;
                        this.p = nVar;
                        this.q = j2;
                        this.n = i7;
                    }
                } else if (i2 == 3) {
                    int min = Math.min(kVar.a(), this.n - this.i);
                    this.p.a(kVar2, min);
                    int i8 = this.i + min;
                    this.i = i8;
                    int i9 = this.n;
                    if (i8 == i9) {
                        this.p.a(this.o, 1, i9, 0, (byte[]) null);
                        this.o += this.q;
                        c();
                    }
                }
            } else if (a(kVar2, this.c.a, 10)) {
                this.g.a(this.c, 10);
                this.c.e(6);
                n nVar2 = this.g;
                this.h = 3;
                this.i = 10;
                this.p = nVar2;
                this.q = 0;
                this.n = this.c.k() + 10;
            }
        }
    }

    public final boolean a(k kVar, byte[] bArr, int i2) {
        int min = Math.min(kVar.a(), i2 - this.i);
        System.arraycopy(kVar.a, kVar.b, bArr, this.i, min);
        kVar.b += min;
        int i3 = this.i + min;
        this.i = i3;
        return i3 == i2;
    }
}
