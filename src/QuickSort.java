
import java.util.*;

public class QuickSort {

    public static void main(String[] args) throws Exception{
        QuickSort s = new QuickSort();
        int[] a = new int[]{10, 30, 1, 20, 3, 7, 15, 18, 2, 9};

        System.out.println(s.quickFind(a, 0, a.length - 1, 8));
        s.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickFind(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickFind(int[] arr, int l, int r, int k){
        int i = l, j = r;
        int pivot = arr[i];
        while (i < j){
            while(i < j && arr[j] > pivot)
                j--;
            if(i == j) break;
            arr[i] = arr[j];
            arr[j] = pivot;
            i++;
            while(i < j && arr[i] < pivot)
                i++;
            if(i == j) break;
            arr[j] = arr[i];
            arr[i] = pivot;
            j--;
        }

        if(i == k) return arr[i];
        if(k > i) return quickFind(arr, i + 1, r, k);
        else return quickFind(arr, l, i - 1, k);
    }

    public void quickSort(int[] arr, int l, int r){
        if(l >= r) return;

        int i = l, j = r;
        int pivot = arr[i];
        while (i < j){
            while(i < j && arr[j] > pivot)
                j--;
            if(i == j) break;
            arr[i] = arr[j];
            arr[j] = pivot;
            i++;
            while(i < j && arr[i] < pivot)
                i++;
            if(i == j) break;
            arr[j] = arr[i];
            arr[i] = pivot;
            j--;
        }
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
}