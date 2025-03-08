package com.fyber.inneractive.sdk.response;

import com.fyber.inneractive.sdk.network.m;
import com.fyber.inneractive.sdk.network.n;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;

public class k implements j {
    public final n a;

    public k(n nVar) {
        this.a = nVar;
    }

    public final String a(Map<String, String> map, m mVar) {
        String lowerCase = mVar.key.toLowerCase();
        String str = map.get(lowerCase);
        IAlog.d("%s%s extracted from response header: %s", IAlog.a((Object) this), lowerCase, str);
        int i = IAlog.a;
        IAlog.a(1, (Exception) null, "%s %s : %s", "RESPONSE_HEADER", lowerCase, str);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0229  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.fyber.inneractive.sdk.response.b r34) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            com.fyber.inneractive.sdk.response.e r2 = r1.a
            r3 = 0
            r2.B = r3
            com.fyber.inneractive.sdk.config.IAConfigManager r2 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.f0 r2 = r2.x
            r2.e = r3
            com.fyber.inneractive.sdk.external.ImpressionData r2 = new com.fyber.inneractive.sdk.external.ImpressionData
            r2.<init>()
            com.fyber.inneractive.sdk.network.n r4 = r0.a
            java.util.Map r4 = r4.t()
            com.fyber.inneractive.sdk.network.m r5 = com.fyber.inneractive.sdk.network.m.RETURNED_AD_TYPE
            java.lang.String r5 = r0.a(r4, r5)
            com.fyber.inneractive.sdk.network.m r6 = com.fyber.inneractive.sdk.network.m.ERROR_CODE
            r0.a(r4, r6)
            com.fyber.inneractive.sdk.network.m r6 = com.fyber.inneractive.sdk.network.m.SESSION_ID
            java.lang.String r6 = r0.a(r4, r6)
            com.fyber.inneractive.sdk.network.m r7 = com.fyber.inneractive.sdk.network.m.CONTENT_ID
            java.lang.String r7 = r0.a(r4, r7)
            com.fyber.inneractive.sdk.network.m r8 = com.fyber.inneractive.sdk.network.m.PUBLISHER_ID
            r0.a(r4, r8)
            com.fyber.inneractive.sdk.network.m r8 = com.fyber.inneractive.sdk.network.m.WIDTH
            java.lang.String r8 = r0.a(r4, r8)
            com.fyber.inneractive.sdk.network.m r9 = com.fyber.inneractive.sdk.network.m.HEIGHT
            java.lang.String r9 = r0.a(r4, r9)
            com.fyber.inneractive.sdk.network.m r10 = com.fyber.inneractive.sdk.network.m.SDK_IMPRESSION_URL
            java.lang.String r10 = r0.a(r4, r10)
            com.fyber.inneractive.sdk.network.m r11 = com.fyber.inneractive.sdk.network.m.SDK_CLICK_URL
            java.lang.String r11 = r0.a(r4, r11)
            com.fyber.inneractive.sdk.network.m r12 = com.fyber.inneractive.sdk.network.m.AD_TIMEOUT
            java.lang.String r12 = r0.a(r4, r12)
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.AD_COMPLETION_URL
            java.lang.String r13 = r0.a(r4, r13)
            com.fyber.inneractive.sdk.network.m r14 = com.fyber.inneractive.sdk.network.m.AD_UNIT_ID
            java.lang.String r14 = r0.a(r4, r14)
            r1.b = r14
            com.fyber.inneractive.sdk.network.m r14 = com.fyber.inneractive.sdk.network.m.AD_UNIT_TYPE
            r0.a(r4, r14)
            com.fyber.inneractive.sdk.network.m r14 = com.fyber.inneractive.sdk.network.m.AD_UNIT_DISPLAY_TYPE
            java.lang.String r14 = r0.a(r4, r14)
            com.fyber.inneractive.sdk.network.m r15 = com.fyber.inneractive.sdk.network.m.AD_NETWORK
            java.lang.String r15 = r0.a(r4, r15)
            com.fyber.inneractive.sdk.network.m r3 = com.fyber.inneractive.sdk.network.m.AD_NETWORK_ID
            java.lang.String r3 = r0.a(r4, r3)
            r16 = r14
            com.fyber.inneractive.sdk.network.m r14 = com.fyber.inneractive.sdk.network.m.CREATIVE_ID
            java.lang.String r14 = r0.a(r4, r14)
            r17 = r14
            com.fyber.inneractive.sdk.network.m r14 = com.fyber.inneractive.sdk.network.m.AD_DOMAIN
            java.lang.String r14 = r0.a(r4, r14)
            r18 = r14
            com.fyber.inneractive.sdk.network.m r14 = com.fyber.inneractive.sdk.network.m.APP_BUNDLE
            java.lang.String r14 = r0.a(r4, r14)
            r19 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.CAMPAIGN_ID
            java.lang.String r13 = r0.a(r4, r13)
            r20 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.CPM_VALUE
            java.lang.String r13 = r0.a(r4, r13)
            r21 = r11
            com.fyber.inneractive.sdk.network.m r11 = com.fyber.inneractive.sdk.network.m.CPM_CURRENCY
            java.lang.String r11 = r0.a(r4, r11)
            r2.setCpmValue(r13)
            r2.setCurrency(r11)
            com.fyber.inneractive.sdk.network.m r11 = com.fyber.inneractive.sdk.network.m.BANNER_MRC_PERCENT
            java.lang.String r11 = r0.a(r4, r11)
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.BANNER_MRC_DURATION
            java.lang.String r13 = r0.a(r4, r13)
            r22 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.BANNER_MRC_IMPRESSION_URL
            java.lang.String r13 = r0.a(r4, r13)
            r23 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.INTERSTITIAL_SKIP_MODE
            java.lang.String r13 = r0.a(r4, r13)
            r24 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.IGNITE_INSTALL_URL
            java.lang.String r13 = r0.a(r4, r13)
            r25 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.IGNITE_MODE
            java.lang.String r13 = r0.a(r4, r13)
            r26 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.APP_BUNDLE_LAUNCHER
            java.lang.String r13 = r0.a(r4, r13)
            r27 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.BRAND_BIDDER_SHOW_ENDCARD
            java.lang.String r13 = r0.a(r4, r13)
            r28 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.BRAND_BIDDER_CTA_TEXT
            java.lang.String r13 = r0.a(r4, r13)
            r29 = r13
            com.fyber.inneractive.sdk.network.m r13 = com.fyber.inneractive.sdk.network.m.MRAID_VIDEO_SIGNAL
            java.lang.String r13 = r0.a(r4, r13)
            boolean r30 = r34.b()
            if (r30 == 0) goto L_0x0105
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r0.p = r4
        L_0x0105:
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r0.getClass()
            long r30 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x0112 }
        L_0x010e:
            r4 = r13
            r12 = r30
            goto L_0x0115
        L_0x0112:
            r30 = 20
            goto L_0x010e
        L_0x0115:
            r0.b = r12
            r30 = r10
            r31 = r11
            long r10 = r0.c
            r32 = r4
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MINUTES
            long r12 = r4.toMillis(r12)
            long r10 = r10 + r12
            r0.a = r10
            r2.setImpressionId(r6)
            r2.setDemandSource(r15)
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r0.d = r7
            r0.getClass()
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r0.y = r14
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0146
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            r2.setDemandId(r0)
        L_0x0146:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0158
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            int r3 = r3.intValue()
            r0.g = r3
        L_0x0158:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x016a
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            int r3 = r3.intValue()
            r0.e = r3
        L_0x016a:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x017c
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            int r3 = r3.intValue()
            r0.f = r3
        L_0x017c:
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r3 = r30
            r0.k = r3
            r3 = r21
            r0.l = r3
            r3 = r19
            r0.o = r3
            java.lang.String r3 = r1.b
            r0.m = r3
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r3 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.fromValue(r16)     // Catch:{ IllegalArgumentException -> 0x0195 }
            r0.n = r3     // Catch:{ IllegalArgumentException -> 0x0195 }
            goto L_0x019b
        L_0x0195:
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r3 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL
            r0.n = r3
        L_0x019b:
            boolean r0 = android.text.TextUtils.isEmpty(r17)
            if (r0 != 0) goto L_0x01a6
            r0 = r17
            r2.setCreativeId(r0)
        L_0x01a6:
            boolean r0 = android.text.TextUtils.isEmpty(r18)
            if (r0 != 0) goto L_0x01b1
            r0 = r18
            r2.setAdvertiserDomain(r0)
        L_0x01b1:
            boolean r0 = android.text.TextUtils.isEmpty(r20)
            if (r0 != 0) goto L_0x01bc
            r0 = r20
            r2.setCampaignId(r0)
        L_0x01bc:
            java.lang.String r0 = com.fyber.inneractive.sdk.util.n.h()
            r2.setCountry(r0)
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r0.r = r2
            r2 = r31
            r3 = 0
            int r2 = com.fyber.inneractive.sdk.util.u.a((java.lang.String) r2, (int) r3)
            r0.t = r2
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            boolean r2 = android.text.TextUtils.isEmpty(r22)
            if (r2 != 0) goto L_0x01dd
            float r2 = java.lang.Float.parseFloat(r22)     // Catch:{ NumberFormatException -> 0x01dd }
            goto L_0x01df
        L_0x01dd:
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x01df:
            r0.u = r2
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r2 = r23
            r0.v = r2
            r2 = -1
            r4 = r24
            int r2 = com.fyber.inneractive.sdk.util.u.a((java.lang.String) r4, (int) r2)
            r0.w = r2
            boolean r0 = android.text.TextUtils.isEmpty(r25)
            if (r0 != 0) goto L_0x01fc
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r2 = r25
            r0.E = r2
        L_0x01fc:
            boolean r0 = android.text.TextUtils.isEmpty(r26)
            if (r0 != 0) goto L_0x020b
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            com.fyber.inneractive.sdk.ignite.k r2 = com.fyber.inneractive.sdk.ignite.k.a(r26)
            r0.a((com.fyber.inneractive.sdk.ignite.k) r2)
        L_0x020b:
            boolean r0 = android.text.TextUtils.isEmpty(r27)
            if (r0 != 0) goto L_0x0217
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r2 = r27
            r0.G = r2
        L_0x0217:
            boolean r0 = android.text.TextUtils.isEmpty(r28)
            if (r0 != 0) goto L_0x0223
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r2 = r28
            r0.C = r2
        L_0x0223:
            boolean r0 = android.text.TextUtils.isEmpty(r29)
            if (r0 != 0) goto L_0x022f
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            r2 = r29
            r0.D = r2
        L_0x022f:
            com.fyber.inneractive.sdk.response.e r0 = r1.a
            java.lang.String r1 = "1"
            r2 = r32
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0241
            boolean r1 = java.lang.Boolean.parseBoolean(r2)
            if (r1 == 0) goto L_0x0242
        L_0x0241:
            r3 = 1
        L_0x0242:
            r0.H = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.response.k.a(com.fyber.inneractive.sdk.response.b):void");
    }

    public String a() {
        return this.a.e().toString();
    }
}
