package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.flow.h0;

public class InneractiveAdRequest extends h0 {
    public String c;
    public b0 d;

    public InneractiveAdRequest(String str) {
        this.c = str;
    }

    @Deprecated
    public String getKeywords() {
        return InneractiveAdManager.getKeywords();
    }

    @Deprecated
    public boolean getMuteVideo() {
        return InneractiveAdManager.getMuteVideo();
    }

    public b0 getSelectedUnitConfig() {
        return this.d;
    }

    public String getSpotId() {
        return this.c;
    }

    @Deprecated
    public InneractiveUserConfig getUserParams() {
        return InneractiveAdManager.getUserParams();
    }

    @Deprecated
    public void setKeywords(String str) {
        InneractiveAdManager.setKeywords(str);
    }

    @Deprecated
    public void setMuteVideo(boolean z) {
        InneractiveAdManager.setMuteVideo(z);
    }

    public void setSelectedUnitConfig(b0 b0Var) {
        this.d = b0Var;
    }

    @Deprecated
    public void setUserParams(InneractiveUserConfig inneractiveUserConfig) {
        InneractiveAdManager.setUserParams(inneractiveUserConfig);
    }
}
