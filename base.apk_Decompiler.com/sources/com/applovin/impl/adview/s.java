package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.j;

public final class s extends j {
    private static final Paint ahY = new Paint(1);
    private static final Paint ahZ = new Paint(1);

    public s(Context context) {
        super(context);
        ahY.setARGB(80, 0, 0, 0);
        Paint paint = ahZ;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.ahA * 8.0f;
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
    }

    public j.a getStyle() {
        return j.a.WHITE_ON_TRANSPARENT;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, ahY);
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
