package com.unity3d.ads.network.model;

import com.applovin.sdk.AppLovinEventTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/network/model/HttpBody;", "", "ByteArrayBody", "EmptyBody", "StringBody", "Lcom/unity3d/ads/network/model/HttpBody$ByteArrayBody;", "Lcom/unity3d/ads/network/model/HttpBody$EmptyBody;", "Lcom/unity3d/ads/network/model/HttpBody$StringBody;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpBody.kt */
public interface HttpBody {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/unity3d/ads/network/model/HttpBody$StringBody;", "Lcom/unity3d/ads/network/model/HttpBody;", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HttpBody.kt */
    public static final class StringBody implements HttpBody {
        private final String content;

        public final String getContent() {
            return this.content;
        }

        public StringBody(String str) {
            Intrinsics.checkNotNullParameter(str, AppLovinEventTypes.USER_VIEWED_CONTENT);
            this.content = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/unity3d/ads/network/model/HttpBody$ByteArrayBody;", "Lcom/unity3d/ads/network/model/HttpBody;", "content", "", "([B)V", "getContent", "()[B", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HttpBody.kt */
    public static final class ByteArrayBody implements HttpBody {
        private final byte[] content;

        public final byte[] getContent() {
            return this.content;
        }

        public ByteArrayBody(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, AppLovinEventTypes.USER_VIEWED_CONTENT);
            this.content = bArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/unity3d/ads/network/model/HttpBody$EmptyBody;", "Lcom/unity3d/ads/network/model/HttpBody;", "()V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HttpBody.kt */
    public static final class EmptyBody implements HttpBody {
        public static final EmptyBody INSTANCE = new EmptyBody();

        private EmptyBody() {
        }
    }
}
