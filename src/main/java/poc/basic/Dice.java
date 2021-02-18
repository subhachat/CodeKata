package poc.basic;

import java.util.Random;

public class Dice {
    private static int sidesOfDice = 6;
    private int faceValue = 0; // default, assign no value

    public static void changeNumOfSides(int newVal){
        sidesOfDice = newVal;
    }

    public int getFaceValue() {
        return faceValue;
    }
    public int roll(){
        Random random = new Random();
        faceValue = random.nextInt(Dice.sidesOfDice) + 1;
        return faceValue;
    }
}
