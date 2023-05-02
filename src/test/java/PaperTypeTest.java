package org.example.Enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaperTypeTest {

    @Test
    public void testGetPriceForRegularPaper() {
        double expectedPrice = 0.25;
        double actualPrice = PaperType.REGULAR.getPrice(PageSizeType.A4);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testGetPriceForGlossyPaper() {
        double expectedPrice = 1.1;
        double actualPrice = PaperType.GLOSSY.getPrice(PageSizeType.A2);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testGetPriceForNewspaperPaper() {
        double expectedPrice = 0.5;
        double actualPrice = PaperType.NEWSPAPER.getPrice(PageSizeType.A5);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testGetPriceThrowsExceptionForUnsupportedPaperType() {
        assertThrows(IllegalArgumentException.class, () -> {
            PaperType unsupportedPaperType = PaperType.valueOf("INVALID");
            unsupportedPaperType.getPrice(PageSizeType.A4);
        });
    }

    @Test
    public void testGetPriceThrowsExceptionForUnsupportedPageSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            PaperType.REGULAR.getPrice(PageSizeType.valueOf("LETTER"));
        });
    }

}