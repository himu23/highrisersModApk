package com.applovin.exoplayer2.e.a;

import com.applovin.exoplayer2.e.d;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.k.g;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class a implements h {
    public static final l vq = new a$$ExternalSyntheticLambda0();
    private static final int[] vr = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] vs;
    private static final byte[] vt = ai.bk("#!AMR\n");
    private static final byte[] vu = ai.bk("#!AMR-WB\n");
    private static final int vv;
    private final int jF;
    private int vA;
    private boolean vB;
    private long vC;
    private int vD;
    private int vE;
    private long vF;
    private j vG;
    private x vH;
    private v vI;
    private boolean vJ;
    private final byte[] vw;
    private boolean vx;
    private long vy;
    private int vz;

    private boolean bV(int i) {
        return this.vx && (i < 10 || i > 13);
    }

    private boolean bW(int i) {
        return !this.vx && (i < 12 || i > 14);
    }

    public void release() {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        vs = iArr;
        vv = iArr[8];
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new a()};
    }

    public a() {
        this(0);
    }

    public a(int i) {
        this.jF = (i & 2) != 0 ? i | 1 : i;
        this.vw = new byte[1];
        this.vD = -1;
    }

    public boolean a(i iVar) throws IOException {
        return f(iVar);
    }

    public void a(j jVar) {
        this.vG = jVar;
        this.vH = jVar.y(0, 1);
        jVar.ig();
    }

    public int b(i iVar, u uVar) throws IOException {
        io();
        if (iVar.ie() != 0 || f(iVar)) {
            in();
            int g = g(iVar);
            d(iVar.m1771if(), g);
            return g;
        }
        throw com.applovin.exoplayer2.ai.c("Could not find AMR header.", (Throwable) null);
    }

    public void o(long j, long j2) {
        this.vy = 0;
        this.vz = 0;
        this.vA = 0;
        if (j != 0) {
            v vVar = this.vI;
            if (vVar instanceof d) {
                this.vF = ((d) vVar).al(j);
                return;
            }
        }
        this.vF = 0;
    }

    private boolean f(i iVar) throws IOException {
        byte[] bArr = vt;
        if (a(iVar, bArr)) {
            this.vx = false;
            iVar.bH(bArr.length);
            return true;
        }
        byte[] bArr2 = vu;
        if (!a(iVar, bArr2)) {
            return false;
        }
        this.vx = true;
        iVar.bH(bArr2.length);
        return true;
    }

    private static boolean a(i iVar, byte[] bArr) throws IOException {
        iVar.ic();
        byte[] bArr2 = new byte[bArr.length];
        iVar.c(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private void in() {
        if (!this.vJ) {
            this.vJ = true;
            boolean z = this.vx;
            this.vH.j(new v.a().m(z ? "audio/amr-wb" : "audio/3gpp").I(vv).N(1).O(z ? 16000 : GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY).bT());
        }
    }

    private int g(i iVar) throws IOException {
        if (this.vA == 0) {
            try {
                int h = h(iVar);
                this.vz = h;
                this.vA = h;
                if (this.vD == -1) {
                    this.vC = iVar.ie();
                    this.vD = this.vz;
                }
                if (this.vD == this.vz) {
                    this.vE++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int a = this.vH.a((g) iVar, this.vA, true);
        if (a == -1) {
            return -1;
        }
        int i = this.vA - a;
        this.vA = i;
        if (i > 0) {
            return 0;
        }
        this.vH.a(this.vF + this.vy, 1, this.vz, 0, (x.a) null);
        this.vy += 20000;
        return 0;
    }

    private int h(i iVar) throws IOException {
        iVar.ic();
        iVar.c(this.vw, 0, 1);
        byte b = this.vw[0];
        if ((b & 131) <= 0) {
            return bT((b >> 3) & 15);
        }
        throw com.applovin.exoplayer2.ai.c("Invalid padding bits for frame header " + b, (Throwable) null);
    }

    private int bT(int i) throws com.applovin.exoplayer2.ai {
        if (bU(i)) {
            return this.vx ? vs[i] : vr[i];
        }
        StringBuilder sb = new StringBuilder("Illegal AMR ");
        sb.append(this.vx ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i);
        throw com.applovin.exoplayer2.ai.c(sb.toString(), (Throwable) null);
    }

    private boolean bU(int i) {
        return i >= 0 && i <= 15 && (bV(i) || bW(i));
    }

    private void d(long j, int i) {
        int i2;
        if (!this.vB) {
            int i3 = this.jF;
            if ((i3 & 1) == 0 || j == -1 || !((i2 = this.vD) == -1 || i2 == this.vz)) {
                v.b bVar = new v.b(-9223372036854775807L);
                this.vI = bVar;
                this.vG.a(bVar);
                this.vB = true;
            } else if (this.vE >= 20 || i == -1) {
                com.applovin.exoplayer2.e.v b = b(j, (i3 & 2) != 0);
                this.vI = b;
                this.vG.a(b);
                this.vB = true;
            }
        }
    }

    private com.applovin.exoplayer2.e.v b(long j, boolean z) {
        return new d(j, this.vC, d(this.vD, 20000), this.vD, z);
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.vH);
        ai.R(this.vG);
    }

    private static int d(int i, long j) {
        return (int) ((((long) (i * 8)) * 1000000) / j);
    }
}
