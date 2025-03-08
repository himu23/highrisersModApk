package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.m;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.network.b;
import com.fyber.inneractive.sdk.network.f;
import com.fyber.inneractive.sdk.network.g0;
import com.fyber.inneractive.sdk.network.r0;
import com.fyber.inneractive.sdk.network.t0;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;

public class o implements w<IAConfigManager.c> {
    public final /* synthetic */ IAConfigManager a;

    public o(IAConfigManager iAConfigManager) {
        this.a = iAConfigManager;
    }

    public void a(Object obj, Exception exc, boolean z) {
        int i;
        IAConfigManager.c cVar = (IAConfigManager.c) obj;
        if (cVar != null) {
            if (z) {
                IAConfigManager iAConfigManager = this.a;
                IAConfigManager iAConfigManager2 = IAConfigManager.M;
                iAConfigManager.getClass();
                iAConfigManager.e = cVar.c;
                iAConfigManager.d = cVar.b;
                iAConfigManager.a = cVar.d;
                iAConfigManager.b = cVar.e;
            } else {
                IAConfigManager.N = System.currentTimeMillis();
                IAConfigManager iAConfigManager3 = this.a;
                iAConfigManager3.getClass();
                IAlog.a("Got new remote configuration from server:", new Object[0]);
                iAConfigManager3.e = cVar.c;
                iAConfigManager3.d = cVar.b;
                iAConfigManager3.a = cVar.d;
                iAConfigManager3.b = cVar.e;
            }
        } else if (exc instanceof f) {
            IAConfigManager.N = System.currentTimeMillis();
        }
        if (!z) {
            IAConfigManager iAConfigManager4 = this.a;
            boolean h = IAConfigManager.h();
            iAConfigManager4.getClass();
            if (h) {
                iAConfigManager4.a((Exception) null);
            } else if ((exc instanceof InvalidAppIdException) || (exc instanceof FileNotFoundException) || (!(exc instanceof t0) ? TextUtils.isEmpty(iAConfigManager4.c.trim()) : !((i = ((t0) exc).a) < 400 || i >= 500))) {
                iAConfigManager4.a((Exception) new InvalidAppIdException());
            } else if (exc instanceof b) {
                iAConfigManager4.a(exc);
            } else {
                iAConfigManager4.a((Exception) new IAConfigManager.d());
            }
            if (IAConfigManager.h()) {
                IAConfigManager iAConfigManager5 = this.a;
                if (iAConfigManager5.C == null) {
                    iAConfigManager5.C = new g0(new q(iAConfigManager5), iAConfigManager5.f, new m());
                }
                r0 p = iAConfigManager5.C.p();
                if (p != r0.RUNNING && p != r0.QUEUED) {
                    iAConfigManager5.s.b(iAConfigManager5.C);
                }
            }
        }
    }
}
