package org.example.Enums;

public enum PaperType {
    REGULAR,
    GLOSSY,
    NEWSPAPER;

    public double getPrice(PageSizeType pageSize) {
        switch (this) {
            case REGULAR:
                return getPriceForRegularPaper(pageSize);
            case GLOSSY:
                return getPriceForGlossyPaper(pageSize);
            case NEWSPAPER:
                return getPriceForNewspaperPaper(pageSize);
            default:
                throw new IllegalArgumentException("Unsupported paper type: " + this);  //TODO:Catch this
        }
    }
    private double getPriceForRegularPaper(PageSizeType pageSize) {
        switch (pageSize) {
            case A1:
                return 2.50;
            case A2:
                return 1.50;
            case A3:
                return 1.00;
            case A4:
                return 0.75;
            case A5:
                return 0.50;
            default:
                throw new IllegalArgumentException("Unsupported page size: " + pageSize); //TODO: Catch this
        }
    }

    private double getPriceForGlossyPaper(PageSizeType pageSize) {
        switch (pageSize) {
            case A1:
                return 3.50;
            case A2:
                return 2.50;
            case A3:
                return 2.00;
            case A4:
                return 1.75;
            case A5:
                return 1.50;
            default:
                throw new IllegalArgumentException("Unsupported page size: " + pageSize); //TODO: Catch this
        }
    }

    private double getPriceForNewspaperPaper(PageSizeType pageSize) {
        switch (pageSize) {
            case A1:
                return 1.50;
            case A2:
                return 0.50;
            case A3:
                return 0.40;
            case A4:
                return 0.35;
            case A5:
                return 0.30;
            default:
                throw new IllegalArgumentException("Unsupported page size: " + pageSize); //TODO: Catch this
        }
    }
}
