package control.service;

import com.github.pagehelper.PageInfo;
import model.Employee;

import java.util.List;

public interface EmployeeService {
    PageInfo<Employee> queryEmployee(int pageNum, int pageSize);
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(int empNo);
    Employee selectEmployee(int empNo);
    boolean updateEmployee(Employee employee);
    boolean fireEmployee(int empNp);
}
