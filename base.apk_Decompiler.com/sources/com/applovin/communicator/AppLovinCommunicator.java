package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.communicator.a;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.Collections;
import java.util.List;

public final class AppLovinCommunicator {
    private static AppLovinCommunicator x;
    private static final Object y = new Object();
    private final MessagingServiceImpl A = new MessagingServiceImpl();
    private x logger;
    private n sdk;
    private final a z = new a();

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.A;
    }

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (y) {
            if (x == null) {
                x = new AppLovinCommunicator();
            }
        }
        return x;
    }

    public boolean hasSubscriber(String str) {
        return this.z.hasSubscriber(str);
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            if (!this.z.a(appLovinCommunicatorSubscriber, next)) {
                c("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + next);
            }
        }
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            c("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + next);
            this.z.unsubscribe(appLovinCommunicatorSubscriber, next);
        }
    }

    public boolean respondsToTopic(String str) {
        return this.sdk.Ch().respondsToTopic(str);
    }

    public void a(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        c("Attached SDK instance: " + nVar + "...");
    }

    private void c(String str) {
        if (this.logger != null && x.Fn()) {
            this.logger.f("AppLovinCommunicator", str);
        }
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.sdk + '}';
    }
}
