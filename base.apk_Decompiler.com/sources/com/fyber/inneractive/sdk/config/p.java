package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class p implements Runnable {
    public final /* synthetic */ IAConfigManager a;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            IAConfigManager iAConfigManager = p.this.a;
            iAConfigManager.s.b(iAConfigManager.B);
        }
    }

    public p(IAConfigManager iAConfigManager) {
        this.a = iAConfigManager;
    }

    public void run() {
        List<InputMethodInfo> list;
        IAConfigManager iAConfigManager = this.a;
        if (iAConfigManager.q == null) {
            Context context = iAConfigManager.f;
            HashSet hashSet = new HashSet();
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            try {
                list = inputMethodManager.getEnabledInputMethodList();
            } catch (Throwable unused) {
                list = null;
            }
            if (list != null) {
                int i = 0;
                for (InputMethodInfo enabledInputMethodSubtypeList : list) {
                    for (InputMethodSubtype next : inputMethodManager.getEnabledInputMethodSubtypeList(enabledInputMethodSubtypeList, true)) {
                        if (next.getMode().equals("keyboard") && i < 10) {
                            String locale = next.getLocale();
                            if (!TextUtils.isEmpty(locale)) {
                                try {
                                    String replace = locale.replace("_", "-");
                                    hashSet.add(replace);
                                    IAlog.a("Available input language: %s", replace);
                                    i++;
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    }
                }
            }
            if (hashSet.isEmpty()) {
                if (Build.VERSION.SDK_INT >= 24) {
                    hashSet.addAll(Arrays.asList(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(g$$ExternalSyntheticApiModelOutline0.m()).split(",")));
                } else {
                    Locale locale2 = Locale.getDefault();
                    if (locale2 != null) {
                        hashSet.add(locale2.toString().replace("_", "-"));
                    }
                }
            }
            iAConfigManager.q = new ArrayList(hashSet);
        }
        q.b.post(new a());
    }
}
