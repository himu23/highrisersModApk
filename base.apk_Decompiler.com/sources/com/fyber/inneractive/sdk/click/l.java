package com.fyber.inneractive.sdk.click;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.web.r;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.m2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l {
    public Context a;
    public String b;
    public boolean c;
    public b d;
    public final List<i> e;
    public long f = 0;
    public q0 g;
    public final ArrayList<a> h;
    public r i;
    public boolean j;
    public k k;

    public class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public void run() {
            b bVar = l.this.d;
            if (bVar != null) {
                bVar.a(this.a);
            }
        }
    }

    public interface b {
        void a(b bVar);
    }

    public static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    public enum d {
        FAILED(m2.h.t),
        OPEN_GOOGLE_STORE(m2.h.U),
        OPENED_IN_INTERNAL_BROWSER("internal browser"),
        OPENED_IN_EXTERNAL_BROWSER("external browser"),
        INTERNAL_REDIRECT("internal redirect"),
        OPEN_IN_EXTERNAL_APPLICATION("external app"),
        DEEP_LINK("deep link"),
        OPENED_USING_CHROME_NAVIGATE("chrome navigate"),
        OPEN_INTERNAL_STORE("internal store");
        
        public String simpleName;

        /* access modifiers changed from: public */
        d(String str) {
            this.simpleName = str;
        }
    }

    public l(boolean z) {
        this.c = z;
        this.h = new ArrayList<>();
        this.e = new ArrayList();
    }

    public static void a(l lVar, c cVar, String str, boolean z) {
        lVar.getClass();
        for (String next : cVar.a) {
            if (!TextUtils.equals(next, str)) {
                lVar.e.add(new i(next, z, d.INTERNAL_REDIRECT, (String) null));
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008e, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0091, code lost:
        if ((r5 instanceof java.lang.InterruptedException) == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0093, code lost:
        com.fyber.inneractive.sdk.util.IAlog.b("%sfailed followRedirects %s", com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r3), r5);
        r3.e.add(new com.fyber.inneractive.sdk.click.i(r4, false, com.fyber.inneractive.sdk.click.l.d.INTERNAL_REDIRECT, (java.lang.String) null));
        a(new com.fyber.inneractive.sdk.click.b(r4, com.fyber.inneractive.sdk.click.l.d.FAILED, "followRedirects", r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        com.fyber.inneractive.sdk.util.IAlog.a("%sgetDecodedUri: Failed parsing Uri!", "SuperClickHandler");
        r5 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r4, java.lang.String r5, com.fyber.inneractive.sdk.click.l.b r6, com.fyber.inneractive.sdk.web.r r7, boolean r8, com.fyber.inneractive.sdk.ignite.k r9, java.lang.String r10) {
        /*
            r3 = this;
            r3.a = r4
            r3.b = r5
            r3.d = r6
            r3.j = r8
            long r0 = java.lang.System.currentTimeMillis()
            r3.f = r0
            r3.i = r7
            r3.k = r9
            java.lang.String r4 = r3.b
            com.fyber.inneractive.sdk.click.b r4 = r3.a((java.lang.String) r4)
            int r6 = com.fyber.inneractive.sdk.util.IAlog.a
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = "VAST_EVENT"
            r8 = 0
            r6[r8] = r7
            r7 = 1
            r6[r7] = r4
            r9 = 2
            r6[r9] = r5
            java.lang.String r5 = "%s EVENT_CLICK %s %s"
            r0 = 0
            com.fyber.inneractive.sdk.util.IAlog.a(r7, r0, r5, r6)
            if (r4 != 0) goto L_0x00ba
            java.lang.String r4 = r3.b
            boolean r5 = com.fyber.inneractive.sdk.util.b0.d(r4)     // Catch:{ Exception -> 0x0048 }
            if (r5 != 0) goto L_0x0043
            java.lang.String r5 = "utf-8"
            java.lang.String r5 = java.net.URLDecoder.decode(r4, r5)     // Catch:{ Exception -> 0x0048 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0054
        L_0x0043:
            android.net.Uri r5 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0054
        L_0x0048:
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x008e }
            java.lang.String r6 = "SuperClickHandler"
            r5[r8] = r6     // Catch:{ Exception -> 0x008e }
            java.lang.String r6 = "%sgetDecodedUri: Failed parsing Uri!"
            com.fyber.inneractive.sdk.util.IAlog.a(r6, r5)     // Catch:{ Exception -> 0x008e }
            r5 = r0
        L_0x0054:
            boolean r6 = r3.a((android.net.Uri) r5)     // Catch:{ Exception -> 0x008e }
            if (r6 != 0) goto L_0x005b
            goto L_0x00ba
        L_0x005b:
            java.lang.String r6 = "%sfollowRedirects: Fetching uri: %s"
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x008e }
            java.lang.String r2 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r3)     // Catch:{ Exception -> 0x008e }
            r1[r8] = r2     // Catch:{ Exception -> 0x008e }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x008e }
            r1[r7] = r2     // Catch:{ Exception -> 0x008e }
            com.fyber.inneractive.sdk.util.IAlog.a(r6, r1)     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x008e }
            com.fyber.inneractive.sdk.network.q0 r6 = new com.fyber.inneractive.sdk.network.q0     // Catch:{ Exception -> 0x008e }
            com.fyber.inneractive.sdk.click.k r1 = new com.fyber.inneractive.sdk.click.k     // Catch:{ Exception -> 0x008e }
            r1.<init>(r3, r5, r10)     // Catch:{ Exception -> 0x008e }
            com.fyber.inneractive.sdk.network.x r10 = com.fyber.inneractive.sdk.network.x.a()     // Catch:{ Exception -> 0x008e }
            com.fyber.inneractive.sdk.network.g r10 = r10.b()     // Catch:{ Exception -> 0x008e }
            r6.<init>(r1, r5, r10)     // Catch:{ Exception -> 0x008e }
            r3.g = r6     // Catch:{ Exception -> 0x008e }
            com.fyber.inneractive.sdk.config.IAConfigManager r5 = com.fyber.inneractive.sdk.config.IAConfigManager.M     // Catch:{ Exception -> 0x008e }
            com.fyber.inneractive.sdk.network.y r5 = r5.s     // Catch:{ Exception -> 0x008e }
            r5.b(r6)     // Catch:{ Exception -> 0x008e }
            goto L_0x00ba
        L_0x008e:
            r5 = move-exception
            boolean r6 = r5 instanceof java.lang.InterruptedException
            if (r6 != 0) goto L_0x00ba
            java.lang.Object[] r6 = new java.lang.Object[r9]
            java.lang.String r9 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r3)
            r6[r8] = r9
            r6[r7] = r5
            java.lang.String r7 = "%sfailed followRedirects %s"
            com.fyber.inneractive.sdk.util.IAlog.b(r7, r6)
            java.util.List<com.fyber.inneractive.sdk.click.i> r6 = r3.e
            com.fyber.inneractive.sdk.click.i r7 = new com.fyber.inneractive.sdk.click.i
            com.fyber.inneractive.sdk.click.l$d r9 = com.fyber.inneractive.sdk.click.l.d.INTERNAL_REDIRECT
            r7.<init>(r4, r8, r9, r0)
            r6.add(r7)
            com.fyber.inneractive.sdk.click.b r6 = new com.fyber.inneractive.sdk.click.b
            com.fyber.inneractive.sdk.click.l$d r7 = com.fyber.inneractive.sdk.click.l.d.FAILED
            java.lang.String r8 = "followRedirects"
            r6.<init>(r4, r7, r8, r5)
            r3.a((com.fyber.inneractive.sdk.click.b) r6)
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.click.l.a(android.content.Context, java.lang.String, com.fyber.inneractive.sdk.click.l$b, com.fyber.inneractive.sdk.web.r, boolean, com.fyber.inneractive.sdk.ignite.k, java.lang.String):void");
    }

    public final boolean a(Uri uri) {
        if (uri == null) {
            IAlog.a("%s followRedirects: Got a url which is not valid: null", IAlog.a((Object) this));
            this.e.add(new i((String) null, false, (d) null, "Invalid url"));
            a(a(uri.toString(), "followRedirects", "Invalid url"));
            return false;
        }
        String scheme = uri.getScheme();
        if (scheme != null && (scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTP) || scheme.equalsIgnoreCase("https"))) {
            return true;
        }
        IAlog.a("%scould not follow redirects for scheme: %s", IAlog.a((Object) this), uri.getScheme());
        IAlog.a("%sfull url: %s", IAlog.a((Object) this), uri.toString());
        List<i> list = this.e;
        String uri2 = uri.toString();
        list.add(new i(uri2, false, (d) null, "Invalid scheme: " + uri.getScheme()));
        a(a(uri.toString(), "followRedirects", "Invalid scheme: " + uri.getScheme()));
        return false;
    }

    public final b a(String str) {
        Uri uri;
        try {
            uri = Uri.parse(str);
        } catch (Exception unused) {
            IAlog.a("IAJavaUtil: getValidUri: Invalid url %s", str);
            uri = null;
        }
        if (uri == null) {
            this.e.add(new i(str, false, (d) null, "illegal uri"));
            return a(a(str, (String) null, "illegal uri"));
        } else if (this.h.size() <= 0) {
            this.e.add(new i(str, false, (d) null, "no click handlers found"));
            return a(a(str, (String) null, "no click handlers found"));
        } else {
            Iterator<a> it = this.h.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a(uri, this)) {
                    Context context = this.a;
                    b a2 = context != null ? next.a(context, uri, this.e) : null;
                    if (a2 != null) {
                        return a(a2);
                    }
                }
            }
            return null;
        }
    }

    public static void a(l lVar, String str, String str2, String str3) {
        if (lVar.c) {
            Intent intent = new Intent(lVar.a, InneractiveInternalBrowserActivity.class);
            if (!TextUtils.isEmpty(str)) {
                InneractiveInternalBrowserActivity.setHtmlExtra(str);
            }
            intent.putExtra(InneractiveInternalBrowserActivity.URL_EXTRA, str2);
            intent.putExtra("spotId", str3);
            if (!(lVar.a instanceof Activity)) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
            }
            try {
                Context context = lVar.a;
                if (context != null) {
                    context.startActivity(intent);
                }
                List<i> list = lVar.e;
                d dVar = d.OPENED_IN_INTERNAL_BROWSER;
                list.add(new i(str2, true, dVar, (String) null));
                lVar.a(a(str2, dVar, "followRedirects"));
            } catch (ActivityNotFoundException unused) {
                lVar.e.add(new i(str2, false, d.OPENED_IN_INTERNAL_BROWSER, "internal browser not registered"));
                lVar.a(a(str2, "followRedirects", "internal browser not registered"));
            }
        }
    }

    public static b a(String str, String str2, String str3) {
        return new b(str, d.FAILED, str2, new c(str3));
    }

    public static b a(String str, d dVar, String str2) {
        return new b(str, dVar, str2, (Throwable) null);
    }

    public final b a(b bVar) {
        bVar.f = this.e;
        bVar.e = System.currentTimeMillis() - this.f;
        IAlog.a("%s reporting result: %s", IAlog.a((Object) this), bVar);
        q.b.post(new a(bVar));
        return bVar;
    }
}
