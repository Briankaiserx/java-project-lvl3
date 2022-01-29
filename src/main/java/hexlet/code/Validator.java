package hexlet.code;

public class Validator {

    public final StringSchema string() {
        return new StringSchema();
    }
    public final NumberSchema numberSchema() {
        return new NumberSchema();
    }

}
