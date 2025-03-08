package com.applovin.impl.communicator;

import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MessagingServiceImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AppLovinCommunicatorMessage f$0;

    public /* synthetic */ MessagingServiceImpl$$ExternalSyntheticLambda0(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f$0 = appLovinCommunicatorMessage;
    }

    public final void run() {
        AppLovinBroadcastManager.sendBroadcastSync(this.f$0, (Map<String, Object>) null);
    }
}
