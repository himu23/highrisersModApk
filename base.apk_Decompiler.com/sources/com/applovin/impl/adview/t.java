package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.applovin.impl.adview.j;

public final class t extends j {
    private static final Paint ahY = new Paint(1);
    private static final Paint aia = new Paint(1);
    private final float[] aib = {30.0f, 30.0f, 50.0f, 50.0f, 30.0f, 70.0f, 55.0f, 30.0f, 75.0f, 50.0f, 55.0f, 70.0f};
    private Path aic;

    public t(Context context) {
        super(context);
        ahY.setARGB(80, 0, 0, 0);
        Paint paint = aia;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.ahA * 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    public void fZ(int i) {
        setViewScale(((float) i) / 30.0f);
        rV();
    }

    public j.a getStyle() {
        return j.a.TRANSPARENT_SKIP;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, ahY);
        Paint paint = aia;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawPath(this.aic, paint);
    }

    private void rV() {
        int i = 0;
        while (true) {
            float[] fArr = this.aib;
            if (i < fArr.length) {
                fArr[i] = fArr[i] * 0.3f * this.ahA;
                i++;
            } else {
                Path path = new Path();
                this.aic = path;
                float[] fArr2 = this.aib;
                path.moveTo(fArr2[0], fArr2[1]);
                Path path2 = this.aic;
                float[] fArr3 = this.aib;
                path2.lineTo(fArr3[2], fArr3[3]);
                Path path3 = this.aic;
                float[] fArr4 = this.aib;
                path3.lineTo(fArr4[4], fArr4[5]);
                Path path4 = this.aic;
                float[] fArr5 = this.aib;
                path4.moveTo(fArr5[6], fArr5[7]);
                Path path5 = this.aic;
                float[] fArr6 = this.aib;
                path5.lineTo(fArr6[8], fArr6[9]);
                Path path6 = this.aic;
                float[] fArr7 = this.aib;
                path6.lineTo(fArr7[10], fArr7[11]);
                return;
            }
        }
    }
}
