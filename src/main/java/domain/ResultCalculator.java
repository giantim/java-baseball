package domain;

import java.util.List;
import java.util.stream.IntStream;

public class ResultCalculator {
    private static final int BASEBALL_NUMBERS_SIZE = 3;

    private ResultCalculator() {
    }

    public static int calculateStrike(BaseballNumbers playerNumbers, BaseballNumbers computerNumbers) {
        return (int) IntStream.range(0, BASEBALL_NUMBERS_SIZE)
                .filter(index -> playerNumbers.getBaseballNumberByIndex(index).equals(
                        computerNumbers.getBaseballNumberByIndex(index)))
                .count();
    }

    public static int calculateBall(BaseballNumbers playerNumbers, BaseballNumbers computerNumbers) {
        int allMatch = (int) IntStream.range(0, BASEBALL_NUMBERS_SIZE)
                .filter(index -> containsBaseballNumber(playerNumbers.getBaseballNumberByIndex(index), computerNumbers))
                .count();
        return allMatch - calculateStrike(playerNumbers, computerNumbers);
    }

    private static boolean containsBaseballNumber(BaseballNumber playerNumber, BaseballNumbers computerNumbers) {
        return computerNumbers.contains(playerNumber);
    }
}
