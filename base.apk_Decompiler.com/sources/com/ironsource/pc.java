package com.ironsource;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class pc {
    public static void a(Context context, String str) throws Exception {
        a(context, str, (String) null);
    }

    public static void a(Context context, String str, String str2) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            context.startActivity(intent);
            return;
        }
        throw new Exception("url is null");
    }
}
