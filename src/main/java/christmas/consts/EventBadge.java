package christmas.consts;

public enum EventBadge {
    NONE("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);


    private final String name;
    private final int minimumBenefitAmount;

    EventBadge(String name, int minimumBenefitAmount) {
        this.name = name;
        this.minimumBenefitAmount = minimumBenefitAmount;
    }

    public int getMinimumBenefitAmount() {
        return minimumBenefitAmount;
    }

    public String getName() {
        return name;
    }

    public static EventBadge getEventBadgeByBenefitAmount(int benefitAmount) {
        if (SANTA.getMinimumBenefitAmount() <= benefitAmount) {
            return SANTA;
        } else if (TREE.getMinimumBenefitAmount() <= benefitAmount) {
            return TREE;
        } else if (STAR.getMinimumBenefitAmount() <= benefitAmount) {
            return STAR;
        }
        return NONE;
    }
}
