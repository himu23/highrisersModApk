package com.ironsource;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class h implements xc {
    private WeakReference<Activity> a;

    public h(Activity activity) {
        this.a = new WeakReference<>(activity);
    }

    public void a() {
        Activity activity = this.a.get();
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }
}
