package menu.model;

import static menu.model.Validate.INVALID_COACH_MAXIMUM_COUNT;
import static menu.model.Validate.INVALID_COACH_MAXIMUM_LENGTH;
import static menu.model.Validate.INVALID_COACH_MINIMUM_COUNT;
import static menu.model.Validate.INVALID_COACH_MINIMUM_LENGTH;
import static menu.model.Validate.INVALID_MENU_MAXIMUM_COUNT;
import static menu.model.Validate.INVALID_MENU_SAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Coach {
    private final List<String> name;
    private List<List<String>> menu;

    public Coach(String name) {
        List<String> divideName = divideName(name);
        validateCountCoach(divideName);
        validateLengthCoachName(divideName);
        this.name = divideName;
    }

    public void setMenu(String menu) {
        List<String> divideMenu = divideName(menu);
        validateCountMenu(divideMenu);
        validateSameMenu(divideMenu);
        if (this.menu == null) {
            this.menu = new ArrayList<>();
        }
        this.menu.add(divideMenu);
    }

    private void validateSameMenu(List<String> divideMenu) {
        for (int i = 0; i < divideMenu.size() - 1; i++) {
            for (int j = i + 1; j < divideMenu.size(); j++) {
                checkSameMenu(divideMenu.get(i), divideMenu.get(j));
            }
        }
    }

    private void checkSameMenu(String menu, String compareMenu) {
        if (menu.equals(compareMenu)) {
            throw new IllegalArgumentException(INVALID_MENU_SAME.getMessage());
        }
    }

    private void validateCountMenu(List<String> divideMenu) {
        if (divideMenu.size() > 2) {
            throw new IllegalArgumentException(INVALID_MENU_MAXIMUM_COUNT.getMessage());
        }
    }

    private void validateLengthCoachName(List<String> divideName) {
        for (int i = 0; i < divideName.size(); i++) {
            String name = divideName.get(i);
            if (name.length() < 2) {
                throw new IllegalArgumentException(INVALID_COACH_MINIMUM_LENGTH.getMessage());
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException(INVALID_COACH_MAXIMUM_LENGTH.getMessage());
            }
        }
    }

    private void validateCountCoach(List<String> divideName) {
        if (divideName.size() < 2) {
            throw new IllegalArgumentException(INVALID_COACH_MINIMUM_COUNT.getMessage());
        }
        if (divideName.size() > 5) {
            throw new IllegalArgumentException(INVALID_COACH_MAXIMUM_COUNT.getMessage());
        }
    }

    private List<String> divideName(String name) {
        StringTokenizer stringTokenizer = new StringTokenizer(name, ",");
        List<String> returnName = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String tokenName = stringTokenizer.nextToken();
            returnName.add(tokenName.trim());
        }
        return returnName;
    }

    public Integer getCoachCount() {
        return this.name.size();
    }

    public List<String> getName() {
        return name;
    }

    public List<List<String>> getRandomMenu(Category category) {
        List<String> name = getName();
        List<List<String>> resultMenus = new ArrayList<>();
        for (int i = 0; i < name.size(); i++) {
            resultMenus.add(randomMenu(category, i));
        }
        return resultMenus;
    }

    private List<String> randomMenu(Category category, Integer number) {
        List<String> categories = category.getName();
        List<String> choiceMenus = new ArrayList<>();
        int i = 0;
        do {
            String choiceMenu = getCategoryMenu(categories.get(i));
            List<String> exceptMenu = menu.get(number);
            if (!choiceMenus.contains(choiceMenu) && !exceptMenu.contains(choiceMenu)) {
                choiceMenus.add(choiceMenu);
                i++;
            }
        } while (i < categories.size());
        return choiceMenus;
    }

    private String getCategoryMenu(String categoryName) {
        String randomMenu = "";
        for (Menu menuList : Menu.values()) {
            List<String> menus = menuList.getMenu();
            if (menuList.getName().equals(categoryName)) {
                randomMenu = Randoms.shuffle(menus).get(0);
                break;
            }
        }
        return randomMenu;
    }
}
