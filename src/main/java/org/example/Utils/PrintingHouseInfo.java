package org.example.Utils;

import org.example.Models.PrintingHouse;

import java.io.Serializable;

public class PrintingHouseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private PrintingHouse printingHouse;
    private double income;
    private double expenses;

    public PrintingHouseInfo(PrintingHouse printingHouse, double income, double expenses) {
        this.printingHouse = printingHouse;
        this.income = income;
        this.expenses = expenses;
    }

    public PrintingHouse getPrintingHouse() {
        return printingHouse;
    }

    public double getIncome() {
        return income;
    }

    public double getExpenses() {
        return expenses;
    }
}
