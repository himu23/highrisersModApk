package com.fyber.inneractive.sdk.network;

import android.content.SharedPreferences;

public class u {
    public SharedPreferences a = null;

    public static final class a {
        public static u a = new u();
    }

    /* JADX WARNING: type inference failed for: r20v0, types: [com.fyber.inneractive.sdk.flow.q<? extends com.fyber.inneractive.sdk.response.e>, com.fyber.inneractive.sdk.flow.q] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r17, java.lang.String r18, java.lang.String r19, com.fyber.inneractive.sdk.flow.q<? extends com.fyber.inneractive.sdk.response.e> r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "Got exception adding param to json object: %s, %s"
            r5 = 0
            if (r0 == 0) goto L_0x011e
            if (r1 == 0) goto L_0x011e
            com.fyber.inneractive.sdk.response.e r6 = r20.d()
            if (r6 != 0) goto L_0x0017
            goto L_0x011e
        L_0x0017:
            com.fyber.inneractive.sdk.network.u r6 = com.fyber.inneractive.sdk.network.u.a.a
            android.content.SharedPreferences r7 = r6.a
            if (r7 == 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            java.lang.String r7 = "AutoWebActionPrefs"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r7, r5)
            r6.a = r0
        L_0x0026:
            r0 = 1
            java.lang.Object[] r7 = new java.lang.Object[r0]
            r7[r5] = r1
            java.lang.String r8 = "IAautoWebActionReporter: reporting action: %s"
            com.fyber.inneractive.sdk.util.IAlog.d(r8, r7)
            java.lang.Object[] r7 = new java.lang.Object[r0]
            r7[r5] = r2
            java.lang.String r8 = "IAautoWebActionReporter: url: %s"
            com.fyber.inneractive.sdk.util.IAlog.d(r8, r7)
            com.fyber.inneractive.sdk.config.IAConfigManager r7 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.s r8 = r7.i
            boolean r8 = r8.c
            if (r8 != 0) goto L_0x004a
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "IAautoWebActionReporter: Report of Non user web actions disabled!"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)
            goto L_0x011d
        L_0x004a:
            com.fyber.inneractive.sdk.network.s$a r8 = new com.fyber.inneractive.sdk.network.s$a
            com.fyber.inneractive.sdk.network.q r9 = com.fyber.inneractive.sdk.network.q.MRAID_AUTO_ACTION_DETECTED
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r10 = r3.a
            com.fyber.inneractive.sdk.response.e r11 = r20.d()
            com.fyber.inneractive.sdk.config.global.s r3 = r3.c
            org.json.JSONArray r3 = r3.c()
            r8.<init>((com.fyber.inneractive.sdk.network.q) r9, (com.fyber.inneractive.sdk.external.InneractiveAdRequest) r10, (com.fyber.inneractive.sdk.response.e) r11, (org.json.JSONArray) r3)
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r9 = "action"
            r10 = 2
            r3.put(r9, r1)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0072
        L_0x0069:
            java.lang.Object[] r11 = new java.lang.Object[r10]
            r11[r5] = r9
            r11[r0] = r1
            com.fyber.inneractive.sdk.util.IAlog.e(r4, r11)
        L_0x0072:
            boolean r1 = android.text.TextUtils.isEmpty(r19)
            if (r1 != 0) goto L_0x0087
            java.lang.String r1 = "url"
            r3.put(r1, r2)     // Catch:{ Exception -> 0x007e }
            goto L_0x0087
        L_0x007e:
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r9[r5] = r1
            r9[r0] = r2
            com.fyber.inneractive.sdk.util.IAlog.e(r4, r9)
        L_0x0087:
            android.content.SharedPreferences r1 = r6.a
            java.lang.String r2 = "lastReportTS"
            r11 = 0
            long r13 = r1.getLong(r2, r11)
            java.lang.String r1 = "UTC"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            java.util.Calendar r9 = java.util.Calendar.getInstance(r1)
            java.util.Calendar r1 = java.util.Calendar.getInstance(r1)
            r1.setTimeInMillis(r13)
            java.lang.String r15 = "numReportsToday"
            int r16 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r16 <= 0) goto L_0x00c1
            r11 = 6
            int r12 = r9.get(r11)
            int r1 = r1.get(r11)
            if (r12 != r1) goto L_0x00c1
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r11 = "IAautoWebActionReporter: encountered same date"
            com.fyber.inneractive.sdk.util.IAlog.d(r11, r1)
            android.content.SharedPreferences r1 = r6.a
            int r1 = r1.getInt(r15, r5)
            goto L_0x00c2
        L_0x00c1:
            r1 = 0
        L_0x00c2:
            com.fyber.inneractive.sdk.config.s r7 = r7.i
            int r7 = r7.d
            java.lang.Object[] r11 = new java.lang.Object[r10]
            int r12 = r1 + 1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)
            r11[r5] = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r7)
            r11[r0] = r13
            java.lang.String r13 = "IAautoWebActionReporter: day counter: %d max: %d"
            com.fyber.inneractive.sdk.util.IAlog.d(r13, r11)
            if (r1 >= r7) goto L_0x00e7
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r7 = "IAautoWebActionReporter: adding ad data"
            com.fyber.inneractive.sdk.util.IAlog.d(r7, r1)
            r8.g = r0
            goto L_0x00ee
        L_0x00e7:
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r7 = "IAautoWebActionReporter: not adding ad data"
            com.fyber.inneractive.sdk.util.IAlog.d(r7, r1)
        L_0x00ee:
            java.lang.String r1 = "daily_count"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)
            r3.put(r1, r7)     // Catch:{ Exception -> 0x00f8 }
            goto L_0x0101
        L_0x00f8:
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r10[r5] = r1
            r10[r0] = r7
            com.fyber.inneractive.sdk.util.IAlog.e(r4, r10)
        L_0x0101:
            org.json.JSONArray r0 = r8.f
            r0.put(r3)
            r0 = 0
            r8.a((java.lang.String) r0)
            android.content.SharedPreferences r0 = r6.a
            android.content.SharedPreferences$Editor r0 = r0.edit()
            long r3 = r9.getTimeInMillis()
            r0.putLong(r2, r3)
            r0.putInt(r15, r12)
            r0.apply()
        L_0x011d:
            return
        L_0x011e:
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "Invalid report request parameters!"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.u.a(android.content.Context, java.lang.String, java.lang.String, com.fyber.inneractive.sdk.flow.q):void");
    }
}
