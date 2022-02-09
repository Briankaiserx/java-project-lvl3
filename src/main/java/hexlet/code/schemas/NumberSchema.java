package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        addRequirement(x -> x instanceof Integer);
        return this;
    }
    public final NumberSchema positive() {
        addRequirement(x -> x == null || x instanceof Integer && (Integer) x > 0);
        return this;
    }
    public final NumberSchema range(int minNum, int maxNum) {
        addRequirement(x -> x instanceof Integer && (int) x >= minNum && (int) x <= maxNum);
        return this;
    }

}
