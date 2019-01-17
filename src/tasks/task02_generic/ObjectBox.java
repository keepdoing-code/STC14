package tasks.task02_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public class ObjectBox {
    private List list = new ArrayList();

    public void addObject(Object o) {
        list.add(o);
    }

    public void deleteObject(Object o) {
        if (list.contains(o)) {
            list.remove(o);
        }
    }

    public String dump() {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o).append(" ");
        }
        return sb.toString();
    }
}
