package tasks.task01_sorting;

import java.util.Arrays;

/**
 * @author Yuri Lupandin
 * @version 1.0
 *          Bubble sorting algorithm class
 */
public class BubbleSortAlgorithm implements ISortAlgorithm {

    /**
     * Method sort() implemented from ISortAlgorithm
     *
     * @param inArr Source array, that we want to sort
     * @return Return new array with sorted elements
     */
    @Override
    public Integer[] sort(final Integer[] inArr) {
        Integer[] arr = Arrays.copyOf(inArr, inArr.length);
        bubbleSort(arr);
        return arr;
    }

    /**
     * Implementation of Bubble sorting algorithm
     *
     * @param arr Array to sort by swapping values
     */
    private void bubbleSort(Integer[] arr) {
        boolean sorted;

        for (int i = 0; i < arr.length; i++) {
            sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    Integer a = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = a;
                    sorted = false;
                }
            }
            if (sorted) return;
        }
    }
}
