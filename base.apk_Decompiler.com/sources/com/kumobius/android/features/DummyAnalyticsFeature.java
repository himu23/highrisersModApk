package com.kumobius.android.features;

import com.kumobius.android.KumoAppActivity;
import java.util.Map;

public class DummyAnalyticsFeature implements IAnalyticsFeature {
    public void analyticsAddEventParam(String str, String str2) {
    }

    public void analyticsBeginEvent() {
    }

    public void analyticsEndTimedEvent(String str) {
    }

    public void analyticsLogEvent(String str, Map<String, String> map, boolean z) {
    }

    public void analyticsLogEvent(String str, boolean z) {
    }

    public void analyticsOnStart() {
    }

    public void analyticsOnStop() {
    }

    public DummyAnalyticsFeature(KumoAppActivity kumoAppActivity) {
    }
}
