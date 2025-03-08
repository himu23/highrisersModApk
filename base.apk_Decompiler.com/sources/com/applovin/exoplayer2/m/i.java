package com.applovin.exoplayer2.m;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import androidx.work.Data;
import com.applovin.exoplayer2.l.n;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class i extends GLSurfaceView implements k {
    private final a aeu;

    @Deprecated
    public k getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(j jVar) {
        this.aeu.setOutputBuffer(jVar);
    }

    private static final class a implements GLSurfaceView.Renderer {
        private static final float[] aev = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        private static final float[] aew = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        private static final float[] aex = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        private static final String[] aey = {"y_tex", "u_tex", "v_tex"};
        private static final FloatBuffer aez = n.a(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        private final GLSurfaceView aeA;
        private final int[] aeB;
        private final int[] aeC;
        private final int[] aeD;
        private final int[] aeE;
        private final AtomicReference<j> aeF;
        private final FloatBuffer[] aeG;
        private int aeH;
        private int aeI;
        private j aeJ;

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            int e = n.e("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.aeH = e;
            GLES20.glUseProgram(e);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.aeH, "in_pos");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, aez);
            this.aeC[0] = GLES20.glGetAttribLocation(this.aeH, "in_tc_y");
            GLES20.glEnableVertexAttribArray(this.aeC[0]);
            this.aeC[1] = GLES20.glGetAttribLocation(this.aeH, "in_tc_u");
            GLES20.glEnableVertexAttribArray(this.aeC[1]);
            this.aeC[2] = GLES20.glGetAttribLocation(this.aeH, "in_tc_v");
            GLES20.glEnableVertexAttribArray(this.aeC[2]);
            n.oX();
            this.aeI = GLES20.glGetUniformLocation(this.aeH, "mColorConversion");
            n.oX();
            qv();
            n.oX();
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        public void onDrawFrame(GL10 gl10) {
            j andSet = this.aeF.getAndSet((Object) null);
            if (andSet != null || this.aeJ != null) {
                if (andSet != null) {
                    j jVar = this.aeJ;
                    if (jVar != null) {
                        jVar.release();
                    }
                    this.aeJ = andSet;
                }
                j jVar2 = (j) com.applovin.exoplayer2.l.a.checkNotNull(this.aeJ);
                float[] fArr = aew;
                int i = jVar2.aeM;
                if (i == 1) {
                    fArr = aev;
                } else if (i == 3) {
                    fArr = aex;
                }
                GLES20.glUniformMatrix3fv(this.aeI, 1, false, fArr, 0);
                int[] iArr = (int[]) com.applovin.exoplayer2.l.a.checkNotNull(jVar2.aeL);
                ByteBuffer[] byteBufferArr = (ByteBuffer[]) com.applovin.exoplayer2.l.a.checkNotNull(jVar2.aeK);
                int i2 = 0;
                while (i2 < 3) {
                    int i3 = i2 == 0 ? jVar2.height : (jVar2.height + 1) / 2;
                    GLES20.glActiveTexture(33984 + i2);
                    GLES20.glBindTexture(3553, this.aeB[i2]);
                    GLES20.glPixelStorei(3317, 1);
                    GLES20.glTexImage2D(3553, 0, 6409, iArr[i2], i3, 0, 6409, 5121, byteBufferArr[i2]);
                    i2++;
                }
                int[] iArr2 = new int[3];
                int i4 = jVar2.dE;
                iArr2[0] = i4;
                int i5 = (i4 + 1) / 2;
                iArr2[2] = i5;
                iArr2[1] = i5;
                for (int i6 = 0; i6 < 3; i6++) {
                    if (this.aeD[i6] != iArr2[i6] || this.aeE[i6] != iArr[i6]) {
                        com.applovin.exoplayer2.l.a.checkState(iArr[i6] != 0);
                        float f = ((float) iArr2[i6]) / ((float) iArr[i6]);
                        this.aeG[i6] = n.a(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f, 0.0f, f, 1.0f});
                        GLES20.glVertexAttribPointer(this.aeC[i6], 2, 5126, false, 0, this.aeG[i6]);
                        this.aeD[i6] = iArr2[i6];
                        this.aeE[i6] = iArr[i6];
                    }
                }
                GLES20.glClear(16384);
                GLES20.glDrawArrays(5, 0, 4);
                n.oX();
            }
        }

        public void setOutputBuffer(j jVar) {
            j andSet = this.aeF.getAndSet(jVar);
            if (andSet != null) {
                andSet.release();
            }
            this.aeA.requestRender();
        }

        private void qv() {
            GLES20.glGenTextures(3, this.aeB, 0);
            for (int i = 0; i < 3; i++) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.aeH, aey[i]), i);
                GLES20.glActiveTexture(33984 + i);
                GLES20.glBindTexture(3553, this.aeB[i]);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            n.oX();
        }
    }
}
