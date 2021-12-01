package lec_10_hashmaps.assign;

import java.util.ArrayList;
import java.util.HashMap;

/*Longest subset zero sum
        Send Feedback
        Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
        Input Format:
        The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
        The following line contains N space separated integers, that denote the value of the elements of the array.
        Output Format
        The first and only line of output contains length of the longest subarray whose sum is zero.
        Constraints:
        0 <= N <= 10^8
        Time Limit: 1 sec
        Sample Input 1:
        10
        95 -97 -387 -435 -5 -70 897 127 23 284
        Sample Output 1:
        5
        Explanation:
        The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897*/
public class longest_subset_zero {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // Write your code here
        ArrayList<Integer> al = new ArrayList<>();
        for(int k : arr){
            al.add(k);
        }
        return LongestSubsetWithZeroSum(al);
    }
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        // Map to store the previous sums
        HashMap<Integer, Integer> presum = new HashMap<Integer, Integer>();

        int sum = 0; // Initialize the sum of elements
        int maxLen = 0; // Initialize result
        int n = arr.size();
        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr.get(i);

            if (arr.get(i) == 0 && maxLen == 0)
                maxLen = 1;
            if (sum == 0)
                maxLen = i + 1;

            // Look for this sum in Hash table
            if (presum.containsKey(sum)) {
                // If this sum is seen before, then update maxLen
                maxLen = Math.max(maxLen, i - presum.get(sum));
            } else {
                // Else insert this sum with index in hash table
                presum.put(sum, i);
            }
        }

        return maxLen;
    }
}
