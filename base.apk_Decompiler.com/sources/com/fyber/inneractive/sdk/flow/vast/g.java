package com.fyber.inneractive.sdk.flow.vast;

public class g {
    public a a;
    public Object b;

    public enum a {
        BITRATE_NOT_IN_RANGE(1),
        UNSUPPORTED_MIME_TYPE(2),
        UNSUPPORTED_DELIVERY(3),
        UNSECURED_VIDEO_URL(4),
        VERTICAL_VIDEO_EXPECTED(5),
        FILTERED_BY_APP_OR_UNIT(6),
        NO_CONTENT(7);
        
        public int value;

        /* access modifiers changed from: public */
        a(int i) {
            this.value = i;
        }
    }

    public g(a aVar, Object obj) {
        this.a = aVar;
        this.b = obj;
    }

    public String toString() {
        return "Media File inc error::  type = " + this.a + " expected value = " + this.b;
    }
}
