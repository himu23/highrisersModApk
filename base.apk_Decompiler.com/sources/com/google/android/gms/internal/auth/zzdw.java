package com.google.android.gms.internal.auth;

import java.util.Comparator;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzdw implements Comparator {
    zzdw() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzee zzee = (zzee) obj;
        zzee zzee2 = (zzee) obj2;
        zzdv zzdv = new zzdv(zzee);
        zzdv zzdv2 = new zzdv(zzee2);
        while (zzdv.hasNext() && zzdv2.hasNext()) {
            int compareTo = Integer.valueOf(zzdv.zza() & UByte.MAX_VALUE).compareTo(Integer.valueOf(zzdv2.zza() & UByte.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzee.zzd()).compareTo(Integer.valueOf(zzee2.zzd()));
    }
}
