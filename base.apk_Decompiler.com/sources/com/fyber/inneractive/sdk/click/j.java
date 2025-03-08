package com.fyber.inneractive.sdk.click;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.click.l;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.google.android.gms.drive.DriveFile;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class j implements a {
    public static final Comparator<ResolveInfo> a = new a();

    public class a implements Comparator<ResolveInfo> {
        public int compare(Object obj, Object obj2) {
            ActivityInfo activityInfo;
            String str;
            ResolveInfo resolveInfo = (ResolveInfo) obj2;
            ActivityInfo activityInfo2 = ((ResolveInfo) obj).activityInfo;
            if (activityInfo2 == null || (activityInfo = resolveInfo.activityInfo) == null || (str = activityInfo2.packageName) == null) {
                return 1;
            }
            return str.compareTo(activityInfo.packageName);
        }
    }

    public boolean a(Uri uri, l lVar) {
        return true;
    }

    public b a(Context context, Uri uri, List<i> list) {
        Intent intent;
        ResolveInfo resolveInfo;
        if (Build.VERSION.SDK_INT > 29) {
            String scheme = uri.getScheme();
            if (!ProxyConfig.MATCH_HTTP.equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                if (!(context instanceof Activity)) {
                    intent2.setFlags(DriveFile.MODE_READ_ONLY);
                }
                return a(context, intent2, uri, list);
            }
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 32);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        List<ResolveInfo> queryIntentActivities2 = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("http://www.fyber.com")), 32);
        TreeSet treeSet = new TreeSet(a);
        treeSet.addAll(queryIntentActivities2);
        queryIntentActivities.removeAll(treeSet);
        if (queryIntentActivities.size() <= 0 || (resolveInfo = queryIntentActivities.get(0)) == null) {
            intent = null;
        } else {
            intent = new Intent("android.intent.action.VIEW", uri);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent.setClassName(activityInfo.packageName, activityInfo.name);
            if (!(context instanceof Activity)) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
            }
        }
        if (intent != null) {
            return a(context, intent, uri, list);
        }
        return null;
    }

    public final b a(Context context, Intent intent, Uri uri, List<i> list) {
        try {
            context.startActivity(intent);
            if (list != null) {
                list.add(new i(uri.toString(), true, a(intent), (String) null));
            }
            return l.a(uri.toString(), a(intent), "Resolver");
        } catch (Exception e) {
            IAlog.a("failed starting activity with error: %s", e.getLocalizedMessage());
            if (list != null) {
                list.add(new i(uri.toString(), false, l.d.OPEN_IN_EXTERNAL_APPLICATION, (String) null));
            }
            return l.a(uri.toString(), "Resolver", "failed starting resolved activity - " + e.getMessage());
        }
    }

    public final l.d a(Intent intent) {
        if (intent.getData() != null) {
            String uri = intent.getData().toString();
            int i = b0.b;
            if (!TextUtils.isEmpty(uri)) {
                Uri parse = Uri.parse(uri);
                String host = parse.getHost();
                String scheme = parse.getScheme();
                if (((uri.startsWith("http:") || uri.startsWith("https:")) && ("play.google.com".equalsIgnoreCase(host) || "market.android.com".equalsIgnoreCase(host))) || "market".equalsIgnoreCase(scheme)) {
                    return l.d.OPEN_GOOGLE_STORE;
                }
            }
        }
        return l.d.OPEN_IN_EXTERNAL_APPLICATION;
    }
}
