package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import gateway.v1.DeveloperConsentOptionKt;
import gateway.v1.DeveloperConsentOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"developerConsentOption", "Lgateway/v1/DeveloperConsentOuterClass$DeveloperConsentOption;", "block", "Lkotlin/Function1;", "Lgateway/v1/DeveloperConsentOptionKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializedeveloperConsentOption", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DeveloperConsentOptionKt.kt */
public final class DeveloperConsentOptionKtKt {
    /* renamed from: -initializedeveloperConsentOption  reason: not valid java name */
    public static final DeveloperConsentOuterClass.DeveloperConsentOption m101initializedeveloperConsentOption(Function1<? super DeveloperConsentOptionKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        DeveloperConsentOptionKt.Dsl.Companion companion = DeveloperConsentOptionKt.Dsl.Companion;
        DeveloperConsentOuterClass.DeveloperConsentOption.Builder newBuilder = DeveloperConsentOuterClass.DeveloperConsentOption.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DeveloperConsentOptionKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final DeveloperConsentOuterClass.DeveloperConsentOption copy(DeveloperConsentOuterClass.DeveloperConsentOption developerConsentOption, Function1<? super DeveloperConsentOptionKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(developerConsentOption, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        DeveloperConsentOptionKt.Dsl.Companion companion = DeveloperConsentOptionKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = developerConsentOption.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        DeveloperConsentOptionKt.Dsl _create = companion._create((DeveloperConsentOuterClass.DeveloperConsentOption.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }
}
