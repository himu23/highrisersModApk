package com.applovin.impl.adview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.app.NotificationCompat;

public class h extends View {
    private static final int ahs = Color.rgb(66, 145, 241);
    private static final int aht = Color.rgb(66, 145, 241);
    private static final int ahu = Color.rgb(66, 145, 241);
    private float Ok;
    private final float YX;
    private Paint ahb;
    private Paint ahc;
    protected Paint ahd;
    protected Paint ahe;
    private RectF ahf;
    private int ahg;
    private int ahh;
    private int ahi;
    private int ahj;
    private int ahk;
    private float ahl;
    private int ahm;
    private String ahn;
    private String aho;
    private float ahp;
    private String ahq;
    private float ahr;
    private final float ahv;
    private final float ahw;
    private final int ahx;

    public int getFinishedStrokeColor() {
        return this.ahk;
    }

    public float getFinishedStrokeWidth() {
        return this.ahl;
    }

    public int getInnerBackgroundColor() {
        return this.ahm;
    }

    public String getInnerBottomText() {
        return this.ahq;
    }

    public int getInnerBottomTextColor() {
        return this.ahh;
    }

    public float getInnerBottomTextSize() {
        return this.ahp;
    }

    public int getMax() {
        return this.ahj;
    }

    public String getPrefixText() {
        return this.ahn;
    }

    public int getProgress() {
        return this.ahi;
    }

    public String getSuffixText() {
        return this.aho;
    }

    public int getTextColor() {
        return this.ahg;
    }

    public float getTextSize() {
        return this.Ok;
    }

    public h(Context context) {
        this(context, (AttributeSet) null);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahf = new RectF();
        this.ahi = 0;
        this.ahn = "";
        this.aho = "";
        this.ahq = "";
        this.YX = a.b(getResources(), 14.0f);
        this.ahx = (int) a.a(getResources(), 100.0f);
        this.ahv = a.a(getResources(), 4.0f);
        this.ahw = a.b(getResources(), 18.0f);
        ry();
        rx();
    }

    /* access modifiers changed from: protected */
    public void rx() {
        TextPaint textPaint = new TextPaint();
        this.ahd = textPaint;
        textPaint.setColor(this.ahg);
        this.ahd.setTextSize(this.Ok);
        this.ahd.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.ahe = textPaint2;
        textPaint2.setColor(this.ahh);
        this.ahe.setTextSize(this.ahp);
        this.ahe.setAntiAlias(true);
        Paint paint = new Paint();
        this.ahb = paint;
        paint.setColor(this.ahk);
        this.ahb.setStyle(Paint.Style.STROKE);
        this.ahb.setAntiAlias(true);
        this.ahb.setStrokeWidth(this.ahl);
        Paint paint2 = new Paint();
        this.ahc = paint2;
        paint2.setColor(this.ahm);
        this.ahc.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void ry() {
        this.ahk = ahs;
        this.ahg = aht;
        this.Ok = this.YX;
        setMax(100);
        setProgress(0);
        this.ahl = this.ahv;
        this.ahm = 0;
        this.ahp = this.ahw;
        this.ahh = ahu;
    }

    public void invalidate() {
        rx();
        super.invalidate();
    }

    public void setFinishedStrokeWidth(float f) {
        this.ahl = f;
        invalidate();
    }

    private float getProgressAngle() {
        return (((float) getProgress()) / ((float) this.ahj)) * 360.0f;
    }

    public void setProgress(int i) {
        this.ahi = i;
        if (i > getMax()) {
            this.ahi %= getMax();
        }
        invalidate();
    }

    public void setMax(int i) {
        if (i > 0) {
            this.ahj = i;
            invalidate();
        }
    }

    public void setTextSize(float f) {
        this.Ok = f;
        invalidate();
    }

    public void setTextColor(int i) {
        this.ahg = i;
        invalidate();
    }

    public void setFinishedStrokeColor(int i) {
        this.ahk = i;
        invalidate();
    }

    public void setSuffixText(String str) {
        this.aho = str;
        invalidate();
    }

    public void setPrefixText(String str) {
        this.ahn = str;
        invalidate();
    }

    public void setInnerBackgroundColor(int i) {
        this.ahm = i;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.ahq = str;
        invalidate();
    }

    public void setInnerBottomTextSize(float f) {
        this.ahp = f;
        invalidate();
    }

    public void setInnerBottomTextColor(int i) {
        this.ahh = i;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(fY(i), fY(i2));
        this.ahr = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    private int fY(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.ahx;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.ahl;
        this.ahf.set(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        float f2 = this.ahl;
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((((float) getWidth()) - f2) + f2) / 2.0f, this.ahc);
        canvas.drawArc(this.ahf, 270.0f, -getProgressAngle(), false, this.ahb);
        String str = this.ahn + this.ahi + this.aho;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (((float) getWidth()) - this.ahd.measureText(str)) / 2.0f, (((float) getWidth()) - (this.ahd.descent() + this.ahd.ascent())) / 2.0f, this.ahd);
        }
        if (!TextUtils.isEmpty(getInnerBottomText())) {
            this.ahe.setTextSize(this.ahp);
            canvas.drawText(getInnerBottomText(), (((float) getWidth()) - this.ahe.measureText(getInnerBottomText())) / 2.0f, (((float) getHeight()) - this.ahr) - ((this.ahd.descent() + this.ahd.ascent()) / 2.0f), this.ahe);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", (float) getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt("max", getMax());
        bundle.putInt(NotificationCompat.CATEGORY_PROGRESS, getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.ahg = bundle.getInt("text_color");
            this.Ok = bundle.getFloat("text_size");
            this.ahp = bundle.getFloat("inner_bottom_text_size");
            this.ahq = bundle.getString("inner_bottom_text");
            this.ahh = bundle.getInt("inner_bottom_text_color");
            this.ahk = bundle.getInt("finished_stroke_color");
            this.ahl = bundle.getFloat("finished_stroke_width");
            this.ahm = bundle.getInt("inner_background_color");
            rx();
            setMax(bundle.getInt("max"));
            setProgress(bundle.getInt(NotificationCompat.CATEGORY_PROGRESS));
            this.ahn = bundle.getString("prefix");
            this.aho = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private static class a {
        /* access modifiers changed from: private */
        public static float a(Resources resources, float f) {
            return (f * resources.getDisplayMetrics().density) + 0.5f;
        }

        /* access modifiers changed from: private */
        public static float b(Resources resources, float f) {
            return f * resources.getDisplayMetrics().scaledDensity;
        }
    }
}
