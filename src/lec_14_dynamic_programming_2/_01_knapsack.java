package lec_14_dynamic_programming_2;
/*Code: 0 1 Knapsack
        Send Feedback
        A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?
        Input Format :
        The first line of the input contains an integer value N, which denotes the total number of items.

        The second line of input contains the N number of weights separated by a single space.

        The third line of input contains the N number of values separated by a single space.

        The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.
        Output Format :
        Print the maximum value of V that the thief can steal.
        Constraints :
        1 <= N <= 20
        1<= Wi <= 100
        1 <= Vi <= 100

        Time Limit: 1 sec
        Sample Input 1 :
        4
        1 2 4 5
        5 4 8 6
        5
        Sample Output 1 :
        13
        Sample Input 2 :
        5
        12 7 11 8 9
        24 13 23 15 16
        26
        Sample Output 2 :
        51*/
public class _01_knapsack {
    public static int knapsack(int[] weights, int[] values, int i, int maxWeight) {

        return knapsack(weights , values , i+ 1 , maxWeight , 0);
    }

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight , int i) {
        if (i == weights.length || maxWeight == 0){
            return 0;
        }
        if (weights[i] > maxWeight){
            return knapsack(weights , values , i+ 1 , maxWeight, i+ 1);
        }else {
            int a =  knapsack(weights , values , i + 1 , maxWeight , i+ 1);
            int b = values[i] + knapsack(weights , values , i + 1 , maxWeight - weights[i] , i+ 1);
            return Math.max(a , b);
        }
    }
}
