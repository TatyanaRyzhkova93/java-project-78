package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        Predicate<String> empty = i -> (i == null || i.isEmpty());
        checks.put("required", empty);
        return this;
    }
    public StringSchema contains(String substr) {
        Predicate<String> cont = value -> !(value != null && substr != null && value.contains(substr)
                || value == null && substr == null);
        checks.put("contains", cont);
        return this;
    }
    public StringSchema minLength(int minLength) {
        Predicate<String> minLen = i -> (i == null && minLength > 0
                || i != null && minLength > i.length());
        checks.put("minLength", minLen);
        return this;
    }

}
