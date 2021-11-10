package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;
import util.MailUtils;
import util.UuidUtil;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.查询用户
        User user_find = dao.FindUserByName(user.getUsername());
        //2.判断用户是否存在
        if (user_find != null) {   //用户名已经存在
            return false;
        }
        //3.用户名不存在则保存注册的用户信息
        //3.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //3.2设置激活状态
        user.setStatus("N");
        dao.save(user);

        //4.激活邮件发送
        String content = "<a href=http://localhost:8080/Travel/User/active?code=" + user.getCode() + ">" + user.getName() + "您好，点击激活</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;
    }

    /**
     * 用户激活
     *
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户
        User user = dao.FindUserByCode(code);
        if (user != null) {
            //2.调用dao修改激活状态status
            dao.updateStatus(user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return dao.FindUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }
}
