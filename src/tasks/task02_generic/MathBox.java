package tasks.task02_generic;

import java.util.*;
/**
 * @author Yuri Lupandin
 * @version 1.0
 */
public class MathBox<T extends Number> extends ObjectBox {

    public MathBox(T[] numbersArray) {
        this.values = new TreeSet<T>();
        this.values.addAll(Arrays.asList(numbersArray));
    }

    public Double amount() {
        Double sum = 0.0;
        for (Object num : values) {
            sum = sum + ((T) num).doubleValue();
        }
        return sum;
    }

    public List<Double> splitter() {
        List<Double> list = new ArrayList<>(values.size());
        for (Object num : values) {
            Double d = ((T) num).doubleValue() / 2.0;
            list.add(d);
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(iterator.hasNext() ? ", " : "]");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MathBox<T> that = (MathBox<T>) obj;
        if (values.size() != that.values.size()) return false;

        Iterator iterator = values.iterator();
        Iterator iteratorAnother = that.values.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() != iteratorAnother.next()) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        Long sum = 1l;
        for (Object num : values) {
            sum = sum * prime + Double.doubleToLongBits(((T) num).doubleValue());
        }
        return sum.intValue();
    }

    @Override
    public void addObject(Object obj) throws Exception {
        if (obj.getClass().getSimpleName().equals("Object"))
            throw new WrongTypeException("Instance of Object class not allowed here");
        if (!(obj instanceof Number)) throw new WrongTypeException("Just instance of Number class allowed here");
        super.addObject(obj);
    }

}

class WrongTypeException extends Exception {
    public WrongTypeException(String message) {
        super(message);
    }
}
