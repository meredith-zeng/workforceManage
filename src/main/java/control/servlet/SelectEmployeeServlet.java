package control.servlet;

import database.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 查询指定员工信息的servelt
 * 作者:曾雨琳
 * 学号:2017214363
 * **/
public class SelectEmployeeServlet extends HttpServlet {
    EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        //获取表单提交的信息
        int empNo = Integer.parseInt(req.getParameter("selectEmpNo"));
        Employee employeeInfo = new Employee();

        try {
            employeeInfo = dao.selectEmp(empNo);
        } catch (SQLException  e) {
            e.printStackTrace();
        }




        req.getSession().setAttribute("employeeInfo",employeeInfo);

        resp.sendRedirect("/workforceManage_war_exploded/views/employee/select_success.jsp");

    }
}
