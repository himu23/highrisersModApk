package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import com.ironsource.m2;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

final class zzlt {
    static String zza(zzlq zzlq, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzlq, sb, 0);
        return sb.toString();
    }

    private static void zza(zzlq zzlq, StringBuilder sb, int i) {
        boolean z;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzlq.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals("List")) {
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zza(sb, i, zzo(concat), zzkk.zza(method2, (Object) zzlq, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                String valueOf3 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zza(sb, i, zzo(concat2), zzkk.zza(method3, (Object) zzlq, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(replaceFirst.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(replaceFirst);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(replaceFirst);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? "has".concat(valueOf10) : new String("has"));
                if (method4 != null) {
                    Object zza = zzkk.zza(method4, (Object) zzlq, new Object[0]);
                    if (method5 == null) {
                        if (zza instanceof Boolean) {
                            if (!((Boolean) zza).booleanValue()) {
                            }
                        } else if (zza instanceof Integer) {
                            if (((Integer) zza).intValue() == 0) {
                            }
                        } else if (zza instanceof Float) {
                            if (((Float) zza).floatValue() == 0.0f) {
                            }
                        } else if (!(zza instanceof Double)) {
                            if (zza instanceof String) {
                                z = zza.equals("");
                            } else if (zza instanceof zzjc) {
                                z = zza.equals(zzjc.zznq);
                            } else if (zza instanceof zzlq) {
                                if (zza == ((zzlq) zza).zzda()) {
                                }
                            } else if ((zza instanceof Enum) && ((Enum) zza).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (((Double) zza).doubleValue() == 0.0d) {
                        }
                    } else if (!((Boolean) zzkk.zza(method5, (Object) zzlq, new Object[0])).booleanValue()) {
                    }
                    zza(sb, i, zzo(concat3), zza);
                }
            }
        }
        if (zzlq instanceof zzkk.zzc) {
            Iterator<Map.Entry<Object, Object>> it = ((zzkk.zzc) zzlq).zzrw.iterator();
            if (it.hasNext()) {
                it.next().getKey();
                throw new NoSuchMethodError();
            }
        }
        zzkk zzkk = (zzkk) zzlq;
        if (zzkk.zzrq != null) {
            zzkk.zzrq.zza(sb, i);
        }
    }

    static final void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zza : (List) obj) {
                zza(sb, i, str, zza);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zza2 : ((Map) obj).entrySet()) {
                zza(sb, i, str, zza2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzmt.zzc(zzjc.zzk((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzjc) {
                sb.append(": \"");
                sb.append(zzmt.zzc((zzjc) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzkk) {
                sb.append(" {");
                zza((zzkk) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zza(sb, i4, m2.h.W, entry.getKey());
                zza(sb, i4, m2.h.X, entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static final String zzo(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
