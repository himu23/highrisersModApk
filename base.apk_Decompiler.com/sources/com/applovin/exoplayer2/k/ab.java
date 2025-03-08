package com.applovin.exoplayer2.k;

import android.net.Uri;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

public final class ab extends e {
    private boolean Zk;
    private final int abA;
    private final byte[] abB;
    private final DatagramPacket abC;
    private DatagramSocket abD;
    private MulticastSocket abE;
    private InetAddress abF;
    private InetSocketAddress abG;
    private int abH;
    private Uri ef;

    public Uri getUri() {
        return this.ef;
    }

    public static final class a extends j {
        public a(Throwable th, int i) {
            super(th, i);
        }
    }

    public ab() {
        this(2000);
    }

    public ab(int i) {
        this(i, GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY);
    }

    public ab(int i, int i2) {
        super(true);
        this.abA = i2;
        byte[] bArr = new byte[i];
        this.abB = bArr;
        this.abC = new DatagramPacket(bArr, 0, i);
    }

    public long a(l lVar) throws a {
        Uri uri = lVar.ef;
        this.ef = uri;
        String host = uri.getHost();
        int port = this.ef.getPort();
        b(lVar);
        try {
            this.abF = InetAddress.getByName(host);
            this.abG = new InetSocketAddress(this.abF, port);
            if (this.abF.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.abG);
                this.abE = multicastSocket;
                multicastSocket.joinGroup(this.abF);
                this.abD = this.abE;
            } else {
                this.abD = new DatagramSocket(this.abG);
            }
            this.abD.setSoTimeout(this.abA);
            this.Zk = true;
            c(lVar);
            return -1;
        } catch (SecurityException e) {
            throw new a(e, 2006);
        } catch (IOException e2) {
            throw new a(e2, 2001);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        if (this.abH == 0) {
            try {
                this.abD.receive(this.abC);
                int length = this.abC.getLength();
                this.abH = length;
                fe(length);
            } catch (SocketTimeoutException e) {
                throw new a(e, 2002);
            } catch (IOException e2) {
                throw new a(e2, 2001);
            }
        }
        int length2 = this.abC.getLength();
        int i3 = this.abH;
        int min = Math.min(i3, i2);
        System.arraycopy(this.abB, length2 - i3, bArr, i, min);
        this.abH -= min;
        return min;
    }

    public void close() {
        this.ef = null;
        MulticastSocket multicastSocket = this.abE;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.abF);
            } catch (IOException unused) {
            }
            this.abE = null;
        }
        DatagramSocket datagramSocket = this.abD;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.abD = null;
        }
        this.abF = null;
        this.abG = null;
        this.abH = 0;
        if (this.Zk) {
            this.Zk = false;
            oe();
        }
    }
}
