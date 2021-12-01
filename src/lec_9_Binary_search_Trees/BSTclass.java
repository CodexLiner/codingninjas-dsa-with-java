package lec_9_Binary_search_Trees;


import lec_8_Binary_Trees.BinaryTreeNode;

/*Code: BST Class
        Send Feedback
        Implement the BST class which includes following functions -
        1. search
        Given an element, find if that is present in BST or not. Return true or false.
        2. insert -
        Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.
        3. delete -
        Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
        4. printTree (recursive) -
        Print the BST in ithe following format -
        For printing a node with data N, you need to follow the exact format -
        N:L:x,R:y
        where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
        There is no space in between.
        You need to print all nodes in the recursive format in different lines.*/
public class BSTclass {
    private BinaryTreeNode<Integer> root;
    private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root ,int data){
        if (root == null){
            BinaryTreeNode<Integer> nn = new BinaryTreeNode<>(data);
            return nn;
        }

        if (data > root.data){

            root.right = insert(root.right , data);;

        }else if (data <= root.data) {

            root.left =insert(root.left , data);
        }

        return root;
    }
    public void insert(int data) {
        root = insert(root ,data);
    }
    private BinaryTreeNode<Integer> remove(int data , BinaryTreeNode<Integer> root) {
        if (root == null){
            return null;
        }
        if (data < root.data){
            root.left = remove(data, root.left);
        }else if (data > root.data){
            root.right = remove(data , root.right);
        }else {
            if (root.right == null && root.left == null){
                return null;
            }else if (root.right==null){
                return root.left;
            }else if (root.left==null){
                return root.right;
            }else {
                BinaryTreeNode<Integer> newNode = root.right;
                while (newNode.left != null){
                    newNode = newNode.left;
                }
                root.data = newNode.data;
                root.right = remove(data , root.right);
                return root;
            }
        }
        return root;
    }
    public void remove(int data) {
        // root = remove(data , root);
        root =  deleteHelper(root, data);
    }
    private static void printTree(BinaryTreeNode<Integer> root ){
        if (root == null){
            return;
        }
        if (root.left != null && root.right != null ){
            System.out.println(root.data+":L:"+root.left.data+",R:"+root.right.data);
        }
        if (root.left != null && root.right == null ){
            System.out.println(root.data+":L:"+root.left.data+",");
        }
        if (root.right != null && root.left == null ){
            System.out.println(root.data+":R"+root.right.data+",");
        }
        if (root.left == null && root.right == null ){
            System.out.println(root.data+":");
        }
        printTree(root.left);
        printTree(root.right);
        // System.out.println(root.data);
    }
    public void printTree() {
        // printTree(root);
        printHelper(root);
    }
    private boolean search(BinaryTreeNode<Integer> root , int data){
        if (root == null){
            return false;
        }
        if (root.data == data){
            return true;
        }
        if (root.data > data){
            return search(root.left , data);
        }else {
            return search(root.right , data);
        }
    }
    public boolean search(int data) {
        return search(root , data);
    }
    private static BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> root,int data){
        if(root==null)
            return null;
        if(root.data==data){
            if(root.left!=null && root.right==null)
                return root.left;
            else if(root.left==null && root.right!=null)
                return root.right;
            else if(root.left==null && root.right==null)
                return null;
            else{
                // int rootData=minimum(root.right);
                //  BinaryTreeNode<Integer> newNode= deleteHelper(root,rootData);

                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = deleteHelper(root.right,minNode.data);
                return root;
            }

        }
        else if(root.data>data)
        {BinaryTreeNode<Integer> leftt=deleteHelper(root.left,data);
            root.left=leftt;}
        else{
            BinaryTreeNode<Integer> rightt=deleteHelper(root.right,data);
            root.right=rightt;
        }

        return root;
    }
    private static void printHelper(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return ;
        // String s=root.data+":";
        System.out.print(root.data+":");
        if(root.left!=null)
            // s=s+"L:"+root.left.data+",";
            System.out.print("L:"+root.left.data+",");
        if(root.right!=null){
            // s=s+"R:"+root.right.data;
            System.out.print("R:"+root.right.data);
        }
        // System.out.println(s);
        System.out.println();
        printHelper(root.left);
        printHelper(root.right);
        return;
    }

}



// public class BinarySearchTree {
//     private static BinaryTreeNode<Integer> root;
//     //     ----search
//     public static boolean search(int data){
//         return searchHelper(root,data);

//     }
//     private static boolean searchHelper(BinaryTreeNode<Integer> root,int data){
//         if(root==null)
//             return false;
//         if(root.data==data)
//             return true;
//         else if(root.data>data)
//             return searchHelper(root.left,data);
//         else
//             return searchHelper(root.right,data);

//     }

//     //    ----insert
//     public static void insert(int data){
//         root=insertHelper(root,data);
//         // return ;
//     }
//     private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root,int data)
//     {
//         if(root==null)
//         {
//             BinaryTreeNode<Integer> node= new BinaryTreeNode<>(data);
//             return node;
//         }
//         if(data>root.data)
//         {
//             BinaryTreeNode<Integer> rightcall=insertHelper(root.right,data);
//             root.right=rightcall;
//         }
//         else if(data<root.data)
//         {
//             BinaryTreeNode<Integer> leftcall=insertHelper(root.left,data);
//             root.left=leftcall;
//         }

//         return root;
//     }



//     // -----printTree
//     public static void printTree(){
//         printHelper(root);
//         return;
//     }
//     private static void printHelper(BinaryTreeNode<Integer> root)
//     {
//         if(root==null)
//             return ;
//        // String s=root.data+":";
//         System.out.print(root.data+":");
//         if(root.left!=null)
//             // s=s+"L:"+root.left.data+",";
//             System.out.print("L:"+root.left.data+",");
//         if(root.right!=null){
//         // s=s+"R:"+root.right.data;
//             System.out.print("R:"+root.right.data);
//         }
//         // System.out.println(s);
//         System.out.println();
//         printHelper(root.left);
//         printHelper(root.right);
//         return;
//     }


//     // ------delete
//     public static void remove(int data){
//         root= deleteHelper(root,data);
//         // return;
//     }
//     private static BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> root,int data){
//         if(root==null)
//             return null;
//         if(root.data==data){
//             if(root.left!=null && root.right==null)
//                 return root.left;
//             else if(root.left==null && root.right!=null)
//                 return root.right;
//             else if(root.left==null && root.right==null)
//                 return null;
//             else{
//                 // int rootData=minimum(root.right);
//                 //  BinaryTreeNode<Integer> newNode= deleteHelper(root,rootData);

//                 BinaryTreeNode<Integer> minNode = root.right;
//                 while (minNode.left != null) {
//                     minNode = minNode.left;
//                 }
//                 root.data = minNode.data;
//                 root.right = deleteHelper(root.right,minNode.data);
//                 return root;
//             }

//         }
//         else if(root.data>data)
//         {BinaryTreeNode<Integer> leftt=deleteHelper(root.left,data);
//          root.left=leftt;}
//         else{
//             BinaryTreeNode<Integer> rightt=deleteHelper(root.right,data);
//             root.right=rightt;
//             return root;
//         }

//         return root;
//     }

// }

