package com.dz.factory.common.aes;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AESUtil {

    @Value("${encryption.secret}")
    private String secretKey;
    
    private static final String IV = "1234567890123456"; 

    public String encrypt(String value) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(IV.getBytes()));
        byte[] encrypted = cipher.doFinal(value.getBytes());
        return Base64.encodeBase64String(encrypted);
    }

    public String decrypt(String encrypted) throws Exception {
        byte[] original = Base64.decodeBase64(encrypted);
        SecretKeySpec skeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(IV.getBytes()));
        return new String(cipher.doFinal(original));
    }
}

