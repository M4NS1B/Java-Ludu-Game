import java.util.ArrayList;

public class Requirements {
    public static int sumOfArray(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        } else if (start > end) {
            return 0;
        } else {
            int mid = (start + end) / 2;
            return sumOfArray(arr, start, mid) + sumOfArray(arr, mid + 1, end);
        }
    }

    public static void traverseString(String str, int index) {
        if (index >= str.length()) {
            return;
        }
        
        System.out.print(str.charAt(index));
        traverseString(str, index + 1);
    }

    public static void traverseArray(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        
        System.out.print(arr[index] + " ");
        traverseArray(arr, index + 1);
    }

    public static void traverseArrayList(ArrayList<Integer> list, int index) {
        if (index >= list.size()) {
            return;
        }
        
        System.out.print(list.get(index) + " ");
        traverseArrayList(list, index + 1);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    
    private static void merge(int[] arr, int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;
    
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
    
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[start + i];
        }
    
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }
    
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = start;
    
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                arr[mergedIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                arr[mergedIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }
    
        // Copy the remaining elements of leftArray, if any
        while (leftIndex < leftSize) {
            arr[mergedIndex] = leftArray[leftIndex];
            leftIndex++;
            mergedIndex++;
        }
    
        // Copy the remaining elements of rightArray, if any
        while (rightIndex < rightSize) {
            arr[mergedIndex] = rightArray[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
    }
}
