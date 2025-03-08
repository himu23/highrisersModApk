package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.j0;
import java.util.PriorityQueue;

public class r {
    public static boolean a(Context context, l lVar) {
        v0 v0Var;
        PriorityQueue priorityQueue = (PriorityQueue) lVar.a;
        do {
            v0Var = (v0) priorityQueue.poll();
            if (v0Var == null || a(context, v0Var.b)) {
            }
            v0Var = (v0) priorityQueue.poll();
            break;
        } while (a(context, v0Var.b));
        if (v0Var == null) {
            return false;
        }
        boolean a = b0.a(context, new Intent("android.intent.action.VIEW", v0Var.b));
        if (a) {
            for (String next : v0Var.c) {
                if (!TextUtils.isEmpty(next)) {
                    int i = IAlog.a;
                    IAlog.a(1, (Exception) null, "%s %s", "SMART_LINK", next);
                }
                j0.b(next);
            }
        }
        return a;
    }

    public static boolean a(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        try {
            return !context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 0).isEmpty();
        } catch (Exception unused) {
            IAlog.a("%sFyberDeepLink: Invalid url ", uri);
            return false;
        }
    }
}
