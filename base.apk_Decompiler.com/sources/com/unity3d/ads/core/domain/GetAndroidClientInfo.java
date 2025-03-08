package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.MediationRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import gateway.v1.ClientInfoKt;
import gateway.v1.ClientInfoOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidClientInfo;", "Lcom/unity3d/ads/core/domain/GetClientInfo;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "mediationRepository", "Lcom/unity3d/ads/core/data/repository/MediationRepository;", "(Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/MediationRepository;)V", "invoke", "Lgateway/v1/ClientInfoOuterClass$ClientInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidClientInfo.kt */
public final class GetAndroidClientInfo implements GetClientInfo {
    private final MediationRepository mediationRepository;
    private final SessionRepository sessionRepository;

    public GetAndroidClientInfo(SessionRepository sessionRepository2, MediationRepository mediationRepository2) {
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(mediationRepository2, "mediationRepository");
        this.sessionRepository = sessionRepository2;
        this.mediationRepository = mediationRepository2;
    }

    public Object invoke(Continuation<? super ClientInfoOuterClass.ClientInfo> continuation) {
        ClientInfoKt.Dsl.Companion companion = ClientInfoKt.Dsl.Companion;
        ClientInfoOuterClass.ClientInfo.Builder newBuilder = ClientInfoOuterClass.ClientInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        ClientInfoKt.Dsl _create = companion._create(newBuilder);
        _create.setSdkVersion(4920);
        _create.setSdkVersionName("4.9.2");
        _create.setGameId(this.sessionRepository.getGameId());
        _create.setTest(this.sessionRepository.isTestModeEnabled());
        _create.setPlatform(ClientInfoOuterClass.Platform.PLATFORM_ANDROID);
        _create.setMediationProvider(this.mediationRepository.getMediationProvider().invoke());
        String name = this.mediationRepository.getName();
        if (name != null && _create.getMediationProvider() == ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_CUSTOM) {
            _create.setCustomMediationName(name);
        }
        String version = this.mediationRepository.getVersion();
        if (version != null) {
            _create.setMediationVersion(version);
        }
        return _create._build();
    }
}
