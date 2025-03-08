package com.fyber.inneractive.sdk.serverapi;

import android.app.NotificationManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.config.t;
import com.fyber.inneractive.sdk.config.z;
import com.fyber.inneractive.sdk.util.p;
import com.ironsource.k2;
import com.ironsource.m9;
import com.unity3d.services.core.device.MimeTypes;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class a {
    public static final HashMap<String, Integer> a = new C0135a();
    public static final List<String> b = Arrays.asList(new String[]{"POWER_SAVE_MODE_OPEN", "SmartModeStatus"});

    /* renamed from: com.fyber.inneractive.sdk.serverapi.a$a  reason: collision with other inner class name */
    public class C0135a extends HashMap<String, Integer> {
        public C0135a() {
            put("HUAWEI", 4);
            put("XIAOMI", 1);
        }
    }

    public static String a() {
        try {
            Intent registerReceiver = p.a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return "";
            }
            return a(((float) (registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) * 100)) / ((float) registerReceiver.getIntExtra("scale", -1)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(float f) {
        return f < 5.0f ? "1" : f <= 9.0f ? "2" : f <= 24.0f ? "3" : f <= 39.0f ? "4" : f <= 54.0f ? "5" : f <= 69.0f ? "6" : f <= 84.0f ? m9.e : f <= 100.0f ? "8" : "";
    }

    public static Long b() {
        long j;
        f0 f0Var = IAConfigManager.M.x;
        f0Var.getClass();
        String str = "";
        try {
            String str2 = f0Var.c.get("SESSION_STAMP");
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j = Long.parseLong(str);
        } catch (Exception unused) {
            j = 0;
        }
        return Long.valueOf(TimeUnit.SECONDS.convert(SystemClock.elapsedRealtime() - j, TimeUnit.MILLISECONDS));
    }

    public static Long d() {
        try {
            return Long.valueOf(TimeUnit.MINUTES.convert((long) Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()), TimeUnit.MILLISECONDS));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean f() {
        if (p.b("android.permission.BLUETOOTH")) {
            try {
                BluetoothManager bluetoothManager = (BluetoothManager) p.a.getSystemService(k2.d);
                if (bluetoothManager.getAdapter().getProfileConnectionState(1) != 2) {
                    if (bluetoothManager.getAdapter().getProfileConnectionState(2) != 2) {
                        return null;
                    }
                }
                return Boolean.TRUE;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Boolean g() {
        return Boolean.valueOf((p.a.getResources().getConfiguration().uiMode & 48) == 32);
    }

    public static Boolean h() {
        int intExtra;
        try {
            Intent registerReceiver = p.a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            boolean z = false;
            if (registerReceiver != null && ((intExtra = registerReceiver.getIntExtra("plugged", -1)) == 1 || intExtra == 2 || intExtra == 4)) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean i() {
        try {
            int ringerMode = ((AudioManager) p.a.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getRingerMode();
            boolean z = true;
            if (!(ringerMode == 0 || ringerMode == 1)) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean j() {
        try {
            NotificationManager notificationManager = (NotificationManager) p.a.getSystemService("notification");
            if (Build.VERSION.SDK_INT < 23) {
                return null;
            }
            int m = notificationManager.getCurrentInterruptionFilter();
            return Boolean.valueOf(m >= 2 && m <= 4);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean k() {
        boolean z;
        try {
            AudioManager audioManager = (AudioManager) p.a.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (Build.VERSION.SDK_INT >= 23) {
                z = false;
                for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                    if (audioDeviceInfo.getType() == 22 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 12 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                        z = true;
                    }
                }
            } else {
                z = audioManager.isWiredHeadsetOn();
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean l() {
        Integer num;
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
            if (TextUtils.isEmpty(upperCase) || !a.containsKey(upperCase)) {
                return Boolean.valueOf(((PowerManager) p.a.getSystemService("power")).isPowerSaveMode());
            }
            try {
                for (String str : b) {
                    int i = Settings.System.getInt(p.a.getContentResolver(), str, -1);
                    if (i != -1 && (num = a.get(upperCase)) != null) {
                        return Boolean.valueOf(num.intValue() == i);
                    }
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Boolean e() {
        try {
            boolean z = false;
            if (Settings.System.getInt(p.a.getContentResolver(), "airplane_mode_on", 0) != 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        try {
            Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
            return "unity3d";
        } catch (Throwable unused) {
            return "native";
        }
    }

    public static UnitDisplayType a(String str) {
        a0 c;
        UnitDisplayType unitDisplayType = UnitDisplayType.INTERSTITIAL;
        z a2 = com.fyber.inneractive.sdk.config.a.a(str);
        if (a2 == null || a2.a.size() <= 0 || (c = a2.c(0)) == null) {
            return unitDisplayType;
        }
        c0 c0Var = c.f;
        t tVar = c.c;
        if (c0Var != null) {
            return c0Var.j;
        }
        return tVar != null ? tVar.b : unitDisplayType;
    }
}
