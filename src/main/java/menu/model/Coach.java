package menu.model;

import static menu.model.Validate.INVALID_COACH_MAXIMUM_COUNT;
import static menu.model.Validate.INVALID_COACH_MAXIMUM_LENGTH;
import static menu.model.Validate.INVALID_COACH_MINIMUM_COUNT;
import static menu.model.Validate.INVALID_COACH_MINIMUM_LENGTH;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Coach {
    private final List<String> name;

    public Coach(String name) {
        List<String> divideName = divideName(name);
        validateCountCoach(divideName);
        validateLengthCoachName(divideName);
        this.name = divideName;
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
}
