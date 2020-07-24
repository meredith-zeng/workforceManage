package control.servlet;

import database.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 查询所有员工信息的servelt
 * 作者:曾雨琳
 * 学号:2017214363
 * **/
public class QueryEmployeeServlet extends HttpServlet {
    EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        List<Employee> empList = new ArrayList<>();


        try {
            empList = dao.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        req.getSession().setAttribute("empList",empList);

        resp.sendRedirect("/workforceManage_war_exploded/views/employee/query_success.jsp");

    }
}
