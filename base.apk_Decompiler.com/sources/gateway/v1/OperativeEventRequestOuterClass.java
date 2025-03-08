package gateway.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import gateway.v1.CampaignStateOuterClass;
import gateway.v1.DynamicDeviceInfoOuterClass;
import gateway.v1.SessionCountersOuterClass;
import gateway.v1.StaticDeviceInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class OperativeEventRequestOuterClass {

    public interface OperativeEventErrorDataOrBuilder extends MessageLiteOrBuilder {
        OperativeEventErrorType getErrorType();

        int getErrorTypeValue();

        String getMessage();

        ByteString getMessageBytes();
    }

    public interface OperativeEventRequestOrBuilder extends MessageLiteOrBuilder {
        ByteString getAdditionalData();

        CampaignStateOuterClass.CampaignState getCampaignState();

        DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo();

        ByteString getEventId();

        OperativeEventType getEventType();

        int getEventTypeValue();

        ByteString getImpressionOpportunityId();

        SessionCountersOuterClass.SessionCounters getSessionCounters();

        String getSid();

        ByteString getSidBytes();

        StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo();

        ByteString getTrackingToken();

        boolean hasCampaignState();

        boolean hasDynamicDeviceInfo();

        boolean hasSessionCounters();

        boolean hasStaticDeviceInfo();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private OperativeEventRequestOuterClass() {
    }

    public enum OperativeEventType implements Internal.EnumLite {
        OPERATIVE_EVENT_TYPE_UNSPECIFIED(0),
        OPERATIVE_EVENT_TYPE_SPECIFIED_BY_AD_PLAYER(1),
        OPERATIVE_EVENT_TYPE_LOAD_ERROR(2),
        OPERATIVE_EVENT_TYPE_SHOW_ERROR(3),
        UNRECOGNIZED(-1);
        
        public static final int OPERATIVE_EVENT_TYPE_LOAD_ERROR_VALUE = 2;
        public static final int OPERATIVE_EVENT_TYPE_SHOW_ERROR_VALUE = 3;
        public static final int OPERATIVE_EVENT_TYPE_SPECIFIED_BY_AD_PLAYER_VALUE = 1;
        public static final int OPERATIVE_EVENT_TYPE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<OperativeEventType> internalValueMap = null;
        private final int value;

        public static OperativeEventType forNumber(int i) {
            if (i == 0) {
                return OPERATIVE_EVENT_TYPE_UNSPECIFIED;
            }
            if (i == 1) {
                return OPERATIVE_EVENT_TYPE_SPECIFIED_BY_AD_PLAYER;
            }
            if (i == 2) {
                return OPERATIVE_EVENT_TYPE_LOAD_ERROR;
            }
            if (i != 3) {
                return null;
            }
            return OPERATIVE_EVENT_TYPE_SHOW_ERROR;
        }

        public static Internal.EnumLiteMap<OperativeEventType> internalGetValueMap() {
            return internalValueMap;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<OperativeEventType>() {
                public OperativeEventType findValueByNumber(int i) {
                    return OperativeEventType.forNumber(i);
                }
            };
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static OperativeEventType valueOf(int i) {
            return forNumber(i);
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return OperativeEventTypeVerifier.INSTANCE;
        }

        private static final class OperativeEventTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            private OperativeEventTypeVerifier() {
            }

            static {
                INSTANCE = new OperativeEventTypeVerifier();
            }

            public boolean isInRange(int i) {
                return OperativeEventType.forNumber(i) != null;
            }
        }

        private OperativeEventType(int i) {
            this.value = i;
        }
    }

    public enum OperativeEventErrorType implements Internal.EnumLite {
        OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED(0),
        OPERATIVE_EVENT_ERROR_TYPE_TIMEOUT(1),
        UNRECOGNIZED(-1);
        
        public static final int OPERATIVE_EVENT_ERROR_TYPE_TIMEOUT_VALUE = 1;
        public static final int OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<OperativeEventErrorType> internalValueMap = null;
        private final int value;

        public static OperativeEventErrorType forNumber(int i) {
            if (i == 0) {
                return OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED;
            }
            if (i != 1) {
                return null;
            }
            return OPERATIVE_EVENT_ERROR_TYPE_TIMEOUT;
        }

        public static Internal.EnumLiteMap<OperativeEventErrorType> internalGetValueMap() {
            return internalValueMap;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<OperativeEventErrorType>() {
                public OperativeEventErrorType findValueByNumber(int i) {
                    return OperativeEventErrorType.forNumber(i);
                }
            };
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static OperativeEventErrorType valueOf(int i) {
            return forNumber(i);
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return OperativeEventErrorTypeVerifier.INSTANCE;
        }

        private static final class OperativeEventErrorTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            private OperativeEventErrorTypeVerifier() {
            }

            static {
                INSTANCE = new OperativeEventErrorTypeVerifier();
            }

            public boolean isInRange(int i) {
                return OperativeEventErrorType.forNumber(i) != null;
            }
        }

        private OperativeEventErrorType(int i) {
            this.value = i;
        }
    }

    public static final class OperativeEventErrorData extends GeneratedMessageLite<OperativeEventErrorData, Builder> implements OperativeEventErrorDataOrBuilder {
        /* access modifiers changed from: private */
        public static final OperativeEventErrorData DEFAULT_INSTANCE;
        public static final int ERROR_TYPE_FIELD_NUMBER = 1;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private static volatile Parser<OperativeEventErrorData> PARSER;
        private int errorType_;
        private String message_ = "";

        /* access modifiers changed from: private */
        public void clearErrorType() {
            this.errorType_ = 0;
        }

        public static OperativeEventErrorData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void setErrorTypeValue(int i) {
            this.errorType_ = i;
        }

        public int getErrorTypeValue() {
            return this.errorType_;
        }

        public String getMessage() {
            return this.message_;
        }

        private OperativeEventErrorData() {
        }

        public OperativeEventErrorType getErrorType() {
            OperativeEventErrorType forNumber = OperativeEventErrorType.forNumber(this.errorType_);
            return forNumber == null ? OperativeEventErrorType.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setErrorType(OperativeEventErrorType operativeEventErrorType) {
            this.errorType_ = operativeEventErrorType.getNumber();
        }

        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        /* access modifiers changed from: private */
        public void setMessage(String str) {
            str.getClass();
            this.message_ = str;
        }

        /* access modifiers changed from: private */
        public void clearMessage() {
            this.message_ = getDefaultInstance().getMessage();
        }

        /* access modifiers changed from: private */
        public void setMessageBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.message_ = byteString.toStringUtf8();
        }

        public static OperativeEventErrorData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static OperativeEventErrorData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static OperativeEventErrorData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static OperativeEventErrorData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OperativeEventErrorData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static OperativeEventErrorData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OperativeEventErrorData parseFrom(InputStream inputStream) throws IOException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OperativeEventErrorData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OperativeEventErrorData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OperativeEventErrorData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OperativeEventErrorData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OperativeEventErrorData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OperativeEventErrorData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OperativeEventErrorData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OperativeEventErrorData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(OperativeEventErrorData operativeEventErrorData) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(operativeEventErrorData);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<OperativeEventErrorData, Builder> implements OperativeEventErrorDataOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(OperativeEventErrorData.DEFAULT_INSTANCE);
            }

            public int getErrorTypeValue() {
                return ((OperativeEventErrorData) this.instance).getErrorTypeValue();
            }

            public Builder setErrorTypeValue(int i) {
                copyOnWrite();
                ((OperativeEventErrorData) this.instance).setErrorTypeValue(i);
                return this;
            }

            public OperativeEventErrorType getErrorType() {
                return ((OperativeEventErrorData) this.instance).getErrorType();
            }

            public Builder setErrorType(OperativeEventErrorType operativeEventErrorType) {
                copyOnWrite();
                ((OperativeEventErrorData) this.instance).setErrorType(operativeEventErrorType);
                return this;
            }

            public Builder clearErrorType() {
                copyOnWrite();
                ((OperativeEventErrorData) this.instance).clearErrorType();
                return this;
            }

            public String getMessage() {
                return ((OperativeEventErrorData) this.instance).getMessage();
            }

            public ByteString getMessageBytes() {
                return ((OperativeEventErrorData) this.instance).getMessageBytes();
            }

            public Builder setMessage(String str) {
                copyOnWrite();
                ((OperativeEventErrorData) this.instance).setMessage(str);
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((OperativeEventErrorData) this.instance).clearMessage();
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) {
                copyOnWrite();
                ((OperativeEventErrorData) this.instance).setMessageBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new OperativeEventErrorData();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002Ȉ", new Object[]{"errorType_", "message_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OperativeEventErrorData> parser = PARSER;
                    if (parser == null) {
                        synchronized (OperativeEventErrorData.class) {
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
            OperativeEventErrorData operativeEventErrorData = new OperativeEventErrorData();
            DEFAULT_INSTANCE = operativeEventErrorData;
            GeneratedMessageLite.registerDefaultInstance(OperativeEventErrorData.class, operativeEventErrorData);
        }

        public static Parser<OperativeEventErrorData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: gateway.v1.OperativeEventRequestOuterClass$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: gateway.v1.OperativeEventRequestOuterClass.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class OperativeEventRequest extends GeneratedMessageLite<OperativeEventRequest, Builder> implements OperativeEventRequestOrBuilder {
        public static final int ADDITIONAL_DATA_FIELD_NUMBER = 5;
        public static final int CAMPAIGN_STATE_FIELD_NUMBER = 10;
        /* access modifiers changed from: private */
        public static final OperativeEventRequest DEFAULT_INSTANCE;
        public static final int DYNAMIC_DEVICE_INFO_FIELD_NUMBER = 9;
        public static final int EVENT_ID_FIELD_NUMBER = 1;
        public static final int EVENT_TYPE_FIELD_NUMBER = 2;
        public static final int IMPRESSION_OPPORTUNITY_ID_FIELD_NUMBER = 3;
        private static volatile Parser<OperativeEventRequest> PARSER = null;
        public static final int SESSION_COUNTERS_FIELD_NUMBER = 7;
        public static final int SID_FIELD_NUMBER = 6;
        public static final int STATIC_DEVICE_INFO_FIELD_NUMBER = 8;
        public static final int TRACKING_TOKEN_FIELD_NUMBER = 4;
        private ByteString additionalData_ = ByteString.EMPTY;
        private CampaignStateOuterClass.CampaignState campaignState_;
        private DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo_;
        private ByteString eventId_ = ByteString.EMPTY;
        private int eventType_;
        private ByteString impressionOpportunityId_ = ByteString.EMPTY;
        private SessionCountersOuterClass.SessionCounters sessionCounters_;
        private String sid_ = "";
        private StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo_;
        private ByteString trackingToken_ = ByteString.EMPTY;

        /* access modifiers changed from: private */
        public void clearCampaignState() {
            this.campaignState_ = null;
        }

        /* access modifiers changed from: private */
        public void clearDynamicDeviceInfo() {
            this.dynamicDeviceInfo_ = null;
        }

        /* access modifiers changed from: private */
        public void clearEventType() {
            this.eventType_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearSessionCounters() {
            this.sessionCounters_ = null;
        }

        /* access modifiers changed from: private */
        public void clearStaticDeviceInfo() {
            this.staticDeviceInfo_ = null;
        }

        public static OperativeEventRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void setEventTypeValue(int i) {
            this.eventType_ = i;
        }

        public ByteString getAdditionalData() {
            return this.additionalData_;
        }

        public ByteString getEventId() {
            return this.eventId_;
        }

        public int getEventTypeValue() {
            return this.eventType_;
        }

        public ByteString getImpressionOpportunityId() {
            return this.impressionOpportunityId_;
        }

        public String getSid() {
            return this.sid_;
        }

        public ByteString getTrackingToken() {
            return this.trackingToken_;
        }

        public boolean hasCampaignState() {
            return this.campaignState_ != null;
        }

        public boolean hasDynamicDeviceInfo() {
            return this.dynamicDeviceInfo_ != null;
        }

        public boolean hasSessionCounters() {
            return this.sessionCounters_ != null;
        }

        public boolean hasStaticDeviceInfo() {
            return this.staticDeviceInfo_ != null;
        }

        private OperativeEventRequest() {
        }

        /* access modifiers changed from: private */
        public void setEventId(ByteString byteString) {
            byteString.getClass();
            this.eventId_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearEventId() {
            this.eventId_ = getDefaultInstance().getEventId();
        }

        public OperativeEventType getEventType() {
            OperativeEventType forNumber = OperativeEventType.forNumber(this.eventType_);
            return forNumber == null ? OperativeEventType.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setEventType(OperativeEventType operativeEventType) {
            this.eventType_ = operativeEventType.getNumber();
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

        /* access modifiers changed from: private */
        public void setTrackingToken(ByteString byteString) {
            byteString.getClass();
            this.trackingToken_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearTrackingToken() {
            this.trackingToken_ = getDefaultInstance().getTrackingToken();
        }

        /* access modifiers changed from: private */
        public void setAdditionalData(ByteString byteString) {
            byteString.getClass();
            this.additionalData_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearAdditionalData() {
            this.additionalData_ = getDefaultInstance().getAdditionalData();
        }

        public ByteString getSidBytes() {
            return ByteString.copyFromUtf8(this.sid_);
        }

        /* access modifiers changed from: private */
        public void setSid(String str) {
            str.getClass();
            this.sid_ = str;
        }

        /* access modifiers changed from: private */
        public void clearSid() {
            this.sid_ = getDefaultInstance().getSid();
        }

        /* access modifiers changed from: private */
        public void setSidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sid_ = byteString.toStringUtf8();
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

        public static OperativeEventRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static OperativeEventRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static OperativeEventRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static OperativeEventRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OperativeEventRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static OperativeEventRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OperativeEventRequest parseFrom(InputStream inputStream) throws IOException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OperativeEventRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OperativeEventRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OperativeEventRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OperativeEventRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OperativeEventRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OperativeEventRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OperativeEventRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OperativeEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(OperativeEventRequest operativeEventRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(operativeEventRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<OperativeEventRequest, Builder> implements OperativeEventRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(OperativeEventRequest.DEFAULT_INSTANCE);
            }

            public ByteString getEventId() {
                return ((OperativeEventRequest) this.instance).getEventId();
            }

            public Builder setEventId(ByteString byteString) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setEventId(byteString);
                return this;
            }

            public Builder clearEventId() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearEventId();
                return this;
            }

            public int getEventTypeValue() {
                return ((OperativeEventRequest) this.instance).getEventTypeValue();
            }

            public Builder setEventTypeValue(int i) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setEventTypeValue(i);
                return this;
            }

            public OperativeEventType getEventType() {
                return ((OperativeEventRequest) this.instance).getEventType();
            }

            public Builder setEventType(OperativeEventType operativeEventType) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setEventType(operativeEventType);
                return this;
            }

            public Builder clearEventType() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearEventType();
                return this;
            }

            public ByteString getImpressionOpportunityId() {
                return ((OperativeEventRequest) this.instance).getImpressionOpportunityId();
            }

            public Builder setImpressionOpportunityId(ByteString byteString) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setImpressionOpportunityId(byteString);
                return this;
            }

            public Builder clearImpressionOpportunityId() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearImpressionOpportunityId();
                return this;
            }

            public ByteString getTrackingToken() {
                return ((OperativeEventRequest) this.instance).getTrackingToken();
            }

            public Builder setTrackingToken(ByteString byteString) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setTrackingToken(byteString);
                return this;
            }

            public Builder clearTrackingToken() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearTrackingToken();
                return this;
            }

            public ByteString getAdditionalData() {
                return ((OperativeEventRequest) this.instance).getAdditionalData();
            }

            public Builder setAdditionalData(ByteString byteString) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setAdditionalData(byteString);
                return this;
            }

            public Builder clearAdditionalData() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearAdditionalData();
                return this;
            }

            public String getSid() {
                return ((OperativeEventRequest) this.instance).getSid();
            }

            public ByteString getSidBytes() {
                return ((OperativeEventRequest) this.instance).getSidBytes();
            }

            public Builder setSid(String str) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setSid(str);
                return this;
            }

            public Builder clearSid() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearSid();
                return this;
            }

            public Builder setSidBytes(ByteString byteString) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setSidBytes(byteString);
                return this;
            }

            public boolean hasSessionCounters() {
                return ((OperativeEventRequest) this.instance).hasSessionCounters();
            }

            public SessionCountersOuterClass.SessionCounters getSessionCounters() {
                return ((OperativeEventRequest) this.instance).getSessionCounters();
            }

            public Builder setSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setSessionCounters(sessionCounters);
                return this;
            }

            public Builder setSessionCounters(SessionCountersOuterClass.SessionCounters.Builder builder) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setSessionCounters((SessionCountersOuterClass.SessionCounters) builder.build());
                return this;
            }

            public Builder mergeSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).mergeSessionCounters(sessionCounters);
                return this;
            }

            public Builder clearSessionCounters() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearSessionCounters();
                return this;
            }

            public boolean hasStaticDeviceInfo() {
                return ((OperativeEventRequest) this.instance).hasStaticDeviceInfo();
            }

            public StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo() {
                return ((OperativeEventRequest) this.instance).getStaticDeviceInfo();
            }

            public Builder setStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setStaticDeviceInfo(staticDeviceInfo);
                return this;
            }

            public Builder setStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder builder) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) builder.build());
                return this;
            }

            public Builder mergeStaticDeviceInfo(StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).mergeStaticDeviceInfo(staticDeviceInfo);
                return this;
            }

            public Builder clearStaticDeviceInfo() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearStaticDeviceInfo();
                return this;
            }

            public boolean hasDynamicDeviceInfo() {
                return ((OperativeEventRequest) this.instance).hasDynamicDeviceInfo();
            }

            public DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
                return ((OperativeEventRequest) this.instance).getDynamicDeviceInfo();
            }

            public Builder setDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setDynamicDeviceInfo(dynamicDeviceInfo);
                return this;
            }

            public Builder setDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo.Builder builder) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setDynamicDeviceInfo((DynamicDeviceInfoOuterClass.DynamicDeviceInfo) builder.build());
                return this;
            }

            public Builder mergeDynamicDeviceInfo(DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).mergeDynamicDeviceInfo(dynamicDeviceInfo);
                return this;
            }

            public Builder clearDynamicDeviceInfo() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearDynamicDeviceInfo();
                return this;
            }

            public boolean hasCampaignState() {
                return ((OperativeEventRequest) this.instance).hasCampaignState();
            }

            public CampaignStateOuterClass.CampaignState getCampaignState() {
                return ((OperativeEventRequest) this.instance).getCampaignState();
            }

            public Builder setCampaignState(CampaignStateOuterClass.CampaignState campaignState) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setCampaignState(campaignState);
                return this;
            }

            public Builder setCampaignState(CampaignStateOuterClass.CampaignState.Builder builder) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).setCampaignState((CampaignStateOuterClass.CampaignState) builder.build());
                return this;
            }

            public Builder mergeCampaignState(CampaignStateOuterClass.CampaignState campaignState) {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).mergeCampaignState(campaignState);
                return this;
            }

            public Builder clearCampaignState() {
                copyOnWrite();
                ((OperativeEventRequest) this.instance).clearCampaignState();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new OperativeEventRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0000\u0000\u0000\u0001\n\u0002\f\u0003\n\u0004\n\u0005\n\u0006Ȉ\u0007\t\b\t\t\t\n\t", new Object[]{"eventId_", "eventType_", "impressionOpportunityId_", "trackingToken_", "additionalData_", "sid_", "sessionCounters_", "staticDeviceInfo_", "dynamicDeviceInfo_", "campaignState_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OperativeEventRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (OperativeEventRequest.class) {
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
            OperativeEventRequest operativeEventRequest = new OperativeEventRequest();
            DEFAULT_INSTANCE = operativeEventRequest;
            GeneratedMessageLite.registerDefaultInstance(OperativeEventRequest.class, operativeEventRequest);
        }

        public static Parser<OperativeEventRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
