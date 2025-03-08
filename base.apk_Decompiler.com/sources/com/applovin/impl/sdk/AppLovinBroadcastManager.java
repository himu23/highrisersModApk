package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppLovinBroadcastManager {
    private static final Handler acG = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AppLovinBroadcastManager.AT();
            } else {
                super.handleMessage(message);
            }
        }
    };
    private static final Map<Receiver, ArrayList<b>> azG = new HashMap();
    private static final Map<String, ArrayList<b>> azH = new HashMap();
    private static final ArrayList<a> azI = new ArrayList<>();

    public interface Receiver {
        void onReceive(Intent intent, Map<String, Object> map);
    }

    private static class b {
        final IntentFilter azM;
        final Receiver azN;
        boolean azO;
        boolean azP;

        b(IntentFilter intentFilter, Receiver receiver) {
            this.azM = intentFilter;
            this.azN = receiver;
        }
    }

    private static class a {
        final Intent azJ;
        final Map<String, Object> azK;
        final List<b> azL;

        a(Intent intent, Map<String, Object> map, List<b> list) {
            this.azJ = intent;
            this.azK = map;
            this.azL = list;
        }
    }

    public static void registerReceiver(Receiver receiver, IntentFilter intentFilter) {
        Map<Receiver, ArrayList<b>> map = azG;
        synchronized (map) {
            b bVar = new b(intentFilter, receiver);
            ArrayList arrayList = map.get(receiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                map.put(receiver, arrayList);
            }
            arrayList.add(bVar);
            Iterator<String> actionsIterator = intentFilter.actionsIterator();
            while (actionsIterator.hasNext()) {
                String next = actionsIterator.next();
                Map<String, ArrayList<b>> map2 = azH;
                ArrayList arrayList2 = map2.get(next);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    map2.put(next, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public static void unregisterReceiver(Receiver receiver) {
        Map<Receiver, ArrayList<b>> map = azG;
        synchronized (map) {
            List<b> remove = map.remove(receiver);
            if (remove != null) {
                for (b bVar : remove) {
                    bVar.azP = true;
                    Iterator<String> actionsIterator = bVar.azM.actionsIterator();
                    while (actionsIterator.hasNext()) {
                        String next = actionsIterator.next();
                        List list = azH.get(next);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                if (((b) it.next()).azN == receiver) {
                                    bVar.azP = true;
                                    it.remove();
                                }
                            }
                            if (list.size() <= 0) {
                                azH.remove(next);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean sendBroadcast(android.content.Intent r4, java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            java.util.Map<com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver, java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$b>> r0 = azG
            monitor-enter(r0)
            java.util.List r1 = a(r4)     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            r4 = 0
            return r4
        L_0x000c:
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r2 = azI     // Catch:{ all -> 0x0024 }
            com.applovin.impl.sdk.AppLovinBroadcastManager$a r3 = new com.applovin.impl.sdk.AppLovinBroadcastManager$a     // Catch:{ all -> 0x0024 }
            r3.<init>(r4, r5, r1)     // Catch:{ all -> 0x0024 }
            r2.add(r3)     // Catch:{ all -> 0x0024 }
            android.os.Handler r4 = acG     // Catch:{ all -> 0x0024 }
            r5 = 1
            boolean r1 = r4.hasMessages(r5)     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0022
            r4.sendEmptyMessage(r5)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return r5
        L_0x0024:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinBroadcastManager.sendBroadcast(android.content.Intent, java.util.Map):boolean");
    }

    public static boolean sendBroadcastWithAdObject(String str, Object obj) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("ad", obj);
        return sendBroadcast(new Intent(str), hashMap);
    }

    public static void sendBroadcastSync(Intent intent, Map<String, Object> map) {
        List<b> a2 = a(intent);
        if (a2 != null) {
            for (b next : a2) {
                if (!next.azP) {
                    next.azN.onReceive(intent, map);
                }
            }
        }
    }

    public static void sendBroadcastSyncWithPendingBroadcasts(Intent intent, Map<String, Object> map) {
        if (sendBroadcast(intent, map)) {
            AT();
        }
    }

    private static List<b> a(Intent intent) {
        synchronized (azG) {
            String action = intent.getAction();
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            List<b> list = azH.get(action);
            if (list == null) {
                return null;
            }
            ArrayList<b> arrayList = null;
            for (b bVar : list) {
                if (!bVar.azO) {
                    if (bVar.azM.match(action, (String) null, scheme, data, categories, "AppLovinBroadcastManager") >= 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(bVar);
                        bVar.azO = true;
                    }
                }
            }
            if (arrayList == null) {
                return null;
            }
            for (b bVar2 : arrayList) {
                bVar2.azO = false;
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r0 >= r2) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        r1 = r3[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        if (r1 != null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        r4 = r1.azL.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r4.hasNext() == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        r5 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        if (r5 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r5.azP != false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        r5.azN.onReceive(r1.azJ, r1.azK);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r0 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void AT() {
        /*
        L_0x0000:
            java.util.Map<com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver, java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$b>> r0 = azG
            monitor-enter(r0)
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r1 = azI     // Catch:{ all -> 0x0043 }
            int r2 = r1.size()     // Catch:{ all -> 0x0043 }
            if (r2 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            return
        L_0x000d:
            com.applovin.impl.sdk.AppLovinBroadcastManager$a[] r3 = new com.applovin.impl.sdk.AppLovinBroadcastManager.a[r2]     // Catch:{ all -> 0x0043 }
            r1.toArray(r3)     // Catch:{ all -> 0x0043 }
            r1.clear()     // Catch:{ all -> 0x0043 }
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            r0 = 0
        L_0x0017:
            if (r0 >= r2) goto L_0x0000
            r1 = r3[r0]
            if (r1 != 0) goto L_0x001e
            goto L_0x0040
        L_0x001e:
            java.util.List<com.applovin.impl.sdk.AppLovinBroadcastManager$b> r4 = r1.azL
            java.util.Iterator r4 = r4.iterator()
        L_0x0024:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0040
            java.lang.Object r5 = r4.next()
            com.applovin.impl.sdk.AppLovinBroadcastManager$b r5 = (com.applovin.impl.sdk.AppLovinBroadcastManager.b) r5
            if (r5 == 0) goto L_0x0024
            boolean r6 = r5.azP
            if (r6 != 0) goto L_0x0024
            com.applovin.impl.sdk.AppLovinBroadcastManager$Receiver r5 = r5.azN
            android.content.Intent r6 = r1.azJ
            java.util.Map<java.lang.String, java.lang.Object> r7 = r1.azK
            r5.onReceive(r6, r7)
            goto L_0x0024
        L_0x0040:
            int r0 = r0 + 1
            goto L_0x0017
        L_0x0043:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinBroadcastManager.AT():void");
    }
}
