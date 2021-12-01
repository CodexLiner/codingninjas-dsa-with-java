package Assignment_grapghs;
/*Coding Ninjas
        Send Feedback
        Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
        There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.
        Input Format :
        The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns in the matrix.
        Each of the following N lines contain M characters. Please note that characters are not space separated.
        Output Format :
        Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.
        Constraints :
        1 <= N <= 1000
        1 <= M <= 1000
        Time Limit: 1 second
        Sample Input 1:
        2 11
        CXDXNXNXNXA
        XOXIXGXIXJX
        Sample Output 1:
        1*/
public class codingNinjas {
    int l=0;
    public int solve(String[] Graph , int N, int M)
    {
        char[][] graph=new char[N][M];
        for(int h=0;h<N;h++){
            for(int k=0;k<M;k++){
                graph[h][k]=' ';
            }
        }
        for(int x=0;x<N;x++){
            graph[x]=Graph[x].toCharArray();
        }
        String s="CODINGNINJA";
        int[][] visited=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j]==s.charAt(0)){

                    solveHelper(graph,N,M,i,j,s,visited);
                    if(l>0)
                        return 1;

                }

            }
        }
        return 0;
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
    }
    public void solveHelper(char Graph[][] ,int N,int M,int i,int j, String S ,int[][] visited)
    {

        if(S.length()==0)

        {
            l++;
            return;
        }


        if(i<0 || i>=N || j<0 || j>=M)
            return ;

        if(visited[i][j]== 1)
            return;


        if(S.charAt(0)!=Graph[i][j])
            return;

        visited[i][j]=1;

        solveHelper(Graph,N,M,i-1,j,S.substring(1),visited);
        solveHelper(Graph,N,M,i+1,j,S.substring(1),visited);
        solveHelper(Graph,N,M,i,j-1,S.substring(1),visited);
        solveHelper(Graph,N,M,i,j+1,S.substring(1),visited);
        solveHelper(Graph,N,M,i+1,j-1,S.substring(1),visited);
        solveHelper(Graph,N,M,i+1,j+1,S.substring(1),visited);
        solveHelper(Graph,N,M,i-1,j-1,S.substring(1),visited);
        solveHelper(Graph,N,M,i-1,j+1,S.substring(1),visited);

        visited[i][j]=0;
    }

}
