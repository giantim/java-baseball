package domain;

import spark.utils.StringUtils;

public class GameContinue {
    private static final int MIN_GAME_CONTINUE = 1;
    private static final int MAX_GAME_CONTINUE = 2;
    private static final int GAME_CONTINUE = 1;
    private static final String INVALID_GAME_CONTINUE_MESSAGE = "1 또는 2를 입력해주세요.";

    private int gameContinue;

    public GameContinue(String input) {
        validateBlank(input);
        int gameContinue = validateNumber(input);
        validateRange(gameContinue);
        this.gameContinue = gameContinue;
    }

    private void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INVALID_GAME_CONTINUE_MESSAGE);
        }
    }

    private int validateNumber(String input) {
        int gameContinue;
        try {
            gameContinue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_GAME_CONTINUE_MESSAGE);
        }
        return gameContinue;
    }

    private void validateRange(int gameContinue) {
        if (gameContinue < MIN_GAME_CONTINUE || gameContinue > MAX_GAME_CONTINUE) {
            throw new IllegalArgumentException(INVALID_GAME_CONTINUE_MESSAGE);
        }
    }

    public boolean playMore() {
        return this.gameContinue == GAME_CONTINUE;
    }
}
