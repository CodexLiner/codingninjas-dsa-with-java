package lec_7_Trees;
/*Code : Number of nodes greater than x
        Send Feedback
        Given a tree and an integer x, find and return number of Nodes which are greater than x.
        Input format :
        Single Line : First Integer denotes x and rest of the elements in level order form separated by space. Order is -
        Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
        Output Format :
        Count of nodes greater than x
        Sample Input 1 :
        35 10 3 20 30 40 2 40 50 0 0 0 0
        Sample Output 1 :
        3
        Sample Input 2 :
        10 10 3 20 30 40 2 40 50 0 0 0 0
        Sample Output 2:
        5*/
public class nodes_greater_than_x {
    public static int numNodeGreater(TreeNode<Integer> root,int x){

        int y = 0;
        if(root==null){
            return 0;
        }
        if(root.data>x){
            y++;

        }
        for(TreeNode<Integer> node : root.children){
            y+= numNodeGreater(node , x);
        }
//         Queue<TreeNode<Integer>> Node = new LinkedList<>();
//         Node.add(root);
//         while (!Node.isEmpty()){
//             TreeNode<Integer> treeNode = Node.poll();
//             for (int i = 0; i < treeNode.children.size(); i++) {
//                 if(treeNode.children.get(i).data > x){
//                     y+=1;
//                 }

//                 Node.add(treeNode.children.get(i));
//             }

//         }
        return y;

    }
}
