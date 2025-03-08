package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import gateway.v1.CampaignStateOuterClass;
import gateway.v1.DynamicDeviceInfoOuterClass;
import gateway.v1.OperativeEventRequestKt;
import gateway.v1.OperativeEventRequestOuterClass;
import gateway.v1.SessionCountersOuterClass;
import gateway.v1.StaticDeviceInfoOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\bø\u0001\u0000¢\u0006\u0002\b\u0018\u001a)\u0010\u0019\u001a\u00020\u0012*\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001a"}, d2 = {"campaignStateOrNull", "Lgateway/v1/CampaignStateOuterClass$CampaignState;", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequestOrBuilder;", "getCampaignStateOrNull", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequestOrBuilder;)Lgateway/v1/CampaignStateOuterClass$CampaignState;", "dynamicDeviceInfoOrNull", "Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo;", "getDynamicDeviceInfoOrNull", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequestOrBuilder;)Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo;", "sessionCountersOrNull", "Lgateway/v1/SessionCountersOuterClass$SessionCounters;", "getSessionCountersOrNull", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequestOrBuilder;)Lgateway/v1/SessionCountersOuterClass$SessionCounters;", "staticDeviceInfoOrNull", "Lgateway/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo;", "getStaticDeviceInfoOrNull", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequestOrBuilder;)Lgateway/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo;", "operativeEventRequest", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequest;", "block", "Lkotlin/Function1;", "Lgateway/v1/OperativeEventRequestKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeoperativeEventRequest", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: OperativeEventRequestKt.kt */
public final class OperativeEventRequestKtKt {
    /* renamed from: -initializeoperativeEventRequest  reason: not valid java name */
    public static final OperativeEventRequestOuterClass.OperativeEventRequest m119initializeoperativeEventRequest(Function1<? super OperativeEventRequestKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        OperativeEventRequestKt.Dsl.Companion companion = OperativeEventRequestKt.Dsl.Companion;
        OperativeEventRequestOuterClass.OperativeEventRequest.Builder newBuilder = OperativeEventRequestOuterClass.OperativeEventRequest.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        OperativeEventRequestKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final OperativeEventRequestOuterClass.OperativeEventRequest copy(OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest, Function1<? super OperativeEventRequestKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(operativeEventRequest, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        OperativeEventRequestKt.Dsl.Companion companion = OperativeEventRequestKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = operativeEventRequest.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        OperativeEventRequestKt.Dsl _create = companion._create((OperativeEventRequestOuterClass.OperativeEventRequest.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final SessionCountersOuterClass.SessionCounters getSessionCountersOrNull(OperativeEventRequestOuterClass.OperativeEventRequestOrBuilder operativeEventRequestOrBuilder) {
        Intrinsics.checkNotNullParameter(operativeEventRequestOrBuilder, "<this>");
        if (operativeEventRequestOrBuilder.hasSessionCounters()) {
            return operativeEventRequestOrBuilder.getSessionCounters();
        }
        return null;
    }

    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfoOrNull(OperativeEventRequestOuterClass.OperativeEventRequestOrBuilder operativeEventRequestOrBuilder) {
        Intrinsics.checkNotNullParameter(operativeEventRequestOrBuilder, "<this>");
        if (operativeEventRequestOrBuilder.hasStaticDeviceInfo()) {
            return operativeEventRequestOrBuilder.getStaticDeviceInfo();
        }
        return null;
    }

    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfoOrNull(OperativeEventRequestOuterClass.OperativeEventRequestOrBuilder operativeEventRequestOrBuilder) {
        Intrinsics.checkNotNullParameter(operativeEventRequestOrBuilder, "<this>");
        if (operativeEventRequestOrBuilder.hasDynamicDeviceInfo()) {
            return operativeEventRequestOrBuilder.getDynamicDeviceInfo();
        }
        return null;
    }

    public static final CampaignStateOuterClass.CampaignState getCampaignStateOrNull(OperativeEventRequestOuterClass.OperativeEventRequestOrBuilder operativeEventRequestOrBuilder) {
        Intrinsics.checkNotNullParameter(operativeEventRequestOrBuilder, "<this>");
        if (operativeEventRequestOrBuilder.hasCampaignState()) {
            return operativeEventRequestOrBuilder.getCampaignState();
        }
        return null;
    }
}
