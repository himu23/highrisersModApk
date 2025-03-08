package com.fyber.inneractive.sdk.config.global.features;

public class b extends g {
    public b() {
        super("child_mode");
    }

    public g b() {
        b bVar = new b();
        a((g) bVar);
        return bVar;
    }

    public int d() {
        Integer b = b("skip_time_sec");
        int intValue = b != null ? b.intValue() : 5;
        if (intValue < 0 || intValue > 8) {
            return 5;
        }
        return intValue;
    }
}
