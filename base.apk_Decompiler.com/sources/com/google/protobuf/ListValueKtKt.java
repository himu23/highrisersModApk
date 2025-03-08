package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"listValue", "Lcom/google/protobuf/ListValue;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/ListValueKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializelistValue", "copy", "protobuf-kotlin-lite"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListValueKt.kt */
public final class ListValueKtKt {
    /* renamed from: -initializelistValue  reason: not valid java name */
    public static final ListValue m15initializelistValue(Function1<? super ListValueKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ListValueKt.Dsl.Companion companion = ListValueKt.Dsl.Companion;
        ListValue.Builder newBuilder = ListValue.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        ListValueKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final ListValue copy(ListValue listValue, Function1<? super ListValueKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(listValue, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ListValueKt.Dsl.Companion companion = ListValueKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = listValue.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ListValueKt.Dsl _create = companion._create((ListValue.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }
}
