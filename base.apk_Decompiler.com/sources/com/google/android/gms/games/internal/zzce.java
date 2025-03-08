package com.google.android.gms.games.internal;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games.zza;
import com.google.android.gms.internal.games.zzc;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class zzce extends zza implements IInterface {
    zzce(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    public final void zzA(zzcb zzcb, String str, String str2, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc(GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED, zza);
    }

    public final void zzB(zzcb zzcb) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc(21007, zza);
    }

    public final void zzC(zzcb zzcb, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        zzc.zzd(zza, bundle);
        zzc(5025, zza);
    }

    public final void zzD(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzc(12017, zza);
    }

    public final void zzE(zzcb zzcb, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeInt(i);
        zzc(22016, zza);
    }

    public final void zzF(zzcb zzcb, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc.zzc(zza, z);
        zzc(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, zza);
    }

    public final void zzG(zzcb zzcb, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc.zzc(zza, z);
        zzc(8027, zza);
    }

    public final void zzH(zzcb zzcb, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc.zzc(zza, z);
        zzc(12016, zza);
    }

    public final void zzI(zzcb zzcb, boolean z, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc.zzc(zza, z);
        zza.writeStringArray(strArr);
        zzc(12031, zza);
    }

    public final void zzJ(zzcb zzcb) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc(5026, zza);
    }

    public final void zzK(zzcb zzcb, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeInt(i);
        zzc.zzc(zza, z);
        zzc.zzc(zza, z2);
        zzc(5015, zza);
    }

    public final void zzL(zzcb zzcb, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zzc.zzc(zza, z);
        zzc(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, zza);
    }

    public final void zzM(zzcb zzcb, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc.zzc(zza, z);
        zzc(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, zza);
    }

    public final void zzN(zzcb zzcb, Bundle bundle, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc.zzd(zza, bundle);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc(5021, zza);
    }

    public final void zzO(zzcb zzcb, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzc.zzc(zza, z);
        zzc(5020, zza);
    }

    public final void zzP(zzcb zzcb, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc.zzc(zza, z);
        zzc(17001, zza);
    }

    public final void zzQ(zzcb zzcb, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zzc.zzc(zza, z);
        zzc(13006, zza);
    }

    public final void zzR(zzcb zzcb, String str, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zza.writeInt(i);
        zzc.zzc(zza, z);
        zzc.zzc(zza, z2);
        zzc(9020, zza);
    }

    public final void zzS(zzcb zzcb, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc.zzc(zza, z);
        zzc(12002, zza);
    }

    public final void zzT(zzcb zzcb, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzc.zzc(zza, z);
        zzc(5019, zza);
    }

    public final void zzU(zzcb zzcb, String str, boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zzc.zzc(zza, z);
        zza.writeInt(i);
        zzc(15001, zza);
    }

    public final void zzV(zzcb zzcb, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeLong(j);
        zzc(22026, zza);
    }

    public final void zzW(zzcd zzcd, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcd);
        zza.writeLong(j);
        zzc(15501, zza);
    }

    public final void zzX(zzcb zzcb, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, snapshotMetadataChangeEntity);
        zzc.zzd(zza, contents);
        zzc(12033, zza);
    }

    public final void zzY(zzcb zzcb, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzc.zzd(zza, bundle);
        zzc(5023, zza);
    }

    public final void zzZ(zzcb zzcb, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        zzc.zzd(zza, bundle);
        zzc(GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED, zza);
    }

    public final void zzaa(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeStrongBinder(iBinder);
        zzc.zzd(zza, bundle);
        zzc(IronSourceConstants.errorCode_loadException, zza);
    }

    public final void zzab(zzcb zzcb) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc(IronSourceConstants.errorCode_isReadyException, zza);
    }

    public final void zzac(zzcb zzcb, String str, long j, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zza.writeLong(j);
        zza.writeString(str2);
        zzc(GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, zza);
    }

    public final void zzad(zzcb zzcb, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzc.zzd(zza, bundle);
        zzc(5024, zza);
    }

    public final void zzae(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(22027, zza);
    }

    public final boolean zzaf() throws RemoteException {
        Parcel zzb = zzb(22030, zza());
        boolean zzg = zzc.zzg(zzb);
        zzb.recycle();
        return zzg;
    }

    public final int zzd() throws RemoteException {
        Parcel zzb = zzb(12036, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final int zze() throws RemoteException {
        Parcel zzb = zzb(12035, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final PendingIntent zzf() throws RemoteException {
        Parcel zzb = zzb(25015, zza());
        PendingIntent pendingIntent = (PendingIntent) zzc.zza(zzb, PendingIntent.CREATOR);
        zzb.recycle();
        return pendingIntent;
    }

    public final Intent zzg() throws RemoteException {
        Parcel zzb = zzb(9005, zza());
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzh() throws RemoteException {
        Parcel zzb = zzb(GamesStatusCodes.STATUS_VIDEO_STORAGE_ERROR, zza());
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzi(PlayerEntity playerEntity) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, playerEntity);
        Parcel zzb = zzb(15503, zza);
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzj(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(25016, zza);
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzk(String str, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        Parcel zzb = zzb(18001, zza);
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzl() throws RemoteException {
        Parcel zzb = zzb(9010, zza());
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzm(String str, boolean z, boolean z2, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, z);
        zzc.zzc(zza, z2);
        zza.writeInt(i);
        Parcel zzb = zzb(12001, zza);
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzn() throws RemoteException {
        Parcel zzb = zzb(9012, zza());
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzo() throws RemoteException {
        Parcel zzb = zzb(19002, zza());
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final DataHolder zzp() throws RemoteException {
        Parcel zzb = zzb(5502, zza());
        DataHolder dataHolder = (DataHolder) zzc.zza(zzb, DataHolder.CREATOR);
        zzb.recycle();
        return dataHolder;
    }

    public final DataHolder zzq() throws RemoteException {
        Parcel zzb = zzb(5013, zza());
        DataHolder dataHolder = (DataHolder) zzc.zza(zzb, DataHolder.CREATOR);
        zzb.recycle();
        return dataHolder;
    }

    public final String zzr() throws RemoteException {
        Parcel zzb = zzb(IronSourceConstants.errorCode_loadInProgress, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final String zzs() throws RemoteException {
        Parcel zzb = zzb(IronSourceConstants.errorCode_initSuccess, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final String zzt() throws RemoteException {
        Parcel zzb = zzb(5012, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final void zzu() throws RemoteException {
        zzc(IronSourceConstants.errorCode_showFailed, zza());
    }

    public final void zzv(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(IronSourceConstants.errorCode_biddingDataException, zza);
    }

    public final void zzw(zzcb zzcb, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zzc.zzd(zza, snapshotMetadataChangeEntity);
        zzc.zzd(zza, contents);
        zzc(12007, zza);
    }

    public final void zzx(zzcb zzcb, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zza.writeString(str);
        zzc(12020, zza);
    }

    public final void zzy(Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, contents);
        zzc(12019, zza);
    }

    public final void zzz(zzcb zzcb) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzcb);
        zzc(22028, zza);
    }
}
