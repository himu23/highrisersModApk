package com.applovin.impl.mediation.debugger.b.b;

public class b {
    private final String aoL;
    private final String aoM;
    private final String aoN;
    private final String aoO;
    private final String aoP;
    private final int aoQ;
    private final boolean aoR;

    public String getPublisherId() {
        return this.aoM;
    }

    public String vd() {
        return this.aoL;
    }

    public String ve() {
        return this.aoN;
    }

    public String vf() {
        return this.aoO;
    }

    public String vg() {
        return this.aoP;
    }

    public int vh() {
        return this.aoQ;
    }

    public boolean vi() {
        return this.aoR;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.canEqual(this)) {
            return false;
        }
        String vd = vd();
        String vd2 = bVar.vd();
        if (vd != null ? !vd.equals(vd2) : vd2 != null) {
            return false;
        }
        String publisherId = getPublisherId();
        String publisherId2 = bVar.getPublisherId();
        if (publisherId != null ? !publisherId.equals(publisherId2) : publisherId2 != null) {
            return false;
        }
        String ve = ve();
        String ve2 = bVar.ve();
        if (ve != null ? !ve.equals(ve2) : ve2 != null) {
            return false;
        }
        String vf = vf();
        String vf2 = bVar.vf();
        return vf != null ? vf.equals(vf2) : vf2 == null;
    }

    public int hashCode() {
        String vd = vd();
        int i = 43;
        int hashCode = vd == null ? 43 : vd.hashCode();
        String publisherId = getPublisherId();
        int hashCode2 = ((hashCode + 59) * 59) + (publisherId == null ? 43 : publisherId.hashCode());
        String ve = ve();
        int hashCode3 = (hashCode2 * 59) + (ve == null ? 43 : ve.hashCode());
        String vf = vf();
        int i2 = hashCode3 * 59;
        if (vf != null) {
            i = vf.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "AppAdsTxtEntry(domainName=" + vd() + ", publisherId=" + getPublisherId() + ", relationship=" + ve() + ", certificateAuthorityId=" + vf() + ", rawValue=" + vg() + ", rowNumber=" + vh() + ", valid=" + vi() + ")";
    }

    public b(String str, int i) {
        this.aoP = str;
        this.aoQ = i;
        String[] split = str.split(",");
        boolean z = split.length == 3 || split.length == 4;
        this.aoR = z;
        String str2 = "";
        if (z) {
            this.aoL = bI(split[0]);
            this.aoM = bI(split[1]);
            this.aoN = bI(split[2]);
            this.aoO = split.length == 4 ? bI(split[3]) : str2;
            return;
        }
        this.aoL = str2;
        this.aoM = str2;
        this.aoN = str2;
        this.aoO = str2;
    }

    public b(String str) {
        this(str, -1);
    }

    public boolean vc() {
        return this.aoL.equals("applovin.com");
    }

    private String bI(String str) {
        return str.replace(173, ' ').trim();
    }
}
