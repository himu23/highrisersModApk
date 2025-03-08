package com.ironsource.mediationsdk.adunit.adapter.internal;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.c;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.UUID;

public abstract class BaseAdAdapter<NetworkAdapter extends AdapterBaseInterface, Listener> {
    private final IronSource.AD_UNIT mAdUnit;
    protected final UUID mAdUnitObjectId;
    protected final NetworkSettings mNetworkSettings;

    public BaseAdAdapter(IronSource.AD_UNIT ad_unit, NetworkSettings networkSettings) {
        this(ad_unit, networkSettings, (UUID) null);
    }

    public BaseAdAdapter(IronSource.AD_UNIT ad_unit, NetworkSettings networkSettings, UUID uuid) {
        this.mAdUnit = ad_unit;
        this.mNetworkSettings = networkSettings;
        this.mAdUnitObjectId = uuid;
    }

    public NetworkAdapter getNetworkAdapter() {
        NetworkAdapter b = c.b().b(this.mNetworkSettings, this.mAdUnit, this.mAdUnitObjectId);
        if (b != null) {
            return b;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public NetworkSettings getNetworkSettings() {
        return this.mNetworkSettings;
    }

    public void releaseMemory() {
    }
}
