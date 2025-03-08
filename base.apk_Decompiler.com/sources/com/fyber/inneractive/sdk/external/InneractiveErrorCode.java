package com.fyber.inneractive.sdk.external;

public enum InneractiveErrorCode {
    NO_FILL("No Ad Found", r4, r7),
    SERVER_INTERNAL_ERROR("Server Internal Error", r4, r5),
    SERVER_INVALID_RESPONSE("Failed Due To Invalid Server Response", r4, r5),
    SDK_INTERNAL_ERROR("SDK Internal Error", r4, r5),
    CANCELLED("Ad Request Was Cancelled", r4, r5),
    CONNECTION_TIMEOUT("Connection Timed Out", r4, r7),
    CONNECTION_ERROR("Network Connection Error", r4, r9),
    LOAD_TIMEOUT("Failed Due To load timeout", r4, r5),
    IN_FLIGHT_TIMEOUT("Failed Due To in flight timeout", r4, r5),
    UNKNOWN_APP_ID("Unknown App ID", r4, r5),
    INVALID_INPUT("User Entered Invalid Input", r7, r5),
    ERROR_CODE_NATIVE_VIDEO_NOT_SUPPORTED("Native Video Not Supported", r4, r5),
    NATIVE_ADS_NOT_SUPPORTED_FOR_OS("Native ads not supported for this Android version", r4, r5),
    ERROR_CONFIGURATION_MISMATCH("Internal Configuration Error", r4, r5),
    ERROR_CONFIGURATION_NO_SUCH_SPOT("Invalid spot supplied", r7, r7),
    SPOT_DISABLED("Selected spot is not active", r4, r5),
    UNSUPPORTED_SPOT("Unsupported Spot", r4, r5),
    NON_SECURE_CONTENT_DETECTED("Non secure content detected", r4, r5),
    UNSPECIFIED("Unspecified Error.", r4, r5),
    SDK_NOT_INITIALIZED("SDK was not initialized. Did you forget to call InneractiveAdManager.init(...)?", r4, r5),
    SDK_NOT_INITIALIZED_OR_CONFIG_ERROR("Invalid App Id", r7, r7);
    
    private final String message;
    private final Metricable metricable;
    private final Metricable timeMetricable;

    public enum Metricable {
        INCLUDED_IN_FAILED_METRICS,
        EXCLUDED_IN_FAILED_METRICS
    }

    /* access modifiers changed from: public */
    InneractiveErrorCode(String str, Metricable metricable2, Metricable metricable3) {
        this.message = str;
        this.metricable = metricable2;
        this.timeMetricable = metricable3;
    }

    public Metricable getMetricable() {
        return this.metricable;
    }

    public boolean shouldSendTimeMetric() {
        return this.timeMetricable == Metricable.INCLUDED_IN_FAILED_METRICS;
    }

    public String toString() {
        return this.message;
    }
}
