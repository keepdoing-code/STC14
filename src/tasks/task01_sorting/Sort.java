package tasks.task01_sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * @author stritron
 * @version 1.0
 *         Bubble sorting algorithm
 *         Quick sorting algorithm
 * @param arr - input array to sort
 */
public class Sort {
    public static void main(String[] args) {
        Integer arr[] = new Integer[10];

        System.out.println("Bubble sort");
        fillAndPrintArray(arr);
        bubbleSort(arr);
        printArray(arr);

        System.out.println("Quick sort");
        fillAndPrintArray(arr);
        fastSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    public static void bubbleSort(Integer[] arr) {
        boolean sorted = false;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    Integer a = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = a;
                    sorted = false;
                }
                System.out.print(++count + " ");
                System.out.println(Arrays.toString(arr));
            }
            if (sorted) return;
        }
    }


    private static int fastSortHelper(Integer[] arr, int start, int end) {
        int tmp;
        int pointer = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] < arr[end]) {
                tmp = arr[pointer];
                arr[pointer] = arr[i];
                arr[i] = tmp;
                pointer += 1;
            }
        }
        tmp = arr[pointer];
        arr[pointer] = arr[end];
        arr[end] = tmp;
        return pointer;
    }

    public static void fastSort(Integer[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = fastSortHelper(arr, start, end);
        fastSort(arr, start, mid - 1);
        fastSort(arr, mid + 1, end);
    }


    public static void fillAndPrintArray(final Object[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10);
        }
        printArray(arr);
    }

    public static void printArray(final Object[] arr) {
        System.out.println('\n' + Arrays.toString(arr) + '\n');
    }
}
