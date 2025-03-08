package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import gateway.v1.AdPlayerConfigRequestKt;
import gateway.v1.AdPlayerConfigRequestOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"adPlayerConfigRequest", "Lgateway/v1/AdPlayerConfigRequestOuterClass$AdPlayerConfigRequest;", "block", "Lkotlin/Function1;", "Lgateway/v1/AdPlayerConfigRequestKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeadPlayerConfigRequest", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdPlayerConfigRequestKt.kt */
public final class AdPlayerConfigRequestKtKt {
    /* renamed from: -initializeadPlayerConfigRequest  reason: not valid java name */
    public static final AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest m92initializeadPlayerConfigRequest(Function1<? super AdPlayerConfigRequestKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        AdPlayerConfigRequestKt.Dsl.Companion companion = AdPlayerConfigRequestKt.Dsl.Companion;
        AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder newBuilder = AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        AdPlayerConfigRequestKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest copy(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest adPlayerConfigRequest, Function1<? super AdPlayerConfigRequestKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(adPlayerConfigRequest, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        AdPlayerConfigRequestKt.Dsl.Companion companion = AdPlayerConfigRequestKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = adPlayerConfigRequest.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AdPlayerConfigRequestKt.Dsl _create = companion._create((AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }
}
