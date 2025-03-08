package com.applovin.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import com.applovin.exoplayer2.common.base.Predicate;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.d.b;

final class j {
    public static float a(int i, float f, int i2, int i3) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f2 = (float) i3;
        } else if (i == 1) {
            f2 = (float) i2;
        } else if (i != 2) {
            return -3.4028235E38f;
        } else {
            return f;
        }
        return f * f2;
    }

    public static void a(a.C0050a aVar) {
        aVar.lT();
        if (aVar.lQ() instanceof Spanned) {
            if (!(aVar.lQ() instanceof Spannable)) {
                aVar.m(SpannableString.valueOf(aVar.lQ()));
            }
            a((Spannable) com.applovin.exoplayer2.l.a.checkNotNull(aVar.lQ()), new j$$ExternalSyntheticLambda0());
        }
        b(aVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean M(Object obj) {
        return !(obj instanceof b);
    }

    public static void b(a.C0050a aVar) {
        aVar.c(-3.4028235E38f, Integer.MIN_VALUE);
        if (aVar.lQ() instanceof Spanned) {
            if (!(aVar.lQ() instanceof Spannable)) {
                aVar.m(SpannableString.valueOf(aVar.lQ()));
            }
            a((Spannable) com.applovin.exoplayer2.l.a.checkNotNull(aVar.lQ()), new j$$ExternalSyntheticLambda1());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean L(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    private static void a(Spannable spannable, Predicate<Object> predicate) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (predicate.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }
}
