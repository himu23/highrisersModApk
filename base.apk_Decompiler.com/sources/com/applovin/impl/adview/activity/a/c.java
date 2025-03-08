package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.v;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;

public class c extends a {
    /* access modifiers changed from: private */
    public static /* synthetic */ boolean c(View view, MotionEvent motionEvent) {
        return true;
    }

    public /* bridge */ /* synthetic */ void a(n nVar) {
        super.a(nVar);
    }

    public /* bridge */ /* synthetic */ void k(View view) {
        super.k(view);
    }

    public c(e eVar, Activity activity, com.applovin.impl.sdk.n nVar) {
        super(eVar, activity, nVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0272  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.widget.ImageView r17, com.applovin.impl.adview.n r18, com.applovin.impl.adview.w r19, com.applovin.impl.adview.a r20, android.widget.ProgressBar r21, com.applovin.impl.adview.h r22, android.view.View r23, com.applovin.adview.AppLovinAdView r24, com.applovin.impl.adview.v r25, android.widget.ImageView r26, android.view.ViewGroup r27) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            com.applovin.impl.sdk.ad.e r12 = r0.aiL
            com.applovin.impl.sdk.ad.e$d r12 = r12.HA()
            com.applovin.impl.sdk.ad.e$d r13 = com.applovin.impl.sdk.ad.e.d.TOP
            r15 = 48
            r14 = -1
            if (r12 != r13) goto L_0x002d
            android.widget.FrameLayout$LayoutParams r12 = new android.widget.FrameLayout$LayoutParams
            r13 = -2
            r12.<init>(r14, r13, r15)
        L_0x002b:
            r15 = 5
            goto L_0x0066
        L_0x002d:
            r13 = -2
            com.applovin.impl.sdk.ad.e r12 = r0.aiL
            com.applovin.impl.sdk.ad.e$d r12 = r12.HA()
            com.applovin.impl.sdk.ad.e$d r15 = com.applovin.impl.sdk.ad.e.d.BOTTOM
            if (r12 != r15) goto L_0x0040
            android.widget.FrameLayout$LayoutParams r12 = new android.widget.FrameLayout$LayoutParams
            r15 = 80
            r12.<init>(r14, r13, r15)
            goto L_0x002b
        L_0x0040:
            com.applovin.impl.sdk.ad.e r12 = r0.aiL
            com.applovin.impl.sdk.ad.e$d r12 = r12.HA()
            com.applovin.impl.sdk.ad.e$d r15 = com.applovin.impl.sdk.ad.e.d.LEFT
            if (r12 != r15) goto L_0x0051
            android.widget.FrameLayout$LayoutParams r12 = new android.widget.FrameLayout$LayoutParams
            r15 = 3
            r12.<init>(r13, r14, r15)
            goto L_0x002b
        L_0x0051:
            r15 = 3
            com.applovin.impl.sdk.ad.e r12 = r0.aiL
            com.applovin.impl.sdk.ad.e$d r12 = r12.HA()
            com.applovin.impl.sdk.ad.e$d r15 = com.applovin.impl.sdk.ad.e.d.RIGHT
            if (r12 != r15) goto L_0x0063
            android.widget.FrameLayout$LayoutParams r12 = new android.widget.FrameLayout$LayoutParams
            r15 = 5
            r12.<init>(r13, r14, r15)
            goto L_0x0066
        L_0x0063:
            r15 = 5
            android.widget.FrameLayout$LayoutParams r12 = r0.aiN
        L_0x0066:
            android.widget.FrameLayout$LayoutParams r13 = r0.aiN
            r8.setLayoutParams(r13)
            android.view.ViewGroup r13 = r0.aiM
            r13.addView(r8)
            android.view.View r8 = new android.view.View
            android.app.Activity r13 = r0.ahM
            r8.<init>(r13)
            android.widget.FrameLayout$LayoutParams r13 = r0.aiN
            r8.setLayoutParams(r13)
            r13 = 254(0xfe, float:3.56E-43)
            r15 = 0
            int r13 = android.graphics.Color.argb(r13, r15, r15, r15)
            r8.setBackgroundColor(r13)
            com.applovin.impl.adview.activity.a.c$$ExternalSyntheticLambda0 r13 = new com.applovin.impl.adview.activity.a.c$$ExternalSyntheticLambda0
            r13.<init>()
            r8.setOnTouchListener(r13)
            android.view.ViewGroup r13 = r0.aiM
            r13.addView(r8)
            r7.setLayoutParams(r12)
            android.view.ViewGroup r8 = r0.aiM
            r8.addView(r7)
            if (r3 == 0) goto L_0x0140
            com.applovin.impl.sdk.ad.e r7 = r0.aiL
            com.applovin.impl.adview.u r7 = r7.Gp()
            android.widget.LinearLayout r8 = new android.widget.LinearLayout
            android.app.Activity r12 = r0.ahM
            r8.<init>(r12)
            r12 = 1
            r8.setOrientation(r12)
            r12 = 1120403456(0x42c80000, float:100.0)
            r8.setWeightSum(r12)
            int r13 = r7.rZ()
            r8.setGravity(r13)
            android.widget.FrameLayout$LayoutParams r13 = new android.widget.FrameLayout$LayoutParams
            r13.<init>(r14, r14)
            android.widget.LinearLayout r14 = new android.widget.LinearLayout
            android.app.Activity r12 = r0.ahM
            r14.<init>(r12)
            r14.setOrientation(r15)
            r12 = 1120403456(0x42c80000, float:100.0)
            r14.setWeightSum(r12)
            int r12 = r7.rZ()
            r14.setGravity(r12)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            int r11 = r7.rX()
            float r11 = (float) r11
            r9 = -2
            r12.<init>(r9, r15, r11)
            android.widget.LinearLayout$LayoutParams r9 = new android.widget.LinearLayout$LayoutParams
            int r11 = r7.rW()
            float r11 = (float) r11
            r10 = -1
            r9.<init>(r15, r10, r11)
            android.app.Activity r10 = r0.ahM
            int r11 = r7.rY()
            int r10 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r10, r11)
            r9.setMargins(r10, r10, r10, r10)
            r14.addView(r3, r9)
            r8.addView(r14, r12)
            android.view.ViewGroup r9 = r0.aiM
            r9.addView(r8, r13)
            float r8 = r7.se()
            r9 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 <= 0) goto L_0x0124
            r8 = 4
            r3.setVisibility(r8)
            float r8 = r7.se()
            long r10 = com.applovin.impl.sdk.utils.u.C(r8)
            long r12 = r7.sc()
            com.applovin.impl.adview.activity.a.c$$ExternalSyntheticLambda1 r8 = new com.applovin.impl.adview.activity.a.c$$ExternalSyntheticLambda1
            r8.<init>(r3, r12)
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThreadDelayed(r8, r10)
        L_0x0124:
            float r8 = r7.sf()
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 <= 0) goto L_0x0140
            float r8 = r7.sf()
            long r8 = com.applovin.impl.sdk.utils.u.C(r8)
            long r10 = r7.sd()
            com.applovin.impl.adview.activity.a.c$$ExternalSyntheticLambda2 r7 = new com.applovin.impl.adview.activity.a.c$$ExternalSyntheticLambda2
            r7.<init>(r3, r10)
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThreadDelayed(r7, r8)
        L_0x0140:
            if (r2 == 0) goto L_0x015b
            com.applovin.impl.sdk.ad.e r3 = r0.aiL
            boolean r3 = r3.GS()
            if (r3 == 0) goto L_0x014e
            r3 = 48
            r14 = 3
            goto L_0x0151
        L_0x014e:
            r3 = 48
            r14 = 5
        L_0x0151:
            r3 = r3 | r14
            com.applovin.impl.sdk.ad.e r7 = r0.aiL
            com.applovin.impl.sdk.ad.e$c r7 = r7.GN()
            r0.a(r7, r3, r2)
        L_0x015b:
            if (r1 == 0) goto L_0x01a0
            android.app.Activity r2 = r0.ahM
            com.applovin.impl.sdk.n r3 = r0.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r7 = com.applovin.impl.sdk.c.b.aNj
            java.lang.Object r3 = r3.a(r7)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            int r2 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r2, r3)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            com.applovin.impl.sdk.n r7 = r0.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r8 = com.applovin.impl.sdk.c.b.aNl
            java.lang.Object r7 = r7.a(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r3.<init>(r2, r2, r7)
            android.app.Activity r2 = r0.ahM
            com.applovin.impl.sdk.n r7 = r0.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r8 = com.applovin.impl.sdk.c.b.aNk
            java.lang.Object r7 = r7.a(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            int r2 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r2, r7)
            r3.setMargins(r2, r2, r2, r2)
            android.view.ViewGroup r2 = r0.aiM
            r2.addView(r1, r3)
        L_0x01a0:
            if (r4 == 0) goto L_0x01a9
            android.view.ViewGroup r1 = r0.aiM
            android.widget.FrameLayout$LayoutParams r2 = r0.aiN
            r1.addView(r4, r2)
        L_0x01a9:
            if (r6 == 0) goto L_0x01ee
            android.app.Activity r1 = r0.ahM
            com.applovin.impl.sdk.n r2 = r0.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.c.b.aMW
            java.lang.Object r2 = r2.a(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r1 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r1, r2)
            com.applovin.impl.sdk.n r2 = r0.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.c.b.aMV
            java.lang.Object r2 = r2.a(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r3.<init>(r1, r1, r2)
            android.app.Activity r1 = r0.ahM
            com.applovin.impl.sdk.n r2 = r0.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r4 = com.applovin.impl.sdk.c.b.aMU
            java.lang.Object r2 = r2.a(r4)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r1 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r1, r2)
            r3.setMargins(r1, r1, r1, r1)
            android.view.ViewGroup r1 = r0.aiM
            r1.addView(r6, r3)
        L_0x01ee:
            if (r5 == 0) goto L_0x0210
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r2 = 20
            r3 = 80
            r4 = -1
            r1.<init>(r4, r2, r3)
            com.applovin.impl.sdk.n r2 = r0.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.c.b.aNo
            java.lang.Object r2 = r2.a(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r1.setMargins(r15, r15, r15, r2)
            android.view.ViewGroup r2 = r0.aiM
            r2.addView(r5, r1)
        L_0x0210:
            r1 = r26
            if (r1 == 0) goto L_0x025d
            com.applovin.impl.sdk.ad.e r2 = r0.aiL
            com.applovin.impl.b.a r2 = (com.applovin.impl.b.a) r2
            boolean r3 = r2.LZ()
            if (r3 == 0) goto L_0x025d
            android.app.Activity r3 = r0.ahM
            com.applovin.impl.b.g r4 = r2.LY()
            int r4 = r4.getWidth()
            int r3 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r3, r4)
            android.app.Activity r4 = r0.ahM
            com.applovin.impl.b.g r2 = r2.LY()
            int r2 = r2.getHeight()
            int r2 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r4, r2)
            android.app.Activity r4 = r0.ahM
            com.applovin.impl.sdk.n r5 = r0.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r6 = com.applovin.impl.sdk.c.b.aPA
            java.lang.Object r5 = r5.a(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r4 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r4, r5)
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r6 = 83
            r5.<init>(r3, r2, r6)
            r5.setMargins(r4, r4, r4, r4)
            android.view.ViewGroup r2 = r0.aiM
            r2.addView(r1, r5)
        L_0x025d:
            r1 = r25
            if (r1 == 0) goto L_0x0268
            android.view.ViewGroup r2 = r0.aiM
            android.widget.FrameLayout$LayoutParams r3 = r0.aiN
            r2.addView(r1, r3)
        L_0x0268:
            r1 = r27
            if (r1 == 0) goto L_0x0272
            android.view.ViewGroup r2 = r0.aiM
            r1.addView(r2)
            goto L_0x0279
        L_0x0272:
            android.app.Activity r1 = r0.ahM
            android.view.ViewGroup r2 = r0.aiM
            r1.setContentView(r2)
        L_0x0279:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.a.c.a(android.widget.ImageView, com.applovin.impl.adview.n, com.applovin.impl.adview.w, com.applovin.impl.adview.a, android.widget.ProgressBar, com.applovin.impl.adview.h, android.view.View, com.applovin.adview.AppLovinAdView, com.applovin.impl.adview.v, android.widget.ImageView, android.view.ViewGroup):void");
    }

    public void a(n nVar, v vVar, View view, ProgressBar progressBar) {
        if (view != null) {
            view.setVisibility(0);
        }
        com.applovin.impl.sdk.utils.c.a(this.aiM, view);
        int i = 48;
        if (nVar != null) {
            a(this.aiL.GN(), (this.aiL.GR() ? 3 : 5) | 48, nVar);
        }
        if (progressBar != null) {
            if (((Boolean) this.sdk.a(b.aNw)).booleanValue()) {
                i = 80;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 20, i);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.sdk.a(b.aNx)).intValue());
            this.aiM.addView(progressBar, layoutParams);
        }
        if (vVar != null) {
            this.aiM.addView(vVar, this.aiN);
        }
    }
}
