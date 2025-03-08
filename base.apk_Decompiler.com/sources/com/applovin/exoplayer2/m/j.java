package com.applovin.exoplayer2.m;

import com.applovin.exoplayer2.c.i;
import java.nio.ByteBuffer;

public class j extends i {
    private final i.a<j> Os;
    public ByteBuffer[] aeK;
    public int[] aeL;
    public int aeM;
    public int dE;
    public int height;

    public void release() {
        this.Os.releaseOutputBuffer(this);
    }
}
