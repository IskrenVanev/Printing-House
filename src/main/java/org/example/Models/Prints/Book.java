package org.example.Models.Prints;

import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;

public class Book extends PrintingHousePublication {
    public Book(String title, PageSizeType pageSizeType, int numberOfPages,double printingPrice, double overchargePercentage) {
        super(title, pageSizeType, numberOfPages,printingPrice,overchargePercentage);
    }


    @Override
    protected PaperType getPaperType() {
        return PaperType.REGULAR;
    }
}
