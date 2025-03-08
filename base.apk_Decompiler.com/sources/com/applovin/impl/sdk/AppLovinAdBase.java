package com.applovin.impl.sdk;

import android.graphics.Color;
import com.applovin.impl.sdk.a.a;
import com.applovin.impl.sdk.array.ArrayDirectDownloadAd;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.List;
import org.json.JSONObject;

public abstract class AppLovinAdBase implements a, ArrayDirectDownloadAd {
    protected final JSONObject adObject;
    protected final Object adObjectLock;
    private final long createdAtMillis;
    protected final JSONObject fullResponse;
    protected final Object fullResponseLock;
    /* access modifiers changed from: protected */
    public final n sdk;

    public abstract long getAdIdNumber();

    public long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public n getSdk() {
        return this.sdk;
    }

    protected AppLovinAdBase(JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (nVar != null) {
            this.adObject = jSONObject;
            this.fullResponse = jSONObject2;
            this.sdk = nVar;
            this.adObjectLock = new Object();
            this.fullResponseLock = new Object();
            this.createdAtMillis = System.currentTimeMillis();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public String getClCode() {
        String stringFromAdObject = getStringFromAdObject("clcode", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return stringFromAdObject;
        }
        return getStringFromFullResponse("clcode", "");
    }

    public String getDspName() {
        return getStringFromFullResponse("dsp_name", "");
    }

    public String getPrimaryKey() {
        return getStringFromAdObject("pk", "NA");
    }

    public String getSecondaryKey1() {
        return getStringFromAdObject("sk1", (String) null);
    }

    public String getSecondaryKey2() {
        return getStringFromAdObject("sk2", (String) null);
    }

    public long getFetchLatencyMillis() {
        return getLongFromFullResponse("ad_fetch_latency_millis", -1);
    }

    public long getFetchResponseSize() {
        return getLongFromFullResponse("ad_fetch_response_size", -1);
    }

    /* access modifiers changed from: protected */
    public boolean containsKeyForAdObject(String str) {
        boolean has;
        synchronized (this.adObjectLock) {
            has = this.adObject.has(str);
        }
        return has;
    }

    /* access modifiers changed from: protected */
    public boolean getBooleanFromAdObject(String str, Boolean bool) {
        boolean booleanValue;
        synchronized (this.adObjectLock) {
            booleanValue = JsonUtils.getBoolean(this.adObject, str, bool).booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: protected */
    public float getFloatFromAdObject(String str, float f) {
        float f2;
        synchronized (this.adObjectLock) {
            f2 = JsonUtils.getFloat(this.adObject, str, f);
        }
        return f2;
    }

    /* access modifiers changed from: protected */
    public int getIntFromAdObject(String str, int i) {
        int i2;
        synchronized (this.adObjectLock) {
            i2 = JsonUtils.getInt(this.adObject, str, i);
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public JSONObject getJsonObjectFromAdObject(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.adObjectLock) {
            jSONObject2 = JsonUtils.getJSONObject(this.adObject, str, jSONObject);
        }
        return jSONObject2;
    }

    /* access modifiers changed from: protected */
    public long getLongFromAdObject(String str, long j) {
        long j2;
        synchronized (this.adObjectLock) {
            j2 = JsonUtils.getLong(this.adObject, str, j);
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    public String getStringFromAdObject(String str, String str2) {
        String string;
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, str, str2);
        }
        return string;
    }

    /* access modifiers changed from: protected */
    public List<String> getStringListFromAdObject(String str, List<String> list) {
        List<String> stringList;
        synchronized (this.adObjectLock) {
            stringList = JsonUtils.getStringList(this.adObject, str, list);
        }
        return stringList;
    }

    /* access modifiers changed from: protected */
    public List<Integer> getIntegerListFromAdObject(String str, List<Integer> list) {
        List<Integer> integerList;
        synchronized (this.adObjectLock) {
            integerList = JsonUtils.getIntegerList(this.adObject, str, list);
        }
        return integerList;
    }

    /* access modifiers changed from: protected */
    public int getColorFromAdObject(String str, int i) {
        String stringFromAdObject = getStringFromAdObject(str, (String) null);
        return StringUtils.isValidString(stringFromAdObject) ? Color.parseColor(stringFromAdObject) : i;
    }

    /* access modifiers changed from: protected */
    public boolean getBooleanFromFullResponse(String str, boolean z) {
        boolean booleanValue;
        synchronized (this.fullResponseLock) {
            booleanValue = JsonUtils.getBoolean(this.fullResponse, str, Boolean.valueOf(z)).booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: protected */
    public float getFloatFromFullResponse(String str, float f) {
        float f2;
        synchronized (this.fullResponseLock) {
            f2 = JsonUtils.getFloat(this.fullResponse, str, f);
        }
        return f2;
    }

    /* access modifiers changed from: protected */
    public int getIntFromFullResponse(String str, int i) {
        int i2;
        synchronized (this.fullResponseLock) {
            i2 = JsonUtils.getInt(this.fullResponse, str, i);
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public JSONObject getJsonObjectFromFullResponse(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.fullResponseLock) {
            jSONObject2 = JsonUtils.getJSONObject(this.fullResponse, str, jSONObject);
        }
        return jSONObject2;
    }

    /* access modifiers changed from: protected */
    public long getLongFromFullResponse(String str, long j) {
        long j2;
        synchronized (this.fullResponseLock) {
            j2 = JsonUtils.getLong(this.fullResponse, str, j);
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    public String getStringFromFullResponse(String str, String str2) {
        String string;
        synchronized (this.fullResponseLock) {
            string = JsonUtils.getString(this.fullResponse, str, str2);
        }
        return string;
    }
}
