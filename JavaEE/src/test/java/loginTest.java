import dao.UserDao;
import doamain.User;
import org.junit.jupiter.api.Test;

public class loginTest {
    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("190665");
        loginUser.setPassword("ytq");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
