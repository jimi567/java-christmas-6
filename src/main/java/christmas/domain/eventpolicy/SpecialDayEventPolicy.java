package christmas.domain.eventpolicy;

import christmas.domain.customer.Customer;

public class SpecialDayEventPolicy implements EventPolicy {
    private static final String NAME = "특별 할인: ";
    private static final int BENEFIT_AMOUNT = 1000;

    @Override
    public boolean applicableEvent(Customer customer) {
        return customer.applicableEvent() && customer.visitDate().isStarDay();
    }

    @Override
    public int getBenefitAmount(Customer customer) {
        if (applicableEvent(customer)) {
            return BENEFIT_AMOUNT;
        }
        return 0;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
