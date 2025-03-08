package com.unity3d.ads.core.data.datasource;

import gateway.v1.AllowedPiiOuterClass;
import gateway.v1.PiiOuterClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/PrivacyDeviceInfoDataSource;", "", "fetch", "Lgateway/v1/PiiOuterClass$Pii;", "allowed", "Lgateway/v1/AllowedPiiOuterClass$AllowedPii;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PrivacyDeviceInfoDataSource.kt */
public interface PrivacyDeviceInfoDataSource {
    PiiOuterClass.Pii fetch(AllowedPiiOuterClass.AllowedPii allowedPii);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PrivacyDeviceInfoDataSource.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ PiiOuterClass.Pii fetch$default(PrivacyDeviceInfoDataSource privacyDeviceInfoDataSource, AllowedPiiOuterClass.AllowedPii allowedPii, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    allowedPii = AllowedPiiOuterClass.AllowedPii.getDefaultInstance();
                    Intrinsics.checkNotNullExpressionValue(allowedPii, "getDefaultInstance()");
                }
                return privacyDeviceInfoDataSource.fetch(allowedPii);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetch");
        }
    }
}
