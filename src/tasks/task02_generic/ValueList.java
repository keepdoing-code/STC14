package tasks.task02_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuri on 17.01.19.
 */
public class ValueList<T extends Number> {
    List<Value<T>> list = new ArrayList<>();
}
