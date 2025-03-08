package com.applovin.impl.mediation.debugger.ui.c;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.mediation.debugger.b.c.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class b extends d {
    private final com.applovin.impl.mediation.debugger.b.c.b arV;
    private List<c> asc;
    private final List<c> asd;
    private final List<c> ase;
    private final List<c> asf;
    private final List<c> asg;
    private SpannedString ash;

    public enum a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }

    public com.applovin.impl.mediation.debugger.b.c.b wA() {
        return this.arV;
    }

    b(com.applovin.impl.mediation.debugger.b.c.b bVar, Context context) {
        super(context);
        this.arV = bVar;
        if (bVar.vl() == b.a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.ash = new SpannedString(spannableString);
        } else {
            this.ash = new SpannedString("");
        }
        this.asc = wJ();
        this.asd = x(bVar.vB());
        this.ase = wN();
        this.asf = y(bVar.vC());
        this.asg = wO();
        notifyDataSetChanged();
    }

    public void wI() {
        this.asc = wJ();
    }

    public boolean a(com.applovin.impl.mediation.debugger.ui.d.a aVar) {
        return aVar.wP() == a.TEST_ADS.ordinal() && aVar.wQ() == this.asg.size() - 1;
    }

    /* access modifiers changed from: protected */
    public int tM() {
        return a.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public int gg(int i) {
        if (i == a.INTEGRATIONS.ordinal()) {
            return this.asc.size();
        }
        if (i == a.PERMISSIONS.ordinal()) {
            return this.asd.size();
        }
        if (i == a.CONFIGURATION.ordinal()) {
            return this.ase.size();
        }
        if (i == a.DEPENDENCIES.ordinal()) {
            return this.asf.size();
        }
        return this.asg.size();
    }

    /* access modifiers changed from: protected */
    public c gh(int i) {
        if (i == a.INTEGRATIONS.ordinal()) {
            return new e("INTEGRATIONS");
        }
        if (i == a.PERMISSIONS.ordinal()) {
            return new e("PERMISSIONS");
        }
        if (i == a.CONFIGURATION.ordinal()) {
            return new e("CONFIGURATION");
        }
        if (i == a.DEPENDENCIES.ordinal()) {
            return new e("DEPENDENCIES");
        }
        return new e("TEST ADS");
    }

    /* access modifiers changed from: protected */
    public List<c> gi(int i) {
        if (i == a.INTEGRATIONS.ordinal()) {
            return this.asc;
        }
        if (i == a.PERMISSIONS.ordinal()) {
            return this.asd;
        }
        if (i == a.CONFIGURATION.ordinal()) {
            return this.ase;
        }
        return i == a.DEPENDENCIES.ordinal() ? this.asf : this.asg;
    }

    private List<c> wJ() {
        ArrayList arrayList = new ArrayList(3);
        CollectionUtils.addObjectIfExists(wK(), arrayList);
        CollectionUtils.addObjectIfExists(wL(), arrayList);
        CollectionUtils.addObjectIfExists(wM(), arrayList);
        return arrayList;
    }

    private c wK() {
        c.a bP = c.wW().bO("SDK").bP(this.arV.getSdkVersion());
        if (TextUtils.isEmpty(this.arV.getSdkVersion())) {
            bP.gk(aB(this.arV.vo())).gn(aD(this.arV.vo()));
        }
        return bP.wX();
    }

    private c wL() {
        c.a bP = c.wW().bO("Adapter").bP(this.arV.getAdapterVersion());
        if (TextUtils.isEmpty(this.arV.getAdapterVersion())) {
            bP.gk(aB(this.arV.vp())).gn(aD(this.arV.vp()));
        }
        return bP.wX();
    }

    private c wM() {
        if (this.arV.vE()) {
            return null;
        }
        return c.wW().bO("Initialization Status").bP(gj(this.arV.vm())).aF(false).wX();
    }

    private List<c> x(List<com.applovin.impl.mediation.debugger.b.c.c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (com.applovin.impl.mediation.debugger.b.c.c next : list) {
                arrayList.add(a(next.getName(), next.vj(), next.vk(), true));
            }
        }
        return arrayList;
    }

    private List<c> wN() {
        ArrayList arrayList = new ArrayList(1);
        if (this.arV.vD()) {
            arrayList.add(a("Java 8", "For optimal performance, please enable Java 8 support. See: https://dash.applovin.com/documentation/mediation/android/getting-started/integration", n.CI(), true));
        }
        return arrayList;
    }

    private List<c> y(List<com.applovin.impl.mediation.debugger.b.c.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (com.applovin.impl.mediation.debugger.b.c.a next : list) {
                arrayList.add(a(next.getName(), next.vj(), next.vk(), true));
            }
        }
        return arrayList;
    }

    private List<c> wO() {
        ArrayList arrayList = new ArrayList(3);
        if (StringUtils.isValidString(this.arV.vG())) {
            arrayList.add(c.a(c.b.DETAIL).bO(this.arV.vG()).wX());
        }
        if (this.arV.vn() == b.C0073b.NOT_SUPPORTED) {
            return arrayList;
        }
        if (this.arV.vw() != null) {
            arrayList.add(z(this.arV.vw()));
        }
        if (this.arV.vH()) {
            arrayList.add(a("Not an Age Restricted User", "Test mode requires Age Restricted User (COPPA) to be set to false.", !AppLovinPrivacySettings.isAgeRestrictedUser(this.E) && AppLovinPrivacySettings.isAgeRestrictedUserSet(this.E), false));
        }
        arrayList.add(a(this.arV.vn()));
        return arrayList;
    }

    private c z(List<String> list) {
        return c.wW().bO("Region/VPN Required").bP(CollectionUtils.implode(list, ", ", list.size())).wX();
    }

    private c a(b.C0073b bVar) {
        c.a wW = c.wW();
        if (bVar == b.C0073b.READY) {
            wW.y(this.E);
        }
        return wW.bO("Test Mode").bP(bVar.vO()).gm(bVar.vP()).bQ("Restart Required").bR(bVar.vQ()).aF(true).wX();
    }

    private c a(String str, String str2, boolean z, boolean z2) {
        return c.a(z ? c.b.RIGHT_DETAIL : c.b.DETAIL).bO(str).b(z ? null : this.ash).bQ("Instructions").bR(str2).gk(z ? R.drawable.applovin_ic_check_mark_bordered : aC(z2)).gn(z ? g.a(R.color.applovin_sdk_checkmarkColor, this.E) : aE(z2)).aF(!z).wX();
    }

    private int aB(boolean z) {
        return z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark;
    }

    private int aC(boolean z) {
        return z ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning;
    }

    private int aD(boolean z) {
        return g.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.E);
    }

    private int aE(boolean z) {
        return g.a(z ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.E);
    }

    private String gj(int i) {
        if (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() == i || MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() == i || MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() == i) {
            return "Initialized";
        }
        if (MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i) {
            return "Failure";
        }
        return MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i ? "Initializing..." : "Not Initialized";
    }
}
