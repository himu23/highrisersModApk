package com.ironsource;

import com.ironsource.sdk.utils.SDKUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/ironsource/m5;", "", "", "c", "a", "b", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class m5 {
    public final String a() {
        String str = m9.f;
        Intrinsics.checkNotNullExpressionValue(str, "OMID_LIB_VERSION");
        return str;
    }

    public final String b() {
        return m9.e;
    }

    public final String c() {
        String sDKVersion = SDKUtils.getSDKVersion();
        Intrinsics.checkNotNullExpressionValue(sDKVersion, "getSDKVersion()");
        return sDKVersion;
    }
}
