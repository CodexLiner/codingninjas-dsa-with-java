package Assignment_BST;

import lec_8_Binary_Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/*Pair sum in a BST
        Send Feedback
        Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).
        Note:
        1. Assume BST contains all unique elements.
        2. In a pair, print the smaller element first.
        Input Format :
        The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
        The following line of input contains an integer, that denotes the value of S.
        Output format:
        You have to print each pair in a different line (pair elements separated by space). The order of different pairs, to be printed, does not matter.
        Constraints:
        Time Limit: 1 second
        Sample Input 1:
        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
        12
        Sample Output 1:
        2 10
        5 7*/
public class pair_sum_in_bst {
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if(root==null){
            return;
        }
        // Write your code here
        pairSum(root, s , root);
    }
    static void pairSum(BinaryTreeNode<Integer> root, int sum , BinaryTreeNode<Integer> temp) {

        ArrayList<Integer> list =  helper(root , new ArrayList<>() , 0);
        int [] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;
        while (i < j){
            if (arr[i] + arr[j] == sum){
                System.out.println(arr[i]+" "+arr[j]);
                i++;
                j--;
            }else if (arr[i] + arr[j] > sum){
                j--;
            }else if (arr[i] + arr[j] < sum){
                i++;
            }
        }

    }
    public static ArrayList<Integer> helper(BinaryTreeNode<Integer> root , ArrayList<Integer> arr , int i){
        if (root== null){
            return null;
        }
        arr.add(root.data);
        helper(root.left , arr , i+1);
        helper(root.right , arr , i+1);
        return arr;

    }
}
