package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public class zzq extends DataBufferRef {
    public zzq(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* access modifiers changed from: protected */
    public final int zzq(String str, int i) {
        return (!hasColumn(str) || hasNull(str)) ? i : getInteger(str);
    }

    /* access modifiers changed from: protected */
    public final String zzr(String str, String str2) {
        if (!hasColumn(str) || hasNull(str)) {
            return null;
        }
        return getString(str);
    }
}
