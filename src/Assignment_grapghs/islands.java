package Assignment_grapghs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Islands
        Send Feedback
        An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 1 to V) and E connections or edges between islands. Can you count the number of connected groups of islands.
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
        Output Format :
        Print the count the number of connected groups of islands
        Constraints :
        0 <= V <= 1000
        0 <= E <= (V * (V-1)) / 2
        0 <= a <= V - 1
        0 <= b <= V - 1
        Time Limit: 1 second
        Sample Input 1:
        5 8
        0 1
        0 4
        1 2
        2 0
        2 4
        3 0
        3 2
        4 3
        Sample Output 1:
        1*/
public class islands {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int solve(boolean[][] graph, int n) {

        int count=0;
        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                if(graph[i][j]==false){
                    continue;
                }
                if(graph[i][j]==true){
                    for(int k=0;k<n;k++){
                        if(k==i)
                            continue;
                        if(graph[j][k]==false){
                            continue;
                        }
                        if(graph[j][k]==true){
                            if(graph[k][i]==true){
                                count++;
                            }
                        }





                    }
                }
            }
        }
        return count/6;
        /*
         * Your class should be named Solution
         * You may write your code here
         */
    }

    public static boolean[][] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int m = Integer.parseInt(strNums[1]);

        boolean[][] graphs = new boolean[n][n];
        int firstvertex, secondvertex;

        for (int i = 0; i < m; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s");
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            graphs[firstvertex][secondvertex] = true;
            graphs[secondvertex][firstvertex] = true;
        }
        return graphs;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        boolean[][] graphs = takeInput();

        int ans = solve(graphs, graphs.length);
        System.out.println(ans);

    }
}
