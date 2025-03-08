package com.iab.omid.library.ironsrc.adsession;

import com.fyber.inneractive.sdk.external.InneractiveMediationNameConsts;

public enum DeviceCategory {
    CTV("ctv"),
    MOBILE("mobile"),
    OTHER(InneractiveMediationNameConsts.OTHER);
    
    private final String deviceCategory;

    private DeviceCategory(String str) {
        this.deviceCategory = str;
    }

    public String toString() {
        return this.deviceCategory;
    }
}
