package com.applovin.mediation.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.c;
import com.applovin.impl.sdk.utils.v;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;

public class MaxAdView extends RelativeLayout {
    private MaxAdViewImpl aYs;
    private View aYt;
    private int aYu;

    public MaxAdView(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, AppLovinSdk appLovinSdk, Context context) {
        this(str, c.T(context), appLovinSdk, context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, Context context) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Context context) {
        super(context.getApplicationContext());
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", sdk=" + appLovinSdk + ")");
        a(str, maxAdFormat, 49, appLovinSdk, context);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.aYs.setListener(maxAdViewAdListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.aYs.setRevenueListener(maxAdRevenueListener);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.aYs.setRequestListener(maxAdRequestListener);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.aYs.setAdReviewListener(maxAdReviewListener);
    }

    public void loadAd() {
        this.aYs.logApiCall("loadAd()");
        this.aYs.loadAd();
    }

    public void startAutoRefresh() {
        this.aYs.logApiCall("startAutoRefresh()");
        this.aYs.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.aYs.logApiCall("stopAutoRefresh()");
        this.aYs.stopAutoRefresh();
    }

    public void setPlacement(String str) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setPlacement(placement=" + str + ")");
        this.aYs.setPlacement(str);
    }

    public String getPlacement() {
        this.aYs.logApiCall("getPlacement()");
        return this.aYs.getPlacement();
    }

    public String getAdUnitId() {
        return this.aYs.getAdUnitId();
    }

    public MaxAdFormat getAdFormat() {
        return this.aYs.getAdFormat();
    }

    public void destroy() {
        this.aYs.logApiCall("destroy()");
        this.aYs.destroy();
    }

    public void setExtraParameter(String str, String str2) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.aYs.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.aYs.setLocalExtraParameter(str, obj);
    }

    public void setCustomData(String str) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setCustomData(value=" + str + ")");
        this.aYs.setCustomData(str);
    }

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MaxAdFormat maxAdFormat;
        String a = c.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adUnitId");
        String a2 = c.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adFormat");
        if (StringUtils.isValidString(a2)) {
            maxAdFormat = MaxAdFormat.formatFromString(a2);
        } else {
            maxAdFormat = c.T(context);
        }
        MaxAdFormat maxAdFormat2 = maxAdFormat;
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (a == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(a)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (isInEditMode()) {
            ao(context);
        } else {
            a(a, maxAdFormat2, attributeIntValue, AppLovinSdk.getInstance(context), context);
        }
    }

    private void a(String str, MaxAdFormat maxAdFormat, int i, AppLovinSdk appLovinSdk, Context context) {
        View view = new View(context.getApplicationContext());
        this.aYt = view;
        view.setBackgroundColor(0);
        addView(this.aYt);
        this.aYt.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aYu = getVisibility();
        this.aYs = new MaxAdViewImpl(str.trim(), maxAdFormat, this, this.aYt, appLovinSdk.a(), context);
        setGravity(i);
        if (getBackground() instanceof ColorDrawable) {
            setBackgroundColor(((ColorDrawable) getBackground()).getColor());
        }
        super.setBackgroundColor(0);
    }

    private void ao(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, i, i2);
    }

    public void setBackgroundColor(int i) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setBackgroundColor(color=" + i + ")");
        MaxAdViewImpl maxAdViewImpl2 = this.aYs;
        if (maxAdViewImpl2 != null) {
            maxAdViewImpl2.setPublisherBackgroundColor(i);
        }
        View view = this.aYt;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setAlpha(float f) {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        maxAdViewImpl.logApiCall("setAlpha(alpha=" + f + ")");
        View view = this.aYt;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.aYs;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!isInEditMode()) {
            MaxAdViewImpl maxAdViewImpl = this.aYs;
            maxAdViewImpl.logApiCall("onWindowVisibilityChanged(visibility=" + i + ")");
            if (this.aYs != null && v.T(this.aYu, i)) {
                this.aYs.onWindowVisibilityChanged(i);
            }
            this.aYu = i;
        }
    }
}
