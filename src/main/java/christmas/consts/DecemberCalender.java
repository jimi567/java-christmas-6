package christmas.consts;

import java.util.List;
import java.util.stream.IntStream;

public enum DecemberCalender {
    EVENT_DAYS(IntStream.rangeClosed(1, 31)
            .boxed()
            .toList()),
    D_DAY_EVENT_DAYS(IntStream.rangeClosed(1, 25)
            .boxed()
            .toList()),
    STAR_DAYS(List.of(3, 10, 17, 24, 31, 25)),
    WEEKEND_DAYS(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));

    public static final int CHRISTMAS = 25;
    private final List<Integer> days;

    DecemberCalender(List<Integer> days) {
        this.days = days;
    }

    public List<Integer> get() {
        return days;
    }
}
