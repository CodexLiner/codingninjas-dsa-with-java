package lec_14_dynamic_programming_2.assign;
/*Matrix Chain Multiplication
        Send Feedback
        Given a chain of matrices A1, A2, A3,.....An, you have to figure out the most efficient way to multiply these matrices. In other words, determine where to place parentheses to minimize the number of multiplications.
        You will be given an array p[] of size n + 1. Dimension of matrix Ai is p[i - 1]*p[i]. You need to find minimum number of multiplications needed to multiply the chain.
        Input Format:
        The first line of input contains an integer, that denotes the value of n. The following line contains n+1 integers, that denote the value of elements of array p[].
        Output Format:
        The first and only line of output prints the minimum number of multiplication needed.
        Constraints :
        1 <= n <= 100
        Time limit: 1 second
        Sample Input 1:
        3
        10 15 20 25
        Sample Output 1:
        8000
        Sample Output Explanation:
        There are two ways to multiply the chain - A1*(A2*A3) or (A1*A2)*A3.
        If we multiply in order- A1*(A2*A3), then number of multiplications required are 11250.
        If we multiply in order- (A1*A2)*A3, then number of multiplications required are 8000.
        Thus minimum number of multiplications required are 8000.*/
public class matrix_chain_multi {
    public static int mcm(int[] p){
        int n=p.length;
        int m[][] = new int[n][n];

        int i, j, k, L, q;

        /* m[i, j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1]; }
}
//         int dp[][]=new int[p.length][p.length];
//         for(int i=0;i<=p.length;i++){
//             dp[i][i]=0;
//             dp[i][0]=0;
//             for(int j=1;j<p.length;j++){
//                 if(i>j)
//                     dp[i][j]=0;
//                 if(i==j-1)
//                     dp[i][j]=0;
//             }
//         }
//         for(int i=0;i<=p.length;i++){
//             for(int j=0;j<=p.length;j++){
//                 int min=Integer.MAX_VALUE;
//                 if(dp[i][j]==0)
//                     continue;
//                 else{
//                     for(int k=i+1;k<=j-1;k++)
//                     {
//                         int op=dp[i][k]+dp[k][j]+(p[i]*p[k]*p[j]);
//                             if(op<min)
//                                 dp[i][j]=min;
//                     }}
//             }
//         }
//         return dp[0][p.length];
//     }
// }
