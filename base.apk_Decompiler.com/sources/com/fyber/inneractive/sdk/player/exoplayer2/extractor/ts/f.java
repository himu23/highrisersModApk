package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.applovin.exoplayer2.common.base.Ascii;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.e;
import com.fyber.inneractive.sdk.player.exoplayer2.drm.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class f implements h {
    public final k a;
    public final String b;
    public String c;
    public n d;
    public int e = 0;
    public int f;
    public int g;
    public long h;
    public i i;
    public int j;
    public long k;

    public f(String str) {
        k kVar = new k(new byte[15]);
        this.a = kVar;
        byte[] bArr = kVar.a;
        bArr[0] = Byte.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = ByteCompanionObject.MIN_VALUE;
        bArr[3] = 1;
        this.b = str;
    }

    public void a() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    public void a(long j2, boolean z) {
        this.k = j2;
    }

    public void b() {
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.c = dVar.b();
        this.d = hVar.a(dVar.c(), 1);
    }

    public void a(k kVar) {
        int i2;
        k kVar2 = kVar;
        while (kVar.a() > 0) {
            int i3 = this.e;
            if (i3 == 0) {
                while (true) {
                    if (kVar.a() <= 0) {
                        break;
                    }
                    int i4 = this.g << 8;
                    this.g = i4;
                    int l = i4 | kVar.l();
                    this.g = l;
                    if (l == 2147385345) {
                        this.g = 0;
                        this.f = 4;
                        this.e = 1;
                        break;
                    }
                }
            } else if (i3 == 1) {
                byte[] bArr = this.a.a;
                int min = Math.min(kVar.a(), 15 - this.f);
                System.arraycopy(kVar2.a, kVar2.b, bArr, this.f, min);
                kVar2.b += min;
                int i5 = this.f + min;
                this.f = i5;
                if (i5 == 15) {
                    byte[] bArr2 = this.a.a;
                    if (this.i == null) {
                        String str = this.c;
                        String str2 = this.b;
                        j jVar = new j(bArr2, bArr2.length);
                        jVar.c(60);
                        int i6 = e.a[jVar.a(6)];
                        int i7 = e.b[jVar.a(4)];
                        int a2 = jVar.a(5);
                        int[] iArr = e.c;
                        if (a2 >= iArr.length) {
                            i2 = -1;
                        } else {
                            i2 = (iArr[a2] * 1000) / 2;
                        }
                        jVar.c(10);
                        i a3 = i.a(str, "audio/vnd.dts", (String) null, i2, -1, i6 + (jVar.a(2) > 0 ? 1 : 0), i7, -1, (List<byte[]>) null, (a) null, 0, str2);
                        this.i = a3;
                        this.d.a(a3);
                    }
                    byte b2 = bArr2[5];
                    this.j = (((b2 & 2) << Ascii.FF) | ((bArr2[6] & UByte.MAX_VALUE) << 4) | ((bArr2[7] & 240) >> 4)) + 1;
                    this.h = (long) ((int) ((((long) (((((bArr2[4] & 1) << 6) | ((b2 & 252) >> 2)) + 1) * 32)) * 1000000) / ((long) this.i.s)));
                    this.a.e(0);
                    this.d.a(this.a, 15);
                    this.e = 2;
                }
            } else if (i3 == 2) {
                int min2 = Math.min(kVar.a(), this.j - this.f);
                this.d.a(kVar2, min2);
                int i8 = this.f + min2;
                this.f = i8;
                int i9 = this.j;
                if (i8 == i9) {
                    this.d.a(this.k, 1, i9, 0, (byte[]) null);
                    this.k += this.h;
                    this.e = 0;
                }
            }
        }
    }
}
