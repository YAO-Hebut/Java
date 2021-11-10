package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        String verifycode = request.getParameter("verifycode");
        Map<String, String[]> map = request.getParameterMap();
        //3.验证码校验
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");//随机生成的验证码
        if (checkCode_session == null || !checkCode_session.equalsIgnoreCase(verifycode)) {
            //验证码错误
            request.setAttribute("login_msg", "验证码错误！");
            //提示信息，跳转页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

            return;
        }
        session.removeAttribute("checkCode_session");//确保验证码的一次性

        //4.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();

        }

        //5.调用Service查询
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        //6.判断是否登陆成功
        if (loginUser != null) {
            //登陆成功
            //将用户存入session
            session.setAttribute("user", loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            request.setAttribute("login_msg", "用户名或密码错误！");
            //提示信息，跳转页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
