package web.servlet;

import domain.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 导航栏类的 Servlet
 */
@WebServlet("/Category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service = new CategoryServiceImpl();

    /**
     * 查询所有
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.调用service查询所有
        List<Category> list = service.findAll();
        //2.序列化为json返回
        writeValue(list, response);
    }

}
