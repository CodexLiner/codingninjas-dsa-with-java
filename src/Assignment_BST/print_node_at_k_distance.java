package Assignment_BST;

import lec_8_Binary_Trees.BinaryTreeNode;

/*Print nodes at distance k from node
        Send Feedback
        You are given a Binary Tree of type integer, a target node, and an integer value K.
        Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
        Example:
        For a given input tree(refer to the image below):
        1. Target Node: 5
        2. K = 2
        alt txt

        Starting from the target node 5, the nodes at distance K are 7 4 and 1.
        Input Format:
        The first line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.

        The second line of input contains two integers separated by a single space, representing the value of the target node and K, respectively.
        Output Format:
        All the node data at distance K from the target node will be printed on a new line.

        The order in which the data is printed doesn't matter.
        Constraints:
        1 <= N <= 10^5
        Where N is the total number of nodes in the binary tree.

        Time Limit: 1 sec
        Sample Input 1:
        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
        3 1
        Sample Output 1:
        9
        6
        Sample Input 2:
        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
        3 3
        Sample Output 2:
        4
        5*/
public class print_node_at_k_distance {
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        // Write your code here
        int x = print(root,k,node);
    }

    public static int print(BinaryTreeNode<Integer> root, int k, int elem){
        if(root == null){
            return -1;
        }

        if(root.data == elem){
            printAtDepthK(root,k);
            return 0;
        }

        int ld = print(root.left,k,elem);

        int rd;
        if(ld == -1){
            rd = print(root.right,k,elem);
            if(rd == -1){
                return -1;
            }else if(rd + 1 == k){
                System.out.println(root.data+" ");
                return k;
            }else{
                printAtDepthK(root.left,k-rd-2);
                return rd+1;
            }
        }else if(ld + 1 == k){
            System.out.println(root.data+" ");
            return k;
        }else{
            printAtDepthK(root.right,k-ld-2);
            return ld+1;
        }

    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root,int depth){
        if(root == null){
            return;
        }

        if(depth == 0 && root != null){
            System.out.println(root.data+" ");
            return;
        }

        printAtDepthK(root.left,depth-1);
        printAtDepthK(root.right,depth-1);
    }
}
