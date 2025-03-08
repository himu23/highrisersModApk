package com.fyber.inneractive.sdk.activities;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.r;
import com.fyber.inneractive.sdk.flow.z;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.renderers.k;
import com.fyber.inneractive.sdk.ui.CloseButtonFlowManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;

public class InneractiveFullscreenAdActivity extends InneractiveBaseActivity implements c.a {
    public static final String EXTRA_KEY_SPOT_ID = "spotId";
    public ViewGroup b;
    public InneractiveAdSpot c;
    public c d;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public boolean h = false;
    public CloseButtonFlowManager i;
    public final Runnable mHideNavigationBarTask = new a();

    public interface FullScreenRendererProvider {
        c getFullscreenRenderer();
    }

    public interface OnInneractiveFullscreenAdDestroyListener {
        void onActivityDestroyed(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity);
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (!InneractiveFullscreenAdActivity.this.isFinishing()) {
                InneractiveFullscreenAdActivity.this.hideNavigationBar();
            }
        }
    }

    public class b implements View.OnSystemUiVisibilityChangeListener {
        public b() {
        }

        public void onSystemUiVisibilityChange(int i) {
            if ((i & 2) == 0) {
                q.b.postDelayed(InneractiveFullscreenAdActivity.this.mHideNavigationBarTask, 3000);
            }
        }
    }

    public void cancelHideNavigationBarTask() {
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener) null);
        q.b.removeCallbacks(this.mHideNavigationBarTask);
    }

    public void destroy() {
        if (!isFinishing() && this.b != null) {
            finish();
        }
    }

    public ViewGroup getLayout() {
        return this.b;
    }

    public void initWindowFeatures(c cVar) {
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        getWindow().addFlags(128);
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().addFlags(2);
        }
        if (cVar != null && (((r) cVar) instanceof k)) {
            setTheme(16973831);
            requestWindowFeature(67108864);
            requestWindowFeature(134217728);
            requestWindowFeature(Integer.MIN_VALUE);
        }
        hideNavigationBar();
        a0 a0Var = (a0) this.c.getAdContent().d;
        if (a0Var.f != null) {
            Orientation orientation = a0Var.f.e;
            setActivityOrientation(orientation.allowOrientationChange, orientation);
        }
    }

    public void onBackPressed() {
        c cVar = this.d;
        if (cVar == null || !cVar.v()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c cVar = this.d;
        if (cVar != null) {
            int i2 = configuration.orientation;
            if (i2 != this.e) {
                this.e = i2;
                cVar.b();
                return;
            }
            int i3 = this.f;
            int i4 = configuration.screenHeightDp;
            if (i3 != i4 || this.g != configuration.screenWidthDp) {
                this.f = i4;
                this.g = configuration.screenWidthDp;
                cVar.b();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("spotId");
        InneractiveAdSpot inneractiveAdSpot = null;
        if (TextUtils.isEmpty(stringExtra)) {
            IAlog.e("%sSpot id must be provided as an extra before calling createActivity with InneractiveInterstitialAdActivty", IAlog.a((Object) this));
        } else {
            InneractiveAdSpot spot = InneractiveAdSpotManager.get().getSpot(stringExtra);
            if (spot == null) {
                IAlog.b("%sSpot id %s cannot be found in spot manager!", IAlog.a((Object) this), stringExtra);
            }
            if (spot != null && spot.getAdContent() == null) {
                IAlog.a("%sSpot does not have a content. Cannot start activity", IAlog.a((Object) this));
            }
            if (!(spot == null || spot.getAdContent() == null)) {
                inneractiveAdSpot = spot;
            }
        }
        this.c = inneractiveAdSpot;
        if (inneractiveAdSpot == null || inneractiveAdSpot.getAdContent() == null || this.c.getAdContent().d == null) {
            super.onCreate(bundle);
            finish();
            return;
        }
        InneractiveUnitController selectedUnitController = this.c.getSelectedUnitController();
        if (selectedUnitController == null || !(selectedUnitController instanceof FullScreenRendererProvider)) {
            IAlog.e("%sno appropriate unit controller found for full screen ad. Aborting", IAlog.a((Object) this));
            super.onCreate(bundle);
            finish();
            return;
        }
        c fullscreenRenderer = ((FullScreenRendererProvider) selectedUnitController).getFullscreenRenderer();
        this.d = fullscreenRenderer;
        initWindowFeatures(fullscreenRenderer);
        super.onCreate(bundle);
        IAlog.a("%sInterstitial for spot id %s created", IAlog.a((Object) this), this.c.getLocalUniqueId());
        this.e = getResources().getConfiguration().orientation;
        this.f = getResources().getConfiguration().screenHeightDp;
        this.g = getResources().getConfiguration().screenWidthDp;
        if (this.d != null) {
            try {
                setContentView(R.layout.ia_fullscreen_activity);
                this.b = (ViewGroup) findViewById(R.id.ia_ad_content);
                this.i = new CloseButtonFlowManager(this);
                c cVar = this.d;
                InneractiveAdSpot inneractiveAdSpot2 = this.c;
                z zVar = (z) cVar;
                zVar.a = inneractiveAdSpot2;
                zVar.b = inneractiveAdSpot2.getAdContent();
                zVar.c = inneractiveAdSpot2.getSelectedUnitController().getEventsListener();
                zVar.v.a = inneractiveAdSpot2;
                try {
                    this.d.a(this, this);
                    this.c.getAdContent().e = true;
                } catch (InneractiveUnitController.AdDisplayError e2) {
                    IAlog.e("Interstitial Activity: %s", e2.getMessage());
                    finish();
                } catch (Resources.NotFoundException e3) {
                    IAlog.e("Interstitial Activity: %s", e3.getMessage());
                    finish();
                }
            } catch (Throwable th) {
                t.a(th, this.c.getAdContent().a, this.c.getAdContent().d());
                finish();
            }
        } else {
            IAlog.e("Interstitial Activity: Could not find an appropriate full screen ad renderer for content!", new Object[0]);
            finish();
        }
    }

    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            c cVar = this.d;
            if (cVar != null) {
                cVar.m();
                this.d.destroy();
                this.d = null;
                return;
            }
            return;
        }
        c cVar2 = this.d;
        if (cVar2 != null) {
            cVar2.t();
        }
    }

    public void onResume() {
        super.onResume();
        c cVar = this.d;
        if (cVar != null) {
            cVar.o();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            hideNavigationBar();
            c cVar = this.d;
            if (cVar != null) {
                cVar.o();
                return;
            }
            return;
        }
        c cVar2 = this.d;
        if (cVar2 != null) {
            cVar2.t();
        }
    }

    public void setActivityOrientation(boolean z, Orientation orientation) {
        if (z && orientation.equals(Orientation.USER)) {
            setRequestedOrientation(13);
        } else if (z && orientation.equals(Orientation.NONE)) {
            setRequestedOrientation(getRequestedOrientation());
        } else if (orientation.equals(Orientation.LANDSCAPE)) {
            setRequestedOrientation(6);
        } else if (orientation.equals(Orientation.PORTRAIT)) {
            setRequestedOrientation(7);
        } else {
            int i2 = getResources().getConfiguration().orientation;
            if (i2 == 1) {
                setRequestedOrientation(7);
            } else if (i2 == 2) {
                setRequestedOrientation(6);
            }
        }
    }

    public void updateCloseCountdown(int i2) {
        CloseButtonFlowManager closeButtonFlowManager = this.i;
        closeButtonFlowManager.getClass();
        if (i2 > 0) {
            closeButtonFlowManager.b.setText(Integer.toString(i2));
        }
    }

    public boolean wasDismissedByUser() {
        return this.h;
    }

    public void disableCloseButton() {
        CloseButtonFlowManager closeButtonFlowManager = this.i;
        closeButtonFlowManager.c.setVisibility(8);
        closeButtonFlowManager.a.setVisibility(8);
    }

    public void dismissAd(boolean z) {
        this.h = z;
        cancelHideNavigationBarTask();
        c cVar = this.d;
        if (cVar != null) {
            cVar.b(z);
        }
    }

    public View getCloseButton() {
        return this.i.e;
    }

    public void hideNavigationBar() {
        View decorView = getWindow().getDecorView();
        if ((decorView.getSystemUiVisibility() & 2) == 0) {
            decorView.setSystemUiVisibility(2818);
        }
        decorView.setOnSystemUiVisibilityChangeListener(new b());
    }

    public boolean isCloseButtonDisplay() {
        return this.i.d.getVisibility() == 0;
    }

    public void onDestroy() {
        InneractiveUnitController inneractiveUnitController;
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.b = null;
        }
        InneractiveAdSpot inneractiveAdSpot = this.c;
        if (inneractiveAdSpot == null) {
            inneractiveUnitController = null;
        } else {
            inneractiveUnitController = inneractiveAdSpot.getSelectedUnitController();
        }
        if (inneractiveUnitController != null && (inneractiveUnitController instanceof OnInneractiveFullscreenAdDestroyListener)) {
            ((OnInneractiveFullscreenAdDestroyListener) inneractiveUnitController).onActivityDestroyed(this);
        }
        c cVar = this.d;
        if (cVar != null) {
            cVar.m();
            this.d.destroy();
            this.d = null;
        }
        super.onDestroy();
        InneractiveAdSpot inneractiveAdSpot2 = this.c;
        if (inneractiveAdSpot2 != null) {
            inneractiveAdSpot2.destroy();
        }
    }

    public void secondEndCardWasDisplayed() {
        this.i.f = true;
    }

    public void showCloseButton(boolean z, int i2, int i3) {
        int i4;
        int i5;
        CloseButtonFlowManager closeButtonFlowManager = this.i;
        if (!z || closeButtonFlowManager.f) {
            closeButtonFlowManager.a.setAlpha(1.0f);
            closeButtonFlowManager.d.setAlpha(1.0f);
        } else {
            closeButtonFlowManager.a.setAlpha(0.0f);
            closeButtonFlowManager.d.setAlpha(0.0f);
        }
        closeButtonFlowManager.b.setText("");
        closeButtonFlowManager.b.setVisibility(8);
        if (i2 >= 5) {
            int round = Math.round((((float) i2) * p.b()) + 0.5f);
            closeButtonFlowManager.d.getLayoutParams().width = round;
            closeButtonFlowManager.d.getLayoutParams().height = round;
        }
        if (i3 >= 5) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) closeButtonFlowManager.a.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) closeButtonFlowManager.c.getLayoutParams();
            int round2 = Math.round((((float) i3) * p.b()) + 0.5f);
            int i6 = ((FrameLayout.LayoutParams) closeButtonFlowManager.d.getLayoutParams()).width;
            int i7 = round2 - i6;
            if (round2 <= i6 || i7 <= (i5 = layoutParams.rightMargin)) {
                layoutParams2.width = round2;
                layoutParams2.height = round2;
                i4 = layoutParams.rightMargin;
                if (i7 < i4) {
                    i4 -= i7 / 2;
                }
            } else {
                int i8 = (round2 / 2) + (i6 / 2) + i5;
                layoutParams2.width = i8;
                layoutParams2.height = i8;
                layoutParams.gravity = 53;
                i4 = 0;
            }
            layoutParams2.setMargins(i4, i4, i4, i4);
            layoutParams2.gravity = 17;
        }
        closeButtonFlowManager.a.setVisibility(0);
        closeButtonFlowManager.d.setVisibility(0);
        closeButtonFlowManager.c.setVisibility(0);
    }

    public void showCloseCountdown() {
        CloseButtonFlowManager closeButtonFlowManager = this.i;
        closeButtonFlowManager.b.setBackgroundResource(R.drawable.ia_round_overlay_bg);
        closeButtonFlowManager.a.setVisibility(0);
        closeButtonFlowManager.b.setVisibility(0);
        closeButtonFlowManager.d.setVisibility(8);
        closeButtonFlowManager.c.setVisibility(8);
    }
}
