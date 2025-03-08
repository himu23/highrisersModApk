package com.applovin.impl.mediation.a;

import android.graphics.Color;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

public class c {
    private final JSONObject aus;

    public c(JSONObject jSONObject) {
        this.aus = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public int mN() {
        String string = JsonUtils.getString(this.aus, "background_color", (String) null);
        return string != null ? Color.parseColor(string) : ViewCompat.MEASURED_STATE_MASK;
    }

    public int xn() {
        return JsonUtils.getInt(this.aus, "close_button_top_margin", 20);
    }

    public int xo() {
        return JsonUtils.getInt(this.aus, "close_button_h_margin", 5);
    }

    public int xp() {
        return JsonUtils.getInt(this.aus, "close_button_size", 30);
    }

    public int xq() {
        return JsonUtils.getInt(this.aus, "close_button_extended_touch_area_size", 10);
    }

    public long xr() {
        return JsonUtils.getLong(this.aus, "close_button_delay_ms", 3000);
    }
}
