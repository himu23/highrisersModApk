package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class l extends FrameLayout implements SubtitleView.a {
    private c VU;
    private float VV;
    private int YW;
    private float YX;
    private final b Zd;
    private List<a> Ze;
    private final WebView webView;

    private static String fc(int i) {
        return i != 1 ? i != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    private static int fd(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public l(Context context) {
        this(context, (AttributeSet) null);
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ze = Collections.emptyList();
        this.VU = c.VW;
        this.YX = 0.0533f;
        this.YW = 0;
        this.VV = 0.08f;
        b bVar = new b(context, attributeSet);
        this.Zd = bVar;
        AnonymousClass1 r2 = new WebView(context, attributeSet) {
            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.webView = r2;
        r2.setBackgroundColor(0);
        addView(bVar);
        addView(r2);
    }

    public void a(List<a> list, c cVar, float f, int i, float f2) {
        this.VU = cVar;
        this.YX = f;
        this.YW = i;
        this.VV = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            a aVar = list.get(i2);
            if (aVar.NZ != null) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        if (!this.Ze.isEmpty() || !arrayList2.isEmpty()) {
            this.Ze = arrayList2;
            nZ();
        }
        this.Zd.a(arrayList, cVar, f, i, f2);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.Ze.isEmpty()) {
            nZ();
        }
    }

    public void destroy() {
        this.webView.destroy();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0152, code lost:
        if (r13 != false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0155, code lost:
        if (r13 != false) goto L_0x0157;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x024f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void nZ() {
        /*
            r26 = this;
            r0 = r26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 4
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.applovin.exoplayer2.ui.c r4 = r0.VU
            int r4 = r4.Qa
            java.lang.String r4 = com.applovin.exoplayer2.ui.e.eX(r4)
            r5 = 0
            r3[r5] = r4
            int r4 = r0.YW
            float r6 = r0.YX
            java.lang.String r4 = r0.d(r4, r6)
            r6 = 1
            r3[r6] = r4
            r4 = 1067030938(0x3f99999a, float:1.2)
            java.lang.Float r7 = java.lang.Float.valueOf(r4)
            r8 = 2
            r3[r8] = r7
            com.applovin.exoplayer2.ui.c r7 = r0.VU
            java.lang.String r7 = a(r7)
            r9 = 3
            r3[r9] = r7
            java.lang.String r7 = "<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>"
            java.lang.String r3 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r7, (java.lang.Object[]) r3)
            r1.append(r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r7 = "default_bg"
            java.lang.String r10 = com.applovin.exoplayer2.ui.e.aJ(r7)
            java.lang.Object[] r11 = new java.lang.Object[r6]
            com.applovin.exoplayer2.ui.c r12 = r0.VU
            int r12 = r12.Qc
            java.lang.String r12 = com.applovin.exoplayer2.ui.e.eX(r12)
            r11[r5] = r12
            java.lang.String r12 = "background-color:%s;"
            java.lang.String r11 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r12, (java.lang.Object[]) r11)
            r3.put(r10, r11)
            r10 = 0
        L_0x005d:
            java.util.List<com.applovin.exoplayer2.i.a> r11 = r0.Ze
            int r11 = r11.size()
            if (r10 >= r11) goto L_0x0269
            java.util.List<com.applovin.exoplayer2.i.a> r11 = r0.Ze
            java.lang.Object r11 = r11.get(r10)
            com.applovin.exoplayer2.i.a r11 = (com.applovin.exoplayer2.i.a) r11
            float r12 = r11.Od
            r13 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r14 = 1120403456(0x42c80000, float:100.0)
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 == 0) goto L_0x007d
            float r12 = r11.Od
            float r12 = r12 * r14
            goto L_0x007f
        L_0x007d:
            r12 = 1112014848(0x42480000, float:50.0)
        L_0x007f:
            int r15 = r11.Oe
            int r15 = fd(r15)
            float r2 = r11.Oa
            r17 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r9 = "%.2f%%"
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 == 0) goto L_0x00e7
            int r2 = r11.Ob
            if (r2 == r6) goto L_0x00b6
            java.lang.Object[] r2 = new java.lang.Object[r6]
            float r8 = r11.Oa
            float r8 = r8 * r14
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r2[r5] = r8
            java.lang.String r2 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r9, (java.lang.Object[]) r2)
            int r8 = r11.Ol
            if (r8 != r6) goto L_0x00af
            int r8 = r11.Oc
            int r8 = fd(r8)
            int r8 = -r8
            goto L_0x00fb
        L_0x00af:
            int r8 = r11.Oc
            int r8 = fd(r8)
            goto L_0x00fb
        L_0x00b6:
            float r2 = r11.Oa
            r8 = 0
            java.lang.String r13 = "%.2fem"
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x00d1
            java.lang.Object[] r2 = new java.lang.Object[r6]
            float r8 = r11.Oa
            float r8 = r8 * r4
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r2[r5] = r8
            java.lang.String r2 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r13, (java.lang.Object[]) r2)
            r8 = 0
            goto L_0x00fb
        L_0x00d1:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            float r8 = r11.Oa
            float r8 = -r8
            float r8 = r8 - r17
            float r8 = r8 * r4
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r2[r5] = r8
            java.lang.String r2 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r13, (java.lang.Object[]) r2)
            r8 = 0
            r13 = 1
            goto L_0x00fc
        L_0x00e7:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            float r8 = r0.VV
            float r17 = r17 - r8
            float r17 = r17 * r14
            java.lang.Float r8 = java.lang.Float.valueOf(r17)
            r2[r5] = r8
            java.lang.String r2 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r9, (java.lang.Object[]) r2)
            r8 = -100
        L_0x00fb:
            r13 = 0
        L_0x00fc:
            float r4 = r11.Of
            r18 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r4 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r4 == 0) goto L_0x0116
            java.lang.Object[] r4 = new java.lang.Object[r6]
            float r6 = r11.Of
            float r6 = r6 * r14
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r4[r5] = r6
            java.lang.String r4 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r9, (java.lang.Object[]) r4)
            goto L_0x0118
        L_0x0116:
            java.lang.String r4 = "fit-content"
        L_0x0118:
            android.text.Layout$Alignment r6 = r11.NX
            java.lang.String r6 = e(r6)
            int r9 = r11.Ol
            java.lang.String r9 = fc(r9)
            int r14 = r11.Oj
            float r5 = r11.Ok
            java.lang.String r5 = r0.d(r14, r5)
            boolean r14 = r11.Oh
            if (r14 == 0) goto L_0x0133
            int r14 = r11.Oi
            goto L_0x0137
        L_0x0133:
            com.applovin.exoplayer2.ui.c r14 = r0.VU
            int r14 = r14.Oi
        L_0x0137:
            java.lang.String r14 = com.applovin.exoplayer2.ui.e.eX(r14)
            r20 = r8
            int r8 = r11.Ol
            java.lang.String r21 = "right"
            java.lang.String r22 = "left"
            java.lang.String r23 = "top"
            r24 = r15
            r15 = 1
            if (r8 == r15) goto L_0x0155
            r15 = 2
            if (r8 == r15) goto L_0x0152
            if (r13 == 0) goto L_0x015d
            java.lang.String r23 = "bottom"
            goto L_0x015d
        L_0x0152:
            if (r13 == 0) goto L_0x0157
            goto L_0x0159
        L_0x0155:
            if (r13 == 0) goto L_0x0159
        L_0x0157:
            r21 = r22
        L_0x0159:
            r22 = r23
            r23 = r21
        L_0x015d:
            int r8 = r11.Ol
            r13 = 2
            if (r8 == r13) goto L_0x016d
            int r8 = r11.Ol
            r13 = 1
            if (r8 != r13) goto L_0x0168
            goto L_0x016d
        L_0x0168:
            java.lang.String r8 = "width"
            r15 = r24
            goto L_0x0173
        L_0x016d:
            java.lang.String r8 = "height"
            r15 = r20
            r20 = r24
        L_0x0173:
            java.lang.CharSequence r13 = r11.NW
            android.content.Context r21 = r26.getContext()
            android.content.res.Resources r21 = r21.getResources()
            android.util.DisplayMetrics r0 = r21.getDisplayMetrics()
            float r0 = r0.density
            com.applovin.exoplayer2.ui.h$a r0 = com.applovin.exoplayer2.ui.h.a((java.lang.CharSequence) r13, (float) r0)
            java.util.Set r13 = r3.keySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x018f:
            boolean r21 = r13.hasNext()
            if (r21 == 0) goto L_0x01c7
            java.lang.Object r21 = r13.next()
            r24 = r13
            r13 = r21
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r21 = r3.get(r13)
            r25 = r0
            r0 = r21
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r3.put(r13, r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x01be
            java.lang.Object r13 = r3.get(r13)
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x01bc
            goto L_0x01be
        L_0x01bc:
            r0 = 0
            goto L_0x01bf
        L_0x01be:
            r0 = 1
        L_0x01bf:
            com.applovin.exoplayer2.l.a.checkState(r0)
            r13 = r24
            r0 = r25
            goto L_0x018f
        L_0x01c7:
            r25 = r0
            r0 = 14
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            r19 = 0
            r0[r19] = r13
            r13 = 1
            r0[r13] = r22
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            r13 = 2
            r0[r13] = r12
            r12 = 3
            r0[r12] = r23
            r16 = 4
            r0[r16] = r2
            r2 = 5
            r0[r2] = r8
            r2 = 6
            r0[r2] = r4
            r2 = 7
            r0[r2] = r6
            r2 = 8
            r0[r2] = r9
            r2 = 9
            r0[r2] = r5
            r2 = 10
            r0[r2] = r14
            r2 = 11
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0[r2] = r4
            r2 = 12
            java.lang.Integer r4 = java.lang.Integer.valueOf(r20)
            r0[r2] = r4
            r2 = 13
            java.lang.String r4 = c(r11)
            r0[r2] = r4
            java.lang.String r2 = "<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>"
            java.lang.String r0 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r2, (java.lang.Object[]) r0)
            r1.append(r0)
            r0 = 1
            java.lang.Object[] r2 = new java.lang.Object[r0]
            r4 = 0
            r2[r4] = r7
            java.lang.String r5 = "<span class='%s'>"
            java.lang.String r2 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r5, (java.lang.Object[]) r2)
            r1.append(r2)
            android.text.Layout$Alignment r2 = r11.NY
            if (r2 == 0) goto L_0x024f
            java.lang.Object[] r2 = new java.lang.Object[r0]
            android.text.Layout$Alignment r0 = r11.NY
            java.lang.String r0 = e(r0)
            r2[r4] = r0
            java.lang.String r0 = "<span style='display:inline-block; text-align:%s;'>"
            java.lang.String r0 = com.applovin.exoplayer2.l.ai.a((java.lang.String) r0, (java.lang.Object[]) r2)
            r1.append(r0)
            r0 = r25
            java.lang.String r0 = r0.Yk
            r1.append(r0)
            java.lang.String r0 = "</span>"
            r1.append(r0)
            goto L_0x0256
        L_0x024f:
            r0 = r25
            java.lang.String r0 = r0.Yk
            r1.append(r0)
        L_0x0256:
            java.lang.String r0 = "</span></div>"
            r1.append(r0)
            int r10 = r10 + 1
            r2 = 4
            r4 = 1067030938(0x3f99999a, float:1.2)
            r5 = 0
            r8 = 2
            r9 = 3
            r0 = r26
            r6 = 1
            goto L_0x005d
        L_0x0269:
            java.lang.String r0 = "</div></body></html>"
            r1.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "<html><head><style>"
            r0.<init>(r2)
            java.util.Set r2 = r3.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x027d:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x02a0
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            r0.append(r4)
            java.lang.String r5 = "{"
            r0.append(r5)
            java.lang.Object r4 = r3.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r0.append(r4)
            java.lang.String r4 = "}"
            r0.append(r4)
            goto L_0x027d
        L_0x02a0:
            java.lang.String r2 = "</style></head>"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 0
            r1.insert(r2, r0)
            r0 = r26
            android.webkit.WebView r2 = r0.webView
            java.lang.String r1 = r1.toString()
            java.nio.charset.Charset r3 = com.applovin.exoplayer2.common.base.Charsets.UTF_8
            byte[] r1 = r1.getBytes(r3)
            r3 = 1
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r3)
            java.lang.String r3 = "text/html"
            java.lang.String r4 = "base64"
            r2.loadData(r1, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.l.nZ():void");
    }

    private static String c(a aVar) {
        if (aVar.Om == 0.0f) {
            return "";
        }
        return ai.a("%s(%.2fdeg)", (aVar.Ol == 2 || aVar.Ol == 1) ? "skewY" : "skewX", Float.valueOf(aVar.Om));
    }

    private String d(int i, float f) {
        float a = j.a(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (a == -3.4028235E38f) {
            return "unset";
        }
        return ai.a("%.2fpx", Float.valueOf(a / getContext().getResources().getDisplayMetrics().density));
    }

    private static String a(c cVar) {
        int i = cVar.VX;
        if (i == 1) {
            return ai.a("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", e.eX(cVar.VY));
        } else if (i == 2) {
            return ai.a("0.1em 0.12em 0.15em %s", e.eX(cVar.VY));
        } else if (i == 3) {
            return ai.a("0.06em 0.08em 0.15em %s", e.eX(cVar.VY));
        } else if (i != 4) {
            return "unset";
        } else {
            return ai.a("-0.05em -0.05em 0.15em %s", e.eX(cVar.VY));
        }
    }

    /* renamed from: com.applovin.exoplayer2.ui.l$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] Zg;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.text.Layout$Alignment[] r0 = android.text.Layout.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                Zg = r0
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = Zg     // Catch:{ NoSuchFieldError -> 0x001d }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = Zg     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.l.AnonymousClass2.<clinit>():void");
        }
    }

    private static String e(Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = AnonymousClass2.Zg[alignment.ordinal()];
        if (i != 1) {
            return i != 2 ? "center" : "end";
        }
        return "start";
    }
}
