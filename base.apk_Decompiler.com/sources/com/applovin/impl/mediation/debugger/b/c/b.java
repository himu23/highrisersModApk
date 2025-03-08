package com.applovin.impl.mediation.debugger.b.c;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.privacy.b.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements AppLovinCommunicatorSubscriber, Comparable<b> {
    private final a aoU;
    private int aoV;
    private final boolean aoW;
    private final boolean aoX;
    private final boolean aoY;
    private final boolean aoZ;
    private final boolean aov;
    private final String aow;
    private final boolean apa;
    private final boolean apb;
    private final boolean apc;
    private final boolean apd;
    private final boolean ape;
    private final boolean apf;
    private final boolean apg;
    private final String aph;
    private String api;
    private final String apj;
    private final String apk;
    private final String apl;
    private final String apm;
    private final int apn;
    private final List<MaxAdFormat> apo;
    private final List<c> app;
    private final List<a> apq;
    private final List<String> apr;
    private final List<String> aps;
    private final Map<MaxAdFormat, String> apt;
    private final boolean apu;
    private final c apv;
    private final String apw;
    private final Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.b> apx;
    private final String name;
    private final n sdk;

    public String getAdapterVersion() {
        return this.apj;
    }

    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    public String getDisplayName() {
        return this.aow;
    }

    public String getName() {
        return this.name;
    }

    public final n getSdk() {
        return this.sdk;
    }

    public String getSdkVersion() {
        return this.api;
    }

    public boolean uN() {
        return this.aov;
    }

    public boolean vA() {
        return this.ape;
    }

    public List<c> vB() {
        return this.app;
    }

    public List<a> vC() {
        return this.apq;
    }

    public boolean vD() {
        return this.apg;
    }

    public boolean vE() {
        return this.apu;
    }

    public Map<MaxAdFormat, String> vF() {
        return this.apt;
    }

    public String vG() {
        return this.apl;
    }

    public boolean vH() {
        return this.apf;
    }

    public c vI() {
        return this.apv;
    }

    public String vK() {
        return this.apw;
    }

    public Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.b> vL() {
        return this.apx;
    }

    public a vl() {
        return this.aoU;
    }

    public int vm() {
        return this.aoV;
    }

    public boolean vo() {
        return this.aoW;
    }

    public boolean vp() {
        return this.aoX;
    }

    public boolean vq() {
        return this.aoY;
    }

    public String vs() {
        return this.apk;
    }

    public String vt() {
        return this.aph;
    }

    public String vu() {
        return this.apm;
    }

    public List<String> vv() {
        return this.aps;
    }

    public List<String> vw() {
        return this.apr;
    }

    public int vx() {
        return this.apn;
    }

    public List<MaxAdFormat> vy() {
        return this.apo;
    }

    public boolean vz() {
        return this.apd;
    }

    public enum a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");
        
        private final String apC;

        /* access modifiers changed from: private */
        public String vN() {
            return this.apC;
        }

        private a(String str) {
            this.apC = str;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.b.c.b$b  reason: collision with other inner class name */
    public enum C0073b {
        NOT_SUPPORTED("Not Supported", SupportMenu.CATEGORY_MASK, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", SupportMenu.CATEGORY_MASK, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", SupportMenu.CATEGORY_MASK, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");
        
        private final String apJ;
        private final int apK;
        private final String apL;

        public String vO() {
            return this.apJ;
        }

        public int vP() {
            return this.apK;
        }

        public String vQ() {
            return this.apL;
        }

        private C0073b(String str, int i, String str2) {
            this.apJ = str;
            this.apK = i;
            this.apL = str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x0226 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(org.json.JSONObject r22, com.applovin.impl.sdk.n r23) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.String r4 = "MediatedNetwork"
            r21.<init>()
            r1.sdk = r3
            java.lang.String r0 = "name"
            java.lang.String r5 = ""
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.name = r0
            java.lang.String r0 = "display_name"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.aow = r0
            java.lang.String r6 = "adapter_class"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r6, r5)
            r1.aph = r0
            java.lang.String r0 = "latest_adapter_version"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.apk = r0
            java.util.List r0 = r21.e(r22)
            r1.apr = r0
            r7 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "hide_if_missing"
            java.lang.Boolean r8 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r2, r8, r0)
            boolean r8 = r8.booleanValue()
            r1.apc = r8
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r9 = "configuration"
            org.json.JSONObject r8 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r9, (org.json.JSONObject) r8)
            java.util.List r9 = r1.b(r8, r3)
            r1.app = r9
            java.lang.String r9 = "java_8_required"
            java.lang.Boolean r9 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r8, r9, r0)
            boolean r9 = r9.booleanValue()
            r1.apg = r9
            java.lang.String r9 = "hide_initialization_status"
            java.lang.Boolean r9 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r8, r9, r0)
            boolean r9 = r9.booleanValue()
            r1.apu = r9
            java.lang.String r9 = "live_network_filtering_names"
            r10 = 0
            java.util.List r9 = com.applovin.impl.sdk.utils.JsonUtils.getList(r8, r9, r10)
            r1.aps = r9
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.lang.String r11 = "test_mode"
            org.json.JSONObject r9 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r8, (java.lang.String) r11, (org.json.JSONObject) r9)
            java.lang.String r12 = "false_coppa_required"
            java.lang.Boolean r12 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r9, r12, r0)
            boolean r12 = r12.booleanValue()
            r1.apf = r12
            java.lang.String r12 = "network_names"
            org.json.JSONObject r12 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r9, (java.lang.String) r12, (org.json.JSONObject) r10)
            if (r12 == 0) goto L_0x00cf
            int r13 = r12.length()
            if (r13 <= 0) goto L_0x00cf
            java.util.HashMap r13 = new java.util.HashMap
            int r14 = r12.length()
            r13.<init>(r14)
            java.util.Iterator r14 = r12.keys()
        L_0x00aa:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x00cc
            java.lang.Object r15 = r14.next()
            java.lang.String r15 = (java.lang.String) r15
            com.applovin.mediation.MaxAdFormat r7 = com.applovin.mediation.MaxAdFormat.formatFromString(r15)
            java.lang.String r15 = com.applovin.impl.sdk.utils.JsonUtils.getString(r12, r15, r10)
            if (r7 == 0) goto L_0x00ca
            boolean r17 = android.text.TextUtils.isEmpty(r15)
            if (r17 == 0) goto L_0x00c7
            goto L_0x00ca
        L_0x00c7:
            r13.put(r7, r15)
        L_0x00ca:
            r7 = 0
            goto L_0x00aa
        L_0x00cc:
            r1.apt = r13
            goto L_0x00d1
        L_0x00cf:
            r1.apt = r10
        L_0x00d1:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            org.json.JSONObject r7 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r11, (org.json.JSONObject) r7)
            java.lang.String r11 = "supported"
            r12 = 1
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r12)
            java.lang.Boolean r11 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r7, r11, r13)
            boolean r11 = r11.booleanValue()
            r1.apa = r11
            java.lang.String r11 = "test_mode_requires_init"
            java.lang.Boolean r0 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r2, r11, r0)
            boolean r0 = r0.booleanValue()
            r1.apb = r0
            java.lang.String r0 = "message"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r7, r0, r10)
            r1.apl = r0
            java.lang.String r0 = "tcf_config"
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject(r8, r0)
            com.applovin.impl.privacy.b.c r7 = new com.applovin.impl.privacy.b.c
            java.lang.String r11 = r1.aow
            r7.<init>(r0, r11)
            r1.apv = r7
            java.lang.String r0 = "existence_classes"
            java.util.List r0 = com.applovin.impl.sdk.utils.JsonUtils.getList(r2, r0, r10)
            if (r0 == 0) goto L_0x011d
            boolean r0 = com.applovin.impl.sdk.utils.u.M(r0)
            r1.aoW = r0
            goto L_0x0129
        L_0x011d:
            java.lang.String r0 = "existence_class"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            boolean r0 = com.applovin.impl.sdk.utils.u.dE(r0)
            r1.aoW = r0
        L_0x0129:
            java.util.List r7 = java.util.Collections.emptyList()
            java.lang.String r0 = r1.aph
            com.applovin.mediation.adapter.MaxAdapter r0 = com.applovin.impl.mediation.e.c.b(r0, r3)
            if (r0 == 0) goto L_0x01ec
            r1.aoX = r12
            java.lang.String r11 = r0.getAdapterVersion()     // Catch:{ all -> 0x018c }
            java.lang.String r13 = r0.getSdkVersion()     // Catch:{ all -> 0x0189 }
            if (r13 == 0) goto L_0x0146
            java.lang.String r13 = r0.getSdkVersion()     // Catch:{ all -> 0x0189 }
            goto L_0x0147
        L_0x0146:
            r13 = r5
        L_0x0147:
            java.lang.String r14 = "is_mrec_supported"
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0187 }
            java.lang.Boolean r9 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r9, r14, r15)     // Catch:{ all -> 0x0187 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0187 }
            java.util.List r7 = r1.a(r0, r9)     // Catch:{ all -> 0x0187 }
            java.lang.String r9 = "native_ad_view_config"
            org.json.JSONObject r9 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r8, (java.lang.String) r9, (org.json.JSONObject) r10)     // Catch:{ all -> 0x0187 }
            if (r9 == 0) goto L_0x017d
            java.lang.String r14 = "min_adapter_version"
            java.lang.String r14 = com.applovin.impl.sdk.utils.JsonUtils.getString(r9, r14, r10)     // Catch:{ all -> 0x0187 }
            if (r14 == 0) goto L_0x0172
            int r14 = com.applovin.impl.sdk.utils.u.M(r11, r14)     // Catch:{ all -> 0x0187 }
            if (r14 < 0) goto L_0x0170
            goto L_0x0172
        L_0x0170:
            r14 = 0
            goto L_0x0173
        L_0x0172:
            r14 = 1
        L_0x0173:
            java.lang.String r15 = "network_name"
            java.lang.String r9 = com.applovin.impl.sdk.utils.JsonUtils.getString(r9, r15, r10)     // Catch:{ all -> 0x017a }
            goto L_0x017f
        L_0x017a:
            r0 = move-exception
            r9 = r10
            goto L_0x0191
        L_0x017d:
            r9 = r10
            r14 = 0
        L_0x017f:
            boolean r0 = r0.isBeta()     // Catch:{ all -> 0x0185 }
            r10 = r0
            goto L_0x01ad
        L_0x0185:
            r0 = move-exception
            goto L_0x0191
        L_0x0187:
            r0 = move-exception
            goto L_0x018f
        L_0x0189:
            r0 = move-exception
            r13 = r5
            goto L_0x018f
        L_0x018c:
            r0 = move-exception
            r11 = r5
            r13 = r11
        L_0x018f:
            r9 = r10
            r14 = 0
        L_0x0191:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r10 = "Failed to load adapter for network "
            r15.<init>(r10)
            java.lang.String r10 = r1.name
            r15.append(r10)
            java.lang.String r10 = ". Please check that you have a compatible network SDK integrated. Error: "
            r15.append(r10)
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            com.applovin.impl.sdk.x.H(r4, r0)
            r10 = 0
        L_0x01ad:
            java.lang.String r0 = r1.aph     // Catch:{ all -> 0x01d7 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x01d7 }
            java.lang.String r15 = "loadNativeAd"
            r12 = 3
            java.lang.Class[] r12 = new java.lang.Class[r12]     // Catch:{ all -> 0x01d7 }
            java.lang.Class<com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters> r19 = com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters.class
            r16 = 0
            r12[r16] = r19     // Catch:{ all -> 0x01d7 }
            java.lang.Class<android.app.Activity> r19 = android.app.Activity.class
            r18 = 1
            r12[r18] = r19     // Catch:{ all -> 0x01d7 }
            java.lang.Class<com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener> r19 = com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener.class
            r20 = 2
            r12[r20] = r19     // Catch:{ all -> 0x01d7 }
            java.lang.reflect.Method r12 = r0.getMethod(r15, r12)     // Catch:{ all -> 0x01d7 }
            java.lang.Class r12 = r12.getDeclaringClass()     // Catch:{ all -> 0x01d7 }
            boolean r0 = r12.equals(r0)     // Catch:{ all -> 0x01d7 }
            goto L_0x01f5
        L_0x01d7:
            r0 = move-exception
            r23.BN()
            boolean r12 = com.applovin.impl.sdk.x.Fn()
            if (r12 == 0) goto L_0x01ea
            com.applovin.impl.sdk.x r12 = r23.BN()
            java.lang.String r15 = "Failed to check if adapter overrides MaxNativeAdAdapter"
            r12.c(r4, r15, r0)
        L_0x01ea:
            r0 = 0
            goto L_0x01f5
        L_0x01ec:
            r4 = 0
            r1.aoX = r4
            r11 = r5
            r13 = r11
            r0 = 0
            r9 = 0
            r10 = 0
            r14 = 0
        L_0x01f5:
            r1.apj = r11
            r1.api = r13
            r1.apo = r7
            r1.apd = r0
            r1.ape = r14
            r1.apm = r9
            java.util.List r0 = r1.a(r8, r11, r3)
            r1.apq = r0
            java.lang.String r0 = "alternative_network"
            r4 = 0
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r0, (org.json.JSONObject) r4)
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r0, r6, r5)
            boolean r0 = com.applovin.impl.sdk.utils.u.dE(r0)
            r1.aoZ = r0
            com.applovin.impl.mediation.debugger.b.c.b$a r0 = r21.vM()
            r1.aoU = r0
            java.lang.String r0 = r1.apk
            boolean r0 = r11.equals(r0)
            if (r0 != 0) goto L_0x022a
            if (r10 != 0) goto L_0x022a
            r0 = 1
            goto L_0x022b
        L_0x022a:
            r0 = 0
        L_0x022b:
            r1.aoY = r0
            android.content.Context r0 = com.applovin.impl.sdk.n.getApplicationContext()
            java.lang.String r2 = r1.name
            java.lang.String r4 = "_"
            int r2 = r2.lastIndexOf(r4)
            r4 = -1
            if (r2 == r4) goto L_0x0248
            java.lang.String r4 = r1.name
            java.lang.String r4 = r4.toLowerCase()
            r5 = 0
            java.lang.String r2 = r4.substring(r5, r2)
            goto L_0x024e
        L_0x0248:
            java.lang.String r2 = r1.name
            java.lang.String r2 = r2.toLowerCase()
        L_0x024e:
            android.content.res.Resources r4 = r0.getResources()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "applovin_ic_mediation_"
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r5 = "drawable"
            java.lang.String r6 = r0.getPackageName()
            int r2 = r4.getIdentifier(r2, r5, r6)
            r1.apn = r2
            com.applovin.mediation.adapter.MaxAdapter$InitializationStatus r2 = com.applovin.mediation.adapter.MaxAdapter.InitializationStatus.NOT_INITIALIZED
            int r2 = r2.getCode()
            r1.aoV = r2
            com.applovin.communicator.AppLovinCommunicator r0 = com.applovin.communicator.AppLovinCommunicator.getInstance(r0)
            java.lang.String r2 = "adapter_initialization_status"
            r0.subscribe((com.applovin.communicator.AppLovinCommunicatorSubscriber) r1, (java.lang.String) r2)
            com.applovin.impl.mediation.e r0 = r23.Cx()
            java.util.LinkedHashMap r0 = r0.tV()
            java.lang.String r2 = r1.aph
            boolean r2 = r0.containsKey(r2)
            if (r2 == 0) goto L_0x029b
            java.lang.String r2 = r1.aph
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r1.aoV = r0
        L_0x029b:
            java.lang.String r0 = "amazon_marketplace"
            r2 = 0
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r8, (java.lang.String) r0, (org.json.JSONObject) r2)
            if (r0 == 0) goto L_0x02fa
            boolean r3 = r1.aoW
            if (r3 == 0) goto L_0x02fa
            r3 = 1
            r1.aov = r3
            java.lang.String r3 = "test_mode_app_id"
            java.lang.String r3 = com.applovin.impl.sdk.utils.JsonUtils.getString(r0, r3, r2)
            r1.apw = r3
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "test_mode_slot_ids"
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r0, (java.lang.String) r3, (org.json.JSONObject) r2)
            java.util.HashMap r2 = new java.util.HashMap
            int r3 = r0.length()
            r2.<init>(r3)
            java.util.Iterator r3 = r0.keys()
        L_0x02cb:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02f7
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.applovin.mediation.MaxAdFormat r5 = com.applovin.mediation.MaxAdFormat.formatFromString(r4)
            r6 = 0
            org.json.JSONObject r4 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r0, (java.lang.String) r4, (org.json.JSONObject) r6)
            if (r5 == 0) goto L_0x02cb
            if (r4 != 0) goto L_0x02e5
            goto L_0x02cb
        L_0x02e5:
            java.lang.String r7 = "uuid"
            java.lang.String r7 = com.applovin.impl.sdk.utils.JsonUtils.getString(r4, r7, r6)
            if (r7 != 0) goto L_0x02ee
            goto L_0x02cb
        L_0x02ee:
            com.applovin.impl.mediation.debugger.a.b r6 = new com.applovin.impl.mediation.debugger.a.b
            r6.<init>(r7, r4, r5)
            r2.put(r5, r6)
            goto L_0x02cb
        L_0x02f7:
            r1.apx = r2
            goto L_0x0302
        L_0x02fa:
            r2 = 0
            r1.aov = r2
            r2 = 0
            r1.apw = r2
            r1.apx = r2
        L_0x0302:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.b.c.b.<init>(org.json.JSONObject, com.applovin.impl.sdk.n):void");
    }

    public C0073b vn() {
        if (!this.apa) {
            return C0073b.NOT_SUPPORTED;
        }
        if (this.aoU != a.COMPLETE && (this.aoU != a.INCOMPLETE_INTEGRATION || !vo() || !vp())) {
            return C0073b.INVALID_INTEGRATION;
        }
        if (!this.sdk.CE().isEnabled()) {
            return C0073b.DISABLED;
        }
        if (!this.apb || (this.aoV != MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() && this.aoV != MaxAdapter.InitializationStatus.INITIALIZING.getCode())) {
            return C0073b.READY;
        }
        return C0073b.NOT_INITIALIZED;
    }

    public boolean vr() {
        return this.aoU == a.MISSING && this.apc;
    }

    public final String vJ() {
        StringBuilder sb = new StringBuilder("\n---------- ");
        sb.append(this.name);
        sb.append(" ----------\nStatus  - ");
        sb.append(this.aoU.vN());
        sb.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        sb.append((!this.aoW || TextUtils.isEmpty(this.api)) ? str : this.api);
        sb.append("\nAdapter - ");
        if (this.aoX && !TextUtils.isEmpty(this.apj)) {
            str = this.apj;
        }
        sb.append(str);
        for (c next : vB()) {
            if (!next.vk()) {
                sb.append("\n* MISSING ");
                sb.append(next.getName());
                sb.append(": ");
                sb.append(next.vj());
            }
        }
        for (a next2 : vC()) {
            if (!next2.vk()) {
                sb.append("\n* MISSING ");
                sb.append(next2.getName());
                sb.append(": ");
                sb.append(next2.vj());
            }
        }
        return sb.toString();
    }

    private a vM() {
        a aVar;
        if (this.aoW) {
            if (this.aoX) {
                aVar = a.COMPLETE;
            } else if (this.aoZ) {
                aVar = a.MISSING;
            } else {
                aVar = a.INCOMPLETE_INTEGRATION;
            }
        } else if (this.aoX) {
            aVar = a.INCOMPLETE_INTEGRATION;
        } else {
            aVar = a.MISSING;
        }
        if (aVar == a.MISSING) {
            return aVar;
        }
        for (c vk : this.app) {
            if (!vk.vk()) {
                return a.INVALID_INTEGRATION;
            }
        }
        for (a vk2 : this.apq) {
            if (!vk2.vk()) {
                return a.INVALID_INTEGRATION;
            }
        }
        return (!this.apg || n.CI()) ? aVar : a.INVALID_INTEGRATION;
    }

    private List<MaxAdFormat> a(MaxAdapter maxAdapter, boolean z) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAppOpenAdapter) {
            arrayList.add(MaxAdFormat.APP_OPEN);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxRewardedInterstitialAdapter) {
            arrayList.add(MaxAdFormat.REWARDED_INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            if (z) {
                arrayList.add(MaxAdFormat.MREC);
            }
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    private List<c> b(JSONObject jSONObject, n nVar) {
        ArrayList arrayList = new ArrayList();
        if (this.aph.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            c cVar = new c("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", n.getApplicationContext());
            if (cVar.vk()) {
                arrayList.add(cVar);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                arrayList.add(new c(next, jSONObject2.getString(next), n.getApplicationContext()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private List<String> e(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", (JSONArray) null), (List) null);
    }

    private List<a> a(JSONObject jSONObject, String str, n nVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new a(jSONObject2, nVar));
            }
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null);
            if (jSONObject3 != null && a.a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", (String) null), JsonUtils.getString(jSONObject3, "max_adapter_version", (String) null))) {
                arrayList.add(new a(jSONObject3, nVar));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        return this.aow.compareToIgnoreCase(bVar.aow);
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.name + ", displayName=" + this.aow + ", sdkAvailable=" + this.aoW + ", sdkVersion=" + this.api + ", adapterAvailable=" + this.aoX + ", adapterVersion=" + this.apj + "}";
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.aph.equals(string)) {
            this.aoV = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter b = com.applovin.impl.mediation.e.c.b(string, this.sdk);
            if (b != null && !this.api.equals(b.getSdkVersion())) {
                this.api = b.getSdkVersion();
                this.sdk.Ch().A(this.api, string);
            }
        }
    }
}
