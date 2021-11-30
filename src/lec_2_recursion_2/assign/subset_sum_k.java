package lec_2_recursion_2.assign;
/*Return subsets sum to K
        Send Feedback
        Given an array A of size n and an integer K, return all subsets of A which sum to K.
        Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
        Note : The order of subsets are not important.
        Input format :
        Line 1 : Integer n, Size of input array
        Line 2 : Array elements separated by space
        Line 3 : K
        Constraints :
        1 <= n <= 20
        Sample Input :
        9
        5 12 3 17 1 18 15 3 17
        6
        Sample Output :
        3 3
        5 1*/
public class subset_sum_k {
    public static int[][] subsetsSumK(int[] input, int k) {
        return subsetsSumK(input , k , 0);
    }
    public static int[][] subsetsSumK(int[] input, int k , int index) {
        if (index==input.length){
            if (k==0){
                return new int[1][0];
            }else {
                return new int[0][0];
            }

        }

        int[][] tempArr = subsetsSumK(input , k , index + 1);
        int[][] tempArr2 = subsetsSumK(input , k - input[index] , index + 1);
        int[][] op = new int[tempArr.length + tempArr2.length][];
        int t = 0;

        for (int i = 0; i < tempArr.length; i++) {
            op[i] = new int[tempArr[i].length ];
            for (int j = 0; j < tempArr[i].length; j++) {
                op[t][j] = tempArr[i][j];
            }
            t++;
        }
        for (int i = 0; i < tempArr2.length; i++) {
            op[t+i]  = new int[tempArr2[i].length + 1];
            op[i+t][0]= input[index];
            for (int j = 1; j <= tempArr2[i].length; j++) {
                op[i+t][j] = tempArr2[i][j- 1];
            }
        }
        return op;

    }

}
