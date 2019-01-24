package lections.lec09;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created on 24.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class StreamDemo {
    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = 0;

        int a = ints.stream().filter(o -> o % 2 == 1)
                .reduce((o1, o2) -> o1 + o2)
                .orElse(0);

        System.out.println(a);
    }
}
