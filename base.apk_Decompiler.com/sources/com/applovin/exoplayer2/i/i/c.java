package com.applovin.exoplayer2.i.i;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.f;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import com.ironsource.m2;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class c {
    private static final Pattern To = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern Tp = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final y Tq = new y();
    private final StringBuilder Tr = new StringBuilder();

    public List<d> ah(y yVar) {
        this.Tr.setLength(0);
        int il = yVar.il();
        al(yVar);
        this.Tq.l(yVar.hO(), yVar.il());
        this.Tq.fx(il);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String a = a(this.Tq, this.Tr);
            if (a == null || !"{".equals(b(this.Tq, this.Tr))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, a);
            String str = null;
            boolean z = false;
            while (!z) {
                int il2 = this.Tq.il();
                String b = b(this.Tq, this.Tr);
                boolean z2 = b == null || "}".equals(b);
                if (!z2) {
                    this.Tq.fx(il2);
                    a(this.Tq, dVar, this.Tr);
                }
                str = b;
                z = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(dVar);
            }
        }
    }

    private static String a(y yVar, StringBuilder sb) {
        aj(yVar);
        if (yVar.pj() < 5 || !"::cue".equals(yVar.fB(5))) {
            return null;
        }
        int il = yVar.il();
        String b = b(yVar, sb);
        if (b == null) {
            return null;
        }
        if ("{".equals(b)) {
            yVar.fx(il);
            return "";
        }
        String ai = "(".equals(b) ? ai(yVar) : null;
        if (!")".equals(b(yVar, sb))) {
            return null;
        }
        return ai;
    }

    private static String ai(y yVar) {
        int il = yVar.il();
        int pk = yVar.pk();
        boolean z = false;
        while (il < pk && !z) {
            int i = il + 1;
            z = ((char) yVar.hO()[il]) == ')';
            il = i;
        }
        return yVar.fB((il - 1) - yVar.il()).trim();
    }

    private static void a(y yVar, d dVar, StringBuilder sb) {
        aj(yVar);
        String d = d(yVar, sb);
        if (!"".equals(d) && ":".equals(b(yVar, sb))) {
            aj(yVar);
            String c = c(yVar, sb);
            if (c != null && !"".equals(c)) {
                int il = yVar.il();
                String b = b(yVar, sb);
                if (!";".equals(b)) {
                    if ("}".equals(b)) {
                        yVar.fx(il);
                    } else {
                        return;
                    }
                }
                if (m2.h.S.equals(d)) {
                    dVar.eI(f.aT(c));
                } else if ("background-color".equals(d)) {
                    dVar.eJ(f.aT(c));
                } else {
                    boolean z = true;
                    if ("ruby-position".equals(d)) {
                        if ("over".equals(c)) {
                            dVar.eL(1);
                        } else if ("under".equals(c)) {
                            dVar.eL(2);
                        }
                    } else if ("text-combine-upright".equals(d)) {
                        if (!"all".equals(c) && !c.startsWith("digits")) {
                            z = false;
                        }
                        dVar.ab(z);
                    } else if ("text-decoration".equals(d)) {
                        if ("underline".equals(c)) {
                            dVar.Y(true);
                        }
                    } else if ("font-family".equals(d)) {
                        dVar.az(c);
                    } else if ("font-weight".equals(d)) {
                        if ("bold".equals(c)) {
                            dVar.Z(true);
                        }
                    } else if ("font-style".equals(d)) {
                        if ("italic".equals(c)) {
                            dVar.aa(true);
                        }
                    } else if ("font-size".equals(d)) {
                        a(c, dVar);
                    }
                }
            }
        }
    }

    static void aj(y yVar) {
        while (true) {
            boolean z = true;
            while (yVar.pj() > 0 && z) {
                if (!ak(yVar) && !am(yVar)) {
                    z = false;
                }
            }
            return;
        }
    }

    static String b(y yVar, StringBuilder sb) {
        aj(yVar);
        if (yVar.pj() == 0) {
            return null;
        }
        String d = d(yVar, sb);
        if (!"".equals(d)) {
            return d;
        }
        return "" + ((char) yVar.po());
    }

    private static boolean ak(y yVar) {
        char E = E(yVar, yVar.il());
        if (E != 9 && E != 10 && E != 12 && E != 13 && E != ' ') {
            return false;
        }
        yVar.fz(1);
        return true;
    }

    static void al(y yVar) {
        do {
        } while (!TextUtils.isEmpty(yVar.pJ()));
    }

    private static char E(y yVar, int i) {
        return (char) yVar.hO()[i];
    }

    private static String c(y yVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int il = yVar.il();
            String b = b(yVar, sb);
            if (b == null) {
                return null;
            }
            if ("}".equals(b) || ";".equals(b)) {
                yVar.fx(il);
                z = true;
            } else {
                sb2.append(b);
            }
        }
        return sb2.toString();
    }

    private static boolean am(y yVar) {
        int il = yVar.il();
        int pk = yVar.pk();
        byte[] hO = yVar.hO();
        if (il + 2 > pk) {
            return false;
        }
        int i = il + 1;
        if (hO[il] != 47) {
            return false;
        }
        int i2 = il + 2;
        if (hO[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= pk) {
                yVar.fz(pk - yVar.il());
                return true;
            } else if (((char) hO[i2]) == '*' && ((char) hO[i3]) == '/') {
                i2 += 2;
                pk = i2;
            } else {
                i2 = i3;
            }
        }
    }

    private static String d(y yVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int il = yVar.il();
        int pk = yVar.pk();
        while (il < pk && !z) {
            char c = (char) yVar.hO()[il];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                z = true;
            } else {
                il++;
                sb.append(c);
            }
        }
        yVar.fz(il - yVar.il());
        return sb.toString();
    }

    private static void a(String str, d dVar) {
        Matcher matcher = Tp.matcher(Ascii.toLowerCase(str));
        if (!matcher.matches()) {
            q.h("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) a.checkNotNull(matcher.group(2));
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals("%")) {
                    c = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals("em")) {
                    c = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals("px")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                dVar.eK(3);
                break;
            case 1:
                dVar.eK(2);
                break;
            case 2:
                dVar.eK(1);
                break;
            default:
                throw new IllegalStateException();
        }
        dVar.u(Float.parseFloat((String) a.checkNotNull(matcher.group(1))));
    }

    private void a(d dVar, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = To.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    dVar.ay((String) a.checkNotNull(matcher.group(1)));
                }
                str = str.substring(0, indexOf);
            }
            String[] l = ai.l(str, "\\.");
            String str2 = l[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                dVar.ax(str2.substring(0, indexOf2));
                dVar.aw(str2.substring(indexOf2 + 1));
            } else {
                dVar.ax(str2);
            }
            if (l.length > 1) {
                dVar.a((String[]) ai.a((T[]) l, 1, l.length));
            }
        }
    }
}
