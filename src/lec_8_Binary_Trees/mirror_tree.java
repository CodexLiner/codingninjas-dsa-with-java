package lec_8_Binary_Trees;
/*Mirror a Binary Tree
        Send Feedback
        For a given Binary Tree of type integer, update it with its corresponding mirror image.
        Example:
        Alt text

        Input Format:
        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
        Output Format:
        The only line of output prints the mirrored tree in a level-wise order.
        Each level will be printed on a new line. Elements printed at each level will be separated by a single line.
        Note:
        You are not required to print anything explicitly. It has already been taken care of.
        Constraints:
        1 <= N <= 10^5
        Where N is the total number of nodes in the binary tree.

        Time Limit: 1 sec
        Sample Input 1:
        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
        Sample Output 1:
        1
        3 2
        7 6 5 4
        Sample Input 2:
        5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
        Sample Output 2:
        5
        6 10
        3 2
        9*/
public class mirror_tree {
    public static void mirrorBinaryTree (BinaryTreeNode<Integer> root){
        root = mirrorBinaryTree(root , root);
        // lol(root);
    }
    public static BinaryTreeNode<Integer> mirrorBinaryTree(BinaryTreeNode<Integer> root , BinaryTreeNode<Integer> root2){
        if (root==null){
            return null;
        }
        BinaryTreeNode<Integer> leftNode , rightNode;
        leftNode=  mirrorBinaryTree(root.right , root2);
        rightNode = mirrorBinaryTree(root.left , root2);
        root.right = rightNode;
        root.left = leftNode;
        return root;

    }
}
