package tasks.task02_generic;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public enum NumberWorker {
    Integer() {
        public Number amount(Number sum, Number n) {
            return sum.intValue() + n.intValue();
        }

        public Number div(Number value) {
            return value.intValue() / 2;
        }
    },
    Double() {
        public Number amount(Number sum, Number n) {
            return sum.doubleValue() + n.doubleValue();
        }

        public Number div(Number value) {
            return value.doubleValue() / 2.0;
        }
    };

    public static NumberWorker getType(Number a) {
        return NumberWorker.valueOf(a.getClass().getSimpleName());
    }

    public abstract Number amount(Number sum, Number n);

    public abstract Number div(Number value);
}
