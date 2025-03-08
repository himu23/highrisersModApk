package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import gateway.v1.TimestampsKt;
import gateway.v1.TimestampsOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"timestampOrNull", "Lcom/google/protobuf/Timestamp;", "Lgateway/v1/TimestampsOuterClass$TimestampsOrBuilder;", "getTimestampOrNull", "(Lgateway/v1/TimestampsOuterClass$TimestampsOrBuilder;)Lcom/google/protobuf/Timestamp;", "timestamps", "Lgateway/v1/TimestampsOuterClass$Timestamps;", "block", "Lkotlin/Function1;", "Lgateway/v1/TimestampsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializetimestamps", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimestampsKt.kt */
public final class TimestampsKtKt {
    /* renamed from: -initializetimestamps  reason: not valid java name */
    public static final TimestampsOuterClass.Timestamps m132initializetimestamps(Function1<? super TimestampsKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        TimestampsKt.Dsl.Companion companion = TimestampsKt.Dsl.Companion;
        TimestampsOuterClass.Timestamps.Builder newBuilder = TimestampsOuterClass.Timestamps.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        TimestampsKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final TimestampsOuterClass.Timestamps copy(TimestampsOuterClass.Timestamps timestamps, Function1<? super TimestampsKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(timestamps, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        TimestampsKt.Dsl.Companion companion = TimestampsKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = timestamps.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        TimestampsKt.Dsl _create = companion._create((TimestampsOuterClass.Timestamps.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final Timestamp getTimestampOrNull(TimestampsOuterClass.TimestampsOrBuilder timestampsOrBuilder) {
        Intrinsics.checkNotNullParameter(timestampsOrBuilder, "<this>");
        if (timestampsOrBuilder.hasTimestamp()) {
            return timestampsOrBuilder.getTimestamp();
        }
        return null;
    }
}
