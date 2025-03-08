package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.work.impl.Scheduler;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.ak;
import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.h;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.i;
import com.applovin.exoplayer2.j;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.m.o;
import com.applovin.exoplayer2.t;
import com.applovin.exoplayer2.ui.k;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class f extends FrameLayout {
    private final ba.c U;
    /* access modifiers changed from: private */
    public boolean WG;
    private long[] WJ;
    private boolean[] WK;
    private final b WL;
    private final CopyOnWriteArrayList<d> WM;
    /* access modifiers changed from: private */
    public final View WN;
    /* access modifiers changed from: private */
    public final View WO;
    /* access modifiers changed from: private */
    public final View WP;
    /* access modifiers changed from: private */
    public final View WQ;
    /* access modifiers changed from: private */
    public final View WR;
    /* access modifiers changed from: private */
    public final View WS;
    /* access modifiers changed from: private */
    public final ImageView WT;
    /* access modifiers changed from: private */
    public final ImageView WU;
    private final View WV;
    private final TextView WW;
    /* access modifiers changed from: private */
    public final TextView WX;
    private final k WY;
    private final Runnable WZ;
    /* access modifiers changed from: private */
    public final StringBuilder Wu;
    /* access modifiers changed from: private */
    public final Formatter Wv;
    private long XA = -9223372036854775807L;
    private long[] XB;
    private boolean[] XC;
    private long XD;
    private long XE;
    private long XF;
    private final Runnable Xa;
    private final Drawable Xb;
    private final Drawable Xc;
    private final Drawable Xd;
    private final String Xe;
    private final String Xf;
    private final String Xg;
    private final Drawable Xh;
    private final Drawable Xi;
    private final float Xj;
    private final float Xk;
    private final String Xl;
    private final String Xm;
    /* access modifiers changed from: private */
    public i Xn;
    private c Xo;
    private boolean Xp;
    private boolean Xq;
    private boolean Xr;
    private int Xs = 5000;
    private int Xt = Scheduler.MAX_GREEDY_SCHEDULER_LIMIT;
    /* access modifiers changed from: private */
    public int Xu = 0;
    private boolean Xv = true;
    private boolean Xw = true;
    private boolean Xx = true;
    private boolean Xy = true;
    private boolean Xz = false;
    private final ba.a bI;
    /* access modifiers changed from: private */
    public an jb;

    public interface c {
        void z(long j, long j2);
    }

    public interface d {
        void eZ(int i);
    }

    private static boolean eY(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    public an getPlayer() {
        return this.jb;
    }

    public int getRepeatToggleModes() {
        return this.Xu;
    }

    public boolean getShowShuffleButton() {
        return this.Xz;
    }

    public int getShowTimeoutMs() {
        return this.Xs;
    }

    public void setProgressUpdateListener(c cVar) {
        this.Xo = cVar;
    }

    static {
        t.f("goog.exo.ui");
    }

    public f(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int i2 = R.layout.applovin_exo_player_control_view;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.AppLovinPlayerControlView, i, 0);
            try {
                this.Xs = obtainStyledAttributes.getInt(R.styleable.AppLovinPlayerControlView_al_show_timeout, this.Xs);
                i2 = obtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerControlView_al_controller_layout_id, i2);
                this.Xu = a(obtainStyledAttributes, this.Xu);
                this.Xv = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_rewind_button, this.Xv);
                this.Xw = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_fastforward_button, this.Xw);
                this.Xx = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_previous_button, this.Xx);
                this.Xy = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_next_button, this.Xy);
                this.Xz = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_shuffle_button, this.Xz);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R.styleable.AppLovinPlayerControlView_al_time_bar_min_update_interval, this.Xt));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.WM = new CopyOnWriteArrayList<>();
        this.bI = new ba.a();
        this.U = new ba.c();
        StringBuilder sb = new StringBuilder();
        this.Wu = sb;
        this.Wv = new Formatter(sb, Locale.getDefault());
        this.WJ = new long[0];
        this.WK = new boolean[0];
        this.XB = new long[0];
        this.XC = new boolean[0];
        b bVar = new b();
        this.WL = bVar;
        this.Xn = new j();
        this.WZ = new f$$ExternalSyntheticLambda0(this);
        this.Xa = new f$$ExternalSyntheticLambda1(this);
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        k kVar = (k) findViewById(R.id.al_exo_progress);
        View findViewById = findViewById(R.id.al_exo_progress_placeholder);
        if (kVar != null) {
            this.WY = kVar;
        } else if (findViewById != null) {
            d dVar = new d(context, (AttributeSet) null, 0, attributeSet2);
            dVar.setId(R.id.al_exo_progress);
            dVar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(dVar, indexOfChild);
            this.WY = dVar;
        } else {
            this.WY = null;
        }
        this.WW = (TextView) findViewById(R.id.al_exo_duration);
        this.WX = (TextView) findViewById(R.id.al_exo_position);
        k kVar2 = this.WY;
        if (kVar2 != null) {
            kVar2.a(bVar);
        }
        View findViewById2 = findViewById(R.id.al_exo_play);
        this.WP = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(bVar);
        }
        View findViewById3 = findViewById(R.id.al_exo_pause);
        this.WQ = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(bVar);
        }
        View findViewById4 = findViewById(R.id.al_exo_prev);
        this.WN = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(bVar);
        }
        View findViewById5 = findViewById(R.id.al_exo_next);
        this.WO = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(bVar);
        }
        View findViewById6 = findViewById(R.id.al_exo_rew);
        this.WS = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(bVar);
        }
        View findViewById7 = findViewById(R.id.al_exo_ffwd);
        this.WR = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(bVar);
        }
        ImageView imageView = (ImageView) findViewById(R.id.al_exo_repeat_toggle);
        this.WT = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(bVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.al_exo_shuffle);
        this.WU = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(bVar);
        }
        View findViewById8 = findViewById(R.id.al_exo_vr);
        this.WV = findViewById8;
        setShowVrButton(false);
        a(false, false, findViewById8);
        Resources resources = context.getResources();
        this.Xj = ((float) resources.getInteger(R.integer.al_exo_media_button_opacity_percentage_enabled)) / 100.0f;
        this.Xk = ((float) resources.getInteger(R.integer.al_exo_media_button_opacity_percentage_disabled)) / 100.0f;
        this.Xb = resources.getDrawable(R.drawable.al_exo_controls_repeat_off);
        this.Xc = resources.getDrawable(R.drawable.al_exo_controls_repeat_one);
        this.Xd = resources.getDrawable(R.drawable.al_exo_controls_repeat_all);
        this.Xh = resources.getDrawable(R.drawable.al_exo_controls_shuffle_on);
        this.Xi = resources.getDrawable(R.drawable.al_exo_controls_shuffle_off);
        this.Xe = resources.getString(R.string.al_exo_controls_repeat_off_description);
        this.Xf = resources.getString(R.string.al_exo_controls_repeat_one_description);
        this.Xg = resources.getString(R.string.al_exo_controls_repeat_all_description);
        this.Xl = resources.getString(R.string.al_exo_controls_shuffle_on_description);
        this.Xm = resources.getString(R.string.al_exo_controls_shuffle_off_description);
    }

    public void setPlayer(an anVar) {
        boolean z = true;
        com.applovin.exoplayer2.l.a.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (!(anVar == null || anVar.az() == Looper.getMainLooper())) {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkArgument(z);
        an anVar2 = this.jb;
        if (anVar2 != anVar) {
            if (anVar2 != null) {
                anVar2.b((an.d) this.WL);
            }
            this.jb = anVar;
            if (anVar != null) {
                anVar.a((an.d) this.WL);
            }
            nv();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.Xq = z;
        nA();
    }

    public void a(d dVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(dVar);
        this.WM.add(dVar);
    }

    public void b(d dVar) {
        this.WM.remove(dVar);
    }

    @Deprecated
    public void setControlDispatcher(i iVar) {
        if (this.Xn != iVar) {
            this.Xn = iVar;
            nx();
        }
    }

    public void setShowRewindButton(boolean z) {
        this.Xv = z;
        nx();
    }

    public void setShowFastForwardButton(boolean z) {
        this.Xw = z;
        nx();
    }

    public void setShowPreviousButton(boolean z) {
        this.Xx = z;
        nx();
    }

    public void setShowNextButton(boolean z) {
        this.Xy = z;
        nx();
    }

    public void setShowTimeoutMs(int i) {
        this.Xs = i;
        if (mx()) {
            nu();
        }
    }

    public void setRepeatToggleModes(int i) {
        this.Xu = i;
        an anVar = this.jb;
        if (anVar != null) {
            int aF = anVar.aF();
            if (i == 0 && aF != 0) {
                this.Xn.a(this.jb, 0);
            } else if (i == 1 && aF == 2) {
                this.Xn.a(this.jb, 1);
            } else if (i == 2 && aF == 1) {
                this.Xn.a(this.jb, 2);
            }
        }
        ny();
    }

    public void setShowShuffleButton(boolean z) {
        this.Xz = z;
        nz();
    }

    public boolean getShowVrButton() {
        View view = this.WV;
        return view != null && view.getVisibility() == 0;
    }

    public void setShowVrButton(boolean z) {
        View view = this.WV;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.WV;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            a(getShowVrButton(), onClickListener != null, this.WV);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.Xt = ai.k(i, 16, 1000);
    }

    public void show() {
        if (!mx()) {
            setVisibility(0);
            Iterator<d> it = this.WM.iterator();
            while (it.hasNext()) {
                it.next().eZ(getVisibility());
            }
            nv();
            nC();
            nD();
        }
        nu();
    }

    public void nt() {
        if (mx()) {
            setVisibility(8);
            Iterator<d> it = this.WM.iterator();
            while (it.hasNext()) {
                it.next().eZ(getVisibility());
            }
            removeCallbacks(this.WZ);
            removeCallbacks(this.Xa);
            this.XA = -9223372036854775807L;
        }
    }

    public boolean mx() {
        return getVisibility() == 0;
    }

    private void nu() {
        removeCallbacks(this.Xa);
        if (this.Xs > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.Xs;
            this.XA = uptimeMillis + ((long) i);
            if (this.Xp) {
                postDelayed(this.Xa, (long) i);
                return;
            }
            return;
        }
        this.XA = -9223372036854775807L;
    }

    private void nv() {
        nw();
        nx();
        ny();
        nz();
        nA();
    }

    /* access modifiers changed from: private */
    public void nw() {
        boolean z;
        boolean z2;
        if (mx() && this.Xp) {
            boolean nE = nE();
            View view = this.WP;
            int i = 8;
            boolean z3 = true;
            if (view != null) {
                z2 = nE && view.isFocused();
                if (ai.acV < 21) {
                    z = z2;
                } else {
                    z = nE && a.g(this.WP);
                }
                this.WP.setVisibility(nE ? 8 : 0);
            } else {
                z2 = false;
                z = false;
            }
            View view2 = this.WQ;
            if (view2 != null) {
                z2 |= !nE && view2.isFocused();
                if (ai.acV < 21) {
                    z3 = z2;
                } else if (nE || !a.g(this.WQ)) {
                    z3 = false;
                }
                z |= z3;
                View view3 = this.WQ;
                if (nE) {
                    i = 0;
                }
                view3.setVisibility(i);
            }
            if (z2) {
                nC();
            }
            if (z) {
                nD();
            }
        }
    }

    /* access modifiers changed from: private */
    public void nx() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (mx() && this.Xp) {
            an anVar = this.jb;
            boolean z5 = false;
            if (anVar != null) {
                boolean n = anVar.n(4);
                boolean n2 = anVar.n(6);
                z = anVar.n(10) && this.Xn.aj();
                if (anVar.n(11) && this.Xn.ak()) {
                    z5 = true;
                }
                boolean z6 = n;
                z3 = anVar.n(8);
                z4 = z5;
                z5 = n2;
                z2 = z6;
            } else {
                z4 = false;
                z3 = false;
                z2 = false;
                z = false;
            }
            a(this.Xx, z5, this.WN);
            a(this.Xv, z, this.WS);
            a(this.Xw, z4, this.WR);
            a(this.Xy, z3, this.WO);
            k kVar = this.WY;
            if (kVar != null) {
                kVar.setEnabled(z2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void ny() {
        ImageView imageView;
        if (mx() && this.Xp && (imageView = this.WT) != null) {
            if (this.Xu == 0) {
                a(false, false, (View) imageView);
                return;
            }
            an anVar = this.jb;
            if (anVar == null) {
                a(true, false, (View) imageView);
                this.WT.setImageDrawable(this.Xb);
                this.WT.setContentDescription(this.Xe);
                return;
            }
            a(true, true, (View) imageView);
            int aF = anVar.aF();
            if (aF == 0) {
                this.WT.setImageDrawable(this.Xb);
                this.WT.setContentDescription(this.Xe);
            } else if (aF == 1) {
                this.WT.setImageDrawable(this.Xc);
                this.WT.setContentDescription(this.Xf);
            } else if (aF == 2) {
                this.WT.setImageDrawable(this.Xd);
                this.WT.setContentDescription(this.Xg);
            }
            this.WT.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void nz() {
        ImageView imageView;
        if (mx() && this.Xp && (imageView = this.WU) != null) {
            an anVar = this.jb;
            if (!this.Xz) {
                a(false, false, (View) imageView);
            } else if (anVar == null) {
                a(true, false, (View) imageView);
                this.WU.setImageDrawable(this.Xi);
                this.WU.setContentDescription(this.Xm);
            } else {
                a(true, true, (View) imageView);
                this.WU.setImageDrawable(anVar.aG() ? this.Xh : this.Xi);
                this.WU.setContentDescription(anVar.aG() ? this.Xl : this.Xm);
            }
        }
    }

    /* access modifiers changed from: private */
    public void nA() {
        int i;
        long j;
        an anVar = this.jb;
        if (anVar != null) {
            boolean z = true;
            this.Xr = this.Xq && a(anVar.aX(), this.U);
            this.XD = 0;
            ba aX = anVar.aX();
            if (!aX.isEmpty()) {
                int aL = anVar.aL();
                boolean z2 = this.Xr;
                int i2 = z2 ? 0 : aL;
                int cP = z2 ? aX.cP() - 1 : aL;
                long j2 = 0;
                i = 0;
                while (true) {
                    if (i2 > cP) {
                        break;
                    }
                    if (i2 == aL) {
                        this.XD = h.f(j2);
                    }
                    aX.a(i2, this.U);
                    if (this.U.fH == -9223372036854775807L) {
                        com.applovin.exoplayer2.l.a.checkState(this.Xr ^ z);
                        break;
                    }
                    for (int i3 = this.U.iQ; i3 <= this.U.iR; i3++) {
                        aX.a(i3, this.bI);
                        int dg = this.bI.dg();
                        for (int dh = this.bI.dh(); dh < dg; dh++) {
                            long al = this.bI.al(dh);
                            if (al == Long.MIN_VALUE) {
                                if (this.bI.fH == -9223372036854775807L) {
                                } else {
                                    al = this.bI.fH;
                                }
                            }
                            long df = al + this.bI.df();
                            if (df >= 0) {
                                long[] jArr = this.WJ;
                                if (i == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.WJ = Arrays.copyOf(jArr, length);
                                    this.WK = Arrays.copyOf(this.WK, length);
                                }
                                this.WJ[i] = h.f(j2 + df);
                                this.WK[i] = this.bI.an(dh);
                                i++;
                            }
                        }
                    }
                    j2 += this.U.fH;
                    i2++;
                    z = true;
                }
                j = j2;
            } else {
                j = 0;
                i = 0;
            }
            long f = h.f(j);
            TextView textView = this.WW;
            if (textView != null) {
                textView.setText(ai.a(this.Wu, this.Wv, f));
            }
            k kVar = this.WY;
            if (kVar != null) {
                kVar.setDuration(f);
                int length2 = this.XB.length;
                int i4 = i + length2;
                long[] jArr2 = this.WJ;
                if (i4 > jArr2.length) {
                    this.WJ = Arrays.copyOf(jArr2, i4);
                    this.WK = Arrays.copyOf(this.WK, i4);
                }
                System.arraycopy(this.XB, 0, this.WJ, i, length2);
                System.arraycopy(this.XC, 0, this.WK, i, length2);
                this.WY.a(this.WJ, this.WK, i4);
            }
            nB();
        }
    }

    /* access modifiers changed from: private */
    public void nB() {
        long j;
        long j2;
        int i;
        if (mx() && this.Xp) {
            an anVar = this.jb;
            if (anVar != null) {
                j2 = this.XD + anVar.aS();
                j = this.XD + anVar.aT();
            } else {
                j2 = 0;
                j = 0;
            }
            boolean z = false;
            boolean z2 = j2 != this.XE;
            if (j != this.XF) {
                z = true;
            }
            this.XE = j2;
            this.XF = j;
            TextView textView = this.WX;
            if (textView != null && !this.WG && z2) {
                textView.setText(ai.a(this.Wu, this.Wv, j2));
            }
            k kVar = this.WY;
            if (kVar != null) {
                kVar.setPosition(j2);
                this.WY.setBufferedPosition(j);
            }
            c cVar = this.Xo;
            if (cVar != null && (z2 || z)) {
                cVar.z(j2, j);
            }
            removeCallbacks(this.WZ);
            if (anVar == null) {
                i = 1;
            } else {
                i = anVar.aB();
            }
            long j3 = 1000;
            if (anVar != null && anVar.v()) {
                k kVar2 = this.WY;
                long min = Math.min(kVar2 != null ? kVar2.getPreferredUpdateDelay() : 1000, 1000 - (j2 % 1000));
                float f = anVar.av().gD;
                if (f > 0.0f) {
                    j3 = (long) (((float) min) / f);
                }
                postDelayed(this.WZ, ai.b(j3, (long) this.Xt, 1000));
            } else if (i != 4 && i != 1) {
                postDelayed(this.WZ, 1000);
            }
        }
    }

    private void nC() {
        View view;
        View view2;
        boolean nE = nE();
        if (!nE && (view2 = this.WP) != null) {
            view2.requestFocus();
        } else if (nE && (view = this.WQ) != null) {
            view.requestFocus();
        }
    }

    private void nD() {
        View view;
        View view2;
        boolean nE = nE();
        if (!nE && (view2 = this.WP) != null) {
            view2.sendAccessibilityEvent(8);
        } else if (nE && (view = this.WQ) != null) {
            view.sendAccessibilityEvent(8);
        }
    }

    private void a(boolean z, boolean z2, View view) {
        if (view != null) {
            view.setEnabled(z2);
            view.setAlpha(z2 ? this.Xj : this.Xk);
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* access modifiers changed from: private */
    public void b(an anVar, long j) {
        int i;
        ba aX = anVar.aX();
        if (this.Xr && !aX.isEmpty()) {
            int cP = aX.cP();
            i = 0;
            while (true) {
                long dl = aX.a(i, this.U).dl();
                if (j < dl) {
                    break;
                } else if (i == cP - 1) {
                    j = dl;
                    break;
                } else {
                    j -= dl;
                    i++;
                }
            }
        } else {
            i = anVar.aL();
        }
        b(anVar, i, j);
        nB();
    }

    private boolean b(an anVar, int i, long j) {
        return this.Xn.a(anVar, i, j);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Xp = true;
        long j = this.XA;
        if (j != -9223372036854775807L) {
            long uptimeMillis = j - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                nt();
            } else {
                postDelayed(this.Xa, uptimeMillis);
            }
        } else if (mx()) {
            nu();
        }
        nv();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Xp = false;
        removeCallbacks(this.WZ);
        removeCallbacks(this.Xa);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.Xa);
        } else if (motionEvent.getAction() == 1) {
            nu();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        an anVar = this.jb;
        if (anVar == null || !eY(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (anVar.aB() == 4) {
                return true;
            }
            this.Xn.e(anVar);
            return true;
        } else if (keyCode == 89) {
            this.Xn.d(anVar);
            return true;
        } else if (keyEvent.getRepeatCount() != 0) {
            return true;
        } else {
            if (keyCode == 79 || keyCode == 85) {
                h(anVar);
                return true;
            } else if (keyCode == 87) {
                this.Xn.c(anVar);
                return true;
            } else if (keyCode == 88) {
                this.Xn.b(anVar);
                return true;
            } else if (keyCode == 126) {
                i(anVar);
                return true;
            } else if (keyCode != 127) {
                return true;
            } else {
                j(anVar);
                return true;
            }
        }
    }

    private boolean nE() {
        an anVar = this.jb;
        if (anVar == null || anVar.aB() == 4 || this.jb.aB() == 1 || !this.jb.aE()) {
            return false;
        }
        return true;
    }

    private void h(an anVar) {
        int aB = anVar.aB();
        if (aB == 1 || aB == 4 || !anVar.aE()) {
            i(anVar);
        } else {
            j(anVar);
        }
    }

    /* access modifiers changed from: private */
    public void i(an anVar) {
        int aB = anVar.aB();
        if (aB == 1) {
            this.Xn.a(anVar);
        } else if (aB == 4) {
            b(anVar, anVar.aL(), -9223372036854775807L);
        }
        this.Xn.a(anVar, true);
    }

    /* access modifiers changed from: private */
    public void j(an anVar) {
        this.Xn.a(anVar, false);
    }

    private static boolean a(ba baVar, ba.c cVar) {
        if (baVar.cP() > 100) {
            return false;
        }
        int cP = baVar.cP();
        for (int i = 0; i < cP; i++) {
            if (baVar.a(i, cVar).fH == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    private static int a(TypedArray typedArray, int i) {
        return typedArray.getInt(R.styleable.AppLovinPlayerControlView_al_repeat_toggle_modes, i);
    }

    private final class b implements View.OnClickListener, an.d, k.a {
        public /* synthetic */ void A(boolean z) {
            an.d.CC.$default$A(this, z);
        }

        public /* synthetic */ void Z(int i) {
            an.d.CC.$default$Z(this, i);
        }

        public /* synthetic */ void a(ab abVar, int i) {
            an.d.CC.$default$a((an.d) this, abVar, i);
        }

        public /* synthetic */ void a(ac acVar) {
            an.d.CC.$default$a((an.d) this, acVar);
        }

        public /* synthetic */ void a(ak akVar) {
            an.d.CC.$default$a((an.d) this, akVar);
        }

        public /* synthetic */ void a(an.e eVar, an.e eVar2, int i) {
            an.d.CC.$default$a(this, eVar, eVar2, i);
        }

        public /* synthetic */ void a(com.applovin.exoplayer2.g.a aVar) {
            an.d.CC.$default$a((an.d) this, aVar);
        }

        public /* synthetic */ void a(ad adVar, com.applovin.exoplayer2.j.h hVar) {
            an.d.CC.$default$a((an.d) this, adVar, hVar);
        }

        public /* synthetic */ void a(o oVar) {
            an.d.CC.$default$a((an.d) this, oVar);
        }

        public /* synthetic */ void a(com.applovin.exoplayer2.o oVar) {
            an.d.CC.$default$a((an.d) this, oVar);
        }

        public /* synthetic */ void aa(int i) {
            an.d.CC.$default$aa(this, i);
        }

        public /* synthetic */ void ab(int i) {
            an.d.CC.$default$ab(this, i);
        }

        public /* synthetic */ void ac(int i) {
            an.b.CC.$default$ac(this, i);
        }

        public /* synthetic */ void b(ak akVar) {
            an.d.CC.$default$b((an.d) this, akVar);
        }

        public /* synthetic */ void b(am amVar) {
            an.d.CC.$default$b((an.d) this, amVar);
        }

        public /* synthetic */ void b(ba baVar, int i) {
            an.d.CC.$default$b(this, baVar, i);
        }

        public /* synthetic */ void cD() {
            an.b.CC.$default$cD(this);
        }

        public /* synthetic */ void cE() {
            an.d.CC.$default$cE(this);
        }

        public /* synthetic */ void d(an.a aVar) {
            an.d.CC.$default$d(this, aVar);
        }

        public /* synthetic */ void d(boolean z, int i) {
            an.b.CC.$default$d(this, z, i);
        }

        public /* synthetic */ void e(int i, boolean z) {
            an.d.CC.$default$e((an.d) this, i, z);
        }

        public /* synthetic */ void e(List list) {
            an.d.CC.$default$e(this, list);
        }

        public /* synthetic */ void e(boolean z, int i) {
            an.d.CC.$default$e((an.d) this, z, i);
        }

        public /* synthetic */ void f(int i, int i2) {
            an.d.CC.$default$f(this, i, i2);
        }

        public /* synthetic */ void g(float f) {
            an.d.CC.$default$g(this, f);
        }

        public /* synthetic */ void w(boolean z) {
            an.d.CC.$default$w(this, z);
        }

        public /* synthetic */ void x(boolean z) {
            an.b.CC.$default$x(this, z);
        }

        public /* synthetic */ void y(boolean z) {
            an.d.CC.$default$y(this, z);
        }

        public /* synthetic */ void z(boolean z) {
            an.d.CC.$default$z(this, z);
        }

        private b() {
        }

        public void a(an anVar, an.c cVar) {
            if (cVar.b(4, 5)) {
                f.this.nw();
            }
            if (cVar.b(4, 5, 7)) {
                f.this.nB();
            }
            if (cVar.X(8)) {
                f.this.ny();
            }
            if (cVar.X(9)) {
                f.this.nz();
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                f.this.nx();
            }
            if (cVar.b(11, 0)) {
                f.this.nA();
            }
        }

        public void a(k kVar, long j) {
            boolean unused = f.this.WG = true;
            if (f.this.WX != null) {
                f.this.WX.setText(ai.a(f.this.Wu, f.this.Wv, j));
            }
        }

        public void b(k kVar, long j) {
            if (f.this.WX != null) {
                f.this.WX.setText(ai.a(f.this.Wu, f.this.Wv, j));
            }
        }

        public void a(k kVar, long j, boolean z) {
            boolean unused = f.this.WG = false;
            if (!z && f.this.jb != null) {
                f fVar = f.this;
                fVar.b(fVar.jb, j);
            }
        }

        public void onClick(View view) {
            an j = f.this.jb;
            if (j != null) {
                if (f.this.WO == view) {
                    f.this.Xn.c(j);
                } else if (f.this.WN == view) {
                    f.this.Xn.b(j);
                } else if (f.this.WR == view) {
                    if (j.aB() != 4) {
                        f.this.Xn.e(j);
                    }
                } else if (f.this.WS == view) {
                    f.this.Xn.d(j);
                } else if (f.this.WP == view) {
                    f.this.i(j);
                } else if (f.this.WQ == view) {
                    f.this.j(j);
                } else if (f.this.WT == view) {
                    f.this.Xn.a(j, com.applovin.exoplayer2.l.ab.L(j.aF(), f.this.Xu));
                } else if (f.this.WU == view) {
                    f.this.Xn.b(j, !j.aG());
                }
            }
        }
    }

    private static final class a {
        public static boolean g(View view) {
            return view.isAccessibilityFocused();
        }
    }
}
