package com.fyber.inneractive.sdk.cache.session;

import android.content.Context;
import com.fyber.inneractive.sdk.cache.session.d;
import com.fyber.inneractive.sdk.cache.session.e;
import com.fyber.inneractive.sdk.cache.session.enums.a;
import com.fyber.inneractive.sdk.cache.session.enums.b;
import com.fyber.inneractive.sdk.util.p;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class c implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ b b;
    public final /* synthetic */ d c;

    public c(d dVar, a aVar, b bVar) {
        this.c = dVar;
        this.a = aVar;
        this.b = bVar;
    }

    public void run() {
        boolean z;
        synchronized (this.c.c) {
            a aVar = this.a;
            if (aVar != a.NEW_SESSION) {
                e eVar = this.c.a.a.get(this.b);
                if (eVar != null) {
                    int i = e.a.a[aVar.ordinal()];
                    if (i == 1) {
                        eVar.b++;
                    } else if (i == 2) {
                        eVar.c++;
                    } else if (i == 3) {
                        eVar.a++;
                    }
                }
            } else {
                this.c.a = new f();
            }
            JSONObject a2 = d.a(this.c);
            try {
                z = p.a("session_details.json", (Context) p.a, a2.toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                z = false;
            }
            d dVar = this.c;
            d.a aVar2 = dVar.e;
            if (aVar2 != null) {
                aVar2.a(dVar, z, a2);
            }
        }
    }
}
