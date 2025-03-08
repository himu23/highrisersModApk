package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bHBø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidAdPlayerContext;", "", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "(Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;)V", "invoke", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidAdPlayerContext.kt */
public final class GetAndroidAdPlayerContext {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_GAME_ID = "gameId";
    private final DeviceInfoRepository deviceInfoRepository;
    private final SessionRepository sessionRepository;

    public GetAndroidAdPlayerContext(DeviceInfoRepository deviceInfoRepository2, SessionRepository sessionRepository2) {
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        this.deviceInfoRepository = deviceInfoRepository2;
        this.sessionRepository = sessionRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.unity3d.ads.core.domain.GetAndroidAdPlayerContext$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.unity3d.ads.core.domain.GetAndroidAdPlayerContext$invoke$1 r0 = (com.unity3d.ads.core.domain.GetAndroidAdPlayerContext$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.GetAndroidAdPlayerContext$invoke$1 r0 = new com.unity3d.ads.core.domain.GetAndroidAdPlayerContext$invoke$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidAdPlayerContext r0 = (com.unity3d.ads.core.domain.GetAndroidAdPlayerContext) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r7 = r6.deviceInfoRepository
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.staticDeviceInfo(r0)
            if (r7 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r0 = r6
        L_0x0047:
            gateway.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r7 = (gateway.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo) r7
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r1 = r0.deviceInfoRepository
            gateway.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo r1 = r1.getDynamicDeviceInfo()
            r2 = 10
            kotlin.Pair[] r2 = new kotlin.Pair[r2]
            java.lang.String r4 = "bundleId"
            java.lang.String r5 = r7.getBundleId()
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            r5 = 0
            r2[r5] = r4
            java.lang.String r4 = "bundleVersion"
            java.lang.String r5 = r7.getBundleVersion()
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            r2[r3] = r4
            java.lang.String r3 = "webviewHash"
            java.lang.String r4 = "unknown"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r4 = 2
            r2[r4] = r3
            java.lang.String r3 = "sdkVersion"
            java.lang.String r4 = com.unity3d.services.core.properties.SdkProperties.getVersionName()
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r4 = 3
            r2[r4] = r3
            java.lang.String r3 = "osVersion"
            java.lang.String r4 = r7.getOsVersion()
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r4 = 4
            r2[r4] = r3
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "systemLanguage"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r4, r3)
            r4 = 5
            r2[r4] = r3
            java.lang.String r3 = "deviceModel"
            java.lang.String r7 = r7.getDeviceModel()
            kotlin.Pair r7 = kotlin.TuplesKt.to(r3, r7)
            r3 = 6
            r2[r3] = r7
            boolean r7 = r1.getLimitedTracking()
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            java.lang.String r3 = "limitAdTracking"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r3, r7)
            r3 = 7
            r2[r3] = r7
            gateway.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android r7 = r1.getAndroid()
            double r3 = r7.getMaxVolume()
            java.lang.Double r7 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r3)
            java.lang.String r1 = "maxVolume"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r1, r7)
            r1 = 8
            r2[r1] = r7
            com.unity3d.ads.core.data.repository.SessionRepository r7 = r0.sessionRepository
            java.lang.String r7 = r7.getGameId()
            java.lang.String r0 = "gameId"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r0, r7)
            r0 = 9
            r2[r0] = r7
            java.util.Map r7 = kotlin.collections.MapsKt.mapOf(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidAdPlayerContext.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidAdPlayerContext$Companion;", "", "()V", "KEY_GAME_ID", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: GetAndroidAdPlayerContext.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
