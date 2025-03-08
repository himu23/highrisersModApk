package com.applovin.impl.privacy.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.applovin.impl.privacy.a.c;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.privacy.a.e;
import com.applovin.impl.privacy.a.g;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.a;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class i {
    private final a aiO = new a() {
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            if (!(activity instanceof AppLovinWebViewActivity) && i.this.ayp != null) {
                if (i.this.ayq != null) {
                    i.this.ayq.dismiss();
                    Dialog unused = i.this.ayq = null;
                }
                e a = i.this.ayp;
                e unused2 = i.this.ayp = null;
                i.this.a(a, activity);
            }
        }
    };
    private final int aym;
    private List<e> ayn;
    private c.a ayo;
    /* access modifiers changed from: private */
    public e ayp;
    /* access modifiers changed from: private */
    public Dialog ayq;
    /* access modifiers changed from: private */
    public final n sdk;

    public boolean zY() {
        return this.ayn != null;
    }

    public i(n nVar) {
        this.sdk = nVar;
        this.aym = ((Integer) nVar.a(b.aQX)).intValue();
    }

    public void a(List<e> list, Activity activity, c.a aVar) {
        if (this.ayn != null) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("AppLovinSdk", "Unable to start states: " + list);
            }
            this.sdk.BN();
            if (x.Fn()) {
                x BN2 = this.sdk.BN();
                BN2.f("AppLovinSdk", "Consent flow already in progress for states: " + this.ayn);
            }
            aVar.onFlowCompleted(new a(a.axJ, "Consent flow is already in progress."));
            return;
        }
        this.ayn = list;
        this.ayo = aVar;
        n.E((Context) activity).a(this.aiO);
        a(Al(), activity);
    }

    public void aI(boolean z) {
        if (this.sdk.Cl().zX() != d.a.TERMS) {
            com.applovin.impl.privacy.a.b(z, n.getApplicationContext());
        }
    }

    public void Ak() {
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f("AppLovinSdk", "Reinitializing SDK and ending consent flow");
        }
        this.ayn = null;
        this.sdk.BM().b(this.aiO);
        c.a aVar = this.ayo;
        if (aVar != null) {
            aVar.onFlowCompleted((a) null);
            this.ayo = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(e eVar, Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new i$$ExternalSyntheticLambda1(this, eVar, activity));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(final e eVar, final Activity activity) {
        SpannableString spannableString;
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("AppLovinSdk", "Transitioning to state: " + eVar);
        }
        boolean z = false;
        if (eVar.Ac() == e.b.ALERT) {
            if (com.applovin.impl.sdk.utils.b.i(activity)) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        i iVar = i.this;
                        iVar.a(eVar, iVar.sdk.CF());
                    }
                }, TimeUnit.SECONDS.toMillis(1));
                return;
            }
            f fVar = (f) eVar;
            this.ayp = fVar;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(false);
            for (final g next : fVar.Af()) {
                AnonymousClass3 r4 = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        e unused = i.this.ayp = null;
                        Dialog unused2 = i.this.ayq = null;
                        e a = i.this.cm(next.Ah());
                        if (a == null) {
                            i.this.sdk.BN();
                            if (x.Fn()) {
                                i.this.sdk.BN().i("AppLovinSdk", "Consent flow failed to get destination state for TOS/PP alert. Finishing flow...");
                            }
                            i.this.Ak();
                            return;
                        }
                        i.this.a(a, activity);
                        if (a.Ac() != e.b.ALERT) {
                            dialogInterface.dismiss();
                        }
                    }
                };
                if (next.Ag() == g.a.POSITIVE) {
                    builder.setPositiveButton(next.getTitle(), r4);
                } else if (next.Ag() == g.a.NEGATIVE) {
                    builder.setNegativeButton(next.getTitle(), r4);
                } else {
                    builder.setNeutralButton(next.getTitle(), r4);
                }
            }
            String title = fVar.getTitle();
            if (StringUtils.isValidString(title)) {
                spannableString = new SpannableString(title);
                String gA = n.gA(R.string.applovin_terms_of_service_text);
                String gA2 = n.gA(R.string.applovin_privacy_policy_text);
                if (StringUtils.containsAtLeastOneSubstring(title, Arrays.asList(new String[]{gA, gA2}))) {
                    final Uri termsOfServiceUri = this.sdk.Cl().getTermsOfServiceUri();
                    if (termsOfServiceUri != null) {
                        StringUtils.addLinks(spannableString, Pattern.compile(gA), new ClickableSpan() {
                            public void onClick(View view) {
                                u.a(termsOfServiceUri, activity, i.this.sdk);
                            }
                        }, true);
                    }
                    final Uri privacyPolicyUri = this.sdk.Cl().getPrivacyPolicyUri();
                    StringUtils.addLinks(spannableString, Pattern.compile(gA2), new ClickableSpan() {
                        public void onClick(View view) {
                            u.a(privacyPolicyUri, activity, i.this.sdk);
                        }
                    }, true);
                }
            } else {
                spannableString = null;
            }
            AlertDialog create = builder.setTitle(spannableString).setMessage(fVar.getMessage()).create();
            create.setOnShowListener(new i$$ExternalSyntheticLambda0(this, create));
            this.ayq = create;
            create.show();
        } else if (eVar.Ac() == e.b.EVENT) {
            h hVar = (h) eVar;
            String name = hVar.getName();
            Map Aj = hVar.Aj();
            if (Aj == null) {
                Aj = new HashMap(1);
            }
            Aj.put("flow_type", this.sdk.Cl().zX().getType());
            this.sdk.BF().trackEvent(name, Aj);
            b(hVar, activity);
        } else if (eVar.Ac() == e.b.HAS_USER_CONSENT) {
            aI(true);
            b(eVar, activity);
        } else if (eVar.Ac() == e.b.CMP_LOAD) {
            if (com.applovin.impl.sdk.utils.b.i(activity)) {
                a(eVar);
            } else {
                this.sdk.Cn().loadCmp(activity, new CmpServiceImpl.a() {
                    public void c(AppLovinCmpError appLovinCmpError) {
                        i.this.a(eVar, activity, Boolean.valueOf(appLovinCmpError == null));
                    }
                });
            }
        } else if (eVar.Ac() == e.b.CMP_SHOW) {
            if (com.applovin.impl.sdk.utils.b.i(activity)) {
                a(eVar);
                return;
            }
            this.sdk.BF().trackEvent("cf_start");
            this.sdk.Cn().showCmp(activity, new CmpServiceImpl.b() {
                public void d(AppLovinCmpError appLovinCmpError) {
                    i.this.b(eVar, activity);
                }
            });
        } else if (eVar.Ac() == e.b.DECISION) {
            e.a Ad = eVar.Ad();
            if (Ad == e.a.IS_AL_GDPR) {
                boolean z2 = this.sdk.Cl().getDebugUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR && u.b(n.getApplicationContext(), this.sdk);
                if (this.sdk.getConfiguration().getConsentFlowUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR || z2) {
                    z = true;
                }
                a(eVar, activity, Boolean.valueOf(z));
                return;
            }
            throw new IllegalStateException("Unsupported decision type: " + Ad);
        } else if (eVar.Ac() == e.b.TERMS_FLOW) {
            List<e> i = b.i(this.sdk);
            if (i == null || i.size() <= 0) {
                Ak();
                return;
            }
            this.sdk.BF().trackEvent("cf_start");
            this.ayn = i;
            a(Al(), activity);
        } else if (eVar.Ac() == e.b.REINIT) {
            Ak();
        } else {
            throw new IllegalStateException("No destination consent flow state found!");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(alertDialog.getContext().getResources().getIdentifier("android:id/alertTitle", (String) null, (String) null));
        textView.setLinkTextColor(textView.getCurrentTextColor());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setMaxLines(this.aym);
    }

    private void a(final e eVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                i iVar = i.this;
                iVar.a(eVar, iVar.sdk.CF());
            }
        }, TimeUnit.SECONDS.toMillis(1));
    }

    /* access modifiers changed from: private */
    public void b(e eVar, Activity activity) {
        a(eVar, activity, (Boolean) null);
    }

    /* access modifiers changed from: private */
    public void a(e eVar, Activity activity, Boolean bool) {
        a(cm(eVar.b(bool)), activity);
    }

    /* access modifiers changed from: private */
    public e cm(String str) {
        List<e> list = this.ayn;
        if (list == null) {
            return null;
        }
        for (e next : list) {
            if (str.equalsIgnoreCase(next.mQ())) {
                return next;
            }
        }
        return null;
    }

    private e Al() {
        for (e next : this.ayn) {
            if (next.Ae()) {
                return next;
            }
        }
        return null;
    }
}
