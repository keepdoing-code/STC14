package tasks.task05_reflection;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 25.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ObjectSaver {
    private final String[] primitives =
            {int.class.getName(),
                    byte.class.getName(),
                    long.class.getName(),
                    double.class.getName(),
                    float.class.getName(),
                    short.class.getName(),
                    boolean.class.getName()};

    private final String OBJECT_NAME = "OBJECT";
    private final String stringClass = String.class.getName();
    private Object src; //хранить состояние или сделать класс сл статическими полями?

    public ObjectSaver(Object src) {
        this.src = src;
    }


    public String toJSON() {
        String srcObjectType = src.getClass().getName();
        Field[] fields = src.getClass().getDeclaredFields();

        for (Field f : fields) {
            f.setAccessible(true);
        }

        StringBuilder data = new StringBuilder();

        data.append('{').append(combine(OBJECT_NAME, srcObjectType, null)).append(',');
        data.append(getFields(fields));
        data.append('}');

        return data.toString();
    }


    public void toFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String data = toJSON();
            writer.write(data);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String getFields(Field[] fields) {
        StringBuilder data = new StringBuilder();
        try {
            int i = 0;
            while (i < fields.length) {
                String key = fields[i].getName();
                String value = String.valueOf(fields[i].get(src));
                String type = fields[i].getType().getTypeName();
                data.append(combine(key, type, value));
                i++;
                if (i < fields.length) data.append(",");
            }
            return data.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "";
        }
    }


    private String combine(String name, String type, String value) {
        return "\"" + name + "\"" + ":{\"" + type + "\":" +
                getQuotes(type, value) + "}";
    }


    private String getQuotes(String type, String value) {
        List<String> list = Arrays.asList(primitives);
        if ("null".equals(value) || (value == null) || list.contains(type)) {
            return value;
        }
        return ("\"" + value + "\"");
    }
}
