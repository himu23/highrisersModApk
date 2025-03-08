package com.applovin.impl.mediation.debugger.ui.b;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.debugger.a;
import com.applovin.impl.mediation.debugger.b.c.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.ironsource.z3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte$$ExternalSyntheticBackport0;

public class b extends com.applovin.impl.mediation.debugger.ui.d.d implements AppLovinCommunicatorSubscriber, a.C0071a {
    private final AtomicBoolean akD = new AtomicBoolean();
    private String apL;
    private List<com.applovin.impl.mediation.debugger.b.a.a> aqQ;
    private List<com.applovin.impl.mediation.debugger.b.a.a> aqR;
    private List<com.applovin.impl.mediation.debugger.b.b.b> aqS;
    private String aqT;
    private String aqU;
    private Boolean aqV;
    private boolean aqW;
    private final StringBuilder aqX = new StringBuilder("");
    private boolean aqY = false;
    private List<com.applovin.impl.mediation.debugger.b.c.b> aqZ = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.c.b> ara = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.c.b> arb = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.a.c> arc = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.a.c> ard = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.c.b> are = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.ui.d.c> arf = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.ui.d.c> arg = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.ui.d.c> arh = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.ui.d.c> ari = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.ui.d.c> arj = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.ui.d.c> ark = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.ui.d.c> arl = new ArrayList();
    private n sdk;

    public enum a {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        SELECT_TEST_MODE_NETWORKS,
        INITIALIZATION_AD_UNITS,
        COUNT
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$b  reason: collision with other inner class name */
    private enum C0076b {
        SUCCESS,
        WARNING,
        ERROR
    }

    public enum c {
        SDK_VERSION,
        PLUGIN_VERSION,
        AD_REVIEW_VERSION,
        CONSENT_FLOW_TYPE,
        GOOGLE_UMP_SDK,
        PRIVACY_POLICY_URL,
        TERMS_OF_SERVICE_URL,
        APP_ADS_TXT
    }

    public enum d {
        CMP,
        NETWORK_CONSENT_STATUSES,
        IS_AGE_RESTRICTED_USER,
        DO_NOT_SELL,
        COUNT
    }

    public enum e {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public void az(boolean z) {
        this.aqY = z;
    }

    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    public n getSdk() {
        return this.sdk;
    }

    public String vQ() {
        return this.apL;
    }

