package com.fyber.inneractive.sdk.metrics;

import android.app.Application;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.util.u;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b<T extends e> extends a {
    public static final String g = String.valueOf(24);
    public static final String h = String.valueOf(3);
    public static final String i = String.valueOf(24);
    public static final String j = String.valueOf(3);
    public final String b;
    public final UnitDisplayType c;
    public final T d;
    public final InneractiveAdRequest e;
    public final JSONArray f;

    public class a implements Runnable {
        public final /* synthetic */ f a;
        public final /* synthetic */ Map b;

        public a(f fVar, Map map) {
            this.a = fVar;
            this.b = map;
        }

        public void run() {
            String str;
            int i;
            int i2;
            IAlog.a("MetricCreativeReporter: sendMetricEvent()", new Object[0]);
            b bVar = b.this;
            UnitDisplayType unitDisplayType = bVar.c;
            if (unitDisplayType == null || !(unitDisplayType == UnitDisplayType.BANNER || unitDisplayType == UnitDisplayType.MRECT || unitDisplayType.isFullscreenUnit())) {
                Object[] objArr = new Object[1];
                UnitDisplayType unitDisplayType2 = bVar.c;
                objArr[0] = unitDisplayType2 != null ? unitDisplayType2.value() : "";
                IAlog.a("Unit display type %s is not supported for metric event", objArr);
                return;
            }
            IAlog.a("MetricCreativeReporter: sendMetricEvent(), collectorData: data: %s", this.a.toString());
            i iVar = IAConfigManager.M.u.b;
            UnitDisplayType unitDisplayType3 = b.this.c;
            if (unitDisplayType3 == UnitDisplayType.BANNER || unitDisplayType3 == UnitDisplayType.MRECT) {
                String str2 = b.g;
                if (iVar.a.containsKey("ad_metrics_interval_banner")) {
                    str2 = iVar.a.get("ad_metrics_interval_banner");
                }
                String str3 = b.h;
                if (iVar.a.containsKey("ad_metrics_limit_banner")) {
                    str3 = iVar.a.get("ad_metrics_limit_banner");
                }
                i2 = u.a(str2, 24);
                i = u.a(str3, 3);
                str = "LastSentMetricsBanner";
            } else {
                String str4 = b.i;
                if (iVar.a.containsKey("ad_metrics_interval_interstitial")) {
                    str4 = iVar.a.get("ad_metrics_interval_interstitial");
                }
                String str5 = b.j;
                if (iVar.a.containsKey("ad_metrics_limit_interstitial")) {
                    str5 = iVar.a.get("ad_metrics_limit_interstitial");
                }
                i2 = u.a(str4, 24);
                i = u.a(str5, 3);
                str = "LastSentMetricsInterstitial";
            }
            Application application = p.a;
            if (application != null) {
                SharedPreferences sharedPreferences = application.getSharedPreferences("IAConfigPrefs", 0);
                JSONArray jSONArray = new JSONArray();
                try {
                    jSONArray = new JSONArray(sharedPreferences.getString(str, "[]"));
                } catch (JSONException unused) {
                }
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                if (iVar.a(b.this.a, false) && !a.a(i2, i, jSONArray, copyOnWriteArrayList)) {
                    copyOnWriteArrayList.add(Long.valueOf(System.currentTimeMillis()));
                    b bVar2 = b.this;
                    InneractiveAdRequest inneractiveAdRequest = bVar2.e;
                    T t = bVar2.d;
                    Map map = this.b;
                    try {
                        s.a aVar = new s.a(r.METRIC_MEASUREMENTS_EVENT, inneractiveAdRequest, (e) t, bVar2.f);
                        JSONObject jSONObject = new JSONObject();
                        for (String str6 : map.keySet()) {
                            Object obj = map.get(str6);
                            try {
                                jSONObject.put(str6, obj);
                            } catch (Exception unused2) {
                                IAlog.e("Got exception adding param to json object: %s, %s", str6, obj);
                            }
                        }
                        aVar.f.put(jSONObject);
                        aVar.a((String) null);
                    } catch (Exception unused3) {
                    }
                }
                sharedPreferences.edit().putString(str, new JSONArray(copyOnWriteArrayList).toString()).apply();
            }
        }
    }

    public b(T t, InneractiveAdRequest inneractiveAdRequest, String str, UnitDisplayType unitDisplayType, JSONArray jSONArray) {
        super("send_metric_report");
        this.d = t;
        this.e = inneractiveAdRequest;
        this.b = str;
        this.c = unitDisplayType;
        this.f = jSONArray;
    }

    public void a() {
        c cVar = c.d;
        f a2 = cVar.a(this.b);
        Map<String, Long> j2 = a2.j();
        if (!a2.a()) {
            IAlog.a("MetricCreativeReporter: Metric data not valid, data: %s", cVar.a(this.b).toString());
            return;
        }
        cVar.a.remove(this.b);
        q.a(new a(a2, j2));
    }
}
