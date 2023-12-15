package christmas.domain.customer.visitdate;

public interface VisitDate {

    void validate(int date);

    boolean isWeekendDay();

    boolean isStarDay();

    boolean isBeforeDday();
}
