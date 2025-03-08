package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zzf;
import com.google.android.gms.internal.drive.zzaa;
import com.google.android.gms.internal.drive.zzhs;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzau;

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.getMetadata().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    @Deprecated
    public final String getNextPageToken() {
        return null;
    }

    static class zza extends Metadata {
        /* access modifiers changed from: private */
        public final int row;
        private final DataHolder zzav;
        private final int zzaw;

        public zza(DataHolder dataHolder, int i) {
            this.zzav = dataHolder;
            this.row = i;
            this.zzaw = dataHolder.getWindowIndex(i);
        }

        public final <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzav, this.row, this.zzaw);
        }

        public final boolean isDataValid() {
            return !this.zzav.isClosed();
        }

        public final /* synthetic */ Object freeze() {
            MetadataBundle zzbe = MetadataBundle.zzbe();
            for (MetadataField<BitmapTeleporter> next : zzf.zzbc()) {
                if (next != zzhs.zzkq) {
                    next.zza(this.zzav, zzbe, this.row, this.zzaw);
                }
            }
            return new zzaa(zzbe);
        }
    }

    public final Metadata get(int i) {
        zza zza2 = this.zzau;
        if (zza2 != null && zza2.row == i) {
            return zza2;
        }
        zza zza3 = new zza(this.mDataHolder, i);
        this.zzau = zza3;
        return zza3;
    }

    public final void release() {
        if (this.mDataHolder != null) {
            zzf.zza(this.mDataHolder);
        }
        super.release();
    }
}
