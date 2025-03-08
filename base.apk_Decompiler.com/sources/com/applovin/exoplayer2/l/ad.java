package com.applovin.exoplayer2.l;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public class ad implements d {
    public void oM() {
    }

    protected ad() {
    }

    public long oK() {
        return SystemClock.elapsedRealtime();
    }

    public long oL() {
        return SystemClock.uptimeMillis();
    }

    public o a(Looper looper, Handler.Callback callback) {
        return new ae(new Handler(looper, callback));
    }
}
