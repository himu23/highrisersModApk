package com.fyber.inneractive.sdk.player.ui;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RotateDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.global.features.n;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.flow.e;
import com.fyber.inneractive.sdk.model.vast.h;
import com.fyber.inneractive.sdk.ui.FyberAdIdentifier;
import com.fyber.inneractive.sdk.ui.IAsmoothProgressBar;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q0;

public class j extends l {
    public TextView R;
    public ImageView S;
    public View T;
    public ViewGroup U;
    public final a V;
    public ViewGroup W;

    public j(Context context, e eVar, a aVar, s sVar, boolean z, String str) {
        super(context, sVar, str);
        LayoutInflater.from(context).inflate(R.layout.ia_video_view_new_design, this, true);
        e();
        this.V = aVar;
        if (eVar != null) {
            eVar.a(this.U, FyberAdIdentifier.Corner.BOTTOM_LEFT);
        }
        f(z);
    }

    private void setProgressBarTint(r rVar) {
        String a = rVar.a("new_video_design_skip_progress_bar_start_color", "#9000D691");
        String a2 = rVar.a("new_video_design_skip_progress_bar_end_color", "#00D691");
        try {
            int[] iArr = {Color.parseColor(a), Color.parseColor(a2)};
            Drawable progressDrawable = this.x.getProgressDrawable();
            if (progressDrawable instanceof RotateDrawable) {
                Drawable drawable = ((RotateDrawable) progressDrawable).getDrawable();
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setColors(iArr);
                    this.x.setProgressDrawable(progressDrawable);
                }
            }
        } catch (Exception unused) {
            IAlog.a("could not parse colors %s %s", a, a2);
        }
    }

    private void setSizesAndTint(r rVar) {
        ImageView imageView = this.v;
        Integer b = rVar.b("new_video_design_mute_btn_size_w");
        int i = 30;
        int intValue = b != null ? b.intValue() : 30;
        Integer b2 = rVar.b("new_video_design_mute_btn_size_h");
        p.a((View) imageView, intValue, b2 != null ? b2.intValue() : 30);
        IAsmoothProgressBar iAsmoothProgressBar = this.x;
        Integer b3 = rVar.b("new_video_design_skip_progress_bar_size_w");
        int i2 = 46;
        int intValue2 = b3 != null ? b3.intValue() : 46;
        Integer b4 = rVar.b("new_video_design_skip_progress_bar_size_h");
        if (b4 != null) {
            i2 = b4.intValue();
        }
        p.a((View) iAsmoothProgressBar, intValue2, i2);
        ImageView imageView2 = this.S;
        Integer b5 = rVar.b("new_video_design_skip_btn_size_w");
        int intValue3 = b5 != null ? b5.intValue() : 30;
        Integer b6 = rVar.b("new_video_design_skip_btn_size_h");
        p.a((View) imageView2, intValue3, b6 != null ? b6.intValue() : 30);
        TextView textView = this.R;
        Integer b7 = rVar.b("new_video_design_skip_btn_size_w");
        int intValue4 = b7 != null ? b7.intValue() : 30;
        Integer b8 = rVar.b("new_video_design_skip_btn_size_h");
        if (b8 != null) {
            i = b8.intValue();
        }
        p.a((View) textView, intValue4, i);
        ImageView imageView3 = this.S;
        Integer b9 = rVar.b("new_video_design_skip_btn_margin");
        int i3 = 12;
        int intValue5 = b9 != null ? b9.intValue() : 12;
        if (imageView3 != null && (imageView3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            int a = p.a(intValue5);
            ((ViewGroup.MarginLayoutParams) imageView3.getLayoutParams()).setMargins(a, a, a, a);
            imageView3.requestLayout();
        }
        TextView textView2 = this.R;
        Integer b10 = rVar.b("new_video_design_skip_btn_margin");
        if (b10 != null) {
            i3 = b10.intValue();
        }
        if (textView2 != null && (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            int a2 = p.a(i3);
            ((ViewGroup.MarginLayoutParams) textView2.getLayoutParams()).setMargins(a2, a2, a2, a2);
            textView2.requestLayout();
        }
        View view = this.T;
        Integer b11 = rVar.b("new_video_design_action_btn_size_w");
        int intValue6 = b11 != null ? b11.intValue() : 120;
        Integer b12 = rVar.b("new_video_design_action_btn_size_h");
        p.a(view, intValue6, b12 != null ? b12.intValue() : 48);
        View view2 = this.T;
        String a3 = rVar.a("new_video_design_tint_color", "#00D691");
        if (view2 != null) {
            try {
                view2.setBackgroundColor(Color.parseColor(a3));
            } catch (Exception unused) {
                IAlog.a("could not parse color %s", a3);
            }
        }
        TextView textView3 = this.k;
        String a4 = rVar.a("new_video_design_action_btn_text_color", "#ffffff");
        if (textView3 != null) {
            try {
                textView3.setTextColor(Color.parseColor(a4));
            } catch (Exception unused2) {
                IAlog.a("could not parse color %s", a4);
            }
        }
    }

    public void b(boolean z) {
        if (this.i != null) {
            ViewGroup viewGroup = this.A;
            int i = 8;
            if (viewGroup == null || viewGroup.getVisibility() != 0) {
                if (z) {
                    this.i.setAlpha(0.0f);
                }
                ImageView imageView = this.i;
                if (z) {
                    i = 0;
                }
                imageView.setVisibility(i);
                if (z) {
                    this.i.animate().alpha(1.0f).setDuration(500).start();
                    return;
                }
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

    public void d() {
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        TextView textView = this.R;
        if (textView != null) {
            textView.setVisibility(4);
        }
        View view = this.T;
        if (view != null) {
            view.setVisibility(8);
        }
        if (this.x != null && !f()) {
            this.x.setVisibility(4);
        }
        e(false);
        this.k.setVisibility(4);
        ImageView imageView2 = this.w;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        ViewGroup viewGroup = this.U;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
        a(false, (String) null);
    }

    public void d(boolean z) {
    }

    public void f(boolean z) {
        s sVar = this.L;
        String d = sVar != null ? ((n) sVar.a(n.class)).d() : getContext().getString(R.string.ia_video_app_info_text);
        if (z) {
            e(false);
            a(true, d);
            return;
        }
        a(false, (String) null);
    }

    public View[] getTrackingFriendlyView() {
        return new View[]{this.W, this.J, this.i, this.K};
    }

    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return new View[]{this.r, this.U};
    }

    public void h() {
        s sVar;
        if (this.T != null && (sVar = this.L) != null) {
            r rVar = (r) sVar.a(r.class);
            TextView textView = this.k;
            if (textView != null) {
                textView.setTextSize(0, getResources().getDimension(R.dimen.ia_video_overlay_text_large_for_cta));
                View view = this.T;
                Integer b = rVar.b("new_video_design_action_btn_size_w_large");
                int intValue = b != null ? b.intValue() : 180;
                Integer b2 = rVar.b("new_video_design_action_btn_size_h");
                p.a(view, intValue, b2 != null ? b2.intValue() : 48);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (f()) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            View view = this.T;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{(((float) displayMetrics.widthPixels) / 2.0f) - (((float) view.getWidth()) / 2.0f)}), PropertyValuesHolder.ofFloat("y", new float[]{((float) displayMetrics.heightPixels) / 1.3f}), PropertyValuesHolder.ofFloat("scaleX", new float[]{1.4f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.4f})});
            ofPropertyValuesHolder.setDuration(750);
            ofPropertyValuesHolder.start();
        }
    }

    public void a(q0 q0Var, int i, int i2) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.a(this.d, this.s, this.t, this.u, q0Var, i, i2, this.b, ((a0) this.c).f.f.intValue());
        }
    }

    public void c() {
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.S.setEnabled(true);
            TextView textView = this.R;
            if (textView != null) {
                textView.setVisibility(4);
            }
        }
    }

    public void j() {
        a aVar = this.V;
        if (aVar != null) {
            this.D = aVar.a(this.d, this.s, this.t, this.C, this.b, this.j, this.i);
        }
    }

    public void setRemainingTime(String str) {
        TextView textView = this.R;
        if (textView != null) {
            textView.setVisibility(0);
            this.R.setText(str);
        }
    }

    public void setSkipText(String str) {
        TextView textView = this.R;
        if (textView != null) {
            textView.setVisibility(0);
            this.R.setText(str);
        }
    }

    public void e(boolean z) {
        ImageView imageView = this.S;
        if (imageView != null && this.R != null) {
            int i = 0;
            if (imageView.isEnabled()) {
                ImageView imageView2 = this.S;
                if (!z) {
                    i = 4;
                }
                imageView2.setVisibility(i);
                this.R.setVisibility(4);
                return;
            }
            this.S.setVisibility(4);
            TextView textView = this.R;
            if (!z) {
                i = 4;
            }
            textView.setVisibility(i);
        }
    }

    public void a(b bVar) {
        View view = bVar.e;
        this.p = view;
        if (view != null && this.A != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.p);
            }
            ViewGroup viewGroup = this.U;
            if (viewGroup != null) {
                viewGroup.setVisibility(4);
            }
            TextView textView = this.R;
            if (textView != null) {
                textView.setVisibility(4);
            }
            b(bVar);
            this.A.addView(this.p, 0);
            c(bVar);
        }
    }

    public void e() {
        super.e();
        this.W = (ViewGroup) findViewById(R.id.ia_video_controls_overlay);
        this.T = findViewById(R.id.ia_cta_container);
        this.x = (IAsmoothProgressBar) findViewById(R.id.ia_video_progressbar_new);
        ImageView imageView = (ImageView) findViewById(R.id.ia_iv_skip);
        this.S = imageView;
        imageView.setEnabled(false);
        this.R = (TextView) findViewById(R.id.ia_tv_skip_left);
        this.U = (ViewGroup) findViewById(R.id.ia_identifier_overlay);
        this.v = (ImageView) findViewById(R.id.ia_iv_mute_button_new);
        this.J = findViewById(R.id.ia_click_overlay);
        this.x.setVisibility(0);
        this.v.setVisibility(0);
        a((View) this.S, 6);
        a((View) this.v, 1);
        s sVar = this.L;
        if (sVar != null) {
            setSizesAndTint((r) sVar.a(r.class));
            setProgressBarTint((r) this.L.a(r.class));
        }
    }
}
