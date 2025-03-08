package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.CampaignState;
import gateway.v1.CampaignStateOuterClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\f0\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;", "", "getCampaignState", "Lgateway/v1/CampaignStateOuterClass$CampaignState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getState", "Lcom/unity3d/ads/core/data/model/CampaignState;", "opportunityId", "Lcom/google/protobuf/ByteString;", "(Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStates", "", "Lkotlin/Pair;", "removeState", "", "setLoadTimestamp", "setShowTimestamp", "updateState", "campaignState", "(Lcom/google/protobuf/ByteString;Lcom/unity3d/ads/core/data/model/CampaignState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CampaignStateRepository.kt */
public interface CampaignStateRepository {
    Object getCampaignState(Continuation<? super CampaignStateOuterClass.CampaignState> continuation);

    Object getState(ByteString byteString, Continuation<? super CampaignState> continuation);

    Object getStates(Continuation<? super List<? extends Pair<? extends ByteString, CampaignState>>> continuation);

    Object removeState(ByteString byteString, Continuation<? super Unit> continuation);

    Object setLoadTimestamp(ByteString byteString, Continuation<? super Unit> continuation);

    Object setShowTimestamp(ByteString byteString, Continuation<? super Unit> continuation);

    Object updateState(ByteString byteString, CampaignState campaignState, Continuation<? super Unit> continuation);
}
