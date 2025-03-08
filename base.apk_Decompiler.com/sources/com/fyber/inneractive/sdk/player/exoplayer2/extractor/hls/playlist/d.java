package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Queue;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d implements y.a<c> {
    public static final Pattern a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern c = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern m = Pattern.compile("METHOD=(NONE|AES-128)");
    public static final Pattern n = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern o = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern q = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern r = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern t = a("AUTOSELECT");
    public static final Pattern u = a("DEFAULT");
    public static final Pattern v = a("FORCED");

    public static b b(a aVar, String str) throws IOException {
        int i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        char c2 = 0;
        int i3 = 1;
        long j2 = 0;
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        boolean z2 = false;
        b.a aVar2 = null;
        int i9 = 0;
        long j9 = -1;
        boolean z3 = false;
        while (true) {
            String str2 = null;
            String str3 = null;
            while (true) {
                if (aVar.a()) {
                    String b2 = aVar.b();
                    if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                        String b3 = b(b2, g);
                        if ("VOD".equals(b3)) {
                            i4 = 1;
                        } else if ("EVENT".equals(b3)) {
                            i4 = 2;
                        }
                    } else if (b2.startsWith("#EXT-X-START")) {
                        j3 = (long) (Double.parseDouble(b(b2, j)) * 1000000.0d);
                    } else if (b2.startsWith("#EXT-X-MAP")) {
                        String b4 = b(b2, n);
                        String a2 = a(b2, l);
                        if (a2 != null) {
                            String[] split = a2.split("@");
                            j9 = Long.parseLong(split[c2]);
                            if (split.length > i3) {
                                j6 = Long.parseLong(split[i3]);
                            }
                        }
                        aVar2 = new b.a(b4, 0, -1, -9223372036854775807L, false, (String) null, (String) null, j6, j9);
                        j6 = j2;
                        j9 = -1;
                    } else if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                        j4 = 1000000 * ((long) Integer.parseInt(b(b2, e)));
                    } else if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        i9 = Integer.parseInt(b(b2, h));
                        i7 = i9;
                    } else if (b2.startsWith("#EXT-X-VERSION")) {
                        i8 = Integer.parseInt(b(b2, f));
                    } else if (b2.startsWith("#EXTINF")) {
                        j8 = (long) (Double.parseDouble(b(b2, i)) * 1000000.0d);
                    } else if (b2.startsWith("#EXT-X-KEY")) {
                        z3 = "AES-128".equals(b(b2, m));
                        if (z3) {
                            str3 = b(b2, n);
                            str2 = a(b2, o);
                        }
                    } else if (b2.startsWith("#EXT-X-BYTERANGE")) {
                        String[] split2 = b(b2, k).split("@");
                        j9 = Long.parseLong(split2[c2]);
                        if (split2.length > i3) {
                            j6 = Long.parseLong(split2[i3]);
                        }
                    } else if (b2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                        i6 = Integer.parseInt(b2.substring(b2.indexOf(58) + i3));
                        z = true;
                    } else if (b2.equals("#EXT-X-DISCONTINUITY")) {
                        i5++;
                    } else if (b2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                        if (j5 == j2) {
                            String substring = b2.substring(b2.indexOf(58) + i3);
                            Matcher matcher = u.f.matcher(substring);
                            if (matcher.matches()) {
                                if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                                    i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                                    if (matcher.group(11).equals("-")) {
                                        i2 *= -1;
                                    }
                                } else {
                                    i2 = 0;
                                }
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                                gregorianCalendar.clear();
                                gregorianCalendar.set(Integer.parseInt(matcher.group(i3)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                                if (!TextUtils.isEmpty(matcher.group(8))) {
                                    gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
                                }
                                long timeInMillis = gregorianCalendar.getTimeInMillis();
                                if (i2 != 0) {
                                    timeInMillis -= (long) (i2 * 60000);
                                }
                                j5 = com.fyber.inneractive.sdk.player.exoplayer2.b.a(timeInMillis) - j7;
                                c2 = 0;
                                i3 = 1;
                                j2 = 0;
                            } else {
                                throw new l("Invalid date/time format: " + substring);
                            }
                        }
                    } else if (b2.startsWith("#EXT-X-DATERANGE")) {
                        arrayList2.add(b2);
                    } else if (!b2.startsWith("#")) {
                        String hexString = !z3 ? null : str2 != null ? str2 : Integer.toHexString(i9);
                        int i10 = i9 + 1;
                        int i11 = (j9 > -1 ? 1 : (j9 == -1 ? 0 : -1));
                        if (i11 == 0) {
                            j6 = 0;
                        }
                        arrayList.add(new b.a(b2, j8, i5, j7, z3, str3, hexString, j6, j9));
                        j7 += j8;
                        if (i11 != 0) {
                            j6 += j9;
                        }
                        i9 = i10;
                        j9 = -1;
                        c2 = 0;
                        i3 = 1;
                        j2 = 0;
                        j8 = 0;
                    } else {
                        if (b2.equals("#EXT-X-ENDLIST")) {
                            c2 = 0;
                            i3 = 1;
                            j2 = 0;
                            z2 = true;
                        }
                        c2 = 0;
                        i3 = 1;
                        j2 = 0;
                    }
                    c2 = 0;
                    i3 = 1;
                    j2 = 0;
                } else {
                    return new b(i4, str, j3, j5, z, i6, i7, i8, j4, z2, j5 != 0, aVar2, arrayList, arrayList2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d7, code lost:
        r8.add(r1);
        r7 = b(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d.a(r8, r0), r7.toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068 A[Catch:{ all -> 0x00fe }, LOOP:3: B:30:0x0068->B:75:0x0068, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f6 A[SYNTHETIC, Splitter:B:61:0x00f6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(android.net.Uri r7, java.io.InputStream r8) throws java.io.IOException {
        /*
            r6 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r8)
            r0.<init>(r1)
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            int r1 = r0.read()     // Catch:{ all -> 0x00fe }
            r2 = 239(0xef, float:3.35E-43)
            r3 = 0
            if (r1 != r2) goto L_0x002d
            int r1 = r0.read()     // Catch:{ all -> 0x00fe }
            r2 = 187(0xbb, float:2.62E-43)
            if (r1 != r2) goto L_0x0066
            int r1 = r0.read()     // Catch:{ all -> 0x00fe }
            r2 = 191(0xbf, float:2.68E-43)
            if (r1 == r2) goto L_0x0029
            goto L_0x0066
        L_0x0029:
            int r1 = r0.read()     // Catch:{ all -> 0x00fe }
        L_0x002d:
            r2 = -1
            if (r1 == r2) goto L_0x003b
            boolean r4 = java.lang.Character.isWhitespace(r1)     // Catch:{ all -> 0x00fe }
            if (r4 == 0) goto L_0x003b
            int r1 = r0.read()     // Catch:{ all -> 0x00fe }
            goto L_0x002d
        L_0x003b:
            r4 = 0
        L_0x003c:
            r5 = 7
            if (r4 >= r5) goto L_0x004f
            java.lang.String r5 = "#EXTM3U"
            char r5 = r5.charAt(r4)     // Catch:{ all -> 0x00fe }
            if (r1 == r5) goto L_0x0048
            goto L_0x0066
        L_0x0048:
            int r1 = r0.read()     // Catch:{ all -> 0x00fe }
            int r4 = r4 + 1
            goto L_0x003c
        L_0x004f:
            if (r1 == r2) goto L_0x0062
            boolean r3 = java.lang.Character.isWhitespace(r1)     // Catch:{ all -> 0x00fe }
            if (r3 == 0) goto L_0x0062
            boolean r3 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.b((int) r1)     // Catch:{ all -> 0x00fe }
            if (r3 != 0) goto L_0x0062
            int r1 = r0.read()     // Catch:{ all -> 0x00fe }
            goto L_0x004f
        L_0x0062:
            boolean r3 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.b((int) r1)     // Catch:{ all -> 0x00fe }
        L_0x0066:
            if (r3 == 0) goto L_0x00f6
        L_0x0068:
            java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x00fe }
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x00fe }
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x00fe }
            if (r2 == 0) goto L_0x0079
            goto L_0x0068
        L_0x0079:
            java.lang.String r2 = "#EXT-X-STREAM-INF"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x00fe }
            if (r2 == 0) goto L_0x0092
            r8.add(r1)     // Catch:{ all -> 0x00fe }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d$a r1 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d$a     // Catch:{ all -> 0x00fe }
            r1.<init>(r8, r0)     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00fe }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a r7 = a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d.a) r1, (java.lang.String) r7)     // Catch:{ all -> 0x00fe }
            goto L_0x00e7
        L_0x0092:
            java.lang.String r2 = "#EXT-X-TARGETDURATION"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x00fe }
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = "#EXT-X-MEDIA-SEQUENCE"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x00fe }
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = "#EXTINF"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x00fe }
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = "#EXT-X-KEY"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x00fe }
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = "#EXT-X-BYTERANGE"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x00fe }
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = "#EXT-X-DISCONTINUITY"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x00fe }
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = "#EXT-X-DISCONTINUITY-SEQUENCE"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x00fe }
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = "#EXT-X-ENDLIST"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x00fe }
            if (r2 == 0) goto L_0x00d3
            goto L_0x00d7
        L_0x00d3:
            r8.add(r1)     // Catch:{ all -> 0x00fe }
            goto L_0x0068
        L_0x00d7:
            r8.add(r1)     // Catch:{ all -> 0x00fe }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d$a r1 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d$a     // Catch:{ all -> 0x00fe }
            r1.<init>(r8, r0)     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00fe }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r7 = b((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d.a) r1, (java.lang.String) r7)     // Catch:{ all -> 0x00fe }
        L_0x00e7:
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r0)
            return r7
        L_0x00eb:
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r0)
            com.fyber.inneractive.sdk.player.exoplayer2.l r7 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r8 = "Failed to parse the playlist, could not identify any tags."
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x00f6:
            com.fyber.inneractive.sdk.player.exoplayer2.source.t r8 = new com.fyber.inneractive.sdk.player.exoplayer2.source.t     // Catch:{ all -> 0x00fe }
            java.lang.String r1 = "Input does not start with the #EXTM3U header."
            r8.<init>(r1, r7)     // Catch:{ all -> 0x00fe }
            throw r8     // Catch:{ all -> 0x00fe }
        L_0x00fe:
            r7 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.io.Closeable) r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d.a(android.net.Uri, java.io.InputStream):java.lang.Object");
    }

    public static class a {
        public final BufferedReader a;
        public final Queue<String> b;
        public String c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.b = queue;
            this.a = bufferedReader;
        }

        public String b() throws IOException {
            if (!a()) {
                return null;
            }
            String str = this.c;
            this.c = null;
            return str;
        }

        public boolean a() throws IOException {
            String trim;
            if (this.c != null) {
                return true;
            }
            if (!this.b.isEmpty()) {
                this.c = this.b.poll();
                return true;
            }
            do {
                String readLine = this.a.readLine();
                this.c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.c = trim;
            } while (trim.isEmpty());
            return true;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
        if (r14.equals("CLOSED-CAPTIONS") == false) goto L_0x006f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0018 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d.a r45, java.lang.String r46) throws java.io.IOException {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r1 = 0
            r2 = 0
            r6 = r1
            r7 = 0
        L_0x0018:
            boolean r8 = r45.a()
            if (r8 == 0) goto L_0x01e1
            java.lang.String r8 = r45.b()
            java.lang.String r9 = "#EXT-X-MEDIA"
            boolean r9 = r8.startsWith(r9)
            r10 = 1
            if (r9 == 0) goto L_0x013c
            java.util.regex.Pattern r9 = u
            boolean r9 = a(r8, r9, r2)
            java.util.regex.Pattern r12 = v
            boolean r12 = a(r8, r12, r2)
            r13 = 2
            if (r12 == 0) goto L_0x003c
            r12 = 2
            goto L_0x003d
        L_0x003c:
            r12 = 0
        L_0x003d:
            r9 = r9 | r12
            java.util.regex.Pattern r12 = t
            boolean r12 = a(r8, r12, r2)
            if (r12 == 0) goto L_0x0048
            r12 = 4
            goto L_0x0049
        L_0x0048:
            r12 = 0
        L_0x0049:
            r9 = r9 | r12
            java.util.regex.Pattern r12 = n
            java.lang.String r12 = a((java.lang.String) r8, (java.util.regex.Pattern) r12)
            java.util.regex.Pattern r14 = r
            java.lang.String r15 = b((java.lang.String) r8, (java.util.regex.Pattern) r14)
            java.util.regex.Pattern r14 = q
            java.lang.String r35 = a((java.lang.String) r8, (java.util.regex.Pattern) r14)
            java.util.regex.Pattern r14 = p
            java.lang.String r14 = b((java.lang.String) r8, (java.util.regex.Pattern) r14)
            r14.getClass()
            r14.hashCode()
            int r16 = r14.hashCode()
            switch(r16) {
                case -959297733: goto L_0x0085;
                case -333210994: goto L_0x007c;
                case 62628790: goto L_0x0071;
                default: goto L_0x006f;
            }
        L_0x006f:
            r10 = -1
            goto L_0x008f
        L_0x0071:
            java.lang.String r10 = "AUDIO"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x007a
            goto L_0x006f
        L_0x007a:
            r10 = 2
            goto L_0x008f
        L_0x007c:
            java.lang.String r11 = "CLOSED-CAPTIONS"
            boolean r11 = r14.equals(r11)
            if (r11 != 0) goto L_0x008f
            goto L_0x006f
        L_0x0085:
            java.lang.String r10 = "SUBTITLES"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x008e
            goto L_0x006f
        L_0x008e:
            r10 = 0
        L_0x008f:
            switch(r10) {
                case 0: goto L_0x011e;
                case 1: goto L_0x00db;
                case 2: goto L_0x0093;
                default: goto L_0x0092;
            }
        L_0x0092:
            goto L_0x0018
        L_0x0093:
            com.fyber.inneractive.sdk.player.exoplayer2.i r8 = new com.fyber.inneractive.sdk.player.exoplayer2.i
            r14 = r8
            java.lang.String r16 = "application/x-mpegURL"
            r17 = 0
            r18 = 0
            r19 = -1
            r20 = -1
            r21 = -1
            r22 = -1
            r23 = -1082130432(0xffffffffbf800000, float:-1.0)
            r24 = -1
            r25 = -1082130432(0xffffffffbf800000, float:-1.0)
            r26 = 0
            r27 = -1
            r28 = 0
            r29 = -1
            r30 = -1
            r31 = -1
            r32 = -1
            r33 = -1
            r36 = -1
            r37 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r39 = 0
            r40 = 0
            r41 = 0
            r34 = r9
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r39, r40, r41)
            if (r12 != 0) goto L_0x00d1
            r6 = r8
            goto L_0x0018
        L_0x00d1:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a r9 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a
            r9.<init>(r12, r8)
            r4.add(r9)
            goto L_0x0018
        L_0x00db:
            java.util.regex.Pattern r10 = s
            java.lang.String r8 = b((java.lang.String) r8, (java.util.regex.Pattern) r10)
            java.lang.String r10 = "CC"
            boolean r10 = r8.startsWith(r10)
            if (r10 == 0) goto L_0x00f4
            java.lang.String r8 = r8.substring(r13)
            int r8 = java.lang.Integer.parseInt(r8)
            java.lang.String r10 = "application/cea-608"
            goto L_0x00ff
        L_0x00f4:
            r10 = 7
            java.lang.String r8 = r8.substring(r10)
            int r8 = java.lang.Integer.parseInt(r8)
            java.lang.String r10 = "application/cea-708"
        L_0x00ff:
            r21 = r8
            r16 = r10
            if (r1 != 0) goto L_0x010a
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x010a:
            r8 = 0
            r17 = 0
            r18 = -1
            r14 = r15
            r15 = r8
            r19 = r9
            r20 = r35
            com.fyber.inneractive.sdk.player.exoplayer2.i r8 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(r14, r15, r16, r17, r18, r19, r20, r21)
            r1.add(r8)
            goto L_0x0018
        L_0x011e:
            java.lang.String r8 = "application/x-mpegURL"
            java.lang.String r16 = "text/vtt"
            r17 = 0
            r18 = -1
            r21 = -1
            r14 = r15
            r15 = r8
            r19 = r9
            r20 = r35
            com.fyber.inneractive.sdk.player.exoplayer2.i r8 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(r14, r15, r16, r17, r18, r19, r20, r21)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a r9 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a
            r9.<init>(r12, r8)
            r5.add(r9)
            goto L_0x0018
        L_0x013c:
            java.lang.String r9 = "#EXT-X-STREAM-INF"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0018
            java.util.regex.Pattern r9 = b
            java.lang.String r9 = b((java.lang.String) r8, (java.util.regex.Pattern) r9)
            int r9 = java.lang.Integer.parseInt(r9)
            java.util.regex.Pattern r11 = a
            java.lang.String r11 = a((java.lang.String) r8, (java.util.regex.Pattern) r11)
            if (r11 == 0) goto L_0x015a
            int r9 = java.lang.Integer.parseInt(r11)
        L_0x015a:
            r22 = r9
            java.util.regex.Pattern r9 = c
            java.lang.String r21 = a((java.lang.String) r8, (java.util.regex.Pattern) r9)
            java.util.regex.Pattern r9 = d
            java.lang.String r9 = a((java.lang.String) r8, (java.util.regex.Pattern) r9)
            java.lang.String r11 = "CLOSED-CAPTIONS=NONE"
            boolean r8 = r8.contains(r11)
            r7 = r7 | r8
            if (r9 == 0) goto L_0x018d
            java.lang.String r8 = "x"
            java.lang.String[] r8 = r9.split(r8)
            r9 = r8[r2]
            int r9 = java.lang.Integer.parseInt(r9)
            r8 = r8[r10]
            int r8 = java.lang.Integer.parseInt(r8)
            if (r9 <= 0) goto L_0x018d
            if (r8 > 0) goto L_0x0188
            goto L_0x018d
        L_0x0188:
            r25 = r8
            r24 = r9
            goto L_0x0191
        L_0x018d:
            r24 = -1
            r25 = -1
        L_0x0191:
            java.lang.String r8 = r45.b()
            boolean r9 = r0.add(r8)
            if (r9 == 0) goto L_0x0018
            int r9 = r3.size()
            java.lang.String r18 = java.lang.Integer.toString(r9)
            com.fyber.inneractive.sdk.player.exoplayer2.i r9 = new com.fyber.inneractive.sdk.player.exoplayer2.i
            r17 = r9
            java.lang.String r19 = "application/x-mpegURL"
            r20 = 0
            r23 = -1
            r26 = -1082130432(0xffffffffbf800000, float:-1.0)
            r27 = -1
            r28 = -1082130432(0xffffffffbf800000, float:-1.0)
            r29 = 0
            r30 = -1
            r31 = 0
            r32 = -1
            r33 = -1
            r34 = -1
            r35 = -1
            r36 = -1
            r37 = 0
            r38 = 0
            r39 = -1
            r40 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r42 = 0
            r43 = 0
            r44 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r42, r43, r44)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a r10 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a
            r10.<init>(r8, r9)
            r3.add(r10)
            goto L_0x0018
        L_0x01e1:
            if (r7 == 0) goto L_0x01e9
            java.util.List r0 = java.util.Collections.emptyList()
            r7 = r0
            goto L_0x01ea
        L_0x01e9:
            r7 = r1
        L_0x01ea:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a r0 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a
            r1 = r0
            r2 = r46
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d$a, java.lang.String):com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a");
    }

    public static String b(String str, Pattern pattern) throws l {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new l("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static String a(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static boolean a(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1).equals("YES") : z;
    }

    public static Pattern a(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }
}
