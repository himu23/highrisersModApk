package com.ironsource.mediationsdk.logger;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

public enum IronLog {
    API(IronSourceLogger.IronSourceTag.API),
    CALLBACK(IronSourceLogger.IronSourceTag.CALLBACK),
    ADAPTER_API(IronSourceLogger.IronSourceTag.ADAPTER_API),
    ADAPTER_CALLBACK(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK),
    NETWORK(IronSourceLogger.IronSourceTag.NETWORK),
    INTERNAL(IronSourceLogger.IronSourceTag.INTERNAL),
    NATIVE(IronSourceLogger.IronSourceTag.NATIVE),
    EVENT(IronSourceLogger.IronSourceTag.EVENT);
    
    IronSourceLogger.IronSourceTag a;

    private IronLog(IronSourceLogger.IronSourceTag ironSourceTag) {
        this.a = ironSourceTag;
    }

    private String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return String.format("%s %s", new Object[]{a(stackTrace, 5), b(stackTrace, 5)});
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return a();
        }
        return String.format("%s - %s", new Object[]{a(), str});
    }

    private String a(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr.length <= i) {
            return "";
        }
        String[] split = stackTraceElementArr[i].getClassName().split("\\.");
        String str = split[split.length - 1];
        return str.contains("$") ? str.split("\\$")[0] : str;
    }

    private String b(StackTraceElement[] stackTraceElementArr, int i) {
        StackTraceElement stackTraceElement;
        int i2;
        if (stackTraceElementArr.length <= i) {
            return "";
        }
        String[] split = stackTraceElementArr[i].getClassName().split("\\.");
        String str = split[split.length - 1];
        if (str.contains("$")) {
            String[] split2 = str.split("\\$");
            return split2[1] + "." + stackTraceElementArr[i].getMethodName();
        }
        if (!stackTraceElementArr[i].getMethodName().contains("$") || stackTraceElementArr.length <= (i2 = i + 1)) {
            stackTraceElement = stackTraceElementArr[i];
        } else {
            String[] split3 = stackTraceElementArr[i2].getClassName().split("\\$");
            if (split3.length > 1) {
                return split3[1] + "." + stackTraceElementArr[i2].getMethodName();
            }
            stackTraceElement = stackTraceElementArr[i2];
        }
        return stackTraceElement.getMethodName();
    }

    public void error() {
        IronSourceLoggerManager.getLogger().log(this.a, a(""), 3);
    }

    public void error(String str) {
        IronSourceLoggerManager.getLogger().log(this.a, a(str), 3);
    }

    public void info() {
        IronSourceLoggerManager.getLogger().log(this.a, a(""), 1);
    }

    public void info(String str) {
        IronSourceLoggerManager.getLogger().log(this.a, a(str), 1);
    }

    public void verbose() {
        IronSourceLoggerManager.getLogger().log(this.a, a(""), 0);
    }

    public void verbose(String str) {
        IronSourceLoggerManager.getLogger().log(this.a, a(str), 0);
    }

    public void warning() {
        IronSourceLoggerManager.getLogger().log(this.a, a(""), 2);
    }

    public void warning(String str) {
        IronSourceLoggerManager.getLogger().log(this.a, a(str), 2);
    }
}
