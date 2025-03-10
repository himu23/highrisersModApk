package com.unity3d.services.core.configuration;

import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.mapper.WebRequestToHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import org.json.JSONObject;

public class ConfigurationLoader implements IConfigurationLoader {
    private final ConfigurationRequestFactory _configurationRequestFactory;
    private final HttpClient _httpClient;
    private final Configuration _localConfiguration;
    private final SDKMetricsSender _sdkMetricsSender;

    public Configuration getLocalConfiguration() {
        return this._localConfiguration;
    }

    public ConfigurationLoader(ConfigurationRequestFactory configurationRequestFactory, SDKMetricsSender sDKMetricsSender, HttpClient httpClient) {
        this._localConfiguration = configurationRequestFactory.getConfiguration();
        this._configurationRequestFactory = configurationRequestFactory;
        this._sdkMetricsSender = sDKMetricsSender;
        this._httpClient = httpClient;
    }

    public void loadConfiguration(IConfigurationLoaderListener iConfigurationLoaderListener) throws Exception {
        try {
            HttpRequest httpRequest = WebRequestToHttpRequestKt.toHttpRequest(this._configurationRequestFactory.getWebRequest());
            InitializeEventsMetricSender.getInstance().didConfigRequestStart();
            HttpResponse executeBlocking = this._httpClient.executeBlocking(httpRequest);
            String obj = executeBlocking.getBody().toString();
            if (executeBlocking.getStatusCode() / 100 == 2) {
                try {
                    this._localConfiguration.handleConfigurationData(new JSONObject(obj), true);
                    sendConfigMetrics(this._localConfiguration.getUnifiedAuctionToken(), this._localConfiguration.getStateId());
                    iConfigurationLoaderListener.onSuccess(this._localConfiguration);
                } catch (Exception unused) {
                    iConfigurationLoaderListener.onError("Could not create web request");
                }
            } else {
                iConfigurationLoaderListener.onError("Non 2xx HTTP status received from ads configuration request.");
            }
        } catch (Exception e) {
            iConfigurationLoaderListener.onError("Could not create web request: " + e);
        }
    }

    private void sendConfigMetrics(String str, String str2) {
        if (str == null || str.isEmpty()) {
            this._sdkMetricsSender.sendMetric(TSIMetric.newMissingToken());
        }
        if (str2 == null || str2.isEmpty()) {
            this._sdkMetricsSender.sendMetric(TSIMetric.newMissingStateId());
        }
    }
}
