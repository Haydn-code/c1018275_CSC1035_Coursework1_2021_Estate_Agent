package Estate_agent;

import java.util.Scanner;

public class ReportingIO {

    public static void main(String[] args) {
        ReportingIO r = new ReportingIO();
        r.menu();
    }


    public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu please enter an int 1-6:");
        System.out.println("1. Enter Branch data");
        System.out.println("2. Enter Sale data");
        System.out.println("3. See branch with highest average sale");
        System.out.println("4. See the highest sale ever recorded");
        System.out.println("5. See all sales greater than a given value");
        System.out.println("6. Exit");
        boolean loop = true;
        while(loop){
            while (!sc.hasNextInt()){
                System.out.println("Please enter an int 1-6");
                sc.nextLine();
            }
            int selection = sc.nextInt();
            sc.nextLine();
            switch (selection) {
                case 1 -> enterBranchData();
                case 2 -> enterSaleData();
                case 3 -> highestAvg();
                case 4 -> highestSale();
                case 5 -> salesGreaterThan();
                case 6 -> loop = false;
            }



        }
    }

    public void enterBranchData(){
        System.out.println("1");
    }

    public void enterSaleData(){
        System.out.println("2");
    }

    public void highestAvg(){
        System.out.println("3");
    }

    public void highestSale(){
        System.out.println("4");
    }

    public void salesGreaterThan(){
        System.out.println("5");
    }

}
