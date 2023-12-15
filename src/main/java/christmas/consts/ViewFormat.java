package christmas.consts;

import java.text.DecimalFormat;

public enum ViewFormat {
    MONEY_FORMAT("%s원"),
    DISCOUNT_AMOUNT_FORMAT("-" + MONEY_FORMAT.get()),
    NOTHING_MESSAGE("없음"),
    MENU_FORMAT("%s %d개"),
    DECIMAL_FORMAT("###,###");

    private final String message;

    ViewFormat(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public static String decimalFormat(int money) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT.get());
        return decimalFormat.format(money);
    }
}
