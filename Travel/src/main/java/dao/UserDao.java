package dao;

import domain.User;

public interface UserDao {

    public User FindUserByName(String username);

    public void save(User user);

    User FindUserByCode(String code);

    void updateStatus(User user);

    User FindUserByUserNameAndPassword(String username, String password);
}
