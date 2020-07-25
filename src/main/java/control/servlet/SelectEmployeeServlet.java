package control.servlet;

import control.mapper.EmployeeMapper;
import database.MyBatisConnection;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查询指定员工信息的servelt
 * 作者:曾雨琳
 * 学号:2017214363
 * **/
public class SelectEmployeeServlet extends HttpServlet {

    public SelectEmployeeServlet() throws IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         EmployeeMapper employeeMapper = MyBatisConnection.getEmployeeMapper(false);

        req.setCharacterEncoding("UTF-8");
        //获取表单提交的信息
        int empNo = Integer.parseInt(req.getParameter("selectEmpNo"));
        Employee employeeInfo = new Employee();

//        try {
//            employeeInfo = dao.selectEmp(empNo);
//        } catch (SQLException  e) {
//            e.printStackTrace();
//        }

        try {
            employeeInfo = employeeMapper.selectEmployee(empNo);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MyBatisConnection.closeSqlSession();
        }

        req.getSession().setAttribute("employeeInfo",employeeInfo);

        resp.sendRedirect("/workforceManage_war_exploded/views/employee/select_success.jsp");

    }
}
