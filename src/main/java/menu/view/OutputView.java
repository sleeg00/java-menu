package menu.view;

import org.w3c.dom.ls.LSOutput;

public class OutputView {
    public void Error(String message) {
        System.out.println(message);
    }

    public void printMenu(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입려해 주세요.");
    }
}
