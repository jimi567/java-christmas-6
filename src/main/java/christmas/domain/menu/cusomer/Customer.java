package christmas.domain.menu.cusomer;

import static christmas.consts.MenuBoard.getPriceByMenu;

import christmas.domain.menu.cusomer.orderMenu.OrderMenu;
import christmas.domain.menu.cusomer.visitdate.VisitDate;

public record Customer(VisitDate visitDate, OrderMenu orderMenu) {

    private static final int MINIMUM_APPLICABLE_TOTAL_ORDER_AMOUNT = 10000;

    public int getTotalOrderAmount() {
        return orderMenu.getOrderMenu().keySet().stream()
                .mapToInt(menu -> getPriceByMenu(menu) * orderMenu.countMenu(menu)).sum();
    }

    public boolean applicableEvent() {
        return getTotalOrderAmount() >= MINIMUM_APPLICABLE_TOTAL_ORDER_AMOUNT;
    }
}
