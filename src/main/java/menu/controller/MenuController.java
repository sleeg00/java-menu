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
        coach = new Coach(name);
    }
}
