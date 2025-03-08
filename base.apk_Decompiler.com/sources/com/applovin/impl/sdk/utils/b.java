package com.applovin.impl.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsetsController;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;

public class b {

    public interface a<T extends Activity> {
        void onActivityCreated(T t);
    }

    public static void a(Context context, final Class cls, final com.applovin.impl.sdk.a aVar, final a aVar2) {
        aVar.a(new a() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (cls.isInstance(activity)) {
                    aVar2.onActivityCreated(activity);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                if (cls.isInstance(activity) && !activity.isChangingConfigurations()) {
                    aVar.b(this);
                }
            }
        });
        context.startActivity(new Intent(context, cls));
    }

    public static void a(boolean z, Activity activity) {
        if (!z || !h.Ld()) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
            return;
        }
        WindowInsetsController m = activity.getWindow().getInsetsController();
        if (m != null) {
            m.setSystemBarsBehavior(2);
            m.hide(g$$ExternalSyntheticApiModelOutline0.m$1());
            return;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public static boolean i(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isChangingConfigurations() || (h.KV() && activity.isDestroyed());
    }

    public static Activity y(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
