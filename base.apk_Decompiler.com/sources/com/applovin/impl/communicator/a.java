package com.applovin.impl.communicator;

import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Set;

public class a {
    private final Set<b> ajZ = new HashSet(32);
    private final Object aka = new Object();

    public boolean hasSubscriber(String str) {
        synchronized (this.aka) {
            for (b topic : this.ajZ) {
                if (str.equals(topic.getTopic())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.applovin.communicator.AppLovinCommunicatorSubscriber r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Attempting to re-subscribe subscriber ("
            if (r7 == 0) goto L_0x005d
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r8)
            if (r1 != 0) goto L_0x000b
            goto L_0x005d
        L_0x000b:
            java.lang.Object r1 = r6.aka
            monitor-enter(r1)
            com.applovin.impl.communicator.b r2 = r6.a((java.lang.String) r8, (com.applovin.communicator.AppLovinCommunicatorSubscriber) r7)     // Catch:{ all -> 0x005a }
            r3 = 1
            if (r2 == 0) goto L_0x0046
            java.lang.String r4 = "AppLovinCommunicator"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r5.<init>(r0)     // Catch:{ all -> 0x005a }
            r5.append(r7)     // Catch:{ all -> 0x005a }
            java.lang.String r7 = ") to topic ("
            r5.append(r7)     // Catch:{ all -> 0x005a }
            r5.append(r8)     // Catch:{ all -> 0x005a }
            java.lang.String r7 = ")"
            r5.append(r7)     // Catch:{ all -> 0x005a }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x005a }
            com.applovin.impl.sdk.x.H(r4, r7)     // Catch:{ all -> 0x005a }
            boolean r7 = r2.isActive()     // Catch:{ all -> 0x005a }
            if (r7 != 0) goto L_0x0044
            r2.ax(r3)     // Catch:{ all -> 0x005a }
            android.content.IntentFilter r7 = new android.content.IntentFilter     // Catch:{ all -> 0x005a }
            r7.<init>(r8)     // Catch:{ all -> 0x005a }
            com.applovin.impl.sdk.AppLovinBroadcastManager.registerReceiver(r2, r7)     // Catch:{ all -> 0x005a }
        L_0x0044:
            monitor-exit(r1)     // Catch:{ all -> 0x005a }
            return r3
        L_0x0046:
            com.applovin.impl.communicator.b r0 = new com.applovin.impl.communicator.b     // Catch:{ all -> 0x005a }
            r0.<init>(r8, r7)     // Catch:{ all -> 0x005a }
            java.util.Set<com.applovin.impl.communicator.b> r7 = r6.ajZ     // Catch:{ all -> 0x005a }
            r7.add(r0)     // Catch:{ all -> 0x005a }
            monitor-exit(r1)     // Catch:{ all -> 0x005a }
            android.content.IntentFilter r7 = new android.content.IntentFilter
            r7.<init>(r8)
            com.applovin.impl.sdk.AppLovinBroadcastManager.registerReceiver(r0, r7)
            return r3
        L_0x005a:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005a }
            throw r7
        L_0x005d:
            java.lang.String r0 = "AppLovinCommunicator"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unable to subscribe - invalid subscriber ("
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = ") or topic ("
            r1.append(r7)
            r1.append(r8)
            java.lang.String r7 = ")"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.applovin.impl.sdk.x.H(r0, r7)
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.communicator.a.a(com.applovin.communicator.AppLovinCommunicatorSubscriber, java.lang.String):boolean");
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        b a;
        if (StringUtils.isValidString(str)) {
            synchronized (this.aka) {
                a = a(str, appLovinCommunicatorSubscriber);
            }
            if (a != null) {
                a.ax(false);
                AppLovinBroadcastManager.unregisterReceiver(a);
            }
        }
    }

    private b a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (b next : this.ajZ) {
            if (str.equals(next.getTopic()) && appLovinCommunicatorSubscriber.equals(next.tu())) {
                return next;
            }
        }
        return null;
    }
}
