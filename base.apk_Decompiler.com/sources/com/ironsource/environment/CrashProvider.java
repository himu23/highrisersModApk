package com.ironsource.environment;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.ironsource.z2;

public class CrashProvider extends ContentProvider {
    Context a;
    z2 b;
    String c;
    UriMatcher d = new UriMatcher(-1);
    Uri e;
    final int f = 1;
    final int g = 2;
    String h;
    String i;
    final String j = "REPORTS";

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        int match = this.d.match(uri);
        if (match == 1) {
            return this.h;
        }
        if (match == 2) {
            return this.i;
        }
        throw new IllegalArgumentException("Invalid URI: " + uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        this.a = getContext();
        this.b = new z2(this.a);
        this.c = this.a.getPackageName();
        this.e = Uri.parse("content://" + this.c + "/REPORTS");
        this.h = "vnd.android.cursor.dir/CrashReporter.Reports";
        this.i = "vnd.android.cursor.item/CrashReporter/Reports";
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int match = this.d.match(uri);
        if (match == 1) {
            return z2.c();
        }
        if (match == 2) {
            return z2.a(Integer.parseInt(uri.getLastPathSegment()));
        }
        throw new IllegalArgumentException("Invalid URI: " + uri);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
