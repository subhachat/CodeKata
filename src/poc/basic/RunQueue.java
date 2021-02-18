package poc.basic;

import java.util.LinkedList;
import java.util.Queue;

public class RunQueue {
    // Java doesn't have a built-in Queue implementation
    // java.util.Queue is an interface -> can be realised with LinkedList or PriorityQueue
    public static void main(String[] args){
        Queue<String> queue = new LinkedList<>(); //even though it is a LinkedList, queue has strict adherence to FIFO
        queue.add("Sarah"); //enqueue
        queue.add("Jane"); //enqueue
        queue.add("Michelle"); //enqueue
        queue.add("Sally"); //enqueue

        System.out.println(queue.peek()); //should be "Sarah"
        System.out.println("-------");

        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }


    }
}
