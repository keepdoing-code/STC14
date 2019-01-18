package tasks.task02_generic;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public class MathBox<T extends Number> extends ObjectBox {
    private Set<T> values = new TreeSet<>();

    public MathBox(T[] arrInt) {
        for (T i : arrInt) {
            values.add(i);
        }
    }

    public T summator() {
        Iterator<T> iterator = values.iterator();
        BigDecimal big = BigDecimal.ZERO;

        while (iterator.hasNext()) {
            T val = iterator.next();
            big = big.add(new BigDecimal(val.toString()));
        }
        return (T) big;
    }

    public Set<T> splitter() {
        Set<T> result = new TreeSet<T>();
        Iterator<T> iterator = values.iterator();

        while (iterator.hasNext()) {
            T val = iterator.next();

            BigDecimal big = new BigDecimal(val.toString()).divide(new BigDecimal(2));

            val = (T) big;

            result.add(val);
        }
        return result;
    }

    public void remove(T val) {
        if (values.contains(val)) {
            values.remove(val);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MathBox mathBox = (MathBox) o;

        if (values.equals(mathBox.values)) {
            return true;
        }

        if (values.size() != mathBox.values.size()) {
            return false;
        }

        Iterator iterator = values.iterator();
        Iterator iteratorAnother = mathBox.values.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() != iteratorAnother.next()) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return values.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Iterator<T> iterator = values.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(iterator.hasNext() ? ", " : "]");
        }

        return sb.toString();
    }
}
