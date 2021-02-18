package poc.basic;

import java.util.LinkedList;
import java.util.Objects;

public class RunLinkedList {

    /**
     * return the modified head-node after removal of middle node
     */
    private static <T> CustomNode<T> deleteMiddle(CustomNode<T> head) {
        Objects.requireNonNull(head);
        if (head.getNextNode() == null){
            return head;
        }
        CustomNode<T> fastPointer = head;
        CustomNode<T> slowPointer = head;

        CustomNode<T> linkNodePrevious = null;
        while(fastPointer != null && fastPointer.getNextNode() != null){
            fastPointer = fastPointer.getNextNode().getNextNode(); // this will bring the slowPointer to the middle of list
            linkNodePrevious = slowPointer;
            slowPointer = slowPointer.getNextNode();
        }
        linkNodePrevious.setNextNode(slowPointer.getNextNode()); // unlinking the slowPointer node in this process
        return head;
    }

    private static <T> CustomNode<T> buildNode(T data) {
        CustomNode<T> node = new CustomNode<>(); //create a new node object
        node.setData(data); //fill in the data
        node.setNextNode(null); //for now, we don't know what comes next
        return node;
    }

    private static void printNode(CustomNode<?> begin) {
        Objects.requireNonNull(begin);
        System.out.print(begin.getData());
        if (begin.getNextNode() != null) {
            System.out.print(",");
            printNode(begin.getNextNode());
        }
        else{
            System.out.println(",END");
        }
    }


    public static void main(String[] args) {
        LinkedList<String> studentsList = new LinkedList<>();
        studentsList.add("Marshal");
        studentsList.add("Skye");
        System.out.println(studentsList);

        /*studentsList.addFirst("Rubble");
        studentsList.addLast("Everest");
        System.out.println(studentsList);

        studentsList.add(2, "Zuma");
        System.out.println(studentsList);

        studentsList.remove("Marshal");
        System.out.println(studentsList);

        studentsList.remove(2);
        System.out.println(studentsList);

        System.out.println(studentsList.contains("Marshal"));*/

        // Build the Node elements
        CustomNode<Integer> head = buildNode(8);
        CustomNode<Integer> nodeA = buildNode(10);
        CustomNode<Integer> nodeB = buildNode(12);
        CustomNode<Integer> nodeC = buildNode(14);
        CustomNode<Integer> nodeD = buildNode(16);
        CustomNode<Integer> nodeE = buildNode(18);
        CustomNode<Integer> nodeF = buildNode(20);

        // Link the nodes in chain
        head.setNextNode(nodeA);
        nodeA.setNextNode(nodeB);
        nodeB.setNextNode(nodeC);
        nodeC.setNextNode(nodeD);
        nodeD.setNextNode(nodeE);
        nodeE.setNextNode(nodeF);

        // print it out -> feel it
        printNode(head);

        // remove the node from middle - TRY 1
        System.out.println("----Delete TRY 1----");
        head = deleteMiddle(head);
        printNode(head);
        // remove the node from middle - TRY 2
        System.out.println("----Delete TRY 2----");
        head = deleteMiddle(head);
        printNode(head);

    }
}
