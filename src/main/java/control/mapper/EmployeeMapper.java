package control.mapper;

import model.Employee;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> queryEmployee() ;

    public void addEmployee(Employee employee) ;

    public void deleteEmployee(int empNo);

    public Employee selectEmployee(int emoNo);

    public void updateEmployee(Employee employee);


}
