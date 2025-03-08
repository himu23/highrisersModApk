package com.applovin.impl.sdk.array;

import com.applovin.array.apphub.aidl.IAppHubService;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;

public class ArrayDataCollector {
    private static final String TAG = "ArrayService";
    private final x logger;
    private final n sdk;

    public ArrayDataCollector(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
    }

    public long collectAppHubVersionCode(IAppHubService iAppHubService) {
        try {
            return iAppHubService.getAppHubVersionCode();
        } catch (Throwable th) {
            if (!x.Fn()) {
                return -1;
            }
            this.logger.c(TAG, "Failed to collect version code", th);
            return -1;
        }
    }

    public Boolean collectDirectDownloadEnabled(IAppHubService iAppHubService) {
        try {
            return Boolean.valueOf(iAppHubService.getEnabledFeatures().getBoolean("DIRECT_DOWNLOAD"));
        } catch (Throwable th) {
            if (!x.Fn()) {
                return null;
            }
            this.logger.c(TAG, "Failed to collect enabled features", th);
            return null;
        }
    }

    public String collectRandomUserToken(IAppHubService iAppHubService) {
        try {
            return iAppHubService.getRandomUserToken();
        } catch (Throwable th) {
            if (!x.Fn()) {
                return null;
            }
            this.logger.c(TAG, "Failed to collect random user token", th);
            return null;
        }
    }
}
