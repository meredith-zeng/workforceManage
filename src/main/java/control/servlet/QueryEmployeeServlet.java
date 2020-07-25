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
 * 查询所有员工信息的servelt
 * 作者:曾雨琳
 * 学号:2017214363
 * **/
public class QueryEmployeeServlet extends HttpServlet {


    public QueryEmployeeServlet(){
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeMapper employeeMapper = MyBatisConnection.getEmployeeMapper(false);
        req.setCharacterEncoding("UTF-8");
        List<Employee> empList = new ArrayList<>();


        try {
            empList = employeeMapper.queryEmployee();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisConnection.closeSqlSession();
        }



        req.getSession().setAttribute("empList",empList);

        resp.sendRedirect("/workforceManage_war_exploded/views/employee/query_success.jsp");

    }
}
