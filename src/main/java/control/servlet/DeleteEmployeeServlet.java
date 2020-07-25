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
 * 删除员工的servelt
 * 作者:曾雨琳
 * 学号:2017214363
 * **/
public class DeleteEmployeeServlet extends HttpServlet {

    public DeleteEmployeeServlet() throws IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         EmployeeMapper employeeMapper = MyBatisConnection.getEmployeeMapper(true);

        req.setCharacterEncoding("UTF-8");
        //获取表单提交的信息
        int empNo = Integer.parseInt(req.getParameter("empNo"));
        Employee deleteEmployeeInfo = new Employee();

        try {
            deleteEmployeeInfo = employeeMapper.selectEmployee(empNo);
            employeeMapper.deleteEmployee(empNo);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MyBatisConnection.closeSqlSession();
        }

        req.getSession().setAttribute("deleteEmployeeInfo",deleteEmployeeInfo);

        //跳转到删除成功页面
        resp.sendRedirect("/workforceManage_war_exploded/views/employee/delete_success.jsp");
    }

}
