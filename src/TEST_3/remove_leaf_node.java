package TEST_3;

import lec_7_Trees.TreeNode;

/*Remove leaf nodes in Tree
        Send Feedback
        Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes, which don't have any children.
        Note : Root will also be a leaf node if it doesn't have any child. You don't need to print the tree, just remove all leaf nodes and return the updated root.
        Input format :
        Line 1 : Elements in level order form separated by space (as per done in class). Order is - `

        Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `
        Output Format :
        Elements are printed level wise, each level in new line (separated by space)
        Sample Input 1 :
        10 3 20 30 40 2 40 50 0 0 0 0
        Sample Output 1 : (Level wise, each level in new line)
        10
        20*/
public class remove_leaf_node {
    public  static TreeNode removeLeafNodes(TreeNode root)
    {   if(root==null){ return null;}// if root is null return null
        if(root.children.size()==0){// if root itself is leaf return null
            return null;}

        for (int i = 0; i < root.children.size(); i++) {

            TreeNode child= (TreeNode) root.children.get(i);

            if (child.children.size() == 0) {


                for (int j = i; j < root.children.size() - 1; j++)
                    root.children.set(j, root.children.get(j + 1));

                root.children.remove(root.children.size()-1);

                i--;
            }
        }


        for (int i = 0;
             i < root.children.size();
             i++) {

            root.children.set(i,removeLeafNodes((TreeNode) root.children.get(i)));
        }
        return root;
    }
}
