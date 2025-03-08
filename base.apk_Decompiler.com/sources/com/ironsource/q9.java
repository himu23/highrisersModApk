package com.ironsource;

import com.ironsource.mediationsdk.model.BasePlacement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ironsource/q9;", "Lcom/ironsource/mediationsdk/model/BasePlacement;", "", "toString", "", "placementId", "placementName", "", "isDefault", "<init>", "(ILjava/lang/String;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class q9 extends BasePlacement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q9(int i, String str, boolean z) {
        super(i, str, z, (ga) null);
        Intrinsics.checkNotNullParameter(str, "placementName");
    }

    public String toString() {
        return super.toString() + ", placement id: " + getPlacementId();
    }
}
