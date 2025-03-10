package gateway.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class GetTokenEventRequestOuterClass {

    public interface GetTokenEventRequestOrBuilder extends MessageLiteOrBuilder {
        ByteString getInterstitial();

        ByteString getRewarded();

        boolean hasInterstitial();

        boolean hasRewarded();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private GetTokenEventRequestOuterClass() {
    }

    public static final class GetTokenEventRequest extends GeneratedMessageLite<GetTokenEventRequest, Builder> implements GetTokenEventRequestOrBuilder {
        /* access modifiers changed from: private */
        public static final GetTokenEventRequest DEFAULT_INSTANCE;
        public static final int INTERSTITIAL_FIELD_NUMBER = 2;
        private static volatile Parser<GetTokenEventRequest> PARSER = null;
        public static final int REWARDED_FIELD_NUMBER = 1;
        private int bitField0_;
        private ByteString interstitial_ = ByteString.EMPTY;
        private ByteString rewarded_ = ByteString.EMPTY;

        public static GetTokenEventRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public ByteString getInterstitial() {
            return this.interstitial_;
        }

        public ByteString getRewarded() {
            return this.rewarded_;
        }

        public boolean hasInterstitial() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasRewarded() {
            return (this.bitField0_ & 1) != 0;
        }

        private GetTokenEventRequest() {
        }

        /* access modifiers changed from: private */
        public void setRewarded(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.rewarded_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearRewarded() {
            this.bitField0_ &= -2;
            this.rewarded_ = getDefaultInstance().getRewarded();
        }

        /* access modifiers changed from: private */
        public void setInterstitial(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.interstitial_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearInterstitial() {
            this.bitField0_ &= -3;
            this.interstitial_ = getDefaultInstance().getInterstitial();
        }

        public static GetTokenEventRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GetTokenEventRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GetTokenEventRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetTokenEventRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GetTokenEventRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetTokenEventRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GetTokenEventRequest parseFrom(InputStream inputStream) throws IOException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetTokenEventRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetTokenEventRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetTokenEventRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetTokenEventRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetTokenEventRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetTokenEventRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GetTokenEventRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetTokenEventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GetTokenEventRequest getTokenEventRequest) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(getTokenEventRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GetTokenEventRequest, Builder> implements GetTokenEventRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(GetTokenEventRequest.DEFAULT_INSTANCE);
            }

            public boolean hasRewarded() {
                return ((GetTokenEventRequest) this.instance).hasRewarded();
            }

            public ByteString getRewarded() {
                return ((GetTokenEventRequest) this.instance).getRewarded();
            }

            public Builder setRewarded(ByteString byteString) {
                copyOnWrite();
                ((GetTokenEventRequest) this.instance).setRewarded(byteString);
                return this;
            }

            public Builder clearRewarded() {
                copyOnWrite();
                ((GetTokenEventRequest) this.instance).clearRewarded();
                return this;
            }

            public boolean hasInterstitial() {
                return ((GetTokenEventRequest) this.instance).hasInterstitial();
            }

            public ByteString getInterstitial() {
                return ((GetTokenEventRequest) this.instance).getInterstitial();
            }

            public Builder setInterstitial(ByteString byteString) {
                copyOnWrite();
                ((GetTokenEventRequest) this.instance).setInterstitial(byteString);
                return this;
            }

            public Builder clearInterstitial() {
                copyOnWrite();
                ((GetTokenEventRequest) this.instance).clearInterstitial();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetTokenEventRequest();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001", new Object[]{"bitField0_", "rewarded_", "interstitial_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GetTokenEventRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (GetTokenEventRequest.class) {
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
            GetTokenEventRequest getTokenEventRequest = new GetTokenEventRequest();
            DEFAULT_INSTANCE = getTokenEventRequest;
            GeneratedMessageLite.registerDefaultInstance(GetTokenEventRequest.class, getTokenEventRequest);
        }

        public static Parser<GetTokenEventRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: gateway.v1.GetTokenEventRequestOuterClass$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: gateway.v1.GetTokenEventRequestOuterClass.AnonymousClass1.<clinit>():void");
        }
    }
}
