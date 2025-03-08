package gateway.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.ironsource.m2;
import gateway.v1.DiagnosticEventRequestOuterClass;
import gateway.v1.TimestampsOuterClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lgateway/v1/DiagnosticEventKt;", "", "()V", "Dsl", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DiagnosticEventKt.kt */
public final class DiagnosticEventKt {
    public static final DiagnosticEventKt INSTANCE = new DiagnosticEventKt();

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\f\b\u0007\u0018\u0000 J2\u00020\u0001:\u0003JKLB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u00020-H\u0001J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020/J\u0006\u00101\u001a\u00020/J\u0006\u00102\u001a\u00020/J\u0006\u00103\u001a\u00020/J\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u000205J\u0006\u00107\u001a\u000205J#\u00108\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u0019H\u0007¢\u0006\u0002\b9J#\u00108\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u0019H\u0007¢\u0006\u0002\b:J3\u0010;\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010<\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\fH\u0007¢\u0006\u0002\b=J3\u0010;\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u00192\u0006\u0010<\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b>J7\u0010?\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u00192\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0AH\u0007¢\u0006\u0002\bBJ7\u0010?\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u00192\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060AH\u0007¢\u0006\u0002\bCJ+\u0010D\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010<\u001a\u00020\u0006H\u0007¢\u0006\u0002\bEJ+\u0010D\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u00192\u0006\u0010<\u001a\u00020\u0006H\u0007¢\u0006\u0002\bFJ4\u0010G\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010<\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\fH\n¢\u0006\u0002\bHJ4\u0010G\u001a\u00020/*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u00192\u0006\u0010<\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\bIR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R#\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u00198G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u00198G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR$\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020 8G@GX\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020&8G@GX\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006M"}, d2 = {"Lgateway/v1/DiagnosticEventKt$Dsl;", "", "_builder", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent$Builder;", "(Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent$Builder;)V", "value", "", "customEventType", "getCustomEventType", "()Ljava/lang/String;", "setCustomEventType", "(Ljava/lang/String;)V", "", "eventId", "getEventId", "()I", "setEventId", "(I)V", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEventType;", "eventType", "getEventType", "()Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEventType;", "setEventType", "(Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEventType;)V", "intTags", "Lcom/google/protobuf/kotlin/DslMap;", "Lgateway/v1/DiagnosticEventKt$Dsl$IntTagsProxy;", "getIntTagsMap", "()Lcom/google/protobuf/kotlin/DslMap;", "stringTags", "Lgateway/v1/DiagnosticEventKt$Dsl$StringTagsProxy;", "getStringTagsMap", "", "timeValue", "getTimeValue", "()D", "setTimeValue", "(D)V", "Lgateway/v1/TimestampsOuterClass$Timestamps;", "timestamps", "getTimestamps", "()Lgateway/v1/TimestampsOuterClass$Timestamps;", "setTimestamps", "(Lgateway/v1/TimestampsOuterClass$Timestamps;)V", "_build", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent;", "clearCustomEventType", "", "clearEventId", "clearEventType", "clearTimeValue", "clearTimestamps", "hasCustomEventType", "", "hasTimeValue", "hasTimestamps", "clear", "clearIntTags", "clearStringTags", "put", "key", "putIntTags", "putStringTags", "putAll", "map", "", "putAllIntTags", "putAllStringTags", "remove", "removeIntTags", "removeStringTags", "set", "setIntTags", "setStringTags", "Companion", "IntTagsProxy", "StringTagsProxy", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DiagnosticEventKt.kt */
    public static final class Dsl {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder _builder;

        public /* synthetic */ Dsl(DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder) {
            this._builder = builder;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lgateway/v1/DiagnosticEventKt$Dsl$Companion;", "", "()V", "_create", "Lgateway/v1/DiagnosticEventKt$Dsl;", "builder", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent$Builder;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: DiagnosticEventKt.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, (DefaultConstructorMarker) null);
            }
        }

