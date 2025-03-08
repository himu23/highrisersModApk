package com.fyber.inneractive.sdk.serverapi;

import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.rtb.data.types.a;
import com.fyber.inneractive.sdk.util.n;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.t;
import com.unity3d.services.core.device.MimeTypes;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b implements c {
    public static final List<Integer> c = Arrays.asList(new Integer[]{5});
    public static final List<Integer> d = Arrays.asList(new Integer[]{Integer.valueOf(a.VAST_2_0.value), Integer.valueOf(a.VAST_2_0_WRAPPER.value)});
    public static final List<String> e = Arrays.asList(new String[]{"video/mp4", MimeTypes.VIDEO_WEBM, "video/3gpp", "application/x-mpegURL"});
    public s a;
    public String b = n.k();

    public b(s sVar) {
        this.a = sVar;
    }

    public String a() {
        try {
            return ((TelephonyManager) p.a.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception unused) {
            return null;
        }
    }

    public String b() {
        int i = n.b;
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public String e() {
        return p.a.getPackageName();
    }

    public String f() {
        try {
            return p.a.getPackageManager().getPackageInfo(p.a.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public int g() {
        return p.b(p.e());
    }

    public int h() {
        return p.b(p.f());
    }

    public boolean i() {
        if ((!t.a()) || IAConfigManager.M.r) {
            return true;
        }
        return false;
    }

    public String c() {
        String str = this.b;
        if (str == null) {
            return "";
        }
        return str.substring(0, Math.min(3, str.length()));
    }

    public String d() {
        String str = this.b;
        if (str == null) {
            return "";
        }
        return str.substring(Math.min(3, str.length()));
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append("-Android-8.2.5");
        if (!TextUtils.isEmpty(InneractiveAdManager.getDevPlatform())) {
            sb.append('-');
            sb.append(InneractiveAdManager.getDevPlatform());
        }
        return sb.toString();
    }

    public void a(Map<String, String> map, String str) {
        String str2;
        String str3;
        HashMap<String, Integer> hashMap = a.a;
        try {
            Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
            str2 = "unity3d";
        } catch (Throwable unused) {
            str2 = "native";
        }
        map.put("frmn", str2);
        map.put("headset", a(a.k()));
        map.put("is_muted", a(a.i()));
        map.put("btry_c", a(a.h()));
        map.put("btry_l", a.a());
        map.put("bt_con", a(a.f()));
        Long d2 = a.d();
        String str4 = "";
        if (d2 == null) {
            str3 = str4;
        } else {
            str3 = String.valueOf(d2);
        }
        map.put("tod", str3);
        map.put("apnm", a(a.e()));
        map.put("dnd", a(a.j()));
        IAConfigManager iAConfigManager = IAConfigManager.M;
        map.put("lng", iAConfigManager.p);
        String a2 = iAConfigManager.x.a(a.a(str), "LAST_DOMAIN_SHOWED");
        if (!TextUtils.isEmpty(a2) && a2.contains(",")) {
            a2 = a2.split(",")[0];
        }
        map.put("ldomain", a2);
        map.put("lbundle", iAConfigManager.x.a(a.a(str), "LAST_APP_BUNDLE_ID"));
        String a3 = iAConfigManager.x.a(a.a(str), "LAST_CLICKED");
        if (TextUtils.equals(a3, "0")) {
            a3 = str4;
        }
        map.put("lclick", a3);
        String a4 = iAConfigManager.x.a(a.a(str), "LAST_VAST_SKIPED");
        if (TextUtils.equals(a4, "0")) {
            a4 = str4;
        }
        map.put("v_lskip", a4);
        UnitDisplayType a5 = a.a(str);
        map.put("v_lclicktype", a5.isFullscreenUnit() ? iAConfigManager.x.a(a5, "LAST_VAST_CLICKED_TYPE") : str4);
        Long b2 = a.b();
        if (b2 != null) {
            str4 = String.valueOf(b2);
        }
        map.put("sdur", str4);
        map.put("userid", IAConfigManager.g());
        map.put("low_power_mode", a(a.l()));
        map.put("dark_mode", a(a.g()));
        map.put("d_api", String.valueOf(Build.VERSION.SDK_INT));
    }

    public static String a(Boolean bool) {
        if (bool == null) {
            return "";
        }
        return bool.booleanValue() ? "1" : "0";
    }

    public String a(Intent intent) {
        return a.a(((float) (intent.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) * 100)) / ((float) intent.getIntExtra("scale", -1)));
    }
}
