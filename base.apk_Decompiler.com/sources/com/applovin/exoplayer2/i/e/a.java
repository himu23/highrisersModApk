package com.applovin.exoplayer2.i.e;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.d;
import com.applovin.exoplayer2.i.e.c;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends d {
    private static final Pattern Rs = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean Rt;
    private final b Ru;
    private Map<String, c> Rv;
    private float Rw;
    private float Rx;

    private static float ez(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public a() {
        this((List<byte[]>) null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        this.Rw = -3.4028235E38f;
        this.Rx = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.Rt = false;
            this.Ru = null;
            return;
        }
        this.Rt = true;
        String J = ai.J(list.get(0));
        com.applovin.exoplayer2.l.a.checkArgument(J.startsWith("Format:"));
        this.Ru = (b) com.applovin.exoplayer2.l.a.checkNotNull(b.ac(J));
        ad(new y(list.get(1)));
    }

    /* access modifiers changed from: protected */
    public f c(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        y yVar = new y(bArr, i);
        if (!this.Rt) {
            ad(yVar);
        }
        a(yVar, (List<List<com.applovin.exoplayer2.i.a>>) arrayList, (List<Long>) arrayList2);
        return new d(arrayList, arrayList2);
    }

    private void ad(y yVar) {
        while (true) {
            String pJ = yVar.pJ();
            if (pJ == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(pJ)) {
                ae(yVar);
            } else if ("[V4+ Styles]".equalsIgnoreCase(pJ)) {
                this.Rv = af(yVar);
            } else if ("[V4 Styles]".equalsIgnoreCase(pJ)) {
                q.g("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(pJ)) {
                return;
            }
        }
    }

    private void ae(y yVar) {
        while (true) {
            String pJ = yVar.pJ();
            if (pJ == null) {
                return;
            }
            if (yVar.pj() == 0 || yVar.pm() != 91) {
                String[] split = pJ.split(":");
                if (split.length == 2) {
                    String lowerCase = Ascii.toLowerCase(split[0].trim());
                    lowerCase.hashCode();
                    if (lowerCase.equals("playresx")) {
                        this.Rw = Float.parseFloat(split[1].trim());
                    } else if (lowerCase.equals("playresy")) {
                        try {
                            this.Rx = Float.parseFloat(split[1].trim());
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private static Map<String, c> af(y yVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVar = null;
        while (true) {
            String pJ = yVar.pJ();
            if (pJ == null || (yVar.pj() != 0 && yVar.pm() == 91)) {
                return linkedHashMap;
            }
            if (pJ.startsWith("Format:")) {
                aVar = c.a.ai(pJ);
            } else if (pJ.startsWith("Style:")) {
                if (aVar == null) {
                    q.h("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + pJ);
                } else {
                    c a = c.a(pJ, aVar);
                    if (a != null) {
                        linkedHashMap.put(a.name, a);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private void a(y yVar, List<List<com.applovin.exoplayer2.i.a>> list, List<Long> list2) {
        b bVar = this.Rt ? this.Ru : null;
        while (true) {
            String pJ = yVar.pJ();
            if (pJ == null) {
                return;
            }
            if (pJ.startsWith("Format:")) {
                bVar = b.ac(pJ);
            } else if (pJ.startsWith("Dialogue:")) {
                if (bVar == null) {
                    q.h("SsaDecoder", "Skipping dialogue line before complete format: " + pJ);
                } else {
                    a(pJ, bVar, list, list2);
                }
            }
        }
    }

    private void a(String str, b bVar, List<List<com.applovin.exoplayer2.i.a>> list, List<Long> list2) {
        com.applovin.exoplayer2.l.a.checkArgument(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", bVar.fR);
        if (split.length != bVar.fR) {
            q.h("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long ab = ab(split[bVar.Ry]);
        if (ab == -9223372036854775807L) {
            q.h("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long ab2 = ab(split[bVar.Rz]);
        if (ab2 == -9223372036854775807L) {
            q.h("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        c cVar = (this.Rv == null || bVar.RA == -1) ? null : this.Rv.get(split[bVar.RA].trim());
        String str2 = split[bVar.RB];
        com.applovin.exoplayer2.i.a a = a(c.b.ak(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.aj(str2), this.Rw, this.Rx);
        int a2 = a(ab2, list2, list);
        for (int a3 = a(ab, list2, list); a3 < a2; a3++) {
            list.get(a3).add(a);
        }
    }

    private static long ab(String str) {
        Matcher matcher = Rs.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong((String) ai.R(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) ai.R(matcher.group(2))) * 60000000) + (Long.parseLong((String) ai.R(matcher.group(3))) * 1000000) + (Long.parseLong((String) ai.R(matcher.group(4))) * 10000);
    }

    private static com.applovin.exoplayer2.i.a a(String str, c cVar, c.b bVar, float f, float f2) {
        SpannableString spannableString = new SpannableString(str);
        a.C0050a m = new a.C0050a().m(spannableString);
        if (cVar != null) {
            if (cVar.RD != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.RD.intValue()), 0, spannableString.length(), 33);
            }
            if (!(cVar.RE == -3.4028235E38f || f2 == -3.4028235E38f)) {
                m.c(cVar.RE / f2, 1);
            }
            if (cVar.RF && cVar.RG) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (cVar.RF) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.RG) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (cVar.Pn) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (cVar.RH) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i = -1;
        if (bVar.RC != -1) {
            i = bVar.RC;
        } else if (cVar != null) {
            i = cVar.RC;
        }
        m.a(ew(i)).eg(ey(i)).ef(ex(i));
        if (bVar.RV == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
            m.o(ez(m.lS()));
            m.b(ez(m.lR()), 0);
        } else {
            m.o(bVar.RV.x / f);
            m.b(bVar.RV.y / f2, 0);
        }
        return m.lU();
    }

    private static Layout.Alignment ew(int i) {
        switch (i) {
            case -1:
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                q.h("SsaDecoder", "Unknown alignment: " + i);
                return null;
        }
    }

    private static int ex(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                q.h("SsaDecoder", "Unknown alignment: " + i);
                return Integer.MIN_VALUE;
        }
    }

    private static int ey(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
            default:
                q.h("SsaDecoder", "Unknown alignment: " + i);
                return Integer.MIN_VALUE;
        }
    }

    private static int a(long j, List<Long> list, List<List<com.applovin.exoplayer2.i.a>> list2) {
        int i;
        ArrayList arrayList;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            } else if (list.get(size).longValue() == j) {
                return size;
            } else {
                if (list.get(size).longValue() < j) {
                    i = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i, Long.valueOf(j));
        if (i != 0) {
            arrayList = new ArrayList(list2.get(i - 1));
        }
        list2.add(i, arrayList);
        return i;
    }
}
