package com.applovin.impl.sdk.nativeAd;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.b.a;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.l;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.R;

public class AppLovinMediaView extends FrameLayout {
    protected final ImageView imageView;
    protected final x logger;
    protected final n sdk;

    public AppLovinMediaView(AppLovinNativeAdImpl appLovinNativeAdImpl, n nVar, Context context) {
        super(context);
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.sdk = nVar;
        this.logger = nVar.BN();
        LayoutInflater.from(context).inflate(R.layout.applovin_native_ad_media_view, this, true);
        Uri mainImageUri = appLovinNativeAdImpl.getMainImageUri();
        a vastAd = appLovinNativeAdImpl.getVastAd();
        Uri FI = vastAd != null ? vastAd.FI() : null;
        if (mainImageUri == null && FI == null) {
            throw new IllegalStateException("AppLovin native ad missing image AND video resources");
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (((Boolean) nVar.a(b.aNB)).booleanValue()) {
            setOnTouchListener(new AppLovinTouchToClickListener(nVar, b.aLp, context, appLovinNativeAdImpl));
        } else {
            setOnClickListener(appLovinNativeAdImpl);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view);
        this.imageView = imageView2;
        if (mainImageUri != null) {
            l.a(imageView2, mainImageUri);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    public float getAspectRatio() {
        Drawable drawable;
        ImageView imageView2 = this.imageView;
        if (imageView2 == null || (drawable = imageView2.getDrawable()) == null) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }

    public void destroy() {
        setOnClickListener((View.OnClickListener) null);
        setOnTouchListener((View.OnTouchListener) null);
        removeAllViews();
    }
}
