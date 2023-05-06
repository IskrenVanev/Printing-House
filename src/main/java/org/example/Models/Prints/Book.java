package org.example.Models.Prints;

import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;

public class Book extends PrintingHousePublication {
    public Book(String title, PageSizeType pageSizeType, int numberOfPages, double overchargePercentage,boolean isColored, double overchargeIfColoredPercentage) {
        super(title, pageSizeType, numberOfPages,overchargePercentage, isColored, overchargeIfColoredPercentage);
    }


    @Override
    protected PaperType getPaperType() {
        return PaperType.REGULAR;
    }

    @Override
    public String toString() {
        return "Book{" +
                "numberOfPages=" + numberOfPages +
                "} " + super.toString();
    }
}
