package lec_14_dynamic_programming_2.assign;

import java.util.Arrays;

/*Ways To Make Coin Change
        Send Feedback
        For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
        Return 0 if the change isn't possible.
        Input Format
        The first line of the input contains an integer value N, which denotes the total number of denominations.

        The second line of input contains N values, separated by a single space. These values denote the value of denomination.

        The third line of the input contains an integer value, that denotes the value of V.
        Output Format
        Print the total total number of ways i.e. W.
        Constraints :
        1 <= n <= 10
        1 <= V <= 1000

        Time Limit: 1sec
        Sample Input 1 :
        3
        1 2 3
        4
        Sample Output 1 :
        4
        Explanation to Sample Input 1 :
        Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
        Sample Input 2 :
        6
        1 2 3 4 5 6
        250
        Sample Output 2 :
        13868903*/
public class ways_to_make_coin_change {

    static int count(int S[], int m, int n)
    {

        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <= 0 && n >= 1)
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count(S, m - 1, n) +
                count(S, m, n - S[m - 1]);
    }

    static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }
    public static int countWaysToMakeChange(int denominations[], int value){
        // Write your code here
        return (int) countWays(denominations , denominations.length, value);
    }
}
