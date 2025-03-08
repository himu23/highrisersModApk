package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public class zzs implements Parcelable.Creator {
    public final /* synthetic */ Object[] newArray(int i) {
        return new PlayerEntity[i];
    }

    /* renamed from: zza */
    public PlayerEntity createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        String str6 = null;
        String str7 = null;
        Uri uri3 = null;
        String str8 = null;
        Uri uri4 = null;
        String str9 = null;
        zzv zzv = null;
        zza zza = null;
        String str10 = null;
        long j = 0;
        long j2 = 0;
        long j3 = -1;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 2:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 5:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 6:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 8:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 14:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) SafeParcelReader.createParcelable(parcel2, readHeader, MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) SafeParcelReader.createParcelable(parcel2, readHeader, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 19:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 20:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 21:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 22:
                    uri3 = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 23:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 24:
                    uri4 = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 25:
                    str9 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 29:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 33:
                    zzv = (zzv) SafeParcelReader.createParcelable(parcel2, readHeader, zzv.CREATOR);
                    break;
                case 35:
                    zza = (zza) SafeParcelReader.createParcelable(parcel2, readHeader, zza.CREATOR);
                    break;
                case 36:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 37:
                    str10 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new PlayerEntity(str, str2, uri, uri2, j, i, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z, z2, str6, str7, uri3, str8, uri4, str9, j3, zzv, zza, z3, str10);
    }
}
