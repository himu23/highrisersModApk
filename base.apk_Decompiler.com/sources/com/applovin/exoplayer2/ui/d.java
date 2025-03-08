package com.applovin.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.ui.k;
import com.applovin.sdk.R;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public class d extends View implements k {
    private int NK;
    private long WA;
    private int WB;
    private Rect WC;
    private ValueAnimator WD;
    private float WE;
    private boolean WF;
    private boolean WG;
    private long WH;
    private long WI;
    private long[] WJ;
    private boolean[] WK;
    private final Rect Wa;
    private final Rect Wb;
    private final Rect Wc;
    private final Rect Wd;
    private final Paint We;
    private final Paint Wf;
    private final Paint Wg;
    private final Paint Wh;
    private final Paint Wi;
    private final Paint Wj;
    private final Drawable Wk;
    private final int Wl;
    private final int Wm;
    private final int Wn;
    private final int Wo;
    private final int Wp;
    private final int Wq;
    private final int Wr;
    private final int Ws;
    private final int Wt;
    private final StringBuilder Wu;
    private final Formatter Wv;
    private final Runnable Ww;
    private final Point Wx;
    private final float Wy;
    private int Wz;
    private final CopyOnWriteArraySet<k.a> hv;
    private long uc;
    private long zE;

    private static int e(float f, int i) {
        return (int) ((((float) i) * f) + 0.5f);
    }

    private static int f(float f, int i) {
        return (int) (((float) i) / f);
    }

    public d(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2, int i2) {
        super(context, attributeSet, i);
        AttributeSet attributeSet3 = attributeSet2;
        this.Wa = new Rect();
        this.Wb = new Rect();
        this.Wc = new Rect();
        this.Wd = new Rect();
        Paint paint = new Paint();
        this.We = paint;
        Paint paint2 = new Paint();
        this.Wf = paint2;
        Paint paint3 = new Paint();
        this.Wg = paint3;
        Paint paint4 = new Paint();
        this.Wh = paint4;
        Paint paint5 = new Paint();
        this.Wi = paint5;
        Paint paint6 = new Paint();
        this.Wj = paint6;
        paint6.setAntiAlias(true);
        this.hv = new CopyOnWriteArraySet<>();
        this.Wx = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.Wy = f;
        this.Wt = e(f, -50);
        int e = e(f, 4);
        int e2 = e(f, 26);
        int e3 = e(f, 4);
        int e4 = e(f, 12);
        int e5 = e(f, 0);
        int e6 = e(f, 16);
        if (attributeSet3 != null) {
            Paint paint7 = paint4;
            Paint paint8 = paint5;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, R.styleable.AppLovinDefaultTimeBar, i, i2);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.AppLovinDefaultTimeBar_al_scrubber_drawable);
                this.Wk = drawable;
                if (drawable != null) {
                    a(drawable);
                    e2 = Math.max(drawable.getMinimumHeight(), e2);
                }
                this.Wl = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_bar_height, e);
                this.Wm = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_touch_target_height, e2);
                this.Wn = obtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_bar_gravity, 0);
                this.Wo = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_ad_marker_width, e3);
                this.Wp = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_enabled_size, e4);
                this.Wq = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_disabled_size, e5);
                this.Wr = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_dragged_size, e6);
                int i3 = obtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_played_color, -1);
                int i4 = obtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_scrubber_color, -1);
                int i5 = obtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_buffered_color, -855638017);
                int i6 = obtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_unplayed_color, 872415231);
                int i7 = obtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_ad_marker_color, -1291845888);
                int i8 = obtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_played_ad_marker_color, 872414976);
                paint.setColor(i3);
                paint6.setColor(i4);
                paint2.setColor(i5);
                paint3.setColor(i6);
                paint7.setColor(i7);
                paint8.setColor(i8);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.Wl = e;
            this.Wm = e2;
            this.Wn = 0;
            this.Wo = e3;
            this.Wp = e4;
            this.Wq = e5;
            this.Wr = e6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.Wk = null;
        }
        StringBuilder sb = new StringBuilder();
        this.Wu = sb;
        this.Wv = new Formatter(sb, Locale.getDefault());
        this.Ww = new d$$ExternalSyntheticLambda2(this);
        Drawable drawable2 = this.Wk;
        if (drawable2 != null) {
            this.Ws = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.Ws = (Math.max(this.Wq, Math.max(this.Wp, this.Wr)) + 1) / 2;
        }
        this.WE = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.WD = valueAnimator;
        valueAnimator.addUpdateListener(new d$$ExternalSyntheticLambda3(this));
        this.zE = -9223372036854775807L;
        this.WA = -9223372036854775807L;
        this.Wz = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ln() {
        an(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.WE = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.Wa);
    }

    public void setPlayedColor(int i) {
        this.We.setColor(i);
        invalidate(this.Wa);
    }

    public void setScrubberColor(int i) {
        this.Wj.setColor(i);
        invalidate(this.Wa);
    }

    public void setBufferedColor(int i) {
        this.Wf.setColor(i);
        invalidate(this.Wa);
    }

    public void setUnplayedColor(int i) {
        this.Wg.setColor(i);
        invalidate(this.Wa);
    }

    public void setAdMarkerColor(int i) {
        this.Wh.setColor(i);
        invalidate(this.Wa);
    }

    public void setPlayedAdMarkerColor(int i) {
        this.Wi.setColor(i);
        invalidate(this.Wa);
    }

    public void a(k.a aVar) {
        a.checkNotNull(aVar);
        this.hv.add(aVar);
    }

    public void setKeyTimeIncrement(long j) {
        a.checkArgument(j > 0);
        this.Wz = -1;
        this.WA = j;
    }

    public void setKeyCountIncrement(int i) {
        a.checkArgument(i > 0);
        this.Wz = i;
        this.WA = -9223372036854775807L;
    }

    public void setPosition(long j) {
        if (this.uc != j) {
            this.uc = j;
            setContentDescription(getProgressText());
            nr();
        }
    }

    public void setBufferedPosition(long j) {
        if (this.WI != j) {
            this.WI = j;
            nr();
        }
    }

    public void setDuration(long j) {
        if (this.zE != j) {
            this.zE = j;
            if (this.WG && j == -9223372036854775807L) {
                an(true);
            }
            nr();
        }
    }

    public long getPreferredUpdateDelay() {
        int f = f(this.Wy, this.Wb.width());
        if (f != 0) {
            long j = this.zE;
            if (!(j == 0 || j == -9223372036854775807L)) {
                return j / ((long) f);
            }
        }
        return Long.MAX_VALUE;
    }

    public void a(long[] jArr, boolean[] zArr, int i) {
        a.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.NK = i;
        this.WJ = jArr;
        this.WK = zArr;
        nr();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.WG && !z) {
            an(true);
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r3 != 3) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0076
            long r2 = r7.zE
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0010
            goto L_0x0076
        L_0x0010:
            android.graphics.Point r0 = r7.a((android.view.MotionEvent) r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x005d
            r5 = 3
            if (r3 == r4) goto L_0x004e
            r6 = 2
            if (r3 == r6) goto L_0x0028
            if (r3 == r5) goto L_0x004e
            goto L_0x0076
        L_0x0028:
            boolean r8 = r7.WG
            if (r8 == 0) goto L_0x0076
            int r8 = r7.Wt
            if (r0 >= r8) goto L_0x003a
            int r8 = r7.WB
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.w(r8)
            goto L_0x0040
        L_0x003a:
            r7.WB = r2
            float r8 = (float) r2
            r7.w(r8)
        L_0x0040:
            long r0 = r7.getScrubberPosition()
            r7.bj(r0)
            r7.nr()
            r7.invalidate()
            return r4
        L_0x004e:
            boolean r0 = r7.WG
            if (r0 == 0) goto L_0x0076
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0059
            r1 = 1
        L_0x0059:
            r7.an(r1)
            return r4
        L_0x005d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.b(r8, r0)
            if (r0 == 0) goto L_0x0076
            r7.w(r8)
            long r0 = r7.getScrubberPosition()
            r7.bi(r0)
            r7.nr()
            r7.invalidate()
            return r4
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.d.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (bk(r0) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        removeCallbacks(r4.Ww);
        postDelayed(r4.Ww, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0030
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0030
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.bk(r0)
            if (r0 == 0) goto L_0x0030
            java.lang.Runnable r5 = r4.Ww
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.Ww
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.WG
            if (r0 == 0) goto L_0x0030
            r5 = 0
            r4.an(r5)
            return r3
        L_0x0030:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.d.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.WG && !z) {
            an(false);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ns();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.Wk;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.Wm;
        } else if (mode != 1073741824) {
            size = Math.min(this.Wm, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        ns();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i7 - getPaddingRight();
        int i9 = this.WF ? 0 : this.Ws;
        if (this.Wn == 1) {
            i6 = (i8 - getPaddingBottom()) - this.Wm;
            int i10 = this.Wl;
            i5 = ((i8 - getPaddingBottom()) - i10) - Math.max(i9 - (i10 / 2), 0);
        } else {
            i6 = (i8 - this.Wm) / 2;
            i5 = (i8 - this.Wl) / 2;
        }
        this.Wa.set(paddingLeft, i6, paddingRight, this.Wm + i6);
        this.Wb.set(this.Wa.left + i9, i5, this.Wa.right - i9, this.Wl + i5);
        if (ai.acV >= 29) {
            H(i7, i8);
        }
        nr();
    }

    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.Wk;
        if (drawable != null && a(drawable, i)) {
            invalidate();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.zE > 0) {
            if (ai.acV >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.zE <= 0) {
            return false;
        }
        if (i == 8192) {
            if (bk(-getPositionIncrement())) {
                an(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (bk(getPositionIncrement())) {
                an(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    private void bi(long j) {
        this.WH = j;
        this.WG = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<k.a> it = this.hv.iterator();
        while (it.hasNext()) {
            it.next().a(this, j);
        }
    }

    private void bj(long j) {
        if (this.WH != j) {
            this.WH = j;
            Iterator<k.a> it = this.hv.iterator();
            while (it.hasNext()) {
                it.next().b(this, j);
            }
        }
    }

    private void an(boolean z) {
        removeCallbacks(this.Ww);
        this.WG = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<k.a> it = this.hv.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.WH, z);
        }
    }

    private boolean bk(long j) {
        long j2 = this.zE;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.WG ? this.WH : this.uc;
        long b = ai.b(j3 + j, 0, j2);
        if (b == j3) {
            return false;
        }
        if (!this.WG) {
            bi(b);
        } else {
            bj(b);
        }
        nr();
        return true;
    }

    private void nr() {
        this.Wc.set(this.Wb);
        this.Wd.set(this.Wb);
        long j = this.WG ? this.WH : this.uc;
        if (this.zE > 0) {
            this.Wc.right = Math.min(this.Wb.left + ((int) ((((long) this.Wb.width()) * this.WI) / this.zE)), this.Wb.right);
            this.Wd.right = Math.min(this.Wb.left + ((int) ((((long) this.Wb.width()) * j) / this.zE)), this.Wb.right);
        } else {
            this.Wc.right = this.Wb.left;
            this.Wd.right = this.Wb.left;
        }
        invalidate(this.Wa);
    }

    private void w(float f) {
        this.Wd.right = ai.k((int) f, this.Wb.left, this.Wb.right);
    }

    private Point a(MotionEvent motionEvent) {
        this.Wx.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.Wx;
    }

    private long getScrubberPosition() {
        if (this.Wb.width() <= 0 || this.zE == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.Wd.width()) * this.zE) / ((long) this.Wb.width());
    }

    private boolean b(float f, float f2) {
        return this.Wa.contains((int) f, (int) f2);
    }

    private void a(Canvas canvas) {
        int height = this.Wb.height();
        int centerY = this.Wb.centerY() - (height / 2);
        int i = height + centerY;
        if (this.zE <= 0) {
            canvas.drawRect((float) this.Wb.left, (float) centerY, (float) this.Wb.right, (float) i, this.Wg);
            return;
        }
        int i2 = this.Wc.left;
        int i3 = this.Wc.right;
        int max = Math.max(Math.max(this.Wb.left, i3), this.Wd.right);
        if (max < this.Wb.right) {
            canvas.drawRect((float) max, (float) centerY, (float) this.Wb.right, (float) i, this.Wg);
        }
        int max2 = Math.max(i2, this.Wd.right);
        if (i3 > max2) {
            canvas.drawRect((float) max2, (float) centerY, (float) i3, (float) i, this.Wf);
        }
        if (this.Wd.width() > 0) {
            canvas.drawRect((float) this.Wd.left, (float) centerY, (float) this.Wd.right, (float) i, this.We);
        }
        if (this.NK != 0) {
            long[] jArr = (long[]) a.checkNotNull(this.WJ);
            boolean[] zArr = (boolean[]) a.checkNotNull(this.WK);
            int i4 = this.Wo / 2;
            for (int i5 = 0; i5 < this.NK; i5++) {
                int min = this.Wb.left + Math.min(this.Wb.width() - this.Wo, Math.max(0, ((int) ((((long) this.Wb.width()) * ai.b(jArr[i5], 0, this.zE)) / this.zE)) - i4));
                canvas.drawRect((float) min, (float) centerY, (float) (min + this.Wo), (float) i, zArr[i5] ? this.Wi : this.Wh);
            }
        }
    }

    private void b(Canvas canvas) {
        if (this.zE > 0) {
            int k = ai.k(this.Wd.right, this.Wd.left, this.Wb.right);
            int centerY = this.Wd.centerY();
            Drawable drawable = this.Wk;
            if (drawable == null) {
                canvas.drawCircle((float) k, (float) centerY, (float) ((int) ((((float) ((this.WG || isFocused()) ? this.Wr : isEnabled() ? this.Wp : this.Wq)) * this.WE) / 2.0f)), this.Wj);
                return;
            }
            int intrinsicWidth = ((int) (((float) drawable.getIntrinsicWidth()) * this.WE)) / 2;
            int intrinsicHeight = ((int) (((float) this.Wk.getIntrinsicHeight()) * this.WE)) / 2;
            this.Wk.setBounds(k - intrinsicWidth, centerY - intrinsicHeight, k + intrinsicWidth, centerY + intrinsicHeight);
            this.Wk.draw(canvas);
        }
    }

    private void ns() {
        Drawable drawable = this.Wk;
        if (drawable != null && drawable.isStateful() && this.Wk.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void H(int i, int i2) {
        Rect rect = this.WC;
        if (rect == null || rect.width() != i || this.WC.height() != i2) {
            Rect rect2 = new Rect(0, 0, i, i2);
            this.WC = rect2;
            setSystemGestureExclusionRects(Collections.singletonList(rect2));
        }
    }

    private String getProgressText() {
        return ai.a(this.Wu, this.Wv, this.uc);
    }

    private long getPositionIncrement() {
        long j = this.WA;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.zE;
        if (j2 == -9223372036854775807L) {
            return 0;
        }
        return j2 / ((long) this.Wz);
    }

    private boolean a(Drawable drawable) {
        return ai.acV >= 23 && a(drawable, getLayoutDirection());
    }

    private static boolean a(Drawable drawable, int i) {
        return ai.acV >= 23 && drawable.setLayoutDirection(i);
    }
}
