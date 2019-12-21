package com.blue.thrift.ftp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.net.PrintCommandListener;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPFile;
//import org.apache.commons.net.ftp.FTPReply;
//import org.apache.log4j.Logger;

/**
 * 列出FTP服务器上指定目录下面的所有文件
 */
public class FTPListAllFiles {
    //    private static Logger logger = Logger.getLogger(FTPListAllFiles.class);
//    public FTPClient ftp;
    public ArrayList<String> arFiles;
    private static final String FAR_SERVER_URL = "10.253.52.29";
    private static final int SERVER_PORT = 8021;
    private static final String SERVER_USER = "fin_buffett_voucher";
    private static final String SERVER_PWD = "bianlifeng";
    private static final String path = "/test/";
    private static final String showPath = "test";

//
//    /**
//     * 登陆FTP服务器
//     *
//     * @param host     FTPServer IP地址
//     * @param port     FTPServer 端口
//     * @param username FTPServer 登陆用户名
//     * @param password FTPServer 登陆密码
//     * @return 是否登录成功
//     * @throws IOException
//     */
//    public boolean login(String host, int port, String username, String password) throws IOException {
//        this.ftp.connect(host, port);
//        if (FTPReply.isPositiveCompletion(this.ftp.getReplyCode())) {
//            if (this.ftp.login(username, password)) {
//                this.ftp.setControlEncoding("GBK");
//                return true;
//            }
//        }
//        if (this.ftp.isConnected()) {
//            this.ftp.disconnect();
//        }
//        return false;
//    }
//
//    /**
//     * 关闭数据链接
//     *
//     * @throws IOException
//     */
//    public void disConnection() throws IOException {
//        if (this.ftp.isConnected()) {
//            this.ftp.disconnect();
//        }
//    }
//
//    /**
//     * 递归遍历出目录下面所有文件
//     *
//     * @param pathName 需要遍历的目录，必须以"/"开始和结束
//     * @throws IOException
//     */
//    public String List(String pathName) throws IOException {
//
//        StringBuffer filename = new StringBuffer();
//        if (pathName.startsWith("/") && pathName.endsWith("/")) {
//            String directory = pathName;
////更换目录到当前目录
//            this.ftp.changeWorkingDirectory(directory);
//            ftp.enterLocalPassiveMode();
//            FTPFile[] files = this.ftp.listFiles();
//            if (files != null) {
//                for (int i = 0; i < files.length; i++) {
//                    if (files[i].isFile()) {
//                        String n = new String(files[i].getName().getBytes("gbk"), "utf-8");
//                        if (i == files.length - 1) {
//                            filename.append(n + "," + showPath);
//                        } else {
//                            filename.append(n + ",");
//                        }
//
//                    }
//                }
//            }
//        }
//        return filename.toString();
//    }
//
//    //获取指定文件夹内的文件名称
//    public static String getFilenames() {
//        String names = "";
//        FTPListAllFiles f = new FTPListAllFiles();
//        try {
//            if (f.login(FAR_SERVER_URL, SERVER_PORT, SERVER_USER, SERVER_PWD)) {
//                names = f.List(path);
//            }
//        } catch (IOException e) {
//// TODO Auto-generated catch block
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println(names);
//            try {
//                f.disConnection();
//            } catch (IOException e) {
//// TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//        return names;
//    }

    //测试
//    public static void main(String[] args) throws IOException {
//        System.out.println(getFilenames());
//    }
}
