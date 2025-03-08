package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.applovin.exoplayer2.common.base.Ascii;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.util.List;

public final class b implements h {
    public final j a;
    public final k b;
    public final String c;
    public String d;
    public n e;
    public int f = 0;
    public int g;
    public boolean h;
    public long i;
    public i j;
    public int k;
    public long l;

    public b(String str) {
        byte[] bArr = new byte[8];
        this.a = new j(bArr);
        this.b = new k(bArr);
        this.c = str;
    }

    public void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
    }

    public void a(long j2, boolean z) {
        this.l = j2;
    }

    public void b() {
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = hVar.a(dVar.c(), 1);
    }

    public void a(k kVar) {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        k kVar2 = kVar;
        while (kVar.a() > 0) {
            int i6 = this.f;
            if (i6 == 0) {
                while (true) {
                    if (kVar.a() <= 0) {
                        break;
                    } else if (!this.h) {
                        this.h = kVar.l() == 11;
                    } else {
                        int l2 = kVar.l();
                        if (l2 == 119) {
                            this.h = false;
                            this.f = 1;
                            byte[] bArr = this.b.a;
                            bArr[0] = Ascii.VT;
                            bArr[1] = 119;
                            this.g = 2;
                            break;
                        }
                        this.h = l2 == 11;
                    }
                }
            } else if (i6 == 1) {
                byte[] bArr2 = this.b.a;
                int min = Math.min(kVar.a(), 8 - this.g);
                System.arraycopy(kVar2.a, kVar2.b, bArr2, this.g, min);
                kVar2.b += min;
                int i7 = this.g + min;
                this.g = i7;
                if (i7 == 8) {
                    this.a.b(0);
                    j jVar = this.a;
                    int i8 = (jVar.b * 8) + jVar.c;
                    jVar.c(40);
                    boolean z = jVar.a(5) == 16;
                    jVar.b(i8);
                    int i9 = 6;
                    if (z) {
                        jVar.c(21);
                        i5 = (jVar.a(11) + 1) * 2;
                        int a2 = jVar.a(2);
                        if (a2 == 3) {
                            i4 = a.c[jVar.a(2)];
                        } else {
                            i9 = a.a[jVar.a(2)];
                            i4 = a.b[a2];
                        }
                        i3 = i9 * 256;
                        i2 = jVar.a(3);
                        str = "audio/eac3";
                    } else {
                        jVar.c(32);
                        int a3 = jVar.a(2);
                        int a4 = a.a(a3, jVar.a(6));
                        jVar.c(8);
                        i2 = jVar.a(3);
                        if (!((i2 & 1) == 0 || i2 == 1)) {
                            jVar.c(2);
                        }
                        if ((i2 & 4) != 0) {
                            jVar.c(2);
                        }
                        if (i2 == 2) {
                            jVar.c(2);
                        }
                        i4 = a.b[a3];
                        i5 = a4;
                        str = "audio/ac3";
                        i3 = 1536;
                    }
                    int i10 = a.d[i2] + (jVar.b() ? 1 : 0);
                    i iVar = this.j;
                    if (!(iVar != null && i10 == iVar.r && i4 == iVar.s && str == iVar.f)) {
                        i a5 = i.a(this.d, str, (String) null, -1, -1, i10, i4, -1, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, this.c);
                        this.j = a5;
                        this.e.a(a5);
                    }
                    this.k = i5;
                    this.i = (((long) i3) * 1000000) / ((long) this.j.s);
                    this.b.e(0);
                    this.e.a(this.b, 8);
                    this.f = 2;
                }
            } else if (i6 == 2) {
                int min2 = Math.min(kVar.a(), this.k - this.g);
                this.e.a(kVar2, min2);
                int i11 = this.g + min2;
                this.g = i11;
                int i12 = this.k;
                if (i11 == i12) {
                    this.e.a(this.l, 1, i12, 0, (byte[]) null);
                    this.l += this.i;
                    this.f = 0;
                }
            }
        }
    }
}
