import org.example.Models.Employees.Employee;
import org.example.Models.Employees.Manager;
import org.example.Models.Employees.PrintingMachineOperator;
import org.example.Models.PrintingHouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesTest {
    //This is tested in PrintingHouseTest class!

  //  @Test
  //  void calculateSalaryManager(){
  //      PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,20000, 1000, 5);
  //      Employee employee = new Manager("Ivan",10);
  //      printingHouse.hireEmployee(employee);
  //      double expectedSalary = 1100;
//
  //      assertEquals(expectedSalary, employee.calculateSalary(1000));
  //  }



    @Test
    void IdEmployeesTest(){
        Employee employee = new Manager("Ivan",10);
        Employee employee2 = new PrintingMachineOperator("Ivan");
        Employee employee3 = new Employee("Ivan");
        int expectedId = 3;
        int actualId = employee3.getId();
        assertEquals(expectedId, actualId);
    }
}
