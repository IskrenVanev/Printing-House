package org.example.Models;

import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
import org.example.Enums.ThingType;

public class PrintBookOrPosterOrNewspaper {
    private static int nextId = 0;
    private ThingType thingType;
    private String title;
    private int id;
    private PageSizeType pageSizeType;
    private int numberOfPages;

    public PrintBookOrPosterOrNewspaper(ThingType thingType, String title, PageSizeType pageSizeType, int numberOfPages) {
        this.thingType = thingType;
        this.title = title;
        this.id = ++nextId;
        this.pageSizeType = pageSizeType;
        this.numberOfPages = numberOfPages;
    }

    public double GetPriceForPrintingSomething(PrintBookOrPosterOrNewspaper thing, PageSizeType pageSizeType) {// price for one Book/Poster/Newspaper


        int numberOfPages = this.numberOfPages;
        PaperType paperType = null;//for example regular paper
        ThingType thingType = thing.thingType;//for example book
        if (thingType == ThingType.BOOK) {

            paperType = PaperType.REGULAR;
        } else if (thingType == ThingType.POSTER) {
            paperType = PaperType.GLOSSY;
        } else if (thingType == ThingType.NEWSPAPER) {
            paperType = PaperType.NEWSPAPER;
        }
        double PriceSum = numberOfPages * paperType.getPrice(pageSizeType);


        return PriceSum;//returns the cost of printing something
    }

    public String getTitle() {
        return title;
    }


    public int getId() {
        return id;
    }


    public PageSizeType getPageSize() {
        return pageSizeType;
    }


    public ThingType getThingType() {
        return thingType;
    }

    @Override
    public String toString() {
        return "PrintSomething{" +
                "thingType=" + thingType +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", pageSizeType=" + pageSizeType +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
