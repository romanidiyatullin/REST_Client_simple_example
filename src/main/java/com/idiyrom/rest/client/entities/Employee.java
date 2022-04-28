package com.idiyrom.rest.client.entities;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int id;
    private int salary;
    private String name;
    private String lastName;
    private String department;

    public Employee() {
    }

    public Employee(int salary, String name, String lastName, String department) {
        this.salary = salary;
        this.name = name;
        this.lastName = lastName;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
