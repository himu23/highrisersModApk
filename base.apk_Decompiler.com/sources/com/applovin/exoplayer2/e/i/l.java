package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.v;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;

public final class l implements j {
    private static final float[] Dr = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private String Ct;
    private final af Dc;
    private final y Dd;
    private final r De;
    private final boolean[] Df;
    private long Dh;
    private long Dk;
    private final a Ds;
    private b Dt;
    private boolean vJ;
    private x wl;

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.Dk = j;
        }
    }

    public void jc() {
    }

    public l() {
        this((af) null);
    }

    l(af afVar) {
        this.Dc = afVar;
        this.Df = new boolean[4];
        this.Ds = new a(128);
        this.Dk = -9223372036854775807L;
        if (afVar != null) {
            this.De = new r(178, 128);
            this.Dd = new y();
            return;
        }
        this.De = null;
        this.Dd = null;
    }

    public void jb() {
        v.b(this.Df);
        this.Ds.Y();
        b bVar = this.Dt;
        if (bVar != null) {
            bVar.Y();
        }
        r rVar = this.De;
        if (rVar != null) {
            rVar.Y();
        }
        this.Dh = 0;
        this.Dk = -9223372036854775807L;
    }

    public void a(j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        x y = jVar.y(dVar.jz(), 2);
        this.wl = y;
        this.Dt = new b(y);
        af afVar = this.Dc;
        if (afVar != null) {
            afVar.a(jVar, dVar);
        }
    }

    public void K(y yVar) {
        com.applovin.exoplayer2.l.a.N(this.Dt);
        com.applovin.exoplayer2.l.a.N(this.wl);
        int il = yVar.il();
        int pk = yVar.pk();
        byte[] hO = yVar.hO();
        this.Dh += (long) yVar.pj();
        this.wl.c(yVar, yVar.pj());
        while (true) {
            int a2 = v.a(hO, il, pk, this.Df);
            if (a2 == pk) {
                break;
            }
            int i = a2 + 3;
            byte b2 = yVar.hO()[i] & UByte.MAX_VALUE;
            int i2 = a2 - il;
            int i3 = 0;
            if (!this.vJ) {
                if (i2 > 0) {
                    this.Ds.e(hO, il, a2);
                }
                if (this.Ds.B(b2, i2 < 0 ? -i2 : 0)) {
                    x xVar = this.wl;
                    a aVar = this.Ds;
                    xVar.j(a(aVar, aVar.Du, (String) com.applovin.exoplayer2.l.a.checkNotNull(this.Ct)));
                    this.vJ = true;
                }
            }
            this.Dt.e(hO, il, a2);
            r rVar = this.De;
            if (rVar != null) {
                if (i2 > 0) {
                    rVar.g(hO, il, a2);
                } else {
                    i3 = -i2;
                }
                if (this.De.cC(i3)) {
                    ((y) ai.R(this.Dd)).l(this.De.EJ, v.i(this.De.EJ, this.De.EK));
                    ((af) ai.R(this.Dc)).a(this.Dk, this.Dd);
                }
                if (b2 == 178 && yVar.hO()[a2 + 2] == 1) {
                    this.De.cB(b2);
                }
            }
            int i4 = pk - a2;
            this.Dt.a(this.Dh - ((long) i4), i4, this.vJ);
            this.Dt.g(b2, this.Dk);
            il = i;
        }
        if (!this.vJ) {
            this.Ds.e(hO, il, pk);
        }
        this.Dt.e(hO, il, pk);
        r rVar2 = this.De;
        if (rVar2 != null) {
            rVar2.g(hO, il, pk);
        }
    }

    private static com.applovin.exoplayer2.v a(a aVar, int i, String str) {
        byte[] copyOf = Arrays.copyOf(aVar.tf, aVar.fR);
        com.applovin.exoplayer2.l.x xVar = new com.applovin.exoplayer2.l.x(copyOf);
        xVar.fz(i);
        xVar.fz(4);
        xVar.ph();
        xVar.bR(8);
        if (xVar.ik()) {
            xVar.bR(4);
            xVar.bR(3);
        }
        int bQ = xVar.bQ(4);
        float f = 1.0f;
        if (bQ == 15) {
            int bQ2 = xVar.bQ(8);
            int bQ3 = xVar.bQ(8);
            if (bQ3 == 0) {
                q.h("H263Reader", "Invalid aspect ratio");
            } else {
                f = ((float) bQ2) / ((float) bQ3);
            }
        } else {
            float[] fArr = Dr;
            if (bQ < fArr.length) {
                f = fArr[bQ];
            } else {
                q.h("H263Reader", "Invalid aspect ratio");
            }
        }
        if (xVar.ik()) {
            xVar.bR(2);
            xVar.bR(1);
            if (xVar.ik()) {
                xVar.bR(15);
                xVar.ph();
                xVar.bR(15);
                xVar.ph();
                xVar.bR(15);
                xVar.ph();
                xVar.bR(3);
                xVar.bR(11);
                xVar.ph();
                xVar.bR(15);
                xVar.ph();
            }
        }
        if (xVar.bQ(2) != 0) {
            q.h("H263Reader", "Unhandled video object layer shape");
        }
        xVar.ph();
        int bQ4 = xVar.bQ(16);
        xVar.ph();
        if (xVar.ik()) {
            if (bQ4 == 0) {
                q.h("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i2 = 0;
                for (int i3 = bQ4 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                xVar.bR(i2);
            }
        }
        xVar.ph();
        int bQ5 = xVar.bQ(13);
        xVar.ph();
        int bQ6 = xVar.bQ(13);
        xVar.ph();
        xVar.ph();
        return new v.a().g(str).m("video/mp4v-es").J(bQ5).K(bQ6).e(f).c((List<byte[]>) Collections.singletonList(copyOf)).bT();
    }

    private static final class a {
        private static final byte[] Do = {0, 0, 1};
        private boolean Dp;
        public int Du;
        private int Z;
        public int fR;
        public byte[] tf;

        public void Y() {
            this.Dp = false;
            this.fR = 0;
            this.Z = 0;
        }

        public a(int i) {
            this.tf = new byte[i];
        }

        public boolean B(int i, int i2) {
            int i3 = this.Z;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new IllegalStateException();
                            } else if (i == 179 || i == 181) {
                                this.fR -= i2;
                                this.Dp = false;
                                return true;
                            }
                        } else if ((i & 240) != 32) {
                            q.h("H263Reader", "Unexpected start code value");
                            Y();
                        } else {
                            this.Du = this.fR;
                            this.Z = 4;
                        }
                    } else if (i > 31) {
                        q.h("H263Reader", "Unexpected start code value");
                        Y();
                    } else {
                        this.Z = 3;
                    }
                } else if (i != 181) {
                    q.h("H263Reader", "Unexpected start code value");
                    Y();
                } else {
                    this.Z = 2;
                }
            } else if (i == 176) {
                this.Z = 1;
                this.Dp = true;
            }
            byte[] bArr = Do;
            e(bArr, 0, bArr.length);
            return false;
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.Dp) {
                int i3 = i2 - i;
                byte[] bArr2 = this.tf;
                int length = bArr2.length;
                int i4 = this.fR;
                if (length < i4 + i3) {
                    this.tf = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.tf, this.fR, i3);
                this.fR += i3;
            }
        }
    }

    private static final class b {
        private long Da;
        private long Dl;
        private boolean Dm;
        private boolean Dv;
        private boolean Dw;
        private int Dx;
        private int Dy;
        private final x wl;

        public void Y() {
            this.Dv = false;
            this.Dw = false;
            this.Dm = false;
            this.Dx = -1;
        }

        public void g(int i, long j) {
            this.Dx = i;
            this.Dm = false;
            boolean z = true;
            this.Dv = i == 182 || i == 179;
            if (i != 182) {
                z = false;
            }
            this.Dw = z;
            this.Dy = 0;
            this.Da = j;
        }

        public b(x xVar) {
            this.wl = xVar;
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.Dw) {
                int i3 = this.Dy;
                int i4 = (i + 1) - i3;
                if (i4 < i2) {
                    this.Dm = ((bArr[i4] & 192) >> 6) == 0;
                    this.Dw = false;
                    return;
                }
                this.Dy = i3 + (i2 - i);
            }
        }

        public void a(long j, int i, boolean z) {
            if (this.Dx == 182 && z && this.Dv) {
                long j2 = this.Da;
                if (j2 != -9223372036854775807L) {
                    int i2 = (int) (j - this.Dl);
                    this.wl.a(j2, this.Dm ? 1 : 0, i2, i, (x.a) null);
                }
            }
            if (this.Dx != 179) {
                this.Dl = j;
            }
        }
    }
}
