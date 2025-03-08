package com.applovin.exoplayer2.e.i;

import android.util.SparseArray;
import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.y;
import java.util.Collections;
import java.util.List;

public interface ad {

    public interface c {
        ad a(int i, b bVar);

        SparseArray<ad> jn();
    }

    void a(ag agVar, j jVar, d dVar);

    void jb();

    void p(y yVar, int i) throws ai;

    public static final class b {
        public final List<a> FR;
        public final byte[] FT;
        public final String dq;
        public final int ir;

        public b(int i, String str, List<a> list, byte[] bArr) {
            List<a> list2;
            this.ir = i;
            this.dq = str;
            if (list == null) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.FR = list2;
            this.FT = bArr;
        }
    }

    public static final class a {
        public final byte[] FQ;
        public final int bs;
        public final String dq;

        public a(String str, int i, byte[] bArr) {
            this.dq = str;
            this.bs = i;
            this.FQ = bArr;
        }
    }

    public static final class d {
        private String Ct;
        private final String FU;
        private final int FV;
        private final int FW;
        private int FX;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + "/";
            } else {
                str = "";
            }
            this.FU = str;
            this.FV = i2;
            this.FW = i3;
            this.FX = Integer.MIN_VALUE;
            this.Ct = "";
        }

        public void jy() {
            int i = this.FX;
            this.FX = i == Integer.MIN_VALUE ? this.FV : i + this.FW;
            this.Ct = this.FU + this.FX;
        }

        public int jz() {
            jB();
            return this.FX;
        }

        public String jA() {
            jB();
            return this.Ct;
        }

        private void jB() {
            if (this.FX == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
