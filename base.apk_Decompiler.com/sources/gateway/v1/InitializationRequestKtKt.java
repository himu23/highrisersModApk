package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import gateway.v1.ClientInfoOuterClass;
import gateway.v1.InitializationRequestKt;
import gateway.v1.InitializationRequestOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\bø\u0001\u0000¢\u0006\u0002\b\u0010\u001a)\u0010\u0011\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, d2 = {"clientInfoOrNull", "Lgateway/v1/ClientInfoOuterClass$ClientInfo;", "Lgateway/v1/InitializationRequestOuterClass$InitializationRequestOrBuilder;", "getClientInfoOrNull", "(Lgateway/v1/InitializationRequestOuterClass$InitializationRequestOrBuilder;)Lgateway/v1/ClientInfoOuterClass$ClientInfo;", "deviceInfoOrNull", "Lgateway/v1/InitializationRequestOuterClass$InitializationDeviceInfo;", "getDeviceInfoOrNull", "(Lgateway/v1/InitializationRequestOuterClass$InitializationRequestOrBuilder;)Lgateway/v1/InitializationRequestOuterClass$InitializationDeviceInfo;", "initializationRequest", "Lgateway/v1/InitializationRequestOuterClass$InitializationRequest;", "block", "Lkotlin/Function1;", "Lgateway/v1/InitializationRequestKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeinitializationRequest", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: InitializationRequestKt.kt */
public final class InitializationRequestKtKt {
    /* renamed from: -initializeinitializationRequest  reason: not valid java name */
    public static final InitializationRequestOuterClass.InitializationRequest m114initializeinitializationRequest(Function1<? super InitializationRequestKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        InitializationRequestKt.Dsl.Companion companion = InitializationRequestKt.Dsl.Companion;
        InitializationRequestOuterClass.InitializationRequest.Builder newBuilder = InitializationRequestOuterClass.InitializationRequest.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        InitializationRequestKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final InitializationRequestOuterClass.InitializationRequest copy(InitializationRequestOuterClass.InitializationRequest initializationRequest, Function1<? super InitializationRequestKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(initializationRequest, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        InitializationRequestKt.Dsl.Companion companion = InitializationRequestKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = initializationRequest.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        InitializationRequestKt.Dsl _create = companion._create((InitializationRequestOuterClass.InitializationRequest.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final ClientInfoOuterClass.ClientInfo getClientInfoOrNull(InitializationRequestOuterClass.InitializationRequestOrBuilder initializationRequestOrBuilder) {
        Intrinsics.checkNotNullParameter(initializationRequestOrBuilder, "<this>");
        if (initializationRequestOrBuilder.hasClientInfo()) {
            return initializationRequestOrBuilder.getClientInfo();
        }
        return null;
    }

    public static final InitializationRequestOuterClass.InitializationDeviceInfo getDeviceInfoOrNull(InitializationRequestOuterClass.InitializationRequestOrBuilder initializationRequestOrBuilder) {
        Intrinsics.checkNotNullParameter(initializationRequestOrBuilder, "<this>");
        if (initializationRequestOrBuilder.hasDeviceInfo()) {
            return initializationRequestOrBuilder.getDeviceInfo();
        }
        return null;
    }
}
