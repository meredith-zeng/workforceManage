package database;

import database.DBconnection;
import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 封装好增删改查的方法以供逻辑层使用
 * **/
public class EmployeeDAO {
    public void addEmp(Employee employee) throws SQLException {
        Connection conn = DBconnection.getConnection();

        String sqlStatement = ""+
                "insert into employee"+
                "(empNo, empName, workSection)"+
                " values"+
                   "(?,?,?)";
//   "employeeNo,employeeName.substring(0,100),workplaceSection.substring(0,100))
        //预处理数据,三个问号占位
        PreparedStatement ptmt = conn.prepareStatement(sqlStatement);

        //分别把三个对应的占位符对应的数据填进去
        ptmt.setInt(1,employee.getEmpNo());
        ptmt.setString(2,employee.getEmpName());
        ptmt.setString(3,employee.getWorkSection());

        //调用运行sql语句
        ptmt.execute();

    }

    public void deleteEmp(int employeeNo) throws SQLException {
        Connection conn = DBconnection.getConnection();

        String sqlStatement = ""+"" +
                "delete from employee"+" "+
                "where"+" "+
                " empNo=?";
//   "employeeNo,employeeName.substring(0,100),workplaceSection.substring(0,100))
        //预处理数据,一个?占位
        PreparedStatement ptmt = conn.prepareStatement(sqlStatement);

        //把要删除的员工工号传进去
        ptmt.setInt(1,employeeNo);

        //调用运行sql语句
        ptmt.executeUpdate();
    }

    public void updateEmp(Employee employee) throws SQLException {
        Connection conn = DBconnection.getConnection();


        String sqlStatement = "update employee"+
                " set "+
                "empName=?, workSection=?"+
                "where empNo=?";
//   "employeeNo,employeeName.substring(0,100),workplaceSection.substring(0,100))
        //预处理数据,三个问号占位
        PreparedStatement ptmt = conn.prepareStatement(sqlStatement);

        //分别把三个对应的占位符对应的数据填进去
        //特别注意:empNo在数据库里设置成了主键,不能修改
        ptmt.setString(1,employee.getEmpName());
        ptmt.setString(2,employee.getWorkSection());
        ptmt.setInt(3,employee.getEmpNo());

        //调用运行sql语句
        ptmt.execute();
    }

    public List<Employee> query() throws SQLException {
        Connection conn = DBconnection.getConnection();
        Statement stmt = conn.createStatement();

        //查询所有员工信息
        String sqlStatement= "select * from employee ";
        ResultSet rs = stmt.executeQuery(sqlStatement);

        List<Employee> emp = new ArrayList<>();

        while (rs.next()){
            Employee employee = new Employee();

            employee.setEmpNo(rs.getInt("empNo"));
            employee.setEmpName(rs.getString("empName"));
            employee.setWorkSection(rs.getString("workSection"));

            emp.add(employee);

        }
        return emp;
    }

    public Employee selectEmp(int employeeNo) throws SQLException {
        Connection conn = DBconnection.getConnection();

        //查询指定员工信息
        String sqlStatement = "select * from employee " +
                "where empNo = ?";
        //预处理数据
        PreparedStatement ptmt = conn.prepareStatement(sqlStatement);

        ptmt.setInt(1, employeeNo);

        ResultSet rs = ptmt.executeQuery();
        Employee employeeInfo = new Employee();
        while (rs.next()) {

            employeeInfo.setEmpNo(rs.getInt("empNo"));
            employeeInfo.setEmpName(rs.getString("empName"));
            employeeInfo.setWorkSection(rs.getString("workSection"));
        }
        return employeeInfo;

    }

}
