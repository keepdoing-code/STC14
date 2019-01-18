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


    public MathBox(T[] arrInt) {
        values = new TreeSet<>();

        for (T i : arrInt) {
            values.add(i);
        }
    }

    public T summator() {
        Iterator<Number> iterator = values.iterator();
        BigDecimal big = BigDecimal.ZERO;

        while (iterator.hasNext()) {
            big = big.add(new BigDecimal(iterator.next().toString()));
        }
        return (T) big;
    }

    public Set<T> splitter() {
        Set<T> result = new TreeSet<>();
        Iterator<T> iterator = values.iterator();

        while (iterator.hasNext()) {
            Number big = resolve(iterator.next());

            big = new BigDecimal(big.toString()).divide(new BigDecimal(2));

            result.add((T) big);
        }
        return result;
    }

    private Number resolve(T number) {
        return number;
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

    @Override
    public void addObject(Object o) throws NotNumberException {
        if (!(o instanceof Number)) {
            throw new NotNumberException();
        }
        values.add(o);
    }
}

class NotNumberException extends Exception {
}
