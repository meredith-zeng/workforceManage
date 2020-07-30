package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import control.mapper.EmployeeMapper;
import model.Employee;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<Employee> queryEmployee(int pageNum, int pageSize) {

            PageHelper.startPage(pageNum,pageSize);
            List<Employee> empList = employeeMapper.queryEmployee();
            return new PageInfo<Employee>(empList);

    }

    @Override
    public boolean addEmployee(Employee employee) {
        try {
            employeeMapper.addEmployee(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int empNo) {

        try {
            employeeMapper.deleteEmployee(empNo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Employee selectEmployee(int empNo) {

        Employee employeeInfo = new Employee();

        try {
            employeeInfo = employeeMapper.selectEmployee(empNo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeInfo;
    }

    @Override
    public boolean updateEmployee(Employee employee) {

        try {
            employeeMapper.updateEmployee(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean fireEmployee(int empNo){
        Employee fireEmployee  = new Employee();
        try {

            fireEmployee =  employeeMapper.selectEmployee(empNo);
            employeeMapper.deleteEmployee(empNo);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
