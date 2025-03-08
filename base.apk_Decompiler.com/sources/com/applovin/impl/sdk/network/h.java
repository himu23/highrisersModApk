package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.p;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    private String aHC;
    private Map<String, String> aHD;
    private p.a aHO;
    private String aIo;
    private String aIp;
    private Map<String, Object> aIq;
    private boolean aIr;
    private boolean aIs;
    private boolean aIt;
    private boolean aIu;
    private String aIv;
    private int aIw;
    private String ajW;
    private Map<String, String> awy;

    /* access modifiers changed from: package-private */
    public String HQ() {
        return this.aHC;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> HR() {
        return this.aHD;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> HS() {
        return this.awy;
    }

    /* access modifiers changed from: package-private */
    public void IA() {
        this.aIw++;
    }

    public boolean IE() {
        return this.aIt;
    }

    /* access modifiers changed from: package-private */
    public boolean Ic() {
        return this.aIr;
    }

    /* access modifiers changed from: package-private */
    public p.a Id() {
        return this.aHO;
    }

    /* access modifiers changed from: package-private */
    public boolean If() {
        return this.aIs;
    }

    /* access modifiers changed from: package-private */
    public String Iu() {
        return this.aIo;
    }

    /* access modifiers changed from: package-private */
    public String Iv() {
        return this.aIp;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> Iw() {
        return this.aIq;
    }

    /* access modifiers changed from: package-private */
    public boolean Ix() {
        return this.aIu;
    }

    /* access modifiers changed from: package-private */
    public String Iy() {
        return this.aIv;
    }

    /* access modifiers changed from: package-private */
    public int Iz() {
        return this.aIw;
    }

    h(JSONObject jSONObject, n nVar) throws Exception {
        Map<String, String> map;
        Map<String, String> map2;
        Map<String, Object> map3;
        String string = JsonUtils.getString(jSONObject, "uniqueId", UUID.randomUUID().toString());
        String string2 = JsonUtils.getString(jSONObject, "communicatorRequestId", "");
        String string3 = JsonUtils.getString(jSONObject, "httpMethod", "");
        String string4 = jSONObject.getString("targetUrl");
        String string5 = JsonUtils.getString(jSONObject, "backupUrl", "");
        int i = jSONObject.getInt("attemptNumber");
        if (JsonUtils.valueExists(jSONObject, "parameters")) {
            map = Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("parameters")));
        } else {
            map = new HashMap<>();
        }
        if (JsonUtils.valueExists(jSONObject, "httpHeaders")) {
            map2 = Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("httpHeaders")));
        } else {
            map2 = new HashMap<>();
        }
        if (JsonUtils.valueExists(jSONObject, "requestBody")) {
            map3 = Collections.synchronizedMap(JsonUtils.toStringObjectMap(jSONObject.getJSONObject("requestBody")));
        } else {
            map3 = new HashMap<>();
        }
        this.ajW = string;
        this.aHC = string3;
        this.aIv = string2;
        this.aIo = string4;
        this.aIp = string5;
        this.aHD = map;
        this.awy = map2;
        this.aIq = map3;
        this.aHO = p.a.gW(jSONObject.optInt("encodingType", p.a.DEFAULT.getValue()));
        this.aIr = jSONObject.optBoolean("isEncodingEnabled", false);
        this.aIs = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.aIt = jSONObject.optBoolean("isAllowedPreInitEvent", false);
        this.aIu = jSONObject.optBoolean("shouldFireInWebView", false);
        this.aIw = i;
    }

    private h(a aVar) {
        this.ajW = UUID.randomUUID().toString();
        this.aHC = aVar.aHC;
        this.aIo = aVar.aIo;
        this.aIp = aVar.aIp;
        this.aHD = aVar.aHD;
        this.awy = aVar.awy;
        this.aIq = aVar.aIq;
        this.aHO = aVar.aHO;
        this.aIr = aVar.aIr;
        this.aIs = aVar.aIs;
        this.aIt = aVar.aIt;
        this.aIu = aVar.aIu;
        this.aIv = aVar.aIv;
        this.aIw = 0;
    }

    /* access modifiers changed from: package-private */
    public void IB() {
        Map<String, String> map = CollectionUtils.map(this.aHD);
        map.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.aHD = map;
    }

    /* access modifiers changed from: package-private */
    public JSONObject IC() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.ajW);
        jSONObject.put("communicatorRequestId", this.aIv);
        jSONObject.put("httpMethod", this.aHC);
        jSONObject.put("targetUrl", this.aIo);
        jSONObject.put("backupUrl", this.aIp);
        jSONObject.put("encodingType", this.aHO);
        jSONObject.put("isEncodingEnabled", this.aIr);
        jSONObject.put("gzipBodyEncoding", this.aIs);
        jSONObject.put("isAllowedPreInitEvent", this.aIt);
        jSONObject.put("attemptNumber", this.aIw);
        if (this.aHD != null) {
            jSONObject.put("parameters", new JSONObject(this.aHD));
        }
        if (this.awy != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.awy));
        }
        if (this.aIq != null) {
            jSONObject.put("requestBody", new JSONObject(this.aIq));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.ajW + "', communicatorRequestId='" + this.aIv + "', httpMethod='" + this.aHC + "', targetUrl='" + this.aIo + "', backupUrl='" + this.aIp + "', attemptNumber=" + this.aIw + ", isEncodingEnabled=" + this.aIr + ", isGzipBodyEncoding=" + this.aIs + ", isAllowedPreInitEvent=" + this.aIt + ", shouldFireInWebView=" + this.aIu + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.ajW.equals(((h) obj).ajW);
    }

    public int hashCode() {
        return this.ajW.hashCode();
    }

    public static a ID() {
        return new a();
    }

    public static class a {
        /* access modifiers changed from: private */
        public String aHC;
        /* access modifiers changed from: private */
        public Map<String, String> aHD;
        /* access modifiers changed from: private */
        public p.a aHO;
        /* access modifiers changed from: private */
        public String aIo;
        /* access modifiers changed from: private */
        public String aIp;
        /* access modifiers changed from: private */
        public Map<String, Object> aIq;
        /* access modifiers changed from: private */
        public boolean aIr;
        /* access modifiers changed from: private */
        public boolean aIs;
        /* access modifiers changed from: private */
        public boolean aIt;
        /* access modifiers changed from: private */
        public boolean aIu;
        /* access modifiers changed from: private */
        public String aIv;
        /* access modifiers changed from: private */
        public Map<String, String> awy;

        public a aV(boolean z) {
            this.aIr = z;
            return this;
        }

        public a aW(boolean z) {
            this.aIs = z;
            return this;
        }

        public a aX(boolean z) {
            this.aIt = z;
            return this;
        }

        public a aY(boolean z) {
            this.aIu = z;
            return this;
        }

        public a b(p.a aVar) {
            this.aHO = aVar;
            return this;
        }

        public a db(String str) {
            this.aIv = str;
            return this;
        }

        public a dc(String str) {
            this.aHC = str;
            return this;
        }

        public a dd(String str) {
            this.aIo = str;
            return this;
        }

        public a de(String str) {
            this.aIp = str;
            return this;
        }

        public a n(Map<String, String> map) {
            this.aHD = map;
            return this;
        }

        public a o(Map<String, String> map) {
            this.awy = map;
            return this;
        }

        public a p(Map<String, Object> map) {
            this.aIq = map;
            return this;
        }

        public h IF() {
            return new h(this);
        }
    }
}
