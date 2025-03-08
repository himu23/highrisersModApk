package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import com.applovin.impl.sdk.r;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

public class j {
    private HandlerThread GH;
    private final long aAg;
    private final long aAh;
    /* access modifiers changed from: private */
    public final int aAi;
    private final int aAj;
    private WeakReference<View> aAk = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public int aAl = 0;
    /* access modifiers changed from: private */
    public Integer aAm = null;
    private a aAn;
    private Handler jS;
    /* access modifiers changed from: private */
    public final x logger;
    private final n sdk;
    private final Runnable v = new j$$ExternalSyntheticLambda3(this);

    public interface a {
        void onBlackViewDetected(View view);
    }

    private interface b {
        void aJ(boolean z);

        void b(Bitmap bitmap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bc() {
        this.aAn = null;
    }

    static /* synthetic */ int d(j jVar) {
        int i = jVar.aAl;
        jVar.aAl = i + 1;
        return i;
    }

    public j(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.aAg = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQC)).longValue();
        this.aAh = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQB)).longValue();
        this.aAi = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aQD)).intValue();
        this.aAj = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aQE)).intValue();
    }

    public void destroy() {
        AY();
        HandlerThread handlerThread = this.GH;
        if (handlerThread != null) {
            handlerThread.quit();
            this.GH = null;
        }
    }

    public void a(View view, a aVar) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQA)).booleanValue()) {
            View view2 = (View) this.aAk.get();
            if (view2 == null) {
                if (x.Fn()) {
                    x xVar = this.logger;
                    xVar.f("BlackViewDetector", "Started monitoring view: " + view);
                }
                try {
                    if (this.GH == null) {
                        HandlerThread handlerThread = new HandlerThread("AppLovinSdk:black_view_detector");
                        this.GH = handlerThread;
                        handlerThread.start();
                    } else {
                        this.sdk.Cs().a(r.a.CAUGHT_EXCEPTION, "BlackViewDetector", "maybeStartMonitoring() unexpectedly called multiple times");
                        AY();
                    }
                    this.aAn = aVar;
                    this.aAk = new WeakReference<>(view);
                    this.aAl = 0;
                    this.aAm = null;
                    Handler handler = new Handler(this.GH.getLooper());
                    this.jS = handler;
                    handler.postDelayed(this.v, this.aAh);
                } catch (Throwable th) {
                    AY();
                    this.sdk.Cs().d("BlackViewDetector", "maybeStartMonitoring", th);
                }
            } else if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.h("BlackViewDetector", "Monitoring is already in progress for a view: " + view2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void AY() {
        if (this.aAk.get() != null) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("BlackViewDetector", "Stopped monitoring view: " + this.aAk.get());
            }
            this.aAk.clear();
        }
        Handler handler = this.jS;
        if (handler != null) {
            handler.removeCallbacks(this.v);
            this.jS = null;
        }
        if (this.aAn != null) {
            AppLovinSdkUtils.runOnUiThread(new j$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    public void AZ() {
        View view = (View) this.aAk.get();
        if (view == null) {
            if (x.Fn()) {
                this.logger.h("BlackViewDetector", "Monitored view no longer exists.");
            }
            AY();
            return;
        }
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("BlackViewDetector", "Checking for black view: " + view);
        }
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth == 0 || measuredHeight == 0) {
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.h("BlackViewDetector", "Monitored view is not visible due to dimensions (width = " + measuredWidth + ", height = " + measuredHeight + ")");
            }
            this.aAl = 0;
            Ba();
            return;
        }
        a(view, (b) new b() {
            public void b(Bitmap bitmap) {
                int a = measuredWidth / j.this.aAi;
                int a2 = measuredHeight / j.this.aAi;
                int i = a / 2;
                for (int i2 = a2 / 2; i2 < measuredHeight; i2 += a2) {
                    for (int i3 = i; i3 < measuredWidth; i3 += a) {
                        int pixel = bitmap.getPixel(i3, i2);
                        if (j.this.gz(pixel)) {
                            int unused = j.this.aAl = 0;
                            bitmap.recycle();
                            j.this.Ba();
                            return;
                        }
                        if (j.this.aAm == null) {
                            Integer unused2 = j.this.aAm = Integer.valueOf(pixel);
                        }
                    }
                }
                j.d(j.this);
                bitmap.recycle();
                j.this.Ba();
            }

            public void aJ(boolean z) {
                if (z) {
                    j.this.AY();
                } else {
                    j.this.Ba();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void Ba() {
        long j = this.aAg;
        if (j <= 0) {
            if (this.aAl == 1) {
                Bb();
            }
            AY();
        } else if (this.aAl > 1) {
            Bb();
            AY();
        } else {
            Handler handler = this.jS;
            if (handler != null) {
                handler.postDelayed(this.v, j);
                return;
            }
            if (x.Fn()) {
                this.logger.h("BlackViewDetector", "Monitoring handler was unexpectedly null");
            }
            AY();
        }
    }

    private void Bb() {
        View view = (View) this.aAk.get();
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.h("BlackViewDetector", "Detected black view: " + view);
        }
        AppLovinSdkUtils.runOnUiThread(new j$$ExternalSyntheticLambda2(this, view));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(View view) {
        a aVar = this.aAn;
        if (aVar != null) {
            aVar.onBlackViewDetected(view);
        }
    }

    /* access modifiers changed from: private */
    public boolean gz(int i) {
        boolean z = Color.red(i) <= this.aAj && Color.blue(i) <= this.aAj && Color.green(i) <= this.aAj;
        Integer num = this.aAm;
        boolean z2 = (num == null || i == num.intValue()) ? false : true;
        if (!z || z2) {
            return true;
        }
        return false;
    }

    private void a(View view, final b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            Activity AA = this.sdk.BM().AA();
            if (AA == null) {
                if (x.Fn()) {
                    this.logger.i("BlackViewDetector", "Failed to capture screenshot due to no active activity");
                }
                bVar.aJ(false);
                return;
            }
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            Rect rect = new Rect(i, i2, i + measuredWidth, i2 + measuredHeight);
            try {
                final Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                PixelCopy.request(AA.getWindow(), rect, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() {
                    public void onPixelCopyFinished(int i) {
                        if (i == 0) {
                            bVar.b(createBitmap);
                            return;
                        }
                        x unused = j.this.logger;
                        if (x.Fn()) {
                            x f = j.this.logger;
                            f.i("BlackViewDetector", "Failed to capture screenshot with error code: " + i);
                        }
                        bVar.aJ(true);
                    }
                }, new Handler());
            } catch (Throwable th) {
                if (x.Fn()) {
                    x xVar = this.logger;
                    xVar.i("BlackViewDetector", "Failed to capture screenshot due to exception: " + th);
                }
                bVar.aJ(true);
            }
        } else {
            if (x.Fn()) {
                this.logger.h("BlackViewDetector", "Unable to capture screenshots on views below API 26");
            }
            bVar.aJ(true);
        }
    }
}
