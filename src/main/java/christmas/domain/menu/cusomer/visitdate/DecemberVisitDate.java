package christmas.domain.menu.cusomer.visitdate;

import static christmas.consts.DecemberCalender.D_DAY_EVENT_DAYS;
import static christmas.consts.DecemberCalender.EVENT_DAYS;
import static christmas.consts.DecemberCalender.STAR_DAYS;
import static christmas.consts.DecemberCalender.WEEKEND_DAYS;
import static christmas.consts.Error.ERROR_NOT_VALIDATE_VISIT_DATE;

public class DecemberVisitDate implements visitDate {

    private final int date;

    public DecemberVisitDate(int date) {
        validate(date);
        this.date = date;
    }

    @Override
    public void validate(int date) {
        if (!validateRange(date)) {
            ERROR_NOT_VALIDATE_VISIT_DATE.throwException();
        }
    }

    private boolean validateRange(int date) {
        return EVENT_DAYS.get().contains(date);
    }

    @Override
    public boolean isWeekendDay() {
        return WEEKEND_DAYS.get().contains(date);
    }

    @Override
    public boolean isStarDay() {
        return STAR_DAYS.get().contains(date);
    }

    @Override
    public boolean isBeforeDday() {
        return D_DAY_EVENT_DAYS.get().contains(date);
    }
}
