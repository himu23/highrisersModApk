package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    private int accountType;
    private String zzbg;
    private String zzbh;
    private String zzbi;
    private int zzbj;
    private boolean zzbk;

    public zzr(String str, int i, String str2, String str3, int i2, boolean z) {
        this.zzbg = str;
        this.accountType = i;
        this.zzbh = str2;
        this.zzbi = str3;
        this.zzbj = i2;
        this.zzbk = z;
    }

    private static boolean zzb(int i) {
        switch (i) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, !zzb(this.accountType) ? null : this.zzbg, false);
        int i2 = -1;
        SafeParcelWriter.writeInt(parcel, 3, !zzb(this.accountType) ? -1 : this.accountType);
        SafeParcelWriter.writeString(parcel, 4, this.zzbh, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbi, false);
        int i3 = this.zzbj;
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3) {
            i2 = i3;
        }
        SafeParcelWriter.writeInt(parcel, 6, i2);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbg, Integer.valueOf(this.accountType), Integer.valueOf(this.zzbj), Boolean.valueOf(this.zzbk));
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            zzr zzr = (zzr) obj;
            return Objects.equal(this.zzbg, zzr.zzbg) && this.accountType == zzr.accountType && this.zzbj == zzr.zzbj && this.zzbk == zzr.zzbk;
        }
    }
}
