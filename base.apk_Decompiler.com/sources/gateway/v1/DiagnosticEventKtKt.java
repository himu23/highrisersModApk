package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import gateway.v1.DiagnosticEventKt;
import gateway.v1.DiagnosticEventRequestOuterClass;
import gateway.v1.TimestampsOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"timestampsOrNull", "Lgateway/v1/TimestampsOuterClass$Timestamps;", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEventOrBuilder;", "getTimestampsOrNull", "(Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEventOrBuilder;)Lgateway/v1/TimestampsOuterClass$Timestamps;", "diagnosticEvent", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent;", "block", "Lkotlin/Function1;", "Lgateway/v1/DiagnosticEventKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializediagnosticEvent", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DiagnosticEventKt.kt */
public final class DiagnosticEventKtKt {
    /* renamed from: -initializediagnosticEvent  reason: not valid java name */
    public static final DiagnosticEventRequestOuterClass.DiagnosticEvent m102initializediagnosticEvent(Function1<? super DiagnosticEventKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        DiagnosticEventKt.Dsl.Companion companion = DiagnosticEventKt.Dsl.Companion;
        DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder newBuilder = DiagnosticEventRequestOuterClass.DiagnosticEvent.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DiagnosticEventKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final DiagnosticEventRequestOuterClass.DiagnosticEvent copy(DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent, Function1<? super DiagnosticEventKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(diagnosticEvent, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        DiagnosticEventKt.Dsl.Companion companion = DiagnosticEventKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = diagnosticEvent.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        DiagnosticEventKt.Dsl _create = companion._create((DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final TimestampsOuterClass.Timestamps getTimestampsOrNull(DiagnosticEventRequestOuterClass.DiagnosticEventOrBuilder diagnosticEventOrBuilder) {
        Intrinsics.checkNotNullParameter(diagnosticEventOrBuilder, "<this>");
        if (diagnosticEventOrBuilder.hasTimestamps()) {
            return diagnosticEventOrBuilder.getTimestamps();
        }
        return null;
    }
}
