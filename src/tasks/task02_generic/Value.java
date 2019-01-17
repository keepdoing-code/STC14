package tasks.task02_generic;

/**
 * Created by yuri on 17.01.19.
 */
public class Value<T extends Number> {
    private T val = null;

    public Value(T val) {
        this.val = val;
    }

    public Value() {
    }

    public T getVal() {
        return val;
    }

    public Value<T> setVal(T val) {
        this.val = val;
        return this;
    }

    public Value<T> divide(Value<T> d) {

        Value<T> result = null;

        switch (val.getClass().getName()) {
            case "java.lang.Integer":
                Integer anInteger = val.intValue() / d.getVal().intValue();
                result = new Value<>((T) anInteger);
                break;
            case "java.lang.Double":
                Double aDouble = val.doubleValue() / d.getVal().doubleValue();
                result = new Value<>((T) aDouble);
                break;
        }

        return result;
    }

    public Value<T> divideApart() {

        Value<T> result = null;

        switch (val.getClass().getName()) {
            case "java.lang.Integer":
                Integer anInteger = val.intValue() / 2;
                result = new Value<>((T) anInteger);
                break;
            case "java.lang.Double":
                Double aDouble = val.doubleValue() / 2.0;
                result = new Value<>((T) aDouble);
                break;
        }

        return result;
    }

    public void add(T d) {
        switch (d.getClass().getName()) {
            case "java.lang.Integer":
                if (val == null) {
                    val = (T) (new Integer(0));
                }
                Integer anInteger = val.intValue() + d.intValue();
                val = (T) anInteger;
                break;
            case "java.lang.Double":
                if (val == null) {
                    val = (T) (new Double(0));
                }
                Double aDouble = val.doubleValue() + d.doubleValue();
                val = (T) aDouble;
                break;
        }
    }

}
