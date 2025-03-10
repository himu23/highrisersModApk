package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public final class zzr extends zza {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    private List<Filter> zzls;
    private final zzx zzlz;
    private final List<FilterHolder> zzmo;

    zzr(zzx zzx, List<FilterHolder> list) {
        this.zzlz = zzx;
        this.zzmo = list;
    }

    public zzr(zzx zzx, Iterable<Filter> iterable) {
        this.zzlz = zzx;
        this.zzls = new ArrayList();
        this.zzmo = new ArrayList();
        for (Filter next : iterable) {
            this.zzls.add(next);
            this.zzmo.add(new FilterHolder(next));
        }
    }

    public zzr(zzx zzx, Filter filter, Filter... filterArr) {
        this.zzlz = zzx;
        ArrayList arrayList = new ArrayList(filterArr.length + 1);
        this.zzmo = arrayList;
        arrayList.add(new FilterHolder(filter));
        ArrayList arrayList2 = new ArrayList(filterArr.length + 1);
        this.zzls = arrayList2;
        arrayList2.add(filter);
        for (Filter filter2 : filterArr) {
            this.zzmo.add(new FilterHolder(filter2));
            this.zzls.add(filter2);
        }
    }

    public final <T> T zza(zzj<T> zzj) {
        ArrayList arrayList = new ArrayList();
        for (FilterHolder filter : this.zzmo) {
            arrayList.add(filter.getFilter().zza(zzj));
        }
        return zzj.zza(this.zzlz, (List<T>) arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzlz, i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzmo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
