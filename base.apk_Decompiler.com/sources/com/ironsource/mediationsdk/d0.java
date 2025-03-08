package com.ironsource.mediationsdk;

import android.content.Context;
import com.ironsource.lc;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.d;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ironsource/mediationsdk/utils/d;", "tokenSettings", "Landroid/content/Context;", "context", "Lorg/json/JSONObject;", "b", "mediationsdk_release"}, k = 2, mv = {1, 8, 0})
public final class d0 {
    /* access modifiers changed from: private */
    public static final JSONObject b(d dVar, Context context) {
        AbstractAdapter a;
        if (dVar.f()) {
            return new lc().a(context);
        }
        NetworkSettings c = dVar.c();
        if (c == null || (a = c.b().a(c, c.getApplicationSettings(), true)) == null) {
            return null;
        }
        return d.c().a(a.getPlayerBiddingData(), dVar.b(), (List<String>) dVar.d());
    }
}
