package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.a.a.a;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.h;
import com.applovin.impl.privacy.a.c;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.privacy.b.b;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.sdk.a.f;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.d.c;
import com.applovin.impl.sdk.d.g;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.l;
import com.applovin.impl.sdk.e.p;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.network.d;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.q;
import com.applovin.impl.sdk.utils.t;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.w;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTargetingData;
import com.applovin.sdk.AppLovinUserSegment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
    public static n aAC;
    public static n aAD;
    private static final long aAE = System.currentTimeMillis();
    private static final boolean aAF;
    private static volatile a aAG;
    private static final Object aAH = new Object();
    protected static Context hr;
    private String aAI;
    private WeakReference<Activity> aAJ;
    private long aAK;
    private boolean aAL;
    private long aAM;
    /* access modifiers changed from: private */
    public final AtomicBoolean aAN = new AtomicBoolean();
    private boolean aAO;
    private AppLovinSdkSettings aAP;
    private AppLovinUserSegment aAQ;
    private AppLovinTargetingData aAR;
    private String aAS;
    private final Object aAT = new Object();
    private volatile AppLovinNativeAdService aAU;
    private final Object aAV = new Object();
    private volatile EventServiceImpl aAW;
    private final Object aAX = new Object();
    private volatile UserServiceImpl aAY;
    private final Object aAZ = new Object();
    private final Object aBA = new Object();
    private volatile d aBB;
    private final Object aBC = new Object();
    private volatile b aBD;
    private final Object aBE = new Object();
    private volatile t aBF;
    private final Object aBG = new Object();
    private volatile c aBH;
    private final Object aBI = new Object();
    private volatile SessionTracker aBJ;
    private final Object aBK = new Object();
    private volatile u aBL;
    private final Object aBM = new Object();
    private volatile ae aBN;
    private final Object aBO = new Object();
    private volatile d aBP;
    private final Object aBQ = new Object();
    private volatile k aBR;
    private final Object aBS = new Object();
    private volatile q aBT;
    private final Object aBU = new Object();
    private volatile i aBV;
    private final Object aBW = new Object();
    private volatile com.applovin.impl.privacy.a.c aBX;
    private final Object aBY = new Object();
    private volatile b aBZ;
    private volatile CmpServiceImpl aBa;
    private final Object aBb = new Object();
    private volatile AppLovinSdk aBc;
    private final Object aBd = new Object();
    private volatile com.applovin.impl.sdk.e.q aBe;
    private final Object aBf = new Object();
    private volatile com.applovin.impl.sdk.c.c aBg;
    private final Object aBh = new Object();
    private volatile com.applovin.impl.sdk.network.b aBi;
    private final Object aBj = new Object();
    private volatile g aBk;
    private final Object aBl = new Object();
    private volatile q aBm;
    private final Object aBn = new Object();
    private volatile o aBo;
    private final Object aBp = new Object();
    private volatile p aBq;
    private final Object aBr = new Object();
    private volatile Boolean aBs;
    private volatile aa aBt;
    private final Object aBu = new Object();
    private volatile e aBv;
    private final Object aBw = new Object();
    private volatile m aBx;
    private final Object aBy = new Object();
    private volatile t aBz;
    private final Object aCA = new Object();
    private volatile com.applovin.impl.mediation.debugger.b aCB;
    private final Object aCC = new Object();
    private volatile y aCD;
    private final Object aCE = new Object();
    private volatile com.applovin.impl.mediation.d aCF;
    private final Object aCG = new Object();
    private volatile com.applovin.impl.mediation.debugger.ui.testmode.c aCH;
    private final Object aCI = new Object();
    /* access modifiers changed from: private */
    public List<MaxAdFormat> aCJ;
    /* access modifiers changed from: private */
    public final Object aCK = new Object();
    private final AtomicBoolean aCL = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public final AtomicBoolean aCM = new AtomicBoolean();
    /* access modifiers changed from: private */
    public boolean aCN = false;
    private boolean aCO = false;
    private boolean aCP = false;
    private boolean aCQ = false;
    private boolean aCR = false;
    private int aCS = 0;
    private String aCT;
    private AppLovinSdk.SdkInitializationListener aCU;
    private AppLovinSdk.SdkInitializationListener aCV;
    /* access modifiers changed from: private */
    public AppLovinSdkConfiguration aCW;
    private final Object aCa = new Object();
    private volatile a aCb;
    private final Object aCc = new Object();
    private volatile f aCd;
    private final Object aCe = new Object();
    private volatile w aCf;
    private final Object aCg = new Object();
    private volatile ArrayService aCh;
    private final Object aCi = new Object();
    private volatile r aCj;
    private final Object aCk = new Object();
    private volatile PostbackServiceImpl aCl;
    private final Object aCm = new Object();
    private volatile com.applovin.impl.sdk.network.f aCn;
    private final Object aCo = new Object();
    private volatile f aCp;
    private final Object aCq = new Object();
    private volatile com.applovin.impl.mediation.f aCr;
    private final Object aCs = new Object();
    private volatile com.applovin.impl.mediation.e aCt;
    private final Object aCu = new Object();
    private volatile MediationServiceImpl aCv;
    private final Object aCw = new Object();
    private volatile com.applovin.impl.mediation.a.d aCx;
    private final Object aCy = new Object();
    private volatile h aCz;
    private volatile AppLovinAdServiceImpl age;
    private boolean iV = false;
    private volatile x logger;

    public static long CH() {
        return aAE;
    }

    public static boolean CI() {
        return aAF;
    }

    public static Context getApplicationContext() {
        return hr;
    }

    public boolean BL() {
        return this.aCP;
    }

    public boolean Bq() {
        return this.aAL;
    }

    public long CJ() {
        return this.aAK;
    }

    public boolean CK() {
        return this.aCO;
    }

    public String CL() {
        return this.aCT;
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.aBc = appLovinSdk;
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.aCW;
    }

    public String getSdkKey() {
        return this.aAI;
    }

    public AppLovinSdkSettings getSettings() {
        return this.aAP;
    }

    public AppLovinUserSegment getUserSegment() {
        return this.aAQ;
    }

    public AppLovinSdk getWrappingSdk() {
        return this.aBc;
    }

    static {
        boolean z;
        try {
            AppLovinSdkUtils.runOnUiThread(new n$$ExternalSyntheticLambda10());
            z = true;
        } catch (Throwable th) {
            aAF = false;
            throw th;
        }
        aAF = z;
    }

    public void initializeSdk(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (!isEnabled()) {
            this.aCU = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            AppLovinSdkUtils.runOnUiThread(new n$$ExternalSyntheticLambda1(this, sdkInitializationListener));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.aCW);
    }

    public void a(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.aAI = str;
        this.aAK = System.currentTimeMillis();
        this.aCN = true;
        this.aAP = appLovinSdkSettings;
        this.aAQ = new h();
        this.aAR = new AppLovinTargetingDataImpl();
        this.aCW = new SdkConfigurationImpl((List<String>) null, this);
        hr = context.getApplicationContext();
        if (CI()) {
            if (context instanceof Activity) {
                this.aAJ = new WeakReference<>((Activity) context);
            }
            if ("HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(str)) {
                this.aAL = true;
                aAD = this;
            } else if (aAC == null) {
                aAC = this;
            } else {
                x.H("AppLovinSdk", "Multiple SDK instances detected");
            }
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.applovin.sdk.1", 0);
            boolean z = sharedPreferences.getBoolean("com.applovin.sdk." + u.dD(str) + ".lisvib", false);
            this.aAO = z;
            if (!z) {
                Bj();
                Bk();
            } else {
                u.k(new n$$ExternalSyntheticLambda8(this));
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return;
        }
        throw new RuntimeException("As of version 12.0.0, the AppLovin MAX SDK requires Java 8. For more information visit our docs: https://dash.applovin.com/documentation/mediation/android/getting-started/integration");
    }

    private void Bj() {
        this.aBv = new e(this);
        this.aBg = new com.applovin.impl.sdk.c.c(this);
        this.logger = new x(this);
        this.aBF = new t(this);
        this.aBB = new d(this);
        this.aBD = new b(this);
        this.aAW = new EventServiceImpl(this);
        this.aAY = new UserServiceImpl(this);
        this.aBH = new c(this);
        this.aBe = new com.applovin.impl.sdk.e.q(this);
        this.aBi = new com.applovin.impl.sdk.network.b(this);
        this.aBk = new g(this);
        this.aCd = new f(this);
        this.aBT = new q(this);
        if (((Boolean) a(com.applovin.impl.sdk.c.b.aOo)).booleanValue()) {
            this.aBm = new q(this);
            this.aBq = new p(this);
        } else {
            this.aBo = new o(this);
        }
        CG();
        this.age = new AppLovinAdServiceImpl(this);
        this.aAU = new AppLovinNativeAdService(this);
        this.aBJ = new SessionTracker(this);
        this.aBL = new u(this);
        this.aBN = new ae(this);
        this.aCl = new PostbackServiceImpl(this);
        this.aCp = new f(this);
        this.aCr = new com.applovin.impl.mediation.f(this);
        this.aCt = new com.applovin.impl.mediation.e(this);
        this.aCv = new MediationServiceImpl(this);
        this.aCx = new com.applovin.impl.mediation.a.d(this);
        this.aCD = new y(this);
        this.aCB = new com.applovin.impl.mediation.debugger.b(this);
        this.aCz = new h();
        this.aCF = new com.applovin.impl.mediation.d(this);
        this.aBx = new m(this);
        this.aBV = new i(this);
        this.aCH = new com.applovin.impl.mediation.debugger.ui.testmode.c(this);
        this.aBX = new com.applovin.impl.privacy.a.c(this);
        this.aBZ = new b(this);
        this.aCb = new a(this);
        this.aCf = new w(this);
        this.aCh = new ArrayService(this);
        this.aCj = new r(this);
        this.aCn = new com.applovin.impl.sdk.network.f(this);
        this.aBR = new k(this);
        this.aBz = new t(this);
    }

    /* access modifiers changed from: private */
    public void Bk() {
        Context context = hr;
        x BN = BN();
        e BX = BX();
        com.applovin.impl.sdk.e.q BO = BO();
        com.applovin.impl.privacy.a.c Cl = Cl();
        E(context);
        Ce();
        Cv();
        Cr();
        Cx().a(MaxAdapter.InitializationStatus.INITIALIZING);
        if (this.aAP.isExceptionHandlerEnabled() && ((Boolean) a(com.applovin.impl.sdk.c.b.aKA)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        if (((Boolean) a(com.applovin.impl.sdk.c.b.aNW)).booleanValue()) {
            this.aBP = new d(context);
        }
        if (TextUtils.isEmpty(this.aAI)) {
            x.H("AppLovinSdk", "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
            x.H("AppLovinSdk", "Called with an invalid SDK key from: " + Log.getStackTraceString(new Throwable("")));
        }
        if (this.aAI.length() != 86 && u.b(context, this)) {
            x.H("AppLovinSdk", "Please double-check that you entered your SDK key correctly (" + this.aAI + ") : " + Log.getStackTraceString(new Throwable("")));
        }
        if (u.LD()) {
            x.H("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!u.O(this)) {
            x.H("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (u.ae(context)) {
            this.aAP.setVerboseLogging(true);
        }
        BP().a((com.applovin.impl.sdk.c.b<?>) com.applovin.impl.sdk.c.b.aKq, (Object) Boolean.valueOf(this.aAP.isVerboseLoggingEnabled()));
        Class<com.applovin.impl.adview.d> cls = com.applovin.impl.adview.d.class;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (TextUtils.isEmpty((String) BX.b(com.applovin.impl.sdk.c.d.aRh, null, defaultSharedPreferences))) {
            this.aCO = true;
            BX.a(com.applovin.impl.sdk.c.d.aRh, Boolean.toString(true), defaultSharedPreferences);
        } else {
            BX.a(com.applovin.impl.sdk.c.d.aRh, Boolean.toString(false), defaultSharedPreferences);
        }
        if (((Boolean) BX.b(com.applovin.impl.sdk.c.d.aRi, false)).booleanValue()) {
            if (x.Fn()) {
                BN.f("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.aCP = true;
        } else {
            if (x.Fn()) {
                BN.f("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            BX.a(com.applovin.impl.sdk.c.d.aRi, true);
            BX.a(com.applovin.impl.sdk.c.d.aRt, Boolean.valueOf(Cl.isEnabled()));
        }
        String str = (String) BX.b(com.applovin.impl.sdk.c.d.aRj, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE > u.dG(str)) {
                BX.a(com.applovin.impl.sdk.c.d.aRj, AppLovinSdk.VERSION);
            }
        } else {
            BX.a(com.applovin.impl.sdk.c.d.aRj, AppLovinSdk.VERSION);
        }
        boolean aa = i.aa(getApplicationContext());
        long parseInt = (long) StringUtils.parseInt(this.aAP.getExtraParameters().get(AppLovinSdkExtraParameterKey.INITIALIZATION_DELAY_MILLIS), ((Integer) a(com.applovin.impl.sdk.c.b.aOZ)).intValue());
        BO.a((com.applovin.impl.sdk.e.d) new ab(this, true, "scheduleAdLoadIntegrationError", new n$$ExternalSyntheticLambda3(this)), q.b.MAIN, parseInt);
        BO.a((com.applovin.impl.sdk.e.d) new ab(this, true, "sdkInit", new n$$ExternalSyntheticLambda4(this, aa, BN, Cl)), q.b.MAIN, parseInt);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void CP() {
        if (Br() && !Bq()) {
            v.w(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, x xVar, com.applovin.impl.privacy.a.c cVar) {
        synchronized (this.aCK) {
            if (!((Boolean) a(com.applovin.impl.sdk.c.b.aNX)).booleanValue() || z) {
                Bm();
            }
            if (((Boolean) a(com.applovin.impl.sdk.c.b.aNW)).booleanValue() && !z) {
                if (x.Fn()) {
                    xVar.g("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                }
                Bw();
            }
            if (cVar.zX() == d.a.TERMS) {
                if (Br()) {
                    if (x.Fn()) {
                        xVar.f("AppLovinSdk", "MAX mediation detected... Generating consent flow...");
                    }
                    cVar.Aa();
                    cVar.a(CF(), (c.a) new c.a() {
                        public void onFlowCompleted(com.applovin.impl.privacy.a.a aVar) {
                        }
                    });
                } else if (x.Fn()) {
                    xVar.f("AppLovinSdk", "non-MAX mediation detected, mediation provider is: " + this.aAS);
                }
            }
        }
    }

    public void aK(boolean z) {
        synchronized (this.aCK) {
            this.aCN = false;
            this.iV = z;
        }
        if (z) {
            List<String> b = b(com.applovin.impl.sdk.c.a.aJe);
            if (b.isEmpty()) {
                BO().KM();
                Bv();
                return;
            }
            Long l = (Long) a(com.applovin.impl.sdk.c.a.aJf);
            ab abVar = new ab(this, true, "timeoutInitAdapters", new n$$ExternalSyntheticLambda5(this));
            BN();
            if (x.Fn()) {
                x BN = BN();
                BN.f("AppLovinSdk", "Waiting for required adapters to init: " + b + " - timing out in " + l + "ms...");
            }
            BO().a(abVar, q.b.MEDIATION_TIMEOUT, l.longValue(), true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void CO() {
        if (!BO().isInitialized()) {
            BN();
            if (x.Fn()) {
                BN().f("AppLovinSdk", "Timing out adapters init...");
            }
            BO().KM();
            Bv();
        }
    }

    public void e(com.applovin.impl.mediation.b.f fVar) {
        if (!BO().isInitialized()) {
            List<String> b = b(com.applovin.impl.sdk.c.a.aJe);
            if (b.size() > 0 && Cx().tV().keySet().containsAll(b)) {
                BN();
                if (x.Fn()) {
                    BN().f("AppLovinSdk", "All required adapters initialized");
                }
                BO().KM();
                Bv();
            }
        }
    }

    public void Bl() {
        synchronized (this.aCK) {
            if (!this.aCN && !this.iV) {
                Bm();
            }
        }
    }

    public void Bm() {
        synchronized (this.aCK) {
            this.aCN = true;
            BO().KL();
            Bn();
        }
    }

    private void Bn() {
        com.applovin.impl.sdk.e.q BO = BO();
        int i = this.aCS + 1;
        this.aCS = i;
        BO.a((com.applovin.impl.sdk.e.d) new l(i, this, new l.a() {
            public void G(JSONObject jSONObject) {
                boolean z = jSONObject != null && jSONObject.length() > 0;
                n.this.D(jSONObject);
                g.o(n.this);
                i.a(jSONObject, z, n.this);
                n.this.CB().h(JsonUtils.getBoolean(jSONObject, "smd", false).booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
                n nVar = n.this;
                List unused = nVar.aCJ = nVar.F(jSONObject);
                if (z) {
                    List<String> explode = CollectionUtils.explode(JsonUtils.getString(jSONObject, "eaaui", ""));
                    n nVar2 = n.this;
                    AppLovinSdkConfiguration unused2 = nVar2.aCW = new SdkConfigurationImpl(explode, nVar2);
                }
                n.this.CE().f(jSONObject);
                n.this.E(jSONObject);
                m.bj(((Boolean) n.this.a(com.applovin.impl.sdk.c.b.aQN)).booleanValue());
                m.bk(((Boolean) n.this.a(com.applovin.impl.sdk.c.b.aQO)).booleanValue());
                if (n.this.Bq() || !n.this.Br()) {
                    n.this.cz("Initializing SDK in non-MAX environment...");
                } else if (n.this.Cl().zX() == d.a.UNIFIED) {
                    Activity CF = n.this.CF();
                    if (n.this.aCM.compareAndSet(false, true)) {
                        n.this.Cl().Aa();
                        n.this.Cl().a(CF, (c.a) new c.a() {
                            public void onFlowCompleted(com.applovin.impl.privacy.a.a aVar) {
                                n.this.cz("Initializing SDK in MAX environment...");
                            }
                        });
                    } else {
                        n.this.cz("Initializing SDK in MAX environment...");
                    }
                } else {
                    n.this.cz("Initializing SDK in MAX environment...");
                }
                if (!((Boolean) n.this.a(com.applovin.impl.sdk.c.b.aNW)).booleanValue() || z || !i.aa(n.getApplicationContext())) {
                    n.this.Bo();
                    return;
                }
                n.this.BN();
                if (x.Fn()) {
                    n.this.BN().g("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                }
                n.this.Bw();
            }
        }), q.b.MAIN);
    }

    /* access modifiers changed from: private */
    public void Bo() {
        Long l = (Long) a(com.applovin.impl.sdk.c.b.aOf);
        if (l.longValue() >= 0 && this.aAN.compareAndSet(false, true)) {
            w.a(l.longValue(), false, this, new n$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void CN() {
        com.applovin.impl.sdk.e.q BO = BO();
        int i = this.aCS + 1;
        this.aCS = i;
        BO.a((com.applovin.impl.sdk.e.d) new l(i, this, new l.a() {
            public void G(JSONObject jSONObject) {
                if (jSONObject != null && jSONObject.length() > 0) {
                    n.this.D(jSONObject);
                }
                n.this.aAN.set(false);
                n.this.Bo();
            }
        }), q.b.MAIN);
    }

    /* access modifiers changed from: private */
    public void D(JSONObject jSONObject) {
        this.aAM = System.currentTimeMillis();
        i.j(jSONObject, this);
        i.i(jSONObject, this);
        i.k(jSONObject, this);
        com.applovin.impl.mediation.e.b.d(jSONObject, this);
        com.applovin.impl.mediation.e.b.e(jSONObject, this);
        com.applovin.impl.mediation.e.b.f(jSONObject, this);
        com.applovin.impl.mediation.e.b.z(jSONObject);
    }

    /* access modifiers changed from: private */
    public void cz(String str) {
        BN();
        if (x.Fn()) {
            BN().f("AppLovinSdk", str);
        }
        BO().b((com.applovin.impl.sdk.e.d) new p(this));
    }

    public boolean Bp() {
        boolean z;
        synchronized (this.aCK) {
            z = this.aCN;
        }
        return z;
    }

    public boolean isEnabled() {
        boolean z;
        synchronized (this.aCK) {
            z = this.iV;
        }
        return z;
    }

    public boolean Br() {
        return StringUtils.containsIgnoreCase(getMediationProvider(), "max");
    }

    public boolean Bs() {
        return u.dE("com.unity3d.player.UnityPlayerActivity");
    }

    public void Bt() {
        String str = (String) BX().b(com.applovin.impl.sdk.c.d.aRj, null);
        if (StringUtils.isValidString(str) && AppLovinSdk.VERSION_CODE < u.dG(str)) {
            x.H("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
        }
    }

    public void Bu() {
        Ch().Bd();
    }

    public void Bv() {
        AppLovinSdk.SdkInitializationListener sdkInitializationListener;
        if ((!Cl().zY() || Cl().zX() != d.a.UNIFIED) && (sdkInitializationListener = this.aCU) != null) {
            if (isEnabled()) {
                this.aCU = null;
                this.aCV = null;
                Cx().a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
            } else if (this.aCV != sdkInitializationListener) {
                Cx().a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
                if (((Boolean) a(com.applovin.impl.sdk.c.b.aKw)).booleanValue()) {
                    this.aCU = null;
                } else {
                    this.aCV = sdkInitializationListener;
                }
            } else {
                return;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new n$$ExternalSyntheticLambda0(this, sdkInitializationListener), Math.max(0, ((Long) a(com.applovin.impl.sdk.c.b.aKx)).longValue()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        BN();
        if (x.Fn()) {
            BN().f("AppLovinSdk", "Calling back publisher's initialization completion handler...");
        }
        sdkInitializationListener.onSdkInitialized(this.aCW);
    }

    /* access modifiers changed from: private */
    public void Bw() {
        final com.applovin.impl.sdk.network.d G = G(hr);
        G.a(new d.a() {
            public void CR() {
            }

            public void CQ() {
                n.this.BN();
                if (x.Fn()) {
                    n.this.BN().g("AppLovinSdk", "Connected to internet - re-initializing SDK");
                }
                synchronized (n.this.aCK) {
                    if (!n.this.aCN) {
                        n.this.Bm();
                    }
                }
                G.b((d.a) this);
            }
        });
    }

    /* access modifiers changed from: private */
    public void E(JSONObject jSONObject) {
        for (String H : JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList())) {
            x.H("AppLovinSdk", H);
        }
    }

    public void Bx() {
        x.H("AppLovinSdk", "Resetting SDK state...");
        long b = BR().b(com.applovin.impl.sdk.d.f.aTa);
        BP().JH();
        BP().JF();
        BR().JW();
        BR().b(com.applovin.impl.sdk.d.f.aTa, b + 1);
        if (this.aCL.compareAndSet(true, false)) {
            Bm();
        } else {
            this.aCL.set(true);
        }
    }

    /* access modifiers changed from: private */
    public List<MaxAdFormat> F(JSONObject jSONObject) {
        List<String> asList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(asList.size());
        for (String formatFromString : asList) {
            MaxAdFormat formatFromString2 = MaxAdFormat.formatFromString(formatFromString);
            if (formatFromString2 != null) {
                arrayList.add(formatFromString2);
            }
        }
        return arrayList;
    }

    public <T> T a(com.applovin.impl.sdk.c.b<T> bVar) {
        return BP().a(bVar);
    }

    public List<String> b(com.applovin.impl.sdk.c.b<String> bVar) {
        return BP().b(bVar);
    }

    public List<MaxAdFormat> c(com.applovin.impl.sdk.c.b<String> bVar) {
        return BP().c(bVar);
    }

    public boolean a(com.applovin.impl.sdk.c.b<String> bVar, MaxAdFormat maxAdFormat) {
        return c(bVar).contains(maxAdFormat);
    }

    public <T> void a(com.applovin.impl.sdk.c.d<T> dVar, T t) {
        BX().a(dVar, t);
    }

    public <T> void a(com.applovin.impl.sdk.c.d<T> dVar, T t, SharedPreferences sharedPreferences) {
        BX().a(dVar, t, sharedPreferences);
    }

    public <T> void a(String str, T t, SharedPreferences.Editor editor) {
        BX().a(str, t, editor);
    }

    public <T> T a(com.applovin.impl.sdk.c.d<T> dVar) {
        return b(dVar, (Object) null);
    }

    public <T> T b(com.applovin.impl.sdk.c.d<T> dVar, T t) {
        return BX().b(dVar, t);
    }

    public <T> T b(com.applovin.impl.sdk.c.d<T> dVar, T t, SharedPreferences sharedPreferences) {
        return BX().b(dVar, t, sharedPreferences);
    }

    public <T> T a(String str, T t, Class<?> cls, SharedPreferences sharedPreferences) {
        return e.a(str, t, (Class) cls, sharedPreferences);
    }

    public <T> void b(com.applovin.impl.sdk.c.d<T> dVar) {
        BX().b(dVar);
    }

    public void a(SharedPreferences sharedPreferences) {
        BX().a(sharedPreferences);
    }

    public static String cl(String str) {
        return b(str, (List<String>) null);
    }

    public static String gA(int i) {
        return c(i, (List<String>) null);
    }

    public static String b(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Context applicationContext = getApplicationContext();
        return c(applicationContext.getResources().getIdentifier(str, "string", applicationContext.getPackageName()), list);
    }

    public static String c(int i, List<String> list) {
        String string = getApplicationContext().getResources().getString(i);
        return list != null ? String.format(string, list.toArray()) : string;
    }

    public boolean g(MaxAdFormat maxAdFormat) {
        List<MaxAdFormat> list = this.aCJ;
        return list != null && list.size() > 0 && !this.aCJ.contains(maxAdFormat);
    }

    public void showMediationDebugger() {
        showMediationDebugger((Map<String, List<?>>) null);
    }

    public void showMediationDebugger(Map<String, List<?>> map) {
        CB().showMediationDebugger(map);
    }

    public void showCreativeDebugger() {
        Co().showCreativeDebugger();
    }

    public void bN(long j) {
        BY().bL(j);
    }

    public long By() {
        if (this.aAM == 0) {
            return -1;
        }
        return System.currentTimeMillis() - this.aAM;
    }

    public void setPluginVersion(String str) {
        x.D("AppLovinSdk", "Setting plugin version: " + str);
        if (!u.Lx() || !this.aAO) {
            BP().a((com.applovin.impl.sdk.c.b<?>) com.applovin.impl.sdk.c.b.aOD, (Object) str);
        } else {
            u.k(new n$$ExternalSyntheticLambda7(this, str));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cC(String str) {
        BP().a((com.applovin.impl.sdk.c.b<?>) com.applovin.impl.sdk.c.b.aOD, (Object) str);
    }

    public void cA(String str) {
        BN();
        if (x.Fn()) {
            x BN = BN();
            BN.f("AppLovinSdk", "Setting user id: " + str);
        }
        if (StringUtils.isValidString(str) && str.length() > u.gX(8)) {
            x.H("AppLovinSdk", "Provided user id longer than supported (" + str.length() + " bytes, " + u.gX(8) + " maximum)");
        }
        if (!u.Lx() || !this.aAO) {
            BZ().cA(str);
        } else {
            u.k(new n$$ExternalSyntheticLambda9(this, str));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cB(String str) {
        BZ().cA(str);
    }

    public String Bz() {
        return BZ().Bz();
    }

    public String BA() {
        return BZ().BA();
    }

    public String BB() {
        return BZ().Lv();
    }

    public AppLovinTargetingDataImpl BC() {
        return (AppLovinTargetingDataImpl) this.aAR;
    }

    public void setMediationProvider(String str) {
        BN();
        if (x.Fn()) {
            x BN = BN();
            BN.f("AppLovinSdk", "setMediationProvider(mediationProvider=" + str + ")");
        }
        if (str == null || (!str.isEmpty() && str.length() <= 64 && StringUtils.isAlphaNumeric(str))) {
            this.aAS = str;
            if (!u.Lx() || !this.aAO) {
                b(com.applovin.impl.sdk.c.d.aRN);
            } else {
                u.k(new n$$ExternalSyntheticLambda6(this));
            }
        } else {
            x.H("AppLovinSdk", "Mediation provider set to invalid value: " + str + ". Please use a valid mediation provider (e.g., AppLovinMediationProvider.MAX)");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void CM() {
        b(com.applovin.impl.sdk.c.d.aRN);
    }

    public String getMediationProvider() {
        String str = (String) a(com.applovin.impl.sdk.c.d.aRN);
        return StringUtils.isValidString(str) ? str : this.aAS;
    }

    public static a E(Context context) {
        if (aAG == null) {
            synchronized (aAH) {
                if (aAG == null) {
                    aAG = new a(context);
                }
            }
        }
        return aAG;
    }

    public static void F(Context context) {
        if (context != null) {
            hr = context.getApplicationContext();
        }
    }

    public AppLovinAdServiceImpl BD() {
        if (this.age == null) {
            synchronized (this.aAT) {
                if (this.age == null) {
                    this.age = new AppLovinAdServiceImpl(this);
                }
            }
        }
        return this.age;
    }

    public AppLovinNativeAdService BE() {
        if (this.aAU == null) {
            synchronized (this.aAV) {
                if (this.aAU == null) {
                    this.aAU = new AppLovinNativeAdService(this);
                }
            }
        }
        return this.aAU;
    }

    public EventServiceImpl BF() {
        if (this.aAW == null) {
            synchronized (this.aAX) {
                if (this.aAW == null) {
                    this.aAW = new EventServiceImpl(this);
                }
            }
        }
        return this.aAW;
    }

    public UserServiceImpl BG() {
        if (this.aAY == null) {
            synchronized (this.aAZ) {
                if (this.aAY == null) {
                    this.aAY = new UserServiceImpl(this);
                }
            }
        }
        return this.aAY;
    }

    public void BH() {
        if (!StringUtils.isValidString(this.aCT)) {
            this.aCT = "max";
            BN();
            if (x.Fn()) {
                BN().f("AppLovinSdk", "Detected mediation provider: MAX");
            }
        }
    }

    public String BI() {
        if (StringUtils.isValidString(this.aCT)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Map<String, String> BJ = BJ();
        List<String> b = b(com.applovin.impl.sdk.c.b.aPc);
        Boolean bool = (Boolean) a(com.applovin.impl.sdk.c.b.aPd);
        if (BJ.isEmpty() && !bool.booleanValue()) {
            return null;
        }
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Integer num = (Integer) a(com.applovin.impl.sdk.c.b.aPb);
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (num.intValue() <= 0) {
                    break;
                }
                String className = stackTraceElement.getClassName();
                Iterator<String> it = b.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (className.startsWith(it.next())) {
                            break;
                        }
                    } else {
                        for (Map.Entry next : BJ.entrySet()) {
                            if (className.startsWith((String) next.getKey())) {
                                this.aCT = (String) next.getValue();
                                BN();
                                if (x.Fn()) {
                                    x BN = BN();
                                    BN.f("AppLovinSdk", "Detected mediation provider: " + this.aCT);
                                }
                                return null;
                            }
                        }
                        if (bool.booleanValue()) {
                            arrayList.add(className);
                        }
                        num = Integer.valueOf(num.intValue() - 1);
                    }
                }
                i++;
            }
        } catch (Throwable th) {
            Cs().d("AppLovinSdk", "detectMediationProvider", th);
        }
        this.aCT = "unknown";
        BN();
        if (x.Fn()) {
            BN().h("AppLovinSdk", "Unable to detect mediation provider");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return StringUtils.join(",", arrayList);
    }

    private Map<String, String> BJ() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) a(com.applovin.impl.sdk.c.b.aPa)));
        } catch (JSONException unused) {
            return Collections.emptyMap();
        }
    }

    public Activity BK() {
        WeakReference<Activity> weakReference = this.aAJ;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public a BM() {
        return E(hr);
    }

    public x BN() {
        if (this.logger == null) {
            synchronized (this.aBd) {
                if (this.logger == null) {
                    this.logger = new x(this);
                }
            }
        }
        return this.logger;
    }

    public com.applovin.impl.sdk.e.q BO() {
        if (this.aBe == null) {
            synchronized (this.aBf) {
                if (this.aBe == null) {
                    this.aBe = new com.applovin.impl.sdk.e.q(this);
                }
            }
        }
        return this.aBe;
    }

    public com.applovin.impl.sdk.c.c BP() {
        if (this.aBg == null) {
            synchronized (this.aBh) {
                if (this.aBg == null) {
                    this.aBg = new com.applovin.impl.sdk.c.c(this);
                }
            }
        }
        return this.aBg;
    }

    public com.applovin.impl.sdk.network.b BQ() {
        if (this.aBi == null) {
            synchronized (this.aBj) {
                if (this.aBi == null) {
                    this.aBi = new com.applovin.impl.sdk.network.b(this);
                }
            }
        }
        return this.aBi;
    }

    public g BR() {
        if (this.aBk == null) {
            synchronized (this.aBl) {
                if (this.aBk == null) {
                    this.aBk = new g(this);
                }
            }
        }
        return this.aBk;
    }

    public o BS() {
        if (this.aBo == null) {
            synchronized (this.aBp) {
                if (this.aBo == null) {
                    this.aBo = new o(this);
                }
            }
        }
        return this.aBo;
    }

    private boolean BT() {
        if (this.aBs == null) {
            this.aBs = (Boolean) a(com.applovin.impl.sdk.c.b.aOo);
        }
        return Boolean.TRUE.equals(this.aBs);
    }

    public q BU() {
        if (BT() && this.aBm == null) {
            synchronized (this.aBn) {
                if (this.aBm == null) {
                    this.aBm = new q(this);
                }
            }
        }
        return this.aBm;
    }

    public p BV() {
        if (BT() && this.aBq == null) {
            synchronized (this.aBr) {
                if (this.aBq == null) {
                    this.aBq = new p(this);
                }
            }
        }
        return this.aBq;
    }

    public aa BW() {
        if (this.aBt == null) {
            synchronized (this.aBu) {
                if (this.aBt == null) {
                    CG();
                }
            }
        }
        return this.aBt;
    }

    public e BX() {
        if (this.aBv == null) {
            synchronized (this.aBw) {
                if (this.aBv == null) {
                    this.aBv = new e(this);
                }
            }
        }
        return this.aBv;
    }

    public m BY() {
        if (this.aBx == null) {
            synchronized (this.aBy) {
                if (this.aBx == null) {
                    this.aBx = new m(this);
                }
            }
        }
        return this.aBx;
    }

    public t BZ() {
        if (this.aBz == null) {
            synchronized (this.aBA) {
                if (this.aBz == null) {
                    this.aBz = new t(this);
                }
            }
        }
        return this.aBz;
    }

    public d Ca() {
        if (this.aBB == null) {
            synchronized (this.aBC) {
                if (this.aBB == null) {
                    this.aBB = new d(this);
                }
            }
        }
        return this.aBB;
    }

    public b Cb() {
        if (this.aBD == null) {
            synchronized (this.aBE) {
                if (this.aBD == null) {
                    this.aBD = new b(this);
                }
            }
        }
        return this.aBD;
    }

    public t Cc() {
        if (this.aBF == null) {
            synchronized (this.aBG) {
                if (this.aBF == null) {
                    this.aBF = new t(this);
                }
            }
        }
        return this.aBF;
    }

    public com.applovin.impl.sdk.d.c Cd() {
        if (this.aBH == null) {
            synchronized (this.aBI) {
                if (this.aBH == null) {
                    this.aBH = new com.applovin.impl.sdk.d.c(this);
                }
            }
        }
        return this.aBH;
    }

    public SessionTracker Ce() {
        if (this.aBJ == null) {
            synchronized (this.aBK) {
                if (this.aBJ == null) {
                    this.aBJ = new SessionTracker(this);
                }
            }
        }
        return this.aBJ;
    }

    public u Cf() {
        if (this.aBL == null) {
            synchronized (this.aBM) {
                if (this.aBL == null) {
                    this.aBL = new u(this);
                }
            }
        }
        return this.aBL;
    }

    public ae Cg() {
        if (this.aBN == null) {
            synchronized (this.aBO) {
                if (this.aBN == null) {
                    this.aBN = new ae(this);
                }
            }
        }
        return this.aBN;
    }

    public com.applovin.impl.sdk.network.d G(Context context) {
        if (this.aBP == null) {
            synchronized (this.aBQ) {
                if (this.aBP == null) {
                    this.aBP = new com.applovin.impl.sdk.network.d(context);
                }
            }
        }
        return this.aBP;
    }

    public k Ch() {
        if (this.aBR == null) {
            synchronized (this.aBS) {
                if (this.aBR == null) {
                    this.aBR = new k(this);
                }
            }
        }
        return this.aBR;
    }

    public com.applovin.impl.sdk.utils.q Ci() {
        if (this.aBT == null) {
            synchronized (this.aBU) {
                if (this.aBT == null) {
                    this.aBT = new com.applovin.impl.sdk.utils.q(this);
                }
            }
        }
        return this.aBT;
    }

    public i Cj() {
        if (this.aBV == null) {
            synchronized (this.aBW) {
                if (this.aBV == null) {
                    this.aBV = new i(this);
                }
            }
        }
        return this.aBV;
    }

    public AppLovinSdkSettings.TermsAndPrivacyPolicyFlowSettings Ck() {
        return getSettings().getBackingConsentFlowSettings();
    }

    public com.applovin.impl.privacy.a.c Cl() {
        if (this.aBX == null) {
            synchronized (this.aBY) {
                if (this.aBX == null) {
                    this.aBX = new com.applovin.impl.privacy.a.c(this);
                }
            }
        }
        return this.aBX;
    }

    public b Cm() {
        if (this.aBZ == null) {
            synchronized (this.aCa) {
                if (this.aBZ == null) {
                    this.aBZ = new b(this);
                }
            }
        }
        return this.aBZ;
    }

    public CmpServiceImpl Cn() {
        if (this.aBa == null) {
            synchronized (this.aBb) {
                if (this.aBa == null) {
                    this.aBa = new CmpServiceImpl(this);
                }
            }
        }
        return this.aBa;
    }

    public a Co() {
        if (this.aCb == null) {
            synchronized (this.aCc) {
                if (this.aCb == null) {
                    this.aCb = new a(this);
                }
            }
        }
        return this.aCb;
    }

    public f Cp() {
        if (this.aCd == null) {
            synchronized (this.aCe) {
                if (this.aCd == null) {
                    this.aCd = new f(this);
                }
            }
        }
        return this.aCd;
    }

    public w Cq() {
        if (this.aCf == null) {
            synchronized (this.aCg) {
                if (this.aCf == null) {
                    this.aCf = new w(this);
                }
            }
        }
        return this.aCf;
    }

    public ArrayService Cr() {
        if (this.aCh == null) {
            synchronized (this.aCi) {
                if (this.aCh == null) {
                    this.aCh = new ArrayService(this);
                }
            }
        }
        return this.aCh;
    }

    public r Cs() {
        if (this.aCj == null) {
            synchronized (this.aCk) {
                if (this.aCj == null) {
                    this.aCj = new r(this);
                }
            }
        }
        return this.aCj;
    }

    public PostbackServiceImpl Ct() {
        if (this.aCl == null) {
            synchronized (this.aCm) {
                if (this.aCl == null) {
                    this.aCl = new PostbackServiceImpl(this);
                }
            }
        }
        return this.aCl;
    }

    public com.applovin.impl.sdk.network.f Cu() {
        if (this.aCn == null) {
            synchronized (this.aCo) {
                if (this.aCn == null) {
                    this.aCn = new com.applovin.impl.sdk.network.f(this);
                }
            }
        }
        return this.aCn;
    }

    public f Cv() {
        if (this.aCp == null) {
            synchronized (this.aCq) {
                if (this.aCp == null) {
                    this.aCp = new f(this);
                }
            }
        }
        return this.aCp;
    }

    public com.applovin.impl.mediation.f Cw() {
        if (this.aCr == null) {
            synchronized (this.aCs) {
                if (this.aCr == null) {
                    this.aCr = new com.applovin.impl.mediation.f(this);
                }
            }
        }
        return this.aCr;
    }

    public com.applovin.impl.mediation.e Cx() {
        if (this.aCt == null) {
            synchronized (this.aCu) {
                if (this.aCt == null) {
                    this.aCt = new com.applovin.impl.mediation.e(this);
                }
            }
        }
        return this.aCt;
    }

    public MediationServiceImpl Cy() {
        if (this.aCv == null) {
            synchronized (this.aCw) {
                if (this.aCv == null) {
                    this.aCv = new MediationServiceImpl(this);
                }
            }
        }
        return this.aCv;
    }

    public com.applovin.impl.mediation.a.d Cz() {
        if (this.aCx == null) {
            synchronized (this.aCy) {
                if (this.aCx == null) {
                    this.aCx = new com.applovin.impl.mediation.a.d(this);
                }
            }
        }
        return this.aCx;
    }

    public h CA() {
        if (this.aCz == null) {
            synchronized (this.aCA) {
                if (this.aCz == null) {
                    this.aCz = new h();
                }
            }
        }
        return this.aCz;
    }

    public com.applovin.impl.mediation.debugger.b CB() {
        if (this.aCB == null) {
            synchronized (this.aCC) {
                if (this.aCB == null) {
                    this.aCB = new com.applovin.impl.mediation.debugger.b(this);
                }
            }
        }
        return this.aCB;
    }

    public y CC() {
        if (this.aCD == null) {
            synchronized (this.aCE) {
                if (this.aCD == null) {
                    this.aCD = new y(this);
                }
            }
        }
        return this.aCD;
    }

    public com.applovin.impl.mediation.d CD() {
        if (this.aCF == null) {
            synchronized (this.aCG) {
                if (this.aCF == null) {
                    this.aCF = new com.applovin.impl.mediation.d(this);
                }
            }
        }
        return this.aCF;
    }

    public com.applovin.impl.mediation.debugger.ui.testmode.c CE() {
        if (this.aCH == null) {
            synchronized (this.aCI) {
                if (this.aCH == null) {
                    this.aCH = new com.applovin.impl.mediation.debugger.ui.testmode.c(this);
                }
            }
        }
        return this.aCH;
    }

    public Activity CF() {
        Activity Az = E(getApplicationContext()).Az();
        if (Az != null) {
            return Az;
        }
        return BK();
    }

    private void CG() {
        if (aa.N(hr) && !this.aCR) {
            try {
                this.aBt = new aa(this);
            } catch (Throwable th) {
                x.f("AppLovinSdk", "Failed to initialize Privacy Sandbox Service", th);
                this.aCR = true;
            }
        }
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.aAI + "', enabled=" + this.iV + ", isFirstSession=" + this.aCO + '}';
    }
}
