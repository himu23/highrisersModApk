package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CollectionUtils {
    public static <T> boolean addObjectIfExists(T t, List<T> list) {
        if (t != null) {
            return list.add(t);
        }
        return false;
    }

    public static <K, V> Map<K, V> map(Map<K, V> map) {
        if (map == null) {
            return new HashMap();
        }
        return new HashMap(map);
    }

    public static List<String> explode(String str) {
        return explode(str, ",\\s*");
    }

    public static List<String> explode(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        return Arrays.asList(str.split(str2));
    }

    public static String implode(Collection<String> collection, int i) {
        return implode(collection, ",", i);
    }

    public static String implode(Collection<String> collection, String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("No glue specified");
        } else if (collection == null || collection.size() < 1) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String next : collection) {
                if (i2 >= i) {
                    break;
                }
                i2++;
                sb.append(next);
                sb.append(str);
            }
            if (sb.length() > str.length()) {
                sb.setLength(sb.length() - str.length());
            }
            return sb.toString();
        }
    }

    public static List<String> removeTrimmedEmptyStrings(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String trim : list) {
            String trim2 = trim.trim();
            if (!TextUtils.isEmpty(trim2)) {
                arrayList.add(trim2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> synchronizedList() {
        return synchronizedList(-1);
    }

    public static <T> List<T> synchronizedList(int i) {
        if (i >= 0) {
            return Collections.synchronizedList(new ArrayList(i));
        }
        return Collections.synchronizedList(new ArrayList());
    }

    public static <K, V> Map<K, V> map(K k, V v) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(k, v);
        return hashMap;
    }

    public static Bundle toBundle(Map<String, ?> map) {
        if (map == null || map.size() == 0) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof Map) {
                bundle.putBundle(next, toBundle((Map) obj));
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                bundle.putString(next, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(next, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(next, (Parcelable) obj);
            }
        }
        return bundle;
    }

    public static String toJsonString(Map<String, Object> map, String str) {
        try {
            return toJson(map).toString();
        } catch (JSONException e) {
            x.e("CollectionUtils", "Failed to convert map '" + map + "' to JSON string.", e);
            return str;
        }
    }

    public static JSONObject toJson(Map<String, ?> map) throws JSONException {
        if (map == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            jSONObject.put((String) next.getKey(), next.getValue());
        }
        return jSONObject;
    }

    public static <T> JSONArray toJSONArray(List<T> list) throws JSONException {
        if (list == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i));
        }
        return jSONArray;
    }

    public static void putObjectToStringIfValid(String str, Object obj, Map map) {
        if (obj != null) {
            putStringIfValid(str, obj.toString(), map);
        }
    }

    public static void putStringIfValid(String str, String str2, Map map) {
        if (StringUtils.isValidString(str) && StringUtils.isValidString(str2)) {
            map.put(str, str2);
        }
    }

    public static void putBooleanIfValid(String str, Boolean bool, Map map) {
        if (StringUtils.isValidString(str) && bool != null) {
            map.put(str, bool);
        }
    }

    public static void putIntegerIfValid(String str, Integer num, Map map) {
        if (StringUtils.isValidString(str) && num != null) {
            map.put(str, num);
        }
    }

    public static void putDoubleIfValid(String str, Double d, Map map) {
        if (StringUtils.isValidString(str) && d != null) {
            map.put(str, d);
        }
    }

    public static void putLongIfValid(String str, Long l, Map map) {
        if (StringUtils.isValidString(str) && l != null) {
            map.put(str, l);
        }
    }

    public static void putFloatIfValid(String str, Float f, Map map) {
        if (StringUtils.isValidString(str) && f != null) {
            map.put(str, f);
        }
    }

    public static void putJsonArrayIfValid(String str, JSONArray jSONArray, Map map) {
        if (StringUtils.isValidString(str) && jSONArray != null && jSONArray.length() > 0) {
            map.put(str, jSONArray);
        }
    }

    public static void putStringArrayIfValid(String str, String[] strArr, Map map) {
        if (StringUtils.isValidString(str) && strArr != null && strArr.length > 0) {
            map.put(str, strArr);
        }
    }

    public static boolean getBoolean(Map<String, Object> map, String str) {
        return getBoolean(map, str, false);
    }

    public static boolean getBoolean(Map<String, Object> map, String str, boolean z) {
        if (map != null && map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                return Boolean.parseBoolean((String) obj);
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof Number) {
                return ((Number) obj).intValue() >= 1;
            }
        }
        return z;
    }
}
