package christmas.service;

import static christmas.consts.EventBadge.getEventBadgeByBenefitAmount;
import static christmas.consts.ViewFormat.NOTHING_MESSAGE;
import static christmas.consts.ViewFormat.decimalFormat;

import christmas.domain.customer.Customer;
import christmas.domain.eventpolicy.EventPolicy;
import christmas.domain.eventpolicy.GiftEventPolicy;
import java.util.ArrayList;
import java.util.List;

public class EventPlannerService {

    private final List<EventPolicy> eventPolicies;

    public EventPlannerService(List<EventPolicy> eventPolicies) {
        this.eventPolicies = eventPolicies;
    }

    public int getTotalBenefitAmount(Customer customer) {
        return eventPolicies.stream().mapToInt(eventPolicy -> eventPolicy.getBenefitAmount(customer)).sum();
    }

    public String getGiftMenuHistory(Customer customer) {
        EventPolicy giftEventPolicy = eventPolicies.stream()
                .filter(GiftEventPolicy.class::isInstance).findFirst().get();

        if (giftEventPolicy.applicableEvent(customer)) {
            return "샴페인 1개";
        }
        return "없음";
    }


    public String getEventBadgeHistory(Customer customer) {
        return getEventBadgeByBenefitAmount(getTotalBenefitAmount(customer)).getName();
    }

    public int getPaymentAfterEvent(Customer customer) {
        EventPolicy giftEventPolicy = eventPolicies.stream()
                .filter(GiftEventPolicy.class::isInstance).findFirst().get();

        return customer.getTotalOrderAmount() - getTotalBenefitAmount(customer) + giftEventPolicy.getBenefitAmount(
                customer);
    }

    public List<String> getTotalBenefitHistory(Customer customer) {
        List<String> history = new ArrayList<>();
        for (EventPolicy eventPolicy : eventPolicies) {
            if (eventPolicy.applicableEvent(customer)) {
                history.add(
                        eventPolicy.toString() + "-" + decimalFormat(eventPolicy.getBenefitAmount(customer)) + '원');
            }
        }
        if (history.size() == 0) {
            history.add(NOTHING_MESSAGE.get());
        }
        return history;
    }
}
