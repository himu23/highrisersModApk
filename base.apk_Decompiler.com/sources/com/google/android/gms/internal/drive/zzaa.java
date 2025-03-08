package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.ironsource.m2;

public final class zzaa extends Metadata {
    private final MetadataBundle zzdt;

    public zzaa(MetadataBundle metadataBundle) {
        this.zzdt = metadataBundle;
    }

    public final boolean isDataValid() {
        return this.zzdt != null;
    }

    public final <T> T zza(MetadataField<T> metadataField) {
        return this.zzdt.zza(metadataField);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzdt);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17);
        sb.append("Metadata [mImpl=");
        sb.append(valueOf);
        sb.append(m2.i.e);
        return sb.toString();
    }

    public final /* synthetic */ Object freeze() {
        return new zzaa(this.zzdt.zzbf());
    }
}
