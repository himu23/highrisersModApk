package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.iab.omid.library.ironsrc.Omid;
import com.iab.omid.library.ironsrc.adsession.AdEvents;
import com.iab.omid.library.ironsrc.adsession.AdSession;
import com.iab.omid.library.ironsrc.adsession.AdSessionConfiguration;
import com.iab.omid.library.ironsrc.adsession.AdSessionContext;
import com.iab.omid.library.ironsrc.adsession.CreativeType;
import com.iab.omid.library.ironsrc.adsession.ImpressionType;
import com.iab.omid.library.ironsrc.adsession.Owner;
import com.iab.omid.library.ironsrc.adsession.Partner;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

public class m9 {
    public static final String d = "Ironsrc";
    public static final String e = "7";
    public static final String f = Omid.getVersion();
    public static final String g = "omidVersion";
    public static final String h = "omidPartnerName";
    public static final String i = "omidPartnerVersion";
    public static final String j = "omidActiveAdSessions";
    private static final String k = "Invalid OMID impressionOwner";
    private static final String l = "Invalid OMID videoEventsOwner";
    private static final String m = "Missing OMID impressionOwner";
    private static final String n = "Missing OMID videoEventsOwner";
    private static final String o = "OMID has not been activated";
    private static final String p = "Missing OMID creativeType";
    private static final String q = "Missing adview id in OMID params";
    private static final String r = "No adview found with the provided adViewId";
    private static final String s = "OMID Session has already started";
    private static final String t = "OMID Session has not started";
    private final Partner a = Partner.createPartner(d, e);
    private final HashMap<String, AdSession> b = new HashMap<>();
    private boolean c = false;

    static class a {
        private static final String i = "isolateVerificationScripts";
        private static final String j = "impressionOwner";
        private static final String k = "videoEventsOwner";
        private static final String l = "customReferenceData";
        private static final String m = "creativeType";
        private static final String n = "impressionType";
        public static final String o = "adViewId";
        public boolean a;
        public Owner b;
        public Owner c;
        public String d;
        public ImpressionType e;
        public CreativeType f;
        public String g;
        public Owner h;

        public static a a(JSONObject jSONObject) throws IllegalArgumentException {
            a aVar = new a();
            aVar.a = jSONObject.optBoolean(i, false);
            String optString = jSONObject.optString(j, "");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    aVar.b = Owner.valueOf(optString.toUpperCase());
                    String optString2 = jSONObject.optString(k, "");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            aVar.c = Owner.valueOf(optString2.toUpperCase());
                            aVar.d = jSONObject.optString(l, "");
                            aVar.f = b(jSONObject);
                            aVar.e = c(jSONObject);
                            aVar.g = e(jSONObject);
                            aVar.h = d(jSONObject);
                            return aVar;
                        } catch (IllegalArgumentException unused) {
                            throw new IllegalArgumentException("Invalid OMID videoEventsOwner " + optString2);
                        }
                    } else {
                        throw new IllegalArgumentException(m9.n);
                    }
                } catch (IllegalArgumentException unused2) {
                    throw new IllegalArgumentException("Invalid OMID impressionOwner " + optString);
                }
            } else {
                throw new IllegalArgumentException(m9.m);
            }
        }

        private static CreativeType b(JSONObject jSONObject) throws IllegalArgumentException {
            String optString = jSONObject.optString(m, "");
            if (!TextUtils.isEmpty(optString)) {
                for (CreativeType creativeType : CreativeType.values()) {
                    if (optString.equalsIgnoreCase(creativeType.toString())) {
                        return creativeType;
                    }
                }
                throw new IllegalArgumentException(m9.p + optString);
            }
            throw new IllegalArgumentException(m9.p + optString);
        }

        private static ImpressionType c(JSONObject jSONObject) throws IllegalArgumentException {
            String optString = jSONObject.optString(n, "");
            if (!TextUtils.isEmpty(optString)) {
                for (ImpressionType impressionType : ImpressionType.values()) {
                    if (optString.equalsIgnoreCase(impressionType.toString())) {
                        return impressionType;
                    }
                }
                throw new IllegalArgumentException(m9.p + optString);
            }
            throw new IllegalArgumentException(m9.p + optString);
        }

        private static Owner d(JSONObject jSONObject) throws IllegalArgumentException {
            try {
                return Owner.valueOf(jSONObject.optString(k, "").toUpperCase());
            } catch (IllegalArgumentException unused) {
                return Owner.NONE;
            }
        }

        private static String e(JSONObject jSONObject) throws IllegalArgumentException {
            String optString = jSONObject.optString("adViewId", "");
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
            throw new IllegalArgumentException(m9.q + optString);
        }
    }

    private AdSession a(a aVar, v6 v6Var) throws IllegalArgumentException {
        AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(aVar.f, aVar.e, aVar.b, aVar.c, aVar.a), AdSessionContext.createHtmlAdSessionContext(this.a, v6Var.getPresentingView(), (String) null, aVar.d));
        createAdSession.registerAdView(v6Var.getPresentingView());
        return createAdSession;
    }

    private void a(JSONObject jSONObject) throws IllegalStateException {
        if (!this.c) {
            throw new IllegalStateException(o);
        } else if (jSONObject == null) {
            throw new IllegalStateException(t);
        }
    }

    public ab a() {
        ab abVar = new ab();
        abVar.b("omidVersion", SDKUtils.encodeString(f));
        abVar.b(h, SDKUtils.encodeString(d));
        abVar.b("omidPartnerVersion", SDKUtils.encodeString(e));
        abVar.b(j, SDKUtils.encodeString(Arrays.toString(this.b.keySet().toArray())));
        return abVar;
    }

    public void a(Context context) throws IllegalArgumentException {
        if (!this.c) {
            Omid.activate(context);
            this.c = true;
        }
    }

    public void a(a aVar) throws IllegalStateException, IllegalArgumentException {
        if (!this.c) {
            throw new IllegalStateException(o);
        } else if (!TextUtils.isEmpty(aVar.g)) {
            String str = aVar.g;
            if (!this.b.containsKey(str)) {
                v6 a2 = d6.a().a(str);
                if (a2 != null) {
                    AdSession a3 = a(aVar, a2);
                    a3.start();
                    this.b.put(str, a3);
                    return;
                }
                throw new IllegalStateException(r);
            }
            throw new IllegalStateException(s);
        } else {
            throw new IllegalStateException(q);
        }
    }

    public void b(JSONObject jSONObject) throws IllegalStateException {
        a(jSONObject);
        String optString = jSONObject.optString("adViewId");
        AdSession adSession = this.b.get(optString);
        if (adSession != null) {
            adSession.finish();
            this.b.remove(optString);
            return;
        }
        throw new IllegalStateException(t);
    }

    public void c(JSONObject jSONObject) throws IllegalArgumentException, IllegalStateException {
        a(jSONObject);
        AdSession adSession = this.b.get(jSONObject.optString("adViewId"));
        if (adSession != null) {
            AdEvents createAdEvents = AdEvents.createAdEvents(adSession);
            if (jSONObject.optBoolean("signalLoaded")) {
                createAdEvents.loaded();
            }
            createAdEvents.impressionOccurred();
            return;
        }
        throw new IllegalStateException(t);
    }

    public void d(JSONObject jSONObject) throws IllegalStateException, IllegalArgumentException {
        a(a.a(jSONObject));
    }
}
