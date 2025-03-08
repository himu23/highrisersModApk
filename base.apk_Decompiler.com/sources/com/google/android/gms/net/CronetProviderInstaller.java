package com.google.android.gms.net;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.Method;
import org.chromium.net.ApiVersion;

/* compiled from: com.google.android.gms:play-services-cronet@@17.0.1 */
public class CronetProviderInstaller {
    public static final String PROVIDER_NAME = "Google-Play-Services-Cronet-Provider";
    private static final String zza = "CronetProviderInstaller";
    private static final GoogleApiAvailabilityLight zzb = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzc = new Object();
    private static DynamiteModule zzd = null;
    private static String zze = "0";

    private CronetProviderInstaller() {
    }

    public static Task<Void> installProvider(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (isInstalled()) {
            taskCompletionSource.setResult(null);
            return taskCompletionSource.getTask();
        }
        new Thread(new zza(context, taskCompletionSource)).start();
        return taskCompletionSource.getTask();
    }

    public static boolean isInstalled() {
        return zza() != null;
    }

    static DynamiteModule zza() {
        DynamiteModule dynamiteModule;
        synchronized (zzc) {
            dynamiteModule = zzd;
        }
        return dynamiteModule;
    }

    static String zzb() {
        String str;
        synchronized (zzc) {
            str = zze;
        }
        return str;
    }

    @Deprecated
    public static void zzc(Context context) throws GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        synchronized (zzc) {
            if (!isInstalled()) {
                Preconditions.checkNotNull(context, "Context must not be null");
                try {
                    ((ClassLoader) Preconditions.checkNotNull(CronetProviderInstaller.class.getClassLoader())).loadClass("org.chromium.net.CronetEngine");
                    int apiLevel = ApiVersion.getApiLevel();
                    GoogleApiAvailabilityLight googleApiAvailabilityLight = zzb;
                    googleApiAvailabilityLight.verifyGooglePlayServicesIsAvailable(context, 11925000);
                    DynamiteModule load = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.cronet_dynamite");
                    Class<?> loadClass = load.getModuleContext().getClassLoader().loadClass("org.chromium.net.impl.ImplVersion");
                    if (loadClass.getClassLoader() != CronetProviderInstaller.class.getClassLoader()) {
                        Method method = loadClass.getMethod("getApiLevel", new Class[0]);
                        Method method2 = loadClass.getMethod("getCronetVersion", new Class[0]);
                        int intValue = ((Integer) Preconditions.checkNotNull((Integer) method.invoke((Object) null, new Object[0]))).intValue();
                        zze = (String) Preconditions.checkNotNull((String) method2.invoke((Object) null, new Object[0]));
                        if (apiLevel > intValue) {
                            Intent errorResolutionIntent = googleApiAvailabilityLight.getErrorResolutionIntent(context, 2, "cr");
                            if (errorResolutionIntent == null) {
                                Log.e(zza, "Unable to fetch error resolution intent");
                                throw new GooglePlayServicesNotAvailableException(2);
                            }
                            String str = zze;
                            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 174);
                            sb.append("Google Play Services update is required. The API Level of the client is ");
                            sb.append(apiLevel);
                            sb.append(". The API Level of the implementation is ");
                            sb.append(intValue);
                            sb.append(". The Cronet implementation version is ");
                            sb.append(str);
                            throw new GooglePlayServicesRepairableException(2, sb.toString(), errorResolutionIntent);
                        }
                        zzd = load;
                        return;
                    }
                    Log.e(zza, "ImplVersion class is missing from Cronet module.");
                    throw new GooglePlayServicesNotAvailableException(8);
                } catch (ClassNotFoundException e) {
                    Log.e(zza, "Cronet API is not available. Have you included all required dependencies?");
                    throw ((GooglePlayServicesNotAvailableException) new GooglePlayServicesNotAvailableException(10).initCause(e));
                } catch (DynamiteModule.LoadingException e2) {
                    Log.e(zza, "Unable to load Cronet module", e2);
                    throw ((GooglePlayServicesNotAvailableException) new GooglePlayServicesNotAvailableException(8).initCause(e2));
                } catch (Exception e3) {
                    Log.e(zza, "Unable to read Cronet version from the Cronet module ", e3);
                    throw ((GooglePlayServicesNotAvailableException) new GooglePlayServicesNotAvailableException(8).initCause(e3));
                }
            }
        }
    }
}
