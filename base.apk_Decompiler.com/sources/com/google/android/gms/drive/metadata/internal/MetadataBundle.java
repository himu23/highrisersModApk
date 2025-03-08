package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzj();
    private static final GmsLogger zzbz = new GmsLogger("MetadataBundle", "");
    private final Bundle zzjh;

    MetadataBundle(Bundle bundle) {
        int i;
        Bundle bundle2 = (Bundle) Preconditions.checkNotNull(bundle);
        this.zzjh = bundle2;
        bundle2.setClassLoader(getClass().getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator it = bundle2.keySet().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (zzf.zzf(str) == null) {
                arrayList.add(str);
                zzbz.wfmt("MetadataBundle", "Ignored unknown metadata field in bundle: %s", str);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            this.zzjh.remove((String) obj);
        }
    }

    public static MetadataBundle zzbe() {
        return new MetadataBundle(new Bundle());
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzbe = zzbe();
        zzbe.zzb(metadataField, t);
        return zzbe;
    }

    public final MetadataBundle zzbf() {
        return new MetadataBundle(new Bundle(this.zzjh));
    }

    public final <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zzf.zzf(metadataField.getName()) == null) {
            String valueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unregistered field: ".concat(valueOf) : new String("Unregistered field: "));
        } else {
            metadataField.zza(t, this.zzjh);
        }
    }

    public final <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zza(this.zzjh);
    }

    public final <T> T zzc(MetadataField<T> metadataField) {
        T zza = zza(metadataField);
        this.zzjh.remove(metadataField.getName());
        return zza;
    }

    public final boolean zzd(MetadataField<?> metadataField) {
        return this.zzjh.containsKey(metadataField.getName());
    }

    public final Set<MetadataField<?>> zzbg() {
        HashSet hashSet = new HashSet();
        for (String zzf : this.zzjh.keySet()) {
            hashSet.add(zzf.zzf(zzf));
        }
        return hashSet;
    }

    public final void zza(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzhs.zzkq);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.setTempDir(context.getCacheDir());
        }
    }

    public final int hashCode() {
        int i = 1;
        for (String str : this.zzjh.keySet()) {
            i = (i * 31) + this.zzjh.get(str).hashCode();
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzjh.keySet();
        if (!keySet.equals(metadataBundle.zzjh.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!Objects.equal(this.zzjh.get(str), metadataBundle.zzjh.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzjh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
