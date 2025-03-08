package com.ironsource;

import android.content.Context;
import android.util.Pair;
import com.ironsource.b4;
import com.ironsource.e6;
import com.ironsource.j6;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class m6 {
    public static b4 a(JSONObject jSONObject) {
        return new b4.a(jSONObject.optString(z3.q)).b().b(jSONObject.optBoolean(z3.r)).a((g5) new k6()).a((List<Pair<String, String>>) a()).a(false).a();
    }

    public static e6.e a(h3 h3Var, e6.e eVar) {
        return (h3Var == null || h3Var.g() == null || h3Var.g().get("rewarded") == null) ? eVar : Boolean.parseBoolean(h3Var.g().get("rewarded")) ? e6.e.RewardedVideo : e6.e.Interstitial;
    }

    public static j6 a(Context context, String str, String str2, Map<String, String> map) throws Exception {
        j6.b bVar = new j6.b();
        if (map != null && map.containsKey(z3.g)) {
            bVar.c(map.get(z3.g));
        }
        bVar.a(context);
        return bVar.d(str).a(str2).a();
    }

    private static ArrayList<Pair<String, String>> a() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        arrayList.add(new Pair(z3.I, z3.J));
        arrayList.add(new Pair(z3.K, z3.L));
        return arrayList;
    }

    public static boolean a(h3 h3Var) {
        if (h3Var == null || h3Var.g().get("inAppBidding") == null) {
            return false;
        }
        return Boolean.parseBoolean(h3Var.g().get("inAppBidding"));
    }
}
