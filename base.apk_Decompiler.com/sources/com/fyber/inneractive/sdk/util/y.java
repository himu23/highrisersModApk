package com.fyber.inneractive.sdk.util;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.util.z;

public class y extends BroadcastReceiver {
    public final /* synthetic */ z a;

    public y(z zVar) {
        this.a = zVar;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z;
        z zVar = this.a;
        zVar.getClass();
        IAlog.a("%sonReceive. action = %s", IAlog.a((Object) zVar), intent.getAction());
        z zVar2 = this.a;
        synchronized (zVar2) {
            try {
                z = ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardLocked();
            } catch (Exception unused) {
                IAlog.a("%sFailed to get lock screen status", IAlog.a((Object) zVar2));
                z = false;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zVar2.b = true;
            } else if (("android.intent.action.SCREEN_ON".equals(intent.getAction()) && !z) || "android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zVar2.b = false;
            }
            IAlog.a("%sNew screen state is locked: %s. number of listeners: %d", IAlog.a((Object) zVar2), Boolean.valueOf(zVar2.b), Integer.valueOf(zVar2.a.size()));
            for (z.b c : zVar2.a) {
                c.c(zVar2.b);
            }
        }
    }
}
