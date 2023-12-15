package christmas.domain.eventpolicy;

import static christmas.consts.DecemberCalender.CHRISTMAS;

import christmas.domain.customer.Customer;

public class DdayEventPolicy implements EventPolicy {

    private static final String NAME = "크리스마스 디데이 할인: ";
    private static final int START_BENEFIT_AMOUNT = 1000;
    private static final int PLUS_BENEFIT_AMOUNT = 100;

    @Override
    public boolean applicableEvent(Customer customer) {
        return customer.applicableEvent() && customer.visitDate().isBeforeDday();
    }

    @Override
    public int getBenefitAmount(Customer customer) {
        if (applicableEvent(customer)) {
            return START_BENEFIT_AMOUNT + (PLUS_BENEFIT_AMOUNT * (CHRISTMAS - customer.visitDate()
                    .calculateDaysUntilDday() - 1));
        }
        return 0;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
