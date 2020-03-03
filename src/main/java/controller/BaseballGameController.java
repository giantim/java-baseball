package controller;

import domain.*;
import view.InputViewer;
import view.OutputViewer;

public class BaseballGameController {
    private static final int ALL_STRIKE = 3;

    public static void run() {
        Computer computer = new Computer();
        BaseballNumbers computerNumbers = computer.getComputerBaseballNumbers();
        int strikeCount = 0;

        do {
            BaseballNumbers playerNumbers = createPlayerBaseballNumbers();
            strikeCount = ResultCalculator.calculateStrike(playerNumbers, computerNumbers);
            int ballCount = ResultCalculator.calculateBall(playerNumbers, computerNumbers);
            OutputViewer.printResult(strikeCount, ballCount);
        } while (strikeCount != ALL_STRIKE);

        checkEndGame();
    }

    private static BaseballNumbers createPlayerBaseballNumbers() {
        try {
            String playerNumber = InputViewer.inputPlayerBaseballNumbers();
            return PlayerBaseballNumbersGenerator.generateBaseballNumbers(playerNumber);
        } catch (IllegalArgumentException e) {
            OutputViewer.printErrorMessage(e.getMessage());
            return createPlayerBaseballNumbers();
        }
    }

    private static void checkEndGame() {
        GameContinue gameContinue = createGameContinue();
        if (gameContinue.playMore()) {
            run();
        }
    }

    private static GameContinue createGameContinue() {
        try {
            String continueNumber = InputViewer.inputContinueGame();
            return new GameContinue(continueNumber);
        } catch (IllegalArgumentException e) {
            OutputViewer.printErrorMessage(e.getMessage());
            return createGameContinue();
        }
    }
}
