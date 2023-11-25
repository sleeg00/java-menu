package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Coach {
    private final List<String> name;

    public Coach(String name) {
        this.name = divideName(name);
        System.out.println(this.name);
    }

    private List<String> divideName(String name) {
        StringTokenizer stringTokenizer = new StringTokenizer(name, ",");
        List<String> returnName = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            returnName.add(stringTokenizer.nextToken());
        }
        return returnName;
    }
}
