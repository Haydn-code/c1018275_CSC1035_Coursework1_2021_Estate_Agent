import java.util.ArrayList;

/**
 * This is a class Branch which stores the branch name and a list of sales made by the branch.
 * It also contains some methods allowing it to return certain sales of importance.
 */
public class Branch {
    private String branchName;
    private ArrayList<Sale> listOfSales = new ArrayList<>();

    /**
     * This is a constructor method which links the parameters to the fields of the class
     * @param branchName - the name of the branch
     */
    public Branch(String branchName){
        setBranchName(branchName);
    }

    public ArrayList<Sale> getListOfSales() {
        return listOfSales;
    }

    public String getBranchName() {
        return branchName;
    }

    /**
     * Allows the user to add a sale to listOfSales
     * @param s - Type Sale - the sale to be added
     */
    public void addToListOfSales(Sale s) {
        this.listOfSales.add(s);
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * Checks that the list of sales is not empty
     */
    public void checkSalesList(){
        if (getListOfSales().size() == 0){ /*Causes the program to crash if this method is run while listOfSales is
            empty*/
            throw new RuntimeException("At this moment in time there are no Sales in this branch");
        }
    }

    /**
     * Method that returns the sale of maximum value made by the branch
     * @return - Type Sale - the sale of max value
     */
    public Sale maxSale(){
        checkSalesList();
        Sale maxSale = null;
        for(Sale s : getListOfSales()){ /*iterates through the list of sales until the end where the sale of maximum
        values will be assigned to maxSale and returned*/
            if (maxSale == null){
                maxSale = s;
            }
            if (maxSale.getValue() < s.getValue()){
                maxSale = s;
            }
        }
        return maxSale;
    }

    /**
     * Method that returns the avg value of sales made by the branch
     * @return - Type double - the average value of a sale made by a branch
     */
    public double avgSale(){
        checkSalesList();
        double totalSale = 0;
        for(Sale s : getListOfSales()){ // adds up the total value from sales
            totalSale += s.getValue();
        }
        return totalSale/getListOfSales().size(); // divides the total value of sales by the amount of sales made

    }

    /**
     * Method that returns a list of sales over a given value
     * @param Value - the value you are checking for sales that are over
     * @return - Type ArrayList[Sale] - returns a list of sales that are over the specified value
     */
    public ArrayList<Sale> greaterSales(int Value){
        checkSalesList();
        ArrayList<Sale> greaterSales = new ArrayList<>();
        for(Sale s : getListOfSales()){ // adds a sale to the array greaterSales for every sale over the specified value
            if(s.getValue() > Value){
                greaterSales.add(s);
            }
        }
        return greaterSales;
    }

    /**
     * Added a toString method which will allow a human-readable form of the branch class to be output to the console
     * @return - Type String - a string format of the branch object
     */
    public String toString(){
        StringBuilder salesList = new StringBuilder();
        for (Sale s : getListOfSales()){ /* iterates through all the sales in the list to create a string of the list of
             sales */
            salesList.append(s.toString()).append(" ");
        }
        return "Name: " + getBranchName() + " Avg Sale: " + avgSale() + " Max Sale: " + maxSale() + " list of sales: "
        + salesList;

    }
}

