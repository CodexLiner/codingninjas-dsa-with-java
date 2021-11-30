package lec_7_Trees;

import java.util.LinkedList;
import java.util.Queue;

/*Code : Sum of nodes
        Send Feedback
        Given a generic tree, count and return the sum of all nodes present in the given tree.
        Input format :
        Elements in level order form separated by space (as per done in class). Order is -
        Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
        Output Format :
        Sum of all nodes
        Sample Input :
        10 3 20 30 40 2 40 50 0 0 0 0
        Sample Output :
        190*/
public class sum_of_nodes {
    public static int sumOfAllNode(TreeNode<Integer> root){
        int y = root.data;
        if(root==null){
            return 0;
        }
        Queue<TreeNode<Integer>> Node = new LinkedList<>();
        Node.add(root);
        int x = 0;
        // System.out.println(root.data);
        while (!Node.isEmpty()){
            TreeNode<Integer> treeNode = Node.poll();
            for (int i = 0; i < treeNode.children.size(); i++) {
                x+= treeNode.children.get(i).data ;
                // System.out.print(treeNode.children.get(i).data+" ");
                Node.add(treeNode.children.get(i));
            }
            // System.out.println();
        }
        return x+y;
    }
}
