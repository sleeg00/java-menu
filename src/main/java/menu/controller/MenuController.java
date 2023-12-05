package menu.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.model.Category;
import menu.model.Coach;
import menu.model.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private InputView inputView;
    private OutputView outputView;

    private Coach coach;
    private MenuService menuService;
    private Category category;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        menuService = new MenuService();
    }

    public void start() {
        readCoachName();
        readCoachMenu();
        printCategory();
        printMenu();
    }

    private void printMenu() {
        List<List<String>> choiceMenus = coach.getRandomMenu(category);
        outputView.printMenu(coach, choiceMenus);
    }

    private void printCategory() {
        category = new Category(menuService.getCategory());
        outputView.printCategory(category);
    }

    private void readCoachMenu() {
        Integer coachCount = coach.getCoachCount();
        for (int i = 0; i < coachCount; i++) {
            outputView.printMenu(coach.getName().get(i));
            readNotEatMenu();
        }
    }

    private void readNotEatMenu() {
        String menuName = inputView.againRead();
        while (true) {
            try {
                coach.setMenu(menuName);
                break;
            } catch (IllegalArgumentException e) {
                menuName = printError(e.getMessage());
            }
        }
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
