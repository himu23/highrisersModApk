package com.fyber.inneractive.sdk.click;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.click.l;
import com.fyber.inneractive.sdk.network.w;
import java.util.List;

public class k implements w<c> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ l c;

    public k(l lVar, String str, String str2) {
        this.c = lVar;
        this.a = str;
        this.b = str2;
    }

    public void a(Object obj, Exception exc, boolean z) {
        c cVar = (c) obj;
        if (exc != null) {
            l.a(this.c, (String) null, this.a, this.b);
        } else if (cVar != null) {
            String str = this.a;
            if (cVar.a.size() > 1) {
                List<String> list = cVar.a;
                str = list.get(list.size() - 1);
            }
            b a2 = this.c.a(str);
            if ((a2 == null || a2.a == l.d.FAILED) && !TextUtils.isEmpty(cVar.b)) {
                l.a(this.c, cVar, str, true);
                l.a(this.c, cVar.b, str, this.b);
                return;
            }
            l.a(this.c, cVar, str, false);
            if (this.c.e.size() == 0) {
                this.c.e.add(new i(str, false, l.d.INTERNAL_REDIRECT, (String) null));
            }
            this.c.a(l.a(str, "followRedirects", "Invalid response"));
        }
    }
}
