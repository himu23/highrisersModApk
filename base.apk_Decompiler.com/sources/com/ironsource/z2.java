package com.ironsource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class z2 extends SQLiteOpenHelper {
    public z2(Context context) {
        super(context, "reports", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.database.Cursor a(int r4) {
        /*
            java.lang.String r0 = "SELECT * FROM REPORTSWHERE id= "
            com.ironsource.z2 r1 = new com.ironsource.z2
            com.ironsource.s2 r2 = com.ironsource.s2.d()
            android.content.Context r2 = r2.a()
            r1.<init>(r2)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r3.<init>(r0)     // Catch:{ all -> 0x002d }
            r3.append(r4)     // Catch:{ all -> 0x002d }
            java.lang.String r4 = ";"
            r3.append(r4)     // Catch:{ all -> 0x002d }
            java.lang.String r4 = r3.toString()     // Catch:{ all -> 0x002d }
            android.database.Cursor r4 = r1.rawQuery(r4, r2)     // Catch:{ all -> 0x002d }
            r1.close()
            return r4
        L_0x002d:
            r4 = move-exception
            r2 = r1
            goto L_0x0031
        L_0x0030:
            r4 = move-exception
        L_0x0031:
            if (r2 == 0) goto L_0x0036
            r2.close()
        L_0x0036:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.z2.a(int):android.database.Cursor");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a() {
        /*
            com.ironsource.z2 r0 = new com.ironsource.z2
            com.ironsource.s2 r1 = com.ironsource.s2.d()
            android.content.Context r1 = r1.a()
            r0.<init>(r1)
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "DELETE FROM REPORTS WHERE id >= 0;"
            r0.execSQL(r1)     // Catch:{ all -> 0x001a }
            r0.close()
            return
        L_0x001a:
            r1 = move-exception
            goto L_0x001e
        L_0x001c:
            r1 = move-exception
            r0 = 0
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()
        L_0x0023:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.z2.a():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.ironsource.h4 r6) {
        /*
            com.ironsource.z2 r0 = new com.ironsource.z2
            com.ironsource.s2 r1 = com.ironsource.s2.d()
            android.content.Context r1 = r1.a()
            r0.<init>(r1)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x0047 }
            r0.beginTransaction()     // Catch:{ all -> 0x0044 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x0044 }
            r2.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = r6.e()     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = r6.b()     // Catch:{ all -> 0x0044 }
            java.lang.String r6 = r6.d()     // Catch:{ all -> 0x0044 }
            java.lang.String r5 = "stack_trace"
            r2.put(r5, r3)     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = "crash_date"
            r2.put(r3, r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = "crashType"
            r2.put(r3, r6)     // Catch:{ all -> 0x0044 }
            java.lang.String r6 = "REPORTS"
            r0.insert(r6, r1, r2)     // Catch:{ all -> 0x0044 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0044 }
            r0.endTransaction()
            r0.close()
            return
        L_0x0044:
            r6 = move-exception
            r1 = r0
            goto L_0x0048
        L_0x0047:
            r6 = move-exception
        L_0x0048:
            if (r1 == 0) goto L_0x0050
            r1.endTransaction()
            r1.close()
        L_0x0050:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.z2.a(com.ironsource.h4):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ironsource.h4 b(int r5) {
        /*
            java.lang.String r0 = "SELECT * FROM REPORTSWHERE id= "
            com.ironsource.z2 r1 = new com.ironsource.z2
            com.ironsource.s2 r2 = com.ironsource.s2.d()
            android.content.Context r2 = r2.a()
            r1.<init>(r2)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ all -> 0x004c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r3.<init>(r0)     // Catch:{ all -> 0x0049 }
            r3.append(r5)     // Catch:{ all -> 0x0049 }
            java.lang.String r5 = ";"
            r3.append(r5)     // Catch:{ all -> 0x0049 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x0049 }
            android.database.Cursor r5 = r1.rawQuery(r5, r2)     // Catch:{ all -> 0x0049 }
            r0 = 0
            int r0 = r5.getInt(r0)     // Catch:{ all -> 0x0049 }
            r2 = 1
            java.lang.String r2 = r5.getString(r2)     // Catch:{ all -> 0x0049 }
            r3 = 2
            java.lang.String r3 = r5.getString(r3)     // Catch:{ all -> 0x0049 }
            r4 = 3
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0049 }
            r5.close()     // Catch:{ all -> 0x0049 }
            com.ironsource.h4 r5 = new com.ironsource.h4     // Catch:{ all -> 0x0049 }
            r5.<init>(r0, r2, r3, r4)     // Catch:{ all -> 0x0049 }
            r1.close()
            return r5
        L_0x0049:
            r5 = move-exception
            r2 = r1
            goto L_0x004d
        L_0x004c:
            r5 = move-exception
        L_0x004d:
            if (r2 == 0) goto L_0x0052
            r2.close()
        L_0x0052:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.z2.b(int):com.ironsource.h4");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.ironsource.h4> b() {
        /*
            com.ironsource.z2 r0 = new com.ironsource.z2
            com.ironsource.s2 r1 = com.ironsource.s2.d()
            android.content.Context r1 = r1.a()
            r0.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "SELECT * FROM REPORTS ;"
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ all -> 0x004f }
            android.database.Cursor r2 = r0.rawQuery(r2, r3)     // Catch:{ all -> 0x004c }
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x0045
        L_0x0023:
            r3 = 0
            int r3 = r2.getInt(r3)     // Catch:{ all -> 0x004c }
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x004c }
            r5 = 2
            java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x004c }
            r6 = 3
            java.lang.String r6 = r2.getString(r6)     // Catch:{ all -> 0x004c }
            com.ironsource.h4 r7 = new com.ironsource.h4     // Catch:{ all -> 0x004c }
            r7.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x004c }
            r1.add(r7)     // Catch:{ all -> 0x004c }
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x004c }
            if (r3 != 0) goto L_0x0023
        L_0x0045:
            r2.close()     // Catch:{ all -> 0x004c }
            r0.close()
            return r1
        L_0x004c:
            r1 = move-exception
            r3 = r0
            goto L_0x0050
        L_0x004f:
            r1 = move-exception
        L_0x0050:
            if (r3 == 0) goto L_0x0055
            r3.close()
        L_0x0055:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.z2.b():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.database.Cursor c() {
        /*
            com.ironsource.z2 r0 = new com.ironsource.z2
            com.ironsource.s2 r1 = com.ironsource.s2.d()
            android.content.Context r1 = r1.a()
            r0.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r1 = "SELECT * FROM REPORTS;"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ all -> 0x0024 }
            android.database.Cursor r1 = r0.rawQuery(r1, r2)     // Catch:{ all -> 0x0021 }
            r0.close()
            return r1
        L_0x0021:
            r1 = move-exception
            r2 = r0
            goto L_0x0025
        L_0x0024:
            r1 = move-exception
        L_0x0025:
            if (r2 == 0) goto L_0x002a
            r2.close()
        L_0x002a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.z2.c():android.database.Cursor");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS REPORTS(id INTEGER PRIMARY KEY AUTOINCREMENT , stack_trace TEXT NOT NULL, crash_date TEXT NOT NULL,crashType TEXT NOT NULL );");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
