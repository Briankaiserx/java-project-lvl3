package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        addRequirement(x -> x instanceof Map<?, ?>);
        return this;
    }

    public final MapSchema sizeof(int keySize) {
        addRequirement(x -> x instanceof Map && ((Map<?, ?>) x).size() == keySize);
        return this;
    }


}
