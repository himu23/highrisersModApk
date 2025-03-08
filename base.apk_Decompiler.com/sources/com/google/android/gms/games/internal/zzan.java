package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzan extends zza {
    private final TaskCompletionSource zza;

    zzan(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzh(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 0 || statusCode == 3) {
            GameBuffer gameBuffer = new GameBuffer(dataHolder);
            boolean z = true;
            try {
                GameEntity gameEntity = gameBuffer.getCount() > 0 ? new GameEntity(gameBuffer.get(0)) : null;
                gameBuffer.close();
                if (statusCode != 3) {
                    z = false;
                }
                this.zza.setResult(new AnnotatedData(gameEntity, z));
                return;
            } catch (Throwable th) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class}).invoke(th, new Object[]{th});
                } catch (Exception unused) {
                }
            }
        } else {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
            return;
        }
        throw th;
    }
}
