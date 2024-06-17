package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean isPositive = false;
    private boolean isRange = false;
    private int x;
    private int y;
    @Override
    public NumberSchema required() {
        return (NumberSchema) super.required();
    }
    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }
    public NumberSchema range(int z, int zz) {
        this.isRange = true;
        this.x = z;
        this.y = zz;
        return this;
    }
    @Override
    public boolean isValid(Integer value) {
        if (isReq && value == null) {
            return false;
        }
        if (value == null) {
            return true;
        }
        if (isPositive && value < 1) {
            return false;
        }
        if (isRange && (value < x || value > y)) {
            return false;
        }
        return true;
    }

}
