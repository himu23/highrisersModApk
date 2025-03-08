package gateway.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import gateway.v1.AdDataRefreshRequestOuterClass;
import gateway.v1.AdPlayerConfigRequestOuterClass;
import gateway.v1.AdRequestOuterClass;
import gateway.v1.DeveloperConsentOuterClass;
import gateway.v1.DiagnosticEventRequestOuterClass;
import gateway.v1.GetTokenEventRequestOuterClass;
import gateway.v1.InitializationCompletedEventRequestOuterClass;
import gateway.v1.InitializationRequestOuterClass;
import gateway.v1.OperativeEventRequestOuterClass;
import gateway.v1.PiiOuterClass;
import gateway.v1.PrivacyUpdateRequestOuterClass;
import gateway.v1.TestDataOuterClass;
import gateway.v1.TimestampsOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class UniversalRequestOuterClass {

    public interface UniversalRequestOrBuilder extends MessageLiteOrBuilder {
        UniversalRequest.Payload getPayload();

        UniversalRequest.SharedData getSharedData();

        boolean hasPayload();

        boolean hasSharedData();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private UniversalRequestOuterClass() {
    }

    public static final class UniversalRequest extends GeneratedMessageLite<UniversalRequest, Builder> implements UniversalRequestOrBuilder {
        /* access modifiers changed from: private */
        public static final UniversalRequest DEFAULT_INSTANCE;
        private static volatile Parser<UniversalRequest> PARSER = null;
        public static final int PAYLOAD_FIELD_NUMBER = 2;
        public static final int SHARED_DATA_FIELD_NUMBER = 1;
        private Payload payload_;
        private SharedData sharedData_;

        public interface PayloadOrBuilder extends MessageLiteOrBuilder {
            AdDataRefreshRequestOuterClass.AdDataRefreshRequest getAdDataRefreshRequest();

            AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest getAdPlayerConfigRequest();

            AdRequestOuterClass.AdRequest getAdRequest();

            DiagnosticEventRequestOuterClass.DiagnosticEventRequest getDiagnosticEventRequest();

            GetTokenEventRequestOuterClass.GetTokenEventRequest getGetTokenEventRequest();

            InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest getInitializationCompletedEventRequest();

            InitializationRequestOuterClass.InitializationRequest getInitializationRequest();

            OperativeEventRequestOuterClass.OperativeEventRequest getOperativeEvent();

            PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest getPrivacyUpdateRequest();

            Payload.ValueCase getValueCase();

            boolean hasAdDataRefreshRequest();

            boolean hasAdPlayerConfigRequest();

            boolean hasAdRequest();

            boolean hasDiagnosticEventRequest();

            boolean hasGetTokenEventRequest();

            boolean hasInitializationCompletedEventRequest();

            boolean hasInitializationRequest();

            boolean hasOperativeEvent();

            boolean hasPrivacyUpdateRequest();
        }

        public interface SharedDataOrBuilder extends MessageLiteOrBuilder {
            Timestamp getAppStartTime();

            ByteString getCurrentState();

            DeveloperConsentOuterClass.DeveloperConsent getDeveloperConsent();

            PiiOuterClass.Pii getPii();

            Timestamp getSdkStartTime();

            ByteString getSessionToken();

            TestDataOuterClass.TestData getTestData();

            TimestampsOuterClass.Timestamps getTimestamps();

            int getWebviewVersion();

            boolean hasAppStartTime();

            boolean hasCurrentState();

            boolean hasDeveloperConsent();

            boolean hasPii();

            boolean hasSdkStartTime();

            boolean hasSessionToken();

            boolean hasTestData();

            boolean hasTimestamps();

            boolean hasWebviewVersion();
        }

        /* access modifiers changed from: private */
        public void clearPayload() {
            this.payload_ = null;
        }

        /* access modifiers changed from: private */
        public void clearSharedData() {
            this.sharedData_ = null;
        }

        public static UniversalRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public boolean hasPayload() {
            return this.payload_ != null;
        }

        public boolean hasSharedData() {
            return this.sharedData_ != null;
        }

        private UniversalRequest() {
        }

        public static final class SharedData extends GeneratedMessageLite<SharedData, Builder> implements SharedDataOrBuilder {
            public static final int APP_START_TIME_FIELD_NUMBER = 8;
            public static final int CURRENT_STATE_FIELD_NUMBER = 6;
            /* access modifiers changed from: private */
            public static final SharedData DEFAULT_INSTANCE;
            public static final int DEVELOPER_CONSENT_FIELD_NUMBER = 4;
            private static volatile Parser<SharedData> PARSER = null;
            public static final int PII_FIELD_NUMBER = 3;
            public static final int SDK_START_TIME_FIELD_NUMBER = 9;
            public static final int SESSION_TOKEN_FIELD_NUMBER = 1;
            public static final int TEST_DATA_FIELD_NUMBER = 7;
            public static final int TIMESTAMPS_FIELD_NUMBER = 2;
            public static final int WEBVIEW_VERSION_FIELD_NUMBER = 5;
            private Timestamp appStartTime_;
            private int bitField0_;
            private ByteString currentState_ = ByteString.EMPTY;
            private DeveloperConsentOuterClass.DeveloperConsent developerConsent_;
            private PiiOuterClass.Pii pii_;
            private Timestamp sdkStartTime_;
            private ByteString sessionToken_ = ByteString.EMPTY;
            private TestDataOuterClass.TestData testData_;
            private TimestampsOuterClass.Timestamps timestamps_;
            private int webviewVersion_;

            /* access modifiers changed from: private */
            public void clearAppStartTime() {
                this.appStartTime_ = null;
            }

            /* access modifiers changed from: private */
            public void clearDeveloperConsent() {
                this.developerConsent_ = null;
                this.bitField0_ &= -5;
            }

            /* access modifiers changed from: private */
            public void clearPii() {
                this.pii_ = null;
                this.bitField0_ &= -3;
            }

            /* access modifiers changed from: private */
            public void clearSdkStartTime() {
                this.sdkStartTime_ = null;
            }

            /* access modifiers changed from: private */
            public void clearTestData() {
                this.testData_ = null;
                this.bitField0_ &= -33;
            }

            /* access modifiers changed from: private */
            public void clearTimestamps() {
                this.timestamps_ = null;
            }

            /* access modifiers changed from: private */
            public void clearWebviewVersion() {
                this.bitField0_ &= -9;
                this.webviewVersion_ = 0;
            }

            public static SharedData getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* access modifiers changed from: private */
            public void setWebviewVersion(int i) {
                this.bitField0_ |= 8;
                this.webviewVersion_ = i;
            }

            public ByteString getCurrentState() {
                return this.currentState_;
            }

            public ByteString getSessionToken() {
                return this.sessionToken_;
            }

            public int getWebviewVersion() {
                return this.webviewVersion_;
            }

            public boolean hasAppStartTime() {
                return this.appStartTime_ != null;
            }

            public boolean hasCurrentState() {
                return (this.bitField0_ & 16) != 0;
            }

            public boolean hasDeveloperConsent() {
                return (this.bitField0_ & 4) != 0;
            }

            public boolean hasPii() {
                return (this.bitField0_ & 2) != 0;
            }

            public boolean hasSdkStartTime() {
                return this.sdkStartTime_ != null;
            }

            public boolean hasSessionToken() {
                return (this.bitField0_ & 1) != 0;
            }

            public boolean hasTestData() {
                return (this.bitField0_ & 32) != 0;
            }

            public boolean hasTimestamps() {
                return this.timestamps_ != null;
            }

            public boolean hasWebviewVersion() {
                return (this.bitField0_ & 8) != 0;
            }

            private SharedData() {
            }

            /* access modifiers changed from: private */
            public void setSessionToken(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 1;
                this.sessionToken_ = byteString;
            }

            /* access modifiers changed from: private */
            public void clearSessionToken() {
                this.bitField0_ &= -2;
                this.sessionToken_ = getDefaultInstance().getSessionToken();
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

            public PiiOuterClass.Pii getPii() {
                PiiOuterClass.Pii pii = this.pii_;
                return pii == null ? PiiOuterClass.Pii.getDefaultInstance() : pii;
            }

            /* access modifiers changed from: private */
            public void setPii(PiiOuterClass.Pii pii) {
                pii.getClass();
                this.pii_ = pii;
                this.bitField0_ |= 2;
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
                this.bitField0_ |= 2;
            }

            public DeveloperConsentOuterClass.DeveloperConsent getDeveloperConsent() {
                DeveloperConsentOuterClass.DeveloperConsent developerConsent = this.developerConsent_;
                return developerConsent == null ? DeveloperConsentOuterClass.DeveloperConsent.getDefaultInstance() : developerConsent;
            }

            /* access modifiers changed from: private */
            public void setDeveloperConsent(DeveloperConsentOuterClass.DeveloperConsent developerConsent) {
                developerConsent.getClass();
                this.developerConsent_ = developerConsent;
                this.bitField0_ |= 4;
            }

            /* access modifiers changed from: private */
            public void mergeDeveloperConsent(DeveloperConsentOuterClass.DeveloperConsent developerConsent) {
                developerConsent.getClass();
                DeveloperConsentOuterClass.DeveloperConsent developerConsent2 = this.developerConsent_;
                if (developerConsent2 == null || developerConsent2 == DeveloperConsentOuterClass.DeveloperConsent.getDefaultInstance()) {
                    this.developerConsent_ = developerConsent;
                } else {
                    this.developerConsent_ = (DeveloperConsentOuterClass.DeveloperConsent) ((DeveloperConsentOuterClass.DeveloperConsent.Builder) DeveloperConsentOuterClass.DeveloperConsent.newBuilder(this.developerConsent_).mergeFrom(developerConsent)).buildPartial();
                }
                this.bitField0_ |= 4;
            }

            /* access modifiers changed from: private */
            public void setCurrentState(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 16;
                this.currentState_ = byteString;
            }

            /* access modifiers changed from: private */
            public void clearCurrentState() {
                this.bitField0_ &= -17;
                this.currentState_ = getDefaultInstance().getCurrentState();
            }

            public TestDataOuterClass.TestData getTestData() {
                TestDataOuterClass.TestData testData = this.testData_;
                return testData == null ? TestDataOuterClass.TestData.getDefaultInstance() : testData;
            }

            /* access modifiers changed from: private */
            public void setTestData(TestDataOuterClass.TestData testData) {
                testData.getClass();
                this.testData_ = testData;
                this.bitField0_ |= 32;
            }

            /* access modifiers changed from: private */
            public void mergeTestData(TestDataOuterClass.TestData testData) {
                testData.getClass();
                TestDataOuterClass.TestData testData2 = this.testData_;
                if (testData2 == null || testData2 == TestDataOuterClass.TestData.getDefaultInstance()) {
                    this.testData_ = testData;
                } else {
                    this.testData_ = (TestDataOuterClass.TestData) ((TestDataOuterClass.TestData.Builder) TestDataOuterClass.TestData.newBuilder(this.testData_).mergeFrom(testData)).buildPartial();
                }
                this.bitField0_ |= 32;
            }

            public Timestamp getAppStartTime() {
                Timestamp timestamp = this.appStartTime_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }

            /* access modifiers changed from: private */
            public void setAppStartTime(Timestamp timestamp) {
                timestamp.getClass();
                this.appStartTime_ = timestamp;
            }

            /* access modifiers changed from: private */
            public void mergeAppStartTime(Timestamp timestamp) {
                timestamp.getClass();
                Timestamp timestamp2 = this.appStartTime_;
                if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
                    this.appStartTime_ = timestamp;
                } else {
                    this.appStartTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.appStartTime_).mergeFrom(timestamp)).buildPartial();
                }
            }

            public Timestamp getSdkStartTime() {
                Timestamp timestamp = this.sdkStartTime_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }

            /* access modifiers changed from: private */
            public void setSdkStartTime(Timestamp timestamp) {
                timestamp.getClass();
                this.sdkStartTime_ = timestamp;
            }

            /* access modifiers changed from: private */
            public void mergeSdkStartTime(Timestamp timestamp) {
                timestamp.getClass();
                Timestamp timestamp2 = this.sdkStartTime_;
                if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
                    this.sdkStartTime_ = timestamp;
                } else {
                    this.sdkStartTime_ = (Timestamp) ((Timestamp.Builder) Timestamp.newBuilder(this.sdkStartTime_).mergeFrom(timestamp)).buildPartial();
                }
            }

            public static SharedData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static SharedData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static SharedData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static SharedData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static SharedData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static SharedData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static SharedData parseFrom(InputStream inputStream) throws IOException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static SharedData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static SharedData parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (SharedData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static SharedData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SharedData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static SharedData parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static SharedData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SharedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(SharedData sharedData) {
                return (Builder) DEFAULT_INSTANCE.createBuilder(sharedData);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<SharedData, Builder> implements SharedDataOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 r1) {
                    this();
                }

                private Builder() {
                    super(SharedData.DEFAULT_INSTANCE);
                }

                public boolean hasSessionToken() {
                    return ((SharedData) this.instance).hasSessionToken();
                }

                public ByteString getSessionToken() {
                    return ((SharedData) this.instance).getSessionToken();
                }

                public Builder setSessionToken(ByteString byteString) {
                    copyOnWrite();
                    ((SharedData) this.instance).setSessionToken(byteString);
                    return this;
                }

                public Builder clearSessionToken() {
                    copyOnWrite();
                    ((SharedData) this.instance).clearSessionToken();
                    return this;
                }

                public boolean hasTimestamps() {
                    return ((SharedData) this.instance).hasTimestamps();
                }

                public TimestampsOuterClass.Timestamps getTimestamps() {
                    return ((SharedData) this.instance).getTimestamps();
                }

                public Builder setTimestamps(TimestampsOuterClass.Timestamps timestamps) {
                    copyOnWrite();
                    ((SharedData) this.instance).setTimestamps(timestamps);
                    return this;
                }

                public Builder setTimestamps(TimestampsOuterClass.Timestamps.Builder builder) {
                    copyOnWrite();
                    ((SharedData) this.instance).setTimestamps((TimestampsOuterClass.Timestamps) builder.build());
                    return this;
                }

                public Builder mergeTimestamps(TimestampsOuterClass.Timestamps timestamps) {
                    copyOnWrite();
                    ((SharedData) this.instance).mergeTimestamps(timestamps);
                    return this;
                }

                public Builder clearTimestamps() {
                    copyOnWrite();
                    ((SharedData) this.instance).clearTimestamps();
                    return this;
                }

                public boolean hasPii() {
                    return ((SharedData) this.instance).hasPii();
                }

                public PiiOuterClass.Pii getPii() {
                    return ((SharedData) this.instance).getPii();
                }

                public Builder setPii(PiiOuterClass.Pii pii) {
                    copyOnWrite();
                    ((SharedData) this.instance).setPii(pii);
                    return this;
                }

                public Builder setPii(PiiOuterClass.Pii.Builder builder) {
                    copyOnWrite();
                    ((SharedData) this.instance).setPii((PiiOuterClass.Pii) builder.build());
                    return this;
                }

                public Builder mergePii(PiiOuterClass.Pii pii) {
                    copyOnWrite();
                    ((SharedData) this.instance).mergePii(pii);
                    return this;
                }

                public Builder clearPii() {
                    copyOnWrite();
                    ((SharedData) this.instance).clearPii();
                    return this;
                }

                public boolean hasDeveloperConsent() {
                    return ((SharedData) this.instance).hasDeveloperConsent();
                }

                public DeveloperConsentOuterClass.DeveloperConsent getDeveloperConsent() {
                    return ((SharedData) this.instance).getDeveloperConsent();
                }

                public Builder setDeveloperConsent(DeveloperConsentOuterClass.DeveloperConsent developerConsent) {
                    copyOnWrite();
                    ((SharedData) this.instance).setDeveloperConsent(developerConsent);
                    return this;
                }

                public Builder setDeveloperConsent(DeveloperConsentOuterClass.DeveloperConsent.Builder builder) {
                    copyOnWrite();
                    ((SharedData) this.instance).setDeveloperConsent((DeveloperConsentOuterClass.DeveloperConsent) builder.build());
                    return this;
                }

                public Builder mergeDeveloperConsent(DeveloperConsentOuterClass.DeveloperConsent developerConsent) {
                    copyOnWrite();
                    ((SharedData) this.instance).mergeDeveloperConsent(developerConsent);
                    return this;
                }

                public Builder clearDeveloperConsent() {
                    copyOnWrite();
                    ((SharedData) this.instance).clearDeveloperConsent();
                    return this;
                }

                public boolean hasWebviewVersion() {
                    return ((SharedData) this.instance).hasWebviewVersion();
                }

                public int getWebviewVersion() {
                    return ((SharedData) this.instance).getWebviewVersion();
                }

                public Builder setWebviewVersion(int i) {
                    copyOnWrite();
                    ((SharedData) this.instance).setWebviewVersion(i);
                    return this;
                }

                public Builder clearWebviewVersion() {
                    copyOnWrite();
                    ((SharedData) this.instance).clearWebviewVersion();
                    return this;
                }

                public boolean hasCurrentState() {
                    return ((SharedData) this.instance).hasCurrentState();
                }

                public ByteString getCurrentState() {
                    return ((SharedData) this.instance).getCurrentState();
                }

                public Builder setCurrentState(ByteString byteString) {
                    copyOnWrite();
                    ((SharedData) this.instance).setCurrentState(byteString);
                    return this;
                }

                public Builder clearCurrentState() {
                    copyOnWrite();
                    ((SharedData) this.instance).clearCurrentState();
                    return this;
                }

                public boolean hasTestData() {
                    return ((SharedData) this.instance).hasTestData();
                }

                public TestDataOuterClass.TestData getTestData() {
                    return ((SharedData) this.instance).getTestData();
                }

                public Builder setTestData(TestDataOuterClass.TestData testData) {
                    copyOnWrite();
                    ((SharedData) this.instance).setTestData(testData);
                    return this;
                }

                public Builder setTestData(TestDataOuterClass.TestData.Builder builder) {
                    copyOnWrite();
                    ((SharedData) this.instance).setTestData((TestDataOuterClass.TestData) builder.build());
                    return this;
                }

                public Builder mergeTestData(TestDataOuterClass.TestData testData) {
                    copyOnWrite();
                    ((SharedData) this.instance).mergeTestData(testData);
                    return this;
                }

                public Builder clearTestData() {
                    copyOnWrite();
                    ((SharedData) this.instance).clearTestData();
                    return this;
                }

                public boolean hasAppStartTime() {
                    return ((SharedData) this.instance).hasAppStartTime();
                }

                public Timestamp getAppStartTime() {
                    return ((SharedData) this.instance).getAppStartTime();
                }

                public Builder setAppStartTime(Timestamp timestamp) {
                    copyOnWrite();
                    ((SharedData) this.instance).setAppStartTime(timestamp);
                    return this;
                }

                public Builder setAppStartTime(Timestamp.Builder builder) {
                    copyOnWrite();
                    ((SharedData) this.instance).setAppStartTime((Timestamp) builder.build());
                    return this;
                }

                public Builder mergeAppStartTime(Timestamp timestamp) {
                    copyOnWrite();
                    ((SharedData) this.instance).mergeAppStartTime(timestamp);
                    return this;
                }

                public Builder clearAppStartTime() {
                    copyOnWrite();
                    ((SharedData) this.instance).clearAppStartTime();
                    return this;
                }

                public boolean hasSdkStartTime() {
                    return ((SharedData) this.instance).hasSdkStartTime();
                }

                public Timestamp getSdkStartTime() {
                    return ((SharedData) this.instance).getSdkStartTime();
                }

                public Builder setSdkStartTime(Timestamp timestamp) {
                    copyOnWrite();
                    ((SharedData) this.instance).setSdkStartTime(timestamp);
                    return this;
                }

                public Builder setSdkStartTime(Timestamp.Builder builder) {
                    copyOnWrite();
                    ((SharedData) this.instance).setSdkStartTime((Timestamp) builder.build());
                    return this;
                }

                public Builder mergeSdkStartTime(Timestamp timestamp) {
                    copyOnWrite();
                    ((SharedData) this.instance).mergeSdkStartTime(timestamp);
                    return this;
                }

                public Builder clearSdkStartTime() {
                    copyOnWrite();
                    ((SharedData) this.instance).clearSdkStartTime();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new SharedData();
                    case 2:
                        return new Builder((AnonymousClass1) null);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ည\u0000\u0002\t\u0003ဉ\u0001\u0004ဉ\u0002\u0005င\u0003\u0006ည\u0004\u0007ဉ\u0005\b\t\t\t", new Object[]{"bitField0_", "sessionToken_", "timestamps_", "pii_", "developerConsent_", "webviewVersion_", "currentState_", "testData_", "appStartTime_", "sdkStartTime_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<SharedData> parser = PARSER;
                        if (parser == null) {
                            synchronized (SharedData.class) {
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
                SharedData sharedData = new SharedData();
                DEFAULT_INSTANCE = sharedData;
                GeneratedMessageLite.registerDefaultInstance(SharedData.class, sharedData);
            }

            public static Parser<SharedData> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Payload extends GeneratedMessageLite<Payload, Builder> implements PayloadOrBuilder {
            public static final int AD_DATA_REFRESH_REQUEST_FIELD_NUMBER = 9;
            public static final int AD_PLAYER_CONFIG_REQUEST_FIELD_NUMBER = 6;
            public static final int AD_REQUEST_FIELD_NUMBER = 3;
            /* access modifiers changed from: private */
            public static final Payload DEFAULT_INSTANCE;
            public static final int DIAGNOSTIC_EVENT_REQUEST_FIELD_NUMBER = 5;
            public static final int GET_TOKEN_EVENT_REQUEST_FIELD_NUMBER = 7;
            public static final int INITIALIZATION_COMPLETED_EVENT_REQUEST_FIELD_NUMBER = 10;
            public static final int INITIALIZATION_REQUEST_FIELD_NUMBER = 2;
            public static final int OPERATIVE_EVENT_FIELD_NUMBER = 4;
            private static volatile Parser<Payload> PARSER = null;
            public static final int PRIVACY_UPDATE_REQUEST_FIELD_NUMBER = 8;
            private int valueCase_ = 0;
            private Object value_;

            /* access modifiers changed from: private */
            public void clearAdDataRefreshRequest() {
                if (this.valueCase_ == 9) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                }
            }

            /* access modifiers changed from: private */
            public void clearAdPlayerConfigRequest() {
                if (this.valueCase_ == 6) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                }
            }

            /* access modifiers changed from: private */
            public void clearAdRequest() {
                if (this.valueCase_ == 3) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                }
            }

            /* access modifiers changed from: private */
            public void clearDiagnosticEventRequest() {
                if (this.valueCase_ == 5) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                }
            }

            /* access modifiers changed from: private */
            public void clearGetTokenEventRequest() {
                if (this.valueCase_ == 7) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                }
            }

            /* access modifiers changed from: private */
            public void clearInitializationCompletedEventRequest() {
                if (this.valueCase_ == 10) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                }
            }

            /* access modifiers changed from: private */
            public void clearInitializationRequest() {
                if (this.valueCase_ == 2) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                }
            }

            /* access modifiers changed from: private */
            public void clearOperativeEvent() {
                if (this.valueCase_ == 4) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                }
            }

            /* access modifiers changed from: private */
            public void clearPrivacyUpdateRequest() {
                if (this.valueCase_ == 8) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                }
            }

            /* access modifiers changed from: private */
            public void clearValue() {
                this.valueCase_ = 0;
                this.value_ = null;
            }

            public static Payload getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public boolean hasAdDataRefreshRequest() {
                return this.valueCase_ == 9;
            }

            public boolean hasAdPlayerConfigRequest() {
                return this.valueCase_ == 6;
            }

            public boolean hasAdRequest() {
                return this.valueCase_ == 3;
            }

            public boolean hasDiagnosticEventRequest() {
                return this.valueCase_ == 5;
            }

            public boolean hasGetTokenEventRequest() {
                return this.valueCase_ == 7;
            }

            public boolean hasInitializationCompletedEventRequest() {
                return this.valueCase_ == 10;
            }

            public boolean hasInitializationRequest() {
                return this.valueCase_ == 2;
            }

            public boolean hasOperativeEvent() {
                return this.valueCase_ == 4;
            }

            public boolean hasPrivacyUpdateRequest() {
                return this.valueCase_ == 8;
            }

            private Payload() {
            }

            public enum ValueCase {
                INITIALIZATION_REQUEST(2),
                AD_REQUEST(3),
                OPERATIVE_EVENT(4),
                DIAGNOSTIC_EVENT_REQUEST(5),
                AD_PLAYER_CONFIG_REQUEST(6),
                GET_TOKEN_EVENT_REQUEST(7),
                PRIVACY_UPDATE_REQUEST(8),
                AD_DATA_REFRESH_REQUEST(9),
                INITIALIZATION_COMPLETED_EVENT_REQUEST(10),
                VALUE_NOT_SET(0);
                
                private final int value;

                public static ValueCase forNumber(int i) {
                    if (i == 0) {
                        return VALUE_NOT_SET;
                    }
                    switch (i) {
                        case 2:
                            return INITIALIZATION_REQUEST;
                        case 3:
                            return AD_REQUEST;
                        case 4:
                            return OPERATIVE_EVENT;
                        case 5:
                            return DIAGNOSTIC_EVENT_REQUEST;
                        case 6:
                            return AD_PLAYER_CONFIG_REQUEST;
                        case 7:
                            return GET_TOKEN_EVENT_REQUEST;
                        case 8:
                            return PRIVACY_UPDATE_REQUEST;
                        case 9:
                            return AD_DATA_REFRESH_REQUEST;
                        case 10:
                            return INITIALIZATION_COMPLETED_EVENT_REQUEST;
                        default:
                            return null;
                    }
                }

                public int getNumber() {
                    return this.value;
                }

                private ValueCase(int i) {
                    this.value = i;
                }

                @Deprecated
                public static ValueCase valueOf(int i) {
                    return forNumber(i);
                }
            }

            public ValueCase getValueCase() {
                return ValueCase.forNumber(this.valueCase_);
            }

            public InitializationRequestOuterClass.InitializationRequest getInitializationRequest() {
                if (this.valueCase_ == 2) {
                    return (InitializationRequestOuterClass.InitializationRequest) this.value_;
                }
                return InitializationRequestOuterClass.InitializationRequest.getDefaultInstance();
            }

            /* access modifiers changed from: private */
            public void setInitializationRequest(InitializationRequestOuterClass.InitializationRequest initializationRequest) {
                initializationRequest.getClass();
                this.value_ = initializationRequest;
                this.valueCase_ = 2;
            }

            /* access modifiers changed from: private */
            public void mergeInitializationRequest(InitializationRequestOuterClass.InitializationRequest initializationRequest) {
                initializationRequest.getClass();
                if (this.valueCase_ != 2 || this.value_ == InitializationRequestOuterClass.InitializationRequest.getDefaultInstance()) {
                    this.value_ = initializationRequest;
                } else {
                    this.value_ = ((InitializationRequestOuterClass.InitializationRequest.Builder) InitializationRequestOuterClass.InitializationRequest.newBuilder((InitializationRequestOuterClass.InitializationRequest) this.value_).mergeFrom(initializationRequest)).buildPartial();
                }
                this.valueCase_ = 2;
            }

            public AdRequestOuterClass.AdRequest getAdRequest() {
                if (this.valueCase_ == 3) {
                    return (AdRequestOuterClass.AdRequest) this.value_;
                }
                return AdRequestOuterClass.AdRequest.getDefaultInstance();
            }

            /* access modifiers changed from: private */
            public void setAdRequest(AdRequestOuterClass.AdRequest adRequest) {
                adRequest.getClass();
                this.value_ = adRequest;
                this.valueCase_ = 3;
            }

            /* access modifiers changed from: private */
            public void mergeAdRequest(AdRequestOuterClass.AdRequest adRequest) {
                adRequest.getClass();
                if (this.valueCase_ != 3 || this.value_ == AdRequestOuterClass.AdRequest.getDefaultInstance()) {
                    this.value_ = adRequest;
                } else {
                    this.value_ = ((AdRequestOuterClass.AdRequest.Builder) AdRequestOuterClass.AdRequest.newBuilder((AdRequestOuterClass.AdRequest) this.value_).mergeFrom(adRequest)).buildPartial();
                }
                this.valueCase_ = 3;
            }

            public OperativeEventRequestOuterClass.OperativeEventRequest getOperativeEvent() {
                if (this.valueCase_ == 4) {
                    return (OperativeEventRequestOuterClass.OperativeEventRequest) this.value_;
                }
                return OperativeEventRequestOuterClass.OperativeEventRequest.getDefaultInstance();
            }

            /* access modifiers changed from: private */
            public void setOperativeEvent(OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest) {
                operativeEventRequest.getClass();
                this.value_ = operativeEventRequest;
                this.valueCase_ = 4;
            }

            /* access modifiers changed from: private */
            public void mergeOperativeEvent(OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest) {
                operativeEventRequest.getClass();
                if (this.valueCase_ != 4 || this.value_ == OperativeEventRequestOuterClass.OperativeEventRequest.getDefaultInstance()) {
                    this.value_ = operativeEventRequest;
                } else {
                    this.value_ = ((OperativeEventRequestOuterClass.OperativeEventRequest.Builder) OperativeEventRequestOuterClass.OperativeEventRequest.newBuilder((OperativeEventRequestOuterClass.OperativeEventRequest) this.value_).mergeFrom(operativeEventRequest)).buildPartial();
                }
                this.valueCase_ = 4;
            }

            public DiagnosticEventRequestOuterClass.DiagnosticEventRequest getDiagnosticEventRequest() {
                if (this.valueCase_ == 5) {
                    return (DiagnosticEventRequestOuterClass.DiagnosticEventRequest) this.value_;
                }
                return DiagnosticEventRequestOuterClass.DiagnosticEventRequest.getDefaultInstance();
            }

            /* access modifiers changed from: private */
            public void setDiagnosticEventRequest(DiagnosticEventRequestOuterClass.DiagnosticEventRequest diagnosticEventRequest) {
                diagnosticEventRequest.getClass();
                this.value_ = diagnosticEventRequest;
                this.valueCase_ = 5;
            }

            /* access modifiers changed from: private */
            public void mergeDiagnosticEventRequest(DiagnosticEventRequestOuterClass.DiagnosticEventRequest diagnosticEventRequest) {
                diagnosticEventRequest.getClass();
                if (this.valueCase_ != 5 || this.value_ == DiagnosticEventRequestOuterClass.DiagnosticEventRequest.getDefaultInstance()) {
                    this.value_ = diagnosticEventRequest;
                } else {
                    this.value_ = ((DiagnosticEventRequestOuterClass.DiagnosticEventRequest.Builder) DiagnosticEventRequestOuterClass.DiagnosticEventRequest.newBuilder((DiagnosticEventRequestOuterClass.DiagnosticEventRequest) this.value_).mergeFrom(diagnosticEventRequest)).buildPartial();
                }
                this.valueCase_ = 5;
            }

            public AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest getAdPlayerConfigRequest() {
                if (this.valueCase_ == 6) {
                    return (AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest) this.value_;
                }
                return AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.getDefaultInstance();
            }

            /* access modifiers changed from: private */
            public void setAdPlayerConfigRequest(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest adPlayerConfigRequest) {
                adPlayerConfigRequest.getClass();
                this.value_ = adPlayerConfigRequest;
                this.valueCase_ = 6;
            }

            /* access modifiers changed from: private */
            public void mergeAdPlayerConfigRequest(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest adPlayerConfigRequest) {
                adPlayerConfigRequest.getClass();
                if (this.valueCase_ != 6 || this.value_ == AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.getDefaultInstance()) {
                    this.value_ = adPlayerConfigRequest;
                } else {
                    this.value_ = ((AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder) AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.newBuilder((AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest) this.value_).mergeFrom(adPlayerConfigRequest)).buildPartial();
                }
                this.valueCase_ = 6;
            }

            public GetTokenEventRequestOuterClass.GetTokenEventRequest getGetTokenEventRequest() {
                if (this.valueCase_ == 7) {
                    return (GetTokenEventRequestOuterClass.GetTokenEventRequest) this.value_;
                }
                return GetTokenEventRequestOuterClass.GetTokenEventRequest.getDefaultInstance();
            }

            /* access modifiers changed from: private */
            public void setGetTokenEventRequest(GetTokenEventRequestOuterClass.GetTokenEventRequest getTokenEventRequest) {
                getTokenEventRequest.getClass();
                this.value_ = getTokenEventRequest;
                this.valueCase_ = 7;
            }

            /* access modifiers changed from: private */
            public void mergeGetTokenEventRequest(GetTokenEventRequestOuterClass.GetTokenEventRequest getTokenEventRequest) {
                getTokenEventRequest.getClass();
                if (this.valueCase_ != 7 || this.value_ == GetTokenEventRequestOuterClass.GetTokenEventRequest.getDefaultInstance()) {
                    this.value_ = getTokenEventRequest;
                } else {
                    this.value_ = ((GetTokenEventRequestOuterClass.GetTokenEventRequest.Builder) GetTokenEventRequestOuterClass.GetTokenEventRequest.newBuilder((GetTokenEventRequestOuterClass.GetTokenEventRequest) this.value_).mergeFrom(getTokenEventRequest)).buildPartial();
                }
                this.valueCase_ = 7;
            }

            public PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest getPrivacyUpdateRequest() {
                if (this.valueCase_ == 8) {
                    return (PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest) this.value_;
                }
                return PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.getDefaultInstance();
            }

            /* access modifiers changed from: private */
            public void setPrivacyUpdateRequest(PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest privacyUpdateRequest) {
                privacyUpdateRequest.getClass();
                this.value_ = privacyUpdateRequest;
                this.valueCase_ = 8;
            }

            /* access modifiers changed from: private */
            public void mergePrivacyUpdateRequest(PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest privacyUpdateRequest) {
                privacyUpdateRequest.getClass();
                if (this.valueCase_ != 8 || this.value_ == PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.getDefaultInstance()) {
                    this.value_ = privacyUpdateRequest;
                } else {
                    this.value_ = ((PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.Builder) PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.newBuilder((PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest) this.value_).mergeFrom(privacyUpdateRequest)).buildPartial();
                }
                this.valueCase_ = 8;
            }

            public AdDataRefreshRequestOuterClass.AdDataRefreshRequest getAdDataRefreshRequest() {
                if (this.valueCase_ == 9) {
                    return (AdDataRefreshRequestOuterClass.AdDataRefreshRequest) this.value_;
                }
                return AdDataRefreshRequestOuterClass.AdDataRefreshRequest.getDefaultInstance();
            }

            /* access modifiers changed from: private */
            public void setAdDataRefreshRequest(AdDataRefreshRequestOuterClass.AdDataRefreshRequest adDataRefreshRequest) {
                adDataRefreshRequest.getClass();
                this.value_ = adDataRefreshRequest;
                this.valueCase_ = 9;
            }

            /* access modifiers changed from: private */
            public void mergeAdDataRefreshRequest(AdDataRefreshRequestOuterClass.AdDataRefreshRequest adDataRefreshRequest) {
                adDataRefreshRequest.getClass();
                if (this.valueCase_ != 9 || this.value_ == AdDataRefreshRequestOuterClass.AdDataRefreshRequest.getDefaultInstance()) {
                    this.value_ = adDataRefreshRequest;
                } else {
                    this.value_ = ((AdDataRefreshRequestOuterClass.AdDataRefreshRequest.Builder) AdDataRefreshRequestOuterClass.AdDataRefreshRequest.newBuilder((AdDataRefreshRequestOuterClass.AdDataRefreshRequest) this.value_).mergeFrom(adDataRefreshRequest)).buildPartial();
                }
                this.valueCase_ = 9;
            }

            public InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest getInitializationCompletedEventRequest() {
                if (this.valueCase_ == 10) {
                    return (InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest) this.value_;
                }
                return InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.getDefaultInstance();
            }

            /* access modifiers changed from: private */
            public void setInitializationCompletedEventRequest(InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest initializationCompletedEventRequest) {
                initializationCompletedEventRequest.getClass();
                this.value_ = initializationCompletedEventRequest;
                this.valueCase_ = 10;
            }

            /* access modifiers changed from: private */
            public void mergeInitializationCompletedEventRequest(InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest initializationCompletedEventRequest) {
                initializationCompletedEventRequest.getClass();
                if (this.valueCase_ != 10 || this.value_ == InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.getDefaultInstance()) {
                    this.value_ = initializationCompletedEventRequest;
                } else {
                    this.value_ = ((InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.Builder) InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.newBuilder((InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest) this.value_).mergeFrom(initializationCompletedEventRequest)).buildPartial();
                }
                this.valueCase_ = 10;
            }

            public static Payload parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Payload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Payload parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Payload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Payload parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Payload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Payload parseFrom(InputStream inputStream) throws IOException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Payload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Payload parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Payload) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Payload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Payload) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Payload parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Payload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Payload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Payload payload) {
                return (Builder) DEFAULT_INSTANCE.createBuilder(payload);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Payload, Builder> implements PayloadOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 r1) {
                    this();
                }

                private Builder() {
                    super(Payload.DEFAULT_INSTANCE);
                }

                public ValueCase getValueCase() {
                    return ((Payload) this.instance).getValueCase();
                }

                public Builder clearValue() {
                    copyOnWrite();
                    ((Payload) this.instance).clearValue();
                    return this;
                }

                public boolean hasInitializationRequest() {
                    return ((Payload) this.instance).hasInitializationRequest();
                }

                public InitializationRequestOuterClass.InitializationRequest getInitializationRequest() {
                    return ((Payload) this.instance).getInitializationRequest();
                }

                public Builder setInitializationRequest(InitializationRequestOuterClass.InitializationRequest initializationRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).setInitializationRequest(initializationRequest);
                    return this;
                }

                public Builder setInitializationRequest(InitializationRequestOuterClass.InitializationRequest.Builder builder) {
                    copyOnWrite();
                    ((Payload) this.instance).setInitializationRequest((InitializationRequestOuterClass.InitializationRequest) builder.build());
                    return this;
                }

                public Builder mergeInitializationRequest(InitializationRequestOuterClass.InitializationRequest initializationRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).mergeInitializationRequest(initializationRequest);
                    return this;
                }

                public Builder clearInitializationRequest() {
                    copyOnWrite();
                    ((Payload) this.instance).clearInitializationRequest();
                    return this;
                }

                public boolean hasAdRequest() {
                    return ((Payload) this.instance).hasAdRequest();
                }

                public AdRequestOuterClass.AdRequest getAdRequest() {
                    return ((Payload) this.instance).getAdRequest();
                }

                public Builder setAdRequest(AdRequestOuterClass.AdRequest adRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).setAdRequest(adRequest);
                    return this;
                }

                public Builder setAdRequest(AdRequestOuterClass.AdRequest.Builder builder) {
                    copyOnWrite();
                    ((Payload) this.instance).setAdRequest((AdRequestOuterClass.AdRequest) builder.build());
                    return this;
                }

                public Builder mergeAdRequest(AdRequestOuterClass.AdRequest adRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).mergeAdRequest(adRequest);
                    return this;
                }

                public Builder clearAdRequest() {
                    copyOnWrite();
                    ((Payload) this.instance).clearAdRequest();
                    return this;
                }

                public boolean hasOperativeEvent() {
                    return ((Payload) this.instance).hasOperativeEvent();
                }

                public OperativeEventRequestOuterClass.OperativeEventRequest getOperativeEvent() {
                    return ((Payload) this.instance).getOperativeEvent();
                }

                public Builder setOperativeEvent(OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).setOperativeEvent(operativeEventRequest);
                    return this;
                }

                public Builder setOperativeEvent(OperativeEventRequestOuterClass.OperativeEventRequest.Builder builder) {
                    copyOnWrite();
                    ((Payload) this.instance).setOperativeEvent((OperativeEventRequestOuterClass.OperativeEventRequest) builder.build());
                    return this;
                }

                public Builder mergeOperativeEvent(OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).mergeOperativeEvent(operativeEventRequest);
                    return this;
                }

                public Builder clearOperativeEvent() {
                    copyOnWrite();
                    ((Payload) this.instance).clearOperativeEvent();
                    return this;
                }

                public boolean hasDiagnosticEventRequest() {
                    return ((Payload) this.instance).hasDiagnosticEventRequest();
                }

                public DiagnosticEventRequestOuterClass.DiagnosticEventRequest getDiagnosticEventRequest() {
                    return ((Payload) this.instance).getDiagnosticEventRequest();
                }

                public Builder setDiagnosticEventRequest(DiagnosticEventRequestOuterClass.DiagnosticEventRequest diagnosticEventRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).setDiagnosticEventRequest(diagnosticEventRequest);
                    return this;
                }

                public Builder setDiagnosticEventRequest(DiagnosticEventRequestOuterClass.DiagnosticEventRequest.Builder builder) {
                    copyOnWrite();
                    ((Payload) this.instance).setDiagnosticEventRequest((DiagnosticEventRequestOuterClass.DiagnosticEventRequest) builder.build());
                    return this;
                }

                public Builder mergeDiagnosticEventRequest(DiagnosticEventRequestOuterClass.DiagnosticEventRequest diagnosticEventRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).mergeDiagnosticEventRequest(diagnosticEventRequest);
                    return this;
                }

                public Builder clearDiagnosticEventRequest() {
                    copyOnWrite();
                    ((Payload) this.instance).clearDiagnosticEventRequest();
                    return this;
                }

                public boolean hasAdPlayerConfigRequest() {
                    return ((Payload) this.instance).hasAdPlayerConfigRequest();
                }

                public AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest getAdPlayerConfigRequest() {
                    return ((Payload) this.instance).getAdPlayerConfigRequest();
                }

                public Builder setAdPlayerConfigRequest(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest adPlayerConfigRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).setAdPlayerConfigRequest(adPlayerConfigRequest);
                    return this;
                }

                public Builder setAdPlayerConfigRequest(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder builder) {
                    copyOnWrite();
                    ((Payload) this.instance).setAdPlayerConfigRequest((AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest) builder.build());
                    return this;
                }

                public Builder mergeAdPlayerConfigRequest(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest adPlayerConfigRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).mergeAdPlayerConfigRequest(adPlayerConfigRequest);
                    return this;
                }

                public Builder clearAdPlayerConfigRequest() {
                    copyOnWrite();
                    ((Payload) this.instance).clearAdPlayerConfigRequest();
                    return this;
                }

                public boolean hasGetTokenEventRequest() {
                    return ((Payload) this.instance).hasGetTokenEventRequest();
                }

                public GetTokenEventRequestOuterClass.GetTokenEventRequest getGetTokenEventRequest() {
                    return ((Payload) this.instance).getGetTokenEventRequest();
                }

                public Builder setGetTokenEventRequest(GetTokenEventRequestOuterClass.GetTokenEventRequest getTokenEventRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).setGetTokenEventRequest(getTokenEventRequest);
                    return this;
                }

                public Builder setGetTokenEventRequest(GetTokenEventRequestOuterClass.GetTokenEventRequest.Builder builder) {
                    copyOnWrite();
                    ((Payload) this.instance).setGetTokenEventRequest((GetTokenEventRequestOuterClass.GetTokenEventRequest) builder.build());
                    return this;
                }

                public Builder mergeGetTokenEventRequest(GetTokenEventRequestOuterClass.GetTokenEventRequest getTokenEventRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).mergeGetTokenEventRequest(getTokenEventRequest);
                    return this;
                }

                public Builder clearGetTokenEventRequest() {
                    copyOnWrite();
                    ((Payload) this.instance).clearGetTokenEventRequest();
                    return this;
                }

                public boolean hasPrivacyUpdateRequest() {
                    return ((Payload) this.instance).hasPrivacyUpdateRequest();
                }

                public PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest getPrivacyUpdateRequest() {
                    return ((Payload) this.instance).getPrivacyUpdateRequest();
                }

                public Builder setPrivacyUpdateRequest(PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest privacyUpdateRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).setPrivacyUpdateRequest(privacyUpdateRequest);
                    return this;
                }

                public Builder setPrivacyUpdateRequest(PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.Builder builder) {
                    copyOnWrite();
                    ((Payload) this.instance).setPrivacyUpdateRequest((PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest) builder.build());
                    return this;
                }

                public Builder mergePrivacyUpdateRequest(PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest privacyUpdateRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).mergePrivacyUpdateRequest(privacyUpdateRequest);
                    return this;
                }

                public Builder clearPrivacyUpdateRequest() {
                    copyOnWrite();
                    ((Payload) this.instance).clearPrivacyUpdateRequest();
                    return this;
                }

                public boolean hasAdDataRefreshRequest() {
                    return ((Payload) this.instance).hasAdDataRefreshRequest();
                }

                public AdDataRefreshRequestOuterClass.AdDataRefreshRequest getAdDataRefreshRequest() {
                    return ((Payload) this.instance).getAdDataRefreshRequest();
                }

                public Builder setAdDataRefreshRequest(AdDataRefreshRequestOuterClass.AdDataRefreshRequest adDataRefreshRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).setAdDataRefreshRequest(adDataRefreshRequest);
                    return this;
                }

                public Builder setAdDataRefreshRequest(AdDataRefreshRequestOuterClass.AdDataRefreshRequest.Builder builder) {
                    copyOnWrite();
                    ((Payload) this.instance).setAdDataRefreshRequest((AdDataRefreshRequestOuterClass.AdDataRefreshRequest) builder.build());
                    return this;
                }

                public Builder mergeAdDataRefreshRequest(AdDataRefreshRequestOuterClass.AdDataRefreshRequest adDataRefreshRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).mergeAdDataRefreshRequest(adDataRefreshRequest);
                    return this;
                }

                public Builder clearAdDataRefreshRequest() {
                    copyOnWrite();
                    ((Payload) this.instance).clearAdDataRefreshRequest();
                    return this;
                }

                public boolean hasInitializationCompletedEventRequest() {
                    return ((Payload) this.instance).hasInitializationCompletedEventRequest();
                }

                public InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest getInitializationCompletedEventRequest() {
                    return ((Payload) this.instance).getInitializationCompletedEventRequest();
                }

                public Builder setInitializationCompletedEventRequest(InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest initializationCompletedEventRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).setInitializationCompletedEventRequest(initializationCompletedEventRequest);
                    return this;
                }

                public Builder setInitializationCompletedEventRequest(InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.Builder builder) {
                    copyOnWrite();
                    ((Payload) this.instance).setInitializationCompletedEventRequest((InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest) builder.build());
                    return this;
                }

                public Builder mergeInitializationCompletedEventRequest(InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest initializationCompletedEventRequest) {
                    copyOnWrite();
                    ((Payload) this.instance).mergeInitializationCompletedEventRequest(initializationCompletedEventRequest);
                    return this;
                }

                public Builder clearInitializationCompletedEventRequest() {
                    copyOnWrite();
                    ((Payload) this.instance).clearInitializationCompletedEventRequest();
                    return this;
                }
            }

            /* access modifiers changed from: protected */
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Payload();
                    case 2:
                        return new Builder((AnonymousClass1) null);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0002\n\t\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000", new Object[]{"value_", "valueCase_", InitializationRequestOuterClass.InitializationRequest.class, AdRequestOuterClass.AdRequest.class, OperativeEventRequestOuterClass.OperativeEventRequest.class, DiagnosticEventRequestOuterClass.DiagnosticEventRequest.class, AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.class, GetTokenEventRequestOuterClass.GetTokenEventRequest.class, PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.class, AdDataRefreshRequestOuterClass.AdDataRefreshRequest.class, InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Payload> parser = PARSER;
                        if (parser == null) {
                            synchronized (Payload.class) {
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
                Payload payload = new Payload();
                DEFAULT_INSTANCE = payload;
                GeneratedMessageLite.registerDefaultInstance(Payload.class, payload);
            }

            public static Parser<Payload> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public SharedData getSharedData() {
            SharedData sharedData = this.sharedData_;
            return sharedData == null ? SharedData.getDefaultInstance() : sharedData;
        }

        /* access modifiers changed from: private */
        public void setSharedData(SharedData sharedData) {
            sharedData.getClass();
            this.sharedData_ = sharedData;
        }

        /* access modifiers changed from: private */
        public void mergeSharedData(SharedData sharedData) {
            sharedData.getClass();
            SharedData sharedData2 = this.sharedData_;
            if (sharedData2 == null || sharedData2 == SharedData.getDefaultInstance()) {
                this.sharedData_ = sharedData;
            } else {
                this.sharedData_ = (SharedData) ((SharedData.Builder) SharedData.newBuilder(this.sharedData_).mergeFrom(sharedData)).buildPartial();
            }
        }

        public Payload getPayload() {
            Payload payload = this.payload_;
            return payload == null ? Payload.getDefaultInstance() : payload;
        }

        /* access modifiers changed from: private */
        public void setPayload(Payload payload) {
            payload.getClass();
            this.payload_ = payload;
        }

        /* access modifiers changed from: private */
        public void mergePayload(Payload payload) {
            payload.getClass();
            Payload payload2 = this.payload_;
            if (payload2 == null || payload2 == Payload.getDefaultInstance()) {
                this.payload_ = payload;
            } else {
                this.payload_ = (Payload) ((Payload.Builder) Payload.newBuilder(this.payload_).mergeFrom(payload)).buildPartial();
            }
        }

        public static UniversalRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UniversalRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UniversalRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UniversalRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UniversalRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UniversalRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UniversalRequest parseFrom(InputStream inputStream) throws IOException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UniversalRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UniversalRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UniversalRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UniversalRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UniversalRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UniversalRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UniversalRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UniversalRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UniversalRequest universalRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(universalRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UniversalRequest, Builder> implements UniversalRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(UniversalRequest.DEFAULT_INSTANCE);
            }

            public boolean hasSharedData() {
                return ((UniversalRequest) this.instance).hasSharedData();
            }

            public SharedData getSharedData() {
                return ((UniversalRequest) this.instance).getSharedData();
            }

            public Builder setSharedData(SharedData sharedData) {
                copyOnWrite();
                ((UniversalRequest) this.instance).setSharedData(sharedData);
                return this;
            }

            public Builder setSharedData(SharedData.Builder builder) {
                copyOnWrite();
                ((UniversalRequest) this.instance).setSharedData((SharedData) builder.build());
                return this;
            }

            public Builder mergeSharedData(SharedData sharedData) {
                copyOnWrite();
                ((UniversalRequest) this.instance).mergeSharedData(sharedData);
                return this;
            }

            public Builder clearSharedData() {
                copyOnWrite();
                ((UniversalRequest) this.instance).clearSharedData();
                return this;
            }

            public boolean hasPayload() {
                return ((UniversalRequest) this.instance).hasPayload();
            }

            public Payload getPayload() {
                return ((UniversalRequest) this.instance).getPayload();
            }

            public Builder setPayload(Payload payload) {
                copyOnWrite();
                ((UniversalRequest) this.instance).setPayload(payload);
                return this;
            }

            public Builder setPayload(Payload.Builder builder) {
                copyOnWrite();
                ((UniversalRequest) this.instance).setPayload((Payload) builder.build());
                return this;
            }

            public Builder mergePayload(Payload payload) {
                copyOnWrite();
                ((UniversalRequest) this.instance).mergePayload(payload);
                return this;
            }

            public Builder clearPayload() {
                copyOnWrite();
                ((UniversalRequest) this.instance).clearPayload();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new UniversalRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"sharedData_", "payload_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UniversalRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (UniversalRequest.class) {
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
            UniversalRequest universalRequest = new UniversalRequest();
            DEFAULT_INSTANCE = universalRequest;
            GeneratedMessageLite.registerDefaultInstance(UniversalRequest.class, universalRequest);
        }

        public static Parser<UniversalRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: gateway.v1.UniversalRequestOuterClass$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: gateway.v1.UniversalRequestOuterClass.AnonymousClass1.<clinit>():void");
        }
    }
}
