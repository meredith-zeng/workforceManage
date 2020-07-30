package control.mapper;

import model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class EmployeeMapperTest {

    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession session = sqlSessionFactory.openSession();

    EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

    public EmployeeMapperTest() throws IOException {

    }

    @Test
    public void queryEmployee() throws Exception {
        List<Employee> queryEmployee =  employeeMapper.queryEmployee();
        for(Employee x : queryEmployee){
            System.out.println("empName" + x.getEmpName() +",empName" +x.getEmpName());
        }
    }

    @Test
    public void addEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmpNo(9);
        employee.setEmpName("秦老师太强了");
        employee.setWorkSection("这就是华迪强者吗？");

        employeeMapper.addEmployee(employee);

        Employee testEmployee = employeeMapper.selectEmployee(employee.getEmpNo());
        System.out.println("添加成功："+testEmployee.getEmpNo()+testEmployee.getEmpName()+testEmployee.getWorkSection());
    }

    @Test
    public void deleteEmployee() throws Exception {
        Employee employee = new Employee();
        int deleteNo  = 1;

        employeeMapper.deleteEmployee(deleteNo);
//
        //此时查询报错则说明删除记录成功
//        Employee testEmployee = employeeMapper.selectEmployee(deleteNo);
//        System.out.println("删除结果："+testEmployee.getEmpNo()+testEmployee.getEmpName()+testEmployee.getWorkSection());
    }

    @Test
    public void selectEmployee() throws Exception {


        Employee employee = employeeMapper.selectEmployee(1199);
        System.out.println("工号为1的员工姓名为："+employee.getEmpName());
    }

    @Test
    public void updateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmpNo(1);
        employee.setEmpName("秦老师");
        employee.setWorkSection("华迪强者");

        employeeMapper.updateEmployee(employee);

        Employee testEmployee = employeeMapper.selectEmployee(employee.getEmpNo());
        System.out.println("修改成功："+testEmployee.getEmpNo()+testEmployee.getEmpName()+testEmployee.getWorkSection());
    }
}