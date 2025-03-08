package com.fyber.inneractive.sdk.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.global.features.p;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.flow.p;
import com.fyber.inneractive.sdk.ignite.j;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.r;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class InternalStoreWebpageActivity extends InneractiveBaseActivity {
    public static final String EXTRA_KEY_SPOT_ID = "spotId";
    public ViewGroup b;
    public r c;
    public p.a d = p.a.FullScreen;

    public static void startActivity(Context context, String str) {
        Intent intent = new Intent(context, InternalStoreWebpageActivity.class);
        intent.putExtra("spotId", str);
        if (!(context instanceof Activity)) {
            intent.setFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }

    public final InneractiveAdSpot a() {
        String stringExtra = getIntent().getStringExtra("spotId");
        if (!TextUtils.isEmpty(stringExtra)) {
            return InneractiveAdSpotManager.get().getSpot(stringExtra);
        }
        IAlog.e("%sSpot id is empty", IAlog.a((Object) this));
        return null;
    }

    public void finish() {
        super.finish();
        r rVar = this.c;
        if (rVar != null) {
            rVar.C = false;
            r.g gVar = rVar.i;
            if (gVar != null) {
                IAlog.a("onInternalStoreWebpageDismissed callback called", new Object[0]);
                ((com.fyber.inneractive.sdk.flow.r) gVar).F();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.width != com.fyber.inneractive.sdk.util.p.f() && this.d == p.a.Modal) {
            attributes.gravity = 83;
            attributes.height = (int) (((float) com.fyber.inneractive.sdk.util.p.e()) * 0.8f);
            attributes.width = com.fyber.inneractive.sdk.util.p.f();
            getWindow().setAttributes(attributes);
        }
    }

    public void onCreate(Bundle bundle) {
        p.a aVar;
        InneractiveAdSpot a = a();
        if (a == null || a.getAdContent() == null) {
            super.onCreate(bundle);
            finish();
            return;
        }
        p pVar = (p) a.getAdContent().c.a(p.class);
        if (pVar != null) {
            String a2 = pVar.a("presentation_mode", (String) null);
            if (a2 != null) {
                p.a[] values = p.a.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    aVar = values[i];
                    Locale locale = Locale.US;
                    if (a2.toLowerCase(locale).equals(aVar.value.toLowerCase(locale))) {
                        break;
                    }
                    i++;
                }
            }
            aVar = p.a.FullScreen;
        } else {
            aVar = p.a.FullScreen;
        }
        this.d = aVar;
        if (aVar == p.a.Modal) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.gravity = 83;
            attributes.height = (int) (((float) com.fyber.inneractive.sdk.util.p.e()) * 0.8f);
            attributes.width = com.fyber.inneractive.sdk.util.p.f();
            attributes.dimAmount = 0.3f;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setBackgroundColor(0);
            getWindow().addFlags(IronSourceConstants.INIT_COMPLETE);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } else {
            setTheme(16973831);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_internal_store_webpage);
        this.b = (ViewGroup) findViewById(R.id.internal_store_content);
        r c2 = a.getAdContent().c();
        this.c = c2;
        if (c2 != null) {
            c2.getClass();
            c2.q = new WeakReference<>(this);
            r rVar = this.c;
            j jVar = rVar.h;
            if (jVar != null) {
                ((p.a) jVar).a(com.fyber.inneractive.sdk.network.r.IGNITE_FLOW_STORE_PAGE_OPENED, rVar.B ? k.TRUE_SINGLE_TAP : k.SINGLE_TAP);
            }
            this.c.t.set(0);
        }
    }

    public void onDestroy() {
        r rVar;
        super.onDestroy();
        InneractiveAdSpot a = a();
        if (a != null && a.getAdContent() != null && !a.getAdContent().e() && (rVar = this.c) != null) {
            rVar.a();
            this.c = null;
        }
    }

    public void onPause() {
        super.onPause();
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    public void onResume() {
        super.onResume();
        r rVar = this.c;
        if (rVar != null) {
            this.b.addView(rVar.a, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void onBackPressed() {
        r rVar = this.c;
        if (rVar != null) {
            if (!rVar.x) {
                if (rVar.w) {
                    rVar.f("navigateBack();");
                    return;
                }
            } else {
                return;
            }
        }
        super.onBackPressed();
    }
}
