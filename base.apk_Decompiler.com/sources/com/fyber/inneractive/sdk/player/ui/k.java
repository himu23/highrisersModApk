package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.global.features.n;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.flow.e;
import com.fyber.inneractive.sdk.model.vast.h;
import com.fyber.inneractive.sdk.ui.FyberAdIdentifier;
import com.fyber.inneractive.sdk.ui.IAsmoothProgressBar;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q0;
import java.util.Locale;

public class k extends l {
    public a R;
    public ViewGroup S;

    public k(Context context, e eVar, a aVar, s sVar, boolean z, String str) {
        super(context, sVar, str);
        LayoutInflater.from(context).inflate(R.layout.ia_video_view, this, true);
        e();
        this.R = aVar;
        if (eVar != null) {
            eVar.a(this.S, FyberAdIdentifier.Corner.BOTTOM_LEFT);
        }
        g(z);
    }

    public void a(b bVar) {
        View view = bVar.e;
        this.p = view;
        this.q = bVar.f;
        if (view != null && this.A != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.p);
            }
            b(bVar);
            this.A.addView(this.p, 0);
            c(bVar);
        }
    }

    public void b(boolean z) {
        if (this.i != null) {
            ViewGroup viewGroup = this.A;
            int i = 8;
            if (viewGroup == null || viewGroup.getVisibility() != 0) {
                ImageView imageView = this.i;
                if (z) {
                    i = 0;
                }
                imageView.setVisibility(i);
                return;
            }
            IAlog.a("end card is visible and requested to show last frame image with value of %s", Boolean.valueOf(z));
            ImageView imageView2 = this.i;
            if (this.q == h.FMP_End_Card && z) {
                i = 0;
            }
            imageView2.setVisibility(i);
        }
    }

    public void c() {
        TextView textView = this.o;
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    public void d(boolean z) {
        TextView textView = this.o;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    public void e(boolean z) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    public void g(boolean z) {
        String str;
        boolean z2;
        String string = getContext().getString(R.string.ia_video_app_info_text);
        s sVar = this.L;
        if (sVar == null || sVar.a(r.class) == null) {
            str = string;
            z2 = true;
        } else {
            z2 = ((r) this.L.a(r.class)).a("show_ad_identifier_original_design", true);
            str = ((n) this.L.a(n.class)).d();
        }
        if (z && z2) {
            e(false);
            a(true, str);
            f(true);
        } else if (z) {
            e(false);
            a(true, str);
            f(false);
        } else if (z2) {
            a(false, (String) null);
            e(false);
            f(true);
        } else {
            e(true);
            f(false);
        }
    }

    public View[] getTrackingFriendlyView() {
        return new View[]{this.k, this.n, this.o, this.v, this.x, this.J, this.K};
    }

    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return new View[]{this.r, this.S};
    }

    public void h() {
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.width = -2;
        this.k.setLayoutParams(layoutParams);
        this.k.setTextSize(0, getResources().getDimension(R.dimen.ia_video_overlay_text_large_for_cta));
    }

    public void setRemainingTime(String str) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSkipText(String str) {
        if (this.o != null) {
            try {
                Integer.parseInt(str);
                int i = R.string.ia_video_before_skip_format;
                Locale locale = Locale.US;
                Context a = IAConfigManager.M.v.a();
                int parseInt = Integer.parseInt(str);
                str = String.format(locale, a.getString(i), new Object[]{Integer.valueOf(parseInt)});
            } catch (Exception unused) {
            }
            this.o.setText(str);
        }
    }

    public void f(boolean z) {
        ViewGroup viewGroup = this.S;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 4);
        }
    }

    public void j() {
        a aVar = this.R;
        if (aVar != null) {
            this.D = aVar.a(this.d, this.s, this.t, this.C, this.b, this.j, this.i);
        }
    }

    public void d() {
        d(false);
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        IAsmoothProgressBar iAsmoothProgressBar = this.x;
        if (iAsmoothProgressBar != null) {
            iAsmoothProgressBar.setVisibility(4);
        }
        e(false);
        this.k.setVisibility(4);
        ImageView imageView2 = this.w;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        f(false);
        a(false, (String) null);
    }

    public void e() {
        super.e();
        this.x = (IAsmoothProgressBar) findViewById(R.id.ia_video_progressbar);
        this.v = (ImageView) findViewById(R.id.ia_iv_mute_button);
        this.n = (TextView) findViewById(R.id.ia_tv_remaining_time);
        this.o = (TextView) findViewById(R.id.ia_tv_skip);
        this.S = (ViewGroup) findViewById(R.id.ia_identifier_overlay);
        this.J = findViewById(R.id.ia_click_overlay);
        this.x.setVisibility(0);
        this.v.setVisibility(0);
        a((View) this.v, 1);
        a((View) this.o, 6);
    }

    public void a(q0 q0Var, int i, int i2) {
        a aVar = this.R;
        if (aVar != null) {
            aVar.a(this.d, this.s, this.t, this.u, q0Var, i, i2, this.b, ((a0) this.c).f.f.intValue());
        }
    }
}
