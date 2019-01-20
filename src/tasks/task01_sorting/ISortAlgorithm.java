package tasks.task01_sorting;

/**
 * ISortAlgorithm interface for any implementation of sorting algorithm
 */
public interface ISortAlgorithm {
    /**
     * Just one method - sort array
     *
     * @param inputArray - source array
     * @return returns sorted array
     */
    Integer[] sort(Integer[] inputArray);
}
