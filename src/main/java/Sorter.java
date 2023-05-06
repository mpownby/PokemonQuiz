import data.Pokemon;
import io.InOut;

import java.util.Collections;
import java.util.List;

public class Sorter
{
    private final InOut io;

    public Sorter(InOut io)
    {
        this.io = io;
    }

    public Pokemon findFavorite(List<Pokemon> lstPokemon)
    {
        int pokemonToCompare = lstPokemon.size();

        // loop while we haven't found a winner
        while (pokemonToCompare > 1)
        {
            // we haven't compared any pokemon this iteration of the loop, so we start at 0
            int pokemonCompared = 0;

            // loop while we have compared less pokemon than the total amount that we want to compare this iteration
            while (pokemonCompared < pokemonToCompare)
            {
                // if we still have 2 pokemon to compare
                if ((pokemonToCompare - pokemonCompared) > 1)
                {
                    int choice = io.getChoice(lstPokemon.get(pokemonCompared), lstPokemon.get(pokemonCompared + 1));

                    int idx = pokemonCompared + choice;
                    Pokemon cur = lstPokemon.get(idx);
                    int score = cur.getScore();
                    score++;
                    cur.setScore(score);

                    pokemonCompared += 2;   // we just compared 2 pokemon
                }
                // else there's just one left so we will give it a 'bye' (increment its score) and send it to the next round
                else
                {
                    // get last pokemon and increment its score
                    Pokemon cur = lstPokemon.get(pokemonCompared);
                    int score = cur.getScore();
                    score++;
                    cur.setScore(score);

                    break;  // exit the while loop since we're done
                }
            }

            // figure out how many pokemon we want to compare next time.  We need to take odd numbers of existing pokemon into account.
            // (so 3 becomes 2 instead of 1, for example)
            pokemonToCompare = (pokemonToCompare / 2) + (pokemonToCompare % 2);

            // sort the pokemon by the score so that the chosen pokemon move to the beginning of the list
            Collections.sort(lstPokemon);
        }

        // the pokemon at the front of the list will now be the one with the highest score and therefore the winner
        return lstPokemon.get(0);
    }

}
