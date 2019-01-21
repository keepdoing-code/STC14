package tasks.task02_generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */

public class ObjectBox<T> {
    protected Collection<T> values = new ArrayList<>();

    public void addObject(T o) {
        values.add(o);
    }

    public void deleteObject(T o) {
        if (values.contains(o)) {
            values.remove(o);
        }
    }

    public String dump() {
        StringBuilder sb = new StringBuilder("[");
        Iterator iterator = values.iterator();

        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(iterator.hasNext() ? ", " : "]");
        }
        return sb.toString();
    }
}
