package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

class c4 {
    static final String a = "ironbeast";
    static final String b = "outcome";
    static final int c = 3;
    static final int d = 2;
    static final int e = 0;

    c4() {
    }

    static c a(String str, int i) {
        if (a.equals(str)) {
            return new f8(i);
        }
        if (b.equals(str)) {
            return new ba(i);
        }
        if (i == 2) {
            return new f8(i);
        }
        if (i == 3) {
            return new ba(i);
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        logger.log(ironSourceTag, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i + ")", 2);
        return null;
    }
}
