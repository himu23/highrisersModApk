package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Mixin;
import com.google.protobuf.MixinKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"mixin", "Lcom/google/protobuf/Mixin;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/MixinKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializemixin", "copy", "protobuf-kotlin-lite"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MixinKt.kt */
public final class MixinKtKt {
    /* renamed from: -initializemixin  reason: not valid java name */
    public static final Mixin m17initializemixin(Function1<? super MixinKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        MixinKt.Dsl.Companion companion = MixinKt.Dsl.Companion;
        Mixin.Builder newBuilder = Mixin.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        MixinKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final Mixin copy(Mixin mixin, Function1<? super MixinKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(mixin, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        MixinKt.Dsl.Companion companion = MixinKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = mixin.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        MixinKt.Dsl _create = companion._create((Mixin.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }
}
