package gateway.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.ironsource.m2;
import gateway.v1.CampaignStateOuterClass;
import gateway.v1.DynamicDeviceInfoOuterClass;
import gateway.v1.OperativeEventRequestOuterClass;
import gateway.v1.SessionCountersOuterClass;
import gateway.v1.StaticDeviceInfoOuterClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lgateway/v1/OperativeEventRequestKt;", "", "()V", "Dsl", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OperativeEventRequestKt.kt */
public final class OperativeEventRequestKt {
    public static final OperativeEventRequestKt INSTANCE = new OperativeEventRequestKt();

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00109\u001a\u00020:H\u0001J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020<J\u0006\u0010>\u001a\u00020<J\u0006\u0010?\u001a\u00020<J\u0006\u0010@\u001a\u00020<J\u0006\u0010A\u001a\u00020<J\u0006\u0010B\u001a\u00020<J\u0006\u0010C\u001a\u00020<J\u0006\u0010D\u001a\u00020<J\u0006\u0010E\u001a\u00020<J\u0006\u0010F\u001a\u00020GJ\u0006\u0010H\u001a\u00020GJ\u0006\u0010I\u001a\u00020GJ\u0006\u0010J\u001a\u00020GR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR$\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8G@GX\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020*8G@GX\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0002002\u0006\u0010\u0005\u001a\u0002008G@GX\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u000e¢\u0006\f\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000b¨\u0006L"}, d2 = {"Lgateway/v1/OperativeEventRequestKt$Dsl;", "", "_builder", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequest$Builder;", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequest$Builder;)V", "value", "Lcom/google/protobuf/ByteString;", "additionalData", "getAdditionalData", "()Lcom/google/protobuf/ByteString;", "setAdditionalData", "(Lcom/google/protobuf/ByteString;)V", "Lgateway/v1/CampaignStateOuterClass$CampaignState;", "campaignState", "getCampaignState", "()Lgateway/v1/CampaignStateOuterClass$CampaignState;", "setCampaignState", "(Lgateway/v1/CampaignStateOuterClass$CampaignState;)V", "Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo;", "dynamicDeviceInfo", "getDynamicDeviceInfo", "()Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo;", "setDynamicDeviceInfo", "(Lgateway/v1/DynamicDeviceInfoOuterClass$DynamicDeviceInfo;)V", "eventId", "getEventId", "setEventId", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventType;", "eventType", "getEventType", "()Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventType;", "setEventType", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventType;)V", "impressionOpportunityId", "getImpressionOpportunityId", "setImpressionOpportunityId", "Lgateway/v1/SessionCountersOuterClass$SessionCounters;", "sessionCounters", "getSessionCounters", "()Lgateway/v1/SessionCountersOuterClass$SessionCounters;", "setSessionCounters", "(Lgateway/v1/SessionCountersOuterClass$SessionCounters;)V", "", "sid", "getSid", "()Ljava/lang/String;", "setSid", "(Ljava/lang/String;)V", "Lgateway/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo;", "staticDeviceInfo", "getStaticDeviceInfo", "()Lgateway/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo;", "setStaticDeviceInfo", "(Lgateway/v1/StaticDeviceInfoOuterClass$StaticDeviceInfo;)V", "trackingToken", "getTrackingToken", "setTrackingToken", "_build", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequest;", "clearAdditionalData", "", "clearCampaignState", "clearDynamicDeviceInfo", "clearEventId", "clearEventType", "clearImpressionOpportunityId", "clearSessionCounters", "clearSid", "clearStaticDeviceInfo", "clearTrackingToken", "hasCampaignState", "", "hasDynamicDeviceInfo", "hasSessionCounters", "hasStaticDeviceInfo", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OperativeEventRequestKt.kt */
    public static final class Dsl {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final OperativeEventRequestOuterClass.OperativeEventRequest.Builder _builder;

        public /* synthetic */ Dsl(OperativeEventRequestOuterClass.OperativeEventRequest.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(OperativeEventRequestOuterClass.OperativeEventRequest.Builder builder) {
            this._builder = builder;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lgateway/v1/OperativeEventRequestKt$Dsl$Companion;", "", "()V", "_create", "Lgateway/v1/OperativeEventRequestKt$Dsl;", "builder", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequest$Builder;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: OperativeEventRequestKt.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(OperativeEventRequestOuterClass.OperativeEventRequest.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, (DefaultConstructorMarker) null);
            }
        }

        public final /* synthetic */ OperativeEventRequestOuterClass.OperativeEventRequest _build() {
            GeneratedMessageLite build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "_builder.build()");
            return (OperativeEventRequestOuterClass.OperativeEventRequest) build;
        }

        public final ByteString getEventId() {
            ByteString eventId = this._builder.getEventId();
            Intrinsics.checkNotNullExpressionValue(eventId, "_builder.getEventId()");
            return eventId;
        }

        public final void setEventId(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, m2.h.X);
            this._builder.setEventId(byteString);
        }

        public final void clearEventId() {
            this._builder.clearEventId();
        }

        public final OperativeEventRequestOuterClass.OperativeEventType getEventType() {
            OperativeEventRequestOuterClass.OperativeEventType eventType = this._builder.getEventType();
            Intrinsics.checkNotNullExpressionValue(eventType, "_builder.getEventType()");
            return eventType;
        }

        public final void setEventType(OperativeEventRequestOuterClass.OperativeEventType operativeEventType) {
            Intrinsics.checkNotNullParameter(operativeEventType, m2.h.X);
            this._builder.setEventType(operativeEventType);
        }

        public final void clearEventType() {
            this._builder.clearEventType();
        }

        public final ByteString getImpressionOpportunityId() {
            ByteString impressionOpportunityId = this._builder.getImpressionOpportunityId();
            Intrinsics.checkNotNullExpressionValue(impressionOpportunityId, "_builder.getImpressionOpportunityId()");
            return impressionOpportunityId;
        }

        public final void setImpressionOpportunityId(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, m2.h.X);
            this._builder.setImpressionOpportunityId(byteString);
        }

        public final void clearImpressionOpportunityId() {
            this._builder.clearImpressionOpportunityId();
        }

        public final ByteString getTrackingToken() {
            ByteString trackingToken = this._builder.getTrackingToken();
            Intrinsics.checkNotNullExpressionValue(trackingToken, "_builder.getTrackingToken()");
            return trackingToken;
        }

        public final void setTrackingToken(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, m2.h.X);
            this._builder.setTrackingToken(byteString);
        }

        public final void clearTrackingToken() {
            this._builder.clearTrackingToken();
        }

        public final ByteString getAdditionalData() {
            ByteString additionalData = this._builder.getAdditionalData();
            Intrinsics.checkNotNullExpressionValue(additionalData, "_builder.getAdditionalData()");
            return additionalData;
        }

        public final void setAdditionalData(ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, m2.h.X);
            this._builder.setAdditionalData(byteString);
        }

        public final void clearAdditionalData() {
            this._builder.clearAdditionalData();
        }

        public final String getSid() {
            String sid = this._builder.getSid();
            Intrinsics.checkNotNullExpressionValue(sid, "_builder.getSid()");
            return sid;
        }

        public final void setSid(String str) {
            Intrinsics.checkNotNullParameter(str, m2.h.X);
            this._builder.setSid(str);
        }

        public final void clearSid() {
            this._builder.clearSid();
        }

        public final SessionCountersOuterClass.SessionCounters getSessionCounters() {
            SessionCountersOuterClass.SessionCounters sessionCounters = this._builder.getSessionCounters();
            Intrinsics.checkNotNullExpressionValue(sessionCounters, "_builder.getSessionCounters()");
            return sessionCounters;
        }

        public final void setSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
            Intrinsics.checkNotNullParameter(sessionCounters, m2.h.X);
            this._builder.setSessionCounters(sessionCounters);
        }

        public final void clearSessionCounters() {
            this._builder.clearSessionCounters();
        }

        public final boolean hasSessionCounters() {
            return this._builder.hasSessionCounters();
        }

        public final StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo = this._builder.getStaticDeviceInfo();
            Intrinsics.checkNotNullExpressionValue(staticDeviceInfo, "_builder.getStaticDeviceInfo()");
            return staticDeviceInfo;
        }

        public final void setStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo) {
            Intrinsics.checkNotNullParameter(staticDeviceInfo, m2.h.X);
            this._builder.setStaticDeviceInfo(staticDeviceInfo);
        }

        public final void clearStaticDeviceInfo() {
            this._builder.clearStaticDeviceInfo();
        }

        public final boolean hasStaticDeviceInfo() {
            return this._builder.hasStaticDeviceInfo();
        }

        public final DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
            DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo = this._builder.getDynamicDeviceInfo();
            Intrinsics.checkNotNullExpressionValue(dynamicDeviceInfo, "_builder.getDynamicDeviceInfo()");
            return dynamicDeviceInfo;
        }

        public final void setDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo) {
            Intrinsics.checkNotNullParameter(dynamicDeviceInfo, m2.h.X);
            this._builder.setDynamicDeviceInfo(dynamicDeviceInfo);
        }

        public final void clearDynamicDeviceInfo() {
            this._builder.clearDynamicDeviceInfo();
        }

        public final boolean hasDynamicDeviceInfo() {
            return this._builder.hasDynamicDeviceInfo();
        }

        public final CampaignStateOuterClass.CampaignState getCampaignState() {
            CampaignStateOuterClass.CampaignState campaignState = this._builder.getCampaignState();
            Intrinsics.checkNotNullExpressionValue(campaignState, "_builder.getCampaignState()");
            return campaignState;
        }

        public final void setCampaignState(CampaignStateOuterClass.CampaignState campaignState) {
            Intrinsics.checkNotNullParameter(campaignState, m2.h.X);
            this._builder.setCampaignState(campaignState);
        }

        public final void clearCampaignState() {
            this._builder.clearCampaignState();
        }

        public final boolean hasCampaignState() {
            return this._builder.hasCampaignState();
        }
    }

    private OperativeEventRequestKt() {
    }
}
