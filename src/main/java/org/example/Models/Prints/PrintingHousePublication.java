package org.example.Models.Prints;

import org.example.Enums.ColorType;
import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
import org.example.Models.PrintingMachine;
//import org.example.Enums.ThingType;

public abstract class PrintingHousePublication {

    private String title;

    private PageSizeType pageSizeType;
    protected int numberOfPages;


    private double sellingPrice;
    private double overchargePercentage;
    private boolean isColored;

    private double OverchargeIfColored;

    public PrintingHousePublication(String title, PageSizeType pageSizeType, int numberOfPages,
                                    double overchargePercentage,boolean isColored, double overchargeIfColored) {

        this.title = title;

        this.pageSizeType = pageSizeType;
        this.numberOfPages = numberOfPages;

        this.overchargePercentage = overchargePercentage;
        this.isColored = isColored;
        if (isColored){
            this.OverchargeIfColored = overchargeIfColored;
        }
        else {
            this.OverchargeIfColored = 0;
        }

        this.sellingPrice = calculateSellingPrice();
    }

    public double calculateSellingPrice() {

       PageSizeType pageSize = this.pageSizeType;
        double overchargeAmount = getPriceForPrinting(pageSize) * overchargePercentage / 100;
        return getPriceForPrinting(pageSize) + overchargeAmount;
    }

    public boolean getIsColored() {
        return isColored;
    }

    public double getOverchargePercentage() {
        return overchargePercentage;
    }

    public double getPriceForPrinting(PageSizeType pageSizeType) {

        PaperType paperType = getPaperType();
        double price = numberOfPages * paperType.getPrice(pageSizeType);
        if (this.getIsColored() == true){
          double overcharge =  this.numberOfPages * this.OverchargeIfColored;
          price += overcharge;
        }

        return price;
    }

    protected abstract PaperType getPaperType();

    public String getTitle() {
        return title;
    }

    public PageSizeType getPageSize() {
        return pageSizeType;
    }


    @Override
    public String toString() {
        return "PrintingHousePublication{" +
                "title='" + title + '\'' +
                ", pageSizeType=" + pageSizeType +
                ", numberOfPages=" + numberOfPages +
                '}';
    }



}
