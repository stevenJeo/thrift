package com.blue.thrift.tst;

//import org.springframework.util.StringUtils;

//import org.apache.commons.codec.binary.StringUtils;

//import org.apache.tomcat.util.codec.binary.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zs on 2017/7/7.
 */
public class TTTT {

    public static void  main(String[] args)throws Exception{

        BigDecimal bigDecimal = new BigDecimal("-32.17");

//        System.out.print("bigDecimal="+bigDecimal);

        BigDecimal a = new BigDecimal("22");
        BigDecimal b = new BigDecimal("37");

        System.out.print("a-b="+a.subtract(b)+", a="+a+"\n");


        System.out.print("MD5:" + MD5("{\"ss\":123, \"w\":\"w23s\"}"));
    }

    public static String MD5(String encTarget) throws Exception{
        MessageDigest mdEnc = null;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.print("Exception while encrypting to md5"+ e);
        } // Encryption algorithm
        mdEnc.update(encTarget.getBytes(), 0, encTarget.length());
        String md5 = new BigInteger(1, mdEnc.digest()).toString(16);
        while (md5.length() < 32) {
            md5 = "0" + md5;
        }
        return md5;
    }


}
