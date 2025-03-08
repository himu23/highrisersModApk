package com.fyber.inneractive.sdk.config.global;

import com.unity3d.services.core.di.ServiceProvider;

public class j implements d {
    public String a;
    public boolean b;

    public j(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.fyber.inneractive.sdk.config.global.e r10) {
        /*
            r9 = this;
            java.lang.String r10 = r9.a
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            r0 = 0
            if (r10 != 0) goto L_0x0132
            java.lang.String r10 = com.fyber.inneractive.sdk.external.InneractiveAdManager.getVersion()
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "j"
            r2[r0] = r3
            r4 = 1
            r2[r4] = r10
            java.lang.String r5 = "%s: shouldApply - running version: %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r5, r2)
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r2[r0] = r3
            java.lang.String r5 = r9.a
            r2[r4] = r5
            java.lang.String r5 = "%s: shouldApply - filter version: %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r5, r2)
            java.lang.String r2 = "\\."
            r5 = 4
            java.lang.String[] r6 = r10.split(r2, r5)
            java.lang.String r7 = r9.a
            java.lang.String[] r2 = r7.split(r2, r5)
            int r5 = r2.length
            int r5 = r5 - r4
            r5 = r2[r5]
            java.lang.String r7 = "*"
            boolean r7 = r5.equals(r7)
            java.lang.String r8 = "%s: shouldApplyByAsterix - version aligned with filter. do not apply"
            if (r7 == 0) goto L_0x0092
            r10 = 0
        L_0x0045:
            int r5 = r2.length
            int r5 = r5 - r4
            if (r10 >= r5) goto L_0x006e
            int r5 = r6.length
            if (r5 >= r10) goto L_0x0057
            java.lang.Object[] r10 = new java.lang.Object[r4]
            r10[r0] = r3
            java.lang.String r2 = "%s: shouldApplyByAsterix - running version is shorter than filter. applying"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r10)
        L_0x0055:
            r10 = 1
            goto L_0x0076
        L_0x0057:
            r5 = r6[r10]
            r7 = r2[r10]
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x006b
            java.lang.Object[] r10 = new java.lang.Object[r4]
            r10[r0] = r3
            java.lang.String r2 = "%s: shouldApplyByAsterix - running version does not comply with filter. applying"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r10)
            goto L_0x0055
        L_0x006b:
            int r10 = r10 + 1
            goto L_0x0045
        L_0x006e:
            java.lang.Object[] r10 = new java.lang.Object[r4]
            r10[r0] = r3
            com.fyber.inneractive.sdk.util.IAlog.a(r8, r10)
            r10 = 0
        L_0x0076:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r3
            r2 = r10 ^ 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1[r4] = r2
            java.lang.String r2 = "%s: shouldApply - * version match: %b"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r1)
            if (r10 == 0) goto L_0x008c
            boolean r0 = r9.b
            goto L_0x0091
        L_0x008c:
            boolean r10 = r9.b
            if (r10 != 0) goto L_0x0091
            r0 = 1
        L_0x0091:
            return r0
        L_0x0092:
            java.lang.String r7 = "+"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0111
            r10 = 0
        L_0x009b:
            int r5 = r2.length
            int r5 = r5 - r4
            if (r10 >= r5) goto L_0x00ed
            int r5 = r6.length
            if (r5 >= r10) goto L_0x00ad
            java.lang.Object[] r10 = new java.lang.Object[r4]
            r10[r0] = r3
            java.lang.String r2 = "%s: shouldApplyByPlus - running version is shorter than filter. applying"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r10)
        L_0x00ab:
            r10 = 1
            goto L_0x00f5
        L_0x00ad:
            r5 = r2[r10]     // Catch:{ NumberFormatException -> 0x00dc }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ NumberFormatException -> 0x00dc }
            int r5 = r5.intValue()     // Catch:{ NumberFormatException -> 0x00dc }
            r7 = r6[r10]     // Catch:{ NumberFormatException -> 0x00dc }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x00dc }
            int r7 = r7.intValue()     // Catch:{ NumberFormatException -> 0x00dc }
            if (r7 <= r5) goto L_0x00cd
            java.lang.String r10 = "%s: shouldApplyByPlus - running version is greater than the filter's version. no filter needed"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ NumberFormatException -> 0x00dc }
            r2[r0] = r3     // Catch:{ NumberFormatException -> 0x00dc }
            com.fyber.inneractive.sdk.util.IAlog.a(r10, r2)     // Catch:{ NumberFormatException -> 0x00dc }
            goto L_0x00f4
        L_0x00cd:
            if (r7 >= r5) goto L_0x00d9
            java.lang.String r10 = "%s: shouldApplyByPlus - running version is lower than the filter's version. applying filter "
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ NumberFormatException -> 0x00dc }
            r2[r0] = r3     // Catch:{ NumberFormatException -> 0x00dc }
            com.fyber.inneractive.sdk.util.IAlog.a(r10, r2)     // Catch:{ NumberFormatException -> 0x00dc }
            goto L_0x00ab
        L_0x00d9:
            int r10 = r10 + 1
            goto L_0x009b
        L_0x00dc:
            r10 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r2[r0] = r3
            java.lang.String r10 = r10.getMessage()
            r2[r4] = r10
            java.lang.String r10 = "%s: shouldApplyByPlus - Error in version string! Not a number. %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r10, r2)
            goto L_0x00ab
        L_0x00ed:
            java.lang.Object[] r10 = new java.lang.Object[r4]
            r10[r0] = r3
            com.fyber.inneractive.sdk.util.IAlog.a(r8, r10)
        L_0x00f4:
            r10 = 0
        L_0x00f5:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r3
            r2 = r10 ^ 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1[r4] = r2
            java.lang.String r2 = "%s: shouldApply - + version match: %b"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r1)
            if (r10 == 0) goto L_0x010b
            boolean r0 = r9.b
            goto L_0x0110
        L_0x010b:
            boolean r10 = r9.b
            if (r10 != 0) goto L_0x0110
            r0 = 1
        L_0x0110:
            return r0
        L_0x0111:
            java.lang.String r2 = r9.a
            boolean r10 = r2.equalsIgnoreCase(r10)
            r2 = r10 ^ 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r3
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r1[r4] = r10
            java.lang.String r10 = "%s: shouldApply - exact version match: %b"
            com.fyber.inneractive.sdk.util.IAlog.a(r10, r1)
            if (r2 == 0) goto L_0x012d
            boolean r0 = r9.b
            goto L_0x0132
        L_0x012d:
            boolean r10 = r9.b
            if (r10 != 0) goto L_0x0132
            r0 = 1
        L_0x0132:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.config.global.j.a(com.fyber.inneractive.sdk.config.global.e):boolean");
    }

    public String toString() {
        return String.format("%s - %s include: %b", new Object[]{ServiceProvider.NAMED_SDK, this.a, Boolean.valueOf(this.b)});
    }
}
