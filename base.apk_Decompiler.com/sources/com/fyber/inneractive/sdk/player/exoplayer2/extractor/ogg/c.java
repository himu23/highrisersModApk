package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.io.IOException;
import java.util.Arrays;

public class c implements f {
    public h a;

    public boolean a(g gVar) throws IOException, InterruptedException {
        try {
            e eVar = new e();
            if (eVar.a(gVar, true)) {
                if ((eVar.a & 2) == 2) {
                    int min = Math.min(eVar.e, 8);
                    k kVar = new k(min);
                    ((b) gVar).a(kVar.a, 0, min, false);
                    kVar.e(0);
                    if (kVar.a() >= 5 && kVar.l() == 127 && kVar.m() == 1179402563) {
                        this.a = new b();
                    } else {
                        kVar.e(0);
                        try {
                            if (k.a(1, kVar, true)) {
                                this.a = new j();
                            }
                        } catch (l unused) {
                        }
                        kVar.e(0);
                        int i = g.o;
                        int a2 = kVar.a();
                        byte[] bArr = g.p;
                        if (a2 >= bArr.length) {
                            byte[] bArr2 = new byte[bArr.length];
                            int length = bArr.length;
                            System.arraycopy(kVar.a, kVar.b, bArr2, 0, length);
                            kVar.b += length;
                            if (Arrays.equals(bArr2, bArr)) {
                                this.a = new g();
                            }
                        }
                    }
                    return true;
                }
            }
        } catch (l unused2) {
        }
        return false;
    }

    public void b() {
    }

    public void a(h hVar) {
        n a2 = hVar.a(0, 1);
        hVar.c();
        h hVar2 = this.a;
        hVar2.c = hVar;
        hVar2.b = a2;
        hVar2.a = new d();
        hVar2.a(true);
    }

    public void a(long j, long j2) {
        h hVar = this.a;
        d dVar = hVar.a;
        dVar.a.a();
        dVar.b.r();
        dVar.c = -1;
        dVar.e = false;
        if (j == 0) {
            hVar.a(!hVar.l);
        } else if (hVar.h != 0) {
            hVar.e = hVar.d.c(j2);
            hVar.h = 2;
        }
    }

    public int a(g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) throws IOException, InterruptedException {
        g gVar2 = gVar;
        h hVar = this.a;
        int i = hVar.h;
        if (i == 0) {
            while (hVar.a.a(gVar2)) {
                b bVar = (b) gVar2;
                long j = bVar.c;
                long j2 = hVar.f;
                hVar.k = j - j2;
                boolean a2 = hVar.a(hVar.a.b, j2, hVar.j);
                if (a2) {
                    hVar.f = bVar.c;
                    continue;
                }
                if (!a2) {
                    i iVar = hVar.j.a;
                    hVar.i = iVar.s;
                    if (!hVar.m) {
                        hVar.b.a(iVar);
                        hVar.m = true;
                    }
                    f fVar = hVar.j.b;
                    if (fVar != null) {
                        hVar.d = fVar;
                    } else {
                        long j3 = ((b) gVar2).b;
                        if (j3 == -1) {
                            hVar.d = new h.b();
                        } else {
                            e eVar = hVar.a.a;
                            hVar.d = new a(hVar.f, j3, hVar, eVar.d + eVar.e, eVar.b);
                        }
                    }
                    hVar.j = null;
                    hVar.h = 2;
                    k kVar = hVar.a.b;
                    byte[] bArr = kVar.a;
                    if (bArr.length != 65025) {
                        kVar.a = Arrays.copyOf(bArr, Math.max(65025, kVar.c));
                    }
                }
            }
            hVar.h = 3;
            return -1;
        } else if (i == 1) {
            ((b) gVar2).c((int) hVar.f);
            hVar.h = 2;
        } else if (i == 2) {
            long a3 = hVar.d.a(gVar2);
            if (a3 >= 0) {
                lVar.a = a3;
                return 1;
            }
            if (a3 < -1) {
                hVar.b(-(a3 + 2));
            }
            if (!hVar.l) {
                hVar.c.a(hVar.d.b());
                hVar.l = true;
            }
            if (hVar.k > 0 || hVar.a.a(gVar2)) {
                hVar.k = 0;
                k kVar2 = hVar.a.b;
                long a4 = hVar.a(kVar2);
                if (a4 >= 0) {
                    long j4 = hVar.g;
                    if (j4 + a4 >= hVar.e) {
                        long j5 = (j4 * 1000000) / ((long) hVar.i);
                        hVar.b.a(kVar2, kVar2.c);
                        hVar.b.a(j5, 1, kVar2.c, 0, (byte[]) null);
                        hVar.e = -1;
                    }
                }
                hVar.g += a4;
            } else {
                hVar.h = 3;
                return -1;
            }
        } else {
            throw new IllegalStateException();
        }
        return 0;
    }
}
