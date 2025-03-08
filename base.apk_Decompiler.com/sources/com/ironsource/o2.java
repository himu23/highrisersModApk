package com.ironsource;

import android.app.Activity;
import android.content.MutableContextWrapper;

public class o2 {
    MutableContextWrapper a;

    public Activity a() {
        return (Activity) this.a.getBaseContext();
    }

    public synchronized void a(Activity activity) {
        if (this.a == null) {
            this.a = new MutableContextWrapper(activity);
        }
        this.a.setBaseContext(activity);
    }

    public synchronized void b() {
        this.a = null;
    }
}
