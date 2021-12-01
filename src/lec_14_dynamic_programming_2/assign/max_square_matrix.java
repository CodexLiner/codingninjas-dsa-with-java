package lec_14_dynamic_programming_2.assign;
/*Maximum Square Matrix With All Zeros
        Send Feedback
        Given an NxM matrix that contains only 0s and 1s, find out the size of the maximum square sub-matrix with all 0s. You need to return the size of the square matrix with all 0s.
        Input format :
        The first line of the test case contains two integer values, 'N' and 'M', separated by a single space. They represent the 'rows' and 'columns' respectively.

        Second-line onwards, the next 'N' lines or rows represent the ith row values.

        Each of the ith rows constitutes column values separated by a single space (Either 0 or 1).
        Output Format:
        Print the size of maximum square sub-matrix.
        Constraints :
        0 <= N <= 10^4
        0 <= M <= 10^4

        Time Limit: 1 sec
        Sample Input 1:
        3 3
        1 1 0
        1 1 1
        1 1 1
        Sample Output 1:
        1
        Sample Input 2:
        4 4
        0 0 0 0
        0 0 0 0
        0 0 0 0
        0 0 0 0
        Sample Output 2:
        4*/
public class max_square_matrix {
    public static int findMaxSquareWithAllZeros(int[][] input){
        if(input.length == 0 )return 0;
        int arr [][] = new int[input.length][input[0].length];

        for(int i=0;i<arr[0].length;i++){
            if(input[0][i] == 0){
                arr[0][i] = 1;
            }else{
                arr[0][i] = 0;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(input[i][0] == 0){
                arr[i][0] = 1;
            }else{
                arr[i][0] = 0;
            }
        }


        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(input[i][j] != 0){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1 + Math.min(arr[i-1][j-1] ,Math.min(arr[i][j-1],arr[i-1][j]));
                }

            }
        }

        int maximum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] > maximum){
                    maximum = arr[i][j];
                }
            }
        }

        return maximum;
    }
}
