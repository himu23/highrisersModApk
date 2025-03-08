package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;
import java.util.Iterator;

public class IronSourceLoggerManager extends IronSourceLogger implements LogListener {
    private static IronSourceLoggerManager d;
    private ArrayList<IronSourceLogger> c = new ArrayList<>();

    private IronSourceLoggerManager(String str) {
        super(str);
        c();
    }

    private IronSourceLoggerManager(String str, int i) {
        super(str, i);
        c();
    }

    private IronSourceLogger a(String str) {
        Iterator<IronSourceLogger> it = this.c.iterator();
        while (it.hasNext()) {
            IronSourceLogger next = it.next();
            if (next.b().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private void c() {
        this.c.add(new a(0));
    }

    public static synchronized IronSourceLoggerManager getLogger() {
        IronSourceLoggerManager ironSourceLoggerManager;
        synchronized (IronSourceLoggerManager.class) {
            if (d == null) {
                d = new IronSourceLoggerManager("IronSourceLoggerManager");
            }
            ironSourceLoggerManager = d;
        }
        return ironSourceLoggerManager;
    }

    public static synchronized IronSourceLoggerManager getLogger(int i) {
        IronSourceLoggerManager ironSourceLoggerManager;
        synchronized (IronSourceLoggerManager.class) {
            IronSourceLoggerManager ironSourceLoggerManager2 = d;
            if (ironSourceLoggerManager2 == null) {
                d = new IronSourceLoggerManager("IronSourceLoggerManager");
            } else {
                ironSourceLoggerManager2.a = i;
            }
            ironSourceLoggerManager = d;
        }
        return ironSourceLoggerManager;
    }

    public void addLogger(IronSourceLogger ironSourceLogger) {
        this.c.add(ironSourceLogger);
    }

    public synchronized void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        if (i >= this.a) {
            Iterator<IronSourceLogger> it = this.c.iterator();
            while (it.hasNext()) {
                IronSourceLogger next = it.next();
                if (next.a() <= i) {
                    next.log(ironSourceTag, str, i);
                }
            }
        }
    }

    public synchronized void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th == null) {
            Iterator<IronSourceLogger> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().log(ironSourceTag, str, 3);
            }
        } else {
            Iterator<IronSourceLogger> it2 = this.c.iterator();
            while (it2.hasNext()) {
                it2.next().logException(ironSourceTag, str, th);
            }
        }
    }

    public synchronized void onLog(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        log(ironSourceTag, str, i);
    }

    public void setLoggerDebugLevel(String str, int i) {
        if (str != null) {
            IronSourceLogger a = a(str);
            if (a == null) {
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                log(ironSourceTag, "Failed to find logger:setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i + ")", 0);
            } else if (i < 0 || i > 3) {
                this.c.remove(a);
            } else {
                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NATIVE;
                log(ironSourceTag2, "setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i + ")", 0);
                a.setDebugLevel(i);
            }
        }
    }
}
