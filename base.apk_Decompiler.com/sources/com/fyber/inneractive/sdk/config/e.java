package com.fyber.inneractive.sdk.config;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.fyber.inneractive.sdk.util.u;
import java.lang.ref.WeakReference;

public class e {
    public final Context a;
    public WeakReference<Context> b;

    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            e.this.b = new WeakReference<>(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public e(Context context, Context context2) {
        a aVar = new a();
        this.a = context2;
        if (context instanceof Activity) {
            this.b = new WeakReference<>(context);
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(aVar);
        }
    }

    public Context a() {
        Context context = (Context) u.a(this.b);
        return context != null ? context : this.a;
    }
}
