package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository", f = "AndroidCampaignStateRepository.kt", i = {0, 0, 1, 1, 1}, l = {22, 25, 26}, m = "setShowTimestamp", n = {"this", "opportunityId", "this", "opportunityId", "campaignState"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* compiled from: AndroidCampaignStateRepository.kt */
final class AndroidCampaignStateRepository$setShowTimestamp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidCampaignStateRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCampaignStateRepository$setShowTimestamp$1(AndroidCampaignStateRepository androidCampaignStateRepository, Continuation<? super AndroidCampaignStateRepository$setShowTimestamp$1> continuation) {
        super(continuation);
        this.this$0 = androidCampaignStateRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setShowTimestamp((ByteString) null, this);
    }
}
