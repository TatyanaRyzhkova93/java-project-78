package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    private int sizeOf;
    private boolean isSizeOf;
    private boolean isShape;
    private Map<String, BaseSchema<String>> schemas;
    @Override
    public MapSchema required() {
        return (MapSchema) super.required();
    }

    public MapSchema sizeof(int n) {
        this.sizeOf = n;
        this.isSizeOf = true;
        return this;
    }
    @Override
    public boolean isValid(Map value) {
        if (isReq && value == null) {
            return false;
        }
        if (isSizeOf && (value == null || value.size() != sizeOf)) {
            return false;
        }
        if (isShape) {
            long c = schemas.entrySet().stream()
                    .filter(entry -> entry.getValue().isValid(entry.getKey()))
                    .count();
            return c == value.size();
        }
        return true;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> sch) {
        this.schemas = sch;
        this.isShape = true;
        return this;
    }
}
