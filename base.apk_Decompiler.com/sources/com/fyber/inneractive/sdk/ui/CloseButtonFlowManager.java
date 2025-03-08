package com.fyber.inneractive.sdk.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;

public class CloseButtonFlowManager {
    public final View a;
    public final TextView b;
    public final View c;
    public final ImageView d;
    public final FrameLayout e;
    public boolean f = false;

    public class a implements View.OnClickListener {
        public final /* synthetic */ InneractiveFullscreenAdActivity a;

        public a(CloseButtonFlowManager closeButtonFlowManager, InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
            this.a = inneractiveFullscreenAdActivity;
        }

        public void onClick(View view) {
            this.a.dismissAd(true);
        }
    }

    public CloseButtonFlowManager(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        View findViewById = inneractiveFullscreenAdActivity.findViewById(R.id.ia_fl_close_button);
        this.a = findViewById;
        this.b = (TextView) inneractiveFullscreenAdActivity.findViewById(R.id.ia_tv_close_button);
        View findViewById2 = inneractiveFullscreenAdActivity.findViewById(R.id.ia_clickable_close_button);
        this.c = findViewById2;
        this.d = (ImageView) inneractiveFullscreenAdActivity.findViewById(R.id.ia_iv_close_button);
        this.e = (FrameLayout) inneractiveFullscreenAdActivity.findViewById(R.id.close_button_container);
        findViewById.setVisibility(8);
        findViewById2.setOnClickListener(new a(this, inneractiveFullscreenAdActivity));
    }
}
