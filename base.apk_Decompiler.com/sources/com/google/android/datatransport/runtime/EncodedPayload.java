package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;

public final class EncodedPayload {
    private final byte[] bytes;
    private final Encoding encoding;

    public byte[] getBytes() {
        return this.bytes;
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public EncodedPayload(Encoding encoding2, byte[] bArr) {
        if (encoding2 == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.encoding = encoding2;
            this.bytes = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.encoding.equals(encodedPayload.encoding)) {
            return false;
        }
        return Arrays.equals(this.bytes, encodedPayload.bytes);
    }

    public int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.encoding + ", bytes=[...]}";
    }
}
