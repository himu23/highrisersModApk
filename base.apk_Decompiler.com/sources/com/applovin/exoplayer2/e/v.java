package com.applovin.exoplayer2.e;

import com.ironsource.m2;

public interface v {
    a ai(long j);

    long dd();

    boolean hU();

    public static class b implements v {
        private final long fH;
        private final a uS;

        public a ai(long j) {
            return this.uS;
        }

        public long dd() {
            return this.fH;
        }

        public boolean hU() {
            return false;
        }

        public b(long j) {
            this(j, 0);
        }

        public b(long j, long j2) {
            this.fH = j;
            this.uS = new a(j2 == 0 ? w.uT : new w(0, j2));
        }
    }

    public static final class a {
        public final w uQ;
        public final w uR;

        public a(w wVar) {
            this(wVar, wVar);
        }

        public a(w wVar, w wVar2) {
            this.uQ = (w) com.applovin.exoplayer2.l.a.checkNotNull(wVar);
            this.uR = (w) com.applovin.exoplayer2.l.a.checkNotNull(wVar2);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder(m2.i.d);
            sb.append(this.uQ);
            if (this.uQ.equals(this.uR)) {
                str = "";
            } else {
                str = ", " + this.uR;
            }
            sb.append(str);
            sb.append(m2.i.e);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.uQ.equals(aVar.uQ) || !this.uR.equals(aVar.uR)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.uQ.hashCode() * 31) + this.uR.hashCode();
        }
    }
}
