package com.iab.omid.library.fyber.walking.async;

import com.iab.omid.library.fyber.adsession.a;
import com.iab.omid.library.fyber.internal.c;
import com.iab.omid.library.fyber.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

public class e extends a {
    public e(b.C0007b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    private void b(String str) {
        c c = c.c();
        if (c != null) {
            for (a next : c.b()) {
                if (this.c.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().a(str, this.e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.d.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        b(str);
        super.onPostExecute(str);
    }
}
