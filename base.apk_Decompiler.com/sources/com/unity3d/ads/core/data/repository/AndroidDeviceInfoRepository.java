package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.VolumeSettingsChange;
import gateway.v1.AllowedPiiOuterClass;
import gateway.v1.DynamicDeviceInfoOuterClass;
import gateway.v1.PiiOuterClass;
import gateway.v1.StaticDeviceInfoOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u00103\u001a\u000204H@ø\u0001\u0000¢\u0006\u0002\u00105J\u0011\u00106\u001a\u000204H@ø\u0001\u0000¢\u0006\u0002\u00105J\u0011\u00107\u001a\u000208H@ø\u0001\u0000¢\u0006\u0002\u00105R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u0014\u0010 \u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0014\u0010\"\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0011R\u0014\u0010$\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0011R\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lcom/unity3d/ads/core/data/repository/AndroidDeviceInfoRepository;", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "staticDeviceInfoDataSource", "Lcom/unity3d/ads/core/data/datasource/StaticDeviceInfoDataSource;", "dynamicDeviceInfoDataSource", "Lcom/unity3d/ads/core/data/datasource/DynamicDeviceInfoDataSource;", "privacyDeviceInfoDataSource", "Lcom/unity3d/ads/core/data/datasource/PrivacyDeviceInfoDataSource;", "(Lcom/unity3d/ads/core/data/datasource/StaticDeviceInfoDataSource;Lcom/unity3d/ads/core/data/datasource/DynamicDeviceInfoDataSource;Lcom/unity3d/ads/core/data/datasource/PrivacyDeviceInfoDataSource;)V", "allowedPii", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lgateway/v1/AllowedPiiOuterClass$AllowedPii;", "getAllowedPii", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "analyticsUserId", "", "getAnalyticsUserId", "()Ljava/lang/String;", "appName", "getAppName", "connectionTypeStr", "getConnectionTypeStr", "dynamicDeviceInfo", "Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo;", "getDynamicDeviceInfo", "()Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo;", "hasInternet", "", "getHasInternet", "()Z", "manufacturer", "getManufacturer", "model", "getModel", "orientation", "getOrientation", "osVersion", "getOsVersion", "piiData", "Lgateway/v1/PiiOuterClass$Pii;", "getPiiData", "()Lgateway/v1/PiiOuterClass$Pii;", "ringerMode", "", "getRingerMode", "()I", "volumeSettingsChange", "Lkotlinx/coroutines/flow/Flow;", "Lcom/unity3d/ads/core/data/datasource/VolumeSettingsChange;", "getVolumeSettingsChange", "()Lkotlinx/coroutines/flow/Flow;", "getAuid", "Lcom/google/protobuf/ByteString;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIdfi", "staticDeviceInfo", "Lgateway/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDeviceInfoRepository.kt */
public final class AndroidDeviceInfoRepository implements DeviceInfoRepository {
    private final MutableStateFlow<AllowedPiiOuterClass.AllowedPii> allowedPii;
    private final String analyticsUserId;
    private final DynamicDeviceInfoDataSource dynamicDeviceInfoDataSource;
    private final PrivacyDeviceInfoDataSource privacyDeviceInfoDataSource;
    private final StaticDeviceInfoDataSource staticDeviceInfoDataSource;
    private final Flow<VolumeSettingsChange> volumeSettingsChange;

    public MutableStateFlow<AllowedPiiOuterClass.AllowedPii> getAllowedPii() {
        return this.allowedPii;
    }

    public String getAnalyticsUserId() {
        return this.analyticsUserId;
    }

    public Flow<VolumeSettingsChange> getVolumeSettingsChange() {
        return this.volumeSettingsChange;
    }

    public AndroidDeviceInfoRepository(StaticDeviceInfoDataSource staticDeviceInfoDataSource2, DynamicDeviceInfoDataSource dynamicDeviceInfoDataSource2, PrivacyDeviceInfoDataSource privacyDeviceInfoDataSource2) {
        Intrinsics.checkNotNullParameter(staticDeviceInfoDataSource2, "staticDeviceInfoDataSource");
        Intrinsics.checkNotNullParameter(dynamicDeviceInfoDataSource2, "dynamicDeviceInfoDataSource");
        Intrinsics.checkNotNullParameter(privacyDeviceInfoDataSource2, "privacyDeviceInfoDataSource");
        this.staticDeviceInfoDataSource = staticDeviceInfoDataSource2;
        this.dynamicDeviceInfoDataSource = dynamicDeviceInfoDataSource2;
        this.privacyDeviceInfoDataSource = privacyDeviceInfoDataSource2;
        AllowedPiiOuterClass.AllowedPii defaultInstance = AllowedPiiOuterClass.AllowedPii.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance()");
        this.allowedPii = StateFlowKt.MutableStateFlow(defaultInstance);
        this.analyticsUserId = staticDeviceInfoDataSource2.getAnalyticsUserId();
        this.volumeSettingsChange = dynamicDeviceInfoDataSource2.getVolumeSettingsChange();
    }

    public Object staticDeviceInfo(Continuation<? super StaticDeviceInfoOuterClass.StaticDeviceInfo> continuation) {
        return this.staticDeviceInfoDataSource.fetch(continuation);
    }

    public DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
        return this.dynamicDeviceInfoDataSource.fetch();
    }

    public PiiOuterClass.Pii getPiiData() {
        return this.privacyDeviceInfoDataSource.fetch(getAllowedPii().getValue());
    }

    public Object getIdfi(Continuation<? super ByteString> continuation) {
        return this.staticDeviceInfoDataSource.getIdfi(continuation);
    }

    public Object getAuid(Continuation<? super ByteString> continuation) {
        return this.staticDeviceInfoDataSource.getAuid(continuation);
    }

    public int getRingerMode() {
        return this.dynamicDeviceInfoDataSource.getRingerMode();
    }

    public String getOrientation() {
        return this.dynamicDeviceInfoDataSource.getOrientation();
    }

    public String getConnectionTypeStr() {
        return this.dynamicDeviceInfoDataSource.getConnectionTypeStr();
    }

    public String getAppName() {
        return this.staticDeviceInfoDataSource.getAppName();
    }

    public String getModel() {
        return this.staticDeviceInfoDataSource.getModel();
    }

    public String getManufacturer() {
        return this.staticDeviceInfoDataSource.getManufacturer();
    }

    public String getOsVersion() {
        return this.staticDeviceInfoDataSource.getOsVersion();
    }

    public boolean getHasInternet() {
        return this.dynamicDeviceInfoDataSource.hasInternet();
    }
}
