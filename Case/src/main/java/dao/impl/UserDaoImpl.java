package dao.impl;

import dao.UserDao;
import domain.Address;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DruidUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //定义sql
        String sql = "select * from user";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }

    @Override
    public User findUserByNameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void add(User user) {
        //1.定义sql语句
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //2.执行sql语句
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void del(int id) {
        //1.定义sql语句
        String sql = "delete from user where id=?";
        //2.执行sql语句
        template.update(sql, id);
    }

    @Override
    public User findUserById(int id) {
        //1.定义sql语句
        String sql = "select * from user where id=?";
        //2.执行sql语句
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //初始化sql模板
        String sql = "select count(*) from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map集合
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数currentPage和rows
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " + key + " like ?");
                params.add("%" + value + "%");//?条件的值，待会进行传参
            }
        }
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());//params变成数组传参
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        //初始化sql模板
        String sql = "select * from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map集合
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数currentPage和rows
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " + key + " like ?");
                params.add("%" + value + "%");//?条件的值，待会进行传参
            }
        }

        //添加分页查询
        sb.append(" limit ?,?");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }

    @Override
    public List<User> findUserInRedis() {
        String sql = "select address from user ";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }


}
