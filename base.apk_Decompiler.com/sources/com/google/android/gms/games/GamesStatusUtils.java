package com.google.android.gms.games;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class GamesStatusUtils {
    private GamesStatusUtils() {
    }

    public static void zza(TaskCompletionSource taskCompletionSource, int i) {
        int i2;
        Status zza = GamesStatusCodes.zza(i);
        int i3 = GamesClientStatusCodes.NETWORK_ERROR_NO_DATA;
        int statusCode = zza.getStatusCode();
        if (statusCode == 1) {
            i2 = 8;
        } else if (statusCode == 2) {
            i2 = 26502;
        } else if (statusCode == 3) {
            i2 = 26503;
        } else if (statusCode == 4) {
            i2 = GamesClientStatusCodes.NETWORK_ERROR_NO_DATA;
        } else if (statusCode == 5) {
            i2 = 26505;
        } else if (statusCode != 6) {
            if (statusCode != 7) {
                if (statusCode == 1500) {
                    i2 = 26540;
                } else if (statusCode != 1501) {
                    switch (statusCode) {
                        case 7:
                            break;
                        case 8:
                            i2 = GamesClientStatusCodes.APP_MISCONFIGURED;
                            break;
                        case 9:
                            i2 = GamesClientStatusCodes.GAME_NOT_FOUND;
                            break;
                        case 500:
                            i2 = 26520;
                            break;
                        case GamesStatusCodes.STATUS_VIDEO_NOT_ACTIVE:
                            i2 = GamesClientStatusCodes.VIDEO_NOT_ACTIVE;
                            break;
                        case GamesStatusCodes.STATUS_VIDEO_UNSUPPORTED:
                            i2 = GamesClientStatusCodes.VIDEO_UNSUPPORTED;
                            break;
                        case GamesStatusCodes.STATUS_VIDEO_PERMISSION_ERROR:
                            i2 = GamesClientStatusCodes.VIDEO_PERMISSION_ERROR;
                            break;
                        case GamesStatusCodes.STATUS_VIDEO_STORAGE_ERROR:
                            i2 = GamesClientStatusCodes.VIDEO_STORAGE_ERROR;
                            break;
                        case GamesStatusCodes.STATUS_VIDEO_UNEXPECTED_CAPTURE_ERROR:
                            i2 = GamesClientStatusCodes.VIDEO_UNEXPECTED_CAPTURE_ERROR;
                            break;
                        case GamesStatusCodes.STATUS_VIDEO_ALREADY_CAPTURING:
                            i2 = GamesClientStatusCodes.VIDEO_ALREADY_CAPTURING;
                            break;
                        case GamesStatusCodes.STATUS_VIDEO_OUT_OF_DISK_SPACE:
                            i2 = GamesClientStatusCodes.VIDEO_OUT_OF_DISK_SPACE;
                            break;
                        case 9010:
                            i2 = 26627;
                            break;
                        case 9011:
                            i2 = 26628;
                            break;
                        case 9012:
                            i2 = 26629;
                            break;
                        case 9016:
                            i2 = 26630;
                            break;
                        case 9017:
                            i2 = 26631;
                            break;
                        case 9018:
                            i2 = 26632;
                            break;
                        case 9200:
                            i2 = 26650;
                            break;
                        case 9202:
                            i2 = 26652;
                            break;
                        case 10000:
                            i2 = 26700;
                            break;
                        case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED:
                            i2 = 26701;
                            break;
                        case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED:
                            i2 = 26702;
                            break;
                        case GamesActivityResultCodes.RESULT_LICENSE_FAILED:
                            i2 = GamesClientStatusCodes.CONSENT_REQUIRED;
                            break;
                        case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED:
                            i2 = 26704;
                            break;
                        default:
                            switch (statusCode) {
                                case 1000:
                                    i2 = 26530;
                                    break;
                                case 1001:
                                    i2 = 26531;
                                    break;
                                case 1002:
                                    i2 = 26532;
                                    break;
                                case 1003:
                                    i2 = 26533;
                                    break;
                                case 1004:
                                    i2 = 26534;
                                    break;
                                case 1005:
                                    i2 = 26535;
                                    break;
                                case 1006:
                                    i2 = 26536;
                                    break;
                                default:
                                    switch (statusCode) {
                                        case 2000:
                                            i2 = 26550;
                                            break;
                                        case 2001:
                                            i2 = 26551;
                                            break;
                                        case 2002:
                                            i2 = 26552;
                                            break;
                                        default:
                                            switch (statusCode) {
                                                case 3000:
                                                    i2 = GamesClientStatusCodes.ACHIEVEMENT_UNLOCK_FAILURE;
                                                    break;
                                                case 3001:
                                                    i2 = GamesClientStatusCodes.ACHIEVEMENT_UNKNOWN;
                                                    break;
                                                case 3002:
                                                    i2 = GamesClientStatusCodes.ACHIEVEMENT_NOT_INCREMENTAL;
                                                    break;
                                                case 3003:
                                                    i2 = GamesClientStatusCodes.ACHIEVEMENT_UNLOCKED;
                                                    break;
                                                default:
                                                    switch (statusCode) {
                                                        case GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND:
                                                            i2 = GamesClientStatusCodes.SNAPSHOT_NOT_FOUND;
                                                            break;
                                                        case 4001:
                                                            i2 = GamesClientStatusCodes.SNAPSHOT_CREATION_FAILED;
                                                            break;
                                                        case 4002:
                                                            i2 = GamesClientStatusCodes.SNAPSHOT_CONTENTS_UNAVAILABLE;
                                                            break;
                                                        case GamesStatusCodes.STATUS_SNAPSHOT_COMMIT_FAILED:
                                                            i2 = GamesClientStatusCodes.SNAPSHOT_COMMIT_FAILED;
                                                            break;
                                                        case GamesStatusCodes.STATUS_SNAPSHOT_CONFLICT:
                                                            i2 = 26574;
                                                            break;
                                                        case 4005:
                                                            i2 = GamesClientStatusCodes.SNAPSHOT_FOLDER_UNAVAILABLE;
                                                            break;
                                                        case GamesStatusCodes.STATUS_SNAPSHOT_CONFLICT_MISSING:
                                                            i2 = GamesClientStatusCodes.SNAPSHOT_CONFLICT_MISSING;
                                                            break;
                                                        default:
                                                            switch (statusCode) {
                                                                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED:
                                                                    i2 = 26580;
                                                                    break;
                                                                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER:
                                                                    i2 = 26581;
                                                                    break;
                                                                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE:
                                                                    i2 = 26582;
                                                                    break;
                                                                case GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED:
                                                                    i2 = 26583;
                                                                    break;
                                                                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION:
                                                                    i2 = 26584;
                                                                    break;
                                                                default:
                                                                    switch (statusCode) {
                                                                        case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE:
                                                                            i2 = 26590;
                                                                            break;
                                                                        case GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH:
                                                                            i2 = 26591;
                                                                            break;
                                                                        case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE:
                                                                            i2 = 26592;
                                                                            break;
                                                                        case GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION:
                                                                            i2 = 26593;
                                                                            break;
                                                                        case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS:
                                                                            i2 = 26594;
                                                                            break;
                                                                        case GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED:
                                                                            i2 = 26595;
                                                                            break;
                                                                        case GamesStatusCodes.STATUS_MATCH_NOT_FOUND:
                                                                            i2 = 26596;
                                                                            break;
                                                                        case GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED:
                                                                            i2 = 26597;
                                                                            break;
                                                                        default:
                                                                            switch (statusCode) {
                                                                                case GamesStatusCodes.STATUS_REAL_TIME_CONNECTION_FAILED:
                                                                                    i2 = 26600;
                                                                                    break;
                                                                                case GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED:
                                                                                    i2 = 26601;
                                                                                    break;
                                                                                case GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID:
                                                                                    i2 = 26602;
                                                                                    break;
                                                                                case GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED:
                                                                                    i2 = 26603;
                                                                                    break;
                                                                                case GamesStatusCodes.STATUS_REAL_TIME_ROOM_NOT_JOINED:
                                                                                    i2 = 26604;
                                                                                    break;
                                                                                case GamesStatusCodes.STATUS_REAL_TIME_INACTIVE_ROOM:
                                                                                    i2 = 26605;
                                                                                    break;
                                                                                case 7006:
                                                                                    i2 = 26606;
                                                                                    break;
                                                                                case GamesStatusCodes.STATUS_OPERATION_IN_FLIGHT:
                                                                                    i2 = GamesClientStatusCodes.OPERATION_IN_FLIGHT;
                                                                                    break;
                                                                                default:
                                                                                    switch (statusCode) {
                                                                                        case GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY:
                                                                                            i2 = 26610;
                                                                                            break;
                                                                                        case GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED:
                                                                                            i2 = 26611;
                                                                                            break;
                                                                                        case GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE:
                                                                                            i2 = 26612;
                                                                                            break;
                                                                                        case GamesStatusCodes.STATUS_QUEST_NOT_STARTED:
                                                                                            i2 = 26613;
                                                                                            break;
                                                                                        default:
                                                                                            i2 = statusCode;
                                                                                            break;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    i2 = 26541;
                }
            }
            i2 = GamesClientStatusCodes.LICENSE_CHECK_FAILED;
        } else {
            i2 = GamesClientStatusCodes.NETWORK_ERROR_OPERATION_FAILED;
        }
        if (i2 != zza.getStatusCode()) {
            if (!GamesStatusCodes.getStatusString(zza.getStatusCode()).equals(zza.getStatusMessage())) {
                switch (statusCode) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                        break;
                    default:
                        zza = new Status(i2, zza.getStatusMessage(), zza.getResolution());
                        break;
                }
            } else {
                zza = GamesClientStatusCodes.zzb(i2, zza.getResolution());
            }
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(zza));
    }

    public static void zzb(TaskCompletionSource taskCompletionSource, SecurityException securityException) {
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(new ApiException(GamesClientStatusCodes.zza(4)));
        }
    }
}
