package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

final class AutoValue_SchedulerConfig extends SchedulerConfig {
    private final Clock clock;
    private final Map<Priority, SchedulerConfig.ConfigValue> values;

    /* access modifiers changed from: package-private */
    public Clock getClock() {
        return this.clock;
    }

    /* access modifiers changed from: package-private */
    public Map<Priority, SchedulerConfig.ConfigValue> getValues() {
        return this.values;
    }

    AutoValue_SchedulerConfig(Clock clock2, Map<Priority, SchedulerConfig.ConfigValue> map) {
        if (clock2 != null) {
            this.clock = clock2;
            if (map != null) {
                this.values = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.clock + ", values=" + this.values + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        if (!this.clock.equals(schedulerConfig.getClock()) || !this.values.equals(schedulerConfig.getValues())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.clock.hashCode() ^ 1000003) * 1000003) ^ this.values.hashCode();
    }
}
