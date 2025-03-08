package com.google.android.gms.games;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public class AnnotatedData<T> {
    private final Object zza;
    private final boolean zzb;

    public AnnotatedData(Object obj, boolean z) {
        this.zza = obj;
        this.zzb = z;
    }

    public T get() {
        return this.zza;
    }

    public boolean isStale() {
        return this.zzb;
    }
}
