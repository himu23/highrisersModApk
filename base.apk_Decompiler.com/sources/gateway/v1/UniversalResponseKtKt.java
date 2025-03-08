package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import gateway.v1.AdDataRefreshResponseOuterClass;
import gateway.v1.AdPlayerConfigResponseOuterClass;
import gateway.v1.AdResponseOuterClass;
import gateway.v1.ErrorOuterClass;
import gateway.v1.InitializationResponseOuterClass;
import gateway.v1.MutableDataOuterClass;
import gateway.v1.PrivacyUpdateResponseOuterClass;
import gateway.v1.UniversalResponseKt;
import gateway.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\"\u001a\u00020#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(H\bø\u0001\u0000¢\u0006\u0002\b)\u001a)\u0010*\u001a\u00020#*\u00020#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(H\bø\u0001\u0000\u001a)\u0010*\u001a\u00020\u001b*\u00020\u001b2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(H\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b \u0010!\u0002\u0007\n\u0005\b20\u0001¨\u0006,"}, d2 = {"adDataRefreshResponseOrNull", "Lgateway/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponse;", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$PayloadOrBuilder;", "getAdDataRefreshResponseOrNull", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$PayloadOrBuilder;)Lgateway/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponse;", "adPlayerConfigResponseOrNull", "Lgateway/v1/AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse;", "getAdPlayerConfigResponseOrNull", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$PayloadOrBuilder;)Lgateway/v1/AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse;", "adResponseOrNull", "Lgateway/v1/AdResponseOuterClass$AdResponse;", "getAdResponseOrNull", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$PayloadOrBuilder;)Lgateway/v1/AdResponseOuterClass$AdResponse;", "errorOrNull", "Lgateway/v1/ErrorOuterClass$Error;", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponseOrBuilder;", "getErrorOrNull", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponseOrBuilder;)Lgateway/v1/ErrorOuterClass$Error;", "initializationResponseOrNull", "Lgateway/v1/InitializationResponseOuterClass$InitializationResponse;", "getInitializationResponseOrNull", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$PayloadOrBuilder;)Lgateway/v1/InitializationResponseOuterClass$InitializationResponse;", "mutableDataOrNull", "Lgateway/v1/MutableDataOuterClass$MutableData;", "getMutableDataOrNull", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponseOrBuilder;)Lgateway/v1/MutableDataOuterClass$MutableData;", "payloadOrNull", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload;", "getPayloadOrNull", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponseOrBuilder;)Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$Payload;", "privacyUpdateResponseOrNull", "Lgateway/v1/PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse;", "getPrivacyUpdateResponseOrNull", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponse$PayloadOrBuilder;)Lgateway/v1/PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse;", "universalResponse", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse;", "block", "Lkotlin/Function1;", "Lgateway/v1/UniversalResponseKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeuniversalResponse", "copy", "Lgateway/v1/UniversalResponseKt$PayloadKt$Dsl;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: UniversalResponseKt.kt */
public final class UniversalResponseKtKt {
    /* renamed from: -initializeuniversalResponse  reason: not valid java name */
    public static final UniversalResponseOuterClass.UniversalResponse m137initializeuniversalResponse(Function1<? super UniversalResponseKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        UniversalResponseKt.Dsl.Companion companion = UniversalResponseKt.Dsl.Companion;
        UniversalResponseOuterClass.UniversalResponse.Builder newBuilder = UniversalResponseOuterClass.UniversalResponse.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        UniversalResponseKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final UniversalResponseOuterClass.UniversalResponse copy(UniversalResponseOuterClass.UniversalResponse universalResponse, Function1<? super UniversalResponseKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(universalResponse, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        UniversalResponseKt.Dsl.Companion companion = UniversalResponseKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = universalResponse.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        UniversalResponseKt.Dsl _create = companion._create((UniversalResponseOuterClass.UniversalResponse.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final UniversalResponseOuterClass.UniversalResponse.Payload copy(UniversalResponseOuterClass.UniversalResponse.Payload payload, Function1<? super UniversalResponseKt.PayloadKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(payload, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        UniversalResponseKt.PayloadKt.Dsl.Companion companion = UniversalResponseKt.PayloadKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = payload.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        UniversalResponseKt.PayloadKt.Dsl _create = companion._create((UniversalResponseOuterClass.UniversalResponse.Payload.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final InitializationResponseOuterClass.InitializationResponse getInitializationResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        Intrinsics.checkNotNullParameter(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasInitializationResponse()) {
            return payloadOrBuilder.getInitializationResponse();
        }
        return null;
    }

    public static final AdResponseOuterClass.AdResponse getAdResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        Intrinsics.checkNotNullParameter(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAdResponse()) {
            return payloadOrBuilder.getAdResponse();
        }
        return null;
    }

    public static final AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse getAdPlayerConfigResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        Intrinsics.checkNotNullParameter(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAdPlayerConfigResponse()) {
            return payloadOrBuilder.getAdPlayerConfigResponse();
        }
        return null;
    }

    public static final AdDataRefreshResponseOuterClass.AdDataRefreshResponse getAdDataRefreshResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        Intrinsics.checkNotNullParameter(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAdDataRefreshResponse()) {
            return payloadOrBuilder.getAdDataRefreshResponse();
        }
        return null;
    }

    public static final PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse getPrivacyUpdateResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        Intrinsics.checkNotNullParameter(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasPrivacyUpdateResponse()) {
            return payloadOrBuilder.getPrivacyUpdateResponse();
        }
        return null;
    }

    public static final UniversalResponseOuterClass.UniversalResponse.Payload getPayloadOrNull(UniversalResponseOuterClass.UniversalResponseOrBuilder universalResponseOrBuilder) {
        Intrinsics.checkNotNullParameter(universalResponseOrBuilder, "<this>");
        if (universalResponseOrBuilder.hasPayload()) {
            return universalResponseOrBuilder.getPayload();
        }
        return null;
    }

    public static final MutableDataOuterClass.MutableData getMutableDataOrNull(UniversalResponseOuterClass.UniversalResponseOrBuilder universalResponseOrBuilder) {
        Intrinsics.checkNotNullParameter(universalResponseOrBuilder, "<this>");
        if (universalResponseOrBuilder.hasMutableData()) {
            return universalResponseOrBuilder.getMutableData();
        }
        return null;
    }

    public static final ErrorOuterClass.Error getErrorOrNull(UniversalResponseOuterClass.UniversalResponseOrBuilder universalResponseOrBuilder) {
        Intrinsics.checkNotNullParameter(universalResponseOrBuilder, "<this>");
        if (universalResponseOrBuilder.hasError()) {
            return universalResponseOrBuilder.getError();
        }
        return null;
    }
}
