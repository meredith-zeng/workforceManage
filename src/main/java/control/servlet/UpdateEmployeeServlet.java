package control.servlet;

import control.mapper.EmployeeMapper;
import database.MyBatisConnection;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 更新指定员工信息的servelt
 * 作者:曾雨琳
 * 学号:2017214363
 * **/
public class UpdateEmployeeServlet extends HttpServlet {

    public UpdateEmployeeServlet() throws IOException {
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
        String empName = req.getParameter("empName");
        String workSection = req.getParameter("workSection");

        //将表单提交的信息装填到对象中
        //将对象传给dao进行数据库存储动作
        Employee employee = new Employee();
        employee.setEmpNo(empNo);
        employee.setEmpName(empName);
        employee.setWorkSection(workSection);

         try{
                    employeeMapper.updateEmployee(employee);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    MyBatisConnection.closeSqlSession();
                }



        req.getSession().setAttribute("UpdataEmployee",employee);

        resp.sendRedirect("/workforceManage_war_exploded/views/employee/updata_success.jsp");

    }
}
