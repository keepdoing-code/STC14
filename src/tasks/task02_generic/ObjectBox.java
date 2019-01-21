package tasks.task02_generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */

public class ObjectBox {
    protected Collection values = new ArrayList<>();

    public void addObject(Object o) throws Exception {
        values.add(o);
    }

    public void deleteObject(Object o) {
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
