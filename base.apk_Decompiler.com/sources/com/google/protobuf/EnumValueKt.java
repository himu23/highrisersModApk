package com.google.protobuf;

import com.google.protobuf.EnumValue;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.ironsource.m2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/EnumValueKt;", "", "()V", "Dsl", "protobuf-kotlin-lite"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnumValueKt.kt */
public final class EnumValueKt {
    public static final EnumValueKt INSTANCE = new EnumValueKt();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ%\u0010\u001d\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0005\u001a\u00020\u0014H\u0007¢\u0006\u0002\b\u001eJ+\u0010\u001f\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140!H\u0007¢\u0006\u0002\b\"J\u001d\u0010#\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007¢\u0006\u0002\b$J&\u0010%\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0005\u001a\u00020\u0014H\n¢\u0006\u0002\b&J,\u0010%\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140!H\n¢\u0006\u0002\b'J.\u0010(\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010)\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0014H\u0002¢\u0006\u0002\b*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lcom/google/protobuf/EnumValueKt$Dsl;", "", "_builder", "Lcom/google/protobuf/EnumValue$Builder;", "(Lcom/google/protobuf/EnumValue$Builder;)V", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "number", "getNumber", "()I", "setNumber", "(I)V", "options", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/Option;", "Lcom/google/protobuf/EnumValueKt$Dsl$OptionsProxy;", "getOptions", "()Lcom/google/protobuf/kotlin/DslList;", "_build", "Lcom/google/protobuf/EnumValue;", "clearName", "", "clearNumber", "add", "addOptions", "addAll", "values", "", "addAllOptions", "clear", "clearOptions", "plusAssign", "plusAssignOptions", "plusAssignAllOptions", "set", "index", "setOptions", "Companion", "OptionsProxy", "protobuf-kotlin-lite"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EnumValueKt.kt */
    public static final class Dsl {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final EnumValue.Builder _builder;

        public /* synthetic */ Dsl(EnumValue.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(EnumValue.Builder builder) {
            this._builder = builder;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/EnumValueKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/EnumValueKt$Dsl;", "builder", "Lcom/google/protobuf/EnumValue$Builder;", "protobuf-kotlin-lite"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EnumValueKt.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(EnumValue.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, (DefaultConstructorMarker) null);
            }
        }

        public final /* synthetic */ EnumValue _build() {
            GeneratedMessageLite build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "_builder.build()");
            return (EnumValue) build;
        }

        public final String getName() {
            String name = this._builder.getName();
            Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
            return name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, m2.h.X);
            this._builder.setName(str);
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final int getNumber() {
            return this._builder.getNumber();
        }

        public final void setNumber(int i) {
            this._builder.setNumber(i);
        }

        public final void clearNumber() {
            this._builder.clearNumber();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumValueKt$Dsl$OptionsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "protobuf-kotlin-lite"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EnumValueKt.kt */
        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public final /* synthetic */ DslList getOptions() {
            List<Option> optionsList = this._builder.getOptionsList();
            Intrinsics.checkNotNullExpressionValue(optionsList, "_builder.getOptionsList()");
            return new DslList(optionsList);
        }

        public final /* synthetic */ void addOptions(DslList dslList, Option option) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(option, m2.h.X);
            this._builder.addOptions(option);
        }

        public final /* synthetic */ void plusAssignOptions(DslList<Option, OptionsProxy> dslList, Option option) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(option, m2.h.X);
            addOptions(dslList, option);
        }

        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable iterable) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(iterable, "values");
            this._builder.addAllOptions(iterable);
        }

        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> iterable) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(iterable, "values");
            addAllOptions(dslList, iterable);
        }

        public final /* synthetic */ void setOptions(DslList dslList, int i, Option option) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(option, m2.h.X);
            this._builder.setOptions(i, option);
        }

        public final /* synthetic */ void clearOptions(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearOptions();
        }
    }

    private EnumValueKt() {
    }
}
