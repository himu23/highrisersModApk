package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import gateway.v1.TestDataKt;
import gateway.v1.TestDataOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"testData", "Lgateway/v1/TestDataOuterClass$TestData;", "block", "Lkotlin/Function1;", "Lgateway/v1/TestDataKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializetestData", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TestDataKt.kt */
public final class TestDataKtKt {
    /* renamed from: -initializetestData  reason: not valid java name */
    public static final TestDataOuterClass.TestData m131initializetestData(Function1<? super TestDataKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        TestDataKt.Dsl.Companion companion = TestDataKt.Dsl.Companion;
        TestDataOuterClass.TestData.Builder newBuilder = TestDataOuterClass.TestData.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        TestDataKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final TestDataOuterClass.TestData copy(TestDataOuterClass.TestData testData, Function1<? super TestDataKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(testData, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        TestDataKt.Dsl.Companion companion = TestDataKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = testData.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        TestDataKt.Dsl _create = companion._create((TestDataOuterClass.TestData.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }
}
