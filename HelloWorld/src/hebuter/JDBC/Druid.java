package hebuter.JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        InputStream is = Druid.class.getClassLoader().getResourceAsStream("src/druid.properties");
        pro.load(is);

        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        Connection connection = ds.getConnection();

        System.out.println(connection);
    }
}
