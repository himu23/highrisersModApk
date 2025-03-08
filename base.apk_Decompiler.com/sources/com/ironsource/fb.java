package com.ironsource;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.d;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import org.json.JSONObject;

public class fb {

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;
        final /* synthetic */ int c;

        a(String str, boolean z, int i) {
            this.a = str;
            this.b = z;
            this.c = i;
        }

        public void run() {
            fb.c(this.a, this.b, this.c);
        }
    }

    public static void b(String str, boolean z, int i) {
        Thread thread = new Thread(new a(str, z, i), "callAsyncRequestURL");
        thread.setUncaughtExceptionHandler(new d());
        thread.start();
    }

    /* access modifiers changed from: private */
    public static void c(String str, boolean z, int i) {
        try {
            new JSONObject(HttpFunctions.getStringFromURL(ServerURL.getRequestURL(str, z, i)));
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NETWORK;
            logger.log(ironSourceTag, "callRequestURL(reqUrl:" + str + ", hit:" + z + ")", 1);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("callRequestURL(reqUrl:");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(", hit:");
            sb.append(z);
            sb.append(")");
            IronSourceLoggerManager logger2 = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NETWORK;
            logger2.log(ironSourceTag2, sb.toString() + ", e:" + Log.getStackTraceString(th), 0);
        }
    }
}
