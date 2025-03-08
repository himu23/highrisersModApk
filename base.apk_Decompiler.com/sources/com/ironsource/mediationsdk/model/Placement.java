package com.ironsource.mediationsdk.model;

import com.ironsource.ga;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\n8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/ironsource/mediationsdk/model/Placement;", "Lcom/ironsource/mediationsdk/model/BasePlacement;", "", "toString", "<set-?>", "e", "Ljava/lang/String;", "getRewardName", "()Ljava/lang/String;", "rewardName", "", "f", "I", "getRewardAmount", "()I", "rewardAmount", "placementId", "placementName", "", "isDefault", "Lcom/ironsource/ga;", "placementAvailabilitySettings", "<init>", "(ILjava/lang/String;ZLjava/lang/String;ILcom/ironsource/ga;)V", "placement", "(Lcom/ironsource/mediationsdk/model/BasePlacement;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class Placement extends BasePlacement {
    private String e;
    private int f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Placement(int i, String str, boolean z, String str2, int i2, ga gaVar) {
        super(i, str, z, gaVar);
        Intrinsics.checkNotNullParameter(str, "placementName");
        Intrinsics.checkNotNullParameter(str2, IronSourceConstants.EVENTS_REWARD_NAME);
        this.f = i2;
        this.e = str2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Placement(BasePlacement basePlacement) {
        super(basePlacement.getPlacementId(), basePlacement.getPlacementName(), basePlacement.isDefault(), basePlacement.getPlacementAvailabilitySettings());
        Intrinsics.checkNotNullParameter(basePlacement, "placement");
        this.e = "";
    }

    public final int getRewardAmount() {
        return this.f;
    }

    public final String getRewardName() {
        return this.e;
    }

    public String toString() {
        return super.toString() + ", reward name: " + this.e + " , amount: " + this.f;
    }
}
