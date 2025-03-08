package com.ironsource;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.core.util.HalfKt$$ExternalSyntheticApiModelOutline0;
import java.lang.ref.WeakReference;

public class g implements xc {
    private WeakReference<Activity> a;

    public g(Activity activity) {
        this.a = new WeakReference<>(activity);
    }

    public void a() {
        Activity activity = this.a.get();
        if (activity != null) {
            int i = Build.VERSION.SDK_INT;
            Window window = activity.getWindow();
            if (i >= 30) {
                WindowInsetsController m = window.getDecorView().getWindowInsetsController();
                if (m != null) {
                    m.hide(HalfKt$$ExternalSyntheticApiModelOutline0.m());
                    return;
                }
                return;
            }
            window.setFlags(1024, 1024);
        }
    }
}
