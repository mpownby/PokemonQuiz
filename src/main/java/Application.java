import data.Pokemon;
import io.InOutImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application
{
    public static void main(String[] args) {

        List<Pokemon> lstPokemon = new ArrayList<>();

        lstPokemon.add(new Pokemon("Girafarig"));
        lstPokemon.add(new Pokemon("Farigiraf"));
        lstPokemon.add(new Pokemon("Wattrel"));
        lstPokemon.add(new Pokemon("Kilowattrel"));
        lstPokemon.add(new Pokemon("Paras"));
        lstPokemon.add(new Pokemon("Parasect"));
        lstPokemon.add(new Pokemon("Shellder"));
        lstPokemon.add(new Pokemon("Cloyster"));
        lstPokemon.add(new Pokemon("Spearow"));
        lstPokemon.add(new Pokemon("Fearow"));

        Sorter sorter = new Sorter(new InOutImpl());

        Collections.shuffle(lstPokemon);    // randomize the starting list

        Pokemon favorite = sorter.findFavorite(lstPokemon);

        System.out.printf("%s is your favorite!%n", favorite.getName());
    }
}
