package hebuter.myproject.IO;

import java.io.*;

public class PrinterCopy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\IO\\HTML\\兴兴\\摘下兴兴给你.html"));
        PrintWriter pw = new PrintWriter(new FileWriter("D:\\JavaProject\\HelloWorld\\src\\hebuter\\myproject\\IO\\1.html", true));

        String line;
        while ((line = br.readLine()) != null) {
            pw.println(line);
        }
        pw.close();
        br.close();
    }
}
