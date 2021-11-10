package garbage;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取激活码
        String code = request.getParameter("code");
        //2.调用service完成激活
        UserService service = new UserServiceImpl();
        boolean flag = service.active(code);

        String msg = null;
        //3.判断激活是否成功
        if (flag) {
            //激活成功，跳转至登录页面
            msg = "激活成功，请<a href='login.html'>登录</a>";
        } else {
            //激活失败
            msg = "激活失败，请联系管理员!(3079763131@qq.com)";
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(msg);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
