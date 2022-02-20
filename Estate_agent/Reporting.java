package Estate_agent;
import java.util.List;
import java.util.ArrayList;

public class Reporting {
    private String branchName;
    private ArrayList<Sale> listOfSales;

    public List<Sale> getListOfSales() {
        return listOfSales;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setListOfSales(ArrayList<Sale> listOfSales) {
        this.listOfSales = listOfSales;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Sale maxSale(){
        if (getListOfSales().size() == 0){ /*Causes the program to crash if this method is ran while listOfSales is
            empty*/
            throw new RuntimeException("At this moment in time there are no Sales in this branch");
        }
        Sale maxSale = null;
        for (Sale s : getListOfSales());{ /*iterates through the list of sales until the end where the sale of maximum
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

    public Sale avgSale(){

    }
}

