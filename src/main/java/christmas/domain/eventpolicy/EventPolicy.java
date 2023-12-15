package christmas.domain.eventpolicy;

import christmas.domain.customer.Customer;

public interface EventPolicy {
    boolean applicableEvent(Customer customer);

    int getBenefitAmount(Customer customer);
}
