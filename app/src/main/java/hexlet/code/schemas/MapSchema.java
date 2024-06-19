package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map> {
    private Map<String, BaseSchema<String>> schemas = new HashMap<>();
    private boolean isShape;
    public MapSchema required() {
        Predicate<Map> empty = Objects::isNull;
        checks.put("required", empty);
        return this;
    }

    public MapSchema sizeof(int n) {
        Predicate<Map> size = value -> (value == null || value.size() != n);
        checks.put("sizeof", size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schs) {
        schemas = schs;
        this.isShape = true;
        return this;
    }

    public final boolean isValid(Map<String, String> value) {
        if (isShape) {
            for (Map.Entry<String, String> entry : value.entrySet()) {
                BaseSchema<String> schema = schemas.get(entry.getKey());
                schema.isValid(entry.getValue());
            }
        }
        return super.isValid(value);
    }
}
