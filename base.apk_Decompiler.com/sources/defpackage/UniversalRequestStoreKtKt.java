package defpackage;

import com.google.protobuf.GeneratedMessageLite;
import defpackage.UniversalRequestStoreKt;
import defpackage.UniversalRequestStoreOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"universalRequestStore", "LUniversalRequestStoreOuterClass$UniversalRequestStore;", "block", "Lkotlin/Function1;", "LUniversalRequestStoreKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeuniversalRequestStore", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: UniversalRequestStoreKtKt  reason: default package */
/* compiled from: UniversalRequestStoreKt.kt */
public final class UniversalRequestStoreKtKt {
    /* renamed from: -initializeuniversalRequestStore  reason: not valid java name */
    public static final UniversalRequestStoreOuterClass.UniversalRequestStore m0initializeuniversalRequestStore(Function1<? super UniversalRequestStoreKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        UniversalRequestStoreKt.Dsl.Companion companion = UniversalRequestStoreKt.Dsl.Companion;
        UniversalRequestStoreOuterClass.UniversalRequestStore.Builder newBuilder = UniversalRequestStoreOuterClass.UniversalRequestStore.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        UniversalRequestStoreKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final UniversalRequestStoreOuterClass.UniversalRequestStore copy(UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, Function1<? super UniversalRequestStoreKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(universalRequestStore, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        UniversalRequestStoreKt.Dsl.Companion companion = UniversalRequestStoreKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = universalRequestStore.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        UniversalRequestStoreKt.Dsl _create = companion._create((UniversalRequestStoreOuterClass.UniversalRequestStore.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }
}
