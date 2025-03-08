package com.ironsource;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J*\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/ironsource/j4;", "Lcom/ironsource/u9;", "Lorg/json/JSONObject;", "b", "", "dataSource", "impressionData", "", "a", "", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnits", "", "revived", "Lcom/ironsource/g2;", "configurations", "reason", "d", "Z", "isExternalArmEventsEnabled", "Ljava/lang/String;", "externalArmEventsUrl", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class j4 implements u9 {
    private boolean a = true;
    private String b = k4.j;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/ironsource/j4$a", "Lcom/ironsource/y4;", "", "requestSucceeded", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements y4 {
        a() {
        }

        public void a(boolean z) {
            if (!z) {
                IronLog.API.error("failed to send impression data");
            }
        }
    }

    private final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(jc.p0, "android");
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext != null) {
            jSONObject.put("deviceType", IronSourceUtils.getDeviceType(applicationContext));
            s7 ironSourceAdvId = IronSourceUtils.getIronSourceAdvId(applicationContext);
            if (ironSourceAdvId != null) {
                jSONObject.put(jc.b, ironSourceAdvId.c());
                jSONObject.put(jc.i1, ironSourceAdvId.d());
            }
        }
        String p = p.o().p();
        if (p != null) {
            jSONObject.put("applicationKey", p);
        }
        return jSONObject;
    }

    public void a() {
    }

    public final void a(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "dataSource");
        Intrinsics.checkNotNullParameter(jSONObject, "impressionData");
        if (!this.a) {
            IronLog.INTERNAL.verbose("disabled from server");
            return;
        }
        try {
            JSONObject b2 = b();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("externalMediationSource", str);
            jSONObject2.putOpt("externalMediationData", jSONObject);
            jSONObject2.putOpt("clientParams", b2);
            IronLog ironLog = IronLog.API;
            ironLog.info("impressionData: " + jSONObject2);
            HttpFunctions.sendPostRequest(this.b, jSONObject2.toString(), new a());
        } catch (Exception e) {
            IronLog ironLog2 = IronLog.API;
            ironLog2.error("exception " + e.getMessage() + " sending impression data");
            e.printStackTrace();
        }
    }

    public void a(List<IronSource.AD_UNIT> list, boolean z, g2 g2Var) {
        if (g2Var != null) {
            j0 b2 = g2Var.b();
            o0 e = b2 != null ? b2.e() : null;
            Intrinsics.checkNotNull(e);
            this.a = e.h();
            this.b = g2Var.b().e().c();
        }
    }

    public void d(String str) {
    }
}
