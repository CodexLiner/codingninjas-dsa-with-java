package lec_9_Binary_search_Trees.assign;



import lec_8_Binary_Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/*Pair Sum Binary Tree
        Send Feedback
        Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.
        Note:
        1. Assume the given binary tree contains all unique elements.
        2. In a pair, print the smaller element first. Order of different pairs doesn't matter.
        Input format :
        The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
        The following line of input contains an integer, that denotes the value of S.
        Output Format :
        Print each pair in a new line, as described in the task.
        Constraints:
        Time Limit: 1 second
        Sample Input 1:
        5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
        15
        Sample Output 1:
        5 10
        6 9*/
public class pair_sum_binarytree {
    static void pairSum(BinaryTreeNode<Integer> root, int sum) {
        pairSum(root, sum , root);
    }
    static void pairSum(BinaryTreeNode<Integer> root, int sum , BinaryTreeNode<Integer> temp) {

        ArrayList<Integer> list =  helper(root , new ArrayList<>() , 0);
        int [] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length ; j++) {
                if (arr[i] + arr[j] ==sum && arr[i] != arr[j]){
                    System.out.println(arr[i]+" "+arr[j]);
                }
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
