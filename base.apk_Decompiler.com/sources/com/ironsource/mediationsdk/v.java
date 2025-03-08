package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.g7;
import com.ironsource.h5;
import com.ironsource.h7;
import com.ironsource.i5;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.n9;
import com.ironsource.q9;
import com.ironsource.va;
import com.ironsource.w6;
import com.ironsource.w8;
import com.ironsource.y3;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class v implements g7, h7 {
    private final String a;
    private n9 b;
    private h7 c;
    private IronSourceLoggerManager d;
    private AtomicBoolean e;
    private AtomicBoolean f;
    private c g;
    private NetworkSettings h;
    private String i;
    private final w6 j;
    private final w6.a k;

    v() {
        this(w8.e(), w8.d());
    }

    v(i5 i5Var, h5 h5Var) {
        this.a = getClass().getName();
        this.j = i5Var.b();
        this.k = h5Var.a();
        this.e = new AtomicBoolean(true);
        this.f = new AtomicBoolean(false);
        this.d = IronSourceLoggerManager.getLogger();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.ironsource.mediationsdk.AbstractAdapter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ironsource.mediationsdk.AbstractAdapter a(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "com.ironsource.adapters."
            r1 = 0
            com.ironsource.mediationsdk.p r2 = com.ironsource.mediationsdk.p.o()     // Catch:{ all -> 0x004e }
            com.ironsource.mediationsdk.AbstractAdapter r3 = r2.p(r9)     // Catch:{ all -> 0x004e }
            if (r3 != 0) goto L_0x004a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r3.<init>(r0)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = com.ironsource.environment.StringUtils.toLowerCase(r9)     // Catch:{ all -> 0x004e }
            r3.append(r0)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = "."
            r3.append(r0)     // Catch:{ all -> 0x004e }
            r3.append(r9)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = "Adapter"
            r3.append(r0)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x004e }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x004e }
            java.lang.String r3 = "startAdapter"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x004e }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{ all -> 0x004e }
            java.lang.reflect.Method r3 = r0.getMethod(r3, r5)     // Catch:{ all -> 0x004e }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x004e }
            r4[r7] = r9     // Catch:{ all -> 0x004e }
            java.lang.Object r0 = r3.invoke(r0, r4)     // Catch:{ all -> 0x004e }
            r3 = r0
            com.ironsource.mediationsdk.AbstractAdapter r3 = (com.ironsource.mediationsdk.AbstractAdapter) r3     // Catch:{ all -> 0x004e }
            if (r3 != 0) goto L_0x004a
            return r1
        L_0x004a:
            r2.a((com.ironsource.mediationsdk.AbstractAdapter) r3)     // Catch:{ all -> 0x004e }
            return r3
        L_0x004e:
            r0 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r8.d
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            java.lang.String r9 = " initialization failed - please verify that required dependencies are in you build path."
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            r4 = 2
            r2.log(r3, r9, r4)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r8.d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r8.a
            r2.append(r4)
            java.lang.String r4 = ":startOfferwallAdapter"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r9.logException(r3, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.v.a(java.lang.String):com.ironsource.mediationsdk.AbstractAdapter");
    }

    private String a(c cVar) {
        return (cVar == null || cVar.b() == null || cVar.b().f() == null || cVar.b().f().b() == null) ? IronSourceConstants.SUPERSONIC_CONFIG_NAME : cVar.b().f().b();
    }

    private void a(AbstractAdapter abstractAdapter) {
        try {
            Boolean j2 = p.o().j();
            if (j2 != null) {
                IronSourceLoggerManager ironSourceLoggerManager = this.d;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
                ironSourceLoggerManager.log(ironSourceTag, "Offerwall | setConsent(consent:" + j2 + ")", 1);
                abstractAdapter.setConsent(j2.booleanValue());
            }
        } catch (Exception e2) {
            IronSourceLoggerManager ironSourceLoggerManager2 = this.d;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager2.log(ironSourceTag2, ":setCustomParams():" + e2.toString(), 3);
        }
    }

    private synchronized void a(IronSourceError ironSourceError) {
        AtomicBoolean atomicBoolean = this.f;
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        AtomicBoolean atomicBoolean2 = this.e;
        if (atomicBoolean2 != null) {
            atomicBoolean2.set(true);
        }
        h7 h7Var = this.c;
        if (h7Var != null) {
            h7Var.a(false, ironSourceError);
        }
    }

    public void a(OfferwallListener offerwallListener) {
    }

    public synchronized void a(String str, String str2) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        ironSourceLoggerManager.log(ironSourceTag, this.a + ":initOfferwall(appKey: " + str + ", userId: " + str2 + ")", 1);
        c k2 = p.o().k();
        this.g = k2;
        if (k2 == null) {
            a(ErrorBuilder.buildInitFailedError("Please check configurations for Offerwall adapters", IronSourceConstants.OFFERWALL_AD_UNIT));
        } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            a(ErrorBuilder.buildInitFailedError("Activity must be provided when initializing SDK", IronSourceConstants.OFFERWALL_AD_UNIT));
        } else {
            String a2 = a(this.g);
            NetworkSettings b2 = this.g.i().b(a2);
            this.h = b2;
            if (b2 == null) {
                a(ErrorBuilder.buildInitFailedError("Please check configurations for Offerwall adapters", IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            AbstractAdapter a3 = a(a2);
            if (a3 == null) {
                a(ErrorBuilder.buildInitFailedError("Please check configurations for Offerwall adapters", IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            a(a3);
            n9 n9Var = (n9) a3;
            this.b = n9Var;
            n9Var.setInternalOfferwallListener(this);
            this.b.initOfferwall(str, str2, this.h.getRewardedVideoSettings());
        }
    }

    public void a(boolean z, IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onOfferwallAvailable(isAvailable: " + z + ")", 1);
        if (z) {
            this.f.set(true);
            h7 h7Var = this.c;
            if (h7Var != null) {
                h7Var.onOfferwallAvailable(true);
                return;
            }
            return;
        }
        a(ironSourceError);
    }

    public void c() {
    }

    public void getOfferwallCredits() {
        n9 n9Var = this.b;
        if (n9Var != null) {
            n9Var.getOfferwallCredits();
        }
    }

    public synchronized boolean isOfferwallAvailable() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.f;
        return atomicBoolean != null ? atomicBoolean.get() : false;
    }

    public void j(String str) {
        n9 n9Var;
        String str2 = "OWManager:showOfferwall(" + str + ")";
        try {
            if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                this.c.onOfferwallShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.OFFERWALL_AD_UNIT, "Activity must be provided when initializing SDK"));
            } else if (!IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
                this.c.onOfferwallShowFailed(ErrorBuilder.buildNoInternetConnectionShowFailError(IronSourceConstants.OFFERWALL_AD_UNIT));
            } else {
                this.i = str;
                q9 a2 = this.g.b().f().a(str);
                if (a2 == null) {
                    IronSourceLoggerManager ironSourceLoggerManager = this.d;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                    ironSourceLoggerManager.log(ironSourceTag, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                    a2 = this.g.b().f().a();
                    if (a2 == null) {
                        this.d.log(ironSourceTag, "Default placement was not found, please make sure you are using the right placements.", 3);
                        return;
                    }
                }
                this.d.log(IronSourceLogger.IronSourceTag.INTERNAL, str2, 1);
                AtomicBoolean atomicBoolean = this.f;
                if (atomicBoolean != null && atomicBoolean.get() && (n9Var = this.b) != null) {
                    n9Var.showOfferwall(String.valueOf(a2.getPlacementId()), this.h.getRewardedVideoSettings());
                }
            }
        } catch (Exception e2) {
            this.d.logException(IronSourceLogger.IronSourceTag.INTERNAL, str2, e2);
        }
    }

    public void onGetOfferwallCreditsFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onGetOfferwallCreditsFailed(" + ironSourceError + ")", 1);
        h7 h7Var = this.c;
        if (h7Var != null) {
            h7Var.onGetOfferwallCreditsFailed(ironSourceError);
        }
    }

    public boolean onOfferwallAdCredited(int i2, int i3, boolean z) {
        this.d.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallAdCredited()", 1);
        h7 h7Var = this.c;
        if (h7Var != null) {
            return h7Var.onOfferwallAdCredited(i2, i3, z);
        }
        return false;
    }

    public void onOfferwallAvailable(boolean z) {
        a(z, (IronSourceError) null);
    }

    public void onOfferwallClosed() {
        this.d.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallClosed()", 1);
        h7 h7Var = this.c;
        if (h7Var != null) {
            h7Var.onOfferwallClosed();
        }
    }

    public void onOfferwallOpened() {
        this.d.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallOpened()", 1);
        int a2 = this.j.a(IronSource.AD_UNIT.OFFERWALL);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            if (!TextUtils.isEmpty(this.i)) {
                mediationAdditionalData.put("placement", this.i);
            }
            mediationAdditionalData.put("sessionDepth", a2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        va.i().a(new y3(IronSourceConstants.OFFERWALL_OPENED, mediationAdditionalData));
        this.k.b(IronSource.AD_UNIT.OFFERWALL);
        h7 h7Var = this.c;
        if (h7Var != null) {
            h7Var.onOfferwallOpened();
        }
    }

    public void onOfferwallShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onOfferwallShowFailed(" + ironSourceError + ")", 1);
        h7 h7Var = this.c;
        if (h7Var != null) {
            h7Var.onOfferwallShowFailed(ironSourceError);
        }
    }

    public void setInternalOfferwallListener(h7 h7Var) {
        this.c = h7Var;
    }
}
