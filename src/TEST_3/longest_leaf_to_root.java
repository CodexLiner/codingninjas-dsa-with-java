package TEST_3;

import lec_8_Binary_Trees.BinaryTreeNode;

import java.util.ArrayList;

/*Longest Leaf to root path
        Send Feedback
        Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
        Input format :

        Elements in level order form (separated by space)

        (If any node does not have left or right child, take -1 in its place)

        Line 1 : Binary Tree 1 (separated by space)

        Sample Input 1 :
        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
        Sample Output 1 :
        9
        3
        6
        5*/
public class longest_leaf_to_root {
    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root)
    {

        // If root is null means there
        // is no binary tree so
        // return a empty vector
        if(root == null)
        {
            ArrayList<Integer> output = new ArrayList<>();
            return output;
        }

        ArrayList<Integer> right = longestRootToLeafPath(root.right);

        ArrayList<Integer> left = longestRootToLeafPath(root.left);

        if(right.size() < left.size())
        {
            left.add(root.data);
        }
        else
        {
            right.add(root.data);
        }

        // Return the appropriate ArrayList
        return (left.size() >
                right.size() ? left :right);
    }

}
