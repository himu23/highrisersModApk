package com.ironsource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.provider.BaseColumns;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;

public class y2 extends SQLiteOpenHelper implements f5 {
    private static y2 e = null;
    private static final String f = " TEXT";
    private static final String g = " INTEGER";
    private static final String h = ",";
    private final int a = 4;
    private final int b = CommonGatewayClient.CODE_400;
    private final String c = "DROP TABLE IF EXISTS events";
    private final String d = "CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )";

    static abstract class a implements BaseColumns {
        public static final String a = "events";
        public static final int b = 4;
        public static final String c = "eventid";
        public static final String d = "timestamp";
        public static final String e = "type";
        public static final String f = "data";

        a() {
        }
    }

    public y2(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    private ContentValues a(y3 y3Var, String str) {
        if (y3Var == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("eventid", Integer.valueOf(y3Var.c()));
        contentValues.put(a.d, Long.valueOf(y3Var.d()));
        contentValues.put("type", str);
        contentValues.put("data", y3Var.a());
        return contentValues;
    }

    private synchronized SQLiteDatabase a(boolean z) throws Throwable {
        int i = 0;
        while (true) {
            if (z) {
                try {
                    return getWritableDatabase();
                } catch (Throwable th) {
                    i++;
                    if (i < 4) {
                        SystemClock.sleep((long) (i * CommonGatewayClient.CODE_400));
                    } else {
                        throw th;
                    }
                }
            } else {
                return getReadableDatabase();
            }
        }
    }

    public static synchronized y2 a(Context context, String str, int i) {
        y2 y2Var;
        synchronized (y2.class) {
            if (e == null) {
                e = new y2(context, str, i);
            }
            y2Var = e;
        }
        return y2Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        if (r1.isOpen() != false) goto L_0x008d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c A[SYNTHETIC, Splitter:B:28:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087 A[Catch:{ all -> 0x0092 }, DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.ArrayList<com.ironsource.y3> a(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00aa }
            r0.<init>()     // Catch:{ all -> 0x00aa }
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.a((boolean) r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r6 = "type = ?"
            java.lang.String[] r7 = new java.lang.String[]{r12}     // Catch:{ all -> 0x006f }
            java.lang.String r10 = "timestamp ASC"
            java.lang.String r4 = "events"
            r5 = 0
            r8 = 0
            r9 = 0
            r3 = r1
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x006f }
            int r12 = r2.getCount()     // Catch:{ all -> 0x006f }
            if (r12 <= 0) goto L_0x005f
            r2.moveToFirst()     // Catch:{ all -> 0x006f }
        L_0x0027:
            boolean r12 = r2.isAfterLast()     // Catch:{ all -> 0x006f }
            if (r12 != 0) goto L_0x005c
            java.lang.String r12 = "eventid"
            int r12 = r2.getColumnIndex(r12)     // Catch:{ all -> 0x006f }
            int r12 = r2.getInt(r12)     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "timestamp"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ all -> 0x006f }
            long r3 = r2.getLong(r3)     // Catch:{ all -> 0x006f }
            java.lang.String r5 = "data"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x006f }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x006f }
            com.ironsource.y3 r6 = new com.ironsource.y3     // Catch:{ all -> 0x006f }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x006f }
            r7.<init>(r5)     // Catch:{ all -> 0x006f }
            r6.<init>(r12, r3, r7)     // Catch:{ all -> 0x006f }
            r0.add(r6)     // Catch:{ all -> 0x006f }
            r2.moveToNext()     // Catch:{ all -> 0x006f }
            goto L_0x0027
        L_0x005c:
            r2.close()     // Catch:{ all -> 0x006f }
        L_0x005f:
            boolean r12 = r2.isClosed()     // Catch:{ all -> 0x00aa }
            if (r12 != 0) goto L_0x0068
            r2.close()     // Catch:{ all -> 0x00aa }
        L_0x0068:
            boolean r12 = r1.isOpen()     // Catch:{ all -> 0x00aa }
            if (r12 == 0) goto L_0x0090
            goto L_0x008d
        L_0x006f:
            r12 = move-exception
            goto L_0x0073
        L_0x0071:
            r12 = move-exception
            r1 = r2
        L_0x0073:
            java.lang.String r3 = "IronSource"
            java.lang.String r4 = "Exception while loading events: "
            android.util.Log.e(r3, r4, r12)     // Catch:{ all -> 0x0092 }
            if (r2 == 0) goto L_0x0085
            boolean r12 = r2.isClosed()     // Catch:{ all -> 0x00aa }
            if (r12 != 0) goto L_0x0085
            r2.close()     // Catch:{ all -> 0x00aa }
        L_0x0085:
            if (r1 == 0) goto L_0x0090
            boolean r12 = r1.isOpen()     // Catch:{ all -> 0x00aa }
            if (r12 == 0) goto L_0x0090
        L_0x008d:
            r1.close()     // Catch:{ all -> 0x00aa }
        L_0x0090:
            monitor-exit(r11)
            return r0
        L_0x0092:
            r12 = move-exception
            if (r2 == 0) goto L_0x009e
            boolean r0 = r2.isClosed()     // Catch:{ all -> 0x00aa }
            if (r0 != 0) goto L_0x009e
            r2.close()     // Catch:{ all -> 0x00aa }
        L_0x009e:
            if (r1 == 0) goto L_0x00a9
            boolean r0 = r1.isOpen()     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x00a9
            r1.close()     // Catch:{ all -> 0x00aa }
        L_0x00a9:
            throw r12     // Catch:{ all -> 0x00aa }
        L_0x00aa:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.y2.a(java.lang.String):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r0.isOpen() != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0061, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0044 A[SYNTHETIC, Splitter:B:27:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.util.List<com.ironsource.y3> r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x0060
            boolean r0 = r5.isEmpty()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x000a
            goto L_0x0060
        L_0x000a:
            r0 = 1
            r1 = 0
            android.database.sqlite.SQLiteDatabase r0 = r4.a((boolean) r0)     // Catch:{ all -> 0x003a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0037 }
        L_0x0014:
            boolean r2 = r5.hasNext()     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r5.next()     // Catch:{ all -> 0x0037 }
            com.ironsource.y3 r2 = (com.ironsource.y3) r2     // Catch:{ all -> 0x0037 }
            android.content.ContentValues r2 = r4.a((com.ironsource.y3) r2, (java.lang.String) r6)     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0014
            if (r2 == 0) goto L_0x0014
            java.lang.String r3 = "events"
            r0.insert(r3, r1, r2)     // Catch:{ all -> 0x0037 }
            goto L_0x0014
        L_0x002e:
            if (r0 == 0) goto L_0x004e
            boolean r5 = r0.isOpen()     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x004e
            goto L_0x004b
        L_0x0037:
            r5 = move-exception
            r1 = r0
            goto L_0x003b
        L_0x003a:
            r5 = move-exception
        L_0x003b:
            java.lang.String r6 = "IronSource"
            java.lang.String r0 = "Exception while saving events: "
            android.util.Log.e(r6, r0, r5)     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x004e
            boolean r5 = r1.isOpen()     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x004e
            r0 = r1
        L_0x004b:
            r0.close()     // Catch:{ all -> 0x005d }
        L_0x004e:
            monitor-exit(r4)
            return
        L_0x0050:
            r5 = move-exception
            if (r1 == 0) goto L_0x005c
            boolean r6 = r1.isOpen()     // Catch:{ all -> 0x005d }
            if (r6 == 0) goto L_0x005c
            r1.close()     // Catch:{ all -> 0x005d }
        L_0x005c:
            throw r5     // Catch:{ all -> 0x005d }
        L_0x005d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0060:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.y2.a(java.util.List, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        if (r1.isOpen() != false) goto L_0x002b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0025 A[SYNTHETIC, Splitter:B:20:0x0025] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "type = ?"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ all -> 0x003d }
            r1 = 1
            android.database.sqlite.SQLiteDatabase r1 = r3.a((boolean) r1)     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "events"
            r1.delete(r2, r0, r4)     // Catch:{ all -> 0x0018 }
            boolean r4 = r1.isOpen()     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x002e
            goto L_0x002b
        L_0x0018:
            r4 = move-exception
            goto L_0x001c
        L_0x001a:
            r4 = move-exception
            r1 = 0
        L_0x001c:
            java.lang.String r0 = "IronSource"
            java.lang.String r2 = "Exception while clearing events: "
            android.util.Log.e(r0, r2, r4)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
            boolean r4 = r1.isOpen()     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x002e
        L_0x002b:
            r1.close()     // Catch:{ all -> 0x003d }
        L_0x002e:
            monitor-exit(r3)
            return
        L_0x0030:
            r4 = move-exception
            if (r1 == 0) goto L_0x003c
            boolean r0 = r1.isOpen()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x003c
            r1.close()     // Catch:{ all -> 0x003d }
        L_0x003c:
            throw r4     // Catch:{ all -> 0x003d }
        L_0x003d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.y2.b(java.lang.String):void");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }
}
