import org.example.Enums.ColorType;
import org.example.Exceptions.NotEnoughPaperException;
import org.example.Models.PrintingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintingMachineTest {
    @Test
    public void testConstructorWithValidInput() throws NotEnoughPaperException {
        PrintingMachine pm = new PrintingMachine(70,50, ColorType.BLACK_AND_WHITE, 10, 40);
        assertEquals(ColorType.BLACK_AND_WHITE, pm.getColor());
        assertEquals(50, pm.getMaxCapacityPaperThatIsLoaded());
        assertEquals(40, pm.getLoadedPaper());
        assertEquals(10, pm.getMaxPagesPrintedInOneMinute());
    }
    @Test
    public void testConstructorWithTooManyLoadedPapers() throws NotEnoughPaperException {
        PrintingMachine pm = new PrintingMachine(70,50, ColorType.BLACK_AND_WHITE, 10, 60);
        assertEquals(ColorType.BLACK_AND_WHITE, pm.getColor());
        assertEquals(50, pm.getMaxCapacityPaperThatIsLoaded());
        assertEquals(50, pm.getLoadedPaper());
        assertEquals(10, pm.getMaxPagesPrintedInOneMinute());
    }
    @Test
    public void testConstructorWithNotEnoughLoadedPapers() {
        NotEnoughPaperException exception = assertThrows(NotEnoughPaperException.class, () -> {
            new PrintingMachine(70,50, ColorType.BLACK_AND_WHITE, 10, 0);
        });
        assertEquals("There is not enough paper in the printing machine! It can be loaded with a maximum of 50 papers!", exception.getMessage());
    }

}
