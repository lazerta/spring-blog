package com.shawn.springblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class EncodeUtils {
    private final static String AlGO = "sha-256";


    public static String encode(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance(AlGO);
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuilder builder = new StringBuilder();
            for (byte b : byteDigest) {
                i = b;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    builder.append("0");
                builder.append(Integer.toHexString(i));
            }
            return builder.toString();


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static void main(String[] args) {
        System.out.println(encode("test"));
    }
}
