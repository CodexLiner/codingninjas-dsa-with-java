package lec_14_dynamic_programming_2;
/*Code: Knapsack(Memoization and DP)
        Send Feedback
        A thief is robbing a store and can carry a maximal weight of W into his knapsack. There are N items and ith item weighs wi and is of value vi. Considering the constraints of maximum weight that knapsack can carry, you have to find and return the maximum value that thief can generate by stealing items.
        Note
        Space complexity should be O(W).
        Input Format :
        The first line contains an integers, that denote the value of N. The following line contains N space separated integers, that denote the values of weight of items. The following line contains N space separated integers, that denote the values associated with the items. The following line contains an integer that denote the value of W. W denotes maximum weight that thief can carry.
        Output Format :
        The first and only line of output contains the maximum value that thief can generate, as described in the task.
        Constraints
        1 <= N <= 10^4
        1<= wi <= 100
        1 <= vi <= 100
        Time Limit: 1 second
        Sample Input 1 :
        4
        1 2 4 5
        5 4 8 6
        5
        Sample Output 1 :
        13*/
public class _01_knapsack_dp {
    public static int knapsack(int[] weight,int value[], int n ,int maxWeight){

//         int n=weight.length;
//         int storage[][]=new int[n+1][maxWeight+1];
//         for(int i=0;i<n+1;i++){
//             for(int j=0;j<maxWeight+1;j++){
//                 storage[i][j]=-1;
//             }
//         }
//         return knapsack(weight,value,maxWeight,n+1,storage,0);
//     }
//     public static int knapsack(int[] weight,int value[],int maxWeight,int n,int[][] storage,int i){
//         if(i==weight.length || maxWeight==0){
//             storage[i][maxWeight]=0;
//             return storage[i][maxWeight];}

//         if(storage[i][maxWeight]!=-1)
//             return storage[i][maxWeight];
//         if(weight[i]>maxWeight)
//         {
//             storage[i][maxWeight]=knapsack(weight,value,maxWeight,n-1,storage,i+1);
//             return storage[i][maxWeight];
//         }
//         else{
//             int op1=value[i]+knapsack(weight,value,maxWeight-weight[i],n-1,storage,i+1);
//             int op2=knapsack(weight,value,maxWeight,n-1,storage,i+1);
//             storage[i][maxWeight]=Math.max(op1,op2);
//             return storage[i][maxWeight];
//         }

//     }

// }


        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int storagePrev[] = new int[maxWeight+1];
        int storageCurrent[] = new int [maxWeight+1];
        for(int i=1;i<value.length+1;i++){
            for(int w = 1;w<maxWeight+1;w++){
                if(weight[i-1]>w){
                    storageCurrent[w] = storagePrev[w];
                }
                else {
                    storageCurrent[w]= Math.max(storagePrev[w - weight[i-1]]+ value[i-1],storagePrev[w]);
                }
            }
            storagePrev = storageCurrent ;
            storageCurrent = new int[maxWeight+1];

        }
        return storagePrev[maxWeight];
    }

}
