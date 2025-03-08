package com.applovin.impl.sdk.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class v {
    public static boolean gZ(int i) {
        return i == 0;
    }

    public static void a(View view, long j) {
        a(view, j, (Runnable) null);
    }

    public static void a(final View view, long j, final Runnable runnable) {
        view.setVisibility(4);
        view.bringToFront();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }

            public void onAnimationEnd(Animation animation) {
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static void b(final View view, long j, final Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }

            public void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static boolean T(int i, int i2) {
        return gZ(i) != gZ(i2);
    }

    public static String ha(int i) {
        if (i == 0) {
            return "VISIBLE";
        }
        if (i == 4) {
            return "INVISIBLE";
        }
        return i == 8 ? "GONE" : String.valueOf(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if ((r3 & 16) == 16) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0074, code lost:
        if ((r3 & 1) == 1) goto L_0x003f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] m(int r3, int r4, int r5) {
        /*
            if (r3 != 0) goto L_0x0007
            int[] r3 = new int[]{r4, r5}
            return r3
        L_0x0007:
            r0 = r3 & 119(0x77, float:1.67E-43)
            r1 = 119(0x77, float:1.67E-43)
            if (r0 != r1) goto L_0x0014
            r3 = 13
            int[] r3 = new int[]{r3}
            return r3
        L_0x0014:
            r0 = r3 & 112(0x70, float:1.57E-43)
            r1 = 15
            r2 = 112(0x70, float:1.57E-43)
            if (r0 != r2) goto L_0x001f
        L_0x001c:
            r4 = 15
            goto L_0x0038
        L_0x001f:
            r0 = r3 & 48
            r2 = 48
            if (r0 != r2) goto L_0x0028
            r4 = 10
            goto L_0x0038
        L_0x0028:
            r0 = r3 & 80
            r2 = 80
            if (r0 != r2) goto L_0x0031
            r4 = 12
            goto L_0x0038
        L_0x0031:
            r0 = r3 & 16
            r2 = 16
            if (r0 != r2) goto L_0x0038
            goto L_0x001c
        L_0x0038:
            r0 = r3 & 7
            r1 = 14
            r2 = 7
            if (r0 != r2) goto L_0x0042
        L_0x003f:
            r5 = 14
            goto L_0x0077
        L_0x0042:
            boolean r0 = com.applovin.impl.sdk.utils.h.KV()
            if (r0 == 0) goto L_0x0052
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r2 = r3 & r0
            if (r2 != r0) goto L_0x0052
            r5 = 20
            goto L_0x0077
        L_0x0052:
            r0 = r3 & 3
            r2 = 3
            if (r0 != r2) goto L_0x005a
            r5 = 9
            goto L_0x0077
        L_0x005a:
            boolean r0 = com.applovin.impl.sdk.utils.h.KV()
            if (r0 == 0) goto L_0x006a
            r0 = 8388613(0x800005, float:1.175495E-38)
            r2 = r3 & r0
            if (r2 != r0) goto L_0x006a
            r5 = 21
            goto L_0x0077
        L_0x006a:
            r0 = r3 & 5
            r2 = 5
            if (r0 != r2) goto L_0x0072
            r5 = 11
            goto L_0x0077
        L_0x0072:
            r0 = 1
            r3 = r3 & r0
            if (r3 != r0) goto L_0x0077
            goto L_0x003f
        L_0x0077:
            int[] r3 = new int[]{r5, r4}
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.v.m(int, int, int):int[]");
    }

    public static void B(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