    public boolean wh() {
        return this.aqY;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.a> wi() {
        return this.aqQ;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.a> wj() {
        return this.aqR;
    }

    public String wk() {
        return this.aqT;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.c> wl() {
        return this.arc;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.c> wm() {
        return this.ard;
    }

    public List<com.applovin.impl.mediation.debugger.b.c.b> wn() {
        return this.are;
    }

    public b(Context context) {
        super(context);
    }

    public boolean isInitialized() {
        return this.akD.get();
    }

    public String wo() {
        return this.aqX.toString();
    }

    public void a(List<com.applovin.impl.mediation.debugger.b.c.b> list, List<com.applovin.impl.mediation.debugger.b.a.a> list2, List<com.applovin.impl.mediation.debugger.b.a.a> list3, List<com.applovin.impl.mediation.debugger.b.b.b> list4, String str, String str2, String str3, Boolean bool, boolean z, n nVar) {
        this.sdk = nVar;
        this.aqQ = list2;
        this.aqR = list3;
        this.aqS = list4;
        this.aqT = str;
        this.apL = str2;
        this.aqU = str3;
        this.aqV = bool;
        this.aqW = z;
        if (list != null && this.akD.compareAndSet(false, true)) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().f("MediationDebuggerListAdapter", "Populating networks...");
            }
            nVar.Cm().F(list);
            t(list);
            u(list2);
            v(this.ara);
            this.arf.addAll(wq());
            this.arg.addAll(wr());
            this.arh.addAll(ws());
            this.ari.addAll(wt());
            this.arj = w(this.aqZ);
            this.ark = w(this.ara);
            this.arl = w(this.arb);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            arrayList.add("live_networks_updated");
            arrayList.add("test_mode_networks_updated");
            AppLovinCommunicator.getInstance(this.E).subscribe((AppLovinCommunicatorSubscriber) this, (List<String>) arrayList);
            wp();
        }
        AppLovinSdkUtils.runOnUiThread(new b$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: protected */
    public int tM() {
        return e.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public int gg(int i) {
        if (i == e.APP_INFO.ordinal()) {
            return this.arf.size();
        }
        if (i == e.MAX.ordinal()) {
            return this.arg.size();
        }
        if (i == e.PRIVACY.ordinal()) {
            return this.arh.size();
        }
        if (i == e.ADS.ordinal()) {
            return this.ari.size();
        }
        if (i == e.INCOMPLETE_NETWORKS.ordinal()) {
            return this.arj.size();
        }
        if (i == e.COMPLETED_NETWORKS.ordinal()) {
            return this.ark.size();
        }
        return this.arl.size();
    }

    /* access modifiers changed from: protected */
    public com.applovin.impl.mediation.debugger.ui.d.c gh(int i) {
        if (i == e.APP_INFO.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("APP INFO");
        }
        if (i == e.MAX.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("MAX");
        }
        if (i == e.PRIVACY.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("PRIVACY");
        }
        if (i == e.ADS.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("ADS");
        }
        if (i == e.INCOMPLETE_NETWORKS.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("INCOMPLETE SDK INTEGRATIONS");
        }
        if (i == e.COMPLETED_NETWORKS.ordinal()) {
            return new com.applovin.impl.mediation.debugger.ui.d.e("COMPLETED SDK INTEGRATIONS");
        }
        return new com.applovin.impl.mediation.debugger.ui.d.e("MISSING SDK INTEGRATIONS");
    }

    /* access modifiers changed from: protected */
    public List<com.applovin.impl.mediation.debugger.ui.d.c> gi(int i) {
        if (i == e.APP_INFO.ordinal()) {
            return this.arf;
        }
        if (i == e.MAX.ordinal()) {
            return this.arg;
        }
        if (i == e.PRIVACY.ordinal()) {
            return this.arh;
        }
        if (i == e.ADS.ordinal()) {
            return this.ari;
        }
        if (i == e.INCOMPLETE_NETWORKS.ordinal()) {
            return this.arj;
        }
        return i == e.COMPLETED_NETWORKS.ordinal() ? this.ark : this.arl;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.arh = ws();
            wZ();
        } else if ("network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.arj = w(this.aqZ);
            this.ark = w(this.ara);
            wZ();
        } else if ("live_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.ari = v(b((List<String>) appLovinCommunicatorMessage.getMessageData().getStringArrayList("live_networks"), true), (String) null);
            wZ();
        } else if ("test_mode_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.ari = v((String) null, b((List<String>) appLovinCommunicatorMessage.getMessageData().getStringArrayList("test_mode_networks"), false));
            wZ();
        }
    }

    public void a(com.applovin.impl.mediation.debugger.b.b.a aVar, String str) {
        C0076b bVar;
        String str2;
        com.applovin.impl.mediation.debugger.b.b.b bVar2;
        ArrayList arrayList = new ArrayList();
        for (com.applovin.impl.mediation.debugger.b.b.b next : this.aqS) {
            List list = aVar.va().get(next.vd());
            if (list == null || !list.contains(next)) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().i("MediationDebuggerListAdapter", str + " is missing a required entry: " + next.vg());
                }
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            str2 = "All required entries found at " + str + ".";
            bVar = C0076b.SUCCESS;
        } else {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = (com.applovin.impl.mediation.debugger.b.b.b) it.next();
                if (bVar2.vc()) {
                    break;
                }
            }
            if (bVar2 != null) {
                str2 = a(a.b.MISSING_APPLOVIN_ENTRIES, str, bVar2.vg());
                bVar = b(a.b.MISSING_APPLOVIN_ENTRIES);
            } else {
                str2 = a(a.b.MISSING_NON_APPLOVIN_ENTRIES, str, (String) null);
                bVar = b(a.b.MISSING_NON_APPLOVIN_ENTRIES);
            }
        }
        this.arg.add(a(str2, bVar));
        wZ();
    }

    public void b(a.b bVar, String str) {
        if (bVar == a.b.DEVELOPER_URI_NOT_FOUND) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("MediationDebuggerListAdapter", "Developer URI was not found; app-ads.txt row will not show on the mediation debugger");
                return;
            }
            return;
        }
        this.arg.add(a(a(bVar, str, (String) null), b(bVar)));
        wZ();
    }

