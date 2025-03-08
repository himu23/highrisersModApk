package gateway.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import gateway.v1.TimestampsOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class CampaignStateOuterClass {

    public interface CampaignOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();

        int getDataVersion();

        ByteString getImpressionOpportunityId();

        TimestampsOuterClass.Timestamps getLoadTimestamp();

        String getPlacementId();

        ByteString getPlacementIdBytes();

        TimestampsOuterClass.Timestamps getShowTimestamp();

        boolean hasLoadTimestamp();

        boolean hasShowTimestamp();
    }

    public interface CampaignStateOrBuilder extends MessageLiteOrBuilder {
        Campaign getLoadedCampaigns(int i);

        int getLoadedCampaignsCount();

        List<Campaign> getLoadedCampaignsList();

        Campaign getShownCampaigns(int i);

        int getShownCampaignsCount();

        List<Campaign> getShownCampaignsList();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private CampaignStateOuterClass() {
    }

    public static final class Campaign extends GeneratedMessageLite<Campaign, Builder> implements CampaignOrBuilder {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int DATA_VERSION_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final Campaign DEFAULT_INSTANCE;
        public static final int IMPRESSION_OPPORTUNITY_ID_FIELD_NUMBER = 4;
        public static final int LOAD_TIMESTAMP_FIELD_NUMBER = 5;
        private static volatile Parser<Campaign> PARSER = null;
        public static final int PLACEMENT_ID_FIELD_NUMBER = 3;
        public static final int SHOW_TIMESTAMP_FIELD_NUMBER = 6;
        private int bitField0_;
        private int dataVersion_;
        private ByteString data_ = ByteString.EMPTY;
        private ByteString impressionOpportunityId_ = ByteString.EMPTY;
        private TimestampsOuterClass.Timestamps loadTimestamp_;
        private String placementId_ = "";
        private TimestampsOuterClass.Timestamps showTimestamp_;

        /* access modifiers changed from: private */
        public void clearDataVersion() {
            this.dataVersion_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearLoadTimestamp() {
            this.loadTimestamp_ = null;
        }

        /* access modifiers changed from: private */
        public void clearShowTimestamp() {
            this.showTimestamp_ = null;
            this.bitField0_ &= -2;
        }

        public static Campaign getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void setDataVersion(int i) {
            this.dataVersion_ = i;
        }

        public ByteString getData() {
            return this.data_;
        }

        public int getDataVersion() {
            return this.dataVersion_;
        }

        public ByteString getImpressionOpportunityId() {
            return this.impressionOpportunityId_;
        }

        public String getPlacementId() {
            return this.placementId_;
        }

        public boolean hasLoadTimestamp() {
            return this.loadTimestamp_ != null;
        }

        public boolean hasShowTimestamp() {
            return (this.bitField0_ & 1) != 0;
        }

        private Campaign() {
        }

        /* access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public ByteString getPlacementIdBytes() {
            return ByteString.copyFromUtf8(this.placementId_);
        }

        /* access modifiers changed from: private */
        public void setPlacementId(String str) {
            str.getClass();
            this.placementId_ = str;
        }

        /* access modifiers changed from: private */
        public void clearPlacementId() {
            this.placementId_ = getDefaultInstance().getPlacementId();
        }

        /* access modifiers changed from: private */
        public void setPlacementIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.placementId_ = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        public void setImpressionOpportunityId(ByteString byteString) {
            byteString.getClass();
            this.impressionOpportunityId_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearImpressionOpportunityId() {
            this.impressionOpportunityId_ = getDefaultInstance().getImpressionOpportunityId();
        }

        public TimestampsOuterClass.Timestamps getLoadTimestamp() {
            TimestampsOuterClass.Timestamps timestamps = this.loadTimestamp_;
            return timestamps == null ? TimestampsOuterClass.Timestamps.getDefaultInstance() : timestamps;
        }

        /* access modifiers changed from: private */
        public void setLoadTimestamp(TimestampsOuterClass.Timestamps timestamps) {
            timestamps.getClass();
            this.loadTimestamp_ = timestamps;
        }

        /* access modifiers changed from: private */
        public void mergeLoadTimestamp(TimestampsOuterClass.Timestamps timestamps) {
            timestamps.getClass();
            TimestampsOuterClass.Timestamps timestamps2 = this.loadTimestamp_;
            if (timestamps2 == null || timestamps2 == TimestampsOuterClass.Timestamps.getDefaultInstance()) {
                this.loadTimestamp_ = timestamps;
            } else {
                this.loadTimestamp_ = (TimestampsOuterClass.Timestamps) ((TimestampsOuterClass.Timestamps.Builder) TimestampsOuterClass.Timestamps.newBuilder(this.loadTimestamp_).mergeFrom(timestamps)).buildPartial();
            }
        }

        public TimestampsOuterClass.Timestamps getShowTimestamp() {
            TimestampsOuterClass.Timestamps timestamps = this.showTimestamp_;
            return timestamps == null ? TimestampsOuterClass.Timestamps.getDefaultInstance() : timestamps;
        }

        /* access modifiers changed from: private */
        public void setShowTimestamp(TimestampsOuterClass.Timestamps timestamps) {
            timestamps.getClass();
            this.showTimestamp_ = timestamps;
            this.bitField0_ |= 1;
        }

        /* access modifiers changed from: private */
        public void mergeShowTimestamp(TimestampsOuterClass.Timestamps timestamps) {
            timestamps.getClass();
            TimestampsOuterClass.Timestamps timestamps2 = this.showTimestamp_;
            if (timestamps2 == null || timestamps2 == TimestampsOuterClass.Timestamps.getDefaultInstance()) {
                this.showTimestamp_ = timestamps;
            } else {
                this.showTimestamp_ = (TimestampsOuterClass.Timestamps) ((TimestampsOuterClass.Timestamps.Builder) TimestampsOuterClass.Timestamps.newBuilder(this.showTimestamp_).mergeFrom(timestamps)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Campaign parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Campaign parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Campaign parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Campaign parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Campaign parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Campaign parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Campaign parseFrom(InputStream inputStream) throws IOException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Campaign parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Campaign parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Campaign) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Campaign parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Campaign) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Campaign parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Campaign parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Campaign) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Campaign campaign) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(campaign);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Campaign, Builder> implements CampaignOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(Campaign.DEFAULT_INSTANCE);
            }

            public int getDataVersion() {
                return ((Campaign) this.instance).getDataVersion();
            }

            public Builder setDataVersion(int i) {
                copyOnWrite();
                ((Campaign) this.instance).setDataVersion(i);
                return this;
            }

            public Builder clearDataVersion() {
                copyOnWrite();
                ((Campaign) this.instance).clearDataVersion();
                return this;
            }

            public ByteString getData() {
                return ((Campaign) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((Campaign) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((Campaign) this.instance).clearData();
                return this;
            }

            public String getPlacementId() {
                return ((Campaign) this.instance).getPlacementId();
            }

            public ByteString getPlacementIdBytes() {
                return ((Campaign) this.instance).getPlacementIdBytes();
            }

            public Builder setPlacementId(String str) {
                copyOnWrite();
                ((Campaign) this.instance).setPlacementId(str);
                return this;
            }

            public Builder clearPlacementId() {
                copyOnWrite();
                ((Campaign) this.instance).clearPlacementId();
                return this;
            }

            public Builder setPlacementIdBytes(ByteString byteString) {
                copyOnWrite();
                ((Campaign) this.instance).setPlacementIdBytes(byteString);
                return this;
            }

            public ByteString getImpressionOpportunityId() {
                return ((Campaign) this.instance).getImpressionOpportunityId();
            }

            public Builder setImpressionOpportunityId(ByteString byteString) {
                copyOnWrite();
                ((Campaign) this.instance).setImpressionOpportunityId(byteString);
                return this;
            }

            public Builder clearImpressionOpportunityId() {
                copyOnWrite();
                ((Campaign) this.instance).clearImpressionOpportunityId();
                return this;
            }

            public boolean hasLoadTimestamp() {
                return ((Campaign) this.instance).hasLoadTimestamp();
            }

            public TimestampsOuterClass.Timestamps getLoadTimestamp() {
                return ((Campaign) this.instance).getLoadTimestamp();
            }

            public Builder setLoadTimestamp(TimestampsOuterClass.Timestamps timestamps) {
                copyOnWrite();
                ((Campaign) this.instance).setLoadTimestamp(timestamps);
                return this;
            }

            public Builder setLoadTimestamp(TimestampsOuterClass.Timestamps.Builder builder) {
                copyOnWrite();
                ((Campaign) this.instance).setLoadTimestamp((TimestampsOuterClass.Timestamps) builder.build());
                return this;
            }

            public Builder mergeLoadTimestamp(TimestampsOuterClass.Timestamps timestamps) {
                copyOnWrite();
                ((Campaign) this.instance).mergeLoadTimestamp(timestamps);
                return this;
            }

            public Builder clearLoadTimestamp() {
                copyOnWrite();
                ((Campaign) this.instance).clearLoadTimestamp();
                return this;
            }

            public boolean hasShowTimestamp() {
                return ((Campaign) this.instance).hasShowTimestamp();
            }

            public TimestampsOuterClass.Timestamps getShowTimestamp() {
                return ((Campaign) this.instance).getShowTimestamp();
            }

            public Builder setShowTimestamp(TimestampsOuterClass.Timestamps timestamps) {
                copyOnWrite();
                ((Campaign) this.instance).setShowTimestamp(timestamps);
                return this;
            }

            public Builder setShowTimestamp(TimestampsOuterClass.Timestamps.Builder builder) {
                copyOnWrite();
                ((Campaign) this.instance).setShowTimestamp((TimestampsOuterClass.Timestamps) builder.build());
                return this;
            }

            public Builder mergeShowTimestamp(TimestampsOuterClass.Timestamps timestamps) {
                copyOnWrite();
                ((Campaign) this.instance).mergeShowTimestamp(timestamps);
                return this;
            }

            public Builder clearShowTimestamp() {
                copyOnWrite();
                ((Campaign) this.instance).clearShowTimestamp();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Campaign();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002\n\u0003Ȉ\u0004\n\u0005\t\u0006ဉ\u0000", new Object[]{"bitField0_", "dataVersion_", "data_", "placementId_", "impressionOpportunityId_", "loadTimestamp_", "showTimestamp_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Campaign> parser = PARSER;
                    if (parser == null) {
                        synchronized (Campaign.class) {
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
            Campaign campaign = new Campaign();
            DEFAULT_INSTANCE = campaign;
            GeneratedMessageLite.registerDefaultInstance(Campaign.class, campaign);
        }

        public static Parser<Campaign> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: gateway.v1.CampaignStateOuterClass$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: gateway.v1.CampaignStateOuterClass.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class CampaignState extends GeneratedMessageLite<CampaignState, Builder> implements CampaignStateOrBuilder {
        /* access modifiers changed from: private */
        public static final CampaignState DEFAULT_INSTANCE;
        public static final int LOADED_CAMPAIGNS_FIELD_NUMBER = 1;
        private static volatile Parser<CampaignState> PARSER = null;
        public static final int SHOWN_CAMPAIGNS_FIELD_NUMBER = 2;
        private Internal.ProtobufList<Campaign> loadedCampaigns_ = emptyProtobufList();
        private Internal.ProtobufList<Campaign> shownCampaigns_ = emptyProtobufList();

        public static CampaignState getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public List<Campaign> getLoadedCampaignsList() {
            return this.loadedCampaigns_;
        }

        public List<? extends CampaignOrBuilder> getLoadedCampaignsOrBuilderList() {
            return this.loadedCampaigns_;
        }

        public List<Campaign> getShownCampaignsList() {
            return this.shownCampaigns_;
        }

        public List<? extends CampaignOrBuilder> getShownCampaignsOrBuilderList() {
            return this.shownCampaigns_;
        }

        private CampaignState() {
        }

        public int getLoadedCampaignsCount() {
            return this.loadedCampaigns_.size();
        }

        public Campaign getLoadedCampaigns(int i) {
            return (Campaign) this.loadedCampaigns_.get(i);
        }

        public CampaignOrBuilder getLoadedCampaignsOrBuilder(int i) {
            return (CampaignOrBuilder) this.loadedCampaigns_.get(i);
        }

        private void ensureLoadedCampaignsIsMutable() {
            Internal.ProtobufList<Campaign> protobufList = this.loadedCampaigns_;
            if (!protobufList.isModifiable()) {
                this.loadedCampaigns_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
        }

        /* access modifiers changed from: private */
        public void setLoadedCampaigns(int i, Campaign campaign) {
            campaign.getClass();
            ensureLoadedCampaignsIsMutable();
            this.loadedCampaigns_.set(i, campaign);
        }

        /* access modifiers changed from: private */
        public void addLoadedCampaigns(Campaign campaign) {
            campaign.getClass();
            ensureLoadedCampaignsIsMutable();
            this.loadedCampaigns_.add(campaign);
        }

        /* access modifiers changed from: private */
        public void addLoadedCampaigns(int i, Campaign campaign) {
            campaign.getClass();
            ensureLoadedCampaignsIsMutable();
            this.loadedCampaigns_.add(i, campaign);
        }

        /* access modifiers changed from: private */
        public void addAllLoadedCampaigns(Iterable<? extends Campaign> iterable) {
            ensureLoadedCampaignsIsMutable();
            AbstractMessageLite.addAll(iterable, this.loadedCampaigns_);
        }

        /* access modifiers changed from: private */
        public void clearLoadedCampaigns() {
            this.loadedCampaigns_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeLoadedCampaigns(int i) {
            ensureLoadedCampaignsIsMutable();
            this.loadedCampaigns_.remove(i);
        }

        public int getShownCampaignsCount() {
            return this.shownCampaigns_.size();
        }

        public Campaign getShownCampaigns(int i) {
            return (Campaign) this.shownCampaigns_.get(i);
        }

        public CampaignOrBuilder getShownCampaignsOrBuilder(int i) {
            return (CampaignOrBuilder) this.shownCampaigns_.get(i);
        }

        private void ensureShownCampaignsIsMutable() {
            Internal.ProtobufList<Campaign> protobufList = this.shownCampaigns_;
            if (!protobufList.isModifiable()) {
                this.shownCampaigns_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
        }

        /* access modifiers changed from: private */
        public void setShownCampaigns(int i, Campaign campaign) {
            campaign.getClass();
            ensureShownCampaignsIsMutable();
            this.shownCampaigns_.set(i, campaign);
        }

        /* access modifiers changed from: private */
        public void addShownCampaigns(Campaign campaign) {
            campaign.getClass();
            ensureShownCampaignsIsMutable();
            this.shownCampaigns_.add(campaign);
        }

        /* access modifiers changed from: private */
        public void addShownCampaigns(int i, Campaign campaign) {
            campaign.getClass();
            ensureShownCampaignsIsMutable();
            this.shownCampaigns_.add(i, campaign);
        }

        /* access modifiers changed from: private */
        public void addAllShownCampaigns(Iterable<? extends Campaign> iterable) {
            ensureShownCampaignsIsMutable();
            AbstractMessageLite.addAll(iterable, this.shownCampaigns_);
        }

        /* access modifiers changed from: private */
        public void clearShownCampaigns() {
            this.shownCampaigns_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeShownCampaigns(int i) {
            ensureShownCampaignsIsMutable();
            this.shownCampaigns_.remove(i);
        }

        public static CampaignState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CampaignState parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CampaignState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CampaignState parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CampaignState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CampaignState parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CampaignState parseFrom(InputStream inputStream) throws IOException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CampaignState parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CampaignState parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CampaignState) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CampaignState parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CampaignState) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CampaignState parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CampaignState parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(CampaignState campaignState) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(campaignState);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<CampaignState, Builder> implements CampaignStateOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(CampaignState.DEFAULT_INSTANCE);
            }

            public List<Campaign> getLoadedCampaignsList() {
                return Collections.unmodifiableList(((CampaignState) this.instance).getLoadedCampaignsList());
            }

            public int getLoadedCampaignsCount() {
                return ((CampaignState) this.instance).getLoadedCampaignsCount();
            }

            public Campaign getLoadedCampaigns(int i) {
                return ((CampaignState) this.instance).getLoadedCampaigns(i);
            }

            public Builder setLoadedCampaigns(int i, Campaign campaign) {
                copyOnWrite();
                ((CampaignState) this.instance).setLoadedCampaigns(i, campaign);
                return this;
            }

            public Builder setLoadedCampaigns(int i, Campaign.Builder builder) {
                copyOnWrite();
                ((CampaignState) this.instance).setLoadedCampaigns(i, (Campaign) builder.build());
                return this;
            }

            public Builder addLoadedCampaigns(Campaign campaign) {
                copyOnWrite();
                ((CampaignState) this.instance).addLoadedCampaigns(campaign);
                return this;
            }

            public Builder addLoadedCampaigns(int i, Campaign campaign) {
                copyOnWrite();
                ((CampaignState) this.instance).addLoadedCampaigns(i, campaign);
                return this;
            }

            public Builder addLoadedCampaigns(Campaign.Builder builder) {
                copyOnWrite();
                ((CampaignState) this.instance).addLoadedCampaigns((Campaign) builder.build());
                return this;
            }

            public Builder addLoadedCampaigns(int i, Campaign.Builder builder) {
                copyOnWrite();
                ((CampaignState) this.instance).addLoadedCampaigns(i, (Campaign) builder.build());
                return this;
            }

            public Builder addAllLoadedCampaigns(Iterable<? extends Campaign> iterable) {
                copyOnWrite();
                ((CampaignState) this.instance).addAllLoadedCampaigns(iterable);
                return this;
            }

            public Builder clearLoadedCampaigns() {
                copyOnWrite();
                ((CampaignState) this.instance).clearLoadedCampaigns();
                return this;
            }

            public Builder removeLoadedCampaigns(int i) {
                copyOnWrite();
                ((CampaignState) this.instance).removeLoadedCampaigns(i);
                return this;
            }

            public List<Campaign> getShownCampaignsList() {
                return Collections.unmodifiableList(((CampaignState) this.instance).getShownCampaignsList());
            }

            public int getShownCampaignsCount() {
                return ((CampaignState) this.instance).getShownCampaignsCount();
            }

            public Campaign getShownCampaigns(int i) {
                return ((CampaignState) this.instance).getShownCampaigns(i);
            }

            public Builder setShownCampaigns(int i, Campaign campaign) {
                copyOnWrite();
                ((CampaignState) this.instance).setShownCampaigns(i, campaign);
                return this;
            }

            public Builder setShownCampaigns(int i, Campaign.Builder builder) {
                copyOnWrite();
                ((CampaignState) this.instance).setShownCampaigns(i, (Campaign) builder.build());
                return this;
            }

            public Builder addShownCampaigns(Campaign campaign) {
                copyOnWrite();
                ((CampaignState) this.instance).addShownCampaigns(campaign);
                return this;
            }

            public Builder addShownCampaigns(int i, Campaign campaign) {
                copyOnWrite();
                ((CampaignState) this.instance).addShownCampaigns(i, campaign);
                return this;
            }

            public Builder addShownCampaigns(Campaign.Builder builder) {
                copyOnWrite();
                ((CampaignState) this.instance).addShownCampaigns((Campaign) builder.build());
                return this;
            }

            public Builder addShownCampaigns(int i, Campaign.Builder builder) {
                copyOnWrite();
                ((CampaignState) this.instance).addShownCampaigns(i, (Campaign) builder.build());
                return this;
            }

            public Builder addAllShownCampaigns(Iterable<? extends Campaign> iterable) {
                copyOnWrite();
                ((CampaignState) this.instance).addAllShownCampaigns(iterable);
                return this;
            }

            public Builder clearShownCampaigns() {
                copyOnWrite();
                ((CampaignState) this.instance).clearShownCampaigns();
                return this;
            }

            public Builder removeShownCampaigns(int i) {
                copyOnWrite();
                ((CampaignState) this.instance).removeShownCampaigns(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CampaignState();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"loadedCampaigns_", Campaign.class, "shownCampaigns_", Campaign.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CampaignState> parser = PARSER;
                    if (parser == null) {
                        synchronized (CampaignState.class) {
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
            CampaignState campaignState = new CampaignState();
            DEFAULT_INSTANCE = campaignState;
            GeneratedMessageLite.registerDefaultInstance(CampaignState.class, campaignState);
        }

        public static Parser<CampaignState> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
