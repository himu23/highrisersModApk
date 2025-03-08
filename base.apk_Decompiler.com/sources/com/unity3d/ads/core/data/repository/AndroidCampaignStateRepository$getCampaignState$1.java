package com.unity3d.ads.core.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository", f = "AndroidCampaignStateRepository.kt", i = {}, l = {52}, m = "getCampaignState", n = {}, s = {})
/* compiled from: AndroidCampaignStateRepository.kt */
final class AndroidCampaignStateRepository$getCampaignState$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidCampaignStateRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCampaignStateRepository$getCampaignState$1(AndroidCampaignStateRepository androidCampaignStateRepository, Continuation<? super AndroidCampaignStateRepository$getCampaignState$1> continuation) {
        super(continuation);
        this.this$0 = androidCampaignStateRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCampaignState(this);
    }
}
