package dao;

import domain.Address;
import domain.User;

import java.util.List;
import java.util.Map;


//对数据库的基本CRUD操作
public interface UserDao {
    public List<User> findAll();

    public User findUserByNameAndPassword(String username, String password);

    public void add(User user);

    public void del(int parseInt);

    public User findUserById(int parseInt);

    public void updateUser(User user);

    public int findTotalCount(Map<String, String[]> condition);

    public List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    public List<User> findUserInRedis();
}
