package com.applovin.impl.sdk.d;

public final class e {
    private long aSI;
    private long aSJ;
    private boolean aSK;
    private long aSL;
    private long aSM;
    private int aSN;
    private Throwable aSO;

    public void JS() {
        this.aSK = true;
    }

    public void JT() {
        this.aSL++;
    }

    public void JU() {
        this.aSM++;
    }

    public void bW(long j) {
        this.aSI += j;
    }

    public void bX(long j) {
        this.aSJ += j;
    }

    public void gO(int i) {
        this.aSN = i;
    }

    public void p(Throwable th) {
        this.aSO = th;
    }

    public String toString() {
        return "CacheStatsTracker{totalDownloadedBytes=" + this.aSI + ", totalCachedBytes=" + this.aSJ + ", isHTMLCachingCancelled=" + this.aSK + ", htmlResourceCacheSuccessCount=" + this.aSL + ", htmlResourceCacheFailureCount=" + this.aSM + '}';
    }
}
