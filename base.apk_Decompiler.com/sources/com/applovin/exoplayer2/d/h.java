package com.applovin.exoplayer2.d;

import android.os.Looper;
import com.applovin.exoplayer2.d.f;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.v;
import com.google.android.gms.games.GamesStatusCodes;

public interface h {
    public static final h ti;
    @Deprecated
    public static final h tj;

    public interface a {
        public static final a tk = new h$a$$ExternalSyntheticLambda0();

        /* renamed from: com.applovin.exoplayer2.d.h$a$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            static {
                a aVar = a.tk;
            }

            public static /* synthetic */ void hK() {
            }
        }

        void release();
    }

    a a(Looper looper, g.a aVar, v vVar);

    void aD();

    f b(Looper looper, g.a aVar, v vVar);

    int g(v vVar);

    void release();

    static {
        AnonymousClass1 r0 = new h() {
            public /* synthetic */ a a(Looper looper, g.a aVar, v vVar) {
                return CC.$default$a(this, looper, aVar, vVar);
            }

            public /* synthetic */ void aD() {
                CC.$default$aD(this);
            }

            public /* synthetic */ void release() {
                CC.$default$release(this);
            }

            public f b(Looper looper, g.a aVar, v vVar) {
                if (vVar.dC == null) {
                    return null;
                }
                return new l(new f.a(new t(1), GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER));
            }

            public int g(v vVar) {
                return vVar.dC != null ? 1 : 0;
            }
        };
        ti = r0;
        tj = r0;
    }

    /* renamed from: com.applovin.exoplayer2.d.h$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$aD(h _this) {
        }

        public static void $default$release(h _this) {
        }

        public static a $default$a(h _this, Looper looper, g.a aVar, v vVar) {
            return a.tk;
        }
    }
}
