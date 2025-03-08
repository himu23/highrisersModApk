package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.w5;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class f implements AppLovinCommunicatorSubscriber {
    private final Object azc = new Object();
    private final LinkedHashMap<String, Bundle> azd = new LinkedHashMap<String, Bundle>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > 16;
        }
    };
    private final Set<a> aze = Collections.synchronizedSet(new HashSet());
    private final n sdk;

    public interface a {
        void onCreativeIdGenerated(String str, String str2);
    }

    public String getCommunicatorId() {
        return InneractiveMediationDefs.GENDER_FEMALE;
    }

    public f(n nVar) {
        this.sdk = nVar;
        if (StringUtils.isValidString(getVersion())) {
            AppLovinCommunicator.getInstance(n.getApplicationContext()).subscribe((AppLovinCommunicatorSubscriber) this, "safedk_ad_info");
        }
    }

    public Bundle cu(String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.azc) {
            bundle = this.azd.get(str);
        }
        return bundle;
    }

    public void cv(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.azc) {
                this.azd.remove(str);
            }
        }
    }

    public void a(a aVar) {
        this.aze.add(aVar);
    }

    public void b(a aVar) {
        this.aze.remove(aVar);
    }

    public static String getVersion() {
        return cw(MobileAdsBridge.versionMethodName);
    }

    public static String getSdkKey() {
        return cw("getSdkKey");
    }

    private static String cw(String str) {
        Class<?> cls;
        try {
            cls = Class.forName("com.applovin.quality.AppLovinQualityService");
        } catch (Throwable unused) {
            return "";
        }
        return (String) cls.getMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle bundle = appLovinCommunicatorMessage.getMessageData().getBundle("public");
            if (bundle == null) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().h("AppLovinSdk", "Received SafeDK ad info without public data");
                    return;
                }
                return;
            }
            Bundle bundle2 = appLovinCommunicatorMessage.getMessageData().getBundle("private");
            if (bundle2 == null) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().h("AppLovinSdk", "Received SafeDK ad info without private data");
                }
            } else if (MaxAdFormat.formatFromString(bundle2.getString("ad_format")) == null) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().h("AppLovinSdk", "Received SafeDK ad info without ad format");
                }
            } else {
                String string = bundle2.getString(w5.x);
                if (TextUtils.isEmpty(string)) {
                    this.sdk.BN();
                    if (x.Fn()) {
                        this.sdk.BN().h("AppLovinSdk", "Received SafeDK ad info without serve id");
                        return;
                    }
                    return;
                }
                synchronized (this.azc) {
                    this.sdk.BN();
                    if (x.Fn()) {
                        x BN = this.sdk.BN();
                        BN.f("AppLovinSdk", "Storing current SafeDK ad info for serve id: " + string);
                    }
                    this.azd.put(string, bundle);
                }
                String string2 = bundle.getString("ad_review_creative_id");
                if (StringUtils.isValidString(string2) && !this.aze.isEmpty()) {
                    Iterator it = new HashSet(this.aze).iterator();
                    while (it.hasNext()) {
                        this.sdk.BO().a((d) new ab(this.sdk, "creativeIdGenerated", new f$$ExternalSyntheticLambda0((a) it.next(), string, string2)), q.b.BACKGROUND);
                    }
                }
            }
        }
    }
}
