package com.unity3d.services.ads.operation.load;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoadModuleDecoratorTimeout$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ LoadOperationState f$0;

    public /* synthetic */ LoadModuleDecoratorTimeout$$ExternalSyntheticLambda0(LoadOperationState loadOperationState) {
        this.f$0 = loadOperationState;
    }

    public final void run() {
        LoadModuleDecoratorTimeout.lambda$onOperationTimeout$0(this.f$0);
    }
}
