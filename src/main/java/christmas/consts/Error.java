package christmas.consts;

public enum Error {
    ERROR_NOT_VALIDATE_VISIT_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_NOT_VALIDATE_ORDER_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String error = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return error + message;
    }

    public void throwException() {
        throw new IllegalArgumentException(getMessage());
    }
}
