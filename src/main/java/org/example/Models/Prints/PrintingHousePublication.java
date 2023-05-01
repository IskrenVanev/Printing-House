package org.example.Models.Prints;

import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
//import org.example.Enums.ThingType;

public abstract class PrintingHousePublication {

    private String title;

    private PageSizeType pageSizeType;
    protected int numberOfPages;

    private double printingPrice;
    private double sellingPrice;
    private double overchargePercentage;

    public PrintingHousePublication(String title, PageSizeType pageSizeType, int numberOfPages, double printingPrice, double overchargePercentage) {

        this.title = title;

        this.pageSizeType = pageSizeType;
        this.numberOfPages = numberOfPages;
        this.printingPrice = printingPrice;
        this.overchargePercentage = overchargePercentage;
        this.sellingPrice = calculateSellingPrice();
    }

    private double calculateSellingPrice() {
        double overchargeAmount = printingPrice * overchargePercentage / 100;
        return printingPrice + overchargeAmount;
    }


    public double getOverchargePercentage() {
        return overchargePercentage;
    }

    public double getPriceForPrinting(PageSizeType pageSizeType) {
        PaperType paperType = getPaperType();

        double price = numberOfPages * paperType.getPrice(pageSizeType);
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
