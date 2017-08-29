package com.blue.thrift.crypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * 消息摘要，其实就是将需要摘要的数据作为参数，经过哈希函数(Hash)的计算，得到的散列值。
 * <p>
 * 常用算法
 * 消息摘要算法包括MD(Message Digest，消息摘要算法)、SHA(Secure Hash Algorithm，安全散列算法)、MAC(Message AuthenticationCode，
 * 消息认证码算法)共3大系列，常用于验证数据的完整性，是数字签名算法的核心算法。
 * MD5和SHA1分别是MD、SHA算法系列中最有代表性的算法。
 * 如今，MD5已被发现有许多漏洞，从而不再安全。SHA算法比MD算法的摘要长度更长，也更加安全。
 * <p>
 * Created by zhishuai.zhou on 2017/8/29.
 */
public class MDigest {


    public static void main(String[] args) throws Exception {

        String plantTxt = "this is a plant txt!!";

        //MD5摘要
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        md5Digest.update(plantTxt.getBytes());//更新要计算的内容
        byte[] md5Encode = md5Digest.digest();//完成哈希计算，得到摘要

        //SHA摘要
        MessageDigest shaDigest = MessageDigest.getInstance("SHA");
        shaDigest.update(plantTxt.getBytes());//更新要计算的内容
        byte[] shaEncode = shaDigest.digest();//完成哈希计算，得到摘要


        System.out.println("=============================");
        System.out.println("原文：" + plantTxt);
        System.out.println("MD5摘要：" + Base64.encodeBase64URLSafeString(md5Encode));
        System.out.println("SHA摘要：" + Base64.encodeBase64URLSafeString(shaEncode));

        //HMAC摘要
        byte[] secretKey = "Secret_Key".getBytes("UTF8");
        byte[] digest = hmacEncode(plantTxt.getBytes(), secretKey, HmacTypeEn.HmacSHA256);
        System.out.println(HmacTypeEn.HmacSHA256 + " 摘要: " + Base64.encodeBase64URLSafeString(digest));


    }


    /**
     * JDK支持HmacMD5, HmacSHA1,HmacSHA256, HmacSHA384, HmacSHA512
     */
    public enum HmacTypeEn {
        HmacMD5, HmacSHA1, HmacSHA256, HmacSHA384, HmacSHA512;
    }

    public static byte[] hmacEncode(byte[] plaintext, byte[] secretKey, HmacTypeEn type) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey, type.name());
        Mac mac = Mac.getInstance(keySpec.getAlgorithm());
        mac.init(keySpec);
        return mac.doFinal(plaintext);
    }


}
