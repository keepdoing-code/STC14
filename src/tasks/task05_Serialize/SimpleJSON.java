package tasks.task05_Serialize;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created on 25.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class SimpleJSON {

    public static void main(String[] args) {

        JSONObject json = new JSONObject();
        json.put("name", "John");
        json.put("num", new Integer(100));
        json.put("balance", new Double(1000.21));
        json.put("is_vip", new Boolean(true));

        StringWriter out = new StringWriter();
        try {
            json.writeJSONString(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonText = out.toString();
        System.out.print(jsonText);


        JSONParser parser = new JSONParser();
    }

}