    private void wp() {
        Map<String, String> a2;
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        sb.append("\nDev Build - " + u.b(this.E, this.sdk));
        sb.append("\nTest Mode - ".concat(this.sdk.CE().isEnabled() ? z3.r : "disabled"));
        if (this.sdk.BV() != null) {
            sb.append("\nTarget SDK - " + this.sdk.BU().Ej().Es());
        } else {
            sb.append("\nTarget SDK - " + this.sdk.BS().Db().get("target_sdk"));
        }
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.sdk.a(com.applovin.impl.sdk.c.b.aOD);
        String version = f.getVersion();
        sb.append("\nSDK Version - " + str);
        StringBuilder sb2 = new StringBuilder("\nPlugin Version - ");
        String str3 = "None";
        if (!StringUtils.isValidString(str2)) {
            str2 = str3;
        }
        sb2.append(str2);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder("\nAd Review Version - ");
        if (!StringUtils.isValidString(version)) {
            version = "Disabled";
        }
        sb3.append(version);
        sb.append(sb3.toString());
        if (this.sdk.Bs() && (a2 = u.a(this.sdk.getSettings())) != null) {
            String str4 = a2.get("UnityVersion");
            StringBuilder sb4 = new StringBuilder("\nUnity Version - ");
            if (StringUtils.isValidString(str4)) {
                str3 = str4;
            }
            sb4.append(str3);
            sb.append(sb4.toString());
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(com.applovin.impl.privacy.a.A(this.E));
        sb.append(this.sdk.Cl().uI());
        sb.append("\n========== CMP (CONSENT MANAGEMENT PLATFORM) ==========");
        sb.append(this.sdk.Cm().uI());
        sb.append("\n========== NETWORK CONSENT STATUSES ==========");
        for (com.applovin.impl.privacy.b.c uI : this.sdk.Cm().Au()) {
            sb.append(uI.uI());
        }
        sb.append("\n========== NETWORKS ==========");
        for (com.applovin.impl.mediation.debugger.b.c.b vJ : this.ara) {
            a(sb, vJ.vJ());
        }
        for (com.applovin.impl.mediation.debugger.b.c.b vJ2 : this.aqZ) {
            a(sb, vJ2.vJ());
        }
        sb.append("\n========== AD UNITS ==========");
        for (com.applovin.impl.mediation.debugger.b.a.a uI2 : this.aqQ) {
            a(sb, uI2.uI());
        }
        sb.append("\n========== END ==========");
        x.D("MediationDebuggerListAdapter", sb.toString());
        this.aqX.append(sb.toString());
    }

    private void a(StringBuilder sb, String str) {
        String sb2 = sb.toString();
        if (sb2.length() + str.length() >= ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aKy)).intValue()) {
            x.D("MediationDebuggerListAdapter", sb2);
            this.aqX.append(sb2);
            sb.setLength(1);
        }
        sb.append(str);
    }

    private void t(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        for (com.applovin.impl.mediation.debugger.b.c.b next : list) {
            if (!next.vr()) {
                if (next.vl() == b.a.INCOMPLETE_INTEGRATION || next.vl() == b.a.INVALID_INTEGRATION) {
                    this.aqZ.add(next);
                } else if (next.vl() == b.a.COMPLETE) {
                    this.ara.add(next);
                } else if (next.vl() == b.a.MISSING) {
                    this.arb.add(next);
                }
            }
        }
    }

    private void u(List<com.applovin.impl.mediation.debugger.b.a.a> list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (com.applovin.impl.mediation.debugger.b.a.a uG : list) {
            com.applovin.impl.mediation.debugger.b.a.b uG2 = uG.uG();
            for (com.applovin.impl.mediation.debugger.b.a.e uR : uG2.uL()) {
                hashSet.add(uR.uR());
            }
            for (com.applovin.impl.mediation.debugger.b.a.e uR2 : uG2.uM()) {
                hashSet2.add(uR2.uR());
            }
        }
        this.arc = new ArrayList(hashSet);
        this.ard = new ArrayList(hashSet2);
        Collections.sort(this.arc);
        Collections.sort(this.ard);
    }

