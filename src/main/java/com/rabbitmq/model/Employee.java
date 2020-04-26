package com.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employee.class)
public class Employee {
    public Employee() {
    }

    public Employee(String empName, String empId) {
        this.empName = empName;
        this.empId = empId;
    }

    private String empName;
    private String empId;

    public String getEmpName() {
        return empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpName(String empName) {
        this.empName = this.empName;
    }

    public void setEmpId(String empId) {
        this.empId = this.empId;
    }

    @Override
    public String toString() {
        return "Employee [empName=" + empName + ", empId=" + empId + "]";
    }}
