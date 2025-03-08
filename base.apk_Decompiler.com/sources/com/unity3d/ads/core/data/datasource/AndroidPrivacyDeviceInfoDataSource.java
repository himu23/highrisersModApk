package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.core.device.AdvertisingId;
import com.unity3d.services.core.device.OpenAdvertisingId;
import gateway.v1.AllowedPiiOuterClass;
import gateway.v1.PiiKt;
import gateway.v1.PiiOuterClass;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidPrivacyDeviceInfoDataSource;", "Lcom/unity3d/ads/core/data/datasource/PrivacyDeviceInfoDataSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "idfaInitialized", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "fetch", "Lgateway/v1/PiiOuterClass$Pii;", "allowed", "Lgateway/v1/AllowedPiiOuterClass$AllowedPii;", "getAdvertisingTrackingId", "", "getOpenAdvertisingTrackingId", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPrivacyDeviceInfoDataSource.kt */
public final class AndroidPrivacyDeviceInfoDataSource implements PrivacyDeviceInfoDataSource {
    private final Context context;
    private final MutableStateFlow<Boolean> idfaInitialized = StateFlowKt.MutableStateFlow(false);

    public AndroidPrivacyDeviceInfoDataSource(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public PiiOuterClass.Pii fetch(AllowedPiiOuterClass.AllowedPii allowedPii) {
        Intrinsics.checkNotNullParameter(allowedPii, "allowed");
        if (!this.idfaInitialized.getValue().booleanValue()) {
            this.idfaInitialized.setValue(true);
            AdvertisingId.init(this.context);
            OpenAdvertisingId.init(this.context);
        }
        PiiKt.Dsl.Companion companion = PiiKt.Dsl.Companion;
        PiiOuterClass.Pii.Builder newBuilder = PiiOuterClass.Pii.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        PiiKt.Dsl _create = companion._create(newBuilder);
        if (allowedPii.getIdfa()) {
            String advertisingTrackingId = getAdvertisingTrackingId();
            if (advertisingTrackingId.length() > 0) {
                UUID fromString = UUID.fromString(advertisingTrackingId);
                Intrinsics.checkNotNullExpressionValue(fromString, "fromString(adId)");
                _create.setAdvertisingId(ProtobufExtensionsKt.toByteString(fromString));
            }
            String openAdvertisingTrackingId = getOpenAdvertisingTrackingId();
            if (openAdvertisingTrackingId.length() > 0) {
                UUID fromString2 = UUID.fromString(openAdvertisingTrackingId);
                Intrinsics.checkNotNullExpressionValue(fromString2, "fromString(openAdId)");
                _create.setOpenAdvertisingTrackingId(ProtobufExtensionsKt.toByteString(fromString2));
            }
        }
        return _create._build();
    }

    private final String getAdvertisingTrackingId() {
        String advertisingTrackingId = AdvertisingId.getAdvertisingTrackingId();
        return advertisingTrackingId == null ? "" : advertisingTrackingId;
    }

    private final String getOpenAdvertisingTrackingId() {
        String openAdvertisingTrackingId = OpenAdvertisingId.getOpenAdvertisingTrackingId();
        return openAdvertisingTrackingId == null ? "" : openAdvertisingTrackingId;
    }
}
