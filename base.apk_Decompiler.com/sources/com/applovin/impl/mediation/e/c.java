package com.applovin.impl.mediation.e;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.b.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    private static final TreeMap<String, String> axi;
    private static final List<String> axj;
    private static JSONArray axk;
    private static final Object axl = new Object();
    private static final Map<Integer, AppLovinSdkUtils.Size> axm = Collections.synchronizedMap(new HashMap(1));

    static {
        TreeMap<String, String> treeMap = new TreeMap<>();
        axi = treeMap;
        treeMap.put("com.applovin.mediation.adapters.AdColonyMediationAdapter", "AdColony");
        treeMap.put("com.applovin.mediation.adapters.AmazonMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AmazonPublisherServicesMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", "AppLovin");
        treeMap.put("com.applovin.mediation.adapters.BidMachineMediationAdapter", "BidMachine");
        treeMap.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "Chartboost");
        treeMap.put("com.applovin.mediation.adapters.CriteoMediationAdapter", "Criteo");
        treeMap.put("com.applovin.mediation.adapters.CSJMediationAdapter", "CSJ");
        treeMap.put("com.applovin.mediation.adapters.DataseatMediationAdapter", "Dataseat");
        treeMap.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "Facebook");
        treeMap.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "AdMob");
        treeMap.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "Google Ad Manager");
        treeMap.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "HyprMX");
        treeMap.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "InMobi");
        treeMap.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "Fyber");
        treeMap.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "ironSource");
        treeMap.put("com.applovin.mediation.adapters.LineMediationAdapter", "LINE");
        treeMap.put("com.applovin.mediation.adapters.MaioMediationAdapter", "Maio");
        treeMap.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "Mintegral");
        treeMap.put("com.applovin.mediation.adapters.MobileFuseMediationAdapter", "MobileFuse");
        treeMap.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "myTarget");
        treeMap.put("com.applovin.mediation.adapters.NendMediationAdapter", "Nend");
        treeMap.put("com.applovin.mediation.adapters.NimbusMediationAdapter", "Nimbus");
        treeMap.put("com.applovin.mediation.adapters.OguryMediationAdapter", "Ogury");
        treeMap.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "Ogury Presage");
        treeMap.put("com.applovin.mediation.adapters.PangleMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.SayGamesMediationAdapter", "SayGames");
        treeMap.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "Smaato");
        treeMap.put("com.applovin.mediation.adapters.SnapMediationAdapter", "Snap");
        treeMap.put("com.applovin.mediation.adapters.TencentMediationAdapter", "Tencent");
        treeMap.put("com.applovin.mediation.adapters.TaboolaMediationAdapter", "Taboola");
        treeMap.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "Unity Ads");
        treeMap.put("com.applovin.mediation.adapters.VerizonAdsMediationAdapter", "Verizon");
        treeMap.put("com.applovin.mediation.adapters.VerveMediationAdapter", "Verve");
        treeMap.put("com.applovin.mediation.adapters.VungleMediationAdapter", "Vungle");
        treeMap.put("com.applovin.mediation.adapters.YahooMediationAdapter", "Yahoo");
        treeMap.put("com.applovin.mediation.adapters.YandexMediationAdapter", "Yandex");
        axj = new ArrayList(treeMap.keySet());
    }

    public static JSONArray f(n nVar) {
        if (axk != null) {
            g(nVar);
            return axk;
        }
        axk = new JSONArray();
        for (String next : axj) {
            MaxAdapter b = b(next, nVar);
            if (b != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", axi.get(next));
                    jSONObject.put("class", next);
                    jSONObject.put("sdk_version", b.getSdkVersion());
                    jSONObject.put(MediationMetaData.KEY_VERSION, b.getAdapterVersion());
                } catch (Throwable unused) {
                }
                synchronized (axl) {
                    axk.put(jSONObject);
                }
            }
        }
        return axk;
    }

    public static JSONObject a(String str, n nVar) {
        JSONArray f = f(nVar);
        for (int i = 0; i < f.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(f, i, (JSONObject) null);
            if (jSONObject != null && str.equals(JsonUtils.getString(jSONObject, "class", (String) null))) {
                return jSONObject;
            }
        }
        return null;
    }

    private static void g(n nVar) {
        MaxAdapter b;
        for (int i = 0; i < axk.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(axk, i, (JSONObject) null);
            String string = JsonUtils.getString(jSONObject, "class", "");
            if (!StringUtils.isValidString(JsonUtils.getString(jSONObject, "sdk_version", "")) && (b = b(string, nVar)) != null) {
                String sdkVersion = b.getSdkVersion();
                if (StringUtils.isValidString(sdkVersion)) {
                    synchronized (axl) {
                        JsonUtils.putString(jSONObject, "sdk_version", sdkVersion);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static q.b f(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
            return q.b.MEDIATION_INTERSTITIAL;
        }
        if (maxAdFormat == MaxAdFormat.APP_OPEN) {
            return q.b.MEDIATION_APP_OPEN;
        }
        if (maxAdFormat == MaxAdFormat.REWARDED) {
            return q.b.MEDIATION_INCENTIVIZED;
        }
        if (maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL) {
            return q.b.MEDIATION_REWARDED_INTERSTITIAL;
        }
        return q.b.MEDIATION_BANNER;
    }

    public static MaxAdapter b(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("AppLovinSdk", "Failed to create adapter instance. No class name provided");
            }
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return (MaxAdapter) cls.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{nVar.getWrappingSdk()});
            }
            nVar.BN();
            if (x.Fn()) {
                x BN = nVar.BN();
                BN.i("AppLovinSdk", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            }
            return null;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            nVar.BN();
            if (x.Fn()) {
                x BN2 = nVar.BN();
                BN2.c("AppLovinSdk", "Failed to load: " + str, th);
            }
        }
    }

    public static boolean Z(Object obj) {
        return (obj instanceof e) && StringUtils.isValidString(((e) obj).GB());
    }

    public static boolean aa(Object obj) {
        return (obj instanceof a) && "APPLOVIN".equals(((a) obj).yB());
    }

    public static AppLovinSdkUtils.Size a(int i, MaxAdFormat maxAdFormat, Context context) {
        if (i < 0) {
            try {
                i = AppLovinSdkUtils.pxToDp(context, h.Z(context).x);
            } catch (Throwable unused) {
                return maxAdFormat.getSize();
            }
        }
        Map<Integer, AppLovinSdkUtils.Size> map = axm;
        AppLovinSdkUtils.Size size = map.get(Integer.valueOf(i));
        if (size != null) {
            return size;
        }
        Class<?> cls = Class.forName("com.google.android.gms.ads.AdSize");
        Method method = cls.getMethod("getCurrentOrientationAnchoredAdaptiveBannerAdSize", new Class[]{Context.class, Integer.TYPE});
        Method method2 = cls.getMethod("getWidth", new Class[0]);
        Method method3 = cls.getMethod("getHeight", new Class[0]);
        Object invoke = method.invoke((Object) null, new Object[]{context, Integer.valueOf(i)});
        AppLovinSdkUtils.Size size2 = new AppLovinSdkUtils.Size(((Integer) method2.invoke(invoke, new Object[0])).intValue(), ((Integer) method3.invoke(invoke, new Object[0])).intValue());
        map.put(Integer.valueOf(i), size2);
        return size2;
    }
}
