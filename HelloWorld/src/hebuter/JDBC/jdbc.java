package hebuter.JDBC;

import hebuter.JDBC.Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.Scanner;

public class jdbc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        boolean flag = new jdbc().login(username, password);

        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名或密码错误");
        }
    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);

            String sql = "select * from user where username='"+username+"' and password='"+password+"'";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery(sql);

            conn.commit();

            return rs.next();

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
//            JDBCUtils.close(rs, pstmt, conn);
        }
        return false;
    }
}
