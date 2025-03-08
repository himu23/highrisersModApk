package com.applovin.impl.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import java.util.Objects;
import java.util.Set;

public final class e {
    private static n aRU;
    private static SharedPreferences aRV;
    private final SharedPreferences ayw;

    public e(n nVar) {
        this.ayw = n.getApplicationContext().getSharedPreferences("com.applovin.sdk.preferences." + nVar.getSdkKey(), 0);
        if (!nVar.Bq()) {
            aRU = nVar;
        }
    }

    public <T> void a(d<T> dVar, T t) {
        a(dVar, t, this.ayw);
    }

    public <T> void a(String str, T t, SharedPreferences.Editor editor) {
        a(str, t, (SharedPreferences) null, editor);
    }

    public <T> void a(d<T> dVar, T t, SharedPreferences sharedPreferences) {
        a(dVar.getName(), t, sharedPreferences);
    }

    public <T> void a(String str, T t, SharedPreferences sharedPreferences) {
        a(str, t, sharedPreferences, (SharedPreferences.Editor) null);
    }

    public static <T> void a(d<T> dVar, T t, Context context) {
        a(dVar.getName(), t, S(context), (SharedPreferences.Editor) null);
    }

    public static <T> void a(String str, T t, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        boolean z = editor != null;
        if (!z) {
            editor = sharedPreferences.edit();
        }
        if (t == null) {
            editor.remove(str);
        } else if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        } else if (t instanceof Double) {
            editor.putLong(str, Double.doubleToRawLongBits(((Double) t).doubleValue()));
        } else if (t instanceof String) {
            editor.putString(str, (String) t);
        } else if (t instanceof Set) {
            editor.putStringSet(str, (Set) t);
        } else {
            x.H("SharedPreferencesManager", "Unable to put default value of invalid type: " + t);
            return;
        }
        if (!z) {
            a(editor);
        }
    }

    public <T> T b(d<T> dVar, T t) {
        return b(dVar, t, this.ayw);
    }

    public <T> T b(d<T> dVar, T t, SharedPreferences sharedPreferences) {
        return a(dVar.getName(), t, (Class) dVar.JJ(), sharedPreferences);
    }

    public static <T> T b(d<T> dVar, T t, Context context) {
        return a(dVar.getName(), t, (Class) dVar.JJ(), S(context));
    }

    public static <T> T a(d<T> dVar, T t, SharedPreferences sharedPreferences, boolean z) {
        return a(dVar.getName(), t, dVar.JJ(), sharedPreferences, z);
    }

    public static <T> T a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        return a(str, t, cls, sharedPreferences, true);
    }

    public static <T> T a(String str, T t, Class cls, SharedPreferences sharedPreferences, boolean z) {
        T t2;
        long j;
        int i;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (sharedPreferences.contains(str)) {
                if (Boolean.class.equals(cls)) {
                    t2 = t != null ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue())) : Boolean.valueOf(sharedPreferences.getBoolean(str, false));
                } else if (Float.class.equals(cls)) {
                    t2 = t != null ? Float.valueOf(sharedPreferences.getFloat(str, ((Float) t).floatValue())) : Float.valueOf(sharedPreferences.getFloat(str, 0.0f));
                } else if (Integer.class.equals(cls)) {
                    if (t != null) {
                        if (t.getClass().equals(Long.class)) {
                            i = ((Long) t).intValue();
                        } else {
                            i = ((Integer) t).intValue();
                        }
                        t2 = Integer.valueOf(sharedPreferences.getInt(str, i));
                    } else {
                        t2 = Integer.valueOf(sharedPreferences.getInt(str, 0));
                    }
                } else if (Long.class.equals(cls)) {
                    if (t != null) {
                        if (t.getClass().equals(Integer.class)) {
                            j = ((Integer) t).longValue();
                        } else {
                            j = ((Long) t).longValue();
                        }
                        t2 = Long.valueOf(sharedPreferences.getLong(str, j));
                    } else {
                        t2 = Long.valueOf(sharedPreferences.getLong(str, 0));
                    }
                } else if (Double.class.equals(cls)) {
                    t2 = t != null ? Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, Double.doubleToRawLongBits(((Double) t).doubleValue())))) : Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, 0)));
                } else if (String.class.equals(cls)) {
                    t2 = sharedPreferences.getString(str, (String) t);
                } else {
                    t2 = Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) t) : t;
                }
                if (t2 != null) {
                    return cls.cast(t2);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return t;
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return t;
        } catch (Throwable th) {
            if (z) {
                x.e("SharedPreferencesManager", "Error getting value for key: " + str, th);
            }
            return t;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public <T> void b(d<T> dVar) {
        a(this.ayw.edit().remove(dVar.getName()));
    }

    public void a(SharedPreferences sharedPreferences) {
        a(sharedPreferences.edit().clear());
    }

    private static void a(SharedPreferences.Editor editor) {
        try {
            if (u.Lx()) {
                n nVar = aRU;
                if (nVar == null || nVar.BO() == null) {
                    editor.apply();
                    return;
                }
                q BO = aRU.BO();
                n nVar2 = aRU;
                Objects.requireNonNull(editor);
                BO.a((d) new ab(nVar2, "commitSharedPreferencesChanges", new e$$ExternalSyntheticLambda0(editor)), q.b.BACKGROUND);
                return;
            }
            editor.commit();
        } catch (Throwable th) {
            x.e("SharedPreferencesManager", "Unable to apply changes", th);
        }
    }

    private static SharedPreferences S(Context context) {
        if (aRV == null) {
            aRV = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return aRV;
    }
}
