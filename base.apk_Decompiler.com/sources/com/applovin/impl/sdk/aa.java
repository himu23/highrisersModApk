package com.applovin.impl.sdk;

import android.adservices.measurement.MeasurementManager;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.text.TextUtils;
import android.view.InputEvent;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import com.ironsource.t4;
import com.ironsource.w5;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class aa {
    private final TopicsManager aFA;
    private final Executor aFw;
    private final MeasurementManager aFx;
    /* access modifiers changed from: private */
    public final AtomicReference<JSONArray> aFy = new AtomicReference<>(new JSONArray());
    private final a aFz = new a();
    /* access modifiers changed from: private */
    public final n sdk;

    protected aa(n nVar) {
        this.sdk = nVar;
        this.aFw = nVar.BO().KK();
        Context applicationContext = n.getApplicationContext();
        this.aFx = g$$ExternalSyntheticApiModelOutline0.m(applicationContext.getSystemService(g$$ExternalSyntheticApiModelOutline0.m$1()));
        this.aFA = g$$ExternalSyntheticApiModelOutline0.m(applicationContext.getSystemService(g$$ExternalSyntheticApiModelOutline0.m()));
        if (((Boolean) nVar.a(b.aQY)).booleanValue()) {
            g(((Boolean) nVar.a(b.aRb)).booleanValue(), 0);
        }
    }

    public void I(List<String> list) {
        if (list != null && !list.isEmpty() && this.aFx != null && M(n.hr)) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("PrivacySandboxService", "Registering impression...");
            }
            for (String parse : list) {
                this.aFx.registerSource(Uri.parse(parse), (InputEvent) null, this.aFw, new OutcomeReceiver<Object, Exception>() {
                    public void onResult(Object obj) {
                        aa.this.sdk.BN();
                        if (x.Fn()) {
                            aa.this.sdk.BN().f("PrivacySandboxService", "Successfully registered impression");
                        }
                    }

                    /* renamed from: m */
                    public void onError(Exception exc) {
                        aa.this.sdk.BN();
                        if (x.Fn()) {
                            aa.this.sdk.BN().c("PrivacySandboxService", "Failed to register impression", exc);
                        }
                    }
                });
            }
        }
    }

    public void a(List<String> list, InputEvent inputEvent) {
        if (list != null && !list.isEmpty() && this.aFx != null && M(n.hr)) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("PrivacySandboxService", "Registering click...");
            }
            for (String parse : list) {
                this.aFx.registerSource(Uri.parse(parse), inputEvent, this.aFw, new OutcomeReceiver<Object, Exception>() {
                    public void onResult(Object obj) {
                        aa.this.sdk.BN();
                        if (x.Fn()) {
                            aa.this.sdk.BN().f("PrivacySandboxService", "Successfully registered click");
                        }
                    }

                    /* renamed from: m */
                    public void onError(Exception exc) {
                        aa.this.sdk.BN();
                        if (x.Fn()) {
                            aa.this.sdk.BN().c("PrivacySandboxService", "Failed to register click", exc);
                        }
                    }
                });
            }
        }
    }

    public void cL(String str) {
        if (!TextUtils.isEmpty(str) && this.aFx != null && M(n.hr)) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("PrivacySandboxService", "Registering conversion: " + str);
            }
            this.aFx.registerTrigger(Uri.parse(str), this.aFw, new OutcomeReceiver<Object, Exception>() {
                public void onResult(Object obj) {
                    aa.this.sdk.BN();
                    if (x.Fn()) {
                        aa.this.sdk.BN().f("PrivacySandboxService", "Successfully registered conversion");
                    }
                }

                /* renamed from: m */
                public void onError(Exception exc) {
                    aa.this.sdk.BN();
                    if (x.Fn()) {
                        aa.this.sdk.BN().c("PrivacySandboxService", "Failed to register conversion", exc);
                    }
                }
            });
        }
    }

    public JSONArray Ft() {
        return this.aFy.get();
    }

    /* access modifiers changed from: private */
    public void g(boolean z, long j) {
        if (this.aFA != null) {
            GetTopicsRequest m = g$$ExternalSyntheticApiModelOutline0.m().setShouldRecordObservation(z).setAdsSdkName("AppLovin").build();
            if (j > 0) {
                this.sdk.BO().a((d) new ab(this.sdk, true, "getTopics", new aa$$ExternalSyntheticLambda12(this, m)), q.b.BACKGROUND, j);
            } else {
                this.aFA.getTopics(m, this.aFw, this.aFz);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(GetTopicsRequest getTopicsRequest) {
        this.aFA.getTopics(getTopicsRequest, this.aFw, this.aFz);
    }

    public static boolean M(Context context) {
        return N(context) && g$$ExternalSyntheticApiModelOutline0.m();
    }

    public static boolean N(Context context) {
        return h.Lg() && !AppLovinSdkUtils.isFireOS(context);
    }

    public static boolean O(Context context) {
        return h.d("android.permission.ACCESS_ADSERVICES_TOPICS", context);
    }

    public static boolean P(Context context) {
        return h.d("android.permission.ACCESS_ADSERVICES_ATTRIBUTION", context);
    }

    public static boolean Q(Context context) {
        return h.d("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE", context);
    }

    public static boolean R(Context context) {
        return h.d("android.permission.ACCESS_ADSERVICES_AD_ID", context);
    }

    private class a implements OutcomeReceiver<GetTopicsResponse, Exception> {
        private a() {
        }

        public /* synthetic */ void onResult(Object obj) {
            a(g$$ExternalSyntheticApiModelOutline0.m(obj));
        }

        public void a(GetTopicsResponse getTopicsResponse) {
            List<Object> m = getTopicsResponse.getTopics();
            int size = m.size();
            aa.this.sdk.BN();
            if (x.Fn()) {
                x BN = aa.this.sdk.BN();
                BN.g("PrivacySandboxService", size + " topic(s) received");
            }
            JSONArray jSONArray = new JSONArray();
            for (Object m2 : m) {
                Topic m3 = g$$ExternalSyntheticApiModelOutline0.m(m2);
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putInt(jSONObject, w5.x, g$$ExternalSyntheticApiModelOutline0.m(m3));
                JsonUtils.putLong(jSONObject, t4.u, g$$ExternalSyntheticApiModelOutline0.m(m3));
                JsonUtils.putLong(jSONObject, "taxonomy", m3.getTaxonomyVersion());
                jSONArray.put(jSONObject);
            }
            aa.this.aFy.set(jSONArray);
            aa.this.g(((Boolean) aa.this.sdk.a(b.aRb)).booleanValue(), ((Long) aa.this.sdk.a(b.aQZ)).longValue());
        }

        /* renamed from: m */
        public void onError(Exception exc) {
            String str;
            Long l = (Long) aa.this.sdk.a(b.aRa);
            boolean z = l.longValue() == -1;
            aa.this.sdk.BN();
            if (x.Fn()) {
                x BN = aa.this.sdk.BN();
                StringBuilder sb = new StringBuilder("Failed to retrieve topics");
                if (z) {
                    str = "";
                } else {
                    str = ", retrying in " + l + " ms";
                }
                sb.append(str);
                BN.c("PrivacySandboxService", sb.toString(), exc);
            }
            if (!z) {
                aa.this.g(((Boolean) aa.this.sdk.a(b.aRc)).booleanValue(), l.longValue());
            }
        }
    }
}
