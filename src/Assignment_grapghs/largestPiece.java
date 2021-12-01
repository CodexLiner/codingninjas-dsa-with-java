package Assignment_grapghs;
/*Largest Piece
        Send Feedback
        It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
        Input Format :
        The first line of input contains an integer, that denotes the value of N.
        Each of the following N lines contain N space separated integers.
        Output Format :
        Print the count of '1's in the biggest piece of '1's, according to the description in the task.
        Constraints :
        1 <= N <= 1000
        Time Limit: 1 sec
        Sample Input 1:
        2
        1 1
        0 1
        Sample Output 1:
        3*/
public class largestPiece {
    public static int dfs(String[] edge, int n) {
        int max=0;
        int s=0;
        char[][] edg=new char[n][n];
        boolean[][] visited=new boolean[n][n];
        // WE DON'T NEED THIS.
        // for(int h=0;h<n;h++){
        //     for(int k=0;k<n;k++){
        //         edg[h][k]=' ';
        //     }
        // }
        for(int x=0;x<n;x++){
            edg[x]=edge[x].toCharArray();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(edg[i][j]=='1'  && !visited[i][j]  )
                    s=dfs(i,j,visited,edg,n);
                if(s>max){
                    max=s;
                }
            }
        }
        // if(s>max){
        //     max=s;
        // }
        return max;
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
    }
    // char[][] graph;
    //     for(int x=0;x<n;x++){
    //         graph[x]=Graph[x].toCharArray();
    //     }
    public static int dfs(int i,int j,boolean[][] visited,char[][] edg,int n){
        if((i<0 ||i>=n || j<0 || j>=n)  || visited[i][j]==true || edg[i][j]=='0')
            return 0;
        visited[i][j]=true;
        int count=0;
        count+=dfs(i-1,j,visited,edg,n);
        count+=dfs(i,j+1,visited,edg,n);
        count+=dfs(i+1,j,visited,edg,n);
        count+=dfs(i,j-1,visited,edg,n);
        return count+1;
    }
}
