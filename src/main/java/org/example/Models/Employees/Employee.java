package org.example.Models.Employees;

public class Employee {
    private String name;
    private int id;
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public  double calculateSalary(double baseSalary)
    {

       return baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
  //  public double getRevenueThreshold() {
  //      return 0; // default threshold for employees without a threshold
  //  }
}
