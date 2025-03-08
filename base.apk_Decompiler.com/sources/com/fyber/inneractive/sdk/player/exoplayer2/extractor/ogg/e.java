package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.EOFException;
import java.io.IOException;

public final class e {
    public static final int h = u.a("OggS");
    public int a;
    public long b;
    public int c;
    public int d;
    public int e;
    public final int[] f = new int[255];
    public final k g = new k(255);

    public void a() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public boolean a(g gVar, boolean z) throws IOException, InterruptedException {
        this.g.r();
        a();
        b bVar = (b) gVar;
        long j = bVar.b;
        if ((j == -1 || j - (bVar.c + ((long) bVar.e)) >= 27) && bVar.a(this.g.a, 0, 27, true)) {
            if (this.g.m() != ((long) h)) {
                if (z) {
                    return false;
                }
                throw new l("expected OggS capture pattern at begin of page");
            } else if (this.g.l() == 0) {
                this.a = this.g.l();
                k kVar = this.g;
                byte[] bArr = kVar.a;
                int i = kVar.b;
                int i2 = i + 1;
                kVar.b = i2;
                int i3 = i + 2;
                kVar.b = i3;
                long j2 = (((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8);
                int i4 = i + 3;
                kVar.b = i4;
                long j3 = ((((long) bArr[i3]) & 255) << 16) | j2;
                int i5 = i + 4;
                kVar.b = i5;
                int i6 = i + 5;
                kVar.b = i6;
                int i7 = i + 6;
                kVar.b = i7;
                int i8 = i + 7;
                kVar.b = i8;
                kVar.b = i + 8;
                this.b = j3 | ((((long) bArr[i4]) & 255) << 24) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 40) | ((((long) bArr[i7]) & 255) << 48) | ((((long) bArr[i8]) & 255) << 56);
                kVar.f();
                this.g.f();
                this.g.f();
                int l = this.g.l();
                this.c = l;
                this.d = l + 27;
                this.g.r();
                bVar.a(this.g.a, 0, this.c, false);
                for (int i9 = 0; i9 < this.c; i9++) {
                    this.f[i9] = this.g.l();
                    this.e += this.f[i9];
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new l("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new EOFException();
        }
    }
}
