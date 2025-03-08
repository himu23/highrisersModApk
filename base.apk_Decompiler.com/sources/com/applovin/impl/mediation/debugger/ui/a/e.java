package com.applovin.impl.mediation.debugger.ui.a;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;

public class e extends Dialog {
    private Activity ahM;
    private RelativeLayout ahP;
    private ViewGroup aqG;
    private AppLovinSdkUtils.Size aqH;

    public e(ViewGroup viewGroup, AppLovinSdkUtils.Size size, Activity activity) {
        super(activity, 16973840);
        this.aqG = viewGroup;
        this.aqH = size;
        this.ahM = activity;
        requestWindowFeature(1);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this.ahM, this.aqH.getWidth()), AppLovinSdkUtils.dpToPx(this.ahM, this.aqH.getHeight()));
        layoutParams.addRule(13);
        this.aqG.setLayoutParams(layoutParams);
        int dpToPx = AppLovinSdkUtils.dpToPx(this.ahM, 60);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        ImageButton imageButton = new ImageButton(this.ahM);
        imageButton.setLayoutParams(layoutParams2);
        imageButton.setImageDrawable(this.ahM.getResources().getDrawable(R.drawable.applovin_ic_x_mark));
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setColorFilter(-1);
        imageButton.setBackground((Drawable) null);
        imageButton.setOnClickListener(new e$$ExternalSyntheticLambda0(this));
        RelativeLayout relativeLayout = new RelativeLayout(this.ahM);
        this.ahP = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.ahP.setBackgroundColor(Integer.MIN_VALUE);
        this.ahP.addView(imageButton);
        this.ahP.addView(this.aqG);
        this.ahP.setOnClickListener(new e$$ExternalSyntheticLambda1(this));
        setContentView(this.ahP);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        dismiss();
    }

    public void dismiss() {
        this.ahP.removeView(this.aqG);
        super.dismiss();
    }
}
