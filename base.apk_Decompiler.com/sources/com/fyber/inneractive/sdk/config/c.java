package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.cache.a;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.remote.e;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.unity3d.services.UnityAdsConstants;
import org.json.JSONObject;

public class c implements a<IAConfigManager.c> {
    public boolean a = false;

    public String a() {
        String str = IAConfigManager.M.c;
        StringBuilder sb = new StringBuilder("https://");
        int i = f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.baseConfigUrl");
        if (TextUtils.isEmpty(property)) {
            sb.append("cdn2.inner-active.mobi/ia-sdk-config/apps/");
        } else {
            sb.append(property);
        }
        sb.append(str);
        sb.append('/');
        sb.append(str);
        sb.append(".json");
        String sb2 = sb.toString();
        int i2 = IAlog.a;
        IAlog.a(1, (Exception) null, "%s: %s", "APP_CONFIG_REQUEST", sb2);
        return sb2;
    }

    public String b() {
        return "IALastModifiedFromHeader";
    }

    public String c() {
        return "inneractive.config";
    }

    public boolean d() {
        String string = p.a.getSharedPreferences("IAConfigurationPreferences", 0).getString("cached.config.appid", (String) null);
        if (string == null || !string.equalsIgnoreCase(IAConfigManager.M.c)) {
            return false;
        }
        return true;
    }

    public void a(Object obj) {
        IAConfigManager.c cVar = (IAConfigManager.c) obj;
        if (cVar != null && cVar.a != null) {
            p.a.getSharedPreferences("IAConfigurationPreferences", 0).edit().putString("cached.config.appid", cVar.a).apply();
        }
    }

