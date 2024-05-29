public class InLineQuickSort {
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
    private static void inlinequickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            inlinequickSort(array, low, pi - 1);
            inlinequickSort(array, pi + 1, high);
        }
    }
    public static void main(String[] args) {
        int[] data = {2, 8, 7, 1, 3, 5, 6, 4};

        System.out.println("the unsorted array is :");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
        inlinequickSort(data, 0, data.length - 1);
        System.out.println("the sorted array is :");
        for (int num : data) {
            System.out.print(num + " ");
        }}}