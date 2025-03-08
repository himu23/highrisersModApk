package com.fyber.inneractive.sdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.fyber.inneractive.sdk.util.p;

public class IAcloseButton extends View {
    public Paint a;
    public Path b;

    public IAcloseButton(Context context, int i, boolean z) {
        super(context);
        int a2 = p.a(10);
        int i2 = (z ? (i - (a2 * 2)) / 4 : 0) + a2;
        Point point = new Point(i2, i2);
        int i3 = i - i2;
        Point point2 = new Point(i2, i3);
        Point point3 = new Point(i3, i3);
        Point point4 = new Point(i3, i2);
        Path path = new Path();
        this.b = path;
        path.setFillType(Path.FillType.EVEN_ODD);
        this.b.moveTo((float) point.x, (float) point.y);
        this.b.lineTo((float) point3.x, (float) point3.y);
        this.b.moveTo((float) point2.x, (float) point2.y);
        this.b.lineTo((float) point4.x, (float) point4.y);
        this.b.close();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStrokeWidth((float) p.a(2));
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setAntiAlias(true);
        if (z) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(-1436657061);
            gradientDrawable.setStroke(p.a(2), -1);
            p.a((View) this, (Drawable) gradientDrawable);
        }
        setPadding(a2, a2, a2, a2);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.b, this.a);
    }
}
