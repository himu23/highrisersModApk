package com.fyber.inneractive.sdk.ignite;

import java.util.HashMap;
import java.util.Map;

public enum i {
    FAILED_TO_BIND_SERVICE("failed to bind"),
    FAILED_TO_RETRIEVE_CREDENTIALS("failed to retrieve credentials"),
    FAILED_TO_AUTHENTICATE("failed to authenticate"),
    INSTALL_TIMEOUT("install timeout"),
    WEBPAGE_NOT_LOADED_BEFORE_SHOW("webpage not loaded before show"),
    LOAD_WEBPAGE_TIMEOUT("webpage timeout"),
    NOT_CONNECTED("not connected"),
    SESSION_EXPIRED("session expired"),
    DOWNLOAD_IS_CANCELLED("Download is cancelled");
    
    private static final Map<String, i> CONSTANTS = null;
    private final String value;

    /* access modifiers changed from: public */
    static {
        int i;
        CONSTANTS = new HashMap();
        for (i iVar : values()) {
            CONSTANTS.put(iVar.value, iVar);
        }
    }

    /* access modifiers changed from: public */
    i(String str) {
        this.value = str;
    }

    public String e() {
        return this.value;
    }
}