        public final /* synthetic */ DiagnosticEventRequestOuterClass.DiagnosticEvent _build() {
            GeneratedMessageLite build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "_builder.build()");
            return (DiagnosticEventRequestOuterClass.DiagnosticEvent) build;
        }

        public final DiagnosticEventRequestOuterClass.DiagnosticEventType getEventType() {
            DiagnosticEventRequestOuterClass.DiagnosticEventType eventType = this._builder.getEventType();
            Intrinsics.checkNotNullExpressionValue(eventType, "_builder.getEventType()");
            return eventType;
        }

        public final void setEventType(DiagnosticEventRequestOuterClass.DiagnosticEventType diagnosticEventType) {
            Intrinsics.checkNotNullParameter(diagnosticEventType, m2.h.X);
            this._builder.setEventType(diagnosticEventType);
        }

        public final void clearEventType() {
            this._builder.clearEventType();
        }

        public final String getCustomEventType() {
            String customEventType = this._builder.getCustomEventType();
            Intrinsics.checkNotNullExpressionValue(customEventType, "_builder.getCustomEventType()");
            return customEventType;
        }

        public final void setCustomEventType(String str) {
            Intrinsics.checkNotNullParameter(str, m2.h.X);
            this._builder.setCustomEventType(str);
        }

        public final void clearCustomEventType() {
            this._builder.clearCustomEventType();
        }

        public final boolean hasCustomEventType() {
            return this._builder.hasCustomEventType();
        }

        public final TimestampsOuterClass.Timestamps getTimestamps() {
            TimestampsOuterClass.Timestamps timestamps = this._builder.getTimestamps();
            Intrinsics.checkNotNullExpressionValue(timestamps, "_builder.getTimestamps()");
            return timestamps;
        }

        public final void setTimestamps(TimestampsOuterClass.Timestamps timestamps) {
            Intrinsics.checkNotNullParameter(timestamps, m2.h.X);
            this._builder.setTimestamps(timestamps);
        }

        public final void clearTimestamps() {
            this._builder.clearTimestamps();
        }

        public final boolean hasTimestamps() {
            return this._builder.hasTimestamps();
        }

        public final double getTimeValue() {
            return this._builder.getTimeValue();
        }

        public final void setTimeValue(double d) {
            this._builder.setTimeValue(d);
        }

        public final void clearTimeValue() {
            this._builder.clearTimeValue();
        }

        public final boolean hasTimeValue() {
            return this._builder.hasTimeValue();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lgateway/v1/DiagnosticEventKt$Dsl$StringTagsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: DiagnosticEventKt.kt */
        public static final class StringTagsProxy extends DslProxy {
            private StringTagsProxy() {
            }
        }

        public final /* synthetic */ DslMap getStringTagsMap() {
            Map<String, String> stringTagsMap = this._builder.getStringTagsMap();
            Intrinsics.checkNotNullExpressionValue(stringTagsMap, "_builder.getStringTagsMap()");
            return new DslMap(stringTagsMap);
        }

        public final void putStringTags(DslMap<String, String, StringTagsProxy> dslMap, String str, String str2) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(str, m2.h.W);
            Intrinsics.checkNotNullParameter(str2, m2.h.X);
            this._builder.putStringTags(str, str2);
        }

        public final /* synthetic */ void setStringTags(DslMap<String, String, StringTagsProxy> dslMap, String str, String str2) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(str, m2.h.W);
            Intrinsics.checkNotNullParameter(str2, m2.h.X);
            putStringTags(dslMap, str, str2);
        }

        public final /* synthetic */ void removeStringTags(DslMap dslMap, String str) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(str, m2.h.W);
            this._builder.removeStringTags(str);
        }

        public final /* synthetic */ void putAllStringTags(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllStringTags(map);
        }

        public final /* synthetic */ void clearStringTags(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearStringTags();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lgateway/v1/DiagnosticEventKt$Dsl$IntTagsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: DiagnosticEventKt.kt */
        public static final class IntTagsProxy extends DslProxy {
            private IntTagsProxy() {
            }
        }

        public final /* synthetic */ DslMap getIntTagsMap() {
            Map<String, Integer> intTagsMap = this._builder.getIntTagsMap();
            Intrinsics.checkNotNullExpressionValue(intTagsMap, "_builder.getIntTagsMap()");
            return new DslMap(intTagsMap);
        }

        public final void putIntTags(DslMap<String, Integer, IntTagsProxy> dslMap, String str, int i) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(str, m2.h.W);
            this._builder.putIntTags(str, i);
        }

        public final /* synthetic */ void setIntTags(DslMap<String, Integer, IntTagsProxy> dslMap, String str, int i) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(str, m2.h.W);
            putIntTags(dslMap, str, i);
        }

        public final /* synthetic */ void removeIntTags(DslMap dslMap, String str) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(str, m2.h.W);
            this._builder.removeIntTags(str);
        }

        public final /* synthetic */ void putAllIntTags(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllIntTags(map);
        }

        public final /* synthetic */ void clearIntTags(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearIntTags();
        }

        public final int getEventId() {
            return this._builder.getEventId();
        }

        public final void setEventId(int i) {
            this._builder.setEventId(i);
        }

        public final void clearEventId() {
            this._builder.clearEventId();
        }
    }

    private DiagnosticEventKt() {
    }
}
