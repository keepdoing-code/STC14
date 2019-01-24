package tasks.task04_concurrency;

import java.time.LocalDateTime;

/**
 * Created on 24.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Loger {
    public static void i(String str) {
        String template = "%s : %s \r\n";
        System.out.printf(template, LocalDateTime.now().toString(), str);
    }

    public static void i(Integer integer) {
        i(integer.toString());
    }
}
