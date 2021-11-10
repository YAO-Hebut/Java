package hebuter.myproject.IO;

import java.io.*;

public class IOStream {
    public static void main(String[] args) throws IOException {
//        FileReader fr = new FileReader("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\File\\CopyFile.java");
//        FileWriter fw = new FileWriter("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\IO\\Copy.java");

        BufferedReader br = new BufferedReader(new FileReader("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\IO\\IOStream.java"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\File\\Copy"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
