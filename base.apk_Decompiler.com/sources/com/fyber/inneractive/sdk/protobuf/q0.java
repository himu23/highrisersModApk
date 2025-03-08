package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite;
import com.ironsource.m2;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

public final class q0 {
    public static void a(o0 o0Var, StringBuilder sb, int i) {
        boolean z;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (Method method : o0Var.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String str2 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 4);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb, i, a(str2), GeneratedMessageLite.invokeOrDie(method2, o0Var, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String str3 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb, i, a(str3), GeneratedMessageLite.invokeOrDie(method3, o0Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + substring)) != null) {
                if (substring.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + substring.substring(0, substring.length() - 5))) {
                    }
                }
                String str4 = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                Method method4 = (Method) hashMap.get("get" + substring);
                Method method5 = (Method) hashMap.get("has" + substring);
                if (method4 != null) {
                    Object invokeOrDie = GeneratedMessageLite.invokeOrDie(method4, o0Var, new Object[0]);
                    if (method5 == null) {
                        if (invokeOrDie instanceof Boolean) {
                            z = !((Boolean) invokeOrDie).booleanValue();
                        } else if (invokeOrDie instanceof Integer) {
                            if (((Integer) invokeOrDie).intValue() == 0) {
                            }
                        } else if (invokeOrDie instanceof Float) {
                            if (((Float) invokeOrDie).floatValue() == 0.0f) {
                            }
                        } else if (invokeOrDie instanceof Double) {
                            if (((Double) invokeOrDie).doubleValue() == 0.0d) {
                            }
                        } else if (invokeOrDie instanceof String) {
                            z = invokeOrDie.equals("");
                        } else if (invokeOrDie instanceof i) {
                            z = invokeOrDie.equals(i.b);
                        } else if (invokeOrDie instanceof o0) {
                            if (invokeOrDie == ((o0) invokeOrDie).getDefaultInstanceForType()) {
                            }
                        } else if ((invokeOrDie instanceof Enum) && ((Enum) invokeOrDie).ordinal() == 0) {
                        }
                        if (z) {
                        }
                    } else if (!((Boolean) GeneratedMessageLite.invokeOrDie(method5, o0Var, new Object[0])).booleanValue()) {
                    }
                    a(sb, i, a(str4), invokeOrDie);
                }
            }
        }
        if (o0Var instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.d, Object>> f = ((GeneratedMessageLite.ExtendableMessage) o0Var).extensions.f();
            while (f.hasNext()) {
                Map.Entry next = f.next();
                a(sb, i, m2.i.d + ((GeneratedMessageLite.d) next.getKey()).b + m2.i.e, next.getValue());
            }
        }
        l1 l1Var = ((GeneratedMessageLite) o0Var).unknownFields;
        if (l1Var != null) {
            for (int i2 = 0; i2 < l1Var.a; i2++) {
                int i3 = l1Var.b[i2];
                int i4 = r1.a;
                a(sb, i, String.valueOf(i3 >>> 3), l1Var.c[i2]);
            }
        }
    }

    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object a : (List) obj) {
                a(sb, i, str, a);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry a2 : ((Map) obj).entrySet()) {
                a(sb, i, str, a2);
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
                sb.append(i1.a(i.a((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof i) {
                sb.append(": \"");
                sb.append(i1.a((i) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                a((GeneratedMessageLite) obj, sb, i + 2);
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
                a(sb, i4, m2.h.W, entry.getKey());
                a(sb, i4, m2.h.X, entry.getValue());
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

    public static final String a(String str) {
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
