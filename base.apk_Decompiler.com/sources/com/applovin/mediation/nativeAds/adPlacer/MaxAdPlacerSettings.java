package com.applovin.mediation.nativeAds.adPlacer;

import com.applovin.impl.sdk.x;
import java.util.Set;
import java.util.TreeSet;

public class MaxAdPlacerSettings {
    public static final int MIN_REPEATING_INTERVAL = 2;
    private final Set<Integer> aYY = new TreeSet();
    private int aYZ = 0;
    private int aZa = 256;
    private int aZb = 4;
    private final String adUnitId;
    private String amN;

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public Set<Integer> getFixedPositions() {
        return this.aYY;
    }

    public int getMaxAdCount() {
        return this.aZa;
    }

    public int getMaxPreloadedAdCount() {
        return this.aZb;
    }

    public String getPlacement() {
        return this.amN;
    }

    public int getRepeatingInterval() {
        return this.aYZ;
    }

    public boolean isRepeatingEnabled() {
        return this.aYZ >= 2;
    }

    public void setMaxAdCount(int i) {
        this.aZa = i;
    }

    public void setMaxPreloadedAdCount(int i) {
        this.aZb = i;
    }

    public void setPlacement(String str) {
        this.amN = str;
    }

    public MaxAdPlacerSettings(String str) {
        this.adUnitId = str;
    }

    public void addFixedPosition(int i) {
        this.aYY.add(Integer.valueOf(i));
    }

    public void resetFixedPositions() {
        this.aYY.clear();
    }

    public void setRepeatingInterval(int i) {
        if (i >= 2) {
            this.aYZ = i;
            x.D("MaxAdPlacerSettings", "Repeating interval set to " + i);
            return;
        }
        this.aYZ = 0;
        x.F("MaxAdPlacerSettings", "Repeating interval has been disabled, since it has been set to " + i + ", which is less than minimum value of 2");
    }

    public boolean hasValidPositioning() {
        return !this.aYY.isEmpty() || isRepeatingEnabled();
    }

    public String toString() {
        return "MaxAdPlacerSettings{adUnitId='" + this.adUnitId + "', fixedPositions=" + this.aYY + ", repeatingInterval=" + this.aYZ + ", maxAdCount=" + this.aZa + ", maxPreloadedAdCount=" + this.aZb + '}';
    }
}