    private void v(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        for (com.applovin.impl.mediation.debugger.b.c.b next : list) {
            if (next.vn() == b.C0073b.READY) {
                this.are.add(next);
            }
        }
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> wq() {
        String str;
        ArrayList arrayList = new ArrayList(7);
        try {
            str = this.E.getPackageManager().getPackageInfo(this.E.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Package Name").bP(this.E.getPackageName()).wX());
        c.a bO = com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("App Version");
        String str2 = "None";
        if (!StringUtils.isValidString(str)) {
            str = str2;
        }
        arrayList.add(bO.bP(str).wX());
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("OS").bP(u.LB()).wX());
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Account").bP(StringUtils.isValidString(this.aqU) ? this.aqU : str2).wX());
        c.a bO2 = com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Mediation Provider");
        if (StringUtils.isValidString(this.sdk.getMediationProvider())) {
            str2 = this.sdk.getMediationProvider();
        }
        arrayList.add(bO2.bP(str2).wX());
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("OM SDK Version").bP(this.sdk.Cp().getSdkVersion()).wX());
        arrayList.add(aA(n.CI()));
        if (this.aqV != null) {
            arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Google Families Policy").bP(String.valueOf(this.aqV)).wX());
        }
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> wr() {
        Map<String, String> a2;
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("SDK Version").bP(AppLovinSdk.VERSION).wX());
        String str = (String) this.sdk.a(com.applovin.impl.sdk.c.b.aOD);
        c.a bO = com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Plugin Version");
        String str2 = "None";
        if (!StringUtils.isValidString(str)) {
            str = str2;
        }
        arrayList.add(bO.bP(str).wX());
        c.a bO2 = com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Ad Review Version");
        String version = f.getVersion();
        if (StringUtils.isValidString(version)) {
            String sdkKey = f.getSdkKey();
            if (!StringUtils.isValidString(sdkKey)) {
                bO2.bP(version);
            } else if (sdkKey.equals(this.sdk.getSdkKey())) {
                bO2.bP(version);
            } else {
                StringBuilder sb = new StringBuilder("MAX Ad Review integrated with wrong SDK key. Please check that your ");
                sb.append(this.sdk.Bs() ? "SDK key is downloaded" : "Gradle plugin snippet is integrated");
                sb.append(" from the correct account.");
                a(bO2, sb.toString());
            }
        } else {
            a(bO2, "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps.");
        }
        arrayList.add(bO2.wX());
        if (this.sdk.Bs() && (a2 = u.a(this.sdk.getSettings())) != null) {
            String str3 = a2.get("UnityVersion");
            if (StringUtils.isValidString(str3)) {
                str2 = str3;
            }
            arrayList.add(w("Unity Version", str2));
        }
        if (this.sdk.Cl().isEnabled()) {
            arrayList.add(wu());
            if (this.sdk.Cl().zX() == d.a.UNIFIED) {
                arrayList.add(wv());
            }
            arrayList.add(ww());
            arrayList.add(wx());
        }
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> ws() {
        ArrayList arrayList = new ArrayList(d.COUNT.ordinal());
        arrayList.add(wy());
        if (StringUtils.isValidString(this.sdk.Cm().As())) {
            arrayList.add(wz());
        } else {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(com.applovin.impl.privacy.a.zP(), false, this.E));
        }
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(com.applovin.impl.privacy.a.zO(), true, this.E));
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(com.applovin.impl.privacy.a.zQ(), true, this.E));
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> wt() {
        boolean isEnabled = this.sdk.CE().isEnabled();
        List<String> xk = this.sdk.CE().xk();
        if (isEnabled) {
            return v((String) null, b(xk, false));
        }
        return v(b(xk, true), (String) null);
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> v(String str, String str2) {
        ArrayList arrayList = new ArrayList(3);
        c.a wW = com.applovin.impl.mediation.debugger.ui.d.c.wW();
        arrayList.add(wW.bO("View Ad Units (" + this.aqQ.size() + ")").y(this.E).aF(true).wX());
        arrayList.add(bM(str));
        arrayList.add(bN(str2));
        if (!this.aqR.isEmpty()) {
            c.a wW2 = com.applovin.impl.mediation.debugger.ui.d.c.wW();
            arrayList.add(wW2.bO("Selective Init Ad Units (" + this.aqR.size() + ")").y(this.E).aF(true).wX());
        }
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.ui.d.c> w(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (com.applovin.impl.mediation.debugger.b.c.b aVar : list) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(aVar, this.E));
        }
        return arrayList;
    }

    private com.applovin.impl.mediation.debugger.ui.d.c w(String str, String str2) {
        c.a bO = com.applovin.impl.mediation.debugger.ui.d.c.wW().bO(str);
        if (StringUtils.isValidString(str2)) {
            bO.bP(str2);
        } else {
            bO.gk(R.drawable.applovin_ic_x_mark);
            bO.gn(g.a(R.color.applovin_sdk_xmarkColor, this.E));
        }
        return bO.wX();
    }

