package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.player.zze;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.internal.games.zzb;
import com.google.android.gms.internal.games.zzc;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public abstract class zzca extends zzb implements zzcb {
    public zzca() {
        super("com.google.android.gms.games.internal.IGamesCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 6001) {
            parcel.readString();
            zzc.zzb(parcel);
        } else if (i == 6002) {
            parcel.readString();
            zzc.zzb(parcel);
        } else if (i == 12011) {
            zzc.zzb(parcel);
            zzf((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
        } else if (i == 12012) {
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            zzc.zzb(parcel);
            zzr(readInt, readString);
        } else if (i == 13001) {
            DataHolder dataHolder = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
            zzc.zzb(parcel);
        } else if (i == 13002) {
            parcel.readInt();
            zzc.zzb(parcel);
        } else if (i == 19001) {
            zzc.zzb(parcel);
            zzv(parcel.readInt(), (VideoCapabilities) zzc.zza(parcel, VideoCapabilities.CREATOR));
        } else if (i != 19002) {
            switch (i) {
                case IronSourceConstants.errorCode_biddingDataException /*5001*/:
                    parcel.readInt();
                    parcel.readString();
                    zzc.zzb(parcel);
                    break;
                case IronSourceConstants.errorCode_isReadyException /*5002*/:
                    zzc.zzb(parcel);
                    zzc((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case IronSourceConstants.errorCode_loadInProgress /*5003*/:
                    int readInt2 = parcel.readInt();
                    String readString2 = parcel.readString();
                    zzc.zzb(parcel);
                    zzb(readInt2, readString2);
                    break;
                case IronSourceConstants.errorCode_showInProgress /*5004*/:
                    zzc.zzb(parcel);
                    zzj((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case IronSourceConstants.errorCode_loadException /*5005*/:
                    zzc.zzb(parcel);
                    zzi((DataHolder) zzc.zza(parcel, DataHolder.CREATOR), (DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case IronSourceConstants.errorCode_showFailed /*5006*/:
                    zzc.zzb(parcel);
                    zzn((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case IronSourceConstants.errorCode_initSuccess /*5007*/:
                    zzc.zzb(parcel);
                    zzm((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case IronSourceConstants.errorCode_initFailed /*5008*/:
                    zzc.zzb(parcel);
                    zzg((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case IronSourceConstants.errorCode_adClosed /*5009*/:
                    zzc.zzb(parcel);
                    zzh((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                    break;
                case IronSourceConstants.errorCode_destroy /*5010*/:
                    DataHolder dataHolder2 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                    zzc.zzb(parcel);
                    break;
                case IronSourceConstants.errorCode_internal /*5011*/:
                    DataHolder dataHolder3 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                    zzc.zzb(parcel);
                    break;
                default:
                    switch (i) {
                        case 5016:
                            zzo();
                            break;
                        case 5017:
                            DataHolder dataHolder4 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5018:
                            DataHolder dataHolder5 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5019:
                            DataHolder dataHolder6 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5020:
                            parcel.readInt();
                            parcel.readString();
                            zzc.zzb(parcel);
                            break;
                        case 5021:
                            DataHolder dataHolder7 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5022:
                            DataHolder dataHolder8 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5023:
                            DataHolder dataHolder9 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5024:
                            DataHolder dataHolder10 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5025:
                            DataHolder dataHolder11 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5026:
                            DataHolder dataHolder12 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            zzc.zzb(parcel);
                            break;
                        case 5027:
                            DataHolder dataHolder13 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            zzc.zzb(parcel);
                            break;
                        case 5028:
                            DataHolder dataHolder14 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            zzc.zzb(parcel);
                            break;
                        case 5029:
                            DataHolder dataHolder15 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            zzc.zzb(parcel);
                            break;
                        case 5030:
                            DataHolder dataHolder16 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            zzc.zzb(parcel);
                            break;
                        case 5031:
                            DataHolder dataHolder17 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            parcel.createStringArray();
                            zzc.zzb(parcel);
                            break;
                        case 5032:
                            com.google.android.gms.games.multiplayer.realtime.zzb zzb = (com.google.android.gms.games.multiplayer.realtime.zzb) zzc.zza(parcel, com.google.android.gms.games.multiplayer.realtime.zzb.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5033:
                            parcel.readInt();
                            parcel.readInt();
                            parcel.readString();
                            zzc.zzb(parcel);
                            break;
                        case 5034:
                            parcel.readInt();
                            parcel.readString();
                            zzc.zzg(parcel);
                            zzc.zzb(parcel);
                            break;
                        case 5035:
                            DataHolder dataHolder18 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5036:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 5037:
                            DataHolder dataHolder19 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5038:
                            DataHolder dataHolder20 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5039:
                            DataHolder dataHolder21 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 5040:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case GamesStatusCodes.STATUS_VIDEO_UNSUPPORTED:
                            DataHolder dataHolder22 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 11001:
                            parcel.readInt();
                            Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 12001:
                            zzc.zzb(parcel);
                            zzt((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 14001:
                            DataHolder[] dataHolderArr = (DataHolder[]) parcel.createTypedArray(DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 15001:
                            zzc.zzb(parcel);
                            zzl((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 17002:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 19008:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 19009:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 19010:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 20001:
                            DataHolder dataHolder23 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20002:
                            DataHolder dataHolder24 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20003:
                            DataHolder dataHolder25 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20004:
                            DataHolder dataHolder26 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20005:
                            DataHolder dataHolder27 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20006:
                            DataHolder dataHolder28 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20007:
                            DataHolder dataHolder29 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20008:
                            DataHolder dataHolder30 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20009:
                            DataHolder dataHolder31 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20012:
                            Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 20019:
                            int readInt3 = parcel.readInt();
                            zzc.zzb(parcel);
                            zzd(readInt3);
                            break;
                        case 20020:
                            zzc.zzb(parcel);
                            zze(parcel.readInt(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                            break;
                        case 23001:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 23002:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 23003:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 23004:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 23005:
                            parcel.readInt();
                            zzc.zzb(parcel);
                            break;
                        case 24002:
                            zzc.zzg(parcel);
                            zzc.zzb(parcel);
                            break;
                        case 25002:
                            parcel.readString();
                            zzc.zzb(parcel);
                            break;
                        case 25003:
                            Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
                            parcel.readString();
                            zzc.zzb(parcel);
                            break;
                        case 25004:
                            Status status3 = (Status) zzc.zza(parcel, Status.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        case 25005:
                            parcel.readInt();
                            zze zze = (zze) zzc.zza(parcel, zze.CREATOR);
                            zzc.zzb(parcel);
                            break;
                        default:
                            switch (i) {
                                case GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED:
                                    zzc.zzb(parcel);
                                    zzk((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE:
                                    parcel.readInt();
                                    Bundle bundle2 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                                    zzc.zzb(parcel);
                                    break;
                                case GamesStatusCodes.STATUS_QUEST_NOT_STARTED:
                                    DataHolder dataHolder32 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    zzc.zzb(parcel);
                                    break;
                                case 8004:
                                    DataHolder dataHolder33 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    zzc.zzb(parcel);
                                    break;
                                case 8005:
                                    DataHolder dataHolder34 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    zzc.zzb(parcel);
                                    break;
                                case 8006:
                                    DataHolder dataHolder35 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    zzc.zzb(parcel);
                                    break;
                                case 8007:
                                    parcel.readInt();
                                    parcel.readString();
                                    zzc.zzb(parcel);
                                    break;
                                case 8008:
                                    DataHolder dataHolder36 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                    zzc.zzb(parcel);
                                    break;
                                case 8009:
                                    parcel.readString();
                                    zzc.zzb(parcel);
                                    break;
                                case 8010:
                                    parcel.readString();
                                    zzc.zzb(parcel);
                                    break;
                                default:
                                    switch (i) {
                                        case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED:
                                            DataHolder dataHolder37 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                            zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED:
                                            parcel.readString();
                                            zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_LICENSE_FAILED:
                                            DataHolder dataHolder38 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                            zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED:
                                            DataHolder dataHolder39 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                            zzc.zzb(parcel);
                                            break;
                                        case 10005:
                                            parcel.readInt();
                                            Bundle bundle3 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                                            zzc.zzb(parcel);
                                            break;
                                        case GamesActivityResultCodes.RESULT_NETWORK_FAILURE:
                                            DataHolder dataHolder40 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                            zzc.zzb(parcel);
                                            break;
                                        default:
                                            switch (i) {
                                                case 12004:
                                                    zzc.zzb(parcel);
                                                    zzs((DataHolder) zzc.zza(parcel, DataHolder.CREATOR), (Contents) zzc.zza(parcel, Contents.CREATOR));
                                                    break;
                                                case 12005:
                                                    zzc.zzb(parcel);
                                                    zzp((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                case 12006:
                                                    DataHolder dataHolder41 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                    zzc.zzb(parcel);
                                                    break;
                                                case 12007:
                                                    DataHolder dataHolder42 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                    zzc.zzb(parcel);
                                                    break;
                                                case 12008:
                                                    DataHolder dataHolder43 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                    zzc.zzb(parcel);
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 12014:
                                                            DataHolder dataHolder44 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                            zzc.zzb(parcel);
                                                            break;
                                                        case 12015:
                                                            parcel.readInt();
                                                            Bundle bundle4 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                                                            zzc.zzb(parcel);
                                                            break;
                                                        case 12016:
                                                            DataHolder dataHolder45 = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
                                                            zzc.zzb(parcel);
                                                            break;
                                                        case 12017:
                                                            zzc.zzb(parcel);
                                                            zzq((DataHolder) zzc.zza(parcel, DataHolder.CREATOR), parcel.readString(), (Contents) zzc.zza(parcel, Contents.CREATOR), (Contents) zzc.zza(parcel, Contents.CREATOR), (Contents) zzc.zza(parcel, Contents.CREATOR));
                                                            break;
                                                        default:
                                                            return false;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            int readInt4 = parcel.readInt();
            boolean zzg = zzc.zzg(parcel);
            zzc.zzb(parcel);
            zzu(readInt4, zzg);
        }
        parcel2.writeNoException();
        return true;
    }
}
