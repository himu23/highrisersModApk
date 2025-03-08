package gateway.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.ironsource.m2;
import gateway.v1.ClientInfoOuterClass;
import gateway.v1.InitializationRequestOuterClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lgateway/v1/InitializationRequestKt;", "", "()V", "Dsl", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InitializationRequestKt.kt */
public final class InitializationRequestKt {
    public static final InitializationRequestKt INSTANCE = new InitializationRequestKt();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001GB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00103\u001a\u000204H\u0001J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206J\u0006\u00108\u001a\u000206J\u0006\u00109\u001a\u000206J\u0006\u0010:\u001a\u000206J\u0006\u0010;\u001a\u000206J\u0006\u0010<\u001a\u000206J\u0006\u0010=\u001a\u000206J\u0006\u0010>\u001a\u000206J\u0006\u0010?\u001a\u000206J\u0006\u0010@\u001a\u00020$J\u0006\u0010A\u001a\u00020$J\u0006\u0010B\u001a\u00020$J\u0006\u0010C\u001a\u00020$J\u0006\u0010D\u001a\u00020$J\u0006\u0010E\u001a\u00020$J\u0006\u0010F\u001a\u00020$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158G@GX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR$\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8G@GX\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR$\u0010-\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R$\u00100\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011¨\u0006H"}, d2 = {"Lgateway/v1/InitializationRequestKt$Dsl;", "", "_builder", "Lgateway/v1/InitializationRequestOuterClass$InitializationRequest$Builder;", "(Lgateway/v1/InitializationRequestOuterClass$InitializationRequest$Builder;)V", "value", "", "analyticsUserId", "getAnalyticsUserId", "()Ljava/lang/String;", "setAnalyticsUserId", "(Ljava/lang/String;)V", "Lcom/google/protobuf/ByteString;", "auid", "getAuid", "()Lcom/google/protobuf/ByteString;", "setAuid", "(Lcom/google/protobuf/ByteString;)V", "cache", "getCache", "setCache", "Lgateway/v1/ClientInfoOuterClass$ClientInfo;", "clientInfo", "getClientInfo", "()Lgateway/v1/ClientInfoOuterClass$ClientInfo;", "setClientInfo", "(Lgateway/v1/ClientInfoOuterClass$ClientInfo;)V", "Lgateway/v1/InitializationRequestOuterClass$InitializationDeviceInfo;", "deviceInfo", "getDeviceInfo", "()Lgateway/v1/InitializationRequestOuterClass$InitializationDeviceInfo;", "setDeviceInfo", "(Lgateway/v1/InitializationRequestOuterClass$InitializationDeviceInfo;)V", "idfi", "getIdfi", "setIdfi", "", "isFirstInit", "getIsFirstInit", "()Z", "setIsFirstInit", "(Z)V", "legacyFlowUserConsent", "getLegacyFlowUserConsent", "setLegacyFlowUserConsent", "privacy", "getPrivacy", "setPrivacy", "sessionId", "getSessionId", "setSessionId", "_build", "Lgateway/v1/InitializationRequestOuterClass$InitializationRequest;", "clearAnalyticsUserId", "", "clearAuid", "clearCache", "clearClientInfo", "clearDeviceInfo", "clearIdfi", "clearIsFirstInit", "clearLegacyFlowUserConsent", "clearPrivacy", "clearSessionId", "hasAnalyticsUserId", "hasAuid", "hasCache", "hasClientInfo", "hasDeviceInfo", "hasLegacyFlowUserConsent", "hasPrivacy", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InitializationRequestKt.kt */
    public static final class Dsl {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final InitializationRequestOuterClass.InitializationRequest.Builder _builder;

        public /* synthetic */ Dsl(InitializationRequestOuterClass.InitializationRequest.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(InitializationRequestOuterClass.InitializationRequest.Builder builder) {
            this._builder = builder;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lgateway/v1/InitializationRequestKt$Dsl$Companion;", "", "()V", "_create", "Lgateway/v1/InitializationRequestKt$Dsl;", "builder", "Lgateway/v1/InitializationRequestOuterClass$InitializationRequest$Builder;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: InitializationRequestKt.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(InitializationRequestOuterClass.InitializationRequest.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, (DefaultConstructorMarker) null);
            }
        }

        public final /* synthetic */ InitializationRequestOuterClass.InitializationRequest _build() {
            GeneratedMessageLite build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "_builder.build()");
            return (InitializationRequestOuterClass.InitializationRequest) build;
        }

        public final ClientInfoOuterClass.ClientInfo getClientInfo() {
            ClientInfoOuterClass.ClientInfo clientInfo = this._builder.getClientInfo();
            Intrinsics.checkNotNullExpressionValue(clientInfo, "_builder.getClientInfo()");
            return clientInfo;
        }

        public final void setClientInfo(ClientInfoOuterClass.ClientInfo clientInfo) {
            Intrinsics.checkNotNullParameter(clientInfo, m2.h.X);
            this._builder.setClientInfo(clientInfo);
        }