    private void a(c.a aVar, String str) {
        aVar.bQ("MAX Ad Review").bR(str).gk(R.drawable.applovin_ic_x_mark).gn(g.a(R.color.applovin_sdk_xmarkColor, this.E)).aF(true);
    }

    private com.applovin.impl.mediation.debugger.ui.d.c bM(String str) {
        c.a wW = com.applovin.impl.mediation.debugger.ui.d.c.wW();
        if (!this.sdk.CE().isEnabled()) {
            wW.y(this.E);
        }
        c.a bO = wW.bO((StringUtils.isValidString(str) ? "" : "Select ").concat("Live Network"));
        if (this.sdk.CE().isEnabled()) {
            str = "Enable";
        }
        return bO.bP(str).gm(-16776961).bR("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").aF(true).wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c bN(String str) {
        c.a wW = com.applovin.impl.mediation.debugger.ui.d.c.wW();
        if (this.sdk.CE().isEnabled()) {
            wW.y(this.E);
        }
        c.a bO = wW.bO((StringUtils.isValidString(str) ? "" : "Select ").concat("Test Mode Network"));
        if (!this.sdk.CE().isEnabled()) {
            str = "Enable";
        }
        return bO.bP(str).gm(-16776961).bR("Please re-launch the app to enable test mode. This will allow the selection of test mode networks.").aF(true).wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c aA(boolean z) {
        return com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Java 8").gk(z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).gn(g.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.E)).bQ("Upgrade to Java 8").bR("For optimal performance, please enable Java 8 support. This will be required in a future SDK release. See: https://dash.applovin.com/documentation/mediation/android/getting-started/integration").aF(!z).wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wu() {
        boolean z = this.sdk.Cl().zX() == d.a.TERMS;
        return com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.DETAIL).bO("Flow Type").bP(z ? "MAX Terms Flow" : "MAX Terms and Privacy Policy Flow").gk(z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_check_mark_bordered).gn(g.a(z ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_checkmarkColor, this.E)).bQ("MAX Terms Flow").bR("MAX Terms Flow is deprecated and will be removed in a future SDK version. For more details, see:\nhttps://dash.applovin.com/documentation/mediation/android/getting-started/terms-and-privacy-policy-flow").aF(z).wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wv() {
        boolean hasSupportedCmp = this.sdk.Cn().hasSupportedCmp();
        return com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Google UMP SDK").gk(hasSupportedCmp ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).gn(g.a(hasSupportedCmp ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.E)).bQ("Google UMP SDK").bR("In order to use MAX Terms and Privacy Policy Flow, you must add the Google User Messaging Platform SDK as a dependency. For more details, see:\nhttps://dash.applovin.com/documentation/mediation/android/getting-started/terms-and-privacy-policy-flow\"").aF(!hasSupportedCmp).wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c ww() {
        boolean z = this.sdk.Cl().getPrivacyPolicyUri() != null;
        return com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Privacy Policy URL").gk(z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).gn(g.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.E)).aF(true).wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wx() {
        c.a bO = com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Terms of Service URL");
        if (this.sdk.Cl().getTermsOfServiceUri() != null) {
            bO.gk(R.drawable.applovin_ic_check_mark_bordered);
            bO.gn(g.a(R.color.applovin_sdk_checkmarkColor, this.E));
            bO.aF(true);
        } else {
            bO.bP("None");
            bO.aF(false);
        }
        return bO.wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c a(String str, C0076b bVar) {
        int i;
        int i2;
        if (bVar == C0076b.SUCCESS) {
            i = R.drawable.applovin_ic_check_mark_bordered;
            i2 = g.a(R.color.applovin_sdk_checkmarkColor, this.E);
        } else if (bVar == C0076b.WARNING) {
            i = R.drawable.applovin_ic_warning;
            i2 = g.a(R.color.applovin_sdk_warningColor, this.E);
        } else {
            i = R.drawable.applovin_ic_x_mark;
            i2 = g.a(R.color.applovin_sdk_xmarkColor, this.E);
        }
        return com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("app-ads.txt").gk(i).gn(i2).bQ("app-ads.txt").bR(str).aF(true).wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wy() {
        int i;
        String Am = this.sdk.Cm().Am();
        boolean isValidString = StringUtils.isValidString(Am);
        c.a a2 = com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.DETAIL);
        a2.bO("CMP (Consent Management Platform)");
        if (!isValidString) {
            Am = "None";
        }
        a2.bP(Am);
        if (this.aqW) {
            boolean z = true;
            a2.aF(true);
            if (isValidString) {
                a2.y(this.E);
            } else {
                Integer Ap = this.sdk.Cm().Ap();
                String str = "SharedPreferences value for key IABTCF_CmpSdkID is " + Ap + ".";
                if (Ap == null || Ap.intValue() == 0) {
                    a2.bR("No CMP found. " + str + "\n\nBy January 16, 2024, if you use Google AdMob or Google Ad Manager, you must also use a Google-certified CMP. Test your app in EEA and UK regions to ensure that this warning doesn't appear in those regions.\n\nFor more details, see:\nhttps://support.google.com/admob/answer/13554116");
                    if (this.sdk.getConfiguration().getConsentFlowUserGeography() != AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR) {
                        z = false;
                    }
                    a2.gk(z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning);
                    if (z) {
                        i = R.color.applovin_sdk_xmarkColor;
                    } else {
                        i = R.color.applovin_sdk_warningColor;
                    }
                    a2.gn(g.a(i, this.E));
                } else {
                    a2.bR("Your integrated CMP might not be Google-certified. " + str + "\n\nBy January 16, 2024, if you use Google AdMob or Google Ad Manager, you must also use a Google-certified CMP. Test your app in EEA and UK regions to ensure that this warning doesn't appear in those regions.\n\nFor more details, see:\nhttps://support.google.com/admob/answer/13554116");
                    a2.gk(R.drawable.applovin_ic_warning);
                    a2.gn(g.a(R.color.applovin_sdk_warningColor, this.E));
                }
            }
        }
        return a2.wX();
    }

    private com.applovin.impl.mediation.debugger.ui.d.c wz() {
        return com.applovin.impl.mediation.debugger.ui.d.c.wW().bO("Network Consent Statuses").y(this.E).aF(true).wX();
    }

    private String a(a.b bVar, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "app-ads.txt URL";
        }
        int i = AnonymousClass1.arm[bVar.ordinal()];
        if (i == 1) {
            return "Could not retrieve developer website from the Play Store for this package name. Check back once this app has been published on the Play Store.";
        }
        if (i == 2) {
            return "Unable to find app-ads.txt file or parse entries of the file at " + str + ".\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        } else if (i == 3) {
            return "Text file at " + str + " is missing the required AppLovin line:\n\n" + str2 + "\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        } else if (i != 4) {
            return "";
        } else {
            return "Text file at " + str + " is missing some of the suggested lines.\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] arm;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.applovin.impl.mediation.debugger.a$b[] r0 = com.applovin.impl.mediation.debugger.a.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                arm = r0
                com.applovin.impl.mediation.debugger.a$b r1 = com.applovin.impl.mediation.debugger.a.b.DEVELOPER_URI_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = arm     // Catch:{ NoSuchFieldError -> 0x001d }
                com.applovin.impl.mediation.debugger.a$b r1 = com.applovin.impl.mediation.debugger.a.b.APPADSTXT_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = arm     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.applovin.impl.mediation.debugger.a$b r1 = com.applovin.impl.mediation.debugger.a.b.MISSING_APPLOVIN_ENTRIES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = arm     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.applovin.impl.mediation.debugger.a$b r1 = com.applovin.impl.mediation.debugger.a.b.MISSING_NON_APPLOVIN_ENTRIES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.ui.b.b.AnonymousClass1.<clinit>():void");
        }
    }

    private C0076b b(a.b bVar) {
        int i = AnonymousClass1.arm[bVar.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return C0076b.ERROR;
        }
        if (i != 4) {
            return C0076b.ERROR;
        }
        return C0076b.WARNING;
    }

    private String b(List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (z) {
            for (com.applovin.impl.mediation.debugger.b.a.c next : this.arc) {
                if (list.equals(next.uO())) {
                    return next.getDisplayName();
                }
            }
            for (com.applovin.impl.mediation.debugger.b.a.c next2 : this.ard) {
                if (list.equals(next2.uO())) {
                    return next2.getDisplayName();
                }
            }
        } else {
            for (com.applovin.impl.mediation.debugger.b.c.b next3 : this.are) {
                if (list.equals(Collections.singletonList(next3.getName()))) {
                    return next3.getDisplayName();
                }
            }
        }
        return UByte$$ExternalSyntheticBackport0.m((CharSequence) ",", (Iterable) list);
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.akD.get() + "}";
    }
}
