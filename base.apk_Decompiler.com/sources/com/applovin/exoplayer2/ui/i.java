package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.l.ai;

final class i {
    private int Oi;
    private int Qa;
    private int Qc;
    private float VV;
    private int VX;
    private int VY;
    private CharSequence YA;
    private Layout.Alignment YB;
    private Bitmap YC;
    private float YD;
    private int YE;
    private int YF;
    private float YG;
    private int YH;
    private float YI;
    private float YJ;
    private float YK;
    private float YL;
    private int YM;
    private int YN;
    private int YO;
    private int YP;
    private StaticLayout YQ;
    private StaticLayout YR;
    private int YS;
    private int YT;
    private int YU;
    private Rect YV;
    private final float Ys;
    private final float Yt;
    private final float Yu;
    private final float Yv;
    private final float Yw;
    private final TextPaint Yx;
    private final Paint Yy;
    private final Paint Yz;

    public i(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{16843287, 16843288}, 0, 0);
        this.Yw = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.Yv = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.Ys = round;
        this.Yt = round;
        this.Yu = round;
        TextPaint textPaint = new TextPaint();
        this.Yx = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.Yy = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.Yz = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public void a(a aVar, c cVar, float f, float f2, float f3, Canvas canvas, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = aVar.NZ == null;
        if (!z) {
            i5 = ViewCompat.MEASURED_STATE_MASK;
        } else if (!TextUtils.isEmpty(aVar.NW)) {
            i5 = aVar.Oh ? aVar.Oi : cVar.Oi;
        } else {
            return;
        }
        if (a(this.YA, aVar.NW) && ai.r(this.YB, aVar.NX) && this.YC == aVar.NZ && this.YD == aVar.Oa && this.YE == aVar.Ob && ai.r(Integer.valueOf(this.YF), Integer.valueOf(aVar.Oc)) && this.YG == aVar.Od && ai.r(Integer.valueOf(this.YH), Integer.valueOf(aVar.Oe)) && this.YI == aVar.Of && this.YJ == aVar.Og && this.Qa == cVar.Qa && this.Qc == cVar.Qc && this.Oi == i5 && this.VX == cVar.VX && this.VY == cVar.VY && ai.r(this.Yx.getTypeface(), cVar.VZ) && this.YK == f && this.YL == f2 && this.VV == f3 && this.YM == i && this.YN == i2 && this.YO == i3 && this.YP == i4) {
            a(canvas, z);
            return;
        }
        this.YA = aVar.NW;
        this.YB = aVar.NX;
        this.YC = aVar.NZ;
        this.YD = aVar.Oa;
        this.YE = aVar.Ob;
        this.YF = aVar.Oc;
        this.YG = aVar.Od;
        this.YH = aVar.Oe;
        this.YI = aVar.Of;
        this.YJ = aVar.Og;
        this.Qa = cVar.Qa;
        this.Qc = cVar.Qc;
        this.Oi = i5;
        this.VX = cVar.VX;
        this.VY = cVar.VY;
        this.Yx.setTypeface(cVar.VZ);
        this.YK = f;
        this.YL = f2;
        this.VV = f3;
        this.YM = i;
        this.YN = i2;
        this.YO = i3;
        this.YP = i4;
        if (z) {
            com.applovin.exoplayer2.l.a.checkNotNull(this.YA);
            nU();
        } else {
            com.applovin.exoplayer2.l.a.checkNotNull(this.YC);
            nV();
        }
        a(canvas, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void nU() {
        /*
            r26 = this;
            r0 = r26
            java.lang.CharSequence r1 = r0.YA
            boolean r2 = r1 instanceof android.text.SpannableStringBuilder
            if (r2 == 0) goto L_0x000b
            android.text.SpannableStringBuilder r1 = (android.text.SpannableStringBuilder) r1
            goto L_0x0012
        L_0x000b:
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
            java.lang.CharSequence r2 = r0.YA
            r1.<init>(r2)
        L_0x0012:
            int r2 = r0.YO
            int r3 = r0.YM
            int r2 = r2 - r3
            int r3 = r0.YP
            int r4 = r0.YN
            int r11 = r3 - r4
            android.text.TextPaint r3 = r0.Yx
            float r4 = r0.YK
            r3.setTextSize(r4)
            float r3 = r0.YK
            r4 = 1040187392(0x3e000000, float:0.125)
            float r3 = r3 * r4
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r12 = (int) r3
            int r13 = r12 * 2
            int r3 = r2 - r13
            float r4 = r0.YI
            r14 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r5 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x003f
            float r3 = (float) r3
            float r3 = r3 * r4
            int r3 = (int) r3
        L_0x003f:
            r15 = r3
            java.lang.String r10 = "SubtitlePainter"
            if (r15 > 0) goto L_0x004a
            java.lang.String r1 = "Skipped drawing subtitle cue (insufficient space)"
            com.applovin.exoplayer2.l.q.h(r10, r1)
            return
        L_0x004a:
            float r3 = r0.YL
            r16 = 0
            r4 = 16711680(0xff0000, float:2.3418052E-38)
            r9 = 0
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 <= 0) goto L_0x0064
            android.text.style.AbsoluteSizeSpan r3 = new android.text.style.AbsoluteSizeSpan
            float r5 = r0.YL
            int r5 = (int) r5
            r3.<init>(r5)
            int r5 = r1.length()
            r1.setSpan(r3, r9, r5, r4)
        L_0x0064:
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r1)
            int r3 = r0.VX
            r7 = 1
            if (r3 != r7) goto L_0x0087
            int r3 = r8.length()
            java.lang.Class<android.text.style.ForegroundColorSpan> r5 = android.text.style.ForegroundColorSpan.class
            java.lang.Object[] r3 = r8.getSpans(r9, r3, r5)
            android.text.style.ForegroundColorSpan[] r3 = (android.text.style.ForegroundColorSpan[]) r3
            int r5 = r3.length
            r6 = 0
        L_0x007c:
            if (r6 >= r5) goto L_0x0087
            r7 = r3[r6]
            r8.removeSpan(r7)
            int r6 = r6 + 1
            r7 = 1
            goto L_0x007c
        L_0x0087:
            int r3 = r0.Qc
            int r3 = android.graphics.Color.alpha(r3)
            r7 = 2
            if (r3 <= 0) goto L_0x00b4
            int r3 = r0.VX
            if (r3 == 0) goto L_0x00a6
            if (r3 != r7) goto L_0x0097
            goto L_0x00a6
        L_0x0097:
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r5 = r0.Qc
            r3.<init>(r5)
            int r5 = r8.length()
            r8.setSpan(r3, r9, r5, r4)
            goto L_0x00b4
        L_0x00a6:
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r5 = r0.Qc
            r3.<init>(r5)
            int r5 = r1.length()
            r1.setSpan(r3, r9, r5, r4)
        L_0x00b4:
            android.text.Layout$Alignment r3 = r0.YB
            if (r3 != 0) goto L_0x00ba
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_CENTER
        L_0x00ba:
            r21 = r3
            android.text.StaticLayout r6 = new android.text.StaticLayout
            android.text.TextPaint r5 = r0.Yx
            float r4 = r0.Yv
            float r3 = r0.Yw
            r18 = 1
            r19 = r3
            r3 = r6
            r20 = r4
            r4 = r1
            r14 = r6
            r6 = r15
            r7 = r21
            r23 = r8
            r8 = r20
            r25 = r12
            r12 = 0
            r9 = r19
            r12 = r10
            r10 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0.YQ = r14
            int r3 = r14.getHeight()
            android.text.StaticLayout r4 = r0.YQ
            int r4 = r4.getLineCount()
            r5 = 0
            r9 = 0
        L_0x00ed:
            if (r9 >= r4) goto L_0x0102
            android.text.StaticLayout r6 = r0.YQ
            float r6 = r6.getLineWidth(r9)
            double r6 = (double) r6
            double r6 = java.lang.Math.ceil(r6)
            int r6 = (int) r6
            int r5 = java.lang.Math.max(r6, r5)
            int r9 = r9 + 1
            goto L_0x00ed
        L_0x0102:
            float r4 = r0.YI
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x010e
            if (r5 >= r15) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r15 = r5
        L_0x010f:
            int r15 = r15 + r13
            float r4 = r0.YG
            int r5 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x013c
            float r2 = (float) r2
            float r2 = r2 * r4
            int r2 = java.lang.Math.round(r2)
            int r4 = r0.YM
            int r2 = r2 + r4
            int r5 = r0.YH
            r6 = 1
            if (r5 == r6) goto L_0x012b
            r7 = 2
            if (r5 == r7) goto L_0x0129
            goto L_0x0130
        L_0x0129:
            int r2 = r2 - r15
            goto L_0x0130
        L_0x012b:
            r7 = 2
            int r2 = r2 * 2
            int r2 = r2 - r15
            int r2 = r2 / r7
        L_0x0130:
            int r2 = java.lang.Math.max(r2, r4)
            int r15 = r15 + r2
            int r4 = r0.YO
            int r4 = java.lang.Math.min(r15, r4)
            goto L_0x0145
        L_0x013c:
            r6 = 1
            r7 = 2
            int r2 = r2 - r15
            int r2 = r2 / r7
            int r4 = r0.YM
            int r2 = r2 + r4
            int r4 = r2 + r15
        L_0x0145:
            int r20 = r4 - r2
            if (r20 > 0) goto L_0x014f
            java.lang.String r1 = "Skipped drawing subtitle cue (invalid horizontal positioning)"
            com.applovin.exoplayer2.l.q.h(r12, r1)
            return
        L_0x014f:
            float r4 = r0.YD
            r5 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x01ae
            int r5 = r0.YE
            if (r5 != 0) goto L_0x0172
            float r5 = (float) r11
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.YN
            int r4 = r4 + r5
            int r5 = r0.YF
            if (r5 != r7) goto L_0x016b
            goto L_0x019e
        L_0x016b:
            if (r5 != r6) goto L_0x019f
            int r4 = r4 * 2
            int r4 = r4 - r3
            int r4 = r4 / r7
            goto L_0x019f
        L_0x0172:
            android.text.StaticLayout r4 = r0.YQ
            r5 = 0
            int r4 = r4.getLineBottom(r5)
            android.text.StaticLayout r6 = r0.YQ
            int r5 = r6.getLineTop(r5)
            int r4 = r4 - r5
            float r5 = r0.YD
            int r6 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r6 < 0) goto L_0x0191
            float r4 = (float) r4
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.YN
            int r4 = r4 + r5
            goto L_0x019f
        L_0x0191:
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r5 + r6
            float r4 = (float) r4
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.YP
            int r4 = r4 + r5
        L_0x019e:
            int r4 = r4 - r3
        L_0x019f:
            int r5 = r4 + r3
            int r6 = r0.YP
            if (r5 <= r6) goto L_0x01a8
            int r4 = r6 - r3
            goto L_0x01b8
        L_0x01a8:
            int r3 = r0.YN
            if (r4 >= r3) goto L_0x01b8
            r11 = r3
            goto L_0x01b9
        L_0x01ae:
            int r4 = r0.YP
            int r4 = r4 - r3
            float r3 = (float) r11
            float r5 = r0.VV
            float r3 = r3 * r5
            int r3 = (int) r3
            int r4 = r4 - r3
        L_0x01b8:
            r11 = r4
        L_0x01b9:
            android.text.StaticLayout r12 = new android.text.StaticLayout
            android.text.TextPaint r5 = r0.Yx
            float r8 = r0.Yv
            float r9 = r0.Yw
            r10 = 1
            r3 = r12
            r4 = r1
            r6 = r20
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0.YQ = r12
            android.text.StaticLayout r1 = new android.text.StaticLayout
            android.text.TextPaint r3 = r0.Yx
            float r4 = r0.Yv
            float r5 = r0.Yw
            r24 = 1
            r17 = r1
            r18 = r23
            r19 = r3
            r22 = r4
            r23 = r5
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r0.YR = r1
            r0.YS = r2
            r0.YT = r11
            r1 = r25
            r0.YU = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.i.nU():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void nV() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.YC
            int r1 = r7.YO
            int r2 = r7.YM
            int r1 = r1 - r2
            int r3 = r7.YP
            int r4 = r7.YN
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.YG
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.YD
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.YI
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.YJ
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0032
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L_0x0044
        L_0x0032:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L_0x0044:
            int r3 = r7.YH
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L_0x004d
            float r3 = (float) r1
        L_0x004b:
            float r2 = r2 - r3
            goto L_0x0053
        L_0x004d:
            if (r3 != r5) goto L_0x0053
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L_0x004b
        L_0x0053:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.YF
            if (r3 != r6) goto L_0x005e
            float r3 = (float) r0
        L_0x005c:
            float r4 = r4 - r3
            goto L_0x0064
        L_0x005e:
            if (r3 != r5) goto L_0x0064
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L_0x005c
        L_0x0064:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.YV = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.i.nV():void");
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            c(canvas);
            return;
        }
        com.applovin.exoplayer2.l.a.checkNotNull(this.YV);
        com.applovin.exoplayer2.l.a.checkNotNull(this.YC);
        d(canvas);
    }

    private void c(Canvas canvas) {
        StaticLayout staticLayout = this.YQ;
        StaticLayout staticLayout2 = this.YR;
        if (staticLayout != null && staticLayout2 != null) {
            int save = canvas.save();
            canvas.translate((float) this.YS, (float) this.YT);
            if (Color.alpha(this.Oi) > 0) {
                this.Yy.setColor(this.Oi);
                canvas.drawRect((float) (-this.YU), 0.0f, (float) (staticLayout.getWidth() + this.YU), (float) staticLayout.getHeight(), this.Yy);
            }
            int i = this.VX;
            boolean z = true;
            if (i == 1) {
                this.Yx.setStrokeJoin(Paint.Join.ROUND);
                this.Yx.setStrokeWidth(this.Ys);
                this.Yx.setColor(this.VY);
                this.Yx.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout2.draw(canvas);
            } else if (i == 2) {
                TextPaint textPaint = this.Yx;
                float f = this.Yt;
                float f2 = this.Yu;
                textPaint.setShadowLayer(f, f2, f2, this.VY);
            } else if (i == 3 || i == 4) {
                if (i != 3) {
                    z = false;
                }
                int i2 = -1;
                int i3 = z ? -1 : this.VY;
                if (z) {
                    i2 = this.VY;
                }
                float f3 = this.Yt / 2.0f;
                this.Yx.setColor(this.Qa);
                this.Yx.setStyle(Paint.Style.FILL);
                float f4 = -f3;
                this.Yx.setShadowLayer(this.Yt, f4, f4, i3);
                staticLayout2.draw(canvas);
                this.Yx.setShadowLayer(this.Yt, f3, f3, i2);
            }
            this.Yx.setColor(this.Qa);
            this.Yx.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.Yx.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private void d(Canvas canvas) {
        canvas.drawBitmap(this.YC, (Rect) null, this.YV, this.Yz);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
