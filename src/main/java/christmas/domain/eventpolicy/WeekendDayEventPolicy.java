package christmas.domain.eventpolicy;

import static christmas.consts.MenuBoard.MAIN;

import christmas.domain.customer.Customer;

public class WeekendDayEventPolicy implements EventPolicy {

    private static final String NAME = "주말 할인: ";
    private static final int BENEFIT_AMOUNT = 2023;

    @Override
    public boolean applicableEvent(Customer customer) {
        return customer.applicableEvent() && customer.visitDate().isWeekendDay();
    }

    @Override
    public int getBenefitAmount(Customer customer) {
        if (applicableEvent(customer)) {
            return BENEFIT_AMOUNT * customer.orderMenu().countMenusByCategory(MAIN);
        }
        return 0;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
