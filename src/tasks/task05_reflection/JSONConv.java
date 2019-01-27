package tasks.task05_reflection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created on 26/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class JSONConv {
    private static final String OBJECT_INDENT = "OBJECT";


    public Object toObject(String json) {
        json = trim(json, '{');
        json = trim(json, '}');

        Map<String, String> pairs = new HashMap<>();
        List<String> params = Arrays.asList(json.split(","));

        for (String str : params) {
            String[] strPairs = str.split(":");
            String key = trim(strPairs[0].trim(), '\"');
            String value = trim(strPairs[1], '\"');
            pairs.put(key, value);
        }

        String objType = pairs.get(OBJECT_INDENT);
        pairs.remove(OBJECT_INDENT);

        Object obj = null;
        try {
            obj = Class.forName(objType).newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field f : fields) {
                f.setAccessible(true);
                String value = pairs.get(f.getName());
                String type = f.getType().getName();

                PrimeEnum e = PrimeEnum.get(type);

                switch (e) {
                    case CHAR:
                        f.setChar(obj, value.charAt(0));
                        break;
                    case SHORT:
                        f.set(obj, Short.valueOf(value));
                        break;
                    case BYTE:
                        f.set(obj, Byte.valueOf(value));
                        break;
                    case INT:
                        f.set(obj, Integer.valueOf(value));
                        break;
                    case LONG:
                        f.set(obj, Long.valueOf(value));
                        break;
                    case FLOAT:
                        f.set(obj, Float.valueOf(value));
                        break;
                    case DOUBLE:
                        f.set(obj, Double.valueOf(value));
                        break;
                    case BOOLEAN:
                        f.set(obj, Boolean.valueOf(value));
                        break;
                    default:
                        f.set(obj, Class.forName(type).cast(value));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    public String toJSON(Object obj) {
        StringBuilder json = new StringBuilder();
        String objType = obj.getClass().getTypeName();
        List<Field> fields = Arrays.asList(obj.getClass().getDeclaredFields());

        try {
            Iterator<Field> iterator = fields.iterator();
            json.append('{').append(combine(OBJECT_INDENT, objType, null)).append(',');

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


    public String toString(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getSimpleName()).append("\r\n");
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                String name = f.getName();
                String type = f.getType().getName();
                String value = f.get(obj).toString();
                sb
                        .append("[ ").append(name).append(" : ")
                        .append(type).append(" : ").append(value).append(" ]\r\n");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public void toFile(String fileName, Object obj) {
        String JSONData = toJSON(obj);
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(JSONData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Object fromFile(String fileName) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int i;
            while ((i = reader.read()) > 0) {
                data.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return toObject(data.toString());
    }


    private String combine(String name, String value, String type) {
        if (("null".equals(value) || (value == null) || PrimeEnum.contains(type))) {
            return "\"" + name + "\":" + value;
        }
        return "\"" + name + "\":\"" + value + "\"";
    }


    private String trim(String value, char charToTrim) {
        int len = value.length();
        int st = 0;
        char[] val = value.toCharArray();
        while ((st < len) && (val[st] == charToTrim)) {
            st++;
        }
        while ((st < len) && (val[len - 1] == charToTrim)) {
            len--;
        }
        return ((st > 0) || (len < value.length())) ? value.substring(st, len) : value;
    }


    public enum PrimeEnum {
        BOOLEAN(boolean.class.getName()),
        CHAR(char.class.getName()),
        BYTE(byte.class.getName()),
        SHORT(short.class.getName()),
        INT(int.class.getName()),
        LONG(long.class.getName()),
        FLOAT(float.class.getName()),
        DOUBLE(double.class.getName()),
        OTHER("OTHER");

        private String type;

        PrimeEnum(String type) {
            this.type = type;
        }

        public static PrimeEnum get(String type) {
            for (PrimeEnum p : PrimeEnum.values()) {
                if (p.type.equals(type)) return p;
            }
            return OTHER;
        }

        public static boolean contains(String type) {
            return PrimeEnum.get(type) != OTHER;
        }
    }
}
