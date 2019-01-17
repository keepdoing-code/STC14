package tasks.task02_generic;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public class MathBox<T extends Number> {
    private Set<T> listInt = new TreeSet<T>();

    public MathBox(T[] arrInt) {
        for (T i : arrInt) {
            listInt.add(i);
        }
    }

    public T summator() {
        T sum = null;
        Iterator iterator = listInt.iterator();
        while (iterator.hasNext()) {
            sum = (T) iterator.next();
        }
        return sum;
    }

    public Set splitter() {
        Set result = new TreeSet();
        Iterator iterator = listInt.iterator();
        while (iterator.hasNext()) {
            T i = (T) iterator.next();
            Object o;

            switch (i.getClass().getName()) {
                case "Integer":
                    o = i.intValue() / 2;
                    break;
                case "Byte":
                    o = i.byteValue() / 2;
                    break;
                case "Double":
                    o = i.doubleValue() / 2.0;
                    break;
                case "Float":
                    o = i.floatValue() / 2.0;
                    break;
                default:
                    o = null;
            }

            i = (T) o;
            result.add(i);
        }
        return result;
    }

    public void remove(Integer i) {
        if (listInt.contains(i)) {
            listInt.remove(i);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        if (listInt.equals(mathBox.listInt)) return true;
        if (listInt.size() != mathBox.listInt.size()) return false;

        Iterator iterator = listInt.iterator();
        Iterator iteratorAnother = mathBox.listInt.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() != iteratorAnother.next()) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return listInt.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object i : listInt) {
            sb.append(i).append(", ");
        }
        return sb.toString();
    }
}
