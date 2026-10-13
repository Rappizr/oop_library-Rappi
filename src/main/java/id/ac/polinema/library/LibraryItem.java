package id.ac.polinema.library;

public class LibraryItem {
    protected String title;
    protected int year;
    private boolean available;
    private int extendedDays;

    public LibraryItem(String title, int year){
        setTitle(title);
        setYear(year);
        this.available = true;
        this.extendedDays = 0;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if (title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }        this.title = title;
    }

    public int getYear(){
        return year;
    }
    
    public void setYear(int year){
        if (year < 0){
            throw new IllegalArgumentException("Year must be greater than 0");
        }        this.year = year;
    }

    public boolean isAvailable(){
        return available;
    }

    
    public boolean checkOut() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    public void returnItem() {
        this.available = true;
    }

    public int loanDays() {
        return 7;
    }

    public void extendLoan() {
        extendLoan(7);
    }

    public void extendLoan(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than 0");
        }
        this.extendedDays += days;
    }

    public int getTotalLoanDays() {
        return loanDays() + extendedDays;
    }

    public String describe() {
        return title + " (" + year + ")";
    }

    @Override
    public String toString() {
        return describe();
    }

}
