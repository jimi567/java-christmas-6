package christmas.domain.customer.orderMenu;

import static christmas.consts.Error.ERROR_NOT_VALIDATE_ORDER_MENU;
import static christmas.consts.MenuBoard.getCategoryByMenu;
import static christmas.consts.MenuBoard.getSellingMenus;
import static christmas.consts.ViewFormat.MENU_FORMAT;

import christmas.domain.menu.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMenu {

    private static final int MINIMUM_ORDER_COUNT = 1;
    private static final int MAXIMUM_ORDER_TOTAL_COUNT = 20;
    private final Map<Menu, Integer> orderMenu;

    public OrderMenu(HashMap<Menu, Integer> orderMenu) {
        validate(orderMenu);
        this.orderMenu = orderMenu;
    }

    public Map<Menu, Integer> getOrderMenu() {
        return Collections.unmodifiableMap(orderMenu);
    }

    public int countMenu(Menu menu) {
        return orderMenu.get(menu);
    }

    private void validate(HashMap<Menu, Integer> orderMenu) {
        if (!containsAllMenuBoard(orderMenu)) {
            ERROR_NOT_VALIDATE_ORDER_MENU.throwException();
        } else if (!validateOrderCount(orderMenu)) {
            ERROR_NOT_VALIDATE_ORDER_MENU.throwException();
        } else if (!validateOrderTotalCount(orderMenu)) {
            ERROR_NOT_VALIDATE_ORDER_MENU.throwException();
        }
    }

    private boolean containsAllMenuBoard(HashMap<Menu, Integer> orderMenu) {
        return getSellingMenus().containsAll(orderMenu.keySet());
    }

    private boolean validateOrderCount(HashMap<Menu, Integer> orderMenu) {
        return orderMenu.values().stream()
                .allMatch(count -> count >= MINIMUM_ORDER_COUNT);
    }

    private boolean validateOrderTotalCount(HashMap<Menu, Integer> orderMenu) {
        return orderMenu.values().stream().mapToInt(Integer::intValue).sum() <= MAXIMUM_ORDER_TOTAL_COUNT;
    }

    public int countMenusByCategory(String category) {
        return (int) orderMenu.keySet().stream().filter(menu -> getCategoryByMenu(menu).equals(category))
                .mapToInt(menu -> orderMenu.get(menu)).sum();
    }

    @Override
    public String toString() {
        List<String> orderMenuInformation = new ArrayList<>();
        orderMenu.forEach(
                (menu, quantity) -> orderMenuInformation.add(String.format(MENU_FORMAT.get(), menu.name(), quantity)));
        return String.join("\n", orderMenuInformation);
    }
}
