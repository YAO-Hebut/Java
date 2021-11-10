package hebuter.JDBC;

import hebuter.JDBC.Utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidUtilsDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DruidUtils.getConnection();

            String sql = "insert into user values(null,?,?)";

            pstmt = conn.prepareStatement(sql);//预编译sql语句

            pstmt.setString(1, "190996");
            pstmt.setString(2, "190996PaceMaker");

            int count = pstmt.executeUpdate();

            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(pstmt, conn);
        }
    }
}
