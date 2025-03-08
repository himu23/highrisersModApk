package com.applovin.impl.mediation;

import com.applovin.mediation.MaxReward;

public class MaxRewardImpl implements MaxReward {
    private final int alr;
    private final String dp;

    public final int getAmount() {
        return this.alr;
    }

    public final String getLabel() {
        return this.dp;
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    public static MaxReward create(int i, String str) {
        return new MaxRewardImpl(i, str);
    }

    private MaxRewardImpl(int i, String str) {
        if (i >= 0) {
            this.dp = str;
            this.alr = i;
            return;
        }
        throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
    }

    public String toString() {
        return "MaxReward{amount=" + this.alr + ", label=" + this.dp + "}";
    }
}
