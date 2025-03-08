package com.applovin.impl.privacy.cmp;

import com.applovin.sdk.AppLovinCmpError;

public class CmpErrorImpl implements AppLovinCmpError {
    private final AppLovinCmpError.Code axs;
    private final String axt;
    private final int axu;
    private final String axv;

    public int getCmpCode() {
        return this.axu;
    }

    public String getCmpMessage() {
        return this.axv;
    }

    public AppLovinCmpError.Code getCode() {
        return this.axs;
    }

    public String getMessage() {
        return this.axt;
    }

    public String toString() {
        return "CmpErrorImpl(code=" + getCode() + ", message=" + getMessage() + ", cmpCode=" + getCmpCode() + ", cmpMessage=" + getCmpMessage() + ")";
    }

    public CmpErrorImpl(AppLovinCmpError.Code code, String str) {
        this(code, str, -1, "");
    }

    public CmpErrorImpl(AppLovinCmpError.Code code, String str, int i, String str2) {
        this.axs = code;
        this.axt = str;
        this.axu = i;
        this.axv = str2;
    }
}
