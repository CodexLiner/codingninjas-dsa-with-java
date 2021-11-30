package lec_6_stack_and_queues.assign;

import java.util.Queue;

public class reverse_queue { public static void reverseQueue(Queue input) {
    if (input.size() <= 1){
        return;
    }
    int x = (int) input.poll();
    // System.out.println(x);
    reverseQueue(input);
    input.add(x);
}

}
