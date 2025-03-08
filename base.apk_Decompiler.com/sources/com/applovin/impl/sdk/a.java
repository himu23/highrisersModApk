package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a implements Application.ActivityLifecycleCallbacks {
    private final List<com.applovin.impl.sdk.utils.a> ayM = Collections.synchronizedList(new ArrayList());
    private WeakReference<Activity> ayN = new WeakReference<>((Object) null);
    private WeakReference<Activity> ayO = new WeakReference<>((Object) null);

    public a(Context context) {
        x.D("AppLovinSdk", "Attaching Activity lifecycle manager...");
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.ayN = new WeakReference<>(activity);
            if (activity.hasWindowFocus()) {
                this.ayO = this.ayN;
            }
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    public Activity Az() {
        return (Activity) this.ayN.get();
    }

    public Activity AA() {
        return (Activity) this.ayO.get();
    }

    public void a(com.applovin.impl.sdk.utils.a aVar) {
        this.ayM.add(aVar);
    }

    public void b(com.applovin.impl.sdk.utils.a aVar) {
        this.ayM.remove(aVar);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (com.applovin.impl.sdk.utils.a onActivityCreated : new ArrayList(this.ayM)) {
            onActivityCreated.onActivityCreated(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        for (com.applovin.impl.sdk.utils.a onActivityStarted : new ArrayList(this.ayM)) {
            onActivityStarted.onActivityStarted(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.ayN = weakReference;
        this.ayO = weakReference;
        for (com.applovin.impl.sdk.utils.a onActivityResumed : new ArrayList(this.ayM)) {
            onActivityResumed.onActivityResumed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        this.ayO = new WeakReference<>((Object) null);
        for (com.applovin.impl.sdk.utils.a onActivityPaused : new ArrayList(this.ayM)) {
            onActivityPaused.onActivityPaused(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        for (com.applovin.impl.sdk.utils.a onActivityStopped : new ArrayList(this.ayM)) {
            onActivityStopped.onActivityStopped(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        for (com.applovin.impl.sdk.utils.a onActivitySaveInstanceState : new ArrayList(this.ayM)) {
            onActivitySaveInstanceState.onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        for (com.applovin.impl.sdk.utils.a onActivityDestroyed : new ArrayList(this.ayM)) {
            onActivityDestroyed.onActivityDestroyed(activity);
        }
    }
}
