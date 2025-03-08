package com.applovin.impl.communicator;

import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {
    private ScheduledThreadPoolExecutor ajX;
    private final Object ajY = new Object();

    public String toString() {
        return "MessagingServiceImpl{}";
    }

    public void publish(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        ScheduledThreadPoolExecutor tt = tt();
        this.ajX = tt;
        tt.execute(new MessagingServiceImpl$$ExternalSyntheticLambda0(appLovinCommunicatorMessage));
    }

    private ScheduledThreadPoolExecutor tt() {
        synchronized (this.ajY) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.ajX;
            if (scheduledThreadPoolExecutor != null) {
                return scheduledThreadPoolExecutor;
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new MessagingServiceImpl$$ExternalSyntheticLambda1());
            return scheduledThreadPoolExecutor2;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread f(Runnable runnable) {
        Thread thread = new Thread(runnable, "AppLovinSdk:communicator");
        thread.setPriority(1);
        thread.setDaemon(true);
        return thread;
    }
}
