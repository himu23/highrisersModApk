package com.applovin.impl.sdk.ad;

import android.net.Uri;
import com.applovin.impl.adview.j;
import com.applovin.impl.sdk.a.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.unity3d.services.core.device.MimeTypes;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends e {
    private final String aGb = FB();
    private final String aGc = FJ();
    private final String aGd = FG();
    private final c aGe = new c(this);

    /* renamed from: FC */
    public c getAdEventTracker() {
        return this.aGe;
    }

    public String FD() {
        return this.aGc;
    }

    public String FE() {
        return this.aGd;
    }

    public a(JSONObject jSONObject, JSONObject jSONObject2, b bVar, n nVar) {
        super(jSONObject, jSONObject2, bVar, nVar);
    }

    public void FA() {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", this.aGb);
            JsonUtils.putString(this.adObject, "stream_url", this.aGd);
        }
    }

    public JSONObject getOriginalFullResponse() {
        JSONObject deepCopy;
        synchronized (this.fullResponseLock) {
            deepCopy = JsonUtils.deepCopy(this.fullResponse);
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(deepCopy, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject, "html", this.aGb);
            JsonUtils.putString(jSONObject, MimeTypes.BASE_TYPE_VIDEO, this.aGc);
            JsonUtils.putString(jSONObject, "stream_url", this.aGd);
        }
        return deepCopy;
    }

    public String FB() {
        String string;
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, "html", "");
        }
        return string;
    }

    public void cP(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", str);
        }
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", false);
    }

    public boolean FF() {
        return this.adObject.has("stream_url");
    }

    private String FG() {
        return getStringFromAdObject("stream_url", "");
    }

    public void FH() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    public Uri FI() {
        String FG = FG();
        if (StringUtils.isValidString(FG)) {
            return Uri.parse(FG);
        }
        String FJ = FJ();
        if (StringUtils.isValidString(FJ)) {
            return Uri.parse(FJ);
        }
        return null;
    }

    public void j(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, MimeTypes.BASE_TYPE_VIDEO, uri.toString());
        }
    }

    public String FJ() {
        return getStringFromAdObject(MimeTypes.BASE_TYPE_VIDEO, "");
    }

    public boolean hasVideoUrl() {
        return FI() != null;
    }

    public Uri FK() {
        String stringFromAdObject = getStringFromAdObject("click_url", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public Uri FL() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return FK();
    }

    public float FM() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    public boolean FN() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", false);
        }
        return true;
    }

    public j.a FO() {
        return gC(getIntFromAdObject("expandable_style", j.a.INVISIBLE.getValue()));
    }
}
