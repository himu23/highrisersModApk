package com.applovin.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.applovin.exoplayer2.l.q;
import com.ironsource.k2;

final class bc {
    private boolean iV;
    private boolean iW;
    private final WifiManager iX;
    private WifiManager.WifiLock iY;

    public bc(Context context) {
        this.iX = (WifiManager) context.getApplicationContext().getSystemService(k2.b);
    }

    public void setEnabled(boolean z) {
        if (z && this.iY == null) {
            WifiManager wifiManager = this.iX;
            if (wifiManager == null) {
                q.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
            this.iY = createWifiLock;
            createWifiLock.setReferenceCounted(false);
        }
        this.iV = z;
        dp();
    }

    public void C(boolean z) {
        this.iW = z;
        dp();
    }

    private void dp() {
        WifiManager.WifiLock wifiLock = this.iY;
        if (wifiLock != null) {
            if (!this.iV || !this.iW) {
                wifiLock.release();
            } else {
                wifiLock.acquire();
            }
        }
    }
}
