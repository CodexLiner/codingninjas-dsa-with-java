package lec_7_Trees;
/*Node having sum of children and node is max
        Send Feedback
        Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.
        Input format :

        Line 1 : Elements in level order form separated by space (as per done in class). Order is -

        Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

        Output format : Node with maximum sum.

        Sample Input 1 :
        5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
        Sample Output 1 :
        1*/
public class node_having_children_and_node_is_max {
    static int meraMax = 0;
    static TreeNode<Integer> head;

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        root = maxSumNode(root , null , 0);
        //  System.out.println(root.data+" <- data "+" sum -> ");
        root.children = null;
        return root;
    }
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root , TreeNode<Integer> maxRoot  , int maxSum){
        if (root == null){
            return null;
        }
        // doublNode<Integer> node = null ;
        int sum = root.data;
        int sze = root.children.size();
        for (int i = 0; i < sze; i++) {
            sum+= root.children.get(i).data;
            maxSumNode(root.children.get(i) , maxRoot , maxSum);
        }
        if (sum > meraMax){
            meraMax = sum;
            head = new TreeNode<>(root.data);
            // System.out.println(head.data);
        }

        return head;
    }
}
