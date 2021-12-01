package lec_11_priority_queues;
/*Code : In-place heap sort
        Send Feedback
        Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
        Note: Space complexity should be O(1).
        Input Format:
        The first line of input contains an integer, that denotes the value of the size of the array or N.
        The following line contains N space separated integers, that denote the value of the elements of the array.
        Output Format :
        The first and only line of output contains array elements after sorting. The elements of the array in the output are separated by single space.
        Constraints :
        1 <= n <= 10^6
        Time Limit: 1 sec
        Sample Input 1:
        6
        2 6 8 5 4 3
        Sample Output 1:
        8 6 5 4 3 2*/
public class heap_sort {
    public static void inplaceHeapSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insertVirtually(arr , i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[(arr.length - 1 ) -i ] = removeVirtually(arr , arr.length -i);
        }

    }

    private static int removeVirtually(int[] arr, int i) {
        int temp = arr[0];
        arr[0] = arr[i - 1];
        i--;
        int index = 0;
        int childL = 1;
        int childR = 2;
        while (childL <  i){
            int min = index;
            if (arr[childL] < arr[min]){
                min = childL;
            }  if (childR < i && arr[childR] < arr[min]){
                min = childR;
            }
            if (min != index){
                int t = arr[min];
                arr[min] = arr[index];
                arr[index] = t;
                index = min;
                childL = 2* index +1;
                childR = 2 * index + 2;
            }else {
                break;
            }
        }
        return temp;
    }

    private static void insertVirtually(int[] arr, int i) {
        int childIndex = i;
        int parent =  (childIndex - 1) / 2;
        while (childIndex > 0){
            if (arr[childIndex] < arr[parent]){
                int temp = arr[parent];
                arr[parent] = arr[childIndex];
                arr[childIndex] = temp;
                childIndex = parent ;
                parent = (childIndex - 1 ) / 2;

            }else {
                return;
            }
        }
    }
}
