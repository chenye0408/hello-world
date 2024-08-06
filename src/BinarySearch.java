public class BinarySearch {

    //Binary search, unique elements
    public int find(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <=  right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    //Binary search: duplicate elements, right-most insertion point
    public int findRightMostInsertionPoint(int[] arr, int target) {
        int left = 0, right = arr.length -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target){
                if(mid == arr.length - 1) return mid + 1;
                if(arr[mid + 1] != target) return mid + 1;
                else left = mid + 1;
            }else if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    //Binary search: duplicate elements, left-most insertion point
    public int findLeftMost(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target){
                if(mid == 0) return mid;
                if(arr[mid - 1] != target) return mid - 1;
                else right = mid -1;
            }else if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}
