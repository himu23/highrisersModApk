package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.graphics.ColorKt$$ExternalSyntheticApiModelOutline0;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.i;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.d;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.m2;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public class q {
    /* access modifiers changed from: private */
    public static final AtomicReference<d.a> aDL = new AtomicReference<>();
    private static final AtomicReference<b> aDM = new AtomicReference<>();
    private static final AtomicReference<Integer> aDN = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final Context E;
    private e aDA;
    private e aDB;
    private e aDC;
    private e aDD;
    private e aDE;
    /* access modifiers changed from: private */
    public final int aDF;
    /* access modifiers changed from: private */
    public final int aDG;
    /* access modifiers changed from: private */
    public final int aDH;
    /* access modifiers changed from: private */
    public final int aDI;
    private final int aDJ;
    /* access modifiers changed from: private */
    public final int aDK;
    private boolean aDc;
    private final h aDl = new h();
    private final i aDm = new i();
    private final c aDn = new c();
    private final d aDo = new d();
    private final f aDp = new f();
    private final g aDq = new g();
    private final String aDr;
    private final String aDs;
    private final double aDt;
    private final boolean aDu;
    private String aDv;
    private long aDw;
    private final a aDx;
    /* access modifiers changed from: private */
    public e aDy;
    private e aDz;
    /* access modifiers changed from: private */
    public final n sdk;

    public h DX() {
        return this.aDl;
    }

    public i DY() {
        return this.aDm;
    }

    public c DZ() {
        return this.aDn;
    }

    public boolean Da() {
        return this.aDc;
    }

    public d Ea() {
        return this.aDo;
    }

    public f Eb() {
        return this.aDp;
    }

    public g Ec() {
        return this.aDq;
    }

    public String Ed() {
        return this.aDr;
    }

    public String Ee() {
        return this.aDs;
    }

    public double Ef() {
        return this.aDt;
    }

    public boolean Eg() {
        return this.aDu;
    }

    public String Eh() {
        return this.aDv;
    }

    public long Ei() {
        return this.aDw;
    }

    public a Ej() {
        return this.aDx;
    }

    protected q(n nVar) {
        this.sdk = nVar;
        Context applicationContext = n.getApplicationContext();
        this.E = applicationContext;
        this.aDF = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPe)).intValue();
        this.aDG = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPf)).intValue();
        this.aDH = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPg)).intValue();
        this.aDI = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPh)).intValue();
        this.aDJ = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPi)).intValue();
        this.aDK = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPj)).intValue();
        this.aDr = AppLovinSdkUtils.isFireOS(applicationContext) ? "fireos" : "android";
        int orientation = AppLovinSdkUtils.getOrientation(applicationContext);
        if (orientation == 1) {
            this.aDs = m2.h.D;
        } else if (orientation == 2) {
            this.aDs = m2.h.C;
        } else {
            this.aDs = "none";
        }
        this.aDt = ((double) Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d)) / 10.0d;
        SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
        this.aDu = (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
        if (com.applovin.impl.sdk.utils.h.KZ()) {
            LocaleList m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(applicationContext.getResources().getConfiguration());
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < ColorKt$$ExternalSyntheticApiModelOutline0.m(m); i2++) {
                sb.append(m.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            this.aDv = sb.toString();
        }
        try {
            this.aDw = Environment.getDataDirectory().getTotalSpace();
        } catch (Throwable th) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().c("DataProvider", "Unable to collect total disk space.", th);
            }
        }
        this.aDx = new a();
    }

    public b DJ() {
        return aDM.get();
    }

    public static void a(b bVar) {
        aDM.set(bVar);
    }

    /* access modifiers changed from: protected */
    public d.a DK() {
        return aDL.get();
    }

    /* access modifiers changed from: protected */
    public Integer DL() {
        return aDN.get();
    }

    public d.a DM() {
        d.a U = com.applovin.impl.sdk.utils.d.U(this.E);
        if (U == null) {
            return new d.a();
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOr)).booleanValue()) {
            if (U.KQ() && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOq)).booleanValue()) {
                U.dx("");
            }
            aDL.set(U);
        } else {
            U = new d.a();
        }
        boolean z = false;
        if (StringUtils.isValidString(U.KR())) {
            List<String> testDeviceAdvertisingIds = this.sdk.getSettings().getTestDeviceAdvertisingIds();
            if (testDeviceAdvertisingIds != null && testDeviceAdvertisingIds.contains(U.KR())) {
                z = true;
            }
            this.aDc = z;
        } else {
            this.aDc = false;
        }
        return U;
    }

    public static void a(d.a aVar) {
        aDL.set(aVar);
    }

    /* access modifiers changed from: protected */
    public void DN() {
        this.sdk.BO().a((com.applovin.impl.sdk.e.d) new com.applovin.impl.sdk.e.i(this.sdk, new i.a() {
            public void b(d.a aVar) {
                q.aDL.set(aVar);
            }
        }), q.b.ADVERTISING_INFO_COLLECTION);
        this.sdk.BO().a((com.applovin.impl.sdk.e.d) new ab(this.sdk, true, "setDeviceVolume", new q$$ExternalSyntheticLambda0(this)), q.b.CACHING_OTHER);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ek() {
        aDN.set(this.aDn.Ev());
    }

    /* access modifiers changed from: protected */
    public String DO() {
        e eVar = this.aDD;
        if (eVar != null && !eVar.isExpired()) {
            return (String) this.aDD.aEf;
        }
        e eVar2 = new e(com.applovin.impl.sdk.utils.i.G(this.sdk), (long) this.aDK);
        this.aDD = eVar2;
        return (String) eVar2.aEf;
    }

    /* access modifiers changed from: protected */
    public Long DP() {
        e eVar = this.aDz;
        if (eVar != null && !eVar.isExpired()) {
            return Long.valueOf(((Long) this.aDz.aEf).longValue());
        }
        try {
            e eVar2 = new e(Long.valueOf(Environment.getDataDirectory().getFreeSpace()), (long) this.aDI);
            this.aDz = eVar2;
            return Long.valueOf(((Long) eVar2.aEf).longValue());
        } catch (Throwable th) {
            this.sdk.BN();
            if (!x.Fn()) {
                return null;
            }
            this.sdk.BN().c("DataProvider", "Unable to collect free space.", th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Float DQ() {
        e eVar = this.aDB;
        if (eVar != null && !eVar.isExpired()) {
            return Float.valueOf(((Float) this.aDB.aEf).floatValue());
        }
        if (this.sdk.Ci() == null) {
            return null;
        }
        e eVar2 = new e(Float.valueOf(this.sdk.Ci().Ls()), (long) this.aDF);
        this.aDB = eVar2;
        return Float.valueOf(((Float) eVar2.aEf).floatValue());
    }

    /* access modifiers changed from: protected */
    public Float DR() {
        e eVar = this.aDC;
        if (eVar != null && !eVar.isExpired()) {
            return Float.valueOf(((Float) this.aDC.aEf).floatValue());
        }
        if (this.sdk.Ci() == null) {
            return null;
        }
        e eVar2 = new e(Float.valueOf(this.sdk.Ci().Lr()), (long) this.aDF);
        this.aDC = eVar2;
        return Float.valueOf(((Float) eVar2.aEf).floatValue());
    }

    /* access modifiers changed from: protected */
    public Integer DS() {
        e eVar = this.aDE;
        if (eVar != null && !eVar.isExpired()) {
            return Integer.valueOf(((Integer) this.aDE.aEf).intValue());
        }
        try {
            e eVar2 = new e(Integer.valueOf((int) ((((float) Settings.System.getInt(this.E.getContentResolver(), "screen_brightness")) / 255.0f) * 100.0f)), (long) this.aDG);
            this.aDE = eVar2;
            return Integer.valueOf(((Integer) eVar2.aEf).intValue());
        } catch (Settings.SettingNotFoundException e2) {
            this.sdk.BN();
            if (!x.Fn()) {
                return null;
            }
            this.sdk.BN().c("DataProvider", "Unable to collect screen brightness", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long DT() {
        /*
            r6 = this;
            android.content.Context r0 = r6.E
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r1 = "enabled_accessibility_services"
            java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r1)
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.emptyIfNull(r0)
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)
            java.util.List r0 = java.util.Arrays.asList(r0)
            java.lang.String r1 = "AccessibilityMenuService"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x0025
            r1 = 256(0x100, double:1.265E-321)
            goto L_0x0027
        L_0x0025:
            r1 = 0
        L_0x0027:
            java.lang.String r3 = "SelectToSpeakService"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x0032
            r3 = 512(0x200, double:2.53E-321)
            long r1 = r1 | r3
        L_0x0032:
            java.lang.String r3 = "SoundAmplifierService"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x003d
            r3 = 2
            long r1 = r1 | r3
        L_0x003d:
            java.lang.String r3 = "SpeechToTextAccessibilityService"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x0048
            r3 = 128(0x80, double:6.32E-322)
            long r1 = r1 | r3
        L_0x0048:
            java.lang.String r3 = "SwitchAccessService"
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x0053
            r3 = 4
            long r1 = r1 | r3
        L_0x0053:
            android.content.Context r0 = r6.E
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r3 = 32
            if (r0 != r3) goto L_0x0068
            r3 = 1024(0x400, double:5.06E-321)
            long r1 = r1 | r3
        L_0x0068:
            java.lang.String r0 = "accessibility_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0073
            r3 = 8
            long r1 = r1 | r3
        L_0x0073:
            java.lang.String r0 = "touch_exploration_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x007e
            r3 = 16
            long r1 = r1 | r3
        L_0x007e:
            boolean r0 = com.applovin.impl.sdk.utils.h.KX()
            if (r0 == 0) goto L_0x009a
            java.lang.String r0 = "accessibility_display_inversion_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x008f
            r3 = 32
            long r1 = r1 | r3
        L_0x008f:
            java.lang.String r0 = "skip_first_use_hints"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x009a
            r3 = 64
            long r1 = r1 | r3
        L_0x009a:
            java.lang.String r0 = "lock_screen_allow_remote_input"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00a5
            r3 = 2048(0x800, double:1.0118E-320)
            long r1 = r1 | r3
        L_0x00a5:
            java.lang.String r0 = "enabled_accessibility_audio_description_by_default"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00b0
            r3 = 4096(0x1000, double:2.0237E-320)
            long r1 = r1 | r3
        L_0x00b0:
            java.lang.String r0 = "accessibility_shortcut_on_lock_screen"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00bb
            r3 = 8192(0x2000, double:4.0474E-320)
            long r1 = r1 | r3
        L_0x00bb:
            java.lang.String r0 = "wear_talkback_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00c6
            r3 = 16384(0x4000, double:8.0948E-320)
            long r1 = r1 | r3
        L_0x00c6:
            java.lang.String r0 = "hush_gesture_used"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00d2
            r3 = 32768(0x8000, double:1.61895E-319)
            long r1 = r1 | r3
        L_0x00d2:
            java.lang.String r0 = "high_text_contrast_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00de
            r3 = 65536(0x10000, double:3.2379E-319)
            long r1 = r1 | r3
        L_0x00de:
            java.lang.String r0 = "accessibility_display_magnification_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00ea
            r3 = 131072(0x20000, double:6.47582E-319)
            long r1 = r1 | r3
        L_0x00ea:
            java.lang.String r0 = "accessibility_display_magnification_navbar_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00f6
            r3 = 262144(0x40000, double:1.295163E-318)
            long r1 = r1 | r3
        L_0x00f6:
            java.lang.String r0 = "accessibility_captioning_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0102
            r3 = 524288(0x80000, double:2.590327E-318)
            long r1 = r1 | r3
        L_0x0102:
            java.lang.String r0 = "accessibility_display_daltonizer_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x010e
            r3 = 1048576(0x100000, double:5.180654E-318)
            long r1 = r1 | r3
        L_0x010e:
            java.lang.String r0 = "accessibility_autoclick_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x011a
            r3 = 2097152(0x200000, double:1.0361308E-317)
            long r1 = r1 | r3
        L_0x011a:
            java.lang.String r0 = "accessibility_large_pointer_icon"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0126
            r3 = 4194304(0x400000, double:2.0722615E-317)
            long r1 = r1 | r3
        L_0x0126:
            java.lang.String r0 = "reduce_bright_colors_activated"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0132
            r3 = 8388608(0x800000, double:4.144523E-317)
            long r1 = r1 | r3
        L_0x0132:
            java.lang.String r0 = "reduce_bright_colors_persist_across_reboots"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x013e
            r3 = 16777216(0x1000000, double:8.289046E-317)
            long r1 = r1 | r3
        L_0x013e:
            java.lang.String r0 = "tty_mode_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x014a
            r3 = 33554432(0x2000000, double:1.6578092E-316)
            long r1 = r1 | r3
        L_0x014a:
            java.lang.String r0 = "rtt_calling_mode"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0156
            r3 = 67108864(0x4000000, double:3.31561842E-316)
            long r1 = r1 | r3
        L_0x0156:
            java.lang.String r0 = "accessibility_floating_menu_fade_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0162
            r3 = 134217728(0x8000000, double:6.63123685E-316)
            long r1 = r1 | r3
        L_0x0162:
            java.lang.String r0 = "accessibility_show_window_magnification_prompt"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x016e
            r3 = 268435456(0x10000000, double:1.32624737E-315)
            long r1 = r1 | r3
        L_0x016e:
            java.lang.String r0 = "accessibility_floating_menu_migration_tooltip_prompt"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x017a
            r3 = 536870912(0x20000000, double:2.652494739E-315)
            long r1 = r1 | r3
        L_0x017a:
            java.lang.String r0 = "accessibility_magnification_mode"
            int r0 = r6.cE(r0)
            r3 = 1
            if (r0 != 0) goto L_0x0188
            r4 = 1073741824(0x40000000, double:5.304989477E-315)
        L_0x0186:
            long r1 = r1 | r4
            goto L_0x01a2
        L_0x0188:
            if (r0 != r3) goto L_0x0190
            r4 = 2147483648(0x80000000, double:1.0609978955E-314)
            goto L_0x0186
        L_0x0190:
            r4 = 2
            if (r0 != r4) goto L_0x0199
            r4 = 4294967296(0x100000000, double:2.121995791E-314)
            goto L_0x0186
        L_0x0199:
            r4 = 3
            if (r0 != r4) goto L_0x01a2
            r4 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x0186
        L_0x01a2:
            java.lang.String r0 = "accessibility_button_mode"
            int r0 = r6.cE(r0)
            if (r0 != 0) goto L_0x01b1
            r4 = 17179869184(0x400000000, double:8.4879831639E-314)
        L_0x01af:
            long r1 = r1 | r4
            goto L_0x01b9
        L_0x01b1:
            if (r0 != r3) goto L_0x01b9
            r4 = 34359738368(0x800000000, double:1.69759663277E-313)
            goto L_0x01af
        L_0x01b9:
            java.lang.String r0 = "accessibility_floating_menu_size"
            int r0 = r6.cE(r0)
            if (r0 != 0) goto L_0x01c8
            r4 = 68719476736(0x1000000000, double:3.39519326554E-313)
        L_0x01c6:
            long r1 = r1 | r4
            goto L_0x01d0
        L_0x01c8:
            if (r0 != r3) goto L_0x01d0
            r4 = 137438953472(0x2000000000, double:6.7903865311E-313)
            goto L_0x01c6
        L_0x01d0:
            java.lang.String r0 = "accessibility_floating_menu_icon_type"
            int r0 = r6.cE(r0)
            if (r0 != 0) goto L_0x01df
            r3 = 274877906944(0x4000000000, double:1.358077306218E-312)
        L_0x01dd:
            long r1 = r1 | r3
            goto L_0x01e7
        L_0x01df:
            if (r0 != r3) goto L_0x01e7
            r3 = 549755813888(0x8000000000, double:2.716154612436E-312)
            goto L_0x01dd
        L_0x01e7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.q.DT():long");
    }

    /* access modifiers changed from: protected */
    public float DU() {
        try {
            return Settings.System.getFloat(this.E.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e2) {
            this.sdk.BN();
            if (!x.Fn()) {
                return -1.0f;
            }
            this.sdk.BN().c("DataProvider", "Error collecting font scale", e2);
            return -1.0f;
        }
    }

    /* access modifiers changed from: protected */
    public boolean DV() {
        e eVar = this.aDA;
        if (eVar != null && !eVar.isExpired()) {
            return ((Boolean) this.aDA.aEf).booleanValue();
        }
        e eVar2 = new e(Boolean.valueOf(u.Lz()), (long) this.aDI);
        this.aDA = eVar2;
        return ((Boolean) eVar2.aEf).booleanValue();
    }

    /* access modifiers changed from: protected */
    public boolean Dh() {
        ConnectivityManager connectivityManager;
        if (!com.applovin.impl.sdk.utils.h.KZ() || (connectivityManager = (ConnectivityManager) this.E.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            if (connectivityManager.getRestrictBackgroundStatus() == 3) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().c("DataProvider", "Unable to collect constrained network info.", th);
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean Dy() {
        try {
            return DB() || DC();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean DW() {
        boolean z = this.E.getResources().getConfiguration().keyboard == 2;
        boolean hasSystemFeature = this.E.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
        boolean hasSystemFeature2 = this.E.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        if (!z || (!hasSystemFeature && !hasSystemFeature2)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public String[] DA() {
        if (!com.applovin.impl.sdk.utils.h.KX()) {
            return null;
        }
        return Build.SUPPORTED_ABIS;
    }

    private boolean DB() {
        String str = Build.TAGS;
        return str != null && str.contains(cF("lz}$blpz"));
    }

    private boolean DC() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i2 = 0; i2 < 9; i2++) {
            if (new File(cF(strArr[i2])).exists()) {
                return true;
            }
        }
        return false;
    }

    private String cF(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = str.charAt(i2);
            for (int i3 = 9; i3 >= 0; i3--) {
                cArr[i2] = (char) (cArr[i2] ^ iArr[i3]);
            }
        }
        return new String(cArr);
    }

    private boolean cD(String str) {
        return cE(str) == 1;
    }

    private int cE(String str) {
        try {
            return Settings.Secure.getInt(this.E.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static class b {
        private final int aDh;

        /* renamed from: do  reason: not valid java name */
        private final String f16do;

        public int Et() {
            return this.aDh;
        }

        public String mQ() {
            return this.f16do;
        }

        public b(String str, int i) {
            this.f16do = str;
            this.aDh = i;
        }
    }

    protected class h {
        private final PowerManager iT;

        private h() {
            this.iT = (PowerManager) q.this.E.getSystemService("power");
        }

        /* access modifiers changed from: protected */
        public Integer EP() {
            if (q.this.aDy != null && !q.this.aDy.isExpired()) {
                return Integer.valueOf(((Integer) q.this.aDy.aEf).intValue());
            }
            if (this.iT == null || !com.applovin.impl.sdk.utils.h.KX()) {
                return null;
            }
            q qVar = q.this;
            e unused = qVar.aDy = new e(Integer.valueOf(this.iT.isPowerSaveMode() ? 1 : 0), (long) q.this.aDH);
            return Integer.valueOf(((Integer) q.this.aDy.aEf).intValue());
        }
    }

    protected class i {
        private final TelephonyManager aEt;
        private String aEu;
        private String aEv;
        private String aEw;
        private String aEx;
        private String aEy;
        private e aEz;

        public String ER() {
            return this.aEw;
        }

        public String ES() {
            return this.aEx;
        }

        public String ET() {
            return this.aEy;
        }

        public String getCountryCode() {
            return this.aEv;
        }

        private i() {
            TelephonyManager telephonyManager = (TelephonyManager) q.this.E.getSystemService("phone");
            this.aEt = telephonyManager;
            if (telephonyManager != null) {
                this.aEv = telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH);
                try {
                    this.aEw = telephonyManager.getNetworkOperatorName();
                } catch (Throwable th) {
                    q.this.sdk.BN();
                    if (x.Fn()) {
                        q.this.sdk.BN().c("DataProvider", "Unable to collect carrier", th);
                    }
                }
                try {
                    this.aEu = this.aEt.getNetworkOperator();
                } catch (Throwable th2) {
                    q.this.sdk.BN();
                    if (x.Fn()) {
                        q.this.sdk.BN().c("DataProvider", "Unable to collect get network operator", th2);
                    }
                }
                String str = this.aEu;
                if (str != null) {
                    int min = Math.min(3, str.length());
                    this.aEx = this.aEu.substring(0, min);
                    this.aEy = this.aEu.substring(min);
                }
            }
        }

        /* access modifiers changed from: protected */
        public Integer EQ() {
            e eVar = this.aEz;
            if (eVar != null && !eVar.isExpired()) {
                return Integer.valueOf(((Integer) this.aEz.aEf).intValue());
            }
            if (!com.applovin.impl.sdk.utils.h.d("android.permission.READ_PHONE_STATE", q.this.E) || this.aEt == null || !com.applovin.impl.sdk.utils.h.KZ()) {
                return null;
            }
            e eVar2 = new e(Integer.valueOf(this.aEt.getDataNetworkType()), (long) q.this.aDK);
            this.aEz = eVar2;
            return Integer.valueOf(((Integer) eVar2.aEf).intValue());
        }
    }

    protected class d {
        private e aEa;
        private e aEb;
        private e aEc;
        private final Intent aEd;
        private BatteryManager aEe;

        private d() {
            this.aEd = q.this.E.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (com.applovin.impl.sdk.utils.h.KX()) {
                this.aEe = (BatteryManager) q.this.E.getSystemService("batterymanager");
            }
        }

        /* access modifiers changed from: protected */
        public Integer Ez() {
            int i;
            BatteryManager batteryManager;
            e eVar = this.aEa;
            if (eVar != null && !eVar.isExpired()) {
                return Integer.valueOf(((Integer) this.aEa.aEf).intValue());
            }
            if (!com.applovin.impl.sdk.utils.h.KX() || (batteryManager = this.aEe) == null) {
                Intent intent = this.aEd;
                if (intent == null) {
                    return null;
                }
                int intExtra = intent.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
                int intExtra2 = this.aEd.getIntExtra("scale", -1);
                if (intExtra < 0 || intExtra2 < 0) {
                    return null;
                }
                i = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
            } else {
                i = batteryManager.getIntProperty(4);
            }
            e eVar2 = new e(Integer.valueOf(i), (long) q.this.aDH);
            this.aEa = eVar2;
            return Integer.valueOf(((Integer) eVar2.aEf).intValue());
        }

        /* access modifiers changed from: protected */
        public Integer EA() {
            int i;
            BatteryManager batteryManager;
            e eVar = this.aEb;
            if (eVar != null && !eVar.isExpired()) {
                return Integer.valueOf(((Integer) this.aEb.aEf).intValue());
            }
            if (!com.applovin.impl.sdk.utils.h.La() || (batteryManager = this.aEe) == null) {
                Intent intent = this.aEd;
                if (intent == null || (i = intent.getIntExtra("status", -1)) < 0) {
                    return null;
                }
            } else {
                i = batteryManager.getIntProperty(6);
            }
            e eVar2 = new e(Integer.valueOf(i), (long) q.this.aDH);
            this.aEb = eVar2;
            return Integer.valueOf(((Integer) eVar2.aEf).intValue());
        }

        /* access modifiers changed from: protected */
        public Boolean EB() {
            e eVar = this.aEc;
            if (eVar != null && !eVar.isExpired()) {
                return Boolean.valueOf(((Boolean) this.aEc.aEf).booleanValue());
            }
            boolean z = false;
            if (com.applovin.impl.sdk.utils.h.KV()) {
                if (Settings.Global.getInt(q.this.E.getContentResolver(), "stay_on_while_plugged_in", -1) > 0) {
                    z = true;
                }
                this.aEc = new e(Boolean.valueOf(z), (long) q.this.aDH);
            } else {
                Intent intent = this.aEd;
                if (intent == null) {
                    return null;
                }
                int intExtra = (intent.getIntExtra("plugged", -1) & 1) | 14;
                q qVar = q.this;
                if (intExtra > 0) {
                    z = true;
                }
                this.aEc = new e(Boolean.valueOf(z), (long) q.this.aDH);
            }
            return Boolean.valueOf(((Boolean) this.aEc.aEf).booleanValue());
        }
    }

    protected class c {
        private final AudioManager K;
        private e aDV;
        private e aDW;
        private e aDX;
        private e aDY;
        private e aDZ;

        private c() {
            this.K = (AudioManager) q.this.E.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        }

        /* access modifiers changed from: protected */
        public int Eu() {
            e eVar = this.aDX;
            if (eVar != null && !eVar.isExpired()) {
                return ((Integer) this.aDX.aEf).intValue();
            }
            q qVar = q.this;
            e eVar2 = new e(Integer.valueOf(qVar.sdk.Cj().AV()), (long) q.this.aDH);
            this.aDX = eVar2;
            return ((Integer) eVar2.aEf).intValue();
        }

        /* access modifiers changed from: protected */
        public Integer Ev() {
            e eVar = this.aDV;
            if (eVar != null && !eVar.isExpired()) {
                return Integer.valueOf(((Integer) this.aDV.aEf).intValue());
            }
            if (this.K == null) {
                return null;
            }
            try {
                e eVar2 = new e(Integer.valueOf((int) (((float) this.K.getStreamVolume(3)) * ((Float) q.this.sdk.a(com.applovin.impl.sdk.c.b.aOQ)).floatValue())), (long) q.this.aDG);
                this.aDV = eVar2;
                return Integer.valueOf(((Integer) eVar2.aEf).intValue());
            } catch (Throwable th) {
                q.this.sdk.BN();
                if (x.Fn()) {
                    q.this.sdk.BN().c("DataProvider", "Unable to collect device volume", th);
                }
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public String Ew() {
            e eVar = this.aDW;
            if (eVar != null && !eVar.isExpired()) {
                return (String) this.aDW.aEf;
            }
            if (this.K == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (com.applovin.impl.sdk.utils.h.KY()) {
                for (AudioDeviceInfo m : this.K.getDevices(2)) {
                    sb.append(m.getType());
                    sb.append(",");
                }
            } else {
                if (this.K.isWiredHeadsetOn()) {
                    sb.append("3,");
                }
                if (this.K.isBluetoothScoOn()) {
                    sb.append("7,");
                }
                if (this.K.isBluetoothA2dpOn()) {
                    sb.append(8);
                }
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                q.this.sdk.BN();
                if (x.Fn()) {
                    q.this.sdk.BN().f("DataProvider", "No sound outputs detected");
                }
            }
            q qVar = q.this;
            e eVar2 = new e(sb2, (long) qVar.aDI);
            this.aDW = eVar2;
            return (String) eVar2.aEf;
        }

        /* access modifiers changed from: protected */
        public Boolean Ex() {
            e eVar = this.aDY;
            if (eVar != null && !eVar.isExpired()) {
                return Boolean.valueOf(((Boolean) this.aDY.aEf).booleanValue());
            }
            AudioManager audioManager = this.K;
            if (audioManager == null) {
                return null;
            }
            e eVar2 = new e(Boolean.valueOf(audioManager.isMusicActive()), (long) q.this.aDI);
            this.aDY = eVar2;
            return Boolean.valueOf(((Boolean) eVar2.aEf).booleanValue());
        }

        /* access modifiers changed from: protected */
        public Boolean Ey() {
            e eVar = this.aDZ;
            if (eVar != null && !eVar.isExpired()) {
                return Boolean.valueOf(((Boolean) this.aDZ.aEf).booleanValue());
            }
            AudioManager audioManager = this.K;
            if (audioManager == null) {
                return null;
            }
            e eVar2 = new e(Boolean.valueOf(audioManager.isSpeakerphoneOn()), (long) q.this.aDI);
            this.aDZ = eVar2;
            return Boolean.valueOf(((Boolean) eVar2.aEf).booleanValue());
        }
    }

    protected class f {
        private float Wy;
        private int aEh;
        private int aEi;
        private int aEj;
        private float aEk;
        private float aEl;
        private double aEm;
        private final Boolean aEn;

        public int ED() {
            return this.aEh;
        }

        public int EE() {
            return this.aEi;
        }

        public int EF() {
            return this.aEj;
        }

        public float EG() {
            return this.aEk;
        }

        public float EH() {
            return this.aEl;
        }

        public float EI() {
            return this.Wy;
        }

        public double EJ() {
            return this.aEm;
        }

        public Boolean EK() {
            return this.aEn;
        }

        private f() {
            this.aEn = com.applovin.impl.sdk.utils.h.La() ? Boolean.valueOf(q.this.E.getResources().getConfiguration().isScreenHdr()) : null;
            DisplayMetrics displayMetrics = q.this.E.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                this.Wy = displayMetrics.density;
                this.aEk = displayMetrics.xdpi;
                this.aEl = displayMetrics.ydpi;
                this.aEj = displayMetrics.densityDpi;
                Point Y = com.applovin.impl.sdk.utils.h.Y(q.this.E);
                this.aEh = Y.x;
                this.aEi = Y.y;
                this.aEm = Math.sqrt(Math.pow((double) this.aEh, 2.0d) + Math.pow((double) this.aEi, 2.0d)) / ((double) this.aEk);
            }
        }
    }

    protected class g {
        private long aEo;
        private e aEp;
        private e aEq;
        private e aEr;
        private final ActivityManager aEs;

        public long EO() {
            return this.aEo;
        }

        private g() {
            ActivityManager activityManager = (ActivityManager) q.this.E.getSystemService("activity");
            this.aEs = activityManager;
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                try {
                    activityManager.getMemoryInfo(memoryInfo);
                    this.aEo = memoryInfo.totalMem;
                } catch (Throwable th) {
                    q.this.sdk.BN();
                    if (x.Fn()) {
                        q.this.sdk.BN().c("DataProvider", "Unable to collect memory info.", th);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public Long EL() {
            e eVar = this.aEp;
            if (eVar != null && !eVar.isExpired()) {
                return Long.valueOf(((Long) this.aEp.aEf).longValue());
            }
            if (this.aEs == null) {
                return null;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            try {
                this.aEs.getMemoryInfo(memoryInfo);
                e eVar2 = new e(Long.valueOf(memoryInfo.availMem), (long) q.this.aDF);
                this.aEp = eVar2;
                return Long.valueOf(((Long) eVar2.aEf).longValue());
            } catch (Throwable th) {
                q.this.sdk.BN();
                if (x.Fn()) {
                    q.this.sdk.BN().c("DataProvider", "Unable to collect available memory.", th);
                }
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public Long EM() {
            e eVar = this.aEq;
            if (eVar != null && !eVar.isExpired()) {
                return Long.valueOf(((Long) this.aEq.aEf).longValue());
            }
            if (this.aEs == null) {
                return null;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            try {
                this.aEs.getMemoryInfo(memoryInfo);
                e eVar2 = new e(Long.valueOf(memoryInfo.threshold), (long) q.this.aDF);
                this.aEq = eVar2;
                return Long.valueOf(((Long) eVar2.aEf).longValue());
            } catch (Throwable th) {
                q.this.sdk.BN();
                if (x.Fn()) {
                    q.this.sdk.BN().c("DataProvider", "Unable to collect low memory threshold.", th);
                }
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public Boolean EN() {
            e eVar = this.aEr;
            if (eVar != null && !eVar.isExpired()) {
                return Boolean.valueOf(((Boolean) this.aEr.aEf).booleanValue());
            }
            if (this.aEs == null) {
                return null;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            try {
                this.aEs.getMemoryInfo(memoryInfo);
                e eVar2 = new e(Boolean.valueOf(memoryInfo.lowMemory), (long) q.this.aDF);
                this.aEr = eVar2;
                return Boolean.valueOf(((Boolean) eVar2.aEf).booleanValue());
            } catch (Throwable th) {
                q.this.sdk.BN();
                if (x.Fn()) {
                    q.this.sdk.BN().c("DataProvider", "Unable to collect has low memory.", th);
                }
                return null;
            }
        }
    }

    public class a {
        private final String aDP;
        private final String aDQ;
        private final Long aDR;
        private final long aDS;
        private final int aDT;
        private final int aDU;
        private final String abm;
        private final String name;
        private final String version;

        public String En() {
            return this.abm;
        }

        public String Eo() {
            return this.aDP;
        }

        public String Ep() {
            return this.aDQ;
        }

        public Long Eq() {
            return this.aDR;
        }

        public long Er() {
            return this.aDS;
        }

        public int Es() {
            return this.aDU;
        }

        public String getName() {
            return this.name;
        }

        public String getVersion() {
            return this.version;
        }

        public int getVersionCode() {
            return this.aDT;
        }

        private a() {
            PackageManager packageManager = q.this.E.getPackageManager();
            ApplicationInfo applicationInfo = q.this.E.getApplicationInfo();
            File file = new File(applicationInfo.sourceDir);
            PackageInfo packageInfo = packageManager.getPackageInfo(q.this.E.getPackageName(), 0);
            this.name = packageManager.getApplicationLabel(applicationInfo).toString();
            this.version = packageInfo.versionName;
            this.aDT = packageInfo.versionCode;
            String str = applicationInfo.packageName;
            this.abm = str;
            this.aDP = StringUtils.toShortSHA1Hash(str);
            this.aDS = file.lastModified();
            this.aDR = Long.valueOf(packageInfo.firstInstallTime);
            this.aDU = applicationInfo.targetSdkVersion;
            this.aDQ = packageManager.getInstallerPackageName(str);
        }

        /* access modifiers changed from: protected */
        public Long Em() {
            Long l = (Long) q.this.sdk.a(com.applovin.impl.sdk.c.d.aRk);
            if (l != null) {
                return l;
            }
            q.this.sdk.a(com.applovin.impl.sdk.c.d.aRk, Long.valueOf(this.aDS));
            return null;
        }
    }

    private class e {
        /* access modifiers changed from: private */
        public final Object aEf;
        private final long aEg;

        private e(Object obj, long j) {
            this.aEf = obj;
            this.aEg = EC() + j;
        }

        /* access modifiers changed from: private */
        public boolean isExpired() {
            if (((Boolean) q.this.sdk.a(com.applovin.impl.sdk.c.b.aOp)).booleanValue() && this.aEg - EC() > 0) {
                return false;
            }
            return true;
        }

        private long EC() {
            return System.currentTimeMillis() / 1000;
        }
    }
}
