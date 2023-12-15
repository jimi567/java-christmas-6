package christmas.view;

public class OutputView {

    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String VISIT_DAY_PROMPT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_MENU_PROMPT_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String RESULT_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String BEFORE_DISCOUNT_TOTAL_ORDER_PAYMENT_MESSAGE = "<할인 전 총주문 금액>";
    private static final String GIFT_MESSAGE = "<증정 메뉴>";
    private static final String BENEFIT_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_AMOUNT_MESSAGE = "<총혜택 금액>";
    private static final String AFTER_DISCOUNT_TOTAL_ORDER_PAYMENT_MESSAGE = "<할인 후 예상 결제 금액>";

    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";
    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printVisitDayPrompt() {
        System.out.println(VISIT_DAY_PROMPT_MESSAGE);
    }

    public void printOrderMenuPrompt() {
        System.out.println(ORDER_MENU_PROMPT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printOrderMenu(String orderMenuInformation) {
        System.out.println();
        System.out.println(ORDER_MENU_MESSAGE);
        System.out.println(orderMenuInformation);
    }

    public void printBeforeDiscountTotalPayment(String beforeDiscountTotalPaymentInformation) {
        System.out.println();
        System.out.println(BEFORE_DISCOUNT_TOTAL_ORDER_PAYMENT_MESSAGE);
        System.out.println(beforeDiscountTotalPaymentInformation);
    }

    public void printGiftMenu(String giftMenuInformation) {
        System.out.println();
        System.out.println(GIFT_MESSAGE);
        System.out.println(giftMenuInformation);
    }

    public void printBenefitHistory(String benefitHistoryInformation) {
        System.out.println();
        System.out.println(BENEFIT_MESSAGE);
        System.out.println(benefitHistoryInformation);
    }

    public void printTotalBenefitAmount(String totalBenefitAmountInformation) {
        System.out.println();
        System.out.println(TOTAL_BENEFIT_AMOUNT_MESSAGE);
        System.out.println(totalBenefitAmountInformation);
    }

    public void printAfterDiscountTotalPayment(String afterDiscountTotalPaymentInformation) {
        System.out.println();
        System.out.println(AFTER_DISCOUNT_TOTAL_ORDER_PAYMENT_MESSAGE);
        System.out.println(afterDiscountTotalPaymentInformation);
    }

    public void printEventBadge(String eventBadgeInformation) {
        System.out.println();
        System.out.println(EVENT_BADGE_MESSAGE);
        System.out.println(eventBadgeInformation);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
