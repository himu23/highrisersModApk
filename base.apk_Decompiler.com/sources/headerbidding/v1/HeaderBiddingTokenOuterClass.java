package headerbidding.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import gateway.v1.CampaignStateOuterClass;
import gateway.v1.ClientInfoOuterClass;
import gateway.v1.DynamicDeviceInfoOuterClass;
import gateway.v1.PiiOuterClass;
import gateway.v1.SessionCountersOuterClass;
import gateway.v1.StaticDeviceInfoOuterClass;
import gateway.v1.TimestampsOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class HeaderBiddingTokenOuterClass {

    public interface HeaderBiddingTokenOrBuilder extends MessageLiteOrBuilder {
        CampaignStateOuterClass.CampaignState getCampaignState();

        ClientInfoOuterClass.ClientInfo getClientInfo();

        DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo();

        PiiOuterClass.Pii getPii();

        SessionCountersOuterClass.SessionCounters getSessionCounters();

        ByteString getSessionToken();

        StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo();

        ByteString getTcf();

        TimestampsOuterClass.Timestamps getTimestamps();

        ByteString getTokenId();

        int getTokenNumber();

        boolean hasCampaignState();

        boolean hasClientInfo();

        boolean hasDynamicDeviceInfo();

        boolean hasPii();

        boolean hasSessionCounters();

        boolean hasStaticDeviceInfo();

        boolean hasTcf();

        boolean hasTimestamps();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private HeaderBiddingTokenOuterClass() {
    }

    public static final class HeaderBiddingToken extends GeneratedMessageLite<HeaderBiddingToken, Builder> implements HeaderBiddingTokenOrBuilder {
        public static final int CAMPAIGN_STATE_FIELD_NUMBER = 10;
        public static final int CLIENT_INFO_FIELD_NUMBER = 4;
        /* access modifiers changed from: private */
        public static final HeaderBiddingToken DEFAULT_INSTANCE;
        public static final int DYNAMIC_DEVICE_INFO_FIELD_NUMBER = 8;
        private static volatile Parser<HeaderBiddingToken> PARSER = null;
        public static final int PII_FIELD_NUMBER = 9;
        public static final int SESSION_COUNTERS_FIELD_NUMBER = 6;
        public static final int SESSION_TOKEN_FIELD_NUMBER = 3;
        public static final int STATIC_DEVICE_INFO_FIELD_NUMBER = 7;
        public static final int TCF_FIELD_NUMBER = 11;
        public static final int TIMESTAMPS_FIELD_NUMBER = 5;
        public static final int TOKEN_ID_FIELD_NUMBER = 1;
        public static final int TOKEN_NUMBER_FIELD_NUMBER = 2;
        private int bitField0_;
        private CampaignStateOuterClass.CampaignState campaignState_;
        private ClientInfoOuterClass.ClientInfo clientInfo_;
        private DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo_;
        private PiiOuterClass.Pii pii_;
        private SessionCountersOuterClass.SessionCounters sessionCounters_;
        private ByteString sessionToken_ = ByteString.EMPTY;
        private StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo_;
        private ByteString tcf_ = ByteString.EMPTY;
        private TimestampsOuterClass.Timestamps timestamps_;
        private ByteString tokenId_ = ByteString.EMPTY;
        private int tokenNumber_;

        /* access modifiers changed from: private */
        public void clearCampaignState() {
            this.campaignState_ = null;
        }

        /* access modifiers changed from: private */
        public void clearClientInfo() {
            this.clientInfo_ = null;
        }

        /* access modifiers changed from: private */
        public void clearDynamicDeviceInfo() {
            this.dynamicDeviceInfo_ = null;
        }

        /* access modifiers changed from: private */
        public void clearPii() {
            this.pii_ = null;
            this.bitField0_ &= -2;
        }

        /* access modifiers changed from: private */
        public void clearSessionCounters() {
            this.sessionCounters_ = null;
        }

        /* access modifiers changed from: private */
        public void clearStaticDeviceInfo() {
            this.staticDeviceInfo_ = null;
        }

        /* access modifiers changed from: private */
        public void clearTimestamps() {
            this.timestamps_ = null;
        }

        /* access modifiers changed from: private */
        public void clearTokenNumber() {
            this.tokenNumber_ = 0;
        }

        public static HeaderBiddingToken getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void setTokenNumber(int i) {
            this.tokenNumber_ = i;
        }

        public ByteString getSessionToken() {
            return this.sessionToken_;
        }

        public ByteString getTcf() {
            return this.tcf_;
        }

        public ByteString getTokenId() {
            return this.tokenId_;
        }

        public int getTokenNumber() {
            return this.tokenNumber_;
        }

        public boolean hasCampaignState() {
            return this.campaignState_ != null;
        }

        public boolean hasClientInfo() {
            return this.clientInfo_ != null;
        }

        public boolean hasDynamicDeviceInfo() {
            return this.dynamicDeviceInfo_ != null;
        }

        public boolean hasPii() {
            return (this.bitField0_ & 1) != 0;
        }

        public boolean hasSessionCounters() {
            return this.sessionCounters_ != null;
        }

        public boolean hasStaticDeviceInfo() {
            return this.staticDeviceInfo_ != null;
        }

        public boolean hasTcf() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasTimestamps() {
            return this.timestamps_ != null;
        }

        private HeaderBiddingToken() {
        }

        /* access modifiers changed from: private */
        public void setTokenId(ByteString byteString) {
            byteString.getClass();
            this.tokenId_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearTokenId() {
            this.tokenId_ = getDefaultInstance().getTokenId();
        }

        /* access modifiers changed from: private */
        public void setSessionToken(ByteString byteString) {
            byteString.getClass();
            this.sessionToken_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearSessionToken() {
            this.sessionToken_ = getDefaultInstance().getSessionToken();
        }

        public ClientInfoOuterClass.ClientInfo getClientInfo() {
            ClientInfoOuterClass.ClientInfo clientInfo = this.clientInfo_;
            return clientInfo == null ? ClientInfoOuterClass.ClientInfo.getDefaultInstance() : clientInfo;
        }

        /* access modifiers changed from: private */
        public void setClientInfo(ClientInfoOuterClass.ClientInfo clientInfo) {
            clientInfo.getClass();
            this.clientInfo_ = clientInfo;
        }

        /* access modifiers changed from: private */
        public void mergeClientInfo(ClientInfoOuterClass.ClientInfo clientInfo) {
            clientInfo.getClass();
            ClientInfoOuterClass.ClientInfo clientInfo2 = this.clientInfo_;
            if (clientInfo2 == null || clientInfo2 == ClientInfoOuterClass.ClientInfo.getDefaultInstance()) {
                this.clientInfo_ = clientInfo;
            } else {
                this.clientInfo_ = (ClientInfoOuterClass.ClientInfo) ((ClientInfoOuterClass.ClientInfo.Builder) ClientInfoOuterClass.ClientInfo.newBuilder(this.clientInfo_).mergeFrom(clientInfo)).buildPartial();
            }
        }

        public TimestampsOuterClass.Timestamps getTimestamps() {
            TimestampsOuterClass.Timestamps timestamps = this.timestamps_;
            return timestamps == null ? TimestampsOuterClass.Timestamps.getDefaultInstance() : timestamps;
        }

        /* access modifiers changed from: private */
        public void setTimestamps(TimestampsOuterClass.Timestamps timestamps) {
            timestamps.getClass();
            this.timestamps_ = timestamps;
        }

        /* access modifiers changed from: private */
        public void mergeTimestamps(TimestampsOuterClass.Timestamps timestamps) {
            timestamps.getClass();
            TimestampsOuterClass.Timestamps timestamps2 = this.timestamps_;
            if (timestamps2 == null || timestamps2 == TimestampsOuterClass.Timestamps.getDefaultInstance()) {
                this.timestamps_ = timestamps;
            } else {
                this.timestamps_ = (TimestampsOuterClass.Timestamps) ((TimestampsOuterClass.Timestamps.Builder) TimestampsOuterClass.Timestamps.newBuilder(this.timestamps_).mergeFrom(timestamps)).buildPartial();
            }
        }

        public SessionCountersOuterClass.SessionCounters getSessionCounters() {
            SessionCountersOuterClass.SessionCounters sessionCounters = this.sessionCounters_;
            return sessionCounters == null ? SessionCountersOuterClass.SessionCounters.getDefaultInstance() : sessionCounters;
        }

        /* access modifiers changed from: private */
        public void setSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
            sessionCounters.getClass();
            this.sessionCounters_ = sessionCounters;
        }

        /* access modifiers changed from: private */
        public void mergeSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
            sessionCounters.getClass();
            SessionCountersOuterClass.SessionCounters sessionCounters2 = this.sessionCounters_;
            if (sessionCounters2 == null || sessionCounters2 == SessionCountersOuterClass.SessionCounters.getDefaultInstance()) {
                this.sessionCounters_ = sessionCounters;
            } else {
                this.sessionCounters_ = (SessionCountersOuterClass.SessionCounters) ((SessionCountersOuterClass.SessionCounters.Builder) SessionCountersOuterClass.SessionCounters.newBuilder(this.sessionCounters_).mergeFrom(sessionCounters)).buildPartial();
            }
        }

        public StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo = this.staticDeviceInfo_;
            return staticDeviceInfo == null ? StaticDeviceInfoOuterClass.StaticDeviceInfo.getDefaultInstance() : staticDeviceInfo;
        }

        /* access modifiers changed from: private */
        public void setStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo) {
            staticDeviceInfo.getClass();
            this.staticDeviceInfo_ = staticDeviceInfo;
        }

        /* access modifiers changed from: private */
        public void mergeStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo) {
            staticDeviceInfo.getClass();
            StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo2 = this.staticDeviceInfo_;
            if (staticDeviceInfo2 == null || staticDeviceInfo2 == StaticDeviceInfoOuterClass.StaticDeviceInfo.getDefaultInstance()) {
                this.staticDeviceInfo_ = staticDeviceInfo;
            } else {
                this.staticDeviceInfo_ = (StaticDeviceInfoOuterClass.StaticDeviceInfo) ((StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder) StaticDeviceInfoOuterClass.StaticDeviceInfo.newBuilder(this.staticDeviceInfo_).mergeFrom(staticDeviceInfo)).buildPartial();
            }
        }

        public DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
            DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo = this.dynamicDeviceInfo_;
            return dynamicDeviceInfo == null ? DynamicDeviceInfoOuterClass.DynamicDeviceInfo.getDefaultInstance() : dynamicDeviceInfo;
        }

        /* access modifiers changed from: private */
        public void setDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo) {
            dynamicDeviceInfo.getClass();
            this.dynamicDeviceInfo_ = dynamicDeviceInfo;
        }

        /* access modifiers changed from: private */
        public void mergeDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo) {
            dynamicDeviceInfo.getClass();
            DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo2 = this.dynamicDeviceInfo_;
            if (dynamicDeviceInfo2 == null || dynamicDeviceInfo2 == DynamicDeviceInfoOuterClass.DynamicDeviceInfo.getDefaultInstance()) {
                this.dynamicDeviceInfo_ = dynamicDeviceInfo;
            } else {
                this.dynamicDeviceInfo_ = (DynamicDeviceInfoOuterClass.DynamicDeviceInfo) ((DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Builder) DynamicDeviceInfoOuterClass.DynamicDeviceInfo.newBuilder(this.dynamicDeviceInfo_).mergeFrom(dynamicDeviceInfo)).buildPartial();
            }
        }

        public PiiOuterClass.Pii getPii() {
            PiiOuterClass.Pii pii = this.pii_;
            return pii == null ? PiiOuterClass.Pii.getDefaultInstance() : pii;
        }

        /* access modifiers changed from: private */
        public void setPii(PiiOuterClass.Pii pii) {
            pii.getClass();
            this.pii_ = pii;
            this.bitField0_ |= 1;
        }

        /* access modifiers changed from: private */
        public void mergePii(PiiOuterClass.Pii pii) {
            pii.getClass();
            PiiOuterClass.Pii pii2 = this.pii_;
            if (pii2 == null || pii2 == PiiOuterClass.Pii.getDefaultInstance()) {
                this.pii_ = pii;
            } else {
                this.pii_ = (PiiOuterClass.Pii) ((PiiOuterClass.Pii.Builder) PiiOuterClass.Pii.newBuilder(this.pii_).mergeFrom(pii)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public CampaignStateOuterClass.CampaignState getCampaignState() {
            CampaignStateOuterClass.CampaignState campaignState = this.campaignState_;
            return campaignState == null ? CampaignStateOuterClass.CampaignState.getDefaultInstance() : campaignState;
        }

        /* access modifiers changed from: private */
        public void setCampaignState(CampaignStateOuterClass.CampaignState campaignState) {
            campaignState.getClass();
            this.campaignState_ = campaignState;
        }

        /* access modifiers changed from: private */
        public void mergeCampaignState(CampaignStateOuterClass.CampaignState campaignState) {
            campaignState.getClass();
            CampaignStateOuterClass.CampaignState campaignState2 = this.campaignState_;
            if (campaignState2 == null || campaignState2 == CampaignStateOuterClass.CampaignState.getDefaultInstance()) {
                this.campaignState_ = campaignState;
            } else {
                this.campaignState_ = (CampaignStateOuterClass.CampaignState) ((CampaignStateOuterClass.CampaignState.Builder) CampaignStateOuterClass.CampaignState.newBuilder(this.campaignState_).mergeFrom(campaignState)).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void setTcf(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.tcf_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearTcf() {
            this.bitField0_ &= -3;
            this.tcf_ = getDefaultInstance().getTcf();
        }

        public static HeaderBiddingToken parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static HeaderBiddingToken parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static HeaderBiddingToken parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static HeaderBiddingToken parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static HeaderBiddingToken parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static HeaderBiddingToken parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static HeaderBiddingToken parseFrom(InputStream inputStream) throws IOException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HeaderBiddingToken parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HeaderBiddingToken parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (HeaderBiddingToken) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HeaderBiddingToken parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HeaderBiddingToken) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HeaderBiddingToken parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static HeaderBiddingToken parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HeaderBiddingToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(HeaderBiddingToken headerBiddingToken) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(headerBiddingToken);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<HeaderBiddingToken, Builder> implements HeaderBiddingTokenOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(HeaderBiddingToken.DEFAULT_INSTANCE);
            }

            public ByteString getTokenId() {
                return ((HeaderBiddingToken) this.instance).getTokenId();
            }

            public Builder setTokenId(ByteString byteString) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setTokenId(byteString);
                return this;
            }

            public Builder clearTokenId() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearTokenId();
                return this;
            }

            public int getTokenNumber() {
                return ((HeaderBiddingToken) this.instance).getTokenNumber();
            }

            public Builder setTokenNumber(int i) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setTokenNumber(i);
                return this;
            }

            public Builder clearTokenNumber() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearTokenNumber();
                return this;
            }

            public ByteString getSessionToken() {
                return ((HeaderBiddingToken) this.instance).getSessionToken();
            }

            public Builder setSessionToken(ByteString byteString) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setSessionToken(byteString);
                return this;
            }

            public Builder clearSessionToken() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearSessionToken();
                return this;
            }

            public boolean hasClientInfo() {
                return ((HeaderBiddingToken) this.instance).hasClientInfo();
            }

            public ClientInfoOuterClass.ClientInfo getClientInfo() {
                return ((HeaderBiddingToken) this.instance).getClientInfo();
            }

            public Builder setClientInfo(ClientInfoOuterClass.ClientInfo clientInfo) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setClientInfo(clientInfo);
                return this;
            }

            public Builder setClientInfo(ClientInfoOuterClass.ClientInfo.Builder builder) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setClientInfo((ClientInfoOuterClass.ClientInfo) builder.build());
                return this;
            }

            public Builder mergeClientInfo(ClientInfoOuterClass.ClientInfo clientInfo) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).mergeClientInfo(clientInfo);
                return this;
            }

            public Builder clearClientInfo() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearClientInfo();
                return this;
            }

            public boolean hasTimestamps() {
                return ((HeaderBiddingToken) this.instance).hasTimestamps();
            }

            public TimestampsOuterClass.Timestamps getTimestamps() {
                return ((HeaderBiddingToken) this.instance).getTimestamps();
            }

            public Builder setTimestamps(TimestampsOuterClass.Timestamps timestamps) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setTimestamps(timestamps);
                return this;
            }

            public Builder setTimestamps(TimestampsOuterClass.Timestamps.Builder builder) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setTimestamps((TimestampsOuterClass.Timestamps) builder.build());
                return this;
            }

            public Builder mergeTimestamps(TimestampsOuterClass.Timestamps timestamps) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).mergeTimestamps(timestamps);
                return this;
            }

            public Builder clearTimestamps() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearTimestamps();
                return this;
            }

            public boolean hasSessionCounters() {
                return ((HeaderBiddingToken) this.instance).hasSessionCounters();
            }

            public SessionCountersOuterClass.SessionCounters getSessionCounters() {
                return ((HeaderBiddingToken) this.instance).getSessionCounters();
            }

            public Builder setSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setSessionCounters(sessionCounters);
                return this;
            }

            public Builder setSessionCounters(SessionCountersOuterClass.SessionCounters.Builder builder) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setSessionCounters((SessionCountersOuterClass.SessionCounters) builder.build());
                return this;
            }

            public Builder mergeSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).mergeSessionCounters(sessionCounters);
                return this;
            }

            public Builder clearSessionCounters() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearSessionCounters();
                return this;
            }

            public boolean hasStaticDeviceInfo() {
                return ((HeaderBiddingToken) this.instance).hasStaticDeviceInfo();
            }

            public StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo() {
                return ((HeaderBiddingToken) this.instance).getStaticDeviceInfo();
            }

            public Builder setStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setStaticDeviceInfo(staticDeviceInfo);
                return this;
            }

            public Builder setStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder builder) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) builder.build());
                return this;
            }

            public Builder mergeStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).mergeStaticDeviceInfo(staticDeviceInfo);
                return this;
            }

            public Builder clearStaticDeviceInfo() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearStaticDeviceInfo();
                return this;
            }

            public boolean hasDynamicDeviceInfo() {
                return ((HeaderBiddingToken) this.instance).hasDynamicDeviceInfo();
            }

            public DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
                return ((HeaderBiddingToken) this.instance).getDynamicDeviceInfo();
            }

            public Builder setDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setDynamicDeviceInfo(dynamicDeviceInfo);
                return this;
            }

            public Builder setDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Builder builder) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setDynamicDeviceInfo((DynamicDeviceInfoOuterClass.DynamicDeviceInfo) builder.build());
                return this;
            }

            public Builder mergeDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).mergeDynamicDeviceInfo(dynamicDeviceInfo);
                return this;
            }

            public Builder clearDynamicDeviceInfo() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearDynamicDeviceInfo();
                return this;
            }

            public boolean hasPii() {
                return ((HeaderBiddingToken) this.instance).hasPii();
            }

            public PiiOuterClass.Pii getPii() {
                return ((HeaderBiddingToken) this.instance).getPii();
            }

            public Builder setPii(PiiOuterClass.Pii pii) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setPii(pii);
                return this;
            }

            public Builder setPii(PiiOuterClass.Pii.Builder builder) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setPii((PiiOuterClass.Pii) builder.build());
                return this;
            }

            public Builder mergePii(PiiOuterClass.Pii pii) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).mergePii(pii);
                return this;
            }

            public Builder clearPii() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearPii();
                return this;
            }

            public boolean hasCampaignState() {
                return ((HeaderBiddingToken) this.instance).hasCampaignState();
            }

            public CampaignStateOuterClass.CampaignState getCampaignState() {
                return ((HeaderBiddingToken) this.instance).getCampaignState();
            }

            public Builder setCampaignState(CampaignStateOuterClass.CampaignState campaignState) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setCampaignState(campaignState);
                return this;
            }

            public Builder setCampaignState(CampaignStateOuterClass.CampaignState.Builder builder) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setCampaignState((CampaignStateOuterClass.CampaignState) builder.build());
                return this;
            }

            public Builder mergeCampaignState(CampaignStateOuterClass.CampaignState campaignState) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).mergeCampaignState(campaignState);
                return this;
            }

            public Builder clearCampaignState() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearCampaignState();
                return this;
            }

            public boolean hasTcf() {
                return ((HeaderBiddingToken) this.instance).hasTcf();
            }

            public ByteString getTcf() {
                return ((HeaderBiddingToken) this.instance).getTcf();
            }

            public Builder setTcf(ByteString byteString) {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).setTcf(byteString);
                return this;
            }

            public Builder clearTcf() {
                copyOnWrite();
                ((HeaderBiddingToken) this.instance).clearTcf();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new HeaderBiddingToken();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\n\u0002\u0004\u0003\n\u0004\t\u0005\t\u0006\t\u0007\t\b\t\tဉ\u0000\n\t\u000bည\u0001", new Object[]{"bitField0_", "tokenId_", "tokenNumber_", "sessionToken_", "clientInfo_", "timestamps_", "sessionCounters_", "staticDeviceInfo_", "dynamicDeviceInfo_", "pii_", "campaignState_", "tcf_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<HeaderBiddingToken> parser = PARSER;
                    if (parser == null) {
                        synchronized (HeaderBiddingToken.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            HeaderBiddingToken headerBiddingToken = new HeaderBiddingToken();
            DEFAULT_INSTANCE = headerBiddingToken;
            GeneratedMessageLite.registerDefaultInstance(HeaderBiddingToken.class, headerBiddingToken);
        }

        public static Parser<HeaderBiddingToken> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: headerbidding.v1.HeaderBiddingTokenOuterClass$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: headerbidding.v1.HeaderBiddingTokenOuterClass.AnonymousClass1.<clinit>():void");
        }
    }
}
