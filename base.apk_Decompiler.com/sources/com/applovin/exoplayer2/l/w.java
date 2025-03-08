package com.applovin.exoplayer2.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class w {
    private static w acF;
    private final CopyOnWriteArrayList<WeakReference<b>> Zl = new CopyOnWriteArrayList<>();
    private int aaa = 0;
    private final Handler acG = new Handler(Looper.getMainLooper());
    private final Object acH = new Object();

    public static final class a {
        /* access modifiers changed from: private */
        public static volatile boolean acI;
    }

    public interface b {
        void onNetworkTypeChanged(int i);
    }

    public static synchronized w k(Context context) {
        w wVar;
        synchronized (w.class) {
            if (acF == null) {
                acF = new w(context);
            }
            wVar = acF;
        }
        return wVar;
    }

    private w(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new c(), intentFilter);
    }

    public void a(b bVar) {
        pd();
        this.Zl.add(new WeakReference(bVar));
        this.acG.post(new w$$ExternalSyntheticLambda0(this, bVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(b bVar) {
        bVar.onNetworkTypeChanged(pc());
    }

    public int pc() {
        int i;
        synchronized (this.acH) {
            i = this.aaa;
        }
        return i;
    }

    private void pd() {
        Iterator<WeakReference<b>> it = this.Zl.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            if (next.get() == null) {
                this.Zl.remove(next);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r0.hasNext() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1 = r0.next();
        r2 = (com.applovin.exoplayer2.l.w.b) r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r2 == null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r2.onNetworkTypeChanged(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r3.Zl.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r0 = r3.Zl.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fw(int r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.acH
            monitor-enter(r0)
            int r1 = r3.aaa     // Catch:{ all -> 0x0031 }
            if (r1 != r4) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x0009:
            r3.aaa = r4     // Catch:{ all -> 0x0031 }
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<com.applovin.exoplayer2.l.w$b>> r0 = r3.Zl
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r0.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r2 = r1.get()
            com.applovin.exoplayer2.l.w$b r2 = (com.applovin.exoplayer2.l.w.b) r2
            if (r2 == 0) goto L_0x002a
            r2.onNetworkTypeChanged(r4)
            goto L_0x0012
        L_0x002a:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<com.applovin.exoplayer2.l.w$b>> r2 = r3.Zl
            r2.remove(r1)
            goto L_0x0012
        L_0x0030:
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.l.w.fw(int):void");
    }

    /* access modifiers changed from: private */
    public static int l(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (!(type == 4 || type == 5)) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return a(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i;
    }

    private static int a(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 18:
                return 2;
            case 20:
                return ai.acV >= 29 ? 9 : 0;
            default:
                return 6;
        }
    }

    private final class c extends BroadcastReceiver {
        private c() {
        }

        public void onReceive(Context context, Intent intent) {
            int m = w.l(context);
            if (ai.acV >= 29 && !a.acI && m == 5) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) a.checkNotNull((TelephonyManager) context.getSystemService("phone"));
                    d dVar = new d();
                    if (ai.acV < 31) {
                        telephonyManager.listen(dVar, 1);
                    } else {
                        telephonyManager.listen(dVar, 1048576);
                    }
                    telephonyManager.listen(dVar, 0);
                    return;
                } catch (RuntimeException unused) {
                }
            }
            w.this.fw(m);
        }
    }

    private class d extends PhoneStateListener {
        private d() {
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            String serviceState2 = serviceState == null ? "" : serviceState.toString();
            w.this.fw(serviceState2.contains("nrState=CONNECTED") || serviceState2.contains("nrState=NOT_RESTRICTED") ? 10 : 5);
        }

        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            int m = telephonyDisplayInfo.getOverrideNetworkType();
            w.this.fw(m == 3 || m == 4 ? 10 : 5);
        }
    }
}
