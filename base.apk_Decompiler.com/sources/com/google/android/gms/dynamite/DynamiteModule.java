package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = new zzl();
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;

    /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzp) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v48 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x025f A[Catch:{ all -> 0x02df }] */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(android.content.Context r20, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r21, java.lang.String r22) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.String r0 = "Selected remote version of "
            java.lang.String r4 = "Selected remote version of "
            java.lang.String r5 = "VersionPolicy returned invalid code:"
            java.lang.String r6 = "No acceptable module "
            java.lang.String r7 = "Considering local module "
            android.content.Context r8 = r20.getApplicationContext()
            r9 = 0
            if (r8 == 0) goto L_0x0300
            java.lang.ThreadLocal r10 = zzg
            java.lang.Object r11 = r10.get()
            com.google.android.gms.dynamite.zzn r11 = (com.google.android.gms.dynamite.zzn) r11
            com.google.android.gms.dynamite.zzn r12 = new com.google.android.gms.dynamite.zzn
            r12.<init>(r9)
            r10.set(r12)
            java.lang.ThreadLocal r13 = zzh
            java.lang.Object r14 = r13.get()
            java.lang.Long r14 = (java.lang.Long) r14
            long r14 = r14.longValue()
            r16 = 0
            long r18 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x02df }
            java.lang.Long r9 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x02df }
            r13.set(r9)     // Catch:{ all -> 0x02df }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions r9 = zzi     // Catch:{ all -> 0x02df }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r9 = r2.selectModule(r1, r3, r9)     // Catch:{ all -> 0x02df }
            r18 = r6
            java.lang.String r6 = "DynamiteModule"
            r19 = r5
            int r5 = r9.localVersion     // Catch:{ all -> 0x02df }
            int r2 = r9.remoteVersion     // Catch:{ all -> 0x02df }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x02df }
            r1.<init>(r7)     // Catch:{ all -> 0x02df }
            r1.append(r3)     // Catch:{ all -> 0x02df }
            java.lang.String r7 = ":"
            r1.append(r7)     // Catch:{ all -> 0x02df }
            r1.append(r5)     // Catch:{ all -> 0x02df }
            java.lang.String r5 = " and remote module "
            r1.append(r5)     // Catch:{ all -> 0x02df }
            r1.append(r3)     // Catch:{ all -> 0x02df }
            java.lang.String r5 = ":"
            r1.append(r5)     // Catch:{ all -> 0x02df }
            r1.append(r2)     // Catch:{ all -> 0x02df }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x02df }
            android.util.Log.i(r6, r1)     // Catch:{ all -> 0x02df }
            int r1 = r9.selection     // Catch:{ all -> 0x02df }
            if (r1 == 0) goto L_0x02b1
            r2 = -1
            if (r1 != r2) goto L_0x0083
            int r1 = r9.localVersion     // Catch:{ all -> 0x02df }
            if (r1 == 0) goto L_0x02b1
            r1 = -1
        L_0x0083:
            r5 = 1
            if (r1 != r5) goto L_0x008a
            int r6 = r9.remoteVersion     // Catch:{ all -> 0x02df }
            if (r6 == 0) goto L_0x02b1
        L_0x008a:
            if (r1 != r2) goto L_0x00aa
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r8, r3)     // Catch:{ all -> 0x02df }
            int r1 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x0098
            r13.remove()
            goto L_0x009f
        L_0x0098:
            java.lang.Long r1 = java.lang.Long.valueOf(r14)
            r13.set(r1)
        L_0x009f:
            android.database.Cursor r1 = r12.zza
            if (r1 == 0) goto L_0x00a6
            r1.close()
        L_0x00a6:
            r10.set(r11)
            return r0
        L_0x00aa:
            if (r1 != r5) goto L_0x029c
            r1 = 0
            int r6 = r9.remoteVersion     // Catch:{ LoadingException -> 0x023e }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r7 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r7)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            boolean r18 = zzf(r20)     // Catch:{ all -> 0x021a }
            if (r18 == 0) goto L_0x0211
            java.lang.Boolean r18 = zzb     // Catch:{ all -> 0x021a }
            monitor-exit(r7)     // Catch:{ all -> 0x021a }
            if (r18 == 0) goto L_0x0208
            boolean r7 = r18.booleanValue()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r5 = 2
            if (r7 == 0) goto L_0x0168
            java.lang.String r4 = "DynamiteModule"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r7.<init>(r0)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r7.append(r3)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r0 = ", version >= "
            r7.append(r0)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r7.append(r6)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r0 = r7.toString()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            android.util.Log.i(r4, r0)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r4 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamite.zzr r0 = zzl     // Catch:{ all -> 0x0165 }
            monitor-exit(r4)     // Catch:{ all -> 0x0165 }
            if (r0 == 0) goto L_0x015c
            java.lang.Object r4 = r10.get()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamite.zzn r4 = (com.google.android.gms.dynamite.zzn) r4     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            if (r4 == 0) goto L_0x0153
            android.database.Cursor r7 = r4.zza     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            if (r7 == 0) goto L_0x0153
            android.content.Context r7 = r20.getApplicationContext()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            android.database.Cursor r4 = r4.zza     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r18 = 0
            com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r18 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r18)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            int r2 = zze     // Catch:{ all -> 0x0150 }
            if (r2 < r5) goto L_0x0105
            r5 = 1
            goto L_0x0106
        L_0x0105:
            r5 = 0
        L_0x0106:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0150 }
            monitor-exit(r18)     // Catch:{ all -> 0x0150 }
            boolean r2 = r2.booleanValue()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            if (r2 == 0) goto L_0x0125
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r5 = "Dynamite loader version >= 2, using loadModule2NoCrashUtils"
            android.util.Log.v(r2, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r7)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzf(r2, r3, r6, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            goto L_0x0138
        L_0x0125:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r5 = "Dynamite loader version < 2, falling back to loadModule2"
            android.util.Log.w(r2, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r7)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zze(r2, r3, r6, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x0138:
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            if (r0 == 0) goto L_0x0147
            com.google.android.gms.dynamite.DynamiteModule r2 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r2.<init>(r0)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            goto L_0x01dc
        L_0x0147:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r2 = "Failed to get module context"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x0150:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x0150 }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x0153:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r2 = "No result cursor"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x015c:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r2 = "DynamiteLoaderV2 was not cached."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x0165:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0165 }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x0168:
            java.lang.String r0 = "DynamiteModule"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r2.<init>(r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r2.append(r3)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r4 = ", version >= "
            r2.append(r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r2.append(r6)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r2 = r2.toString()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            android.util.Log.i(r0, r2)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamite.zzq r0 = zzg(r20)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            if (r0 == 0) goto L_0x01ff
            int r2 = r0.zze()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r4 = 3
            if (r2 < r4) goto L_0x01ae
            java.lang.Object r2 = r10.get()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamite.zzn r2 = (com.google.android.gms.dynamite.zzn) r2     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            if (r2 == 0) goto L_0x01a5
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            android.database.Cursor r2 = r2.zza     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r2)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzi(r4, r3, r6, r2)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            goto L_0x01cf
        L_0x01a5:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r2 = "No cached result cursor holder"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x01ae:
            if (r2 != r5) goto L_0x01c0
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r4 = "IDynamite loader version = 2"
            android.util.Log.w(r2, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzj(r2, r3, r6)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            goto L_0x01cf
        L_0x01c0:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r4 = "Dynamite loader version < 2, falling back to createModuleContext"
            android.util.Log.w(r2, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzh(r2, r3, r6)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x01cf:
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            if (r0 == 0) goto L_0x01f6
            com.google.android.gms.dynamite.DynamiteModule r2 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            r2.<init>(r0)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x01dc:
            int r0 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x01e4
            r13.remove()
            goto L_0x01eb
        L_0x01e4:
            java.lang.Long r0 = java.lang.Long.valueOf(r14)
            r13.set(r0)
        L_0x01eb:
            android.database.Cursor r0 = r12.zza
            if (r0 == 0) goto L_0x01f2
            r0.close()
        L_0x01f2:
            r10.set(r11)
            return r2
        L_0x01f6:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r2 = "Failed to load remote module."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x01ff:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r2 = "Failed to create IDynamiteLoader."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x0208:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            java.lang.String r2 = "Failed to determine which loading route to use."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x0211:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x021a }
            java.lang.String r2 = "Remote loading disabled"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ all -> 0x021a }
            throw r0     // Catch:{ all -> 0x021a }
        L_0x021a:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x021a }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022c, all -> 0x021d }
        L_0x021d:
            r0 = move-exception
            r2 = r20
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r2, r0)     // Catch:{ LoadingException -> 0x023c }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x023c }
            java.lang.String r5 = "Failed to load remote module."
            r6 = 0
            r4.<init>(r5, r0, r6)     // Catch:{ LoadingException -> 0x023c }
            throw r4     // Catch:{ LoadingException -> 0x023c }
        L_0x022c:
            r0 = move-exception
            r2 = r20
            throw r0     // Catch:{ LoadingException -> 0x023c }
        L_0x0230:
            r0 = move-exception
            r2 = r20
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x023c }
            java.lang.String r5 = "Failed to load remote module."
            r6 = 0
            r4.<init>(r5, r0, r6)     // Catch:{ LoadingException -> 0x023c }
            throw r4     // Catch:{ LoadingException -> 0x023c }
        L_0x023c:
            r0 = move-exception
            goto L_0x0241
        L_0x023e:
            r0 = move-exception
            r2 = r20
        L_0x0241:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r5 = r0.getMessage()     // Catch:{ all -> 0x02df }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x02df }
            r6.<init>()     // Catch:{ all -> 0x02df }
            java.lang.String r7 = "Failed to load remote module: "
            r6.append(r7)     // Catch:{ all -> 0x02df }
            r6.append(r5)     // Catch:{ all -> 0x02df }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x02df }
            android.util.Log.w(r4, r5)     // Catch:{ all -> 0x02df }
            int r4 = r9.localVersion     // Catch:{ all -> 0x02df }
            if (r4 == 0) goto L_0x0293
            com.google.android.gms.dynamite.zzo r5 = new com.google.android.gms.dynamite.zzo     // Catch:{ all -> 0x02df }
            r5.<init>(r4, r1)     // Catch:{ all -> 0x02df }
            r1 = r21
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r1 = r1.selectModule(r2, r3, r5)     // Catch:{ all -> 0x02df }
            int r1 = r1.selection     // Catch:{ all -> 0x02df }
            r2 = -1
            if (r1 != r2) goto L_0x0293
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r8, r3)     // Catch:{ all -> 0x02df }
            int r1 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x027d
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x0286
        L_0x027d:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r14)
            r1.set(r2)
        L_0x0286:
            android.database.Cursor r1 = r12.zza
            if (r1 == 0) goto L_0x028d
            r1.close()
        L_0x028d:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r11)
            return r0
        L_0x0293:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x02df }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r3 = 0
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x02df }
            throw r1     // Catch:{ all -> 0x02df }
        L_0x029c:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x02df }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02df }
            r3 = r19
            r2.<init>(r3)     // Catch:{ all -> 0x02df }
            r2.append(r1)     // Catch:{ all -> 0x02df }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x02df }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x02df }
            throw r0     // Catch:{ all -> 0x02df }
        L_0x02b1:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x02df }
            int r1 = r9.localVersion     // Catch:{ all -> 0x02df }
            int r2 = r9.remoteVersion     // Catch:{ all -> 0x02df }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02df }
            r5 = r18
            r4.<init>(r5)     // Catch:{ all -> 0x02df }
            r4.append(r3)     // Catch:{ all -> 0x02df }
            java.lang.String r3 = " found. Local version is "
            r4.append(r3)     // Catch:{ all -> 0x02df }
            r4.append(r1)     // Catch:{ all -> 0x02df }
            java.lang.String r1 = " and remote version is "
            r4.append(r1)     // Catch:{ all -> 0x02df }
            r4.append(r2)     // Catch:{ all -> 0x02df }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ all -> 0x02df }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x02df }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x02df }
            throw r0     // Catch:{ all -> 0x02df }
        L_0x02df:
            r0 = move-exception
            int r1 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x02ea
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x02f3
        L_0x02ea:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r14)
            r1.set(r2)
        L_0x02f3:
            android.database.Cursor r1 = r12.zza
            if (r1 == 0) goto L_0x02fa
            r1.close()
        L_0x02fa:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r11)
            throw r0
        L_0x0300:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException
            java.lang.String r1 = "null application Context"
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:17:0x003b=Splitter:B:17:0x003b, B:50:0x009e=Splitter:B:50:0x009e} */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01c6 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01c3 }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00dc
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00b6 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b6 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b6 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b6 }
            goto L_0x00b4
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            zzd(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b6 }
            goto L_0x00b4
        L_0x003f:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x00b6 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            return r3
        L_0x0048:
            boolean r5 = zzd     // Catch:{ all -> 0x00b6 }
            if (r5 != 0) goto L_0x00ab
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b6 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x00b6 }
            if (r5 == 0) goto L_0x0055
            goto L_0x00ab
        L_0x0055:
            r5 = 1
            int r5 = zzb(r10, r11, r12, r5)     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x00a1 }
            if (r6 == 0) goto L_0x009e
            boolean r6 = r6.isEmpty()     // Catch:{ LoadingException -> 0x00a1 }
            if (r6 == 0) goto L_0x0065
            goto L_0x009e
        L_0x0065:
            java.lang.ClassLoader r6 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x00a1 }
            if (r6 == 0) goto L_0x006c
            goto L_0x0091
        L_0x006c:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x00a1 }
            r7 = 29
            if (r6 < r7) goto L_0x0083
            com.ironsource.g$$ExternalSyntheticApiModelOutline0.m$2()     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x00a1 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00a1 }
            dalvik.system.DelegateLastClassLoader r6 = com.ironsource.g$$ExternalSyntheticApiModelOutline0.m((java.lang.String) r6, (java.lang.ClassLoader) r7)     // Catch:{ LoadingException -> 0x00a1 }
            goto L_0x0091
        L_0x0083:
            com.google.android.gms.dynamite.zzc r6 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x00a1 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00a1 }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x00a1 }
        L_0x0091:
            zzd(r6)     // Catch:{ LoadingException -> 0x00a1 }
            r1.set(r2, r6)     // Catch:{ LoadingException -> 0x00a1 }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x00a1 }
            zzb = r6     // Catch:{ LoadingException -> 0x00a1 }
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            return r5
        L_0x009e:
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            return r5
        L_0x00a1:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b6 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b6 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b6 }
            goto L_0x00b4
        L_0x00ab:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b6 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b6 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b6 }
        L_0x00b4:
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            goto L_0x00da
        L_0x00b6:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00bd, IllegalAccessException -> 0x00bb, NoSuchFieldException -> 0x00b9 }
        L_0x00b9:
            r1 = move-exception
            goto L_0x00be
        L_0x00bb:
            r1 = move-exception
            goto L_0x00be
        L_0x00bd:
            r1 = move-exception
        L_0x00be:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01c3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c3 }
            r5.<init>()     // Catch:{ all -> 0x01c3 }
            java.lang.String r6 = "Failed to load module via V2: "
            r5.append(r6)     // Catch:{ all -> 0x01c3 }
            r5.append(r1)     // Catch:{ all -> 0x01c3 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01c3 }
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x01c3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01c3 }
        L_0x00da:
            zzb = r1     // Catch:{ all -> 0x01c3 }
        L_0x00dc:
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01c6 }
            if (r0 == 0) goto L_0x0104
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00e8 }
            return r10
        L_0x00e8:
            r11 = move-exception
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01c6 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c6 }
            r0.<init>()     // Catch:{ all -> 0x01c6 }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01c6 }
            r0.append(r11)     // Catch:{ all -> 0x01c6 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x01c6 }
            android.util.Log.w(r12, r11)     // Catch:{ all -> 0x01c6 }
            return r3
        L_0x0104:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x01c6 }
            if (r4 != 0) goto L_0x010c
            goto L_0x01ba
        L_0x010c:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x0199 }
            r1 = 3
            if (r0 < r1) goto L_0x0174
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x0199 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0199 }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x0199 }
            if (r0 == 0) goto L_0x0127
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x0199 }
            if (r0 == 0) goto L_0x0127
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x0199 }
            goto L_0x01ba
        L_0x0127:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0199 }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x0199 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0199 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0199 }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x0199 }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x0199 }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x0199 }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x0199 }
            if (r11 == 0) goto L_0x0161
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x0171, all -> 0x016e }
            if (r12 != 0) goto L_0x014c
            goto L_0x0161
        L_0x014c:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x0171, all -> 0x016e }
            if (r12 <= 0) goto L_0x0159
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x0171, all -> 0x016e }
            if (r0 == 0) goto L_0x0159
            goto L_0x015a
        L_0x0159:
            r2 = r11
        L_0x015a:
            if (r2 == 0) goto L_0x015f
            r2.close()     // Catch:{ all -> 0x01c6 }
        L_0x015f:
            r3 = r12
            goto L_0x01ba
        L_0x0161:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r0)     // Catch:{ RemoteException -> 0x0171, all -> 0x016e }
            if (r11 == 0) goto L_0x01ba
            r11.close()     // Catch:{ all -> 0x01c6 }
            goto L_0x01ba
        L_0x016e:
            r12 = move-exception
            r2 = r11
            goto L_0x01bd
        L_0x0171:
            r12 = move-exception
            r2 = r11
            goto L_0x019b
        L_0x0174:
            r1 = 2
            if (r0 != r1) goto L_0x0187
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0199 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0199 }
            int r3 = r4.zzg(r0, r11, r12)     // Catch:{ RemoteException -> 0x0199 }
            goto L_0x01ba
        L_0x0187:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0199 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0199 }
            int r3 = r4.zzf(r0, r11, r12)     // Catch:{ RemoteException -> 0x0199 }
            goto L_0x01ba
        L_0x0197:
            r12 = r11
            goto L_0x01bd
        L_0x0199:
            r11 = move-exception
            r12 = r11
        L_0x019b:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01bb }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bb }
            r0.<init>()     // Catch:{ all -> 0x01bb }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01bb }
            r0.append(r12)     // Catch:{ all -> 0x01bb }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x01bb }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01bb }
            if (r2 == 0) goto L_0x01ba
            r2.close()     // Catch:{ all -> 0x01c6 }
        L_0x01ba:
            return r3
        L_0x01bb:
            r11 = move-exception
            goto L_0x0197
        L_0x01bd:
            if (r2 == 0) goto L_0x01c2
            r2.close()     // Catch:{ all -> 0x01c6 }
        L_0x01c2:
            throw r12     // Catch:{ all -> 0x01c6 }
        L_0x01c3:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01c3 }
            throw r11     // Catch:{ all -> 0x01c6 }
        L_0x01c6:
            r11 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bd A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = zzh     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r12.<init>()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            if (r10 == 0) goto L_0x00a3
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009b }
            if (r11 == 0) goto L_0x00a3
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009b }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009b }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            zzc = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            zze = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = 0
        L_0x007f:
            zzd = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x008e:
            if (r13 == 0) goto L_0x009d
            if (r11 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r11 = move-exception
            goto L_0x00b8
        L_0x009d:
            if (r10 == 0) goto L_0x00a2
            r10.close()
        L_0x00a2:
            return r12
        L_0x00a3:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r12)     // Catch:{ Exception -> 0x009b }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x00b2:
            r10 = move-exception
            r11 = r10
            goto L_0x00da
        L_0x00b5:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00b8:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00d8 }
            if (r12 == 0) goto L_0x00bd
            throw r11     // Catch:{ all -> 0x00d8 }
        L_0x00bd:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00d8 }
            java.lang.String r13 = r11.getMessage()     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r1.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "V2 version check failed: "
            r1.append(r2)     // Catch:{ all -> 0x00d8 }
            r1.append(r13)     // Catch:{ all -> 0x00d8 }
            java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x00d8 }
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x00d8 }
            throw r12     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            r11 = move-exception
            r0 = r10
        L_0x00da:
            if (r0 == 0) goto L_0x00df
            r0.close()
        L_0x00df:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals((Object) null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
        }
        return null;
    }

    @ResultIgnorabilityUnspecified
    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, (zzp) null);
        }
    }
}
