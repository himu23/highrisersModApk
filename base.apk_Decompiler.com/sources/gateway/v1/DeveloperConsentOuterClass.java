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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class DeveloperConsentOuterClass {

    public interface DeveloperConsentOptionOrBuilder extends MessageLiteOrBuilder {
        String getCustomType();

        ByteString getCustomTypeBytes();

        DeveloperConsentType getType();

        int getTypeValue();

        DeveloperConsentChoice getValue();

        int getValueValue();

        boolean hasCustomType();
    }

    public interface DeveloperConsentOrBuilder extends MessageLiteOrBuilder {
        DeveloperConsentOption getOptions(int i);

        int getOptionsCount();

        List<DeveloperConsentOption> getOptionsList();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private DeveloperConsentOuterClass() {
    }

    public enum DeveloperConsentType implements Internal.EnumLite {
        DEVELOPER_CONSENT_TYPE_UNSPECIFIED(0),
        DEVELOPER_CONSENT_TYPE_CUSTOM(1),
        DEVELOPER_CONSENT_TYPE_NON_BEHAVIORAL(2),
        DEVELOPER_CONSENT_TYPE_PIPL_CONSENT(3),
        DEVELOPER_CONSENT_TYPE_PRIVACY_CONSENT(4),
        DEVELOPER_CONSENT_TYPE_GDPR_CONSENT(5),
        DEVELOPER_CONSENT_TYPE_USER_OVER_AGE_LIMIT(6),
        UNRECOGNIZED(-1);
        
        public static final int DEVELOPER_CONSENT_TYPE_CUSTOM_VALUE = 1;
        public static final int DEVELOPER_CONSENT_TYPE_GDPR_CONSENT_VALUE = 5;
        public static final int DEVELOPER_CONSENT_TYPE_NON_BEHAVIORAL_VALUE = 2;
        public static final int DEVELOPER_CONSENT_TYPE_PIPL_CONSENT_VALUE = 3;
        public static final int DEVELOPER_CONSENT_TYPE_PRIVACY_CONSENT_VALUE = 4;
        public static final int DEVELOPER_CONSENT_TYPE_UNSPECIFIED_VALUE = 0;
        public static final int DEVELOPER_CONSENT_TYPE_USER_OVER_AGE_LIMIT_VALUE = 6;
        private static final Internal.EnumLiteMap<DeveloperConsentType> internalValueMap = null;
        private final int value;

        public static DeveloperConsentType forNumber(int i) {
            switch (i) {
                case 0:
                    return DEVELOPER_CONSENT_TYPE_UNSPECIFIED;
                case 1:
                    return DEVELOPER_CONSENT_TYPE_CUSTOM;
                case 2:
                    return DEVELOPER_CONSENT_TYPE_NON_BEHAVIORAL;
                case 3:
                    return DEVELOPER_CONSENT_TYPE_PIPL_CONSENT;
                case 4:
                    return DEVELOPER_CONSENT_TYPE_PRIVACY_CONSENT;
                case 5:
                    return DEVELOPER_CONSENT_TYPE_GDPR_CONSENT;
                case 6:
                    return DEVELOPER_CONSENT_TYPE_USER_OVER_AGE_LIMIT;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<DeveloperConsentType> internalGetValueMap() {
            return internalValueMap;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<DeveloperConsentType>() {
                public DeveloperConsentType findValueByNumber(int i) {
                    return DeveloperConsentType.forNumber(i);
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
        public static DeveloperConsentType valueOf(int i) {
            return forNumber(i);
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return DeveloperConsentTypeVerifier.INSTANCE;
        }

        private static final class DeveloperConsentTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            private DeveloperConsentTypeVerifier() {
            }

            static {
                INSTANCE = new DeveloperConsentTypeVerifier();
            }

            public boolean isInRange(int i) {
                return DeveloperConsentType.forNumber(i) != null;
            }
        }

        private DeveloperConsentType(int i) {
            this.value = i;
        }
    }

    public enum DeveloperConsentChoice implements Internal.EnumLite {
        DEVELOPER_CONSENT_CHOICE_UNSPECIFIED(0),
        DEVELOPER_CONSENT_CHOICE_TRUE(1),
        DEVELOPER_CONSENT_CHOICE_FALSE(2),
        UNRECOGNIZED(-1);
        
        public static final int DEVELOPER_CONSENT_CHOICE_FALSE_VALUE = 2;
        public static final int DEVELOPER_CONSENT_CHOICE_TRUE_VALUE = 1;
        public static final int DEVELOPER_CONSENT_CHOICE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<DeveloperConsentChoice> internalValueMap = null;
        private final int value;

        public static DeveloperConsentChoice forNumber(int i) {
            if (i == 0) {
                return DEVELOPER_CONSENT_CHOICE_UNSPECIFIED;
            }
            if (i == 1) {
                return DEVELOPER_CONSENT_CHOICE_TRUE;
            }
            if (i != 2) {
                return null;
            }
            return DEVELOPER_CONSENT_CHOICE_FALSE;
        }

        public static Internal.EnumLiteMap<DeveloperConsentChoice> internalGetValueMap() {
            return internalValueMap;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<DeveloperConsentChoice>() {
                public DeveloperConsentChoice findValueByNumber(int i) {
                    return DeveloperConsentChoice.forNumber(i);
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
        public static DeveloperConsentChoice valueOf(int i) {
            return forNumber(i);
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return DeveloperConsentChoiceVerifier.INSTANCE;
        }

        private static final class DeveloperConsentChoiceVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            private DeveloperConsentChoiceVerifier() {
            }

            static {
                INSTANCE = new DeveloperConsentChoiceVerifier();
            }

            public boolean isInRange(int i) {
                return DeveloperConsentChoice.forNumber(i) != null;
            }
        }

        private DeveloperConsentChoice(int i) {
            this.value = i;
        }
    }

    public static final class DeveloperConsentOption extends GeneratedMessageLite<DeveloperConsentOption, Builder> implements DeveloperConsentOptionOrBuilder {
        public static final int CUSTOM_TYPE_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final DeveloperConsentOption DEFAULT_INSTANCE;
        private static volatile Parser<DeveloperConsentOption> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 3;
        private int bitField0_;
        private String customType_ = "";
        private int type_;
        private int value_;

        /* access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.value_ = 0;
        }

        public static DeveloperConsentOption getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* access modifiers changed from: private */
        public void setTypeValue(int i) {
            this.type_ = i;
        }

        /* access modifiers changed from: private */
        public void setValueValue(int i) {
            this.value_ = i;
        }

        public String getCustomType() {
            return this.customType_;
        }

        public int getTypeValue() {
            return this.type_;
        }

        public int getValueValue() {
            return this.value_;
        }

        public boolean hasCustomType() {
            return (this.bitField0_ & 1) != 0;
        }

        private DeveloperConsentOption() {
        }

        public DeveloperConsentType getType() {
            DeveloperConsentType forNumber = DeveloperConsentType.forNumber(this.type_);
            return forNumber == null ? DeveloperConsentType.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setType(DeveloperConsentType developerConsentType) {
            this.type_ = developerConsentType.getNumber();
        }

        public ByteString getCustomTypeBytes() {
            return ByteString.copyFromUtf8(this.customType_);
        }

        /* access modifiers changed from: private */
        public void setCustomType(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.customType_ = str;
        }

        /* access modifiers changed from: private */
        public void clearCustomType() {
            this.bitField0_ &= -2;
            this.customType_ = getDefaultInstance().getCustomType();
        }

        /* access modifiers changed from: private */
        public void setCustomTypeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.customType_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public DeveloperConsentChoice getValue() {
            DeveloperConsentChoice forNumber = DeveloperConsentChoice.forNumber(this.value_);
            return forNumber == null ? DeveloperConsentChoice.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setValue(DeveloperConsentChoice developerConsentChoice) {
            this.value_ = developerConsentChoice.getNumber();
        }

        public static DeveloperConsentOption parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DeveloperConsentOption parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DeveloperConsentOption parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DeveloperConsentOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DeveloperConsentOption parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeveloperConsentOption parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DeveloperConsentOption parseFrom(InputStream inputStream) throws IOException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeveloperConsentOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeveloperConsentOption parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeveloperConsentOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeveloperConsentOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeveloperConsentOption) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeveloperConsentOption parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DeveloperConsentOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeveloperConsentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeveloperConsentOption developerConsentOption) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(developerConsentOption);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DeveloperConsentOption, Builder> implements DeveloperConsentOptionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(DeveloperConsentOption.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return ((DeveloperConsentOption) this.instance).getTypeValue();
            }

            public Builder setTypeValue(int i) {
                copyOnWrite();
                ((DeveloperConsentOption) this.instance).setTypeValue(i);
                return this;
            }

            public DeveloperConsentType getType() {
                return ((DeveloperConsentOption) this.instance).getType();
            }

            public Builder setType(DeveloperConsentType developerConsentType) {
                copyOnWrite();
                ((DeveloperConsentOption) this.instance).setType(developerConsentType);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((DeveloperConsentOption) this.instance).clearType();
                return this;
            }

            public boolean hasCustomType() {
                return ((DeveloperConsentOption) this.instance).hasCustomType();
            }

            public String getCustomType() {
                return ((DeveloperConsentOption) this.instance).getCustomType();
            }

            public ByteString getCustomTypeBytes() {
                return ((DeveloperConsentOption) this.instance).getCustomTypeBytes();
            }

            public Builder setCustomType(String str) {
                copyOnWrite();
                ((DeveloperConsentOption) this.instance).setCustomType(str);
                return this;
            }

            public Builder clearCustomType() {
                copyOnWrite();
                ((DeveloperConsentOption) this.instance).clearCustomType();
                return this;
            }

            public Builder setCustomTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((DeveloperConsentOption) this.instance).setCustomTypeBytes(byteString);
                return this;
            }

            public int getValueValue() {
                return ((DeveloperConsentOption) this.instance).getValueValue();
            }

            public Builder setValueValue(int i) {
                copyOnWrite();
                ((DeveloperConsentOption) this.instance).setValueValue(i);
                return this;
            }

            public DeveloperConsentChoice getValue() {
                return ((DeveloperConsentOption) this.instance).getValue();
            }

            public Builder setValue(DeveloperConsentChoice developerConsentChoice) {
                copyOnWrite();
                ((DeveloperConsentOption) this.instance).setValue(developerConsentChoice);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((DeveloperConsentOption) this.instance).clearValue();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DeveloperConsentOption();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002ለ\u0000\u0003\f", new Object[]{"bitField0_", "type_", "customType_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DeveloperConsentOption> parser = PARSER;
                    if (parser == null) {
                        synchronized (DeveloperConsentOption.class) {
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
            DeveloperConsentOption developerConsentOption = new DeveloperConsentOption();
            DEFAULT_INSTANCE = developerConsentOption;
            GeneratedMessageLite.registerDefaultInstance(DeveloperConsentOption.class, developerConsentOption);
        }

        public static Parser<DeveloperConsentOption> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: gateway.v1.DeveloperConsentOuterClass$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: gateway.v1.DeveloperConsentOuterClass.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class DeveloperConsent extends GeneratedMessageLite<DeveloperConsent, Builder> implements DeveloperConsentOrBuilder {
        /* access modifiers changed from: private */
        public static final DeveloperConsent DEFAULT_INSTANCE;
        public static final int OPTIONS_FIELD_NUMBER = 1;
        private static volatile Parser<DeveloperConsent> PARSER;
        private Internal.ProtobufList<DeveloperConsentOption> options_ = emptyProtobufList();

        public static DeveloperConsent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public List<DeveloperConsentOption> getOptionsList() {
            return this.options_;
        }

        public List<? extends DeveloperConsentOptionOrBuilder> getOptionsOrBuilderList() {
            return this.options_;
        }

        private DeveloperConsent() {
        }

        public int getOptionsCount() {
            return this.options_.size();
        }

        public DeveloperConsentOption getOptions(int i) {
            return (DeveloperConsentOption) this.options_.get(i);
        }

        public DeveloperConsentOptionOrBuilder getOptionsOrBuilder(int i) {
            return (DeveloperConsentOptionOrBuilder) this.options_.get(i);
        }

        private void ensureOptionsIsMutable() {
            Internal.ProtobufList<DeveloperConsentOption> protobufList = this.options_;
            if (!protobufList.isModifiable()) {
                this.options_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
        }

        /* access modifiers changed from: private */
        public void setOptions(int i, DeveloperConsentOption developerConsentOption) {
            developerConsentOption.getClass();
            ensureOptionsIsMutable();
            this.options_.set(i, developerConsentOption);
        }

        /* access modifiers changed from: private */
        public void addOptions(DeveloperConsentOption developerConsentOption) {
            developerConsentOption.getClass();
            ensureOptionsIsMutable();
            this.options_.add(developerConsentOption);
        }

        /* access modifiers changed from: private */
        public void addOptions(int i, DeveloperConsentOption developerConsentOption) {
            developerConsentOption.getClass();
            ensureOptionsIsMutable();
            this.options_.add(i, developerConsentOption);
        }

        /* access modifiers changed from: private */
        public void addAllOptions(Iterable<? extends DeveloperConsentOption> iterable) {
            ensureOptionsIsMutable();
            AbstractMessageLite.addAll(iterable, this.options_);
        }

        /* access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removeOptions(int i) {
            ensureOptionsIsMutable();
            this.options_.remove(i);
        }

        public static DeveloperConsent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DeveloperConsent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DeveloperConsent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DeveloperConsent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DeveloperConsent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeveloperConsent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DeveloperConsent parseFrom(InputStream inputStream) throws IOException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeveloperConsent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeveloperConsent parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeveloperConsent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeveloperConsent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeveloperConsent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeveloperConsent parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DeveloperConsent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeveloperConsent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeveloperConsent developerConsent) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(developerConsent);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DeveloperConsent, Builder> implements DeveloperConsentOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(DeveloperConsent.DEFAULT_INSTANCE);
            }

            public List<DeveloperConsentOption> getOptionsList() {
                return Collections.unmodifiableList(((DeveloperConsent) this.instance).getOptionsList());
            }

            public int getOptionsCount() {
                return ((DeveloperConsent) this.instance).getOptionsCount();
            }

            public DeveloperConsentOption getOptions(int i) {
                return ((DeveloperConsent) this.instance).getOptions(i);
            }

            public Builder setOptions(int i, DeveloperConsentOption developerConsentOption) {
                copyOnWrite();
                ((DeveloperConsent) this.instance).setOptions(i, developerConsentOption);
                return this;
            }

            public Builder setOptions(int i, DeveloperConsentOption.Builder builder) {
                copyOnWrite();
                ((DeveloperConsent) this.instance).setOptions(i, (DeveloperConsentOption) builder.build());
                return this;
            }

            public Builder addOptions(DeveloperConsentOption developerConsentOption) {
                copyOnWrite();
                ((DeveloperConsent) this.instance).addOptions(developerConsentOption);
                return this;
            }

            public Builder addOptions(int i, DeveloperConsentOption developerConsentOption) {
                copyOnWrite();
                ((DeveloperConsent) this.instance).addOptions(i, developerConsentOption);
                return this;
            }

            public Builder addOptions(DeveloperConsentOption.Builder builder) {
                copyOnWrite();
                ((DeveloperConsent) this.instance).addOptions((DeveloperConsentOption) builder.build());
                return this;
            }

            public Builder addOptions(int i, DeveloperConsentOption.Builder builder) {
                copyOnWrite();
                ((DeveloperConsent) this.instance).addOptions(i, (DeveloperConsentOption) builder.build());
                return this;
            }

            public Builder addAllOptions(Iterable<? extends DeveloperConsentOption> iterable) {
                copyOnWrite();
                ((DeveloperConsent) this.instance).addAllOptions(iterable);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((DeveloperConsent) this.instance).clearOptions();
                return this;
            }

            public Builder removeOptions(int i) {
                copyOnWrite();
                ((DeveloperConsent) this.instance).removeOptions(i);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DeveloperConsent();
                case 2:
                    return new Builder((AnonymousClass1) null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"options_", DeveloperConsentOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DeveloperConsent> parser = PARSER;
                    if (parser == null) {
                        synchronized (DeveloperConsent.class) {
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
            DeveloperConsent developerConsent = new DeveloperConsent();
            DEFAULT_INSTANCE = developerConsent;
            GeneratedMessageLite.registerDefaultInstance(DeveloperConsent.class, developerConsent);
        }

        public static Parser<DeveloperConsent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
