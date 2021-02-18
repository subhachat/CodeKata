package poc.basic;

public class RunStringEquality {
    public static void main(String[] args) {
        String literalA = "abc";
        String literalB = "abc"; //same literal value, but common memory story
        String literalC = "c";

        String objectA = new String("abc"); // different object
        String objectB = new String("abc"); // another different object
        String objectC = new String("c");

        System.out.println("Literal string equality check := " + (literalA == literalB)); // checks for references
        System.out.println("Literal & object equality check := " + (literalA == objectA)); // checks for references
        System.out.println("Object string equality check := " + (objectA == objectB)); // checks for references

        System.out.println("Literal string equality check := " + literalA.equals(literalB)); // checks for true values
        System.out.println("Literal & object equality check := " + literalA.equals(objectA)); // checks for true values
        System.out.println("Object string equality check := " + objectA.equals(objectB)); // checks for true values
        System.out.println(literalA.equals(literalC)); // checks for true values
        System.out.println(literalA.equals(objectC)); // checks for true values
    }
}
