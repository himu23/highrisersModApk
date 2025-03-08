package com.applovin.exoplayer2.l;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class b {
    private static Method abI;

    public static IBinder a(Bundle bundle, String str) {
        if (ai.acV >= 18) {
            return bundle.getBinder(str);
        }
        return b(bundle, str);
    }

    private static IBinder b(Bundle bundle, String str) {
        Method method = abI;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                abI = method2;
                method2.setAccessible(true);
                method = abI;
            } catch (NoSuchMethodException e) {
                q.a("BundleUtil", "Failed to retrieve getIBinder method", e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, new Object[]{str});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            q.a("BundleUtil", "Failed to invoke getIBinder via reflection", e2);
            return null;
        }
    }
}
