package com.fyber.inneractive.sdk.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class d extends AnimatorListenerAdapter {
    public final /* synthetic */ FyberAdIdentifier a;

    public d(FyberAdIdentifier fyberAdIdentifier) {
        this.a = fyberAdIdentifier;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        FyberAdIdentifier fyberAdIdentifier = this.a;
        fyberAdIdentifier.e = null;
        boolean unused = fyberAdIdentifier.d = !fyberAdIdentifier.d;
    }
}
