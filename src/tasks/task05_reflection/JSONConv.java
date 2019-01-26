package tasks.task05_reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 26/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class JSONConv {
    private static final String OBJECT_IDENT = "OBJECT";
    private static final List<String> primitives = Arrays.asList(
            int.class.getName(),
            byte.class.getName(),
            long.class.getName(),
            double.class.getName(),
            float.class.getName(),
            short.class.getName(),
            boolean.class.getName());


    public String toJSON(Object obj) {
        StringBuilder json = new StringBuilder();
        String objType = obj.getClass().getTypeName();
        List<Field> fields = Arrays.asList(obj.getClass().getDeclaredFields());

        try {
            Iterator<Field> iterator = fields.iterator();
            json.append('{').append(combine(OBJECT_IDENT, objType, null)).append(',');

            while (iterator.hasNext()) {
                Field f = iterator.next();
                f.setAccessible(true);
                String name = f.getName();
                String value = String.valueOf(f.get(obj));
                String type = f.getType().getTypeName();
                json.append(combine(name, value, type));
                if (iterator.hasNext()) {
                    json.append(',');
                } else {
                    json.append('}');
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return json.toString();
    }


    private String combine(String name, String value, String type) {
        if (("null".equals(value) || (value == null) || primitives.contains(type))) {
            return "\"" + name + "\":" + value;
        }
        return "\"" + name + "\":\"" + value + "\"";
    }
}
