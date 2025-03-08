package com.applovin.impl.b;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.y;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class e {
    private static final List<String> aXk = Arrays.asList(new String[]{"video/mp4", MimeTypes.VIDEO_WEBM, "video/3gpp", "video/x-matroska"});
    protected List<y> aXl = new ArrayList();
    private final JSONObject aXm;
    private final JSONObject awB;
    private final long createdAtMillis = System.currentTimeMillis();
    private final n sdk;
    private final b source;

    public JSONObject FR() {
        return this.awB;
    }

    public List<y> Ms() {
        return this.aXl;
    }

    public JSONObject Mt() {
        return this.aXm;
    }

    public long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public b getSource() {
        return this.source;
    }

    public e(JSONObject jSONObject, JSONObject jSONObject2, b bVar, n nVar) {
        this.sdk = nVar;
        this.aXm = jSONObject;
        this.awB = jSONObject2;
        this.source = bVar;
    }

    public int Mr() {
        return this.aXl.size();
    }

    public List<String> Mu() {
        List<String> explode = CollectionUtils.explode(JsonUtils.getString(this.aXm, "vast_preferred_video_types", (String) null));
        return !explode.isEmpty() ? explode : aXk;
    }

    public int GE() {
        return u.U(this.aXm);
    }
}
