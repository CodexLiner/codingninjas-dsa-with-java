package lec_5_linked_list_2;

import lec_4_Linked_list.LinkedListNode;

/*Code : Merge Sort
        Send Feedback
        Given a singly linked list of integers, sort it using 'Merge Sort.'
        Note :
        No need to print the list, it has already been taken care. Only return the new head to the list.
        Input format :
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
        Output format :
        For each test case/query, print the elements of the sorted singly linked list.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Where M is the size of the singly linked list.

        Time Limit: 1sec
        Sample Input 1 :
        1
        10 9 8 7 6 5 4 3 -1
        Sample Output 1 :
        3 4 5 6 7 8 9 10
        Sample Output 2 :
        2
        -1
        10 -5 9 90 5 67 1 89 -1
        Sample Output 2 :
        -5 1 5 9 10 67 89 90*/
public class mergeSort {
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        LinkedListNode<Integer> list1 = head1 , list2 = head2 , tail = null , head = null;
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        if (list1.data <= list2.data){
            head = list1;
            tail = list1;
            list1 = list1.next;
        }else {
            head = list2;
            tail = list2;
            list2 = list2.next;
        }
        while (list1!=null && list2!= null){
            if (list1.data <= list2.data){
                tail.next = list1;
                tail=list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                tail= tail.next;
                list2 = list2.next;
            }
        }
        if (list1==null)
            tail.next = list2;
        if (list2 == null)
            tail.next = list1;

        return head;
    }

    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        if (head == null || head.next == null){
            return head;
        }
        LinkedListNode<Integer> midNode = findmidNode(head);
        LinkedListNode<Integer> head2 = midNode.next;
        midNode.next = null;
        LinkedListNode<Integer> merge1 = mergeSort(head2);
        LinkedListNode<Integer> merge2 =  mergeSort(head);
        LinkedListNode<Integer> merged = mergeTwoSortedLinkedLists(merge1 , merge2);
        return merged;
    }
    private static LinkedListNode<Integer> findmidNode(LinkedListNode<Integer> head) {
        if (head== null)
            return head;
        LinkedListNode<Integer> slow = head , fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

}
