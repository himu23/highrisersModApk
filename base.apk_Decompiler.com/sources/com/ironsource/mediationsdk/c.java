package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n7;
import com.ironsource.y3;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class c {
    private static final String j = "IronSource";
    private static final String k = "com.ironsource.adapters";
    private static final String l = "aps";
    private static final c m = new c();
    private static final Object n = new Object();
    private final ConcurrentHashMap<String, AbstractAdapter> a = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AdapterBaseWrapper> b = new ConcurrentHashMap<>();
    private String c;
    private String d;
    private Boolean e;
    private Boolean f;
    private final ConcurrentHashMap<String, List<String>> g = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<IronSource.AD_UNIT, JSONObject> h = new ConcurrentHashMap<>();
    private final AtomicBoolean i = new AtomicBoolean(false);

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.ironsource.mediationsdk.IronSource$AD_UNIT[] r0 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.c.a.<clinit>():void");
        }
    }

    c() {
    }

    private AbstractAdapter a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.ironsource.adapters." + StringUtils.toLowerCase(str2) + "." + str2 + "Adapter");
            return (AbstractAdapter) cls.getMethod(IronSourceConstants.START_ADAPTER, new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e2) {
            String str3 = "Error while loading adapter - exception = " + e2.getLocalizedMessage();
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
            a(str3);
            return null;
        }
    }

    private AdapterBaseInterface a(String str, String str2, NetworkSettings networkSettings) {
        if (!networkSettings.isCustomNetwork() || !TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            String str3 = (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkPackage() : k) + "." + str2;
            try {
                BaseAdapter baseAdapter = (BaseAdapter) Class.forName(str3).newInstance();
                IronLog.INTERNAL.info(str3 + " was allocated (adapter version: " + baseAdapter.getAdapterVersion() + ", sdk version: " + baseAdapter.getNetworkSDKVersion() + ")");
                a((AdapterBaseInterface) baseAdapter);
                this.b.put(str, new AdapterBaseWrapper(baseAdapter, networkSettings));
                return baseAdapter;
            } catch (Exception unused) {
                if (networkSettings.isCustomNetwork()) {
                    String str4 = "failed to load " + str3;
                    IronLog.INTERNAL.error(str4);
                    a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str4);
                }
                return null;
            }
        } else {
            IronLog.INTERNAL.error("missing package definition for " + str);
            return null;
        }
    }

    private BaseAdAdapter<?, ?> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        if (!networkSettings.isCustomNetwork() || !TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            String str = (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkPackage() : k) + "." + (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkAdapterName(ad_unit) : networkSettings.getProviderTypeForReflection());
            try {
                return (BaseAdAdapter) Class.forName(str).getConstructor(new Class[]{NetworkSettings.class}).newInstance(new Object[]{networkSettings});
            } catch (Exception unused) {
                if (networkSettings.isCustomNetwork()) {
                    String str2 = "failed to load " + str;
                    IronLog.INTERNAL.error(str2);
                    a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                }
                return null;
            }
        } else {
            IronLog.INTERNAL.error("missing package definition for " + networkSettings.getProviderTypeForReflection());
            return null;
        }
    }

    private String a(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == null || TextUtils.isEmpty(ad_unit.toString())) {
            return "";
        }
        return ad_unit.toString().substring(0, 1).toUpperCase() + ad_unit.toString().substring(1);
    }

    private void a(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("reason", str);
            }
            n7.i().a(new y3(i2, jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(AbstractAdapter abstractAdapter) {
        if (StringUtils.toLowerCase(abstractAdapter.getProviderName()).equals(l) && this.h.size() != 0) {
            for (IronSource.AD_UNIT next : this.h.keySet()) {
                try {
                    JSONObject jSONObject = this.h.get(next);
                    if (jSONObject != null && jSONObject.length() > 0 && (abstractAdapter instanceof SetAPSInterface)) {
                        ((SetAPSInterface) abstractAdapter).setAPSData(next, jSONObject);
                    }
                } catch (Exception e2) {
                    String str = "error while setting aps data: " + e2.getLocalizedMessage();
                    a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, str);
                    b(str);
                    e2.printStackTrace();
                }
            }
            this.h.clear();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.ironsource.mediationsdk.IronSource.AD_UNIT r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            r0 = 88003(0x157c3, float:1.23318E-40)
            if (r7 == 0) goto L_0x00ae
            int r1 = r7.length()
            if (r1 != 0) goto L_0x000d
            goto L_0x00ae
        L_0x000d:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0091 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0091 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0091 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.AbstractAdapter> r7 = r5.a     // Catch:{ Exception -> 0x0091 }
            boolean r7 = r7.isEmpty()     // Catch:{ Exception -> 0x0091 }
            if (r7 != 0) goto L_0x004e
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.AbstractAdapter> r7 = r5.a     // Catch:{ Exception -> 0x0091 }
            java.util.Collection r7 = r7.values()     // Catch:{ Exception -> 0x0091 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0091 }
        L_0x0028:
            boolean r2 = r7.hasNext()     // Catch:{ Exception -> 0x0091 }
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r7.next()     // Catch:{ Exception -> 0x0091 }
            com.ironsource.mediationsdk.AbstractAdapter r2 = (com.ironsource.mediationsdk.AbstractAdapter) r2     // Catch:{ Exception -> 0x0091 }
            java.lang.String r3 = r2.getProviderName()     // Catch:{ Exception -> 0x0091 }
            java.lang.String r3 = com.ironsource.environment.StringUtils.toLowerCase(r3)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r4 = "aps"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x0028
            boolean r3 = r2 instanceof com.ironsource.mediationsdk.SetAPSInterface     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x0028
            com.ironsource.mediationsdk.SetAPSInterface r2 = (com.ironsource.mediationsdk.SetAPSInterface) r2     // Catch:{ Exception -> 0x0091 }
            r2.setAPSData(r6, r1)     // Catch:{ Exception -> 0x0091 }
            return
        L_0x004e:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper> r7 = r5.b     // Catch:{ Exception -> 0x0091 }
            java.util.Collection r7 = r7.values()     // Catch:{ Exception -> 0x0091 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0091 }
        L_0x0058:
            boolean r2 = r7.hasNext()     // Catch:{ Exception -> 0x0091 }
            if (r2 == 0) goto L_0x0084
            java.lang.Object r2 = r7.next()     // Catch:{ Exception -> 0x0091 }
            com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper r2 = (com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper) r2     // Catch:{ Exception -> 0x0091 }
            com.ironsource.mediationsdk.model.NetworkSettings r3 = r2.getSettings()     // Catch:{ Exception -> 0x0091 }
            java.lang.String r3 = r3.getProviderTypeForReflection()     // Catch:{ Exception -> 0x0091 }
            java.lang.String r3 = com.ironsource.environment.StringUtils.toLowerCase(r3)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r4 = "aps"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x0058
            com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface r7 = r2.getAdapterBaseInterface()     // Catch:{ Exception -> 0x0091 }
            if (r7 == 0) goto L_0x0083
            com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface r7 = (com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface) r7     // Catch:{ Exception -> 0x0091 }
            r7.setAPSData(r6, r1)     // Catch:{ Exception -> 0x0091 }
        L_0x0083:
            return
        L_0x0084:
            java.lang.Object r7 = n     // Catch:{ Exception -> 0x0091 }
            monitor-enter(r7)     // Catch:{ Exception -> 0x0091 }
            java.util.concurrent.ConcurrentHashMap<com.ironsource.mediationsdk.IronSource$AD_UNIT, org.json.JSONObject> r2 = r5.h     // Catch:{ all -> 0x008e }
            r2.put(r6, r1)     // Catch:{ all -> 0x008e }
            monitor-exit(r7)     // Catch:{ all -> 0x008e }
            goto L_0x00ad
        L_0x008e:
            r6 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x008e }
            throw r6     // Catch:{ Exception -> 0x0091 }
        L_0x0091:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r1 = "error while setting APSData: "
            r7.<init>(r1)
            java.lang.String r1 = r6.getLocalizedMessage()
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            r5.a((int) r0, (java.lang.String) r7)
            r5.a((java.lang.String) r7)
            r6.printStackTrace()
        L_0x00ad:
            return
        L_0x00ae:
            java.lang.String r6 = "APSData is empty"
            r5.a((int) r0, (java.lang.String) r6)
            java.lang.String r6 = "APSData is empty"
            r5.a((java.lang.String) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.c.a(com.ironsource.mediationsdk.IronSource$AD_UNIT, org.json.JSONObject):void");
    }

    private void a(AdapterBaseInterface adapterBaseInterface) {
        Boolean bool = this.f;
        if (bool != null && (adapterBaseInterface instanceof AdapterDebugInterface)) {
            try {
                ((AdapterDebugInterface) adapterBaseInterface).setAdapterDebug(bool.booleanValue());
            } catch (Exception e2) {
                String str = "error while setting adapterDebug of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                b(str);
                e2.printStackTrace();
            }
        }
    }

    private void a(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "AdapterRepository: " + str, 3);
    }

    private void a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            if (!next.equalsIgnoreCase(ad_unit.toString())) {
                ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
                if (!next.equalsIgnoreCase(ad_unit.toString())) {
                    ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
                    if (!next.equalsIgnoreCase(ad_unit.toString())) {
                    }
                }
            }
            a(ad_unit, optJSONObject);
        }
    }

    private void a(JSONObject jSONObject, AbstractAdapter abstractAdapter, String str) {
        if ((str.equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) || str.equalsIgnoreCase("IronSource")) && this.i.compareAndSet(false, true)) {
            b("SDK5 earlyInit  <" + str + ">");
            try {
                abstractAdapter.earlyInit(this.c, this.d, jSONObject);
            } catch (Exception e2) {
                String str2 = "error while calling early init for " + abstractAdapter.getProviderName() + ": " + e2.getLocalizedMessage();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                IronLog.INTERNAL.error(str2);
            }
        }
    }

    public static c b() {
        return m;
    }

    private String b(NetworkSettings networkSettings) {
        return networkSettings.isMultipleInstances() ? networkSettings.getProviderDefaultInstance() : networkSettings.getProviderName();
    }

    private void b(AbstractAdapter abstractAdapter) {
        Boolean bool = this.f;
        if (bool != null) {
            try {
                abstractAdapter.setAdapterDebug(bool);
            } catch (Throwable th) {
                String str = "error while setting adapterDebug of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                b(str);
                th.printStackTrace();
            }
        }
    }

    private void b(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "AdapterRepository: " + str, 0);
    }

    private String c(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        String uuid2 = (uuid == null || ad_unit != IronSource.AD_UNIT.NATIVE_AD) ? "" : uuid.toString();
        return uuid2 + "-" + ad_unit.toString() + "-" + networkSettings.getProviderName();
    }

    private void c(AbstractAdapter abstractAdapter) {
        try {
            Boolean bool = this.e;
            if (bool != null) {
                abstractAdapter.setConsent(bool.booleanValue());
            }
        } catch (Throwable th) {
            String str = "error while setting consent of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
            b(str);
            th.printStackTrace();
        }
    }

    private void d(AbstractAdapter abstractAdapter) {
        for (String next : this.g.keySet()) {
            try {
                List list = this.g.get(next);
                IronSourceUtils.sendAutomationLog(abstractAdapter.getProviderName() + "Adapter setMetaData key = " + next + ", values = " + list);
                if (list != null) {
                    abstractAdapter.setMetaData(next, list);
                }
            } catch (Throwable th) {
                String str = "error while setting metadata of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                b(str);
                th.printStackTrace();
            }
        }
    }

    public AbstractAdapter a(NetworkSettings networkSettings) {
        String b2 = b(networkSettings);
        return networkSettings.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) ? this.a.get(b2) : a(b2, networkSettings.getProviderTypeForReflection());
    }

    public AbstractAdapter a(NetworkSettings networkSettings, JSONObject jSONObject, boolean z) {
        String str;
        String b2 = b(networkSettings);
        String providerTypeForReflection = z ? "IronSource" : networkSettings.getProviderTypeForReflection();
        synchronized (n) {
            if (this.a.containsKey(b2)) {
                AbstractAdapter abstractAdapter = this.a.get(b2);
                return abstractAdapter;
            }
            AbstractAdapter a2 = a(b2, providerTypeForReflection);
            if (a2 == null) {
                a(b2 + " adapter was not loaded");
                return null;
            }
            try {
                str = a2.getCoreSDKVersion();
            } catch (Throwable th) {
                String str2 = "error while retrieving coreSDKVersion " + a2.getProviderName() + ": " + th.getLocalizedMessage();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                IronLog.INTERNAL.error(str2);
                str = "Unknown";
            }
            b(b2 + " was allocated (adapter version: " + a2.getVersion() + ", sdk version: " + str + ")");
            d(a2);
            a(a2);
            c(a2);
            b(a2);
            a(jSONObject, a2, providerTypeForReflection);
            this.a.put(b2, a2);
            return a2;
        }
    }

    public BaseAdAdapter<?, ?> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        BaseAdAdapter<?, ?> a2 = a(networkSettings, ad_unit);
        if (a2 != null || networkSettings.isCustomNetwork()) {
            return a2;
        }
        AbstractAdapter a3 = a(networkSettings);
        if (a3 != null) {
            return a.a(a3, networkSettings, ad_unit, uuid);
        }
        String str = "error creating ad adapter " + networkSettings.getProviderName();
        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
        IronLog.INTERNAL.error(str);
        return null;
    }

    /* access modifiers changed from: package-private */
    public ConcurrentHashMap<String, AbstractAdapter> a() {
        return this.a;
    }

    public void a(String str, List<String> list) {
        synchronized (n) {
            this.g.put(str, list);
            if (!this.a.isEmpty()) {
                IronSourceUtils.sendAutomationLog("setMetaData key = " + str + ", values = " + list);
                for (AbstractAdapter next : this.a.values()) {
                    try {
                        next.setMetaData(str, list);
                    } catch (Throwable th) {
                        String str2 = "error while setting metadata of " + next.getProviderName() + ": " + th.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                        b(str2);
                        th.printStackTrace();
                    }
                }
            }
            for (AdapterBaseWrapper next2 : this.b.values()) {
                AdapterBaseInterface adapterBaseInterface = next2.getAdapterBaseInterface();
                if (!next2.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterMetaDataInterface)) {
                    try {
                        ((AdapterMetaDataInterface) adapterBaseInterface).setMetaData(str, list);
                    } catch (Exception e2) {
                        String str3 = "error while setting metadata of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
                        b(str3);
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void a(String str, JSONObject jSONObject) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "Calling setNetworkData on an empty network";
        } else if (jSONObject == null || jSONObject.length() == 0) {
            str2 = "Calling setNetworkData with empty networkData";
        } else if (StringUtils.toLowerCase(str).equals(l)) {
            a(jSONObject);
            return;
        } else {
            String str3 = "Calling setNetworkData on an unsupported network: " + str;
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, str3);
            a(str3);
            return;
        }
        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, str2);
        a(str2);
    }

    public void a(boolean z) {
        synchronized (n) {
            this.f = Boolean.valueOf(z);
            for (AbstractAdapter b2 : this.a.values()) {
                b(b2);
            }
        }
    }

    public AdapterBaseInterface b(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        ConcurrentHashMap<String, AdapterBaseWrapper> concurrentHashMap;
        AdapterBaseWrapper adapterBaseWrapper;
        String b2 = networkSettings.isCustomNetwork() ? b(networkSettings) : c(networkSettings, ad_unit, uuid);
        if (this.b.containsKey(b2)) {
            return this.b.get(b2).getAdapterBaseInterface();
        }
        AdapterBaseInterface a2 = a(b2, networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkAdapterName((IronSource.AD_UNIT) null) : networkSettings.getProviderTypeForReflection(), networkSettings);
        if (a2 != null || networkSettings.isCustomNetwork()) {
            concurrentHashMap = this.b;
            adapterBaseWrapper = new AdapterBaseWrapper(a2, networkSettings);
        } else {
            int i2 = a.a[ad_unit.ordinal()];
            AbstractAdapter a3 = a(networkSettings, i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : networkSettings.getNativeAdSettings() : networkSettings.getBannerSettings() : networkSettings.getInterstitialSettings() : networkSettings.getRewardedVideoSettings(), false);
            if (a3 != null) {
                a2 = new u(a3);
                concurrentHashMap = this.b;
                adapterBaseWrapper = new AdapterBaseWrapper(a2, networkSettings);
            } else {
                String str = "error creating network adapter " + networkSettings.getProviderName();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                IronLog.INTERNAL.error(str);
                return null;
            }
        }
        concurrentHashMap.put(b2, adapterBaseWrapper);
        return a2;
    }

    public void b(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    public void b(boolean z) {
        synchronized (n) {
            this.e = Boolean.valueOf(z);
            for (AbstractAdapter c2 : this.a.values()) {
                c(c2);
            }
            for (AdapterBaseWrapper next : this.b.values()) {
                AdapterBaseInterface adapterBaseInterface = next.getAdapterBaseInterface();
                if (!next.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterConsentInterface)) {
                    try {
                        ((AdapterConsentInterface) adapterBaseInterface).setConsent(z);
                    } catch (Exception e2) {
                        String str = "error while setting consent of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                        b(str);
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public ConcurrentHashMap<String, List<String>> c() {
        return this.g;
    }

    public ConcurrentHashMap<String, AdapterBaseWrapper> d() {
        return this.b;
    }

    public void e() {
        this.a.clear();
        this.b.clear();
    }
}
