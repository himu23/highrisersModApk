package com.applovin.exoplayer2.i.e;

final class b {
    public final int RA;
    public final int RB;
    public final int Ry;
    public final int Rz;
    public final int fR;

    private b(int i, int i2, int i3, int i4, int i5) {
        this.Ry = i;
        this.Rz = i2;
        this.RA = i3;
        this.RB = i4;
        this.fR = i5;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.applovin.exoplayer2.i.e.b ac(java.lang.String r9) {
        /*
            java.lang.String r0 = "Format:"
            boolean r0 = r9.startsWith(r0)
            com.applovin.exoplayer2.l.a.checkArgument(r0)
            r0 = 7
            java.lang.String r9 = r9.substring(r0)
            java.lang.String r0 = ","
            java.lang.String[] r9 = android.text.TextUtils.split(r9, r0)
            r0 = -1
            r1 = 0
            r2 = 0
            r4 = -1
            r5 = -1
            r6 = -1
            r7 = -1
        L_0x001b:
            int r3 = r9.length
            if (r2 >= r3) goto L_0x006d
            r3 = r9[r2]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = com.applovin.exoplayer2.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            int r8 = r3.hashCode()
            switch(r8) {
                case 100571: goto L_0x0055;
                case 3556653: goto L_0x004a;
                case 109757538: goto L_0x003f;
                case 109780401: goto L_0x0034;
                default: goto L_0x0032;
            }
        L_0x0032:
            r3 = -1
            goto L_0x005f
        L_0x0034:
            java.lang.String r8 = "style"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L_0x003d
            goto L_0x0032
        L_0x003d:
            r3 = 3
            goto L_0x005f
        L_0x003f:
            java.lang.String r8 = "start"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L_0x0048
            goto L_0x0032
        L_0x0048:
            r3 = 2
            goto L_0x005f
        L_0x004a:
            java.lang.String r8 = "text"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L_0x0053
            goto L_0x0032
        L_0x0053:
            r3 = 1
            goto L_0x005f
        L_0x0055:
            java.lang.String r8 = "end"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L_0x005e
            goto L_0x0032
        L_0x005e:
            r3 = 0
        L_0x005f:
            switch(r3) {
                case 0: goto L_0x0069;
                case 1: goto L_0x0067;
                case 2: goto L_0x0065;
                case 3: goto L_0x0063;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x006a
        L_0x0063:
            r6 = r2
            goto L_0x006a
        L_0x0065:
            r4 = r2
            goto L_0x006a
        L_0x0067:
            r7 = r2
            goto L_0x006a
        L_0x0069:
            r5 = r2
        L_0x006a:
            int r2 = r2 + 1
            goto L_0x001b
        L_0x006d:
            if (r4 == r0) goto L_0x007b
            if (r5 == r0) goto L_0x007b
            if (r7 == r0) goto L_0x007b
            com.applovin.exoplayer2.i.e.b r0 = new com.applovin.exoplayer2.i.e.b
            int r8 = r9.length
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x007c
        L_0x007b:
            r0 = 0
        L_0x007c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.i.e.b.ac(java.lang.String):com.applovin.exoplayer2.i.e.b");
    }
}
