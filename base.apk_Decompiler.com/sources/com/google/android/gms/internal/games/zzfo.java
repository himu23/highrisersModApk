package com.google.android.gms.internal.games;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public abstract class zzfo {
    private final AtomicReference zza = new AtomicReference();

    /* access modifiers changed from: protected */
    public abstract zzfn zza();

    public final void zzb() {
        zzfn zzfn = (zzfn) this.zza.get();
        if (zzfn != null) {
            zzfn.zzd();
        }
    }

    public final void zzc(String str, int i) {
        zzfn zzfn = (zzfn) this.zza.get();
        if (zzfn == null) {
            zzfn zza2 = zza();
            AtomicReference atomicReference = this.zza;
            while (true) {
                if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, (Object) null, zza2)) {
                    if (atomicReference.get() != null) {
                        zzfn = (zzfn) this.zza.get();
                        break;
                    }
                } else {
                    zzfn = zza2;
                    break;
                }
            }
        }
        zzfn.zzc(str, i);
    }
}
