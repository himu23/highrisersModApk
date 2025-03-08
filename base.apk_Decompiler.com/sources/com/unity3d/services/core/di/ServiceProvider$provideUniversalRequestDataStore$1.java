package com.unity3d.services.core.di;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceProvider.kt */
final class ServiceProvider$provideUniversalRequestDataStore$1 extends Lambda implements Function0<File> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceProvider$provideUniversalRequestDataStore$1(Context context) {
        super(0);
        this.$context = context;
    }

    public final File invoke() {
        return DataStoreFile.dataStoreFile(this.$context, ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST);
    }
}
