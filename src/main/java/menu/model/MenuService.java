package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuService {
    private static final List<String> FOOD_ORIGIN = List.of("", "일식", "한식", "중식", "아시안", "양식");
    private static final Integer CATEGORY_LENGTH = 5;
    private static final Integer MINIMUM_SAME_CATEGORY = 2;

    public List<String> getCategory() {
        List<String> category = new ArrayList<>();
        do {
            String name = FOOD_ORIGIN.get(Randoms.pickNumberInRange(1, 5));
            int count = Collections.frequency(category, name);
            if (count < MINIMUM_SAME_CATEGORY) {
                category.add(name);
            }
        } while (category.size() != CATEGORY_LENGTH);
        return category;
    }

}
