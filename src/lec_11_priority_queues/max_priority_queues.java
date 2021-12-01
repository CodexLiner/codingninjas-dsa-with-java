package lec_11_priority_queues;

import java.util.ArrayList;

/*Code : Max Priority Queue
        Send Feedback
        Implement the class for Max Priority Queue which includes following functions -
        1. getSize -
        Return the size of priority queue i.e. number of elements present in the priority queue.
        2. isEmpty -
        Check if priority queue is empty or not. Return true or false accordingly.
        3. insert -
        Given an element, insert that element in the priority queue at the correct position.
        4. getMax -
        Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.
        5. removeMax -
        Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
        Note : main function is given for your reference which we are using internally to test the class.*/
public class max_priority_queues {
}
class PQ1 {
    private ArrayList<Integer> heap ;
    public PQ1(){
        heap =  new ArrayList<>();
    }
    boolean isEmpty() {
        return heap.size() == 0;
    }

    int getSize() {
        return heap.size();
    }

    int getMax()  {
        if (isEmpty()) {
            // Throw an exception

        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }
    int removeMax(){
        if (heap.isEmpty()){

        }
        int temp = heap.get(0);
        int last =  heap.get(heap.size() - 1);
        heap.set(0 , last);
        heap.remove(heap.size() - 1);
        int index = 0;
        int mindIndex = index;
        int childLeft = 1 ;
        int childRight =  2 ;
        while (childLeft < heap.size() ){
            if (heap.get(childLeft) >heap.get(mindIndex) ){
                mindIndex = childLeft;

            }if (childRight < heap.size() && heap.get(childRight) > heap.get(mindIndex) ){
                mindIndex = childRight;
            }
            if (mindIndex == index) {
                break;
            }else {
                int t = heap.get(index);
                heap.set(index, heap.get(mindIndex));
                heap.set(mindIndex, t);
                index = mindIndex;
                childLeft = 2 * index + 1;
                childRight = 2 * index + 2;
            }
        }

        return temp;
    }
}
