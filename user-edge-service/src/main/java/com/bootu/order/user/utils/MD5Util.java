package com.bootu.order.user.utils;

import org.apache.tomcat.util.buf.HexUtils;

import java.security.MessageDigest;

public class MD5Util {

    public MD5Util() {
    }

    public static String encodeStr (String inStr){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(inStr.getBytes("utf-8"));
            return HexUtils.toHexString(md5Bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
