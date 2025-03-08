package com.unity3d.ads.core.data.model;

import com.google.protobuf.ByteString;
import com.ironsource.m2;
import com.unity3d.ads.adplayer.FullscreenAdPlayer;
import com.unity3d.ads.core.domain.HandleAndroidInvocationsUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/unity3d/ads/core/data/model/AdObject;", "", "opportunityId", "Lcom/google/protobuf/ByteString;", "placementId", "", "trackingToken", "fullscreenAdPlayer", "Lcom/unity3d/ads/adplayer/FullscreenAdPlayer;", "playerServerId", "(Lcom/google/protobuf/ByteString;Ljava/lang/String;Lcom/google/protobuf/ByteString;Lcom/unity3d/ads/adplayer/FullscreenAdPlayer;Ljava/lang/String;)V", "getFullscreenAdPlayer", "()Lcom/unity3d/ads/adplayer/FullscreenAdPlayer;", "getOpportunityId", "()Lcom/google/protobuf/ByteString;", "getPlacementId", "()Ljava/lang/String;", "getPlayerServerId", "setPlayerServerId", "(Ljava/lang/String;)V", "getTrackingToken", "setTrackingToken", "(Lcom/google/protobuf/ByteString;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdObject.kt */
public final class AdObject {
    private final FullscreenAdPlayer fullscreenAdPlayer;
    private final ByteString opportunityId;
    private final String placementId;
    private String playerServerId;
    private ByteString trackingToken;

    public static /* synthetic */ AdObject copy$default(AdObject adObject, ByteString byteString, String str, ByteString byteString2, FullscreenAdPlayer fullscreenAdPlayer2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            byteString = adObject.opportunityId;
        }
        if ((i & 2) != 0) {
            str = adObject.placementId;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            byteString2 = adObject.trackingToken;
        }
        ByteString byteString3 = byteString2;
        if ((i & 8) != 0) {
            fullscreenAdPlayer2 = adObject.fullscreenAdPlayer;
        }
        FullscreenAdPlayer fullscreenAdPlayer3 = fullscreenAdPlayer2;
        if ((i & 16) != 0) {
            str2 = adObject.playerServerId;
        }
        return adObject.copy(byteString, str3, byteString3, fullscreenAdPlayer3, str2);
    }

    public final ByteString component1() {
        return this.opportunityId;
    }

    public final String component2() {
        return this.placementId;
    }

    public final ByteString component3() {
        return this.trackingToken;
    }

    public final FullscreenAdPlayer component4() {
        return this.fullscreenAdPlayer;
    }

    public final String component5() {
        return this.playerServerId;
    }

    public final AdObject copy(ByteString byteString, String str, ByteString byteString2, FullscreenAdPlayer fullscreenAdPlayer2, String str2) {
        Intrinsics.checkNotNullParameter(byteString, "opportunityId");
        Intrinsics.checkNotNullParameter(str, m2.i);
        Intrinsics.checkNotNullParameter(byteString2, HandleAndroidInvocationsUseCase.KEY_TRACKING_TOKEN);
        return new AdObject(byteString, str, byteString2, fullscreenAdPlayer2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdObject)) {
            return false;
        }
        AdObject adObject = (AdObject) obj;
        return Intrinsics.areEqual((Object) this.opportunityId, (Object) adObject.opportunityId) && Intrinsics.areEqual((Object) this.placementId, (Object) adObject.placementId) && Intrinsics.areEqual((Object) this.trackingToken, (Object) adObject.trackingToken) && Intrinsics.areEqual((Object) this.fullscreenAdPlayer, (Object) adObject.fullscreenAdPlayer) && Intrinsics.areEqual((Object) this.playerServerId, (Object) adObject.playerServerId);
    }

    public final FullscreenAdPlayer getFullscreenAdPlayer() {
        return this.fullscreenAdPlayer;
    }

    public final ByteString getOpportunityId() {
        return this.opportunityId;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final String getPlayerServerId() {
        return this.playerServerId;
    }

    public final ByteString getTrackingToken() {
        return this.trackingToken;
    }

    public int hashCode() {
        int hashCode = ((((this.opportunityId.hashCode() * 31) + this.placementId.hashCode()) * 31) + this.trackingToken.hashCode()) * 31;
        FullscreenAdPlayer fullscreenAdPlayer2 = this.fullscreenAdPlayer;
        int i = 0;
        int hashCode2 = (hashCode + (fullscreenAdPlayer2 == null ? 0 : fullscreenAdPlayer2.hashCode())) * 31;
        String str = this.playerServerId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setPlayerServerId(String str) {
        this.playerServerId = str;
    }

    public final void setTrackingToken(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<set-?>");
        this.trackingToken = byteString;
    }

    public String toString() {
        return "AdObject(opportunityId=" + this.opportunityId + ", placementId=" + this.placementId + ", trackingToken=" + this.trackingToken + ", fullscreenAdPlayer=" + this.fullscreenAdPlayer + ", playerServerId=" + this.playerServerId + ')';
    }

    public AdObject(ByteString byteString, String str, ByteString byteString2, FullscreenAdPlayer fullscreenAdPlayer2, String str2) {
        Intrinsics.checkNotNullParameter(byteString, "opportunityId");
        Intrinsics.checkNotNullParameter(str, m2.i);
        Intrinsics.checkNotNullParameter(byteString2, HandleAndroidInvocationsUseCase.KEY_TRACKING_TOKEN);
        this.opportunityId = byteString;
        this.placementId = str;
        this.trackingToken = byteString2;
        this.fullscreenAdPlayer = fullscreenAdPlayer2;
        this.playerServerId = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdObject(ByteString byteString, String str, ByteString byteString2, FullscreenAdPlayer fullscreenAdPlayer2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteString, str, byteString2, fullscreenAdPlayer2, (i & 16) != 0 ? null : str2);
    }
}
