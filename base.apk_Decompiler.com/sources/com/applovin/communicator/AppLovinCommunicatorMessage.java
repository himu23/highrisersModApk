package com.applovin.communicator;

import android.os.Bundle;
import com.applovin.impl.communicator.CommunicatorMessageImpl;

public class AppLovinCommunicatorMessage extends CommunicatorMessageImpl {
    public AppLovinCommunicatorMessage(Bundle bundle, String str, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher) {
        super(bundle, str, appLovinCommunicatorPublisher);
    }

    public Bundle getMessageData() {
        return this.data;
    }

    public String getTopic() {
        return getAction();
    }

    public String getPublisherId() {
        AppLovinCommunicatorPublisher appLovinCommunicatorPublisher = (AppLovinCommunicatorPublisher) this.publisherRef.get();
        return appLovinCommunicatorPublisher != null ? appLovinCommunicatorPublisher.getCommunicatorId() : "";
    }
}
