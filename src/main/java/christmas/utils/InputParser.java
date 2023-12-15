package christmas.utils;

import christmas.domain.menu.Menu;
import java.util.Arrays;
import java.util.HashMap;

public class InputParser {
    private static final String DASH = "-";
    private static final String COMMA = ",";
    InputValidator inputValidator = new InputValidator();

    public int parseVisitDate(String input) {
        input = removeSpaces(input);
        inputValidator.validateVisitDateInput(input);
        return Integer.parseInt(input);
    }

    public HashMap<Menu, Integer> parseOrderMenu(String input) {
        input = removeSpaces(input);
        inputValidator.validateOrderMenuInput(input);
        HashMap<Menu, Integer> orderMenuSource = new HashMap<>();
        Arrays.asList(input.split(COMMA)).forEach(order -> {
            String[] parts = order.split(DASH);
            orderMenuSource.put(new Menu(parts[0]), Integer.parseInt(parts[1]));
        });
        return orderMenuSource;
    }

    private String removeSpaces(String input) {
        return input.replaceAll(" ", "");
    }
}
