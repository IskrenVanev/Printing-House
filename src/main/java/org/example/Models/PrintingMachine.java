package org.example.Models;

import org.example.Enums.ColorType;
import org.example.Exceptions.NotEnoughPaperException;

public class PrintingMachine {
    private int maxCapacityPaperThatIsLoaded; //for example 50
    private int LoadedPaper;//for example 40
    private ColorType color;

    private int maxPagesPrintedInOneMinute; //for example 10

    public PrintingMachine(int maxCapacityPaperThatIsLoaded, ColorType color, int maxPagesPrintedInOneMinute,int LoadedPaper) {
        this.maxCapacityPaperThatIsLoaded = maxCapacityPaperThatIsLoaded;
        this.color = color;
        if (LoadedPaper <= maxCapacityPaperThatIsLoaded){
            this.LoadedPaper = LoadedPaper;
        }
        else {
            this.LoadedPaper = maxCapacityPaperThatIsLoaded;
        }


    }

    public void setMaxPagesPrintedInOneMinute(int maxPagesPrintedInOneMinute) throws NotEnoughPaperException {
        if (LoadedPaper < 1){

        throw new NotEnoughPaperException("There is not enough paper in the printing machine!" +
                "It can be loaded with maximum of ", maxCapacityPaperThatIsLoaded + " papers!");
        }//TODO:catch!
        this.maxPagesPrintedInOneMinute = maxPagesPrintedInOneMinute;
    }


}
