package model;

import java.util.Objects;

public class Employee {
    /**
    * 符合JavaBeans的规则
    *
    * 属性:
    * @工号 int empNo
    * @姓名 String empName
    * @部门 String workSection
     * @头像路径 String empImg
    *
    * **/

    int empNo;
    String empName;
    String workSection;
    String empImg;

    //要有无参构造函数

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getEmpNo() == employee.getEmpNo() &&
                getEmpName().equals(employee.getEmpName()) &&
                getWorkSection().equals(employee.getWorkSection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpNo(), getEmpName(), getWorkSection());
    }

    //每个属性都要有get和set方法

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getWorkSection() {
        return workSection;
    }

    public void setWorkSection(String workSection) {
        this.workSection = workSection;
    }

    public String getEmpImg() {
        return empImg;
    }

    public void setEmpImg(String empImg) {
        this.empImg = empImg;
    }
}
