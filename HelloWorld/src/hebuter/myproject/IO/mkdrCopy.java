package hebuter.myproject.IO;

import java.io.*;

public class mkdrCopy {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\File");

        String srcFileName = srcFile.getName();

        File destFolder = new File("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\IO", srcFileName);

        if (!destFolder.exists()) {
            destFolder.mkdir();
        }
        File[] files = srcFile.listFiles();
        for (File file : files) {
            String name = file.getName();
            File destFile = new File(destFolder, name);
            copy(destFile, file);
        }
    }

    public static void copy(File destFile, File srcFile) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bos.close();
        bis.close();
    }
}
