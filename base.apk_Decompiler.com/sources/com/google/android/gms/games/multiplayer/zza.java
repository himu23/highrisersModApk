package com.google.android.gms.games.multiplayer;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zza extends zzb {
    zza() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    public final ParticipantEntity zza(Parcel parcel) {
        if (ParticipantEntity.zzp(ParticipantEntity.getUnparcelClientVersion()) || ParticipantEntity.canUnparcelSafely(ParticipantEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        return new ParticipantEntity();
    }
}
