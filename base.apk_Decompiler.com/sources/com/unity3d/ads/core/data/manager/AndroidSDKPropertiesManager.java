package com.unity3d.ads.core.data.manager;

import com.unity3d.services.core.properties.SdkProperties;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/unity3d/ads/core/data/manager/AndroidSDKPropertiesManager;", "Lcom/unity3d/ads/core/data/manager/SDKPropertiesManager;", "()V", "setInitialized", "", "initialized", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSDKPropertiesManager.kt */
public final class AndroidSDKPropertiesManager implements SDKPropertiesManager {
    public void setInitialized(boolean z) {
        SdkProperties.setInitialized(z);
    }
}
