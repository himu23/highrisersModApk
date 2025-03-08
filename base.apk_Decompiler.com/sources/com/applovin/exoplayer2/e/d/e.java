package com.applovin.exoplayer2.e.d;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.e.d.b;
import com.applovin.exoplayer2.l.aj;
import com.applovin.exoplayer2.l.q;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

final class e {
    private static final String[] wH = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] wI = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] wJ = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static b E(String str) throws IOException {
        try {
            return F(str);
        } catch (ai | NumberFormatException | XmlPullParserException unused) {
            q.h("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static b F(String str) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (aj.b(newPullParser, "x:xmpmeta")) {
            s<b.a> ga = s.ga();
            long j = -9223372036854775807L;
            do {
                newPullParser.next();
                if (aj.b(newPullParser, "rdf:Description")) {
                    if (!a(newPullParser)) {
                        return null;
                    }
                    j = b(newPullParser);
                    ga = c(newPullParser);
                } else if (aj.b(newPullParser, "Container:Directory")) {
                    ga = a(newPullParser, "Container", "Item");
                } else if (aj.b(newPullParser, "GContainer:Directory")) {
                    ga = a(newPullParser, "GContainer", "GContainerItem");
                }
            } while (!aj.a(newPullParser, "x:xmpmeta"));
            if (ga.isEmpty()) {
                return null;
            }
            return new b(j, ga);
        }
        throw ai.c("Couldn't find xmp metadata", (Throwable) null);
    }

    private static boolean a(XmlPullParser xmlPullParser) {
        String[] strArr = wH;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String c = aj.c(xmlPullParser, strArr[i]);
            if (c == null) {
                i++;
            } else if (Integer.parseInt(c) == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private static long b(XmlPullParser xmlPullParser) {
        for (String c : wI) {
            String c2 = aj.c(xmlPullParser, c);
            if (c2 != null) {
                long parseLong = Long.parseLong(c2);
                if (parseLong == -1) {
                    return -9223372036854775807L;
                }
                return parseLong;
            }
        }
        return -9223372036854775807L;
    }

    private static s<b.a> c(XmlPullParser xmlPullParser) {
        for (String c : wJ) {
            String c2 = aj.c(xmlPullParser, c);
            if (c2 != null) {
                return s.k(new b.a("image/jpeg", "Primary", 0, 0), new b.a("video/mp4", "MotionPhoto", Long.parseLong(c2), 0));
            }
        }
        return s.ga();
    }

    private static s<b.a> a(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        long j;
        s.a gc = s.gc();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (aj.b(xmlPullParser, str3)) {
                String c = aj.c(xmlPullParser, str2 + ":Mime");
                String c2 = aj.c(xmlPullParser, str2 + ":Semantic");
                String c3 = aj.c(xmlPullParser, str2 + ":Length");
                String c4 = aj.c(xmlPullParser, str2 + ":Padding");
                if (c == null || c2 == null) {
                    return s.ga();
                }
                long parseLong = c3 != null ? Long.parseLong(c3) : 0;
                if (c4 != null) {
                    j = Long.parseLong(c4);
                } else {
                    j = 0;
                }
                gc.t(new b.a(c, c2, parseLong, j));
            }
        } while (!aj.a(xmlPullParser, str4));
        return gc.gd();
    }
}
