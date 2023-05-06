package io;

import data.Pokemon;

import java.util.Scanner;

public class InOutImpl implements InOut
{
    @Override
    public void printMessage(String msg)
    {
        System.out.println(msg);
    }

    @Override
    public int getChoice(Pokemon choice1, Pokemon choice2)
    {
        String question = String.format("Do you like 1) %s or 2) %s ?", choice1.getName(), choice2.getName());
        printMessage(question);
        return getIntegerWithRangeRestriction(1, 2) - 1;    // - 1 to make the range 0 to 1 instead of 1 to 2
    }

    @Override
    public int getIntegerWithRangeRestriction(int rangeLow, int rangeHigh) {

        boolean outOfRange = true;
        int result = 0;

        while (outOfRange) {

            result = getInteger();

            if (result < rangeLow) {
                System.out.println("I'm sorry but I can only handle numbers that are at least " + rangeLow);
            } else if (result > rangeHigh) {
                System.out.println("I'm sorry but I can only handle numbers up to " + rangeHigh);
            } else {
                outOfRange = false;
            }
        }

        return result;
    }

    public int getInteger() {

        boolean gotValidInteger = false;
        int integerThatWeRead = 0;

        while (!gotValidInteger) {

            String str = readStringFromConsole();

            try {
                integerThatWeRead = Integer.parseInt(str);
                gotValidInteger = true;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter an integer next time.");
            }
        }

        return (integerThatWeRead);
    }

    private String readStringFromConsole()
    {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream

        return sc.nextLine();
    }

}
