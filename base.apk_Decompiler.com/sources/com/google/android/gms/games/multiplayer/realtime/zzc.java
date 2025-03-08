package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzc extends zzd {
    zzc() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    public final RoomEntity zza(Parcel parcel) {
        if (RoomEntity.zzp(RoomEntity.getUnparcelClientVersion()) || RoomEntity.canUnparcelSafely(RoomEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        return new RoomEntity();
    }
}
