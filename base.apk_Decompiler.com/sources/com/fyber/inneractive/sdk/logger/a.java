package com.fyber.inneractive.sdk.logger;

import android.content.Context;
import android.util.Log;
import com.fyber.inneractive.sdk.util.IAlog;

public class a extends FMPLogger {
    public void debug(String str, Object... objArr) {
        if (IAlog.a <= 3) {
            Log.d("Inneractive_debug", String.format(str, objArr));
        }
    }

    public void error(String str, Throwable th, Object... objArr) {
        if (IAlog.a > 6) {
            return;
        }
        if (th == null) {
            Log.e("Inneractive_error", String.format(str, objArr));
        } else {
            Log.e("Inneractive_error", String.format(str, objArr), th);
        }
    }

    public void info(String str, Object... objArr) {
        if (IAlog.a <= 4) {
            Log.i("Inneractive_info", String.format(str, objArr));
        }
    }

    public void initialize(Context context) {
    }

    public void log(int i, Exception exc, String str, Object... objArr) {
        if (IAlog.a > i) {
            return;
        }
        if (exc == null) {
            Log.v("Inneractive_general", String.format(str, objArr));
        } else {
            Log.v("Inneractive_general", String.format(str, objArr), exc);
        }
    }

    public void verbose(String str, Object... objArr) {
        if (IAlog.a <= 2) {
            Log.v("Inneractive_verbose", String.format(str, objArr));
        }
    }

    public void warning(String str, Object... objArr) {
        if (IAlog.a <= 4) {
            Log.w("Inneractive_warning", String.format(str, objArr));
        }
    }

    public void verbose(String str, Throwable th, Object... objArr) {
        if (IAlog.a <= 2) {
            Log.v("Inneractive_verbose", String.format(str, objArr), th);
        }
    }
}
