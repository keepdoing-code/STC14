package tasks;

import java.util.Arrays;
import java.util.Random;

/**
 * Author - yuri on 16.01.19.
 * Merge sorting algorithm
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    Integer a = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = a;
                }
            }
        }
    }



    public static void fillArray(final Object[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10);
        }
    }

    public static void printArray(final Object[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
