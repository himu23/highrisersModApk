package com.applovin.impl.sdk;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinUserSegment;

class h implements AppLovinUserSegment {
    private String name;

    public String getName() {
        return this.name;
    }

    h() {
    }

    public void setName(String str) {
        if (str != null) {
            if (str.length() > 32) {
                x.H("AppLovinUserSegment", "Setting name greater than 32 characters: " + str);
            }
            if (!StringUtils.isAlphaNumeric(str)) {
                x.H("AppLovinUserSegment", "Setting name that is not alphanumeric: " + str);
            }
        }
        this.name = str;
    }

    public String toString() {
        return "AppLovinUserSegment{name=" + getName() + '}';
    }
}
