package com.fyber.marketplace.fairbid.bridge;

import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.g;
import java.util.List;
import org.json.JSONObject;

public interface MarketplaceAuctionParameters {
    String getAdvertisingId();

    String getAmazonAdvertisingId();

    String getAppVersion();

    String getBundleId();

    String getCarrier();

    String getDeviceModel();

    s getFeatureProvider(String str);

    int getHeight();

    @Deprecated
    String getHorizontalAccuracy();

    List<String> getInputLanguages();

    String getLanguage();

    @Deprecated
    String getLatitudeLongitude();

    JSONObject getMarketplaceEntry();

    String getMobileCountryCode();

    String getMobileNetworkCode();

    String getNetwork();

    List<Integer> getSupportedApis();

    List<String> getSupportedMimes();

    List<Integer> getSupportedProtocols();

    int getSupportedTypesBitwise();

    @Deprecated
    String getTimeAccuracy();

    @Deprecated
    String getVerticalAccuracy();

    int getWidth();

    g getWrapperQueryInfo(String str);

    boolean hasAmazonAdvertisingId();

    Boolean isLimitTrackingEnabled();
}
