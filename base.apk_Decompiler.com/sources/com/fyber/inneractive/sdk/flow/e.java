package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.FyberReportAdActivity;
import com.fyber.inneractive.sdk.cache.b;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.a;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.h0;
import com.fyber.inneractive.sdk.network.r0;
import com.fyber.inneractive.sdk.ui.FyberAdIdentifier;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;

public class e implements FyberAdIdentifier.ClickListener, f {
    public final InneractiveAdRequest a;
    public final com.fyber.inneractive.sdk.response.e b;
    public final FyberAdIdentifier c;
    public Context d;
    public final s e;

    public e(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, s sVar) {
        this.a = inneractiveAdRequest;
        this.b = eVar;
        this.e = sVar;
        FyberAdIdentifier fyberAdIdentifier = new FyberAdIdentifier();
        this.c = fyberAdIdentifier;
        fyberAdIdentifier.a((FyberAdIdentifier.ClickListener) this);
    }

    public void a(ViewGroup viewGroup, FyberAdIdentifier.Corner corner) {
        a.C0089a aVar;
        FyberAdIdentifier fyberAdIdentifier = this.c;
        fyberAdIdentifier.c = corner;
        s sVar = this.e;
        int i = 0;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fyber_ad_identifier_layout, viewGroup, false);
        fyberAdIdentifier.a = (ImageView) viewGroup2.findViewById(R.id.fyber_identifier_image);
        fyberAdIdentifier.b = viewGroup2.findViewById(R.id.fyber_identifier_text);
        if (sVar != null) {
            a aVar2 = (a) sVar.a(a.class);
            View view = fyberAdIdentifier.b;
            Integer b2 = aVar2.b("ad_identifier_text_size_w");
            int intValue = b2 != null ? b2.intValue() : 55;
            Integer b3 = aVar2.b("ad_identifier_text_size_h");
            int i2 = 18;
            p.a(view, intValue, b3 != null ? b3.intValue() : 18);
            ImageView imageView = fyberAdIdentifier.a;
            Integer b4 = aVar2.b("ad_identifier_image_size_w");
            int intValue2 = b4 != null ? b4.intValue() : 18;
            Integer b5 = aVar2.b("ad_identifier_image_size_h");
            if (b5 != null) {
                i2 = b5.intValue();
            }
            p.a((View) imageView, intValue2, i2);
            View view2 = fyberAdIdentifier.b;
            Integer b6 = aVar2.b("ad_identifier_text_size");
            int intValue3 = b6 != null ? b6.intValue() : 8;
            if (view2 instanceof TextView) {
                ((TextView) view2).setTextSize((float) intValue3);
            }
            ImageView imageView2 = fyberAdIdentifier.a;
            String a2 = aVar2.a("ad_identifier_tint_color", "#75DCDCDC");
            try {
                if ((imageView2 instanceof ImageView) && !TextUtils.isEmpty(a2)) {
                    imageView2.setColorFilter(Color.parseColor(a2));
                }
            } catch (Exception unused) {
                IAlog.a("could not parse color %s", a2);
            }
            String a3 = aVar2.a("identifier_click_action", a.e.mKey);
            a.C0089a[] values = a.C0089a.values();
            int length = values.length;
            while (true) {
                if (i >= length) {
                    aVar = a.C0089a.NONE;
                    break;
                }
                aVar = values[i];
                if (a3.equalsIgnoreCase(aVar.mKey)) {
                    break;
                }
                i++;
            }
            if (aVar.equals(a.C0089a.OPEN)) {
                fyberAdIdentifier.b.setOnClickListener(fyberAdIdentifier);
            } else {
                fyberAdIdentifier.b.setOnClickListener((View.OnClickListener) null);
            }
            ((TextView) fyberAdIdentifier.b).setText(aVar2.a("ad_identifier_text", "Ads by DT"));
            String a4 = aVar2.a("ad_identifier_icon_url", (String) null);
            if (!TextUtils.isEmpty(a4)) {
                h0 h0Var = new h0(new com.fyber.inneractive.sdk.ui.a(fyberAdIdentifier), viewGroup.getContext(), new b(a4));
                IAConfigManager.M.s.a.offer(h0Var);
                h0Var.a(r0.QUEUED);
            }
        }
        FyberAdIdentifier.Corner corner2 = fyberAdIdentifier.c;
        if (corner2 == FyberAdIdentifier.Corner.TOP_LEFT || corner2 == FyberAdIdentifier.Corner.BOTTOM_LEFT) {
            viewGroup2.removeView(fyberAdIdentifier.b);
            viewGroup2.addView(fyberAdIdentifier.b);
        }
        viewGroup2.addOnLayoutChangeListener(new com.fyber.inneractive.sdk.ui.b(fyberAdIdentifier));
        fyberAdIdentifier.a.setOnClickListener(fyberAdIdentifier);
        fyberAdIdentifier.a();
        viewGroup.addView(viewGroup2);
        ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int i3 = FyberAdIdentifier.a.a[fyberAdIdentifier.c.ordinal()];
            layoutParams2.gravity = i3 != 1 ? i3 != 2 ? i3 != 3 ? 85 : 83 : 53 : 51;
        }
        this.d = viewGroup.getContext();
    }

    public void a() {
        FyberReportAdActivity.start(this.d, this);
    }
}
