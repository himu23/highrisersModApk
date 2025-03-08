package com.fyber.inneractive.sdk.flow;

import android.os.Looper;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.adm.AdmParametersOuterClass$AdmParameters;
import com.fyber.inneractive.sdk.bidder.adm.f;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.g;
import com.fyber.inneractive.sdk.config.global.l;
import com.fyber.inneractive.sdk.config.global.q;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.config.n;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.k;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.network.t0;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class t implements w, c0 {
    public final String a;
    public InneractiveAdSpot.RequestListener b;
    public InneractiveAdRequest c;
    public k.a d;
    public q e;
    public e0 f;
    public Set<e0> g;
    public j h;
    public c i;
    public boolean j = true;
    public boolean k = false;
    public l l;

    public class a implements f.a {
        public final /* synthetic */ f a;
        public final /* synthetic */ s b;
        public final /* synthetic */ String c;

        public a(f fVar, s sVar, String str) {
            this.a = fVar;
            this.b = sVar;
            this.c = str;
        }

        public void a() {
            q a2;
            com.fyber.inneractive.sdk.config.global.b bVar;
            com.fyber.inneractive.sdk.config.global.k kVar;
            l lVar;
            q a3;
            t tVar = t.this;
            tVar.getClass();
            IAlog.a("%s : InneractiveAdSpotImpl markup data available", IAlog.a((Object) tVar));
            AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.a.a;
            if (admParametersOuterClass$AdmParameters != null) {
                s sVar = this.b;
                List<AdmParametersOuterClass$AdmParameters.Experiment> abExperimentsList = admParametersOuterClass$AdmParameters.getAbExperimentsList();
                sVar.getClass();
                com.fyber.inneractive.sdk.config.global.a aVar = IAConfigManager.M.z;
                aVar.getClass();
                for (g next : sVar.c.values()) {
                    if (!(next == null || (lVar = aVar.a) == null || (a3 = lVar.a(next.b)) == null)) {
                        next.a = a3.a;
                    }
                }
                if (abExperimentsList != null && abExperimentsList.size() > 0) {
                    com.fyber.inneractive.sdk.config.global.a aVar2 = IAConfigManager.M.z;
                    aVar2.b = sVar;
                    for (g next2 : sVar.c.values()) {
                        for (AdmParametersOuterClass$AdmParameters.Experiment next3 : abExperimentsList) {
                            String identifier = next3.getIdentifier();
                            String variant = next3.getVariant();
                            l lVar2 = aVar2.a;
                            if (!(lVar2 == null || (a2 = lVar2.a(next2.b)) == null || (bVar = a2.c.get(identifier)) == null)) {
                                Iterator<com.fyber.inneractive.sdk.config.global.k> it = bVar.c.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        kVar = null;
                                        break;
                                    }
                                    kVar = it.next();
                                    if (kVar.b.equals(variant)) {
                                        break;
                                    }
                                }
                                next2.c.put(bVar.a, bVar);
                                if (kVar != null) {
                                    next2.d.put(bVar.a, kVar);
                                }
                            }
                        }
                    }
                }
            }
        }

        public void a(Exception exc, InneractiveErrorCode inneractiveErrorCode, e... eVarArr) {
            com.fyber.inneractive.sdk.network.q qVar;
            t tVar = t.this;
            tVar.getClass();
            IAlog.a("%s : InneractiveAdSpotImpl data error", IAlog.a((Object) tVar));
            e eVar = eVarArr.length > 0 ? eVarArr[0] : null;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, g.ADM_FETCH_FAILED);
            k.a aVar = t.this.d;
            if (aVar != null) {
                ((u) aVar).a((InneractiveAdRequest) null, eVar, inneractiveInfrastructureError);
            }
            l lVar = t.this.l;
            if (lVar != null) {
                lVar.a((InneractiveAdRequest) null, eVar, inneractiveInfrastructureError);
            }
            t tVar2 = t.this;
            String str = this.c;
            s sVar = this.b;
            tVar2.getClass();
            if (inneractiveErrorCode.equals(InneractiveErrorCode.CONNECTION_ERROR) || inneractiveErrorCode.equals(InneractiveErrorCode.NO_FILL)) {
                qVar = com.fyber.inneractive.sdk.network.q.FATAL_ADM_MARKUP_FETCHING_ERROR;
            } else {
                qVar = com.fyber.inneractive.sdk.network.q.FATAL_ADM_PARSING_ERROR;
            }
            if (eVar != null) {
                eVar.B = false;
            }
            String name = exc.getClass().getName();
            if (exc instanceof t0) {
                t0 t0Var = (t0) exc;
                name = "NetworkStackException";
            }
            s.a aVar2 = new s.a(qVar, (InneractiveAdRequest) null, eVar, sVar.c());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exception", name);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "exception", name);
            }
            String localizedMessage = exc.getLocalizedMessage();
            Object obj = exc;
            if (localizedMessage != null) {
                obj = exc.getLocalizedMessage();
            }
            try {
                jSONObject.put("message", obj);
            } catch (Exception unused2) {
                IAlog.e("Got exception adding param to json object: %s, %s", "message", obj);
            }
            try {
                jSONObject.put("admPayload", str);
            } catch (Exception unused3) {
                IAlog.e("Got exception adding param to json object: %s, %s", "admPayload", str);
            }
            aVar2.f.put(jSONObject);
            aVar2.a((String) null);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            t.this.c();
        }
    }

    public interface c {
        void onAdRefreshFailed(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode);

        void onAdRefreshed(InneractiveAdSpot inneractiveAdSpot);
    }

    public t() {
        String uuid = UUID.randomUUID().toString();
        this.a = uuid;
        this.g = new HashSet();
        IAlog.a("%sInneractiveAdSpotImpl created with UID: %s", d(), uuid);
    }

    public void addUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            e0 e0Var = (e0) inneractiveUnitController;
            e0Var.setAdSpot(this);
            if (this.g.size() > 0) {
                Iterator it = new HashSet(this.g).iterator();
                while (it.hasNext()) {
                    InneractiveUnitController inneractiveUnitController2 = (InneractiveUnitController) it.next();
                    if (inneractiveUnitController2.getClass().equals(inneractiveUnitController.getClass())) {
                        e0 e0Var2 = this.f;
                        if (e0Var2 != null && e0Var2.equals(inneractiveUnitController2)) {
                            this.f.destroy();
                            this.f = null;
                        }
                        this.g.remove(inneractiveUnitController2);
                    }
                }
            }
            this.g.add(e0Var);
            if (this.e != null) {
                e();
            }
        }
    }

    public final void b() {
        IAConfigManager iAConfigManager = IAConfigManager.M;
        com.fyber.inneractive.sdk.measurement.a aVar = iAConfigManager.J;
        if (aVar == null || !aVar.a) {
            IAlog.a("%sinitOmidSdk", IAlog.a((Object) this));
            com.fyber.inneractive.sdk.util.q.a(new n(iAConfigManager, p.a));
        }
    }

    public final void c() {
        for (e0 destroy : this.g) {
            destroy.destroy();
        }
        this.g.clear();
        l lVar = this.l;
        if (lVar != null) {
            lVar.a(true);
            lVar.b = null;
            this.l = null;
        }
        j jVar = this.h;
        if (jVar != null) {
            jVar.b(true);
            this.h = null;
        }
        this.b = null;
        a();
        InneractiveAdSpotManager.get().removeSpot(this);
    }

    public final String d() {
        return IAlog.a((Object) this);
    }

    public void destroy() {
        if (Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) {
            com.fyber.inneractive.sdk.util.q.b.post(new b());
        } else {
            c();
        }
    }

    public final boolean e() {
        for (e0 next : this.g) {
            if (next.supports(this)) {
                this.f = next;
                return true;
            }
        }
        return false;
    }

    public q getAdContent() {
        return this.e;
    }

    public InneractiveAdRequest getCurrentProcessedRequest() {
        return this.c;
    }

    public String getLocalUniqueId() {
        return this.a;
    }

    public InneractiveMediationName getMediationName() {
        return IAConfigManager.M.n;
    }

    public String getMediationNameString() {
        return IAConfigManager.M.m;
    }

    public String getMediationVersion() {
        return IAConfigManager.M.o;
    }

    public String getRequestedSpotId() {
        InneractiveAdRequest inneractiveAdRequest = this.c;
        return inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : "";
    }

    public InneractiveUnitController getSelectedUnitController() {
        return this.f;
    }

    public void removeUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            e0 e0Var = this.f;
            if (e0Var != null && e0Var.equals(inneractiveUnitController)) {
                this.f.destroy();
                this.f = null;
            }
            this.g.remove(inneractiveUnitController);
        }
    }

    public void setMediationName(InneractiveMediationName inneractiveMediationName) {
        InneractiveAdManager.setMediationName(inneractiveMediationName);
    }

    public void setMediationVersion(String str) {
        InneractiveAdManager.setMediationVersion(str);
    }

    public void loadAd(String str) {
        IAlog.a("%s : InneractiveAdSpotImpl Start load ad process", IAlog.a((Object) this));
        System.currentTimeMillis();
        if (str == null || TextUtils.isEmpty(str)) {
            InneractiveAdSpot.RequestListener requestListener = this.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
            }
        } else if (!InneractiveAdManager.wasInitialized()) {
            InneractiveAdSpot.RequestListener requestListener2 = this.b;
            if (requestListener2 != null) {
                requestListener2.onInneractiveFailedAdRequest(this, InneractiveErrorCode.SDK_NOT_INITIALIZED);
            }
        } else {
            com.fyber.inneractive.sdk.metrics.c.d.a(this.a).c();
            String str2 = this.a;
            this.l = new l(str2);
            if (this.d == null) {
                this.d = new u(this);
            }
            f fVar = new f(str, str2);
            com.fyber.inneractive.sdk.config.global.s b2 = com.fyber.inneractive.sdk.config.global.s.b();
            a aVar = new a(fVar, b2, str);
            b();
            com.fyber.inneractive.sdk.util.q.a(new com.fyber.inneractive.sdk.bidder.adm.b(fVar, aVar, b2));
        }
    }

    public void requestAd(InneractiveAdRequest inneractiveAdRequest) {
        IAlog.a("%srequestAd called with request: %s", IAlog.a((Object) this), inneractiveAdRequest);
        if (inneractiveAdRequest == null && this.c == null) {
            IAlog.b("%srequestAd called with a null request, but no previous request is available! Cannot continue", IAlog.a((Object) this));
            InneractiveAdSpot.RequestListener requestListener = this.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
            }
        } else if (!InneractiveAdManager.wasInitialized()) {
            InneractiveAdSpot.RequestListener requestListener2 = this.b;
            if (requestListener2 != null) {
                requestListener2.onInneractiveFailedAdRequest(this, InneractiveErrorCode.SDK_NOT_INITIALIZED);
            }
        } else {
            InneractiveAdRequest inneractiveAdRequest2 = inneractiveAdRequest != null ? inneractiveAdRequest : this.c;
            String str = this.a;
            inneractiveAdRequest2.b = str;
            com.fyber.inneractive.sdk.metrics.c.d.a(str).c();
            if (this.g.isEmpty()) {
                IAlog.b("%srequestAd called but no AdUnitControllers exist! Cannot continue", IAlog.a((Object) this));
                if (this.b != null) {
                    if (inneractiveAdRequest == null) {
                        inneractiveAdRequest = this.c;
                    }
                    a(inneractiveAdRequest, (e) null);
                    this.b.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                    return;
                }
                return;
            }
            j jVar = this.h;
            if (jVar != null) {
                jVar.b(inneractiveAdRequest != null || this.c == null);
            }
            if (inneractiveAdRequest != null) {
                InneractiveAdRequest inneractiveAdRequest3 = this.c;
                if (inneractiveAdRequest3 != null) {
                    inneractiveAdRequest.setSelectedUnitConfig(inneractiveAdRequest3.getSelectedUnitConfig());
                }
                this.c = inneractiveAdRequest;
                q qVar = this.e;
                if (qVar != null) {
                    qVar.a();
                    this.j = true;
                }
                Iterator<e0> it = this.g.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next() instanceof InneractiveFullscreenUnitController) {
                            break;
                        }
                    } else {
                        this.c.a = false;
                        break;
                    }
                }
            }
            this.h = new j(this.a);
            if (this.d == null) {
                this.d = new u(this);
            }
            IAlog.a("%sFound ad source for request! %s", IAlog.a((Object) this), this.h);
            b();
            j jVar2 = this.h;
            if (jVar2 != null) {
                InneractiveAdRequest inneractiveAdRequest4 = this.c;
                jVar2.b = this.d;
                if (IAConfigManager.i()) {
                    jVar2.c(inneractiveAdRequest4);
                    return;
                }
                i iVar = new i(jVar2, inneractiveAdRequest4);
                jVar2.g = iVar;
                IAConfigManager.addListener(iVar);
                IAConfigManager.a();
            }
        }
    }

    public void setMediationName(String str) {
        InneractiveAdManager.setMediationName(str);
    }

    public void setRequestListener(InneractiveAdSpot.RequestListener requestListener) {
        IAlog.a("%ssetRequestListener called with: %s", IAlog.a((Object) this), requestListener);
        this.b = requestListener;
    }

    public void a(c cVar) {
        this.i = cVar;
        IAlog.a("%srequestAd called with request: %s", IAlog.a((Object) this), null);
        if (this.c == null) {
            IAlog.b("%srequestAd called with a null request, but no previous request is available! Cannot continue", IAlog.a((Object) this));
            InneractiveAdSpot.RequestListener requestListener = this.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
            }
        } else if (!InneractiveAdManager.wasInitialized()) {
            InneractiveAdSpot.RequestListener requestListener2 = this.b;
            if (requestListener2 != null) {
                requestListener2.onInneractiveFailedAdRequest(this, InneractiveErrorCode.SDK_NOT_INITIALIZED);
            }
        } else {
            InneractiveAdRequest inneractiveAdRequest = this.c;
            String str = this.a;
            inneractiveAdRequest.b = str;
            com.fyber.inneractive.sdk.metrics.c.d.a(str).c();
            if (this.g.isEmpty()) {
                IAlog.b("%srequestAd called but no AdUnitControllers exist! Cannot continue", IAlog.a((Object) this));
                if (this.b != null) {
                    a(this.c, (e) null);
                    this.b.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                    return;
                }
                return;
            }
            j jVar = this.h;
            if (jVar != null) {
                jVar.b(this.c == null);
            }
            this.h = new j(this.a);
            if (this.d == null) {
                this.d = new u(this);
            }
            IAlog.a("%sFound ad source for request! %s", IAlog.a((Object) this), this.h);
            b();
            j jVar2 = this.h;
            if (jVar2 != null) {
                InneractiveAdRequest inneractiveAdRequest2 = this.c;
                jVar2.b = this.d;
                if (IAConfigManager.i()) {
                    jVar2.c(inneractiveAdRequest2);
                    return;
                }
                i iVar = new i(jVar2, inneractiveAdRequest2);
                jVar2.g = iVar;
                IAConfigManager.addListener(iVar);
                IAConfigManager.a();
            }
        }
    }

    public boolean isReady() {
        q qVar;
        q qVar2 = this.e;
        if (qVar2 == null) {
            return false;
        }
        boolean z = qVar2.d() != null && this.e.d().c();
        if (z && (qVar = this.e) != null) {
            e d2 = qVar.d();
            if (!this.k && d2 != null) {
                long minutes = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - d2.c);
                long j2 = d2.b;
                long j3 = minutes - j2;
                IAlog.a(String.format("Firing Event 802 - AdExpired - time passed- %s, sessionTimeOut - %s", new Object[]{Long.valueOf(j3), Long.valueOf(j2)}), new Object[0]);
                s.a aVar = new s.a(com.fyber.inneractive.sdk.network.q.IA_AD_EXPIRED, qVar.a, d2, qVar.c.c());
                JSONObject jSONObject = new JSONObject();
                Long valueOf = Long.valueOf(j3);
                try {
                    jSONObject.put("time_passed", valueOf);
                } catch (Exception unused) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "time_passed", valueOf);
                }
                Long valueOf2 = Long.valueOf(j2);
                try {
                    jSONObject.put("timeout", valueOf2);
                } catch (Exception unused2) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "timeout", valueOf2);
                }
                aVar.f.put(jSONObject);
                aVar.a((String) null);
                this.k = true;
            }
        }
        if (z || !this.e.g()) {
            return false;
        }
        return true;
    }

    public void a() {
        q qVar;
        q qVar2 = this.e;
        if (qVar2 != null) {
            if (qVar2.e() && (qVar = this.e) != null && !qVar.e) {
                e d2 = qVar.d();
                InneractiveAdRequest inneractiveAdRequest = this.e.a;
                com.fyber.inneractive.sdk.util.q.b.post(new v(this, Arrays.toString(Thread.currentThread().getStackTrace()), inneractiveAdRequest, d2));
            }
            this.e.a();
            this.e = null;
        }
        this.f = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        r2 = r2.b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.fyber.inneractive.sdk.external.InneractiveAdRequest r10, com.fyber.inneractive.sdk.response.e r11) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x0033
            com.fyber.inneractive.sdk.config.b0 r1 = r10.getSelectedUnitConfig()
            if (r1 == 0) goto L_0x0033
            com.fyber.inneractive.sdk.config.b0 r1 = r10.getSelectedUnitConfig()
            com.fyber.inneractive.sdk.config.a0 r1 = (com.fyber.inneractive.sdk.config.a0) r1
            com.fyber.inneractive.sdk.config.t r1 = r1.c
            if (r1 == 0) goto L_0x001e
            com.fyber.inneractive.sdk.config.b0 r1 = r10.getSelectedUnitConfig()
            com.fyber.inneractive.sdk.config.a0 r1 = (com.fyber.inneractive.sdk.config.a0) r1
            com.fyber.inneractive.sdk.config.t r1 = r1.c
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = r1.b
            goto L_0x0034
        L_0x001e:
            com.fyber.inneractive.sdk.config.b0 r1 = r10.getSelectedUnitConfig()
            com.fyber.inneractive.sdk.config.a0 r1 = (com.fyber.inneractive.sdk.config.a0) r1
            com.fyber.inneractive.sdk.config.c0 r1 = r1.f
            if (r1 == 0) goto L_0x0033
            com.fyber.inneractive.sdk.config.b0 r1 = r10.getSelectedUnitConfig()
            com.fyber.inneractive.sdk.config.a0 r1 = (com.fyber.inneractive.sdk.config.a0) r1
            com.fyber.inneractive.sdk.config.c0 r1 = r1.f
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = r1.j
            goto L_0x0034
        L_0x0033:
            r1 = r0
        L_0x0034:
            com.fyber.inneractive.sdk.flow.q r2 = r9.e
            if (r2 == 0) goto L_0x003e
            T r2 = r2.b
            if (r2 == 0) goto L_0x003e
            r4 = r2
            goto L_0x003f
        L_0x003e:
            r4 = r11
        L_0x003f:
            java.lang.String r6 = r9.a
            if (r1 != 0) goto L_0x0047
            if (r4 == 0) goto L_0x0047
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = r4.n
        L_0x0047:
            r7 = r1
            com.fyber.inneractive.sdk.metrics.b r11 = new com.fyber.inneractive.sdk.metrics.b
            com.fyber.inneractive.sdk.flow.q r1 = r9.e
            if (r1 != 0) goto L_0x004f
            goto L_0x0055
        L_0x004f:
            com.fyber.inneractive.sdk.config.global.s r0 = r1.c
            org.json.JSONArray r0 = r0.c()
        L_0x0055:
            r8 = r0
            r3 = r11
            r5 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r11.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.t.a(com.fyber.inneractive.sdk.external.InneractiveAdRequest, com.fyber.inneractive.sdk.response.e):void");
    }
}
