package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addCheck("required", Objects::isNull);
        return this;
    }
    public NumberSchema positive() {
        Predicate<Integer> pos = value -> (value != null && value < 1);
        checks.put("positive", pos);
        return this;
    }
    public NumberSchema range(int x, int y) {
        Predicate<Integer> pos = value -> (value < x || value > y);
        checks.put("range", pos);
        return this;
    }


}
