package com.ironsource;

import java.lang.Thread;

public class r2 implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;

    r2(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(th.toString());
        sb.append(System.lineSeparator());
        boolean z = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString());
            sb.append(";" + System.lineSeparator());
            if (stackTraceElement.toString().contains(s2.d().e())) {
                z = true;
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            sb.append("--CAUSE");
            sb.append(System.lineSeparator());
            sb.append(cause.toString());
            sb.append(System.lineSeparator());
            for (StackTraceElement stackTraceElement2 : cause.getStackTrace()) {
                sb.append(stackTraceElement2.toString());
                sb.append(";" + System.lineSeparator());
                if (stackTraceElement2.toString().contains(s2.d().e())) {
                    z = true;
                }
            }
        }
        if (z) {
            new h4(sb.toString(), "" + System.currentTimeMillis(), "Crash").a();
        }
        this.a.uncaughtException(thread, th);
    }
}
