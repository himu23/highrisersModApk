package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdContentRating;
import com.applovin.sdk.AppLovinGender;
import com.applovin.sdk.AppLovinTargetingData;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppLovinTargetingDataImpl implements AppLovinTargetingData {
    private List<String> aAa = null;
    private List<String> aoI = null;
    private final Map<String, String> azT = new HashMap();
    private final Object azU = new Object();
    private Integer azV = null;
    private AppLovinGender azW = null;
    private AppLovinAdContentRating azX = null;
    private String azY = null;
    private String azZ = null;

    public String getEmail() {
        return this.azY;
    }

    public AppLovinGender getGender() {
        return this.azW;
    }

    public List<String> getInterests() {
        return this.aAa;
    }

    public List<String> getKeywords() {
        return this.aoI;
    }

    public AppLovinAdContentRating getMaximumAdContentRating() {
        return this.azX;
    }

    public String getPhoneNumber() {
        return this.azZ;
    }

    public Integer getYearOfBirth() {
        return this.azV;
    }

    public void setYearOfBirth(Integer num) {
        y("year_of_birth", num == null ? null : Integer.toString(num.intValue()));
        this.azV = num;
    }

    public void setGender(AppLovinGender appLovinGender) {
        String str;
        if (appLovinGender != null) {
            if (appLovinGender == AppLovinGender.FEMALE) {
                str = "F";
            } else if (appLovinGender == AppLovinGender.MALE) {
                str = "M";
            } else if (appLovinGender == AppLovinGender.OTHER) {
                str = "O";
            }
            y(InneractiveMediationDefs.KEY_GENDER, str);
            this.azW = appLovinGender;
        }
        str = null;
        y(InneractiveMediationDefs.KEY_GENDER, str);
        this.azW = appLovinGender;
    }

    public void setMaximumAdContentRating(AppLovinAdContentRating appLovinAdContentRating) {
        y("maximum_ad_content_rating", (appLovinAdContentRating == null || appLovinAdContentRating == AppLovinAdContentRating.NONE) ? null : Integer.toString(appLovinAdContentRating.ordinal()));
        this.azX = appLovinAdContentRating;
    }

    public void setEmail(String str) {
        y("email", str != null ? StringUtils.toFullSHA1Hash(str.toLowerCase().trim()) : str);
        this.azY = str;
    }

    public void setPhoneNumber(String str) {
        y("phone_number", str != null ? StringUtils.toFullSHA1Hash(str.replaceAll("[^0-9]", "")) : str);
        this.azZ = str;
    }

    public void setKeywords(List<String> list) {
        y("keywords", list == null ? null : CollectionUtils.implode(list, list.size()));
        this.aoI = list;
    }

    public void setInterests(List<String> list) {
        y("interests", list == null ? null : CollectionUtils.implode(list, list.size()));
        this.aAa = list;
    }

    public void clearAll() {
        synchronized (this.azU) {
            this.azT.clear();
        }
        this.azV = null;
        this.azW = null;
        this.azX = null;
        this.azY = null;
        this.azZ = null;
        this.aoI = null;
        this.aAa = null;
    }

    public Map<String, String> getAllData() {
        Map<String, String> map;
        synchronized (this.azU) {
            map = CollectionUtils.map(this.azT);
        }
        return map;
    }

    private void y(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.azU) {
                if (StringUtils.isValidString(str2)) {
                    this.azT.put(str, str2);
                } else {
                    this.azT.remove(str);
                }
            }
        }
    }
}
