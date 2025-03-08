package com.applovin.impl.mediation;

import com.applovin.impl.mediation.b.a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import java.util.List;

public class MaxAdWaterfallInfoImpl implements MaxAdWaterfallInfo {
    private final a akW;
    private final String akX;
    private final List<MaxNetworkResponseInfo> akY;
    private final long akZ;
    private final String name;

    public long getLatencyMillis() {
        return this.akZ;
    }

    public MaxAd getLoadedAd() {
        return this.akW;
    }

    public String getName() {
        return this.name;
    }

    public List<MaxNetworkResponseInfo> getNetworkResponses() {
        return this.akY;
    }

    public String getTestName() {
        return this.akX;
    }

    public MaxAdWaterfallInfoImpl(a aVar, long j, List<MaxNetworkResponseInfo> list) {
        this(aVar, aVar.xH(), aVar.xI(), j, list);
    }

    public MaxAdWaterfallInfoImpl(a aVar, String str, String str2, long j, List<MaxNetworkResponseInfo> list) {
        this.akW = aVar;
        this.name = str;
        this.akX = str2;
        this.akY = list;
        this.akZ = j;
    }

    public String toString() {
        return "MaxAdWaterfallInfo{name=" + this.name + ", testName=" + this.akX + ", networkResponses=" + this.akY + ", latencyMillis=" + this.akZ + '}';
    }
}
