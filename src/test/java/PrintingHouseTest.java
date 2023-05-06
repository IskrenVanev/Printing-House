import org.example.Enums.ColorType;
import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
import org.example.Exceptions.NotEnoughPaperException;
import org.example.Exceptions.OutOfMoneyException;
import org.example.Models.Employees.Employee;
import org.example.Models.Employees.Manager;
import org.example.Models.Employees.PrintingMachineOperator;
import org.example.Models.PrintingHouse;
import org.example.Models.PrintingMachine;
import org.example.Models.Prints.Book;
import org.example.Models.Prints.Newspaper;
import org.example.Models.Prints.Poster;
import org.example.Models.Prints.PrintingHousePublication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PrintingHouseTest {
    @Test
    public void testHireEmployee() {
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,1000, 5000, 5);
        Employee employee1 = new Employee("John");
        Employee employee2 = new Employee("Jane");

        printingHouse.hireEmployee(employee1);
        printingHouse.hireEmployee(employee2);

        Set<Employee> employees = printingHouse.getEmployees();

        assertEquals(2, employees.size());
        assertTrue(employees.contains(employee1));
        assertTrue(employees.contains(employee2));
    }

    @Test
    public void testAddToPrintBookOrPosterOrNewspaper() {

        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,20000, 2000, 5);

        // Create a new book
        String bookTitle = "Test Book";
        PageSizeType bookPageSizeType = PageSizeType.A5;
        int bookNumberOfPages = 200;
        double bookOverchargePercentage = 10;
        boolean bookIsColored = true;
        double bookOverchargeIfColored = 0.5;

        PrintingHousePublication book = new Book(bookTitle, bookPageSizeType, bookNumberOfPages,
                bookOverchargePercentage, bookIsColored, bookOverchargeIfColored);

        printingHouse.addToPrintingHousePublications(book);

        assertEquals(1, printingHouse.getPrintingHousePublications().size());
        assertEquals(book, printingHouse.getPrintingHousePublications().get(0));

        // Create a new poster
        String posterTitle = "Test Poster";
        PageSizeType posterPageSizeType = PageSizeType.A3;
        int posterNumberOfPages = 1;
        double posterOverchargePercentage = 5;
        boolean posterIsColored = false;
        double posterOverchargeIfColored = 0;

        PrintingHousePublication poster = new Poster(posterTitle, posterPageSizeType, posterNumberOfPages,
                posterOverchargePercentage, posterIsColored, posterOverchargeIfColored);

        printingHouse.addToPrintingHousePublications(poster);

        assertEquals(2, printingHouse.getPrintingHousePublications().size());
        assertEquals(poster, printingHouse.getPrintingHousePublications().get(1));

        // Create a new newspaper
        String newspaperTitle = "Test Newspaper";
        PageSizeType newspaperPageSizeType = PageSizeType.A4;
        int newspaperNumberOfPages = 20;
        double newspaperOverchargePercentage = 15;
        boolean newspaperIsColored = true;
        double newspaperOverchargeIfColored = 0.25;

        PrintingHousePublication newspaper = new Newspaper(newspaperTitle, newspaperPageSizeType, newspaperNumberOfPages,
                newspaperOverchargePercentage, newspaperIsColored, newspaperOverchargeIfColored);

        printingHouse.addToPrintingHousePublications(newspaper);

        assertEquals(3, printingHouse.getPrintingHousePublications().size());
        assertEquals(newspaper, printingHouse.getPrintingHousePublications().get(2));

    }

    @Test
    public void testBuyPrintingMachinesBW() throws NotEnoughPaperException {

        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,20000, 2000, 5);
        printingHouse.BuyPrintingMachinesBW(70,100, 50, 10, 40);

        PrintingMachine expectedPrintingMachine =
                new PrintingMachine(100,50, ColorType.BLACK_AND_WHITE, 10, 40);
        List<PrintingMachine> printingMachines = printingHouse.getPrintingMachines();
        assertEquals(70, printingMachines.size());


        for (PrintingMachine printingMachine : printingHouse.getPrintingMachines()) {
            assertEquals(expectedPrintingMachine.getColor(), printingMachine.getColor());
            assertEquals(expectedPrintingMachine.getMaxCapacityPaperThatIsLoaded(), printingMachine.getMaxCapacityPaperThatIsLoaded());
            assertEquals(expectedPrintingMachine.getMaxPagesPrintedInOneMinute(), printingMachine.getMaxPagesPrintedInOneMinute());
            assertEquals(expectedPrintingMachine.getLoadedPaper(), printingMachine.getLoadedPaper());
        }
    }

    @Test
    public void testBuyPrintingMachinesCLR() throws NotEnoughPaperException{

        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,20000, 2000, 5);

        printingHouse.BuyPrintingMachinesCLR(70,500, 50, 10, 40);

        PrintingMachine expectedPrintingMachine =
                new PrintingMachine(500,50, ColorType.COLORED, 10, 40);
        List<PrintingMachine> printingMachines = printingHouse.getPrintingMachines();
        assertEquals(70, printingMachines.size());

        for (PrintingMachine printingMachine : printingHouse.getPrintingMachines()) {
            assertEquals(expectedPrintingMachine.getColor(), printingMachine.getColor());
            assertEquals(expectedPrintingMachine.getMaxCapacityPaperThatIsLoaded(), printingMachine.getMaxCapacityPaperThatIsLoaded());
            assertEquals(expectedPrintingMachine.getMaxPagesPrintedInOneMinute(), printingMachine.getMaxPagesPrintedInOneMinute());
            assertEquals(expectedPrintingMachine.getLoadedPaper(), printingMachine.getLoadedPaper());
        }
    }

    @Test
    public void testBuyMixedPrintingMachines() throws NotEnoughPaperException{
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,20000, 2000, 5);
        printingHouse.BuyPrintingMachinesCLR(70,5, 50, 10, 40);
        printingHouse.BuyPrintingMachinesBW(70,2, 50, 10, 40);


        List<PrintingMachine> printingMachines = printingHouse.getPrintingMachines();
        assertEquals(140, printingMachines.size());
    }

    @Test
    public void testCalculatePrintingHouseIncomeIfIsColoredIsFalse() {
        // Create a new printing house object
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,1000, 10, 100);

        // Create a new printing house publication object and add it to the printing house
        PrintingHousePublication publication = new Book("The Lord of the Rings", PageSizeType.A4,
                100, 10.0, false, 1);
        printingHouse.addToPrintingHousePublications(publication);

        printingHouse.CalculatePrintingHouseIncome(2);
        //1.95 income
        double expectedIncome = 1.95;
        assertEquals(expectedIncome, printingHouse.CalculatePrintingHouseIncome(2), 0.01);


    }

    @Test
    public void testCalculatePrintingHouseIncomeIfIsColoredIsTrue() {
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,1000, 10, 100);

        // Create a new printing house publication object and add it to the printing house
        PrintingHousePublication publication = new Book("The Lord of the Rings", PageSizeType.A4,
                100, 10.0, true, 10);
        printingHouse.addToPrintingHousePublications(publication);
        printingHouse.CalculatePrintingHouseIncome(2);
        double expectedIncome = 2.73;
        assertEquals(expectedIncome, printingHouse.CalculatePrintingHouseIncome(2), 0.01);
    }

    @Test
    public void calculateTotalSalaryExpenses() throws OutOfMoneyException {
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,2.5, 1000, 100);
        Employee employee = new PrintingMachineOperator("Ivan");
        Employee employee2 = new Manager("Iskren", 10);
        PrintingHousePublication publication = new Book("The Lord of the Rings", PageSizeType.A4,
                100, 10.0, true, 10);
        printingHouse.addToPrintingHousePublications(publication);
        printingHouse.CalculatePrintingHouseIncome(2);

        printingHouse.hireEmployee(employee);
        printingHouse.hireEmployee(employee2);
        double expectedSalaryExpenses = 2100;
        assertEquals(expectedSalaryExpenses, printingHouse.calculateTotalSalaryExpenses());

    }

    @Test
    public void calculateTotalSalaryExpensesIfExpectedIncomeIsBiggerThanActual() throws OutOfMoneyException{
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,3, 1000, 100);
        Employee employee = new PrintingMachineOperator("Ivan");
        Employee employee2 = new Manager("Iskren", 10);
        PrintingHousePublication publication = new Book("The Lord of the Rings", PageSizeType.A4,
                100, 10.0, true, 10);
        printingHouse.addToPrintingHousePublications(publication);
        printingHouse.CalculatePrintingHouseIncome(2);

        printingHouse.hireEmployee(employee);
        printingHouse.hireEmployee(employee2);
        double expectedSalaryExpenses = 2000;
        assertEquals(expectedSalaryExpenses, printingHouse.calculateTotalSalaryExpenses());

    }

    @Test
    public void buyPaperTest(){
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,3, 100, 100);
        printingHouse.buyPaper(100, PaperType.REGULAR, PageSizeType.A4);
        double expectedPaperPrice = 25;
        assertEquals(expectedPaperPrice, printingHouse.buyPaper(100, PaperType.REGULAR, PageSizeType.A4));
    }
    @Test
    public void calculatePaperExpenses(){
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",100000,3, 100, 100);
        printingHouse.buyPaper(100, PaperType.REGULAR, PageSizeType.A4);
        printingHouse.buyPaper(100, PaperType.REGULAR, PageSizeType.A4);
        double expectedCalculation = 50;

        assertEquals(expectedCalculation, printingHouse.calculatePaperExpenses());
    }

    @Test
    public void OutOfMoneyExceptionTest(){
        PrintingHouse printingHouse = new PrintingHouse("IskoPHouse",10,3, 1000, 100);
        Employee employee = new PrintingMachineOperator("Iskrata");
        printingHouse.hireEmployee(employee);

        OutOfMoneyException exception = assertThrows(OutOfMoneyException.class, () -> {
            printingHouse.calculateTotalSalaryExpenses();
        });
        assertEquals("The company is out of money. Salaries will not be payed this month.", exception.getMessage());

    }
}
