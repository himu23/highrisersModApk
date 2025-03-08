package com.fyber.inneractive.sdk.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import com.fyber.inneractive.sdk.network.c;

public class d implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ c a;

    public d(c cVar) {
        this.a = cVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        c cVar = this.a;
        Handler handler = cVar.d;
        if (handler != null) {
            handler.post(new c.a(20150330, 3500));
        }
    }

    public void onActivityResumed(Activity activity) {
        Handler handler = this.a.d;
        if (handler != null) {
            handler.removeMessages(20150330);
        }
    }
}
