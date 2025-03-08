package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Method;
import com.google.protobuf.MethodKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"method", "Lcom/google/protobuf/Method;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/MethodKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializemethod", "copy", "protobuf-kotlin-lite"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MethodKt.kt */
public final class MethodKtKt {
    /* renamed from: -initializemethod  reason: not valid java name */
    public static final Method m16initializemethod(Function1<? super MethodKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        MethodKt.Dsl.Companion companion = MethodKt.Dsl.Companion;
        Method.Builder newBuilder = Method.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        MethodKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final Method copy(Method method, Function1<? super MethodKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        MethodKt.Dsl.Companion companion = MethodKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = method.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        MethodKt.Dsl _create = companion._create((Method.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }
}
