import java.time.LocalDate;

public class Sales {
    private int houseNumber;
    private String postcode;
    private int value;
    private int monthSold;
    private int yearSold;
    final public LocalDate currentDate = LocalDate.now();
    public Sales(int houseNumber, String postcode, int value, int monthSold, int yearSold){
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
        if (1 > monthSold || monthSold > 12) {
            throw new IllegalArgumentException("The monthSold must be an integer value 1-12");
        }
        if(getYearSold() == this.currentDate.getYear() && monthSold >
                this.currentDate.getMonth().getValue()){
            throw new IllegalArgumentException("The monthSold cannot be a date in the future");
        }
        else{
            this.monthSold = monthSold;
        }
    }

    public void setPostcode(String postcode) {
        if (5 < postcode.length() && postcode.length() < 9) {
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
        if (yearSold > this.currentDate.getYear()){
            throw new IllegalArgumentException("The value of yearSold cannot be in the future");
        }
        else{
            this.yearSold = yearSold;
        }
    }

}
