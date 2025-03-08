package com.ironsource;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.m2;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class x5 extends FrameLayout implements v6 {
    private static final String b = "IronSourceAdContainer";
    /* access modifiers changed from: private */
    public c6 a;

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            x5 x5Var = x5.this;
            x5Var.removeView(x5Var.a.getPresentingView());
            x5.this.a.a(this.a, this.b);
            c6 unused = x5.this.a = null;
        }
    }

    public x5(Context context) {
        super(context);
    }

    public x5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public x5(c6 c6Var, Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(c6Var.d().c(), c6Var.d().a()));
        this.a = c6Var;
        addView(c6Var.getPresentingView());
    }

    private void b() throws Exception {
        JSONObject jSONObject;
        try {
            jSONObject = this.a.c().a().getJSONObject(w5.p).getJSONObject(w5.s);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("adViewId", this.a.b());
        this.a.c().a(m2.g.Y, jSONObject);
    }

    public void a() throws Exception {
        c6 c6Var = this.a;
        if (c6Var == null || c6Var.c() == null) {
            throw new Exception("mAdPresenter or mAdPresenter.getAdViewLogic() are null");
        }
        b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.ironsource.c6 r0 = r2.a     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0029
            com.ironsource.a6 r0 = r0.c()     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0029
            com.ironsource.c6 r0 = r2.a     // Catch:{ all -> 0x002b }
            android.webkit.WebView r0 = r0.getPresentingView()     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0014
            goto L_0x0029
        L_0x0014:
            com.ironsource.c6 r0 = r2.a     // Catch:{ all -> 0x002b }
            com.ironsource.a6 r0 = r0.c()     // Catch:{ all -> 0x002b }
            r0.e()     // Catch:{ all -> 0x002b }
            com.ironsource.n5 r0 = com.ironsource.n5.a     // Catch:{ all -> 0x002b }
            com.ironsource.x5$a r1 = new com.ironsource.x5$a     // Catch:{ all -> 0x002b }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x002b }
            r0.c(r1)     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x0029:
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.x5.a(java.lang.String, java.lang.String):void");
    }

    public void a(String str, String str2, String str3) {
        c6 c6Var = this.a;
        if (c6Var != null) {
            c6Var.a(str, str2, str3);
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) {
        this.a.a(jSONObject, str, str2);
    }

    public void b(JSONObject jSONObject, String str, String str2) {
        this.a.b(jSONObject, str, str2);
    }

    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        this.a.c(jSONObject, str, str2);
    }

    public WebView getPresentingView() {
        return this.a.getPresentingView();
    }

    public v5 getSize() {
        c6 c6Var = this.a;
        return c6Var != null ? c6Var.d() : new v5();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        Logger.i(b, "onVisibilityChanged: " + i);
        c6 c6Var = this.a;
        if (c6Var != null) {
            try {
                c6Var.c().a(w5.k, i, isShown());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        Logger.i(b, "onWindowVisibilityChanged: " + i);
        c6 c6Var = this.a;
        if (c6Var != null) {
            try {
                c6Var.c().a(w5.l, i, isShown());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
