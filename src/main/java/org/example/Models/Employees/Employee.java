package org.example.Models.Employees;

import java.io.Serializable;

public class Employee implements Serializable {
    private static int count = 0;
    private String name;
    private int id;

    public Employee(String name) {
        this.name = name;
        this.id = ++count;
    }

    public double calculateSalary(double baseSalary) {

        return baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
