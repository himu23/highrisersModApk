package com.applovin.impl.mediation.b;

public class g {
    private final h auF;
    private final String auG;
    private final String auH;
    private final String auI;
    private final String auJ;
    private final long auK;

    public interface a {
        void a(g gVar);
    }

    public String getAdapterVersion() {
        return this.auH;
    }

    public String getErrorMessage() {
        return this.auJ;
    }

    public String getSdkVersion() {
        return this.auG;
    }

    public h yH() {
        return this.auF;
    }

    public String yI() {
        return this.auI;
    }

    public long yJ() {
        return this.auK;
    }

    public static g a(h hVar, com.applovin.impl.mediation.g gVar, String str, long j) {
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (gVar != null) {
            return new g(hVar, gVar, str, (String) null, j);
        } else {
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
    }

    public static g a(h hVar, String str) {
        return b(hVar, (com.applovin.impl.mediation.g) null, str, -1);
    }

    public static g b(h hVar, com.applovin.impl.mediation.g gVar, String str, long j) {
        if (hVar != null) {
            return new g(hVar, gVar, (String) null, str, j);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    private g(h hVar, com.applovin.impl.mediation.g gVar, String str, String str2, long j) {
        this.auF = hVar;
        this.auI = str;
        this.auJ = str2;
        this.auK = j;
        if (gVar != null) {
            this.auG = gVar.getSdkVersion();
            this.auH = gVar.getAdapterVersion();
            return;
        }
        this.auG = null;
        this.auH = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.auF);
        sb.append(", mSdkVersion='");
        sb.append(this.auG);
        sb.append("', mAdapterVersion='");
        sb.append(this.auH);
        sb.append("', mSignalDataLength='");
        String str = this.auI;
        sb.append(str != null ? str.length() : 0);
        sb.append("', mErrorMessage=");
        sb.append(this.auJ);
        sb.append('}');
        return sb.toString();
    }
}
