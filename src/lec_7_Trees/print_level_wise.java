package lec_7_Trees;

import java.util.LinkedList;
import java.util.Queue;

/*Code : Print Level Wise
        Send Feedback
        Given a generic tree, print the input tree in level wise order. That is, print the elements at same level in one line (separated by space). Print different levels in differnet lines.
        Input format :
        Elements in level order form separated by space (as per done in class). Order is -
        Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
        Output Format :
        Level wise print
        Sample Input :
        10 3 20 30 40 2 40 50 0 0 0 0
        Sample Output :
        10
        20 30 40
        40 50*/
public class print_level_wise {
    public static void printLevelWise(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            TreeNode<Integer> t = q.poll();
            if(!(t==null)){
                System.out.print(t.data+" ");
                for(int i =0 ; i < t.children.size() ; i++){
                    q.add(t.children.get(i));
                }
            }else{
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }

        }

    }
}
