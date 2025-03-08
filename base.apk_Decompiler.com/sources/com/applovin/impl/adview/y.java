package com.applovin.impl.adview;

import android.webkit.WebSettings;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;

public final class y {
    private final JSONObject aiq;

    public y(JSONObject jSONObject) {
        this.aiq = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public Integer si() {
        String string = JsonUtils.getString(this.aiq, "mixed_content_mode", (String) null);
        if (StringUtils.isValidString(string)) {
            if ("always_allow".equalsIgnoreCase(string)) {
                return 0;
            }
            if ("never_allow".equalsIgnoreCase(string)) {
                return 1;
            }
            if ("compatibility_mode".equalsIgnoreCase(string)) {
                return 2;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public WebSettings.PluginState sj() {
        String string = JsonUtils.getString(this.aiq, "plugin_state", (String) null);
        if (StringUtils.isValidString(string)) {
            if (DebugKt.DEBUG_PROPERTY_VALUE_ON.equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON_DEMAND;
            }
            if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equalsIgnoreCase(string)) {
                return WebSettings.PluginState.OFF;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Boolean sk() {
        return JsonUtils.getBoolean(this.aiq, "allow_file_access", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sl() {
        return JsonUtils.getBoolean(this.aiq, "load_with_overview_mode", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sm() {
        return JsonUtils.getBoolean(this.aiq, "use_wide_view_port", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sn() {
        return JsonUtils.getBoolean(this.aiq, "allow_content_access", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean so() {
        return JsonUtils.getBoolean(this.aiq, "use_built_in_zoom_controls", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sp() {
        return JsonUtils.getBoolean(this.aiq, "display_zoom_controls", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sq() {
        return JsonUtils.getBoolean(this.aiq, "save_form_data", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sr() {
        return JsonUtils.getBoolean(this.aiq, "geolocation_enabled", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean ss() {
        return JsonUtils.getBoolean(this.aiq, "need_initial_focus", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean st() {
        return JsonUtils.getBoolean(this.aiq, "allow_file_access_from_file_urls", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean su() {
        return JsonUtils.getBoolean(this.aiq, "allow_universal_access_from_file_urls", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sv() {
        return JsonUtils.getBoolean(this.aiq, "offscreen_pre_raster", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sw() {
        return JsonUtils.getBoolean(this.aiq, "algorithmic_darkening_allowed", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sx() {
        return JsonUtils.getBoolean(this.aiq, "loads_images_automatically", (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public Boolean sy() {
        return JsonUtils.getBoolean(this.aiq, "block_network_image", (Boolean) null);
    }
}
