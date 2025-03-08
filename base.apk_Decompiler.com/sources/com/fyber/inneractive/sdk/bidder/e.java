package com.fyber.inneractive.sdk.bidder;

import android.content.BroadcastReceiver;

public class e extends BroadcastReceiver {
    public final d a;

    public e(d dVar) {
        this.a = dVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0161
            java.lang.String r7 = r8.getAction()
            if (r7 == 0) goto L_0x0161
            java.lang.String r7 = r8.getAction()
            r7.getClass()
            r7.hashCode()
            int r0 = r7.hashCode()
            r1 = 4
            r2 = -1
            r3 = 2
            r4 = 0
            r5 = 1
            switch(r0) {
                case -1538406691: goto L_0x0062;
                case -1530327060: goto L_0x0057;
                case -1076576821: goto L_0x004c;
                case 1123270207: goto L_0x0041;
                case 1779291251: goto L_0x0036;
                case 2070024785: goto L_0x002b;
                case 2106958107: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            r7 = -1
            goto L_0x006c
        L_0x0020:
            java.lang.String r0 = "android.app.action.INTERRUPTION_FILTER_CHANGED"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0029
            goto L_0x001e
        L_0x0029:
            r7 = 6
            goto L_0x006c
        L_0x002b:
            java.lang.String r0 = "android.media.RINGER_MODE_CHANGED"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0034
            goto L_0x001e
        L_0x0034:
            r7 = 5
            goto L_0x006c
        L_0x0036:
            java.lang.String r0 = "android.os.action.POWER_SAVE_MODE_CHANGED"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x003f
            goto L_0x001e
        L_0x003f:
            r7 = 4
            goto L_0x006c
        L_0x0041:
            java.lang.String r0 = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x004a
            goto L_0x001e
        L_0x004a:
            r7 = 3
            goto L_0x006c
        L_0x004c:
            java.lang.String r0 = "android.intent.action.AIRPLANE_MODE"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0055
            goto L_0x001e
        L_0x0055:
            r7 = 2
            goto L_0x006c
        L_0x0057:
            java.lang.String r0 = "android.bluetooth.adapter.action.STATE_CHANGED"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0060
            goto L_0x001e
        L_0x0060:
            r7 = 1
            goto L_0x006c
        L_0x0062:
            java.lang.String r0 = "android.intent.action.BATTERY_CHANGED"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x006b
            goto L_0x001e
        L_0x006b:
            r7 = 0
        L_0x006c:
            switch(r7) {
                case 0: goto L_0x0117;
                case 1: goto L_0x00f6;
                case 2: goto L_0x00e0;
                case 3: goto L_0x00f6;
                case 4: goto L_0x00cf;
                case 5: goto L_0x00a4;
                case 6: goto L_0x0071;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x0161
        L_0x0071:
            com.fyber.inneractive.sdk.bidder.d r7 = r6.a
            com.fyber.inneractive.sdk.bidder.a r7 = (com.fyber.inneractive.sdk.bidder.a) r7
            r7.getClass()
            android.app.Application r8 = com.fyber.inneractive.sdk.util.p.a
            java.lang.String r0 = "notification"
            java.lang.Object r8 = r8.getSystemService(r0)
            android.app.NotificationManager r8 = (android.app.NotificationManager) r8
            int r8 = r8.getCurrentInterruptionFilter()
            if (r8 < r3) goto L_0x008b
            if (r8 > r1) goto L_0x008b
            r4 = 1
        L_0x008b:
            com.fyber.inneractive.sdk.bidder.c r8 = r7.c
            java.lang.Boolean r8 = r8.x
            if (r8 == 0) goto L_0x0097
            boolean r8 = r8.booleanValue()
            if (r8 == r4) goto L_0x0161
        L_0x0097:
            com.fyber.inneractive.sdk.bidder.c r8 = r7.c
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            r8.x = r0
            r7.b()
            goto L_0x0161
        L_0x00a4:
            com.fyber.inneractive.sdk.bidder.d r7 = r6.a
            com.fyber.inneractive.sdk.bidder.a r7 = (com.fyber.inneractive.sdk.bidder.a) r7
            r7.getClass()
            java.lang.String r0 = "android.media.EXTRA_RINGER_MODE"
            int r8 = r8.getIntExtra(r0, r2)
            if (r8 == 0) goto L_0x00b5
            if (r8 != r5) goto L_0x00b6
        L_0x00b5:
            r4 = 1
        L_0x00b6:
            com.fyber.inneractive.sdk.bidder.c r8 = r7.c
            java.lang.Boolean r8 = r8.y
            if (r8 == 0) goto L_0x00c2
            boolean r8 = r8.booleanValue()
            if (r8 == r4) goto L_0x0161
        L_0x00c2:
            com.fyber.inneractive.sdk.bidder.c r8 = r7.c
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            r8.y = r0
            r7.b()
            goto L_0x0161
        L_0x00cf:
            com.fyber.inneractive.sdk.bidder.d r7 = r6.a
            com.fyber.inneractive.sdk.bidder.a r7 = (com.fyber.inneractive.sdk.bidder.a) r7
            com.fyber.inneractive.sdk.bidder.c r8 = r7.c
            java.lang.Boolean r0 = com.fyber.inneractive.sdk.serverapi.a.l()
            r8.u = r0
            r7.b()
            goto L_0x0161
        L_0x00e0:
            com.fyber.inneractive.sdk.bidder.d r7 = r6.a
            com.fyber.inneractive.sdk.bidder.a r7 = (com.fyber.inneractive.sdk.bidder.a) r7
            com.fyber.inneractive.sdk.bidder.c r0 = r7.c
            java.lang.String r1 = "state"
            boolean r8 = r8.getBooleanExtra(r1, r4)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r0.w = r8
            r7.b()
            goto L_0x0161
        L_0x00f6:
            com.fyber.inneractive.sdk.bidder.d r7 = r6.a
            com.fyber.inneractive.sdk.bidder.a r7 = (com.fyber.inneractive.sdk.bidder.a) r7
            r7.getClass()
            java.lang.String r0 = "android.bluetooth.adapter.extra.CONNECTION_STATE"
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r8 = r8.getIntExtra(r0, r1)
            if (r8 != r3) goto L_0x010a
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            goto L_0x010b
        L_0x010a:
            r8 = 0
        L_0x010b:
            com.fyber.inneractive.sdk.bidder.c r0 = r7.c
            java.lang.Boolean r1 = r0.t
            if (r1 == r8) goto L_0x0161
            r0.t = r8
            r7.b()
            goto L_0x0161
        L_0x0117:
            com.fyber.inneractive.sdk.bidder.d r7 = r6.a
            com.fyber.inneractive.sdk.bidder.a r7 = (com.fyber.inneractive.sdk.bidder.a) r7
            com.fyber.inneractive.sdk.serverapi.b r0 = r7.b
            r0.getClass()
            java.lang.String r0 = "plugged"
            int r0 = r8.getIntExtra(r0, r2)
            if (r0 == r5) goto L_0x012c
            if (r0 == r3) goto L_0x012c
            if (r0 != r1) goto L_0x012d
        L_0x012c:
            r4 = 1
        L_0x012d:
            com.fyber.inneractive.sdk.bidder.c r0 = r7.c
            java.lang.Boolean r0 = r0.B
            if (r0 == 0) goto L_0x0139
            boolean r0 = r0.booleanValue()
            if (r0 == r4) goto L_0x0144
        L_0x0139:
            com.fyber.inneractive.sdk.bidder.c r0 = r7.c
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
            r0.B = r1
            r7.b()
        L_0x0144:
            com.fyber.inneractive.sdk.serverapi.b r0 = r7.b
            java.lang.String r0 = r0.a((android.content.Intent) r8)
            com.fyber.inneractive.sdk.bidder.c r1 = r7.c
            java.lang.String r1 = r1.C
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 != 0) goto L_0x0161
            com.fyber.inneractive.sdk.bidder.c r0 = r7.c
            com.fyber.inneractive.sdk.serverapi.b r1 = r7.b
            java.lang.String r8 = r1.a((android.content.Intent) r8)
            r0.C = r8
            r7.b()
        L_0x0161:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.bidder.e.onReceive(android.content.Context, android.content.Intent):void");
    }
}
