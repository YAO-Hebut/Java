package WebServlet;

import dao.UserDao;
import doamain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
//        //2.获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        //3.封装user对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");//获取随机生成的验证码

        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        //获取用户写的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");

        //先判断验证码是否正确
        if (checkCode_session != null && checkCode_session.equals(checkCode)) {//验证码正确，则调用UserDao判断账号密码是否正确

            //4.调用UserDao的login方法
            UserDao dao = new UserDao();
            User user = dao.login(loginUser);

            //5.判断user
            if (user == null) {
                //登录失败
                //存储提示信息到request
                req.setAttribute("login_error", "账号或密码错误");
                //转发到登陆界面
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                //登录成功
                //存储数据
                session.setAttribute("user", username);
                //重定向到success.jsp
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            }

        } else {//验证码错误时
            //存储提示信息到request
            req.setAttribute("cc_error", "验证码错误");
            //转发到登陆界面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
