package Estate_agent;
import java.util.List;
import java.util.ArrayList;


public class Branch {
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

    public void checkSalesList(){
        if (getListOfSales().size() == 0){ /*Causes the program to crash if this method is ran while listOfSales is
            empty*/
            throw new RuntimeException("At this moment in time there are no Sales in this branch");
        }
    }

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

    public double avgSale(){
        checkSalesList();
        double totalSale = 0;
        for(Sale s : getListOfSales()){
            totalSale += s.getValue();
        }
        return totalSale/getListOfSales().size();

    }

    public ArrayList<Sale> greaterSales(int Value){
        checkSalesList();
        ArrayList<Sale> l = new ArrayList<>();
        for(Sale s : getListOfSales()){
            if(s.getValue() > Value){
                l.add(s);
            }
        }
        return l;
    }
}

