package org.example;

import org.example.Enums.PageSizeType;
import org.example.Exceptions.NotEnoughPaperException;
import org.example.Exceptions.OutOfMoneyException;
import org.example.Models.Employees.Employee;
import org.example.Models.Employees.PrintingMachineOperator;
import org.example.Models.PrintingHouse;
import org.example.Models.PrintingMachine;
import org.example.Models.Prints.Book;
import org.example.Models.Prints.PrintingHousePublication;
import org.example.Utils.PrintingHouseInfo;
import org.example.Utils.PrintingHouseUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse", 100000, 10000, 1000, 10);

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
        try {
            printingHouse.BuyPrintingMachinesBW(3, 100, 100, 10, 80);
            printingHouse.BuyPrintingMachinesCLR(3, 100, 100, 10, 80);
        } catch (NotEnoughPaperException e) {
            System.out.println(e);
        }


        List<PrintingMachine> printingMachines = printingHouse.getPrintingMachines();
        double pmExpenses = 0;
        for (PrintingMachine pm : printingMachines) {
            pmExpenses += pm.getPriceOfThePrintingMachine();
        }


        Employee employee = new PrintingMachineOperator("Iskrata");
        printingHouse.hireEmployee(employee);


//serialize

        try {
            PrintingHouseInfo info = new PrintingHouseInfo(printingHouse, printingHouse.CalculatePrintingHouseIncome(10),
                    printingHouse.calculatePaperExpenses() + printingHouse.calculateTotalSalaryExpenses() + pmExpenses);
            PrintingHouseUtil.serialize(info, "printing_house_info.ser");
        } catch (OutOfMoneyException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

//deserialize

        List<PrintingHousePublication> publications = printingHouse.getPrintingHousePublications();

        try {
            PrintingHouseInfo info = (PrintingHouseInfo) PrintingHouseUtil.deserialize("printing_house_info.ser");
            System.out.println("Printing House Name: " + info.getPrintingHouse().getName());
            System.out.println();
            System.out.println("Printing house publications: ");
            for (int i = 0; i < publications.size(); i++) {
                System.out.println(publications.get(i));
            }
            System.out.println();
            System.out.println("Income: " + info.getIncome());
            System.out.println("Expenses: " + info.getExpenses());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }


    }
}