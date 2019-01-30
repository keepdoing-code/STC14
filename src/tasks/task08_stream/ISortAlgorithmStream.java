package tasks.task08_stream;

/**
 * ISortAlgorithmStream interface for any implementation of sorting algorithm
 */
public interface ISortAlgorithmStream {
    /**
     * Just one method - sort array
     *
     * @param inputArray - source array
     * @return returns sorted array
     */
    Integer[] sort(Integer[] inputArray);

    default void swap(Integer[] arr, int i, int j) {
        Integer a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }
}
