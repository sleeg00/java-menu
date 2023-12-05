package menu.view;

import java.util.List;
import menu.model.Category;
import menu.model.Coach;

public class OutputView {
    public void Error(String message) {
        System.out.println(message);
    }

    public void printMenu(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printCategory(Category category) {
        List<String> categories = category.getName();
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리");
        for (int i = 0; i < categories.size(); i++) {
            System.out.print(" | " + categories.get(i));
        }
        System.out.println(" ]");
    }

    public void printMenu(Coach coach, List<List<String>> choiceMenus) {
        List<String> coachName = coach.getName();
        for (int i = 0; i < coachName.size(); i++) {
            List<String> coachMenu = choiceMenus.get(i);
            System.out.print("[ " + coachName.get(i));
            for (int j = 0; j < coachMenu.size(); j++) {
                System.out.print(" | " + coachMenu.get(j));
            }
            System.out.println(" ]");
        }
        System.out.println("\n추천을 완료했습니다.");
    }
}
