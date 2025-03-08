package com.fyber.inneractive.sdk.network;

import android.os.Handler;
import android.os.HandlerThread;
import com.fyber.inneractive.sdk.util.o0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class c implements o0 {
    public final BlockingQueue<JSONObject> a = new LinkedBlockingQueue();
    public JSONArray b = new JSONArray();
    public final HandlerThread c = new HandlerThread("EventCollectorHandlerThread", 0);
    public Handler d;
    public int e;
    public boolean f = false;
    public boolean g = false;

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;

        public a(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public void run() {
            c.this.d.sendEmptyMessageDelayed(this.a, this.b);
        }
    }

    /* JADX WARNING: type inference failed for: r11v21, types: [org.json.JSONObject] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r11) {
        /*
            r10 = this;
            int r11 = r11.what
            r0 = 12312329(0xbbdf09, float:1.7253248E-38)
            if (r11 == r0) goto L_0x000c
            r1 = 20150330(0x133783a, float:3.2963366E-38)
            if (r11 != r1) goto L_0x0087
        L_0x000c:
            boolean r11 = r10.f
            if (r11 == 0) goto L_0x0078
            java.util.concurrent.BlockingQueue<org.json.JSONObject> r11 = r10.a
            int r11 = r11.size()
            if (r11 <= 0) goto L_0x0078
        L_0x0018:
            java.util.concurrent.BlockingQueue<org.json.JSONObject> r11 = r10.a
            int r11 = r11.size()
            r1 = 0
            if (r11 <= 0) goto L_0x0034
            java.util.concurrent.BlockingQueue<org.json.JSONObject> r11 = r10.a     // Catch:{ all -> 0x002b }
            java.lang.Object r11 = r11.poll()     // Catch:{ all -> 0x002b }
            org.json.JSONObject r11 = (org.json.JSONObject) r11     // Catch:{ all -> 0x002b }
            r1 = r11
            goto L_0x002c
        L_0x002b:
        L_0x002c:
            if (r1 == 0) goto L_0x0018
            org.json.JSONArray r11 = r10.b
            r11.put(r1)
            goto L_0x0018
        L_0x0034:
            org.json.JSONArray r11 = r10.b
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x0078
            org.json.JSONArray r5 = r10.b
            java.lang.String r11 = com.fyber.inneractive.sdk.config.a.b()
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x004b }
            goto L_0x004c
        L_0x004b:
        L_0x004c:
            if (r1 == 0) goto L_0x0071
            com.fyber.inneractive.sdk.network.i0 r8 = new com.fyber.inneractive.sdk.network.i0
            com.fyber.inneractive.sdk.network.e r9 = new com.fyber.inneractive.sdk.network.e
            r2 = r9
            r3 = r10
            r4 = r11
            r2.<init>(r3, r4, r5, r6)
            com.fyber.inneractive.sdk.network.x r2 = com.fyber.inneractive.sdk.network.x.a()
            com.fyber.inneractive.sdk.network.g r2 = r2.b()
            r8.<init>(r9, r11, r1, r2)
            com.fyber.inneractive.sdk.config.IAConfigManager r11 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.network.y r11 = r11.s
            java.util.concurrent.BlockingQueue<com.fyber.inneractive.sdk.network.c0<?>> r11 = r11.a
            r11.offer(r8)
            com.fyber.inneractive.sdk.network.r0 r11 = com.fyber.inneractive.sdk.network.r0.QUEUED
            r8.a((com.fyber.inneractive.sdk.network.r0) r11)
        L_0x0071:
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            r10.b = r11
        L_0x0078:
            android.os.Handler r11 = r10.d
            if (r11 == 0) goto L_0x0087
            r11.removeMessages(r0)
            int r11 = r10.e
            int r11 = r11 * 1000
            long r1 = (long) r11
            r10.a(r0, r1)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.c.handleMessage(android.os.Message):void");
    }

    public final void a(int i, long j) {
        Handler handler = this.d;
        if (handler != null) {
            handler.post(new a(i, j));
        }
    }

    public void a(int i) {
        this.f = true;
        this.e = i;
        Handler handler = this.d;
        if (handler != null && handler.hasMessages(12312329)) {
            this.d.removeMessages(12312329);
        }
        a(12312329, (long) (this.e * 1000));
    }
}
