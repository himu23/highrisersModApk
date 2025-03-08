package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b extends View implements SubtitleView.a {
    private List<a> OV;
    private int Oj;
    private float Ok;
    private final List<i> VS;
    private c VU;
    private float VV;

    public b(Context context) {
        this(context, (AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VS = new ArrayList();
        this.OV = Collections.emptyList();
        this.Oj = 0;
        this.Ok = 0.0533f;
        this.VU = c.VW;
        this.VV = 0.08f;
    }

    public void a(List<a> list, c cVar, float f, int i, float f2) {
        this.OV = list;
        this.VU = cVar;
        this.Ok = f;
        this.Oj = i;
        this.VV = f2;
        while (this.VS.size() < list.size()) {
            this.VS.add(new i(getContext()));
        }
        invalidate();
    }

    public void dispatchDraw(Canvas canvas) {
        List<a> list = this.OV;
        if (!list.isEmpty()) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int paddingBottom = height - getPaddingBottom();
            if (paddingBottom > paddingTop && width > paddingLeft) {
                int i = paddingBottom - paddingTop;
                float a = j.a(this.Oj, this.Ok, height, i);
                if (a > 0.0f) {
                    int size = list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        a aVar = list.get(i2);
                        if (aVar.Ol != Integer.MIN_VALUE) {
                            aVar = a(aVar);
                        }
                        a aVar2 = aVar;
                        float f = a;
                        int i3 = paddingBottom;
                        this.VS.get(i2).a(aVar2, this.VU, f, j.a(aVar2.Oj, aVar2.Ok, height, i), this.VV, canvas, paddingLeft, paddingTop, width, i3);
                        i2++;
                        size = size;
                        i = i;
                        paddingBottom = i3;
                        width = width;
                    }
                }
            }
        }
    }

    private static a a(a aVar) {
        a.C0050a a = aVar.lP().o(-3.4028235E38f).eg(Integer.MIN_VALUE).a((Layout.Alignment) null);
        if (aVar.Ob == 0) {
            a.b(1.0f - aVar.Oa, 0);
        } else {
            a.b((-aVar.Oa) - 1.0f, 1);
        }
        int i = aVar.Oc;
        if (i == 0) {
            a.ef(2);
        } else if (i == 2) {
            a.ef(0);
        }
        return a.lU();
    }
}
