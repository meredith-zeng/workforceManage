package control;

import database.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
/**
 * 开除员工的servlet
 * 作者:曾雨琳
 * 学号:2017214363
 * **/
public class EmployeeLeave extends HttpServlet {
    EmployeeDAO dao = new EmployeeDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        //获取表单提交的信息
        int empNo = Integer.parseInt(req.getParameter("empNo"));

        Employee fireEmployee = new Employee();
        try {
            fireEmployee =dao.selectEmp(empNo);
            dao.deleteEmp(empNo);

        } catch (SQLException  e) {
            e.printStackTrace();
        }

        req.getSession().setAttribute("fireEmployee",fireEmployee);


//        req.getRequestDispatcher("add_success.jsp");
//        resp.sendRedirect(" ");

        //跳转到删除成功页面
        resp.sendRedirect("/workforceManage_war_exploded/views/employee/leave_success.jsp");
    }
}
