package aicodepair;

/**
 * @Author yuxiangjin
 * @Date 2023/7/26 18:52
 **/
public class Codeieum {
    // 编写代码实现快速排序
    public static void main(String[] args) {
        System.out.println(Codeieum.class.getName());
        int[] arr = {5, 2, 3, 1, 4};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    // 第一种方法
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
    // 第他种方法
    public static void quickSort2(int[] arr) {
        quickSort2(arr, 0, arr.length - 1);
    }
    /**
     * Sorts an array of integers using the QuickSort algorithm.
     *
     * @param  arr   the array to be sorted
     * @param  left  the starting index of the subarray
     * @param  right the ending index of the subarray
     */
    public static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition2(arr, left, right);
            quickSort2(arr, left, pivot - 1);
            quickSort2(arr, pivot + 1, right);
        }
    }
    public static int partition2(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
    // 第三种方法
}
