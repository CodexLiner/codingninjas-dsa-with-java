package lec_11_priority_queues.assign;
/*Check Max-Heap
        Send Feedback
        Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.
        Input Format:
        The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
        The following line contains N space separated integers, that denote the value of the elements of the array.
        Output Format :
        The first and only line of output contains true if it represents max-heap and false if it is not a max-heap.
        Constraints:
        1 <= N <= 10^5
        1 <= Ai <= 10^5
        Time Limit: 1 sec
        Sample Input 1:
        8
        42 20 18 6 14 11 9 4
        Sample Output 1:
        true*/
public class check_max_heap {
    public static boolean checkMaxHeap(int A[]) {
        for (int i = 0; i <= (A.length - 2) / 2; i++)
        {
            if (A[i] < A[2*i + 1] || (2*i + 2 != A.length && A[i] < A[2*i + 2])) {
                return false;
            }
        }
        return true;
    }
}
