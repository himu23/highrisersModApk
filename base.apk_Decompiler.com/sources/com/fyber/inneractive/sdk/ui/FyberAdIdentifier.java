package com.fyber.inneractive.sdk.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.R;

public class FyberAdIdentifier implements View.OnClickListener {
    public ImageView a;
    public View b;
    public Corner c = Corner.BOTTOM_LEFT;
    public boolean d = false;
    public Animator e;
    public float f = 0.0f;
    public ClickListener g;
    public Bitmap h;

    public interface ClickListener {
        void a();
    }

    public enum Corner {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.fyber.inneractive.sdk.ui.FyberAdIdentifier$Corner[] r0 = com.fyber.inneractive.sdk.ui.FyberAdIdentifier.Corner.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.ui.FyberAdIdentifier$Corner r1 = com.fyber.inneractive.sdk.ui.FyberAdIdentifier.Corner.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.ui.FyberAdIdentifier$Corner r1 = com.fyber.inneractive.sdk.ui.FyberAdIdentifier.Corner.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.ui.FyberAdIdentifier$Corner r1 = com.fyber.inneractive.sdk.ui.FyberAdIdentifier.Corner.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.ui.FyberAdIdentifier$Corner r1 = com.fyber.inneractive.sdk.ui.FyberAdIdentifier.Corner.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.ui.FyberAdIdentifier.a.<clinit>():void");
        }
    }

    public FyberAdIdentifier a(ClickListener clickListener) {
        this.g = clickListener;
        return this;
    }

    public void onClick(View view) {
        if (view.getId() == this.a.getId()) {
            if (this.e == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, View.ROTATION_X, new float[]{90.0f});
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this.a, "imageAlpha", new int[]{255, 25});
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(new Animator[]{ofFloat, ofInt});
                animatorSet2.addListener(new c(this, animatorSet));
                animatorSet2.setDuration(225);
                this.e = animatorSet2;
                animatorSet2.start();
                float f2 = 0.0f;
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, View.ROTATION_X, new float[]{0.0f});
                ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this.a, "imageAlpha", new int[]{25, 255});
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(new Animator[]{ofFloat2, ofInt2});
                animatorSet3.setDuration(225);
                View view2 = this.b;
                Property property = View.TRANSLATION_X;
                float[] fArr = new float[1];
                if (this.d) {
                    f2 = this.f;
                }
                fArr[0] = f2;
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, property, fArr);
                ofFloat3.setDuration(450);
                animatorSet.setDuration(450);
                animatorSet.playTogether(new Animator[]{ofFloat3, animatorSet3});
                animatorSet.addListener(new d(this));
            }
        } else if (view.getId() == this.b.getId() && this.g != null) {
            a();
            this.g.a();
        }
    }

    public final void a() {
        this.d = false;
        this.b.setTranslationX(0.0f);
        this.a.setImageResource(R.drawable.fyber_info_button);
        Animator animator = this.e;
        if (animator != null) {
            animator.removeAllListeners();
            this.e = null;
        }
    }

    public static boolean a(FyberAdIdentifier fyberAdIdentifier) {
        Corner corner = fyberAdIdentifier.c;
        return corner == Corner.TOP_LEFT || corner == Corner.BOTTOM_LEFT;
    }
}
