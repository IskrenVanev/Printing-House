package org.example;

import org.example.Enums.PageSizeType;
import org.example.Exceptions.OutOfMoneyException;
import org.example.Models.Employees.Employee;
import org.example.Models.Employees.PrintingMachineOperator;
import org.example.Models.PrintingHouse;
import org.example.Models.Prints.Book;

public class Main {
    public static void main(String[] args) {
        PrintingHouse printingHouse = new PrintingHouse(100000,10000, 1000, 10);

        Book book1 = new Book("My Book 1", PageSizeType.A4, 100, 30.0, true, 5);
        Book book2 = new Book("My Book 2", PageSizeType.A4, 200, 30.0, false, 5);
        Book newspaper1 = new Book("My newspaper 1", PageSizeType.A4, 200, 30.0, false, 5);
        Book newspaper2 = new Book("My newspaper 2", PageSizeType.A4, 200, 30.0, false, 5);
        Book poster1 = new Book("My poster 1", PageSizeType.A4, 200, 30.0, false, 5);
        Book poster2 = new Book("My poster 2", PageSizeType.A4, 200, 30.0, false, 5);

        printingHouse.addToPrintingHousePublications(book1);
        printingHouse.addToPrintingHousePublications(book2);
        printingHouse.addToPrintingHousePublications(newspaper1);
        printingHouse.addToPrintingHousePublications(newspaper2);
        printingHouse.addToPrintingHousePublications(poster1);
        printingHouse.addToPrintingHousePublications(poster2);


        System.out.println( printingHouse.CalculatePrintingHouseIncome(10));

        Employee employee = new PrintingMachineOperator("Iskrata");
        printingHouse.hireEmployee(employee);
        try{
            double expenses =  printingHouse.calculatePaperExpenses() + printingHouse.calculateTotalSalaryExpenses();
            System.out.println(expenses);
        }catch (OutOfMoneyException e){
            System.out.println(e);
        }





    }
}