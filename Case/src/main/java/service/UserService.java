package service;

import domain.Address;
import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 * 通过对Dao层的整合实现业务逻辑操作
 */
public interface UserService {
    /**
     * 查询所有用户信息
     */
    public List<User> findAll();

    /**
     * 登陆方法
     */
    public User login(User user);

    /**
     * 添加用户
     */
    public void addUser(User user);

    /**
     * 删除用户
     */
    public void deleteUser(String id);

    /**
     * 根据ID查询用户
     */
    public User findUserById(String id);

    public void update(User user);


    public void delSelected(String[] ids);

    /**
     * 分页条件查询
     */
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 查询所有user(缓存在redis上)
     */
    public List<User> findUserInRedis();
}
