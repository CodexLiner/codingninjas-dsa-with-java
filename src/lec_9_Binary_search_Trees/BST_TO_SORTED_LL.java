package lec_9_Binary_search_Trees;


import lec_4_Linked_list.LinkedListNode;
import lec_8_Binary_Trees.BinaryTreeNode;


/*Code: BST to Sorted LL
        Send Feedback
        Given a BST, convert it into a sorted linked list. You have to return the head of LL.
        Input format:
        The first and only line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
        Output Format:
        The first and only line of output prints the elements of sorted linked list.
        Constraints:
        Time Limit: 1 second
        Sample Input 1:
        8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
        Sample Output 1:
        2 5 6 7 8 10*/
class pair{
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
}

public class BST_TO_SORTED_LL {
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root ) {
        if (root == null ){
            return null;
        }
        pair node = helper(root);

        return node.head;
    }
    public static pair helper (BinaryTreeNode<Integer> root){
        if (root == null){
            return new pair();
        }
        pair leftTree = helper(root.left);
        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);
        pair rightTree = helper(root.right);
        pair out = new pair();
        if (leftTree.head!= null){
            out.head = leftTree.head;
            leftTree.tail.next = newNode;

        }else {
            out.head = newNode;
        }
        newNode.next = rightTree.head;
        if (rightTree.head == null){
            out.tail = newNode;
        }else {
            out.tail = rightTree.tail;
        }
        return out;

    }
}
