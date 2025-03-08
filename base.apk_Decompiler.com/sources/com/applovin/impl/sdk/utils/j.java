package com.applovin.impl.sdk.utils;

import android.content.Context;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.q;
import com.applovin.impl.sdk.utils.d;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

public class j {
    public static void ac(Context context) {
        new Thread(new j$$ExternalSyntheticLambda0(context)).start();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void ad(Context context) {
        d.a U = d.U(context);
        q.a(U);
        o.a(U);
        if (u.dE("com.google.android.gms.appset.AppSet")) {
            try {
                AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() {
                    /* renamed from: a */
                    public void onSuccess(AppSetIdInfo appSetIdInfo) {
                        if (appSetIdInfo != null) {
                            q.a(new q.b(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                            o.a(new o.a(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                            return;
                        }
                        throw new NullPointerException("info is marked non-null but is null");
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }
}
