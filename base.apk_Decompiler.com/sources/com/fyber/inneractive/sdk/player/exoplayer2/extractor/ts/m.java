package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.fyber.inneractive.sdk.player.exoplayer2.drm.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.util.List;
import kotlin.UByte;

public final class m implements h {
    public final k a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.k b;
    public final String c;
    public String d;
    public n e;
    public int f = 0;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public long l;

    public m(String str) {
        k kVar = new k(4);
        this.a = kVar;
        kVar.a[0] = -1;
        this.b = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.k();
        this.c = str;
    }

    public void a() {
        this.f = 0;
        this.g = 0;
        this.i = false;
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
        k kVar2 = kVar;
        while (kVar.a() > 0) {
            int i2 = this.f;
            if (i2 == 0) {
                byte[] bArr = kVar2.a;
                int i3 = kVar2.b;
                int i4 = kVar2.c;
                while (true) {
                    if (i3 >= i4) {
                        kVar2.e(i4);
                        break;
                    }
                    byte b2 = bArr[i3];
                    boolean z = (b2 & UByte.MAX_VALUE) == 255;
                    boolean z2 = this.i && (b2 & 224) == 224;
                    this.i = z;
                    if (z2) {
                        kVar2.e(i3 + 1);
                        this.i = false;
                        this.a.a[1] = bArr[i3];
                        this.g = 2;
                        this.f = 1;
                        break;
                    }
                    i3++;
                }
            } else if (i2 == 1) {
                int min = Math.min(kVar.a(), 4 - this.g);
                kVar2.a(this.a.a, this.g, min);
                int i5 = this.g + min;
                this.g = i5;
                if (i5 >= 4) {
                    this.a.e(0);
                    if (!com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(this.a.c(), this.b)) {
                        this.g = 0;
                        this.f = 1;
                    } else {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.k kVar3 = this.b;
                        this.k = kVar3.c;
                        if (!this.h) {
                            int i6 = kVar3.d;
                            this.j = (((long) kVar3.g) * 1000000) / ((long) i6);
                            this.e.a(i.a(this.d, kVar3.b, (String) null, -1, 4096, kVar3.e, i6, -1, (List<byte[]>) null, (a) null, 0, this.c));
                            this.h = true;
                        }
                        this.a.e(0);
                        this.e.a(this.a, 4);
                        this.f = 2;
                    }
                }
            } else if (i2 == 2) {
                int min2 = Math.min(kVar.a(), this.k - this.g);
                this.e.a(kVar2, min2);
                int i7 = this.g + min2;
                this.g = i7;
                int i8 = this.k;
                if (i7 >= i8) {
                    this.e.a(this.l, 1, i8, 0, (byte[]) null);
                    this.l += this.j;
                    this.g = 0;
                    this.f = 0;
                }
            }
        }
    }
}
