package com.fyber.inneractive.sdk.flow;

import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    public static void a(InneractiveAdRequest inneractiveAdRequest, InneractiveInfrastructureError inneractiveInfrastructureError, q qVar, e eVar, JSONArray jSONArray) {
        String str;
        if (inneractiveInfrastructureError.getErrorCode().getMetricable() != InneractiveErrorCode.Metricable.INCLUDED_IN_FAILED_METRICS) {
            return;
        }
        if ((qVar == null || qVar.e() || qVar.isVideoAd()) && !inneractiveInfrastructureError.isErrorAlreadyReported(q.IA_AD_LOAD_FAILED)) {
            IAlog.a("Firing Event 801 - AdLoadFailed - errorCode - %s", inneractiveInfrastructureError.getErrorCode());
            if (inneractiveInfrastructureError.getCause() != null) {
                str = Arrays.toString(inneractiveInfrastructureError.getCause().getStackTrace());
            } else {
                StringBuilder sb = new StringBuilder();
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int i = 7;
                while (i >= 0 && i < 13 && i < stackTrace.length) {
                    sb.append(stackTrace[i].toString());
                    sb.append(",");
                    i++;
                }
                Log.d("stack trace:", sb.toString());
                str = sb.toString();
            }
            q qVar2 = q.IA_AD_LOAD_FAILED;
            s.a aVar = new s.a(qVar2, inneractiveAdRequest, eVar, jSONArray);
            JSONObject jSONObject = new JSONObject();
            String str2 = inneractiveInfrastructureError.getFyberMarketplaceAdLoadFailureReason().toString();
            try {
                jSONObject.put("message", str2);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "message", str2);
            }
            try {
                jSONObject.put("description", str);
            } catch (Exception unused2) {
                IAlog.e("Got exception adding param to json object: %s, %s", "description", str);
            }
            String description = inneractiveInfrastructureError.description();
            try {
                jSONObject.put("extra_description", description);
            } catch (Exception unused3) {
                IAlog.e("Got exception adding param to json object: %s, %s", "extra_description", description);
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
            inneractiveInfrastructureError.addReportedError(qVar2);
        }
    }
}
