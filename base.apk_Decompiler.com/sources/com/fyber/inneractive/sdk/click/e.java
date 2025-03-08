package com.fyber.inneractive.sdk.click;

import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.click.l;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.w;
import java.util.List;

public class e implements w<c> {
    public final /* synthetic */ List a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ f c;

    public e(f fVar, List list, Uri uri) {
        this.c = fVar;
        this.a = list;
        this.b = uri;
    }

    public void a(Object obj, Exception exc, boolean z) {
        c cVar = (c) obj;
        if (exc != null || cVar == null) {
            IAConfigManager.a(this.b.toString(), (String) null);
            Uri uri = this.b;
            this.c.getClass();
            b a2 = l.a(uri.toString(), "IgniteGooglePlay", "failed getting redirects");
            List list = this.a;
            if (list != null) {
                list.add(new i(this.b.toString(), false, l.d.INTERNAL_REDIRECT, "failed getting redirects. ignite click handler"));
                a2.f = this.a;
            }
            f fVar = this.c;
            fVar.c.a(a2, fVar.d, fVar.e);
        } else if (cVar.a.size() > 0) {
            List<String> list2 = cVar.a;
            String str = list2.get(list2.size() - 1);
            if (this.a != null) {
                for (String next : cVar.a) {
                    if (!TextUtils.equals(next, str)) {
                        this.a.add(new i(next, true, l.d.INTERNAL_REDIRECT, (String) null));
                    }
                }
                List list3 = this.a;
                l.d dVar = l.d.OPEN_INTERNAL_STORE;
                list3.add(new i(str, true, dVar, (String) null));
                this.c.getClass();
                b a3 = l.a(str, dVar, "IgniteGooglePlay");
                a3.f = this.a;
                f fVar2 = this.c;
                fVar2.c.a(a3, fVar2.d, fVar2.e);
            }
            if (str.startsWith("market")) {
                IAConfigManager.a(str.replace("market://details?id=", "https://play.google.com/store/apps/details?id="), (String) null);
            } else {
                IAConfigManager.a(str, cVar.b);
            }
        }
    }
}
