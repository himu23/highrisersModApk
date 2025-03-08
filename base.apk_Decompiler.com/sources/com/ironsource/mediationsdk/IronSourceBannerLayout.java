package com.ironsource.mediationsdk;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.f1;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;

public class IronSourceBannerLayout extends FrameLayout {
    /* access modifiers changed from: private */
    public View a;
    private ISBannerSize b;
    private String c;
    private Activity d;
    private boolean e = false;
    /* access modifiers changed from: private */
    public boolean f = false;
    private b g;

    class a implements Runnable {
        final /* synthetic */ IronSourceError a;
        final /* synthetic */ boolean b;

        a(IronSourceError ironSourceError, boolean z) {
            this.a = ironSourceError;
            this.b = z;
        }

        public void run() {
            f1 a2;
            IronSourceError ironSourceError;
            boolean z;
            if (IronSourceBannerLayout.this.f) {
                a2 = f1.a();
                ironSourceError = this.a;
                z = true;
            } else {
                if (IronSourceBannerLayout.this.a != null) {
                    IronSourceBannerLayout ironSourceBannerLayout = IronSourceBannerLayout.this;
                    ironSourceBannerLayout.removeView(ironSourceBannerLayout.a);
                    View unused = IronSourceBannerLayout.this.a = null;
                }
                a2 = f1.a();
                ironSourceError = this.a;
                z = this.b;
            }
            a2.a(ironSourceError, z);
        }
    }

    public interface b {
        void onWindowFocusChanged(boolean z);
    }

    public IronSourceBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.d = activity;
        this.b = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.e = true;
        this.d = null;
        this.b = null;
        this.c = null;
        this.a = null;
        this.g = null;
        removeBannerListener();
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        this.a = view;
        l.a(this, view, layoutParams);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void a(AdInfo adInfo, boolean z) {
        f1.a().a(adInfo, z);
        this.f = true;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void a(IronSourceError ironSourceError, boolean z) {
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(ironSourceError, z));
    }

    /* access modifiers changed from: protected */
    public IronSourceBannerLayout b() {
        IronSourceBannerLayout ironSourceBannerLayout = new IronSourceBannerLayout(this.d, this.b);
        ironSourceBannerLayout.setPlacementName(this.c);
        return ironSourceBannerLayout;
    }

    public Activity getActivity() {
        return this.d;
    }

    public BannerListener getBannerListener() {
        return f1.a().c();
    }

    public LevelPlayBannerListener getLevelPlayBannerListener() {
        return f1.a().b();
    }

    public String getPlacementName() {
        return this.c;
    }

    public ISBannerSize getSize() {
        return this.b;
    }

    public b getWindowFocusChangedListener() {
        return this.g;
    }

    public boolean isDestroyed() {
        return this.e;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b bVar = this.g;
        if (bVar != null) {
            bVar.onWindowFocusChanged(z);
        }
    }

    public void removeBannerListener() {
        IronLog.API.info();
        f1.a().a((BannerListener) null);
        f1.a().a((LevelPlayBannerListener) null);
    }

    public void setBannerListener(BannerListener bannerListener) {
        IronLog.API.info();
        f1.a().a(bannerListener);
    }

    public void setLevelPlayBannerListener(LevelPlayBannerListener levelPlayBannerListener) {
        IronLog.API.info();
        f1.a().a(levelPlayBannerListener);
    }

    public void setPlacementName(String str) {
        this.c = str;
    }

    public void setWindowFocusChangedListener(b bVar) {
        this.g = bVar;
    }
}
