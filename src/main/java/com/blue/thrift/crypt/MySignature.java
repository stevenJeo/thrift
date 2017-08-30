package com.blue.thrift.crypt;

import org.apache.commons.codec.binary.Base64;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * <<数字签名>>
 * 算法简述
 * 数字签名算法可以看做是一种带有密钥的消息摘要算法，并且这种密钥包含了公钥和私钥。也就是说，数字签名算法是非对称加密算法和消息摘要算法的结合体。
 * <p>
 * (特点)
 * 数字签名算法要求能够验证数据完整性、认证数据来源，并起到抗否认的作用。
 * (原理)
 * 数字签名算法包含签名和验证两项操作，遵循私钥签名，公钥验证的方式。
 * <p>
 * 签名时要使用私钥和待签名数据，验证时则需要公钥、签名值和待签名数据，其核心算法主要是消息摘要算法。
 * <p>
 *
 * @see ## http://blog.csdn.net/lll350203041/article/details/41482017
 * Created by zhishuai.zhou on 2017/8/29.
 */
public class MySignature {

    private static final String KEY_ALGORITHM = "DSA";
    private KeyFactory keyFactory;
    private Signature signature;

    public enum DsaTypeEn {
        MD5withDSA, SHA1withDSA
    }

    /**
     * DSA密钥长度默认1024位。 密钥长度必须是64的整数倍，范围在512~1024之间
     */
    private static final int KEY_SIZE = 1024;

    private KeyPair keyPair;

    //初始化密钥对
    public MySignature() throws Exception {
        // 初始化密钥对生成器
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        // 实例化密钥对生成器
        keyPairGen.initialize(KEY_SIZE);
        // 实例化密钥对
        keyPair = keyPairGen.genKeyPair();
        keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        signature = Signature.getInstance(DsaTypeEn.SHA1withDSA.name());
    }

    public byte[] signature(byte[] data, byte[] privateKey) throws Exception {
        //私钥用 PKCS#8 编码保存
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
        PrivateKey key = keyFactory.generatePrivate(keySpec);

        signature.initSign(key);
        signature.update(data);
        return signature.sign();
    }

    public boolean verify(byte[] data, byte[] publicKey, byte[] sign) throws Exception {
        //公钥用 X.509 编码保存
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);

        PublicKey key = keyFactory.generatePublic(keySpec);


        signature.initVerify(key);
        signature.update(data);
        return signature.verify(sign);
    }


    public byte[] getPublicKey() {
        return keyPair.getPublic().getEncoded();
    }

    public byte[] getPrivateKey() {
        return keyPair.getPrivate().getEncoded();
    }


    public static void main(String[] args) throws Exception {

        String msg = "Hello World";
        MySignature dsa = new MySignature();
        byte[] sign = dsa.signature(msg.getBytes(), dsa.getPrivateKey());
        boolean flag = dsa.verify(msg.getBytes(), dsa.getPublicKey(), sign);
        String result = flag ? "数字签名匹配" : "数字签名不匹配";

        System.out.println("数字签名：" + Base64.encodeBase64URLSafeString(sign));
        System.out.println("验证结果：" + result);

    }


}
