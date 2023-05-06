package io;

import data.Pokemon;

public interface InOut
{
    void printMessage(String msg);

    int getChoice(Pokemon choice1, Pokemon choice2);

    int getIntegerWithRangeRestriction(int rangeLow, int rangeHigh);
}
