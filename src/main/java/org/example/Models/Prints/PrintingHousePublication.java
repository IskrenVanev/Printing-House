package org.example.Models.Prints;

import org.example.Enums.ColorType;
import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
import org.example.Models.PrintingMachine;

import java.io.Serializable;
//import org.example.Enums.ThingType;

public abstract class PrintingHousePublication implements Serializable {

    private String title;

    private PageSizeType pageSizeType;
    protected int numberOfPages;


    private double sellingPrice;
    private double overchargePercentage;
    private boolean isColored;

    private double OverchargeIfColoredPercentage;

    public PrintingHousePublication(String title, PageSizeType pageSizeType, int numberOfPages,
                                    double overchargePercentage,boolean isColored, double overchargeIfColoredPercentage) {

        if (overchargePercentage <= 0) {
            throw new IllegalArgumentException("Overcharge percentage cannot be negative or 0");
        }

        this.title = title;

        this.pageSizeType = pageSizeType;
        this.numberOfPages = numberOfPages;

        this.overchargePercentage = overchargePercentage;
        this.isColored = isColored;
        if (isColored && overchargeIfColoredPercentage >= 0){
            this.OverchargeIfColoredPercentage = overchargeIfColoredPercentage;
        }
        else {
            this.OverchargeIfColoredPercentage = 0;
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
          double overcharge =  this.numberOfPages * (this.OverchargeIfColoredPercentage/100);
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
