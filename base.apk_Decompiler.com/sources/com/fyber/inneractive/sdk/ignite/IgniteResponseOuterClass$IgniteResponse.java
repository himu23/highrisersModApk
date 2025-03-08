package com.fyber.inneractive.sdk.ignite;

import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite;
import com.fyber.inneractive.sdk.protobuf.i;
import com.fyber.inneractive.sdk.protobuf.j;
import com.fyber.inneractive.sdk.protobuf.p0;
import com.fyber.inneractive.sdk.protobuf.q;
import com.fyber.inneractive.sdk.protobuf.w0;
import com.fyber.inneractive.sdk.protobuf.z;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class IgniteResponseOuterClass$IgniteResponse extends GeneratedMessageLite<IgniteResponseOuterClass$IgniteResponse, a> implements p0 {
    public static final int CLIENTID_FIELD_NUMBER = 1;
    public static final int CLIENTSECRET_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final IgniteResponseOuterClass$IgniteResponse DEFAULT_INSTANCE;
    private static volatile w0<IgniteResponseOuterClass$IgniteResponse> PARSER;
    private int bitField0_;
    private String clientId_ = "";
    private String clientSecret_ = "";

    public static final class a extends GeneratedMessageLite.b<IgniteResponseOuterClass$IgniteResponse, a> implements p0 {
        public a() {
            super(IgniteResponseOuterClass$IgniteResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        IgniteResponseOuterClass$IgniteResponse igniteResponseOuterClass$IgniteResponse = new IgniteResponseOuterClass$IgniteResponse();
        DEFAULT_INSTANCE = igniteResponseOuterClass$IgniteResponse;
        GeneratedMessageLite.registerDefaultInstance(IgniteResponseOuterClass$IgniteResponse.class, igniteResponseOuterClass$IgniteResponse);
    }

    private IgniteResponseOuterClass$IgniteResponse() {
    }

    public static IgniteResponseOuterClass$IgniteResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static IgniteResponseOuterClass$IgniteResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(ByteBuffer byteBuffer) throws z {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static w0<IgniteResponseOuterClass$IgniteResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setClientId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.clientId_ = str;
    }

    /* access modifiers changed from: private */
    public void setClientIdBytes(i iVar) {
        com.fyber.inneractive.sdk.protobuf.a.checkByteStringIsUtf8(iVar);
        this.clientId_ = iVar.i();
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    public void setClientSecret(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.clientSecret_ = str;
    }

    /* access modifiers changed from: private */
    public void setClientSecretBytes(i iVar) {
        com.fyber.inneractive.sdk.protobuf.a.checkByteStringIsUtf8(iVar);
        this.clientSecret_ = iVar.i();
        this.bitField0_ |= 2;
    }

    public final Object dynamicMethod(GeneratedMessageLite.f fVar, Object obj, Object obj2) {
        switch (m.a[fVar.ordinal()]) {
            case 1:
                return new IgniteResponseOuterClass$IgniteResponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001", new Object[]{"bitField0_", "clientId_", "clientSecret_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                w0<IgniteResponseOuterClass$IgniteResponse> w0Var = PARSER;
                if (w0Var == null) {
                    synchronized (IgniteResponseOuterClass$IgniteResponse.class) {
                        w0Var = PARSER;
                        if (w0Var == null) {
                            w0Var = new GeneratedMessageLite.c<>(DEFAULT_INSTANCE);
                            PARSER = w0Var;
                        }
                    }
                }
                return w0Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getClientId() {
        return this.clientId_;
    }

    public i getClientIdBytes() {
        return i.a(this.clientId_);
    }

    public String getClientSecret() {
        return this.clientSecret_;
    }

    public i getClientSecretBytes() {
        return i.a(this.clientSecret_);
    }

    public boolean hasClientId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasClientSecret() {
        return (this.bitField0_ & 2) != 0;
    }

    /* access modifiers changed from: private */
    public void clearClientId() {
        this.bitField0_ &= -2;
        this.clientId_ = getDefaultInstance().getClientId();
    }

    /* access modifiers changed from: private */
    public void clearClientSecret() {
        this.bitField0_ &= -3;
        this.clientSecret_ = getDefaultInstance().getClientSecret();
    }

    public static a newBuilder(IgniteResponseOuterClass$IgniteResponse igniteResponseOuterClass$IgniteResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(igniteResponseOuterClass$IgniteResponse);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, qVar);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(ByteBuffer byteBuffer, q qVar) throws z {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, qVar);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(i iVar) throws z {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(i iVar, q qVar) throws z {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar, qVar);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(byte[] bArr) throws z {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(byte[] bArr, q qVar) throws z {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, qVar);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(InputStream inputStream) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, qVar);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(j jVar) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(j jVar, q qVar) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, jVar, qVar);
    }
}
