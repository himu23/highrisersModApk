package com.applovin.exoplayer2.e.h;

import androidx.work.WorkRequest;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.k;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.w;
import com.applovin.exoplayer2.l.ai;
import java.io.EOFException;
import java.io.IOException;

final class a implements f {
    private long BA;
    private long BB;
    private final e Br;
    /* access modifiers changed from: private */
    public final long Bs;
    /* access modifiers changed from: private */
    public final long Bt;
    /* access modifiers changed from: private */
    public final h Bu;
    /* access modifiers changed from: private */
    public long Bv;
    private long Bw;
    private long Bx;
    private long By;
    private long Bz;
    private int Z;

    public a(h hVar, long j, long j2, long j3, long j4, boolean z) {
        com.applovin.exoplayer2.l.a.checkArgument(j >= 0 && j2 > j);
        this.Bu = hVar;
        this.Bs = j;
        this.Bt = j2;
        if (j3 == j2 - j || z) {
            this.Bv = j4;
            this.Z = 4;
        } else {
            this.Z = 0;
        }
        this.Br = new e();
    }

    public long N(i iVar) throws IOException {
        int i = this.Z;
        if (i == 0) {
            long ie = iVar.ie();
            this.Bw = ie;
            this.Z = 1;
            long j = this.Bt - 65307;
            if (j > ie) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long O = O(iVar);
                if (O != -1) {
                    return O;
                }
                this.Z = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1;
                }
                throw new IllegalStateException();
            }
            P(iVar);
            this.Z = 4;
            return -(this.BA + 2);
        }
        this.Bv = Q(iVar);
        this.Z = 4;
        return this.Bw;
    }

    /* renamed from: iW */
    public C0043a iX() {
        if (this.Bv != 0) {
            return new C0043a();
        }
        return null;
    }

    public void aC(long j) {
        this.Bx = ai.b(j, 0, this.Bv - 1);
        this.Z = 2;
        this.By = this.Bs;
        this.Bz = this.Bt;
        this.BA = 0;
        this.BB = this.Bv;
    }

    private long O(i iVar) throws IOException {
        i iVar2 = iVar;
        if (this.By == this.Bz) {
            return -1;
        }
        long ie = iVar.ie();
        if (!this.Br.c(iVar2, this.Bz)) {
            long j = this.By;
            if (j != ie) {
                return j;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.Br.f(iVar2, false);
        iVar.ic();
        long j2 = this.Bx - this.Br.BN;
        int i = this.Br.BT + this.Br.BU;
        if (0 <= j2 && j2 < 72000) {
            return -1;
        }
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            this.Bz = ie;
            this.BB = this.Br.BN;
        } else {
            this.By = iVar.ie() + ((long) i);
            this.BA = this.Br.BN;
        }
        long j3 = this.Bz;
        long j4 = this.By;
        if (j3 - j4 < 100000) {
            this.Bz = j4;
            return j4;
        }
        long j5 = ((long) i) * (i2 <= 0 ? 2 : 1);
        long j6 = this.Bz;
        long j7 = this.By;
        return ai.b((iVar.ie() - j5) + ((j2 * (j6 - j7)) / (this.BB - this.BA)), j7, j6 - 1);
    }

    private void P(i iVar) throws IOException {
        while (true) {
            this.Br.T(iVar);
            this.Br.f(iVar, false);
            if (this.Br.BN > this.Bx) {
                iVar.ic();
                return;
            }
            iVar.bH(this.Br.BT + this.Br.BU);
            this.By = iVar.ie();
            this.BA = this.Br.BN;
        }
    }

    /* access modifiers changed from: package-private */
    public long Q(i iVar) throws IOException {
        this.Br.Y();
        if (this.Br.T(iVar)) {
            this.Br.f(iVar, false);
            iVar.bH(this.Br.BT + this.Br.BU);
            long j = this.Br.BN;
            while ((this.Br.bs & 4) != 4 && this.Br.T(iVar) && iVar.ie() < this.Bt && this.Br.f(iVar, true) && k.a(iVar, this.Br.BT + this.Br.BU)) {
                j = this.Br.BN;
            }
            return j;
        }
        throw new EOFException();
    }

    /* renamed from: com.applovin.exoplayer2.e.h.a$a  reason: collision with other inner class name */
    private final class C0043a implements v {
        public boolean hU() {
            return true;
        }

        private C0043a() {
        }

        public v.a ai(long j) {
            return new v.a(new w(j, ai.b((a.this.Bs + ((a.this.Bu.aF(j) * (a.this.Bt - a.this.Bs)) / a.this.Bv)) - WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, a.this.Bs, a.this.Bt - 1)));
        }

        public long dd() {
            return a.this.Bu.aE(a.this.Bv);
        }
    }
}
