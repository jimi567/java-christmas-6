package christmas.domain.menu.cusomer.visitdate;

public interface VisitDate {

    void validate(int date);

    boolean isWeekendDay();

    boolean isStarDay();

    boolean isBeforeDday();
}
