package com.applovin.exoplayer2.k;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.exoplayer2.l.ai;
import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.services.core.device.MimeTypes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class f extends e {
    private long Zj;
    private boolean Zk;
    private final ContentResolver Zq;
    private AssetFileDescriptor Zr;
    private FileInputStream Zs;
    private Uri ef;

    public Uri getUri() {
        return this.ef;
    }

    public static class b extends j {
        public b(IOException iOException, int i) {
            super((Throwable) iOException, i);
        }
    }

    public f(Context context) {
        super(false);
        this.Zq = context.getContentResolver();
    }

    public long a(l lVar) throws b {
        AssetFileDescriptor assetFileDescriptor;
        int i = 2000;
        try {
            Uri uri = lVar.ef;
            this.ef = uri;
            b(lVar);
            if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(lVar.ef.getScheme())) {
                Bundle bundle = new Bundle();
                if (ai.acV >= 31) {
                    a.E(bundle);
                }
                assetFileDescriptor = this.Zq.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptor = this.Zq.openAssetFileDescriptor(uri, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            }
            this.Zr = assetFileDescriptor;
            if (assetFileDescriptor != null) {
                long length = assetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
                this.Zs = fileInputStream;
                int i2 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i2 != 0) {
                    if (lVar.uc > length) {
                        throw new b((IOException) null, 2008);
                    }
                }
                long startOffset = assetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(lVar.uc + startOffset) - startOffset;
                if (skip == lVar.uc) {
                    if (i2 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.Zj = -1;
                        } else {
                            long position = size - channel.position();
                            this.Zj = position;
                            if (position < 0) {
                                throw new b((IOException) null, 2008);
                            }
                        }
                    } else {
                        long j = length - skip;
                        this.Zj = j;
                        if (j < 0) {
                            throw new b((IOException) null, 2008);
                        }
                    }
                    if (lVar.wC != -1) {
                        long j2 = this.Zj;
                        this.Zj = j2 == -1 ? lVar.wC : Math.min(j2, lVar.wC);
                    }
                    this.Zk = true;
                    c(lVar);
                    return lVar.wC != -1 ? lVar.wC : this.Zj;
                }
                throw new b((IOException) null, 2008);
            }
            throw new b(new IOException("Could not open file descriptor for: " + uri), 2000);
        } catch (b e) {
            throw e;
        } catch (IOException e2) {
            if (e2 instanceof FileNotFoundException) {
                i = 2005;
            }
            throw new b(e2, i);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws b {
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
                throw new b(e, 2000);
            }
        }
        int read = ((FileInputStream) ai.R(this.Zs)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.Zj;
        if (j2 != -1) {
            this.Zj = j2 - ((long) read);
        }
        fe(read);
        return read;
    }

    public void close() throws b {
        this.ef = null;
        try {
            FileInputStream fileInputStream = this.Zs;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.Zs = null;
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
                throw new b(e, 2000);
            } catch (Throwable th) {
                this.Zr = null;
                if (this.Zk) {
                    this.Zk = false;
                    oe();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new b(e2, 2000);
        } catch (Throwable th2) {
            this.Zs = null;
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
                throw new b(e3, 2000);
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

    private static final class a {
        public static void E(Bundle bundle) {
            bundle.putParcelable("android.provider.extra.MEDIA_CAPABILITIES", g$$ExternalSyntheticApiModelOutline0.m().addSupportedVideoMimeType(MimeTypes.VIDEO_H265).addSupportedHdrType("android.media.feature.hdr.dolby_vision").addSupportedHdrType("android.media.feature.hdr.hdr10").addSupportedHdrType("android.media.feature.hdr.hdr10_plus").addSupportedHdrType("android.media.feature.hdr.hlg").build());
        }
    }
}
