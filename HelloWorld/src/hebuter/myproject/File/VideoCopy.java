package hebuter.myproject.File;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class VideoCopy {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\QQ\\程序视频.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\File\\BufferedCopyVideo.mp4"));

        byte[] bys = new byte[4096];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("共耗时" + (endTime - startTime) + "毫秒");
    }

}
