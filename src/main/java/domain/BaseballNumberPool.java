package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumberPool {
    private static final int MIN_BASEBALL_NUMBER_RANGE = 1;
    private static final int MAX_BASEBALL_NUMBER_RANGE = 9;
    private static final int MAX_BASEBALL_NUMBERS_SIZE = 3;

    private static List<BaseballNumber> baseballNumberPool;

    static {
        baseballNumberPool = IntStream.rangeClosed(MIN_BASEBALL_NUMBER_RANGE, MAX_BASEBALL_NUMBER_RANGE)
                .mapToObj(BaseballNumber::new)
                .collect(Collectors.toList());
    }

    public static List<BaseballNumber> getNonDuplicateNumber() {
        Collections.shuffle(baseballNumberPool);
        return baseballNumberPool.stream()
                .limit(MAX_BASEBALL_NUMBERS_SIZE)
                .collect(Collectors.toList());
    }

    public static BaseballNumber getBaseballNumberByNumber(int number) {
        return baseballNumberPool.stream()
                .filter(bn -> bn.isSame(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 범위의 숫자를 입력하였습니다."));
    }
}
