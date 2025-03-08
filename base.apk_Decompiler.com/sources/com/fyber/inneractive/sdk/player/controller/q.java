package com.fyber.inneractive.sdk.player.controller;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.fyber.inneractive.sdk.player.ui.l;
import com.fyber.inneractive.sdk.util.IAlog;

public class q implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ n a;

    public q(n nVar) {
        this.a = nVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        if (activity.equals(this.a.d.getContext())) {
            l lVar = this.a.d;
            lVar.h = true;
            if (lVar.H != null) {
                IAlog.a("Autoclick paused", new Object[0]);
                lVar.H.a();
            }
            this.a.d.b();
        }
    }

    public void onActivityResumed(Activity activity) {
        if (activity.equals(this.a.d.getContext())) {
            l lVar = this.a.d;
            lVar.h = false;
            if (lVar.H != null) {
                IAlog.a("Autoclick resumed", new Object[0]);
                lVar.H.b();
            }
            this.a.d.b();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
