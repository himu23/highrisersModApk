package com.fyber.inneractive.sdk.player.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class m extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public m(l lVar) {
        this.a = lVar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        l lVar = this.a;
        ViewGroup viewGroup = lVar.A;
        if (viewGroup != null && viewGroup.getParent() != null) {
            ((View) lVar.A.getParent()).setOnTouchListener((View.OnTouchListener) null);
        }
    }
}
