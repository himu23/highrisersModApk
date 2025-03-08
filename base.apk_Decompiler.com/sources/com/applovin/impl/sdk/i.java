package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.services.core.device.MimeTypes;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class i extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {
    public static int aAb = -1;
    private final Context E;
    private final AudioManager K;
    private final Set<a> aAc = new HashSet();
    private final Object aAd = new Object();
    private boolean aAe;
    private int aAf;
    private final n sdk;

    public interface a {
        void ge(int i);
    }

    public static boolean gx(int i) {
        return i == 0 || i == 1;
    }

    i(n nVar) {
        this.sdk = nVar;
        Context applicationContext = n.getApplicationContext();
        this.E = applicationContext;
        this.K = (AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public int AV() {
        return this.K.getRingerMode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.applovin.impl.sdk.i.a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.aAd
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.i$a> r1 = r2.aAc     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.i$a> r1 = r2.aAc     // Catch:{ all -> 0x0020 }
            r1.add(r3)     // Catch:{ all -> 0x0020 }
            java.util.Set<com.applovin.impl.sdk.i$a> r3 = r2.aAc     // Catch:{ all -> 0x0020 }
            int r3 = r3.size()     // Catch:{ all -> 0x0020 }
            r1 = 1
            if (r3 != r1) goto L_0x001e
            r2.AW()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.i.a(com.applovin.impl.sdk.i$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.applovin.impl.sdk.i.a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.aAd
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.i$a> r1 = r2.aAc     // Catch:{ all -> 0x001f }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.i$a> r1 = r2.aAc     // Catch:{ all -> 0x001f }
            r1.remove(r3)     // Catch:{ all -> 0x001f }
            java.util.Set<com.applovin.impl.sdk.i$a> r3 = r2.aAc     // Catch:{ all -> 0x001f }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x001d
            r2.AX()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.i.b(com.applovin.impl.sdk.i$a):void");
    }

    private void AW() {
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f("AudioSessionManager", "Observing ringer mode...");
        }
        this.aAf = aAb;
        this.E.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    private void AX() {
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f("AudioSessionManager", "Stopping observation of mute switch state...");
        }
        this.E.unregisterReceiver(this);
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    private void gy(int i) {
        if (!this.aAe) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("AudioSessionManager", "Ringer mode is " + i);
            }
            synchronized (this.aAd) {
                for (a i__externalsyntheticlambda0 : this.aAc) {
                    AppLovinSdkUtils.runOnUiThread(new i$$ExternalSyntheticLambda0(i__externalsyntheticlambda0, i));
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            gy(this.K.getRingerMode());
        }
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.aAe = true;
            this.aAf = this.K.getRingerMode();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.aAe = false;
            if (this.aAf != this.K.getRingerMode()) {
                this.aAf = aAb;
                gy(this.K.getRingerMode());
            }
        }
    }
}
