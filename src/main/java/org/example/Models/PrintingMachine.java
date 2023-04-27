package org.example.Models;

import org.example.Enums.ColorType;
import org.example.Exceptions.NotEnoughPaperException;

public class PrintingMachine {
    private int maxCapacityPaperThatIsLoaded;
    private ColorType color;

    private int maxPagesPrintedInOneMinute;

    public PrintingMachine(int maxCapacityPaperThatIsLoaded, ColorType color, int maxPagesPrintedInOneMinute) {
        this.maxCapacityPaperThatIsLoaded = maxCapacityPaperThatIsLoaded;
        this.color = color;

    }

    public void setMaxPagesPrintedInOneMinute(int maxPagesPrintedInOneMinute) throws NotEnoughPaperException {
        if (maxCapacityPaperThatIsLoaded < 1){
            //TODO : check this again, it seeems wrong
        throw new NotEnoughPaperException("There is not enough paper in the printing machine! There are ", maxCapacityPaperThatIsLoaded + "papers left");
        }
        this.maxPagesPrintedInOneMinute = maxPagesPrintedInOneMinute;
    }


}
