package com.java8.model;

public class Employee
{
    private Integer empId;
    private String name;
    private String address;
    private Integer salary;
    private String designation;
    private String gender;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Employee(String name, String department, Integer salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(Integer empId, String name, String address, Integer salary) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }
    public Employee(Integer empId, String name, String address, Integer salary, String department) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.department = department;
    }

    public Employee(Integer empId, String name, String address, Integer salary, String designation, String gender) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.designation = designation;
        this.gender = gender;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId() {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "model.Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary + '\'' +
                ", department=" + department +
        '}';
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
