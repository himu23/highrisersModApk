package com.applovin.exoplayer2.i.g;

import android.text.Layout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.i.d;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.i.h;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.aj;
import com.applovin.exoplayer2.l.q;
import com.ironsource.jc;
import com.ironsource.m2;
import com.ironsource.w5;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class c extends d {
    private static final Pattern Si = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern Sj = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern Sk = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern Sl = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern Sm = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern Sn = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern So = Pattern.compile("^(\\d+) (\\d+)$");
    private static final b Sp = new b(30.0f, 1, 1);
    private static final a Sq = new a(32, 15);
    private final XmlPullParserFactory Sr;

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.Sr = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* access modifiers changed from: protected */
    public f c(byte[] bArr, int i, boolean z) throws h {
        b bVar;
        try {
            XmlPullParser newPullParser = this.Sr.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new e(""));
            C0056c cVar = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVar2 = Sp;
            a aVar = Sq;
            h hVar = null;
            int i2 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVar2 = d(newPullParser);
                            aVar = a(newPullParser, Sq);
                            cVar = e(newPullParser);
                        }
                        C0056c cVar2 = cVar;
                        b bVar3 = bVar2;
                        a aVar2 = aVar;
                        if (!aq(name)) {
                            q.g("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i2++;
                            bVar2 = bVar3;
                        } else {
                            if ("head".equals(name)) {
                                bVar = bVar3;
                                a(newPullParser, hashMap, aVar2, cVar2, hashMap2, hashMap3);
                            } else {
                                bVar = bVar3;
                                try {
                                    d a2 = a(newPullParser, dVar, hashMap2, bVar);
                                    arrayDeque.push(a2);
                                    if (dVar != null) {
                                        dVar.a(a2);
                                    }
                                } catch (h e) {
                                    q.b("TtmlDecoder", "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            bVar2 = bVar;
                        }
                        cVar = cVar2;
                        aVar = aVar2;
                    } else if (eventType == 4) {
                        ((d) com.applovin.exoplayer2.l.a.checkNotNull(dVar)).a(d.as(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            hVar = new h((d) com.applovin.exoplayer2.l.a.checkNotNull((d) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (hVar != null) {
                return hVar;
            }
            throw new h("No TTML subtitles found");
        } catch (XmlPullParserException e2) {
            throw new h("Unable to decode source", e2);
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        }
    }

    private static b d(XmlPullParser xmlPullParser) throws h {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] l = ai.l(attributeValue2, " ");
            if (l.length == 2) {
                f = ((float) Integer.parseInt(l[0])) / ((float) Integer.parseInt(l[1]));
            } else {
                throw new h("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f = 1.0f;
        }
        b bVar = Sp;
        int i = bVar.Sv;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = bVar.Sw;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new b(((float) parseInt) * f, i, i2);
    }

    private static a a(XmlPullParser xmlPullParser, a aVar) throws h {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = So.matcher(attributeValue);
        if (!matcher.matches()) {
            q.h("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new a(parseInt, parseInt2);
            }
            throw new h("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            q.h("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    private static C0056c e(XmlPullParser xmlPullParser) {
        String c = aj.c(xmlPullParser, "extent");
        if (c == null) {
            return null;
        }
        Matcher matcher = Sn.matcher(c);
        if (!matcher.matches()) {
            q.h("TtmlDecoder", "Ignoring non-pixel tts extent: " + c);
            return null;
        }
        try {
            return new C0056c(Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1))), Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            q.h("TtmlDecoder", "Ignoring malformed tts extent: " + c);
            return null;
        }
    }

    private static Map<String, g> a(XmlPullParser xmlPullParser, Map<String, g> map, a aVar, C0056c cVar, Map<String, e> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (aj.b(xmlPullParser, "style")) {
                String c = aj.c(xmlPullParser, "style");
                g a2 = a(xmlPullParser, new g());
                if (c != null) {
                    for (String str : ao(c)) {
                        a2.b(map.get(str));
                    }
                }
                String mQ = a2.mQ();
                if (mQ != null) {
                    map.put(mQ, a2);
                }
            } else if (aj.b(xmlPullParser, "region")) {
                e a3 = a(xmlPullParser, aVar, cVar);
                if (a3 != null) {
                    map2.put(a3.f6do, a3);
                }
            } else if (aj.b(xmlPullParser, jc.l1)) {
                a(xmlPullParser, map3);
            }
        } while (!aj.a(xmlPullParser, "head"));
        return map;
    }

    private static void a(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String c;
        do {
            xmlPullParser.next();
            if (aj.b(xmlPullParser, "image") && (c = aj.c(xmlPullParser, w5.x)) != null) {
                map.put(c, xmlPullParser.nextText());
            }
        } while (!aj.a(xmlPullParser, jc.l1));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x019d, code lost:
        if (r0.equals("tb") == false) goto L_0x017f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0170  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.exoplayer2.i.g.e a(org.xmlpull.v1.XmlPullParser r17, com.applovin.exoplayer2.i.g.c.a r18, com.applovin.exoplayer2.i.g.c.C0056c r19) {
        /*
            r0 = r17
            r1 = r19
            java.lang.String r2 = "id"
            java.lang.String r4 = com.applovin.exoplayer2.l.aj.c(r0, r2)
            r2 = 0
            if (r4 != 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.String r3 = "origin"
            java.lang.String r3 = com.applovin.exoplayer2.l.aj.c(r0, r3)
            java.lang.String r5 = "TtmlDecoder"
            if (r3 == 0) goto L_0x0202
            java.util.regex.Pattern r6 = Sm
            java.util.regex.Matcher r7 = r6.matcher(r3)
            java.util.regex.Pattern r8 = Sn
            java.util.regex.Matcher r9 = r8.matcher(r3)
            boolean r10 = r7.matches()
            java.lang.String r11 = "Ignoring region with malformed origin: "
            java.lang.String r12 = "Ignoring region with missing tts:extent: "
            r13 = 1120403456(0x42c80000, float:100.0)
            r14 = 2
            r15 = 1
            if (r10 == 0) goto L_0x0066
            java.lang.String r9 = r7.group(r15)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.Object r9 = com.applovin.exoplayer2.l.a.checkNotNull(r9)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x0056 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0056 }
            float r9 = r9 / r13
            java.lang.String r7 = r7.group(r14)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.Object r7 = com.applovin.exoplayer2.l.a.checkNotNull(r7)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x0056 }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ NumberFormatException -> 0x0056 }
            float r7 = r7 / r13
            r16 = r9
            r9 = r7
            r7 = r16
            goto L_0x00a4
        L_0x0056:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        L_0x0066:
            boolean r7 = r9.matches()
            if (r7 == 0) goto L_0x01f0
            if (r1 != 0) goto L_0x007e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        L_0x007e:
            java.lang.String r7 = r9.group(r15)     // Catch:{ NumberFormatException -> 0x01e0 }
            java.lang.Object r7 = com.applovin.exoplayer2.l.a.checkNotNull(r7)     // Catch:{ NumberFormatException -> 0x01e0 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x01e0 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x01e0 }
            java.lang.String r9 = r9.group(r14)     // Catch:{ NumberFormatException -> 0x01e0 }
            java.lang.Object r9 = com.applovin.exoplayer2.l.a.checkNotNull(r9)     // Catch:{ NumberFormatException -> 0x01e0 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x01e0 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x01e0 }
            float r7 = (float) r7     // Catch:{ NumberFormatException -> 0x01e0 }
            int r10 = r1.dE     // Catch:{ NumberFormatException -> 0x01e0 }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x01e0 }
            float r7 = r7 / r10
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x01e0 }
            int r10 = r1.height     // Catch:{ NumberFormatException -> 0x01e0 }
            float r10 = (float) r10
            float r9 = r9 / r10
        L_0x00a4:
            java.lang.String r10 = "extent"
            java.lang.String r10 = com.applovin.exoplayer2.l.aj.c(r0, r10)
            if (r10 == 0) goto L_0x01da
            java.util.regex.Matcher r6 = r6.matcher(r10)
            java.util.regex.Matcher r8 = r8.matcher(r10)
            boolean r10 = r6.matches()
            java.lang.String r11 = "Ignoring region with malformed extent: "
            if (r10 == 0) goto L_0x00ec
            java.lang.String r1 = r6.group(r15)     // Catch:{ NumberFormatException -> 0x00dc }
            java.lang.Object r1 = com.applovin.exoplayer2.l.a.checkNotNull(r1)     // Catch:{ NumberFormatException -> 0x00dc }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x00dc }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x00dc }
            float r1 = r1 / r13
            java.lang.String r6 = r6.group(r14)     // Catch:{ NumberFormatException -> 0x00dc }
            java.lang.Object r6 = com.applovin.exoplayer2.l.a.checkNotNull(r6)     // Catch:{ NumberFormatException -> 0x00dc }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x00dc }
            float r2 = java.lang.Float.parseFloat(r6)     // Catch:{ NumberFormatException -> 0x00dc }
            float r2 = r2 / r13
            r10 = r2
            goto L_0x012c
        L_0x00dc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        L_0x00ec:
            boolean r6 = r8.matches()
            if (r6 == 0) goto L_0x01c8
            if (r1 != 0) goto L_0x0104
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        L_0x0104:
            java.lang.String r6 = r8.group(r15)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.Object r6 = com.applovin.exoplayer2.l.a.checkNotNull(r6)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x01b8 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r8 = r8.group(r14)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.Object r8 = com.applovin.exoplayer2.l.a.checkNotNull(r8)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NumberFormatException -> 0x01b8 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x01b8 }
            float r6 = (float) r6     // Catch:{ NumberFormatException -> 0x01b8 }
            int r10 = r1.dE     // Catch:{ NumberFormatException -> 0x01b8 }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x01b8 }
            float r6 = r6 / r10
            float r8 = (float) r8     // Catch:{ NumberFormatException -> 0x01b8 }
            int r1 = r1.height     // Catch:{ NumberFormatException -> 0x01b8 }
            float r1 = (float) r1
            float r8 = r8 / r1
            r1 = r6
            r10 = r8
        L_0x012c:
            java.lang.String r2 = "displayAlign"
            java.lang.String r2 = com.applovin.exoplayer2.l.aj.c(r0, r2)
            r3 = 0
            if (r2 == 0) goto L_0x015d
            java.lang.String r2 = com.applovin.exoplayer2.common.base.Ascii.toLowerCase((java.lang.String) r2)
            r2.hashCode()
            java.lang.String r5 = "center"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0153
            java.lang.String r5 = "after"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x014d
            goto L_0x015d
        L_0x014d:
            float r9 = r9 + r10
            r2 = r18
            r6 = r9
            r8 = 2
            goto L_0x0161
        L_0x0153:
            r2 = 1073741824(0x40000000, float:2.0)
            float r2 = r10 / r2
            float r9 = r9 + r2
            r2 = r18
            r6 = r9
            r8 = 1
            goto L_0x0161
        L_0x015d:
            r2 = r18
            r6 = r9
            r8 = 0
        L_0x0161:
            int r2 = r2.St
            float r2 = (float) r2
            r5 = 1065353216(0x3f800000, float:1.0)
            float r12 = r5 / r2
            java.lang.String r2 = "writingMode"
            java.lang.String r0 = com.applovin.exoplayer2.l.aj.c(r0, r2)
            if (r0 == 0) goto L_0x01a8
            java.lang.String r0 = com.applovin.exoplayer2.common.base.Ascii.toLowerCase((java.lang.String) r0)
            r0.hashCode()
            int r2 = r0.hashCode()
            r5 = -1
            switch(r2) {
                case 3694: goto L_0x0197;
                case 3553396: goto L_0x018c;
                case 3553576: goto L_0x0181;
                default: goto L_0x017f;
            }
        L_0x017f:
            r3 = -1
            goto L_0x01a0
        L_0x0181:
            java.lang.String r2 = "tbrl"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x018a
            goto L_0x017f
        L_0x018a:
            r3 = 2
            goto L_0x01a0
        L_0x018c:
            java.lang.String r2 = "tblr"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0195
            goto L_0x017f
        L_0x0195:
            r3 = 1
            goto L_0x01a0
        L_0x0197:
            java.lang.String r2 = "tb"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01a0
            goto L_0x017f
        L_0x01a0:
            switch(r3) {
                case 0: goto L_0x01a6;
                case 1: goto L_0x01a6;
                case 2: goto L_0x01a4;
                default: goto L_0x01a3;
            }
        L_0x01a3:
            goto L_0x01a8
        L_0x01a4:
            r13 = 1
            goto L_0x01ac
        L_0x01a6:
            r13 = 2
            goto L_0x01ac
        L_0x01a8:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x01ac:
            com.applovin.exoplayer2.i.g.e r0 = new com.applovin.exoplayer2.i.g.e
            r2 = 0
            r11 = 1
            r3 = r0
            r5 = r7
            r7 = r2
            r9 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x01b8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        L_0x01c8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Ignoring region with unsupported extent: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        L_0x01da:
            java.lang.String r0 = "Ignoring region without an extent"
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        L_0x01e0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        L_0x01f0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Ignoring region with unsupported origin: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        L_0x0202:
            java.lang.String r0 = "Ignoring region without an origin"
            com.applovin.exoplayer2.l.q.h(r5, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.g.c.a(org.xmlpull.v1.XmlPullParser, com.applovin.exoplayer2.i.g.c$a, com.applovin.exoplayer2.i.g.c$c):com.applovin.exoplayer2.i.g.e");
    }

    private static String[] ao(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : ai.l(trim, "\\s+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01d7, code lost:
        if (r3.equals(com.ironsource.m2.h.K0) == false) goto L_0x01cf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.exoplayer2.i.g.g a(org.xmlpull.v1.XmlPullParser r12, com.applovin.exoplayer2.i.g.g r13) {
        /*
            int r0 = r12.getAttributeCount()
            r1 = 0
            r2 = 0
        L_0x0006:
            if (r2 >= r0) goto L_0x02ed
            java.lang.String r3 = r12.getAttributeValue(r2)
            java.lang.String r4 = r12.getAttributeName(r2)
            r4.hashCode()
            int r5 = r4.hashCode()
            r6 = 5
            r7 = 4
            r8 = -1
            r9 = 3
            r10 = 2
            r11 = 1
            switch(r5) {
                case -1550943582: goto L_0x00cf;
                case -1224696685: goto L_0x00c3;
                case -1065511464: goto L_0x00b7;
                case -879295043: goto L_0x00ab;
                case -734428249: goto L_0x009f;
                case 3355: goto L_0x0094;
                case 3511770: goto L_0x0089;
                case 94842723: goto L_0x007e;
                case 109403361: goto L_0x0071;
                case 110138194: goto L_0x0064;
                case 365601008: goto L_0x0057;
                case 921125321: goto L_0x004a;
                case 1115953443: goto L_0x003d;
                case 1287124693: goto L_0x0030;
                case 1754920356: goto L_0x0023;
                default: goto L_0x0020;
            }
        L_0x0020:
            r4 = -1
            goto L_0x00da
        L_0x0023:
            java.lang.String r5 = "multiRowAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x002c
            goto L_0x0020
        L_0x002c:
            r4 = 14
            goto L_0x00da
        L_0x0030:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0039
            goto L_0x0020
        L_0x0039:
            r4 = 13
            goto L_0x00da
        L_0x003d:
            java.lang.String r5 = "rubyPosition"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0046
            goto L_0x0020
        L_0x0046:
            r4 = 12
            goto L_0x00da
        L_0x004a:
            java.lang.String r5 = "textEmphasis"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0053
            goto L_0x0020
        L_0x0053:
            r4 = 11
            goto L_0x00da
        L_0x0057:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0060
            goto L_0x0020
        L_0x0060:
            r4 = 10
            goto L_0x00da
        L_0x0064:
            java.lang.String r5 = "textCombine"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x006d
            goto L_0x0020
        L_0x006d:
            r4 = 9
            goto L_0x00da
        L_0x0071:
            java.lang.String r5 = "shear"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x007a
            goto L_0x0020
        L_0x007a:
            r4 = 8
            goto L_0x00da
        L_0x007e:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0087
            goto L_0x0020
        L_0x0087:
            r4 = 7
            goto L_0x00da
        L_0x0089:
            java.lang.String r5 = "ruby"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0092
            goto L_0x0020
        L_0x0092:
            r4 = 6
            goto L_0x00da
        L_0x0094:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x009d
            goto L_0x0020
        L_0x009d:
            r4 = 5
            goto L_0x00da
        L_0x009f:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00a9
            goto L_0x0020
        L_0x00a9:
            r4 = 4
            goto L_0x00da
        L_0x00ab:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00b5
            goto L_0x0020
        L_0x00b5:
            r4 = 3
            goto L_0x00da
        L_0x00b7:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00c1
            goto L_0x0020
        L_0x00c1:
            r4 = 2
            goto L_0x00da
        L_0x00c3:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00cd
            goto L_0x0020
        L_0x00cd:
            r4 = 1
            goto L_0x00da
        L_0x00cf:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00d9
            goto L_0x0020
        L_0x00d9:
            r4 = 0
        L_0x00da:
            java.lang.String r5 = "TtmlDecoder"
            switch(r4) {
                case 0: goto L_0x02db;
                case 1: goto L_0x02d2;
                case 2: goto L_0x02c5;
                case 3: goto L_0x0263;
                case 4: goto L_0x0253;
                case 5: goto L_0x023d;
                case 6: goto L_0x01c1;
                case 7: goto L_0x01a1;
                case 8: goto L_0x0193;
                case 9: goto L_0x0166;
                case 10: goto L_0x014a;
                case 11: goto L_0x013c;
                case 12: goto L_0x010f;
                case 13: goto L_0x00ef;
                case 14: goto L_0x00e1;
                default: goto L_0x00df;
            }
        L_0x00df:
            goto L_0x02e9
        L_0x00e1:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            android.text.Layout$Alignment r3 = ap(r3)
            com.applovin.exoplayer2.i.g.g r13 = r13.d(r3)
            goto L_0x02e9
        L_0x00ef:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            int r4 = com.applovin.exoplayer2.l.f.aS(r3)     // Catch:{ IllegalArgumentException -> 0x00fc }
            r13.eE(r4)     // Catch:{ IllegalArgumentException -> 0x00fc }
            goto L_0x02e9
        L_0x00fc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed parsing background value: "
            r4.<init>(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.applovin.exoplayer2.l.q.h(r5, r3)
            goto L_0x02e9
        L_0x010f:
            java.lang.String r3 = com.applovin.exoplayer2.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            java.lang.String r4 = "before"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0132
            java.lang.String r4 = "after"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0128
            goto L_0x02e9
        L_0x0128:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.eG(r10)
            goto L_0x02e9
        L_0x0132:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.eG(r11)
            goto L_0x02e9
        L_0x013c:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.b r3 = com.applovin.exoplayer2.i.g.b.an(r3)
            com.applovin.exoplayer2.i.g.g r13 = r13.a(r3)
            goto L_0x02e9
        L_0x014a:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)     // Catch:{ h -> 0x0153 }
            a((java.lang.String) r3, (com.applovin.exoplayer2.i.g.g) r13)     // Catch:{ h -> 0x0153 }
            goto L_0x02e9
        L_0x0153:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed parsing fontSize value: "
            r4.<init>(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.applovin.exoplayer2.l.q.h(r5, r3)
            goto L_0x02e9
        L_0x0166:
            java.lang.String r3 = com.applovin.exoplayer2.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            java.lang.String r4 = "all"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0189
            java.lang.String r4 = "none"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x017f
            goto L_0x02e9
        L_0x017f:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.W(r1)
            goto L_0x02e9
        L_0x0189:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.W(r11)
            goto L_0x02e9
        L_0x0193:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            float r3 = ar(r3)
            com.applovin.exoplayer2.i.g.g r13 = r13.s(r3)
            goto L_0x02e9
        L_0x01a1:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            int r4 = com.applovin.exoplayer2.l.f.aS(r3)     // Catch:{ IllegalArgumentException -> 0x01ae }
            r13.eD(r4)     // Catch:{ IllegalArgumentException -> 0x01ae }
            goto L_0x02e9
        L_0x01ae:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed parsing color value: "
            r4.<init>(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.applovin.exoplayer2.l.q.h(r5, r3)
            goto L_0x02e9
        L_0x01c1:
            java.lang.String r3 = com.applovin.exoplayer2.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -618561360: goto L_0x0206;
                case -410956671: goto L_0x01fb;
                case -250518009: goto L_0x01f0;
                case -136074796: goto L_0x01e5;
                case 3016401: goto L_0x01da;
                case 3556653: goto L_0x01d1;
                default: goto L_0x01cf;
            }
        L_0x01cf:
            r6 = -1
            goto L_0x0210
        L_0x01d1:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0210
            goto L_0x01cf
        L_0x01da:
            java.lang.String r4 = "base"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01e3
            goto L_0x01cf
        L_0x01e3:
            r6 = 4
            goto L_0x0210
        L_0x01e5:
            java.lang.String r4 = "textContainer"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01ee
            goto L_0x01cf
        L_0x01ee:
            r6 = 3
            goto L_0x0210
        L_0x01f0:
            java.lang.String r4 = "delimiter"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01f9
            goto L_0x01cf
        L_0x01f9:
            r6 = 2
            goto L_0x0210
        L_0x01fb:
            java.lang.String r4 = "container"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0204
            goto L_0x01cf
        L_0x0204:
            r6 = 1
            goto L_0x0210
        L_0x0206:
            java.lang.String r4 = "baseContainer"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x020f
            goto L_0x01cf
        L_0x020f:
            r6 = 0
        L_0x0210:
            switch(r6) {
                case 0: goto L_0x0233;
                case 1: goto L_0x0229;
                case 2: goto L_0x021f;
                case 3: goto L_0x0215;
                case 4: goto L_0x0233;
                case 5: goto L_0x0215;
                default: goto L_0x0213;
            }
        L_0x0213:
            goto L_0x02e9
        L_0x0215:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.eF(r9)
            goto L_0x02e9
        L_0x021f:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.eF(r7)
            goto L_0x02e9
        L_0x0229:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.eF(r11)
            goto L_0x02e9
        L_0x0233:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.eF(r10)
            goto L_0x02e9
        L_0x023d:
            java.lang.String r4 = "style"
            java.lang.String r5 = r12.getName()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x02e9
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.av(r3)
            goto L_0x02e9
        L_0x0253:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.applovin.exoplayer2.i.g.g r13 = r13.U(r3)
            goto L_0x02e9
        L_0x0263:
            java.lang.String r3 = com.applovin.exoplayer2.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x0293;
                case -1026963764: goto L_0x0288;
                case 913457136: goto L_0x027d;
                case 1679736913: goto L_0x0272;
                default: goto L_0x0271;
            }
        L_0x0271:
            goto L_0x029d
        L_0x0272:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x027b
            goto L_0x029d
        L_0x027b:
            r8 = 3
            goto L_0x029d
        L_0x027d:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0286
            goto L_0x029d
        L_0x0286:
            r8 = 2
            goto L_0x029d
        L_0x0288:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0291
            goto L_0x029d
        L_0x0291:
            r8 = 1
            goto L_0x029d
        L_0x0293:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x029c
            goto L_0x029d
        L_0x029c:
            r8 = 0
        L_0x029d:
            switch(r8) {
                case 0: goto L_0x02bc;
                case 1: goto L_0x02b3;
                case 2: goto L_0x02aa;
                case 3: goto L_0x02a1;
                default: goto L_0x02a0;
            }
        L_0x02a0:
            goto L_0x02e9
        L_0x02a1:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.S(r11)
            goto L_0x02e9
        L_0x02aa:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.S(r1)
            goto L_0x02e9
        L_0x02b3:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.T(r11)
            goto L_0x02e9
        L_0x02bc:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.T(r1)
            goto L_0x02e9
        L_0x02c5:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            android.text.Layout$Alignment r3 = ap(r3)
            com.applovin.exoplayer2.i.g.g r13 = r13.c(r3)
            goto L_0x02e9
        L_0x02d2:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            com.applovin.exoplayer2.i.g.g r13 = r13.au(r3)
            goto L_0x02e9
        L_0x02db:
            com.applovin.exoplayer2.i.g.g r13 = a(r13)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.applovin.exoplayer2.i.g.g r13 = r13.V(r3)
        L_0x02e9:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x02ed:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.g.c.a(org.xmlpull.v1.XmlPullParser, com.applovin.exoplayer2.i.g.g):com.applovin.exoplayer2.i.g.g");
    }

    private static g a(g gVar) {
        return gVar == null ? new g() : gVar;
    }

    private static Layout.Alignment ap(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.hashCode();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1364013995:
                if (lowerCase.equals("center")) {
                    c = 0;
                    break;
                }
                break;
            case 100571:
                if (lowerCase.equals("end")) {
                    c = 1;
                    break;
                }
                break;
            case 3317767:
                if (lowerCase.equals("left")) {
                    c = 2;
                    break;
                }
                break;
            case 108511772:
                if (lowerCase.equals("right")) {
                    c = 3;
                    break;
                }
                break;
            case 109757538:
                if (lowerCase.equals("start")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.exoplayer2.i.g.d a(org.xmlpull.v1.XmlPullParser r20, com.applovin.exoplayer2.i.g.d r21, java.util.Map<java.lang.String, com.applovin.exoplayer2.i.g.e> r22, com.applovin.exoplayer2.i.g.c.b r23) throws com.applovin.exoplayer2.i.h {
        /*
            r0 = r20
            r9 = r21
            r1 = r23
            int r2 = r20.getAttributeCount()
            r3 = 0
            com.applovin.exoplayer2.i.g.g r5 = a((org.xmlpull.v1.XmlPullParser) r0, (com.applovin.exoplayer2.i.g.g) r3)
            java.lang.String r4 = ""
            r10 = r3
            r12 = r10
            r11 = r4
            r3 = 0
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0024:
            if (r3 >= r2) goto L_0x00b4
            java.lang.String r4 = r0.getAttributeName(r3)
            java.lang.String r8 = r0.getAttributeValue(r3)
            r4.hashCode()
            int r19 = r4.hashCode()
            r6 = 1
            switch(r19) {
                case -934795532: goto L_0x0072;
                case 99841: goto L_0x0067;
                case 100571: goto L_0x005c;
                case 93616297: goto L_0x0051;
                case 109780401: goto L_0x0046;
                case 1292595405: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            r7 = -1
            goto L_0x007c
        L_0x003b:
            java.lang.String r7 = "backgroundImage"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0044
            goto L_0x0039
        L_0x0044:
            r7 = 5
            goto L_0x007c
        L_0x0046:
            java.lang.String r7 = "style"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x004f
            goto L_0x0039
        L_0x004f:
            r7 = 4
            goto L_0x007c
        L_0x0051:
            java.lang.String r7 = "begin"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x005a
            goto L_0x0039
        L_0x005a:
            r7 = 3
            goto L_0x007c
        L_0x005c:
            java.lang.String r7 = "end"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0065
            goto L_0x0039
        L_0x0065:
            r7 = 2
            goto L_0x007c
        L_0x0067:
            java.lang.String r7 = "dur"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0070
            goto L_0x0039
        L_0x0070:
            r7 = 1
            goto L_0x007c
        L_0x0072:
            java.lang.String r7 = "region"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x007b
            goto L_0x0039
        L_0x007b:
            r7 = 0
        L_0x007c:
            switch(r7) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x00a2;
                case 2: goto L_0x009d;
                case 3: goto L_0x0096;
                case 4: goto L_0x008d;
                case 5: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x009a
        L_0x0080:
            java.lang.String r4 = "#"
            boolean r4 = r8.startsWith(r4)
            if (r4 == 0) goto L_0x009a
            java.lang.String r12 = r8.substring(r6)
            goto L_0x009a
        L_0x008d:
            java.lang.String[] r4 = ao(r8)
            int r6 = r4.length
            if (r6 <= 0) goto L_0x009a
            r10 = r4
            goto L_0x009a
        L_0x0096:
            long r13 = a((java.lang.String) r8, (com.applovin.exoplayer2.i.g.c.b) r1)
        L_0x009a:
            r4 = r22
            goto L_0x00b0
        L_0x009d:
            long r15 = a((java.lang.String) r8, (com.applovin.exoplayer2.i.g.c.b) r1)
            goto L_0x009a
        L_0x00a2:
            long r17 = a((java.lang.String) r8, (com.applovin.exoplayer2.i.g.c.b) r1)
            goto L_0x009a
        L_0x00a7:
            r4 = r22
            boolean r6 = r4.containsKey(r8)
            if (r6 == 0) goto L_0x00b0
            r11 = r8
        L_0x00b0:
            int r3 = r3 + 1
            goto L_0x0024
        L_0x00b4:
            if (r9 == 0) goto L_0x00d0
            long r1 = r9.Gi
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00d5
            int r1 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00c8
            long r1 = r9.Gi
            long r13 = r13 + r1
        L_0x00c8:
            int r1 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00d5
            long r1 = r9.Gi
            long r15 = r15 + r1
            goto L_0x00d5
        L_0x00d0:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00d5:
            r1 = r13
            int r6 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x00ee
            int r6 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00e3
            long r17 = r1 + r17
            r3 = r17
            goto L_0x00ef
        L_0x00e3:
            if (r9 == 0) goto L_0x00ee
            long r6 = r9.Sy
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 == 0) goto L_0x00ee
            long r3 = r9.Sy
            goto L_0x00ef
        L_0x00ee:
            r3 = r15
        L_0x00ef:
            java.lang.String r0 = r20.getName()
            r6 = r10
            r7 = r11
            r8 = r12
            r9 = r21
            com.applovin.exoplayer2.i.g.d r0 = com.applovin.exoplayer2.i.g.d.a(r0, r1, r3, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.g.c.a(org.xmlpull.v1.XmlPullParser, com.applovin.exoplayer2.i.g.d, java.util.Map, com.applovin.exoplayer2.i.g.c$b):com.applovin.exoplayer2.i.g.d");
    }

    private static boolean aq(String str) {
        return str.equals("tt") || str.equals("head") || str.equals(m2.h.E0) || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals(jc.l1) || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static void a(String str, g gVar) throws h {
        Matcher matcher;
        String[] l = ai.l(str, "\\s+");
        if (l.length == 1) {
            matcher = Sk.matcher(str);
        } else if (l.length == 2) {
            matcher = Sk.matcher(l[1]);
            q.h("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new h("Invalid number of entries for fontSize: " + l.length + ".");
        }
        if (matcher.matches()) {
            String str2 = (String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(3));
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
                    gVar.eH(3);
                    break;
                case 1:
                    gVar.eH(2);
                    break;
                case 2:
                    gVar.eH(1);
                    break;
                default:
                    throw new h("Invalid unit for fontSize: '" + str2 + "'.");
            }
            gVar.t(Float.parseFloat((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1))));
            return;
        }
        throw new h("Invalid expression for fontSize: '" + str + "'.");
    }

    private static float ar(String str) {
        Matcher matcher = Sl.matcher(str);
        if (!matcher.matches()) {
            q.h("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(1)))));
        } catch (NumberFormatException e) {
            q.b("TtmlDecoder", "Failed to parse shear: " + str, e);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00bf, code lost:
        if (r13.equals("ms") == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f6, code lost:
        r8 = r8 / r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0104, code lost:
        r8 = r8 * r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(java.lang.String r13, com.applovin.exoplayer2.i.g.c.b r14) throws com.applovin.exoplayer2.i.h {
        /*
            java.util.regex.Pattern r0 = Si
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0088
            java.lang.String r13 = r0.group(r7)
            java.lang.Object r13 = com.applovin.exoplayer2.l.a.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r7 = java.lang.Long.parseLong(r13)
            r9 = 3600(0xe10, double:1.7786E-320)
            long r7 = r7 * r9
            double r7 = (double) r7
            java.lang.String r13 = r0.group(r6)
            java.lang.Object r13 = com.applovin.exoplayer2.l.a.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r5)
            java.lang.Object r13 = com.applovin.exoplayer2.l.a.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r5 = java.lang.Long.parseLong(r13)
            double r5 = (double) r5
            double r7 = r7 + r5
            java.lang.String r13 = r0.group(r4)
            r4 = 0
            if (r13 == 0) goto L_0x0059
            double r9 = java.lang.Double.parseDouble(r13)
            goto L_0x005a
        L_0x0059:
            r9 = r4
        L_0x005a:
            double r7 = r7 + r9
            r13 = 5
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x006c
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r1 = r14.Su
            float r13 = r13 / r1
            double r9 = (double) r13
            goto L_0x006d
        L_0x006c:
            r9 = r4
        L_0x006d:
            double r7 = r7 + r9
            r13 = 6
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0083
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.Sv
            double r4 = (double) r13
            double r0 = r0 / r4
            float r13 = r14.Su
            double r13 = (double) r13
            double r4 = r0 / r13
        L_0x0083:
            double r7 = r7 + r4
            double r7 = r7 * r2
            long r13 = (long) r7
            return r13
        L_0x0088:
            java.util.regex.Pattern r0 = Sj
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x010f
            java.lang.String r13 = r0.group(r7)
            java.lang.Object r13 = com.applovin.exoplayer2.l.a.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            double r8 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r0.group(r6)
            java.lang.Object r13 = com.applovin.exoplayer2.l.a.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            r13.hashCode()
            int r0 = r13.hashCode()
            r1 = -1
            switch(r0) {
                case 102: goto L_0x00e3;
                case 104: goto L_0x00d8;
                case 109: goto L_0x00cd;
                case 116: goto L_0x00c2;
                case 3494: goto L_0x00b9;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            r4 = -1
            goto L_0x00ed
        L_0x00b9:
            java.lang.String r0 = "ms"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ed
            goto L_0x00b7
        L_0x00c2:
            java.lang.String r0 = "t"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00cb
            goto L_0x00b7
        L_0x00cb:
            r4 = 3
            goto L_0x00ed
        L_0x00cd:
            java.lang.String r0 = "m"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00d6
            goto L_0x00b7
        L_0x00d6:
            r4 = 2
            goto L_0x00ed
        L_0x00d8:
            java.lang.String r0 = "h"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00e1
            goto L_0x00b7
        L_0x00e1:
            r4 = 1
            goto L_0x00ed
        L_0x00e3:
            java.lang.String r0 = "f"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ec
            goto L_0x00b7
        L_0x00ec:
            r4 = 0
        L_0x00ed:
            switch(r4) {
                case 0: goto L_0x0107;
                case 1: goto L_0x00ff;
                case 2: goto L_0x00fc;
                case 3: goto L_0x00f8;
                case 4: goto L_0x00f1;
                default: goto L_0x00f0;
            }
        L_0x00f0:
            goto L_0x010b
        L_0x00f1:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x00f6:
            double r8 = r8 / r13
            goto L_0x010b
        L_0x00f8:
            int r13 = r14.Sw
            double r13 = (double) r13
            goto L_0x00f6
        L_0x00fc:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x0104
        L_0x00ff:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x0104:
            double r8 = r8 * r13
            goto L_0x010b
        L_0x0107:
            float r13 = r14.Su
            double r13 = (double) r13
            goto L_0x00f6
        L_0x010b:
            double r8 = r8 * r2
            long r13 = (long) r8
            return r13
        L_0x010f:
            com.applovin.exoplayer2.i.h r14 = new com.applovin.exoplayer2.i.h
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Malformed time expression: "
            r0.<init>(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r14.<init>((java.lang.String) r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.g.c.a(java.lang.String, com.applovin.exoplayer2.i.g.c$b):long");
    }

    private static final class b {
        final float Su;
        final int Sv;
        final int Sw;

        b(float f, int i, int i2) {
            this.Su = f;
            this.Sv = i;
            this.Sw = i2;
        }
    }

    private static final class a {
        final int Ss;
        final int St;

        a(int i, int i2) {
            this.Ss = i;
            this.St = i2;
        }
    }

    /* renamed from: com.applovin.exoplayer2.i.g.c$c  reason: collision with other inner class name */
    private static final class C0056c {
        final int dE;
        final int height;

        C0056c(int i, int i2) {
            this.dE = i;
            this.height = i2;
        }
    }
}
