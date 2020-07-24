package control.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 登录验证的servelt
 * 作者:曾雨琳
 * 学号:2017214363
 * **/
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int userId = Integer.parseInt(req.getParameter("userId"));
        String password = req.getParameter("userPassword");

        if (userId==2017214363 && password.equals("199811")){
            req.getSession().setAttribute("userId",userId);
            resp.sendRedirect("/workforceManage_war_exploded/views/employee/manageEmployee.jsp");
        }else{
            resp.sendRedirect("/workforceManage_war_exploded/views/login/login_false.jsp");

        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
