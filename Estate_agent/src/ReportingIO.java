import java.util.Objects;
import java.util.Scanner;

/**
 * The ReportingIO class is designed to provide an interface that allows the user to interact with the rest of the
 * class, allowing them to both input data and retrieve data.
 */
public class ReportingIO {

    final private static Reporting r = new Reporting();
    final private static ReportingIO IO = new ReportingIO();

    public static Reporting getR() {
        return r;
    }

    public static ReportingIO getIO() {
        return IO;
    }

    public static void main(String[] args) {
       getIO().menu();
    }

    /**
     * The menu method is designed to create an interactive menu that allows the user to select what they want to do,
     * it will loop at the end of each task until the user decides to select the exit option.
     */
    public void menu(){
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop){ // loops through a menu system until the user decides to exit
            System.out.println("Menu please enter an int 1-6:");
            System.out.println("1. Enter Branch data");
            System.out.println("2. Enter Sale data");
            System.out.println("3. See branch with highest average sale");
            System.out.println("4. See the highest sale ever recorded");
            System.out.println("5. See all sales greater than a given value");
            System.out.println("6. Exit");
            while (!sc.hasNextInt()){ // checks that the input is valid
                System.out.println("Please enter an int 1-6");
                sc.nextLine(); // clears the old input
            }
            int selection = sc.nextInt();
            sc.nextLine();
            switch (selection) { // carries out the appropriate command according to the users input
                case 1 -> enterBranchData();
                case 2 -> enterSaleData("");
                case 3 -> highestAvg();
                case 4 -> highestSale();
                case 5 -> salesGreaterThan();
                case 6 -> loop = false;
            }



        }
    }

    /**
     * The enterBranchData method allows the user to add a branch object to the Reporting class and gives the option to
     * add sales to that branch
     */
    public void enterBranchData() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String branchName = null;
        while (loop) { /* asks the user for a branch name and checks to see if the branch already exists before
            implementing */
            System.out.println("Please enter the branch name");
            branchName = sc.nextLine();
            loop = false;
            for (Branch b : getR().getListOfBranches()) {
                if (Objects.equals(branchName, b.getBranchName())) {
                    loop = true;
                    break;
                    }
            }

        }
        getR().addToListOfBranches(new Branch(branchName)); /* creates a new instance from the branch class and adds it
        to the list of branches in the object R of the reporting class */
        loop = true;
        while (loop) { /* implements a menu system that gives the user the option to return to the main menu or to add
         a sale to the branch*/
            System.out.println("Please enter an int 1-2:");
            System.out.println("1. To add a sale to this branch");
            System.out.println("2. To return to the main menu");
            while (!sc.hasNextInt()) { // checks that the input is valid
                System.out.println("Please enter an int 1-2");
                sc.nextLine(); // clears the old input
            }
            int selection =sc.nextInt();
            switch(selection){ // carries out the appropriate command according to the users input
                case 1 -> enterSaleData(branchName);
                case 2 -> loop = false;
            }
        }
    }

    /**
     * Enter sale data allows the user to enter sale data about a specific sale and link it to a branch
     * @param branchName - Type String - the name of the branch that the user wants to access (will be empty and asked
     *                   for later unless supplied by a function call from the enterBranchData method)
     */
    public void enterSaleData(String branchName) {
        Scanner sc = new Scanner(System.in);
        System.out.println(branchName);
        if (Objects.equals(branchName, "")) { /* if called from the main menu asks the user to define which branch
        they wish to add the sale to */
            System.out.println("Please enter the name of the branch you wish to add a sale to");
            branchName = sc.nextLine();
        }
        boolean loop = true;
        Branch branch = null;
        while (true) { // checks that the branch that has been named exists in the Reporting object
            for (Branch b : getR().getListOfBranches()) {
                if (Objects.equals(branchName, b.getBranchName())) {
                    branch = b;
                    loop = false;
                    break;
                }
            }
            if (!loop){
                break;
            }
            System.out.println("This branch is not in our list, please enter another branch name");
            branchName = sc.nextLine();
        }
        // takes all the sale data as inputs with some simple checks for invalid inputs
        System.out.println("Please enter the house number of the sale(must be an integer)");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter the house number of the sale(must be an integer)");
            sc.nextLine();
        }
        int houseNumber = sc.nextInt();
        System.out.println("Please enter the value that the house was sold at(must be an integer, assume pounds" +
                "as the measurement)");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter the value that the house was sold at(must be an integer, assume pounds " +
                    "as the measurement)");
            sc.nextLine();
        }
        int value = sc.nextInt();
        System.out.println("Please enter the year the house was sold(must be an integer)");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter the year the house was sold(must be an integer)");
            sc.nextLine();
        }
        int yearSold = sc.nextInt();
        System.out.println("Please enter the month the house was sold(must be an integer 1-12");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter the month the house was sold(must be an integer 1-12");
            sc.nextLine();
        }
        int monthSold = sc.nextInt();
        System.out.println("Please enter the postcode of the house of the sale(must be between 6-8 characters)");
        sc.nextLine();
        String postcode = sc.nextLine();
        branch.addToListOfSales(new Sale(houseNumber, postcode, value, monthSold, yearSold));
    }

    /**
     * Finds the branch with the highest average sale and outputs it to the user
     */
    public void highestAvg(){
        System.out.println(getR().highestAvg()); /* implements the existing method in Reporting class in order to find
        the branch with the highest average and outputs it to the user */
    }

    /**
     * Finds the highest sale and outputs it to the user
     */
    public void highestSale(){
        System.out.println(getR().highestSale()); /* implements the existing method in Reporting class in order to find
        the highest sale across all branches */
    }

    /**
     * Outputs to the console the list of Sales greater than a user specified value
     */
    public void salesGreaterThan(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the value you wish to see sales greater than(must be an integer");
        while (!sc.hasNextInt()){ // Repeats until the user gives a valid input for value
            System.out.println("Please enter the value you wish to see sales greater than(must be an integer");
            sc.nextLine();
        }
        int value = sc.nextInt();
        System.out.println(getR().greaterBranchSales(value));
    }

}
