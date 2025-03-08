package com.applovin.mediation.nativeAds;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.ads.b;
import com.applovin.impl.mediation.b.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.nativeAd.AppLovinStarRatingView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.l;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MaxNativeAdView extends FrameLayout {
    public static final String MEDIUM_TEMPLATE_1 = "medium_template_1";
    private final TextView aYF;
    private final TextView aYG;
    private final TextView aYH;
    private final Button aYI;
    private final ImageView aYJ;
    private final FrameLayout aYK;
    private final ViewGroup aYL;
    private final FrameLayout aYM;
    private final ViewGroup aYN;
    private final ViewGroup aYO;
    private final FrameLayout aYP;
    private b adViewTracker;
    private final View mainView;

    public b getAdViewTracker() {
        return this.adViewTracker;
    }

    public TextView getAdvertiserTextView() {
        return this.aYG;
    }

    public TextView getBodyTextView() {
        return this.aYH;
    }

    public Button getCallToActionButton() {
        return this.aYI;
    }

    @Deprecated
    public FrameLayout getIconContentView() {
        return this.aYK;
    }

    public ImageView getIconImageView() {
        return this.aYJ;
    }

    public View getMainView() {
        return this.mainView;
    }

    @Deprecated
    public FrameLayout getMediaContentView() {
        return this.aYP;
    }

    public ViewGroup getMediaContentViewGroup() {
        ViewGroup viewGroup = this.aYO;
        return viewGroup != null ? viewGroup : this.aYP;
    }

    @Deprecated
    public FrameLayout getOptionsContentView() {
        return this.aYM;
    }

    public ViewGroup getOptionsContentViewGroup() {
        ViewGroup viewGroup = this.aYL;
        return viewGroup != null ? viewGroup : this.aYM;
    }

    public ViewGroup getStarRatingContentViewGroup() {
        return this.aYN;
    }

    public TextView getTitleTextView() {
        return this.aYF;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaxNativeAdView(MaxNativeAd maxNativeAd, Activity activity) {
        this(maxNativeAd, (String) null, activity);
        String str = null;
    }

    public MaxNativeAdView(String str, Context context) {
        this((MaxNativeAd) null, str, context);
    }

    @Deprecated
    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Activity activity) {
        this(maxNativeAd, str, activity.getApplicationContext());
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Context context) {
        this(maxNativeAd, new MaxNativeAdViewBinder.Builder(-1).setTemplateType(str).setTitleTextViewId(R.id.applovin_native_title_text_view).setAdvertiserTextViewId(R.id.applovin_native_advertiser_text_view).setBodyTextViewId(R.id.applovin_native_body_text_view).setCallToActionButtonId(R.id.applovin_native_cta_button).setIconImageViewId(R.id.applovin_native_icon_image_view).setIconContentViewId(R.id.applovin_native_icon_view).setOptionsContentViewGroupId(R.id.applovin_native_options_view).setOptionsContentFrameLayoutId(R.id.applovin_native_options_view).setStarRatingContentViewGroupId(R.id.applovin_native_star_rating_view).setMediaContentViewGroupId(R.id.applovin_native_media_content_view).setMediaContentFrameLayoutId(R.id.applovin_native_media_content_view).build(), context);
    }

    public MaxNativeAdView(MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        this((MaxNativeAd) null, maxNativeAdViewBinder, context);
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        super(context);
        int i;
        boolean z = maxNativeAdViewBinder.templateType != null;
        MaxAdFormat format = maxNativeAd != null ? maxNativeAd.getFormat() : MaxAdFormat.NATIVE;
        if (maxNativeAdViewBinder.mainView != null) {
            this.mainView = maxNativeAdViewBinder.mainView;
        } else {
            if (z) {
                i = b(maxNativeAdViewBinder.templateType, format);
            } else {
                i = maxNativeAdViewBinder.layoutResourceId;
            }
            this.mainView = LayoutInflater.from(context).inflate(i, this, false);
        }
        addView(this.mainView);
        this.aYF = (TextView) findViewById(maxNativeAdViewBinder.titleTextViewId);
        this.aYG = (TextView) findViewById(maxNativeAdViewBinder.advertiserTextViewId);
        this.aYH = (TextView) findViewById(maxNativeAdViewBinder.bodyTextViewId);
        this.aYI = (Button) findViewById(maxNativeAdViewBinder.callToActionButtonId);
        this.aYJ = (ImageView) findViewById(maxNativeAdViewBinder.iconImageViewId);
        this.aYK = (FrameLayout) findViewById(maxNativeAdViewBinder.iconContentViewId);
        this.aYL = (ViewGroup) findViewById(maxNativeAdViewBinder.optionsContentViewGroupId);
        this.aYM = (FrameLayout) findViewById(maxNativeAdViewBinder.optionsContentFrameLayoutId);
        this.aYN = (ViewGroup) findViewById(maxNativeAdViewBinder.starRatingContentViewGroupId);
        this.aYO = (ViewGroup) findViewById(maxNativeAdViewBinder.mediaContentViewGroupId);
        this.aYP = (FrameLayout) findViewById(maxNativeAdViewBinder.mediaContentFrameLayoutId);
        if (maxNativeAd != null) {
            a(maxNativeAd);
        }
    }

    public void render(d dVar, a.C0067a aVar, n nVar) {
        recycle();
        if (!dVar.yp().get() || !dVar.yo().get()) {
            this.adViewTracker = new b(dVar, this, aVar, nVar);
        }
        MaxNativeAd nativeAd = dVar.getNativeAd();
        if (dVar.isContainerClickable() && nativeAd.isContainerClickable()) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().f("MaxNativeAdView", "Enabling container click");
            }
            setOnClickListener(new MaxNativeAdView$$ExternalSyntheticLambda0(nativeAd));
        }
        if (StringUtils.isValidString(dVar.yn())) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().f("MaxNativeAdView", "Rendering template ad view");
            }
            a(nativeAd);
            return;
        }
        nVar.BN();
        if (x.Fn()) {
            nVar.BN().f("MaxNativeAdView", "Rendering custom ad view");
        }
        renderCustomNativeAdView(nativeAd);
    }

    public void recycle() {
        setOnClickListener((View.OnClickListener) null);
        b bVar = this.adViewTracker;
        if (bVar != null) {
            bVar.destroy();
            this.adViewTracker = null;
        }
        View view = this.mainView;
        if (view != null && view.getParent() != this) {
            ViewGroup viewGroup = (ViewGroup) this.mainView.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                removeView(viewGroup);
            }
            addView(this.mainView);
        }
    }

    private int b(String str, MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.NATIVE) {
            if ("small_template_1".equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_small_template_1;
            }
            if (MEDIUM_TEMPLATE_1.equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_medium_template_1;
            }
            throw new IllegalArgumentException("Attempting to render MAX native ad with invalid format: " + str);
        } else if (maxAdFormat == MaxAdFormat.BANNER) {
            if ("vertical_banner_template".equals(str)) {
                return R.layout.max_native_ad_vertical_banner_view;
            }
            if ("media_banner_template".equals(str) || "no_body_banner_template".equals(str)) {
                return R.layout.max_native_ad_media_banner_view;
            }
            if ("vertical_media_banner_template".equals(str)) {
                return R.layout.max_native_ad_vertical_media_banner_view;
            }
            return R.layout.max_native_ad_banner_view;
        } else if (maxAdFormat == MaxAdFormat.LEADER) {
            if ("vertical_leader_template".equals(str)) {
                return R.layout.max_native_ad_vertical_leader_view;
            }
            return R.layout.max_native_ad_leader_view;
        } else if (maxAdFormat == MaxAdFormat.MREC) {
            return R.layout.max_native_ad_mrec_view;
        } else {
            throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
        }
    }

    private void a(MaxNativeAd maxNativeAd) {
        if (this.aYF == null) {
            x.F("MaxNativeAdView", "Rendering template ad view without title text view");
        } else if (StringUtils.isValidString(maxNativeAd.getTitle())) {
            this.aYF.setText(maxNativeAd.getTitle());
        } else {
            this.aYF.setVisibility(8);
        }
        if (this.aYG != null) {
            if (StringUtils.isValidString(maxNativeAd.getAdvertiser())) {
                this.aYG.setText(maxNativeAd.getAdvertiser());
            } else {
                this.aYG.setVisibility(8);
            }
        }
        if (this.aYH != null) {
            if (StringUtils.isValidString(maxNativeAd.getBody())) {
                this.aYH.setText(maxNativeAd.getBody());
            } else if (maxNativeAd.getFormat() == MaxAdFormat.NATIVE || maxNativeAd.getFormat() == MaxAdFormat.MREC) {
                this.aYH.setVisibility(8);
            } else {
                this.aYH.setVisibility(4);
            }
        }
        if (this.aYI != null) {
            if (StringUtils.isValidString(maxNativeAd.getCallToAction())) {
                this.aYI.setText(maxNativeAd.getCallToAction());
            } else if (maxNativeAd.getFormat() == MaxAdFormat.NATIVE || maxNativeAd.getFormat() == MaxAdFormat.MREC) {
                this.aYI.setVisibility(8);
            } else {
                this.aYI.setVisibility(4);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        View iconView = maxNativeAd.getIconView();
        FrameLayout frameLayout = this.aYK;
        if (frameLayout != null) {
            if (icon == null || this.aYJ == null) {
                if (iconView != null) {
                    iconView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    this.aYK.removeAllViews();
                    this.aYK.addView(iconView);
                } else {
                    frameLayout.setVisibility(8);
                }
            } else if (icon.getDrawable() != null) {
                this.aYJ.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() == null || !StringUtils.isValidString(icon.getUri().toString())) {
                this.aYK.setVisibility(8);
            } else if (((Boolean) n.aAC.a(com.applovin.impl.sdk.c.a.aJK)).booleanValue()) {
                l.a(this.aYJ, icon.getUri());
            } else {
                this.aYJ.setImageURI(icon.getUri());
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        FrameLayout frameLayout2 = this.aYM;
        if (frameLayout2 != null && optionsView != null) {
            optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.aYM.addView(optionsView);
            this.aYM.bringToFront();
        } else if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        View mediaView = maxNativeAd.getMediaView();
        if (this.aYP != null) {
            if (mediaView != null) {
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.aYP.addView(mediaView);
            } else if (maxNativeAd.getFormat() == MaxAdFormat.LEADER) {
                this.aYP.setVisibility(8);
            }
        }
        if (this.aYN != null) {
            Double starRating = maxNativeAd.getStarRating();
            if (starRating != null) {
                this.aYN.removeAllViews();
                AppLovinStarRatingView appLovinStarRatingView = new AppLovinStarRatingView(starRating, getContext());
                appLovinStarRatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.aYN.addView(appLovinStarRatingView);
            } else {
                this.aYN.setVisibility(8);
            }
        }
        ML();
        postDelayed(new MaxNativeAdView$$ExternalSyntheticLambda1(this), 2000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void MM() {
        setSelected(true);
    }

    public void renderCustomNativeAdView(MaxNativeAd maxNativeAd) {
        TextView textView = this.aYF;
        if (textView != null) {
            textView.setText(maxNativeAd.getTitle());
        }
        TextView textView2 = this.aYH;
        if (textView2 != null) {
            textView2.setText(maxNativeAd.getBody());
        }
        TextView textView3 = this.aYG;
        if (textView3 != null) {
            textView3.setText(maxNativeAd.getAdvertiser());
        }
        Button button = this.aYI;
        if (button != null) {
            button.setText(maxNativeAd.getCallToAction());
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        ImageView imageView = this.aYJ;
        if (imageView != null) {
            if (icon == null) {
                imageView.setImageDrawable((Drawable) null);
            } else if (icon.getDrawable() != null) {
                this.aYJ.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() == null) {
                this.aYJ.setImageDrawable((Drawable) null);
            } else if (((Boolean) n.aAC.a(com.applovin.impl.sdk.c.a.aJK)).booleanValue()) {
                l.a(this.aYJ, icon.getUri());
            } else {
                this.aYJ.setImageURI(icon.getUri());
            }
        }
        View mediaView = maxNativeAd.getMediaView();
        ViewGroup viewGroup = this.aYO;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (mediaView != null) {
                ViewParent parent = mediaView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeAllViews();
                }
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.aYO.addView(mediaView);
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        ViewGroup viewGroup2 = this.aYL;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            if (optionsView != null) {
                ViewParent parent2 = optionsView.getParent();
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeAllViews();
                }
                optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.aYL.addView(optionsView);
                this.aYL.bringToFront();
            }
        }
        ViewGroup viewGroup3 = this.aYN;
        if (viewGroup3 != null) {
            viewGroup3.removeAllViews();
            Double starRating = maxNativeAd.getStarRating();
            if (starRating != null) {
                AppLovinStarRatingView appLovinStarRatingView = new AppLovinStarRatingView(starRating, getContext());
                appLovinStarRatingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.aYN.addView(appLovinStarRatingView);
            }
        }
    }

    private void ML() {
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.applovin_native_inner_parent_layout);
        if (viewGroup != null) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                final WeakReference weakReference = new WeakReference(viewTreeObserver);
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                            n.aAC.BN();
                            if (x.Fn()) {
                                n.aAC.BN().h("MaxNativeAdView", "Failed to remove onPreDrawListener since the view tree observer is not alive.");
                            }
                        } else {
                            viewTreeObserver.removeOnPreDrawListener(this);
                        }
                        weakReference.clear();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                        layoutParams.height = ((View) viewGroup.getParent()).getWidth();
                        viewGroup.setLayoutParams(layoutParams);
                        return true;
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.adViewTracker;
        if (bVar != null) {
            bVar.uy();
        }
        if (!isHardwareAccelerated()) {
            x.F("MaxNativeAdView", "Attached to non-hardware accelerated window: some native ad views require hardware accelerated Activities to render properly.");
        }
    }

    public List<View> getClickableViews() {
        ArrayList arrayList = new ArrayList(5);
        TextView textView = this.aYF;
        if (textView != null) {
            arrayList.add(textView);
        }
        TextView textView2 = this.aYG;
        if (textView2 != null) {
            arrayList.add(textView2);
        }
        TextView textView3 = this.aYH;
        if (textView3 != null) {
            arrayList.add(textView3);
        }
        Button button = this.aYI;
        if (button != null) {
            arrayList.add(button);
        }
        ImageView imageView = this.aYJ;
        if (imageView != null) {
            arrayList.add(imageView);
        }
        return arrayList;
    }
}
