package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new zzh();
    private final Filter zzbc;
    private final zzb<?> zzmd;
    private final zzd zzme;
    private final zzr zzmf;
    private final zzv zzmg;
    private final zzp<?> zzmh;
    private final zzt zzmi;
    private final zzn zzmj;
    private final zzl zzmk;
    private final zzz zzml;

    FilterHolder(zzb<?> zzb, zzd zzd, zzr zzr, zzv zzv, zzp<?> zzp, zzt zzt, zzn<?> zzn, zzl zzl, zzz zzz) {
        this.zzmd = zzb;
        this.zzme = zzd;
        this.zzmf = zzr;
        this.zzmg = zzv;
        this.zzmh = zzp;
        this.zzmi = zzt;
        this.zzmj = zzn;
        this.zzmk = zzl;
        this.zzml = zzz;
        if (zzb != null) {
            this.zzbc = zzb;
        } else if (zzd != null) {
            this.zzbc = zzd;
        } else if (zzr != null) {
            this.zzbc = zzr;
        } else if (zzv != null) {
            this.zzbc = zzv;
        } else if (zzp != null) {
            this.zzbc = zzp;
        } else if (zzt != null) {
            this.zzbc = zzt;
        } else if (zzn != null) {
            this.zzbc = zzn;
        } else if (zzl != null) {
            this.zzbc = zzl;
        } else if (zzz != null) {
            this.zzbc = zzz;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public final Filter getFilter() {
        return this.zzbc;
    }

    public FilterHolder(Filter filter) {
        Preconditions.checkNotNull(filter, "Null filter.");
        zzz zzz = null;
        zzb<?> zzb = filter instanceof zzb ? (zzb) filter : null;
        this.zzmd = zzb;
        zzd zzd = filter instanceof zzd ? (zzd) filter : null;
        this.zzme = zzd;
        zzr zzr = filter instanceof zzr ? (zzr) filter : null;
        this.zzmf = zzr;
        zzv zzv = filter instanceof zzv ? (zzv) filter : null;
        this.zzmg = zzv;
        zzp<?> zzp = filter instanceof zzp ? (zzp) filter : null;
        this.zzmh = zzp;
        zzt zzt = filter instanceof zzt ? (zzt) filter : null;
        this.zzmi = zzt;
        zzn zzn = filter instanceof zzn ? (zzn) filter : null;
        this.zzmj = zzn;
        zzl zzl = filter instanceof zzl ? (zzl) filter : null;
        this.zzmk = zzl;
        zzz = filter instanceof zzz ? (zzz) filter : zzz;
        this.zzml = zzz;
        if (zzb == null && zzd == null && zzr == null && zzv == null && zzp == null && zzt == null && zzn == null && zzl == null && zzz == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzbc = filter;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzmd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzme, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzmf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzmg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzmh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzmi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzmj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzmk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzml, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
