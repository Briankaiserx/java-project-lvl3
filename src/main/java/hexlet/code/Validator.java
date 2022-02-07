package hexlet.code;

import hexlet.code.schema.MapSchema;
import hexlet.code.schema.NumberSchema;
import hexlet.code.schema.StringSchema;

public class Validator {

    public final StringSchema stringSchema() {
        return new StringSchema();
    }
    public final NumberSchema numberSchema() {
        return new NumberSchema();
    }
    public final MapSchema mapSchema() {
        return new MapSchema();
    }

}
