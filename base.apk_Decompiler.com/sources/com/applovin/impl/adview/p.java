package com.applovin.impl.adview;

import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import java.util.Map;

public class p {
    private final Map<String, Object> agg;
    private final n sdk;

    public String getIdentifier() {
        return "google watermark";
    }

    public p(Map<String, Object> map, n nVar) {
        this.agg = map;
        this.sdk = nVar;
    }

    public Drawable rM() {
        Object obj = this.agg.get("google_watermark");
        if (!U(obj)) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.i("GoogleWatermarkGenerator", "Unable to render invalid watermark: " + obj);
            }
            return null;
        }
        try {
            byte[] decode = Base64.decode((String) obj, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(n.getApplicationContext().getResources(), BitmapFactory.decodeByteArray(decode, 0, decode.length));
            bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            return bitmapDrawable;
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().c("GoogleWatermarkGenerator", "Failed to render watermark", th);
            }
            return null;
        }
    }

    public boolean rN() {
        return U(this.agg.get("google_watermark"));
    }

    private boolean U(Object obj) {
        return (obj instanceof String) && StringUtils.isValidString((String) obj);
    }
}
