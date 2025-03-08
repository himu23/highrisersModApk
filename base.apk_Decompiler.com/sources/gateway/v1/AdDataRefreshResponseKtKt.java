package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import gateway.v1.AdDataRefreshResponseKt;
import gateway.v1.AdDataRefreshResponseOuterClass;
import gateway.v1.ErrorOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"errorOrNull", "Lgateway/v1/ErrorOuterClass$Error;", "Lgateway/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponseOrBuilder;", "getErrorOrNull", "(Lgateway/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponseOrBuilder;)Lgateway/v1/ErrorOuterClass$Error;", "adDataRefreshResponse", "Lgateway/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponse;", "block", "Lkotlin/Function1;", "Lgateway/v1/AdDataRefreshResponseKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeadDataRefreshResponse", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdDataRefreshResponseKt.kt */
public final class AdDataRefreshResponseKtKt {
    /* renamed from: -initializeadDataRefreshResponse  reason: not valid java name */
    public static final AdDataRefreshResponseOuterClass.AdDataRefreshResponse m90initializeadDataRefreshResponse(Function1<? super AdDataRefreshResponseKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        AdDataRefreshResponseKt.Dsl.Companion companion = AdDataRefreshResponseKt.Dsl.Companion;
        AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder newBuilder = AdDataRefreshResponseOuterClass.AdDataRefreshResponse.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        AdDataRefreshResponseKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final AdDataRefreshResponseOuterClass.AdDataRefreshResponse copy(AdDataRefreshResponseOuterClass.AdDataRefreshResponse adDataRefreshResponse, Function1<? super AdDataRefreshResponseKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(adDataRefreshResponse, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        AdDataRefreshResponseKt.Dsl.Companion companion = AdDataRefreshResponseKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = adDataRefreshResponse.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AdDataRefreshResponseKt.Dsl _create = companion._create((AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final ErrorOuterClass.Error getErrorOrNull(AdDataRefreshResponseOuterClass.AdDataRefreshResponseOrBuilder adDataRefreshResponseOrBuilder) {
        Intrinsics.checkNotNullParameter(adDataRefreshResponseOrBuilder, "<this>");
        if (adDataRefreshResponseOrBuilder.hasError()) {
            return adDataRefreshResponseOrBuilder.getError();
        }
        return null;
    }
}
