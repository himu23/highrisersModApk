package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzb extends zzc {
    zzb() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    public final GameBadgeEntity zza(Parcel parcel) {
        Uri uri;
        if (GameBadgeEntity.zzp(GameBadgeEntity.getUnparcelClientVersion()) || GameBadgeEntity.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        if (readString3 == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString3);
        }
        return new GameBadgeEntity(readInt, readString, readString2, uri);
    }
}
