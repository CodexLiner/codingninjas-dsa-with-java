package lec_10_hashmaps.assign;

import java.util.HashMap;

/*Pairs with difference K
        Send Feedback
        You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
        Note: Take absolute difference between the elements of the array.
        Input Format:
        The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol n.
        The following line contains n space separated integers, that denote the value of the elements of the array.
        The following line contains an integer, that denotes the value of K.
        Output format :
        The first and only line of output contains count of all such pairs which have an absolute difference of K.
        Constraints :
        0 <= n <= 10^4
        Time Limit: 1 sec
        Sample Input 1 :
        4
        5 1 2 4
        3
        Sample Output 1 :
        2
        Sample Input 2 :
        4
        4 4 4 4
        0
        Sample Output 2 :
        6*/
public class pair_with_diff_k {
    public static int getPairsWithDifferenceK(int arr[], int k) {
        if(k==0){
            int n=arr.length;
            return (n*(n-1))/2;
        }
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int key: arr){
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }
            else{
                map.put(key,1);
            }
        }
        int count=0;
        for(int a:arr){
            if(map.containsKey(a+k)){
                count+=map.get(a)*map.get(a+k);
            }
            if(map.containsKey(a-k)){
                count+=map.get(a)*map.get(a-k);
            }
            map.put(a,0);
        }
        return count;
    }
}
