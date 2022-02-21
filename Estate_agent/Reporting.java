package Estate_agent;

import java.util.ArrayList;

public class Reporting {
    private ArrayList<Branch> listOfBranches;

    /**
     * This is a constructor method which links the parameters to the fields
     * @param listOfBranches - the list of Branches
     */
    public Reporting(ArrayList<Branch> listOfBranches){
        setListOfBranches(listOfBranches);
    }

    public ArrayList<Branch> getListOfBranches() {
        return listOfBranches;
    }

    public void setListOfBranches(ArrayList<Branch> listOfBranches) {
        this.listOfBranches = listOfBranches;
    }

    /**
     * Checks that the list of branches is not empty
     */
    public void checkBranchesList() {
        if (getListOfBranches().size() == 0) { /*Causes the program to crash if this method is run while listOfBranches
            is empty*/
            throw new RuntimeException("At this moment in time there are no Branches in this list");
        }
    }

    /**
     * This method returns the branch with the highest sale average from the listOfBranches
     * @return - Type Branch - the branch with the highest sale average
     */
    public Branch highestAvg(){
        checkBranchesList();
        Branch highestAvg = null;
        for (Branch b : getListOfBranches()){ /* repeats through the list of branches setting the highestAvg to the
        branch with the higher average each time*/
            if (highestAvg == null){
                highestAvg = b;
            }
            if (highestAvg.avgSale() < b.avgSale()){
                highestAvg = b;
            }
        }
        return highestAvg;
    }

    /**
     * This method returns the sale with the highest value from all the sales in the branches listed in listOfBranches
     * @return - Type Sale - the sale with the highest value
     */
    public Sale highestSale(){
        checkBranchesList();
        Sale highestSale = null;
        for (Branch b : getListOfBranches()){ /* repeats through the list of branches setting the highestSale to the
        Sale with the higher value each time */
            if (highestSale == null){
                highestSale = b.maxSale();
            }
            if (highestSale.getValue() < b.maxSale().getValue()){
                highestSale = b.maxSale();
            }
        }
        return highestSale;
    }

    /**
     * This method returns the list of sales over a given value from all the sales in the branches listed in
     * listOfBranches
     * @param value - the value you are checking that the sales are over
     * @return - Type ArrayList<Sale> - returns the list of sales that are over the specified value
     */
    public ArrayList<Sale> greaterBranchSales(int value){
        checkBranchesList();
        ArrayList<Sale> greaterBranchSales = new ArrayList<>();
        for (Branch b : getListOfBranches()){ /* repeats through the list of branches and adds all the sales within
        that branch that are over the specified value */
            greaterBranchSales.addAll(b.greaterSales(value));
        }
        return greaterBranchSales;
    }
}
