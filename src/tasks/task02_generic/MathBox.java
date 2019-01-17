package tasks.task02_generic;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by yuri on 17.01.19.
 */
public class MathBox {
    private Set listInt = new TreeSet();

    public MathBox(Integer[] arrInt) {
        for (Integer i : arrInt) {
            listInt.add(i);
        }
    }

    public Integer summator() {
        Integer sum = 0;
        Iterator iterator = listInt.iterator();
        while (iterator.hasNext()) {
            sum += (Integer) iterator.next();
        }
        return sum;
    }

    public Set splitter() {
        Set result = new TreeSet();
        Iterator iterator = listInt.iterator();
        while (iterator.hasNext()) {
            Integer i = (Integer) iterator.next();
            i = i / 2;
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
