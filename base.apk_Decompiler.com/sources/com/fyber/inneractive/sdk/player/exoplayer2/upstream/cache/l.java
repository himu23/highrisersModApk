package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.io.File;
import java.util.regex.Pattern;

public final class l extends g {
    public static final Pattern g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public l(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
    }

    public static File a(File file, int i2, long j, long j2) {
        return new File(file, i2 + "." + j + "." + j2 + ".v3.exo");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        if (r1 == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c9, code lost:
        if (r16.renameTo(r1) == false) goto L_0x00cb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l a(java.io.File r16, com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.i r17) {
        /*
            r0 = r17
            java.lang.String r1 = r16.getName()
            java.lang.String r2 = ".v3.exo"
            boolean r2 = r1.endsWith(r2)
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 != 0) goto L_0x00d6
            java.lang.String r1 = r16.getName()
            java.util.regex.Pattern r2 = h
            java.util.regex.Matcher r2 = r2.matcher(r1)
            boolean r7 = r2.matches()
            if (r7 == 0) goto L_0x0088
            java.lang.String r1 = r2.group(r6)
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            int r7 = r1.length()
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x002f:
            if (r9 >= r7) goto L_0x003e
            char r11 = r1.charAt(r9)
            r12 = 37
            if (r11 != r12) goto L_0x003b
            int r10 = r10 + 1
        L_0x003b:
            int r9 = r9 + 1
            goto L_0x002f
        L_0x003e:
            if (r10 != 0) goto L_0x0041
            goto L_0x0085
        L_0x0041:
            int r9 = r10 * 2
            int r9 = r7 - r9
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r9)
            java.util.regex.Pattern r12 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.g
            java.util.regex.Matcher r12 = r12.matcher(r1)
        L_0x0050:
            if (r10 <= 0) goto L_0x0074
            boolean r13 = r12.find()
            if (r13 == 0) goto L_0x0074
            java.lang.String r13 = r12.group(r6)
            r14 = 16
            int r13 = java.lang.Integer.parseInt(r13, r14)
            char r13 = (char) r13
            int r14 = r12.start()
            r11.append(r1, r8, r14)
            r11.append(r13)
            int r8 = r12.end()
            int r10 = r10 + -1
            goto L_0x0050
        L_0x0074:
            if (r8 >= r7) goto L_0x0079
            r11.append(r1, r8, r7)
        L_0x0079:
            int r1 = r11.length()
            if (r1 == r9) goto L_0x0081
            r1 = r5
            goto L_0x0085
        L_0x0081:
            java.lang.String r1 = r11.toString()
        L_0x0085:
            if (r1 != 0) goto L_0x0099
            goto L_0x00cb
        L_0x0088:
            java.util.regex.Pattern r2 = g
            java.util.regex.Matcher r2 = r2.matcher(r1)
            boolean r1 = r2.matches()
            if (r1 != 0) goto L_0x0095
            goto L_0x00cb
        L_0x0095:
            java.lang.String r1 = r2.group(r6)
        L_0x0099:
            java.io.File r7 = r16.getParentFile()
            java.util.HashMap<java.lang.String, com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h> r8 = r0.a
            java.lang.Object r8 = r8.get(r1)
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h r8 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h) r8
            if (r8 != 0) goto L_0x00ad
            r8 = -1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h r8 = r0.a(r1, r8)
        L_0x00ad:
            int r8 = r8.a
            java.lang.String r1 = r2.group(r4)
            long r9 = java.lang.Long.parseLong(r1)
            java.lang.String r1 = r2.group(r3)
            long r11 = java.lang.Long.parseLong(r1)
            java.io.File r1 = a(r7, r8, r9, r11)
            r2 = r16
            boolean r2 = r2.renameTo(r1)
            if (r2 != 0) goto L_0x00cc
        L_0x00cb:
            r1 = r5
        L_0x00cc:
            if (r1 != 0) goto L_0x00cf
            return r5
        L_0x00cf:
            java.lang.String r2 = r1.getName()
            r15 = r1
            r1 = r2
            goto L_0x00d9
        L_0x00d6:
            r2 = r16
            r15 = r2
        L_0x00d9:
            java.util.regex.Pattern r2 = i
            java.util.regex.Matcher r1 = r2.matcher(r1)
            boolean r2 = r1.matches()
            if (r2 != 0) goto L_0x00e6
            return r5
        L_0x00e6:
            long r11 = r15.length()
            java.lang.String r2 = r1.group(r6)
            int r2 = java.lang.Integer.parseInt(r2)
            android.util.SparseArray<java.lang.String> r0 = r0.b
            java.lang.Object r0 = r0.get(r2)
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L_0x00fe
            goto L_0x0114
        L_0x00fe:
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l r5 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l
            java.lang.String r0 = r1.group(r4)
            long r9 = java.lang.Long.parseLong(r0)
            java.lang.String r0 = r1.group(r3)
            long r13 = java.lang.Long.parseLong(r0)
            r7 = r5
            r7.<init>(r8, r9, r11, r13, r15)
        L_0x0114:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l.a(java.io.File, com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.i):com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l");
    }
}
