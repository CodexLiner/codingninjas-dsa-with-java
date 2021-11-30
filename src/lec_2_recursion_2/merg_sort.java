package lec_2_recursion_2;
/*Merge Sort Code
        Send Feedback
        Sort an array A using Merge Sort.
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
        2 1 5 2 3
        Sample Output 2 :
        1 2 2 3 5*/
public class merg_sort {
    public static void mergeSort(int[] input){
        mergeSort(input , 0 , input.length - 1);
    }
    public static void mergeSort(int[] input , int start , int end){
        if (start >= end){
            return;
        }
        int mid =( start + end ) / 2;
        mergeSort(input , start , mid);
        mergeSort(input , mid+1 , end);
        merge(input , start , end , mid);
    }
    private static void merge(int[] input, int start, int end , int mid) {
        int[] ans = new int[ (end - start ) + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        int l = 0;
        while (i <= mid && j <= end) {
            if (input[i] >  input[j]){
                ans [k] = input[j];
                j++;
                k++;
            }else {
                ans[k] = input[i];
                k++;
                i++;
            }
        }

        while (i<=mid){
            ans[k] = input[i];
            i++;
            k++;
        }
        while (j<=end){
            ans[k] = input[j];
            j++;
            k++;

        }

        while (l <ans.length) {
            input[l + start] = ans[l];
            l++;
        }

    }
}
