package com.applovin.exoplayer2.i.f;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.applovin.exoplayer2.i.d;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.r;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends d {
    private static final Pattern RX = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern RY = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder RZ = new StringBuilder();
    private final ArrayList<String> Sa = new ArrayList<>();

    public a() {
        super("SubripDecoder");
    }

    /* access modifiers changed from: protected */
    public f c(byte[] bArr, int i, boolean z) {
        String str;
        ArrayList arrayList = new ArrayList();
        r rVar = new r();
        y yVar = new y(bArr, i);
        while (true) {
            String pJ = yVar.pJ();
            int i2 = 0;
            if (pJ == null) {
                break;
            } else if (pJ.length() != 0) {
                try {
                    Integer.parseInt(pJ);
                    String pJ2 = yVar.pJ();
                    if (pJ2 == null) {
                        q.h("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = RX.matcher(pJ2);
                    if (matcher.matches()) {
                        rVar.bo(a(matcher, 1));
                        rVar.bo(a(matcher, 6));
                        this.RZ.setLength(0);
                        this.Sa.clear();
                        for (String pJ3 = yVar.pJ(); !TextUtils.isEmpty(pJ3); pJ3 = yVar.pJ()) {
                            if (this.RZ.length() > 0) {
                                this.RZ.append("<br>");
                            }
                            this.RZ.append(a(pJ3, this.Sa));
                        }
                        Spanned fromHtml = Html.fromHtml(this.RZ.toString());
                        while (true) {
                            if (i2 >= this.Sa.size()) {
                                str = null;
                                break;
                            }
                            str = this.Sa.get(i2);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i2++;
                        }
                        arrayList.add(a(fromHtml, str));
                        arrayList.add(com.applovin.exoplayer2.i.a.NV);
                    } else {
                        q.h("SubripDecoder", "Skipping invalid timing: " + pJ2);
                    }
                } catch (NumberFormatException unused) {
                    q.h("SubripDecoder", "Skipping invalid index: " + pJ);
                }
            }
        }
        return new b((com.applovin.exoplayer2.i.a[]) arrayList.toArray(new com.applovin.exoplayer2.i.a[0]), rVar.pa());
    }

    private String a(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = RY.matcher(trim);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i;
            int length = group.length();
            sb.replace(start, start + length, "");
            i += length;
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.exoplayer2.i.a a(android.text.Spanned r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r18
            com.applovin.exoplayer2.i.a$a r1 = new com.applovin.exoplayer2.i.a$a
            r1.<init>()
            r2 = r17
            com.applovin.exoplayer2.i.a$a r1 = r1.m(r2)
            if (r0 != 0) goto L_0x0014
            com.applovin.exoplayer2.i.a r0 = r1.lU()
            return r0
        L_0x0014:
            int r2 = r18.hashCode()
            java.lang.String r6 = "{\\an9}"
            java.lang.String r7 = "{\\an8}"
            java.lang.String r8 = "{\\an7}"
            java.lang.String r9 = "{\\an6}"
            java.lang.String r10 = "{\\an5}"
            java.lang.String r11 = "{\\an4}"
            java.lang.String r12 = "{\\an3}"
            java.lang.String r13 = "{\\an2}"
            java.lang.String r14 = "{\\an1}"
            r4 = 4
            r5 = 3
            r15 = 2
            r3 = 1
            switch(r2) {
                case -685620710: goto L_0x0073;
                case -685620679: goto L_0x006b;
                case -685620648: goto L_0x0063;
                case -685620617: goto L_0x005b;
                case -685620586: goto L_0x0053;
                case -685620555: goto L_0x004b;
                case -685620524: goto L_0x0043;
                case -685620493: goto L_0x003a;
                case -685620462: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x007b
        L_0x0032:
            boolean r2 = r0.equals(r6)
            if (r2 == 0) goto L_0x007b
            r2 = 5
            goto L_0x007c
        L_0x003a:
            boolean r2 = r0.equals(r7)
            if (r2 == 0) goto L_0x007b
            r2 = 8
            goto L_0x007c
        L_0x0043:
            boolean r2 = r0.equals(r8)
            if (r2 == 0) goto L_0x007b
            r2 = 2
            goto L_0x007c
        L_0x004b:
            boolean r2 = r0.equals(r9)
            if (r2 == 0) goto L_0x007b
            r2 = 4
            goto L_0x007c
        L_0x0053:
            boolean r2 = r0.equals(r10)
            if (r2 == 0) goto L_0x007b
            r2 = 7
            goto L_0x007c
        L_0x005b:
            boolean r2 = r0.equals(r11)
            if (r2 == 0) goto L_0x007b
            r2 = 1
            goto L_0x007c
        L_0x0063:
            boolean r2 = r0.equals(r12)
            if (r2 == 0) goto L_0x007b
            r2 = 3
            goto L_0x007c
        L_0x006b:
            boolean r2 = r0.equals(r13)
            if (r2 == 0) goto L_0x007b
            r2 = 6
            goto L_0x007c
        L_0x0073:
            boolean r2 = r0.equals(r14)
            if (r2 == 0) goto L_0x007b
            r2 = 0
            goto L_0x007c
        L_0x007b:
            r2 = -1
        L_0x007c:
            if (r2 == 0) goto L_0x0091
            if (r2 == r3) goto L_0x0091
            if (r2 == r15) goto L_0x0091
            if (r2 == r5) goto L_0x008d
            if (r2 == r4) goto L_0x008d
            r4 = 5
            if (r2 == r4) goto L_0x008d
            r1.eg(r3)
            goto L_0x0095
        L_0x008d:
            r1.eg(r15)
            goto L_0x0095
        L_0x0091:
            r2 = 0
            r1.eg(r2)
        L_0x0095:
            int r2 = r18.hashCode()
            switch(r2) {
                case -685620710: goto L_0x00de;
                case -685620679: goto L_0x00d6;
                case -685620648: goto L_0x00ce;
                case -685620617: goto L_0x00c6;
                case -685620586: goto L_0x00be;
                case -685620555: goto L_0x00b5;
                case -685620524: goto L_0x00ad;
                case -685620493: goto L_0x00a5;
                case -685620462: goto L_0x009d;
                default: goto L_0x009c;
            }
        L_0x009c:
            goto L_0x00e6
        L_0x009d:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00e6
            r0 = 5
            goto L_0x00e7
        L_0x00a5:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00e6
            r0 = 4
            goto L_0x00e7
        L_0x00ad:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x00e6
            r0 = 3
            goto L_0x00e7
        L_0x00b5:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00e6
            r0 = 8
            goto L_0x00e7
        L_0x00be:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00e6
            r0 = 7
            goto L_0x00e7
        L_0x00c6:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x00e6
            r0 = 6
            goto L_0x00e7
        L_0x00ce:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00e6
            r0 = 2
            goto L_0x00e7
        L_0x00d6:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x00e6
            r0 = 1
            goto L_0x00e7
        L_0x00de:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x00e6
            r0 = 0
            goto L_0x00e7
        L_0x00e6:
            r0 = -1
        L_0x00e7:
            if (r0 == 0) goto L_0x00fe
            if (r0 == r3) goto L_0x00fe
            if (r0 == r15) goto L_0x00fe
            if (r0 == r5) goto L_0x00f9
            r2 = 4
            if (r0 == r2) goto L_0x00f9
            r2 = 5
            if (r0 == r2) goto L_0x00f9
            r1.ef(r3)
            goto L_0x0101
        L_0x00f9:
            r0 = 0
            r1.ef(r0)
            goto L_0x0101
        L_0x00fe:
            r1.ef(r15)
        L_0x0101:
            int r0 = r1.lS()
            float r0 = eB(r0)
            com.applovin.exoplayer2.i.a$a r0 = r1.o(r0)
            int r1 = r1.lR()
            float r1 = eB(r1)
            r2 = 0
            com.applovin.exoplayer2.i.a$a r0 = r0.b(r1, r2)
            com.applovin.exoplayer2.i.a r0 = r0.lU()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.f.a.a(android.text.Spanned, java.lang.String):com.applovin.exoplayer2.i.a");
    }

    private static long a(Matcher matcher, int i) {
        String group = matcher.group(i + 1);
        long parseLong = (group != null ? Long.parseLong(group) * 3600000 : 0) + (Long.parseLong((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(i + 2))) * 60000) + (Long.parseLong((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(i + 3))) * 1000);
        String group2 = matcher.group(i + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    static float eB(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }
}
