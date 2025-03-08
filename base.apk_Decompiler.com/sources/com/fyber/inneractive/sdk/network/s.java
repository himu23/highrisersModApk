package com.fyber.inneractive.sdk.network;

import android.os.Build;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.n;
import com.ironsource.m2;
import com.ironsource.t4;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s extends l {

    public static class a {
        public static final SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        public InneractiveAdRequest a;
        public q b;
        public r c;
        public JSONArray d;
        public e e;
        public JSONArray f;
        public boolean g;

        /* renamed from: com.fyber.inneractive.sdk.network.s$a$a  reason: collision with other inner class name */
        public class C0104a implements Runnable {
            public final /* synthetic */ s a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;
            public final /* synthetic */ Object f;
            public final /* synthetic */ String g;

            public C0104a(s sVar, String str, String str2, String str3, String str4, Object obj, String str5) {
                this.a = sVar;
                this.b = str;
                this.c = str2;
                this.d = str3;
                this.e = str4;
                this.f = obj;
                this.g = str5;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:44:0x01a7, code lost:
                r2 = r11.h.e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r11 = this;
                    com.fyber.inneractive.sdk.network.s r0 = r11.a
                    java.lang.String r1 = r11.b
                    java.lang.String r2 = "contentid"
                    r0.a(r2, r1)
                    com.fyber.inneractive.sdk.network.s r0 = r11.a
                    java.lang.String r1 = r11.c
                    java.lang.String r2 = "fairbidv"
                    r0.a(r2, r1)
                    com.fyber.inneractive.sdk.network.s$a r0 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.network.q r1 = r0.b
                    java.lang.String r2 = "%s %s"
                    r3 = 2
                    r4 = 0
                    r5 = 1
                    r6 = 0
                    if (r1 == 0) goto L_0x005d
                    com.fyber.inneractive.sdk.network.s r0 = r11.a
                    int r1 = r1.val
                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                    java.lang.String r7 = "err"
                    r0.a(r7, r1)
                    com.fyber.inneractive.sdk.network.s$a r0 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.network.q r0 = r0.b
                    r0.getClass()
                    com.fyber.inneractive.sdk.network.y0 r0 = com.fyber.inneractive.sdk.network.y0.ERROR_TABLE
                    java.lang.String r0 = r0.e()
                    java.lang.Object[] r1 = new java.lang.Object[r5]
                    com.fyber.inneractive.sdk.network.s$a r7 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.network.q r7 = r7.b
                    r1[r4] = r7
                    java.lang.String r7 = "Event dispatcher - dispatching error: %s"
                    com.fyber.inneractive.sdk.util.IAlog.a(r7, r1)
                    int r1 = com.fyber.inneractive.sdk.util.IAlog.a
                    java.lang.Object[] r1 = new java.lang.Object[r3]
                    java.lang.String r7 = "DISPATCHED_SDK_ERROR"
                    r1[r4] = r7
                    com.fyber.inneractive.sdk.network.s$a r7 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.network.q r7 = r7.b
                    int r7 = r7.val
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                    r1[r5] = r7
                    com.fyber.inneractive.sdk.util.IAlog.a(r5, r6, r2, r1)
                    goto L_0x00a1
                L_0x005d:
                    com.fyber.inneractive.sdk.network.r r0 = r0.c
                    if (r0 == 0) goto L_0x00a0
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    int r0 = r0.val
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    java.lang.String r7 = "event"
                    r1.a(r7, r0)
                    com.fyber.inneractive.sdk.network.s$a r0 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.network.r r0 = r0.c
                    r0.getClass()
                    com.fyber.inneractive.sdk.network.y0 r0 = com.fyber.inneractive.sdk.network.y0.EVENT_TABLE
                    java.lang.String r0 = r0.e()
                    java.lang.Object[] r1 = new java.lang.Object[r5]
                    com.fyber.inneractive.sdk.network.s$a r7 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.network.r r7 = r7.c
                    r1[r4] = r7
                    java.lang.String r7 = "Event dispatcher - dispatching event: %s"
                    com.fyber.inneractive.sdk.util.IAlog.a(r7, r1)
                    int r1 = com.fyber.inneractive.sdk.util.IAlog.a
                    java.lang.Object[] r1 = new java.lang.Object[r3]
                    java.lang.String r7 = "DISPATCHED_SDK_EVENT"
                    r1[r4] = r7
                    com.fyber.inneractive.sdk.network.s$a r7 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.network.r r7 = r7.c
                    int r7 = r7.val
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                    r1[r5] = r7
                    com.fyber.inneractive.sdk.util.IAlog.a(r5, r6, r2, r1)
                    goto L_0x00a1
                L_0x00a0:
                    r0 = r6
                L_0x00a1:
                    java.lang.String r1 = r11.d
                    boolean r1 = android.text.TextUtils.isEmpty(r1)
                    if (r1 != 0) goto L_0x00b2
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    java.lang.String r2 = r11.d
                    java.lang.String r7 = "placement_type"
                    r1.a(r7, r2)
                L_0x00b2:
                    java.lang.String r1 = r11.e
                    boolean r1 = android.text.TextUtils.isEmpty(r1)
                    if (r1 != 0) goto L_0x00c3
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    java.lang.String r2 = r11.e
                    java.lang.String r7 = "spot_id"
                    r1.a(r7, r2)
                L_0x00c3:
                    boolean r1 = com.fyber.inneractive.sdk.external.InneractiveAdManager.isCurrentUserAChild()
                    if (r1 != 0) goto L_0x00d4
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    java.lang.String r2 = com.fyber.inneractive.sdk.util.n.h()
                    java.lang.String r7 = "ciso"
                    r1.a(r7, r2)
                L_0x00d4:
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    java.lang.Object r2 = r11.f
                    java.lang.String r7 = "ad_type"
                    r1.a(r7, r2)
                    com.fyber.inneractive.sdk.network.s$a r1 = com.fyber.inneractive.sdk.network.s.a.this
                    boolean r1 = r1.g
                    if (r1 == 0) goto L_0x00f1
                    java.lang.String r1 = r11.g
                    boolean r1 = android.text.TextUtils.isEmpty(r1)
                    if (r1 != 0) goto L_0x00f1
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    java.lang.String r2 = r11.g
                    r1.c = r2
                L_0x00f1:
                    java.lang.String r1 = "UTC"
                    java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
                    java.util.Calendar r1 = java.util.Calendar.getInstance(r1)
                    com.fyber.inneractive.sdk.network.s r2 = r11.a
                    com.fyber.inneractive.sdk.util.k0 r7 = com.fyber.inneractive.sdk.util.k0.e()
                    java.lang.String r7 = r7.key
                    java.lang.String r8 = "n"
                    r2.a(r8, r7)
                    com.fyber.inneractive.sdk.network.s r2 = r11.a
                    long r7 = r1.getTimeInMillis()
                    java.lang.Long r7 = java.lang.Long.valueOf(r7)
                    java.lang.String r8 = "date_created"
                    r2.a(r8, r7)
                    com.fyber.inneractive.sdk.network.s r2 = r11.a     // Catch:{ all -> 0x0129 }
                    java.lang.String r7 = "day"
                    java.text.SimpleDateFormat r8 = com.fyber.inneractive.sdk.network.s.a.h     // Catch:{ all -> 0x0129 }
                    java.util.Date r9 = r1.getTime()     // Catch:{ all -> 0x0129 }
                    java.lang.String r8 = r8.format(r9)     // Catch:{ all -> 0x0129 }
                    r2.a(r7, r8)     // Catch:{ all -> 0x0129 }
                    goto L_0x012a
                L_0x0129:
                L_0x012a:
                    com.fyber.inneractive.sdk.network.s r2 = r11.a
                    r7 = 11
                    int r1 = r1.get(r7)
                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                    java.lang.String r7 = "hour"
                    r2.a(r7, r1)
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    r2.append(r0)
                    com.fyber.inneractive.sdk.network.s$a r0 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.network.q r7 = r0.b
                    if (r7 == 0) goto L_0x0152
                    int r0 = r7.val
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                    goto L_0x015a
                L_0x0152:
                    com.fyber.inneractive.sdk.network.r r0 = r0.c
                    int r0 = r0.val
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                L_0x015a:
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    java.lang.String r2 = "table"
                    r1.a(r2, r0)
                    com.fyber.inneractive.sdk.network.s$a r0 = com.fyber.inneractive.sdk.network.s.a.this
                    org.json.JSONArray r0 = r0.d
                    if (r0 == 0) goto L_0x017d
                    int r0 = r0.length()
                    if (r0 <= 0) goto L_0x017d
                    com.fyber.inneractive.sdk.network.s r0 = r11.a
                    com.fyber.inneractive.sdk.network.s$a r1 = com.fyber.inneractive.sdk.network.s.a.this
                    org.json.JSONArray r1 = r1.d
                    java.lang.String r2 = "experiments"
                    r0.a(r2, r1)
                L_0x017d:
                    com.fyber.inneractive.sdk.network.s$a r0 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.response.e r0 = r0.e
                    java.lang.String r1 = "1"
                    if (r0 == 0) goto L_0x0190
                    boolean r0 = r0.B
                    if (r0 == 0) goto L_0x0190
                    com.fyber.inneractive.sdk.network.s r0 = r11.a
                    java.lang.String r2 = "sdk_bidding"
                    r0.a(r2, r1)
                L_0x0190:
                    boolean r0 = com.fyber.inneractive.sdk.external.InneractiveAdManager.isCurrentUserAChild()
                    if (r0 == 0) goto L_0x019d
                    com.fyber.inneractive.sdk.network.s r0 = r11.a
                    java.lang.String r2 = "child_mode"
                    r0.a(r2, r1)
                L_0x019d:
                    com.fyber.inneractive.sdk.config.IAConfigManager r0 = com.fyber.inneractive.sdk.config.IAConfigManager.M
                    com.fyber.inneractive.sdk.ignite.c r2 = r0.E
                    boolean r2 = r2.d()
                    if (r2 == 0) goto L_0x01b5
                    com.fyber.inneractive.sdk.network.s$a r2 = com.fyber.inneractive.sdk.network.s.a.this
                    com.fyber.inneractive.sdk.response.e r2 = r2.e
                    if (r2 == 0) goto L_0x01b5
                    com.fyber.inneractive.sdk.ignite.k r2 = r2.F
                    com.fyber.inneractive.sdk.ignite.k r7 = com.fyber.inneractive.sdk.ignite.k.NONE
                    if (r2 == r7) goto L_0x01b5
                    r2 = 1
                    goto L_0x01b6
                L_0x01b5:
                    r2 = 0
                L_0x01b6:
                    com.fyber.inneractive.sdk.network.s r7 = r11.a
                    if (r2 == 0) goto L_0x01bb
                    goto L_0x01bd
                L_0x01bb:
                    java.lang.String r1 = "0"
                L_0x01bd:
                    java.lang.String r2 = "ignite"
                    r7.a(r2, r1)
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    com.fyber.inneractive.sdk.ignite.c r2 = r0.E
                    java.lang.String r2 = r2.c
                    java.lang.String r7 = "ignitep"
                    r1.a(r7, r2)
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    com.fyber.inneractive.sdk.ignite.c r2 = r0.E
                    java.lang.String r2 = r2.d
                    java.lang.String r7 = "ignitev"
                    r1.a(r7, r2)
                    com.fyber.inneractive.sdk.config.global.s r0 = r0.L
                    org.json.JSONArray r0 = r0.c()
                    if (r0 == 0) goto L_0x01ed
                    int r1 = r0.length()
                    if (r1 <= 0) goto L_0x01ed
                    com.fyber.inneractive.sdk.network.s r1 = r11.a
                    java.lang.String r2 = "s_experiments"
                    r1.a(r2, r0)
                L_0x01ed:
                    com.fyber.inneractive.sdk.network.s$a r0 = com.fyber.inneractive.sdk.network.s.a.this
                    org.json.JSONArray r0 = r0.f
                    if (r0 == 0) goto L_0x0219
                    int r1 = r0.length()
                    if (r1 <= 0) goto L_0x0219
                    r1 = 0
                L_0x01fa:
                    int r2 = r0.length()
                    if (r1 >= r2) goto L_0x0219
                    org.json.JSONObject r2 = r0.optJSONObject(r1)
                    int r2 = r2.length()
                    if (r2 < r5) goto L_0x0216
                    com.fyber.inneractive.sdk.network.s r0 = r11.a
                    com.fyber.inneractive.sdk.network.s$a r1 = com.fyber.inneractive.sdk.network.s.a.this
                    org.json.JSONArray r1 = r1.f
                    java.lang.String r2 = "extra"
                    r0.a(r2, r1)
                    goto L_0x0219
                L_0x0216:
                    int r1 = r1 + 1
                    goto L_0x01fa
                L_0x0219:
                    com.fyber.inneractive.sdk.network.s r0 = r11.a
                    r0.getClass()
                    java.lang.String r1 = r0.a
                    boolean r1 = android.text.TextUtils.isEmpty(r1)
                    if (r1 != 0) goto L_0x02dc
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r0.b
                    if (r1 == 0) goto L_0x02dc
                    int r1 = r1.size()
                    if (r1 == 0) goto L_0x02dc
                    com.fyber.inneractive.sdk.config.IAConfigManager r1 = com.fyber.inneractive.sdk.config.IAConfigManager.M
                    com.fyber.inneractive.sdk.network.c r1 = r1.H
                    r1.getClass()
                    org.json.JSONObject r2 = new org.json.JSONObject
                    r2.<init>()
                    java.util.Map<java.lang.String, java.lang.Object> r7 = r0.b
                    java.util.Set r8 = r7.keySet()
                    java.util.Iterator r8 = r8.iterator()
                L_0x0246:
                    boolean r9 = r8.hasNext()
                    if (r9 == 0) goto L_0x025e
                    java.lang.Object r9 = r8.next()
                    java.lang.String r9 = (java.lang.String) r9
                    java.lang.Object r10 = r7.get(r9)
                    if (r10 == 0) goto L_0x0246
                    r2.put(r9, r10)     // Catch:{ JSONException -> 0x025c }
                    goto L_0x0246
                L_0x025c:
                    goto L_0x0246
                L_0x025e:
                    java.lang.String r0 = r0.c
                    if (r0 == 0) goto L_0x029d
                    int r7 = r0.length()
                    r8 = 51200(0xc800, float:7.1746E-41)
                    if (r7 <= r8) goto L_0x028f
                    java.lang.String r9 = "iawrapper"
                    int r9 = r0.indexOf(r9)
                    r10 = -1
                    if (r9 != r10) goto L_0x0275
                    r9 = 0
                L_0x0275:
                    r10 = 51199(0xc7ff, float:7.1745E-41)
                    java.lang.String r0 = r0.substring(r9, r10)
                    java.lang.Object[] r9 = new java.lang.Object[r3]
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                    r9[r4] = r7
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
                    r9[r5] = r7
                    java.lang.String r7 = "Sdk event dispatcher: message size %d is too long! trimming message to %d Characters"
                    com.fyber.inneractive.sdk.util.IAlog.a(r7, r9)
                L_0x028f:
                    java.lang.String r7 = "ad"
                    r2.put(r7, r0)     // Catch:{ JSONException -> 0x0295 }
                    goto L_0x029d
                L_0x0295:
                    r0 = move-exception
                    java.lang.Object[] r7 = new java.lang.Object[r4]
                    java.lang.String r8 = "Failed inserting ad body to json"
                    com.fyber.inneractive.sdk.util.IAlog.a(r8, r0, r7)
                L_0x029d:
                    int r0 = com.fyber.inneractive.sdk.util.IAlog.a
                    int r7 = com.fyber.inneractive.sdk.util.IAlog.a
                    if (r0 != r5) goto L_0x02b6
                    java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x02b5 }
                    java.lang.String r7 = "%s, Event: %s"
                    java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x02b5 }
                    java.lang.String r8 = "SDK_EVENT"
                    r3[r4] = r8     // Catch:{ all -> 0x02b5 }
                    r3[r5] = r0     // Catch:{ all -> 0x02b5 }
                    com.fyber.inneractive.sdk.util.IAlog.a(r5, r6, r7, r3)     // Catch:{ all -> 0x02b5 }
                    goto L_0x02b6
                L_0x02b5:
                L_0x02b6:
                    java.util.concurrent.BlockingQueue<org.json.JSONObject> r0 = r1.a
                    r0.offer(r2)
                    java.util.concurrent.BlockingQueue<org.json.JSONObject> r0 = r1.a
                    int r0 = r0.size()
                    r2 = 30
                    if (r0 <= r2) goto L_0x02dc
                    android.os.Handler r0 = r1.d
                    r2 = 12312329(0xbbdf09, float:1.7253248E-38)
                    if (r0 == 0) goto L_0x02d7
                    boolean r0 = r0.hasMessages(r2)
                    if (r0 == 0) goto L_0x02d7
                    android.os.Handler r0 = r1.d
                    r0.removeMessages(r2)
                L_0x02d7:
                    r3 = 0
                    r1.a(r2, r3)
                L_0x02dc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.s.a.C0104a.run():void");
            }
        }

        public a(q qVar) {
            this(qVar, (InneractiveAdRequest) null, (e) null, (JSONArray) null);
        }

        public a a(Object... objArr) {
            if (objArr.length > 0) {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < objArr.length - 1; i += 2) {
                    String obj = objArr[i].toString();
                    Object obj2 = objArr[i + 1];
                    try {
                        jSONObject.put(obj, obj2);
                    } catch (Exception unused) {
                        IAlog.e("Got exception adding param to json object: %s, %s", obj, obj2);
                    }
                }
                this.f.put(jSONObject);
            }
            return this;
        }

        public a(q qVar, InneractiveAdRequest inneractiveAdRequest, e eVar, JSONArray jSONArray) {
            this(eVar);
            this.b = qVar;
            this.a = inneractiveAdRequest;
            this.d = jSONArray;
        }

        public a(r rVar, InneractiveAdRequest inneractiveAdRequest, e eVar, JSONArray jSONArray) {
            this(eVar);
            this.c = rVar;
            this.a = inneractiveAdRequest;
            this.d = jSONArray;
        }

        public a(e eVar) {
            this.g = false;
            this.e = eVar;
            this.f = new JSONArray();
        }

        /* JADX WARNING: Removed duplicated region for block: B:71:0x00ee  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x00fe  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x011d  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x012a  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x012c  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x013a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.String r20) {
            /*
                r19 = this;
                r9 = r19
                com.fyber.inneractive.sdk.response.e r0 = r9.e
                r1 = 0
                if (r0 == 0) goto L_0x005d
                com.fyber.inneractive.sdk.external.ImpressionData r0 = r0.r
                if (r0 == 0) goto L_0x0010
                java.lang.String r0 = r0.getImpressionId()
                goto L_0x0011
            L_0x0010:
                r0 = r1
            L_0x0011:
                com.fyber.inneractive.sdk.response.e r2 = r9.e
                com.fyber.inneractive.sdk.external.ImpressionData r2 = r2.r
                if (r2 == 0) goto L_0x001c
                java.lang.String r2 = r2.getDemandSource()
                goto L_0x001d
            L_0x001c:
                r2 = r1
            L_0x001d:
                com.fyber.inneractive.sdk.response.e r3 = r9.e
                com.fyber.inneractive.sdk.external.ImpressionData r3 = r3.r
                if (r3 == 0) goto L_0x0028
                java.lang.Long r3 = r3.getDemandId()
                goto L_0x0029
            L_0x0028:
                r3 = r1
            L_0x0029:
                com.fyber.inneractive.sdk.response.e r4 = r9.e
                com.fyber.inneractive.sdk.external.ImpressionData r4 = r4.r
                if (r4 == 0) goto L_0x0034
                java.lang.String r4 = r4.getCreativeId()
                goto L_0x0035
            L_0x0034:
                r4 = r1
            L_0x0035:
                com.fyber.inneractive.sdk.response.e r5 = r9.e
                com.fyber.inneractive.sdk.external.ImpressionData r5 = r5.r
                if (r5 == 0) goto L_0x0040
                java.lang.String r5 = r5.getAdvertiserDomain()
                goto L_0x0041
            L_0x0040:
                r5 = r1
            L_0x0041:
                com.fyber.inneractive.sdk.response.e r6 = r9.e
                com.fyber.inneractive.sdk.external.ImpressionData r6 = r6.r
                if (r6 == 0) goto L_0x0054
                java.lang.String r6 = r6.getCampaignId()
                r12 = r0
                r13 = r2
                r14 = r3
                r15 = r4
                r16 = r5
                r17 = r6
                goto L_0x0065
            L_0x0054:
                r12 = r0
                r17 = r1
                r13 = r2
                r14 = r3
                r15 = r4
                r16 = r5
                goto L_0x0065
            L_0x005d:
                r12 = r1
                r13 = r12
                r14 = r13
                r15 = r14
                r16 = r15
                r17 = r16
            L_0x0065:
                com.fyber.inneractive.sdk.network.s r2 = new com.fyber.inneractive.sdk.network.s
                com.fyber.inneractive.sdk.config.IAConfigManager r0 = com.fyber.inneractive.sdk.config.IAConfigManager.M
                java.lang.String r11 = r0.c
                r10 = r2
                r18 = r20
                r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r3 = r9.a
                if (r3 != 0) goto L_0x0077
                r3 = r1
                goto L_0x007b
            L_0x0077:
                com.fyber.inneractive.sdk.config.b0 r3 = r3.getSelectedUnitConfig()
            L_0x007b:
                if (r3 == 0) goto L_0x00aa
                com.fyber.inneractive.sdk.config.a0 r3 = (com.fyber.inneractive.sdk.config.a0) r3
                com.fyber.inneractive.sdk.config.x r4 = r3.d
                com.fyber.inneractive.sdk.config.enums.Track r5 = com.fyber.inneractive.sdk.config.enums.Track.ERRORS
                java.util.Set<com.fyber.inneractive.sdk.config.enums.Track> r4 = r4.a
                if (r4 != 0) goto L_0x0088
                goto L_0x00a9
            L_0x0088:
                boolean r4 = r4.contains(r5)
                if (r4 == 0) goto L_0x00a9
                com.fyber.inneractive.sdk.config.t r4 = r3.c
                if (r4 == 0) goto L_0x009b
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r4 = r4.b
                if (r4 == 0) goto L_0x009b
                boolean r3 = r4.isDeprecated()
                goto L_0x00a7
            L_0x009b:
                com.fyber.inneractive.sdk.config.c0 r3 = r3.f
                if (r3 == 0) goto L_0x00aa
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r3 = r3.j
                if (r3 == 0) goto L_0x00aa
                boolean r3 = r3.isDeprecated()
            L_0x00a7:
                if (r3 == 0) goto L_0x00aa
            L_0x00a9:
                return
            L_0x00aa:
                com.fyber.inneractive.sdk.response.e r3 = r9.e
                if (r3 != 0) goto L_0x00b0
                r3 = r1
                goto L_0x00b2
            L_0x00b0:
                java.lang.String r3 = r3.d
            L_0x00b2:
                java.lang.String r4 = r0.t
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                if (r4 == 0) goto L_0x00bc
                r4 = r1
                goto L_0x00be
            L_0x00bc:
                java.lang.String r4 = r0.t
            L_0x00be:
                com.fyber.inneractive.sdk.network.q r5 = r9.b
                if (r5 != 0) goto L_0x00cf
                com.fyber.inneractive.sdk.network.r r5 = r9.c
                if (r5 != 0) goto L_0x00cf
                r0 = 0
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.String r1 = "Sdk event dispatcher - error id or event id must be provided"
                com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)
                return
            L_0x00cf:
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r5 = r9.a
                if (r5 == 0) goto L_0x00d9
                java.lang.String r5 = r5.getSpotId()
            L_0x00d7:
                r6 = r5
                goto L_0x00e1
            L_0x00d9:
                com.fyber.inneractive.sdk.response.e r5 = r9.e
                if (r5 == 0) goto L_0x00e0
                java.lang.String r5 = r5.A
                goto L_0x00d7
            L_0x00e0:
                r6 = r1
            L_0x00e1:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r7 = r0.m
                boolean r7 = android.text.TextUtils.isEmpty(r7)
                if (r7 != 0) goto L_0x00f8
                java.lang.String r0 = r0.m
                r5.append(r0)
                java.lang.String r0 = "_"
                r5.append(r0)
            L_0x00f8:
                com.fyber.inneractive.sdk.response.e r0 = r9.e
                if (r0 != 0) goto L_0x00fe
                r0 = r1
                goto L_0x0100
            L_0x00fe:
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r0 = r0.n
            L_0x0100:
                if (r0 != 0) goto L_0x0116
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r7 = r9.a
                if (r7 == 0) goto L_0x0116
                java.lang.String r7 = r7.getSpotId()
                if (r7 == 0) goto L_0x0116
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r0 = r9.a
                java.lang.String r0 = r0.getSpotId()
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r0 = com.fyber.inneractive.sdk.serverapi.a.a((java.lang.String) r0)
            L_0x0116:
                if (r0 == 0) goto L_0x011d
                java.lang.String r0 = r0.toString()
                goto L_0x011f
            L_0x011d:
                java.lang.String r0 = "unknown"
            L_0x011f:
                r5.append(r0)
                java.lang.String r5 = r5.toString()
                com.fyber.inneractive.sdk.response.e r0 = r9.e
                if (r0 != 0) goto L_0x012c
                r7 = r1
                goto L_0x0133
            L_0x012c:
                int r0 = r0.g
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r7 = r0
            L_0x0133:
                com.fyber.inneractive.sdk.response.e r0 = r9.e
                if (r0 != 0) goto L_0x013a
                java.lang.String r0 = ""
                goto L_0x013c
            L_0x013a:
                java.lang.String r0 = r0.h
            L_0x013c:
                r8 = r0
                com.fyber.inneractive.sdk.network.s$a$a r10 = new com.fyber.inneractive.sdk.network.s$a$a
                r0 = r10
                r1 = r19
                r0.<init>(r2, r3, r4, r5, r6, r7, r8)
                com.fyber.inneractive.sdk.util.q.a(r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.s.a.a(java.lang.String):void");
        }
    }

    public static class b {
        public JSONObject a = new JSONObject();

        public b a(String str, Object obj) {
            try {
                this.a.put(str, obj);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", str, obj);
            }
            return this;
        }
    }

    public s(String str, String str2, String str3, Long l, String str4, String str5, String str6, String str7) {
        super(com.fyber.inneractive.sdk.config.a.b());
        a("osn", m2.e);
        a(t4.y, Build.VERSION.RELEASE);
        a(t4.u, n.i());
        a(t4.J, str7 == null ? "8.2.5" : str7);
        a("pkgn", n.l());
        a("pkgv", n.m());
        a("appid", str);
        a("session", str2);
        a("adnt", str3);
        a("adnt_id", l);
        a("creative_id", str4);
        a("adomain", str5);
        a("campaign_id", str6);
    }
}
