package tasks.task08_stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author Yuri Lupandin
 * @version 1.0
 *          Bubble sorting algorithm
 *          Quick sorting algorithm
 */
public class Sorter {
    /**
     * Main testing program
     * Generates specified size array of random integer numbers from 0 to n
     * Tests fast sorting algorithm. Creating instance of FastSortAlgorithmStreamStream
     * class, that implements ISortAlgorithmStream with only one method sort().
     * Similarly with BubbleSortAlgorithmStreamStream().
     */
    public static void main(String[] args) {
        Integer[] randomArray = generateArray(20, 100);
        printArray("Source random array: ", randomArray);

        ISortAlgorithmStream fast = new FastSortAlgorithmStreamStream();
        Integer[] sortedArray = fast.sort(randomArray);
        printArray("Sorted using fast sorting algorithm: ", sortedArray);

        ISortAlgorithmStream bubble = new BubbleSortAlgorithmStreamStream();
        sortedArray = bubble.sort(randomArray);
        printArray("Sorted by bubble sort: ", sortedArray);
    }

    /**
     * @param size  Length of generated random array
     * @param range Range of generated random values from 0 to range
     * @return Return Integer array of specified parameters
     */
    public static Integer[] generateArray(final int size, final int range) {
//        Supplier<Integer> rndSup = ()-> new Random().nextInt(range);
//        Integer[] arr = new Integer[size];

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = rndSup.get();
//        }
//        arr = Arrays.stream(arr).map((a)->new Random().nextInt(range)).collect(Collectors.toList()).toArray(new Integer[]{});
//        arr = Stream.generate(rndSup).limit(size).toArray(Integer[]::new);

        return Stream.generate(() -> new Random().nextInt(range)).limit(size).toArray(Integer[]::new);
    }

    /**
     * @param message Text message to print on console
     * @param arr     Object of array, that we want to see on screen
     */
    public static void printArray(final String message, final Object[] arr) {
        System.out.print("|");
        Arrays.stream(arr).forEach(s -> System.out.printf("%2s|", s));
        System.out.print(" - " + message + "\r\n");
//        Arrays.stream(arr).forEach(System.out::println);
    }

}
