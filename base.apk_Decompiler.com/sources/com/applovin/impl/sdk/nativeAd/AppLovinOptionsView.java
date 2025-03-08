package com.applovin.impl.sdk.nativeAd;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.s;
import com.applovin.sdk.R;

public class AppLovinOptionsView extends FrameLayout implements View.OnClickListener {
    private final Uri privacyDestinationUri;
    private final n sdk;

    public AppLovinOptionsView(AppLovinNativeAdImpl appLovinNativeAdImpl, n nVar, Context context) {
        super(context);
        this.sdk = nVar;
        this.privacyDestinationUri = appLovinNativeAdImpl.getPrivacyDestinationUri();
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Uri privacyIconUri = appLovinNativeAdImpl.getPrivacyIconUri();
        if (privacyIconUri != null) {
            imageView.setImageURI(privacyIconUri);
        } else {
            imageView.setImageResource(R.drawable.applovin_ic_privacy_icon_layered_list);
        }
        addView(imageView);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        s.a(this.privacyDestinationUri, n.getApplicationContext(), this.sdk);
    }

    public void destroy() {
        setOnClickListener((View.OnClickListener) null);
        removeAllViews();
    }
}
