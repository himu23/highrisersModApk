package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.bb;
import com.ironsource.r7;

@Deprecated
public class SSAFactory {
    public static bb getPublisherInstance(Activity activity) throws Exception {
        return r7.b((Context) activity);
    }

    public static bb getPublisherTestInstance(Activity activity, int i) throws Exception {
        return r7.a((Context) activity, i);
    }
}
