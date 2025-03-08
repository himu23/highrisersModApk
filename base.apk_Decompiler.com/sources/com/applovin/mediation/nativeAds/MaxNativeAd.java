package com.applovin.mediation.nativeAds;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.applovin.impl.mediation.nativeAds.MaxNativeAdImpl;
import com.applovin.mediation.MaxAdFormat;
import java.util.List;

public class MaxNativeAd extends MaxNativeAdImpl {
    private static final float MINIMUM_STARS_TO_RENDER = 3.0f;
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final MaxAdFormat format;
    private final MaxNativeAdImage icon;
    private final View iconView;
    private boolean isExpired;
    private final MaxNativeAdImage mainImage;
    private final float mediaContentAspectRatio;
    private final View mediaView;
    private MaxNativeAdView nativeAdView;
    private final View optionsView;
    private final Double starRating;
    private final String title;

    public final String getAdvertiser() {
        return this.advertiser;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getCallToAction() {
        return this.callToAction;
    }

    public final MaxAdFormat getFormat() {
        return this.format;
    }

    public final MaxNativeAdImage getIcon() {
        return this.icon;
    }

    public final View getIconView() {
        return this.iconView;
    }

    public final MaxNativeAdImage getMainImage() {
        return this.mainImage;
    }

    public final float getMediaContentAspectRatio() {
        return this.mediaContentAspectRatio;
    }

    public final View getMediaView() {
        return this.mediaView;
    }

    public final View getOptionsView() {
        return this.optionsView;
    }

    public final Double getStarRating() {
        return this.starRating;
    }

    public final String getTitle() {
        return this.title;
    }

    public boolean isContainerClickable() {
        return false;
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
        return false;
    }

    @Deprecated
    public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
    }

    public void setExpired() {
        this.isExpired = true;
    }

    public void setNativeAdView(MaxNativeAdView maxNativeAdView) {
        this.nativeAdView = maxNativeAdView;
    }

    public boolean shouldPrepareViewForInteractionOnMainThread() {
        return true;
    }

    public MaxNativeAd(Builder builder) {
        this.format = builder.adFormat;
        this.title = builder.title;
        this.advertiser = builder.advertiser;
        this.body = builder.body;
        this.callToAction = builder.callToAction;
        this.icon = builder.icon;
        this.iconView = builder.iconView;
        this.optionsView = builder.optionsView;
        this.mediaView = builder.mediaView;
        this.mainImage = builder.mainImage;
        this.mediaContentAspectRatio = builder.mediaContentAspectRatio;
        Double l = builder.starRating;
        this.starRating = (l == null || l.doubleValue() < 3.0d) ? null : l;
    }

    public void performClick() {
        Button callToActionButton;
        MaxNativeAdView maxNativeAdView = this.nativeAdView;
        if (maxNativeAdView != null && (callToActionButton = maxNativeAdView.getCallToActionButton()) != null) {
            callToActionButton.performClick();
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public MaxAdFormat adFormat;
        /* access modifiers changed from: private */
        public String advertiser;
        /* access modifiers changed from: private */
        public String body;
        /* access modifiers changed from: private */
        public String callToAction;
        /* access modifiers changed from: private */
        public MaxNativeAdImage icon;
        /* access modifiers changed from: private */
        public View iconView;
        /* access modifiers changed from: private */
        public MaxNativeAdImage mainImage;
        /* access modifiers changed from: private */
        public float mediaContentAspectRatio;
        /* access modifiers changed from: private */
        public View mediaView;
        /* access modifiers changed from: private */
        public View optionsView;
        /* access modifiers changed from: private */
        public Double starRating;
        /* access modifiers changed from: private */
        public String title;

        public Builder setAdFormat(MaxAdFormat maxAdFormat) {
            this.adFormat = maxAdFormat;
            return this;
        }

        public Builder setAdvertiser(String str) {
            this.advertiser = str;
            return this;
        }

        public Builder setBody(String str) {
            this.body = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.callToAction = str;
            return this;
        }

        public Builder setIcon(MaxNativeAdImage maxNativeAdImage) {
            this.icon = maxNativeAdImage;
            return this;
        }

        public Builder setIconView(View view) {
            this.iconView = view;
            return this;
        }

        public Builder setMainImage(MaxNativeAdImage maxNativeAdImage) {
            this.mainImage = maxNativeAdImage;
            return this;
        }

        public Builder setMediaContentAspectRatio(float f) {
            this.mediaContentAspectRatio = f;
            return this;
        }

        public Builder setMediaView(View view) {
            this.mediaView = view;
            return this;
        }

        public Builder setOptionsView(View view) {
            this.optionsView = view;
            return this;
        }

        public Builder setStarRating(Double d) {
            this.starRating = d;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public MaxNativeAd build() {
            return new MaxNativeAd(this);
        }
    }

    public static class MaxNativeAdImage {
        private Drawable aYD;
        private Uri ef;

        public Drawable getDrawable() {
            return this.aYD;
        }

        public Uri getUri() {
            return this.ef;
        }

        public MaxNativeAdImage(Drawable drawable) {
            this.aYD = drawable;
        }

        public MaxNativeAdImage(Uri uri) {
            this.ef = uri;
        }
    }
}
