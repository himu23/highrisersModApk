package com.ironsource.mediationsdk.logger;

import android.os.Looper;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.m2;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

public class a extends IronSourceLogger {
    public static final String c = "console";
    public static final String d = "ironSourceSDK: ";

    private a() {
        super(c);
    }

    public a(int i) {
        super(c, i);
    }

    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        StringBuilder sb = new StringBuilder("UIThread: ");
        sb.append(Looper.getMainLooper() == Looper.myLooper());
        sb.append(" ");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder("Activity: ");
        sb3.append(ContextProvider.getInstance().getCurrentActiveActivity() != null ? Integer.valueOf(ContextProvider.getInstance().getCurrentActiveActivity().hashCode()) : Boolean.FALSE);
        sb3.append(" ");
        String sb4 = sb3.toString();
        if (i == 0) {
            Log.v(d + ironSourceTag, sb2 + sb4 + str);
        } else if (i == 1) {
            Log.i(d + ironSourceTag, str);
        } else if (i == 2) {
            Log.w(d + ironSourceTag, str);
        } else if (i == 3) {
            Log.e(d + ironSourceTag, str);
        }
    }

    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        log(ironSourceTag, str + ":stacktrace[" + Log.getStackTraceString(th) + m2.i.e, 3);
    }
}
