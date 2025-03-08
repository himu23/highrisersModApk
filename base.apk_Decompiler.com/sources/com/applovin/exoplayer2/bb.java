package com.applovin.exoplayer2;

import android.content.Context;
import android.os.PowerManager;
import com.applovin.exoplayer2.l.q;

final class bb {
    private final PowerManager iT;
    private PowerManager.WakeLock iU;
    private boolean iV;
    private boolean iW;

    public bb(Context context) {
        this.iT = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void setEnabled(boolean z) {
        if (z && this.iU == null) {
            PowerManager powerManager = this.iT;
            if (powerManager == null) {
                q.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
            this.iU = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.iV = z;
        m1758do();
    }

    public void C(boolean z) {
        this.iW = z;
        m1758do();
    }

    /* renamed from: do  reason: not valid java name */
    private void m1758do() {
        PowerManager.WakeLock wakeLock = this.iU;
        if (wakeLock != null) {
            if (!this.iV || !this.iW) {
                wakeLock.release();
            } else {
                wakeLock.acquire();
            }
        }
    }
}
