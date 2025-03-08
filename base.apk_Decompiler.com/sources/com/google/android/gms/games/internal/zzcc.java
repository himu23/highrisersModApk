package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.games.zzb;
import com.google.android.gms.internal.games.zzc;
import com.google.android.gms.internal.games.zzfr;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public abstract class zzcc extends zzb implements zzcd {
    public zzcc() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1001) {
            return false;
        }
        zzfr zzb = zzb();
        parcel2.writeNoException();
        zzc.zze(parcel2, zzb);
        return true;
    }
}
