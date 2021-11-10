package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> userList = service.findUserInRedis();
//        //2.将list存入request域
//        request.setAttribute("users", users);

        //2.将list转为json
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(userList);
        //3.转发到list.jsp
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        response.sendRedirect(request.getContextPath() + "/FindUserByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
