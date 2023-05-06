import data.Pokemon;
import io.InOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SorterTest
{
    @Mock
    InOut mockInOut;

    @InjectMocks
    Sorter instance;

    @Test
    public void threeCardsTest()
    {
        // ARRANGE

        List<Pokemon> lstPokemon = new ArrayList<>();

        Pokemon girafarig = new Pokemon("Girafarig");
        Pokemon farigiraf = new Pokemon("Farigiraf");
        Pokemon wattrel = new Pokemon("Wattrel");

        lstPokemon.add(girafarig);
        lstPokemon.add(farigiraf);
        lstPokemon.add(wattrel);

        when(mockInOut.getChoice(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenAnswer(
                        (Answer<Integer>) invocation ->
                        {
                            Object[] args = invocation.getArguments();
                            Pokemon choice1 = (Pokemon) args[0];
                            Pokemon choice2 = (Pokemon) args[1];

                            Integer result = null;

                            switch (choice1.getScore())
                            {
                            case 0:
                                assertEquals(girafarig, choice1);
                                assertEquals(farigiraf, choice2);
                                result = 0; //  choose first item
                                break;
                            case 1:
                                assertEquals(girafarig, choice1);
                                assertEquals(wattrel, choice2);
                                result = 1; //  choose second item
                                break;
                            }

                            return result;
                        }
                );

        // ACT

        Pokemon favorite = instance.findFavorite(lstPokemon);

        // ASSERT

        assertEquals(wattrel, favorite);
    }
}
