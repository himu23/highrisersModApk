package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.games.internal.zzc;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class MostRecentGameInfoEntity extends zzc implements zza {
    public static final Parcelable.Creator<MostRecentGameInfoEntity> CREATOR = new zzb();
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final Uri zzd;
    private final Uri zze;
    private final Uri zzf;

    public MostRecentGameInfoEntity(zza zza2) {
        this.zza = zza2.zze();
        this.zzb = zza2.zzf();
        this.zzc = zza2.zza();
        this.zzd = zza2.zzd();
        this.zze = zza2.zzc();
        this.zzf = zza2.zzb();
    }

    static int zzg(zza zza2) {
        return Objects.hashCode(zza2.zze(), zza2.zzf(), Long.valueOf(zza2.zza()), zza2.zzd(), zza2.zzc(), zza2.zzb());
    }

    static String zzh(zza zza2) {
        return Objects.toStringHelper(zza2).add("GameId", zza2.zze()).add("GameName", zza2.zzf()).add("ActivityTimestampMillis", Long.valueOf(zza2.zza())).add("GameIconUri", zza2.zzd()).add("GameHiResUri", zza2.zzc()).add("GameFeaturedUri", zza2.zzb()).toString();
    }

    static boolean zzi(zza zza2, Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (zza2 == obj) {
            return true;
        }
        zza zza3 = (zza) obj;
        return Objects.equal(zza3.zze(), zza2.zze()) && Objects.equal(zza3.zzf(), zza2.zzf()) && Objects.equal(Long.valueOf(zza3.zza()), Long.valueOf(zza2.zza())) && Objects.equal(zza3.zzd(), zza2.zzd()) && Objects.equal(zza3.zzc(), zza2.zzc()) && Objects.equal(zza3.zzb(), zza2.zzb());
    }

    public final boolean equals(Object obj) {
        return zzi(this, obj);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return zzg(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzh(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public final long zza() {
        return this.zzc;
    }

    public final Uri zzb() {
        return this.zzf;
    }

    public final Uri zzc() {
        return this.zze;
    }

    public final Uri zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzb;
    }

    MostRecentGameInfoEntity(String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = uri;
        this.zze = uri2;
        this.zzf = uri3;
    }
}
