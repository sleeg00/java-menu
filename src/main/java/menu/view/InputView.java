package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readCoachName() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String name = Console.readLine();
        return name;
    }
}
