package database.test;

import model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
//    public static void main(String[] args) throws IOException {
//        //根据mybatis-config.xml配置的信息得到sqlSessionFactory
//        String resource = "config/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //然后根据sqlSessionFactory得到session
//        SqlSession session = sqlSessionFactory.openSession();



        /**
         * 增
         * **/
//        Employee employeeAdd = new Employee();
//        employeeAdd.setEmpNo(6);
//        employeeAdd.setEmpName("曾瘦琳");
//        employeeAdd.setWorkSection("华迪");
//        session.insert("addEmployee",employeeAdd);

        /**
         * 删
         * **/
//        int deleteNo = 7;
//        session.delete("deleteEmployee",deleteNo);

        /**
         * 测试输出全部数据项
         * **/
//        List<Employee> queryEmployee = session.selectList("queryEmployee");
//        for(Employee x : queryEmployee){
//            System.out.println("empName" + x.getEmpName() +",empName" +x.getEmpName());
//        }
        /**
         * 改
         * **/
//        employeeAdd.setWorkSection("加州大学圣地亚哥分校");
//        session.update("updateEmployee",employeeAdd);


        /**
         * 查
         * **/
//        Employee selectOneEmployee = session.selectOne("selectEmployee",6);
//        System.out.println(
//                selectOneEmployee.getWorkSection()
//        );
//
//        //没有这两行，数据不会在数据库中被真正的修改
//        //提交修改
//        session.commit();
//        //关闭session
//        session.close();
//    }

}
