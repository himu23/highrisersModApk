package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.ironsource.m2;
import gateway.v1.AdDataRefreshResponseOuterClass;
import gateway.v1.AdPlayerConfigResponseOuterClass;
import gateway.v1.AdResponseOuterClass;
import gateway.v1.ErrorOuterClass;
import gateway.v1.InitializationResponseOuterClass;
import gateway.v1.MutableDataOuterClass;
import gateway.v1.PrivacyUpdateResponseOuterClass;
import gateway.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0002\b\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"Lgateway/v1/UniversalResponseKt;", "", "()V", "payload", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload;", "block", "Lkotlin/Function1;", "Lgateway/v1/UniversalResponseKt$PayloadKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializepayload", "Dsl", "PayloadKt", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UniversalResponseKt.kt */
public final class UniversalResponseKt {
    public static final UniversalResponseKt INSTANCE = new UniversalResponseKt();

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0001J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006)"}, d2 = {"Lgateway/v1/UniversalResponseKt$Dsl;", "", "_builder", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Builder;", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Builder;)V", "value", "Lgateway/v1/ErrorOuterClass$Error;", "error", "getError", "()Lgateway/v1/ErrorOuterClass$Error;", "setError", "(Lgateway/v1/ErrorOuterClass$Error;)V", "Lgateway/v1/MutableDataOuterClass$MutableData;", "mutableData", "getMutableData", "()Lgateway/v1/MutableDataOuterClass$MutableData;", "setMutableData", "(Lgateway/v1/MutableDataOuterClass$MutableData;)V", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload;", "payload", "getPayload", "()Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload;", "setPayload", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload;)V", "errorOrNull", "getErrorOrNull", "(Lgateway/v1/UniversalResponseKt$Dsl;)Lgateway/v1/ErrorOuterClass$Error;", "mutableDataOrNull", "getMutableDataOrNull", "(Lgateway/v1/UniversalResponseKt$Dsl;)Lgateway/v1/MutableDataOuterClass$MutableData;", "_build", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse;", "clearError", "", "clearMutableData", "clearPayload", "hasError", "", "hasMutableData", "hasPayload", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UniversalResponseKt.kt */
    public static final class Dsl {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final UniversalResponseOuterClass.UniversalResponse.Builder _builder;

        public /* synthetic */ Dsl(UniversalResponseOuterClass.UniversalResponse.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(UniversalResponseOuterClass.UniversalResponse.Builder builder) {
            this._builder = builder;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lgateway/v1/UniversalResponseKt$Dsl$Companion;", "", "()V", "_create", "Lgateway/v1/UniversalResponseKt$Dsl;", "builder", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Builder;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: UniversalResponseKt.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(UniversalResponseOuterClass.UniversalResponse.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, (DefaultConstructorMarker) null);
            }
        }

        public final /* synthetic */ UniversalResponseOuterClass.UniversalResponse _build() {
            GeneratedMessageLite build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "_builder.build()");
            return (UniversalResponseOuterClass.UniversalResponse) build;
        }

        public final UniversalResponseOuterClass.UniversalResponse.Payload getPayload() {
            UniversalResponseOuterClass.UniversalResponse.Payload payload = this._builder.getPayload();
            Intrinsics.checkNotNullExpressionValue(payload, "_builder.getPayload()");
            return payload;
        }

        public final void setPayload(UniversalResponseOuterClass.UniversalResponse.Payload payload) {
            Intrinsics.checkNotNullParameter(payload, m2.h.X);
            this._builder.setPayload(payload);
        }

        public final void clearPayload() {
            this._builder.clearPayload();
        }

        public final boolean hasPayload() {
            return this._builder.hasPayload();
        }

        public final MutableDataOuterClass.MutableData getMutableData() {
            MutableDataOuterClass.MutableData mutableData = this._builder.getMutableData();
            Intrinsics.checkNotNullExpressionValue(mutableData, "_builder.getMutableData()");
            return mutableData;
        }

        public final void setMutableData(MutableDataOuterClass.MutableData mutableData) {
            Intrinsics.checkNotNullParameter(mutableData, m2.h.X);
            this._builder.setMutableData(mutableData);
        }

        public final void clearMutableData() {
            this._builder.clearMutableData();
        }

        public final boolean hasMutableData() {
            return this._builder.hasMutableData();
        }

        public final MutableDataOuterClass.MutableData getMutableDataOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return UniversalResponseKtKt.getMutableDataOrNull(dsl._builder);
        }

        public final ErrorOuterClass.Error getError() {
            ErrorOuterClass.Error error = this._builder.getError();
            Intrinsics.checkNotNullExpressionValue(error, "_builder.getError()");
            return error;
        }

        public final void setError(ErrorOuterClass.Error error) {
            Intrinsics.checkNotNullParameter(error, m2.h.X);
            this._builder.setError(error);
        }

        public final void clearError() {
            this._builder.clearError();
        }

        public final boolean hasError() {
            return this._builder.hasError();
        }

        public final ErrorOuterClass.Error getErrorOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return UniversalResponseKtKt.getErrorOrNull(dsl._builder);
        }
    }

    private UniversalResponseKt() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lgateway/v1/UniversalResponseKt$PayloadKt;", "", "()V", "Dsl", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UniversalResponseKt.kt */
    public static final class PayloadKt {
        public static final PayloadKt INSTANCE = new PayloadKt();

        @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020)H\u0001J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\u0006\u0010/\u001a\u00020+J\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000202J\u0006\u00105\u001a\u000202J\u0006\u00106\u001a\u000202R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u001e8G@GX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8G¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u00068"}, d2 = {"Lgateway/v1/UniversalResponseKt$PayloadKt$Dsl;", "", "_builder", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload$Builder;", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload$Builder;)V", "value", "Lgateway/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponse;", "adDataRefreshResponse", "getAdDataRefreshResponse", "()Lgateway/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponse;", "setAdDataRefreshResponse", "(Lgateway/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponse;)V", "Lgateway/v1/AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse;", "adPlayerConfigResponse", "getAdPlayerConfigResponse", "()Lgateway/v1/AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse;", "setAdPlayerConfigResponse", "(Lgateway/v1/AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse;)V", "Lgateway/v1/AdResponseOuterClass$AdResponse;", "adResponse", "getAdResponse", "()Lgateway/v1/AdResponseOuterClass$AdResponse;", "setAdResponse", "(Lgateway/v1/AdResponseOuterClass$AdResponse;)V", "Lgateway/v1/InitializationResponseOuterClass$InitializationResponse;", "initializationResponse", "getInitializationResponse", "()Lgateway/v1/InitializationResponseOuterClass$InitializationResponse;", "setInitializationResponse", "(Lgateway/v1/InitializationResponseOuterClass$InitializationResponse;)V", "Lgateway/v1/PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse;", "privacyUpdateResponse", "getPrivacyUpdateResponse", "()Lgateway/v1/PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse;", "setPrivacyUpdateResponse", "(Lgateway/v1/PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse;)V", "valueCase", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload$ValueCase;", "getValueCase", "()Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload$ValueCase;", "_build", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload;", "clearAdDataRefreshResponse", "", "clearAdPlayerConfigResponse", "clearAdResponse", "clearInitializationResponse", "clearPrivacyUpdateResponse", "clearValue", "hasAdDataRefreshResponse", "", "hasAdPlayerConfigResponse", "hasAdResponse", "hasInitializationResponse", "hasPrivacyUpdateResponse", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: UniversalResponseKt.kt */
        public static final class Dsl {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final UniversalResponseOuterClass.UniversalResponse.Payload.Builder _builder;

            public /* synthetic */ Dsl(UniversalResponseOuterClass.UniversalResponse.Payload.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            private Dsl(UniversalResponseOuterClass.UniversalResponse.Payload.Builder builder) {
                this._builder = builder;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lgateway/v1/UniversalResponseKt$PayloadKt$Dsl$Companion;", "", "()V", "_create", "Lgateway/v1/UniversalResponseKt$PayloadKt$Dsl;", "builder", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload$Builder;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: UniversalResponseKt.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final /* synthetic */ Dsl _create(UniversalResponseOuterClass.UniversalResponse.Payload.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, (DefaultConstructorMarker) null);
                }
            }

            public final /* synthetic */ UniversalResponseOuterClass.UniversalResponse.Payload _build() {
                GeneratedMessageLite build = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(build, "_builder.build()");
                return (UniversalResponseOuterClass.UniversalResponse.Payload) build;
            }

            public final InitializationResponseOuterClass.InitializationResponse getInitializationResponse() {
                InitializationResponseOuterClass.InitializationResponse initializationResponse = this._builder.getInitializationResponse();
                Intrinsics.checkNotNullExpressionValue(initializationResponse, "_builder.getInitializationResponse()");
                return initializationResponse;
            }

            public final void setInitializationResponse(InitializationResponseOuterClass.InitializationResponse initializationResponse) {
                Intrinsics.checkNotNullParameter(initializationResponse, m2.h.X);
                this._builder.setInitializationResponse(initializationResponse);
            }

            public final void clearInitializationResponse() {
                this._builder.clearInitializationResponse();
            }

            public final boolean hasInitializationResponse() {
                return this._builder.hasInitializationResponse();
            }

            public final AdResponseOuterClass.AdResponse getAdResponse() {
                AdResponseOuterClass.AdResponse adResponse = this._builder.getAdResponse();
                Intrinsics.checkNotNullExpressionValue(adResponse, "_builder.getAdResponse()");
                return adResponse;
            }

            public final void setAdResponse(AdResponseOuterClass.AdResponse adResponse) {
                Intrinsics.checkNotNullParameter(adResponse, m2.h.X);
                this._builder.setAdResponse(adResponse);
            }

            public final void clearAdResponse() {
                this._builder.clearAdResponse();
            }

            public final boolean hasAdResponse() {
                return this._builder.hasAdResponse();
            }

            public final AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse getAdPlayerConfigResponse() {
                AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse adPlayerConfigResponse = this._builder.getAdPlayerConfigResponse();
                Intrinsics.checkNotNullExpressionValue(adPlayerConfigResponse, "_builder.getAdPlayerConfigResponse()");
                return adPlayerConfigResponse;
            }

            public final void setAdPlayerConfigResponse(AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse adPlayerConfigResponse) {
                Intrinsics.checkNotNullParameter(adPlayerConfigResponse, m2.h.X);
                this._builder.setAdPlayerConfigResponse(adPlayerConfigResponse);
            }

            public final void clearAdPlayerConfigResponse() {
                this._builder.clearAdPlayerConfigResponse();
            }

            public final boolean hasAdPlayerConfigResponse() {
                return this._builder.hasAdPlayerConfigResponse();
            }

            public final AdDataRefreshResponseOuterClass.AdDataRefreshResponse getAdDataRefreshResponse() {
                AdDataRefreshResponseOuterClass.AdDataRefreshResponse adDataRefreshResponse = this._builder.getAdDataRefreshResponse();
                Intrinsics.checkNotNullExpressionValue(adDataRefreshResponse, "_builder.getAdDataRefreshResponse()");
                return adDataRefreshResponse;
            }

            public final void setAdDataRefreshResponse(AdDataRefreshResponseOuterClass.AdDataRefreshResponse adDataRefreshResponse) {
                Intrinsics.checkNotNullParameter(adDataRefreshResponse, m2.h.X);
                this._builder.setAdDataRefreshResponse(adDataRefreshResponse);
            }

            public final void clearAdDataRefreshResponse() {
                this._builder.clearAdDataRefreshResponse();
            }

            public final boolean hasAdDataRefreshResponse() {
                return this._builder.hasAdDataRefreshResponse();
            }

            public final PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse getPrivacyUpdateResponse() {
                PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse privacyUpdateResponse = this._builder.getPrivacyUpdateResponse();
                Intrinsics.checkNotNullExpressionValue(privacyUpdateResponse, "_builder.getPrivacyUpdateResponse()");
                return privacyUpdateResponse;
            }

            public final void setPrivacyUpdateResponse(PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse privacyUpdateResponse) {
                Intrinsics.checkNotNullParameter(privacyUpdateResponse, m2.h.X);
                this._builder.setPrivacyUpdateResponse(privacyUpdateResponse);
            }

            public final void clearPrivacyUpdateResponse() {
                this._builder.clearPrivacyUpdateResponse();
            }

            public final boolean hasPrivacyUpdateResponse() {
                return this._builder.hasPrivacyUpdateResponse();
            }

            public final UniversalResponseOuterClass.UniversalResponse.Payload.ValueCase getValueCase() {
                UniversalResponseOuterClass.UniversalResponse.Payload.ValueCase valueCase = this._builder.getValueCase();
                Intrinsics.checkNotNullExpressionValue(valueCase, "_builder.getValueCase()");
                return valueCase;
            }

            public final void clearValue() {
                this._builder.clearValue();
            }
        }

        private PayloadKt() {
        }
    }

    /* renamed from: -initializepayload  reason: not valid java name */
    public final UniversalResponseOuterClass.UniversalResponse.Payload m136initializepayload(Function1<? super PayloadKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        PayloadKt.Dsl.Companion companion = PayloadKt.Dsl.Companion;
        UniversalResponseOuterClass.UniversalResponse.Payload.Builder newBuilder = UniversalResponseOuterClass.UniversalResponse.Payload.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        PayloadKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }
}
