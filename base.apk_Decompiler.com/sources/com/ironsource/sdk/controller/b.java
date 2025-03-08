package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.ironsource.sdk.controller.u;
import com.ironsource.sdk.utils.Logger;
import java.lang.reflect.Method;
import java.security.AccessControlException;

class b {
    private static final String b = "b";
    private final u.v a;

    b(u.v vVar) {
        this.a = vVar;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        u.v vVar = this.a;
        if (vVar != null) {
            vVar.b(str);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(String str, String str2) throws Exception {
        if (this.a == null) {
            Logger.e(b, "!!! nativeAPI == null !!!");
            return;
        }
        Method declaredMethod = u.v.class.getDeclaredMethod(str, new Class[]{String.class});
        if (declaredMethod.isAnnotationPresent(JavascriptInterface.class)) {
            declaredMethod.invoke(this.a, new Object[]{str2});
            return;
        }
        throw new AccessControlException("Trying to access a private function: " + str);
    }
}
