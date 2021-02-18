package poc.basic;

import java.util.Stack;

public class RunStack {

    /**
     * Java has a built-in implementation of Stack
     * @param args
     */
    public static void main(String[] args){
        Stack<String> packOfCards = new Stack<>();
        String card1 = "Jack of Diamond";
        String card2 = "Ace of Heart";
        String card3 = "Ten of Clubs";

        packOfCards.push(card1);
        packOfCards.push(card2);
        packOfCards.push(card3);
        System.out.println("Top of Stack->"+packOfCards.peek());
        System.out.println("Size->"+packOfCards.size());
        System.out.println("-------");

        while(!packOfCards.empty()) {
            System.out.println(packOfCards.pop());
        }
    }
}
