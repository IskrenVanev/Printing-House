package org.example.Models.Prints;

import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;

public class Newspaper extends PrintingHousePublication {
    public Newspaper(String title, PageSizeType pageSizeType, int numberOfPages, double overchargePercentage,boolean isColored, double overchargeIfColoredPercentage) {
        super(title, pageSizeType, numberOfPages,overchargePercentage, isColored, overchargeIfColoredPercentage);
    }
    @Override
    protected PaperType getPaperType() {
        return PaperType.NEWSPAPER;
    }

}
