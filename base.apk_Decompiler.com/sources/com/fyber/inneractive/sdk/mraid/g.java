package com.fyber.inneractive.sdk.mraid;

public enum g {
    CLOSE("close"),
    EXPAND("expand"),
    USECUSTOMCLOSE("usecustomclose"),
    OPEN("open"),
    RESIZE("resize"),
    GET_RESIZE_PROPERTIES("getResizeProperties"),
    SET_RESIZE_PROPERTIES("setResizeProperties"),
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO("playVideo"),
    STORE_PICTURE("storePicture"),
    GET_CURRENT_POSITION("getCurrentPosition"),
    GET_DEFAULT_POSITION("getDefaultPosition"),
    GET_MAX_SIZE("getMaxSize"),
    GET_SCREEN_SIZE("getScreenSize"),
    CREATE_CALENDAR_EVENT("createCalendarEvent"),
    UNSPECIFIED("");
    
    private String mCommand;

    /* access modifiers changed from: public */
    g(String str) {
        this.mCommand = str;
    }

    public static g a(String str) {
        for (g gVar : values()) {
            if (gVar.mCommand.equals(str)) {
                return gVar;
            }
        }
        return UNSPECIFIED;
    }

    public String e() {
        return this.mCommand;
    }
}
