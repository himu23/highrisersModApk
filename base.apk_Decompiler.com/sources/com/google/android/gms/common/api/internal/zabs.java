package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;
import com.ironsource.m2;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
final class zabs {
    /* access modifiers changed from: private */
    public final ApiKey<?> zaa;
    /* access modifiers changed from: private */
    public final Feature zab;

    /* synthetic */ zabs(ApiKey apiKey, Feature feature, zabr zabr) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabs = (zabs) obj;
            if (!Objects.equal(this.zaa, zabs.zaa) || !Objects.equal(this.zab, zabs.zab)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zaa, this.zab);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(m2.h.W, this.zaa).add("feature", this.zab).toString();
    }
}
