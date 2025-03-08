package com.applovin.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.a.u;
import com.applovin.exoplayer2.i.d.e;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

final class h {
    private static final Pattern Yj = Pattern.compile("(&#13;)?&#10;");

    private static final class c {
        /* access modifiers changed from: private */
        public final List<b> Yq = new ArrayList();
        /* access modifiers changed from: private */
        public final List<b> Yr = new ArrayList();
    }

    private static String fb(int i) {
        return i != 2 ? "over right" : "under left";
    }

    public static a a(CharSequence charSequence, float f) {
        if (charSequence == null) {
            return new a("", u.gi());
        }
        if (!(charSequence instanceof Spanned)) {
            return new a(o(charSequence), u.gi());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet<Integer> hashSet = new HashSet<>();
        int i = 0;
        for (BackgroundColorSpan backgroundColor : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColor.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        for (Integer intValue : hashSet) {
            int intValue2 = intValue.intValue();
            hashMap.put(e.aJ("bg_" + intValue2), ai.a("background-color:%s;", e.eX(intValue2)));
        }
        SparseArray<c> a2 = a(spanned, f);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i2 = 0;
        while (i < a2.size()) {
            int keyAt = a2.keyAt(i);
            sb.append(o(spanned.subSequence(i2, keyAt)));
            c cVar = a2.get(keyAt);
            Collections.sort(cVar.Yr, b.Yn);
            for (b bVar : cVar.Yr) {
                sb.append(bVar.Yp);
            }
            Collections.sort(cVar.Yq, b.Ym);
            for (b bVar2 : cVar.Yq) {
                sb.append(bVar2.Yo);
            }
            i++;
            i2 = keyAt;
        }
        sb.append(o(spanned.subSequence(i2, spanned.length())));
        return new a(sb.toString(), hashMap);
    }

    private static SparseArray<c> a(Spanned spanned, float f) {
        SparseArray<c> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String a2 = a(obj, f);
            String K = K(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (a2 != null) {
                com.applovin.exoplayer2.l.a.checkNotNull(K);
                b bVar = new b(spanStart, spanEnd, a2, K);
                b(sparseArray, spanStart).Yq.add(bVar);
                b(sparseArray, spanEnd).Yr.add(bVar);
            }
        }
        return sparseArray;
    }

    private static String a(Object obj, float f) {
        float f2;
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return ai.a("<span style='color:%s;'>", e.eX(((ForegroundColorSpan) obj).getForegroundColor()));
        } else if (obj instanceof BackgroundColorSpan) {
            return ai.a("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        } else if (obj instanceof com.applovin.exoplayer2.i.d.a) {
            return "<span style='text-combine-upright:all;'>";
        } else {
            if (obj instanceof AbsoluteSizeSpan) {
                AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
                if (absoluteSizeSpan.getDip()) {
                    f2 = (float) absoluteSizeSpan.getSize();
                } else {
                    f2 = ((float) absoluteSizeSpan.getSize()) / f;
                }
                return ai.a("<span style='font-size:%.2fpx;'>", Float.valueOf(f2));
            } else if (obj instanceof RelativeSizeSpan) {
                return ai.a("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
            } else if (obj instanceof TypefaceSpan) {
                String family = ((TypefaceSpan) obj).getFamily();
                if (family == null) {
                    return null;
                }
                return ai.a("<span style='font-family:\"%s\";'>", family);
            } else if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "<b>";
                }
                if (style == 2) {
                    return "<i>";
                }
                if (style != 3) {
                    return null;
                }
                return "<b><i>";
            } else if (obj instanceof com.applovin.exoplayer2.i.d.c) {
                int i = ((com.applovin.exoplayer2.i.d.c) obj).oX;
                if (i == -1) {
                    return "<ruby style='ruby-position:unset;'>";
                }
                if (i == 1) {
                    return "<ruby style='ruby-position:over;'>";
                }
                if (i != 2) {
                    return null;
                }
                return "<ruby style='ruby-position:under;'>";
            } else if (obj instanceof UnderlineSpan) {
                return "<u>";
            } else {
                if (!(obj instanceof e)) {
                    return null;
                }
                e eVar = (e) obj;
                return ai.a("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", I(eVar.Rq, eVar.Rr), fb(eVar.oX));
            }
        }
    }

    private static String K(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof com.applovin.exoplayer2.i.d.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof e)) {
            return "</span>";
        }
        if (!(obj instanceof TypefaceSpan)) {
            if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "</b>";
                }
                if (style == 2) {
                    return "</i>";
                }
                if (style != 3) {
                    return null;
                }
                return "</i></b>";
            } else if (obj instanceof com.applovin.exoplayer2.i.d.c) {
                return "<rt>" + o(((com.applovin.exoplayer2.i.d.c) obj).Rp) + "</rt></ruby>";
            } else if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
            return null;
        } else if (((TypefaceSpan) obj).getFamily() != null) {
            return "</span>";
        } else {
            return null;
        }
    }

    private static String I(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i2 == 1) {
            sb.append("filled ");
        } else if (i2 == 2) {
            sb.append("open ");
        }
        if (i == 0) {
            sb.append("none");
        } else if (i == 1) {
            sb.append("circle");
        } else if (i == 2) {
            sb.append("dot");
        } else if (i != 3) {
            sb.append("unset");
        } else {
            sb.append("sesame");
        }
        return sb.toString();
    }

    private static c b(SparseArray<c> sparseArray, int i) {
        c cVar = sparseArray.get(i);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        sparseArray.put(i, cVar2);
        return cVar2;
    }

    private static String o(CharSequence charSequence) {
        return Yj.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static class a {
        public final String Yk;
        public final Map<String, String> Yl;

        private a(String str, Map<String, String> map) {
            this.Yk = str;
            this.Yl = map;
        }
    }

    private static final class b {
        /* access modifiers changed from: private */
        public static final Comparator<b> Ym = new h$b$$ExternalSyntheticLambda0();
        /* access modifiers changed from: private */
        public static final Comparator<b> Yn = new h$b$$ExternalSyntheticLambda1();
        public final String Yo;
        public final String Yp;
        public final int end;
        public final int start;

        /* access modifiers changed from: private */
        public static /* synthetic */ int b(b bVar, b bVar2) {
            int compare = Integer.compare(bVar2.end, bVar.end);
            if (compare != 0) {
                return compare;
            }
            int compareTo = bVar.Yo.compareTo(bVar2.Yo);
            if (compareTo != 0) {
                return compareTo;
            }
            return bVar.Yp.compareTo(bVar2.Yp);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ int a(b bVar, b bVar2) {
            int compare = Integer.compare(bVar2.start, bVar.start);
            if (compare != 0) {
                return compare;
            }
            int compareTo = bVar2.Yo.compareTo(bVar.Yo);
            if (compareTo != 0) {
                return compareTo;
            }
            return bVar2.Yp.compareTo(bVar.Yp);
        }

        private b(int i, int i2, String str, String str2) {
            this.start = i;
            this.end = i2;
            this.Yo = str;
            this.Yp = str2;
        }
    }
}
