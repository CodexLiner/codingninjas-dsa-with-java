package lec_9_Binary_search_Trees;


import lec_8_Binary_Trees.BinaryTreeNode;

/*Check if a Binary Tree is BST
        Send Feedback
        Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree). If yes, return true, return false otherwise.
        Note: Duplicate elements should be kept in the right subtree.
        Input format :
        The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
        Output format :
        The first and only line of output contains either true or false.
        Constraints :
        Time Limit: 1 second
        Sample Input 1 :
        3 1 5 -1 2 -1 -1 -1 -1
        Sample Output 1 :
        true
        Sample Input 2 :
        5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1
        Sample Output 2 :
        false*/
public class checkBST {
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        if (root == null){
            return true;
        }
        int leftMin = maximum(root.left);
        int max =minimum(root.right);
        if (root.data <= leftMin){
            return false;
        }
        if (root.data > max ){
            // System.out.println("J");
            return false;
        }
        boolean isL = isBST(root.left);
        boolean isR = isBST(root.right);

        if (isR && isL){

            return true;
        }else {
            // System.out.println(" h");
            return false;
        }

    }

    private static int maximum(BinaryTreeNode<Integer> right) {
        if (right == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(right.data, Math.max(maximum(right.left) , maximum(right.right)) );
    }

    private static int minimum(BinaryTreeNode<Integer> left) {
        if (left == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(left.data, Math.min(minimum(left.left) , minimum(left.right)) );
    }
}
