package lec_3_time_complexcity;
/*Pair sum in array
        Send Feedback
        You have been given an integer array/list(ARR) and a number 'num'. Find and return the total number of pairs in the array/list which sum to 'num'.
        Note:
        Given array/list can contain duplicate elements.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        First line of each test case or query contains an integer 'N' representing the size of the first array/list.

        Second line contains 'N' single space separated integers representing the elements in the array/list.

        Third line contains an integer 'num'.
        Output format :
        For each test case, print the total number of pairs present in the array/list.

        Output for every test case will be printed in a separate line.
        Constraints :
        1 <= t <= 10^2
        0 <= N <= 10^4
        0 <= num <= 10^9

        Time Limit: 1 sec
        Sample Input 1:
        1
        9
        1 3 6 2 5 4 3 2 4
        7
        Sample Output 1:
        7
        Sample Input 2:
        2
        9
        1 3 6 2 5 4 3 2 4
        12
        6
        2 8 10 5 -2 5
        10
        Sample Output 2:
        0
        2*/

public class pairSum {
    public static int pairSum(int[] arr, int num) {
        int x = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j]== num){
                    x++;
                }
            }
        }
        // if (arr.length > 1&& arr[arr.length - 1]==0){   x--; }
        return x;
    }
}
