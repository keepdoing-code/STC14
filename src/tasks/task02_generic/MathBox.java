package tasks.task02_generic;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public class MathBox<T extends Number> {
    private Set<T> values = new TreeSet<>();

    public MathBox(T[] arrInt) {
        for (T i : arrInt) {
            values.add(i);
        }
    }

    public T summator() {
        Iterator<T> iterator = values.iterator();
        Value<T> sum = new Value<>();

        while (iterator.hasNext()) {
            T val = iterator.next();
            sum.add(val);
        }

        return sum.getVal();
    }

    public Set<T> splitter() {
        Set<T> result = new TreeSet<T>();
        Iterator<T> iterator = values.iterator();

        while (iterator.hasNext()) {
            T val = iterator.next();
            result.add(new Value<T>(val).divideApart().getVal());
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
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        if (values.equals(mathBox.values)) return true;
        if (values.size() != mathBox.values.size()) return false;

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
