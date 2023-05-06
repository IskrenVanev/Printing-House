package org.example.Models;

import org.example.Enums.ColorType;
import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
import org.example.Exceptions.NotEnoughPaperException;
import org.example.Exceptions.OutOfMoneyException;
import org.example.Models.Employees.Employee;
import org.example.Models.Employees.Manager;
import org.example.Models.Employees.PrintingMachineOperator;
import org.example.Models.Prints.PrintingHousePublication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintingHouse implements Serializable {
    private String name;
    private List<PrintingHousePublication> PrintingHousePublications;
    private Set<Employee> employees;
    private List<Double> boughtPapers;
    private List<PrintingMachine> PrintingMachines;

    private double expectedIncome;
    private double actualIncome;
    private double baseSalary;
    private final int numberOfPrintedThingsAfterWhichCustomerGetsDiscount;


    private double percentageDiscount;


    private double MoneyThatThePrintingHouseHave;

    public PrintingHouse(String name, double MoneyThatThePrintingHouseHave, double expectedIncome, double baseSalary, int numberOfPrintedThingsAfterWhichCustomerGetsDiscount) {
        this.name = name;
        this.MoneyThatThePrintingHouseHave = MoneyThatThePrintingHouseHave;
        this.expectedIncome = expectedIncome;
        if (baseSalary <= 780) {//minimal salary for Bulgaria
            this.baseSalary = 780;
        } else {
            this.baseSalary = baseSalary;
        }

        this.numberOfPrintedThingsAfterWhichCustomerGetsDiscount = numberOfPrintedThingsAfterWhichCustomerGetsDiscount;
        this.percentageDiscount = 0;
        this.employees = new HashSet<>();
        this.PrintingHousePublications = new ArrayList<>();
        this.boughtPapers = new ArrayList<>();
        this.PrintingMachines = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addToPrintingHousePublications(PrintingHousePublication pSth) {
        PrintingHousePublications.add(pSth);
    }

    public List<PrintingHousePublication> getPrintingHousePublications() {
        return PrintingHousePublications;
    }

    public void BuyPrintingMachinesBW(int countBW, double priceOfPMachine, int maxCapacityPaper, int maxPrintedOneMin, int LoadedPaper) throws NotEnoughPaperException {

        PrintingMachine printingMachine =
                new PrintingMachine(priceOfPMachine, maxCapacityPaper, ColorType.BLACK_AND_WHITE, maxPrintedOneMin, LoadedPaper);
        for (int i = 0; i < countBW; i++) {

            PrintingMachines.add(printingMachine);
        }
    }

    public List<PrintingMachine> getPrintingMachines() {
        return PrintingMachines;
    }

    public void BuyPrintingMachinesCLR(int countCLR, double priceOfPMachine, int maxCapacityPaper, int maxPrintedOneMin, int LoadedPaper) throws NotEnoughPaperException {
        PrintingMachine printingMachine =
                new PrintingMachine(priceOfPMachine, maxCapacityPaper, ColorType.COLORED, maxPrintedOneMin, LoadedPaper);
        for (int i = 0; i < countCLR; i++) {

            PrintingMachines.add(printingMachine);
        }
    }

    public double getPercentageDiscount() {
        return percentageDiscount;
    }

    public double CalculatePrintingHouseIncome(double percentageDiscount) {
        double sum = 0;
        if (numberOfPrintedThingsAfterWhichCustomerGetsDiscount < PrintingHousePublications.size()) {

            this.percentageDiscount = percentageDiscount;
        } else {
            this.percentageDiscount = 0;
        }


        for (PrintingHousePublication printingHousePublication : PrintingHousePublications) {

            double priceForPrinting = printingHousePublication.getPriceForPrinting(printingHousePublication.getPageSize());
            double priceForSelling = priceForPrinting * (1 + printingHousePublication.getOverchargePercentage() / 100);
            double priceAfterDiscount = priceForSelling * (1 - percentageDiscount / 100);
            double winPrice = priceAfterDiscount - priceForPrinting;
            if (winPrice <= 0) {
                winPrice = 0.01;
            }
            sum += winPrice;
        }
        this.actualIncome = sum;
        return sum;
    }

    public double calculateTotalSalaryExpenses() throws OutOfMoneyException {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee instanceof PrintingMachineOperator) {
                totalSalary += employee.calculateSalary(baseSalary);
            } else if (employee instanceof Manager) {
                totalSalary += ((Manager) employee).calculateSalary(this);
            }

        }
        if (totalSalary > this.MoneyThatThePrintingHouseHave) {
            throw new OutOfMoneyException("The company is out of money. Salaries will not be payed this month.");
        }
        return totalSalary;
    }

    public double buyPaper(int numberOfPapers, PaperType paperType, PageSizeType pageSizeType) {
        double sum = 0;


        sum += numberOfPapers * paperType.getPrice(pageSizeType);

        boughtPapers.add(sum);
        return sum;
    }

    public double calculatePaperExpenses() {
        double sum = 0;
        for (Double boughtPaper : boughtPapers) {
            sum += boughtPaper;
        }
        return sum;
    }


    public void setExpectedIncome(double expectedIncome) {
        this.expectedIncome = expectedIncome;
    }

    public double getExpectedIncome() {
        return expectedIncome;
    }

    public double getActualIncome() {
        return actualIncome;
    }

    public double getBaseSalary() {
        return baseSalary;
    }


    public Set<Employee> getEmployees() {
        return employees;
    }
}
