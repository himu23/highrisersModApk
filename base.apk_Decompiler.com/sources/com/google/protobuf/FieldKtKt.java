package com.google.protobuf;

import com.google.protobuf.Field;
import com.google.protobuf.FieldKt;
import com.google.protobuf.GeneratedMessageLite;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"field", "Lcom/google/protobuf/Field;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FieldKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializefield", "copy", "protobuf-kotlin-lite"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldKt.kt */
public final class FieldKtKt {
    /* renamed from: -initializefield  reason: not valid java name */
    public static final Field m10initializefield(Function1<? super FieldKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        FieldKt.Dsl.Companion companion = FieldKt.Dsl.Companion;
        Field.Builder newBuilder = Field.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        FieldKt.Dsl _create = companion._create(newBuilder);
        function1.invoke(_create);
        return _create._build();
    }

    public static final Field copy(Field field, Function1<? super FieldKt.Dsl, Unit> function1) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        FieldKt.Dsl.Companion companion = FieldKt.Dsl.Companion;
        GeneratedMessageLite.Builder builder = field.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FieldKt.Dsl _create = companion._create((Field.Builder) builder);
        function1.invoke(_create);
        return _create._build();
    }
}
