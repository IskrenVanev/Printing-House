package org.example.Models.Prints;

import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;

public class Poster extends PrintingHousePublication {
    public Poster(String title, PageSizeType pageSizeType, int numberOfPages, double overchargePercentage,boolean isColored, double overchargeIfColoredPercentage ) {
        super(title, pageSizeType, numberOfPages,overchargePercentage, isColored, overchargeIfColoredPercentage );
    }
    @Override
    protected PaperType getPaperType() {
        return PaperType.GLOSSY;
    }


}
