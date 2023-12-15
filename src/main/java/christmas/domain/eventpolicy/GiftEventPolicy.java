package christmas.domain.eventpolicy;

import static christmas.consts.MenuBoard.getPriceByMenu;

import christmas.domain.customer.Customer;
import christmas.domain.menu.Menu;

public class GiftEventPolicy implements EventPolicy {
    private static final String NAME = "증정 이벤트: ";
    private static final int APPLICABLE_TOTAL_AMOUNT = 12_000;
    private static final Menu GIFT_MENU = new Menu("샴페인");

    @Override
    public boolean applicableEvent(Customer customer) {
        return customer.applicableEvent() && customer.getTotalOrderAmount() >= APPLICABLE_TOTAL_AMOUNT;
    }

    @Override
    public int getBenefitAmount(Customer customer) {
        if (applicableEvent(customer)) {
            return getPriceByMenu(GIFT_MENU);
        }
        return 0;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
