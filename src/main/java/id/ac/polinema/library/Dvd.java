package id.ac.polinema.library;

public class Dvd extends LibraryItem {
    private int duration;

    public Dvd(String title, int year, int duration) {
        super(title, year);
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int loanDays() {
        return 3;
    }

    @Override
    public String describe() {
        return super.describe() + " [" + duration + " min]";
    }
}
