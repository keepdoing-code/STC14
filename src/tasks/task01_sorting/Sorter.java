package tasks.task01_sorting;

import java.util.Arrays;
import java.util.Random;

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
     * Tests fast sorting algorithm. Creating instance of FastSortAlgorithm
     * class, that implements ISortAlgorithm with only one method sort().
     * Similarly with BubbleSortAlgorithm().
     */
    public static void main(String[] args) {
        Integer[] randomArray = generateArray(20, 100);
        printArray("Source random array: ", randomArray);

        ISortAlgorithm fast = new FastSortAlgorithm();
        Integer[] sortedArray = fast.sort(randomArray);
        printArray("Sorted using fast sorting algorithm: ", sortedArray);

        ISortAlgorithm bubble = new BubbleSortAlgorithm();
        sortedArray = bubble.sort(randomArray);
        printArray("Sorted by bubble sort: ", sortedArray);
    }

    /**
     *
     * @param size Length of generated random array
     * @param range Range of generated random values from 0 to range
     * @return Return Integer array of specified parameters
     */
    public static Integer[] generateArray(final int size, final int range) {
        Random rnd = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(range);
        }
        return arr;
    }

    /**
     *
     * @param message Text message to print on console
     * @param arr Object of array, that we want to see on screen
     */
    public static void printArray(final String message, final Object[] arr) {
        System.out.println(message + '\n' + Arrays.toString(arr) + '\n');
    }
}
