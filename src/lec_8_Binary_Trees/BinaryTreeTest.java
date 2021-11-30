package lec_8_Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeTest {
    public static void print(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        String s = root.data+" :";
        if (root.left!=null){
            s+= root.left.data+" ";
        }
        if (root.right!=null){
            s+= root.right.data+" ";
        }
        System.out.println(s+" ");
        print(root.left);
        print(root.right);
    }
    public static BinaryTreeNode<Integer> takeInput(){
       Scanner s = new Scanner(System.in);
       int rootNode = s.nextInt();
       if (rootNode == - 1){
           return null;
       }
       BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootNode);
       Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
           BinaryTreeNode<Integer> front = q.poll();
           int left = s.nextInt();
           if (!(left ==-1)){
               BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(left);
               front.left = leftNode;
               q.add(leftNode);
           }
           int right = s.nextInt();
           if (!(right ==-1)){
               BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(right);
               front.right = rightNode;
               q.add(rightNode);
           }
       }
       return root;
    }
    public static BinaryTreeNode<Integer> ScanTree(Scanner s){
       int rootData;
       rootData = s.nextInt();
       if (rootData == -1){
           return null;
       }
       BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
       root.left = ScanTree(s);
       root.right = ScanTree(s);
       return root;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInput();
//        BinaryTreeNode<Integer> root = ScanTree(new Scanner(System.in));
        print(root);
    }
}
