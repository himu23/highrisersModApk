package com.ironsource;

import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class b8 {
    public static final int a = 1024;
    public static final String b = "RSA/ECB/PKCS1Padding";

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Base64.encodeToString(a(str.getBytes("UTF-8"), (PublicKey) a(str2)), 0).replaceAll(System.getProperty("line.separator"), "");
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception on string encryption error: " + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    public static KeyPair a() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(b);
            instance.initialize(1024);
            return instance.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception on key generation error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static RSAPublicKey a(String str) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    public static byte[] a(byte[] bArr, PrivateKey privateKey) {
        try {
            Cipher instance = Cipher.getInstance(b);
            instance.init(2, privateKey);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception on decryption error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance(b);
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception on encryption error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
