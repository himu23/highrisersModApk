package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.j;

public final class z extends j {
    private static final Paint ahY = new Paint(1);
    private static final Paint ahZ = new Paint(1);
    private static final Paint ahc = new Paint(1);

    public z(Context context) {
        super(context);
        ahY.setColor(-1);
        ahc.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint = ahZ;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.ahA * 10.0f;
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.ahA * 3.0f;
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleOffset() {
        return this.ahA * 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    public j.a getStyle() {
        return j.a.WHITE_ON_BLACK;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, ahY);
        canvas.drawCircle(center, center, getInnerCircleRadius(), ahc);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = ahZ;
        paint.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        Paint paint2 = paint;
        canvas2.drawLine(f, crossOffset, f2, size, paint2);
        canvas2.drawLine(f, size, f2, crossOffset, paint2);
    }
}
