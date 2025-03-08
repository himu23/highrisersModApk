package com.applovin.exoplayer2.i.g;

import android.text.Layout;

final class g {
    private int Qc;
    private float RE;
    private String SK;
    private int SL;
    private boolean SM;
    private boolean SN;
    private int SQ = -1;
    private int SR = -1;
    private int SS = -1;
    private int ST = -1;
    private int SU = -1;
    private int SV = -1;
    private Layout.Alignment SW;
    private Layout.Alignment SX;
    private int SY = -1;
    private b SZ;
    private float Ta = Float.MAX_VALUE;

    /* renamed from: do  reason: not valid java name */
    private String f7do;
    private int italic = -1;

    public g S(boolean z) {
        this.SQ = z ? 1 : 0;
        return this;
    }

    public g T(boolean z) {
        this.SR = z ? 1 : 0;
        return this;
    }

    public g U(boolean z) {
        this.SS = z ? 1 : 0;
        return this;
    }

    public g V(boolean z) {
        this.italic = z ? 1 : 0;
        return this;
    }

    public g W(boolean z) {
        this.SY = z ? 1 : 0;
        return this;
    }

    public g a(b bVar) {
        this.SZ = bVar;
        return this;
    }

    public g au(String str) {
        this.SK = str;
        return this;
    }

    public g av(String str) {
        this.f7do = str;
        return this;
    }

    public g c(Layout.Alignment alignment) {
        this.SW = alignment;
        return this;
    }

    public g d(Layout.Alignment alignment) {
        this.SX = alignment;
        return this;
    }

    public g eD(int i) {
        this.SL = i;
        this.SM = true;
        return this;
    }

    public g eE(int i) {
        this.Qc = i;
        this.SN = true;
        return this;
    }

    public g eF(int i) {
        this.SU = i;
        return this;
    }

    public g eG(int i) {
        this.SV = i;
        return this;
    }

    public g eH(int i) {
        this.ST = i;
        return this;
    }

    public int mH() {
        int i = this.SS;
        if (i == -1 && this.italic == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = i == 1 ? 1 : 0;
        if (this.italic == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    public boolean mI() {
        return this.SQ == 1;
    }

    public boolean mJ() {
        return this.SR == 1;
    }

    public String mK() {
        return this.SK;
    }

    public boolean mM() {
        return this.SM;
    }

    public boolean mO() {
        return this.SN;
    }

    public float mP() {
        return this.Ta;
    }

    public String mQ() {
        return this.f7do;
    }

    public int mR() {
        return this.SU;
    }

    public int mS() {
        return this.SV;
    }

    public Layout.Alignment mT() {
        return this.SW;
    }

    public Layout.Alignment mU() {
        return this.SX;
    }

    public boolean mV() {
        return this.SY == 1;
    }

    public b mW() {
        return this.SZ;
    }

    public int mX() {
        return this.ST;
    }

    public float mY() {
        return this.RE;
    }

    public g s(float f) {
        this.Ta = f;
        return this;
    }

    public g t(float f) {
        this.RE = f;
        return this;
    }

    public int mL() {
        if (this.SM) {
            return this.SL;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public int mN() {
        if (this.SN) {
            return this.Qc;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public g b(g gVar) {
        return a(gVar, true);
    }

    private g a(g gVar, boolean z) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.SM && gVar.SM) {
                eD(gVar.SL);
            }
            if (this.SS == -1) {
                this.SS = gVar.SS;
            }
            if (this.italic == -1) {
                this.italic = gVar.italic;
            }
            if (this.SK == null && (str = gVar.SK) != null) {
                this.SK = str;
            }
            if (this.SQ == -1) {
                this.SQ = gVar.SQ;
            }
            if (this.SR == -1) {
                this.SR = gVar.SR;
            }
            if (this.SV == -1) {
                this.SV = gVar.SV;
            }
            if (this.SW == null && (alignment2 = gVar.SW) != null) {
                this.SW = alignment2;
            }
            if (this.SX == null && (alignment = gVar.SX) != null) {
                this.SX = alignment;
            }
            if (this.SY == -1) {
                this.SY = gVar.SY;
            }
            if (this.ST == -1) {
                this.ST = gVar.ST;
                this.RE = gVar.RE;
            }
            if (this.SZ == null) {
                this.SZ = gVar.SZ;
            }
            if (this.Ta == Float.MAX_VALUE) {
                this.Ta = gVar.Ta;
            }
            if (z && !this.SN && gVar.SN) {
                eE(gVar.Qc);
            }
            if (z && this.SU == -1 && (i = gVar.SU) != -1) {
                this.SU = i;
            }
        }
        return this;
    }
}
