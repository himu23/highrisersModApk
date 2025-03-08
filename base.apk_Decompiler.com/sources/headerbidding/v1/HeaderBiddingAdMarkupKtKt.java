package headerbidding.v1;

import com.google.protobuf.GeneratedMessageLite;
import headerbidding.v1.HeaderBiddingAdMarkupKt;
import headerbidding.v1.HeaderBiddingAdMarkupOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"headerBiddingAdMarkup", "Lheaderbidding/v1/HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup;", "block", "Lkotlin/Function1;", "Lheaderbidding/v1/HeaderBiddingAdMarkupKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeheaderBiddingAdMarkup", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: HeaderBiddingAdMarkupKt.kt */
public final class HeaderBiddingAdMarkupKtKt {
    /* renamed from: -initializeheaderBiddingAdMarkup  reason: not valid java name */
    public static final HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup m138initializeheaderBiddingAdMarkup(Function1<? super HeaderBiddingAdMarkupKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        HeaderBiddingAdMarkupKt.Dsl.Companion companion = HeaderBiddingAdMarkupKt.Dsl.Companion;
        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.Builder newBuilder = HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        HeaderBiddingAdMarkupKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup copy(HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, Function1<? super HeaderBiddingAdMarkupKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(headerBiddingAdMarkup, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HeaderBiddingAdMarkupKt.Dsl.Companion companion = HeaderBiddingAdMarkupKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = headerBiddingAdMarkup.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        HeaderBiddingAdMarkupKt.Dsl _create = companion._create((HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }
}
