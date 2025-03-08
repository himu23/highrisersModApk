package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.impl.sdk.utils.h;

public class AppLovinTouchToClickListener implements View.OnTouchListener {
    private final Context E;
    private final long agS;
    private final int agT;
    private final int agU;
    private final ClickRecognitionState agV;
    private long agW;
    private PointF agX;
    private boolean agY;
    private final OnClickListener agZ;

    public enum ClickRecognitionState {
        DISABLED,
        ACTION_DOWN,
        ACTION_POINTER_UP,
        ACTION_UP
    }

    public interface OnClickListener {
        void onClick(View view, MotionEvent motionEvent);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.applovin.impl.sdk.c.b, com.applovin.impl.sdk.c.b<java.lang.Integer>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppLovinTouchToClickListener(com.applovin.impl.sdk.n r3, com.applovin.impl.sdk.c.b<java.lang.Integer> r4, android.content.Context r5, com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener r6) {
        /*
            r2 = this;
            r2.<init>()
            com.applovin.impl.sdk.c.b<java.lang.Long> r0 = com.applovin.impl.sdk.c.b.aLk
            java.lang.Object r0 = r3.a(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2.agS = r0
            com.applovin.impl.sdk.c.b<java.lang.Integer> r0 = com.applovin.impl.sdk.c.b.aLl
            java.lang.Object r0 = r3.a(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r2.agT = r0
            com.applovin.impl.sdk.c.b<java.lang.Integer> r0 = com.applovin.impl.sdk.c.b.aLq
            java.lang.Object r0 = r3.a(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r5, r0)
            r2.agU = r0
            java.lang.Object r3 = r3.a(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState[] r4 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.values()
            r3 = r4[r3]
            r2.agV = r3
            r2.E = r5
            r2.agZ = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AppLovinTouchToClickListener.<init>(com.applovin.impl.sdk.n, com.applovin.impl.sdk.c.b, android.content.Context, com.applovin.impl.adview.AppLovinTouchToClickListener$OnClickListener):void");
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 6 && !this.agY && this.agV == ClickRecognitionState.ACTION_POINTER_UP) {
                    b(view, motionEvent);
                }
            } else if (!this.agY && this.agV == ClickRecognitionState.ACTION_UP) {
                b(view, motionEvent);
            } else if (this.agV == ClickRecognitionState.DISABLED) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.agW;
                float a = a(this.agX, new PointF(motionEvent.getX(), motionEvent.getY()));
                if (!this.agY) {
                    long j = this.agS;
                    if ((j < 0 || elapsedRealtime < j) && ((i = this.agT) < 0 || a < ((float) i))) {
                        b(view, motionEvent);
                    }
                }
            }
        } else if (this.agV != ClickRecognitionState.ACTION_DOWN) {
            this.agW = SystemClock.elapsedRealtime();
            this.agX = new PointF(motionEvent.getX(), motionEvent.getY());
            this.agY = false;
        } else if (d(motionEvent)) {
            b(view, motionEvent);
        }
        return true;
    }

    private void b(View view, MotionEvent motionEvent) {
        this.agZ.onClick(view, motionEvent);
        this.agY = true;
    }

    private float a(PointF pointF, PointF pointF2) {
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return z((float) Math.sqrt((double) ((f * f) + (f2 * f2))));
    }

    private float z(float f) {
        return f / this.E.getResources().getDisplayMetrics().density;
    }

    private boolean d(MotionEvent motionEvent) {
        if (this.agU <= 0) {
            return true;
        }
        Point Y = h.Y(this.E);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i = this.agU;
        if (rawX < ((float) i) || rawY < ((float) i) || rawX > ((float) (Y.x - this.agU)) || rawY > ((float) (Y.y - this.agU))) {
            return false;
        }
        return true;
    }
}
