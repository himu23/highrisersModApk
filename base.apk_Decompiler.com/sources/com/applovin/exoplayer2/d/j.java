package com.applovin.exoplayer2.d;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import com.applovin.exoplayer2.d.c;
import com.applovin.exoplayer2.h;
import com.applovin.exoplayer2.l.ai;
import com.google.android.gms.games.GamesStatusCodes;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;

public final class j {
    public static int b(Exception exc, int i) {
        if (ai.acV >= 21 && b.d(exc)) {
            return b.e(exc);
        }
        if (ai.acV >= 23 && c.f(exc)) {
            return 6006;
        }
        if (ai.acV >= 18 && a.b(exc)) {
            return GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE;
        }
        if (ai.acV >= 18 && a.c(exc)) {
            return 6007;
        }
        if (exc instanceof t) {
            return GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER;
        }
        if (exc instanceof c.d) {
            return GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED;
        }
        if (exc instanceof q) {
            return 6008;
        }
        if (i == 1) {
            return 6006;
        }
        if (i == 2) {
            return GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION;
        }
        if (i == 3) {
            return GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE;
        }
        throw new IllegalArgumentException();
    }

    private static final class a {
        public static boolean b(Throwable th) {
            return th instanceof NotProvisionedException;
        }

        public static boolean c(Throwable th) {
            return th instanceof DeniedByServerException;
        }
    }

    private static final class b {
        public static boolean d(Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }

        public static int e(Throwable th) {
            return h.r(ai.bl(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
    }

    private static final class c {
        public static boolean f(Throwable th) {
            return g$$ExternalSyntheticApiModelOutline0.m((Object) th);
        }
    }
}
