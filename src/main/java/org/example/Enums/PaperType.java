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
                return 0.50;
            case A2:
                return 0.40;
            case A3:
                return 0.30;
            case A4:
                return 0.25;
            case A5:
                return 0.10;
            default:
                throw new IllegalArgumentException("Unsupported page size: " + pageSize); //TODO: Catch this
        }
    }

    private double getPriceForGlossyPaper(PageSizeType pageSize) {
        switch (pageSize) {
            case A1:
                return 1.50;
            case A2:
                return 1.10;
            case A3:
                return 0.80;
            case A4:
                return 0.45;
            case A5:
                return 0.20;
            default:
                throw new IllegalArgumentException("Unsupported page size: " + pageSize); //TODO: Catch this
        }
    }

    private double getPriceForNewspaperPaper(PageSizeType pageSize) {
        switch (pageSize) {
            case A1:
                return 0.40;
            case A2:
                return 0.30;
            case A3:
                return 0.20;
            case A4:
                return 0.15;
            case A5:
                return 0.5;
            default:
                throw new IllegalArgumentException("Unsupported page size: " + pageSize); //TODO: Catch this
        }
    }
}
