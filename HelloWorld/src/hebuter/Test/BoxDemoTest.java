package hebuter.Test;


import org.junit.After;
import org.junit.Test;

import java.io.File;

import static hebuter.myproject.File.getAll.getAllFiles;

public class BoxDemoTest {
    @Test
    public void test() {
        File srcFile = new File("D:\\QQ");
        getAllFiles(srcFile);
    }
}
