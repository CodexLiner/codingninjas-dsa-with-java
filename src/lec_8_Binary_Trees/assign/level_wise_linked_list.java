package lec_8_Binary_Trees.assign;

import lec_4_Linked_list.LinkedListNode;
import lec_8_Binary_Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Level wise linkedlist
        Send Feedback
        Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.
        Input format :
        The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
        Output format :
        Each level linked list is printed in new line (elements are separated by space).
        Constraints:
        Time Limit: 1 second
        Sample Input 1:
        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
        Sample Output 1:
        5
        6 10
        2 3
        9*/
public class level_wise_linked_list {
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        ArrayList<LinkedListNode<Integer>> list =  new ArrayList<>();
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            BinaryTreeNode<Integer> node = q.poll();
//            System.out.print(node.data+" ");
            if (node!=null){
                LinkedListNode<Integer> newNode = new LinkedListNode<>(node.data);
                if (head == null && tail == null){
                    head = newNode;
                    tail = newNode;
                }else {
                    tail.next = newNode;
                    tail = newNode;
                }
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }

            }else {
                list.add(head);
                head = null;
                tail = null;
                if(q.isEmpty()){
                    break;
                }else{
                    if (q.peek() == null){
                        break;
                    }
                    q.add(null);
                }
            }

        }
        return list;
    }
}
