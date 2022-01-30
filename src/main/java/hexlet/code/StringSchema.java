package hexlet.code;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
     addRequirement(x -> x instanceof String && !((String) x).trim().isEmpty());
     return this;
    }
     public final StringSchema contains(String str) {
        addRequirement(x -> x instanceof String && ((String) x).contains(str));
        return this;
     }
    public final StringSchema minLength(int length) {
        addRequirement(x -> x instanceof String && ((String) x).length() >= length);
        return this;
    }

}
