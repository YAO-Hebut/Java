package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.Address;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
//        调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.del(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelected(String[] ids) {
        for (String id : ids) {
            dao.del(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage_String, String rows_String, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(currentPage_String);
        int rows = Integer.parseInt(rows_String);
        if (currentPage <= 0) {
            currentPage = 1;
        }
        //1.设置空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3.调用Dao查询totalCount
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.调用Dao查询list集合
        //计算开始的索引记录
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);

        //5.计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public List<User> findUserInRedis() {
        return dao.findUserInRedis();
    }
}
