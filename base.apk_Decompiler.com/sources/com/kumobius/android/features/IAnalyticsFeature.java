package com.kumobius.android.features;

import java.util.Map;

public interface IAnalyticsFeature {
    void analyticsAddEventParam(String str, String str2);

    void analyticsBeginEvent();

    void analyticsEndTimedEvent(String str);

    void analyticsLogEvent(String str, Map<String, String> map, boolean z);

    void analyticsLogEvent(String str, boolean z);

    void analyticsOnStart();

    void analyticsOnStop();
}
