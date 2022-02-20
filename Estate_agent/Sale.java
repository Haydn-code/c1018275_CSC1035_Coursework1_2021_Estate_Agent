 package Estate_agent;

import java.time.LocalDate;

 /**
  * This a sale class which stores all the necessary info related to a single sale in its fields
  * @author Haydn Small
  */
 public class Sale {
    private int houseNumber;
    private String postcode;
    private int value;
    private int monthSold;
    private int yearSold;
    final public LocalDate currentDate = LocalDate.now();

     /**
      * This is a constructor method which links the parameters to the fields of the class
      * @param houseNumber - the number of the house sold
      * @param postcode - the postcode of the house sold
      * @param value - the value the house was sold at
      * @param monthSold - the month the house was sold
      * @param yearSold - the year the house was sold
      */
    public Sale(int houseNumber, String postcode, int value, int monthSold, int yearSold){
        setHouseNumber(houseNumber);
        setPostcode(postcode);
        setValue(value);
        setMonthSold(monthSold);
        setYearSold(yearSold);
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getMonthSold() {
        return monthSold;
    }

    public int getValue() {
        return value;
    }

    public int getYearSold() {
        return yearSold;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setMonthSold(int monthSold) {
        if (1 > monthSold || monthSold > 12) { //prevents an invalid month from being input
            throw new IllegalArgumentException("The monthSold must be an integer value 1-12");
        }
        if(getYearSold() == this.currentDate.getYear() && monthSold >
                this.currentDate.getMonth().getValue()){ //ensures that the month is not at a time in the future
            throw new IllegalArgumentException("The monthSold cannot be a date in the future");
        }
        else{
            this.monthSold = monthSold;
        }
    }

    public void setPostcode(String postcode) {
        if (5 < postcode.length() && postcode.length() < 9) { //ensures the postcode has between 6 and 8 characters
            this.postcode = postcode;
        }
        else{
            throw new IllegalArgumentException("The postcode must be between six " +
                    "to eight characters");
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setYearSold(int yearSold) {
        if (yearSold > this.currentDate.getYear()){ //ensures the sold year is not in the future
            throw new IllegalArgumentException("The value of yearSold cannot be in the future");
        }
        else{
            this.yearSold = yearSold;
        }
    }

     /**
      * returns the object in a more human readable form
      * @return - a string representation of the object
      */
    @Override
    public String toString(){
        return "House Number: " + getHouseNumber() + " Postcode: " + getPostcode() + " Value: "
                + getValue() + " Month Sold: " + getMonthSold() + " Year Sold: " + getYearSold();
    }
}