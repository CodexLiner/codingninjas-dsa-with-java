package TEST_3;

import lec_8_Binary_Trees.BinaryTreeNode;

/*Check cousins
        Send Feedback
        Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are cousins of each other or not. Two nodes are said to be cousins of each other if they are at same level of the Binary Tree and have different parents.
        Do it in O(n).
        Input format :
        Line 1 : Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place
        Line 2 : integer value of p
        Line 3 : Integer value of q
        Output format :
        true or false
        Constraints :
        1 <= N <= 10^5
        Sample Input :
        5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1
        2
        4
        Sample Output :
        true*/
public class check_cousins {

    public static boolean areNodesSibling(BinaryTreeNode<Integer> root, int a, int b)
    {
        if (root == null)
        {
            return false;
        }

        if (root.left != null && root.right != null)
        {
            if (root.left.data == a && root.right.data == b)
            {
                return true;
            }
            if (root.left.data == b && root.right.data == a)
            {
                return true;
            }
        }

        if (areNodesSibling(root.left, a, b))
        {
            return true;
        }
        if (areNodesSibling(root.right, a, b))
        {
            return true;
        }

        return false;
    }

    public static int findLevel(BinaryTreeNode<Integer> root, int x, int level)
    {
        if (root == null)
        {
            return 0;
        }
        if (root.data == x)
        {
            return level;
        }

        // if x is found in left subtree
        int lev = findLevel(root.left, x, level + 1);
        if (lev != 0)
        {
            return lev;
        }

        return findLevel(root.right, x, level + 1);
    }

    public static boolean isCousin(BinaryTreeNode<Integer> root, int a, int b)
    {

        // a and b are the given two nodes
        if (a != b && findLevel(root, a, 1) == findLevel(root, b, 1) && !areNodesSibling(root, a, b))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
