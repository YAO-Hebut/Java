package hebuter.myproject.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:\\兴兴");

        //创建文件的File对象数组 进行遍历
        File[] fileArray = srcFile.listFiles();
        int index = 0;
        for (File file : fileArray) {
            //创建输入输出流对象
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\File\\" + index + ".jpg");
            index++;
            //读写数据
//        int by;
//        while ((by = fis.read()) != -1) {
//            fos.write(by);
//        }


            //按字节流读取数据
            byte[] bys = new byte[4096];
            int len;
            while ((len = fis.read(bys)) != -1) {
                fos.write(bys, 0, len);
            }

            //释放资源
            fis.close();
            fos.close();
        }
    }
}

