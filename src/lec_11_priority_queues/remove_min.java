package lec_11_priority_queues;

import java.util.ArrayList;

/*Code : Remove Min
        Send Feedback
        Implement the function RemoveMin for the min priority queue class.
        For a minimum priority queue, write the function for removing the minimum element present. Remove and return the minimum element.
        Note : main function is given for your reference which we are using internally to test the code.*/
public class remove_min {
}
 class PQ {
    private ArrayList<Integer> heap;

    public PQ() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
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

    int removeMin() throws PriorityQueueException{
        if (heap.isEmpty()){
            throw new PriorityQueueException();
        }
        int temp = heap.get(0);
        int last =  heap.get(heap.size() - 1);
        heap.set(0 , last);
        heap.remove(size() - 1);
        int index = 0;
        int mindIndex = index;
        int childLeft = 1 ;
        int childRight =  2 ;
        while (childLeft < heap.size() ){
            if (heap.get(childLeft) < heap.get(mindIndex) ){
                mindIndex = childLeft;

            }if (childRight < heap.size() && heap.get(childRight) < heap.get(mindIndex) ){
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
class PriorityQueueException extends Exception {

}