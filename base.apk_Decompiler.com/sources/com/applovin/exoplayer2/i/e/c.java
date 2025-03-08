package com.applovin.exoplayer2.i.e;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class c {
    public final boolean Pn;
    public final int RC;
    public final Integer RD;
    public final float RE;
    public final boolean RF;
    public final boolean RG;
    public final boolean RH;
    public final String name;

    private static boolean eA(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private c(String str, int i, Integer num, float f, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.RC = i;
        this.RD = num;
        this.RE = f;
        this.RF = z;
        this.RG = z2;
        this.Pn = z3;
        this.RH = z4;
    }

    public static c a(String str, a aVar) {
        String str2 = str;
        a aVar2 = aVar;
        com.applovin.exoplayer2.l.a.checkArgument(str2.startsWith("Style:"));
        String[] split = TextUtils.split(str2.substring(6), ",");
        if (split.length != aVar2.fR) {
            q.h("SsaStyle", ai.a("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(aVar2.fR), Integer.valueOf(split.length), str2));
            return null;
        }
        try {
            return new c(split[aVar2.RI].trim(), aVar2.RJ != -1 ? ad(split[aVar2.RJ].trim()) : -1, aVar2.RK != -1 ? ae(split[aVar2.RK].trim()) : null, aVar2.RL != -1 ? af(split[aVar2.RL].trim()) : -3.4028235E38f, aVar2.RM != -1 && ag(split[aVar2.RM].trim()), aVar2.RN != -1 && ag(split[aVar2.RN].trim()), aVar2.RO != -1 && ag(split[aVar2.RO].trim()), aVar2.RP != -1 && ag(split[aVar2.RP].trim()));
        } catch (RuntimeException e) {
            q.b("SsaStyle", "Skipping malformed 'Style:' line: '" + str2 + "'", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static int ad(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (eA(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        q.h("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    public static Integer ae(String str) {
        long j;
        try {
            if (str.startsWith("&H")) {
                j = Long.parseLong(str.substring(2), 16);
            } else {
                j = Long.parseLong(str);
            }
            com.applovin.exoplayer2.l.a.checkArgument(j <= 4294967295L);
            return Integer.valueOf(Color.argb(com.applovin.exoplayer2.common.b.c.ad(((j >> 24) & 255) ^ 255), com.applovin.exoplayer2.common.b.c.ad(j & 255), com.applovin.exoplayer2.common.b.c.ad((j >> 8) & 255), com.applovin.exoplayer2.common.b.c.ad((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            q.b("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    private static float af(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            q.b("SsaStyle", "Failed to parse font size: '" + str + "'", e);
            return -3.4028235E38f;
        }
    }

    private static boolean ag(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e) {
            q.b("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }

    static final class a {
        public final int RI;
        public final int RJ;
        public final int RK;
        public final int RL;
        public final int RM;
        public final int RN;
        public final int RO;
        public final int RP;
        public final int fR;

        private a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.RI = i;
            this.RJ = i2;
            this.RK = i3;
            this.RL = i4;
            this.RM = i5;
            this.RN = i6;
            this.RO = i7;
            this.RP = i8;
            this.fR = i9;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.applovin.exoplayer2.i.e.c.a ai(java.lang.String r14) {
            /*
                r0 = 7
                java.lang.String r14 = r14.substring(r0)
                java.lang.String r1 = ","
                java.lang.String[] r14 = android.text.TextUtils.split(r14, r1)
                r1 = -1
                r2 = 0
                r3 = 0
                r5 = -1
                r6 = -1
                r7 = -1
                r8 = -1
                r9 = -1
                r10 = -1
                r11 = -1
                r12 = -1
            L_0x0016:
                int r4 = r14.length
                if (r3 >= r4) goto L_0x009e
                r4 = r14[r3]
                java.lang.String r4 = r4.trim()
                java.lang.String r4 = com.applovin.exoplayer2.common.base.Ascii.toLowerCase((java.lang.String) r4)
                r4.hashCode()
                int r13 = r4.hashCode()
                switch(r13) {
                    case -1178781136: goto L_0x007d;
                    case -1026963764: goto L_0x0072;
                    case -192095652: goto L_0x0067;
                    case -70925746: goto L_0x005c;
                    case 3029637: goto L_0x0051;
                    case 3373707: goto L_0x0046;
                    case 366554320: goto L_0x003b;
                    case 1767875043: goto L_0x0030;
                    default: goto L_0x002d;
                }
            L_0x002d:
                r4 = -1
                goto L_0x0087
            L_0x0030:
                java.lang.String r13 = "alignment"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0039
                goto L_0x002d
            L_0x0039:
                r4 = 7
                goto L_0x0087
            L_0x003b:
                java.lang.String r13 = "fontsize"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0044
                goto L_0x002d
            L_0x0044:
                r4 = 6
                goto L_0x0087
            L_0x0046:
                java.lang.String r13 = "name"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x004f
                goto L_0x002d
            L_0x004f:
                r4 = 5
                goto L_0x0087
            L_0x0051:
                java.lang.String r13 = "bold"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x005a
                goto L_0x002d
            L_0x005a:
                r4 = 4
                goto L_0x0087
            L_0x005c:
                java.lang.String r13 = "primarycolour"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0065
                goto L_0x002d
            L_0x0065:
                r4 = 3
                goto L_0x0087
            L_0x0067:
                java.lang.String r13 = "strikeout"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0070
                goto L_0x002d
            L_0x0070:
                r4 = 2
                goto L_0x0087
            L_0x0072:
                java.lang.String r13 = "underline"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x007b
                goto L_0x002d
            L_0x007b:
                r4 = 1
                goto L_0x0087
            L_0x007d:
                java.lang.String r13 = "italic"
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0086
                goto L_0x002d
            L_0x0086:
                r4 = 0
            L_0x0087:
                switch(r4) {
                    case 0: goto L_0x0099;
                    case 1: goto L_0x0097;
                    case 2: goto L_0x0095;
                    case 3: goto L_0x0093;
                    case 4: goto L_0x0091;
                    case 5: goto L_0x008f;
                    case 6: goto L_0x008d;
                    case 7: goto L_0x008b;
                    default: goto L_0x008a;
                }
            L_0x008a:
                goto L_0x009a
            L_0x008b:
                r6 = r3
                goto L_0x009a
            L_0x008d:
                r8 = r3
                goto L_0x009a
            L_0x008f:
                r5 = r3
                goto L_0x009a
            L_0x0091:
                r9 = r3
                goto L_0x009a
            L_0x0093:
                r7 = r3
                goto L_0x009a
            L_0x0095:
                r12 = r3
                goto L_0x009a
            L_0x0097:
                r11 = r3
                goto L_0x009a
            L_0x0099:
                r10 = r3
            L_0x009a:
                int r3 = r3 + 1
                goto L_0x0016
            L_0x009e:
                if (r5 == r1) goto L_0x00a8
                com.applovin.exoplayer2.i.e.c$a r0 = new com.applovin.exoplayer2.i.e.c$a
                int r13 = r14.length
                r4 = r0
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                goto L_0x00a9
            L_0x00a8:
                r0 = 0
            L_0x00a9:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.e.c.a.ai(java.lang.String):com.applovin.exoplayer2.i.e.c$a");
        }
    }

    static final class b {
        private static final Pattern RQ = Pattern.compile("\\{([^}]*)\\}");
        private static final Pattern RR = Pattern.compile(ai.a("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        private static final Pattern RT = Pattern.compile(ai.a("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        private static final Pattern RU = Pattern.compile("\\\\an(\\d+)");
        public final int RC;
        public final PointF RV;

        private b(int i, PointF pointF) {
            this.RC = i;
            this.RV = pointF;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|(1:7)|8|9|(2:11|18)(1:17)|15|1) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0021 */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0009 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.applovin.exoplayer2.i.e.c.b aj(java.lang.String r5) {
            /*
                java.util.regex.Pattern r0 = RQ
                java.util.regex.Matcher r5 = r0.matcher(r5)
                r0 = -1
                r1 = 0
                r2 = -1
            L_0x0009:
                boolean r3 = r5.find()
                if (r3 == 0) goto L_0x002b
                r3 = 1
                java.lang.String r3 = r5.group(r3)
                java.lang.Object r3 = com.applovin.exoplayer2.l.a.checkNotNull(r3)
                java.lang.String r3 = (java.lang.String) r3
                android.graphics.PointF r4 = al(r3)     // Catch:{ RuntimeException -> 0x0021 }
                if (r4 == 0) goto L_0x0021
                r1 = r4
            L_0x0021:
                int r3 = am(r3)     // Catch:{ RuntimeException -> 0x0029 }
                if (r3 == r0) goto L_0x0009
                r2 = r3
                goto L_0x0009
            L_0x0029:
                goto L_0x0009
            L_0x002b:
                com.applovin.exoplayer2.i.e.c$b r5 = new com.applovin.exoplayer2.i.e.c$b
                r5.<init>(r2, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.e.c.b.aj(java.lang.String):com.applovin.exoplayer2.i.e.c$b");
        }

        public static String ak(String str) {
            return RQ.matcher(str).replaceAll("");
        }

        private static PointF al(String str) {
            String str2;
            String str3;
            Matcher matcher = RR.matcher(str);
            Matcher matcher2 = RT.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    q.g("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                str2 = matcher.group(1);
                str3 = matcher.group(2);
            } else if (!find2) {
                return null;
            } else {
                str2 = matcher2.group(1);
                str3 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) com.applovin.exoplayer2.l.a.checkNotNull(str2)).trim()), Float.parseFloat(((String) com.applovin.exoplayer2.l.a.checkNotNull(str3)).trim()));
        }

        private static int am(String str) {
            Matcher matcher = RU.matcher(str);
            if (matcher.find()) {
                return c.ad((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1)));
            }
            return -1;
        }
    }
}
