package lec_5_linked_list_2.assign;

import lec_4_Linked_list.LinkedListNode;

/*Even after Odd LinkedList
        Send Feedback
        For a given singly linked list of integers, arrange the elements such that all the even numbers are placed after the odd numbers. The relative order of the odd and even terms should remain unchanged.
        Note :
        No need to print the list, it has already been taken care. Only return the new head to the list.
        Input format:
        The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

        The first line of each test case or query contains the elements of the singly linked list separated by a single space.
        Remember/Consider :
        While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
        Output format:
        For each test case/query, print the elements of the updated singly linked list.

        Output for every test case will be printed in a seperate line.
        Constraints :
        1 <= t <= 10^2
        0 <= M <= 10^5
        Where M is the size of the singly linked list.

        Time Limit: 1sec
        Sample Input 1 :
        1
        1 4 5 2 -1
        Sample Output 1 :
        1 5 4 2
        Sample Input 2 :
        2
        1 11 3 6 8 0 9 -1
        10 20 30 40 -1
        Sample Output 2 :
        1 11 3 9 6 8 0
        10 20 30 40*/
public class even_after_odd {
    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> Etail = null , Otail = null;
        LinkedListNode<Integer> listOdd = null;
        LinkedListNode<Integer> listEven = null;
        while (head != null){
            if (head.data %2==0){
                if (listEven == null ){
                    listEven = head;
                    Etail = head;
                }else {
                    Etail.next = head;
                    Etail = head;
                }
                head = head.next;

            }else {
                if (listOdd == null ){
                    listOdd = head;
                    Otail = head;
                }else {
                    Otail.next = head;
                    Otail = head;
                }
                head = head.next;

            }
        }
        if (listOdd!= null){
            Otail.next = listEven;
        }else {
            return listEven;
        }
        if (listEven != null){
            Etail.next = null;

        }

        return listOdd;
        // LinkedListNode<Integer> listEven=null,Etail=null,listOdd=null,Otail=null;
        // while(head!=null){
        //     if(head.data%2==0){
        //         if(listEven == null)
        //         {
        //             listEven=head;
        //             Etail=head;
        //         }
        //         else{
        //             Etail.next=head;
        //             Etail=head;
        //         }
        //         head=head.next;
        //     }
        //     else{
        //         if(listOdd == null)
        //         {
        //             listOdd=head;
        //             Otail=head;
        //         }
        //         else{
        //             Otail.next=head;
        //             Otail=head;
        //         }
        //         head=head.next;
        //     }
        // }
        // if(listOdd!=null){
        //     Otail.next=listEven;
        // }
        // else{
        //     return listEven;
        // }
        // if(listEven!=null){
        //     Etail.next=null;
        // }
        // return listOdd;
    }
}
