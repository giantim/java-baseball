package domain;

import spark.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PlayerBaseballNumbersGenerator {
    private static final String DELIMITER = "";
    private static final int MAX_BASEBALL_NUMBERS_LENGTH = 3;

    private PlayerBaseballNumbersGenerator() {
    }

    public static BaseballNumbers generateBaseballNumbers(String input) {
        validateBlank(input);
        validateLength(input);
        String[] inputs = input.split(DELIMITER);
        List<Integer> numbers = getNumbers(inputs);
        List<BaseballNumber> baseballNumberList = getBaseballNumbers(numbers);
        return new BaseballNumbers(baseballNumberList);
    }

    private static void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private static void validateLength(String input) {
        if (input.length() != MAX_BASEBALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }
    }

    private static List<Integer> getNumbers(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        try {
            parseInteger(inputs, numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        return numbers;
    }

    private static void parseInteger(String[] inputs, List<Integer> numbers) {
        for (int i = 0; i < MAX_BASEBALL_NUMBERS_LENGTH; i++) {
            int convertInteger = Integer.parseInt(inputs[i]);
            numbers.add(convertInteger);
        }
    }

    private static List<BaseballNumber> getBaseballNumbers(List<Integer> numbers) {
        List<BaseballNumber> baseballNumberList = new ArrayList<>();
        for (int number : numbers) {
            BaseballNumber baseballNumber = BaseballNumberPool.getBaseballNumberByNumber(number);
            baseballNumberList.add(baseballNumber);
        }
        return baseballNumberList;
    }
}
