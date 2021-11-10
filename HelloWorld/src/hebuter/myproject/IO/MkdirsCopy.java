package hebuter.myproject.IO;

import java.io.*;

public class MkdirsCopy {
    public static void main(String[] args) throws IOException {
        //创建源地址和目的地址的File对象
        File srcFile = new File("D:\\Codefield\\Code\\HTML");
        File destFile = new File("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\IO\\");

        mkdirsCopy(srcFile, destFile);
    }

    public static void mkdirsCopy(File srcFile, File destFile) throws IOException {
        if (srcFile.isDirectory()) {
            String srcFolderName = srcFile.getName();
            File newFolder = new File(destFile, srcFolderName);
            if (!newFolder.exists()) {
                newFolder.mkdir();
            }

            File[] fileArray = srcFile.listFiles();
            for (File file : fileArray) {
                mkdirsCopy(file, newFolder);
            }
        } else {
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }
    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bis.close();
        bos.close();
    }
}
