package org.example.Models;

import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
import org.example.Enums.ThingType;

public class PrintSomething {
    private ThingType thingType;
    private String title;
    private int id;
    private PageSizeType pageSizeType;
    private int numberOfPages;

    public PrintSomething(ThingType thingType,String title, int id, PageSizeType pageSizeType, int numberOfPages) {
        this.thingType = thingType;
        this.title = title;
        this.id = id;
        this.pageSizeType = pageSizeType;
        this.numberOfPages= numberOfPages;
    }

    public double PrintTheThing(PrintSomething thing, PageSizeType pageSizeType){//we have already created an object of this class and now we want to print it

        //При отпечатването на всяко издание може да се използва обикновена хартия, гланцирана
        //хартия или хартия за отпечатване на вестници. Цената на хартията се определя от размера и
        //типа ѝ
        int numberOfPages = this.numberOfPages;
        PaperType paperType = null;//for example regular paper
        ThingType thingType = thing.thingType;//for example book
        if (thingType == ThingType.BOOK){
           
            paperType = PaperType.REGULAR;
        }
        else if (thingType == ThingType.POSTER) {
            paperType = PaperType.GLOSSY;
        }
        else if(thingType == ThingType.NEWSPAPER){
            paperType = PaperType.NEWSPAPER;
        }
        double PriceSum=numberOfPages*paperType.getPrice(pageSizeType);




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


}
