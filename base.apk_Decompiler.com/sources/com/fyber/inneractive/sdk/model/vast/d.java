package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class d {
    public final String a;
    public final String b;
    public int c = a();
    public final int d;

    public static class a implements Comparator<d> {
        public int compare(Object obj, Object obj2) {
            return ((d) obj).c - ((d) obj2).c;
        }
    }

    public d(String str, String str2) {
        this.a = str;
        this.b = str2;
        this.d = b(str2);
    }

    public int b(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("-")) {
            if (str.endsWith("%") && str.endsWith("%")) {
                try {
                    int b2 = b();
                    if (b2 >= 0 && b2 <= 100) {
                        return 1;
                    }
                } catch (NumberFormatException e) {
                    IAlog.e("ProgressTrackingEvent: failed isPercentageOffsetValid with %s", e.getMessage());
                }
            }
            if (str.contains(":")) {
                ArrayList arrayList = (ArrayList) a(str);
                if (arrayList.isEmpty() || ((Integer) arrayList.get(0)).intValue() < 0 || ((Integer) arrayList.get(1)).intValue() < 0 || ((Integer) arrayList.get(2)).intValue() < 0 || ((Integer) arrayList.get(3)).intValue() < 0) {
                    return 0;
                }
                return 2;
            }
        }
        return 0;
    }

    public final int a() {
        String str;
        if (this.d != 2 || (str = this.b) == null) {
            return -1;
        }
        ArrayList arrayList = (ArrayList) a(str);
        return (((((Integer) arrayList.get(0)).intValue() * 3600) + (((Integer) arrayList.get(1)).intValue() * 60) + ((Integer) arrayList.get(2)).intValue()) * 1000) + ((Integer) arrayList.get(3)).intValue();
    }

    public List<Integer> a(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        String[] split = str.split(":");
        if (split.length != 3) {
            return arrayList;
        }
        String str2 = split[0];
        String str3 = split[1];
        String[] split2 = split[2].split("\\.");
        String str4 = split2[0];
        String str5 = split2.length > 1 ? split2[1] : "000";
        try {
            arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str3)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str4)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str5)));
            return arrayList;
        } catch (NumberFormatException e) {
            IAlog.e("ProgressTrackingEvent: failed convertOffsetToTimeList with %s", e.getMessage());
            return new ArrayList();
        }
    }

    public int b() {
        if (TextUtils.isEmpty(this.b)) {
            return -1;
        }
        String str = this.b;
        return Integer.parseInt(str.substring(0, str.length() - 1));
    }
}
