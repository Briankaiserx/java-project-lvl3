package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private List<Predicate<Object>> rules = new ArrayList<>();

    public final void addRequirement(Predicate<Object> rule) {
        rules.add(rule);
    }

    public final boolean isValid(Object data) {
        for (Predicate<Object> requirement : rules) {
            if (!requirement.test(data)) {
                return false;
            }
        }
        return true;
    }
}
