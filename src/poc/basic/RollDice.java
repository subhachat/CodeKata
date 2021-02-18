package poc.basic;

public class RollDice {

    public static void main(String[] args) {
        // write your code here
        //System.out.println(Arrays.toString(digitize(12345)));

        // Create dices
        Dice firstOne = new Dice();
        Dice secondOne = new Dice();

        //Change the total number of sides, forever
        Dice.changeNumOfSides(11);

        // Roll dices, 10 times
        for (int counter = 0; counter < 10; counter++){
            firstOne.roll();
            secondOne.roll();
        }
        System.out.println("Final Face value of firstOne ="+firstOne.getFaceValue());
        System.out.println("Final Face value of secondOne ="+secondOne.getFaceValue());
    }

    public static int[] digitize(long n) {
        /*
        int[] output = null;
        if( n > 0) {
            String convertNumberToText = n + "";
            StringBuilder strBuild = new StringBuilder(convertNumberToText);
            strBuild.reverse();
            output = new int[strBuild.length()];
            for (int index = 0; index < strBuild.length(); index++) {
                output[index] = Character.getNumericValue(strBuild.charAt(index));
            }
        }
        return output;
         */
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }

}
