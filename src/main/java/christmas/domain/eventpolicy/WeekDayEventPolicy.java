package christmas.domain.eventpolicy;

import static christmas.consts.MenuBoard.DESSERT;

import christmas.domain.customer.Customer;

public class WeekDayEventPolicy implements EventPolicy {

    private static final int BENEFIT_AMOUNT = 2023;

    @Override
    public boolean applicableEvent(Customer customer) {
        return customer.applicableEvent() && !customer.visitDate().isWeekendDay();
    }

    @Override
    public int getBenefitAmount(Customer customer) {
        if (applicableEvent(customer)) {
            return customer.orderMenu().countMenusByCategory(DESSERT) * BENEFIT_AMOUNT;
        }
        return 0;
    }
}
