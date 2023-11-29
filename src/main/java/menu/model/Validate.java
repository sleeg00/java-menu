package menu.model;

public enum Validate {
    INVALID_COACH_MINIMUM_COUNT("[ERROR] 코치는 최소 2명 이상 입력해야 합니다."),
    INVALID_COACH_MAXIMUM_COUNT("[ERROR] 코치는 최대 5명 이하로 입력해야 합니다."),
    INVALID_COACH_MINIMUM_LENGTH("[ERROR] 코치 이름은 최소 2글자 이상 입력해야 합니다."),
    INVALID_COACH_MAXIMUM_LENGTH("[ERROR] 코치 이름은 최대 5글자 이하로 입력해야 합니다."),
    INVALID_MENU_MAXIMUM_COUNT("[ERROR] 메뉴는 최대 2개 이하여야 합니다."),
    INVALID_MENU_SAME("[ERROR] 같은 메뉴가 2개 입니다.");

    private String message;

    Validate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
