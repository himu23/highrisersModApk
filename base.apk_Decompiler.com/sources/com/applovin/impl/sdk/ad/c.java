package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: do  reason: not valid java name */
    private final String f13do;
    private final n sdk;

    public String mQ() {
        return this.f13do;
    }

    public enum a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");
        
        private final String mTag;

        public String toString() {
            return this.mTag;
        }

        private a(String str) {
            this.mTag = str;
        }
    }

    public c(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        } else if (nVar != null) {
            this.f13do = str;
            this.sdk = nVar;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public a FP() {
        if (d(b.aLA) != null) {
            return a.REGULAR;
        }
        if (d(b.aLB) != null) {
            return a.AD_RESPONSE_JSON;
        }
        return a.UNSPECIFIED;
    }

    public String FQ() {
        String d = d(b.aLA);
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String d2 = d(b.aLB);
        if (!TextUtils.isEmpty(d2)) {
            return d2;
        }
        return null;
    }

    public JSONObject FR() {
        if (FP() != a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f13do.substring(FQ().length()), 0), "UTF-8"));
                this.sdk.BN();
                if (x.Fn()) {
                    x BN = this.sdk.BN();
                    BN.f("AdToken", "Decoded token into ad response: " + jSONObject);
                }
                return jSONObject;
            } catch (JSONException e) {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN2 = this.sdk.BN();
                    BN2.c("AdToken", "Unable to decode token '" + this.f13do + "' into JSON", e);
                }
                this.sdk.Cs().d("AdToken", "decodeFullAdResponseStr", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN3 = this.sdk.BN();
                BN3.c("AdToken", "Unable to process ad response from token '" + this.f13do + "'", e2);
            }
            this.sdk.Cs().d("AdToken", "decodeFullAdResponse", e2);
            return null;
        }
    }

    private String d(b<String> bVar) {
        for (String next : this.sdk.b(bVar)) {
            if (this.f13do.startsWith(next)) {
                return next;
            }
        }
        return null;
    }

    public String toString() {
        String prefixToIndex = StringUtils.prefixToIndex(32, this.f13do);
        return "AdToken{id=" + prefixToIndex + ", type=" + FP() + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        String str = this.f13do;
        String str2 = ((c) obj).f13do;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f13do;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
