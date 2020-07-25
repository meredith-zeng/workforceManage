package control.mapper;

import model.Employee;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> queryEmployee() throws Exception;

    public void addEmployee(Employee employee) throws Exception;

    public void deleteEmployee(int empNo) throws Exception;

    public Employee selectEmployee(int emoNo) throws Exception;

    public void updateEmployee(Employee employee) throws Exception;


}
