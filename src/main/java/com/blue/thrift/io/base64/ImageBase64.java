package com.blue.thrift.io.base64;

import org.springframework.core.io.UrlResource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * Created by zs on 2017/7/25.
 */
public class ImageBase64 {


    private ImageBase64() {
    }

    public static ImageBase64 newInstance() {
        return new ImageBase64();
    }

    /**
     * 编码图片,将本地或网络图片文件编码
     *
     * @param imageUrl
     * @return
     */
    public static String encodeImage(String imageUrl) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            UrlResource urlResource = new UrlResource(imageUrl);
            long contentLength = urlResource.contentLength();
            inputStream = urlResource.getInputStream();
            int available = inputStream.available();
            while (available < contentLength) {//网络文件可能一次读取不全
                available = inputStream.available();
            }
            data = new byte[available];
            inputStream.read(data);
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        return new String(Base64.getEncoder().encode(data));
    }

    /**
     * 将编码后的图片解压还原为图片
     *
     * @param imgBase64Data
     * @param destPath
     * @return
     */
    public static boolean decoderImage(String imgBase64Data, String destPath) {
        if (imgBase64Data == null) {
            return false;
        }
        try (FileOutputStream out = new FileOutputStream(destPath)) {
            // 解码
            byte[] b = Base64.getDecoder().decode(imgBase64Data);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            out.write(b);
            out.flush();
            out.getFD().sync();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
