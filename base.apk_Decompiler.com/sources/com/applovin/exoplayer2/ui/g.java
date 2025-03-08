package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.ak;
import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.i;
import com.applovin.exoplayer2.j.h;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.k;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.m.o;
import com.applovin.exoplayer2.ui.AspectRatioFrameLayout;
import com.applovin.exoplayer2.ui.f;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class g extends FrameLayout {
    private final a XH;
    private final AspectRatioFrameLayout XI;
    /* access modifiers changed from: private */
    public final View XJ;
    private final View XK;
    private final boolean XL;
    private final ImageView XM;
    /* access modifiers changed from: private */
    public final SubtitleView XN;
    private final View XO;
    private final TextView XP;
    private final f XQ;
    private final FrameLayout XR;
    private final FrameLayout XS;
    private boolean XT;
    private f.d XU;
    private boolean XV;
    private Drawable XW;
    private int XX;
    private boolean XY;
    private k<? super ak> XZ;
    private CharSequence Ya;
    private int Yb;
    private boolean Yc;
    /* access modifiers changed from: private */
    public boolean Yd;
    private boolean Ye;
    /* access modifiers changed from: private */
    public int Yf;
    private boolean Yg;
    /* access modifiers changed from: private */
    public an jb;

    private boolean fa(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    public boolean getControllerAutoShow() {
        return this.Yc;
    }

    public boolean getControllerHideOnTouch() {
        return this.Ye;
    }

    public int getControllerShowTimeoutMs() {
        return this.Yb;
    }

    public Drawable getDefaultArtwork() {
        return this.XW;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.XS;
    }

    public an getPlayer() {
        return this.jb;
    }

    public SubtitleView getSubtitleView() {
        return this.XN;
    }

    public boolean getUseArtwork() {
        return this.XV;
    }

    public boolean getUseController() {
        return this.XT;
    }

    public View getVideoSurfaceView() {
        return this.XK;
    }

    public void setControllerAutoShow(boolean z) {
        this.Yc = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.Yd = z;
    }

    public g(Context context) {
        this(context, (AttributeSet) null);
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        int i7;
        boolean z6;
        boolean z7;
        boolean z8;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        a aVar = new a();
        this.XH = aVar;
        if (isInEditMode()) {
            this.XI = null;
            this.XJ = null;
            this.XK = null;
            this.XL = false;
            this.XM = null;
            this.XN = null;
            this.XO = null;
            this.XP = null;
            this.XQ = null;
            this.XR = null;
            this.XS = null;
            ImageView imageView = new ImageView(context2);
            if (ai.acV >= 23) {
                a(getResources(), imageView);
            } else {
                b(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i8 = R.layout.applovin_exo_player_view;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.AppLovinPlayerView, i, 0);
            try {
                boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.AppLovinPlayerView_al_shutter_background_color);
                int color = obtainStyledAttributes.getColor(R.styleable.AppLovinPlayerView_al_shutter_background_color, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerView_al_player_layout_id, i8);
                boolean z9 = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerView_al_default_artwork, 0);
                boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_use_controller, true);
                int i9 = obtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_surface_type, 1);
                int i10 = obtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_resize_mode, 0);
                int i11 = obtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_show_timeout, 5000);
                boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_hide_on_touch, true);
                int i12 = resourceId;
                boolean z12 = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_auto_show, true);
                i6 = obtainStyledAttributes.getInteger(R.styleable.AppLovinPlayerView_al_show_buffering, 0);
                int i13 = i10;
                this.XY = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_keep_content_on_player_reset, this.XY);
                boolean z13 = obtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                z4 = z11;
                z6 = z12;
                i7 = i13;
                z = z10;
                i3 = resourceId2;
                z2 = z9;
                i4 = color;
                z3 = hasValue;
                i5 = i9;
                boolean z14 = z13;
                i8 = i12;
                i2 = i11;
                z5 = z14;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i2 = 5000;
            z6 = true;
            i7 = 0;
            i6 = 0;
            z5 = true;
            z4 = true;
            i5 = 1;
            z3 = false;
            i4 = 0;
            z2 = true;
            i3 = 0;
            z = true;
        }
        LayoutInflater.from(context).inflate(i8, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.al_exo_content_frame);
        this.XI = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            a(aspectRatioFrameLayout, i7);
        }
        View findViewById = findViewById(R.id.al_exo_shutter);
        this.XJ = findViewById;
        if (findViewById != null && z3) {
            findViewById.setBackgroundColor(i4);
        }
        if (aspectRatioFrameLayout == null || i5 == 0) {
            this.XK = null;
            z7 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i5 == 2) {
                this.XK = new TextureView(context2);
            } else if (i5 == 3) {
                try {
                    this.XK = (View) Class.forName("com.applovin.exoplayer2.m.a.i").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context2});
                    z8 = true;
                    this.XK.setLayoutParams(layoutParams);
                    this.XK.setOnClickListener(aVar);
                    this.XK.setClickable(false);
                    aspectRatioFrameLayout.addView(this.XK, 0);
                    z7 = z8;
                } catch (Exception e) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                }
            } else if (i5 != 4) {
                this.XK = new SurfaceView(context2);
            } else {
                try {
                    this.XK = (View) Class.forName("com.applovin.exoplayer2.m.i").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context2});
                } catch (Exception e2) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            }
            z8 = false;
            this.XK.setLayoutParams(layoutParams);
            this.XK.setOnClickListener(aVar);
            this.XK.setClickable(false);
            aspectRatioFrameLayout.addView(this.XK, 0);
            z7 = z8;
        }
        this.XL = z7;
        this.XR = (FrameLayout) findViewById(R.id.al_exo_ad_overlay);
        this.XS = (FrameLayout) findViewById(R.id.al_exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.al_exo_artwork);
        this.XM = imageView2;
        this.XV = z2 && imageView2 != null;
        if (i3 != 0) {
            this.XW = ContextCompat.getDrawable(getContext(), i3);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.al_exo_subtitles);
        this.XN = subtitleView;
        if (subtitleView != null) {
            subtitleView.nX();
            subtitleView.nW();
        }
        View findViewById2 = findViewById(R.id.al_exo_buffering);
        this.XO = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.XX = i6;
        TextView textView = (TextView) findViewById(R.id.al_exo_error_message);
        this.XP = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        f fVar = (f) findViewById(R.id.al_exo_controller);
        View findViewById3 = findViewById(R.id.al_exo_controller_placeholder);
        if (fVar != null) {
            this.XQ = fVar;
        } else if (findViewById3 != null) {
            f fVar2 = new f(context2, (AttributeSet) null, 0, attributeSet2);
            this.XQ = fVar2;
            fVar2.setId(R.id.al_exo_controller);
            fVar2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(fVar2, indexOfChild);
        } else {
            this.XQ = null;
        }
        f fVar3 = this.XQ;
        this.Yb = fVar3 != null ? i2 : 0;
        this.Ye = z4;
        this.Yc = z6;
        this.Yd = z5;
        this.XT = z && fVar3 != null;
        nG();
        nQ();
        f fVar4 = this.XQ;
        if (fVar4 != null) {
            fVar4.a((f.d) aVar);
        }
    }

    public void setPlayer(an anVar) {
        com.applovin.exoplayer2.l.a.checkState(Looper.myLooper() == Looper.getMainLooper());
        com.applovin.exoplayer2.l.a.checkArgument(anVar == null || anVar.az() == Looper.getMainLooper());
        an anVar2 = this.jb;
        if (anVar2 != anVar) {
            if (anVar2 != null) {
                anVar2.b((an.d) this.XH);
                if (anVar2.n(26)) {
                    View view = this.XK;
                    if (view instanceof TextureView) {
                        anVar2.b((TextureView) view);
                    } else if (view instanceof SurfaceView) {
                        anVar2.b((SurfaceView) view);
                    }
                }
            }
            SubtitleView subtitleView = this.XN;
            if (subtitleView != null) {
                subtitleView.setCues((List<com.applovin.exoplayer2.i.a>) null);
            }
            this.jb = anVar;
            if (nH()) {
                this.XQ.setPlayer(anVar);
            }
            nO();
            nP();
            aq(true);
            if (anVar != null) {
                if (anVar.n(26)) {
                    View view2 = this.XK;
                    if (view2 instanceof TextureView) {
                        anVar.a((TextureView) view2);
                    } else if (view2 instanceof SurfaceView) {
                        anVar.a((SurfaceView) view2);
                    }
                    nL();
                }
                if (this.XN != null && anVar.n(27)) {
                    this.XN.setCues(anVar.bd());
                }
                anVar.a((an.d) this.XH);
                ao(false);
                return;
            }
            nG();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.XK;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        com.applovin.exoplayer2.l.a.N(this.XI);
        this.XI.setResizeMode(i);
    }

    public int getResizeMode() {
        com.applovin.exoplayer2.l.a.N(this.XI);
        return this.XI.getResizeMode();
    }

    public void setUseArtwork(boolean z) {
        com.applovin.exoplayer2.l.a.checkState(!z || this.XM != null);
        if (this.XV != z) {
            this.XV = z;
            aq(false);
        }
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.XW != drawable) {
            this.XW = drawable;
            aq(false);
        }
    }

    public void setUseController(boolean z) {
        com.applovin.exoplayer2.l.a.checkState(!z || this.XQ != null);
        if (this.XT != z) {
            this.XT = z;
            if (nH()) {
                this.XQ.setPlayer(this.jb);
            } else {
                f fVar = this.XQ;
                if (fVar != null) {
                    fVar.nt();
                    this.XQ.setPlayer((an) null);
                }
            }
            nQ();
        }
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.XJ;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.XY != z) {
            this.XY = z;
            aq(false);
        }
    }

    public void setShowBuffering(int i) {
        if (this.XX != i) {
            this.XX = i;
            nO();
        }
    }

    public void setErrorMessageProvider(k<? super ak> kVar) {
        if (this.XZ != kVar) {
            this.XZ = kVar;
            nP();
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        com.applovin.exoplayer2.l.a.checkState(this.XP != null);
        this.Ya = charSequence;
        nP();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        an anVar = this.jb;
        if (anVar != null && anVar.aP()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean fa = fa(keyEvent.getKeyCode());
        if (fa && nH() && !this.XQ.mx()) {
            ao(true);
            return true;
        } else if (a(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            ao(true);
            return true;
        } else {
            if (fa && nH()) {
                ao(true);
            }
            return false;
        }
    }

    public boolean a(KeyEvent keyEvent) {
        return nH() && this.XQ.a(keyEvent);
    }

    public void nF() {
        ap(nK());
    }

    public void nG() {
        f fVar = this.XQ;
        if (fVar != null) {
            fVar.nt();
        }
    }

    public void setControllerShowTimeoutMs(int i) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.Yb = i;
        if (this.XQ.mx()) {
            nF();
        }
    }

    public void setControllerHideOnTouch(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.Ye = z;
        nQ();
    }

    public void setControllerVisibilityListener(f.d dVar) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        f.d dVar2 = this.XU;
        if (dVar2 != dVar) {
            if (dVar2 != null) {
                this.XQ.b(dVar2);
            }
            this.XU = dVar;
            if (dVar != null) {
                this.XQ.a(dVar);
            }
        }
    }

    @Deprecated
    public void setControlDispatcher(i iVar) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setControlDispatcher(iVar);
    }

    public void setShowRewindButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowRewindButton(z);
    }

    public void setShowFastForwardButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowFastForwardButton(z);
    }

    public void setShowPreviousButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowPreviousButton(z);
    }

    public void setShowNextButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowNextButton(z);
    }

    public void setRepeatToggleModes(int i) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowMultiWindowTimeBar(z);
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.a aVar) {
        com.applovin.exoplayer2.l.a.N(this.XI);
        this.XI.setAspectRatioListener(aVar);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!nH() || this.jb == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Yg = true;
            return true;
        } else if (action != 1 || !this.Yg) {
            return false;
        } else {
            this.Yg = false;
            performClick();
            return true;
        }
    }

    public boolean performClick() {
        super.performClick();
        return nJ();
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!nH() || this.jb == null) {
            return false;
        }
        ao(true);
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(AspectRatioFrameLayout aspectRatioFrameLayout, float f) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f);
        }
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) com.applovin.exoplayer2.l.a.q(this.XR, "exo_ad_overlay must be present for ad playback");
    }

    public List<a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.XS;
        if (frameLayout != null) {
            arrayList.add(new a(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        f fVar = this.XQ;
        if (fVar != null) {
            arrayList.add(new a(fVar, 0));
        }
        return s.d(arrayList);
    }

    private boolean nH() {
        if (!this.XT) {
            return false;
        }
        com.applovin.exoplayer2.l.a.N(this.XQ);
        return true;
    }

    private boolean nI() {
        if (!this.XV) {
            return false;
        }
        com.applovin.exoplayer2.l.a.N(this.XM);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean nJ() {
        if (!nH() || this.jb == null) {
            return false;
        }
        if (!this.XQ.mx()) {
            ao(true);
        } else if (this.Ye) {
            this.XQ.nt();
        }
        return true;
    }

    private void ao(boolean z) {
        if ((!aP() || !this.Yd) && nH()) {
            boolean z2 = this.XQ.mx() && this.XQ.getShowTimeoutMs() <= 0;
            boolean nK = nK();
            if (z || z2 || nK) {
                ap(nK);
            }
        }
    }

    private boolean nK() {
        an anVar = this.jb;
        if (anVar == null) {
            return true;
        }
        int aB = anVar.aB();
        if (!this.Yc || (aB != 1 && aB != 4 && this.jb.aE())) {
            return false;
        }
        return true;
    }

    private void ap(boolean z) {
        if (nH()) {
            this.XQ.setShowTimeoutMs(z ? 0 : this.Yb);
            this.XQ.show();
        }
    }

    /* access modifiers changed from: private */
    public boolean aP() {
        an anVar = this.jb;
        return anVar != null && anVar.aP() && this.jb.aE();
    }

    /* access modifiers changed from: private */
    public void aq(boolean z) {
        an anVar = this.jb;
        if (anVar != null && !anVar.aU().isEmpty()) {
            if (z && !this.XY) {
                nN();
            }
            h aV = anVar.aV();
            for (int i = 0; i < aV.fR; i++) {
                com.applovin.exoplayer2.j.g eU = aV.eU(i);
                if (eU != null) {
                    for (int i2 = 0; i2 < eU.kD(); i2++) {
                        if (u.ba(eU.dZ(i2).dz) == 2) {
                            nM();
                            return;
                        }
                    }
                    continue;
                }
            }
            nN();
            if (!nI() || (!b(anVar.aW()) && !b(this.XW))) {
                nM();
            }
        } else if (!this.XY) {
            nM();
            nN();
        }
    }

    /* access modifiers changed from: private */
    public void nL() {
        an anVar = this.jb;
        o aY = anVar != null ? anVar.aY() : o.afk;
        int i = aY.dE;
        int i2 = aY.height;
        int i3 = aY.afl;
        float f = 0.0f;
        float f2 = (i2 == 0 || i == 0) ? 0.0f : (((float) i) * aY.dH) / ((float) i2);
        View view = this.XK;
        if (view instanceof TextureView) {
            if (f2 > 0.0f && (i3 == 90 || i3 == 270)) {
                f2 = 1.0f / f2;
            }
            if (this.Yf != 0) {
                view.removeOnLayoutChangeListener(this.XH);
            }
            this.Yf = i3;
            if (i3 != 0) {
                this.XK.addOnLayoutChangeListener(this.XH);
            }
            a((TextureView) this.XK, this.Yf);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.XI;
        if (!this.XL) {
            f = f2;
        }
        a(aspectRatioFrameLayout, f);
    }

    private boolean b(ac acVar) {
        if (acVar.eX == null) {
            return false;
        }
        return b((Drawable) new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(acVar.eX, 0, acVar.eX.length)));
    }

    private boolean b(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                a(this.XI, ((float) intrinsicWidth) / ((float) intrinsicHeight));
                this.XM.setImageDrawable(drawable);
                this.XM.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private void nM() {
        ImageView imageView = this.XM;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.XM.setVisibility(4);
        }
    }

    private void nN() {
        View view = this.XJ;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r4.jb.aE() == false) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void nO() {
        /*
            r4 = this;
            android.view.View r0 = r4.XO
            if (r0 == 0) goto L_0x002b
            com.applovin.exoplayer2.an r0 = r4.jb
            r1 = 0
            if (r0 == 0) goto L_0x0020
            int r0 = r0.aB()
            r2 = 2
            if (r0 != r2) goto L_0x0020
            int r0 = r4.XX
            r3 = 1
            if (r0 == r2) goto L_0x0021
            if (r0 != r3) goto L_0x0020
            com.applovin.exoplayer2.an r0 = r4.jb
            boolean r0 = r0.aE()
            if (r0 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            android.view.View r0 = r4.XO
            if (r3 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = 8
        L_0x0028:
            r0.setVisibility(r1)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.g.nO():void");
    }

    /* access modifiers changed from: private */
    public void nP() {
        k<? super ak> kVar;
        TextView textView = this.XP;
        if (textView != null) {
            CharSequence charSequence = this.Ya;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.XP.setVisibility(0);
                return;
            }
            an anVar = this.jb;
            ak ax = anVar != null ? anVar.ax() : null;
            if (ax == null || (kVar = this.XZ) == null) {
                this.XP.setVisibility(8);
                return;
            }
            this.XP.setText((CharSequence) kVar.k(ax).second);
            this.XP.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void nQ() {
        f fVar = this.XQ;
        String str = null;
        if (fVar == null || !this.XT) {
            setContentDescription((CharSequence) null);
        } else if (fVar.getVisibility() == 0) {
            if (this.Ye) {
                str = getResources().getString(R.string.al_exo_controls_hide);
            }
            setContentDescription(str);
        } else {
            setContentDescription(getResources().getString(R.string.al_exo_controls_show));
        }
    }

    /* access modifiers changed from: private */
    public void nR() {
        if (!aP() || !this.Yd) {
            ao(false);
        } else {
            nG();
        }
    }

    private static void a(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.applovin_exo_edit_mode_logo, (Resources.Theme) null));
        imageView.setBackgroundColor(resources.getColor(R.color.al_exo_edit_mode_background_color, (Resources.Theme) null));
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.applovin_exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R.color.al_exo_edit_mode_background_color));
    }

    private static void a(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    /* access modifiers changed from: private */
    public static void a(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (!(width == 0.0f || height == 0.0f || i == 0)) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate((float) i, f, f2);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    private final class a implements View.OnClickListener, View.OnLayoutChangeListener, an.d, f.d {
        private Object Yh;
        private final ba.a bI = new ba.a();

        public /* synthetic */ void A(boolean z) {
            an.d.CC.$default$A(this, z);
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

        public /* synthetic */ void a(an anVar, an.c cVar) {
            an.d.CC.$default$a((an.d) this, anVar, cVar);
        }

        public /* synthetic */ void a(com.applovin.exoplayer2.g.a aVar) {
            an.d.CC.$default$a((an.d) this, aVar);
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

        public /* synthetic */ void d(an.a aVar) {
            an.d.CC.$default$d(this, aVar);
        }

        public /* synthetic */ void d(boolean z, int i) {
            an.b.CC.$default$d(this, z, i);
        }

        public /* synthetic */ void e(int i, boolean z) {
            an.d.CC.$default$e((an.d) this, i, z);
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

        public a() {
        }

        public void e(List<com.applovin.exoplayer2.i.a> list) {
            if (g.this.XN != null) {
                g.this.XN.setCues(list);
            }
        }

        public void a(o oVar) {
            g.this.nL();
        }

        public void cE() {
            if (g.this.XJ != null) {
                g.this.XJ.setVisibility(4);
            }
        }

        public void a(ad adVar, h hVar) {
            an anVar = (an) com.applovin.exoplayer2.l.a.checkNotNull(g.this.jb);
            ba aX = anVar.aX();
            if (aX.isEmpty()) {
                this.Yh = null;
            } else if (!anVar.aU().isEmpty()) {
                this.Yh = aX.a(anVar.aK(), this.bI, true).ch;
            } else {
                Object obj = this.Yh;
                if (obj != null) {
                    int c = aX.c(obj);
                    if (c == -1 || anVar.aL() != aX.a(c, this.bI).cN) {
                        this.Yh = null;
                    } else {
                        return;
                    }
                }
            }
            g.this.aq(false);
        }

        public void Z(int i) {
            g.this.nO();
            g.this.nP();
            g.this.nR();
        }

        public void e(boolean z, int i) {
            g.this.nO();
            g.this.nR();
        }

        public void a(an.e eVar, an.e eVar2, int i) {
            if (g.this.aP() && g.this.Yd) {
                g.this.nG();
            }
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            g.a((TextureView) view, g.this.Yf);
        }

        public void onClick(View view) {
            boolean unused = g.this.nJ();
        }

        public void eZ(int i) {
            g.this.nQ();
        }
    }
}
