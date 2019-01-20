package tasks.task01_sorting;

import java.util.Arrays;

/**
 * @author Yuri Lupandin
 * @version 1.0
 *          Fast sorting algorithm class
 */
public class FastSortAlgorithm implements ISortAlgorithm {
    /**
     * Method sort() implemented from ISortAlgorithm
     *
     * @param inArr Source array, that we want to sort
     * @return Return new array with sorted elements
     */
    @Override
    public Integer[] sort(final Integer[] inArr) {
        Integer[] arr = Arrays.copyOf(inArr, inArr.length);
        fastSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * Sub part of fast sorting algorithm
     *
     * @param arr   sortable array
     * @param start start position in array
     * @param end   end position in array
     * @return returns middle point as described by algorithm
     */
    private int fastSortHelper(Integer[] arr, int start, int end) {
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

    /**
     * Main sorting method
     *
     * @param arr   sortable array
     * @param start start position used in recurrent call
     * @param end   end position used in recurrent call
     */
    public void fastSort(Integer[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = fastSortHelper(arr, start, end);
        fastSort(arr, start, mid - 1);
        fastSort(arr, mid + 1, end);
    }
}
