package gateway.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import gateway.v1.AllowedPiiOuterClass;
import gateway.v1.SessionCountersOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class MutableDataOuterClass {

    public interface MutableDataOrBuilder extends MessageLiteOrBuilder {
        AllowedPiiOuterClass.AllowedPii getAllowedPii();

        ByteString getCache();

        ByteString getCurrentState();

        ByteString getPrivacy();

        ByteString getPrivacyFsm();

        SessionCountersOuterClass.SessionCounters getSessionCounters();

        ByteString getSessionToken();

        boolean hasAllowedPii();

        boolean hasCache();

        boolean hasCurrentState();

        boolean hasPrivacy();

        boolean hasPrivacyFsm();

        boolean hasSessionCounters();

        boolean hasSessionToken();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private MutableDataOuterClass() {
    }

    public static final class MutableData extends GeneratedMessageLite<MutableData, Builder> implements MutableDataOrBuilder {
        public static final int ALLOWED_PII_FIELD_NUMBER = 13;
        public static final int CACHE_FIELD_NUMBER = 14;
        public static final int CURRENT_STATE_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final MutableData DEFAULT_INSTANCE;
        private static volatile Parser<MutableData> PARSER = null;
        public static final int PRIVACY_FIELD_NUMBER = 11;
        public static final int PRIVACY_FSM_FIELD_NUMBER = 15;
        public static final int SESSION_COUNTERS_FIELD_NUMBER = 12;
        public static final int SESSION_TOKEN_FIELD_NUMBER = 10;
        private AllowedPiiOuterClass.AllowedPii allowedPii_;
        private int bitField0_;
        private ByteString cache_ = ByteString.EMPTY;
        private ByteString currentState_ = ByteString.EMPTY;
        private ByteString privacyFsm_ = ByteString.EMPTY;
        private ByteString privacy_ = ByteString.EMPTY;
        private SessionCountersOuterClass.SessionCounters sessionCounters_;
        private ByteString sessionToken_ = ByteString.EMPTY;

        /* access modifiers changed from: private */
        public void clearAllowedPii() {
            this.allowedPii_ = null;
            this.bitField0_ &= -17;
        }

        /* access modifiers changed from: private */
        public void clearSessionCounters() {
            this.sessionCounters_ = null;
            this.bitField0_ &= -9;
        }

        public static MutableData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public ByteString getCache() {
            return this.cache_;
        }

        public ByteString getCurrentState() {
            return this.currentState_;
        }

        public ByteString getPrivacy() {
            return this.privacy_;
        }

        public ByteString getPrivacyFsm() {
            return this.privacyFsm_;
        }

        public ByteString getSessionToken() {
            return this.sessionToken_;
        }

        public boolean hasAllowedPii() {
            return (this.bitField0_ & 16) != 0;
        }

        public boolean hasCache() {
            return (this.bitField0_ & 32) != 0;
        }

        public boolean hasCurrentState() {
            return (this.bitField0_ & 1) != 0;
        }

        public boolean hasPrivacy() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasPrivacyFsm() {
            return (this.bitField0_ & 64) != 0;
        }

        public boolean hasSessionCounters() {
            return (this.bitField0_ & 8) != 0;
        }

        public boolean hasSessionToken() {
            return (this.bitField0_ & 2) != 0;
        }

        private MutableData() {
        }

        /* access modifiers changed from: private */
        public void setCurrentState(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.currentState_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearCurrentState() {
            this.bitField0_ &= -2;
            this.currentState_ = getDefaultInstance().getCurrentState();
        }

        /* access modifiers changed from: private */
        public void setSessionToken(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.sessionToken_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearSessionToken() {
            this.bitField0_ &= -3;
            this.sessionToken_ = getDefaultInstance().getSessionToken();
        }

        /* access modifiers changed from: private */
        public void setPrivacy(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.privacy_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearPrivacy() {
            this.bitField0_ &= -5;
            this.privacy_ = getDefaultInstance().getPrivacy();
        }

        public SessionCountersOuterClass.SessionCounters getSessionCounters() {
            SessionCountersOuterClass.SessionCounters sessionCounters = this.sessionCounters_;
            return sessionCounters == null ? SessionCountersOuterClass.SessionCounters.getDefaultInstance() : sessionCounters;
        }

        /* access modifiers changed from: private */
        public void setSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
            sessionCounters.getClass();
            this.sessionCounters_ = sessionCounters;
            this.bitField0_ |= 8;
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
            this.bitField0_ |= 8;
        }

        public AllowedPiiOuterClass.AllowedPii getAllowedPii() {
            AllowedPiiOuterClass.AllowedPii allowedPii = this.allowedPii_;
            return allowedPii == null ? AllowedPiiOuterClass.AllowedPii.getDefaultInstance() : allowedPii;
        }

        /* access modifiers changed from: private */
        public void setAllowedPii(AllowedPiiOuterClass.AllowedPii allowedPii) {
            allowedPii.getClass();
            this.allowedPii_ = allowedPii;
            this.bitField0_ |= 16;
        }

        /* access modifiers changed from: private */
        public void mergeAllowedPii(AllowedPiiOuterClass.AllowedPii allowedPii) {
            allowedPii.getClass();
            AllowedPiiOuterClass.AllowedPii allowedPii2 = this.allowedPii_;
            if (allowedPii2 == null || allowedPii2 == AllowedPiiOuterClass.AllowedPii.getDefaultInstance()) {
                this.allowedPii_ = allowedPii;
            } else {
                this.allowedPii_ = (AllowedPiiOuterClass.AllowedPii) ((AllowedPiiOuterClass.AllowedPii.Builder) AllowedPiiOuterClass.AllowedPii.newBuilder(this.allowedPii_).mergeFrom(allowedPii)).buildPartial();
            }
            this.bitField0_ |= 16;
        }

        /* access modifiers changed from: private */
        public void setCache(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.cache_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearCache() {
            this.bitField0_ &= -33;
            this.cache_ = getDefaultInstance().getCache();
        }

        /* access modifiers changed from: private */
        public void setPrivacyFsm(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.privacyFsm_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearPrivacyFsm() {
            this.bitField0_ &= -65;
            this.privacyFsm_ = getDefaultInstance().getPrivacyFsm();
        }

        public static MutableData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static MutableData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MutableData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MutableData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MutableData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MutableData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MutableData parseFrom(InputStream inputStream) throws IOException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MutableData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MutableData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MutableData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MutableData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MutableData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MutableData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MutableData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MutableData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MutableData mutableData) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(mutableData);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MutableData, Builder> implements MutableDataOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(MutableData.DEFAULT_INSTANCE);
            }

            public boolean hasCurrentState() {
                return ((MutableData) this.instance).hasCurrentState();
            }

            public ByteString getCurrentState() {
                return ((MutableData) this.instance).getCurrentState();
            }

            public Builder setCurrentState(ByteString byteString) {
                copyOnWrite();
                ((MutableData) this.instance).setCurrentState(byteString);
                return this;
            }

            public Builder clearCurrentState() {
                copyOnWrite();
                ((MutableData) this.instance).clearCurrentState();
                return this;
            }

            public boolean hasSessionToken() {
                return ((MutableData) this.instance).hasSessionToken();
            }

            public ByteString getSessionToken() {
                return ((MutableData) this.instance).getSessionToken();
            }

            public Builder setSessionToken(ByteString byteString) {
                copyOnWrite();
                ((MutableData) this.instance).setSessionToken(byteString);
                return this;
            }

            public Builder clearSessionToken() {
                copyOnWrite();
                ((MutableData) this.instance).clearSessionToken();
                return this;
            }

            public boolean hasPrivacy() {
                return ((MutableData) this.instance).hasPrivacy();
            }

            public ByteString getPrivacy() {
                return ((MutableData) this.instance).getPrivacy();
            }

            public Builder setPrivacy(ByteString byteString) {
                copyOnWrite();
                ((MutableData) this.instance).setPrivacy(byteString);
                return this;
            }

            public Builder clearPrivacy() {
                copyOnWrite();
                ((MutableData) this.instance).clearPrivacy();
                return this;
            }

            public boolean hasSessionCounters() {
                return ((MutableData) this.instance).hasSessionCounters();
            }

            public SessionCountersOuterClass.SessionCounters getSessionCounters() {
                return ((MutableData) this.instance).getSessionCounters();
            }

            public Builder setSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
                copyOnWrite();
                ((MutableData) this.instance).setSessionCounters(sessionCounters);
                return this;
            }

            public Builder setSessionCounters(SessionCountersOuterClass.SessionCounters.Builder builder) {
                copyOnWrite();
                ((MutableData) this.instance).setSessionCounters((SessionCountersOuterClass.SessionCounters) builder.build());
                return this;
            }

            public Builder mergeSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
                copyOnWrite();
                ((MutableData) this.instance).mergeSessionCounters(sessionCounters);
                return this;
            }

            public Builder clearSessionCounters() {
                copyOnWrite();
                ((MutableData) this.instance).clearSessionCounters();
                return this;
            }

            public boolean hasAllowedPii() {
                return ((MutableData) this.instance).hasAllowedPii();
            }

            public AllowedPiiOuterClass.AllowedPii getAllowedPii() {
                return ((MutableData) this.instance).getAllowedPii();
            }

            public Builder setAllowedPii(AllowedPiiOuterClass.AllowedPii allowedPii) {
                copyOnWrite();
                ((MutableData) this.instance).setAllowedPii(allowedPii);
                return this;
            }

            public Builder setAllowedPii(AllowedPiiOuterClass.AllowedPii.Builder builder) {
                copyOnWrite();
                ((MutableData) this.instance).setAllowedPii((AllowedPiiOuterClass.AllowedPii) builder.build());
                return this;
            }

            public Builder mergeAllowedPii(AllowedPiiOuterClass.AllowedPii allowedPii) {
                copyOnWrite();
                ((MutableData) this.instance).mergeAllowedPii(allowedPii);
                return this;
            }

            public Builder clearAllowedPii() {
                copyOnWrite();
                ((MutableData) this.instance).clearAllowedPii();
                return this;
            }

            public boolean hasCache() {
                return ((MutableData) this.instance).hasCache();
            }

            public ByteString getCache() {
                return ((MutableData) this.instance).getCache();
            }

            public Builder setCache(ByteString byteString) {
                copyOnWrite();
                ((MutableData) this.instance).setCache(byteString);
                return this;
            }

            public Builder clearCache() {
                copyOnWrite();
                ((MutableData) this.instance).clearCache();
                return this;
            }

            public boolean hasPrivacyFsm() {
                return ((MutableData) this.instance).hasPrivacyFsm();
            }

            public ByteString getPrivacyFsm() {
                return ((MutableData) this.instance).getPrivacyFsm();
            }

            public Builder setPrivacyFsm(ByteString byteString) {
                copyOnWrite();
                ((MutableData) this.instance).setPrivacyFsm(byteString);
                return this;
            }

            public Builder clearPrivacyFsm() {
                copyOnWrite();
                ((MutableData) this.instance).clearPrivacyFsm();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new MutableData();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u000f\u0007\u0000\u0000\u0000\u0001ည\u0000\nည\u0001\u000bည\u0002\fဉ\u0003\rဉ\u0004\u000eည\u0005\u000fည\u0006", new Object[]{"bitField0_", "currentState_", "sessionToken_", "privacy_", "sessionCounters_", "allowedPii_", "cache_", "privacyFsm_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MutableData> parser = PARSER;
                    if (parser == null) {
                        synchronized (MutableData.class) {
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
            MutableData mutableData = new MutableData();
            DEFAULT_INSTANCE = mutableData;
            GeneratedMessageLite.registerDefaultInstance(MutableData.class, mutableData);
        }

        public static Parser<MutableData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: gateway.v1.MutableDataOuterClass$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: gateway.v1.MutableDataOuterClass.AnonymousClass1.<clinit>():void");
        }
    }
}
