package com.applovin.impl.mediation.debugger.c;

import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.applovin.impl.mediation.debugger.a;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.x;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.i9;
import java.util.ArrayList;
import java.util.Arrays;

public class a extends d {
    /* access modifiers changed from: private */
    public String anT;
    /* access modifiers changed from: private */
    public final C0074a apN;
    private final String apO;

    /* renamed from: com.applovin.impl.mediation.debugger.c.a$a  reason: collision with other inner class name */
    public interface C0074a {
        void a(a.b bVar, String str);

        void t(String str, String str2);
    }

    public a(n nVar, String str, C0074a aVar) {
        super("TaskFetchAppAdsContent", nVar);
        this.apO = str;
        this.apN = aVar;
    }

    public void run() {
        ArrayList arrayList = new ArrayList(Arrays.asList(Uri.parse(this.apO).getAuthority().split("\\.")));
        if (arrayList.size() > 0) {
            String str = (String) arrayList.get(0);
            if ("www".equals(str) || InneractiveMediationDefs.GENDER_MALE.equals(str)) {
                arrayList.remove(0);
            }
        }
        String join = TextUtils.join(".", arrayList);
        Uri build = new Uri.Builder().scheme("https").authority(join).appendPath("app-ads.txt").build();
        c Ig = c.D(this.sdk).cX(i9.a).cW(build.toString()).cY(new Uri.Builder().scheme(ProxyConfig.MATCH_HTTP).authority(join).appendPath("app-ads.txt").build().toString()).ad("").aS(false).Ig();
        this.anT = build.toString();
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str2 = this.tag;
            xVar2.f(str2, "Looking up app-ads.txt at " + this.anT);
        }
        this.sdk.BO().b((d) new w<String>(Ig, this.sdk) {
            /* renamed from: c */
            public void d(String str, int i) {
                if (TextUtils.isEmpty(str)) {
                    x xVar = this.logger;
                    if (x.Fn()) {
                        this.logger.i(this.tag, "No app-ads.txt found");
                    }
                    a.this.apN.a(a.b.APPADSTXT_NOT_FOUND, a.this.anT);
                    return;
                }
                x xVar2 = this.logger;
                if (x.Fn()) {
                    this.logger.f(this.tag, "Found app-ads.txt");
                }
                a.this.apN.t(str, a.this.anT);
            }

            public void a(int i, String str, String str2) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str3 = this.tag;
                    xVar2.i(str3, "Unable to fetch app-ads.txt due to: " + str + ", and received error code: " + i);
                }
                a.this.apN.a(a.b.APPADSTXT_NOT_FOUND, a.this.anT);
            }
        });
    }
}
