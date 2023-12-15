package christmas.domain.menu.cusomer.orderMenu;

import static christmas.consts.Error.ERROR_NOT_VALIDATE_ORDER_MENU;
import static christmas.consts.MenuBoard.getCategoryByMenu;
import static christmas.consts.MenuBoard.getSellingMenus;

import christmas.domain.menu.Menu;
import java.util.HashMap;

public class OrderMenu {

    private static final int MINIMUM_ORDER_COUNT = 1;
    private static final int MAXIMUM_ORDER_COUNT = 20;
    private final HashMap<Menu, Integer> orderMenu;

    public OrderMenu(HashMap<Menu, Integer> orderMenu) {
        validate(orderMenu);
        this.orderMenu = orderMenu;
    }

    private void validate(HashMap<Menu, Integer> orderMenu) {
        if (!containsAllMenuBoard(orderMenu)) {
            ERROR_NOT_VALIDATE_ORDER_MENU.throwException();
        } else if (!validateOrderCount(orderMenu)) {
            ERROR_NOT_VALIDATE_ORDER_MENU.throwException();
        }
    }

    private boolean containsAllMenuBoard(HashMap<Menu, Integer> orderMenu) {
        return getSellingMenus().containsAll(orderMenu.keySet());
    }

    private boolean validateOrderCount(HashMap<Menu, Integer> orderMenu) {
        return orderMenu.values().stream()
                .allMatch(count -> count >= MINIMUM_ORDER_COUNT && count <= MAXIMUM_ORDER_COUNT);
    }

    public int countMenusByCategory(String category) {
        return (int) orderMenu.keySet().stream().filter(menu -> getCategoryByMenu(menu).equals(category)).count();
    }

}
