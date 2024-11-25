package src;

import java.util.Objects;

/**
 * This is a testing class and is simply used to test the functionality of existing methods(for the testing of inputs
 * via the terminal I will leave comments below on my inputs and the return values)
 */
public class Testing {
    public static void main(String[] args) {
        Sale test1 = new Sale(0, "TYQ123", 1200, 4, 2000);
        if (test1.getHouseNumber() == 0 && Objects.equals(test1.getPostcode(), "TYQ123") && test1.getValue() == 1200
                && test1.getMonthSold() == 4 && test1.getYearSold() == 2000) {
            System.out.println("test1 passed");
        }
        else {
            System.out.println("test1 failed");
        }
        try {
            Sale test2 = new Sale(1, "123456789", 1300, 4, 1980);
            System.out.println("test2 failed");
        } catch (IllegalArgumentException e) {
            System.out.println("test2 passed");
        }
        try {
            Sale test3 = new Sale(2, "123 456", 1400, 5, 2023);
            System.out.println("test3 passed");
        } catch (IllegalArgumentException e) {
            System.out.println("test3 failed");
        }
        try {
            Sale test4 = new Sale(3, "WE6845", 1500, 12, 2022);
            System.out.println("test4 passed");
        } catch (IllegalArgumentException e) {
            System.out.println("test4 failed");
        }
        Branch test5 = new Branch("Branch1");
        test5.addToListOfSales(new Sale(0, "TE34ST", 4000, 6, 2000));
        test5.addToListOfSales(new Sale(1, "TE35ST", 8000, 6, 2000));
        test5.addToListOfSales(new Sale(2, "TE36ST", 12000, 6, 2000));
        if (test5.maxSale().getValue() == 12000 && test5.avgSale() == 8000 &&
                test5.greaterSales(7999).size() == 2 && test5.greaterSales(8000).size() == 1) {
            System.out.println("test5 passed");
        }
        else {
            System.out.println("test5 failed");
        }
        Branch test6 = new Branch("Branch2");
        try{
            test6.maxSale();
            System.out.println("test6 failed");
        }
        catch(RuntimeException e){
            System.out.println("test6 passed");
        }
        /*ReportingIO tested through command Line
        When ran:
        On the main menu
        Typing 1 caused the enterBranchData method to be called as expected
            -It then asked the user to enter a Branch Name which would always be accepted
            -It then gave the user the option to either enter branch data or exit
                -Typing 1 caused the enterSalesData method to be called as expected
                -Typing 2 caused the user to return to the main menu
                -Typing anything else caused the program to again ask the user to enter an int 1-2
        Typing 2 caused the enterSalesData method to be called as expected
            -It then asked the user to enter the branch name that they wish to add the sale to (note: if this was
            requested from the enterBranchData method this was bypassed)
            -If the branch name was not on the system it then it would ask the user again to enter the branch name they
            wish to add the sale for.
            -It would then ask the user to enter the data for the sale one at a time(for the 4 integer fields it would
            detect if it wasn't an integer and ask the user again to input the data)
            -It would then attempt to create an object from the Sales class given that data, any more complex errors
            such as entering a date in the future would then be picked up their
        Typing 3 4 and 5(before entering any data had been entered) caused  the program to return a RunTimeError as
        with a description of what caused it as these commands could not be carried out on an empty
        Typing 3 (with data) caused information about data with the highest average to be output
        Typing 4 (with data) caused information about the highest sale to be output
        Typing 5 (with data) caused the program to call the salesGreaterThan method as expected
            -It would then prompt the user to enter the value that they wish to see sales greater than
            -If the user did not input an integer it would repeat and ask them once again to enter the value
            -If the user entered an integer the sales greater than that value would then be output to the console
        After every process above process had finished it returned to the main menu
        Typing 6 caused the program to shut down as expected*/
    }
}

