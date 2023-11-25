package menu.controller;

import menu.model.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private InputView inputView;
    private OutputView outputView;

    private Coach coach;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        readCoachName();
    }

    private void readCoachName() {
        String name = inputView.readCoachName();
        while (true) {
            try {
                coach = new Coach(name);
                break;
            } catch (IllegalArgumentException e) {
                name = printError(e.getMessage());
            }
        }
    }

    private String printError(String message) {
        outputView.Error(message);
        return inputView.againRead();
    }
}
