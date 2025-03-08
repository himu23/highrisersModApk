package gateway.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import gateway.v1.ClientInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class InitializationRequestOuterClass {

    public interface InitializationDeviceInfoOrBuilder extends MessageLiteOrBuilder {
        String getBundleId();

        ByteString getBundleIdBytes();

        String getDeviceMake();

        ByteString getDeviceMakeBytes();

        String getDeviceModel();

        ByteString getDeviceModelBytes();

        String getOsVersion();

        ByteString getOsVersionBytes();
    }

    public interface InitializationRequestOrBuilder extends MessageLiteOrBuilder {
        String getAnalyticsUserId();

        ByteString getAnalyticsUserIdBytes();

        ByteString getAuid();

        ByteString getCache();

        ClientInfoOuterClass.ClientInfo getClientInfo();

        InitializationDeviceInfo getDeviceInfo();

        String getIdfi();

        ByteString getIdfiBytes();

        boolean getIsFirstInit();

        String getLegacyFlowUserConsent();

        ByteString getLegacyFlowUserConsentBytes();

        ByteString getPrivacy();

        ByteString getSessionId();

        boolean hasAnalyticsUserId();

        boolean hasAuid();

        boolean hasCache();

        boolean hasClientInfo();

        boolean hasDeviceInfo();

        boolean hasLegacyFlowUserConsent();

        boolean hasPrivacy();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private InitializationRequestOuterClass() {
    }

    public static final class InitializationDeviceInfo extends GeneratedMessageLite<InitializationDeviceInfo, Builder> implements InitializationDeviceInfoOrBuilder {
        public static final int BUNDLE_ID_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final InitializationDeviceInfo DEFAULT_INSTANCE;
        public static final int DEVICE_MAKE_FIELD_NUMBER = 2;
        public static final int DEVICE_MODEL_FIELD_NUMBER = 3;
        public static final int OS_VERSION_FIELD_NUMBER = 4;
        private static volatile Parser<InitializationDeviceInfo> PARSER;
        private String bundleId_ = "";
        private String deviceMake_ = "";
        private String deviceModel_ = "";
        private String osVersion_ = "";

        public static InitializationDeviceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public String getBundleId() {
            return this.bundleId_;
        }

        public String getDeviceMake() {
            return this.deviceMake_;
        }

        public String getDeviceModel() {
            return this.deviceModel_;
        }

        public String getOsVersion() {
            return this.osVersion_;
        }

        private InitializationDeviceInfo() {
        }

        public ByteString getBundleIdBytes() {
            return ByteString.copyFromUtf8(this.bundleId_);
        }

        /* access modifiers changed from: private */
        public void setBundleId(String str) {
            str.getClass();
            this.bundleId_ = str;
        }

        /* access modifiers changed from: private */
        public void clearBundleId() {
            this.bundleId_ = getDefaultInstance().getBundleId();
        }

        /* access modifiers changed from: private */
        public void setBundleIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.bundleId_ = byteString.toStringUtf8();
        }

        public ByteString getDeviceMakeBytes() {
            return ByteString.copyFromUtf8(this.deviceMake_);
        }

        /* access modifiers changed from: private */
        public void setDeviceMake(String str) {
            str.getClass();
            this.deviceMake_ = str;
        }

        /* access modifiers changed from: private */
        public void clearDeviceMake() {
            this.deviceMake_ = getDefaultInstance().getDeviceMake();
        }

        /* access modifiers changed from: private */
        public void setDeviceMakeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.deviceMake_ = byteString.toStringUtf8();
        }

        public ByteString getDeviceModelBytes() {
            return ByteString.copyFromUtf8(this.deviceModel_);
        }

        /* access modifiers changed from: private */
        public void setDeviceModel(String str) {
            str.getClass();
            this.deviceModel_ = str;
        }

        /* access modifiers changed from: private */
        public void clearDeviceModel() {
            this.deviceModel_ = getDefaultInstance().getDeviceModel();
        }

        /* access modifiers changed from: private */
        public void setDeviceModelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.deviceModel_ = byteString.toStringUtf8();
        }

        public ByteString getOsVersionBytes() {
            return ByteString.copyFromUtf8(this.osVersion_);
        }

        /* access modifiers changed from: private */
        public void setOsVersion(String str) {
            str.getClass();
            this.osVersion_ = str;
        }

        /* access modifiers changed from: private */
        public void clearOsVersion() {
            this.osVersion_ = getDefaultInstance().getOsVersion();
        }

        /* access modifiers changed from: private */
        public void setOsVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.osVersion_ = byteString.toStringUtf8();
        }

        public static InitializationDeviceInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static InitializationDeviceInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static InitializationDeviceInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static InitializationDeviceInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static InitializationDeviceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static InitializationDeviceInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static InitializationDeviceInfo parseFrom(InputStream inputStream) throws IOException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InitializationDeviceInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static InitializationDeviceInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (InitializationDeviceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InitializationDeviceInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InitializationDeviceInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static InitializationDeviceInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static InitializationDeviceInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InitializationDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(InitializationDeviceInfo initializationDeviceInfo) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(initializationDeviceInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<InitializationDeviceInfo, Builder> implements InitializationDeviceInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(InitializationDeviceInfo.DEFAULT_INSTANCE);
            }

            public String getBundleId() {
                return ((InitializationDeviceInfo) this.instance).getBundleId();
            }

            public ByteString getBundleIdBytes() {
                return ((InitializationDeviceInfo) this.instance).getBundleIdBytes();
            }

            public Builder setBundleId(String str) {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).setBundleId(str);
                return this;
            }

            public Builder clearBundleId() {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).clearBundleId();
                return this;
            }

            public Builder setBundleIdBytes(ByteString byteString) {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).setBundleIdBytes(byteString);
                return this;
            }

            public String getDeviceMake() {
                return ((InitializationDeviceInfo) this.instance).getDeviceMake();
            }

            public ByteString getDeviceMakeBytes() {
                return ((InitializationDeviceInfo) this.instance).getDeviceMakeBytes();
            }

            public Builder setDeviceMake(String str) {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).setDeviceMake(str);
                return this;
            }

            public Builder clearDeviceMake() {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).clearDeviceMake();
                return this;
            }

            public Builder setDeviceMakeBytes(ByteString byteString) {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).setDeviceMakeBytes(byteString);
                return this;
            }

            public String getDeviceModel() {
                return ((InitializationDeviceInfo) this.instance).getDeviceModel();
            }

            public ByteString getDeviceModelBytes() {
                return ((InitializationDeviceInfo) this.instance).getDeviceModelBytes();
            }

            public Builder setDeviceModel(String str) {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).setDeviceModel(str);
                return this;
            }

            public Builder clearDeviceModel() {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).clearDeviceModel();
                return this;
            }

            public Builder setDeviceModelBytes(ByteString byteString) {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).setDeviceModelBytes(byteString);
                return this;
            }

            public String getOsVersion() {
                return ((InitializationDeviceInfo) this.instance).getOsVersion();
            }

            public ByteString getOsVersionBytes() {
                return ((InitializationDeviceInfo) this.instance).getOsVersionBytes();
            }

            public Builder setOsVersion(String str) {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).setOsVersion(str);
                return this;
            }

            public Builder clearOsVersion() {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).clearOsVersion();
                return this;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((InitializationDeviceInfo) this.instance).setOsVersionBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new InitializationDeviceInfo();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"bundleId_", "deviceMake_", "deviceModel_", "osVersion_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<InitializationDeviceInfo> parser = PARSER;
                    if (parser == null) {
                        synchronized (InitializationDeviceInfo.class) {
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
            InitializationDeviceInfo initializationDeviceInfo = new InitializationDeviceInfo();
            DEFAULT_INSTANCE = initializationDeviceInfo;
            GeneratedMessageLite.registerDefaultInstance(InitializationDeviceInfo.class, initializationDeviceInfo);
        }

        public static Parser<InitializationDeviceInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: gateway.v1.InitializationRequestOuterClass$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: gateway.v1.InitializationRequestOuterClass.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class InitializationRequest extends GeneratedMessageLite<InitializationRequest, Builder> implements InitializationRequestOrBuilder {
        public static final int ANALYTICS_USER_ID_FIELD_NUMBER = 8;
        public static final int AUID_FIELD_NUMBER = 7;
        public static final int CACHE_FIELD_NUMBER = 5;
        public static final int CLIENT_INFO_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final InitializationRequest DEFAULT_INSTANCE;
        public static final int DEVICE_INFO_FIELD_NUMBER = 9;
        public static final int IDFI_FIELD_NUMBER = 3;
        public static final int IS_FIRST_INIT_FIELD_NUMBER = 10;
        public static final int LEGACY_FLOW_USER_CONSENT_FIELD_NUMBER = 6;
        private static volatile Parser<InitializationRequest> PARSER = null;
        public static final int PRIVACY_FIELD_NUMBER = 2;
        public static final int SESSION_ID_FIELD_NUMBER = 4;
        private String analyticsUserId_ = "";
        private ByteString auid_ = ByteString.EMPTY;
        private int bitField0_;
        private ByteString cache_ = ByteString.EMPTY;
        private ClientInfoOuterClass.ClientInfo clientInfo_;
        private InitializationDeviceInfo deviceInfo_;
        private String idfi_ = "";
        private boolean isFirstInit_;
        private String legacyFlowUserConsent_ = "";
        private ByteString privacy_ = ByteString.EMPTY;
        private ByteString sessionId_ = ByteString.EMPTY;

        /* access modifiers changed from: private */
        public void clearClientInfo() {
            this.clientInfo_ = null;
        }

        /* access modifiers changed from: private */
        public void clearDeviceInfo() {
            this.deviceInfo_ = null;
        }

        /* access modifiers changed from: private */
        public void clearIsFirstInit() {
            this.isFirstInit_ = false;
        }

        public static InitializationRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void setIsFirstInit(boolean z) {
            this.isFirstInit_ = z;
        }

        public String getAnalyticsUserId() {
            return this.analyticsUserId_;
        }

        public ByteString getAuid() {
            return this.auid_;
        }

        public ByteString getCache() {
            return this.cache_;
        }

        public String getIdfi() {
            return this.idfi_;
        }

        public boolean getIsFirstInit() {
            return this.isFirstInit_;
        }

        public String getLegacyFlowUserConsent() {
            return this.legacyFlowUserConsent_;
        }

        public ByteString getPrivacy() {
            return this.privacy_;
        }

        public ByteString getSessionId() {
            return this.sessionId_;
        }

        public boolean hasAnalyticsUserId() {
            return (this.bitField0_ & 16) != 0;
        }

        public boolean hasAuid() {
            return (this.bitField0_ & 8) != 0;
        }

        public boolean hasCache() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasClientInfo() {
            return this.clientInfo_ != null;
        }

        public boolean hasDeviceInfo() {
            return this.deviceInfo_ != null;
        }

        public boolean hasLegacyFlowUserConsent() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasPrivacy() {
            return (this.bitField0_ & 1) != 0;
        }

        private InitializationRequest() {
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

        /* access modifiers changed from: private */
        public void setPrivacy(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.privacy_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearPrivacy() {
            this.bitField0_ &= -2;
            this.privacy_ = getDefaultInstance().getPrivacy();
        }

        public ByteString getIdfiBytes() {
            return ByteString.copyFromUtf8(this.idfi_);
        }

        /* access modifiers changed from: private */
        public void setIdfi(String str) {
            str.getClass();
            this.idfi_ = str;
        }

        /* access modifiers changed from: private */
        public void clearIdfi() {
            this.idfi_ = getDefaultInstance().getIdfi();
        }

        /* access modifiers changed from: private */
        public void setIdfiBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.idfi_ = byteString.toStringUtf8();
        }

        /* access modifiers changed from: private */
        public void setSessionId(ByteString byteString) {
            byteString.getClass();
            this.sessionId_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearSessionId() {
            this.sessionId_ = getDefaultInstance().getSessionId();
        }

        /* access modifiers changed from: private */
        public void setCache(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.cache_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearCache() {
            this.bitField0_ &= -3;
            this.cache_ = getDefaultInstance().getCache();
        }

        public ByteString getLegacyFlowUserConsentBytes() {
            return ByteString.copyFromUtf8(this.legacyFlowUserConsent_);
        }

        /* access modifiers changed from: private */
        public void setLegacyFlowUserConsent(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.legacyFlowUserConsent_ = str;
        }

        /* access modifiers changed from: private */
        public void clearLegacyFlowUserConsent() {
            this.bitField0_ &= -5;
            this.legacyFlowUserConsent_ = getDefaultInstance().getLegacyFlowUserConsent();
        }

        /* access modifiers changed from: private */
        public void setLegacyFlowUserConsentBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.legacyFlowUserConsent_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        /* access modifiers changed from: private */
        public void setAuid(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.auid_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearAuid() {
            this.bitField0_ &= -9;
            this.auid_ = getDefaultInstance().getAuid();
        }

        public ByteString getAnalyticsUserIdBytes() {
            return ByteString.copyFromUtf8(this.analyticsUserId_);
        }

        /* access modifiers changed from: private */
        public void setAnalyticsUserId(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.analyticsUserId_ = str;
        }

        /* access modifiers changed from: private */
        public void clearAnalyticsUserId() {
            this.bitField0_ &= -17;
            this.analyticsUserId_ = getDefaultInstance().getAnalyticsUserId();
        }

        /* access modifiers changed from: private */
        public void setAnalyticsUserIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.analyticsUserId_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        public InitializationDeviceInfo getDeviceInfo() {
            InitializationDeviceInfo initializationDeviceInfo = this.deviceInfo_;
            return initializationDeviceInfo == null ? InitializationDeviceInfo.getDefaultInstance() : initializationDeviceInfo;
        }

        /* access modifiers changed from: private */
        public void setDeviceInfo(InitializationDeviceInfo initializationDeviceInfo) {
            initializationDeviceInfo.getClass();
            this.deviceInfo_ = initializationDeviceInfo;
        }

        /* access modifiers changed from: private */
        public void mergeDeviceInfo(InitializationDeviceInfo initializationDeviceInfo) {
            initializationDeviceInfo.getClass();
            InitializationDeviceInfo initializationDeviceInfo2 = this.deviceInfo_;
            if (initializationDeviceInfo2 == null || initializationDeviceInfo2 == InitializationDeviceInfo.getDefaultInstance()) {
                this.deviceInfo_ = initializationDeviceInfo;
            } else {
                this.deviceInfo_ = (InitializationDeviceInfo) ((InitializationDeviceInfo.Builder) InitializationDeviceInfo.newBuilder(this.deviceInfo_).mergeFrom(initializationDeviceInfo)).buildPartial();
            }
        }

        public static InitializationRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static InitializationRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static InitializationRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static InitializationRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static InitializationRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static InitializationRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static InitializationRequest parseFrom(InputStream inputStream) throws IOException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InitializationRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static InitializationRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (InitializationRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InitializationRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InitializationRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static InitializationRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static InitializationRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InitializationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(InitializationRequest initializationRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(initializationRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<InitializationRequest, Builder> implements InitializationRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(InitializationRequest.DEFAULT_INSTANCE);
            }

            public boolean hasClientInfo() {
                return ((InitializationRequest) this.instance).hasClientInfo();
            }

            public ClientInfoOuterClass.ClientInfo getClientInfo() {
                return ((InitializationRequest) this.instance).getClientInfo();
            }

            public Builder setClientInfo(ClientInfoOuterClass.ClientInfo clientInfo) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setClientInfo(clientInfo);
                return this;
            }

            public Builder setClientInfo(ClientInfoOuterClass.ClientInfo.Builder builder) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setClientInfo((ClientInfoOuterClass.ClientInfo) builder.build());
                return this;
            }

            public Builder mergeClientInfo(ClientInfoOuterClass.ClientInfo clientInfo) {
                copyOnWrite();
                ((InitializationRequest) this.instance).mergeClientInfo(clientInfo);
                return this;
            }

            public Builder clearClientInfo() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearClientInfo();
                return this;
            }

            public boolean hasPrivacy() {
                return ((InitializationRequest) this.instance).hasPrivacy();
            }

            public ByteString getPrivacy() {
                return ((InitializationRequest) this.instance).getPrivacy();
            }

            public Builder setPrivacy(ByteString byteString) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setPrivacy(byteString);
                return this;
            }

            public Builder clearPrivacy() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearPrivacy();
                return this;
            }

            public String getIdfi() {
                return ((InitializationRequest) this.instance).getIdfi();
            }

            public ByteString getIdfiBytes() {
                return ((InitializationRequest) this.instance).getIdfiBytes();
            }

            public Builder setIdfi(String str) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setIdfi(str);
                return this;
            }

            public Builder clearIdfi() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearIdfi();
                return this;
            }

            public Builder setIdfiBytes(ByteString byteString) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setIdfiBytes(byteString);
                return this;
            }

            public ByteString getSessionId() {
                return ((InitializationRequest) this.instance).getSessionId();
            }

            public Builder setSessionId(ByteString byteString) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setSessionId(byteString);
                return this;
            }

            public Builder clearSessionId() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearSessionId();
                return this;
            }

            public boolean hasCache() {
                return ((InitializationRequest) this.instance).hasCache();
            }

            public ByteString getCache() {
                return ((InitializationRequest) this.instance).getCache();
            }

            public Builder setCache(ByteString byteString) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setCache(byteString);
                return this;
            }

            public Builder clearCache() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearCache();
                return this;
            }

            public boolean hasLegacyFlowUserConsent() {
                return ((InitializationRequest) this.instance).hasLegacyFlowUserConsent();
            }

            public String getLegacyFlowUserConsent() {
                return ((InitializationRequest) this.instance).getLegacyFlowUserConsent();
            }

            public ByteString getLegacyFlowUserConsentBytes() {
                return ((InitializationRequest) this.instance).getLegacyFlowUserConsentBytes();
            }

            public Builder setLegacyFlowUserConsent(String str) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setLegacyFlowUserConsent(str);
                return this;
            }

            public Builder clearLegacyFlowUserConsent() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearLegacyFlowUserConsent();
                return this;
            }

            public Builder setLegacyFlowUserConsentBytes(ByteString byteString) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setLegacyFlowUserConsentBytes(byteString);
                return this;
            }

            public boolean hasAuid() {
                return ((InitializationRequest) this.instance).hasAuid();
            }

            public ByteString getAuid() {
                return ((InitializationRequest) this.instance).getAuid();
            }

            public Builder setAuid(ByteString byteString) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setAuid(byteString);
                return this;
            }

            public Builder clearAuid() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearAuid();
                return this;
            }

            public boolean hasAnalyticsUserId() {
                return ((InitializationRequest) this.instance).hasAnalyticsUserId();
            }

            public String getAnalyticsUserId() {
                return ((InitializationRequest) this.instance).getAnalyticsUserId();
            }

            public ByteString getAnalyticsUserIdBytes() {
                return ((InitializationRequest) this.instance).getAnalyticsUserIdBytes();
            }

            public Builder setAnalyticsUserId(String str) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setAnalyticsUserId(str);
                return this;
            }

            public Builder clearAnalyticsUserId() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearAnalyticsUserId();
                return this;
            }

            public Builder setAnalyticsUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setAnalyticsUserIdBytes(byteString);
                return this;
            }

            public boolean hasDeviceInfo() {
                return ((InitializationRequest) this.instance).hasDeviceInfo();
            }

            public InitializationDeviceInfo getDeviceInfo() {
                return ((InitializationRequest) this.instance).getDeviceInfo();
            }

            public Builder setDeviceInfo(InitializationDeviceInfo initializationDeviceInfo) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setDeviceInfo(initializationDeviceInfo);
                return this;
            }

            public Builder setDeviceInfo(InitializationDeviceInfo.Builder builder) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setDeviceInfo((InitializationDeviceInfo) builder.build());
                return this;
            }

            public Builder mergeDeviceInfo(InitializationDeviceInfo initializationDeviceInfo) {
                copyOnWrite();
                ((InitializationRequest) this.instance).mergeDeviceInfo(initializationDeviceInfo);
                return this;
            }

            public Builder clearDeviceInfo() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearDeviceInfo();
                return this;
            }

            public boolean getIsFirstInit() {
                return ((InitializationRequest) this.instance).getIsFirstInit();
            }

            public Builder setIsFirstInit(boolean z) {
                copyOnWrite();
                ((InitializationRequest) this.instance).setIsFirstInit(z);
                return this;
            }

            public Builder clearIsFirstInit() {
                copyOnWrite();
                ((InitializationRequest) this.instance).clearIsFirstInit();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new InitializationRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\t\u0002ည\u0000\u0003Ȉ\u0004\n\u0005ည\u0001\u0006ለ\u0002\u0007ည\u0003\bለ\u0004\t\t\n\u0007", new Object[]{"bitField0_", "clientInfo_", "privacy_", "idfi_", "sessionId_", "cache_", "legacyFlowUserConsent_", "auid_", "analyticsUserId_", "deviceInfo_", "isFirstInit_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<InitializationRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (InitializationRequest.class) {
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
            InitializationRequest initializationRequest = new InitializationRequest();
            DEFAULT_INSTANCE = initializationRequest;
            GeneratedMessageLite.registerDefaultInstance(InitializationRequest.class, initializationRequest);
        }

        public static Parser<InitializationRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
