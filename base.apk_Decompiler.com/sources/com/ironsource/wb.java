package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\n\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/ironsource/wb;", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "networkSettings", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnit", "", "a", "", "Ljava/lang/String;", "mAdNetworkName", "b", "Z", "mIsBiddingNetwork", "c", "Ljava/lang/Boolean;", "mUseTestAds", "adNetworkName", "isBiddingNetwork", "useTestAds", "<init>", "(Ljava/lang/String;ZLjava/lang/Boolean;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class wb {
    private final String a;
    private final boolean b;
    private final Boolean c;

    public wb(String str, boolean z, Boolean bool) {
        this.a = str;
        this.b = z;
        this.c = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wb(String str, boolean z, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? Boolean.FALSE : bool);
    }

    public final boolean a() {
        return Intrinsics.areEqual((Object) this.c, (Object) Boolean.TRUE);
    }

    public final boolean a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        String str = this.a;
        if (str == null || str.length() == 0) {
            return true;
        }
        yb ybVar = yb.a;
        return Intrinsics.areEqual((Object) ybVar.a(networkSettings), (Object) this.a) && ybVar.a(networkSettings, ad_unit) == this.b;
    }
}
