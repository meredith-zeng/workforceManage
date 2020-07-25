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
 * 更新指定员工信息的servelt
 * 作者:曾雨琳
 * 学号:2017214363
 * **/
public class UpdateEmployeeServlet extends HttpServlet {
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
        String empName = req.getParameter("empName");
        String workSection = req.getParameter("workSection");

        //将表单提交的信息装填到对象中
        //将对象传给dao进行数据库存储动作
        Employee employee = new Employee();
        employee.setEmpNo(empNo);
        employee.setEmpName(empName);
        employee.setWorkSection(workSection);

        //判断数据库中是否存在对应数据
        //如果存在则进行操作，如果不存在则抛出异常
        List<Employee> empList = new ArrayList<>();
        try {
            empList = dao.query();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Employee x :empList){
            //判断数据库中是否存在对应数据项，
            if(x.equals(employee) && x.hashCode()==employee.hashCode()){
                try {
                    dao.updateEmp(employee);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        req.getSession().setAttribute("UpdataEmployee",employee);

        resp.sendRedirect("/workforceManage_war_exploded/views/employee/updata_success.jsp");

    }
}
