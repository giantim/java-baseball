package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {
    private static final int MAX_BASEBALL_NUMBERS_SIZE = 3;

    private List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumberList) {
        validateBaseballNumbersSize(baseballNumberList);
        validateDuplication(baseballNumberList);
        this.baseballNumbers = baseballNumberList;
    }

    private void validateBaseballNumbersSize(List<BaseballNumber> baseballNumberList) {
        if (baseballNumberList.size() != MAX_BASEBALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException("3자리의 숫자를 입력하세요.");
        }
    }

    private void validateDuplication(List<BaseballNumber> baseballNumberList) {
        Set<BaseballNumber> duplicateBaseballNumbers = new HashSet<>(baseballNumberList);
        if (duplicateBaseballNumbers.size() != baseballNumberList.size()) {
            throw new IllegalArgumentException("중복된 수를 입력할 수 없습니다.");
        }
    }

    public BaseballNumber getBaseballNumberByIndex(int index) {
        return this.baseballNumbers.get(index);
    }

    public boolean contains(BaseballNumber baseballNumber) {
        return this.baseballNumbers.contains(baseballNumber);
    }

    public List<BaseballNumber> getBaseballNumbers() {
        return this.baseballNumbers;
    }
}
