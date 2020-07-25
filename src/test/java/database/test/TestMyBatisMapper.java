package database.test;

import control.mapper.EmployeeMapper;
import model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import java.io.InputStream;


public class TestMyBatisMapper {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

//////        //获得Mapper代理
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
//
//////        //执行Mapper代理独享的查询方法
        Employee employee = employeeMapper.selectEmployee(1);


//////                List<Employee> queryEmployee = employeeMapper.queryEmployee();
//////                for(Employee x : queryEmployee){
//////                    System.out.println("empName" + x.getEmpName() +",empName" +x.getEmpName());
//////                }
////
////

        //        //没有这两行，数据不会在数据库中被真正的修改
//        //提交修改
//        session.commit();
//        //关闭session
//        session.close();
        }
    }
