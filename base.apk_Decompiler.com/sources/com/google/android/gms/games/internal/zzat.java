package com.google.android.gms.games.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
final class zzat extends zza {
    final /* synthetic */ zzbz zza;
    private final TaskCompletionSource zzb;

    zzat(zzbz zzbz, TaskCompletionSource taskCompletionSource) {
        this.zza = zzbz;
        this.zzb = taskCompletionSource;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.google.android.gms.games.leaderboard.Leaderboard} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.google.android.gms.games.leaderboard.Leaderboard} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: com.google.android.gms.games.leaderboard.Leaderboard} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.gms.common.data.DataHolder r6, com.google.android.gms.common.data.DataHolder r7) {
        /*
            r5 = this;
            int r0 = r7.getStatusCode()
            r1 = 3
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x000b
            r1 = 1
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            r4 = 10003(0x2713, float:1.4017E-41)
            if (r0 != r4) goto L_0x001e
            com.google.android.gms.games.internal.zzbz r0 = r5.zza
            com.google.android.gms.tasks.TaskCompletionSource r1 = r5.zzb
            com.google.android.gms.games.internal.zzbz.zzL(r0, r1)
            r6.close()
            r7.close()
            return
        L_0x001e:
            if (r0 == 0) goto L_0x002f
            if (r1 == 0) goto L_0x0023
            goto L_0x002f
        L_0x0023:
            com.google.android.gms.tasks.TaskCompletionSource r1 = r5.zzb
            com.google.android.gms.games.GamesStatusUtils.zza(r1, r0)
            r6.close()
            r7.close()
            return
        L_0x002f:
            com.google.android.gms.games.leaderboard.LeaderboardBuffer r0 = new com.google.android.gms.games.leaderboard.LeaderboardBuffer
            r0.<init>(r6)
            int r6 = r0.getCount()     // Catch:{ all -> 0x005e }
            if (r6 <= 0) goto L_0x0045
            java.lang.Object r6 = r0.get(r3)     // Catch:{ all -> 0x005e }
            com.google.android.gms.games.leaderboard.Leaderboard r6 = (com.google.android.gms.games.leaderboard.Leaderboard) r6     // Catch:{ all -> 0x005e }
            java.lang.Object r6 = r6.freeze()     // Catch:{ all -> 0x005e }
            goto L_0x0046
        L_0x0045:
            r6 = 0
        L_0x0046:
            r0.close()
            com.google.android.gms.tasks.TaskCompletionSource r0 = r5.zzb
            com.google.android.gms.games.AnnotatedData r2 = new com.google.android.gms.games.AnnotatedData
            com.google.android.gms.games.LeaderboardsClient$LeaderboardScores r3 = new com.google.android.gms.games.LeaderboardsClient$LeaderboardScores
            com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer r4 = new com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer
            r4.<init>(r7)
            r3.<init>(r6, r4)
            r2.<init>(r3, r1)
            r0.setResult(r2)
            return
        L_0x005e:
            r6 = move-exception
            r0.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0079
        L_0x0063:
            r7 = move-exception
            java.lang.Class[] r0 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0079 }
            java.lang.Class<java.lang.Throwable> r1 = java.lang.Throwable.class
            r0[r3] = r1     // Catch:{ Exception -> 0x0079 }
            java.lang.Class<java.lang.Throwable> r1 = java.lang.Throwable.class
            java.lang.String r4 = "addSuppressed"
            java.lang.reflect.Method r0 = r1.getDeclaredMethod(r4, r0)     // Catch:{ Exception -> 0x0079 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0079 }
            r1[r3] = r7     // Catch:{ Exception -> 0x0079 }
            r0.invoke(r6, r1)     // Catch:{ Exception -> 0x0079 }
        L_0x0079:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.zzat.zzi(com.google.android.gms.common.data.DataHolder, com.google.android.gms.common.data.DataHolder):void");
    }
}
