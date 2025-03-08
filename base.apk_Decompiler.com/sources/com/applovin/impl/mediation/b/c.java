package com.applovin.impl.mediation.b;

import android.os.SystemClock;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.n;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class c extends a implements g {
    private final AtomicBoolean auA;
    private final AtomicBoolean auB;
    private boolean auC;
    private final AtomicReference<com.applovin.impl.sdk.b.c> auz;
    private boolean isExpired;

    public void aH(boolean z) {
        this.auC = z;
    }

    public void setExpired() {
        this.isExpired = true;
    }

    public AtomicBoolean yi() {
        return this.auB;
    }

    public boolean yk() {
        return this.auC;
    }

    public c(int i, Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
        super(i, map, jSONObject, jSONObject2, (com.applovin.impl.mediation.g) null, nVar);
        this.auB = new AtomicBoolean();
        this.auz = new AtomicReference<>();
        this.auA = new AtomicBoolean();
    }

    private c(c cVar, com.applovin.impl.mediation.g gVar) {
        super(cVar.ah(), cVar.getLocalExtraParameters(), cVar.yz(), cVar.yy(), gVar, cVar.sdk);
        this.auB = new AtomicBoolean();
        this.auz = cVar.auz;
        this.auA = cVar.auA;
    }

    public a k(com.applovin.impl.mediation.g gVar) {
        return new c(this, gVar);
    }

    public long xW() {
        long longFromAdObject = getLongFromAdObject("ad_hidden_timeout_ms", -1);
        if (longFromAdObject >= 0) {
            return longFromAdObject;
        }
        return getLongFromFullResponse("ad_hidden_timeout_ms", ((Long) this.sdk.a(a.aJN)).longValue());
    }

    public boolean xX() {
        if (b("schedule_ad_hidden_on_ad_dismiss", (Boolean) false).booleanValue()) {
            return true;
        }
        return a("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.sdk.a(a.aJO)).booleanValue();
    }

    public boolean xY() {
        if (b("schedule_ad_hidden_on_single_task_app_relaunch", (Boolean) false).booleanValue()) {
            return true;
        }
        return a("schedule_ad_hidden_on_single_task_app_relaunch", (Boolean) this.sdk.a(a.aJP)).booleanValue();
    }

    public long xZ() {
        long longFromAdObject = getLongFromAdObject("ad_hidden_on_ad_dismiss_callback_delay_ms", -1);
        if (longFromAdObject >= 0) {
            return longFromAdObject;
        }
        return getLongFromFullResponse("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.sdk.a(a.aJQ)).longValue());
    }

    public long ya() {
        if (xM() > 0) {
            return SystemClock.elapsedRealtime() - xM();
        }
        return -1;
    }

    public long yb() {
        long longFromAdObject = getLongFromAdObject("fullscreen_display_delay_ms", -1);
        if (longFromAdObject >= 0) {
            return longFromAdObject;
        }
        return ((Long) this.sdk.a(a.aJy)).longValue();
    }

    public long yc() {
        return getLongFromAdObject("ahdm", ((Long) this.sdk.a(a.aJA)).longValue());
    }

    public boolean yd() {
        return b("susaode", (Boolean) this.sdk.a(a.aJz)).booleanValue();
    }

    public String ye() {
        return getStringFromFullResponse("mcode", "");
    }

    public boolean yf() {
        return this.auA.get();
    }

    public void yg() {
        this.auA.set(true);
    }

    public void a(com.applovin.impl.sdk.b.c cVar) {
        this.auz.set(cVar);
    }

    public com.applovin.impl.sdk.b.c yh() {
        return this.auz.getAndSet((Object) null);
    }

    public long getTimeToLiveMillis() {
        return yj() - (SystemClock.elapsedRealtime() - xM());
    }

    private long yj() {
        long longFromAdObject = getLongFromAdObject("ad_expiration_ms", -1);
        return longFromAdObject < 0 ? getLongFromFullResponse("ad_expiration_ms", ((Long) this.sdk.a(a.aJH)).longValue()) : longFromAdObject;
    }
}
