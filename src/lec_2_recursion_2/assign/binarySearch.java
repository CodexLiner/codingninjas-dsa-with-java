package lec_2_recursion_2.assign;
/*Binary Search (Recursive)
        Send Feedback
        Given an integer sorted array (sorted in increasing order) and an element x, find the x in given array using binary search. Return the index of x.
        Return -1 if x is not present in the given array.
        Note : If given array size is even, take first mid.
        Input format :

        Line 1 : Array size

        Line 2 : Array elements (separated by space)

        Line 3 : x (element to be searched)

        Sample Input :
        6
        2 3 4 5 6 8
        5
        Sample Output:
        3*/
public class binarySearch {
    // element - number to be searched
    public static int binarySearch(int[] input, int element) {
        return binarySearch(input , element , 0  , input.length - 1);
    }
    public static int binarySearch(int[] input, int element , int start , int end) {
        if (start >= end){
            return -1;

        }
        int mid = (start + end) / 2;
        if (input[mid]== element){
            return mid;
        }
        if (input[mid]<element){
            return binarySearch(input , element ,mid+ 1 , end);
        }
        if (input[mid] > element ){
            return binarySearch(input , element ,start , mid- 1);
        }
        return -1;

    }
}
