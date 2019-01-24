package tasks.task04_concurrency;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ResourceLoader {
    private String source = "";
    private List<String> list = new ArrayList<>();


    public ResourceLoader(String source) {
        this.source = source;
    }


    public List<String> get() {
        if (list.size() > 0) {
            return list;
        }

        if (source.toLowerCase().startsWith("http") || source.toLowerCase().startsWith("ftp")) {
            try (InputStream stream = new URL(source).openStream()) {
                return getData(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (InputStream stream = new FileInputStream(source)) {
            return getData(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private List<String> getData(InputStream stream) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(stream))) {

            int symbol;
            StringBuilder sentence = new StringBuilder();

            while ((symbol = reader.read()) != -1) {
                if (symbol == '\r' || symbol == '\n') {
                    symbol = ' ';
                }
                sentence.append((char) symbol);
                if ((symbol == '?') || (symbol == '.') || (symbol == '!')) {
                    list.add(sentence.toString().trim());
                    sentence = new StringBuilder();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public void printAll() {
        list.forEach(System.out::println);
    }


    public void print(int num) {
        if (num <= list.size() && num > 0) {
            System.out.println(list.get(num));
        } else {
            System.out.println("Wrong input parameter");
        }
    }

}
