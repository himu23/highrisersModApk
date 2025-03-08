package com.applovin.impl.sdk.e;

import com.applovin.impl.b.e;
import com.applovin.impl.b.f;
import com.applovin.impl.b.m;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.utils.z;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

public abstract class t extends d {
    private final AppLovinAdLoadListener aTG;
    private final a aUT;

    t(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super("TaskProcessVastResponse", nVar);
        if (eVar != null) {
            this.aTG = appLovinAdLoadListener;
            this.aUT = (a) eVar;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    public static t a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        return new c(new a(jSONObject, jSONObject2, bVar, nVar), appLovinAdLoadListener, nVar);
    }

    public static t a(String str, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        return new b(str, new a(jSONObject, jSONObject2, bVar, nVar), appLovinAdLoadListener, nVar);
    }

    public static t a(y yVar, e eVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        return new d(yVar, eVar, appLovinAdLoadListener, nVar);
    }

    /* access modifiers changed from: protected */
    public y dw(String str) {
        try {
            return z.e(str, this.sdk);
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Failed to process VAST response", th);
            }
            a(f.XML_PARSING);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(y yVar) {
        int Mr = this.aUT.Mr();
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Finished parsing XML at depth " + Mr);
        }
        this.aUT.b(yVar);
        if (m.d(yVar)) {
            int intValue = ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPs)).intValue();
            if (Mr < intValue) {
                x xVar3 = this.logger;
                if (x.Fn()) {
                    this.logger.f(this.tag, "VAST response is wrapper. Resolving...");
                }
                this.sdk.BO().b((d) new z(this.aUT, this.aTG, this.sdk));
                return;
            }
            x xVar4 = this.logger;
            if (x.Fn()) {
                x xVar5 = this.logger;
                String str2 = this.tag;
                xVar5.i(str2, "Reached beyond max wrapper depth of " + intValue);
            }
            a(f.WRAPPER_LIMIT_REACHED);
        } else if (m.e(yVar)) {
            x xVar6 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "VAST response is inline. Rendering ad...");
            }
            this.sdk.BO().b((d) new v(this.aUT, this.aTG, this.sdk));
        } else {
            x xVar7 = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, "VAST response is an error");
            }
            a(f.NO_WRAPPER_RESPONSE);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.i(str, "Failed to process VAST response due to VAST error code " + fVar);
        }
        m.a((e) this.aUT, this.aTG, fVar, -6, this.sdk);
    }

    private static final class c extends t {
        private final JSONObject aUV;

        c(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
            super(eVar, appLovinAdLoadListener, nVar);
            this.aUV = eVar.Mt();
        }

        public void run() {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Processing SDK JSON response...");
            }
            String string = JsonUtils.getString(this.aUV, "xml", (String) null);
            if (!StringUtils.isValidString(string)) {
                x xVar2 = this.logger;
                if (x.Fn()) {
                    this.logger.i(this.tag, "No VAST response received.");
                }
                a(f.NO_WRAPPER_RESPONSE);
            } else if (string.length() < ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPr)).intValue()) {
                a(dw(string));
            } else {
                x xVar3 = this.logger;
                if (x.Fn()) {
                    this.logger.i(this.tag, "VAST response is over max length");
                }
                a(f.XML_PARSING);
            }
        }
    }

    private static final class b extends t {
        private final String aUU;

        b(String str, e eVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
            super(eVar, appLovinAdLoadListener, nVar);
            this.aUU = str;
        }

        public void run() {
            a(dw(this.aUU));
        }
    }

    private static final class d extends t {
        private final y aUW;

        d(y yVar, e eVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
            super(eVar, appLovinAdLoadListener, nVar);
            if (yVar == null) {
                throw new IllegalArgumentException("No response specified.");
            } else if (eVar == null) {
                throw new IllegalArgumentException("No context specified.");
            } else if (appLovinAdLoadListener != null) {
                this.aUW = yVar;
            } else {
                throw new IllegalArgumentException("No callback specified.");
            }
        }

        public void run() {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Processing VAST Wrapper response...");
            }
            a(this.aUW);
        }
    }

    private static final class a extends e {
        a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, n nVar) {
            super(jSONObject, jSONObject2, bVar, nVar);
        }

        /* access modifiers changed from: package-private */
        public void b(y yVar) {
            if (yVar != null) {
                this.aXl.add(yVar);
                return;
            }
            throw new IllegalArgumentException("No aggregated vast response specified");
        }
    }
}
