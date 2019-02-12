package tasks.task14_junit;

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

    public List<String> get() throws IOException {
        if (list.size() > 0) {
            return list;
        }

        if (source.toLowerCase().startsWith("http") || source.toLowerCase().startsWith("ftp")) {
            InputStream stream = new URL(source).openStream();
            getData(stream);
            stream.close();
            return list;
        }

        InputStream stream = new FileInputStream(source);
        getData(stream);
        stream.close();
        return list;
    }


    public List<String> getData(InputStream stream) {
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
                    list.add(sentence.toString().replaceAll("\\ +", " ").trim());
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
}
