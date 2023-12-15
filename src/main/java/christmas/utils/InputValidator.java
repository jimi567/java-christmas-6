package christmas.utils;

import static christmas.consts.Error.ERROR_NOT_VALIDATE_ORDER_MENU;
import static christmas.consts.Error.ERROR_NOT_VALIDATE_VISIT_DATE;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final String DASH = "-";
    private static final String COMMA = ",";
    private final Pattern pattern = Pattern.compile("^([가-힣a-zA-Z]+)-(\\d+)(,([가-힣a-zA-Z]+)-(\\d+))*$");

    public void validateVisitDateInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ERROR_NOT_VALIDATE_VISIT_DATE.throwException();
        }
    }

    public void validateOrderMenuInput(String input) {
        if (!isValidFormat(input) || hasDuplication(input)) {
            ERROR_NOT_VALIDATE_ORDER_MENU.throwException();
        }
    }

    private boolean isValidFormat(String input) {
        return pattern.matcher(input).matches();
    }

    private boolean hasDuplication(String input) {
        Set<String> uniqueMenuNames = Arrays.stream(input.split(COMMA))
                .map(order -> order.split(DASH)[0])
                .collect(Collectors.toSet());

        return uniqueMenuNames.size() != input.split(COMMA).length;
    }
}
