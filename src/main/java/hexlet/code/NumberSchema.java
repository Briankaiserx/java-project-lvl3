package hexlet.code;

public class NumberSchema extends BaseSchema{

    public NumberSchema required(){
        addRequirement(x -> x instanceof  Integer);
        return this;
    }
    public NumberSchema range(int minNum, int maxNum){
        addRequirement(x -> x instanceof Integer && (int) x >= minNum && (int) x <= maxNum);
        return this;
    }
    public NumberSchema positive() {
        addRequirement(x -> x instanceof Integer && (Integer) x > 0);
        return this;
}
}