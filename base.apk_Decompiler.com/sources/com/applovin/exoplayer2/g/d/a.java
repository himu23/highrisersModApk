package com.applovin.exoplayer2.g.d;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.exoplayer2.g.d;
import com.applovin.exoplayer2.g.g;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends g {
    private static final Pattern Jy = Pattern.compile("(.+?)='(.*?)';", 32);
    private final CharsetDecoder JA = Charsets.ISO_8859_1.newDecoder();
    private final CharsetDecoder Jz = Charsets.UTF_8.newDecoder();

    /* access modifiers changed from: protected */
    public com.applovin.exoplayer2.g.a a(d dVar, ByteBuffer byteBuffer) {
        String l = l(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (l == null) {
            return new com.applovin.exoplayer2.g.a(new c(bArr, (String) null, (String) null));
        }
        Matcher matcher = Jy.matcher(l);
        String str2 = null;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String lowerCase = Ascii.toLowerCase(group);
                lowerCase.hashCode();
                if (lowerCase.equals("streamurl")) {
                    str2 = group2;
                } else if (lowerCase.equals("streamtitle")) {
                    str = group2;
                }
            }
        }
        return new com.applovin.exoplayer2.g.a(new c(bArr, str, str2));
    }

    /* JADX INFO: finally extract failed */
    private String l(ByteBuffer byteBuffer) {
        try {
            return this.Jz.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = this.JA.decode(byteBuffer).toString();
                this.JA.reset();
                byteBuffer.rewind();
                return charBuffer;
            } catch (CharacterCodingException unused2) {
                this.JA.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.JA.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.Jz.reset();
            byteBuffer.rewind();
        }
    }
}
