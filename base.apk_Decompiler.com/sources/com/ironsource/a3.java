package com.ironsource;

import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/ironsource/a3;", "Lcom/ironsource/h2;", "", "url", "Ljava/io/InputStream;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
final class a3 implements h2 {
    public static final a3 a = new a3();

    private a3() {
    }

    public InputStream a(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        InputStream openStream = new URL(str).openStream();
        Intrinsics.checkNotNullExpressionValue(openStream, "URL(url).openStream()");
        return openStream;
    }
}
