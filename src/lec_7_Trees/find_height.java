package lec_7_Trees;
/*Code : Find Height
        Send Feedback
        Given a generic tree, find and return the height of given tree.
        Input Format:
        The first line of input contains data of the nodes of the tree in level order form. The order is: data for root node, number of children to root node, data of each of child nodes and so on and so forth for each node. The data of the nodes of the tree is separated by space.
        Output Format :
        The first and only line of output prints the height of the given generic tree.
        Constraints:
        Time Limit: 1 sec
        Sample Input 1:
        10 3 20 30 40 2 40 50 0 0 0 0
        Sample Output 1:
        3*/
public class find_height {
    public static int getHeight(TreeNode<Integer> root){

        if(root==null)
            return 0;
        int height=0;
        int max=0;
        for(int i=0;i<root.children.size();i++){
            height=getHeight(root.children.get(i));
            if(height>max)
                max=height;
        }

        return max+1;




        // int x = 0;
        // for (TreeNode<Integer> font : root.children){
        //            int ans = getHeight(font);
        //            x = ans;
        // }
        // return x+1;
    }

}
