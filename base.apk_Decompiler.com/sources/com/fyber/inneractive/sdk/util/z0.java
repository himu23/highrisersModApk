package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ironsource.t4;
import java.util.concurrent.atomic.AtomicBoolean;

public class z0 {
    public volatile String a = null;
    public Context b = null;
    public AtomicBoolean c = new AtomicBoolean(false);
    public final Runnable d = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            z0.this.e();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        public void run() {
            z0.this.b.getSharedPreferences("fyber.ua", 0).edit().putString(t4.R, this.a).apply();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            String str;
            z0 z0Var = z0.this;
            Context context = z0Var.b;
            if (context != null) {
                try {
                    str = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused) {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    z0Var.a(str);
                }
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            z0.this.b();
        }
    }

    public String a() {
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        Runnable runnable = this.d;
        if (runnable != null) {
            Handler handler = q.b;
            handler.removeCallbacks(runnable);
            handler.postDelayed(this.d, 50);
        }
        return System.getProperty("http.agent");
    }

    public final void b() {
        WebView webView;
        String str = null;
        try {
            webView = new WebView(this.b);
            try {
                str = webView.getSettings().getUserAgentString();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            webView = null;
        }
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
        if (webView != null) {
            webView.destroy();
        }
    }

    public final void c() {
        if (this.b != null && TextUtils.isEmpty(this.a)) {
            this.a = this.b.getSharedPreferences("fyber.ua", 0).getString(t4.R, (String) null);
            if (!TextUtils.isEmpty(this.a)) {
                IAlog.a("UserAgentProvider | populated user agent from shared prefs", new Object[0]);
                this.c.compareAndSet(false, true);
            }
            e();
        }
    }

    public void d() {
        Context context;
        String str;
        c();
        if (!this.c.get() && (context = this.b) != null) {
            try {
                str = WebSettings.getDefaultUserAgent(context);
            } catch (Throwable unused) {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                a(str);
            }
        }
    }

    public final void e() {
        q.a(new c());
    }

    public final void a(String str) {
        this.a = str;
        if (!TextUtils.isEmpty(this.a)) {
            IAlog.a("UserAgentProvider | populated user agent form updateUserAgentIfPossible", new Object[0]);
            this.c.compareAndSet(false, true);
        }
        q.a(new b(str));
    }
}
