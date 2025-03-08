package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import androidx.core.view.InputDeviceCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import kotlin.UByte;

public final class r implements v {
    public final q a;
    public final k b = new k(32);
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public r(q qVar) {
        this.a = qVar;
    }

    public void a() {
        this.f = true;
    }

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar, h hVar, v.d dVar) {
        this.a.a(rVar, hVar, dVar);
        this.f = true;
    }

    public void a(k kVar, boolean z) {
        int i;
        if (z) {
            i = kVar.b + kVar.l();
        } else {
            i = -1;
        }
        if (this.f) {
            if (z) {
                this.f = false;
                kVar.e(i);
                this.d = 0;
            } else {
                return;
            }
        }
        while (kVar.a() > 0) {
            int i2 = this.d;
            boolean z2 = true;
            if (i2 < 3) {
                if (i2 == 0) {
                    int l = kVar.l();
                    kVar.e(kVar.b - 1);
                    if (l == 255) {
                        this.f = true;
                        return;
                    }
                }
                int min = Math.min(kVar.a(), 3 - this.d);
                kVar.a(this.b.a, this.d, min);
                int i3 = this.d + min;
                this.d = i3;
                if (i3 == 3) {
                    this.b.c(3);
                    this.b.f(1);
                    int l2 = this.b.l();
                    int l3 = this.b.l();
                    if ((l2 & 128) == 0) {
                        z2 = false;
                    }
                    this.e = z2;
                    this.c = (((l2 & 15) << 8) | l3) + 3;
                    int b2 = this.b.b();
                    int i4 = this.c;
                    if (b2 < i4) {
                        k kVar2 = this.b;
                        byte[] bArr = kVar2.a;
                        kVar2.c(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i4, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.b.a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(kVar.a(), this.c - this.d);
                kVar.a(this.b.a, this.d, min2);
                int i5 = this.d + min2;
                this.d = i5;
                int i6 = this.c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (this.e) {
                        byte[] bArr2 = this.b.a;
                        int i7 = u.a;
                        int i8 = -1;
                        for (int i9 = 0; i9 < i6; i9++) {
                            i8 = u.h[((i8 >>> 24) ^ (bArr2[i9] & UByte.MAX_VALUE)) & UByte.MAX_VALUE] ^ (i8 << 8);
                        }
                        if (i8 != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.c(this.c - 4);
                    } else {
                        this.b.c(i6);
                    }
                    this.a.a(this.b);
                    this.d = 0;
                }
            }
        }
    }
}
