package com.google.android.gms.internal.games;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public abstract class zzfn {
    private final Handler zza;
    final Object zzb = new Object();
    private boolean zzc;
    private final HashMap zzd;

    public zzfn(Looper looper, int i) {
        this.zza = new zzfu(looper);
        this.zzd = new HashMap();
    }

    static /* bridge */ /* synthetic */ void zzb(zzfn zzfn) {
        synchronized (zzfn.zzb) {
            zzfn.zzc = false;
            zzfn.zzd();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zza(String str, int i);

    public final void zzc(String str, int i) {
        synchronized (this.zzb) {
            if (!this.zzc) {
                this.zzc = true;
                this.zza.postDelayed(new zzfm(this), 1000);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzd.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzd.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }

    public final void zzd() {
        synchronized (this.zzb) {
            for (Map.Entry entry : this.zzd.entrySet()) {
                zza((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzd.clear();
        }
    }
}
