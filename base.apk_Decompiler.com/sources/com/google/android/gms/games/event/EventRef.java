package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.ironsource.m2;

/* compiled from: com.google.android.gms:play-services-games@@23.1.0 */
public final class EventRef extends DataBufferRef implements Event {
    EventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return EventEntity.zzc(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new EventEntity(this);
    }

    public final String getDescription() {
        return getString("description");
    }

    public final String getEventId() {
        return getString("external_event_id");
    }

    public final String getFormattedValue() {
        return getString("formatted_value");
    }

    public final Uri getIconImageUri() {
        return parseUri("icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("icon_image_url");
    }

    public final String getName() {
        return getString("name");
    }

    public final Player getPlayer() {
        return new PlayerRef(this.mDataHolder, this.mDataRow, (String) null);
    }

    public final long getValue() {
        return getLong(m2.h.X);
    }

    public final int hashCode() {
        return EventEntity.zza(this);
    }

    public final boolean isVisible() {
        return getBoolean("visibility");
    }

    public final String toString() {
        return EventEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        new EventEntity(this).writeToParcel(parcel, i);
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    public final void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("formatted_value", charArrayBuffer);
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }
}
