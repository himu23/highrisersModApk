package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.b.a;
import com.applovin.exoplayer2.e.g;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;

public final class f implements j {
    private static final byte[] CH = {73, 68, 51};
    private int Ai;
    private final boolean CI;
    private final x CJ;
    private final y CK;
    private com.applovin.exoplayer2.e.x CL;
    private int CM;
    private boolean CN;
    private boolean CO;
    private int CP;
    private int CQ;
    private int CS;
    private com.applovin.exoplayer2.e.x CT;
    private long CU;
    private String Ct;
    private int Cu;
    private long Cw;
    private int Z;
    private final String dq;
    private long rJ;
    private boolean vJ;
    private com.applovin.exoplayer2.e.x wl;

    private void a(com.applovin.exoplayer2.e.x xVar, long j, int i, int i2) {
        this.Z = 4;
        this.Cu = i;
        this.CT = xVar;
        this.CU = j;
        this.Ai = i2;
    }

    public static boolean cu(int i) {
        return (i & 65526) == 65520;
    }

    private void jg() {
        this.Z = 0;
        this.Cu = 0;
        this.CM = 256;
    }

    private void ji() {
        this.Z = 3;
        this.Cu = 0;
    }

    private void jj() {
        this.Z = 1;
        this.Cu = 0;
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.rJ = j;
        }
    }

    public void jc() {
    }

    public long je() {
        return this.Cw;
    }

    public f(boolean z) {
        this(z, (String) null);
    }

    public f(boolean z, String str) {
        this.CJ = new x(new byte[7]);
        this.CK = new y(Arrays.copyOf(CH, 10));
        jg();
        this.CP = -1;
        this.CQ = -1;
        this.Cw = -9223372036854775807L;
        this.rJ = -9223372036854775807L;
        this.CI = z;
        this.dq = str;
    }

    public void jb() {
        this.rJ = -9223372036854775807L;
        jf();
    }

    public void a(j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        com.applovin.exoplayer2.e.x y = jVar.y(dVar.jz(), 1);
        this.wl = y;
        this.CT = y;
        if (this.CI) {
            dVar.jy();
            com.applovin.exoplayer2.e.x y2 = jVar.y(dVar.jz(), 5);
            this.CL = y2;
            y2.j(new v.a().g(dVar.jA()).m("application/id3").bT());
            return;
        }
        this.CL = new g();
    }

    public void K(y yVar) throws ai {
        jm();
        while (yVar.pj() > 0) {
            int i = this.Z;
            if (i == 0) {
                M(yVar);
            } else if (i == 1) {
                N(yVar);
            } else if (i != 2) {
                if (i == 3) {
                    if (a(yVar, this.CJ.tf, this.CN ? 7 : 5)) {
                        jl();
                    }
                } else if (i == 4) {
                    O(yVar);
                } else {
                    throw new IllegalStateException();
                }
            } else if (a(yVar, this.CK.hO(), 10)) {
                jk();
            }
        }
    }

    private void jf() {
        this.CO = false;
        jg();
    }

    private boolean a(y yVar, byte[] bArr, int i) {
        int min = Math.min(yVar.pj(), i - this.Cu);
        yVar.r(bArr, this.Cu, min);
        int i2 = this.Cu + min;
        this.Cu = i2;
        return i2 == i;
    }

    private void jh() {
        this.Z = 2;
        this.Cu = CH.length;
        this.Ai = 0;
        this.CK.fx(0);
    }

    private void M(y yVar) {
        byte[] hO = yVar.hO();
        int il = yVar.il();
        int pk = yVar.pk();
        while (il < pk) {
            int i = il + 1;
            byte b = hO[il];
            byte b2 = b & UByte.MAX_VALUE;
            if (this.CM != 512 || !a((byte) -1, (byte) b2) || (!this.CO && !n(yVar, il - 1))) {
                int i2 = this.CM;
                byte b3 = b2 | i2;
                if (b3 == 329) {
                    this.CM = 768;
                } else if (b3 == 511) {
                    this.CM = 512;
                } else if (b3 == 836) {
                    this.CM = 1024;
                } else if (b3 == 1075) {
                    jh();
                    yVar.fx(i);
                    return;
                } else if (i2 != 256) {
                    this.CM = 256;
                }
                il = i;
            } else {
                this.CS = (b & 8) >> 3;
                boolean z = true;
                if ((b & 1) != 0) {
                    z = false;
                }
                this.CN = z;
                if (!this.CO) {
                    jj();
                } else {
                    ji();
                }
                yVar.fx(i);
                return;
            }
        }
        yVar.fx(il);
    }

    private void N(y yVar) {
        if (yVar.pj() != 0) {
            this.CJ.tf[0] = yVar.hO()[yVar.il()];
            this.CJ.fx(2);
            int bQ = this.CJ.bQ(4);
            int i = this.CQ;
            if (i == -1 || bQ == i) {
                if (!this.CO) {
                    this.CO = true;
                    this.CP = this.CS;
                    this.CQ = bQ;
                }
                ji();
                return;
            }
            jf();
        }
    }

    private boolean n(y yVar, int i) {
        yVar.fx(i + 1);
        if (!b(yVar, this.CJ.tf, 1)) {
            return false;
        }
        this.CJ.fx(4);
        int bQ = this.CJ.bQ(1);
        int i2 = this.CP;
        if (i2 != -1 && bQ != i2) {
            return false;
        }
        if (this.CQ != -1) {
            if (!b(yVar, this.CJ.tf, 1)) {
                return true;
            }
            this.CJ.fx(2);
            if (this.CJ.bQ(4) != this.CQ) {
                return false;
            }
            yVar.fx(i + 2);
        }
        if (!b(yVar, this.CJ.tf, 4)) {
            return true;
        }
        this.CJ.fx(14);
        int bQ2 = this.CJ.bQ(13);
        if (bQ2 < 7) {
            return false;
        }
        byte[] hO = yVar.hO();
        int pk = yVar.pk();
        int i3 = i + bQ2;
        if (i3 >= pk) {
            return true;
        }
        byte b = hO[i3];
        if (b == -1) {
            int i4 = i3 + 1;
            if (i4 == pk) {
                return true;
            }
            if (!a((byte) -1, hO[i4]) || ((hO[i4] & 8) >> 3) != bQ) {
                return false;
            }
            return true;
        } else if (b != 73) {
            return false;
        } else {
            int i5 = i3 + 1;
            if (i5 == pk) {
                return true;
            }
            if (hO[i5] != 68) {
                return false;
            }
            int i6 = i3 + 2;
            if (i6 == pk || hO[i6] == 51) {
                return true;
            }
            return false;
        }
    }

    private boolean a(byte b, byte b2) {
        return cu(((b & UByte.MAX_VALUE) << 8) | (b2 & UByte.MAX_VALUE));
    }

    private boolean b(y yVar, byte[] bArr, int i) {
        if (yVar.pj() < i) {
            return false;
        }
        yVar.r(bArr, 0, i);
        return true;
    }

    private void jk() {
        this.CL.c(this.CK, 10);
        this.CK.fx(6);
        a(this.CL, 0, 10, this.CK.pC() + 10);
    }

    private void jl() throws ai {
        this.CJ.fx(0);
        if (!this.vJ) {
            int i = 2;
            int bQ = this.CJ.bQ(2) + 1;
            if (bQ != 2) {
                q.h("AdtsReader", "Detected audio object type: " + bQ + ", but assuming AAC LC.");
            } else {
                i = bQ;
            }
            this.CJ.bR(5);
            byte[] b = a.b(i, this.CQ, this.CJ.bQ(3));
            a.C0031a b2 = a.b(b);
            v bT = new v.a().g(this.Ct).m("audio/mp4a-latm").k(b2.dw).N(b2.dL).O(b2.js).c((List<byte[]>) Collections.singletonList(b)).j(this.dq).bT();
            this.Cw = 1024000000 / ((long) bT.dM);
            this.wl.j(bT);
            this.vJ = true;
        } else {
            this.CJ.bR(10);
        }
        this.CJ.bR(4);
        int bQ2 = this.CJ.bQ(13);
        int i2 = bQ2 - 7;
        if (this.CN) {
            i2 = bQ2 - 9;
        }
        a(this.wl, this.Cw, 0, i2);
    }

    private void O(y yVar) {
        int min = Math.min(yVar.pj(), this.Ai - this.Cu);
        this.CT.c(yVar, min);
        int i = this.Cu + min;
        this.Cu = i;
        int i2 = this.Ai;
        if (i == i2) {
            long j = this.rJ;
            if (j != -9223372036854775807L) {
                this.CT.a(j, 1, i2, 0, (x.a) null);
                this.rJ += this.CU;
            }
            jg();
        }
    }

    private void jm() {
        com.applovin.exoplayer2.l.a.checkNotNull(this.wl);
        com.applovin.exoplayer2.l.ai.R(this.CT);
        com.applovin.exoplayer2.l.ai.R(this.CL);
    }
}
