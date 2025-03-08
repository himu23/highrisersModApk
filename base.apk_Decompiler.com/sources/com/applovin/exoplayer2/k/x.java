package com.applovin.exoplayer2.k;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.exoplayer2.l.ai;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public final class x extends e {
    private InputStream Zi;
    private long Zj;
    private boolean Zk;
    private AssetFileDescriptor Zr;
    private final Resources abl;
    private final String abm;
    private Uri ef;

    public Uri getUri() {
        return this.ef;
    }

    public static class a extends j {
        public a(String str, Throwable th, int i) {
            super(str, th, i);
        }
    }

    public x(Context context) {
        super(false);
        this.abl = context.getResources();
        this.abm = context.getPackageName();
    }

    public long a(l lVar) throws a {
        int i;
        String str;
        l lVar2 = lVar;
        Uri uri = lVar2.ef;
        this.ef = uri;
        if (TextUtils.equals("rawresource", uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                i = Integer.parseInt((String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.", (Throwable) null, 1004);
            }
        } else if (TextUtils.equals("android.resource", uri.getScheme())) {
            String str2 = (String) com.applovin.exoplayer2.l.a.checkNotNull(uri.getPath());
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            String host = uri.getHost();
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + ":";
            }
            sb.append(str);
            sb.append(str2);
            i = this.abl.getIdentifier(sb.toString(), "raw", this.abm);
            if (i == 0) {
                throw new a("Resource not found.", (Throwable) null, 2005);
            }
        } else {
            throw new a("URI must either use scheme rawresource or android.resource", (Throwable) null, 1004);
        }
        b(lVar);
        try {
            AssetFileDescriptor openRawResourceFd = this.abl.openRawResourceFd(i);
            this.Zr = openRawResourceFd;
            if (openRawResourceFd != null) {
                long length = openRawResourceFd.getLength();
                FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                this.Zi = fileInputStream;
                int i2 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i2 != 0) {
                    try {
                        if (lVar2.uc > length) {
                            throw new a((String) null, (Throwable) null, 2008);
                        }
                    } catch (a e) {
                        throw e;
                    } catch (IOException e2) {
                        throw new a((String) null, e2, 2000);
                    }
                }
                long startOffset = openRawResourceFd.getStartOffset();
                long skip = fileInputStream.skip(lVar2.uc + startOffset) - startOffset;
                if (skip == lVar2.uc) {
                    if (i2 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        if (channel.size() == 0) {
                            this.Zj = -1;
                        } else {
                            long size = channel.size() - channel.position();
                            this.Zj = size;
                            if (size < 0) {
                                throw new a((String) null, (Throwable) null, 2008);
                            }
                        }
                    } else {
                        long j = length - skip;
                        this.Zj = j;
                        if (j < 0) {
                            throw new j(2008);
                        }
                    }
                    if (lVar2.wC != -1) {
                        long j2 = this.Zj;
                        this.Zj = j2 == -1 ? lVar2.wC : Math.min(j2, lVar2.wC);
                    }
                    this.Zk = true;
                    c(lVar);
                    return lVar2.wC != -1 ? lVar2.wC : this.Zj;
                }
                throw new a((String) null, (Throwable) null, 2008);
            }
            throw new a("Resource is compressed: " + uri, (Throwable) null, 2000);
        } catch (Resources.NotFoundException e3) {
            throw new a((String) null, e3, 2005);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.Zj;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new a((String) null, e, 2000);
            }
        }
        int read = ((InputStream) ai.R(this.Zi)).read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.Zj;
            if (j2 != -1) {
                this.Zj = j2 - ((long) read);
            }
            fe(read);
            return read;
        } else if (this.Zj == -1) {
            return -1;
        } else {
            throw new a("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
    }

    public void close() throws a {
        this.ef = null;
        try {
            InputStream inputStream = this.Zi;
            if (inputStream != null) {
                inputStream.close();
            }
            this.Zi = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.Zr;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.Zr = null;
                if (this.Zk) {
                    this.Zk = false;
                    oe();
                }
            } catch (IOException e) {
                throw new a((String) null, e, 2000);
            } catch (Throwable th) {
                this.Zr = null;
                if (this.Zk) {
                    this.Zk = false;
                    oe();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new a((String) null, e2, 2000);
        } catch (Throwable th2) {
            this.Zi = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.Zr;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.Zr = null;
                if (this.Zk) {
                    this.Zk = false;
                    oe();
                }
                throw th2;
            } catch (IOException e3) {
                throw new a((String) null, e3, 2000);
            } catch (Throwable th3) {
                this.Zr = null;
                if (this.Zk) {
                    this.Zk = false;
                    oe();
                }
                throw th3;
            }
        }
    }
}
