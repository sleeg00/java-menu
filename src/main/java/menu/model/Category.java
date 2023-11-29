package menu.model;

import java.util.List;

public class Category {
    private final List<String> name;

    public Category(List<String> name) {
        this.name = name;
    }

    public List<String> getName() {
        return name;
    }
}
