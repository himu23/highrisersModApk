package com.applovin.exoplayer2;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.applovin.exoplayer2.g;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

public class ak extends Exception implements g {
    public static final g.a<ak> br = new ak$$ExternalSyntheticLambda0();
    public final int errorCode;
    public final long gp;

    public static String V(int i) {
        if (i == 5001) {
            return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
        }
        if (i == 5002) {
            return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
        }
        switch (i) {
            case 1000:
                return "ERROR_CODE_UNSPECIFIED";
            case 1001:
                return "ERROR_CODE_REMOTE_ERROR";
            case 1002:
                return "ERROR_CODE_BEHIND_LIVE_WINDOW";
            case 1003:
                return "ERROR_CODE_TIMEOUT";
            case 1004:
                return "ERROR_CODE_FAILED_RUNTIME_CHECK";
            default:
                switch (i) {
                    case 2000:
                        return "ERROR_CODE_IO_UNSPECIFIED";
                    case 2001:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                    case 2002:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                    case 2003:
                        return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                    case IronSourceConstants.IS_CALLBACK_LOAD_SUCCESS:
                        return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                    case 2005:
                        return "ERROR_CODE_IO_FILE_NOT_FOUND";
                    case 2006:
                        return "ERROR_CODE_IO_NO_PERMISSION";
                    case 2007:
                        return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                    case 2008:
                        return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                    default:
                        switch (i) {
                            case 3001:
                                return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                            case 3002:
                                return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                            case 3003:
                                return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                            case AuthApiStatusCodes.AUTH_TOKEN_ERROR:
                                return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                            default:
                                switch (i) {
                                    case 4001:
                                        return "ERROR_CODE_DECODER_INIT_FAILED";
                                    case 4002:
                                        return "ERROR_CODE_DECODER_QUERY_FAILED";
                                    case GamesStatusCodes.STATUS_SNAPSHOT_COMMIT_FAILED:
                                        return "ERROR_CODE_DECODING_FAILED";
                                    case GamesStatusCodes.STATUS_SNAPSHOT_CONFLICT:
                                        return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                    case 4005:
                                        return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                    default:
                                        switch (i) {
                                            case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED:
                                                return "ERROR_CODE_DRM_UNSPECIFIED";
                                            case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER:
                                                return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                            case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE:
                                                return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                            case GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED:
                                                return "ERROR_CODE_DRM_CONTENT_ERROR";
                                            case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION:
                                                return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                            case 6005:
                                                return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                            case 6006:
                                                return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                            case 6007:
                                                return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                            case 6008:
                                                return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                            default:
                                                return i >= 1000000 ? "custom error code" : "invalid error code";
                                        }
                                }
                        }
                }
        }
    }

    public final String cA() {
        return V(this.errorCode);
    }

    protected ak(Bundle bundle) {
        this(bundle.getString(t(2)), j(bundle), bundle.getInt(t(0), 1000), bundle.getLong(t(1), SystemClock.elapsedRealtime()));
    }

    protected ak(String str, Throwable th, int i, long j) {
        super(str, th);
        this.errorCode = i;
        this.gp = j;
    }

    protected static String t(int i) {
        return Integer.toString(i, 36);
    }

    private static Throwable a(Class<?> cls, String str) throws Exception {
        return (Throwable) cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
    }

    private static RemoteException q(String str) {
        return new RemoteException(str);
    }

    private static Throwable j(Bundle bundle) {
        String string = bundle.getString(t(3));
        String string2 = bundle.getString(t(4));
        Throwable th = null;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, ak.class.getClassLoader());
            if (Throwable.class.isAssignableFrom(cls)) {
                th = a(cls, string2);
            }
            if (th != null) {
                return th;
            }
        } catch (Throwable unused) {
        }
        return q(string2);
    }
}
