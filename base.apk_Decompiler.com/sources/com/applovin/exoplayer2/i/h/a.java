package com.applovin.exoplayer2.i.h;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.d;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.i.h;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import java.util.List;
import kotlin.UByte;

public final class a extends d {
    private final y Tg = new y();
    private final boolean Th;
    private final int Ti;
    private final int Tj;
    private final String Tk;
    private final float Tl;
    private final int Tm;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        String str = "sans-serif";
        boolean z = false;
        if (list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.Ti = bArr[24];
            this.Tj = ((bArr[26] & UByte.MAX_VALUE) << Ascii.CAN) | ((bArr[27] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[28] & UByte.MAX_VALUE) << 8) | (bArr[29] & UByte.MAX_VALUE);
            this.Tk = "Serif".equals(ai.t(bArr, 43, bArr.length - 43)) ? "serif" : str;
            int i = bArr[25] * Ascii.DC4;
            this.Tm = i;
            z = (bArr[0] & 32) != 0 ? true : z;
            this.Th = z;
            if (z) {
                this.Tl = ai.a(((float) ((bArr[11] & UByte.MAX_VALUE) | ((bArr[10] & UByte.MAX_VALUE) << 8))) / ((float) i), 0.0f, 0.95f);
            } else {
                this.Tl = 0.85f;
            }
        } else {
            this.Ti = 0;
            this.Tj = -1;
            this.Tk = str;
            this.Th = false;
            this.Tl = 0.85f;
            this.Tm = -1;
        }
    }

    /* access modifiers changed from: protected */
    public f c(byte[] bArr, int i, boolean z) throws h {
        this.Tg.l(bArr, i);
        String ag = ag(this.Tg);
        if (ag.isEmpty()) {
            return b.Tn;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ag);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        a(spannableStringBuilder2, this.Ti, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder2, this.Tj, -1, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.Tk, 0, spannableStringBuilder.length());
        float f = this.Tl;
        while (this.Tg.pj() >= 8) {
            int il = this.Tg.il();
            int px = this.Tg.px();
            int px2 = this.Tg.px();
            boolean z2 = true;
            if (px2 == 1937013100) {
                if (this.Tg.pj() < 2) {
                    z2 = false;
                }
                X(z2);
                int pp = this.Tg.pp();
                for (int i2 = 0; i2 < pp; i2++) {
                    a(this.Tg, spannableStringBuilder);
                }
            } else if (px2 == 1952608120 && this.Th) {
                if (this.Tg.pj() < 2) {
                    z2 = false;
                }
                X(z2);
                f = ai.a(((float) this.Tg.pp()) / ((float) this.Tm), 0.0f, 0.95f);
            }
            this.Tg.fx(il + px);
        }
        return new b(new a.C0050a().m(spannableStringBuilder).b(f, 0).ef(0).lU());
    }

    private static String ag(y yVar) throws h {
        char pn;
        X(yVar.pj() >= 2);
        int pp = yVar.pp();
        if (pp == 0) {
            return "";
        }
        if (yVar.pj() < 2 || ((pn = yVar.pn()) != 65279 && pn != 65534)) {
            return yVar.b(pp, Charsets.UTF_8);
        }
        return yVar.b(pp, Charsets.UTF_16);
    }

    private void a(y yVar, SpannableStringBuilder spannableStringBuilder) throws h {
        X(yVar.pj() >= 12);
        int pp = yVar.pp();
        int pp2 = yVar.pp();
        yVar.fz(2);
        int po = yVar.po();
        yVar.fz(1);
        int px = yVar.px();
        if (pp2 > spannableStringBuilder.length()) {
            q.h("Tx3gDecoder", "Truncating styl end (" + pp2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            pp2 = spannableStringBuilder.length();
        }
        if (pp >= pp2) {
            q.h("Tx3gDecoder", "Ignoring styl with start (" + pp + ") >= end (" + pp2 + ").");
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i = pp;
        int i2 = pp2;
        a(spannableStringBuilder2, po, this.Ti, i, i2, 0);
        b(spannableStringBuilder2, px, this.Tj, i, i2, 0);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = true;
            boolean z2 = (i & 1) != 0;
            boolean z3 = (i & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            if ((i & 4) == 0) {
                z = false;
            }
            if (z) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (!z && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, int i, int i2) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, 16711713);
        }
    }

    private static void X(boolean z) throws h {
        if (!z) {
            throw new h("Unexpected subtitle format.");
        }
    }
}
