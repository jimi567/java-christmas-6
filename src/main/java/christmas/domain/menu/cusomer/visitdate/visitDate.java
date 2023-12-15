package christmas.domain.menu.cusomer.visitdate;

public interface visitDate {

    void validate(int date);

    boolean isWeekendDay();

    boolean isStarDay();

    boolean isBeforeDday();
}
