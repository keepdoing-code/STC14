package tasks;

import java.util.Arrays;
import java.util.Random;

/**
 * @author stritron
 * Merge sorting algorithm
 * @param arr - input array to sort
 */
public class Sort {
    public static void main(String[] args) {
        Integer arr[] = new Integer[10];
        fillArray(arr);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    public static void bubbleSort(Integer[] arr) {
        boolean sorted = false;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if(arr[j] > arr[j + 1]){
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




    public static void fillArray(final Object[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10);
        }
    }

    public static void printArray(final Object[] arr) {
        System.out.println('\n' + Arrays.toString(arr) + '\n');
    }
}
