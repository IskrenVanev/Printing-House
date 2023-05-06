package org.example.Models;

import org.example.Enums.ColorType;
import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
import org.example.Exceptions.NotEnoughPaperException;

import java.io.Serializable;

public class PrintingMachine implements Serializable {
    private int maxCapacityPaperThatIsLoaded; //for example 50
    private int LoadedPaper;//for example 40
    private ColorType color;

    private int maxPagesPrintedInOneMinute; //for example 10

    private double PriceOfThePrintingMachine;

    public PrintingMachine(double priceOfThePrintingMachine, int maxCapacityPaperThatIsLoaded, ColorType color, int maxPagesPrintedInOneMinute, int LoadedPaper) throws NotEnoughPaperException {
        if (priceOfThePrintingMachine <= 0) {
            this.PriceOfThePrintingMachine = 60;
        } else {
            this.PriceOfThePrintingMachine = priceOfThePrintingMachine;
        }
        if (maxCapacityPaperThatIsLoaded <= 0) {
            this.maxCapacityPaperThatIsLoaded = 1;
        } else {
            this.maxCapacityPaperThatIsLoaded = maxCapacityPaperThatIsLoaded;
        }

        this.color = color;

        if (LoadedPaper <= maxCapacityPaperThatIsLoaded) {
            this.LoadedPaper = LoadedPaper;
        } else {
            this.LoadedPaper = maxCapacityPaperThatIsLoaded;
        }
        if (LoadedPaper < 1) {

            throw new NotEnoughPaperException("There is not enough paper in the printing machine! " +
                    "It can be loaded with a maximum of " + this.maxCapacityPaperThatIsLoaded + " papers!", "");
        }
        this.maxPagesPrintedInOneMinute = maxPagesPrintedInOneMinute;

    }


    public ColorType getColor() {
        return color;
    }

    public int getMaxCapacityPaperThatIsLoaded() {
        return maxCapacityPaperThatIsLoaded;
    }

    public int getLoadedPaper() {
        return LoadedPaper;
    }

    public int getMaxPagesPrintedInOneMinute() {
        return maxPagesPrintedInOneMinute;
    }

    public double getPriceOfThePrintingMachine() {
        return PriceOfThePrintingMachine;
    }
}

