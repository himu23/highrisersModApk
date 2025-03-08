package com.unity3d.ads.core.data.datasource;

import android.database.ContentObserver;
import android.os.Handler;
import com.unity3d.ads.core.data.datasource.VolumeSettingsChange;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/unity3d/ads/core/data/datasource/AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDynamicDeviceInfoDataSource.kt */
public final class AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1 extends ContentObserver {
    final /* synthetic */ ProducerScope<VolumeSettingsChange> $$this$callbackFlow;
    final /* synthetic */ Ref.IntRef $currentRingerMode;
    final /* synthetic */ Ref.DoubleRef $currentVolume;
    final /* synthetic */ AndroidDynamicDeviceInfoDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1(AndroidDynamicDeviceInfoDataSource androidDynamicDeviceInfoDataSource, Ref.DoubleRef doubleRef, ProducerScope<? super VolumeSettingsChange> producerScope, Ref.IntRef intRef) {
        super((Handler) null);
        this.this$0 = androidDynamicDeviceInfoDataSource;
        this.$currentVolume = doubleRef;
        this.$$this$callbackFlow = producerScope;
        this.$currentRingerMode = intRef;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        double access$getStreamVolume = this.this$0.getStreamVolume(3);
        if (access$getStreamVolume != this.$currentVolume.element) {
            this.$currentVolume.element = access$getStreamVolume;
            ChannelsKt.trySendBlocking(this.$$this$callbackFlow, new VolumeSettingsChange.VolumeChange(access$getStreamVolume));
        }
        int ringerMode = this.this$0.getRingerMode();
        if (ringerMode != this.$currentRingerMode.element) {
            this.$currentRingerMode.element = ringerMode;
            ChannelsKt.trySendBlocking(this.$$this$callbackFlow, new VolumeSettingsChange.MuteChange(ringerMode == 0));
        }
    }
}
