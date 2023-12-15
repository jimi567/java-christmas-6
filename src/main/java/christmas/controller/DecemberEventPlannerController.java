package christmas.controller;

import static christmas.consts.ViewFormat.DISCOUNT_AMOUNT_FORMAT;
import static christmas.consts.ViewFormat.MONEY_FORMAT;
import static christmas.consts.ViewFormat.decimalFormat;

import christmas.domain.customer.Customer;
import christmas.domain.customer.orderMenu.OrderMenu;
import christmas.domain.customer.visitdate.DecemberVisitDate;
import christmas.domain.customer.visitdate.VisitDate;
import christmas.domain.eventpolicy.DdayEventPolicy;
import christmas.domain.eventpolicy.GiftEventPolicy;
import christmas.domain.eventpolicy.SpecialDayEventPolicy;
import christmas.domain.eventpolicy.WeekDayEventPolicy;
import christmas.domain.eventpolicy.WeekendDayEventPolicy;
import christmas.service.EventPlannerService;
import christmas.utils.InputParser;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class DecemberEventPlannerController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final InputParser inputParser = new InputParser();
    private EventPlannerService eventPlannerService;
    private VisitDate visitDate;
    private OrderMenu orderMenu;
    private Customer customer;


    public void run() {
        setEventPlannerService();
        outputView.printStartMessage();
        setCustomer();
        outputView.printResultMessage();
        showResult();
    }

    private void setEventPlannerService() {
        eventPlannerService = new EventPlannerService(
                List.of(new DdayEventPolicy(), new WeekDayEventPolicy(), new WeekendDayEventPolicy(),
                        new GiftEventPolicy(), new SpecialDayEventPolicy()));
    }

    private void setCustomer() {
        setVisitDate();
        setOrderMenu();
        customer = new Customer(visitDate, orderMenu);
    }

    private void setVisitDate() {
        try {
            visitDate = new DecemberVisitDate(inputParser.parseVisitDate(inputView.readVisitDay()));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            setVisitDate();
        }
    }

    private void setOrderMenu() {
        try {
            orderMenu = new OrderMenu(inputParser.parseOrderMenu(inputView.readOrderMenu()));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            setOrderMenu();
        }
    }

    private void showResult() {
        showOrderMenu();
        showBeforeDiscountTotalPayment();
        showGiftMenu();
        showBenefitHistory();
        showTotalBenefitAmount();
        showAfterDiscountTotalPayment();
        showEventBadge();
    }

    private void showOrderMenu() {
        outputView.printOrderMenu(customer.orderMenu().toString());
    }

    private void showBeforeDiscountTotalPayment() {
        outputView.printBeforeDiscountTotalPayment(
                String.format(MONEY_FORMAT.get(), decimalFormat(customer.getTotalOrderAmount())));
    }

    private void showGiftMenu() {
        outputView.printGiftMenu(eventPlannerService.getGiftMenuHistory(customer));
    }

    private void showBenefitHistory() {
        outputView.printBenefitHistory(String.join("\n", eventPlannerService.getTotalBenefitHistory(customer)));
    }

    private void showTotalBenefitAmount() {
        int totalBenefitAmount = eventPlannerService.getTotalBenefitAmount(customer);
        String history = String.format(MONEY_FORMAT.get(), 0);
        if (totalBenefitAmount > 0) {
            history = String.format(DISCOUNT_AMOUNT_FORMAT.get(),
                    decimalFormat(eventPlannerService.getTotalBenefitAmount(customer)));
        }
        outputView.printTotalBenefitAmount(history);
    }

    private void showAfterDiscountTotalPayment() {
        outputView.printAfterDiscountTotalPayment(String.format(MONEY_FORMAT.get(),
                decimalFormat(eventPlannerService.getPaymentAfterEvent(customer))));
    }

    private void showEventBadge() {
        outputView.printEventBadge(eventPlannerService.getEventBadgeHistory(customer));
    }
}
