package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import com.fyber.inneractive.sdk.player.exoplayer2.i;
import java.util.Collections;
import java.util.List;

public final class a extends c {
    public final List<C0117a> b;
    public final List<C0117a> c;
    public final List<C0117a> d;
    public final i e;
    public final List<i> f;

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a  reason: collision with other inner class name */
    public static final class C0117a {
        public final String a;
        public final i b;

        public C0117a(String str, i iVar) {
            this.a = str;
            this.b = iVar;
        }
    }

    public a(String str, List<C0117a> list, List<C0117a> list2, List<C0117a> list3, i iVar, List<i> list4) {
        super(str);
        this.b = Collections.unmodifiableList(list);
        this.c = Collections.unmodifiableList(list2);
        this.d = Collections.unmodifiableList(list3);
        this.e = iVar;
        this.f = list4 != null ? Collections.unmodifiableList(list4) : null;
    }
}
