package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    protected final void addCheck(String name, Predicate<T> predicate) {
        checks.put(name, predicate);
    }

    public final boolean isValid(T value) {
        if (checks.isEmpty()) {
            return true;
        }
        return checks.entrySet().stream()
                .noneMatch(entry -> entry.getValue().test(value));
    }
}
