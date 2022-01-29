package hexlet.code;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
     addRequirement(x -> x instanceof String && !((String) x).trim().isEmpty());
     return this;
    }
     public StringSchema contains(String str) {
        addRequirement(x -> x instanceof String && ((String) x).contains(str));
        return this;
     }
    public StringSchema minLength(int length) {
        addRequirement(x -> x instanceof String && ((String) x).trim().length() >= length);
        return this;
    }

}