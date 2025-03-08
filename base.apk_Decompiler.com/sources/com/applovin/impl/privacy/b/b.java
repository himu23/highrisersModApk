package com.applovin.impl.privacy.b;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.impl.privacy.b.c;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.List;

public class b implements SharedPreferences.OnSharedPreferenceChangeListener {
    private String ayA;
    private String ayB;
    private String ayC;
    private final List<c> ayD = new ArrayList();
    private final SharedPreferences ayw;
    private Integer ayx;
    private Integer ayy;
    private Integer ayz;
    private final n sdk;

    public Integer Ap() {
        return this.ayx;
    }

    public Integer Aq() {
        return this.ayy;
    }

    public Integer Ar() {
        return this.ayz;
    }

    public String As() {
        return this.ayA;
    }

    public String At() {
        return this.ayB;
    }

    public List<c> Au() {
        return this.ayD;
    }

    public b(n nVar) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(n.getApplicationContext());
        this.ayw = defaultSharedPreferences;
        this.sdk = nVar;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.ayx = cn(d.aRu.getName());
        this.ayy = cn(d.aRv.getName());
        this.ayz = An();
        this.ayA = (String) e.a(d.aRx, null, defaultSharedPreferences, false);
        this.ayB = (String) e.a(d.aRy, null, defaultSharedPreferences, false);
        this.ayC = (String) e.a(d.aRz, null, defaultSharedPreferences, false);
        co(this.ayB);
    }

    public void F(List<com.applovin.impl.mediation.debugger.b.c.b> list) {
        for (com.applovin.impl.mediation.debugger.b.c.b vI : list) {
            this.ayD.add(vI.vI());
        }
        cp(this.ayC);
        cq(this.ayB);
    }

    public String Am() {
        return a.l(this.ayx);
    }

    public String uI() {
        return b("CMP Name", Am()) + b("CMP SDK ID", this.ayx) + b("CMP SDK Version", this.ayy) + b(d.aRw.getName(), this.ayz) + b(d.aRx.getName(), this.ayA) + b(d.aRy.getName(), this.ayB);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("TcfManager", "SharedPreferences are cleared - setting all stored TC data to null");
            }
            Ao();
        } else if (str.equals(d.aRu.getName())) {
            this.ayx = cn(str);
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayx);
            }
            this.sdk.Bu();
        } else if (str.equals(d.aRv.getName())) {
            this.ayy = cn(str);
            this.sdk.BN();
            if (x.Fn()) {
                x BN2 = this.sdk.BN();
                BN2.f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayy);
            }
        } else if (str.equals(d.aRw.getName())) {
            this.ayz = An();
            this.sdk.BN();
            if (x.Fn()) {
                x BN3 = this.sdk.BN();
                BN3.f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayz);
            }
        } else if (str.equals(d.aRx.getName())) {
            this.ayA = (String) e.a(str, null, String.class, sharedPreferences);
            this.sdk.BN();
            if (x.Fn()) {
                x BN4 = this.sdk.BN();
                BN4.f("TcfManager", "SharedPreference entry updated - key: " + str + ", value: " + this.ayA);
            }
            this.sdk.Bu();
        } else if (str.equals(d.aRy.getName())) {
            this.ayB = (String) e.a(str, null, String.class, sharedPreferences);
            this.sdk.BN();
            if (x.Fn()) {
                x BN5 = this.sdk.BN();
                BN5.f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayB);
            }
            co(this.ayB);
            cq(this.ayB);
        } else if (str.equals(d.aRz.getName())) {
            this.ayC = (String) e.a(str, null, String.class, sharedPreferences);
            this.sdk.BN();
            if (x.Fn()) {
                x BN6 = this.sdk.BN();
                BN6.f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.ayC);
            }
            cp(this.ayC);
        } else if (str.equals(d.aRA.getName())) {
            String str2 = (String) e.a(str, null, String.class, sharedPreferences);
            this.sdk.BN();
            if (x.Fn()) {
                x BN7 = this.sdk.BN();
                BN7.f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str2);
            }
        } else if (str.equals(d.aRB.getName())) {
            String str3 = (String) e.a(str, null, String.class, sharedPreferences);
            this.sdk.BN();
            if (x.Fn()) {
                x BN8 = this.sdk.BN();
                BN8.f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str3);
            }
        } else if (str.equals(d.aRC.getName())) {
            String str4 = (String) e.a(str, null, String.class, sharedPreferences);
            this.sdk.BN();
            if (x.Fn()) {
                x BN9 = this.sdk.BN();
                BN9.f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str4);
            }
        } else if (str.contains("IABTCF_PublisherRestrictions")) {
            String str5 = (String) e.a(str, null, String.class, sharedPreferences);
            this.sdk.BN();
            if (x.Fn()) {
                x BN10 = this.sdk.BN();
                BN10.f("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str5);
            }
        }
    }

    private Integer cn(String str) {
        if (this.ayw.contains(str)) {
            Integer num = (Integer) e.a(str, null, Integer.class, this.ayw, false);
            if (num != null) {
                return num;
            }
            Long l = (Long) e.a(str, null, Long.class, this.ayw, false);
            if (l != null && l.longValue() >= -2147483648L && l.longValue() <= 2147483647L) {
                return Integer.valueOf(l.intValue());
            }
            String str2 = (String) e.a(str, null, String.class, this.ayw, false);
            if (str2 != null) {
                if (StringUtils.isNumeric(str2)) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                this.sdk.BN();
                if (x.Fn()) {
                    x BN = this.sdk.BN();
                    BN.i("TcfManager", "String value (" + str2 + ") for " + str + " is not numeric - storing value as null");
                }
            }
        }
        return null;
    }

    private Integer An() {
        String name = d.aRw.getName();
        if (this.ayw.contains(name)) {
            Integer num = (Integer) e.a(name, null, Integer.class, this.ayw, false);
            if (num == null) {
                Long l = (Long) e.a(name, null, Long.class, this.ayw, false);
                if (l == null) {
                    Boolean bool = (Boolean) e.a(name, null, Boolean.class, this.ayw, false);
                    if (bool != null) {
                        return Integer.valueOf(bool.booleanValue() ? 1 : 0);
                    }
                    String str = (String) e.a(name, null, String.class, this.ayw, false);
                    if (str != null) {
                        if ("1".equals(str) || "true".equals(str)) {
                            return 1;
                        }
                        if ("0".equals(str) || "false".equals(str)) {
                            return 0;
                        }
                        this.sdk.BN();
                        if (x.Fn()) {
                            x BN = this.sdk.BN();
                            BN.i("TcfManager", "String value (" + str + ") for " + name + " is invalid - setting GDPR Applies to null");
                        }
                        return null;
                    }
                } else if (l.longValue() == 1 || l.longValue() == 0) {
                    return Integer.valueOf(l.intValue());
                } else {
                    this.sdk.BN();
                    if (x.Fn()) {
                        x BN2 = this.sdk.BN();
                        BN2.i("TcfManager", "Long value (" + l + ") for " + name + " is invalid - setting GDPR Applies to null");
                    }
                    return null;
                }
            } else if (num.intValue() == 1 || num.intValue() == 0) {
                return num;
            } else {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN3 = this.sdk.BN();
                    BN3.i("TcfManager", "Integer value (" + num + ") for " + name + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
        }
        return null;
    }

    private void co(String str) {
        x.D("TcfManager", "Attempting to update consent from Additional Consent string: " + str);
        Boolean f = d.f(IronSourceConstants.RV_AUCTION_FAILED, str);
        if (f != null) {
            if (f.booleanValue()) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().f("TcfManager", "Found AppLovin ID in the list of consented ATP IDs - setting user consent to true");
                }
                AppLovinPrivacySettings.setHasUserConsent(true, n.getApplicationContext());
            } else {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().f("TcfManager", "Could not find AppLovin ID in the list of consented ATP IDs - setting user consent to false");
                }
                AppLovinPrivacySettings.setHasUserConsent(false, n.getApplicationContext());
            }
            this.sdk.Bu();
            return;
        }
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f("TcfManager", "AC string is not valid or AppLovin was not listed on the CMP flow - no consent update");
        }
    }

    private void cp(String str) {
        if (str != null) {
            for (c next : this.ayD) {
                if (next.Av() == c.a.TCF_VENDOR && next.Aw() != null) {
                    next.c(Boolean.valueOf(d.e(str, next.Aw().intValue() - 1)));
                }
            }
            return;
        }
        for (c c : this.ayD) {
            c.c((Boolean) null);
        }
    }

    private void cq(String str) {
        for (c next : this.ayD) {
            if (next.Av() == c.a.ATP_NETWORK && next.Aw() != null) {
                next.c(d.f(next.Aw().intValue(), str));
            }
        }
    }

    private void Ao() {
        this.ayx = null;
        this.ayz = null;
        this.ayA = null;
        this.ayB = null;
        this.ayC = null;
        for (c c : this.ayD) {
            c.c((Boolean) null);
        }
    }

    private String b(String str, Object obj) {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(str);
        sb.append(" - ");
        sb.append(obj != null ? obj.toString() : "No value set");
        return sb.toString();
    }
}
