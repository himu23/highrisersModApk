package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.ironsource.bc;
import com.ironsource.c7;
import com.ironsource.environment.StringUtils;
import com.ironsource.g2;
import com.ironsource.g9;
import com.ironsource.ga;
import com.ironsource.m;
import com.ironsource.m1;
import com.ironsource.m2;
import com.ironsource.m3;
import com.ironsource.ma;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.na;
import com.ironsource.q9;
import com.ironsource.t4;
import com.ironsource.tb;
import com.ironsource.z3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static final String W1 = "appKey";
    public static final String X1 = "userId";
    public static final String Y1 = "response";
    private final boolean A = false;
    private final String A0 = "sendUltraEvents";
    private final String A1 = IronSourceConstants.AUCTION_TRIALS;
    private final long B = 3000;
    private final String B0 = "sendEventsToggle";
    private final String B1 = "auctionTimeout";
    private final boolean C = false;
    private final String C0 = "eventsCompression";
    private final String C1 = "auctionSavedHistory";
    private final boolean D = false;
    private final String D0 = "eventsCompressionLevel";
    private final String D1 = "disableLoadWhileShowSupportFor";
    private final int E = 30000;
    private final String E0 = "serverEventsURL";
    private final String E1 = "timeToDeleteOldWaterfallAfterAuction";
    private final int F = -1;
    private final String F0 = "serverEventsType";
    private final String F1 = "compressAuctionRequest";
    private final int G = 5000;
    private final String G0 = "backupThreshold";
    private final String G1 = "compressAuctionResponse";
    private final int H = 1;
    private final String H0 = "maxNumberOfEvents";
    private final String H1 = "encryptionVersion";
    private final boolean I = false;
    private final String I0 = "maxEventsPerBatch";
    private final String I1 = "shouldSendBannerBURLFromImpression";
    private final String J = "providerOrder";
    private final String J0 = "optOut";
    private final String J1 = "optInKeys";
    private final String K = "providerSettings";
    private final String K0 = "optIn";
    private final String K1 = "tokenGenericParams";
    private final String L = d.i;
    private final String L0 = "triggerEvents";
    private final String L1 = "oneToken";
    private final String M = "genericParams";
    private final String M0 = "nonConnectivityEvents";
    private final String M1 = "compressToken";
    private final String N = "adUnits";
    private final String N0 = "shouldSendPublisherLogsOnUIThread";
    private final String N1 = "compressExternalToken";
    private final String O = "providerLoadName";
    private final String O0 = "pixel";
    private ma O1;
    private final String P = m2.h.F;
    private final String P0 = "pixelEventsUrl";
    private na P1;
    private final String Q = "rewardedVideo";
    private final String Q0 = "pixelEventsEnabled";
    private g2 Q1;
    private final String R = IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE;
    private final String R0 = "placements";
    private String R1;
    private final String S = "offerwall";
    private final String S0 = m2.i;
    private String S1;
    private final String T = "banner";
    private final String T0 = "placementName";
    private JSONObject T1;
    private final String U = "nativeAd";
    private final String U0 = "delivery";
    private Context U1;
    private final String V = "integration";
    private final String V0 = "isDefault";
    private a V1 = a.NOT_SET;
    private final String W = "loggers";
    private final String W0 = "capping";
    private final String X = "segment";
    private final String X0 = "pacing";
    private final String Y = "events";
    private final String Y0 = z3.r;
    private final String Z = "crashReporter";
    private final String Z0 = "maxImpressions";
    private final String a = "error";
    private final String a0 = IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY;
    private final String a1 = "numOfSeconds";
    private final int b = 3;
    private final String b0 = "external";
    private final String b1 = "unit";
    private final boolean c = false;
    private final String c0 = "mediationTypes";
    private final String c1 = "virtualItemName";
    private final boolean d = true;
    private final String d0 = "providerDefaultInstance";
    private final String d1 = "virtualItemCount";
    private final boolean e = false;
    private final String e0 = "testSuite";
    private final String e1 = m3.n;
    private final boolean f = true;
    private final String f0 = tb.b;
    private final String f1 = t4.r0;
    private final int g = 2;
    private final String g0 = "AdQuality";
    private final String g1 = "delayLoadFailure";
    private final int h = 2;
    private final String h0 = "initSDK";
    private final String h1 = "keysToInclude";
    private final int i = 1;
    private final String i0 = d.f;
    private final String i1 = "reporterURL";
    private final int j = 1;
    private final String j0 = "collectBiddingDataTimeout";
    private final String j1 = "reporterKeyword";
    private final boolean k = true;
    private final String k0 = "collectBiddingDataAsyncEnabled";
    private final String k1 = "includeANR";
    private final boolean l = false;
    private final String l0 = "providers";
    private final String l1 = "timeout";
    private final boolean m = false;
    private final String m0 = "parallelInit";
    private final String m1 = "setIgnoreDebugger";
    private final boolean n = false;
    private final String n0 = "waitUntilAllProvidersFinishInit";
    private final String n1 = "adSourceName";
    private final int o = 60;
    private final String o0 = "threadPerManager";
    private final String o1 = IronSourceConstants.EVENTS_SUB_PROVIDER_ID;
    private final int p = 10000;
    private final String p0 = "sharedManagersThread";
    private final String p1 = "mpis";
    private final int q = 10000;
    private final String q0 = d.n0;
    private final String q1 = "auction";
    private final int r = -1;
    private final String r0 = d.o0;
    private final String r1 = "auctionData";
    private final int s = 5000;
    private final String s0 = "adapterTimeOutInSeconds";
    private final String s1 = "auctioneerURL";
    private final int t = 3;
    private final String t0 = "atim";
    private final String t1 = "extAuctioneerURL";
    private final int u = 3;
    private final String u0 = "bannerInterval";
    private final String u1 = "objectPerWaterfall";
    private final int v = 3;
    private final String v0 = "isOneFlow";
    private final String v1 = "minTimeBeforeFirstAuction";
    private final int w = 0;
    private final String w0 = "expiredDurationInMinutes";
    private final String w1 = "timeToWaitBeforeAuction";
    private final int x = 2;
    private final String x0 = "server";
    private final String x1 = "timeToWaitBeforeLoad";
    private final int y = 15;
    private final String y0 = "publisher";
    private final String y1 = "auctionRetryInterval";
    private final long z = 10000;
    private final String z0 = com.ironsource.mediationsdk.logger.a.c;
    private final String z1 = "isLoadWhileShow";

    public enum a {
        NOT_SET,
        CACHE,
        SERVER
    }

    public c(Context context, String str, String str2, String str3) {
        this.U1 = context;
        try {
            this.T1 = TextUtils.isEmpty(str3) ? new JSONObject() : new JSONObject(str3);
            p();
            n();
            o();
            this.R1 = TextUtils.isEmpty(str) ? "" : str;
            this.S1 = TextUtils.isEmpty(str2) ? "" : str2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            a();
        }
    }

    public c(c cVar) {
        try {
            this.U1 = cVar.c();
            this.T1 = new JSONObject(cVar.T1.toString());
            this.R1 = cVar.R1;
            this.S1 = cVar.S1;
            this.O1 = cVar.h();
            this.P1 = cVar.i();
            this.Q1 = cVar.b();
            this.V1 = cVar.f();
        } catch (Exception unused) {
            a();
        }
    }

    private int a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i2) {
        int i3 = 0;
        if (jSONObject.has(str)) {
            i3 = jSONObject.optInt(str, 0);
        } else if (jSONObject2.has(str)) {
            i3 = jSONObject2.optInt(str, 0);
        }
        return i3 == 0 ? i2 : i3;
    }

    private long a(JSONObject jSONObject, JSONObject jSONObject2, String str, long j2) {
        long optLong = jSONObject.has(str) ? jSONObject.optLong(str, 0) : jSONObject2.has(str) ? jSONObject2.optLong(str, 0) : 0;
        return optLong == 0 ? j2 : optLong;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r7.toString().equals(r6) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ironsource.ga a(org.json.JSONObject r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.ironsource.ga$b r1 = new com.ironsource.ga$b
            r1.<init>()
            java.lang.String r2 = "delivery"
            r3 = 1
            boolean r2 = r10.optBoolean(r2, r3)
            r1.a(r2)
            java.lang.String r2 = "capping"
            org.json.JSONObject r2 = r10.optJSONObject(r2)
            java.lang.String r4 = "enabled"
            r5 = 0
            if (r2 == 0) goto L_0x0059
            java.lang.String r6 = "unit"
            java.lang.String r6 = r2.optString(r6)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0045
            com.ironsource.ha r7 = com.ironsource.ha.PER_DAY
            java.lang.String r8 = r7.toString()
            boolean r8 = r8.equals(r6)
            if (r8 == 0) goto L_0x0038
        L_0x0036:
            r0 = r7
            goto L_0x0045
        L_0x0038:
            com.ironsource.ha r7 = com.ironsource.ha.PER_HOUR
            java.lang.String r8 = r7.toString()
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x0045
            goto L_0x0036
        L_0x0045:
            java.lang.String r6 = "maxImpressions"
            int r6 = r2.optInt(r6, r5)
            boolean r2 = r2.optBoolean(r4, r5)
            if (r2 == 0) goto L_0x0055
            if (r6 <= 0) goto L_0x0055
            r2 = 1
            goto L_0x0056
        L_0x0055:
            r2 = 0
        L_0x0056:
            r1.a(r2, r0, r6)
        L_0x0059:
            java.lang.String r0 = "pacing"
            org.json.JSONObject r10 = r10.optJSONObject(r0)
            if (r10 == 0) goto L_0x0074
            java.lang.String r0 = "numOfSeconds"
            int r0 = r10.optInt(r0, r5)
            boolean r10 = r10.optBoolean(r4, r5)
            if (r10 == 0) goto L_0x0070
            if (r0 <= 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r3 = 0
        L_0x0071:
            r1.a(r3, r0)
        L_0x0074:
            com.ironsource.ga r10 = r1.a()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.c.a(org.json.JSONObject):com.ironsource.ga");
    }

    public static a a(c cVar) {
        return cVar != null ? cVar.f() : a.NOT_SET;
    }

    private void a() {
        this.T1 = new JSONObject();
        this.R1 = "";
        this.S1 = "";
        this.O1 = new ma();
        this.P1 = na.c();
        this.Q1 = new g2.a().a();
    }

    private boolean a(String str) {
        String lowerCase = StringUtils.toLowerCase(str);
        return this.P1.a("Mediation") && (StringUtils.toLowerCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME).equals(lowerCase) || StringUtils.toLowerCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME).equals(lowerCase));
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str, boolean z2) {
        return jSONObject.has(str) ? jSONObject.optBoolean(str, z2) : jSONObject2.has(str) ? jSONObject2.optBoolean(str, z2) : z2;
    }

    private int[] a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        int[] iArr = new int[optJSONArray.length()];
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            iArr[i2] = optJSONArray.optInt(i2);
        }
        return iArr;
    }

    private m b(JSONObject jSONObject) {
        m mVar = new m();
        JSONObject b2 = b(jSONObject, "AdQuality");
        if (b2 != null) {
            mVar.a(b2.optBoolean("initSDK"));
        }
        return mVar;
    }

    public static d b(c cVar) {
        if (cVar == null || !cVar.m()) {
            return d.a();
        }
        d j2 = cVar.b().b().j();
        if (j2.f()) {
            return j2;
        }
        j2.a(cVar.i().b(IronSourceConstants.IRONSOURCE_CONFIG_NAME));
        return j2;
    }

    private JSONObject b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    private Context c() {
        return this.U1;
    }

    private m1 c(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt(m2.i, -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            ga a2 = a(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                m1 m1Var = new m1(optInt, optString, optBoolean, a2);
                if (a2 == null) {
                    return m1Var;
                }
                b.a(this.U1, m1Var);
                return m1Var;
            }
        }
        return null;
    }

    private JSONObject c(JSONObject jSONObject, String str) {
        JSONObject b2 = b(jSONObject, str);
        return b2 != null ? b2 : new JSONObject();
    }

    private InterstitialPlacement d(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt(m2.i, -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            ga a2 = a(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                InterstitialPlacement interstitialPlacement = new InterstitialPlacement(optInt, optString, optBoolean, a2);
                if (a2 == null) {
                    return interstitialPlacement;
                }
                b.a(this.U1, interstitialPlacement);
                return interstitialPlacement;
            }
        }
        return null;
    }

    private g9 e(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt(m2.i, -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            ga a2 = a(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                g9 g9Var = new g9(optInt, optString, optBoolean, a2);
                if (a2 == null) {
                    return g9Var;
                }
                b.a(this.U1, g9Var);
                return g9Var;
            }
        }
        return null;
    }

    private q9 f(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt(m2.i, -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                return new q9(optInt, optString, optBoolean);
            }
        }
        return null;
    }

    private Placement g(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt(m2.i, -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            String optString2 = jSONObject.optString("virtualItemName", "");
            int optInt2 = jSONObject.optInt("virtualItemCount", -1);
            ga a2 = a(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optInt2 > 0) {
                Placement placement = new Placement(optInt, optString, optBoolean, optString2, optInt2, a2);
                if (a2 == null) {
                    return placement;
                }
                b.a(this.U1, placement);
                return placement;
            }
        }
        return null;
    }

    private bc h(JSONObject jSONObject) {
        bc bcVar = new bc();
        JSONObject b2 = b(jSONObject, "testSuite");
        if (b2 != null) {
            bcVar.b(b2.optString(tb.b));
        }
        return bcVar;
    }

    private boolean j() {
        JSONObject b2;
        JSONArray optJSONArray;
        JSONObject b3 = b(this.T1, "providerOrder");
        JSONArray names = b3.names();
        if (names == null) {
            return true;
        }
        JSONObject b4 = b(b(this.T1, d.i), "adUnits");
        for (int i2 = 0; i2 < names.length(); i2++) {
            String optString = names.optString(i2);
            JSONArray optJSONArray2 = b3.optJSONArray(optString);
            if (optJSONArray2 != null && optJSONArray2.length() != 0 && (b2 = b(b4, optString)) != null && ((optJSONArray = b2.optJSONArray("placements")) == null || optJSONArray.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0c6d: MOVE  (r2v11 java.lang.String) = (r96v1 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0523 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0538 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00e2 A[SYNTHETIC, Splitter:B:15:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0747 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0760 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0784 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0970 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0987 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x099f A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0a99 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0aac A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0aed A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0b02 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0b0a A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0b52 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0baa A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0bc6 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0bcf A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0be1 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0c00 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0c8c A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:355:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0320 A[Catch:{ Exception -> 0x0c9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x033a A[Catch:{ Exception -> 0x0c9f }] */
    private void n() {
        /*
            r115 = this;
            r7 = r115
            java.lang.String r8 = "events"
            org.json.JSONObject r1 = r7.T1     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "configurations"
            org.json.JSONObject r9 = r7.b(r1, r2)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "adUnits"
            org.json.JSONObject r1 = r7.b(r9, r1)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "application"
            org.json.JSONObject r10 = r7.b(r9, r2)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "rewardedVideo"
            org.json.JSONObject r2 = r7.b(r1, r2)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r3 = "interstitial"
            org.json.JSONObject r3 = r7.b(r1, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r4 = "offerwall"
            org.json.JSONObject r11 = r7.b(r1, r4)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r4 = "banner"
            org.json.JSONObject r12 = r7.b(r1, r4)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r4 = "nativeAd"
            org.json.JSONObject r13 = r7.b(r1, r4)     // Catch:{ Exception -> 0x0c9f }
            org.json.JSONObject r14 = r7.b(r10, r8)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "loggers"
            org.json.JSONObject r15 = r7.b(r10, r1)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "token"
            org.json.JSONObject r5 = r7.b(r10, r1)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "segment"
            org.json.JSONObject r6 = r7.b(r10, r1)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "auction"
            org.json.JSONObject r4 = r7.b(r10, r1)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "crashReporter"
            org.json.JSONObject r1 = r7.b(r10, r1)     // Catch:{ Exception -> 0x0c9f }
            r16 = r1
            java.lang.String r1 = "settings"
            org.json.JSONObject r17 = r7.b(r10, r1)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "external"
            org.json.JSONObject r1 = r7.b(r10, r1)     // Catch:{ Exception -> 0x0c9f }
            r18 = r1
            java.lang.String r1 = "pixel"
            org.json.JSONObject r1 = r7.b(r14, r1)     // Catch:{ Exception -> 0x0c9f }
            r19 = r5
            r5 = 1
            if (r10 == 0) goto L_0x0085
            r20 = r1
            java.lang.String r1 = "uuidEnabled"
            boolean r1 = r10.optBoolean(r1, r5)     // Catch:{ Exception -> 0x0c9f }
            android.content.Context r5 = r7.U1     // Catch:{ Exception -> 0x0c9f }
            r22 = r6
            java.lang.String r6 = "uuidEnabled"
            com.ironsource.mediationsdk.utils.IronSourceUtils.saveBooleanToSharedPrefs(r5, r6, r1)     // Catch:{ Exception -> 0x0c9f }
            goto L_0x0089
        L_0x0085:
            r20 = r1
            r22 = r6
        L_0x0089:
            r23 = 0
            if (r14 == 0) goto L_0x00aa
            java.lang.String r1 = "abt"
            java.lang.String r1 = r14.optString(r1)     // Catch:{ Exception -> 0x0c9f }
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0c9f }
            if (r5 != 0) goto L_0x00aa
            com.ironsource.n7 r5 = com.ironsource.n7.i()     // Catch:{ Exception -> 0x0c9f }
            r5.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.va r5 = com.ironsource.va.i()     // Catch:{ Exception -> 0x0c9f }
            r5.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0c9f }
            r34 = r1
            goto L_0x00ac
        L_0x00aa:
            r34 = r23
        L_0x00ac:
            java.lang.String r5 = "auctionData"
            java.lang.String r6 = "triggerEvents"
            java.lang.String r1 = "maxEventsPerBatch"
            r35 = r9
            java.lang.String r9 = "maxNumberOfEvents"
            r24 = r15
            java.lang.String r15 = "backupThreshold"
            r25 = r11
            java.lang.String r11 = "serverEventsType"
            r26 = r13
            java.lang.String r13 = "serverEventsURL"
            r27 = r12
            java.lang.String r12 = "sendEventsToggle"
            r28 = r3
            java.lang.String r3 = "placements"
            r29 = r5
            java.lang.String r5 = "optIn"
            r31 = r4
            java.lang.String r4 = "eventsCompressionLevel"
            r32 = r6
            java.lang.String r6 = "optOut"
            r33 = r5
            java.lang.String r5 = "eventsCompression"
            r36 = r6
            java.lang.String r6 = ""
            r37 = r1
            if (r2 == 0) goto L_0x0320
            org.json.JSONArray r1 = r2.optJSONArray(r3)     // Catch:{ Exception -> 0x0c9f }
            r38 = r3
            org.json.JSONObject r3 = r7.b(r2, r8)     // Catch:{ Exception -> 0x0c9f }
            r39 = r8
            java.lang.String r8 = "providers"
            org.json.JSONObject r8 = r7.c(r2, r8)     // Catch:{ Exception -> 0x0c9f }
            r40 = r1
            java.lang.String r1 = "collectBiddingDataAsyncEnabled"
            r41 = r9
            r9 = 0
            boolean r51 = r2.optBoolean(r1, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "collectBiddingDataTimeout"
            r58 = r10
            r9 = 3000(0xbb8, double:1.482E-320)
            long r52 = r2.optLong(r1, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "parallelInit"
            r9 = 0
            boolean r54 = r8.optBoolean(r1, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "waitUntilAllProvidersFinishInit"
            boolean r55 = r8.optBoolean(r1, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "threadPerManager"
            boolean r56 = r2.optBoolean(r1, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "sharedManagersThread"
            boolean r57 = r2.optBoolean(r1, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "parallelLoad"
            r8 = r58
            r9 = 2
            int r43 = r7.a((org.json.JSONObject) r2, (org.json.JSONObject) r8, (java.lang.String) r1, (int) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "bidderExclusive"
            r9 = 1
            boolean r44 = r7.a((org.json.JSONObject) r2, (org.json.JSONObject) r8, (java.lang.String) r1, (boolean) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "adapterTimeOutInSeconds"
            r9 = 60
            int r45 = r7.a((org.json.JSONObject) r2, (org.json.JSONObject) r8, (java.lang.String) r1, (int) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "expiredDurationInMinutes"
            r9 = -1
            int r46 = r7.a((org.json.JSONObject) r2, (org.json.JSONObject) r8, (java.lang.String) r1, (int) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "delayLoadFailure"
            r9 = 3
            int r49 = r7.a((org.json.JSONObject) r2, (org.json.JSONObject) r8, (java.lang.String) r1, (int) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "isOneFlow"
            r9 = 0
            boolean r50 = r7.a((org.json.JSONObject) r2, (org.json.JSONObject) r8, (java.lang.String) r1, (boolean) r9)     // Catch:{ Exception -> 0x0c9f }
            org.json.JSONObject r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r3, r14)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "sendUltraEvents"
            boolean r59 = r1.optBoolean(r2, r9)     // Catch:{ Exception -> 0x0c9f }
            boolean r60 = r1.optBoolean(r12, r9)     // Catch:{ Exception -> 0x0c9f }
            boolean r61 = r1.optBoolean(r5, r9)     // Catch:{ Exception -> 0x0c9f }
            r2 = -1
            int r62 = r1.optInt(r4, r2)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r63 = r1.optString(r13, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r64 = r1.optString(r11, r6)     // Catch:{ Exception -> 0x0c9f }
            int r65 = r1.optInt(r15, r2)     // Catch:{ Exception -> 0x0c9f }
            r9 = r41
            int r66 = r1.optInt(r9, r2)     // Catch:{ Exception -> 0x0c9f }
            r2 = r37
            r3 = 5000(0x1388, float:7.006E-42)
            int r67 = r1.optInt(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            r10 = r36
            org.json.JSONArray r3 = r1.optJSONArray(r10)     // Catch:{ Exception -> 0x0c9f }
            if (r3 == 0) goto L_0x01a7
            r36 = r10
            int r10 = r3.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r10 = new int[r10]     // Catch:{ Exception -> 0x0c9f }
            r37 = r2
            r41 = r9
            r2 = 0
        L_0x0195:
            int r9 = r3.length()     // Catch:{ Exception -> 0x0c9f }
            if (r2 >= r9) goto L_0x01a4
            int r9 = r3.optInt(r2)     // Catch:{ Exception -> 0x0c9f }
            r10[r2] = r9     // Catch:{ Exception -> 0x0c9f }
            int r2 = r2 + 1
            goto L_0x0195
        L_0x01a4:
            r68 = r10
            goto L_0x01af
        L_0x01a7:
            r37 = r2
            r41 = r9
            r36 = r10
            r68 = r23
        L_0x01af:
            r9 = r33
            org.json.JSONArray r2 = r1.optJSONArray(r9)     // Catch:{ Exception -> 0x0c9f }
            if (r2 == 0) goto L_0x01d2
            int r3 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r3 = new int[r3]     // Catch:{ Exception -> 0x0c9f }
            r33 = r9
            r10 = 0
        L_0x01c0:
            int r9 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            if (r10 >= r9) goto L_0x01cf
            int r9 = r2.optInt(r10)     // Catch:{ Exception -> 0x0c9f }
            r3[r10] = r9     // Catch:{ Exception -> 0x0c9f }
            int r10 = r10 + 1
            goto L_0x01c0
        L_0x01cf:
            r69 = r3
            goto L_0x01d6
        L_0x01d2:
            r33 = r9
            r69 = r23
        L_0x01d6:
            r9 = r32
            org.json.JSONArray r2 = r1.optJSONArray(r9)     // Catch:{ Exception -> 0x0c9f }
            if (r2 == 0) goto L_0x01f9
            int r3 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r3 = new int[r3]     // Catch:{ Exception -> 0x0c9f }
            r32 = r9
            r10 = 0
        L_0x01e7:
            int r9 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            if (r10 >= r9) goto L_0x01f6
            int r9 = r2.optInt(r10)     // Catch:{ Exception -> 0x0c9f }
            r3[r10] = r9     // Catch:{ Exception -> 0x0c9f }
            int r10 = r10 + 1
            goto L_0x01e7
        L_0x01f6:
            r70 = r3
            goto L_0x01fd
        L_0x01f9:
            r32 = r9
            r70 = r23
        L_0x01fd:
            java.lang.String r2 = "nonConnectivityEvents"
            org.json.JSONArray r1 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0c9f }
            if (r1 == 0) goto L_0x021e
            int r2 = r1.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x0c9f }
            r3 = 0
        L_0x020c:
            int r9 = r1.length()     // Catch:{ Exception -> 0x0c9f }
            if (r3 >= r9) goto L_0x021b
            int r9 = r1.optInt(r3)     // Catch:{ Exception -> 0x0c9f }
            r2[r3] = r9     // Catch:{ Exception -> 0x0c9f }
            int r3 = r3 + 1
            goto L_0x020c
        L_0x021b:
            r71 = r2
            goto L_0x0220
        L_0x021e:
            r71 = r23
        L_0x0220:
            com.ironsource.m0 r47 = new com.ironsource.m0     // Catch:{ Exception -> 0x0c9f }
            r58 = r47
            r58.<init>(r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71)     // Catch:{ Exception -> 0x0c9f }
            if (r31 == 0) goto L_0x02e4
            java.lang.String r1 = "rewardedVideo"
            r9 = r31
            org.json.JSONObject r1 = r7.b(r9, r1)     // Catch:{ Exception -> 0x0c9f }
            r10 = r29
            java.lang.String r59 = r9.optString(r10, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "auctioneerURL"
            java.lang.String r60 = r9.optString(r2, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "extAuctioneerURL"
            java.lang.String r61 = r9.optString(r2, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "auctionTrials"
            r3 = 2
            int r62 = r9.optInt(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "auctionTimeout"
            r31 = r10
            r29 = r11
            r10 = 10000(0x2710, double:4.9407E-320)
            long r64 = r9.optLong(r2, r10)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "auctionSavedHistory"
            r3 = 15
            int r63 = r9.optInt(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "compressAuctionRequest"
            r3 = 0
            boolean r76 = r9.optBoolean(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "compressAuctionResponse"
            boolean r77 = r9.optBoolean(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "encryptionVersion"
            r3 = 1
            int r79 = r9.optInt(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "minTimeBeforeFirstAuction"
            r3 = 2000(0x7d0, float:2.803E-42)
            int r2 = r1.optInt(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r3 = "auctionRetryInterval"
            r10 = 30000(0x7530, float:4.2039E-41)
            int r3 = r1.optInt(r3, r10)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r10 = "timeToWaitBeforeAuction"
            r11 = 5000(0x1388, float:7.006E-42)
            int r10 = r1.optInt(r10, r11)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "timeToWaitBeforeLoad"
            r81 = r9
            r9 = 50
            int r9 = r1.optInt(r11, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "objectPerWaterfall"
            r82 = r15
            r15 = 0
            boolean r78 = r1.optBoolean(r11, r15)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "isLoadWhileShow"
            r15 = 1
            boolean r74 = r1.optBoolean(r11, r15)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "timeToDeleteOldWaterfallAfterAuction"
            r15 = 30000(0x7530, float:4.2039E-41)
            int r75 = r1.optInt(r11, r15)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.mediationsdk.utils.a r11 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            r15 = r4
            r83 = r5
            long r4 = (long) r2     // Catch:{ Exception -> 0x0c9f }
            long r2 = (long) r3     // Catch:{ Exception -> 0x0c9f }
            r85 = r12
            r84 = r13
            long r12 = (long) r10     // Catch:{ Exception -> 0x0c9f }
            long r9 = (long) r9     // Catch:{ Exception -> 0x0c9f }
            r80 = 0
            r58 = r11
            r66 = r4
            r68 = r2
            r70 = r12
            r72 = r9
            r58.<init>(r59, r60, r61, r62, r63, r64, r66, r68, r70, r72, r74, r75, r76, r77, r78, r79, r80)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "disableLoadWhileShowSupportFor"
            org.json.JSONArray r1 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0c9f }
            if (r1 == 0) goto L_0x02e1
            r2 = 0
        L_0x02d1:
            int r3 = r1.length()     // Catch:{ Exception -> 0x0c9f }
            if (r2 >= r3) goto L_0x02e1
            java.lang.String r3 = r1.optString(r2)     // Catch:{ Exception -> 0x0c9f }
            r11.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0c9f }
            int r2 = r2 + 1
            goto L_0x02d1
        L_0x02e1:
            r48 = r11
            goto L_0x02fa
        L_0x02e4:
            r83 = r5
            r85 = r12
            r84 = r13
            r82 = r15
            r81 = r31
            r15 = r4
            r31 = r29
            r29 = r11
            com.ironsource.mediationsdk.utils.a r1 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            r1.<init>()     // Catch:{ Exception -> 0x0c9f }
            r48 = r1
        L_0x02fa:
            com.ironsource.ua r1 = new com.ironsource.ua     // Catch:{ Exception -> 0x0c9f }
            r42 = r1
            r42.<init>(r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r54, r55, r56, r57)     // Catch:{ Exception -> 0x0c9f }
            if (r40 == 0) goto L_0x031e
            r2 = 0
        L_0x0304:
            int r3 = r40.length()     // Catch:{ Exception -> 0x0c9f }
            if (r2 >= r3) goto L_0x031e
            r3 = r40
            org.json.JSONObject r4 = r3.optJSONObject(r2)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.mediationsdk.model.Placement r4 = r7.g(r4)     // Catch:{ Exception -> 0x0c9f }
            if (r4 == 0) goto L_0x0319
            r1.a((com.ironsource.mediationsdk.model.Placement) r4)     // Catch:{ Exception -> 0x0c9f }
        L_0x0319:
            int r2 = r2 + 1
            r40 = r3
            goto L_0x0304
        L_0x031e:
            r9 = r1
            goto L_0x0338
        L_0x0320:
            r38 = r3
            r83 = r5
            r39 = r8
            r41 = r9
            r8 = r10
            r85 = r12
            r84 = r13
            r82 = r15
            r81 = r31
            r15 = r4
            r31 = r29
            r29 = r11
            r9 = r23
        L_0x0338:
            if (r28 == 0) goto L_0x0523
            r1 = r28
            r3 = r38
            org.json.JSONArray r2 = r1.optJSONArray(r3)     // Catch:{ Exception -> 0x0c9f }
            r10 = r39
            org.json.JSONObject r4 = r7.b(r1, r10)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "providers"
            org.json.JSONObject r5 = r7.c(r1, r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "collectBiddingDataAsyncEnabled"
            r12 = 0
            boolean r50 = r1.optBoolean(r11, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "collectBiddingDataTimeout"
            r12 = 3000(0xbb8, double:1.482E-320)
            long r51 = r1.optLong(r11, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "parallelInit"
            r12 = 0
            boolean r53 = r5.optBoolean(r11, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "waitUntilAllProvidersFinishInit"
            boolean r54 = r5.optBoolean(r11, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "threadPerManager"
            boolean r55 = r1.optBoolean(r5, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "sharedManagersThread"
            boolean r56 = r1.optBoolean(r5, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "parallelLoad"
            r11 = 2
            int r43 = r7.a((org.json.JSONObject) r1, (org.json.JSONObject) r8, (java.lang.String) r5, (int) r11)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "bidderExclusive"
            boolean r44 = r7.a((org.json.JSONObject) r1, (org.json.JSONObject) r8, (java.lang.String) r5, (boolean) r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "adapterTimeOutInSeconds"
            r11 = 60
            int r45 = r7.a((org.json.JSONObject) r1, (org.json.JSONObject) r8, (java.lang.String) r5, (int) r11)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "delayLoadFailure"
            r11 = 3
            int r48 = r7.a((org.json.JSONObject) r1, (org.json.JSONObject) r8, (java.lang.String) r5, (int) r11)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "isOneFlow"
            r12 = 0
            boolean r49 = r7.a((org.json.JSONObject) r1, (org.json.JSONObject) r8, (java.lang.String) r5, (boolean) r12)     // Catch:{ Exception -> 0x0c9f }
            org.json.JSONObject r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r4, r14)     // Catch:{ Exception -> 0x0c9f }
            r13 = r85
            boolean r59 = r1.optBoolean(r13, r12)     // Catch:{ Exception -> 0x0c9f }
            r5 = r83
            boolean r60 = r1.optBoolean(r5, r12)     // Catch:{ Exception -> 0x0c9f }
            r4 = r15
            r12 = -1
            int r61 = r1.optInt(r4, r12)     // Catch:{ Exception -> 0x0c9f }
            r15 = r84
            java.lang.String r62 = r1.optString(r15, r6)     // Catch:{ Exception -> 0x0c9f }
            r11 = r29
            java.lang.String r63 = r1.optString(r11, r6)     // Catch:{ Exception -> 0x0c9f }
            r83 = r5
            r5 = r82
            int r64 = r1.optInt(r5, r12)     // Catch:{ Exception -> 0x0c9f }
            r82 = r5
            r5 = r41
            int r65 = r1.optInt(r5, r12)     // Catch:{ Exception -> 0x0c9f }
            r41 = r5
            r12 = r37
            r5 = 5000(0x1388, float:7.006E-42)
            int r66 = r1.optInt(r12, r5)     // Catch:{ Exception -> 0x0c9f }
            r28 = r4
            r5 = r36
            org.json.JSONArray r4 = r1.optJSONArray(r5)     // Catch:{ Exception -> 0x0c9f }
            if (r4 == 0) goto L_0x03fe
            r36 = r5
            int r5 = r4.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r5 = new int[r5]     // Catch:{ Exception -> 0x0c9f }
            r38 = r9
            r37 = r12
            r12 = 0
        L_0x03ec:
            int r9 = r4.length()     // Catch:{ Exception -> 0x0c9f }
            if (r12 >= r9) goto L_0x03fb
            int r9 = r4.optInt(r12)     // Catch:{ Exception -> 0x0c9f }
            r5[r12] = r9     // Catch:{ Exception -> 0x0c9f }
            int r12 = r12 + 1
            goto L_0x03ec
        L_0x03fb:
            r67 = r5
            goto L_0x0406
        L_0x03fe:
            r36 = r5
            r38 = r9
            r37 = r12
            r67 = r23
        L_0x0406:
            r5 = r33
            org.json.JSONArray r4 = r1.optJSONArray(r5)     // Catch:{ Exception -> 0x0c9f }
            if (r4 == 0) goto L_0x0429
            int r9 = r4.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r9 = new int[r9]     // Catch:{ Exception -> 0x0c9f }
            r33 = r5
            r12 = 0
        L_0x0417:
            int r5 = r4.length()     // Catch:{ Exception -> 0x0c9f }
            if (r12 >= r5) goto L_0x0426
            int r5 = r4.optInt(r12)     // Catch:{ Exception -> 0x0c9f }
            r9[r12] = r5     // Catch:{ Exception -> 0x0c9f }
            int r12 = r12 + 1
            goto L_0x0417
        L_0x0426:
            r68 = r9
            goto L_0x042d
        L_0x0429:
            r33 = r5
            r68 = r23
        L_0x042d:
            r5 = r32
            org.json.JSONArray r4 = r1.optJSONArray(r5)     // Catch:{ Exception -> 0x0c9f }
            if (r4 == 0) goto L_0x0450
            int r9 = r4.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r9 = new int[r9]     // Catch:{ Exception -> 0x0c9f }
            r32 = r5
            r12 = 0
        L_0x043e:
            int r5 = r4.length()     // Catch:{ Exception -> 0x0c9f }
            if (r12 >= r5) goto L_0x044d
            int r5 = r4.optInt(r12)     // Catch:{ Exception -> 0x0c9f }
            r9[r12] = r5     // Catch:{ Exception -> 0x0c9f }
            int r12 = r12 + 1
            goto L_0x043e
        L_0x044d:
            r69 = r9
            goto L_0x0454
        L_0x0450:
            r32 = r5
            r69 = r23
        L_0x0454:
            java.lang.String r4 = "nonConnectivityEvents"
            org.json.JSONArray r1 = r1.optJSONArray(r4)     // Catch:{ Exception -> 0x0c9f }
            if (r1 == 0) goto L_0x0475
            int r4 = r1.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r4 = new int[r4]     // Catch:{ Exception -> 0x0c9f }
            r9 = 0
        L_0x0463:
            int r5 = r1.length()     // Catch:{ Exception -> 0x0c9f }
            if (r9 >= r5) goto L_0x0472
            int r5 = r1.optInt(r9)     // Catch:{ Exception -> 0x0c9f }
            r4[r9] = r5     // Catch:{ Exception -> 0x0c9f }
            int r9 = r9 + 1
            goto L_0x0463
        L_0x0472:
            r70 = r4
            goto L_0x0477
        L_0x0475:
            r70 = r23
        L_0x0477:
            com.ironsource.m0 r46 = new com.ironsource.m0     // Catch:{ Exception -> 0x0c9f }
            r58 = 0
            r57 = r46
            r57.<init>(r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70)     // Catch:{ Exception -> 0x0c9f }
            if (r81 == 0) goto L_0x04f3
            java.lang.String r1 = "interstitial"
            r4 = r81
            org.json.JSONObject r1 = r7.b(r4, r1)     // Catch:{ Exception -> 0x0c9f }
            r5 = r31
            java.lang.String r58 = r4.optString(r5, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "auctioneerURL"
            java.lang.String r59 = r4.optString(r9, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "extAuctioneerURL"
            java.lang.String r60 = r4.optString(r9, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "auctionTrials"
            r12 = 2
            int r61 = r4.optInt(r9, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "auctionSavedHistory"
            r12 = 15
            int r62 = r4.optInt(r9, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "auctionTimeout"
            r29 = r5
            r12 = r6
            r5 = 10000(0x2710, double:4.9407E-320)
            long r63 = r4.optLong(r9, r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "compressAuctionRequest"
            r9 = 0
            boolean r75 = r4.optBoolean(r5, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "compressAuctionResponse"
            boolean r76 = r4.optBoolean(r5, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "encryptionVersion"
            r6 = 1
            int r78 = r4.optInt(r5, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "objectPerWaterfall"
            boolean r77 = r1.optBoolean(r5, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "minTimeBeforeFirstAuction"
            r6 = 2000(0x7d0, float:2.803E-42)
            int r1 = r1.optInt(r5, r6)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.mediationsdk.utils.a r5 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            r39 = r10
            long r9 = (long) r1     // Catch:{ Exception -> 0x0c9f }
            r67 = 0
            r69 = 0
            r71 = 0
            r73 = 1
            r74 = 0
            r79 = 0
            r57 = r5
            r65 = r9
            r57.<init>(r58, r59, r60, r61, r62, r63, r65, r67, r69, r71, r73, r74, r75, r76, r77, r78, r79)     // Catch:{ Exception -> 0x0c9f }
            r47 = r5
            goto L_0x0501
        L_0x04f3:
            r12 = r6
            r39 = r10
            r29 = r31
            r4 = r81
            com.ironsource.mediationsdk.utils.a r1 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            r1.<init>()     // Catch:{ Exception -> 0x0c9f }
            r47 = r1
        L_0x0501:
            com.ironsource.m7 r1 = new com.ironsource.m7     // Catch:{ Exception -> 0x0c9f }
            r42 = r1
            r42.<init>(r43, r44, r45, r46, r47, r48, r49, r50, r51, r53, r54, r55, r56)     // Catch:{ Exception -> 0x0c9f }
            if (r2 == 0) goto L_0x0521
            r9 = 0
        L_0x050b:
            int r5 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            if (r9 >= r5) goto L_0x0521
            org.json.JSONObject r5 = r2.optJSONObject(r9)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.mediationsdk.model.InterstitialPlacement r5 = r7.d(r5)     // Catch:{ Exception -> 0x0c9f }
            if (r5 == 0) goto L_0x051e
            r1.a((com.ironsource.mediationsdk.model.InterstitialPlacement) r5)     // Catch:{ Exception -> 0x0c9f }
        L_0x051e:
            int r9 = r9 + 1
            goto L_0x050b
        L_0x0521:
            r9 = r1
            goto L_0x0536
        L_0x0523:
            r12 = r6
            r28 = r15
            r11 = r29
            r29 = r31
            r3 = r38
            r4 = r81
            r15 = r84
            r13 = r85
            r38 = r9
            r9 = r23
        L_0x0536:
            if (r27 == 0) goto L_0x0760
            r10 = r27
            org.json.JSONArray r5 = r10.optJSONArray(r3)     // Catch:{ Exception -> 0x0c9f }
            r6 = r39
            org.json.JSONObject r2 = r7.b(r10, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "providers"
            org.json.JSONObject r1 = r7.c(r10, r1)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r27 = "atim"
            r39 = 10000(0x2710, double:4.9407E-320)
            r89 = r1
            r86 = r16
            r87 = r18
            r88 = r20
            r90 = r37
            r1 = r115
            r91 = r2
            r2 = r10
            r92 = r3
            r3 = r8
            r18 = r9
            r16 = r12
            r9 = r28
            r12 = r4
            r4 = r27
            r95 = r5
            r96 = r6
            r31 = r12
            r101 = r16
            r93 = r19
            r94 = r22
            r97 = r29
            r98 = r33
            r99 = r36
            r100 = r83
            r12 = 3
            r5 = r39
            long r44 = r1.a((org.json.JSONObject) r2, (org.json.JSONObject) r3, (java.lang.String) r4, (long) r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "delayLoadFailure"
            int r50 = r7.a((org.json.JSONObject) r10, (org.json.JSONObject) r8, (java.lang.String) r1, (int) r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "bannerInterval"
            r2 = 60
            int r48 = r7.a((org.json.JSONObject) r10, (org.json.JSONObject) r8, (java.lang.String) r1, (int) r2)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "isOneFlow"
            r5 = 0
            boolean r51 = r7.a((org.json.JSONObject) r10, (org.json.JSONObject) r8, (java.lang.String) r1, (boolean) r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "collectBiddingDataAsyncEnabled"
            boolean r52 = r10.optBoolean(r1, r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "collectBiddingDataTimeout"
            r2 = 3000(0xbb8, double:1.482E-320)
            long r53 = r10.optLong(r1, r2)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "parallelInit"
            r2 = r89
            boolean r55 = r2.optBoolean(r1, r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "waitUntilAllProvidersFinishInit"
            boolean r56 = r2.optBoolean(r1, r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "threadPerManager"
            boolean r57 = r10.optBoolean(r1, r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "sharedManagersThread"
            boolean r58 = r10.optBoolean(r1, r5)     // Catch:{ Exception -> 0x0c9f }
            r1 = r91
            org.json.JSONObject r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r1, r14)     // Catch:{ Exception -> 0x0c9f }
            boolean r61 = r1.optBoolean(r13, r5)     // Catch:{ Exception -> 0x0c9f }
            r10 = r100
            boolean r62 = r1.optBoolean(r10, r5)     // Catch:{ Exception -> 0x0c9f }
            r6 = -1
            int r63 = r1.optInt(r9, r6)     // Catch:{ Exception -> 0x0c9f }
            r4 = r101
            java.lang.String r64 = r1.optString(r15, r4)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r65 = r1.optString(r11, r4)     // Catch:{ Exception -> 0x0c9f }
            r3 = r82
            int r66 = r1.optInt(r3, r6)     // Catch:{ Exception -> 0x0c9f }
            r2 = r41
            int r67 = r1.optInt(r2, r6)     // Catch:{ Exception -> 0x0c9f }
            r12 = r90
            r6 = 5000(0x1388, float:7.006E-42)
            int r68 = r1.optInt(r12, r6)     // Catch:{ Exception -> 0x0c9f }
            r6 = r99
            org.json.JSONArray r5 = r1.optJSONArray(r6)     // Catch:{ Exception -> 0x0c9f }
            if (r5 == 0) goto L_0x061b
            r41 = r2
            int r2 = r5.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x0c9f }
            r82 = r3
            r99 = r6
            r3 = 0
        L_0x0609:
            int r6 = r5.length()     // Catch:{ Exception -> 0x0c9f }
            if (r3 >= r6) goto L_0x0618
            int r6 = r5.optInt(r3)     // Catch:{ Exception -> 0x0c9f }
            r2[r3] = r6     // Catch:{ Exception -> 0x0c9f }
            int r3 = r3 + 1
            goto L_0x0609
        L_0x0618:
            r69 = r2
            goto L_0x0623
        L_0x061b:
            r41 = r2
            r82 = r3
            r99 = r6
            r69 = r23
        L_0x0623:
            r5 = r98
            org.json.JSONArray r2 = r1.optJSONArray(r5)     // Catch:{ Exception -> 0x0c9f }
            if (r2 == 0) goto L_0x0646
            int r3 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r3 = new int[r3]     // Catch:{ Exception -> 0x0c9f }
            r98 = r5
            r6 = 0
        L_0x0634:
            int r5 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            if (r6 >= r5) goto L_0x0643
            int r5 = r2.optInt(r6)     // Catch:{ Exception -> 0x0c9f }
            r3[r6] = r5     // Catch:{ Exception -> 0x0c9f }
            int r6 = r6 + 1
            goto L_0x0634
        L_0x0643:
            r70 = r3
            goto L_0x064a
        L_0x0646:
            r98 = r5
            r70 = r23
        L_0x064a:
            r5 = r32
            org.json.JSONArray r2 = r1.optJSONArray(r5)     // Catch:{ Exception -> 0x0c9f }
            if (r2 == 0) goto L_0x066d
            int r3 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r3 = new int[r3]     // Catch:{ Exception -> 0x0c9f }
            r32 = r5
            r6 = 0
        L_0x065b:
            int r5 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            if (r6 >= r5) goto L_0x066a
            int r5 = r2.optInt(r6)     // Catch:{ Exception -> 0x0c9f }
            r3[r6] = r5     // Catch:{ Exception -> 0x0c9f }
            int r6 = r6 + 1
            goto L_0x065b
        L_0x066a:
            r71 = r3
            goto L_0x0671
        L_0x066d:
            r32 = r5
            r71 = r23
        L_0x0671:
            java.lang.String r2 = "nonConnectivityEvents"
            org.json.JSONArray r1 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0c9f }
            if (r1 == 0) goto L_0x0692
            int r2 = r1.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x0c9f }
            r3 = 0
        L_0x0680:
            int r5 = r1.length()     // Catch:{ Exception -> 0x0c9f }
            if (r3 >= r5) goto L_0x068f
            int r5 = r1.optInt(r3)     // Catch:{ Exception -> 0x0c9f }
            r2[r3] = r5     // Catch:{ Exception -> 0x0c9f }
            int r3 = r3 + 1
            goto L_0x0680
        L_0x068f:
            r72 = r2
            goto L_0x0694
        L_0x0692:
            r72 = r23
        L_0x0694:
            com.ironsource.m0 r47 = new com.ironsource.m0     // Catch:{ Exception -> 0x0c9f }
            r60 = 0
            r59 = r47
            r59.<init>(r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72)     // Catch:{ Exception -> 0x0c9f }
            if (r31 == 0) goto L_0x072f
            java.lang.String r1 = "banner"
            r5 = r31
            org.json.JSONObject r1 = r7.b(r5, r1)     // Catch:{ Exception -> 0x0c9f }
            if (r1 == 0) goto L_0x0725
            r6 = r97
            java.lang.String r60 = r5.optString(r6, r4)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "auctioneerURL"
            java.lang.String r61 = r5.optString(r2, r4)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "extAuctioneerURL"
            java.lang.String r62 = r5.optString(r2, r4)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "auctionTrials"
            r3 = 2
            int r63 = r5.optInt(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "auctionSavedHistory"
            r3 = 15
            int r64 = r5.optInt(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "auctionTimeout"
            r101 = r4
            r3 = 10000(0x2710, double:4.9407E-320)
            long r65 = r5.optLong(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "compressAuctionRequest"
            r3 = 0
            boolean r77 = r5.optBoolean(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "compressAuctionResponse"
            boolean r78 = r5.optBoolean(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "encryptionVersion"
            r4 = 1
            int r80 = r5.optInt(r2, r4)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "objectPerWaterfall"
            boolean r79 = r1.optBoolean(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r2 = "minTimeBeforeFirstAuction"
            r3 = 2000(0x7d0, float:2.803E-42)
            int r2 = r1.optInt(r2, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r3 = "shouldSendBannerBURLFromImpression"
            boolean r81 = r1.optBoolean(r3, r4)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r3 = "isLoadWhileShow"
            r31 = r5
            r5 = 0
            boolean r75 = r1.optBoolean(r3, r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r3 = "timeToWaitBeforeAuction"
            r4 = 50
            int r1 = r1.optInt(r3, r4)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.mediationsdk.utils.a r3 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            r97 = r6
            long r5 = (long) r2     // Catch:{ Exception -> 0x0c9f }
            long r1 = (long) r1     // Catch:{ Exception -> 0x0c9f }
            r69 = 0
            r73 = 0
            r76 = 0
            r59 = r3
            r67 = r5
            r71 = r1
            r59.<init>(r60, r61, r62, r63, r64, r65, r67, r69, r71, r73, r75, r76, r77, r78, r79, r80, r81)     // Catch:{ Exception -> 0x0c9f }
            r49 = r3
            goto L_0x0738
        L_0x0725:
            r101 = r4
            r31 = r5
            com.ironsource.mediationsdk.utils.a r1 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            r1.<init>()     // Catch:{ Exception -> 0x0c9f }
            goto L_0x0736
        L_0x072f:
            r101 = r4
            com.ironsource.mediationsdk.utils.a r1 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            r1.<init>()     // Catch:{ Exception -> 0x0c9f }
        L_0x0736:
            r49 = r1
        L_0x0738:
            com.ironsource.k1 r1 = new com.ironsource.k1     // Catch:{ Exception -> 0x0c9f }
            r43 = 1
            r46 = 0
            r42 = r1
            r42.<init>(r43, r44, r46, r47, r48, r49, r50, r51, r52, r53, r55, r56, r57, r58)     // Catch:{ Exception -> 0x0c9f }
            r2 = r95
            if (r2 == 0) goto L_0x075e
            r3 = 0
        L_0x0748:
            int r4 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            if (r3 >= r4) goto L_0x075e
            org.json.JSONObject r4 = r2.optJSONObject(r3)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.m1 r4 = r7.c(r4)     // Catch:{ Exception -> 0x0c9f }
            if (r4 == 0) goto L_0x075b
            r1.a((com.ironsource.m1) r4)     // Catch:{ Exception -> 0x0c9f }
        L_0x075b:
            int r3 = r3 + 1
            goto L_0x0748
        L_0x075e:
            r5 = r1
            goto L_0x0782
        L_0x0760:
            r92 = r3
            r31 = r4
            r101 = r12
            r86 = r16
            r87 = r18
            r93 = r19
            r88 = r20
            r94 = r22
            r97 = r29
            r98 = r33
            r99 = r36
            r12 = r37
            r96 = r39
            r10 = r83
            r18 = r9
            r9 = r28
            r5 = r23
        L_0x0782:
            if (r26 == 0) goto L_0x0987
            r6 = r26
            r4 = r92
            org.json.JSONArray r3 = r6.optJSONArray(r4)     // Catch:{ Exception -> 0x0c9f }
            r2 = r96
            org.json.JSONObject r1 = r7.b(r6, r2)     // Catch:{ Exception -> 0x0c9f }
            r16 = r1
            java.lang.String r1 = "providers"
            org.json.JSONObject r1 = r7.c(r6, r1)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r19 = "atim"
            r20 = 10000(0x2710, double:4.9407E-320)
            r103 = r1
            r102 = r16
            r1 = r115
            r104 = r2
            r105 = r41
            r2 = r6
            r106 = r3
            r107 = r82
            r3 = r8
            r108 = r4
            r90 = r12
            r12 = r101
            r4 = r19
            r110 = r5
            r29 = r11
            r109 = r31
            r112 = r32
            r111 = r97
            r113 = r98
            r114 = r99
            r12 = 0
            r11 = r6
            r5 = r20
            long r41 = r1.a((org.json.JSONObject) r2, (org.json.JSONObject) r3, (java.lang.String) r4, (long) r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "delayLoadFailure"
            int r46 = r7.a((org.json.JSONObject) r11, (org.json.JSONObject) r8, (java.lang.String) r1, (int) r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "collectBiddingDataAsyncEnabled"
            boolean r47 = r11.optBoolean(r1, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "collectBiddingDataTimeout"
            r2 = 3000(0xbb8, double:1.482E-320)
            long r48 = r11.optLong(r1, r2)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "parallelInit"
            r2 = r103
            boolean r50 = r2.optBoolean(r1, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "waitUntilAllProvidersFinishInit"
            boolean r51 = r2.optBoolean(r1, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "threadPerManager"
            boolean r52 = r11.optBoolean(r1, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "sharedManagersThread"
            boolean r53 = r11.optBoolean(r1, r12)     // Catch:{ Exception -> 0x0c9f }
            r1 = r102
            org.json.JSONObject r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r1, r14)     // Catch:{ Exception -> 0x0c9f }
            boolean r56 = r1.optBoolean(r13, r12)     // Catch:{ Exception -> 0x0c9f }
            boolean r57 = r1.optBoolean(r10, r12)     // Catch:{ Exception -> 0x0c9f }
            r2 = -1
            int r58 = r1.optInt(r9, r2)     // Catch:{ Exception -> 0x0c9f }
            r3 = r101
            java.lang.String r59 = r1.optString(r15, r3)     // Catch:{ Exception -> 0x0c9f }
            r4 = r29
            java.lang.String r60 = r1.optString(r4, r3)     // Catch:{ Exception -> 0x0c9f }
            r5 = r107
            int r61 = r1.optInt(r5, r2)     // Catch:{ Exception -> 0x0c9f }
            r6 = r105
            int r62 = r1.optInt(r6, r2)     // Catch:{ Exception -> 0x0c9f }
            r2 = r90
            r11 = 5000(0x1388, float:7.006E-42)
            int r63 = r1.optInt(r2, r11)     // Catch:{ Exception -> 0x0c9f }
            r11 = r114
            org.json.JSONArray r12 = r1.optJSONArray(r11)     // Catch:{ Exception -> 0x0c9f }
            if (r12 == 0) goto L_0x0854
            r16 = r8
            int r8 = r12.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r8 = new int[r8]     // Catch:{ Exception -> 0x0c9f }
            r90 = r2
            r99 = r11
            r11 = 0
        L_0x0842:
            int r2 = r12.length()     // Catch:{ Exception -> 0x0c9f }
            if (r11 >= r2) goto L_0x0851
            int r2 = r12.optInt(r11)     // Catch:{ Exception -> 0x0c9f }
            r8[r11] = r2     // Catch:{ Exception -> 0x0c9f }
            int r11 = r11 + 1
            goto L_0x0842
        L_0x0851:
            r64 = r8
            goto L_0x085c
        L_0x0854:
            r90 = r2
            r16 = r8
            r99 = r11
            r64 = r23
        L_0x085c:
            r2 = r113
            org.json.JSONArray r8 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0c9f }
            if (r8 == 0) goto L_0x087f
            int r11 = r8.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r11 = new int[r11]     // Catch:{ Exception -> 0x0c9f }
            r98 = r2
            r12 = 0
        L_0x086d:
            int r2 = r8.length()     // Catch:{ Exception -> 0x0c9f }
            if (r12 >= r2) goto L_0x087c
            int r2 = r8.optInt(r12)     // Catch:{ Exception -> 0x0c9f }
            r11[r12] = r2     // Catch:{ Exception -> 0x0c9f }
            int r12 = r12 + 1
            goto L_0x086d
        L_0x087c:
            r65 = r11
            goto L_0x0883
        L_0x087f:
            r98 = r2
            r65 = r23
        L_0x0883:
            r2 = r112
            org.json.JSONArray r8 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0c9f }
            if (r8 == 0) goto L_0x08a6
            int r11 = r8.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r11 = new int[r11]     // Catch:{ Exception -> 0x0c9f }
            r32 = r2
            r12 = 0
        L_0x0894:
            int r2 = r8.length()     // Catch:{ Exception -> 0x0c9f }
            if (r12 >= r2) goto L_0x08a3
            int r2 = r8.optInt(r12)     // Catch:{ Exception -> 0x0c9f }
            r11[r12] = r2     // Catch:{ Exception -> 0x0c9f }
            int r12 = r12 + 1
            goto L_0x0894
        L_0x08a3:
            r66 = r11
            goto L_0x08aa
        L_0x08a6:
            r32 = r2
            r66 = r23
        L_0x08aa:
            java.lang.String r2 = "nonConnectivityEvents"
            org.json.JSONArray r1 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0c9f }
            if (r1 == 0) goto L_0x08cb
            int r2 = r1.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x0c9f }
            r8 = 0
        L_0x08b9:
            int r11 = r1.length()     // Catch:{ Exception -> 0x0c9f }
            if (r8 >= r11) goto L_0x08c8
            int r11 = r1.optInt(r8)     // Catch:{ Exception -> 0x0c9f }
            r2[r8] = r11     // Catch:{ Exception -> 0x0c9f }
            int r8 = r8 + 1
            goto L_0x08b9
        L_0x08c8:
            r67 = r2
            goto L_0x08cd
        L_0x08cb:
            r67 = r23
        L_0x08cd:
            com.ironsource.m0 r44 = new com.ironsource.m0     // Catch:{ Exception -> 0x0c9f }
            r55 = 0
            r54 = r44
            r54.<init>(r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67)     // Catch:{ Exception -> 0x0c9f }
            r1 = r109
            if (r1 == 0) goto L_0x0953
            java.lang.String r2 = "nativeAd"
            org.json.JSONObject r2 = r7.b(r1, r2)     // Catch:{ Exception -> 0x0c9f }
            if (r2 == 0) goto L_0x0946
            r8 = r111
            java.lang.String r55 = r1.optString(r8, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "auctioneerURL"
            java.lang.String r56 = r1.optString(r11, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "extAuctioneerURL"
            java.lang.String r57 = r1.optString(r11, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "auctionTrials"
            r12 = 2
            int r58 = r1.optInt(r11, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "auctionSavedHistory"
            r12 = 15
            int r59 = r1.optInt(r11, r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "auctionTimeout"
            r82 = r5
            r105 = r6
            r5 = 10000(0x2710, double:4.9407E-320)
            long r60 = r1.optLong(r11, r5)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "compressAuctionRequest"
            r6 = 0
            boolean r72 = r1.optBoolean(r5, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "compressAuctionResponse"
            boolean r73 = r1.optBoolean(r5, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "encryptionVersion"
            r6 = 1
            int r75 = r1.optInt(r5, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r5 = "minTimeBeforeFirstAuction"
            r11 = 2000(0x7d0, float:2.803E-42)
            int r2 = r2.optInt(r5, r11)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.mediationsdk.utils.a r5 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            long r11 = (long) r2     // Catch:{ Exception -> 0x0c9f }
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 1
            r71 = 0
            r74 = 1
            r76 = 0
            r54 = r5
            r62 = r11
            r54.<init>(r55, r56, r57, r58, r59, r60, r62, r64, r66, r68, r70, r71, r72, r73, r74, r75, r76)     // Catch:{ Exception -> 0x0c9f }
            r45 = r5
            goto L_0x0961
        L_0x0946:
            r82 = r5
            r105 = r6
            r8 = r111
            r6 = 1
            com.ironsource.mediationsdk.utils.a r2 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            r2.<init>()     // Catch:{ Exception -> 0x0c9f }
            goto L_0x095f
        L_0x0953:
            r82 = r5
            r105 = r6
            r8 = r111
            r6 = 1
            com.ironsource.mediationsdk.utils.a r2 = new com.ironsource.mediationsdk.utils.a     // Catch:{ Exception -> 0x0c9f }
            r2.<init>()     // Catch:{ Exception -> 0x0c9f }
        L_0x095f:
            r45 = r2
        L_0x0961:
            com.ironsource.a9 r2 = new com.ironsource.a9     // Catch:{ Exception -> 0x0c9f }
            r40 = 1
            r43 = 0
            r39 = r2
            r39.<init>(r40, r41, r43, r44, r45, r46, r47, r48, r50, r51, r52, r53)     // Catch:{ Exception -> 0x0c9f }
            r5 = r106
            if (r5 == 0) goto L_0x099d
            r11 = 0
        L_0x0971:
            int r12 = r5.length()     // Catch:{ Exception -> 0x0c9f }
            if (r11 >= r12) goto L_0x099d
            org.json.JSONObject r12 = r5.optJSONObject(r11)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.g9 r12 = r7.e(r12)     // Catch:{ Exception -> 0x0c9f }
            if (r12 == 0) goto L_0x0984
            r2.a((com.ironsource.g9) r12)     // Catch:{ Exception -> 0x0c9f }
        L_0x0984:
            int r11 = r11 + 1
            goto L_0x0971
        L_0x0987:
            r110 = r5
            r16 = r8
            r4 = r11
            r90 = r12
            r1 = r31
            r105 = r41
            r108 = r92
            r104 = r96
            r8 = r97
            r3 = r101
            r6 = 1
            r2 = r23
        L_0x099d:
            if (r25 == 0) goto L_0x0a99
            r5 = r25
            r11 = r104
            org.json.JSONObject r12 = r7.b(r5, r11)     // Catch:{ Exception -> 0x0c9f }
            org.json.JSONObject r12 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r12, r14)     // Catch:{ Exception -> 0x0c9f }
            r6 = 0
            boolean r41 = r12.optBoolean(r13, r6)     // Catch:{ Exception -> 0x0c9f }
            boolean r42 = r12.optBoolean(r10, r6)     // Catch:{ Exception -> 0x0c9f }
            r6 = -1
            int r43 = r12.optInt(r9, r6)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r44 = r12.optString(r15, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r45 = r12.optString(r4, r3)     // Catch:{ Exception -> 0x0c9f }
            r4 = r82
            int r46 = r12.optInt(r4, r6)     // Catch:{ Exception -> 0x0c9f }
            r4 = r105
            int r47 = r12.optInt(r4, r6)     // Catch:{ Exception -> 0x0c9f }
            r4 = r90
            r6 = 5000(0x1388, float:7.006E-42)
            int r48 = r12.optInt(r4, r6)     // Catch:{ Exception -> 0x0c9f }
            r4 = r99
            org.json.JSONArray r6 = r12.optJSONArray(r4)     // Catch:{ Exception -> 0x0c9f }
            if (r6 == 0) goto L_0x09f8
            int r13 = r6.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r13 = new int[r13]     // Catch:{ Exception -> 0x0c9f }
            r96 = r11
            r15 = 0
        L_0x09e6:
            int r11 = r6.length()     // Catch:{ Exception -> 0x0c9f }
            if (r15 >= r11) goto L_0x09f5
            int r11 = r6.optInt(r15)     // Catch:{ Exception -> 0x0c9f }
            r13[r15] = r11     // Catch:{ Exception -> 0x0c9f }
            int r15 = r15 + 1
            goto L_0x09e6
        L_0x09f5:
            r49 = r13
            goto L_0x09fc
        L_0x09f8:
            r96 = r11
            r49 = r23
        L_0x09fc:
            r6 = r98
            org.json.JSONArray r11 = r12.optJSONArray(r6)     // Catch:{ Exception -> 0x0c9f }
            if (r11 == 0) goto L_0x0a1f
            int r13 = r11.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r13 = new int[r13]     // Catch:{ Exception -> 0x0c9f }
            r19 = r2
            r15 = 0
        L_0x0a0d:
            int r2 = r11.length()     // Catch:{ Exception -> 0x0c9f }
            if (r15 >= r2) goto L_0x0a1c
            int r2 = r11.optInt(r15)     // Catch:{ Exception -> 0x0c9f }
            r13[r15] = r2     // Catch:{ Exception -> 0x0c9f }
            int r15 = r15 + 1
            goto L_0x0a0d
        L_0x0a1c:
            r50 = r13
            goto L_0x0a23
        L_0x0a1f:
            r19 = r2
            r50 = r23
        L_0x0a23:
            r2 = r32
            org.json.JSONArray r2 = r12.optJSONArray(r2)     // Catch:{ Exception -> 0x0c9f }
            if (r2 == 0) goto L_0x0a44
            int r11 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r11 = new int[r11]     // Catch:{ Exception -> 0x0c9f }
            r13 = 0
        L_0x0a32:
            int r15 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            if (r13 >= r15) goto L_0x0a41
            int r15 = r2.optInt(r13)     // Catch:{ Exception -> 0x0c9f }
            r11[r13] = r15     // Catch:{ Exception -> 0x0c9f }
            int r13 = r13 + 1
            goto L_0x0a32
        L_0x0a41:
            r51 = r11
            goto L_0x0a46
        L_0x0a44:
            r51 = r23
        L_0x0a46:
            java.lang.String r2 = "nonConnectivityEvents"
            org.json.JSONArray r2 = r12.optJSONArray(r2)     // Catch:{ Exception -> 0x0c9f }
            if (r2 == 0) goto L_0x0a67
            int r11 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            int[] r11 = new int[r11]     // Catch:{ Exception -> 0x0c9f }
            r12 = 0
        L_0x0a55:
            int r13 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            if (r12 >= r13) goto L_0x0a64
            int r13 = r2.optInt(r12)     // Catch:{ Exception -> 0x0c9f }
            r11[r12] = r13     // Catch:{ Exception -> 0x0c9f }
            int r12 = r12 + 1
            goto L_0x0a55
        L_0x0a64:
            r52 = r11
            goto L_0x0a69
        L_0x0a67:
            r52 = r23
        L_0x0a69:
            com.ironsource.m0 r2 = new com.ironsource.m0     // Catch:{ Exception -> 0x0c9f }
            r40 = 0
            r39 = r2
            r39.<init>(r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.p9 r11 = new com.ironsource.p9     // Catch:{ Exception -> 0x0c9f }
            r11.<init>(r2)     // Catch:{ Exception -> 0x0c9f }
            r11.a((org.json.JSONObject) r5)     // Catch:{ Exception -> 0x0c9f }
            r2 = r108
            org.json.JSONArray r2 = r5.optJSONArray(r2)     // Catch:{ Exception -> 0x0c9f }
            if (r2 == 0) goto L_0x0aa3
            r5 = 0
        L_0x0a83:
            int r12 = r2.length()     // Catch:{ Exception -> 0x0c9f }
            if (r5 >= r12) goto L_0x0aa3
            org.json.JSONObject r12 = r2.optJSONObject(r5)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.q9 r12 = r7.f(r12)     // Catch:{ Exception -> 0x0c9f }
            if (r12 == 0) goto L_0x0a96
            r11.a((com.ironsource.q9) r12)     // Catch:{ Exception -> 0x0c9f }
        L_0x0a96:
            int r5 = r5 + 1
            goto L_0x0a83
        L_0x0a99:
            r19 = r2
            r6 = r98
            r4 = r99
            r96 = r104
            r11 = r23
        L_0x0aa3:
            com.ironsource.mediationsdk.utils.d r2 = new com.ironsource.mediationsdk.utils.d     // Catch:{ Exception -> 0x0c9f }
            r2.<init>()     // Catch:{ Exception -> 0x0c9f }
            r5 = r93
            if (r5 == 0) goto L_0x0ae4
            java.lang.String r12 = "optInKeys"
            org.json.JSONArray r12 = r5.optJSONArray(r12)     // Catch:{ Exception -> 0x0c9f }
            if (r12 == 0) goto L_0x0ac5
            r13 = 0
        L_0x0ab5:
            int r15 = r12.length()     // Catch:{ Exception -> 0x0c9f }
            if (r13 >= r15) goto L_0x0ac5
            java.lang.String r15 = r12.optString(r13)     // Catch:{ Exception -> 0x0c9f }
            r2.a((java.lang.String) r15)     // Catch:{ Exception -> 0x0c9f }
            int r13 = r13 + 1
            goto L_0x0ab5
        L_0x0ac5:
            java.lang.String r12 = "tokenGenericParams"
            org.json.JSONObject r12 = r5.optJSONObject(r12)     // Catch:{ Exception -> 0x0c9f }
            if (r12 == 0) goto L_0x0ad0
            r2.a((org.json.JSONObject) r12)     // Catch:{ Exception -> 0x0c9f }
        L_0x0ad0:
            java.lang.String r12 = "oneToken"
            r13 = 0
            boolean r12 = r5.optBoolean(r12, r13)     // Catch:{ Exception -> 0x0c9f }
            r2.b(r12)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r12 = "compressToken"
            r13 = 1
            boolean r5 = r5.optBoolean(r12, r13)     // Catch:{ Exception -> 0x0c9f }
            r2.a((boolean) r5)     // Catch:{ Exception -> 0x0c9f }
        L_0x0ae4:
            com.ironsource.ea r5 = new com.ironsource.ea     // Catch:{ Exception -> 0x0c9f }
            r5.<init>()     // Catch:{ Exception -> 0x0c9f }
            r12 = r88
            if (r12 == 0) goto L_0x0b02
            java.lang.String r13 = "pixelEventsUrl"
            java.lang.String r15 = "https://outcome-ssp.supersonicads.com/mediation?adUnit=3"
            java.lang.String r13 = r12.optString(r13, r15)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r15 = "pixelEventsEnabled"
            r20 = r11
            r11 = 1
            boolean r11 = r12.optBoolean(r15, r11)     // Catch:{ Exception -> 0x0c9f }
            r5.a((java.lang.String) r13)     // Catch:{ Exception -> 0x0c9f }
            goto L_0x0b05
        L_0x0b02:
            r20 = r11
            r11 = 1
        L_0x0b05:
            r5.b((boolean) r11)     // Catch:{ Exception -> 0x0c9f }
            if (r11 == 0) goto L_0x0b28
            int[] r4 = r7.a(r14, r4)     // Catch:{ Exception -> 0x0c9f }
            r5.b((int[]) r4)     // Catch:{ Exception -> 0x0c9f }
            int[] r4 = r7.a(r14, r6)     // Catch:{ Exception -> 0x0c9f }
            r5.a((int[]) r4)     // Catch:{ Exception -> 0x0c9f }
            r4 = 0
            boolean r6 = r14.optBoolean(r10, r4)     // Catch:{ Exception -> 0x0c9f }
            r5.a((boolean) r6)     // Catch:{ Exception -> 0x0c9f }
            r4 = -1
            int r4 = r14.optInt(r9, r4)     // Catch:{ Exception -> 0x0c9f }
            r5.a((int) r4)     // Catch:{ Exception -> 0x0c9f }
        L_0x0b28:
            java.lang.String r4 = "server"
            r6 = r24
            r9 = 3
            int r4 = r6.optInt(r4, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r10 = "publisher"
            int r10 = r6.optInt(r10, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "console"
            int r9 = r6.optInt(r11, r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r11 = "shouldSendPublisherLogsOnUIThread"
            r12 = 0
            boolean r6 = r6.optBoolean(r11, r12)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.q0 r11 = new com.ironsource.q0     // Catch:{ Exception -> 0x0c9f }
            r11.<init>(r4, r10, r9, r6)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.l0 r4 = new com.ironsource.l0     // Catch:{ Exception -> 0x0c9f }
            r4.<init>()     // Catch:{ Exception -> 0x0c9f }
            r6 = r86
            if (r6 == 0) goto L_0x0ba6
            java.lang.String r9 = "enabled"
            r10 = 0
            boolean r9 = r6.optBoolean(r9, r10)     // Catch:{ Exception -> 0x0c9f }
            r4.a((boolean) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "reporterURL"
            java.lang.String r9 = r6.optString(r9, r3)     // Catch:{ Exception -> 0x0c9f }
            r4.c((java.lang.String) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "reporterKeyword"
            java.lang.String r9 = r6.optString(r9, r3)     // Catch:{ Exception -> 0x0c9f }
            r4.b((java.lang.String) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "includeANR"
            r10 = 0
            boolean r9 = r6.optBoolean(r9, r10)     // Catch:{ Exception -> 0x0c9f }
            r4.c((boolean) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "timeout"
            r10 = 5000(0x1388, float:7.006E-42)
            int r9 = r6.optInt(r9, r10)     // Catch:{ Exception -> 0x0c9f }
            r4.a((int) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "setIgnoreDebugger"
            r10 = 0
            boolean r9 = r6.optBoolean(r9, r10)     // Catch:{ Exception -> 0x0c9f }
            r4.b((boolean) r9)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "keysToInclude"
            org.json.JSONArray r6 = r6.optJSONArray(r9)     // Catch:{ Exception -> 0x0c9f }
            if (r6 == 0) goto L_0x0ba6
            r9 = 0
        L_0x0b96:
            int r10 = r6.length()     // Catch:{ Exception -> 0x0c9f }
            if (r9 >= r10) goto L_0x0ba6
            java.lang.String r10 = r6.optString(r9)     // Catch:{ Exception -> 0x0c9f }
            r4.a((java.lang.String) r10)     // Catch:{ Exception -> 0x0c9f }
            int r9 = r9 + 1
            goto L_0x0b96
        L_0x0ba6:
            r6 = r94
            if (r6 == 0) goto L_0x0bc6
            java.lang.String r9 = "name"
            java.lang.String r3 = r6.optString(r9, r3)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r9 = "id"
            java.lang.String r10 = "-1"
            java.lang.String r9 = r6.optString(r9, r10)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r10 = "custom"
            org.json.JSONObject r6 = r6.optJSONObject(r10)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.gb r10 = new com.ironsource.gb     // Catch:{ Exception -> 0x0c9f }
            r10.<init>(r3, r9, r6)     // Catch:{ Exception -> 0x0c9f }
            r26 = r10
            goto L_0x0bc8
        L_0x0bc6:
            r26 = r23
        L_0x0bc8:
            com.ironsource.o0 r3 = new com.ironsource.o0     // Catch:{ Exception -> 0x0c9f }
            if (r17 == 0) goto L_0x0bcf
        L_0x0bcc:
            r6 = r17
            goto L_0x0bd5
        L_0x0bcf:
            org.json.JSONObject r17 = new org.json.JSONObject     // Catch:{ Exception -> 0x0c9f }
            r17.<init>()     // Catch:{ Exception -> 0x0c9f }
            goto L_0x0bcc
        L_0x0bd5:
            r3.<init>(r6)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.n0 r6 = new com.ironsource.n0     // Catch:{ Exception -> 0x0c9f }
            r6.<init>()     // Catch:{ Exception -> 0x0c9f }
            r9 = r87
            if (r9 == 0) goto L_0x0bf7
            java.lang.String r6 = "mediationTypes"
            org.json.JSONObject r6 = r9.optJSONObject(r6)     // Catch:{ Exception -> 0x0c9f }
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ Exception -> 0x0c9f }
            r9.<init>()     // Catch:{ Exception -> 0x0c9f }
            if (r6 == 0) goto L_0x0bf2
            java.util.Map r9 = com.ironsource.mediationsdk.utils.IronSourceUtils.parseJsonToStringMap(r6)     // Catch:{ Exception -> 0x0c9f }
        L_0x0bf2:
            com.ironsource.n0 r6 = new com.ironsource.n0     // Catch:{ Exception -> 0x0c9f }
            r6.<init>(r9)     // Catch:{ Exception -> 0x0c9f }
        L_0x0bf7:
            r31 = r6
            com.ironsource.i0 r6 = new com.ironsource.i0     // Catch:{ Exception -> 0x0c9f }
            r6.<init>()     // Catch:{ Exception -> 0x0c9f }
            if (r1 == 0) goto L_0x0c09
            java.lang.String r1 = r1.optString(r8)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.i0 r6 = new com.ironsource.i0     // Catch:{ Exception -> 0x0c9f }
            r6.<init>(r1)     // Catch:{ Exception -> 0x0c9f }
        L_0x0c09:
            r33 = r6
            java.lang.String r1 = "integration"
            r6 = r16
            r8 = 0
            boolean r28 = r6.optBoolean(r1, r8)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.j0 r1 = new com.ironsource.j0     // Catch:{ Exception -> 0x0c9f }
            r24 = r1
            r25 = r11
            r27 = r2
            r29 = r4
            r30 = r3
            r32 = r5
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)     // Catch:{ Exception -> 0x0c9f }
            r2 = r35
            com.ironsource.bc r3 = r7.h(r2)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.m r2 = r7.b((org.json.JSONObject) r2)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.g2$a r4 = new com.ironsource.g2$a     // Catch:{ Exception -> 0x0c9f }
            r4.<init>()     // Catch:{ Exception -> 0x0c9f }
            r5 = r38
            r4.a((com.ironsource.ua) r5)     // Catch:{ Exception -> 0x0c9f }
            r5 = r18
            r4.a((com.ironsource.m7) r5)     // Catch:{ Exception -> 0x0c9f }
            r11 = r20
            r4.a((com.ironsource.p9) r11)     // Catch:{ Exception -> 0x0c9f }
            r5 = r110
            r4.a((com.ironsource.k1) r5)     // Catch:{ Exception -> 0x0c9f }
            r5 = r19
            r4.a((com.ironsource.a9) r5)     // Catch:{ Exception -> 0x0c9f }
            r4.a((com.ironsource.j0) r1)     // Catch:{ Exception -> 0x0c9f }
            r4.b((com.ironsource.bc) r3)     // Catch:{ Exception -> 0x0c9f }
            r4.a((com.ironsource.m) r2)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.g2 r1 = r4.a()     // Catch:{ Exception -> 0x0c9f }
            r7.Q1 = r1     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0c9f }
            r2.verbose(r1)     // Catch:{ Exception -> 0x0c9f }
            java.lang.String r1 = "genericParams"
            org.json.JSONObject r1 = r7.b(r14, r1)     // Catch:{ Exception -> 0x0c9f }
            if (r1 == 0) goto L_0x0c8a
            r2 = r96
            org.json.JSONObject r3 = r7.b(r1, r2)     // Catch:{ Exception -> 0x0c9f }
            if (r3 == 0) goto L_0x0c8a
            r1.remove(r2)     // Catch:{ Exception -> 0x0c9f }
            java.util.Map r2 = com.ironsource.mediationsdk.utils.IronSourceUtils.parseJsonToStringMap(r3)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.va r3 = com.ironsource.va.i()     // Catch:{ Exception -> 0x0c9f }
            r3.b((java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.n7 r3 = com.ironsource.n7.i()     // Catch:{ Exception -> 0x0c9f }
            r3.b((java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ Exception -> 0x0c9f }
        L_0x0c8a:
            if (r1 == 0) goto L_0x0ca4
            java.util.Map r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.parseJsonToStringMap(r1)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.va r2 = com.ironsource.va.i()     // Catch:{ Exception -> 0x0c9f }
            r2.a((java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ Exception -> 0x0c9f }
            com.ironsource.n7 r2 = com.ironsource.n7.i()     // Catch:{ Exception -> 0x0c9f }
            r2.a((java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ Exception -> 0x0c9f }
            goto L_0x0ca4
        L_0x0c9f:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x0ca4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.c.n():void");
    }

    private void o() {
        try {
            JSONObject b2 = b(this.T1, "providerOrder");
            JSONArray optJSONArray = b2.optJSONArray("rewardedVideo");
            JSONArray optJSONArray2 = b2.optJSONArray(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
            JSONArray optJSONArray3 = b2.optJSONArray("banner");
            JSONArray optJSONArray4 = b2.optJSONArray("nativeAd");
            this.O1 = new ma();
            if (!(optJSONArray == null || b() == null || b().g() == null)) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    this.O1.d(optString);
                    NetworkSettings b3 = na.c().b(optString);
                    if (b3 != null) {
                        b3.setRewardedVideoPriority(i2);
                    }
                }
            }
            if (!(optJSONArray2 == null || b() == null || b().d() == null)) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    String optString2 = optJSONArray2.optString(i3);
                    this.O1.b(optString2);
                    NetworkSettings b4 = na.c().b(optString2);
                    if (b4 != null) {
                        b4.setInterstitialPriority(i3);
                    }
                }
            }
            if (optJSONArray3 != null) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    String optString3 = optJSONArray3.optString(i4);
                    this.O1.a(optString3);
                    NetworkSettings b5 = na.c().b(optString3);
                    if (b5 != null) {
                        b5.setBannerPriority(i4);
                    }
                }
            }
            if (optJSONArray4 != null) {
                for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                    String optString4 = optJSONArray4.optString(i5);
                    this.O1.c(optString4);
                    NetworkSettings b6 = na.c().b(optString4);
                    if (b6 != null) {
                        b6.setNativeAdPriority(i5);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void p() {
        JSONObject jSONObject;
        Iterator<String> it;
        c cVar;
        NetworkSettings networkSettings;
        c cVar2 = this;
        try {
            cVar2.P1 = na.c();
            JSONObject b2 = cVar2.b(cVar2.T1, "providerSettings");
            Iterator<String> keys = b2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = b2.optJSONObject(next);
                if (optJSONObject != null) {
                    boolean optBoolean = optJSONObject.optBoolean("mpis", false);
                    String optString = optJSONObject.optString(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, "0");
                    String optString2 = optJSONObject.optString("adSourceName", (String) null);
                    String optString3 = optJSONObject.optString("providerLoadName", next);
                    String optString4 = optJSONObject.optString("providerDefaultInstance", optString3);
                    JSONObject b3 = cVar2.b(optJSONObject, "adUnits");
                    JSONObject b4 = cVar2.b(optJSONObject, m2.h.F);
                    JSONObject b5 = cVar2.b(b3, "rewardedVideo");
                    JSONObject b6 = cVar2.b(b3, IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
                    JSONObject b7 = cVar2.b(b3, "banner");
                    JSONObject b8 = cVar2.b(b3, "nativeAd");
                    JSONObject mergeJsons = IronSourceUtils.mergeJsons(b5, b4);
                    JSONObject mergeJsons2 = IronSourceUtils.mergeJsons(b6, b4);
                    JSONObject mergeJsons3 = IronSourceUtils.mergeJsons(b7, b4);
                    JSONObject mergeJsons4 = IronSourceUtils.mergeJsons(b8, b4);
                    if (cVar2.P1.a(next)) {
                        NetworkSettings b9 = cVar2.P1.b(next);
                        JSONObject rewardedVideoSettings = b9.getRewardedVideoSettings();
                        JSONObject interstitialSettings = b9.getInterstitialSettings();
                        JSONObject bannerSettings = b9.getBannerSettings();
                        JSONObject nativeAdSettings = b9.getNativeAdSettings();
                        b9.setRewardedVideoSettings(IronSourceUtils.mergeJsons(rewardedVideoSettings, mergeJsons));
                        b9.setInterstitialSettings(IronSourceUtils.mergeJsons(interstitialSettings, mergeJsons2));
                        b9.setBannerSettings(IronSourceUtils.mergeJsons(bannerSettings, mergeJsons3));
                        b9.setNativeAdSettings(IronSourceUtils.mergeJsons(nativeAdSettings, mergeJsons4));
                        b9.setIsMultipleInstances(optBoolean);
                        b9.setSubProviderId(optString);
                        b9.setAdSourceNameForEvents(optString2);
                    } else {
                        if (cVar2.a(optString3)) {
                            NetworkSettings b10 = cVar2.P1.b("Mediation");
                            JSONObject rewardedVideoSettings2 = b10.getRewardedVideoSettings();
                            JSONObject interstitialSettings2 = b10.getInterstitialSettings();
                            JSONObject bannerSettings2 = b10.getBannerSettings();
                            JSONObject nativeAdSettings2 = b10.getNativeAdSettings();
                            jSONObject = b2;
                            JSONObject jSONObject2 = new JSONObject(rewardedVideoSettings2.toString());
                            it = keys;
                            JSONObject jSONObject3 = new JSONObject(interstitialSettings2.toString());
                            try {
                                JSONObject jSONObject4 = new JSONObject(bannerSettings2.toString());
                                JSONObject jSONObject5 = new JSONObject(nativeAdSettings2.toString());
                                networkSettings = new NetworkSettings(next, optString3, optString4, b4, IronSourceUtils.mergeJsons(jSONObject2, mergeJsons), IronSourceUtils.mergeJsons(jSONObject3, mergeJsons2), IronSourceUtils.mergeJsons(jSONObject4, mergeJsons3), IronSourceUtils.mergeJsons(jSONObject5, mergeJsons4));
                                networkSettings.setIsMultipleInstances(optBoolean);
                                networkSettings.setSubProviderId(optString);
                                networkSettings.setAdSourceNameForEvents(optString2);
                                cVar = this;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        } else {
                            jSONObject = b2;
                            it = keys;
                            cVar = cVar2;
                            networkSettings = new NetworkSettings(next, optString3, optString4, b4, mergeJsons, mergeJsons2, mergeJsons3, mergeJsons4);
                            networkSettings.setIsMultipleInstances(optBoolean);
                            networkSettings.setSubProviderId(optString);
                            networkSettings.setAdSourceNameForEvents(optString2);
                        }
                        try {
                            cVar.P1.a(networkSettings);
                            cVar2 = cVar;
                            b2 = jSONObject;
                            keys = it;
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    }
                }
            }
            cVar2.P1.a();
        } catch (Exception e4) {
            e = e4;
            c cVar3 = cVar2;
            e.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.V1 = aVar;
    }

    public g2 b() {
        return this.Q1;
    }

    public c7 d() {
        return new c7(this.R1, this.S1);
    }

    public List<IronSource.AD_UNIT> e() {
        ma maVar;
        ma maVar2;
        ma maVar3;
        ma maVar4;
        if (this.T1 == null || this.Q1 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!(this.Q1.g() == null || (maVar4 = this.O1) == null || maVar4.d().isEmpty())) {
            arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
        if (!(this.Q1.d() == null || (maVar3 = this.O1) == null || maVar3.b().isEmpty())) {
            arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
        }
        if (this.Q1.f() != null) {
            arrayList.add(IronSource.AD_UNIT.OFFERWALL);
        }
        if (!(this.Q1.c() == null || (maVar2 = this.O1) == null || maVar2.a().isEmpty())) {
            arrayList.add(IronSource.AD_UNIT.BANNER);
        }
        if (!(this.Q1.e() == null || (maVar = this.O1) == null || maVar.c().isEmpty())) {
            arrayList.add(IronSource.AD_UNIT.NATIVE_AD);
        }
        return arrayList;
    }

    public a f() {
        return this.V1;
    }

    public JSONObject g() {
        return this.T1;
    }

    public ma h() {
        return this.O1;
    }

    public na i() {
        return this.P1;
    }

    public boolean k() {
        return b().b().j().f();
    }

    public boolean l() {
        return !TextUtils.isEmpty(b().h().b());
    }

    public boolean m() {
        JSONObject jSONObject = this.T1;
        return (jSONObject == null || jSONObject.has("error") || this.O1 == null || this.P1 == null || this.Q1 == null || !j()) ? false : true;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", this.R1);
            jSONObject.put("userId", this.S1);
            jSONObject.put(Y1, this.T1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
