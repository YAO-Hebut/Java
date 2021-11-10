package hebuter.JDBC;


import hebuter.JDBC.Utils.DruidUtils;
import hebuter.myproject.RedBag.User;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

//获取JDBCTemplate对象

public class JDBCTemplate {

    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Test
    public void test1() {
        String sql = "select * from user";
        List<sqlUser> list = template.query(sql, new BeanPropertyRowMapper<sqlUser>(sqlUser.class));
        for (sqlUser user : list) {
            System.out.println(user);
        }
    }
}
