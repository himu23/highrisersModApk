package com.google.android.gms.games;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public interface GamesMetadataClient {
    Task<Game> getCurrentGame();

    Task<AnnotatedData<Game>> loadGame();
}
