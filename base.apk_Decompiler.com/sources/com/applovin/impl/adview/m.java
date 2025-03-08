package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.j;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkUtils;

class m extends Dialog implements l {
    private final Activity ahM;
    private final d ahN;
    private final a ahO;
    private RelativeLayout ahP;
    /* access modifiers changed from: private */
    public j ahQ;
    private final x logger;
    private final n sdk;

    public a rI() {
        return this.ahO;
    }

    public d rJ() {
        return this.ahN;
    }

    m(a aVar, d dVar, Activity activity, n nVar) {
        super(activity, 16973840);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (dVar == null) {
            throw new IllegalArgumentException("No main view specified");
        } else if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity != null) {
            this.sdk = nVar;
            this.logger = nVar.BN();
            this.ahM = activity;
            this.ahN = dVar;
            this.ahO = aVar;
            requestWindowFeature(1);
            setCancelable(false);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        rF();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.ahM.getWindow().getAttributes().flags, this.ahM.getWindow().getAttributes().flags);
                window.addFlags(16777216);
            } else if (x.Fn()) {
                this.logger.i("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
            }
        } catch (Throwable th) {
            if (x.Fn()) {
                this.logger.c("ExpandedAdDialog", "Setting window flags failed.", th);
            }
        }
    }

    private void rF() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.ahN.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.ahM);
        this.ahP = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ahP.setBackgroundColor(-1157627904);
        this.ahP.addView(this.ahN);
        if (!this.ahO.FN()) {
            a(this.ahO.FO());
            rH();
        }
        setContentView(this.ahP);
    }

    private void rG() {
        this.ahN.bq("javascript:al_onCloseTapped();");
        dismiss();
    }

    public void onBackPressed() {
        this.ahN.bq("javascript:al_onBackPressed();");
        dismiss();
    }

    public void dismiss() {
        d statsManagerHelper = this.ahN.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.JP();
        }
        this.ahM.runOnUiThread(new m$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rL() {
        this.ahP.removeView(this.ahN);
        super.dismiss();
    }

    private void a(j.a aVar) {
        if (this.ahQ == null) {
            j a = j.a(aVar, this.ahM);
            this.ahQ = a;
            a.setVisibility(8);
            this.ahQ.setOnClickListener(new m$$ExternalSyntheticLambda2(this));
            this.ahQ.setClickable(false);
            int ga = ga(((Integer) this.sdk.a(b.aME)).intValue());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ga, ga);
            layoutParams.addRule(10);
            int i = 9;
            layoutParams.addRule(((Boolean) this.sdk.a(b.aMH)).booleanValue() ? 9 : 11);
            this.ahQ.fZ(ga);
            int ga2 = ga(((Integer) this.sdk.a(b.aMG)).intValue());
            int ga3 = ga(((Integer) this.sdk.a(b.aMF)).intValue());
            layoutParams.setMargins(ga3, ga2, ga3, 0);
            this.ahP.addView(this.ahQ, layoutParams);
            this.ahQ.bringToFront();
            int ga4 = ga(((Integer) this.sdk.a(b.aMI)).intValue());
            View view = new View(this.ahM);
            view.setBackgroundColor(0);
            int i2 = ga + ga4;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams2.addRule(10);
            if (!((Boolean) this.sdk.a(b.aMH)).booleanValue()) {
                i = 11;
            }
            layoutParams2.addRule(i);
            layoutParams2.setMargins(ga3 - ga(5), ga2 - ga(5), ga3 - ga(5), 0);
            view.setOnClickListener(new m$$ExternalSyntheticLambda3(this));
            this.ahP.addView(view, layoutParams2);
            view.bringToFront();
        } else if (x.Fn()) {
            this.logger.h("ExpandedAdDialog", "Attempting to create duplicate close button");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        rG();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        if (this.ahQ.isClickable()) {
            this.ahQ.performClick();
        }
    }

    private void rH() {
        this.ahM.runOnUiThread(new m$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rK() {
        try {
            if (this.ahQ == null) {
                rG();
            }
            this.ahQ.setVisibility(0);
            this.ahQ.bringToFront();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    m.this.ahQ.setClickable(true);
                }
            });
            this.ahQ.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            if (x.Fn()) {
                this.logger.c("ExpandedAdDialog", "Unable to fade in close button", th);
            }
            rG();
        }
    }

    private int ga(int i) {
        return AppLovinSdkUtils.dpToPx(this.ahM, i);
    }
}
