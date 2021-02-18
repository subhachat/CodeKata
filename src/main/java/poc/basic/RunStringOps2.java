package poc.basic;

public class RunStringOps2 {
    public static void main(String[] args){
        String text = "Apples";
        System.out.println(text.charAt(4));
        System.out.println(text.indexOf('l'));
        System.out.println(text.substring(2,5));

        String longText = "Anaplan’s hyperscale computing lets our customers digitally\n" +
                "encode business strategy and link it to their operational plans.\n" +
                "Doing that makes it possible for them to shine a   light on the\n" +
                "black holes between siloed company systems, connect the\n" +
                "dots in a way they couldn’t before, and have a single source of\n" +
                "truth. This gives decision-makers across their organization the\n" +
                "confidence to make better decisions.This is the last one. is it? is it not?";

        // Find No. of Sentences -
        // usually a sentence is identified by a period (.) and whitespace
        // there could be sentences ending with ? / !
        String[] sentencesSeparated = longText.split("(\\.s*)");
        System.out.println("No. of Sentences = "+sentencesSeparated.length);

        String[] wordsSeparated = longText.split("\\s+|-|\\n");
        System.out.println("No. of words = "+wordsSeparated.length);
    }
}
