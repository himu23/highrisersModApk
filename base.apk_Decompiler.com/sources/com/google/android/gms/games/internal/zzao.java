package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.DataHolderResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
class zzao extends DataHolderResult {
    zzao(DataHolder dataHolder) {
        super(dataHolder, GamesStatusCodes.zza(dataHolder.getStatusCode()));
    }
}
