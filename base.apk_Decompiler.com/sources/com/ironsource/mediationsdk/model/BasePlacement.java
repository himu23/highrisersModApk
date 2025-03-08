package com.ironsource.mediationsdk.model;

import com.ironsource.ga;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/ironsource/mediationsdk/model/BasePlacement;", "", "", "id", "", "isPlacementId", "", "toString", "a", "I", "getPlacementId", "()I", "placementId", "b", "Ljava/lang/String;", "getPlacementName", "()Ljava/lang/String;", "placementName", "c", "Z", "isDefault", "()Z", "Lcom/ironsource/ga;", "d", "Lcom/ironsource/ga;", "getPlacementAvailabilitySettings", "()Lcom/ironsource/ga;", "placementAvailabilitySettings", "<init>", "(ILjava/lang/String;ZLcom/ironsource/ga;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public abstract class BasePlacement {
    private final int a;
    private final String b;
    private final boolean c;
    private final ga d;

    public BasePlacement(int i, String str, boolean z, ga gaVar) {
        Intrinsics.checkNotNullParameter(str, "placementName");
        this.a = i;
        this.b = str;
        this.c = z;
        this.d = gaVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasePlacement(int i, String str, boolean z, ga gaVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : gaVar);
    }

    public final ga getPlacementAvailabilitySettings() {
        return this.d;
    }

    public final int getPlacementId() {
        return this.a;
    }

    public final String getPlacementName() {
        return this.b;
    }

    public final boolean isDefault() {
        return this.c;
    }

    public final boolean isPlacementId(int i) {
        return this.a == i;
    }

    public String toString() {
        return "placement name: " + this.b;
    }
}
