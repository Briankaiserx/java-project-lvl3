package hexlet.code.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        addRequirement(x -> x instanceof Map<?, ?>);
        return this;
    }

    public final MapSchema sizeof(int keySize) {
        addRequirement(x -> x instanceof Map && ((Map<?, ?>) x).size() == keySize);
        return this;
    }
    public final void shape(final Map<String, BaseSchema> mapShape) {
        final Predicate<Object> shape = x -> {
            List<Boolean> result = new ArrayList<>();
            Set<String> keySet = mapShape.keySet();
            for (String key : keySet) {
                result.add(mapShape.get(key).isValid(((Map<Object, Object>) x).get(key)));
            }
            return !result.contains(false);
        };
        addRequirement(shape);
    }
}
