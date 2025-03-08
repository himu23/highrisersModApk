package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.applovin.sdk.R;

public final class AspectRatioFrameLayout extends FrameLayout {
    private final b VJ;
    /* access modifiers changed from: private */
    public a VK;
    private float VL;
    private int VM;

    public interface a {
        void a(float f, float f2, boolean z);
    }

    public int getResizeMode() {
        return this.VM;
    }

    public void setAspectRatioListener(a aVar) {
        this.VK = aVar;
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VM = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AppLovinAspectRatioFrameLayout, 0, 0);
            try {
                this.VM = obtainStyledAttributes.getInt(R.styleable.AppLovinAspectRatioFrameLayout_al_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.VJ = new b();
    }

    public void setAspectRatio(float f) {
        if (this.VL != f) {
            this.VL = f;
            requestLayout();
        }
    }

    public void setResizeMode(int i) {
        if (this.VM != i) {
            this.VM = i;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float f;
        float f2;
        super.onMeasure(i, i2);
        if (this.VL > 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f3 = (float) measuredWidth;
            float f4 = (float) measuredHeight;
            float f5 = f3 / f4;
            float f6 = (this.VL / f5) - 1.0f;
            if (Math.abs(f6) <= 0.01f) {
                this.VJ.b(this.VL, f5, false);
                return;
            }
            int i3 = this.VM;
            if (i3 != 0) {
                if (i3 == 1) {
                    f2 = this.VL;
                } else if (i3 != 2) {
                    if (i3 == 4) {
                        if (f6 > 0.0f) {
                            f = this.VL;
                        } else {
                            f2 = this.VL;
                        }
                    }
                    this.VJ.b(this.VL, f5, true);
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                } else {
                    f = this.VL;
                }
                measuredHeight = (int) (f3 / f2);
                this.VJ.b(this.VL, f5, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            } else if (f6 > 0.0f) {
                f2 = this.VL;
                measuredHeight = (int) (f3 / f2);
                this.VJ.b(this.VL, f5, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            } else {
                f = this.VL;
            }
            measuredWidth = (int) (f4 * f);
            this.VJ.b(this.VL, f5, true);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    private final class b implements Runnable {
        private float VN;
        private float VO;
        private boolean VP;
        private boolean VQ;

        private b() {
        }

        public void b(float f, float f2, boolean z) {
            this.VN = f;
            this.VO = f2;
            this.VP = z;
            if (!this.VQ) {
                this.VQ = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }

        public void run() {
            this.VQ = false;
            if (AspectRatioFrameLayout.this.VK != null) {
                AspectRatioFrameLayout.this.VK.a(this.VN, this.VO, this.VP);
            }
        }
    }
}
