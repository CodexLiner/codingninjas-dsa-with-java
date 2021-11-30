package lec_2_recursion_2;
/*Quick Sort Code
        Send Feedback
        Sort an array A using Quick Sort.
        Change in the input array itself. So no need to return or print anything.


        Input format :
        Line 1 : Integer n i.e. Array size
        Line 2 : Array elements (separated by space)
        Output format :
        Array elements in increasing order (separated by space)
        Constraints :
        1 <= n <= 10^3
        Sample Input 1 :
        6
        2 6 8 5 4 3
        Sample Output 1 :
        2 3 4 5 6 8
        Sample Input 2 :
        5
        1 5 2 7 3
        Sample Output 2 :
        1 2 3 5 7*/
public class quick_sort {
    public static void quickSort(int[] input) {
        quickSort(input , 0 , input.length - 1);
    }
    public static void quickSort(int[] input ,int start , int end) {
        if (start>= end){
            return;
        }
        int pivot = findPivot(input , start , end);
        quickSort(input , start , pivot - 1);
        quickSort(input , pivot + 1 , end);

    }

    private static int findPivot(int[] input, int start, int end) {
        int pivot = input[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (input[j] < pivot){
                i++;
                swap( input , i , j);

            }
        }
        swap(input , i+ 1 , end);
        return i+1;
    }

    private static void swap(int[] input, int i, int j) {
        int t = input[i];
        input[i] = input[j];
        input[j] = t;
    }
}
