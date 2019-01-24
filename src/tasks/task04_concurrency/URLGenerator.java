package tasks.task04_concurrency;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */

public class URLGenerator {
    private String URL_TEMPLATE = "http://www.gutenberg.org/files/%1$s/%1$s.txt";
    private int MAX_RANDOM = 10000;
    private int count;


    public URLGenerator() {
    }


    public String[] get(int count) {
        this.count = count;
        int i = 0;
        Set<Integer> numbers = new HashSet<>();
        List<String> resources = new ArrayList<>();

        while (i < count) {
            int random = new Random().nextInt(MAX_RANDOM) + 1;

            if (!numbers.contains(random) && isExist(String.format(URL_TEMPLATE, random))) {
                numbers.add(random);
                String resource = String.format(URL_TEMPLATE, random);
                Loger.i("check available: " + resource);
                resources.add(resource);
                i++;
            }

        }

        return resources.toArray(new String[count]);
    }


    public String getOne() {
        count = 1;
        String[] res = get(count);
        return res[res.length - 1];
    }


    private boolean isExist(String res) {
        try {
            URL url = new URL(res);
            url.openStream();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
