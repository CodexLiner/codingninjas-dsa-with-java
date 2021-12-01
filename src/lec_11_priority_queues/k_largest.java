package lec_11_priority_queues;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Code : K largest elements
        Send Feedback
        You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
        Time complexity should be O(nlogk) and space complexity should be not more than O(k).
        Order of elements in the output is not important.
        Input Format :
        Line 1 : Size of array (n)
        Line 2 : Array elements (separated by space)
        Line 3 : Integer k
        Output Format :
        k largest elements
        Sample Input :
        13
        2 12 9 16 10 5 3 20 25 11 1 8 6
        4
        Sample Output :
        12
        16
        20
        25*/
public class k_largest {
    public static ArrayList<Integer> kLargest(int input[], int k)
    {
        ArrayList<Integer> ary=new ArrayList<>();
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int i=0;
        for( ;i<k;i++){
            pq.add(input[i]);
        }
        for( ;i<input.length;i++){
            int min=pq.peek();
            if(min<input[i])
            {
                pq.remove();
                pq.add(input[i]);
            }
        }
        while(!pq.isEmpty())
        {
            ary.add(pq.poll());
        }
        return ary;
    }
}