    public final void a(Throwable th, String str) {
        String str2;
        String str3;
        String str4;
        if (!this.a) {
            this.a = true;
            if (!TextUtils.isEmpty(str)) {
                str2 = str.substring(0, str.length() > 501 ? 500 : str.length() - 1);
            } else {
                str2 = "Empty Json Data";
            }
            if (th != null) {
                str4 = th.getClass().getName();
                str3 = th.getLocalizedMessage();
            } else {
                str4 = "Bad remote configuration";
                str3 = UnityAdsConstants.Messages.MSG_INTERNAL_ERROR;
            }
            String str5 = IAConfigManager.M.c;
            s.a aVar = new s.a(q.FATAL_CONFIGURATION_ERROR);
            Object[] objArr = new Object[8];
            objArr[0] = "exception";
            objArr[1] = str4;
            objArr[2] = "message";
            if (str3 == null) {
                str3 = "No message";
            }
            objArr[3] = str3;
            objArr[4] = "data";
            objArr[5] = str2;
            objArr[6] = "appId";
            if (TextUtils.isEmpty(str5)) {
                str5 = "EMPTY_APP_ID";
            }
            objArr[7] = str5;
            aVar.a(objArr).a((String) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.config.IAConfigManager.c a(com.fyber.inneractive.sdk.config.remote.e r24) {
        /*
            r23 = this;
            r0 = r24
            com.fyber.inneractive.sdk.config.IAConfigManager$c r1 = new com.fyber.inneractive.sdk.config.IAConfigManager$c
            r1.<init>()
            java.lang.String r2 = r0.c
            r1.c = r2
            com.fyber.inneractive.sdk.config.remote.a r2 = r0.a
            java.lang.String r3 = r2.b
            r1.b = r3
            java.lang.String r2 = r2.a
            r1.a = r2
            java.util.List<com.fyber.inneractive.sdk.config.remote.h> r2 = r0.b
            java.util.Iterator r2 = r2.iterator()
        L_0x001b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04d1
            java.lang.Object r3 = r2.next()
            com.fyber.inneractive.sdk.config.remote.h r3 = (com.fyber.inneractive.sdk.config.remote.h) r3
            java.util.Map<java.lang.String, com.fyber.inneractive.sdk.config.z> r4 = r1.d
            java.lang.String r5 = r3.a
            com.fyber.inneractive.sdk.config.remote.a r6 = r0.a
            java.util.Map<java.lang.String, com.fyber.inneractive.sdk.config.a0> r7 = r1.e
            com.fyber.inneractive.sdk.config.IAConfigManager$e r8 = r1.f
            com.fyber.inneractive.sdk.config.z r9 = new com.fyber.inneractive.sdk.config.z
            r9.<init>()
            r10 = 2
            com.fyber.inneractive.sdk.config.remote.c[] r11 = new com.fyber.inneractive.sdk.config.remote.c[r10]
            r12 = 0
            r11[r12] = r6
            r13 = 1
            r11[r13] = r3
            r14 = 0
        L_0x0040:
            if (r14 >= r10) goto L_0x005a
            r15 = r11[r14]
            if (r15 == 0) goto L_0x0056
            java.lang.String r15 = r15.b()
            if (r15 == 0) goto L_0x0056
            java.lang.String r10 = "false"
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L_0x0056
            r10 = 0
            goto L_0x005b
        L_0x0056:
            int r14 = r14 + 1
            r10 = 2
            goto L_0x0040
        L_0x005a:
            r10 = 1
        L_0x005b:
            r9.b = r10
            java.util.List<com.fyber.inneractive.sdk.config.remote.i> r10 = r3.g
            java.util.Iterator r10 = r10.iterator()
        L_0x0063:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x04c5
            java.lang.Object r11 = r10.next()
            com.fyber.inneractive.sdk.config.remote.i r11 = (com.fyber.inneractive.sdk.config.remote.i) r11
            com.fyber.inneractive.sdk.config.a0 r14 = new com.fyber.inneractive.sdk.config.a0
            r14.<init>()
            java.lang.String r15 = r11.a
            if (r15 == 0) goto L_0x04bd
            java.lang.String r13 = r11.b
            if (r13 != 0) goto L_0x007e
        L_0x007c:
            r13 = 1
            goto L_0x0063
        L_0x007e:
            r14.a = r15
            r14.b = r13
            com.fyber.inneractive.sdk.config.remote.g r13 = r11.e
            if (r13 == 0) goto L_0x0098
            com.fyber.inneractive.sdk.config.y r15 = new com.fyber.inneractive.sdk.config.y
            r15.<init>()
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r13 = r13.a
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r12 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.DEFAULT
            if (r13 != r12) goto L_0x0096
            r15.a = r13
            r14.e = r15
            goto L_0x0098
        L_0x0096:
            r12 = 0
            goto L_0x007c
        L_0x0098:
            com.fyber.inneractive.sdk.config.remote.b r12 = r11.c
            if (r12 == 0) goto L_0x017d
            com.fyber.inneractive.sdk.config.remote.b r15 = r3.c
            com.fyber.inneractive.sdk.config.remote.b r13 = r6.e
            com.fyber.inneractive.sdk.config.t r0 = new com.fyber.inneractive.sdk.config.t
            r0.<init>()
            r19 = r2
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r2 = r12.a
            r20 = r10
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r10 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.BANNER
            if (r2 == r10) goto L_0x00c1
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r10 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.MRECT
            if (r2 == r10) goto L_0x00c1
            boolean r2 = r2.isFullscreenUnit()
            if (r2 == 0) goto L_0x00ba
            goto L_0x00c1
        L_0x00ba:
            r0 = r24
            r2 = r19
            r10 = r20
            goto L_0x0096
        L_0x00c1:
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r2 = r12.a
            r0.b = r2
            r2 = 3
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.Integer r2 = r12.c
            r18 = 0
            r10[r18] = r2
            if (r15 == 0) goto L_0x00d3
            java.lang.Integer r2 = r15.c
            goto L_0x00d4
        L_0x00d3:
            r2 = 0
        L_0x00d4:
            r17 = 1
            r10[r17] = r2
            if (r13 == 0) goto L_0x00dd
            java.lang.Integer r2 = r13.c
            goto L_0x00de
        L_0x00dd:
            r2 = 0
        L_0x00de:
            r16 = 2
            r10[r16] = r2
            r2 = 0
            java.lang.Object r10 = a((java.lang.Object) r2, (java.lang.Object[]) r10)
            java.lang.Integer r10 = (java.lang.Integer) r10
            r2 = 5
            r22 = r1
            if (r10 == 0) goto L_0x00fe
            int r1 = r10.intValue()
            if (r1 < r2) goto L_0x00fe
            int r1 = r10.intValue()
            r2 = 60
            if (r1 > r2) goto L_0x00fe
            r0.a = r10
        L_0x00fe:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r2 = 3
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.Boolean r2 = r12.b
            r18 = 0
            r10[r18] = r2
            if (r15 == 0) goto L_0x010e
            java.lang.Boolean r2 = r15.b
            goto L_0x010f
        L_0x010e:
            r2 = 0
        L_0x010f:
            r17 = 1
            r10[r17] = r2
            if (r13 == 0) goto L_0x0118
            java.lang.Boolean r2 = r13.b
            goto L_0x0119
        L_0x0118:
            r2 = 0
        L_0x0119:
            r16 = 2
            r10[r16] = r2
            java.lang.Object r2 = a((java.lang.Object) r1, (java.lang.Object[]) r10)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.c = r2
            r2 = 3
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.Integer r2 = r12.d
            r18 = 0
            r10[r18] = r2
            if (r15 == 0) goto L_0x013b
            java.lang.Integer r2 = r15.d
            goto L_0x013c
        L_0x013b:
            r2 = 0
        L_0x013c:
            r15 = 1
            r10[r15] = r2
            if (r13 == 0) goto L_0x0144
            java.lang.Integer r2 = r13.d
            goto L_0x0145
        L_0x0144:
            r2 = 0
        L_0x0145:
            r13 = 2
            r10[r13] = r2
            r2 = 0
            java.lang.Object r10 = a((java.lang.Object) r2, (java.lang.Object[]) r10)
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 == 0) goto L_0x0162
            int r2 = r10.intValue()
            r13 = 5
            if (r2 < r13) goto L_0x0162
            int r2 = r10.intValue()
            r13 = 60
            if (r2 > r13) goto L_0x0162
            r0.d = r10
        L_0x0162:
            java.lang.Integer r2 = r0.d
            if (r2 != 0) goto L_0x017a
            java.lang.Boolean r2 = r0.c
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x017a
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r2 = r12.a
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r10 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL
            if (r2 == r10) goto L_0x0178
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r10 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED
            if (r2 != r10) goto L_0x017a
        L_0x0178:
            r0.c = r1
        L_0x017a:
            r14.c = r0
            goto L_0x0183
        L_0x017d:
            r22 = r1
            r19 = r2
            r20 = r10
        L_0x0183:
            com.fyber.inneractive.sdk.config.remote.j r0 = r11.f
            if (r0 == 0) goto L_0x038f
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r0 = r0.j
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED
            if (r0 != r1) goto L_0x01ad
            com.fyber.inneractive.sdk.config.remote.b r0 = r11.c
            if (r0 != 0) goto L_0x01ad
            com.fyber.inneractive.sdk.config.t r0 = new com.fyber.inneractive.sdk.config.t
            r0.<init>()
            r14.c = r0
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.c = r2
            r2 = -1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            r0.d = r10
            com.fyber.inneractive.sdk.config.t r0 = r14.c
            r0.b = r1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.a = r2
        L_0x01ad:
            com.fyber.inneractive.sdk.config.c0 r0 = new com.fyber.inneractive.sdk.config.c0
            r0.<init>()
            com.fyber.inneractive.sdk.config.remote.j r2 = r11.f
            com.fyber.inneractive.sdk.config.remote.j r10 = r3.e
            com.fyber.inneractive.sdk.config.remote.j r12 = r6.d
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r13 = r2.j
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r15 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.LANDSCAPE
            if (r13 == r15) goto L_0x01da
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r15 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.SQUARE
            if (r13 == r15) goto L_0x01da
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r15 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL
            if (r13 == r15) goto L_0x01da
            r21 = r4
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r4 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.VERTICAL
            if (r13 == r4) goto L_0x01dc
            if (r13 == r1) goto L_0x01dc
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.MRECT
            if (r13 != r1) goto L_0x01d3
            goto L_0x01dc
        L_0x01d3:
            com.fyber.inneractive.sdk.config.y r1 = r14.e
            if (r1 == 0) goto L_0x0383
            r0.j = r15
            goto L_0x01de
        L_0x01da:
            r21 = r4
        L_0x01dc:
            r0.j = r13
        L_0x01de:
            r1 = 3
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.Boolean r1 = r2.a
            r13 = 0
            r4[r13] = r1
            if (r10 == 0) goto L_0x01eb
            java.lang.Boolean r1 = r10.a
            goto L_0x01ec
        L_0x01eb:
            r1 = 0
        L_0x01ec:
            r13 = 1
            r4[r13] = r1
            if (r12 == 0) goto L_0x01f4
            java.lang.Boolean r1 = r12.a
            goto L_0x01f5
        L_0x01f4:
            r1 = 0
        L_0x01f5:
            r13 = 2
            r4[r13] = r1
            r1 = 0
            java.lang.Object r4 = a((java.lang.Object) r1, (java.lang.Object[]) r4)
            if (r4 == 0) goto L_0x0383
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            r0.a = r4
            r4 = 5000(0x1388, float:7.006E-42)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r13 = 3
            java.lang.Object[] r15 = new java.lang.Object[r13]
            java.lang.Integer r13 = r2.b
            r18 = 0
            r15[r18] = r13
            if (r10 == 0) goto L_0x0217
            java.lang.Integer r13 = r10.b
            goto L_0x0218
        L_0x0217:
            r13 = r1
        L_0x0218:
            r17 = 1
            r15[r17] = r13
            if (r12 == 0) goto L_0x0221
            java.lang.Integer r13 = r12.b
            goto L_0x0222
        L_0x0221:
            r13 = r1
        L_0x0222:
            r16 = 2
            r15[r16] = r13
            java.lang.Object r4 = a((java.lang.Object) r4, (java.lang.Object[]) r15)
            java.lang.Integer r4 = (java.lang.Integer) r4
            r0.b = r4
            r4 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r4)
            r15 = 3
            java.lang.Object[] r1 = new java.lang.Object[r15]
            java.lang.Integer r15 = r2.c
            r1[r4] = r15
            if (r10 == 0) goto L_0x023f
            java.lang.Integer r4 = r10.c
            goto L_0x0240
        L_0x023f:
            r4 = 0
        L_0x0240:
            r15 = 1
            r1[r15] = r4
            if (r12 == 0) goto L_0x0248
            java.lang.Integer r4 = r12.c
            goto L_0x0249
        L_0x0248:
            r4 = 0
        L_0x0249:
            r15 = 2
            r1[r15] = r4
            java.lang.Object r1 = a((java.lang.Object) r13, (java.lang.Object[]) r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r4 = r1.intValue()
            if (r4 >= 0) goto L_0x025a
            r1 = 0
            goto L_0x025e
        L_0x025a:
            int r1 = r1.intValue()
        L_0x025e:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.c = r1
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r4 = 3
            java.lang.Object[] r13 = new java.lang.Object[r4]
            java.lang.Boolean r4 = r2.e
            r15 = 0
            r13[r15] = r4
            if (r10 == 0) goto L_0x0273
            java.lang.Boolean r4 = r10.e
            goto L_0x0274
        L_0x0273:
            r4 = 0
        L_0x0274:
            r15 = 1
            r13[r15] = r4
            if (r12 == 0) goto L_0x027c
            java.lang.Boolean r4 = r12.e
            goto L_0x027d
        L_0x027c:
            r4 = 0
        L_0x027d:
            r15 = 2
            r13[r15] = r4
            java.lang.Object r1 = a((java.lang.Object) r1, (java.lang.Object[]) r13)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r0.d = r1
            com.fyber.inneractive.sdk.config.enums.Orientation r1 = com.fyber.inneractive.sdk.config.enums.Orientation.USER
            r4 = 3
            java.lang.Object[] r13 = new java.lang.Object[r4]
            com.fyber.inneractive.sdk.config.enums.Orientation r4 = r2.g
            r15 = 0
            r13[r15] = r4
            if (r10 == 0) goto L_0x0297
            com.fyber.inneractive.sdk.config.enums.Orientation r4 = r10.g
            goto L_0x0298
        L_0x0297:
            r4 = 0
        L_0x0298:
            r15 = 1
            r13[r15] = r4
            if (r12 == 0) goto L_0x02a0
            com.fyber.inneractive.sdk.config.enums.Orientation r4 = r12.g
            goto L_0x02a1
        L_0x02a0:
            r4 = 0
        L_0x02a1:
            r15 = 2
            r13[r15] = r4
            java.lang.Object r1 = a((java.lang.Object) r1, (java.lang.Object[]) r13)
            com.fyber.inneractive.sdk.config.enums.Orientation r1 = (com.fyber.inneractive.sdk.config.enums.Orientation) r1
            r0.e = r1
            r1 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            r13 = 3
            java.lang.Object[] r15 = new java.lang.Object[r13]
            java.lang.Integer r13 = r2.i
            r15[r1] = r13
            if (r10 == 0) goto L_0x02bd
            java.lang.Integer r1 = r10.i
            goto L_0x02be
        L_0x02bd:
            r1 = 0
        L_0x02be:
            r13 = 1
            r15[r13] = r1
            if (r12 == 0) goto L_0x02c6
            java.lang.Integer r1 = r12.i
            goto L_0x02c7
        L_0x02c6:
            r1 = 0
        L_0x02c7:
            r13 = 2
            r15[r13] = r1
            java.lang.Object r1 = a((java.lang.Object) r4, (java.lang.Object[]) r15)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r4 = r1.intValue()
            if (r4 >= 0) goto L_0x02d8
            r1 = 0
            goto L_0x02dc
        L_0x02d8:
            int r1 = r1.intValue()
        L_0x02dc:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.f = r1
            r1 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4 = 3
            java.lang.Object[] r13 = new java.lang.Object[r4]
            java.lang.Integer r4 = r2.h
            r15 = 0
            r13[r15] = r4
            if (r10 == 0) goto L_0x02f5
            java.lang.Integer r4 = r10.h
            goto L_0x02f6
        L_0x02f5:
            r4 = 0
        L_0x02f6:
            r15 = 1
            r13[r15] = r4
            if (r12 == 0) goto L_0x02fe
            java.lang.Integer r4 = r12.h
            goto L_0x02ff
        L_0x02fe:
            r4 = 0
        L_0x02ff:
            r15 = 2
            r13[r15] = r4
            java.lang.Object r1 = a((java.lang.Object) r1, (java.lang.Object[]) r13)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r4 = r1.intValue()
            java.lang.Integer r13 = r0.b
            int r13 = r13.intValue()
            if (r4 <= r13) goto L_0x0316
            java.lang.Integer r1 = r0.b
        L_0x0316:
            r0.g = r1
            com.fyber.inneractive.sdk.config.enums.Skip r1 = com.fyber.inneractive.sdk.config.enums.Skip._0
            r4 = 3
            java.lang.Object[] r13 = new java.lang.Object[r4]
            com.fyber.inneractive.sdk.config.enums.Skip r4 = r2.d
            r15 = 0
            r13[r15] = r4
            if (r10 == 0) goto L_0x0327
            com.fyber.inneractive.sdk.config.enums.Skip r4 = r10.d
            goto L_0x0328
        L_0x0327:
            r4 = 0
        L_0x0328:
            r15 = 1
            r13[r15] = r4
            if (r12 == 0) goto L_0x0330
            com.fyber.inneractive.sdk.config.enums.Skip r4 = r12.d
            goto L_0x0331
        L_0x0330:
            r4 = 0
        L_0x0331:
            r15 = 2
            r13[r15] = r4
            java.lang.Object r1 = a((java.lang.Object) r1, (java.lang.Object[]) r13)
            com.fyber.inneractive.sdk.config.enums.Skip r1 = (com.fyber.inneractive.sdk.config.enums.Skip) r1
            r0.h = r1
            com.fyber.inneractive.sdk.config.enums.TapAction r1 = com.fyber.inneractive.sdk.config.enums.TapAction.DO_NOTHING
            r4 = 3
            java.lang.Object[] r13 = new java.lang.Object[r4]
            com.fyber.inneractive.sdk.config.enums.TapAction r2 = r2.f
            r4 = 0
            r13[r4] = r2
            if (r10 == 0) goto L_0x034b
            com.fyber.inneractive.sdk.config.enums.TapAction r2 = r10.f
            goto L_0x034c
        L_0x034b:
            r2 = 0
        L_0x034c:
            r4 = 1
            r13[r4] = r2
            if (r12 == 0) goto L_0x0354
            com.fyber.inneractive.sdk.config.enums.TapAction r2 = r12.f
            goto L_0x0355
        L_0x0354:
            r2 = 0
        L_0x0355:
            r10 = 2
            r13[r10] = r2
            java.lang.Object r1 = a((java.lang.Object) r1, (java.lang.Object[]) r13)
            com.fyber.inneractive.sdk.config.enums.TapAction r1 = (com.fyber.inneractive.sdk.config.enums.TapAction) r1
            r0.i = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.fyber.inneractive.sdk.config.remote.d[] r2 = new com.fyber.inneractive.sdk.config.remote.d[r4]
            r4 = 0
            r2[r4] = r11
            r2 = r2[r4]
            com.fyber.inneractive.sdk.config.remote.j r2 = r2.a()
            if (r2 == 0) goto L_0x037e
            java.util.List<java.lang.Integer> r4 = r2.k
            if (r4 == 0) goto L_0x037e
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x037e
            java.util.List<java.lang.Integer> r1 = r2.k
        L_0x037e:
            r0.k = r1
            r14.f = r0
            goto L_0x0391
        L_0x0383:
            r0 = r24
            r2 = r19
            r10 = r20
            r4 = r21
            r1 = r22
            goto L_0x0096
        L_0x038f:
            r21 = r4
        L_0x0391:
            com.fyber.inneractive.sdk.config.x r0 = new com.fyber.inneractive.sdk.config.x
            r0.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r2 = 3
            java.lang.Object[] r4 = new java.lang.Object[r2]
            com.fyber.inneractive.sdk.config.remote.f r2 = r11.d
            if (r2 == 0) goto L_0x03a5
            java.util.Set<com.fyber.inneractive.sdk.config.enums.Track> r2 = r2.a
            goto L_0x03a6
        L_0x03a5:
            r2 = 0
        L_0x03a6:
            r10 = 0
            r4[r10] = r2
            com.fyber.inneractive.sdk.config.remote.f r2 = r3.d
            if (r2 == 0) goto L_0x03b0
            java.util.Set<com.fyber.inneractive.sdk.config.enums.Track> r2 = r2.a
            goto L_0x03b1
        L_0x03b0:
            r2 = 0
        L_0x03b1:
            r10 = 1
            r4[r10] = r2
            com.fyber.inneractive.sdk.config.remote.f r2 = r6.c
            if (r2 == 0) goto L_0x03bb
            java.util.Set<com.fyber.inneractive.sdk.config.enums.Track> r2 = r2.a
            goto L_0x03bc
        L_0x03bb:
            r2 = 0
        L_0x03bc:
            r10 = 2
            r4[r10] = r2
            java.lang.Object r1 = a((java.lang.Object) r1, (java.lang.Object[]) r4)
            java.util.Set r1 = (java.util.Set) r1
            r0.a = r1
            r14.d = r0
            com.fyber.inneractive.sdk.config.e0 r0 = new com.fyber.inneractive.sdk.config.e0
            r0.<init>()
            com.fyber.inneractive.sdk.config.remote.k r1 = r11.g
            com.fyber.inneractive.sdk.config.remote.k r2 = r3.f
            com.fyber.inneractive.sdk.config.remote.k r4 = r6.f
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r12 = 3
            java.lang.Object[] r13 = new java.lang.Object[r12]
            if (r1 == 0) goto L_0x03e1
            java.lang.Integer r12 = r1.a
            goto L_0x03e2
        L_0x03e1:
            r12 = 0
        L_0x03e2:
            r15 = 0
            r13[r15] = r12
            if (r2 == 0) goto L_0x03ea
            java.lang.Integer r12 = r2.a
            goto L_0x03eb
        L_0x03ea:
            r12 = 0
        L_0x03eb:
            r13[r10] = r12
            if (r4 == 0) goto L_0x03f2
            java.lang.Integer r10 = r4.a
            goto L_0x03f3
        L_0x03f2:
            r10 = 0
        L_0x03f3:
            r12 = 2
            r13[r12] = r10
            java.lang.Object r10 = a((java.lang.Object) r11, (java.lang.Object[]) r13)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r11 = r10.intValue()
            r12 = 100
            if (r11 > 0) goto L_0x0413
            int r11 = r10.intValue()
            if (r11 > r12) goto L_0x040b
            goto L_0x0413
        L_0x040b:
            r11 = 1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            r0.a = r10
            goto L_0x0415
        L_0x0413:
            r0.a = r10
        L_0x0415:
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r13 = 3
            java.lang.Object[] r15 = new java.lang.Object[r13]
            if (r1 == 0) goto L_0x0422
            java.lang.Integer r13 = r1.b
            goto L_0x0423
        L_0x0422:
            r13 = 0
        L_0x0423:
            r15[r10] = r13
            if (r2 == 0) goto L_0x042a
            java.lang.Integer r10 = r2.b
            goto L_0x042b
        L_0x042a:
            r10 = 0
        L_0x042b:
            r13 = 1
            r15[r13] = r10
            if (r4 == 0) goto L_0x0433
            java.lang.Integer r10 = r4.b
            goto L_0x0434
        L_0x0433:
            r10 = 0
        L_0x0434:
            r13 = 2
            r15[r13] = r10
            java.lang.Object r10 = a((java.lang.Object) r11, (java.lang.Object[]) r15)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r11 = r10.intValue()
            if (r11 >= 0) goto L_0x0452
            int r11 = r10.intValue()
            if (r11 > r12) goto L_0x044a
            goto L_0x0452
        L_0x044a:
            r11 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            r0.b = r10
            goto L_0x0454
        L_0x0452:
            r0.b = r10
        L_0x0454:
            java.util.HashSet r10 = new java.util.HashSet
            r10.<init>()
            r11 = 3
            java.lang.Object[] r11 = new java.lang.Object[r11]
            if (r1 == 0) goto L_0x0461
            java.util.Set<com.fyber.inneractive.sdk.config.enums.Vendor> r1 = r1.c
            goto L_0x0462
        L_0x0461:
            r1 = 0
        L_0x0462:
            r12 = 0
            r11[r12] = r1
            if (r2 == 0) goto L_0x046b
            java.util.Set<com.fyber.inneractive.sdk.config.enums.Vendor> r2 = r2.c
            r1 = 1
            goto L_0x046d
        L_0x046b:
            r1 = 1
            r2 = 0
        L_0x046d:
            r11[r1] = r2
            if (r4 == 0) goto L_0x0475
            java.util.Set<com.fyber.inneractive.sdk.config.enums.Vendor> r15 = r4.c
            r2 = 2
            goto L_0x0477
        L_0x0475:
            r2 = 2
            r15 = 0
        L_0x0477:
            r11[r2] = r15
            java.lang.Object r4 = a((java.lang.Object) r10, (java.lang.Object[]) r11)
            java.util.Set r4 = (java.util.Set) r4
            r0.c = r4
            r14.g = r0
            if (r8 == 0) goto L_0x04a7
            if (r4 == 0) goto L_0x04a7
            java.util.Iterator r0 = r4.iterator()
        L_0x048b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x04a7
            java.lang.Object r4 = r0.next()
            com.fyber.inneractive.sdk.config.enums.Vendor r4 = (com.fyber.inneractive.sdk.config.enums.Vendor) r4
            if (r4 == 0) goto L_0x048b
            java.util.Set<com.fyber.inneractive.sdk.config.enums.Vendor> r10 = r8.a
            boolean r10 = r10.contains(r4)
            if (r10 != 0) goto L_0x048b
            java.util.Set<com.fyber.inneractive.sdk.config.enums.Vendor> r10 = r8.a
            r10.add(r4)
            goto L_0x048b
        L_0x04a7:
            java.util.List<com.fyber.inneractive.sdk.config.a0> r0 = r9.a
            r0.add(r14)
            java.lang.String r0 = r14.a
            r7.put(r0, r14)
            r0 = r24
            r2 = r19
            r10 = r20
            r4 = r21
            r1 = r22
            goto L_0x007c
        L_0x04bd:
            r22 = r1
            r19 = r2
            r0 = r24
            goto L_0x0063
        L_0x04c5:
            r22 = r1
            r19 = r2
            r0 = r4
            r0.put(r5, r9)
            r0 = r24
            goto L_0x001b
        L_0x04d1:
            r22 = r1
            return r22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.config.c.a(com.fyber.inneractive.sdk.config.remote.e):com.fyber.inneractive.sdk.config.IAConfigManager$c");
    }

    public static Object a(Object obj, Object... objArr) {
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                return obj2;
            }
        }
        return obj;
    }

    public Object a(String str) throws Exception {
        try {
            IAConfigManager iAConfigManager = IAConfigManager.M;
            iAConfigManager.D.b();
            e a2 = e.a(new JSONObject(str));
            String str2 = iAConfigManager.c;
            if (a2 == null || !str2.equals(a2.a.a)) {
                IAlog.b("internal error while parsing local configuration", new Object[0]);
                if (a2 != null) {
                    if (!str2.equals(a2.a.a)) {
                        throw new InvalidAppIdException();
                    }
                }
                a((Throwable) null, str);
                return null;
            }
            a2.d = str;
            return a(a2);
        } catch (Throwable th) {
            a(th, str);
            IAlog.b("Exception Error while parsing local configuration", new Object[0]);
            throw th;
        }
    }
}
