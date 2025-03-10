package com.unity3d.services.core.configuration;

public enum InitRequestType {
    PRIVACY("privacy"),
    TOKEN("token_srr");
    
    private String _callType;

    public String getCallType() {
        return this._callType;
    }

    private InitRequestType(String str) {
        this._callType = str;
    }
}
