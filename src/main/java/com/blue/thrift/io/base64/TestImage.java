package com.blue.thrift.io.base64;

/**
 * Created by zhouzhishuai on 2017/7/25.
 */
public class TestImage {

    public static void main(String[] args){
        System.out.print("========");

        String url = "http://preview.quanjing.com/mhrf005/mhrf-cpmh-82767f07x.jpg";
        String base64 = ImageBase64.encodeImage(url);
//        System.out.print("\n base.len=" + base64.length() + ",\n  base64:" + base64);

        ImageBase64.decoderImage(base64,"/Users/zhouzhishuai/Downloads/new.jpg");

    }

}
