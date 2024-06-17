package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected boolean isReq = false;
    protected BaseSchema<T> required() {
        this.isReq = true;
        return this;
    }

    public abstract boolean isValid(T value);
}
