package hexlet.code.schemas;

public class StringSchema {
    private boolean isReq = false;
    private boolean isContains = false;
    private boolean isMinLength = false;
    private int minLength;
    private String subString;
    public StringSchema required() {
        this.isReq = true;
        return this;
    }
    public StringSchema contains(String substr) {
        this.isContains = true;
        this.subString = substr;
        return this;
    }
    public StringSchema minLength(int length) {
        this.isMinLength = true;
        this.minLength = length;
        return this;
    }
    public boolean isValid(String value) {
        if (isReq && (value == null || value.isEmpty())) {
            return false;
        }
        if (isMinLength && (value == null && minLength > 0
                || value != null && minLength > value.length())) {
            return false;
        }
        if (isContains) {
            return value != null && subString != null && value.contains(subString)
                    || value == null && subString == null;
        }
        return true;
    }
}
