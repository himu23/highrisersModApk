package com.applovin.impl.a.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import androidx.core.net.MailTo;
import androidx.webkit.internal.AssetHelper;
import com.applovin.creative.MaxCreativeDebuggerActivity;
import com.applovin.impl.a.a.b.a.b;
import com.applovin.impl.mediation.e.c;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.k;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.m2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public class a implements k.a {
    /* access modifiers changed from: private */
    public static WeakReference<MaxCreativeDebuggerActivity> akk;
    /* access modifiers changed from: private */
    public static final AtomicBoolean akq = new AtomicBoolean();
    private final Context E;
    private final List<com.applovin.impl.a.a.a.a> akh = new ArrayList(10);
    private final Object aki = new Object();
    /* access modifiers changed from: private */
    public final b akj;
    private WeakReference<View> akl = new WeakReference<>((Object) null);
    private k akm;
    private r akn;
    private int ako;
    private boolean akp;
    /* access modifiers changed from: private */
    public final n sdk;

    /* access modifiers changed from: private */
    public /* synthetic */ void tD() {
        this.ako = 0;
    }

    public a(n nVar) {
        this.sdk = nVar;
        Context applicationContext = n.getApplicationContext();
        this.E = applicationContext;
        this.akj = new b(applicationContext);
    }

    public void tv() {
        if (isCreativeDebuggerEnabled()) {
            if (this.akm == null) {
                this.akm = new k(this.sdk, this);
            }
            this.akm.Lm();
        }
    }

    public void tw() {
        k kVar = this.akm;
        if (kVar != null) {
            kVar.Ln();
        }
    }

    public void V(Object obj) {
        if (!isCreativeDebuggerEnabled() || obj == null) {
            return;
        }
        if (c.Z(obj) && !W(obj)) {
            return;
        }
        if (!c.aa(obj) || !W(obj)) {
            synchronized (this.aki) {
                this.akh.add(0, new com.applovin.impl.a.a.a.a(obj, System.currentTimeMillis()));
                if (this.akh.size() > 10) {
                    List<com.applovin.impl.a.a.a.a> list = this.akh;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public void showCreativeDebugger() {
        ArrayList arrayList;
        if (tx() || !akq.compareAndSet(false, true)) {
            x.H("AppLovinSdk", "Creative Debugger is already showing");
            return;
        }
        synchronized (this.aki) {
            arrayList = new ArrayList(this.akh);
        }
        this.akj.initialize(arrayList, this.sdk);
        if (!this.akp) {
            ty();
            this.akp = true;
        }
        Intent intent = new Intent(this.E, MaxCreativeDebuggerActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        x.D("AppLovinSdk", "Starting Creative Debugger...");
        this.E.startActivity(intent);
    }

    public boolean isCreativeDebuggerEnabled() {
        return ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aMr)).booleanValue() && this.sdk.getSettings().isCreativeDebuggerEnabled();
    }

    /* access modifiers changed from: private */
    public boolean tx() {
        WeakReference<MaxCreativeDebuggerActivity> weakReference = akk;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private boolean W(Object obj) {
        MaxAdFormat maxAdFormat;
        if (obj instanceof e) {
            maxAdFormat = ((e) obj).getAdZone().getFormat();
        } else {
            maxAdFormat = obj instanceof com.applovin.impl.mediation.b.a ? ((com.applovin.impl.mediation.b.a) obj).getFormat() : null;
        }
        return maxAdFormat != null && maxAdFormat.isFullscreenAd();
    }

    private void ty() {
        this.sdk.BM().a(new com.applovin.impl.sdk.utils.a() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof MaxCreativeDebuggerActivity) {
                    x.D("AppLovinSdk", "Started Creative Debugger");
                    if (!a.this.tx() || a.akk.get() != activity) {
                        MaxCreativeDebuggerActivity maxCreativeDebuggerActivity = (MaxCreativeDebuggerActivity) activity;
                        WeakReference unused = a.akk = new WeakReference(maxCreativeDebuggerActivity);
                        maxCreativeDebuggerActivity.a(a.this.akj, a.this.sdk.BM());
                    }
                    a.akq.set(false);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof MaxCreativeDebuggerActivity) {
                    x.D("AppLovinSdk", "Creative Debugger destroyed");
                    WeakReference unused = a.akk = null;
                }
            }
        });
    }

    public void tz() {
        if (this.ako == 0) {
            this.akn = r.b(TimeUnit.SECONDS.toMillis(3), this.sdk, new a$$ExternalSyntheticLambda2(this));
        }
        int i = this.ako;
        if (i % 2 == 0) {
            this.ako = i + 1;
        }
    }

    public void tA() {
        int i = this.ako;
        if (i % 2 == 1) {
            this.ako = i + 1;
        }
        if (this.ako / 2 == 2) {
            AppLovinSdkUtils.runOnUiThread(new a$$ExternalSyntheticLambda0(this));
            this.ako = 0;
            this.akn.tT();
        }
    }

    /* access modifiers changed from: private */
    public void tB() {
        if (isCreativeDebuggerEnabled() && this.akl.get() == null && !tx()) {
            Activity Az = this.sdk.BM().Az();
            if (Az == null) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().i("AppLovinSdk", "Failed to display Creative Debugger button");
                    return;
                }
                return;
            }
            View findViewById = Az.findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) findViewById;
                View a = a(Az);
                frameLayout.addView(a);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(150);
                a.startAnimation(alphaAnimation);
                ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                a$$ExternalSyntheticLambda3 a__externalsyntheticlambda3 = new a$$ExternalSyntheticLambda3(this, a, frameLayout);
                viewTreeObserver.addOnGlobalLayoutListener(a__externalsyntheticlambda3);
                AppLovinSdkUtils.runOnUiThreadDelayed(new a$$ExternalSyntheticLambda4(this, frameLayout, a, viewTreeObserver, a__externalsyntheticlambda3), TimeUnit.SECONDS.toMillis(5));
                this.akl = new WeakReference<>(a);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, FrameLayout frameLayout) {
        if (view.getParent() == null && this.akl.get() != null) {
            frameLayout.addView(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(FrameLayout frameLayout, View view, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        frameLayout.removeView(view);
        this.akl = new WeakReference<>((Object) null);
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.widget.Button} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.widget.Button} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.widget.Button} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(android.app.Activity r6) {
        /*
            r5 = this;
            r0 = 40
            int r0 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r6, r0)
            int r1 = r0 / 10
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 8388629(0x800015, float:1.1754973E-38)
            r2.<init>(r0, r0, r3)
            r2.setMargins(r1, r1, r1, r1)
            android.widget.ImageButton r0 = new android.widget.ImageButton     // Catch:{ all -> 0x0030 }
            r0.<init>(r6)     // Catch:{ all -> 0x0030 }
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ all -> 0x0030 }
            int r4 = com.applovin.sdk.R.drawable.applovin_ic_white_small     // Catch:{ all -> 0x0030 }
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)     // Catch:{ all -> 0x0030 }
            r0.setImageDrawable(r3)     // Catch:{ all -> 0x0030 }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ all -> 0x0030 }
            r0.setScaleType(r3)     // Catch:{ all -> 0x0030 }
            int r3 = r1 * 2
            r0.setPadding(r1, r1, r1, r3)     // Catch:{ all -> 0x0030 }
            goto L_0x004b
        L_0x0030:
            android.widget.Button r0 = new android.widget.Button
            r0.<init>(r6)
            java.lang.String r1 = "ⓘ"
            r0.setText(r1)
            r1 = -1
            r0.setTextColor(r1)
            r1 = 0
            r0.setAllCaps(r1)
            r3 = 1101004800(0x41a00000, float:20.0)
            r4 = 2
            r0.setTextSize(r4, r3)
            r0.setPadding(r1, r1, r1, r1)
        L_0x004b:
            r0.setLayoutParams(r2)
            android.graphics.drawable.Drawable r1 = r5.tC()
            r0.setBackground(r1)
            com.applovin.impl.a.a.a$$ExternalSyntheticLambda1 r1 = new com.applovin.impl.a.a.a$$ExternalSyntheticLambda1
            r1.<init>(r5)
            r0.setOnClickListener(r1)
            boolean r1 = com.applovin.impl.sdk.utils.h.KX()
            if (r1 == 0) goto L_0x006c
            r1 = 5
            int r6 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r6, r1)
            float r6 = (float) r6
            r0.setElevation(r6)
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.a.a.a.a(android.app.Activity):android.view.View");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        showCreativeDebugger();
    }

    private Drawable tC() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.rgb(5, 131, 170));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(Color.rgb(2, 98, WorkQueueKt.MASK));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public void a(com.applovin.impl.a.a.a.a aVar, Context context, boolean z) {
        Object tH = aVar.tH();
        String a = a(aVar);
        com.applovin.impl.sdk.utils.n nVar = new com.applovin.impl.sdk.utils.n();
        if (z) {
            nVar.dA("Please describe the issue you had with this ad:\n\n\n\n");
        }
        nVar.dA(a);
        String X = this.sdk.Co().X(tH);
        if (X != null) {
            nVar.dz("\nBid Response:\n");
            nVar.dz(X);
        }
        String str = "AppLovin Ad Report";
        Intent createChooser = Intent.createChooser(new Intent("android.intent.action.SEND").setType(AssetHelper.DEFAULT_MIME_TYPE).putExtra("android.intent.extra.SUBJECT", tH instanceof e ? str : "MAX Ad Report").putExtra("android.intent.extra.TEXT", nVar.toString()).setPackage((String) null), "Share Ad Report");
        if (z) {
            try {
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(MailTo.MAILTO_SCHEME));
                if (!(tH instanceof e)) {
                    str = "MAX Ad Report";
                }
                context.startActivity(intent.putExtra("android.intent.extra.SUBJECT", str).putExtra("android.intent.extra.TEXT", nVar.toString()).setPackage("com.google.android.gm"));
            } catch (ActivityNotFoundException unused) {
                context.startActivity(createChooser);
            }
        } else {
            context.startActivity(createChooser);
        }
    }

    public String a(com.applovin.impl.a.a.a.a aVar) {
        String str;
        Object tH = aVar.tH();
        com.applovin.impl.sdk.utils.n nVar = new com.applovin.impl.sdk.utils.n();
        nVar.dA("Ad Info:\n");
        if (tH instanceof e) {
            e eVar = (e) tH;
            nVar.e("Network", "APPLOVIN").g(eVar).h(eVar);
        } else if (tH instanceof com.applovin.impl.mediation.b.a) {
            nVar.n((com.applovin.impl.mediation.b.a) tH);
        }
        nVar.L(this.sdk);
        nVar.e("Epoch Timestamp (ms)", Long.valueOf(aVar.tI()));
        if (this.sdk.BV() != null) {
            str = this.sdk.BU().Ed();
        } else {
            str = this.sdk.BS().CX();
        }
        nVar.dz("\nDebug Info:\n").e("Platform", "fireos".equals(str) ? "Fire OS" : m2.e).e("AppLovin SDK Version", AppLovinSdk.VERSION).e("Plugin Version", this.sdk.a(com.applovin.impl.sdk.c.b.aOD)).e("App Package Name", this.E.getPackageName()).e("Device", String.format("%s %s (%s)", new Object[]{Build.BRAND, Build.MODEL, Build.DEVICE})).e("OS Version", Build.VERSION.RELEASE).e("AppLovin Random Token", this.sdk.BB()).e("Ad Review Version", f.getVersion()).T(Y(tH)).e("User ID", this.sdk.Bz() != null ? this.sdk.Bz() : "None").e("AEI", this.sdk.a(com.applovin.impl.sdk.c.b.aKC)).e("MEI", this.sdk.a(com.applovin.impl.sdk.c.b.aKD));
        return nVar.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r3 = new com.applovin.impl.sdk.ad.c(r0, r2.sdk).FR();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String X(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof com.applovin.impl.sdk.ad.e
            if (r0 == 0) goto L_0x000f
            com.applovin.impl.sdk.ad.e r3 = (com.applovin.impl.sdk.ad.e) r3
            org.json.JSONObject r3 = r3.getOriginalFullResponse()
            java.lang.String r3 = r3.toString()
            return r3
        L_0x000f:
            boolean r0 = r3 instanceof com.applovin.impl.mediation.b.a
            if (r0 == 0) goto L_0x0033
            r0 = r3
            com.applovin.impl.mediation.b.a r0 = (com.applovin.impl.mediation.b.a) r0
            java.lang.String r0 = r0.getBidResponse()
            boolean r3 = com.applovin.impl.mediation.e.c.aa(r3)
            if (r3 == 0) goto L_0x0032
            com.applovin.impl.sdk.ad.c r3 = new com.applovin.impl.sdk.ad.c
            com.applovin.impl.sdk.n r1 = r2.sdk
            r3.<init>(r0, r1)
            org.json.JSONObject r3 = r3.FR()
            if (r3 == 0) goto L_0x0032
            java.lang.String r3 = r3.toString()
            return r3
        L_0x0032:
            return r0
        L_0x0033:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.a.a.a.X(java.lang.Object):java.lang.String");
    }

    private Bundle Y(Object obj) {
        Bundle cu = this.sdk.Cv().cu(u.ah(obj));
        if (cu == null) {
            return null;
        }
        for (String str : cu.keySet()) {
            Object obj2 = cu.get(str);
            cu.remove(str);
            BundleUtils.put(StringUtils.toHumanReadableString(str), obj2, cu);
        }
        return cu;
    }
}
