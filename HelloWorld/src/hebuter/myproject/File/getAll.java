package hebuter.myproject.File;

import java.io.File;

public class getAll {
    public static void main(String[] args) {
        File srcFile = new File("D:\\QQ");

        getAllFiles(srcFile);
    }

    public static void getAllFiles(File srcFile) {
        File[] fileArray = srcFile.listFiles();
        if (fileArray != null) {
            for (File file : fileArray) {
                if (file.isDirectory()) {
                    getAllFiles(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
