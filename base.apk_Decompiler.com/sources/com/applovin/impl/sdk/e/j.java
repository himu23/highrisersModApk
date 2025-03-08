package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import com.applovin.impl.adview.d;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends d {
    /* access modifiers changed from: private */
    public final i aTZ;
    /* access modifiers changed from: private */
    public final AppLovinPostbackListener aUa;
    private final q.b aUb;

    public j(i iVar, q.b bVar, n nVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", nVar);
        if (iVar != null) {
            this.aTZ = iVar;
            this.aUa = appLovinPostbackListener;
            this.aUb = bVar;
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    public void run() {
        if (!StringUtils.isValidString(this.aTZ.zL())) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.g(this.tag, "Requested URL is not valid; nothing to do...");
            }
            AppLovinPostbackListener appLovinPostbackListener = this.aUa;
            if (appLovinPostbackListener != null) {
                appLovinPostbackListener.onPostbackFailure(this.aTZ.zL(), AppLovinErrorCodes.INVALID_URL);
            }
        } else if (this.aTZ.Ix()) {
            AnonymousClass1 r0 = new AppLovinPostbackListener() {
                public void onPostbackSuccess(String str) {
                    if (j.this.aUa != null) {
                        j.this.aUa.onPostbackSuccess(j.this.aTZ.zL());
                    }
                }

                public void onPostbackFailure(String str, int i) {
                    j.this.KC();
                }
            };
            if (((Boolean) getSdk().a(b.aQL)).booleanValue()) {
                getSdk().Cg().a(this.aTZ, r0);
            } else {
                d.a(this.aTZ, getSdk(), (AppLovinPostbackListener) r0);
            }
        } else {
            KC();
        }
    }

    /* access modifiers changed from: private */
    public void KC() {
        AnonymousClass2 r0 = new w<Object>(this.aTZ, getSdk()) {
            final String aHr;

            {
                this.aHr = j.this.aTZ.zL();
            }

            public void d(Object obj, int i) {
                if (obj instanceof String) {
                    for (String next : this.sdk.b(b.aLr)) {
                        if (next.startsWith(next)) {
                            String str = (String) obj;
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    com.applovin.impl.sdk.utils.i.j(jSONObject, this.sdk);
                                    com.applovin.impl.sdk.utils.i.i(jSONObject, this.sdk);
                                    com.applovin.impl.sdk.utils.i.k(jSONObject, this.sdk);
                                    break;
                                } catch (JSONException unused) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                if (j.this.aUa != null) {
                    j.this.aUa.onPostbackSuccess(this.aHr);
                }
                if (j.this.aTZ.IG()) {
                    this.sdk.Ch().a(j.this.aTZ.Iy(), this.aHr, i, obj, (String) null, true);
                }
            }

            public void a(int i, String str, Object obj) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str2 = this.tag;
                    xVar2.i(str2, "Failed to dispatch postback. Error code: " + i + " URL: " + this.aHr);
                }
                if (j.this.aUa != null) {
                    j.this.aUa.onPostbackFailure(this.aHr, i);
                }
                if (j.this.aTZ.IG()) {
                    this.sdk.Ch().a(j.this.aTZ.Iy(), this.aHr, i, obj, str, false);
                }
            }
        };
        r0.a(this.aUb);
        getSdk().BO().b((d) r0);
    }
}
