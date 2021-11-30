package lec_4_Linked_list;

public class LinkedListNode<T> {
   public T data;
   public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}
