import org.example.Enums.PageSizeType;
import org.example.Models.Prints.Book;
import org.example.Models.Prints.PrintingHousePublication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PrintingHousePublicationsTest {

   @Test
   void testCalculateSellingPrice() {
       Book book = new Book("My Book", PageSizeType.A4, 100, 10.0, true, 1);
       double expectedSellingPrice = 28.60;
       double actualSellingPrice = book.calculateSellingPrice();
       assertEquals(expectedSellingPrice, actualSellingPrice);
   }

    @Test
    public void testGetPriceForPrinting() {
        PrintingHousePublication publication = new Book("The Lord of the Rings", PageSizeType.A4, 100, 10.0, true, 1);
        double expectedPrice = 26;
        double actualPrice = publication.getPriceForPrinting(PageSizeType.A4);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }


}