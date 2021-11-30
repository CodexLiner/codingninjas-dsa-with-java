package lec_7_Trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ScanTree {
    public static TreeNode<Integer> TakeInput() {
        Scanner s = new Scanner(System.in);
        int NodeData = s.nextInt();
        Queue<TreeNode<Integer>> Node = new LinkedList<>();
        TreeNode<Integer> treeNode = new TreeNode<>(NodeData);
        Node.add(treeNode);
        while (!Node.isEmpty()){
            TreeNode<Integer> front = Node.poll();
            int child = s.nextInt();
            for (int i = 0; i < child; i++) {
                int children = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(children);
                front.children.add(childNode);
                Node.add(childNode);
            }
        }

        return treeNode;
    }
    public static void print(TreeNode<Integer> root ){
        Queue<TreeNode<Integer>> Node = new LinkedList<>();
        Node.add(root);
        int x = 0;
        System.out.println(root.data);
        while (!Node.isEmpty()){
            TreeNode<Integer> treeNode = Node.poll();
            for (int i = 0; i < treeNode.children.size(); i++) {
                x+= treeNode.children.get(i).data ;
                System.out.print(treeNode.children.get(i).data+" ");
                Node.add(treeNode.children.get(i));
            }
            System.out.println();
        }

    }
    public static void printLevelWise(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            TreeNode<Integer> t = q.poll();
            if(!(t==null)){
//                System.out.print(t.children.get(i).data+" ");
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
    public static void main(String[] args) {
        TreeNode<Integer> root = TakeInput();
        print(root);
    }

}
;