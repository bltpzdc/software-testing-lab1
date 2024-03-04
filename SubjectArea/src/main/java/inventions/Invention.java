package inventions;

import creatures.Creature;
import lombok.Getter;

public class Invention {
    private String name;
    @Getter
    private int difficulty;
    private Creature creator;

    public Invention(String name, int difficulty, Creature creator){
        this.name = name;
        this.difficulty = difficulty;
        this.creator = creator;
    }
}
