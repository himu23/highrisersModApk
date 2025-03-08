package com.applovin.impl.mediation.debugger.c;

import android.text.TextUtils;
import com.applovin.impl.mediation.debugger.a;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.x;
import com.ironsource.i9;
import com.ironsource.m2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b extends d {
    /* access modifiers changed from: private */
    public final a apQ;

    public interface a {
        void a(a.b bVar);

        void bG(String str);
    }

    public b(n nVar, a aVar) {
        super("TaskFetchDeveloperUri", nVar);
        this.apQ = aVar;
    }

    public void run() {
        String str;
        if (this.sdk.BV() != null) {
            str = String.valueOf(this.sdk.BU().Ej().En());
        } else {
            str = String.valueOf(this.sdk.BS().Db().get(m2.h.V));
        }
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str2 = this.tag;
            xVar2.f(str2, "Looking up developer URI for package name: " + str);
        }
        c.a cX = c.D(this.sdk).cX(i9.a);
        this.sdk.BO().b((d) new w<String>(cX.cW("https://play.google.com/store/apps/details?id=" + str).ad("").aS(false).Ig(), this.sdk) {
            /* renamed from: c */
            public void d(String str, int i) {
                if (TextUtils.isEmpty(str)) {
                    x xVar = this.logger;
                    if (x.Fn()) {
                        this.logger.i(this.tag, "No developer URI found - response is empty");
                    }
                    b.this.apQ.a(a.b.DEVELOPER_URI_NOT_FOUND);
                }
                Matcher matcher = Pattern.compile("(?<=\"appstore:developer_url\" content=\").+?(?=\">)").matcher(str);
                if (matcher.find()) {
                    String group = matcher.group();
                    x xVar2 = this.logger;
                    if (x.Fn()) {
                        x xVar3 = this.logger;
                        String str2 = this.tag;
                        xVar3.f(str2, "Found developer URI: " + group);
                    }
                    b.this.apQ.bG(group);
                    return;
                }
                x xVar4 = this.logger;
                if (x.Fn()) {
                    this.logger.i(this.tag, "Unable to find developer URI from the Play Store listing metadata");
                }
                b.this.apQ.a(a.b.DEVELOPER_URI_NOT_FOUND);
            }

            public void a(int i, String str, String str2) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str3 = this.tag;
                    xVar2.i(str3, "Unable to fetch developer URI due to: " + str + ", and received error code: " + i);
                }
                b.this.apQ.a(a.b.DEVELOPER_URI_NOT_FOUND);
            }
        });
    }
}
