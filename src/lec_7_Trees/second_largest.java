package lec_7_Trees;
/*Second Largest Element In Tree
        Send Feedback
        Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
        Input format :
        Elements in level order form separated by space (as per done in class). Order is -

        Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
        Output format:
        Second Largest node data
        Sample Input 1 :
        10 3 20 30 40 2 40 50 0 0 0 0
        Sample Output 1 :
        40*/
public class second_largest {
    public static TreeNode<Integer> lar=null;
    public static TreeNode<Integer> sec=null;
    public static int largest=0;
    public static int second=0;
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        if(root==null){
            return sec;
        }
        if(root.children.size()==0){
            if(root.data>largest){
                second=largest;
                sec=lar;
                largest=root.data;
                lar=root;
            }
            else if(root.data<largest && root.data>second){
                second=root.data;
                sec=root;
            }
            return sec;
        }
        for(int i=0;i<root.children.size();i++){
            TreeNode<Integer> temp=findSecondLargest(root.children.get(i));
        }
        if(root.data>largest){
            second=largest;
            sec=lar;
            largest=root.data;
            lar=root;
        }
        else if(root.data<largest && root.data>second){
            second=root.data;
            sec=root;
        }
        return sec;
        /*doubleNode<Integer> n = new doubleNode<>(new TreeNode<>(0) , new TreeNode<>(0));
        n = secondLargestNode(root , n);
        return n.sMax;*/
    }
    /*public static doubleNode <Integer> secondLargestNode(TreeNode<Integer> root , doubleNode<Integer> node){
        if (root == null){
            return new doubleNode<>(null , null);
        }
        if (root.data > node.max.data){
            node.sMax.data = node.max.data;
            node.max.data = root.data;
        }else if (root.data > node.sMax.data && !root.data.equals(node.max.data)){
//            node.sMax.data = node.max.data;
              node.sMax.data = root.data;
        }
        for (int i = 0; i < root.children.size(); i++) {
            node = secondLargestNode(root.children.get(i) , node);
        }
        return node;
    }*/
}
