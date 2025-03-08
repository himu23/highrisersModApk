package com.fyber.inneractive.sdk.config.remote;

import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class j {
    public Boolean a;
    public Integer b;
    public Integer c;
    public Skip d;
    public Boolean e;
    public TapAction f;
    public Orientation g;
    public Integer h;
    public Integer i;
    public UnitDisplayType j;
    public List<Integer> k = new ArrayList();

    public static j a(JSONObject jSONObject) {
        Integer num = null;
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        Integer valueOf = Integer.valueOf(jSONObject.optInt("maxBitrate", Integer.MIN_VALUE));
        Integer valueOf2 = Integer.valueOf(jSONObject.optInt("minBitrate", Integer.MIN_VALUE));
        Integer valueOf3 = Integer.valueOf(jSONObject.optInt("pivotBitrate", Integer.MIN_VALUE));
        Integer valueOf4 = Integer.valueOf(jSONObject.optInt("padding", Integer.MIN_VALUE));
        if (valueOf.intValue() == Integer.MIN_VALUE) {
            valueOf = null;
        }
        jVar.b = valueOf;
        if (valueOf2.intValue() == Integer.MIN_VALUE) {
            valueOf2 = null;
        }
        jVar.c = valueOf2;
        jVar.d = Skip.fromValue(Integer.valueOf(jSONObject.optInt("skip", Integer.MIN_VALUE)));
        jVar.e = jSONObject.has("muted") ? Boolean.valueOf(jSONObject.optBoolean("muted", true)) : null;
        jVar.a = jSONObject.has("autoPlay") ? Boolean.valueOf(jSONObject.optBoolean("autoPlay", true)) : null;
        jVar.g = Orientation.fromValue(jSONObject.optString("orientation"));
        jVar.f = TapAction.fromValue(jSONObject.optString("tap"));
        if (valueOf3.intValue() == Integer.MIN_VALUE) {
            valueOf3 = null;
        }
        jVar.h = valueOf3;
        if (valueOf4.intValue() != Integer.MIN_VALUE) {
            num = valueOf4;
        }
        jVar.i = num;
        jVar.j = UnitDisplayType.fromValue(jSONObject.optString("unitDisplayType"));
        JSONArray optJSONArray = jSONObject.optJSONArray("filterApi");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                int optInt = optJSONArray.optInt(i2, Integer.MIN_VALUE);
                if (optInt != Integer.MIN_VALUE) {
                    jVar.k.add(Integer.valueOf(optInt));
                }
            }
        }
        return jVar;
    }
}
