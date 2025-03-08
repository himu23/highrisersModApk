package com.applovin.exoplayer2.k;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Predicate;
import com.applovin.exoplayer2.k.i;
import com.ironsource.m2;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface t extends i {
    public static final Predicate<String> aaJ = new t$$ExternalSyntheticLambda0();

    public interface b extends i.a {

        /* renamed from: com.applovin.exoplayer2.k.t$b$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        /* synthetic */ i of();

        t ox();
    }

    public static final class f {
        private final Map<String, String> aaO = new HashMap();
        private Map<String, String> aaP;

        public synchronized Map<String, String> oy() {
            if (this.aaP == null) {
                this.aaP = Collections.unmodifiableMap(new HashMap(this.aaO));
            }
            return this.aaP;
        }
    }

    /* renamed from: com.applovin.exoplayer2.k.t$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Predicate<String> predicate = t.aaJ;
        }

        public static /* synthetic */ boolean aP(String str) {
            if (str == null) {
                return false;
            }
            String lowerCase = Ascii.toLowerCase(str);
            if (!TextUtils.isEmpty(lowerCase)) {
                return (!lowerCase.contains(m2.h.K0) || lowerCase.contains("text/vtt")) && !lowerCase.contains("html") && !lowerCase.contains("xml");
            }
            return false;
        }
    }

    public static class c extends j {
        public final int bs;
        public final l tw;

        private static int J(int i, int i2) {
            if (i == 2000 && i2 == 1) {
                return 2001;
            }
            return i;
        }

        public static c a(IOException iOException, l lVar, int i) {
            int i2;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i2 = 2002;
            } else if (iOException instanceof InterruptedIOException) {
                i2 = 1004;
            } else {
                i2 = (message == null || !Ascii.toLowerCase(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
            }
            if (i2 == 2007) {
                return new a(iOException, lVar);
            }
            return new c(iOException, lVar, i2, i);
        }

        public c(l lVar, int i, int i2) {
            super(J(i, i2));
            this.tw = lVar;
            this.bs = i2;
        }

        public c(String str, l lVar, int i, int i2) {
            super(str, J(i, i2));
            this.tw = lVar;
            this.bs = i2;
        }

        public c(IOException iOException, l lVar, int i, int i2) {
            super((Throwable) iOException, J(i, i2));
            this.tw = lVar;
            this.bs = i2;
        }

        public c(String str, IOException iOException, l lVar, int i, int i2) {
            super(str, iOException, J(i, i2));
            this.tw = lVar;
            this.bs = i2;
        }
    }

    public static final class a extends c {
        public a(IOException iOException, l lVar) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, lVar, 2007, 1);
        }
    }

    public static final class d extends c {
        public final String aaK;

        public d(String str, l lVar) {
            super("Invalid content type: " + str, lVar, 2003, 1);
            this.aaK = str;
        }
    }

    public static final class e extends c {
        public final int aaC;
        public final String aaL;
        public final Map<String, List<String>> aaM;
        public final byte[] aaN;

        public e(int i, String str, IOException iOException, Map<String, List<String>> map, l lVar, byte[] bArr) {
            super("Response code: " + i, iOException, lVar, IronSourceConstants.IS_CALLBACK_LOAD_SUCCESS, 1);
            this.aaC = i;
            this.aaL = str;
            this.aaM = map;
            this.aaN = bArr;
        }
    }
}