        public final void clearClientInfo() {
            this._builder.clearClientInfo();
        }

        public final boolean hasClientInfo() {
            return this._builder.hasClientInfo();
        }

        public final ByteString getPrivacy() {
            ByteString privacy = this._builder.getPrivacy();
            Intrinsics.checkNotNullExpressionValue(privacy, "_builder.getPrivacy()");
            return privacy;
        }

        public final void setPrivacy(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, m2.h.X);
            this._builder.setPrivacy(byteString);
        }

        public final void clearPrivacy() {
            this._builder.clearPrivacy();
        }

        public final boolean hasPrivacy() {
            return this._builder.hasPrivacy();
        }

        public final String getIdfi() {
            String idfi = this._builder.getIdfi();
            Intrinsics.checkNotNullExpressionValue(idfi, "_builder.getIdfi()");
            return idfi;
        }

        public final void setIdfi(String str) {
            Intrinsics.checkNotNullParameter(str, m2.h.X);
            this._builder.setIdfi(str);
        }

        public final void clearIdfi() {
            this._builder.clearIdfi();
        }

        public final ByteString getSessionId() {
            ByteString sessionId = this._builder.getSessionId();
            Intrinsics.checkNotNullExpressionValue(sessionId, "_builder.getSessionId()");
            return sessionId;
        }

        public final void setSessionId(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, m2.h.X);
            this._builder.setSessionId(byteString);
        }

        public final void clearSessionId() {
            this._builder.clearSessionId();
        }

        public final ByteString getCache() {
            ByteString cache = this._builder.getCache();
            Intrinsics.checkNotNullExpressionValue(cache, "_builder.getCache()");
            return cache;
        }

        public final void setCache(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, m2.h.X);
            this._builder.setCache(byteString);
        }

        public final void clearCache() {
            this._builder.clearCache();
        }

        public final boolean hasCache() {
            return this._builder.hasCache();
        }

        public final String getLegacyFlowUserConsent() {
            String legacyFlowUserConsent = this._builder.getLegacyFlowUserConsent();
            Intrinsics.checkNotNullExpressionValue(legacyFlowUserConsent, "_builder.getLegacyFlowUserConsent()");
            return legacyFlowUserConsent;
        }

        public final void setLegacyFlowUserConsent(String str) {
            Intrinsics.checkNotNullParameter(str, m2.h.X);
            this._builder.setLegacyFlowUserConsent(str);
        }

        public final void clearLegacyFlowUserConsent() {
            this._builder.clearLegacyFlowUserConsent();
        }

        public final boolean hasLegacyFlowUserConsent() {
            return this._builder.hasLegacyFlowUserConsent();
        }

        public final ByteString getAuid() {
            ByteString auid = this._builder.getAuid();
            Intrinsics.checkNotNullExpressionValue(auid, "_builder.getAuid()");
            return auid;
        }

        public final void setAuid(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, m2.h.X);
            this._builder.setAuid(byteString);
        }

        public final void clearAuid() {
            this._builder.clearAuid();
        }

        public final boolean hasAuid() {
            return this._builder.hasAuid();
        }

        public final String getAnalyticsUserId() {
            String analyticsUserId = this._builder.getAnalyticsUserId();
            Intrinsics.checkNotNullExpressionValue(analyticsUserId, "_builder.getAnalyticsUserId()");
            return analyticsUserId;
        }

        public final void setAnalyticsUserId(String str) {
            Intrinsics.checkNotNullParameter(str, m2.h.X);
            this._builder.setAnalyticsUserId(str);
        }

        public final void clearAnalyticsUserId() {
            this._builder.clearAnalyticsUserId();
        }

        public final boolean hasAnalyticsUserId() {
            return this._builder.hasAnalyticsUserId();
        }

        public final InitializationRequestOuterClass.InitializationDeviceInfo getDeviceInfo() {
            InitializationRequestOuterClass.InitializationDeviceInfo deviceInfo = this._builder.getDeviceInfo();
            Intrinsics.checkNotNullExpressionValue(deviceInfo, "_builder.getDeviceInfo()");
            return deviceInfo;
        }

        public final void setDeviceInfo(InitializationRequestOuterClass.InitializationDeviceInfo initializationDeviceInfo) {
            Intrinsics.checkNotNullParameter(initializationDeviceInfo, m2.h.X);
            this._builder.setDeviceInfo(initializationDeviceInfo);
        }

        public final void clearDeviceInfo() {
            this._builder.clearDeviceInfo();
        }

        public final boolean hasDeviceInfo() {
            return this._builder.hasDeviceInfo();
        }

        public final boolean getIsFirstInit() {
            return this._builder.getIsFirstInit();
        }

        public final void setIsFirstInit(boolean z) {
            this._builder.setIsFirstInit(z);
        }

        public final void clearIsFirstInit() {
            this._builder.clearIsFirstInit();
        }
    }

    private InitializationRequestKt() {
    }
}
