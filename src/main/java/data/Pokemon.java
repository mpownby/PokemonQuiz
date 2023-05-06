package data;

public class Pokemon implements Comparable<Pokemon>
{
    int score;
    String name;

    public Pokemon(String name)
    {
        this.name = name;
        this.score = 0;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int compareTo(Pokemon o)
    {
        Integer scoreInt = o.score;
        return scoreInt.compareTo(this.score);
    }
}
