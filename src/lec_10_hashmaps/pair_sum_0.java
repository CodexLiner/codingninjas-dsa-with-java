package lec_10_hashmaps;

import java.util.HashMap;

/*Pair Sum to 0
        Send Feedback
        Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
        Note: Array A can contain duplicate elements as well.
        Input format:
        The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
        The following line contains N space separated integers, that denote the value of the elements of the array.
        Output format :
        The first and only line of output contains the count of pair of elements in the array which sum up to 0.
        Constraints :
        0 <= N <= 10^4
        Time Limit: 1 sec
        Sample Input 1:
        5
        2 1 -2 2 3
        Sample Output 1:
        2*/
public class pair_sum_0 {
    public static int PairSum(int[] input, int size) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if(map.containsKey(0 - input[i]))		// Finding pairs
                count += map.get(0 - input[i]);

            if (map.containsKey(input[i])){
                int x = map.get(input[i]);
                map.put(input[i] , x+1);		// x+1 while updating frequency
                // System.out.println(map.get(input[i]++)+" i ");
            }else {
                map.put(input[i] ,1 );
            }
        }
        // for (int a : input){				count has been updated inside for loop
        //     if (map.containsKey((-a))){
        //         count++;
        //     }
        // }
        return count;
    }
}
