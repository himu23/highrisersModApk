package com.unity3d.ads.core.domain;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gl.EglCore;
import com.unity3d.ads.gl.OffscreenSurface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidOpenGLRendererInfo;", "Lcom/unity3d/ads/core/domain/GetOpenGLRendererInfo;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "(Lcom/unity3d/ads/core/data/repository/SessionRepository;)V", "invoke", "Lcom/google/protobuf/ByteString;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidOpenGLRendererInfo.kt */
public final class GetAndroidOpenGLRendererInfo implements GetOpenGLRendererInfo {
    private final SessionRepository sessionRepository;

    public GetAndroidOpenGLRendererInfo(SessionRepository sessionRepository2) {
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        this.sessionRepository = sessionRepository2;
    }

    public ByteString invoke() {
        if (this.sessionRepository.getFeatureFlags().getOpenglGpuEnabled()) {
            EglCore eglCore = new EglCore((EGLContext) null, 2);
            OffscreenSurface offscreenSurface = new OffscreenSurface(eglCore, 1, 1);
            offscreenSurface.makeCurrent();
            String glGetString = GLES20.glGetString(7937);
            Intrinsics.checkNotNullExpressionValue(glGetString, "renderer");
            byte[] bytes = glGetString.getBytes(Charsets.ISO_8859_1);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            ByteString copyFrom = ByteString.copyFrom(bytes);
            offscreenSurface.release();
            eglCore.release();
            Intrinsics.checkNotNullExpressionValue(copyFrom, "{\n            // We need…dererByteString\n        }");
            return copyFrom;
        }
        ByteString empty = ByteString.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "{\n            ByteString.empty()\n        }");
        return empty;
    }
}
